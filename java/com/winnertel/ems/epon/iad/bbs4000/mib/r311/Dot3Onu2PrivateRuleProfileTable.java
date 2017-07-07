package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2PrivateRuleProfileTable class. Created by QuickDVM
 */
public class Dot3Onu2PrivateRuleProfileTable extends SnmpMibBean {
	public static final String utsDot3Onu2PrivateRuleIndex = "utsDot3Onu2PrivateRuleIndex";
	public static final String utsDot3Onu2PrivateRuleName = "utsDot3Onu2PrivateRuleName";
	public static final String utsDot3Onu2PrivateRuleBitmap = "utsDot3Onu2PrivateRuleBitmap";
	public static final String utsDot3Onu2PrivateRuleDMacMatchType = "utsDot3Onu2PrivateRuleDMacMatchType";
	public static final String utsDot3Onu2PrivateRuleDMac = "utsDot3Onu2PrivateRuleDMac";
	public static final String utsDot3Onu2PrivateRuleSMacMatchType = "utsDot3Onu2PrivateRuleSMacMatchType";
	public static final String utsDot3Onu2PrivateRuleSMac = "utsDot3Onu2PrivateRuleSMac";
	public static final String utsDot3Onu2PrivateRulePriMatchType = "utsDot3Onu2PrivateRulePriMatchType";
	public static final String utsDot3Onu2PrivateRulePri = "utsDot3Onu2PrivateRulePri";
	public static final String utsDot3Onu2PrivateRuleVlanMatchType = "utsDot3Onu2PrivateRuleVlanMatchType";
	public static final String utsDot3Onu2PrivateRuleVlanId = "utsDot3Onu2PrivateRuleVlanId";
	public static final String utsDot3Onu2PrivateRuleEtherTypeMatchType = "utsDot3Onu2PrivateRuleEtherTypeMatchType";
	public static final String utsDot3Onu2PrivateRuleEtherType = "utsDot3Onu2PrivateRuleEtherType";
	public static final String utsDot3Onu2PrivateRuleDIPMatchType = "utsDot3Onu2PrivateRuleDIPMatchType";
	public static final String utsDot3Onu2PrivateRuleDIP = "utsDot3Onu2PrivateRuleDIP";
	public static final String utsDot3Onu2PrivateRuleSIPMatchType = "utsDot3Onu2PrivateRuleSIPMatchType";
	public static final String utsDot3Onu2PrivateRuleSIP = "utsDot3Onu2PrivateRuleSIP";
	public static final String utsDot3Onu2PrivateRuleIpTypeMatchType = "utsDot3Onu2PrivateRuleIpTypeMatchType";
	public static final String utsDot3Onu2PrivateRuleIpType = "utsDot3Onu2PrivateRuleIpType";
	public static final String utsDot3Onu2PrivateRuleDscpMatchType = "utsDot3Onu2PrivateRuleDscpMatchType";
	public static final String utsDot3Onu2PrivateRuleDscp = "utsDot3Onu2PrivateRuleDscp";
	public static final String utsDot3Onu2PrivateRulePrecedenceMatchType = "utsDot3Onu2PrivateRulePrecedenceMatchType";
	public static final String utsDot3Onu2PrivateRulePrecedence = "utsDot3Onu2PrivateRulePrecedence";
	public static final String utsDot3Onu2PrivateRuleSourePortMatchType = "utsDot3Onu2PrivateRuleSourePortMatchType";
	public static final String utsDot3Onu2PrivateRuleSourcePort = "utsDot3Onu2PrivateRuleSourcePort";
	public static final String utsDot3Onu2PrivateRuleDstPortMatchType = "utsDot3Onu2PrivateRuleDstPortMatchType";
	public static final String utsDot3Onu2PrivateRuleDstPort = "utsDot3Onu2PrivateRuleDstPort";

	public Dot3Onu2PrivateRuleProfileTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2PrivateRuleIndex, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleIndex,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleName, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleName,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.2",
				ISnmpConstant.STRING));
		initProperty(utsDot3Onu2PrivateRuleBitmap, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleBitmap,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.3",
				ISnmpConstant.OCTETS));
		initProperty(utsDot3Onu2PrivateRuleDMacMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleDMacMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDMac, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleDMac,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.5",
				ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2PrivateRuleSMacMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleSMacMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleSMac, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleSMac,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.7",
				ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3Onu2PrivateRulePriMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRulePriMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRulePri, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRulePri,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleVlanMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleVlanMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleVlanId, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleVlanId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateRuleEtherTypeMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleEtherType, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleEtherType,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDIPMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleDIPMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDIP, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleDIP,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.15",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2PrivateRuleSIPMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleSIPMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleSIP, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleSIP,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.17",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsDot3Onu2PrivateRuleIpTypeMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleIpTypeMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.18",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleIpType, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleIpType,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDscpMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleDscpMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.20",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDscp, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleDscp,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.21",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRulePrecedenceMatchType,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateRulePrecedenceMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.22",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRulePrecedence, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRulePrecedence,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.23",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleSourePortMatchType,
				new SnmpMibBeanProperty(
						utsDot3Onu2PrivateRuleSourePortMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.24",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleSourcePort, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleSourcePort,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.25",
				ISnmpConstant.GAUGE));
		initProperty(utsDot3Onu2PrivateRuleDstPortMatchType,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateRuleDstPortMatchType,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.26",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleDstPort, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleDstPort,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.27",
				ISnmpConstant.GAUGE));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.106.1.99",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2PrivateRuleIndex() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2PrivateRuleIndex(
			Integer aUtsDot3Onu2PrivateRuleIndex) {
		setIndex(0, aUtsDot3Onu2PrivateRuleIndex);
	}

	public String getUtsDot3Onu2PrivateRuleName() {
		return (String) getProperty(utsDot3Onu2PrivateRuleName).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleName(String aUtsDot3Onu2PrivateRuleName) {
		getProperty(utsDot3Onu2PrivateRuleName).setValue(
				aUtsDot3Onu2PrivateRuleName);
	}

	public byte[] getUtsDot3Onu2PrivateRuleBitmap() {
		return (byte[]) getProperty(utsDot3Onu2PrivateRuleBitmap).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleBitmap(
			byte[] aUtsDot3Onu2PrivateRuleBitmap) {
		getProperty(utsDot3Onu2PrivateRuleBitmap).setValue(
				aUtsDot3Onu2PrivateRuleBitmap);
	}

	public Integer getUtsDot3Onu2PrivateRuleDMacMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleDMacMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDMacMatchType(
			Integer aUtsDot3Onu2PrivateRuleDMacMatchType) {
		getProperty(utsDot3Onu2PrivateRuleDMacMatchType).setValue(
				aUtsDot3Onu2PrivateRuleDMacMatchType);
	}

	public byte[] getUtsDot3Onu2PrivateRuleDMac() {
		return (byte[]) getProperty(utsDot3Onu2PrivateRuleDMac).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDMac(byte[] aUtsDot3Onu2PrivateRuleDMac) {
		getProperty(utsDot3Onu2PrivateRuleDMac).setValue(
				aUtsDot3Onu2PrivateRuleDMac);
	}

	public Integer getUtsDot3Onu2PrivateRuleSMacMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleSMacMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSMacMatchType(
			Integer aUtsDot3Onu2PrivateRuleSMacMatchType) {
		getProperty(utsDot3Onu2PrivateRuleSMacMatchType).setValue(
				aUtsDot3Onu2PrivateRuleSMacMatchType);
	}

	public byte[] getUtsDot3Onu2PrivateRuleSMac() {
		return (byte[]) getProperty(utsDot3Onu2PrivateRuleSMac).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSMac(byte[] aUtsDot3Onu2PrivateRuleSMac) {
		getProperty(utsDot3Onu2PrivateRuleSMac).setValue(
				aUtsDot3Onu2PrivateRuleSMac);
	}

	public Integer getUtsDot3Onu2PrivateRulePriMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRulePriMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRulePriMatchType(
			Integer aUtsDot3Onu2PrivateRulePriMatchType) {
		getProperty(utsDot3Onu2PrivateRulePriMatchType).setValue(
				aUtsDot3Onu2PrivateRulePriMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRulePri() {
		return (Integer) getProperty(utsDot3Onu2PrivateRulePri).getValue();
	}

	public void setUtsDot3Onu2PrivateRulePri(Integer aUtsDot3Onu2PrivateRulePri) {
		getProperty(utsDot3Onu2PrivateRulePri).setValue(
				aUtsDot3Onu2PrivateRulePri);
	}

	public Integer getUtsDot3Onu2PrivateRuleVlanMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleVlanMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleVlanMatchType(
			Integer aUtsDot3Onu2PrivateRuleVlanMatchType) {
		getProperty(utsDot3Onu2PrivateRuleVlanMatchType).setValue(
				aUtsDot3Onu2PrivateRuleVlanMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRuleVlanId() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleVlanId).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleVlanId(
			Integer aUtsDot3Onu2PrivateRuleVlanId) {
		getProperty(utsDot3Onu2PrivateRuleVlanId).setValue(
				aUtsDot3Onu2PrivateRuleVlanId);
	}

	public Integer getUtsDot3Onu2PrivateRuleEtherTypeMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleEtherTypeMatchType(
			Integer aUtsDot3Onu2PrivateRuleEtherTypeMatchType) {
		getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType).setValue(
				aUtsDot3Onu2PrivateRuleEtherTypeMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRuleEtherType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleEtherType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleEtherType(
			Integer aUtsDot3Onu2PrivateRuleEtherType) {
		getProperty(utsDot3Onu2PrivateRuleEtherType).setValue(
				aUtsDot3Onu2PrivateRuleEtherType);
	}

	public Integer getUtsDot3Onu2PrivateRuleDIPMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleDIPMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDIPMatchType(
			Integer aUtsDot3Onu2PrivateRuleDIPMatchType) {
		getProperty(utsDot3Onu2PrivateRuleDIPMatchType).setValue(
				aUtsDot3Onu2PrivateRuleDIPMatchType);
	}

	public String getUtsDot3Onu2PrivateRuleDIP() {
		return (String) getProperty(utsDot3Onu2PrivateRuleDIP).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDIP(String aUtsDot3Onu2PrivateRuleDIP) {
		getProperty(utsDot3Onu2PrivateRuleDIP).setValue(
				aUtsDot3Onu2PrivateRuleDIP);
	}

	public Integer getUtsDot3Onu2PrivateRuleSIPMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleSIPMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSIPMatchType(
			Integer aUtsDot3Onu2PrivateRuleSIPMatchType) {
		getProperty(utsDot3Onu2PrivateRuleSIPMatchType).setValue(
				aUtsDot3Onu2PrivateRuleSIPMatchType);
	}

	public String getUtsDot3Onu2PrivateRuleSIP() {
		return (String) getProperty(utsDot3Onu2PrivateRuleSIP).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSIP(String aUtsDot3Onu2PrivateRuleSIP) {
		getProperty(utsDot3Onu2PrivateRuleSIP).setValue(
				aUtsDot3Onu2PrivateRuleSIP);
	}

	public Integer getUtsDot3Onu2PrivateRuleIpTypeMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleIpTypeMatchType(
			Integer aUtsDot3Onu2PrivateRuleIpTypeMatchType) {
		getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType).setValue(
				aUtsDot3Onu2PrivateRuleIpTypeMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRuleIpType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleIpType).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleIpType(
			Integer aUtsDot3Onu2PrivateRuleIpType) {
		getProperty(utsDot3Onu2PrivateRuleIpType).setValue(
				aUtsDot3Onu2PrivateRuleIpType);
	}

	public Integer getUtsDot3Onu2PrivateRuleDscpMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleDscpMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDscpMatchType(
			Integer aUtsDot3Onu2PrivateRuleDscpMatchType) {
		getProperty(utsDot3Onu2PrivateRuleDscpMatchType).setValue(
				aUtsDot3Onu2PrivateRuleDscpMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRuleDscp() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleDscp).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDscp(
			Integer aUtsDot3Onu2PrivateRuleDscp) {
		getProperty(utsDot3Onu2PrivateRuleDscp).setValue(
				aUtsDot3Onu2PrivateRuleDscp);
	}

	public Integer getUtsDot3Onu2PrivateRulePrecedenceMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRulePrecedenceMatchType(
			Integer aUtsDot3Onu2PrivateRulePrecedenceMatchType) {
		getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType).setValue(
				aUtsDot3Onu2PrivateRulePrecedenceMatchType);
	}

	public Integer getUtsDot3Onu2PrivateRulePrecedence() {
		return (Integer) getProperty(utsDot3Onu2PrivateRulePrecedence)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRulePrecedence(
			Integer aUtsDot3Onu2PrivateRulePrecedence) {
		getProperty(utsDot3Onu2PrivateRulePrecedence).setValue(
				aUtsDot3Onu2PrivateRulePrecedence);
	}

	public Integer getUtsDot3Onu2PrivateRuleSourePortMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleSourePortMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSourePortMatchType(
			Integer aUtsDot3Onu2PrivateRuleSourePortMatchType) {
		getProperty(utsDot3Onu2PrivateRuleSourePortMatchType).setValue(
				aUtsDot3Onu2PrivateRuleSourePortMatchType);
	}

	public Long getUtsDot3Onu2PrivateRuleSourcePort() {
		return (Long) getProperty(utsDot3Onu2PrivateRuleSourcePort)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleSourcePort(
			Long aUtsDot3Onu2PrivateRuleSourcePort) {
		getProperty(utsDot3Onu2PrivateRuleSourcePort).setValue(
				aUtsDot3Onu2PrivateRuleSourcePort);
	}

	public Integer getUtsDot3Onu2PrivateRuleDstPortMatchType() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleDstPortMatchType)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDstPortMatchType(
			Integer aUtsDot3Onu2PrivateRuleDstPortMatchType) {
		getProperty(utsDot3Onu2PrivateRuleDstPortMatchType).setValue(
				aUtsDot3Onu2PrivateRuleDstPortMatchType);
	}

	public Long getUtsDot3Onu2PrivateRuleDstPort() {
		return (Long) getProperty(utsDot3Onu2PrivateRuleDstPort).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleDstPort(
			Long aUtsDot3Onu2PrivateRuleDstPort) {
		getProperty(utsDot3Onu2PrivateRuleDstPort).setValue(
				aUtsDot3Onu2PrivateRuleDstPort);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleName));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleBitmap));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDMacMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDMac));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSMacMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSMac));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePriMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePri));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleVlanMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleVlanId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleEtherType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDIPMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDIP));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSIPMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSIP));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleIpType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDscpMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDscp));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePrecedence));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSourePortMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSourcePort));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDstPortMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDstPort));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleName));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleBitmap));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDMacMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDMac));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSMacMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSMac));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePriMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePri));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleVlanMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleVlanId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleEtherType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDIPMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDIP));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSIPMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSIP));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleIpType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDscpMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDscp));
		prepareRead(super
				.getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRulePrecedence));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSourePortMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleSourcePort));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDstPortMatchType));
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleDstPort));

		return loadAll(new int[] { 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2PrivateRuleName));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleBitmap));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDMacMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDMac));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSMacMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSMac));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePriMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePri));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleVlanMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleVlanId));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleEtherType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDIPMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDIP));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSIPMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSIP));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleIpType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDscpMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDscp));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePrecedence));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSourePortMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSourcePort));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDstPortMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDstPort));

		return save();
	}

	public boolean add() throws MibBeanException {
		super.setRowStatus(new Integer(4));
		
		prepareSave(getProperty(utsDot3Onu2PrivateRuleName));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleBitmap));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDMacMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDMac));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSMacMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSMac));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePriMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePri));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleVlanMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleVlanId));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleEtherTypeMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleEtherType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDIPMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDIP));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSIPMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSIP));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleIpTypeMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleIpType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDscpMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDscp));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePrecedenceMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRulePrecedence));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSourePortMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleSourcePort));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDstPortMatchType));
		prepareSave(getProperty(utsDot3Onu2PrivateRuleDstPort));
		
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException {
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}
