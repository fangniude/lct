package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuCtcMulticastOnlineGroupStatTable extends SnmpMibBean {

    public static final String utsDot3OnuMCastOnlineGroupStatModuleId = "utsDot3OnuMCastOnlineGroupStatModuleId";
    public static final String utsDot3OnuMCastOnlineGroupStatDeviceId = "utsDot3OnuMCastOnlineGroupStatDeviceId";
    public static final String utsDot3OnuMCastOnlineGroupStatPortId = "utsDot3OnuMCastOnlineGroupStatPortId";
    public static final String utsDot3OnuMCastOnlineGroupStatLogicalPortId = "utsDot3OnuMCastOnlineGroupStatLogicalPortId";
    public static final String utsDot3OnuMCastOnlineGroupStatNumber = "utsDot3OnuMCastOnlineGroupStatNumber";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuCtcMulticastOnlineGroupStatTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuMCastOnlineGroupStatModuleId, new SnmpMibBeanProperty(utsDot3OnuMCastOnlineGroupStatModuleId, ".1.3.6.1.4.1.41355.1800.2.4.3.1.8.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastOnlineGroupStatDeviceId, new SnmpMibBeanProperty(utsDot3OnuMCastOnlineGroupStatDeviceId, ".1.3.6.1.4.1.41355.1800.2.4.3.1.8.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastOnlineGroupStatPortId, new SnmpMibBeanProperty(utsDot3OnuMCastOnlineGroupStatPortId, ".1.3.6.1.4.1.41355.1800.2.4.3.1.8.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastOnlineGroupStatLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuMCastOnlineGroupStatLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.4.3.1.8.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuMCastOnlineGroupStatNumber, new SnmpMibBeanProperty(utsDot3OnuMCastOnlineGroupStatNumber, ".1.3.6.1.4.1.41355.1800.2.4.3.1.8.1.5", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuMCastOnlineGroupStatModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuMCastOnlineGroupStatModuleId(Integer aUtsDot3OnuMCastOnlineGroupStatModuleId) {
        setIndex(0, aUtsDot3OnuMCastOnlineGroupStatModuleId);
    }

    public Integer getUtsDot3OnuMCastOnlineGroupStatDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuMCastOnlineGroupStatDeviceId(Integer aUtsDot3OnuMCastOnlineGroupStatDeviceId) {
        setIndex(1, aUtsDot3OnuMCastOnlineGroupStatDeviceId);
    }

    public Integer getUtsDot3OnuMCastOnlineGroupStatPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuMCastOnlineGroupStatPortId(Integer aUtsDot3OnuMCastOnlineGroupStatPortId) {
        setIndex(2, aUtsDot3OnuMCastOnlineGroupStatPortId);
    }

    public Integer getUtsDot3OnuMCastOnlineGroupStatLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuMCastOnlineGroupStatLogicalPortId(Integer aUtsDot3OnuMCastOnlineGroupStatLogicalPortId) {
        setIndex(3, aUtsDot3OnuMCastOnlineGroupStatLogicalPortId);
    }

    public Integer getUtsDot3OnuMCastOnlineGroupStatNumber() {
        return (Integer) getProperty(utsDot3OnuMCastOnlineGroupStatNumber).getValue();
    }

    public void setUtsDot3OnuMCastOnlineGroupStatNumber(Integer aUtsDot3OnuMCastOnlineGroupStatNumber) {
        getProperty(utsDot3OnuMCastOnlineGroupStatNumber).setValue(aUtsDot3OnuMCastOnlineGroupStatNumber);
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
        prepareRead(getProperty(utsDot3OnuMCastOnlineGroupStatNumber));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuMCastOnlineGroupStatNumber));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuCtcMulticastOnlineGroupStatTable bean = (OnuCtcMulticastOnlineGroupStatTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuMCastOnlineGroupStatModuleId()).append("/").append(bean.getUtsDot3OnuMCastOnlineGroupStatPortId()).append("/").append(bean.getUtsDot3OnuMCastOnlineGroupStatLogicalPortId()).toString();
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

}