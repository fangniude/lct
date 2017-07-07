package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.mib.HostRouteTable;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Vector;

public class HostRouteTablModel
{
	private ISnmpProxy aSnmpProxy;
	private PortTreeNodeBuilder builder = null;
	private EthInterface selectedInterface = null;
	
	private boolean duplicate = false;
	private boolean alreadyExist = false;
	private int selectIndex = -1;
	private String checkedIPAddress = null;
	
	private HostRouteTable host = null;
	
	public static final DefaultMutableTreeNode EMPTY_NODE = new DefaultMutableTreeNode( "Empty Port" );
	
	public HostRouteTablModel( ISnmpProxy aSnmpProxy )
	{
		this.aSnmpProxy = aSnmpProxy;
		builder = new PortTreeNodeBuilder( aSnmpProxy );
		host = new HostRouteTable( aSnmpProxy );
	}
	public HostRouteTable getModel( )
	{
		return host;
	}
	
	public void refresh()
	{
		builder.refresh();
	}

	public int getSelectIndex()
	{
		return selectIndex;
	}
	
	public String[] getIPAddress ( )
	{
		String[] result = null;
	
		EthInterface[] threeLayerInterface = builder.getThreeLayerInterface();
		result = new String[threeLayerInterface.length];
		for( int i=0; i< threeLayerInterface.length; i++ )
		{
            if(threeLayerInterface[i].getIpAddress().equals("0.0.0.0")) continue;
			result[i] = threeLayerInterface[i].getIpAddress() + "---" + threeLayerInterface[i].getMask();
		}

		return result;
	}

	
	public TreeNode getPortList()
	{
		if( selectedInterface == null )
		{
			return EMPTY_NODE;
		}
		else
		{
			return builder.getPortInfo( selectedInterface );
		}
	}
	
	public boolean isDuplicate()
	{
		return duplicate;
	}
	public boolean isAlreadyExist()
	{
		return alreadyExist;
	}
	public boolean isLayer3Interface()
	{
		return selectedInterface != null;
	}

	public void doCheck( String ipAddress )
	{
		if( checkedIPAddress!= null && checkedIPAddress.equals( ipAddress ) )
		{
			return;
		}
		else
		{
			checkedIPAddress = ipAddress;
			
			EthInterface[] threeLayerInterface = builder.getThreeLayerInterface();
			selectedInterface = getSelectedInterface( ipAddress, threeLayerInterface );
			if( isLayer3Interface() && (!isDuplicate()) )
			{
				alreadyExist = checkExistRecord( ipAddress );
			}
		}
	}
	
	public void doOK( String ipAdd, TreeNode node ) throws Exception
	{
		PortInfo portInfo = (PortInfo)((DefaultMutableTreeNode)node).getUserObject();
		
		host.setUtsHostRouteIpAddress( ipAdd );
		
		if( selectedInterface.getPortType().intValue() == 5 )
		{
			host.setUtsHostRouteType( new Integer(6) );//NE are stupid, mib value are different in different table
		}
		else 
		{
			host.setUtsHostRouteType( selectedInterface.getPortType() );
		}
		
		host.setUtsHostRouteModuleId( portInfo.getCard() );
		host.setUtsHostRoutePortId( portInfo.getPort() );
		host.setUtsHostRouteLinkAggGroupId( portInfo.getLg() );
		host.setUtsHostRouteVlanId( portInfo.getVlan() );
		host.setUtsHostRouteVlanSubVlanId( portInfo.getSubVlan() );
		
//		host.add();
	}
	
	/**
	 * get the selected interface by ipAddress, null means the ipaddress is not in the three layer interface
	 * 
	 * @param ipAddress
	 * @param threeLayerInterface
	 * @return
	 */
	private EthInterface getSelectedInterface( String ipAddress, EthInterface[] threeLayerInterface )
	{
		EthInterface ethInter = null;
		for( int i=0; i<threeLayerInterface.length; i++ )
		{
			if( isSameNetAdd( ipAddress, threeLayerInterface[i].getIpAddress(), threeLayerInterface[i].getMask()) )
			{
                if(threeLayerInterface[i].getIpAddress().equals("0.0.0.0")) continue;
				ethInter = threeLayerInterface[i];
				if( ipAddress.equals( threeLayerInterface[i].getIpAddress() ) )
				{
					duplicate = true;
				}
				else
				{
					duplicate = false;
				}
				selectIndex = i;
				
				break;
			}
		}
		return ethInter;
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
	private boolean checkExistRecord( String ipAddress )
	{
		try
		{
			Vector hostVec = host.retrieveAll();
			if( hostVec == null )
			{
				return false;
			}
			for( int i=0; i<hostVec.size(); i++ )
			{
				HostRouteTable record = ( HostRouteTable )hostVec.get( i );
				
				if( ipAddress.equals( record.getUtsHostRouteIpAddress() ) )
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
