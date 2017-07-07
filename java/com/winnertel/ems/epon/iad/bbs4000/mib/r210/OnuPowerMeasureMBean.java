package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuPowerMeasureMBean extends SnmpMibBean {

    public static final String utsDot3OnuOpticalPowerModuleId = "utsDot3OnuOpticalPowerModuleId";
    public static final String utsDot3OnuOpticalPowerDeviceId = "utsDot3OnuOpticalPowerDeviceId";
    public static final String utsDot3OnuOpticalPowerPortId = "utsDot3OnuOpticalPowerPortId";
    public static final String utsDot3OnuOpticalPowerLogicalPortId = "utsDot3OnuOpticalPowerLogicalPortId";
    public static final String utsDot3OnuOpticalPowerValue = "utsDot3OnuOpticalPowerValue";
    public static final String utsDot3OnuOpticalPowerAdmin = "utsDot3OnuOpticalPowerAdmin";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuPowerMeasureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuOpticalPowerModuleId, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerModuleId, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuOpticalPowerDeviceId, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerDeviceId, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuOpticalPowerPortId, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerPortId, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuOpticalPowerLogicalPortId, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuOpticalPowerValue, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerValue, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuOpticalPowerAdmin, new SnmpMibBeanProperty(utsDot3OnuOpticalPowerAdmin, ".1.3.6.1.4.1.41355.1800.2.5.1.1.1.6", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuOpticalPowerModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuOpticalPowerModuleId(Integer aUtsDot3OnuOpticalPowerModuleId) {
        setIndex(0, aUtsDot3OnuOpticalPowerModuleId);
    }

    public Integer getUtsDot3OnuOpticalPowerDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3OnuOpticalPowerDeviceId(Integer aUtsDot3OnuOpticalPowerDeviceId) {
        setIndex(1, aUtsDot3OnuOpticalPowerDeviceId);
    }

    public Integer getUtsDot3OnuOpticalPowerPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3OnuOpticalPowerPortId(Integer aUtsDot3OnuOpticalPowerPortId) {
        setIndex(2, aUtsDot3OnuOpticalPowerPortId);
    }

    public Integer getUtsDot3OnuOpticalPowerLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3OnuOpticalPowerLogicalPortId(Integer aUtsDot3OnuOpticalPowerLogicalPortId) {
        setIndex(3, aUtsDot3OnuOpticalPowerLogicalPortId);
    }

    public Integer getUtsDot3OnuOpticalPowerValue() {
        return (Integer) getProperty(utsDot3OnuOpticalPowerValue).getValue();
    }

    public void setUtsDot3OnuOpticalPowerValue(Integer aUtsDot3OnuOpticalPowerValue) {
        getProperty(utsDot3OnuOpticalPowerValue).setValue(aUtsDot3OnuOpticalPowerValue);
    }

    public Integer getUtsDot3OnuOpticalPowerAdmin() {
        return (Integer) getProperty(utsDot3OnuOpticalPowerAdmin).getValue();
    }

    public void setUtsDot3OnuOpticalPowerAdmin(Integer aUtsDot3OnuOpticalPowerAdmin) {
        getProperty(utsDot3OnuOpticalPowerAdmin).setValue(aUtsDot3OnuOpticalPowerAdmin);
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
        prepareRead(getProperty(utsDot3OnuOpticalPowerValue));
        prepareRead(getProperty(utsDot3OnuOpticalPowerAdmin));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3OnuOpticalPowerValue));
        prepareRead(getProperty(utsDot3OnuOpticalPowerAdmin));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuPowerMeasureMBean bean = (OnuPowerMeasureMBean) v.get(i);
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3OnuOpticalPowerModuleId()).append("/").append(bean.getUtsDot3OnuOpticalPowerPortId()).append("/").append(bean.getUtsDot3OnuOpticalPowerLogicalPortId()).toString();
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
        prepareSave(getProperty(utsDot3OnuOpticalPowerAdmin));

        return save();
    }

}