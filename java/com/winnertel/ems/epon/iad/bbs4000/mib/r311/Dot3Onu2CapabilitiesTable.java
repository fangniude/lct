package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2CapabilitiesTable class. Created by QuickDVM
 */
public class Dot3Onu2CapabilitiesTable extends SnmpMibBean {
	public static final String utsDot3Onu2CapabilitiesModuleId = "utsDot3Onu2CapabilitiesModuleId";
	public static final String utsDot3Onu2CapabilitiesDeviceId = "utsDot3Onu2CapabilitiesDeviceId";
	public static final String utsDot3Onu2CapabilitiesPortId = "utsDot3Onu2CapabilitiesPortId";
	public static final String utsDot3Onu2CapabilitiesLogicalPortId = "utsDot3Onu2CapabilitiesLogicalPortId";
	public static final String utsDot3Onu2CapabilitiesVersion = "utsDot3Onu2CapabilitiesVersion";
	public static final String utsDot3Onu2CapabilitiesGEPortNumber = "utsDot3Onu2CapabilitiesGEPortNumber";
	public static final String utsDot3OnuOnu2CapabilitiesGEPortList = "utsDot3OnuOnu2CapabilitiesGEPortList";
	public static final String utsDot3Onu2CapabilitiesFEPortNumber = "utsDot3Onu2CapabilitiesFEPortNumber";
	public static final String utsDot3Onu2CapabilitiesFEPortList = "utsDot3Onu2CapabilitiesFEPortList";
	public static final String utsDot3Onu2CapabilitiesPOTSPortNumber = "utsDot3Onu2CapabilitiesPOTSPortNumber";
	public static final String utsDot3Onu2CapabilitiesE1PortNumber = "utsDot3Onu2CapabilitiesE1PortNumber";
	public static final String utsDot3Onu2CapabilitiesUpsQueueNum = "utsDot3Onu2CapabilitiesUpsQueueNum";
	public static final String utsDot3Onu2CapabilitiesMaxUpsQueueNum = "utsDot3Onu2CapabilitiesMaxUpsQueueNum";
	public static final String utsDot3Onu2CapabilitiesDownsQueueNum = "utsDot3Onu2CapabilitiesDownsQueueNum";
	public static final String utsDot3Onu2CapabilitiesMaxDownsQueueNum = "utsDot3Onu2CapabilitiesMaxDownsQueueNum";
	public static final String utsDot3Onu2CapabilitiesBatteryInstalled = "utsDot3Onu2CapabilitiesBatteryInstalled";
	public static final String utsDot3Onu2CapbilitiesOnuType = "utsDot3Onu2CapbilitiesOnuType";
	public static final String utsDot3Onu2CapbilitiesMultiLlid = "utsDot3Onu2CapbilitiesMultiLlid";
	public static final String utsDot3Onu2CapabilitiesProtectionType = "utsDot3Onu2CapabilitiesProtectionType";
	public static final String utsDot3Onu2CapabilitiesPonIfNum = "utsDot3Onu2CapabilitiesPonIfNum";
	public static final String utsDot3Onu2CapabilitiesSlotNum = "utsDot3Onu2CapabilitiesSlotNum";
	public static final String utsDot3Onu2CapabilitesIfAttribute = "utsDot3Onu2CapabilitesIfAttribute";
	public static final String utsDot3Onu2CapabilitiesIpv6 = "utsDot3Onu2CapabilitiesIpv6";
	public static final String utsDot3Onu2CapabilitiesPowerSupplyControl = "utsDot3Onu2CapabilitiesPowerSupplyControl";
	public static final String utsDot3Onu2CapabilitiesServiceSLA = "utsDot3Onu2CapabilitiesServiceSLA";
	public static final String utsDot3Onu2CapabilitesIfAttributePerSlot = "utsDot3Onu2CapabilitesIfAttributePerSlot";

	public Dot3Onu2CapabilitiesTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2CapabilitiesModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesLogicalPortId,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesVersion, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesVersion,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesGEPortNumber,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesGEPortNumber,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOnu2CapabilitiesGEPortList,
				new SnmpMibBeanProperty(utsDot3OnuOnu2CapabilitiesGEPortList,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.7",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3Onu2CapabilitiesFEPortNumber,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesFEPortNumber,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesFEPortList,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesFEPortList,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.9",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3Onu2CapabilitiesPOTSPortNumber,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesPOTSPortNumber,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesE1PortNumber,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesE1PortNumber,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.11",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesUpsQueueNum,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesUpsQueueNum,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.13",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesDownsQueueNum,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesDownsQueueNum,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesMaxDownsQueueNum,
				new SnmpMibBeanProperty(
						utsDot3Onu2CapabilitiesMaxDownsQueueNum,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesBatteryInstalled,
				new SnmpMibBeanProperty(
						utsDot3Onu2CapabilitiesBatteryInstalled,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapbilitiesOnuType, new SnmpMibBeanProperty(
				utsDot3Onu2CapbilitiesOnuType,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.17",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapbilitiesMultiLlid, new SnmpMibBeanProperty(
				utsDot3Onu2CapbilitiesMultiLlid,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.18",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesProtectionType,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesProtectionType,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.19",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesPonIfNum, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesPonIfNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.20",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesSlotNum, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesSlotNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.21",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitesIfAttribute,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitesIfAttribute,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.22",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3Onu2CapabilitiesIpv6, new SnmpMibBeanProperty(
				utsDot3Onu2CapabilitiesIpv6,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.23",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesPowerSupplyControl,
				new SnmpMibBeanProperty(
						utsDot3Onu2CapabilitiesPowerSupplyControl,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.24",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitiesServiceSLA,
				new SnmpMibBeanProperty(utsDot3Onu2CapabilitiesServiceSLA,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.25",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CapabilitesIfAttributePerSlot,
				new SnmpMibBeanProperty(
						utsDot3Onu2CapabilitesIfAttributePerSlot,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.46.1.26",
						ISnmpConstant.OCTETS));

	}

	public Integer getUtsDot3Onu2CapabilitiesModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2CapabilitiesModuleId(
			Integer aUtsDot3Onu2CapabilitiesModuleId) {
		setIndex(0, aUtsDot3Onu2CapabilitiesModuleId);
	}

	public Integer getUtsDot3Onu2CapabilitiesDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2CapabilitiesDeviceId(
			Integer aUtsDot3Onu2CapabilitiesDeviceId) {
		setIndex(1, aUtsDot3Onu2CapabilitiesDeviceId);
	}

	public Integer getUtsDot3Onu2CapabilitiesPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2CapabilitiesPortId(
			Integer aUtsDot3Onu2CapabilitiesPortId) {
		setIndex(2, aUtsDot3Onu2CapabilitiesPortId);
	}

	public Integer getUtsDot3Onu2CapabilitiesLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2CapabilitiesLogicalPortId(
			Integer aUtsDot3Onu2CapabilitiesLogicalPortId) {
		setIndex(3, aUtsDot3Onu2CapabilitiesLogicalPortId);
	}

	public Integer getUtsDot3Onu2CapabilitiesVersion() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesVersion).getValue();
	}

	public void setUtsDot3Onu2CapabilitiesVersion(
			Integer aUtsDot3Onu2CapabilitiesVersion) {
		getProperty(utsDot3Onu2CapabilitiesVersion).setValue(
				aUtsDot3Onu2CapabilitiesVersion);
	}

	public Integer getUtsDot3Onu2CapabilitiesGEPortNumber() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesGEPortNumber)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesGEPortNumber(
			Integer aUtsDot3Onu2CapabilitiesGEPortNumber) {
		getProperty(utsDot3Onu2CapabilitiesGEPortNumber).setValue(
				aUtsDot3Onu2CapabilitiesGEPortNumber);
	}

	public byte[] getUtsDot3OnuOnu2CapabilitiesGEPortList() {
		return (byte[]) getProperty(utsDot3OnuOnu2CapabilitiesGEPortList)
				.getValue();
	}

	public void setUtsDot3OnuOnu2CapabilitiesGEPortList(
			byte[] aUtsDot3OnuOnu2CapabilitiesGEPortList) {
		getProperty(utsDot3OnuOnu2CapabilitiesGEPortList).setValue(
				aUtsDot3OnuOnu2CapabilitiesGEPortList);
	}

	public Integer getUtsDot3Onu2CapabilitiesFEPortNumber() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesFEPortNumber)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesFEPortNumber(
			Integer aUtsDot3Onu2CapabilitiesFEPortNumber) {
		getProperty(utsDot3Onu2CapabilitiesFEPortNumber).setValue(
				aUtsDot3Onu2CapabilitiesFEPortNumber);
	}

	public byte[] getUtsDot3Onu2CapabilitiesFEPortList() {
		return (byte[]) getProperty(utsDot3Onu2CapabilitiesFEPortList)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesFEPortList(
			byte[] aUtsDot3Onu2CapabilitiesFEPortList) {
		getProperty(utsDot3Onu2CapabilitiesFEPortList).setValue(
				aUtsDot3Onu2CapabilitiesFEPortList);
	}

	public Integer getUtsDot3Onu2CapabilitiesPOTSPortNumber() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesPOTSPortNumber)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesPOTSPortNumber(
			Integer aUtsDot3Onu2CapabilitiesPOTSPortNumber) {
		getProperty(utsDot3Onu2CapabilitiesPOTSPortNumber).setValue(
				aUtsDot3Onu2CapabilitiesPOTSPortNumber);
	}

	public Integer getUtsDot3Onu2CapabilitiesE1PortNumber() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesE1PortNumber)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesE1PortNumber(
			Integer aUtsDot3Onu2CapabilitiesE1PortNumber) {
		getProperty(utsDot3Onu2CapabilitiesE1PortNumber).setValue(
				aUtsDot3Onu2CapabilitiesE1PortNumber);
	}

	public Integer getUtsDot3Onu2CapabilitiesUpsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesUpsQueueNum)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesUpsQueueNum(
			Integer aUtsDot3Onu2CapabilitiesUpsQueueNum) {
		getProperty(utsDot3Onu2CapabilitiesUpsQueueNum).setValue(
				aUtsDot3Onu2CapabilitiesUpsQueueNum);
	}

	public Integer getUtsDot3Onu2CapabilitiesMaxUpsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesMaxUpsQueueNum(
			Integer aUtsDot3Onu2CapabilitiesMaxUpsQueueNum) {
		getProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum).setValue(
				aUtsDot3Onu2CapabilitiesMaxUpsQueueNum);
	}

	public Integer getUtsDot3Onu2CapabilitiesDownsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesDownsQueueNum)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesDownsQueueNum(
			Integer aUtsDot3Onu2CapabilitiesDownsQueueNum) {
		getProperty(utsDot3Onu2CapabilitiesDownsQueueNum).setValue(
				aUtsDot3Onu2CapabilitiesDownsQueueNum);
	}

	public Integer getUtsDot3Onu2CapabilitiesMaxDownsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesMaxDownsQueueNum)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesMaxDownsQueueNum(
			Integer aUtsDot3Onu2CapabilitiesMaxDownsQueueNum) {
		getProperty(utsDot3Onu2CapabilitiesMaxDownsQueueNum).setValue(
				aUtsDot3Onu2CapabilitiesMaxDownsQueueNum);
	}

	public Integer getUtsDot3Onu2CapabilitiesBatteryInstalled() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesBatteryInstalled)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesBatteryInstalled(
			Integer aUtsDot3Onu2CapabilitiesBatteryInstalled) {
		getProperty(utsDot3Onu2CapabilitiesBatteryInstalled).setValue(
				aUtsDot3Onu2CapabilitiesBatteryInstalled);
	}

	public Integer getUtsDot3Onu2CapbilitiesOnuType() {
		return (Integer) getProperty(utsDot3Onu2CapbilitiesOnuType).getValue();
	}

	public void setUtsDot3Onu2CapbilitiesOnuType(
			Integer aUtsDot3Onu2CapbilitiesOnuType) {
		getProperty(utsDot3Onu2CapbilitiesOnuType).setValue(
				aUtsDot3Onu2CapbilitiesOnuType);
	}

	public Integer getUtsDot3Onu2CapbilitiesMultiLlid() {
		return (Integer) getProperty(utsDot3Onu2CapbilitiesMultiLlid)
				.getValue();
	}

	public void setUtsDot3Onu2CapbilitiesMultiLlid(
			Integer aUtsDot3Onu2CapbilitiesMultiLlid) {
		getProperty(utsDot3Onu2CapbilitiesMultiLlid).setValue(
				aUtsDot3Onu2CapbilitiesMultiLlid);
	}

	public Integer getUtsDot3Onu2CapabilitiesProtectionType() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesProtectionType)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesProtectionType(
			Integer aUtsDot3Onu2CapabilitiesProtectionType) {
		getProperty(utsDot3Onu2CapabilitiesProtectionType).setValue(
				aUtsDot3Onu2CapabilitiesProtectionType);
	}

	public Integer getUtsDot3Onu2CapabilitiesPonIfNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesPonIfNum)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesPonIfNum(
			Integer aUtsDot3Onu2CapabilitiesPonIfNum) {
		getProperty(utsDot3Onu2CapabilitiesPonIfNum).setValue(
				aUtsDot3Onu2CapabilitiesPonIfNum);
	}

	public Integer getUtsDot3Onu2CapabilitiesSlotNum() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesSlotNum).getValue();
	}

	public void setUtsDot3Onu2CapabilitiesSlotNum(
			Integer aUtsDot3Onu2CapabilitiesSlotNum) {
		getProperty(utsDot3Onu2CapabilitiesSlotNum).setValue(
				aUtsDot3Onu2CapabilitiesSlotNum);
	}

	public byte[] getUtsDot3Onu2CapabilitesIfAttribute() {
		return (byte[]) getProperty(utsDot3Onu2CapabilitesIfAttribute)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitesIfAttribute(
			byte[] aUtsDot3Onu2CapabilitesIfAttribute) {
		getProperty(utsDot3Onu2CapabilitesIfAttribute).setValue(
				aUtsDot3Onu2CapabilitesIfAttribute);
	}

	public Integer getUtsDot3Onu2CapabilitiesIpv6() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesIpv6).getValue();
	}

	public void setUtsDot3Onu2CapabilitiesIpv6(
			Integer aUtsDot3Onu2CapabilitiesIpv6) {
		getProperty(utsDot3Onu2CapabilitiesIpv6).setValue(
				aUtsDot3Onu2CapabilitiesIpv6);
	}

	public Integer getUtsDot3Onu2CapabilitiesPowerSupplyControl() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesPowerSupplyControl)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesPowerSupplyControl(
			Integer aUtsDot3Onu2CapabilitiesPowerSupplyControl) {
		getProperty(utsDot3Onu2CapabilitiesPowerSupplyControl).setValue(
				aUtsDot3Onu2CapabilitiesPowerSupplyControl);
	}

	public Integer getUtsDot3Onu2CapabilitiesServiceSLA() {
		return (Integer) getProperty(utsDot3Onu2CapabilitiesServiceSLA)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitiesServiceSLA(
			Integer aUtsDot3Onu2CapabilitiesServiceSLA) {
		getProperty(utsDot3Onu2CapabilitiesServiceSLA).setValue(
				aUtsDot3Onu2CapabilitiesServiceSLA);
	}

	public byte[] getUtsDot3Onu2CapabilitesIfAttributePerSlot() {
		return (byte[]) getProperty(utsDot3Onu2CapabilitesIfAttributePerSlot)
				.getValue();
	}

	public void setUtsDot3Onu2CapabilitesIfAttributePerSlot(
			byte[] aUtsDot3Onu2CapabilitesIfAttributePerSlot) {
		getProperty(utsDot3Onu2CapabilitesIfAttributePerSlot).setValue(
				aUtsDot3Onu2CapabilitesIfAttributePerSlot);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesVersion));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesGEPortNumber));
		prepareRead(super.getProperty(utsDot3OnuOnu2CapabilitiesGEPortList));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesFEPortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesFEPortList));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesPOTSPortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesE1PortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesUpsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesDownsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesMaxDownsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesBatteryInstalled));
		prepareRead(super.getProperty(utsDot3Onu2CapbilitiesOnuType));
		prepareRead(super.getProperty(utsDot3Onu2CapbilitiesMultiLlid));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesProtectionType));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesPonIfNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesSlotNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitesIfAttribute));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesIpv6));
		prepareRead(super
				.getProperty(utsDot3Onu2CapabilitiesPowerSupplyControl));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesServiceSLA));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitesIfAttributePerSlot));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesVersion));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesGEPortNumber));
		prepareRead(super.getProperty(utsDot3OnuOnu2CapabilitiesGEPortList));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesFEPortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesFEPortList));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesPOTSPortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesE1PortNumber));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesUpsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesMaxUpsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesDownsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesMaxDownsQueueNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesBatteryInstalled));
		prepareRead(super.getProperty(utsDot3Onu2CapbilitiesOnuType));
		prepareRead(super.getProperty(utsDot3Onu2CapbilitiesMultiLlid));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesProtectionType));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesPonIfNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesSlotNum));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitesIfAttribute));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesIpv6));
		prepareRead(super
				.getProperty(utsDot3Onu2CapabilitiesPowerSupplyControl));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitiesServiceSLA));
		prepareRead(super.getProperty(utsDot3Onu2CapabilitesIfAttributePerSlot));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

}
