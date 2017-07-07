package com.winnertel.ems.epon.iad.bbs4000;

import com.winnertel.ems.epon.iad.bbs4000.gui.action.DynamicFunctionTreeNodeAction;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.tree.BaseNodeDecorator;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;

import java.util.Properties;

public class IADViewTreeBuilder extends BaseNodeDecorator {
  //VoIP View
  private final String[] subTreeOfVoIP = new String[]{
      "VLAN",
      "DHCP",
      "DHCP_Relay",
      "DHCP_Server",
  };

  //Data View
  private final String[] subTreeOfData = new String[]{
      "VLAN",
      "Data_View_ONU",
  };

  //ONU View
  private final String[] subTreeOfONU = new String[]{
      "ONU_View_Port",
      "ONU_View_OLT",
      "Data_View_ONU",
      "ONU_View_Performance",
      "ONU_View_QoS"
  };

  //IPTV View
  private final String[] subTreeOfIPTV = new String[]{
      "VLAN",
      "IPTV_View_ONU",
      "IGMP_Multicast"
  };

  private IDeviceManager fDeviceManager = null;

  public IADViewTreeBuilder(IApplication anApplication) {
    super(anApplication);
  }

  public void decorateNode(FunctionTreeNode aNode) {
    FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) aNode.getUserObject();

    this.fDeviceManager = userObject.getDeviceManager();

    String id = userObject.getId();
    if (id.equalsIgnoreCase("VoIP")) {
      buildTree(aNode, subTreeOfVoIP);
    }else if(id.equalsIgnoreCase("Data")) {
      buildTree(aNode, subTreeOfData);
    }else if(id.equalsIgnoreCase("ONU")) {
      buildTree(aNode, subTreeOfONU);
    }else if(id.equalsIgnoreCase("IPTV")) {
      buildTree(aNode, subTreeOfIPTV);
    }else{
      System.out.println("Not Supported Node: " + id);
    }
  }

  private void buildTree(FunctionTreeNode aNode, String[] nodes) {
    for(int i  =0; i < nodes.length; i++) {
      aNode.add(createNode(nodes[i], fDeviceManager.getGuiComposer().getString(nodes[i]), fDeviceManager, fApplication, null, FunctionTreeNodeObject.ITEM));
    }
  }

  private static FunctionTreeNode createNode(String _nodeId, String _name, IDeviceManager _deviceManager, IApplication _application, Properties _keyContext, String _type) {
    FunctionTreeNodeObject nodeInfo;
    FunctionTreeNode node;
    DynamicFunctionTreeNodeAction action = new DynamicFunctionTreeNodeAction(_application);
    nodeInfo = new FunctionTreeNodeObject(_deviceManager, _nodeId, _name, action, null, _type);
    nodeInfo.setReadCommunity(_deviceManager.getReadCommunity());
    nodeInfo.setWriteCommunity(_deviceManager.getWriteCommunity());
    nodeInfo.setProperties(_keyContext);
    node = new FunctionTreeNode(nodeInfo);
    action.setFunctionTreeNode(node);
    return node;
  }
}
