package com.winnertel.em.framework.gui.swing.tree;

import com.winnertel.em.framework.IApplication;

public abstract class BaseNodeDecorator implements INodeDecorator {
    protected IApplication fApplication = null;


    public BaseNodeDecorator(IApplication anApplication) {
        fApplication = anApplication;
    }

    public abstract void decorateNode(FunctionTreeNode aNode);
}
