package com.winnertel.ems.epon.iad.bbs1000.mib.r341;

import java.util.Vector;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class UtsOnuUpgradeRuleTable extends SnmpMibBean {
    public static final String utsOnuUpgradeRuleOnuType = "utsOnuUpgradeRuleOnuType";
    public static final String utsOnuUpgradeRuleHwComp = "utsOnuUpgradeRuleHwComp";
    public static final String utsOnuUpgradeRuleUpgradeMethod = "utsOnuUpgradeRuleUpgradeMethod";
    public static final String utsOnuUpgradeRuleSwVersino = "utsOnuUpgradeRuleSwVersino";
    public static final String utsOnuUpgradeRuleFtpPath = "utsOnuUpgradeRuleFtpPath";
    public static final String utsOnuUpgradeRuleFtpServerIp = "utsOnuUpgradeRuleFtpServerIp";
    public static final String utsOnuUpgradeRuleFtpUsername = "utsOnuUpgradeRuleFtpUsername";
    public static final String utsOnuUpgradeRuleFtpPassword = "utsOnuUpgradeRuleFtpPassword";

    public UtsOnuUpgradeRuleTable(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsOnuUpgradeRuleOnuType, new SnmpMibBeanProperty(utsOnuUpgradeRuleOnuType, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.1", ISnmpConstant.INTEGER));
	initProperty(utsOnuUpgradeRuleHwComp, new SnmpMibBeanProperty(utsOnuUpgradeRuleHwComp, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.2", ISnmpConstant.INTEGER));
	initProperty(utsOnuUpgradeRuleUpgradeMethod, new SnmpMibBeanProperty(utsOnuUpgradeRuleUpgradeMethod, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.3", ISnmpConstant.INTEGER));
	initProperty(utsOnuUpgradeRuleSwVersino, new SnmpMibBeanProperty(utsOnuUpgradeRuleSwVersino, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.4", ISnmpConstant.STRING));
	initProperty(utsOnuUpgradeRuleFtpPath, new SnmpMibBeanProperty(utsOnuUpgradeRuleFtpPath, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.5", ISnmpConstant.STRING));
	initProperty(utsOnuUpgradeRuleFtpServerIp, new SnmpMibBeanProperty(utsOnuUpgradeRuleFtpServerIp, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.6", ISnmpConstant.IP_ADDRESS));
	initProperty(utsOnuUpgradeRuleFtpUsername, new SnmpMibBeanProperty(utsOnuUpgradeRuleFtpUsername, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.7", ISnmpConstant.STRING));
	initProperty(utsOnuUpgradeRuleFtpPassword, new SnmpMibBeanProperty(utsOnuUpgradeRuleFtpPassword, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.8", ISnmpConstant.STRING));
	initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.7.11.1.100", ISnmpConstant.INTEGER));

    }

    public Integer getUtsOnuUpgradeRuleOnuType() {
	return (Integer) getIndex(0);
    }

    public void setUtsOnuUpgradeRuleOnuType(Integer aUtsOnuUpgradeRuleOnuType) {
	setIndex(0, aUtsOnuUpgradeRuleOnuType);
    }

    public Integer getUtsOnuUpgradeRuleHwComp() {
	return (Integer) getIndex(1);
    }

    public void setUtsOnuUpgradeRuleHwComp(Integer aUtsOnuUpgradeRuleHwComp) {
	setIndex(1, aUtsOnuUpgradeRuleHwComp);
    }

    public Integer getUtsOnuUpgradeRuleUpgradeMethod() {
	return (Integer) getIndex(2);
    }

    public void setUtsOnuUpgradeRuleUpgradeMethod(Integer aUtsOnuUpgradeRuleUpgradeMethod) {
	setIndex(2, aUtsOnuUpgradeRuleUpgradeMethod);
    }

    public String getUtsOnuUpgradeRuleSwVersino() {
	return (String) getProperty(utsOnuUpgradeRuleSwVersino).getValue();
    }

    public void setUtsOnuUpgradeRuleSwVersino(String aUtsOnuUpgradeRuleSwVersino) {
	getProperty(utsOnuUpgradeRuleSwVersino).setValue(aUtsOnuUpgradeRuleSwVersino);
    }

    public String getUtsOnuUpgradeRuleFtpPath() {
	return (String) getProperty(utsOnuUpgradeRuleFtpPath).getValue();
    }

    public void setUtsOnuUpgradeRuleFtpPath(String aUtsOnuUpgradeRuleFtpPath) {
	getProperty(utsOnuUpgradeRuleFtpPath).setValue(aUtsOnuUpgradeRuleFtpPath);
    }

    public String getUtsOnuUpgradeRuleFtpServerIp() {
	return (String) getProperty(utsOnuUpgradeRuleFtpServerIp).getValue();
    }

    public void setUtsOnuUpgradeRuleFtpServerIp(String aUtsOnuUpgradeRuleFtpServerIp) {
	getProperty(utsOnuUpgradeRuleFtpServerIp).setValue(aUtsOnuUpgradeRuleFtpServerIp);
    }

    public String getUtsOnuUpgradeRuleFtpUsername() {
	return (String) getProperty(utsOnuUpgradeRuleFtpUsername).getValue();
    }

    public void setUtsOnuUpgradeRuleFtpUsername(String aUtsOnuUpgradeRuleFtpUsername) {
	getProperty(utsOnuUpgradeRuleFtpUsername).setValue(aUtsOnuUpgradeRuleFtpUsername);
    }

    public String getUtsOnuUpgradeRuleFtpPassword() {
	return (String) getProperty(utsOnuUpgradeRuleFtpPassword).getValue();
    }

    public void setUtsOnuUpgradeRuleFtpPassword(String aUtsOnuUpgradeRuleFtpPassword) {
	getProperty(utsOnuUpgradeRuleFtpPassword).setValue(aUtsOnuUpgradeRuleFtpPassword);
    }

    public boolean retrieve() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuUpgradeRuleSwVersino));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpPath));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpServerIp));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpUsername));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpPassword));

	return load();
    }

    public Vector retrieveAll() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuUpgradeRuleSwVersino));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpPath));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpServerIp));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpUsername));
	prepareRead(super.getProperty(utsOnuUpgradeRuleFtpPassword));

	return loadAll(new int[] { 1, 1, 1 });
    }

    public boolean modify() throws MibBeanException {
//	prepareSave(getProperty(utsOnuUpgradeRuleUpgradeMethod));
	prepareSave(getProperty(utsOnuUpgradeRuleSwVersino));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpPath));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpServerIp));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpUsername));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpPassword));

	return save();
    }

    public boolean add() throws MibBeanException {
//	prepareSave(getProperty(utsOnuUpgradeRuleUpgradeMethod));
	prepareSave(getProperty(utsOnuUpgradeRuleSwVersino));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpPath));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpServerIp));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpUsername));
	prepareSave(getProperty(utsOnuUpgradeRuleFtpPassword));

	super.setRowStatus(new Integer(4));
	prepareSave(getProperty(ROW_STATUS));
	return save();
    }

    public boolean delete() throws MibBeanException {
	super.setRowStatus(new Integer(6));
	prepareSave(getProperty(ROW_STATUS));
	return save();
    }

}
