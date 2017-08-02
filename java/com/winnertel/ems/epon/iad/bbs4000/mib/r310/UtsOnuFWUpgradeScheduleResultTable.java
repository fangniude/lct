/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UtsOnuFWUpgradeScheduleResultTable class. Created by QuickDVM
 */
public class UtsOnuFWUpgradeScheduleResultTable extends SnmpMibBean {
    public static final String utsOnuFWUpgradeScheduleResultTime = "utsOnuFWUpgradeScheduleResultTime";
    public static final String utsOnuFWUpgradeScheduleResultComp = "utsOnuFWUpgradeScheduleResultComp";
    public static final String utsOnuFWUpgradeScheduleResultModule = "utsOnuFWUpgradeScheduleResultModule";
    public static final String utsOnuFWUpgradeScheduleResultPort = "utsOnuFWUpgradeScheduleResultPort";
    public static final String utsOnuFWUpgradeScheduleResultLport = "utsOnuFWUpgradeScheduleResultLport";
    public static final String utsOnuFWUpgradeScheduleResultTargetVersion = "utsOnuFWUpgradeScheduleResultTargetVersion";
    public static final String utsOnuFWUpgradeScheduleResultCurrentVersion = "utsOnuFWUpgradeScheduleResultCurrentVersion";
    public static final String utsOnuFWUpgradeScheduleResultCurrentUpgStatus = "utsOnuFWUpgradeScheduleResultCurrentUpgStatus";
    public static final String utsOnuFWUpgradeScheduleResultFailReason = "utsOnuFWUpgradeScheduleResultFailReason";
    
    private String onuLabel = null; //added by Zengtian, 2011/9/15

    public UtsOnuFWUpgradeScheduleResultTable(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsOnuFWUpgradeScheduleResultTime, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultTime, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.1", ISnmpConstant.OCTETS));
	initProperty(utsOnuFWUpgradeScheduleResultComp, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultComp, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.2", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleResultModule, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultModule, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.3", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleResultPort, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultPort, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.4", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleResultLport, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultLport, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.5", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeScheduleResultTargetVersion, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultTargetVersion, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.6", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeScheduleResultCurrentVersion, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultCurrentVersion, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.7", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.8", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeScheduleResultFailReason, new SnmpMibBeanProperty(utsOnuFWUpgradeScheduleResultFailReason, ".1.3.6.1.4.1.45121.1800.2.3.1.7.16.1.9", ISnmpConstant.STRING));

    }

    public byte[] getUtsOnuFWUpgradeScheduleResultTime() {
	return (byte[]) getIndex(0);
    }

    public void setUtsOnuFWUpgradeScheduleResultTime(byte[] aUtsOnuFWUpgradeScheduleResultTime) {
	setIndex(0, aUtsOnuFWUpgradeScheduleResultTime);
    }

    public Integer getUtsOnuFWUpgradeScheduleResultComp() {
	return (Integer) getIndex(1);
    }

    public void setUtsOnuFWUpgradeScheduleResultComp(Integer aUtsOnuFWUpgradeScheduleResultComp) {
	setIndex(1, aUtsOnuFWUpgradeScheduleResultComp);
    }

    public Integer getUtsOnuFWUpgradeScheduleResultModule() {
	return (Integer) getProperty(utsOnuFWUpgradeScheduleResultModule).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultModule(Integer aUtsOnuFWUpgradeScheduleResultModule) {
	getProperty(utsOnuFWUpgradeScheduleResultModule).setValue(aUtsOnuFWUpgradeScheduleResultModule);
    }

    public Integer getUtsOnuFWUpgradeScheduleResultPort() {
	return (Integer) getProperty(utsOnuFWUpgradeScheduleResultPort).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultPort(Integer aUtsOnuFWUpgradeScheduleResultPort) {
	getProperty(utsOnuFWUpgradeScheduleResultPort).setValue(aUtsOnuFWUpgradeScheduleResultPort);
    }

    public Integer getUtsOnuFWUpgradeScheduleResultLport() {
	return (Integer) getProperty(utsOnuFWUpgradeScheduleResultLport).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultLport(Integer aUtsOnuFWUpgradeScheduleResultLport) {
	getProperty(utsOnuFWUpgradeScheduleResultLport).setValue(aUtsOnuFWUpgradeScheduleResultLport);
    }

    public String getUtsOnuFWUpgradeScheduleResultTargetVersion() {
	return (String) getProperty(utsOnuFWUpgradeScheduleResultTargetVersion).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultTargetVersion(String aUtsOnuFWUpgradeScheduleResultTargetVersion) {
	getProperty(utsOnuFWUpgradeScheduleResultTargetVersion).setValue(aUtsOnuFWUpgradeScheduleResultTargetVersion);
    }

    public String getUtsOnuFWUpgradeScheduleResultCurrentVersion() {
	return (String) getProperty(utsOnuFWUpgradeScheduleResultCurrentVersion).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultCurrentVersion(String aUtsOnuFWUpgradeScheduleResultCurrentVersion) {
	getProperty(utsOnuFWUpgradeScheduleResultCurrentVersion).setValue(aUtsOnuFWUpgradeScheduleResultCurrentVersion);
    }

    public String getUtsOnuFWUpgradeScheduleResultCurrentUpgStatus() {
	return (String) getProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultCurrentUpgStatus(String aUtsOnuFWUpgradeScheduleResultCurrentUpgStatus) {
	getProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus).setValue(aUtsOnuFWUpgradeScheduleResultCurrentUpgStatus);
    }

    public String getUtsOnuFWUpgradeScheduleResultFailReason() {
	return (String) getProperty(utsOnuFWUpgradeScheduleResultFailReason).getValue();
    }

    public void setUtsOnuFWUpgradeScheduleResultFailReason(String aUtsOnuFWUpgradeScheduleResultFailReason) {
	getProperty(utsOnuFWUpgradeScheduleResultFailReason).setValue(aUtsOnuFWUpgradeScheduleResultFailReason);
    }
    
    //added by Zengtian, 2011/9/15
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zengtian, 2011/9/15
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultModule));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultPort));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultLport));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultTargetVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultCurrentVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultFailReason));

	return load();
    }

    public Vector retrieveAll() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultModule));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultPort));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultLport));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultTargetVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultCurrentVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultCurrentUpgStatus));
	prepareRead(super.getProperty(utsOnuFWUpgradeScheduleResultFailReason));
	
    Vector v = loadAll(new int[] { 11, 1 });
	 
	 //added by Zengtian, 2011/9/15
//	    if (!DebugMode.isDebug()) {
//	        try {
//	            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//	            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//	            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//	            for (int i = 0; i < v.size(); i++) {
//	            	UtsOnuFWUpgradeScheduleResultTable bean = (UtsOnuFWUpgradeScheduleResultTable) v.get(i);
//	                //find the onu by module/port/logicalid
//	                String key = new StringBuilder(neName).append(bean.getUtsOnuFWUpgradeScheduleResultModule()).append("/").append(bean.getUtsOnuFWUpgradeScheduleResultPort()).append("/").append(bean.getUtsOnuFWUpgradeScheduleResultLport()).toString();
//	                if (map.containsKey(key)) {
//	                    bean.setOnuLabel((String) map.get(key));
//	                }
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }

	    return v;
    }

}
