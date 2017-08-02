package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import java.util.Vector;

/**
 * The DHCPPoolTable class. Created by QuickDVM
 */
public class DHCPPoolTable extends SnmpMibBean
{
	public static final String utsDHCPPoolName = "utsDHCPPoolName";

	public static final String utsDHCPPoolDomainName = "utsDHCPPoolDomainName";

	public static final String utsDHCPPoolNetworkAddress = "utsDHCPPoolNetworkAddress";

	public static final String utsDHCPPoolNetworkMask = "utsDHCPPoolNetworkMask";

	public static final String utsDHCPPoolClassId = "utsDHCPPoolClassId";

	public static final String utsDHCPPoolLeaseTime = "utsDHCPPoolLeaseTime";

	public static final String utsDHCPPoolMeritDump = "utsDHCPPoolMeritDump";

	public static final String utsDHCPPoolRootPath = "utsDHCPPoolRootPath";

	public DHCPPoolTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
		initProperty(utsDHCPPoolDomainName, new SnmpMibBeanProperty(
				utsDHCPPoolDomainName,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.2", ISnmpConstant.STRING));
		initProperty(utsDHCPPoolNetworkAddress, new SnmpMibBeanProperty(
				utsDHCPPoolNetworkAddress,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.3", ISnmpConstant.IP_ADDRESS));
		initProperty(utsDHCPPoolNetworkMask, new SnmpMibBeanProperty(
				utsDHCPPoolNetworkMask,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.4", ISnmpConstant.IP_ADDRESS));
		initProperty(utsDHCPPoolClassId, new SnmpMibBeanProperty(
				utsDHCPPoolClassId, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.5",
				ISnmpConstant.STRING));
		initProperty(utsDHCPPoolLeaseTime, new SnmpMibBeanProperty(
				utsDHCPPoolLeaseTime, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDHCPPoolMeritDump, new SnmpMibBeanProperty(
				utsDHCPPoolMeritDump, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.7",
				ISnmpConstant.STRING));
		initProperty(utsDHCPPoolRootPath, new SnmpMibBeanProperty(
				utsDHCPPoolRootPath, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.8",
				ISnmpConstant.STRING));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.11",
				ISnmpConstant.INTEGER));

	}

	public String getUtsDHCPPoolName()
	{
        String a = (String) getIndex(0);

		return SnmpUtility.generateStringIndex(a);
	}

	public void setUtsDHCPPoolName(String aUtsDHCPPoolName)
	{
		setIndex(0, aUtsDHCPPoolName);
	}

	public String getUtsDHCPPoolDomainName()
	{
		return (String) getProperty(utsDHCPPoolDomainName).getValue();
	}

	public void setUtsDHCPPoolDomainName(String aUtsDHCPPoolDomainName)
	{
		getProperty(utsDHCPPoolDomainName).setValue(aUtsDHCPPoolDomainName);
	}

	public String getUtsDHCPPoolNetworkAddress()
	{
		return (String) getProperty(utsDHCPPoolNetworkAddress).getValue();
	}

	public void setUtsDHCPPoolNetworkAddress(String aUtsDHCPPoolNetworkAddress)
	{
		getProperty(utsDHCPPoolNetworkAddress).setValue(
				aUtsDHCPPoolNetworkAddress);
	}

	public String getUtsDHCPPoolNetworkMask()
	{
		return (String) getProperty(utsDHCPPoolNetworkMask).getValue();
	}

	public void setUtsDHCPPoolNetworkMask(String aUtsDHCPPoolNetworkMask)
	{
		getProperty(utsDHCPPoolNetworkMask).setValue(aUtsDHCPPoolNetworkMask);
	}

	public String getUtsDHCPPoolClassId()
	{
		return (String) getProperty(utsDHCPPoolClassId).getValue();
	}

	public void setUtsDHCPPoolClassId(String aUtsDHCPPoolClassId)
	{
		getProperty(utsDHCPPoolClassId).setValue(aUtsDHCPPoolClassId);
	}

	public Integer getUtsDHCPPoolLeaseTime()
	{
		return (Integer) getProperty(utsDHCPPoolLeaseTime).getValue();
	}

	public void setUtsDHCPPoolLeaseTime(Integer aUtsDHCPPoolLeaseTime)
	{
		getProperty(utsDHCPPoolLeaseTime).setValue(aUtsDHCPPoolLeaseTime);
	}

	public String getUtsDHCPPoolMeritDump()
	{
		return (String) getProperty(utsDHCPPoolMeritDump).getValue();
	}

	public void setUtsDHCPPoolMeritDump(String aUtsDHCPPoolMeritDump)
	{
		getProperty(utsDHCPPoolMeritDump).setValue(aUtsDHCPPoolMeritDump);
	}

	public String getUtsDHCPPoolRootPath()
	{
		return (String) getProperty(utsDHCPPoolRootPath).getValue();
	}

	public void setUtsDHCPPoolRootPath(String aUtsDHCPPoolRootPath)
	{
		getProperty(utsDHCPPoolRootPath).setValue(aUtsDHCPPoolRootPath);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDHCPPoolDomainName));
		prepareRead(super.getProperty(utsDHCPPoolNetworkAddress));
		prepareRead(super.getProperty(utsDHCPPoolNetworkMask));
		prepareRead(super.getProperty(utsDHCPPoolClassId));
		prepareRead(super.getProperty(utsDHCPPoolLeaseTime));
		prepareRead(super.getProperty(utsDHCPPoolMeritDump));
		prepareRead(super.getProperty(utsDHCPPoolRootPath));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDHCPPoolDomainName));
		prepareRead(super.getProperty(utsDHCPPoolNetworkAddress));
		prepareRead(super.getProperty(utsDHCPPoolNetworkMask));
		prepareRead(super.getProperty(utsDHCPPoolClassId));
		prepareRead(super.getProperty(utsDHCPPoolLeaseTime));
		prepareRead(super.getProperty(utsDHCPPoolMeritDump));
		prepareRead(super.getProperty(utsDHCPPoolRootPath));

		return loadAll(new int[]{ 0 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDHCPPoolName));
		prepareSave(getProperty(utsDHCPPoolNetworkAddress));
		prepareSave(getProperty(utsDHCPPoolNetworkMask));
		prepareSave(getProperty(utsDHCPPoolClassId));
		prepareSave(getProperty(utsDHCPPoolLeaseTime));
		prepareSave(getProperty(utsDHCPPoolMeritDump));
		prepareSave(getProperty(utsDHCPPoolRootPath));

		return save();
	}

	public boolean add() throws MibBeanException
	{
        prepareSave(getProperty(utsDHCPPoolName));
		prepareSave(getProperty(utsDHCPPoolNetworkAddress));
		prepareSave(getProperty(utsDHCPPoolNetworkMask));
		prepareSave(getProperty(utsDHCPPoolClassId));
		prepareSave(getProperty(utsDHCPPoolLeaseTime));
		prepareSave(getProperty(utsDHCPPoolMeritDump));
		prepareSave(getProperty(utsDHCPPoolRootPath));
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
