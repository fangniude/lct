package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

public class DHCPGeneral extends SnmpMibBean
{
//	public static final String utsDHCPServiceState = "utsDHCPServiceState";

	public static final String utsDHCPServiceMode = "utsDHCPServiceMode";

	public DHCPGeneral(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
//		initProperty(utsDHCPServiceState, new SnmpMibBeanProperty(
//				utsDHCPServiceState, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.1.1",
//				ISnmpConstant.INTEGER));
		initProperty(utsDHCPServiceMode, new SnmpMibBeanProperty(
				utsDHCPServiceMode, ".1.3.6.1.4.1.41355.1800.2.2.1.6.3.1.6",
				ISnmpConstant.INTEGER));

	}

//	public Integer getUtsDHCPServiceState()
//	{
//		return (Integer) getProperty(utsDHCPServiceState).getValue();
//	}
//
//	public void setUtsDHCPServiceState(Integer aUtsDHCPServiceState)
//	{
//		getProperty(utsDHCPServiceState).setValue(aUtsDHCPServiceState);
//	}

	public Integer getUtsDHCPServiceMode()
	{
		return (Integer) getProperty(utsDHCPServiceMode).getValue();
	}

	public void setUtsDHCPServiceMode(Integer aUtsDHCPServiceMode)
	{
		getProperty(utsDHCPServiceMode).setValue(aUtsDHCPServiceMode);
	}

	public boolean retrieve() throws MibBeanException
	{
//		prepareRead(super.getProperty(utsDHCPServiceState));
		prepareRead(super.getProperty(utsDHCPServiceMode));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
//		prepareSave(getProperty(utsDHCPServiceState));
		prepareSave(getProperty(utsDHCPServiceMode));

		return save();
	}

}
