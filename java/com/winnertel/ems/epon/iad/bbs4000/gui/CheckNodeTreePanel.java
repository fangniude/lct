package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: ou zhou
 * Date: 2004-9-21
 * Time: 19:18:47
 * To change this template use File | Settings | File Templates.
 */
public class CheckNodeTreePanel extends JPanel implements MouseListener {
    private static final long serialVersionUID = 966731892081697339L;
    JTree jTree = null;
    boolean allEnabled = true;
    boolean commonEnabled = false;
    CheckNode root = new CheckNode();

    public boolean isCommonEnabled() {
        return commonEnabled;
    }

    public void setCommonEnabled(boolean commonEnabled) {
        this.commonEnabled = commonEnabled;
    }


    public boolean isAllEnabled() {
        return allEnabled;
    }

    public void setAllEnabled(boolean allEnabled) {
        this.allEnabled = allEnabled;
    }

    public CheckNodeTreePanel(CheckNode root,String name) {
        this.root = root;
        createUI(root,name);

    }

    void createUI(CheckNode root,String name) {
        jTree = new JTree(root);

        jTree.addMouseListener(this);
        JScrollPane treeView = new JScrollPane(jTree);
        jTree.setCellRenderer(new CheckBoxNodeRender());
        jTree.setCellEditor(new WCellEditor());
        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        NTLayout layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(250, 300));
        this.setBorder(BorderFactory.createTitledBorder(name));
        add(treeView);

    }

    public Vector getCheckNodes() {
        Vector nodes = getCheckedInfo(jTree, root);
        return nodes;
    }

    public Vector getCheckRootChild(int i){
        Vector nodes = getCheckedInfo(jTree,(CheckNode)root.getChildAt(i));
        return nodes;
    }

    private Vector getCheckedInfo(JTree jTree, CheckNode node) {
        Vector SelectedNodes = new Vector();
        for (int i = 0; i < node.getChildCount(); i++) {
            CheckNode nodeChild = (CheckNode) node.getChildAt(i);
            if (nodeChild.isSelected()) {
                if (nodeChild.getChildCount() == 0)
                    SelectedNodes.add(addNode(nodeChild));
                else
                    SelectedNodes.addAll(getCheckedInfo(jTree, nodeChild));
            } else {
                if (nodeChild.getChildCount() != 0)
                    SelectedNodes.addAll(getCheckedInfo(jTree, nodeChild));
            }
        }
        return SelectedNodes;
    }

    String addNode(CheckNode node) {
        String strR = node.toString();
        CheckNode parent = (CheckNode) node.getParent();
        while (parent != null) {
            strR = parent.toString() + "/" + strR;
            parent = (CheckNode) parent.getParent();
        }
        return strR;
    }

    //expand node
    public void expandTreeNode(JTree jTree, DefaultMutableTreeNode aNode) {
        if (aNode.isLeaf()) {
            return;
        }
        jTree.expandPath(new TreePath(((DefaultMutableTreeNode) aNode).getPath()));
        int n = aNode.getChildCount();
        for (int i = 0; i < n; i++) {
            expandTreeNode(jTree, (DefaultMutableTreeNode) aNode.getChildAt(i));
        }
    }

    public void setSelected(JTree jTree, CheckNode node, boolean isSelected) {
        node.setSelected(isSelected);
        CheckNode parentNode = (CheckNode) node.getParent();
        if (parentNode == null) {
            return;
        }
        if (isSelected) {
            Enumeration elements = parentNode.children();
            if (elements == null) {
                return;
            }

            while (elements.hasMoreElements()) {
                CheckNode brotherNode = (CheckNode) elements.nextElement();
                if (!brotherNode.isSelected()) {
                    return;
                }
            }

            if (parentNode.isSelected()) {
                return;
            }
            setPureSelected(jTree, parentNode, true);
        } else {
            setPureSelected(jTree, parentNode, false);
        }
    }

    public void setPureSelected(JTree jTree, CheckNode node, boolean isSelected) {
        node.setPureSelected(isSelected);
        CheckNode parentNode = (CheckNode) node.getParent();
        if (parentNode == null) {
            return;
        }
        if (isSelected) {
            Enumeration elements = parentNode.children();
            if (elements == null) {
                return;
            }
            while (elements.hasMoreElements()) {
                CheckNode brotherNode = (CheckNode) elements.nextElement();
                if (!brotherNode.isSelected()) {
                    return;
                }
            }
            if (parentNode.isSelected()) {
                return;
            }
            setPureSelected(jTree, parentNode, true);
        } else {
            setPureSelected(jTree, parentNode, false);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        WCellEditor celleditor = (WCellEditor) jTree.getCellEditor();
        boolean isInCheckBoxBound = celleditor.isInCellCheckBoxBound(e.getX(), e.getY());
        if (e.getClickCount() == 1 && isInCheckBoxBound) {
            int x = e.getX();
            int y = e.getY();
            int row = jTree.getRowForLocation(x, y);
            TreePath path = jTree.getPathForRow(row);
            if (path != null) {
                CheckNode node = (CheckNode) path.getLastPathComponent();
                boolean isSelected = !(node.isSelected());
                setSelected(jTree, node, isSelected);
                ((DefaultTreeModel) jTree.getModel()).nodeChanged(node);
                if (row == 0) {
                    jTree.revalidate();
                    jTree.repaint();
                }
            }

        } else if (e.getClickCount() == 2 && !isInCheckBoxBound) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    jTree.getLastSelectedPathComponent();
            if (node instanceof CheckNode) {
                if (node.getChildCount() == 0) {
                    expandTreeNode(jTree, node);
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }


    class WCellEditor extends AbstractCellEditor implements TreeCellEditor {
        protected JCheckBox check = new JCheckBox();
        protected JPanel panel = new JPanel();
        protected JTextField tf = new JTextField();
        protected Object o = null;

        public WCellEditor() {
            panel.setBackground(UIManager.getColor("Tree.textBackground"));
            check.setBackground(UIManager.getColor("Tree.textBackground"));
            check.setBorder((BorderFactory.createEmptyBorder(0, 0, 0, 0)));
            panel.add(check);
            panel.add(tf);
            tf.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CheckNodeTreePanel.WCellEditor.this.stopCellEditing();
                }
            });
        }


        public Object getCellEditorValue() {
            return null;
        }


        public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            o = ((CheckNode) value).getUserObject();
            tf.setText(o.toString());
            return panel;
        }


        public boolean isInCellCheckBoxBound(int i, int j) {
            TreePath treepath = jTree.getPathForLocation(i, j);
            if (treepath != null) {
                Rectangle rectangle = jTree.getPathBounds(treepath);
                Rectangle rectangle1 = check.getBounds();
                Dimension dimension = check.getPreferredSize();
                rectangle1.x = rectangle.x;
                rectangle1.y = rectangle.y;
                rectangle1.width = dimension.width;
                rectangle1.height = dimension.height;
                return rectangle1.contains(i, j);

            } else {
                return false;
            }
        }


        public boolean isCellEditable(EventObject event) {
            return false;
        }


    }
}
