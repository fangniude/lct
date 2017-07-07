/*
 * Copyright (c) . All rights reserved.
 */
package com.winnertel.em.standard.text;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;


/**
 * Debug dialog which shows the swing component hierarchy of the specified window. When an item is selected on the
 * component tree, its' border will be highlighted on the target window. When the right-mouse button is clicked on the
 * top of a component, a popup-menu will be opened. Popup-menu contains e.g. details item that shows toString() output
 * of the component.
 * <p/>
 * To display the dialog instantiate this class and call {@code setVisible()} to it.
 */
public class SwingHierarchyDialog extends JDialog {
    /**
     * Default height of the main window.
     */
    private static final int DEFAULT_WINDOW_HEIGHT = 500;

    /**
     * Default window of the main window.
     */
    private static final int DEFAULT_WINDOW_WIDTH = 450;

    /**
     * Map of application windows and their titles.
     */
    protected Map myWindowMap;

    /**
     * Root node of the component tree.
     */
    protected DefaultMutableTreeNode myRootNode;

    /**
     * Swing component hierarchy of the selected window.
     */
    protected JTree mySwingHierarchyTree;

    /**
     * Root frame of the application.
     */
    protected JFrame myRootFrame;

    /**
     * Reference to the currently selected window.
     */
    protected Window myCurrentlySelectedWindow;

    /**
     * A combobox which contains (almost) all windows of a application. This dialog + glasspanes are ignored.
     */
    protected JComboBox myWindowSelectionComboBox;

    /**
     * Currently selected swing component.
     */
    protected Component mySelectedComponent = null;

    /**
     * Currently visible glasspane.
     */
    protected BorderGlassPane myCurrentGlassPane;

    /**
     * Listens to focus change event
     */
    private FocusListener focusListener;

    /**
     * Creates a new component hierarchy dialog by using the specified frame as a root window.
     *
     * @param rootFrame root frame of the the hierarchy
     */
    public SwingHierarchyDialog(JFrame rootFrame) {
        super();
        myWindowMap = new HashMap();

        myRootFrame = rootFrame;
        myCurrentlySelectedWindow = myRootFrame;

        // a modal dialog that always stays on top
        setModal(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removePropertyChangeListener("focusOwner",
                        focusListener);
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removePropertyChangeListener(
                        "permanentFocusOwner", focusListener);
            }
        });
        setLocationByPlatform(true);
        setAlwaysOnTop(true);
        setDialogModality();
        setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        myWindowSelectionComboBox = new JComboBox();
        myWindowSelectionComboBox.setPreferredSize(new Dimension(275, 25));
        myWindowSelectionComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // get selected item
                Window newSelection = (Window) myWindowMap.get(myWindowSelectionComboBox.getSelectedItem());

                // if necessary, rebuild component tree
                if (newSelection != null && myCurrentlySelectedWindow != newSelection) {
                    cleanCurrentGlassPane();
                    myCurrentlySelectedWindow = newSelection;
                    buildComponentTree();
                    repaint();
                }
            }
        });
        comboPanel.add(myWindowSelectionComboBox);

        JButton refreshButton = new JButton("Refresh windows");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cleanCurrentGlassPane();
                buildWindowList();
            }
        });

        comboPanel.add(refreshButton);

        add(comboPanel, BorderLayout.NORTH);

        JPanel treePanel = new JPanel(new BorderLayout());

        // create component tree
        TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        mySwingHierarchyTree = new JTree(myRootNode);
        mySwingHierarchyTree.setRootVisible(true);
        mySwingHierarchyTree.setShowsRootHandles(true);
        mySwingHierarchyTree.setSelectionModel(selectionModel);
        mySwingHierarchyTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                // verify that something is selected in component tree...
                if (mySwingHierarchyTree.getSelectionCount() > 0) {
                    // verify that glass pane is created and emptied
                    myCurrentGlassPane = createGlassPaneIfItDoesNotExist();

                    // find selected component from swing hierarchy
                    DefaultMutableTreeNode selectedTreeNode =
                            (DefaultMutableTreeNode) mySwingHierarchyTree.getLastSelectedPathComponent();
                    // find component from swing hierarchy
                    mySelectedComponent = ((SwingComponentNode) selectedTreeNode.getUserObject()).getComponent();
                    if (mySelectedComponent != null) {
                        // mark borders of the component (and its sub-components)
                        markComponentBorder(mySelectedComponent);
                    }
                }
            }

        });

        // create and add popup menu to the tree
        final TreePopupMenu popupMenu = new TreePopupMenu(this);
        mySwingHierarchyTree.add(popupMenu);
        mySwingHierarchyTree.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show((Component) e.getSource(), e.getX(), e.getY());
                }
            }
        });

        treePanel.add(new JScrollPane(mySwingHierarchyTree), BorderLayout.CENTER);

        add(treePanel, BorderLayout.CENTER);

        // create lower button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton closeButton = new JButton("Close");
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cleanCurrentGlassPane();
                dispose();
            }
        };
        closeButton.addActionListener(al);
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // make initial rebuild
        buildWindowList();

        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusListener = new FocusListener();
        focusManager.addPropertyChangeListener("focusOwner", focusListener);
        focusManager.addPropertyChangeListener("permanentFocusOwner", focusListener);
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Test Frame") {
            public void dispose() {
                super.dispose();
                System.exit(1);
            }
        };
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke("F12"), "showHierarchy");
        frame.getRootPane().getActionMap().put("showHierarchy", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Component c = frame.getFocusOwner();
                SwingHierarchyDialog dlg = new SwingHierarchyDialog(frame);
                dlg.showFocus(c);
                dlg.setVisible(true);

            }
        });

        Container c = frame.getContentPane();

        c.setLayout(new BorderLayout());

        c.add(new JPanel(), BorderLayout.CENTER);

        JButton btn = new JButton("Test");
        btn.setName("Test Button");
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        JPanel btnPan = new JPanel(flow);
        btnPan.add(new JButton("1"));
        btnPan.add(new JButton("2"));
        btnPan.add(new JButton("3"));
        btnPan.add(new JButton("4"));
        btnPan.add(new JButton("5"));
        c.add(btnPan, BorderLayout.SOUTH);

        frame.setLocation(200, 200);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }

    public void showFocus(Component c) {

        Enumeration children = myRootNode.depthFirstEnumeration();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode obj = (DefaultMutableTreeNode) children.nextElement();
            SwingComponentNode node = (SwingComponentNode) obj.getUserObject();
            if (node.myComponent.equals(c)) {
                TreePath path = new TreePath(obj.getPath());
                mySwingHierarchyTree.expandPath(path);
                mySwingHierarchyTree.setSelectionPath(path);
                mySwingHierarchyTree.revalidate();
            }
        }

    }

    /**
     * Sets the modality exclusion for the dialog. It is important that this dialog can be open all the time and it does
     * not block any other modal dialogs. This method should be removed when Poseidon moves to JDK 1.6. Important!
     * Dialog modality exclusion does not work if class is used with JDK 1.5.
     */
    protected void setDialogModality() {
        try {
            Class clazz = Class.forName("java.awt.Dialog$ModalExclusionType");
            Enum valueOf = Enum.valueOf(clazz, "APPLICATION_EXCLUDE");

            Method m = this.getClass().getMethod("setModalExclusionType", new Class[]{clazz});
            m.invoke(this, new Object[]{valueOf});
        } catch (Exception e) {
            // ignore
        }
    }

    /**
     * Marks border of the given component. Also checks whether given tree node contains child nodes. If children are
     * found, they will be marked too.
     *
     * @param component        swing component
     * @param selectedTreeNode currently selected node of the swing component tree
     */
    protected void markComponentBorder(Component component) {
        // add red border to the given component
        if (component != null) {
            drawBorder(component);
        }

        // iterate all children and mark also their borders (and borders of their children....)
        if (component instanceof Container) {
            for (int i = 0; i < ((Container) component).getComponents().length; i++) {
                Component child = ((Container) component).getComponents()[i];
                markComponentBorder(child);
            }
        }

    }

    /**
     * Adds a red border the the given component. Borders are drawn to a special glass pane.
     */
    protected void drawBorder(Component component) {
        // calculate exact location for the border. Location is calculated based on the screen location of the
        // component

        if (SwingUtilities.getRootPane(component) != null) {
            Point compLoc = new Point();
            Point windowLoc = new Point();
            SwingUtilities.convertPointToScreen(compLoc, component);
            SwingUtilities.convertPointToScreen(windowLoc, SwingUtilities.getRootPane(component));
            int x = compLoc.x - windowLoc.x;
            int y = compLoc.y - windowLoc.y;

            Rectangle rect = new Rectangle(x, y, component.getBounds().width - 1, component.getBounds().height - 1);
            myCurrentGlassPane.addBorder(rect);
        }
    }

    /**
     * Creates child nodes for a given swing container.
     *
     * @param container     swing container
     * @param containerNode tree node of the swing container
     */
    protected void createChildNodes(Container container, DefaultMutableTreeNode containerNode) {
        for (int i = 0; i < container.getComponents().length; i++) {
            Component component = container.getComponents()[i];
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new SwingComponentNode(component));
            containerNode.add(childNode);

            if (component instanceof Container) {
                createChildNodes((Container) component, childNode);
            }
        }
    }

    /**
     * Builds the swing component tree.
     */
    protected void buildComponentTree() {
        // remove all current items
        if (myRootNode != null) {
            myRootNode.removeAllChildren();
        }

        // create a root node for the tree
        myRootNode = new DefaultMutableTreeNode(new SwingComponentNode(myCurrentlySelectedWindow));

        // create child nodes using the selected window as a root
        createChildNodes(myCurrentlySelectedWindow, myRootNode);
        mySwingHierarchyTree.setModel(new DefaultTreeModel(myRootNode));

        setTitle("Component tree: " + (String) myWindowSelectionComboBox.getSelectedItem());
        repaint();
    }

    /**
     * Builds a list of application windows and adds them to the combobox.
     */
    protected void buildWindowList() {
        myWindowMap.clear();

        for (int i = 0; i < myRootFrame.getOwnedWindows().length; i++) {
            Window child = myRootFrame.getOwnedWindows()[i];
            // ignore our debug window and the container of modeless swing windows
            if (child == this || child == JOptionPane.getRootFrame()) {
                continue;
            }

            // try to get a good name for the window
            String title = child.getName();
            if (child instanceof Dialog) {
                title = ((Dialog) child).getTitle();
            } else if (child instanceof JFrame) {
                title = ((JFrame) child).getTitle();
            }

            // if the window has a proper name, add it to the window map
            if (title != null && title.trim().length() > 0) {
                String clazzName = child.getClass().getName();
                myWindowMap.put(title + " [" + clazzName + "]", child);
            }
        }

        myWindowMap.put(myRootFrame.getTitle() + " [" + myRootFrame.getClass().getName() + "]", myRootFrame);

        // clear combobox and add new windows to it
        myWindowSelectionComboBox.removeAllItems();
        Iterator it = myWindowMap.keySet().iterator();
        while (it.hasNext()) {
            String windowName = (String) it.next();
            if (myWindowMap.get(windowName) == myRootFrame) {
                myWindowSelectionComboBox.insertItemAt(windowName, 0);
            } else {
                myWindowSelectionComboBox.addItem(windowName);
            }
        }

        // select root frame of the application
        myWindowSelectionComboBox.setSelectedIndex(0);
        myCurrentlySelectedWindow = myRootFrame;

        // build component tree
        buildComponentTree();
    }

    /**
     * Creates a glass pane for the selected window. If the glass pane is already created, it will be reused.
     *
     * @return glass pane for the selected window
     */
    protected BorderGlassPane createGlassPaneIfItDoesNotExist() {
        BorderGlassPane glassPane = null;
        if (myCurrentlySelectedWindow instanceof JDialog) {
            JDialog dialog = (JDialog) myCurrentlySelectedWindow;
            if (dialog.getGlassPane() == null || !(dialog.getGlassPane() instanceof BorderGlassPane)) {
                glassPane = new BorderGlassPane(dialog);
                dialog.setGlassPane(glassPane);
                glassPane.setVisible(true);
            } else {
                glassPane = (BorderGlassPane) dialog.getGlassPane();
            }
        } else if (myCurrentlySelectedWindow instanceof JFrame) {
            JFrame frame = (JFrame) myCurrentlySelectedWindow;
            if (frame.getGlassPane() == null || !(frame.getGlassPane() instanceof BorderGlassPane)) {
                glassPane = new BorderGlassPane(frame);
                frame.setGlassPane(glassPane);
                glassPane.setVisible(true);
            } else {
                glassPane = (BorderGlassPane) frame.getGlassPane();
            }
        }

        glassPane.clearBorders();

        return glassPane;
    }

    /**
     * Cleans and repaints current glasspane.
     */
    protected void cleanCurrentGlassPane() {
        // remove currently visible borders
        if (myCurrentGlassPane != null) {
            myCurrentGlassPane.clearBorders();
            myCurrentlySelectedWindow.repaint();
        }
    }

    /**
     * A node in the component hierarchy tree.
     */
    class SwingComponentNode {
        protected String myName;

        protected String myClassName;

        protected Component myComponent;

        public SwingComponentNode(Component component) {
            myClassName = component.getClass().getName();
            myName = component.getName();
            myComponent = component;
        }

        public String getClassName() {
            return myClassName;
        }

        public Component getComponent() {
            return myComponent;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (myName != null) {
                sb.append(myName);
            }
            sb.append("  [" + myClassName + "]");
            return sb.toString();

        }
    }

    /**
     * Popup menu for tree component.
     */
    class TreePopupMenu extends JPopupMenu {
        private static final int DETAILS_LINE_LENGTH = 80;

        public TreePopupMenu(final SwingHierarchyDialog parentDialog) {
            super();

            JMenuItem detailsItem = new JMenuItem("Details...");
            detailsItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // if an item is selected, show the popup menu
                    if (mySwingHierarchyTree.getSelectionCount() > 0) {
                        // find the selected component and display its toString() output
                        Component comp = getSelectedNodeComponent().getComponent();

                        if (comp != null) {
                            // line-wrap details text
                            String text = TextUtils.forcedTextWrap(comp.toString(), "\n", 120);
                            JOptionPane.showMessageDialog(parentDialog, text, comp.getClass().getName()
                                    + " details", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            });

            add(detailsItem);
        }

        protected SwingComponentNode getSelectedNodeComponent() {
            return (SwingComponentNode) ((DefaultMutableTreeNode) mySwingHierarchyTree
                    .getLastSelectedPathComponent()).getUserObject();
        }
    }

    /**
     * A GlassPane that draws red rectangles on given coordinates.
     */
    class BorderGlassPane extends JComponent {
        protected List myBorders;

        public BorderGlassPane(Window window) {
            myBorders = new LinkedList();
            setSize(window.getSize());
        }

        public void clearBorders() {
            myBorders.clear();
        }

        public void addBorder(Rectangle rect) {
            myBorders.add(rect);
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);
            for (int i = 0; i < myBorders.size(); i++) {
                Rectangle rect = (Rectangle) myBorders.get(i);
                g.drawRect(rect.x, rect.y, rect.width, rect.height);
            }
        }

    }

    class FocusListener implements PropertyChangeListener {
        /**
         * Called when a bound property is changed.
         *
         * @param evt A PropertyChangeEvent object describing the event source and the property that has changed.
         */
        public void propertyChange(PropertyChangeEvent evt) {
            if ("focusOwner".equals(evt.getPropertyName()) || "permanentFocusOwner".equals(evt.getPropertyName())) {
                if (!(evt.getNewValue() instanceof JComponent)) {
                    return;
                }

                JComponent focusedComponent = (JComponent) evt.getNewValue();
                if (focusedComponent == null ||
                        SwingUtilities.getWindowAncestor(focusedComponent) == SwingHierarchyDialog.this) {
                    return;
                }
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) mySwingHierarchyTree.getModel().getRoot();
                Enumeration e = root.depthFirstEnumeration();
                while (e.hasMoreElements()) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) e.nextElement();
                    SwingComponentNode swingNode = (SwingComponentNode) child.getUserObject();
                    if (focusedComponent == swingNode.getComponent()) {
                        TreePath path = new TreePath(child.getPath());
                        mySwingHierarchyTree.setSelectionPath(path);
                        mySwingHierarchyTree.scrollPathToVisible(path);
                        break;
                    }
                }
            }
        }
    }
}
