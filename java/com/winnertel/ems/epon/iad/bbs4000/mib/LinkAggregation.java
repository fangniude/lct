package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The LinkAggregation class. Created by QuickDVM
 */
public class LinkAggregation extends SnmpMibBean
{
	public static final String utsLagExtDot3adAggGroupId = "utsLagExtDot3adAggGroupId";

	public static final String utsLagExtDot3adAggName = "utsLagExtDot3adAggName";

	public static final String utsLagExtDot3adAggPerLinkSpeed = "utsLagExtDot3adAggPerLinkSpeed";

	public static final String utsLagExtDot3adAggPortListPorts = "utsLagExtDot3adAggPortListPorts";

	public static final String utsLagExtDot3adAggRtag = "utsLagExtDot3adAggRtag";

	public LinkAggregation(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsLagExtDot3adAggGroupId, new SnmpMibBeanProperty(
				utsLagExtDot3adAggGroupId,
				".1.3.6.1.4.1.41355.1800.2.2.1.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsLagExtDot3adAggName, new SnmpMibBeanProperty(
				utsLagExtDot3adAggName, ".1.3.6.1.4.1.41355.1800.2.2.1.2.1.2",
				ISnmpConstant.STRING));
		initProperty(utsLagExtDot3adAggPerLinkSpeed, new SnmpMibBeanProperty(
				utsLagExtDot3adAggPerLinkSpeed,
				".1.3.6.1.4.1.41355.1800.2.2.1.2.1.3", ISnmpConstant.INTEGER));
		initProperty(utsLagExtDot3adAggPortListPorts, new SnmpMibBeanProperty(
				utsLagExtDot3adAggPortListPorts,
				".1.3.6.1.4.1.41355.1800.2.2.1.2.1.4", ISnmpConstant.OCTETS));
		initProperty(utsLagExtDot3adAggRtag, new SnmpMibBeanProperty(
				utsLagExtDot3adAggRtag, ".1.3.6.1.4.1.41355.1800.2.2.1.2.1.6",
				ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.2.1.2.1.9", ISnmpConstant.INTEGER));

	}

	public Integer getUtsLagExtDot3adAggGroupId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsLagExtDot3adAggGroupId(Integer aUtsLagExtDot3adAggGroupId)
	{
		setIndex(0, aUtsLagExtDot3adAggGroupId);
	}

	public String getUtsLagExtDot3adAggName()
	{
		return (String) getProperty(utsLagExtDot3adAggName).getValue();
	}

	public void setUtsLagExtDot3adAggName(String aUtsLagExtDot3adAggName)
	{
		getProperty(utsLagExtDot3adAggName).setValue(aUtsLagExtDot3adAggName);
	}

	public Integer getUtsLagExtDot3adAggPerLinkSpeed()
	{
		return (Integer) getProperty(utsLagExtDot3adAggPerLinkSpeed).getValue();
	}

	public void setUtsLagExtDot3adAggPerLinkSpeed(
			Integer aUtsLagExtDot3adAggPerLinkSpeed)
	{
		getProperty(utsLagExtDot3adAggPerLinkSpeed).setValue(
				aUtsLagExtDot3adAggPerLinkSpeed);
	}

	public byte[] getUtsLagExtDot3adAggPortListPorts()
	{
		return (byte[]) getProperty(utsLagExtDot3adAggPortListPorts).getValue();
	}

	public void setUtsLagExtDot3adAggPortListPorts(
			byte[] aUtsLagExtDot3adAggPortListPorts)
	{
		getProperty(utsLagExtDot3adAggPortListPorts).setValue(
				aUtsLagExtDot3adAggPortListPorts);
	}

	public Integer getUtsLagExtDot3adAggRtag()
	{
		return (Integer) getProperty(utsLagExtDot3adAggRtag).getValue();
	}

	public void setUtsLagExtDot3adAggRtag(Integer aUtsLagExtDot3adAggRtag)
	{
		getProperty(utsLagExtDot3adAggRtag).setValue(aUtsLagExtDot3adAggRtag);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsLagExtDot3adAggName));
		prepareRead(super.getProperty(utsLagExtDot3adAggPerLinkSpeed));
		prepareRead(super.getProperty(utsLagExtDot3adAggPortListPorts));
		prepareRead(super.getProperty(utsLagExtDot3adAggRtag));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsLagExtDot3adAggName));
		prepareRead(super.getProperty(utsLagExtDot3adAggPerLinkSpeed));
		prepareRead(super.getProperty(utsLagExtDot3adAggPortListPorts));
		prepareRead(super.getProperty(utsLagExtDot3adAggRtag));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsLagExtDot3adAggName));
		prepareSave(getProperty(utsLagExtDot3adAggPortListPorts));
		prepareSave(getProperty(utsLagExtDot3adAggRtag));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsLagExtDot3adAggGroupId));
    prepareSave(getProperty(utsLagExtDot3adAggName));
    prepareSave(getProperty(utsLagExtDot3adAggPortListPorts));
    prepareSave(getProperty(utsLagExtDot3adAggRtag));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}
