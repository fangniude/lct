package com.winnertel.ems.epon.iad.bbs1000.mib.r341;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class UtsOnuFWUpgradeManualBean extends SnmpMibBean {
    public static final String utsOnuFWUpgradeManualPortListBitMap = "utsOnuFWUpgradeManualPortListBitMap";
    public static final String utsOnuFWUpgradeManualOption = "utsOnuFWUpgradeManualOption";
    public static final String utsOnuFWUpgradeManualActCommitFlag = "utsOnuFWUpgradeManualActCommitFlag";
    public static final String utsOnuFWUpgradeManualCurrentStatus = "utsOnuFWUpgradeManualCurrentStatus";
    public static final String utsOnuFWUpgradeManualManualStop = "utsOnuFWUpgradeManualManualStop";

    public UtsOnuFWUpgradeManualBean(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsOnuFWUpgradeManualPortListBitMap, new SnmpMibBeanProperty(utsOnuFWUpgradeManualPortListBitMap, ".1.3.6.1.4.1.45121.1800.2.3.1.7.12.1", ISnmpConstant.OCTETS));
	initProperty(utsOnuFWUpgradeManualOption, new SnmpMibBeanProperty(utsOnuFWUpgradeManualOption, ".1.3.6.1.4.1.45121.1800.2.3.1.7.12.2", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeManualActCommitFlag, new SnmpMibBeanProperty(utsOnuFWUpgradeManualActCommitFlag, ".1.3.6.1.4.1.45121.1800.2.3.1.7.12.3", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeManualCurrentStatus, new SnmpMibBeanProperty(utsOnuFWUpgradeManualCurrentStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.7.12.4", ISnmpConstant.OCTETS));
	initProperty(utsOnuFWUpgradeManualManualStop, new SnmpMibBeanProperty(utsOnuFWUpgradeManualManualStop, ".1.3.6.1.4.1.45121.1800.2.3.1.7.12.5", ISnmpConstant.INTEGER));
    }

    public byte[] getUtsOnuFWUpgradeManualPortListBitMap() {
	return (byte[]) getProperty(utsOnuFWUpgradeManualPortListBitMap).getValue();
    }

    public void setUtsOnuFWUpgradeManualPortListBitMap(byte[] aUtsOnuFWUpgradeManualPortListBitMap) {
	getProperty(utsOnuFWUpgradeManualPortListBitMap).setValue(aUtsOnuFWUpgradeManualPortListBitMap);
    }

    public Integer getUtsOnuFWUpgradeManualOption() {
	return (Integer) getProperty(utsOnuFWUpgradeManualOption).getValue();
    }

    public void setUtsOnuFWUpgradeManualOption(Integer aUtsOnuFWUpgradeManualOption) {
	getProperty(utsOnuFWUpgradeManualOption).setValue(aUtsOnuFWUpgradeManualOption);
    }

    public Integer getUtsOnuFWUpgradeManualActCommitFlag() {
	return (Integer) getProperty(utsOnuFWUpgradeManualActCommitFlag).getValue();
    }

    public void setUtsOnuFWUpgradeManualActCommitFlag(Integer aUtsOnuFWUpgradeManualActCommitFlag) {
	getProperty(utsOnuFWUpgradeManualActCommitFlag).setValue(aUtsOnuFWUpgradeManualActCommitFlag);
    }

    public String getUtsOnuFWUpgradeManualCurrentStatus() {
	return (String) getProperty(utsOnuFWUpgradeManualCurrentStatus).getValue();
    }

    public void setUtsOnuFWUpgradeManualCurrentStatus(String aUtsOnuFWUpgradeManualCurrentStatus) {
	getProperty(utsOnuFWUpgradeManualCurrentStatus).setValue(aUtsOnuFWUpgradeManualCurrentStatus);
    }

    public Integer getUtsOnuFWUpgradeManualManualStop() {
	return (Integer) getProperty(utsOnuFWUpgradeManualManualStop).getValue();
    }

    public void setUtsOnuFWUpgradeManualManualStop(Integer aUtsOnuFWUpgradeManualManualStop) {
	getProperty(utsOnuFWUpgradeManualManualStop).setValue(aUtsOnuFWUpgradeManualManualStop);
    }

    public boolean retrieve() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeManualPortListBitMap));
	prepareRead(super.getProperty(utsOnuFWUpgradeManualOption));
	prepareRead(super.getProperty(utsOnuFWUpgradeManualActCommitFlag));
	prepareRead(super.getProperty(utsOnuFWUpgradeManualCurrentStatus));
	prepareRead(super.getProperty(utsOnuFWUpgradeManualManualStop));

	return load();
    }

    public boolean modify() throws MibBeanException {
	prepareSave(getProperty(utsOnuFWUpgradeManualPortListBitMap));
	prepareSave(getProperty(utsOnuFWUpgradeManualOption));
	prepareSave(getProperty(utsOnuFWUpgradeManualActCommitFlag));
	// prepareSave(getProperty(utsOnuFWUpgradeManualCurrentStatus));

	String currentStatus = this.getUtsOnuFWUpgradeManualCurrentStatus();
	if ("upgrading".equals(currentStatus) || "not start".equals(currentStatus)) {
	    prepareSave(getProperty(utsOnuFWUpgradeManualManualStop));
	}

	return save();
    }
    
    public boolean doStop() throws MibBeanException {
    	String currentStatus = this.getUtsOnuFWUpgradeManualCurrentStatus();
    	if ("upgrading".equals(currentStatus) || "not start".equals(currentStatus)) {
    	    prepareSave(getProperty(utsOnuFWUpgradeManualManualStop));
    	    return save();
    	}
    	
    	return false;
    }

}
