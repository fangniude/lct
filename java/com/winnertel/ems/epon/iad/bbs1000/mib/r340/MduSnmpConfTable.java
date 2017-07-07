package com.winnertel.ems.epon.iad.bbs1000.mib.r340;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class MduSnmpConfTable extends SnmpMibBean {
    public static final String utsDot3Onu2CtcMduSnmpConfModuleId = "utsDot3Onu2CtcMduSnmpConfModuleId";
    public static final String utsDot3Onu2CtcMduSnmpConfDeviceId = "utsDot3Onu2CtcMduSnmpConfDeviceId";
    public static final String utsDot3Onu2CtcMduSnmpConfPortId = "utsDot3Onu2CtcMduSnmpConfPortId";
    public static final String utsDot3Onu2CtcMduSnmpConfLogicalPortId = "utsDot3Onu2CtcMduSnmpConfLogicalPortId";
    public static final String utsDot3Onu2CtcMduSnmpConfSnmpVer = "utsDot3Onu2CtcMduSnmpConfSnmpVer";
    public static final String utsDot3Onu2CtcMduSnmpConfTrapHost = "utsDot3Onu2CtcMduSnmpConfTrapHost";
    public static final String utsDot3Onu2CtcMduSnmpConfTrapPort = "utsDot3Onu2CtcMduSnmpConfTrapPort";
    public static final String utsDot3Onu2CtcMduSnmpConfSnmpPort = "utsDot3Onu2CtcMduSnmpConfSnmpPort";
    public static final String utsDot3Onu2CtcMduSnmpConfSecurityName = "utsDot3Onu2CtcMduSnmpConfSecurityName";
    public static final String utsDot3Onu2CtcMduSnmpConfCommunityRead = "utsDot3Onu2CtcMduSnmpConfCommunityRead";
    public static final String utsDot3Onu2CtcMduSnmpConfCommunityWrite = "utsDot3Onu2CtcMduSnmpConfCommunityWrite";
    
    private String onuLabel = null; //added by Zengtian, 2011/9/14

    public MduSnmpConfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcMduSnmpConfModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfTrapHost, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfTrapHost, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.6", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcMduSnmpConfTrapPort, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfTrapPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduSnmpConfSecurityName, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfSecurityName, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.9", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.10", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite, new SnmpMibBeanProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.33.1.11", ISnmpConstant.STRING));

    }


    public Integer getUtsDot3Onu2CtcMduSnmpConfModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcMduSnmpConfModuleId(Integer aUtsDot3Onu2CtcMduSnmpConfModuleId) {
        setIndex(0, aUtsDot3Onu2CtcMduSnmpConfModuleId);
    }


    public Integer getUtsDot3Onu2CtcMduSnmpConfDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcMduSnmpConfDeviceId(Integer aUtsDot3Onu2CtcMduSnmpConfDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcMduSnmpConfDeviceId);
    }


    public Integer getUtsDot3Onu2CtcMduSnmpConfPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcMduSnmpConfPortId(Integer aUtsDot3Onu2CtcMduSnmpConfPortId) {
        setIndex(2, aUtsDot3Onu2CtcMduSnmpConfPortId);
    }


    public Integer getUtsDot3Onu2CtcMduSnmpConfLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcMduSnmpConfLogicalPortId(Integer aUtsDot3Onu2CtcMduSnmpConfLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcMduSnmpConfLogicalPortId);
    }


    public Integer getUtsDot3Onu2CtcMduSnmpConfSnmpVer() {
        return (Integer) getProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfSnmpVer(Integer aUtsDot3Onu2CtcMduSnmpConfSnmpVer) {
        getProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer).setValue(aUtsDot3Onu2CtcMduSnmpConfSnmpVer);
    }

    public String getUtsDot3Onu2CtcMduSnmpConfTrapHost() {
        return (String) getProperty(utsDot3Onu2CtcMduSnmpConfTrapHost).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfTrapHost(String aUtsDot3Onu2CtcMduSnmpConfTrapHost) {
        getProperty(utsDot3Onu2CtcMduSnmpConfTrapHost).setValue(aUtsDot3Onu2CtcMduSnmpConfTrapHost);
    }

    public Integer getUtsDot3Onu2CtcMduSnmpConfTrapPort() {
        return (Integer) getProperty(utsDot3Onu2CtcMduSnmpConfTrapPort).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfTrapPort(Integer aUtsDot3Onu2CtcMduSnmpConfTrapPort) {
        getProperty(utsDot3Onu2CtcMduSnmpConfTrapPort).setValue(aUtsDot3Onu2CtcMduSnmpConfTrapPort);
    }

    public Integer getUtsDot3Onu2CtcMduSnmpConfSnmpPort() {
        return (Integer) getProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfSnmpPort(Integer aUtsDot3Onu2CtcMduSnmpConfSnmpPort) {
        getProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort).setValue(aUtsDot3Onu2CtcMduSnmpConfSnmpPort);
    }

    public String getUtsDot3Onu2CtcMduSnmpConfSecurityName() {
        return (String) getProperty(utsDot3Onu2CtcMduSnmpConfSecurityName).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfSecurityName(String aUtsDot3Onu2CtcMduSnmpConfSecurityName) {
        getProperty(utsDot3Onu2CtcMduSnmpConfSecurityName).setValue(aUtsDot3Onu2CtcMduSnmpConfSecurityName);
    }

    public String getUtsDot3Onu2CtcMduSnmpConfCommunityRead() {
        return (String) getProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfCommunityRead(String aUtsDot3Onu2CtcMduSnmpConfCommunityRead) {
        getProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead).setValue(aUtsDot3Onu2CtcMduSnmpConfCommunityRead);
    }

    public String getUtsDot3Onu2CtcMduSnmpConfCommunityWrite() {
        return (String) getProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite).getValue();
    }

    public void setUtsDot3Onu2CtcMduSnmpConfCommunityWrite(String aUtsDot3Onu2CtcMduSnmpConfCommunityWrite) {
        getProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite).setValue(aUtsDot3Onu2CtcMduSnmpConfCommunityWrite);
    }
    
    //added by Zengtian, 2011/9/14
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zengtian, 2011/9/14
    public void setOnuLabel(String label) {
        onuLabel = label;
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfTrapHost));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfTrapPort));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSecurityName));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfTrapHost));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfTrapPort));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfSecurityName));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead));
        prepareRead(super.getProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zengtian, 2011/9/14
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                	MduSnmpConfTable bean = (MduSnmpConfTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcMduSnmpConfModuleId()).append("/").append(bean.getUtsDot3Onu2CtcMduSnmpConfPortId()).append("/").append(bean.getUtsDot3Onu2CtcMduSnmpConfLogicalPortId()).toString();
//                    if (map.containsKey(key)) {
//                        bean.setOnuLabel((String) map.get(key));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfSnmpVer));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfTrapHost));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfTrapPort));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfSnmpPort));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfSecurityName));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfCommunityRead));
        prepareSave(getProperty(utsDot3Onu2CtcMduSnmpConfCommunityWrite));

        return save();
    }
}
