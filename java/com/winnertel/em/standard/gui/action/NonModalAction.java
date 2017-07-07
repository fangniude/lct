package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.standard.gui.EditorDialog;

public class NonModalAction extends FunctionTreeNodeAction {
    protected FunctionTreeNode fNode = null;

    public NonModalAction(IApplication anApplication) {
        super(anApplication);
    }

    protected IEditorDialog getEditorDialog() {
        return new EditorDialog(fApplication, false);
    }
}
