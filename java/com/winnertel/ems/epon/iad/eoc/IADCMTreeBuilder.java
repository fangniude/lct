package com.winnertel.ems.epon.iad.eoc;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.tree.BaseNodeDecorator;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.standard.gui.action.FunctionTreeNodeAction;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-5-18
 * Time: 11:16:04
 * To change this template use File | Settings | File Templates.
 */
public class IADCMTreeBuilder extends BaseNodeDecorator {

    private final static String CM_NODE = "CBAT";
    private final static String CLT2161A_NODE = "CLT2161A";

    private final static String[] CM_IAD_SIP = new String[]{
            "System Information",
            "Device Management",
            "RF",
            "MAC Layer",
            "CNU White List",
            "CNU Service",
            "IGMP Snooping",
    };

    private final static String FM_NODE = "Alarm Management";

    private final static String[] FM_IAD_SIP = new String[]{
            "Analog Property Table",
            "Discrete Property Table",
            "Current Alarm Table",
            "Alarm Log Number",
            "Trap Configuration"
    };

    private final static String PM_NODE = "Performance Management";

    private final static String[] PM_IAD_SIP = new String[]{
            "EoC Statistic"
    };

    public IADCMTreeBuilder(IApplication anApplication) {
        super(anApplication);
    }

    public void decorateNode(FunctionTreeNode aNode) {
        TreeBuilder.buildTree(fApplication, aNode); //delegate to
    }

    public static class TreeBuilder {

        private static TreeBuilder instance = new TreeBuilder();

        private TreeBuilder() {
        }

        public static TreeBuilder getInstance() {
            return instance;
        }

        public static void buildTree(IApplication app, FunctionTreeNode parentNode) {
            FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) parentNode.getUserObject();
            String id = userObject.getId();
            if (id.equals(CM_NODE) || id.equals(CLT2161A_NODE)) {
                addIADSubTree(parentNode, app);
            }
        }

        private static void addIADSubTree(FunctionTreeNode _parentNode, IApplication _application) {
            FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) _parentNode.getUserObject();
            IDeviceManager _deviceManager = userObject.getDeviceManager();
            for (int i = 0; i < CM_IAD_SIP.length; i++) {
                _parentNode.add(createNode(CM_IAD_SIP[i], _deviceManager, _application));
            }

            FunctionTreeNode fmNode = createNode(FM_NODE, _deviceManager, _application);
            _parentNode.add(fmNode);
            for (int i = 0; i < FM_IAD_SIP.length; i++) {
                fmNode.add(createNode(FM_IAD_SIP[i], _deviceManager, _application));
            }

            FunctionTreeNode pmNode = createNode(PM_NODE, _deviceManager, _application);
            _parentNode.add(pmNode);
            for (int i = 0; i < PM_IAD_SIP.length; i++) {
                pmNode.add(createNode(PM_IAD_SIP[i], _deviceManager, _application));
            }

        }

        private static FunctionTreeNode createNode(String _nodeId, IDeviceManager _deviceManager, IApplication _application) {
            FunctionTreeNodeObject nodeInfo;
            FunctionTreeNode node;
            FunctionTreeNodeAction action = new FunctionTreeNodeAction(_application);
            nodeInfo = new FunctionTreeNodeObject(_deviceManager, _nodeId, _deviceManager.getGuiComposer().getString(_nodeId), action, null, FunctionTreeNodeObject.ITEM);

            //nodeInfo.getProperties().put(B100Context.MODULE_ID, new Integer(stackId));
            node = new FunctionTreeNode(nodeInfo);
            action.setFunctionTreeNode(node);

            return node;
        }

    }
}
