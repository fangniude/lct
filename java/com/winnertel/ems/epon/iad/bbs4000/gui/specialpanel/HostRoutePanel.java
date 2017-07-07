package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.HostRouteTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class HostRoutePanel extends UPanel  implements ListSelectionListener, KeyListener{
  private IPAddressField ipAddressTextField = new IPAddressField();;
  private JList interfaceList = new JList();;
  JScrollPane ifPane = new JScrollPane(interfaceList);
  private JTree portListTree = new JTree();

  private PortTreeNodeBuilder builder = new PortTreeNodeBuilder(fApplication.getSnmpProxy());
  private EthInterface[] ifList = null;

  /**
   * This is the default constructor
   */
  public HostRoutePanel(IApplication app) {
    super(app);
    init();
  }

  public void initGui() {
    initialize();
  }

  /**
   * This method initializes this
   */
  private void initialize() {
    NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    setLayout(layout);

//
    add(new JLabel(fStringMap.getString("IP Address:")));
    ipAddressTextField.addKeyListener(this);
    add(ipAddressTextField);
    add(new HSpacer());


    add(new JLabel(fStringMap.getString("Layer 3 Interface:")));
    interfaceList.setEnabled(false);
    interfaceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    interfaceList.addListSelectionListener(this);
    ifPane.setPreferredSize(new Dimension(300, 200));
    add(ifPane);
    add(new HSpacer());

    add(new JLabel(fStringMap.getString("Port List:")));
    portListTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    JScrollPane pane2 = new JScrollPane(portListTree);
    pane2.setPreferredSize(new Dimension(300, 200));
    add(pane2);
    add(new HSpacer());
  }


  public void refresh() {
    builder.refresh();
    ifList = builder.getThreeLayerInterface();
    interfaceList.setListData(ifList);
    portListTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(fStringMap.getString("Empty Port"))));
  }

  public void updateModel() {
    HostRouteTable host = new HostRouteTable(fApplication.getSnmpProxy());

    host.setUtsHostRouteIpAddress( ipAddressTextField.getIPString() );

    EthInterface intf = (EthInterface)interfaceList.getSelectedValue();
    if( intf.getPortType().intValue() == 5 )
    {
      host.setUtsHostRouteType( new Integer(6) );//NE are stupid, mib value are different in different table
    }
    else
    {
      host.setUtsHostRouteType( intf.getPortType() );
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode)portListTree.getLastSelectedPathComponent();
    PortInfo portInfo = (PortInfo)node.getUserObject();
    host.setUtsHostRouteModuleId( portInfo.getCard() );
    host.setUtsHostRoutePortId( portInfo.getPort() );
    host.setUtsHostRouteLinkAggGroupId( portInfo.getLg() );
    host.setUtsHostRouteVlanId( portInfo.getVlan() );
    host.setUtsHostRouteVlanSubVlanId( portInfo.getSubVlan() );

    setModel(host);
  }

  public boolean validateFrom() {
    if (interfaceList.getSelectedIndex() == -1) {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Not_Belong_To_Layer3"));
      return false;
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode) portListTree.getLastSelectedPathComponent();
    if (node == null || !node.isLeaf() || !(node.getUserObject() instanceof PortInfo)) {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Port_Not_Selected"));
      return false;
    }

    if (!checkIPAddressValid()) {
      return false;
    }

    return true;
  }

  private boolean checkIPAddressValid() {
    String ipAddress = ipAddressTextField.getIPString();
    if (isSubnetAddress(ipAddress)) {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Is_Sub_Net"));
      return false;
    }

    if (isDuplicate(ipAddress)) {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Is_Used_By_Layer3"));
      return false;
    }

    if (isAlreadyExist(ipAddress)) {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Is_Used_By_Host"));
      return false;
    }

    return true;
  }

  protected boolean isSubnetAddress(String ipAddress) {
    String subnet = ConfigUtility.getSubnetAddress(ipAddress, ifList[interfaceList.getSelectedIndex()].getMask());

    return ipAddress.equals(subnet);
  }

  protected boolean isDuplicate(String ipAddress) {
    return ipAddress.equals(ifList[interfaceList.getSelectedIndex()].getIpAddress());
  }

  /**
   * check if the ipaddress is already in the NE.
   *
   * @return
   */
  public boolean isAlreadyExist(String ipAddress) {
    // get static host route records
    try {
      HostRouteTable hostRouteTblMBean = new HostRouteTable(fApplication.getSnmpProxy());
      Vector hostRouteTblVec = hostRouteTblMBean.retrieveAll();

      for (int i = 0; i < hostRouteTblVec.size(); i++) {
        HostRouteTable hostRoute = (HostRouteTable) hostRouteTblVec.elementAt(i);
        if (hostRoute.getUtsHostRouteIpAddress().equals(ipAddressTextField.getIPString())) {
          return false;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return false;
  }

  public void valueChanged(ListSelectionEvent e) {
    if (interfaceList.getSelectedIndex() != -1) {
      portListTree.setModel(new DefaultTreeModel(builder.getPortInfo((EthInterface) interfaceList.getSelectedValue())));
    } else {
      portListTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(fStringMap.getString("Empty Port"))));
    }
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    String ip = ipAddressTextField.getIPString();

    for (int i = 0; i < ifList.length; i++) {
      String mask = ifList[i].getMask();

      String subnet1 = ConfigUtility.getSubnetAddress(ip, mask);
      String subnet2 = ConfigUtility.getSubnetAddress(ifList[i].getIpAddress(), mask);

      if (subnet1.equals(subnet2)) {
        int index = interfaceList.getSelectedIndex();

        if (index != i) {
          interfaceList.setSelectedIndex(i);
          Point p = interfaceList.indexToLocation(i);

          ifPane.getViewport().setViewPosition(p);
          ifPane.updateUI();
        }

        return;
      }
    }

    interfaceList.clearSelection();
  }
}
