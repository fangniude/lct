package com.winnertel.em.framework.gui.swing.tree;

import javax.swing.tree.DefaultMutableTreeNode;

public final class FunctionTreeNode extends DefaultMutableTreeNode {
    public interface IType {
        public static String CM = "Configuration";
        public static String FM = "Fault";
        public static String PM = "Performance";
        public static String CPE = "CPE";
        public static String UG = "Upgrade";
    }


    public FunctionTreeNode() {
        super();
    }

    public FunctionTreeNode(FunctionTreeNodeObject userObject) {
        super(userObject);
    }

    public FunctionTreeNode(FunctionTreeNodeObject userObject, boolean allowsChildren) {
        super(userObject, allowsChildren);
    }

    public int hashCode() {
        return getUserObject().hashCode();
    }

    public boolean equals( Object obj ) {
        if( obj == null ) {
            return false;
        }
        if( obj instanceof FunctionTreeNode ) {
            return getUserObject().equals((((FunctionTreeNode) obj).getUserObject() ));
        }
        return false;
    }
}
