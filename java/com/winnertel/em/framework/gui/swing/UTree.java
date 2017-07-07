package com.winnertel.em.framework.gui.swing;

import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.Hashtable;
import java.util.Vector;

public class UTree extends JTree {
    private boolean fInitialized;


    public UTree() {
        super();
        init();
    }

    public UTree(Object[] value) {
        super(value);
        init();
    }

    public UTree(Vector value) {
        super(value);
        init();
    }

    public UTree(Hashtable value) {
        super(value);
        init();
    }

    public UTree(TreeNode root) {
        super(root);
        init();
    }

    public UTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
        init();
    }

    public UTree(TreeModel newModel) {
        super(newModel);
        init();
    }


    private void init() {
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        putClientProperty("JTree.lineStyle", "Angled");

        setCellRenderer(new DefaultTreeCellRenderer() {
            public Component getTreeCellRendererComponent(JTree tree,
                                                          Object value,
                                                          boolean sel,
                                                          boolean expanded,
                                                          boolean leaf,
                                                          int row,
                                                          boolean hasFocus) {
                JLabel renderer = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                FunctionTreeNodeObject treeNodeObject = (FunctionTreeNodeObject) (((DefaultMutableTreeNode) value).getUserObject());
                Icon icon = treeNodeObject.getIcon();
                if (icon != null) {
                    renderer.setIcon(icon);
                }
                if( treeNodeObject.getProperties() != null && "true".equalsIgnoreCase(treeNodeObject.getProperties().getProperty("hit", "false") ) ) {
                    renderer.setBackground( Color.YELLOW);
                    renderer.setForeground( Color.RED);
                    renderer.setOpaque(true);
                } else {
                    renderer.setOpaque(false);
                }
                return renderer;
            }
        });
    }


    public boolean isInitialized() {
        return fInitialized;
    }

    public void setInitialized(boolean aInitialized) {
        fInitialized = aInitialized;
    }
}
