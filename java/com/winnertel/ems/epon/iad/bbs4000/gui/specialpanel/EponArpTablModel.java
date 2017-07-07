package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.mib.EponArpTable;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Vector;

public class EponArpTablModel
{
	private PortTreeNodeBuilder builder = null;

	private int selectedIndex = -1;

	private EponArpTable arp = null;

  private EthInterface[] threeLayerInterface;

	public static final DefaultMutableTreeNode EMPTY_NODE = new DefaultMutableTreeNode( "Empty Port" );
	
	public EponArpTablModel( ISnmpProxy aSnmpProxy )
	{
		builder = new PortTreeNodeBuilder( aSnmpProxy );
		arp= new EponArpTable( aSnmpProxy );
	}
	public EponArpTable getModel( )
	{
		return arp;
	}
	
	public void refresh()
	{
		builder.refresh();
    threeLayerInterface = builder.getThreeLayerInterface();
    selectedIndex = -1;
  }
	
	public int getSelectedIndex()
	{
		return selectedIndex;
	}

  public void setSelectedIndex(int index)
  {
    selectedIndex = index;
  }

	public String[] getIPAddress ( )
	{
		String[] result = null;
	

		result = new String[threeLayerInterface.length];
		for( int i=0; i< threeLayerInterface.length; i++ )
		{
      result[i] = threeLayerInterface[i].getIpAddress() + " / " + threeLayerInterface[i].getMask();
//      if(!threeLayerInterface[i].getIpAddress().equals("0.0.0.0"))
//      {
//        result[i] = threeLayerInterface[i].getIpAddress() + " / " + threeLayerInterface[i].getMask();
//      }
		}

		return result;
	}

	
	public TreeNode getPortList()
	{
//		if( selectedInterface == null )
//		{
//			return EMPTY_NODE;
//		}
//		else
//		{
//			return builder.getPortInfo( selectedInterface );
//		}

    if(selectedIndex < 0 || threeLayerInterface == null || threeLayerInterface.length == 0 || selectedIndex >= threeLayerInterface.length)
    {
      return EMPTY_NODE;
    }
    else
    {
      return builder.getPortInfo( threeLayerInterface[selectedIndex] );
    }
	}
	
	public boolean isDuplicate(String ipAddress)
	{
    return ipAddress.equals( threeLayerInterface[selectedIndex].getIpAddress() ) ;
	}

  public boolean isSameNet(String ipAddress)
  {
	  return isSameNetAdd( ipAddress, threeLayerInterface[selectedIndex].getIpAddress(), threeLayerInterface[selectedIndex].getMask());
  }

	public void doOK( String ipAdd, TreeNode node, byte[] macAdd ) throws Exception
	{
		PortInfo portInfo = (PortInfo)((DefaultMutableTreeNode)node).getUserObject();

		arp.setUtsEponArpIpAddress( ipAdd );
		arp.setUtsEponArpMacAddress( macAdd );

    EthInterface selectedInterface = threeLayerInterface[selectedIndex];

    //NE are stupid, mib value are different in different table
 		if( selectedInterface.getPortType().intValue() == 4 )
		{
			arp.setUtsEponArpIntfType( new Integer(3) );
		}
    else if(selectedInterface.getPortType().intValue() == 5)
    {
      arp.setUtsEponArpIntfType( new Integer(4) );
    }
		else
		{
			arp.setUtsEponArpIntfType( selectedInterface.getPortType() );
		}


		arp.setUtsEponArpModuleId( portInfo.getCard() );
		arp.setUtsEponArpPortId( portInfo.getPort() );
		arp.setUtsEponArpLinkAggGroupId( portInfo.getLg() );
		arp.setUtsEponArpVlanId( portInfo.getVlan() );
		arp.setUtsEponArpVlanSubVlanId( portInfo.getSubVlan() );

//		arp.add();
	}
	

	private boolean isSameNetAdd( String ip, String threeLayerIP, String threeLayerMask )
	{
		String netAdd = ConfigUtility.getSubnetAddress( ip, threeLayerMask );
		String threeLayerNetAdd = ConfigUtility.getSubnetAddress( threeLayerIP, threeLayerMask );
		return netAdd.equals( threeLayerNetAdd );
	}
	
	/**
	 * 
	 * check if the ipaddress is already in the NE.
	 * @return
	 */
	public boolean isAlreadyExist( String ipAddress )
	{
		try
		{
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
}
