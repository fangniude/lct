package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3Onu2CtcPortsCftTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcPotsCfgModuleId = "utsDot3Onu2CtcPotsCfgModuleId";
    public static final String utsDot3Onu2CtcPotsCfgDeviceId = "utsDot3Onu2CtcPotsCfgDeviceId";
    public static final String utsDot3Onu2CtcPotsCfgPortId = "utsDot3Onu2CtcPotsCfgPortId";
    public static final String utsDot3Onu2CtcPotsCfgLogicalPortId = "utsDot3Onu2CtcPotsCfgLogicalPortId";
    public static final String utsDot3Onu2CtcPotsCfgPotsId = "utsDot3Onu2CtcPotsCfgPotsId";
    public static final String utsDot3Onu2CtcPotsCfgH248UserTidInfo = "utsDot3Onu2CtcPotsCfgH248UserTidInfo";
    public static final String utsDot3Onu2CtcPotsCfgSipUserAccount = "utsDot3Onu2CtcPotsCfgSipUserAccount";
    public static final String utsDot3Onu2CtcPotsCfgSipUsername = "utsDot3Onu2CtcPotsCfgSipUsername";
    public static final String utsDot3Onu2CtcPotsCfgSipPassword = "utsDot3Onu2CtcPotsCfgSipPassword";
    /*
    public static final String utsDot3Onu2CtcPotsCfgIadPortStatus = "utsDot3Onu2CtcPotsCfgIadPortStatus";
    public static final String utsDot3Onu2CtcPotsCfgIadPortServiceState = "utsDot3Onu2CtcPotsCfgIadPortServiceState";
    public static final String utsDot3Onu2CtcPotsCfgIadPortCodecMode = "utsDot3Onu2CtcPotsCfgIadPortCodecMode";
    */

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Dot3Onu2CtcPortsCftTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcPotsCfgModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgPotsId, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgPotsId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.11", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcPotsCfgSipUserAccount, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgSipUserAccount, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.21", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcPotsCfgSipUsername, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgSipUsername, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.22", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcPotsCfgSipPassword, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgSipPassword, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.23", ISnmpConstant.STRING));
        /*
        initProperty(utsDot3Onu2CtcPotsCfgIadPortStatus, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgIadPortStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.31", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.32", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode, new SnmpMibBeanProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.42.1.33", ISnmpConstant.INTEGER));
        */
    }

    public Integer getUtsDot3Onu2CtcPotsCfgModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcPotsCfgModuleId(Integer aUtsDot3Onu2CtcPotsCfgModuleId) {
        setIndex(0, aUtsDot3Onu2CtcPotsCfgModuleId);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcPotsCfgDeviceId(Integer aUtsDot3Onu2CtcPotsCfgDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcPotsCfgDeviceId);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcPotsCfgPortId(Integer aUtsDot3Onu2CtcPotsCfgPortId) {
        setIndex(2, aUtsDot3Onu2CtcPotsCfgPortId);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcPotsCfgLogicalPortId(Integer aUtsDot3Onu2CtcPotsCfgLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcPotsCfgLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgPotsId() {
        return (Integer) getIndex(4);
    }

    public void setUtsDot3Onu2CtcPotsCfgPotsId(Integer aUtsDot3Onu2CtcPotsCfgPotsId) {
        setIndex(4, aUtsDot3Onu2CtcPotsCfgPotsId);
    }

    public String getUtsDot3Onu2CtcPotsCfgH248UserTidInfo() {
        return (String) getProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgH248UserTidInfo(String aUtsDot3Onu2CtcPotsCfgH248UserTidInfo) {
        getProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo).setValue(aUtsDot3Onu2CtcPotsCfgH248UserTidInfo);
    }

    public String getUtsDot3Onu2CtcPotsCfgSipUserAccount() {
        return (String) getProperty(utsDot3Onu2CtcPotsCfgSipUserAccount).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgSipUserAccount(String aUtsDot3Onu2CtcPotsCfgSipUserAccount) {
        getProperty(utsDot3Onu2CtcPotsCfgSipUserAccount).setValue(aUtsDot3Onu2CtcPotsCfgSipUserAccount);
    }

    public String getUtsDot3Onu2CtcPotsCfgSipUsername() {
        return (String) getProperty(utsDot3Onu2CtcPotsCfgSipUsername).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgSipUsername(String aUtsDot3Onu2CtcPotsCfgSipUsername) {
        getProperty(utsDot3Onu2CtcPotsCfgSipUsername).setValue(aUtsDot3Onu2CtcPotsCfgSipUsername);
    }

    public String getUtsDot3Onu2CtcPotsCfgSipPassword() {
        return (String) getProperty(utsDot3Onu2CtcPotsCfgSipPassword).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgSipPassword(String aUtsDot3Onu2CtcPotsCfgSipPassword) {
        getProperty(utsDot3Onu2CtcPotsCfgSipPassword).setValue(aUtsDot3Onu2CtcPotsCfgSipPassword);
    }

    /*
    public Integer getUtsDot3Onu2CtcPotsCfgIadPortStatus() {
        return (Integer) getProperty(utsDot3Onu2CtcPotsCfgIadPortStatus).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgIadPortStatus(Integer aUtsDot3Onu2CtcPotsCfgIadPortStatus) {
        getProperty(utsDot3Onu2CtcPotsCfgIadPortStatus).setValue(aUtsDot3Onu2CtcPotsCfgIadPortStatus);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgIadPortServiceState() {
        return (Integer) getProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgIadPortServiceState(Integer aUtsDot3Onu2CtcPotsCfgIadPortServiceState) {
        getProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState).setValue(aUtsDot3Onu2CtcPotsCfgIadPortServiceState);
    }

    public Integer getUtsDot3Onu2CtcPotsCfgIadPortCodecMode() {
        return (Integer) getProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode).getValue();
    }

    public void setUtsDot3Onu2CtcPotsCfgIadPortCodecMode(Integer aUtsDot3Onu2CtcPotsCfgIadPortCodecMode) {
        getProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode).setValue(aUtsDot3Onu2CtcPotsCfgIadPortCodecMode);
    }
    */

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipUserAccount));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipUsername));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipPassword));
        /*
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode));
        */

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipUserAccount));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipUsername));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgSipPassword));
        /*
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortStatus));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortServiceState));
        prepareRead(getProperty(utsDot3Onu2CtcPotsCfgIadPortCodecMode));
        */

        Vector v = loadAll(new int[]{1, 1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3Onu2CtcPortsCftTable bean = (Dot3Onu2CtcPortsCftTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcPotsCfgModuleId()).append("/").append(bean.getUtsDot3Onu2CtcPotsCfgPortId()).append("/").append(bean.getUtsDot3Onu2CtcPotsCfgLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3Onu2CtcPotsCfgH248UserTidInfo));
        prepareSave(getProperty(utsDot3Onu2CtcPotsCfgSipUserAccount));
        prepareSave(getProperty(utsDot3Onu2CtcPotsCfgSipUsername));
        prepareSave(getProperty(utsDot3Onu2CtcPotsCfgSipPassword));

        return save();
    }

}