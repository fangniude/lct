package com.winnertel.ems.epon.iad.bbs4000.gui;


import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: hz08092
 * Date: Sep 6, 2004
 * Time: 5:01:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckBoxNodeRender extends JPanel implements TreeCellRenderer {
    protected JCheckBox check;
    protected TreeLabel label;
    //private boolean isGroup = false;


    public CheckBoxNodeRender() {
        setLayout(null);

        add(check = new JCheckBox());
        add(label = new TreeLabel());
        //check.setBackground(UIManager.getColor("Tree.textBackground"));
        check.setBorder((BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        label.setForeground(UIManager.getColor("Tree.textForeground"));
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean isSelected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        CheckNode node = (CheckNode) value;

/*
        Icon iconImage;
        if (node.getTreeNodeType().equalsIgnoreCase(CheckTreeNode.CHECK_TREE_NODE_TYPE_GROUP)) {
            iconImage = UIManager.getIcon("Tree.openIcon");
        } else {
            iconImage = UIManager.getIcon("Tree.leafIcon");
        }
        label.setIcon(iconImage);
*/

        label.setText(node.getUserObject().toString());
        label.setFont(tree.getFont());
        label.setSelected(isSelected);
        label.setFocus(hasFocus);

        setEnabled(tree.isEnabled());

        TreeCellNodeSelectionSet(node);

        return this;
    }

    protected void TreeCellNodeSelectionSet(CheckNode node) {
        if ((!node.isSelected()) && (node.getChildCount() > 0)) {
            boolean childAllSel = true;
            boolean childNoSel = true;
            for (int i = 0; i < node.getChildCount(); i++) {
                CheckNode achild = (CheckNode) node.getChildAt(i);
                if (achild.isSelected()) {
                    childNoSel = false;
                } else {
                    childAllSel = false;
                }
            }
            if (childAllSel) {
                check.setSelected(true);
                check.setBackground(UIManager.getColor("Tree.textBackground"));
                return;
            }

            if ((!childAllSel) && (!childNoSel)) {
                check.setSelected(true);
                check.setBackground(Color.lightGray);
                return;
            }

            if ((!childAllSel) && hasDesentChildSelected(node)) {
                check.setSelected(true);
                check.setBackground(Color.lightGray);
                return;
            }
        }

        if ((node.isSelected()) && (!isAllchildSelected(node))) {
            check.setBackground(Color.lightGray);
        } else {
            check.setBackground(UIManager.getColor("Tree.textBackground"));
        }

        check.setSelected(node.isSelected());
        check.setBackground(UIManager.getColor("Tree.textBackground"));
    }

    protected boolean hasDesentChildSelected(CheckNode node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            CheckNode childNode = (CheckNode) node.getChildAt(i);
            if (childNode.isSelected()) {
                return true;
            }
            if (!childNode.isLeaf()) {
                boolean oneBranchResult = hasDesentChildSelected(childNode);
                if (oneBranchResult)
                    return true;
            }
        }
        return false;
    }

    protected boolean isAllchildSelected(CheckNode node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            CheckNode childNode = (CheckNode) node.getChildAt(i);
            if (!childNode.isSelected())
                return false;
            if (!childNode.isLeaf()) {
                boolean isAllchildSelected = isAllchildSelected(childNode);
                if (!isAllchildSelected)
                    return false;
            }
        }
        return true;
    }

    public Dimension getPreferredSize() {
        Dimension d_check = check.getPreferredSize();
        Dimension d_label = label.getPreferredSize();
        return new Dimension(d_check.width + 5 + d_label.width, (d_check.height < d_label.height ? d_label.height : d_check.height));
    }

    public void doLayout() {
        Dimension d_check = check.getPreferredSize();
        Dimension d_label = label.getPreferredSize();
        int y_check = 0;
        int y_label = 0;
        if (d_check.height < d_label.height) {
            y_check = (d_label.height - d_check.height) / 2;
        } else {
            y_label = (d_check.height - d_label.height) / 2;
        }

        check.setLocation(0, y_check);
        check.setBounds(0, y_check, d_check.width, d_check.height);
        label.setLocation(d_check.width + 5, y_label);
        label.setBounds(d_check.width + 5, y_label, d_label.width, d_label.height);
    }


    public void setBackground(Color color) {
        if (color instanceof ColorUIResource) {
            color = null;
        }
        super.setBackground(color);
    }

    public Rectangle getCheckBoxBound() {
        return check.getBounds();
    }

    public Dimension getCheckBoxDimension() {
        return check.getPreferredSize();
    }


    public class TreeLabel extends JLabel {
        boolean isSelected;
        boolean hasFocus;

        public TreeLabel() {
        }

        public void setBackground(Color color) {
            if (color instanceof ColorUIResource)
                color = null;
            super.setBackground(color);
        }

        public void paint(Graphics g) {
            String str;
            if ((str = getText()) != null) {
                if (0 < str.length()) {
                    if (isSelected) {
                        g.setColor(UIManager.getColor("Tree.selectionBackground"));
                    } else {
                        g.setColor(UIManager.getColor("Tree.textBackground"));
                    }
                    Dimension d = getPreferredSize();
                    int imageOffset = 0;
                    Icon currentI = getIcon();
                    if (currentI != null) {
                        imageOffset = currentI.getIconWidth() + Math.max(0, getIconTextGap() - 1);
                    }
                    g.fillRect(imageOffset, 0, d.width - 1 - imageOffset, d.height);
                    if (hasFocus) {
                        g.setColor(UIManager.getColor("Tree.selectionBorderColor"));
                        g.drawRect(imageOffset, 0, d.width - 1 - imageOffset, d.height - 1);
                    }
                }
            }
            super.paint(g);
        }

        public Dimension getPreferredSize() {
            Dimension retDimension = super.getPreferredSize();
            if (retDimension != null) {
                retDimension = new Dimension(retDimension.width + 30,
                        retDimension.height);
            }
            return retDimension;
        }

        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
        }

        public void setFocus(boolean hasFocus) {
            this.hasFocus = hasFocus;
        }
    }
}

class CheckNode extends DefaultMutableTreeNode {

    /**
     *
     */
    private static final long serialVersionUID = -6710898572333832591L;
    public final static int SINGLE_SELECTION = 0;
    public final static int DIG_IN_SELECTION = 4;
    protected int selectionMode;
    public boolean isSelected;

    public CheckNode() {
        this(null);
    }

    public CheckNode(Object userObject) {
        this(userObject, true, false);
    }

    public CheckNode(Object userObject, boolean allowsChildren
                     , boolean isSelected) {
        super(userObject, allowsChildren);
        this.isSelected = isSelected;
        setSelectionMode(DIG_IN_SELECTION);
    }


    public void setSelectionMode(int mode) {
        selectionMode = mode;
    }

    public int getSelectionMode() {
        return selectionMode;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;

        if ((selectionMode == DIG_IN_SELECTION)
                && (children != null)) {
            Enumeration enums = children.elements();
            while (enums.hasMoreElements()) {
                CheckNode node = (CheckNode) enums.nextElement();
                node.setSelected(isSelected);
            }

        }
    }

    public void setPureSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }
}




