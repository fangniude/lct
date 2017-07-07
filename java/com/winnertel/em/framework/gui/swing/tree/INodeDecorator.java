package com.winnertel.em.framework.gui.swing.tree;

public interface INodeDecorator {
    /**
     * This method is used for build dynamic nodes, for instance,
     * the module(slot) node. You do whatever you want with aNode,
     * such as append nodes to aNode, modify aNode itself and so on.
     *
     * @param aNode node to decorate
     */
    public void decorateNode(FunctionTreeNode aNode);
}
