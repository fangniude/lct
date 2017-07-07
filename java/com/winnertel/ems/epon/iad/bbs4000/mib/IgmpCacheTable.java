package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The IgmpCacheTable class. Created by QuickDVM
 */
public class IgmpCacheTable extends SnmpMibBean
{
	public static final String utsIgmpCacheIfIndex = "utsIgmpCacheIfIndex";

	public static final String utsIgmpCacheGroupAddress = "utsIgmpCacheGroupAddress";
	

	public static final String utsIgmpCacheType = "utsIgmpCacheType";

	public static final String utsIgmpCacheLastReporter = "utsIgmpCacheLastReporter";

	public static final String utsIgmpCacheExpiryTime = "utsIgmpCacheExpiryTime";

	public IgmpCacheTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIgmpCacheIfIndex, new SnmpMibBeanProperty(
				utsIgmpCacheIfIndex, ".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpCacheGroupAddress, new SnmpMibBeanProperty(
				utsIgmpCacheGroupAddress,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.2", ISnmpConstant.STRING));

		initProperty(utsIgmpCacheType, new SnmpMibBeanProperty(
				utsIgmpCacheType, ".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsIgmpCacheLastReporter, new SnmpMibBeanProperty(
				utsIgmpCacheLastReporter,
				".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.4", ISnmpConstant.STRING));
		initProperty(utsIgmpCacheExpiryTime,
				new SnmpMibBeanProperty(utsIgmpCacheExpiryTime,
						".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.5",
						ISnmpConstant.TIME_TICKS));
		initProperty(ROW_STATUS,
				new SnmpMibBeanProperty(ROW_STATUS,
						".1.3.6.1.4.1.41355.1800.2.2.1.6.9.2.1.6",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsIgmpCacheIfIndex()
	{
		return (Integer)getIndex(0);
	}

	public void setUtsIgmpCacheIfIndex(Integer aUtsIgmpCacheIfIndex)
	{
		setIndex(0, aUtsIgmpCacheIfIndex);
	}

	public String getUtsIgmpCacheGroupAddress()
	{
		return (String) getIndex(1);
	}

	public void setUtsIgmpCacheGroupAddress(String aUtsIgmpCacheGroupAddress)
	{
		setIndex(1, aUtsIgmpCacheGroupAddress);
	}
	

	public Integer getUtsIgmpCacheType()
	{
		return (Integer) getProperty(utsIgmpCacheType).getValue();
	}

	public void setUtsIgmpCacheType(Integer aUtsIgmpCacheType)
	{
		getProperty(utsIgmpCacheType).setValue(aUtsIgmpCacheType);
	}

	public String getUtsIgmpCacheLastReporter()
	{
		return (String) getProperty(utsIgmpCacheLastReporter).getValue();
	}

	public void setUtsIgmpCacheLastReporter(String aUtsIgmpCacheLastReporter)
	{
		getProperty(utsIgmpCacheLastReporter).setValue(
				aUtsIgmpCacheLastReporter);
	}

	public Long getUtsIgmpCacheExpiryTime()
	{
		return (Long) getProperty(utsIgmpCacheExpiryTime).getValue();
	}

	public void setUtsIgmpCacheExpiryTime(Long aUtsIgmpCacheExpiryTime)
	{
		getProperty(utsIgmpCacheExpiryTime).setValue(aUtsIgmpCacheExpiryTime);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpCacheType));
		prepareRead(super.getProperty(utsIgmpCacheLastReporter));
		prepareRead(super.getProperty(utsIgmpCacheExpiryTime));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIgmpCacheType));
		prepareRead(super.getProperty(utsIgmpCacheLastReporter));
		prepareRead(super.getProperty(utsIgmpCacheExpiryTime));

		return loadAll(new int[]
		{ 1, 4 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIgmpCacheType));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		
		prepareSave(getProperty(utsIgmpCacheType));
		
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
