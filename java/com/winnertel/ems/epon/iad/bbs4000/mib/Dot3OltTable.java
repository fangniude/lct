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
public class Dot3OltTable extends SnmpMibBean
{
	public static final String ifIndex = "ifIndex";

	public static final String utsDot3OltModuleId = "utsDot3OltModuleId";

	public static final String utsDot3OltPortId = "utsDot3OltPortId";

	public static final String utsDot3OltOperStatus = "utsDot3OltOperStatus";

	public static final String utsDot3OltMACAddress = "utsDot3OltMACAddress";

	public static final String utsDot3OltMaxLLID = "utsDot3OltMaxLLID";

	public static final String utsDot3OltMACAddressAgingTime = "utsDot3OltMACAddressAgingTime";

	public static final String utsDot3OltARPPON2CNI = "utsDot3OltARPPON2CNI";

	public static final String utsDot3OltARPCNI2PON = "utsDot3OltARPCNI2PON";

	public static final String utsDot3OltIGMPSnooping = "utsDot3OltIGMPSnooping";

	public static final String utsDot3OltIGMPTimeout = "utsDot3OltIGMPTimeout";

	public static final String utsDot3OltVlanTagExchangeDnLinkPrefix = "utsDot3OltVlanTagExchangeDnLinkPrefix";

	public static final String utsDot3OltVlanStackNestedModeVlanType = "utsDot3OltVlanStackNestedModeVlanType";

	public static final String utsDot3OltMultiCopyBroadcastEnable = "utsDot3OltMultiCopyBroadcastEnable";

	public static final String utsDot3OltDiscardUnlearnedAddress = "utsDot3OltDiscardUnlearnedAddress";

	public static final String utsDot3OltHwVersion = "utsDot3OltHwVersion";

	public static final String utsDot3OltFwVersion = "utsDot3OltFwVersion";

	public static final String utsDot3OltTransceiverType = "utsDot3OltTransceiverType";

	public static final String utsDot3OltAdminStatus = "utsDot3OltAdminStatus";

	public static final String utsDot3OltTransceiverVendor = "utsDot3OltTransceiverVendor";

	public static final String utsDot3OltRegisteredONUCount = "utsDot3OltRegisteredONUCount";

	public static final String utsDot3OltOamLimit = "utsDot3OltOamLimit";

	public static final String utsDot3OltRunningMode = "utsDot3OltRunningMode";

	public Dot3OltTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3OltModuleId, new SnmpMibBeanProperty(
				utsDot3OltModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltPortId, new SnmpMibBeanProperty(
				utsDot3OltPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOperStatus, new SnmpMibBeanProperty(
				utsDot3OltOperStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltMACAddress, new SnmpMibBeanProperty(
				utsDot3OltMACAddress, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.4",
				ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3OltMaxLLID, new SnmpMibBeanProperty(
				utsDot3OltMaxLLID, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltMACAddressAgingTime,
				new SnmpMibBeanProperty(utsDot3OltMACAddressAgingTime,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltARPPON2CNI, new SnmpMibBeanProperty(
				utsDot3OltARPPON2CNI, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltARPCNI2PON, new SnmpMibBeanProperty(
				utsDot3OltARPCNI2PON, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltIGMPSnooping, new SnmpMibBeanProperty(
				utsDot3OltIGMPSnooping,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltIGMPTimeout, new SnmpMibBeanProperty(
				utsDot3OltIGMPTimeout,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltVlanTagExchangeDnLinkPrefix,
				new SnmpMibBeanProperty(utsDot3OltVlanTagExchangeDnLinkPrefix,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltVlanStackNestedModeVlanType,
				new SnmpMibBeanProperty(utsDot3OltVlanStackNestedModeVlanType,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.13",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltMultiCopyBroadcastEnable,
				new SnmpMibBeanProperty(utsDot3OltMultiCopyBroadcastEnable,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltDiscardUnlearnedAddress,
				new SnmpMibBeanProperty(utsDot3OltDiscardUnlearnedAddress,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltHwVersion, new SnmpMibBeanProperty(
				utsDot3OltHwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.16",
				ISnmpConstant.STRING));
		initProperty(utsDot3OltFwVersion, new SnmpMibBeanProperty(
				utsDot3OltFwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.17",
				ISnmpConstant.STRING));
		initProperty(utsDot3OltTransceiverType, new SnmpMibBeanProperty(
				utsDot3OltTransceiverType,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.18",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltAdminStatus, new SnmpMibBeanProperty(
				utsDot3OltAdminStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverVendor, new SnmpMibBeanProperty(
				utsDot3OltTransceiverVendor,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.20",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltRegisteredONUCount, new SnmpMibBeanProperty(
				utsDot3OltRegisteredONUCount,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.21",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOamLimit, new SnmpMibBeanProperty(
				utsDot3OltOamLimit, ".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.22",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltRunningMode, new SnmpMibBeanProperty(
				utsDot3OltRunningMode,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.1.1.1.23",
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

	public byte[] getUtsDot3OltMACAddress()
	{
		return (byte[]) getProperty(utsDot3OltMACAddress).getValue();
	}

	public void setUtsDot3OltMACAddress(byte[] aUtsDot3OltMACAddress)
	{
		getProperty(utsDot3OltMACAddress).setValue(aUtsDot3OltMACAddress);
	}

	public Integer getUtsDot3OltMaxLLID()
	{
		return (Integer) getProperty(utsDot3OltMaxLLID).getValue();
	}

	public void setUtsDot3OltMaxLLID(Integer aUtsDot3OltMaxLLID)
	{
		getProperty(utsDot3OltMaxLLID).setValue(aUtsDot3OltMaxLLID);
	}

	public Integer getUtsDot3OltMACAddressAgingTime()
	{
		return (Integer) getProperty(utsDot3OltMACAddressAgingTime).getValue();
	}

	public void setUtsDot3OltMACAddressAgingTime(
			Integer aUtsDot3OltMACAddressAgingTime)
	{
		getProperty(utsDot3OltMACAddressAgingTime).setValue(
				aUtsDot3OltMACAddressAgingTime);
	}

	public Integer getUtsDot3OltARPPON2CNI()
	{
		return (Integer) getProperty(utsDot3OltARPPON2CNI).getValue();
	}

	public void setUtsDot3OltARPPON2CNI(Integer aUtsDot3OltARPPON2CNI)
	{
		getProperty(utsDot3OltARPPON2CNI).setValue(aUtsDot3OltARPPON2CNI);
	}

	public Integer getUtsDot3OltARPCNI2PON()
	{
		return (Integer) getProperty(utsDot3OltARPCNI2PON).getValue();
	}

	public void setUtsDot3OltARPCNI2PON(Integer aUtsDot3OltARPCNI2PON)
	{
		getProperty(utsDot3OltARPCNI2PON).setValue(aUtsDot3OltARPCNI2PON);
	}

	public Integer getUtsDot3OltIGMPSnooping()
	{
		return (Integer) getProperty(utsDot3OltIGMPSnooping).getValue();
	}

	public void setUtsDot3OltIGMPSnooping(Integer aUtsDot3OltIGMPSnooping)
	{
		getProperty(utsDot3OltIGMPSnooping).setValue(aUtsDot3OltIGMPSnooping);
	}

	public Integer getUtsDot3OltIGMPTimeout()
	{
		return (Integer) getProperty(utsDot3OltIGMPTimeout).getValue();
	}

	public void setUtsDot3OltIGMPTimeout(Integer aUtsDot3OltIGMPTimeout)
	{
		getProperty(utsDot3OltIGMPTimeout).setValue(aUtsDot3OltIGMPTimeout);
	}

	public Integer getUtsDot3OltVlanTagExchangeDnLinkPrefix()
	{
		return (Integer) getProperty(utsDot3OltVlanTagExchangeDnLinkPrefix)
				.getValue();
	}

	public void setUtsDot3OltVlanTagExchangeDnLinkPrefix(
			Integer aUtsDot3OltVlanTagExchangeDnLinkPrefix)
	{
		getProperty(utsDot3OltVlanTagExchangeDnLinkPrefix).setValue(
				aUtsDot3OltVlanTagExchangeDnLinkPrefix);
	}

	public Integer getUtsDot3OltVlanStackNestedModeVlanType()
	{
		return (Integer) getProperty(utsDot3OltVlanStackNestedModeVlanType)
				.getValue();
	}

	public void setUtsDot3OltVlanStackNestedModeVlanType(
			Integer aUtsDot3OltVlanStackNestedModeVlanType)
	{
		getProperty(utsDot3OltVlanStackNestedModeVlanType).setValue(
				aUtsDot3OltVlanStackNestedModeVlanType);
	}

	public Integer getUtsDot3OltMultiCopyBroadcastEnable()
	{
		return (Integer) getProperty(utsDot3OltMultiCopyBroadcastEnable)
				.getValue();
	}

	public void setUtsDot3OltMultiCopyBroadcastEnable(
			Integer aUtsDot3OltMultiCopyBroadcastEnable)
	{
		getProperty(utsDot3OltMultiCopyBroadcastEnable).setValue(
				aUtsDot3OltMultiCopyBroadcastEnable);
	}

	public Integer getUtsDot3OltDiscardUnlearnedAddress()
	{
		return (Integer) getProperty(utsDot3OltDiscardUnlearnedAddress)
				.getValue();
	}

	public void setUtsDot3OltDiscardUnlearnedAddress(
			Integer aUtsDot3OltDiscardUnlearnedAddress)
	{
		getProperty(utsDot3OltDiscardUnlearnedAddress).setValue(
				aUtsDot3OltDiscardUnlearnedAddress);
	}

	public String getUtsDot3OltHwVersion()
	{
		return (String) getProperty(utsDot3OltHwVersion).getValue();
	}

	public void setUtsDot3OltHwVersion(String aUtsDot3OltHwVersion)
	{
		getProperty(utsDot3OltHwVersion).setValue(aUtsDot3OltHwVersion);
	}

	public String getUtsDot3OltFwVersion()
	{
		return (String) getProperty(utsDot3OltFwVersion).getValue();
	}

	public void setUtsDot3OltFwVersion(String aUtsDot3OltFwVersion)
	{
		getProperty(utsDot3OltFwVersion).setValue(aUtsDot3OltFwVersion);
	}

	public Integer getUtsDot3OltTransceiverType()
	{
		return (Integer) getProperty(utsDot3OltTransceiverType).getValue();
	}

	public void setUtsDot3OltTransceiverType(Integer aUtsDot3OltTransceiverType)
	{
		getProperty(utsDot3OltTransceiverType).setValue(
				aUtsDot3OltTransceiverType);
	}

	public Integer getUtsDot3OltAdminStatus()
	{
		return (Integer) getProperty(utsDot3OltAdminStatus).getValue();
	}

	public void setUtsDot3OltAdminStatus(Integer aUtsDot3OltAdminStatus)
	{
		getProperty(utsDot3OltAdminStatus).setValue(aUtsDot3OltAdminStatus);
	}

	public Integer getUtsDot3OltTransceiverVendor()
	{
		return (Integer) getProperty(utsDot3OltTransceiverVendor).getValue();
	}

	public void setUtsDot3OltTransceiverVendor(
			Integer aUtsDot3OltTransceiverVendor)
	{
		getProperty(utsDot3OltTransceiverVendor).setValue(
				aUtsDot3OltTransceiverVendor);
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

	public Integer getUtsDot3OltOamLimit()
	{
		return (Integer) getProperty(utsDot3OltOamLimit).getValue();
	}

	public void setUtsDot3OltOamLimit(Integer aUtsDot3OltOamLimit)
	{
		getProperty(utsDot3OltOamLimit).setValue(aUtsDot3OltOamLimit);
	}

	public Integer getUtsDot3OltRunningMode()
	{
		return (Integer) getProperty(utsDot3OltRunningMode).getValue();
	}

	public void setUtsDot3OltRunningMode(Integer aUtsDot3OltRunningMode)
	{
		getProperty(utsDot3OltRunningMode).setValue(aUtsDot3OltRunningMode);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OltModuleId));
		prepareRead(super.getProperty(utsDot3OltPortId));
		prepareRead(super.getProperty(utsDot3OltOperStatus));
		prepareRead(super.getProperty(utsDot3OltMACAddress));
		prepareRead(super.getProperty(utsDot3OltMaxLLID));
		prepareRead(super.getProperty(utsDot3OltMACAddressAgingTime));
		prepareRead(super.getProperty(utsDot3OltARPPON2CNI));
		prepareRead(super.getProperty(utsDot3OltARPCNI2PON));
		prepareRead(super.getProperty(utsDot3OltIGMPSnooping));
		prepareRead(super.getProperty(utsDot3OltIGMPTimeout));
		prepareRead(super.getProperty(utsDot3OltVlanTagExchangeDnLinkPrefix));
		prepareRead(super.getProperty(utsDot3OltVlanStackNestedModeVlanType));
		prepareRead(super.getProperty(utsDot3OltMultiCopyBroadcastEnable));
		prepareRead(super.getProperty(utsDot3OltDiscardUnlearnedAddress));
		prepareRead(super.getProperty(utsDot3OltHwVersion));
		prepareRead(super.getProperty(utsDot3OltFwVersion));
		prepareRead(super.getProperty(utsDot3OltTransceiverType));
		prepareRead(super.getProperty(utsDot3OltAdminStatus));
		prepareRead(super.getProperty(utsDot3OltTransceiverVendor));
		prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));
		prepareRead(super.getProperty(utsDot3OltOamLimit));
		prepareRead(super.getProperty(utsDot3OltRunningMode));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OltModuleId));
		prepareRead(super.getProperty(utsDot3OltPortId));
		prepareRead(super.getProperty(utsDot3OltOperStatus));
		prepareRead(super.getProperty(utsDot3OltMACAddress));
		prepareRead(super.getProperty(utsDot3OltMaxLLID));
		prepareRead(super.getProperty(utsDot3OltMACAddressAgingTime));
		prepareRead(super.getProperty(utsDot3OltARPPON2CNI));
		prepareRead(super.getProperty(utsDot3OltARPCNI2PON));
		prepareRead(super.getProperty(utsDot3OltIGMPSnooping));
		prepareRead(super.getProperty(utsDot3OltIGMPTimeout));
		prepareRead(super.getProperty(utsDot3OltVlanTagExchangeDnLinkPrefix));
		prepareRead(super.getProperty(utsDot3OltVlanStackNestedModeVlanType));
		prepareRead(super.getProperty(utsDot3OltMultiCopyBroadcastEnable));
		prepareRead(super.getProperty(utsDot3OltDiscardUnlearnedAddress));
		prepareRead(super.getProperty(utsDot3OltHwVersion));
		prepareRead(super.getProperty(utsDot3OltFwVersion));
		prepareRead(super.getProperty(utsDot3OltTransceiverType));
		prepareRead(super.getProperty(utsDot3OltAdminStatus));
		prepareRead(super.getProperty(utsDot3OltTransceiverVendor));
		prepareRead(super.getProperty(utsDot3OltRegisteredONUCount));
		prepareRead(super.getProperty(utsDot3OltOamLimit));
		prepareRead(super.getProperty(utsDot3OltRunningMode));

    setRowsToFetch(4);
		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot3OltAdminStatus));
		prepareSave(getProperty(utsDot3OltOamLimit));
		prepareSave(getProperty(utsDot3OltRunningMode));

		return save();
	}

}
