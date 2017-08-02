package com.winnertel.ems.epon.iad.bbs1000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The EponMulticastCtrlGroup class. Created by QuickDVM
 */
public class EponMulticastCtrlGroup extends SnmpMibBean
{
	public static final String utsEponMulticastCtrlIpmcEnable = "utsEponMulticastCtrlIpmcEnable";

	public static final String utsEponMulticastCtrlIgmpSnoopingStatus = "utsEponMulticastCtrlIgmpSnoopingStatus";

	public static final String utsEponMcastCtrlIgmpProxyStatus = "utsEponMcastCtrlIgmpProxyStatus";

	public static final String utsEponMulticastCtrlSuperVidList = "utsEponMulticastCtrlSuperVidList";

	public static final String utsOltCtcMulticastCtrlMode = "utsOltCtcMulticastCtrlMode";

	public EponMulticastCtrlGroup(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsEponMulticastCtrlIpmcEnable,
				new SnmpMibBeanProperty( utsEponMulticastCtrlIpmcEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.6", ISnmpConstant.INTEGER));
		initProperty(utsEponMulticastCtrlIgmpSnoopingStatus,
				new SnmpMibBeanProperty(utsEponMulticastCtrlIgmpSnoopingStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.7", ISnmpConstant.INTEGER));
		initProperty(utsEponMcastCtrlIgmpProxyStatus,
				new SnmpMibBeanProperty( utsEponMcastCtrlIgmpProxyStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.8", ISnmpConstant.INTEGER));
		initProperty(utsEponMulticastCtrlSuperVidList,
				new SnmpMibBeanProperty( utsEponMulticastCtrlSuperVidList, ".1.3.6.1.4.1.45121.1800.2.2.1.5.1.1.9", ISnmpConstant.OCTETS));
		initProperty( utsOltCtcMulticastCtrlMode,
				new SnmpMibBeanProperty(utsOltCtcMulticastCtrlMode, ".1.3.6.1.4.1.45121.1800.2.4.3.1.3.1.2", ISnmpConstant.INTEGER));
	}

	public Integer getUtsEponMulticastCtrlIpmcEnable()
	{
		return (Integer) getProperty(utsEponMulticastCtrlIpmcEnable).getValue();
	}

	public void setUtsEponMulticastCtrlIpmcEnable(
			Integer aUtsEponMulticastCtrlIpmcEnable)
	{
		getProperty(utsEponMulticastCtrlIpmcEnable).setValue(
				aUtsEponMulticastCtrlIpmcEnable);
	}

	public Integer getUtsEponMulticastCtrlIgmpSnoopingStatus()
	{
		return (Integer) getProperty(utsEponMulticastCtrlIgmpSnoopingStatus)
				.getValue();
	}

	public void setUtsEponMulticastCtrlIgmpSnoopingStatus(
			Integer aUtsEponMulticastCtrlIgmpSnoopingStatus)
	{
		getProperty(utsEponMulticastCtrlIgmpSnoopingStatus).setValue(
				aUtsEponMulticastCtrlIgmpSnoopingStatus);
	}

	public Integer getUtsOltCtcMulticastCtrlMode() {
		return (Integer) getProperty(utsOltCtcMulticastCtrlMode).getValue();
	}

	public void setUtsOltCtcMulticastCtrlMode( Integer autsOltCtcMulticastCtrlMode) {
		getProperty(utsOltCtcMulticastCtrlMode).setValue( autsOltCtcMulticastCtrlMode);
	}

	public Integer getUtsEponMcastCtrlIgmpProxyStatus()
	{
		return (Integer) getProperty(utsEponMcastCtrlIgmpProxyStatus).getValue();
	}

	public void setUtsEponMcastCtrlIgmpProxyStatus( Integer aUtsEponMcastCtrlIgmpProxyStatus)
	{
		getProperty(utsEponMcastCtrlIgmpProxyStatus).setValue( aUtsEponMcastCtrlIgmpProxyStatus);
	}

	public byte[] getUtsEponMulticastCtrlSuperVidList() {
//		return bitMapToString("" + getProperty(utsEponMulticastCtrlSuperVidList).getValue());
    return (byte[])getProperty(utsEponMulticastCtrlSuperVidList).getValue();
	}

	public void setUtsEponMulticastCtrlSuperVidList(
			byte[] aUtsEponMulticastCtrlSuperVidList)
	{
//    getProperty(utsEponMulticastCtrlSuperVidList).setValue( generateBitMap(aUtsEponMulticastCtrlSuperVidList));
    getProperty(utsEponMulticastCtrlSuperVidList).setValue( aUtsEponMulticastCtrlSuperVidList);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEponMulticastCtrlIpmcEnable));
		prepareRead(super.getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
		prepareRead(super.getProperty(utsEponMcastCtrlIgmpProxyStatus));
		prepareRead(super.getProperty(utsEponMulticastCtrlSuperVidList));
		prepareRead(super.getProperty(utsOltCtcMulticastCtrlMode));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsEponMulticastCtrlIpmcEnable));
		prepareSave(getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
		prepareSave(getProperty(utsEponMcastCtrlIgmpProxyStatus));
		prepareSave(getProperty(utsEponMulticastCtrlSuperVidList));
		prepareSave(getProperty(utsOltCtcMulticastCtrlMode));

		return save();
	}
}
