package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The SecondIPAddressTable class. Created by QuickDVM
 */
public class SecondIPAddressTable extends SnmpMibBean
{
	public static final String utsIfSecondIpIfIndex = "utsIfSecondIpIfIndex";

	public static final String utsIfSecondIpAddress = "utsIfSecondIpAddress";

	public static final String utsIfSecondIpNetmask = "utsIfSecondIpNetmask";

	public SecondIPAddressTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIfSecondIpIfIndex, new SnmpMibBeanProperty(
				utsIfSecondIpIfIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.7.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIfSecondIpAddress, new SnmpMibBeanProperty(
				utsIfSecondIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.7.1.7",
				ISnmpConstant.STRING));
		initProperty(utsIfSecondIpNetmask, new SnmpMibBeanProperty(
				utsIfSecondIpNetmask, ".1.3.6.1.4.1.45121.1800.2.2.1.7.1.8",
				ISnmpConstant.STRING));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.2.1.7.1.9", ISnmpConstant.INTEGER));

	}

	public Integer getUtsIfSecondIpIfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsIfSecondIpIfIndex(Integer aUtsIfSecondIpIfIndex)
	{
		setIndex(0, aUtsIfSecondIpIfIndex);
	}

	public String getUtsIfSecondIpAddress()
	{
		return (String) getIndex(1);
	}

	public void setUtsIfSecondIpAddress(String aUtsIfSecondIpAddress)
	{
		setIndex(1, aUtsIfSecondIpAddress);
	}

	public String getUtsIfSecondIpNetmask()
	{
		return (String) getIndex(2);
	}

	public void setUtsIfSecondIpNetmask(String aUtsIfSecondIpNetmask)
	{
		setIndex(2, aUtsIfSecondIpNetmask);
	}

	public boolean retrieve() throws MibBeanException
	{

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(getProperty(utsIfSecondIpAddress));
		return loadAll(new int[]
		{ 1, 4, 4 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIfSecondIpAddress));
		prepareSave(getProperty(utsIfSecondIpNetmask));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		super.setRowStatus(new Integer(4));
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
