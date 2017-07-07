package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class PortTreeNodeBuilder
{
	private ISnmpProxy aSnmpProxy;
	
	private EthInterface[] ethInterface = null;

//	private LagInterface[] lagInterface = null;
	private VlanInterface[] vlanInterface = null;
	private SuperVlanInterface[] superVlanInterface = null;
	
	public PortTreeNodeBuilder( ISnmpProxy aSnmpProxy )
	{
		this.aSnmpProxy = aSnmpProxy;
	}
	
	public void refresh()
	{
		ethInterface = EthInterface.getInterface( aSnmpProxy );	
		vlanInterface = VlanInterface.getVlanInterface( aSnmpProxy );
		superVlanInterface = SuperVlanInterface.getSuperVlanInterface( aSnmpProxy );
	}
	
	public TreeNode getPortInfo( EthInterface threeLayerInterface )
	{
		switch (threeLayerInterface.getPortType().intValue())
		{
			case EthInterface.PORT: 
				return getNormalPortInfo( threeLayerInterface.getInterfaceID() );
				
			case EthInterface.LAG_PORT:
				return getLagPortInfo( threeLayerInterface.getInterfaceID() );
				
			case EthInterface.VLAN_PORT:
				return getVlanPortInfo( threeLayerInterface.getInterfaceID(), -1 );
				
			case EthInterface.SUPER_VLAN_PORT:
				return getSuperVlanPortInfo( threeLayerInterface.getInterfaceID() );
				
			default:
				return null;
		}		
	}
	
	private TreeNode getNormalPortInfo( String interfaceId )
	{
		PortInfo portInfo = new PortInfo();
		portInfo.setInterfaceId( interfaceId );
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(portInfo);
		
		return node;
	}
	
	private TreeNode getLagPortInfo( String interfaceId )
	{
		PortInfo portInfo = new PortInfo();
		portInfo.setInterfaceId( interfaceId );

		DefaultMutableTreeNode node = new DefaultMutableTreeNode(portInfo);
		
		return node;
	}

	/**
	 * if vlan belongs to a superSVI, the return port list should belongs to both the vlan and the superSVI;
	 * if vlan doesn't belong to a superSVI (the para is null ),the return port just belongs to the vlan.  
	 * 
	 * @param interfaceID
	 * @param superSVIID -1 means no superSVI
	 * @return
	 */
	private TreeNode getVlanPortInfo( String interfaceID, int superSVIID )
	{
		PortInfo portInfo = new PortInfo();
		portInfo.setInterfaceId( interfaceID );
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(portInfo);
		
		if( vlanInterface == null )
		{
			vlanInterface = VlanInterface.getVlanInterface( aSnmpProxy );
		}

		int[] intPorts = null;
		for( int i=0; i<vlanInterface.length; i++ )
		{
			if( vlanInterface[i].getVlanId() == portInfo.getVlan().intValue() )
			{
				intPorts = ConfigUtility.portMappingToPortArray( vlanInterface[i].getPortList() );
				break;
			}
		}
		
		/**
		 * get the superSVI portlist
		 */
		int[] superPorts = null;
		if( superSVIID != -1 )
		{
			for( int i=0; i<vlanInterface.length; i++ )
			{
				if( vlanInterface[i].getVlanId() == superSVIID )
				{
					superPorts = ConfigUtility.portMappingToPortArray( vlanInterface[i].getPortList() );
					break;
				}
			}
			
			if( superPorts != null )
			{
				for( int i=0; i<intPorts.length; i++ )
				{
					boolean exist = false;
					for( int j=0; j<superPorts.length; j++ )
					{
						if( intPorts[i] == superPorts[j] )
						{
							exist = true;
						}
					}
					
					if( !exist )
					{
						intPorts[i] = -1;
					}
					
				}
			}
		}

		String[] portlist = new String[intPorts.length];
		
		for( int i=0; i<portlist.length; i++ )
		{
			portlist[i] = ConfigUtility.displayConfigIntfNum( intPorts[i] );
		}
		
		if( portlist != null )
		{
			for( int i=0; i<portlist.length; i++ )
			{
				if( "".equals( portlist[i]) )
				{
					continue;
				}
				
				TreeNode portNode = null;
				
				if( portlist[i].startsWith( "lg" ) )
				{
					portNode  = getLagPortInfo( portlist[i] );
				}
				else
				{
					PortInfo port = new PortInfo();
					port.setInterfaceId( portlist[i] );
					portNode = new DefaultMutableTreeNode(port);
				}
				
				node.add( (DefaultMutableTreeNode)portNode );
			}
		}
		
		setLeafWithVlan( node, portInfo.getVlan() );
		
		return node;
	}
	
	private TreeNode getSuperVlanPortInfo( String interfaceID )
	{
		PortInfo portInfo = new PortInfo();
		portInfo.setInterfaceId( interfaceID );
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode( portInfo );
		
		if( superVlanInterface == null )
		{
			superVlanInterface = SuperVlanInterface.getSuperVlanInterface( aSnmpProxy );
		}
		String[] portlist = null;
		
		for( int i=0; i<superVlanInterface.length; i++ )
		{
			if( superVlanInterface[i].getVlanId().equals( portInfo.getVlan().toString() ) )
			{
        int[] vlan = ConfigUtility.VlanMappingToVlanArray(superVlanInterface[i].getVlanMember());
				portlist = new String[vlan.length];
        for(int j = 0; j < vlan.length; j++)
        {
          portlist[j] = "" + vlan[j];
        }
			}
		}
		
		if( portlist != null )
		{
			for( int i=0; i<portlist.length; i++ )
			{
				if( portlist[i].length() == 0 )
				{
					continue;
				}
				TreeNode portNode = null;
				
				portNode = getVlanPortInfo( "vlan" + portlist[i], portInfo.getVlan().intValue() );
				node.add( ( DefaultMutableTreeNode )portNode );
			}
		}
		
		setLeafWithVlan( node, portInfo.getVlan() );
		
		return node;
	}
	
	private void setLeafWithVlan( DefaultMutableTreeNode node, Integer vlan)
	{
		DefaultMutableTreeNode leaf = node.getFirstLeaf();
		
		while( leaf != null )
		{
			PortInfo portInfo = ( PortInfo )leaf.getUserObject();
			portInfo.setVlan( vlan );
			leaf = leaf.getNextLeaf();
		}
	}


	public SuperVlanInterface[] getSuperVlanInterface()
	{
		if( superVlanInterface == null )
		{
			superVlanInterface = SuperVlanInterface.getSuperVlanInterface(aSnmpProxy);
		}
		return superVlanInterface;
	}

	/**
	 * EthInterfac table and SecondIPAddress table
	 * @return
	 */
	public EthInterface[] getThreeLayerInterface()
	{
		ArrayList list = new ArrayList();
		if( ethInterface == null )
		{
			ethInterface = EthInterface.getInterface( aSnmpProxy );
		}

		for( int i=0; i<ethInterface.length; i++ )
		{
			if( ethInterface[i].getSwitchMode() == EthInterface.layer3 && !ethInterface[i].getIpAddress().equals("0.0.0.0"))
			{
				list.add( ethInterface[i] );
			}
		}
		
		if( list.size() > 0 )
		{
			return (EthInterface[])list.toArray( new EthInterface[0]);	
		}
		else
		{
			return new EthInterface[0];
		}
		
	}
	
	/**
	 * only EthInterface table
	 * @return
	 */
	public EthInterface[] getLayer3EthInterface()
	{
		ArrayList list = new ArrayList();

		EthInterface[] layer3EthInterface= EthInterface.getEthInterface( aSnmpProxy );


		for( int i=0; i<layer3EthInterface.length; i++ )
		{
			if( layer3EthInterface[i].getSwitchMode() == EthInterface.layer3 && 
					!layer3EthInterface[i].getIpAddress().equals("0.0.0.0") )
			{
				list.add( layer3EthInterface[i] );
			}
		}
		
		if( list.size() > 0 )
		{
			return (EthInterface[])list.toArray( new EthInterface[0]);	
		}
		else
		{
			return new EthInterface[0];
		}
		
	}
	
	/**
	 * only EthInterface table
	 * @return
	 */
	public EthInterface[] getLayer2EthInterface()
	{
		ArrayList list = new ArrayList();

		EthInterface[] layer2EthInterface= EthInterface.getEthInterface( aSnmpProxy );


		for( int i=0; i<layer2EthInterface.length; i++ )
		{
			if( layer2EthInterface[i].getSwitchMode() == EthInterface.layer2 )
			{
				list.add( layer2EthInterface[i] );
			}
		}
		
		if( list.size() > 0 )
		{
			return (EthInterface[])list.toArray( new EthInterface[0]);	
		}
		else
		{
			return new EthInterface[0];
		}
		
	}
	public EthInterface[] getTwoLayerInterface()
	{
		ArrayList list = new ArrayList();
		if( ethInterface == null )
		{
			ethInterface = EthInterface.getInterface( aSnmpProxy );	
		}
		
		for( int i=0; i<ethInterface.length; i++ )
		{
			if( ethInterface[i].getSwitchMode() == EthInterface.layer2 )
			{
				list.add( ethInterface[i] );
			}
		}
		
		if( list.size() > 0 )
		{
			return (EthInterface[])list.toArray( new EthInterface[0]);	
		}
		else
		{
			return new EthInterface[0];
		}
	}
	
	public VlanInterface[] getVlanInterface()
	{
		if( vlanInterface == null )
		{
			vlanInterface = VlanInterface.getVlanInterface(aSnmpProxy);
		}
		return vlanInterface;
	}
}
	
