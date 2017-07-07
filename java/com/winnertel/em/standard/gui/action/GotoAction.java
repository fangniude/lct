package com.winnertel.em.standard.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.IMainApplet;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UTree;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GotoAction extends BaseAction {
    private static final long serialVersionUID = -2210653217805492119L;

    private ILogger fLogger = LoggerController.createLogger(GotoAction.class);

    private String fTreeTab = null;
    private String fTreeLeaf = null;
    private String fFeature = null;
    private BaseAction fCallbackAction = null;
    private IMainApplet fMainApplet;

    public GotoAction(IApplication anApplication, String aTreeTab, String aTreeLeaf, String aFeature) {
        this(anApplication, aTreeTab, aTreeLeaf, aFeature, null);
    }

    public GotoAction(IApplication anApplication, String aTreeTab, String aTreeLeaf, String aFeature, BaseAction aCallBackAction) {
        super(anApplication);
        this.fTreeTab = aTreeTab;
        this.fTreeLeaf = aTreeLeaf;
        this.fFeature = aFeature;
        this.fCallbackAction = aCallBackAction;
        fMainApplet = fApplication.getMainApplet();
    }

    @Override
    public void executeAction(ActionEvent e) throws Exception {
        if (gotoTreeTab() && gotoTreeLeaf()) {
            Component src = gotoFeature();
            if (fCallbackAction != null) {
                ActionEvent event = new ActionEvent(src, ActionEvent.ACTION_PERFORMED, (String) fCallbackAction.getValue(BaseAction.ID));
                fCallbackAction.actionPerformed(event);
            }
        }
    }

    private boolean gotoTreeTab() {
        UTree functionTree = fMainApplet.getFunctionTree(fTreeTab);
        if (null == functionTree) {
            fLogger.error("The goto Tree tab was not found, please check it:" + fTreeTab);
            MessageDialog.showInfoMessageDialog(fApplication, "Goto failed!");
            return false;
        }
        Container scrollPane = functionTree.getParent().getParent();
        JTabbedPane tabbedPane = (JTabbedPane) scrollPane.getParent();
        tabbedPane.setSelectedComponent(scrollPane);
        return true;
    }

    private boolean gotoTreeLeaf() {
        FunctionTreeNode theLeafNode = findTheLeaf();

        if (theLeafNode == null) {
            return false;
        }

        // 1. set the leaf selected
        UTree functionTree = fMainApplet.getFunctionTree(fTreeTab);
        TreePath theLeafPath = new TreePath(((DefaultTreeModel) functionTree.getModel()).getPathToRoot(theLeafNode));
        functionTree.expandPath(theLeafPath);
        functionTree.getSelectionModel().setSelectionPath(theLeafPath);
        functionTree.makeVisible(theLeafPath);

        // 2. perform the action
        FunctionTreeNodeObject node = (FunctionTreeNodeObject) theLeafNode.getUserObject();
        BaseAction action = node.getExecutor();
        ActionEvent event = new ActionEvent(node, ActionEvent.ACTION_PERFORMED, (String) action.getValue(BaseAction.ID));
        action.actionPerformed(event);
        return true;

    }

    private FunctionTreeNode findTheLeaf() {
        UTree functionTree = fMainApplet.getFunctionTree(fTreeTab);

        FunctionTreeNode root = (FunctionTreeNode) functionTree.getModel().getRoot();
        FunctionTreeNode nextLeaf = (FunctionTreeNode) root.getFirstLeaf();

        while (null != nextLeaf) {
            FunctionTreeNodeObject node = (FunctionTreeNodeObject) nextLeaf.getUserObject();
            if (node.getId().equals(fTreeLeaf)) {
                return nextLeaf;
            }
            nextLeaf = (FunctionTreeNode) nextLeaf.getNextLeaf();
        }

        fLogger.error("The goto tree leaf was not found, please check it:" + fTreeLeaf);
        MessageDialog.showInfoMessageDialog(fApplication, "Goto failed!");
        return null;
    }

    private Component gotoFeature() {
        JTabbedPane tabbedPane = fMainApplet.getEditorDialog().getTabbedPane();
        Component[] tabs = tabbedPane.getComponents();
        for (int i = 0; i < tabs.length; i++) {
            JPanel panel = (JPanel) tabs[i];
            String name = panel.getName();
            if (name.equals(fFeature)) {
                tabbedPane.setSelectedIndex(i);
                return panel;
            }
        }
        fLogger.error("The goto tree feature was not found, please check it:" + fFeature);
        MessageDialog.showInfoMessageDialog(fApplication, "Goto failed!");
        return null;
    }

}
