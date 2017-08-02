package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3OltTable class. Created by QuickDVM
 */
public class Dot3OltRegisteredOnuTable extends SnmpMibBean
{
	public static final String ifIndex = "ifIndex";

	public static final String utsDot3OltModuleId = "utsDot3OltModuleId";

	public static final String utsDot3OltPortId = "utsDot3OltPortId";

	public static final String utsDot3OltOperStatus = "utsDot3OltOperStatus";

	public static final String utsDot3OltAdminStatus = "utsDot3OltAdminStatus";

	public static final String utsDot3OltRegisteredONUCount = "utsDot3OltRegisteredONUCount";


	public Dot3OltRegisteredOnuTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(
				utsDot3OltModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.1.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortId, new SnmpMibBeanProperty(
				utsDot3OltPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.1.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOperStatus, new SnmpMibBeanProperty(
				utsDot3OltOperStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.1.1.1.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltAdminStatus, new SnmpMibBeanProperty(
				utsDot3OltAdminStatus,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.1.1.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltRegisteredONUCount, new SnmpMibBeanProperty(
				utsDot3OltRegisteredONUCount,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.1.1.1.21",
				ISnmpConstant.INTEGER));
	}

	public Integer getIfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsDot3OltModuleId()
	{
		return (Integer) getProperty(utsDot3OltModuleId).getValue();
	}

	public void setUtsDot3OltModuleId(Integer aUtsDot3OltModuleId)
	{
		getProperty(utsDot3OltModuleId).setValue(aUtsDot3OltModuleId);
	}

	public Integer getUtsDot3OltPortId()
	{
		return (Integer) getProperty(utsDot3OltPortId).getValue();
	}

	public void setUtsDot3OltPortId(Integer aUtsDot3OltPortId)
	{
		getProperty(utsDot3OltPortId).setValue(aUtsDot3OltPortId);
	}

	public Integer getUtsDot3OltOperStatus()
	{
		return (Integer) getProperty(utsDot3OltOperStatus).getValue();
	}

	public void setUtsDot3OltOperStatus(Integer aUtsDot3OltOperStatus)
	{
		getProperty(utsDot3OltOperStatus).setValue(aUtsDot3OltOperStatus);
	}

	public Integer getUtsDot3OltAdminStatus()
	{
		return (Integer) getProperty(utsDot3OltAdminStatus).getValue();
	}

	public void setUtsDot3OltAdminStatus(Integer aUtsDot3OltAdminStatus)
	{
		getProperty(utsDot3OltAdminStatus).setValue(aUtsDot3OltAdminStatus);
	}

	public Integer getUtsDot3OltRegisteredONUCount()
	{
		return (Integer) getProperty(utsDot3OltRegisteredONUCount).getValue();
	}

	public void setUtsDot3OltRegisteredONUCount(
			Integer aUtsDot3OltRegisteredONUCount)
	{
		getProperty(utsDot3OltRegisteredONUCount).setValue(
				aUtsDot3OltRegisteredONUCount);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OltModuleId));
		prepareRead(super.getProperty(utsDot3OltPortId));
		prepareRead(super.getProperty(utsDot3OltOperStatus));
		prepareRead(super.getProperty(utsDot3OltAdminStatus));
		prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OltModuleId));
		prepareRead(super.getProperty(utsDot3OltPortId));
		prepareRead(super.getProperty(utsDot3OltOperStatus));
		prepareRead(super.getProperty(utsDot3OltAdminStatus));
		prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot3OltAdminStatus));
		return save();
	}
}
