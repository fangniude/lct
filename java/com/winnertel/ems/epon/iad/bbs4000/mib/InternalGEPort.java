package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The InternalGEPort class. Created by QuickDVM
 */
public class InternalGEPort extends SnmpMibBean
{
	public static final String utsIntfRateControlUplinkSpeed = "utsIntfRateControlUplinkSpeed";

	public static final String utsIntfRateControlVlanIngressFilter = "utsIntfRateControlVlanIngressFilter";

	public static final String utsIntfRateControlUplinkTranceiverType = "utsIntfRateControlUplinkTranceiverType";

	public static final String utsIntfRateControlAutoNegotiation = "utsIntfRateControlAutoNegotiation";

	public InternalGEPort(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsIntfRateControlUplinkSpeed, new SnmpMibBeanProperty(
				utsIntfRateControlUplinkSpeed,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlVlanIngressFilter,
				new SnmpMibBeanProperty(utsIntfRateControlVlanIngressFilter,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlUplinkTranceiverType,
				new SnmpMibBeanProperty(utsIntfRateControlUplinkTranceiverType,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsIntfRateControlAutoNegotiation,
				new SnmpMibBeanProperty(utsIntfRateControlAutoNegotiation,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.3.1.1.16",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsIntfRateControlUplinkSpeed()
	{
		return (Integer) getProperty(utsIntfRateControlUplinkSpeed).getValue();
	}

	public void setUtsIntfRateControlUplinkSpeed(
			Integer aUtsIntfRateControlUplinkSpeed)
	{
		getProperty(utsIntfRateControlUplinkSpeed).setValue(
				aUtsIntfRateControlUplinkSpeed);
	}

	public Integer getUtsIntfRateControlVlanIngressFilter()
	{
		return (Integer) getProperty(utsIntfRateControlVlanIngressFilter)
				.getValue();
	}

	public void setUtsIntfRateControlVlanIngressFilter(
			Integer aUtsIntfRateControlVlanIngressFilter)
	{
		getProperty(utsIntfRateControlVlanIngressFilter).setValue(
				aUtsIntfRateControlVlanIngressFilter);
	}

	public Integer getUtsIntfRateControlUplinkTranceiverType()
	{
		return (Integer) getProperty(utsIntfRateControlUplinkTranceiverType)
				.getValue();
	}

	public void setUtsIntfRateControlUplinkTranceiverType(
			Integer aUtsIntfRateControlUplinkTranceiverType)
	{
		getProperty(utsIntfRateControlUplinkTranceiverType).setValue(
				aUtsIntfRateControlUplinkTranceiverType);
	}

	public Integer getUtsIntfRateControlAutoNegotiation()
	{
		return (Integer) getProperty(utsIntfRateControlAutoNegotiation)
				.getValue();
	}

	public void setUtsIntfRateControlAutoNegotiation(
			Integer aUtsIntfRateControlAutoNegotiation)
	{
		getProperty(utsIntfRateControlAutoNegotiation).setValue(
				aUtsIntfRateControlAutoNegotiation);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsIntfRateControlUplinkSpeed));
		prepareRead(super.getProperty(utsIntfRateControlVlanIngressFilter));
		prepareRead(super.getProperty(utsIntfRateControlUplinkTranceiverType));
		prepareRead(super.getProperty(utsIntfRateControlAutoNegotiation));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsIntfRateControlUplinkSpeed));
		prepareSave(getProperty(utsIntfRateControlVlanIngressFilter));
		prepareSave(getProperty(utsIntfRateControlAutoNegotiation));

		return save();
	}

}
