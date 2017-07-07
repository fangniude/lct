package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The HostRouteTable class. Created by QuickDVM
 */
public class HostRouteTable extends SnmpMibBean
{
	public static final String utsHostRouteIpAddress = "utsHostRouteIpAddress";

	public static final String utsHostRouteType = "utsHostRouteType";

	public static final String utsHostRouteModuleId = "utsHostRouteModuleId";

	public static final String utsHostRoutePortId = "utsHostRoutePortId";

	public static final String utsHostRouteLinkAggGroupId = "utsHostRouteLinkAggGroupId";

	public static final String utsHostRouteVlanId = "utsHostRouteVlanId";

	public static final String utsHostRouteArpType = "utsHostRouteArpType";

	public static final String utsHostRouteVlanSubVlanId = "utsHostRouteVlanSubVlanId";

	public static final String utsHostRouteMacAddress = "utsHostRouteMacAddress";

	public HostRouteTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsHostRouteIpAddress, new SnmpMibBeanProperty(
				utsHostRouteIpAddress,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.1", ISnmpConstant.IP_ADDRESS));
		initProperty(utsHostRouteType, new SnmpMibBeanProperty(
				utsHostRouteType, ".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsHostRouteModuleId, new SnmpMibBeanProperty(
				utsHostRouteModuleId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsHostRoutePortId, new SnmpMibBeanProperty(
				utsHostRoutePortId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsHostRouteLinkAggGroupId,
				new SnmpMibBeanProperty(utsHostRouteLinkAggGroupId,
						".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsHostRouteVlanId, new SnmpMibBeanProperty(
				utsHostRouteVlanId, ".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsHostRouteArpType, new SnmpMibBeanProperty(
				utsHostRouteArpType, ".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsHostRouteVlanSubVlanId,
				new SnmpMibBeanProperty(utsHostRouteVlanSubVlanId,
						".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsHostRouteMacAddress, new SnmpMibBeanProperty(
				utsHostRouteMacAddress,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.9", ISnmpConstant.MAC_ADDRESS));
		
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.5.1.1.10",
				ISnmpConstant.INTEGER));

	}

	public String getUtsHostRouteIpAddress()
	{
		return (String) getIndex(0);
	}

	public void setUtsHostRouteIpAddress(String aUtsHostRouteIpAddress)
	{
		setIndex(0, aUtsHostRouteIpAddress);
	}

	public Integer getUtsHostRouteType()
	{
		return (Integer) getProperty(utsHostRouteType).getValue();
	}

	public void setUtsHostRouteType(Integer aUtsHostRouteType)
	{
		getProperty(utsHostRouteType).setValue(aUtsHostRouteType);
	}

	public Integer getUtsHostRouteModuleId()
	{
		return (Integer) getProperty(utsHostRouteModuleId).getValue();
	}

	public void setUtsHostRouteModuleId(Integer aUtsHostRouteModuleId)
	{
		getProperty(utsHostRouteModuleId).setValue(aUtsHostRouteModuleId);
	}

	public Integer getUtsHostRoutePortId()
	{
		return (Integer) getProperty(utsHostRoutePortId).getValue();
	}

	public void setUtsHostRoutePortId(Integer aUtsHostRoutePortId)
	{
		getProperty(utsHostRoutePortId).setValue(aUtsHostRoutePortId);
	}

	public Integer getUtsHostRouteLinkAggGroupId()
	{
		return (Integer) getProperty(utsHostRouteLinkAggGroupId).getValue();
	}

	public void setUtsHostRouteLinkAggGroupId(
			Integer aUtsHostRouteLinkAggGroupId)
	{
		getProperty(utsHostRouteLinkAggGroupId).setValue(
				aUtsHostRouteLinkAggGroupId);
	}

	public Integer getUtsHostRouteVlanId()
	{
		return (Integer) getProperty(utsHostRouteVlanId).getValue();
	}

	public void setUtsHostRouteVlanId(Integer aUtsHostRouteVlanId)
	{
		getProperty(utsHostRouteVlanId).setValue(aUtsHostRouteVlanId);
	}

	public Integer getUtsHostRouteArpType()
	{
		return (Integer) getProperty(utsHostRouteArpType).getValue();
	}

	public void setUtsHostRouteArpType(Integer aUtsHostRouteArpType)
	{
		getProperty(utsHostRouteArpType).setValue(aUtsHostRouteArpType);
	}

	public Integer getUtsHostRouteVlanSubVlanId()
	{
		return (Integer) getProperty(utsHostRouteVlanSubVlanId).getValue();
	}

	public void setUtsHostRouteVlanSubVlanId(Integer aUtsHostRouteVlanSubVlanId)
	{
		getProperty(utsHostRouteVlanSubVlanId).setValue(
				aUtsHostRouteVlanSubVlanId);
	}

	public byte[] getUtsHostRouteMacAddress()
	{
		return (byte[]) getProperty(utsHostRouteMacAddress).getValue();
	}

	public void setUtsHostRouteMacAddress(byte[] aUtsHostRouteMacAddress)
	{
		getProperty(utsHostRouteMacAddress).setValue(aUtsHostRouteMacAddress);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsHostRouteType));
		prepareRead(super.getProperty(utsHostRouteModuleId));
		prepareRead(super.getProperty(utsHostRoutePortId));
		prepareRead(super.getProperty(utsHostRouteLinkAggGroupId));
		prepareRead(super.getProperty(utsHostRouteVlanId));
		prepareRead(super.getProperty(utsHostRouteArpType));
		prepareRead(super.getProperty(utsHostRouteVlanSubVlanId));
		prepareRead(super.getProperty(utsHostRouteMacAddress));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsHostRouteType));
		prepareRead(super.getProperty(utsHostRouteModuleId));
		prepareRead(super.getProperty(utsHostRoutePortId));
		prepareRead(super.getProperty(utsHostRouteLinkAggGroupId));
		prepareRead(super.getProperty(utsHostRouteVlanId));
		prepareRead(super.getProperty(utsHostRouteArpType));
		prepareRead(super.getProperty(utsHostRouteVlanSubVlanId));
		prepareRead(super.getProperty(utsHostRouteMacAddress));

		return loadAll(new int[]
		{ 4 });
	}

	public boolean modify() throws MibBeanException
	{
		myPrepareSave(getProperty(utsHostRouteIpAddress));
		myPrepareSave(getProperty(utsHostRouteType));
		myPrepareSave(getProperty(utsHostRouteModuleId));
		myPrepareSave(getProperty(utsHostRoutePortId));
		myPrepareSave(getProperty(utsHostRouteLinkAggGroupId));
		myPrepareSave(getProperty(utsHostRouteVlanId));
		myPrepareSave(getProperty(utsHostRouteVlanSubVlanId));

		return save();
	}
	
	private void myPrepareSave ( SnmpMibBeanProperty property )
	{
		if( property.getValue() != null )
		{
			prepareSave( property );
		}
		
	}

	public boolean add() throws MibBeanException
	{
		
		myPrepareSave(getProperty(utsHostRouteIpAddress));
		myPrepareSave(getProperty(utsHostRouteType));
		myPrepareSave(getProperty(utsHostRouteModuleId));
		myPrepareSave(getProperty(utsHostRoutePortId));
		myPrepareSave(getProperty(utsHostRouteLinkAggGroupId));
		myPrepareSave(getProperty(utsHostRouteVlanId));
		myPrepareSave(getProperty(utsHostRouteVlanSubVlanId));

		setRowStatus(new Integer(4));
		myPrepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}
