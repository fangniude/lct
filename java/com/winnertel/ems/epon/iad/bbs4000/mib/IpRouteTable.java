package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The IpRouteTable class. Created by QuickDVM
 */
public class IpRouteTable extends SnmpMibBean
{
	public static final String utsIpRouteEntryIndex = "utsIpRouteEntryIndex";

	public static final String utsIpRouteEntryOwner = "utsIpRouteEntryOwner";

	public static final String utsIpRouteEntryIpAddr = "utsIpRouteEntryIpAddr";

	public static final String utsIpRouteEntryIpMask = "utsIpRouteEntryIpMask";

	public static final String utsIpRouteEntryType = "utsIpRouteEntryType";

	public static final String utsIpRouteEntryCost = "utsIpRouteEntryCost";

	public static final String utsIpRouteEntryNextHop1 = "utsIpRouteEntryNextHop1";

	public static final String utsIpRouteEntryNextHop2 = "utsIpRouteEntryNextHop2";

	public static final String utsIpRouteEntryNextHop3 = "utsIpRouteEntryNextHop3";

	public static final String utsIpRouteEntryNextHop4 = "utsIpRouteEntryNextHop4";

	public static final String utsIpRouteEntryVlanId1 = "utsIpRouteEntryVlanId1";

	public static final String utsIpRouteEntryVlanId2 = "utsIpRouteEntryVlanId2";

	public static final String utsIpRouteEntryVlanId3 = "utsIpRouteEntryVlanId3";

	public static final String utsIpRouteEntryVlanId4 = "utsIpRouteEntryVlanId4";

	public IpRouteTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIpRouteEntryIndex, new SnmpMibBeanProperty(
				utsIpRouteEntryIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryOwner, new SnmpMibBeanProperty(
				utsIpRouteEntryOwner, ".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryIpAddr, new SnmpMibBeanProperty(
				utsIpRouteEntryIpAddr,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.3", ISnmpConstant.IP_ADDRESS));
		initProperty(utsIpRouteEntryIpMask, new SnmpMibBeanProperty(
				utsIpRouteEntryIpMask,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.4", ISnmpConstant.IP_ADDRESS));
		initProperty(utsIpRouteEntryType, new SnmpMibBeanProperty(
				utsIpRouteEntryType, ".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryCost, new SnmpMibBeanProperty(
				utsIpRouteEntryCost, ".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryNextHop1, new SnmpMibBeanProperty(
				utsIpRouteEntryNextHop1,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.7", ISnmpConstant.STRING));
		initProperty(utsIpRouteEntryNextHop2, new SnmpMibBeanProperty(
				utsIpRouteEntryNextHop2,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.8", ISnmpConstant.STRING));
		initProperty(utsIpRouteEntryNextHop3, new SnmpMibBeanProperty(
				utsIpRouteEntryNextHop3,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.9", ISnmpConstant.STRING));
		initProperty(utsIpRouteEntryNextHop4,
				new SnmpMibBeanProperty(utsIpRouteEntryNextHop4,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.10",
						ISnmpConstant.STRING));
		initProperty(utsIpRouteEntryVlanId1, new SnmpMibBeanProperty(
				utsIpRouteEntryVlanId1,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.23",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryVlanId2, new SnmpMibBeanProperty(
				utsIpRouteEntryVlanId2,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.24",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryVlanId3, new SnmpMibBeanProperty(
				utsIpRouteEntryVlanId3,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.25",
				ISnmpConstant.INTEGER));
		initProperty(utsIpRouteEntryVlanId4, new SnmpMibBeanProperty(
				utsIpRouteEntryVlanId4,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.6.1.1.26",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsIpRouteEntryIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsIpRouteEntryIndex(Integer aUtsIpRouteEntryIndex)
	{
		setIndex(0, aUtsIpRouteEntryIndex);
	}

	public Integer getUtsIpRouteEntryOwner()
	{
		return (Integer) getProperty(utsIpRouteEntryOwner).getValue();
	}

	public void setUtsIpRouteEntryOwner(Integer aUtsIpRouteEntryOwner)
	{
		getProperty(utsIpRouteEntryOwner).setValue(aUtsIpRouteEntryOwner);
	}

	public String getUtsIpRouteEntryIpAddr()
	{
		return (String) getProperty(utsIpRouteEntryIpAddr).getValue();
	}

	public void setUtsIpRouteEntryIpAddr(String aUtsIpRouteEntryIpAddr)
	{
		getProperty(utsIpRouteEntryIpAddr).setValue(aUtsIpRouteEntryIpAddr);
	}

	public String getUtsIpRouteEntryIpMask()
	{
		return (String) getProperty(utsIpRouteEntryIpMask).getValue();
	}

	public void setUtsIpRouteEntryIpMask(String aUtsIpRouteEntryIpMask)
	{
		getProperty(utsIpRouteEntryIpMask).setValue(aUtsIpRouteEntryIpMask);
	}

	public Integer getUtsIpRouteEntryType()
	{
		return (Integer) getProperty(utsIpRouteEntryType).getValue();
	}

	public void setUtsIpRouteEntryType(Integer aUtsIpRouteEntryType)
	{
		getProperty(utsIpRouteEntryType).setValue(aUtsIpRouteEntryType);
	}

	public Integer getUtsIpRouteEntryCost()
	{
		return (Integer) getProperty(utsIpRouteEntryCost).getValue();
	}

	public void setUtsIpRouteEntryCost(Integer aUtsIpRouteEntryCost)
	{
		getProperty(utsIpRouteEntryCost).setValue(aUtsIpRouteEntryCost);
	}

	public String getUtsIpRouteEntryNextHop1()
	{
		return (String) getProperty(utsIpRouteEntryNextHop1).getValue();
	}

	public void setUtsIpRouteEntryNextHop1(String aUtsIpRouteEntryNextHop1)
	{
		getProperty(utsIpRouteEntryNextHop1).setValue(aUtsIpRouteEntryNextHop1);
	}

	public String getUtsIpRouteEntryNextHop2()
	{
		return (String) getProperty(utsIpRouteEntryNextHop2).getValue();
	}

	public void setUtsIpRouteEntryNextHop2(String aUtsIpRouteEntryNextHop2)
	{
		getProperty(utsIpRouteEntryNextHop2).setValue(aUtsIpRouteEntryNextHop2);
	}

	public String getUtsIpRouteEntryNextHop3()
	{
		return (String) getProperty(utsIpRouteEntryNextHop3).getValue();
	}

	public void setUtsIpRouteEntryNextHop3(String aUtsIpRouteEntryNextHop3)
	{
		getProperty(utsIpRouteEntryNextHop3).setValue(aUtsIpRouteEntryNextHop3);
	}

	public String getUtsIpRouteEntryNextHop4()
	{
		return (String) getProperty(utsIpRouteEntryNextHop4).getValue();
	}

	public void setUtsIpRouteEntryNextHop4(String aUtsIpRouteEntryNextHop4)
	{
		getProperty(utsIpRouteEntryNextHop4).setValue(aUtsIpRouteEntryNextHop4);
	}

	public Integer getUtsIpRouteEntryVlanId1()
	{
		return (Integer) getProperty(utsIpRouteEntryVlanId1).getValue();
	}

	public void setUtsIpRouteEntryVlanId1(Integer aUtsIpRouteEntryVlanId1)
	{
		getProperty(utsIpRouteEntryVlanId1).setValue(aUtsIpRouteEntryVlanId1);
	}

	public Integer getUtsIpRouteEntryVlanId2()
	{
		return (Integer) getProperty(utsIpRouteEntryVlanId2).getValue();
	}

	public void setUtsIpRouteEntryVlanId2(Integer aUtsIpRouteEntryVlanId2)
	{
		getProperty(utsIpRouteEntryVlanId2).setValue(aUtsIpRouteEntryVlanId2);
	}

	public Integer getUtsIpRouteEntryVlanId3()
	{
		return (Integer) getProperty(utsIpRouteEntryVlanId3).getValue();
	}

	public void setUtsIpRouteEntryVlanId3(Integer aUtsIpRouteEntryVlanId3)
	{
		getProperty(utsIpRouteEntryVlanId3).setValue(aUtsIpRouteEntryVlanId3);
	}

	public Integer getUtsIpRouteEntryVlanId4()
	{
		return (Integer) getProperty(utsIpRouteEntryVlanId4).getValue();
	}

	public void setUtsIpRouteEntryVlanId4(Integer aUtsIpRouteEntryVlanId4)
	{
		getProperty(utsIpRouteEntryVlanId4).setValue(aUtsIpRouteEntryVlanId4);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIpRouteEntryOwner));
		prepareRead(super.getProperty(utsIpRouteEntryIpAddr));
		prepareRead(super.getProperty(utsIpRouteEntryIpMask));
		prepareRead(super.getProperty(utsIpRouteEntryType));
		prepareRead(super.getProperty(utsIpRouteEntryCost));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop1));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop2));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop3));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop4));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId1));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId2));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId3));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId4));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIpRouteEntryOwner));
		prepareRead(super.getProperty(utsIpRouteEntryIpAddr));
		prepareRead(super.getProperty(utsIpRouteEntryIpMask));
		prepareRead(super.getProperty(utsIpRouteEntryType));
		prepareRead(super.getProperty(utsIpRouteEntryCost));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop1));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop2));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop3));
		prepareRead(super.getProperty(utsIpRouteEntryNextHop4));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId1));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId2));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId3));
		prepareRead(super.getProperty(utsIpRouteEntryVlanId4));

		return loadAll(new int[]
		{ 1 });
	}

}
