package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.standard.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FunctionTreeNodeAction extends BaseAction {
    protected FunctionTreeNode fNode = null;


    public FunctionTreeNodeAction(IApplication anApplication) {
        super(anApplication);
    }


    public final void setFunctionTreeNode(FunctionTreeNode aNode) {
        fNode = aNode;
    }


    /**
     * If DvM has a shelf view, this method should be overrided.
     * <p/>
     * DvM should update shelf view in this method and tell framework
     * if the shelf view should be shown.
     * <p/>
     * When the GUI style is embeded, if the return value is true,
     * the framework will show shelf view in right area and the tabbed panel
     * won't come up.
     */
    protected boolean showShelfView() {
        return false;
    }


    public final void executeAction(ActionEvent e) {
        FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) fNode.getUserObject();

        switchDeviceManager(userObject);

        String id = (String) getValue(BaseAction.ID);
        if (id == null) {
            return;
        }

        // backup old communities
        String oldReadCommunity = fApplication.getSnmpProxy().getReadCommunity();
        String oldWriteCommunity = fApplication.getSnmpProxy().getWriteCommunity();

        try {
            boolean bShelfView = showShelfView();
            if (fApplication.getGUIStyle() == Application.EMBEDDED_STYLE && bShelfView) {
                fApplication.getMainApplet().setShelfView(fApplication.getActiveDeviceManager().getShelfViewPane());
                return;
            } else {
                // set new communities for snmp proxy
                setCommunities(userObject);

                // show editor dialog
                IEditorDialog editorDialog = getEditorDialog();
                JTabbedPane tabbedPane = editorDialog.getTabbedPane();

                beforeComposeTabbedPane();
                editorDialog.compose(id);
                afterComposeTabbedPane(tabbedPane);

                beforeShowEditorDialog();
                showEditorDialog(editorDialog);
                afterShowEditorDialog();
            }
        } finally {
            if (fApplication.getGUIStyle() == Application.POPUP_STYLE) {
                // restore original communities for snmp proxy
                fApplication.getSnmpProxy().setReadCommunity(oldReadCommunity);
                fApplication.getSnmpProxy().setWriteCommunity(oldWriteCommunity);
            }
        }
    }

    protected IEditorDialog getEditorDialog() {
        return fApplication.getMainApplet().getEditorDialog();
    }

    protected void beforeComposeTabbedPane() {
    }

    protected void afterComposeTabbedPane(JTabbedPane aTabbedPane) {
    }


    protected void beforeShowEditorDialog() {
    }

    protected void afterShowEditorDialog() {
    }


    private void switchDeviceManager(FunctionTreeNodeObject aUserObject) {
        if (aUserObject.getDeviceManager() != fApplication.getActiveDeviceManager()) {
            fApplication.getMainApplet().setActiveDeviceManager(aUserObject.getDeviceManager());
        }
    }

    private void setCommunities(FunctionTreeNodeObject aUserObject) {
        String readCommunity = aUserObject.getReadCommunity();
        if (readCommunity != null) {
            fApplication.getSnmpProxy().setReadCommunity(readCommunity);
        }
        String writeCommunity = aUserObject.getWriteCommunity();
        if (writeCommunity != null) {
            fApplication.getSnmpProxy().setWriteCommunity(writeCommunity);
        }
    }

    private void showEditorDialog(IEditorDialog aEditorDialog) {
        aEditorDialog.setTitle(fNode.getUserObject().toString());
        aEditorDialog.show();
    }
}
