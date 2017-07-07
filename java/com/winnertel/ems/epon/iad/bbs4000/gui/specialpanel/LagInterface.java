package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import java.util.Vector;

public class LagInterface
{
	private String groupId;
	private byte[] portList;
	private int[] ports;
	
	public static LagInterface[] getLagInterface( ISnmpProxy aSnmpProxy )
	{
		LagInterface[] lagInterface = new LagInterface[0];
		LinkAggregation linkAgg = new LinkAggregation( aSnmpProxy );
		LinkAggregation[] linkAggData = null;
		try
		{
			Vector linkAggVector = linkAgg.retrieveAll();
			if( linkAggVector == null )
			{
				linkAggVector = new Vector();
			}
			linkAggData = new LinkAggregation[linkAggVector.size()];
			for( int i=0; i<linkAggData.length; i++ )
			{
				linkAggData[i] = (LinkAggregation)linkAggVector.get( i );
			}
			
			for( int i=0; i<lagInterface.length; i++ )
			{
				lagInterface[i] =  new LagInterface();
				
				lagInterface[i].setGroupId( linkAggData[i].getUtsLagExtDot3adAggGroupId().toString() );
				lagInterface[i].setPortList( linkAggData[i].getUtsLagExtDot3adAggPortListPorts() );
			}
		} catch (MibBeanException e)
		{
			e.printStackTrace();
		}
		return lagInterface;
	}
	
	public String getGroupId()
	{
		return groupId;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}
	public byte[] getPortList()
	{
		return portList;
	}
	public void setPortList(byte[] portList)
	{
		this.portList = portList;
		this.ports = ConfigUtility.portMappingToPortArray(portList);
	}

	public int[] getPorts()
	{
		return ports;
	}

	public void setPorts(int[] ports)
	{
		this.ports = ports;
	}
	
	
}