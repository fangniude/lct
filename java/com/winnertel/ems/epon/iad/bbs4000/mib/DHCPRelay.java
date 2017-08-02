package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The DHCPRelay class. Created by QuickDVM
 */
public class DHCPRelay extends SnmpMibBean
{
	public static final String utsDHCPRelayOption82 = "utsDHCPRelayOption82";

	public static final String utsDHCPRelayInforChk = "utsDHCPRelayInforChk";

	public static final String utsDHCPRelayPolicy = "utsDHCPRelayPolicy";

	public static final String utsDHCPRelayMaxhop = "utsDHCPRelayMaxhop";

	public DHCPRelay(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsDHCPRelayOption82, new SnmpMibBeanProperty(
				utsDHCPRelayOption82, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDHCPRelayInforChk, new SnmpMibBeanProperty(
				utsDHCPRelayInforChk, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDHCPRelayPolicy, new SnmpMibBeanProperty(
				utsDHCPRelayPolicy, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDHCPRelayMaxhop, new SnmpMibBeanProperty(
				utsDHCPRelayMaxhop, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.1.5",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDHCPRelayOption82()
	{
		return (Integer) getProperty(utsDHCPRelayOption82).getValue();
	}

	public void setUtsDHCPRelayOption82(Integer aUtsDHCPRelayOption82)
	{
		getProperty(utsDHCPRelayOption82).setValue(aUtsDHCPRelayOption82);
	}

	public Integer getUtsDHCPRelayInforChk()
	{
		return (Integer) getProperty(utsDHCPRelayInforChk).getValue();
	}

	public void setUtsDHCPRelayInforChk(Integer aUtsDHCPRelayInforChk)
	{
		getProperty(utsDHCPRelayInforChk).setValue(aUtsDHCPRelayInforChk);
	}

	public Integer getUtsDHCPRelayPolicy()
	{
		return (Integer) getProperty(utsDHCPRelayPolicy).getValue();
	}

	public void setUtsDHCPRelayPolicy(Integer aUtsDHCPRelayPolicy)
	{
		getProperty(utsDHCPRelayPolicy).setValue(aUtsDHCPRelayPolicy);
	}

	public Integer getUtsDHCPRelayMaxhop()
	{
		return (Integer) getProperty(utsDHCPRelayMaxhop).getValue();
	}

	public void setUtsDHCPRelayMaxhop(Integer aUtsDHCPRelayMaxhop)
	{
		getProperty(utsDHCPRelayMaxhop).setValue(aUtsDHCPRelayMaxhop);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDHCPRelayOption82));
		prepareRead(super.getProperty(utsDHCPRelayInforChk));
		prepareRead(super.getProperty(utsDHCPRelayPolicy));
		prepareRead(super.getProperty(utsDHCPRelayMaxhop));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDHCPRelayOption82));
		prepareSave(getProperty(utsDHCPRelayInforChk));
		prepareSave(getProperty(utsDHCPRelayPolicy));
		prepareSave(getProperty(utsDHCPRelayMaxhop));

		return save();
	}

}
