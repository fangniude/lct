package com.winnertel.ems.epon.iad.bbs1000.gui.specialpanel;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortInfo;
import com.winnertel.ems.epon.iad.bbs4000.mib.EponArpTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.HostRouteTable;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.Vector;

public class EponArpPanel extends UPanel implements ListSelectionListener, KeyListener
{
  private IPAddressField ipAddressTextField = new IPAddressField();;
  private JList interfaceList = new JList();;
  JScrollPane ifPane = new JScrollPane(interfaceList);
  private JTree portListTree = new JTree();
  private MacAddressField macTextField = new MacAddressField( MacAddressField.UNICAST_TYPE);

  private PortTreeNodeBuilder builder = new PortTreeNodeBuilder(fApplication.getSnmpProxy());
  private EthInterface[] ifList = null;
  /**
   * This is the default constructor
   */
  public EponArpPanel( IApplication app )
  {
    super( app );
    init();
  }
  public void initGui()
  {
    initialize();
  }

  /**
   * This method initializes this
   *
   */
  private void initialize()
  {
    NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5) ;
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

    add(new JLabel(fStringMap.getString("MAC Address:")));
    macTextField.setValue( "00:00:00:00:00:00" );
    add(macTextField);
    add(new HSpacer());
  }

  public void refresh()
  {
    builder.refresh();
    ifList = builder.getThreeLayerInterface();
    interfaceList.setListData( ifList );
    portListTree.setModel( new DefaultTreeModel( new DefaultMutableTreeNode( fStringMap.getString("Empty Port") ) ) );
  }

  public void updateModel()
  {
    EponArpTable arp = new EponArpTable(fApplication.getSnmpProxy());

    arp.setUtsEponArpIpAddress( ipAddressTextField.getIPString() );
    arp.setUtsEponArpMacAddress( macTextField.getValue() );

    EthInterface intf = (EthInterface)interfaceList.getSelectedValue();

    //NE are stupid, mib value are different in different table
     if( intf.getPortType().intValue() == 4 )
    {
      arp.setUtsEponArpIntfType( new Integer(3) );
    }
    else if(intf.getPortType().intValue() == 5)
    {
      arp.setUtsEponArpIntfType( new Integer(4) );
    }
    else
    {
      arp.setUtsEponArpIntfType( intf.getPortType() );
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode)portListTree.getLastSelectedPathComponent();
    PortInfo portInfo = (PortInfo)node.getUserObject();

    arp.setUtsEponArpModuleId( portInfo.getCard() );
    arp.setUtsEponArpPortId( portInfo.getPort() );
    arp.setUtsEponArpLinkAggGroupId( portInfo.getLg() );
    arp.setUtsEponArpVlanId( portInfo.getVlan() );
    arp.setUtsEponArpVlanSubVlanId( portInfo.getSubVlan() );

    setModel(arp);
  }

  public boolean validateFrom()
  {
    if(interfaceList.getSelectedIndex() == -1)
    {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_IP_Not_Belong_To_Layer3"));
      return false;
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode)portListTree.getLastSelectedPathComponent();
    if( node == null || !node.isLeaf() || !(node.getUserObject() instanceof PortInfo))
    {
      MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Port_Not_Selected"));
      return false;
    }

    if( !checkIPAddressValid() )
    {
      return false;
    }

    if( !isMACValid() )
    {
      MessageDialog.showInfoMessageDialog( fApplication, "MAC address is null." );
      return false;
    }
    return true;
  }

  private boolean checkIPAddressValid( )
  {
    String ipAddress = ipAddressTextField.getIPString();
    if( isSubnetAddress(ipAddress) )
    {
      MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Sub_Net"));
      return false;
    }

    if( isDuplicate(ipAddress) )
    {
      MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Used_By_Layer3"));
      return false;
    }

    if( isAlreadyExist(ipAddress) )
    {
      MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Used_By_ARP"));
      return false;
    }

    // get static host route records
    try {
      HostRouteTable hostRouteTblMBean = new HostRouteTable( fApplication.getSnmpProxy() );
      Vector hostRouteTblVec = hostRouteTblMBean.retrieveAll();

      for ( int i = 0; i < hostRouteTblVec.size(); i++ ) {
        HostRouteTable hostRoute = (HostRouteTable)hostRouteTblVec.elementAt(i);
        if ( hostRoute.getUtsHostRouteArpType().intValue() == 4 && hostRoute.getUtsHostRouteIpAddress().equals(ipAddressTextField.getIPString()))
        {
          MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Used_By_Host"));
          return false;
        }
      }
    } catch ( Exception ex ) {
      ex.printStackTrace();
    }

    return true;
  }

  protected boolean isSubnetAddress(String ipAddress)
  {
    String subnet = ConfigUtility.getSubnetAddress(ipAddress, ifList[interfaceList.getSelectedIndex()].getMask());

    return ipAddress.equals(subnet);
  }

  protected boolean isDuplicate(String ipAddress)
  {
    return ipAddress.equals( ifList[interfaceList.getSelectedIndex()].getIpAddress() ) ;
  }

  /**
   *
   * check if the ipaddress is already in the NE.
   */
  public boolean isAlreadyExist( String ipAddress )
  {
    try
    {
      EponArpTable arp = new EponArpTable(fApplication.getSnmpProxy());
      Vector arpVec = arp.retrieveAll();
      if( arpVec == null )
      {
        return false;
      }
      for( int i=0; i<arpVec.size(); i++ )
      {
        EponArpTable record = ( EponArpTable )arpVec.get( i );

        if( ipAddress.equals( record.getUtsEponArpIpAddress() ) )
        {
          return true;
        }
      }
    } catch (MibBeanException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  private boolean isMACValid()
  {
    String macAdd = macTextField.getMacString();

    return !macAdd.equals( "00:00:00:00:00:00" );
  }

  public void valueChanged(ListSelectionEvent e) {
    if(interfaceList.getSelectedIndex() != -1)
    {
      portListTree.setModel( new DefaultTreeModel( builder.getPortInfo((EthInterface)interfaceList.getSelectedValue()) ) );
    }
    else
    {
      portListTree.setModel( new DefaultTreeModel( new DefaultMutableTreeNode( fStringMap.getString("Empty Port") ) ) );
    }
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    String ip = ipAddressTextField.getIPString();

    ipAddressTextField.isValid();

    String[] list = ip.split("\\.");
    for(int i = 0; i < list.length; i++)
      if(list[i].equals("")) return ;

    for(int i = 0; i < ifList.length; i++)
    {
      String mask = ifList[i].getMask();

      String subnet1 = ConfigUtility.getSubnetAddress( ip, mask );
      String subnet2 = ConfigUtility.getSubnetAddress( ifList[i].getIpAddress(), mask);

      if(subnet1.equals(subnet2))
      {
        int index = interfaceList.getSelectedIndex();

        if(index != i)
        {
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
