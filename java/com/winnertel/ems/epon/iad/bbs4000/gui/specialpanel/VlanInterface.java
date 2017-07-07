package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.PortBasedVLAN;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import java.util.Vector;

public class VlanInterface
{
	private int vlanId;
	private byte[] portList;
	private int[] vidPorts;
	public static VlanInterface[] getVlanInterface( ISnmpProxy aSnmpProxy )
	{
		VlanInterface[] vlanInterface = null;
		PortBasedVLAN vlan = new PortBasedVLAN( aSnmpProxy );
		PortBasedVLAN[] vlanData = null;
		try
		{
			Vector vlanVector = vlan.retrieveAll();
			if( vlanVector == null )
			{
				vlanVector = new Vector();
			}
			vlanData = new PortBasedVLAN[vlanVector.size()];
			for( int i=0; i<vlanData.length; i++ )
			{
				vlanData[i] = (PortBasedVLAN)vlanVector.get( i );
			}
			
			vlanInterface = new VlanInterface[vlanData.length];
			for( int i=0; i<vlanInterface.length; i++ )
			{
				vlanInterface[i] =  new VlanInterface();
				
				vlanInterface[i].setVlanId( vlanData[i].getUtsLagExtDot1qVlanIndex().toString() );
				vlanInterface[i].setPortList( vlanData[i].getUtsLagExtDot1qVlanPortListPorts() );
				vlanInterface[i].setVidPorts(ConfigUtility.portMappingToPortArray( vlanData[i].getUtsLagExtDot1qVlanPortVidListPorts() ));
			}
		} catch (MibBeanException e)
		{
			e.printStackTrace();
		}
		return vlanInterface;	
	}

	public byte[] getPortList()
	{
		return portList;
	}

	public void setPortList(byte[] portList)
	{
		this.portList = portList;
	}

	public int getVlanId()
	{
		return vlanId;
	}

	public void setVlanId(String vlanId)
	{
		this.vlanId = Integer.parseInt( vlanId );
	}

	public int[] getVidPorts()
	{
		return vidPorts;
	}

	public void setVidPorts(int[] vidPorts)
	{
		this.vidPorts = vidPorts;
	}
	
	
}
