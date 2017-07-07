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
 * The UtsOnuFWUpgradeAutoResultTable class. Created by QuickDVM
 */
public class UtsOnuFWUpgradeAutoResultTable extends SnmpMibBean {
    public static final String utsOnuFWUpgradeAutoResultModule = "utsOnuFWUpgradeAutoResultModule";
    public static final String utsOnuFWUpgradeAutoResultPort = "utsOnuFWUpgradeAutoResultPort";
    public static final String utsOnuFWUpgradeAutoResultLport = "utsOnuFWUpgradeAutoResultLport";
    public static final String utsOnuFWUpgradeAutoResultComp = "utsOnuFWUpgradeAutoResultComp";
    public static final String utsOnuFWUpgradeAutoResultTargetVersion = "utsOnuFWUpgradeAutoResultTargetVersion";
    public static final String utsOnuFWUpgradeAutoResultCurrentVersion = "utsOnuFWUpgradeAutoResultCurrentVersion";
    public static final String utsOnuFWUpgradeAutoResultCurrentUpgStatus = "utsOnuFWUpgradeAutoResultCurrentUpgStatus";
    public static final String utsOnuFWUpgradeAutoResultFailReason = "utsOnuFWUpgradeAutoResultFailReason";
    
    private String onuLabel = null; //added by Zengtian, 2011/9/15

    public UtsOnuFWUpgradeAutoResultTable(ISnmpProxy aSnmpProxy) {
	super(aSnmpProxy);
	init();
    }

    protected void init() {
	initProperty(utsOnuFWUpgradeAutoResultModule, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultModule, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.1", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeAutoResultPort, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultPort, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.2", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeAutoResultLport, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultLport, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.3", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeAutoResultComp, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultComp, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.4", ISnmpConstant.INTEGER));
	initProperty(utsOnuFWUpgradeAutoResultTargetVersion, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultTargetVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.5", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeAutoResultCurrentVersion, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultCurrentVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.6", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.7", ISnmpConstant.STRING));
	initProperty(utsOnuFWUpgradeAutoResultFailReason, new SnmpMibBeanProperty(utsOnuFWUpgradeAutoResultFailReason, ".1.3.6.1.4.1.41355.1800.2.3.1.7.17.1.8", ISnmpConstant.STRING));

    }

    public Integer getUtsOnuFWUpgradeAutoResultModule() {
	return (Integer) getIndex(0);
    }

    public void setUtsOnuFWUpgradeAutoResultModule(Integer aUtsOnuFWUpgradeAutoResultModule) {
	setIndex(0, aUtsOnuFWUpgradeAutoResultModule);
    }

    public Integer getUtsOnuFWUpgradeAutoResultPort() {
	return (Integer) getIndex(1);
    }

    public void setUtsOnuFWUpgradeAutoResultPort(Integer aUtsOnuFWUpgradeAutoResultPort) {
	setIndex(1, aUtsOnuFWUpgradeAutoResultPort);
    }

    public Integer getUtsOnuFWUpgradeAutoResultLport() {
	return (Integer) getIndex(2);
    }

    public void setUtsOnuFWUpgradeAutoResultLport(Integer aUtsOnuFWUpgradeAutoResultLport) {
	setIndex(2, aUtsOnuFWUpgradeAutoResultLport);
    }

    public Integer getUtsOnuFWUpgradeAutoResultComp() {
	return (Integer) getIndex(3);
    }

    public void setUtsOnuFWUpgradeAutoResultComp(Integer aUtsOnuFWUpgradeAutoResultComp) {
	setIndex(3, aUtsOnuFWUpgradeAutoResultComp);
    }

    public String getUtsOnuFWUpgradeAutoResultTargetVersion() {
	return (String) getProperty(utsOnuFWUpgradeAutoResultTargetVersion).getValue();
    }

    public void setUtsOnuFWUpgradeAutoResultTargetVersion(String aUtsOnuFWUpgradeAutoResultTargetVersion) {
	getProperty(utsOnuFWUpgradeAutoResultTargetVersion).setValue(aUtsOnuFWUpgradeAutoResultTargetVersion);
    }

    public String getUtsOnuFWUpgradeAutoResultCurrentVersion() {
	return (String) getProperty(utsOnuFWUpgradeAutoResultCurrentVersion).getValue();
    }

    public void setUtsOnuFWUpgradeAutoResultCurrentVersion(String aUtsOnuFWUpgradeAutoResultCurrentVersion) {
	getProperty(utsOnuFWUpgradeAutoResultCurrentVersion).setValue(aUtsOnuFWUpgradeAutoResultCurrentVersion);
    }

    public String getUtsOnuFWUpgradeAutoResultCurrentUpgStatus() {
	return (String) getProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus).getValue();
    }

    public void setUtsOnuFWUpgradeAutoResultCurrentUpgStatus(String aUtsOnuFWUpgradeAutoResultCurrentUpgStatus) {
	getProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus).setValue(aUtsOnuFWUpgradeAutoResultCurrentUpgStatus);
    }

    public String getUtsOnuFWUpgradeAutoResultFailReason() {
	return (String) getProperty(utsOnuFWUpgradeAutoResultFailReason).getValue();
    }

    public void setUtsOnuFWUpgradeAutoResultFailReason(String aUtsOnuFWUpgradeAutoResultFailReason) {
	getProperty(utsOnuFWUpgradeAutoResultFailReason).setValue(aUtsOnuFWUpgradeAutoResultFailReason);
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
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultTargetVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultCurrentVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultFailReason));

	return load();
    }

    public Vector retrieveAll() throws MibBeanException {
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultTargetVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultCurrentVersion));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultCurrentUpgStatus));
	prepareRead(super.getProperty(utsOnuFWUpgradeAutoResultFailReason));

    Vector v = loadAll(new int[] { 1, 1, 1, 1 });
	 
	 //added by Zengtian, 2011/9/15
//	    if (!DebugMode.isDebug()) {
//	        try {
//	            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//	            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//	            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//	            for (int i = 0; i < v.size(); i++) {
//	            	UtsOnuFWUpgradeAutoResultTable bean = (UtsOnuFWUpgradeAutoResultTable) v.get(i);
//	                String key = new StringBuilder(neName).append(bean.getUtsOnuFWUpgradeAutoResultModule()).append("/").append(bean.getUtsOnuFWUpgradeAutoResultPort()).append("/").append(bean.getUtsOnuFWUpgradeAutoResultLport()).toString();
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
