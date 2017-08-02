/**
 * Created by Zhou Chao, 2009/11/3
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class MduMgmtIpConfTable extends SnmpMibBean {

    public static final String utsDot3Onu2CtcMduMgmtIpConfModuleId = "utsDot3Onu2CtcMduMgmtIpConfModuleId";
    public static final String utsDot3Onu2CtcMduMgmtIpConfDeviceId = "utsDot3Onu2CtcMduMgmtIpConfDeviceId";
    public static final String utsDot3Onu2CtcMduMgmtIpConfPortId = "utsDot3Onu2CtcMduMgmtIpConfPortId";
    public static final String utsDot3Onu2CtcMduMgmtIpConfLogicalPortId = "utsDot3Onu2CtcMduMgmtIpConfLogicalPortId";
    public static final String utsDot3Onu2CtcMduMgmtIpConfIpAddr = "utsDot3Onu2CtcMduMgmtIpConfIpAddr";
    public static final String utsDot3Onu2CtcMduMgmtIpConfIpMask = "utsDot3Onu2CtcMduMgmtIpConfIpMask";
    public static final String utsDot3Onu2CtcMduMgmtIpConfGw = "utsDot3Onu2CtcMduMgmtIpConfGw";
    public static final String utsDot3Onu2CtcMduMgmtIpConfCvlan = "utsDot3Onu2CtcMduMgmtIpConfCvlan";
    public static final String utsDot3Onu2CtcMduMgmtIpConfSvlan = "utsDot3Onu2CtcMduMgmtIpConfSvlan";
    public static final String utsDot3Onu2CtcMduMgmtIpConfDataPrio = "utsDot3Onu2CtcMduMgmtIpConfDataPrio";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public MduMgmtIpConfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3Onu2CtcMduMgmtIpConfModuleId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfDeviceId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.2", ISnmpConstant.STRING));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfLogicalPortId, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.5", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.6", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfGw, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfGw, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio, new SnmpMibBeanProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.32.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfModuleId(Integer aUtsDot3Onu2CtcMduMgmtIpConfModuleId) {
        setIndex(0, aUtsDot3Onu2CtcMduMgmtIpConfModuleId);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfDeviceId(Integer aUtsDot3Onu2CtcMduMgmtIpConfDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcMduMgmtIpConfDeviceId);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfPortId(Integer aUtsDot3Onu2CtcMduMgmtIpConfPortId) {
        setIndex(2, aUtsDot3Onu2CtcMduMgmtIpConfPortId);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId(Integer aUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId);
    }

    public String getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() {
        return (String) getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfIpAddr(String aUtsDot3Onu2CtcMduMgmtIpConfIpAddr) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr).setValue(aUtsDot3Onu2CtcMduMgmtIpConfIpAddr);
    }

    public String getUtsDot3Onu2CtcMduMgmtIpConfIpMask() {
        return (String) getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfIpMask(String aUtsDot3Onu2CtcMduMgmtIpConfIpMask) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask).setValue(aUtsDot3Onu2CtcMduMgmtIpConfIpMask);
    }

    public String getUtsDot3Onu2CtcMduMgmtIpConfGw() {
        return (String) getProperty(utsDot3Onu2CtcMduMgmtIpConfGw).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfGw(String aUtsDot3Onu2CtcMduMgmtIpConfGw) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfGw).setValue(aUtsDot3Onu2CtcMduMgmtIpConfGw);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfCvlan() {
        return (Integer) getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfCvlan(Integer aUtsDot3Onu2CtcMduMgmtIpConfCvlan) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan).setValue(aUtsDot3Onu2CtcMduMgmtIpConfCvlan);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfSvlan() {
        return (Integer) getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfSvlan(Integer aUtsDot3Onu2CtcMduMgmtIpConfSvlan) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan).setValue(aUtsDot3Onu2CtcMduMgmtIpConfSvlan);
    }

    public Integer getUtsDot3Onu2CtcMduMgmtIpConfDataPrio() {
        return (Integer) getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio).getValue();
    }

    public void setUtsDot3Onu2CtcMduMgmtIpConfDataPrio(Integer aUtsDot3Onu2CtcMduMgmtIpConfDataPrio) {
        getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio).setValue(aUtsDot3Onu2CtcMduMgmtIpConfDataPrio);
    }

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfGw));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfGw));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan));
        prepareRead(getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    MduMgmtIpConfTable bean = (MduMgmtIpConfTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcMduMgmtIpConfModuleId()).append("/").append(bean.getUtsDot3Onu2CtcMduMgmtIpConfPortId()).append("/").append(bean.getUtsDot3Onu2CtcMduMgmtIpConfLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfGw));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfIpMask));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfGw));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfCvlan));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfSvlan));
        prepareSave(getProperty(utsDot3Onu2CtcMduMgmtIpConfDataPrio));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}