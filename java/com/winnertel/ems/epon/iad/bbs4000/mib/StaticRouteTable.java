package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The StaticRouteTable class. Created by QuickDVM
 */
public class StaticRouteTable extends SnmpMibBean
{
	public static final String utsStaticRouteIpAddress = "utsStaticRouteIpAddress";

	public static final String utsStaticRouteSubnetMask = "utsStaticRouteSubnetMask";

	public static final String utsStaticRouteNextHop = "utsStaticRouteNextHop";

	public static final String utsStaticRouteIfIndex = "utsStaticRouteIfIndex";

	public static final String utsStaticRouteMetric = "utsStaticRouteMetric";

	public StaticRouteTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsStaticRouteIpAddress, new SnmpMibBeanProperty(
				utsStaticRouteIpAddress,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.1", ISnmpConstant.IP_ADDRESS));
		initProperty(utsStaticRouteSubnetMask, new SnmpMibBeanProperty(
				utsStaticRouteSubnetMask,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.2", ISnmpConstant.IP_ADDRESS));
		initProperty(utsStaticRouteNextHop, new SnmpMibBeanProperty(
				utsStaticRouteNextHop,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.3", ISnmpConstant.IP_ADDRESS));
		initProperty(utsStaticRouteIfIndex,
				new SnmpMibBeanProperty(utsStaticRouteIfIndex,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsStaticRouteMetric, new SnmpMibBeanProperty(
				utsStaticRouteMetric, ".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.5",
				ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS,
				new SnmpMibBeanProperty(ROW_STATUS,
						".1.3.6.1.4.1.45121.1800.2.2.1.6.2.1.1.6",
						ISnmpConstant.INTEGER));

	}

	public String getUtsStaticRouteIpAddress()
	{
		return (String) getIndex(0);
	}

	public void setUtsStaticRouteIpAddress(String aUtsStaticRouteIpAddress)
	{
		setIndex(0, aUtsStaticRouteIpAddress);
	}

	public String getUtsStaticRouteSubnetMask()
	{
		return (String) getIndex(1);
	}

	public void setUtsStaticRouteSubnetMask(String aUtsStaticRouteSubnetMask)
	{
		setIndex(1, aUtsStaticRouteSubnetMask);
	}

	public String getUtsStaticRouteNextHop()
	{
		return (String) getIndex(2);
	}

	public void setUtsStaticRouteNextHop(String aUtsStaticRouteNextHop)
	{
		setIndex(2, aUtsStaticRouteNextHop);
	}

	public Integer getUtsStaticRouteIfIndex()
	{
		return (Integer) getProperty(utsStaticRouteIfIndex).getValue();
	}

	public void setUtsStaticRouteIfIndex(Integer aUtsStaticRouteIfIndex)
	{
		getProperty(utsStaticRouteIfIndex).setValue(aUtsStaticRouteIfIndex);
	}

	public Integer getUtsStaticRouteMetric()
	{
		return (Integer) getProperty(utsStaticRouteMetric).getValue();
	}

	public void setUtsStaticRouteMetric(Integer aUtsStaticRouteMetric)
	{
		getProperty(utsStaticRouteMetric).setValue(aUtsStaticRouteMetric);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsStaticRouteIfIndex));
		prepareRead(super.getProperty(utsStaticRouteMetric));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsStaticRouteIfIndex));
		prepareRead(super.getProperty(utsStaticRouteMetric));

		return loadAll(new int[]
		{ 4, 4, 4 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsStaticRouteIpAddress));
		prepareSave(getProperty(utsStaticRouteSubnetMask));
		prepareSave(getProperty(utsStaticRouteNextHop));
		prepareSave(getProperty(utsStaticRouteMetric));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		prepareSave(getProperty(utsStaticRouteMetric));
		
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
