/**
 * Created by Zhou Chao, 2009/7/29
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuConfigWoOamTable extends SnmpMibBean {

    public static final String utsOnuSlotId = "utsOnuSlotId";
    public static final String utsOnuPortId = "utsOnuPortId";
    public static final String utsOnuLogicalPortId = "utsOnuLogicalPortId";
    public static final String utsOnuCtcExtOamEnable = "utsOnuCtcExtOamEnable";
    public static final String utsOnuDescription = "utsOnuDescription";
    public static final String utsOnuAdminStatus = "utsOnuAdminStatus";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public OnuConfigWoOamTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsOnuSlotId, new SnmpMibBeanProperty(utsOnuSlotId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsOnuPortId, new SnmpMibBeanProperty(utsOnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsOnuLogicalPortId, new SnmpMibBeanProperty(utsOnuLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsOnuCtcExtOamEnable, new SnmpMibBeanProperty(utsOnuCtcExtOamEnable, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.1", ISnmpConstant.INTEGER));
        initProperty(utsOnuDescription, new SnmpMibBeanProperty(utsOnuDescription, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.2", ISnmpConstant.STRING));
        initProperty(utsOnuAdminStatus, new SnmpMibBeanProperty(utsOnuAdminStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.4.3.1.32", ISnmpConstant.INTEGER));
    }

    public Integer getUtsOnuSlotId() {
        return (Integer) getIndex(0);
    }

    public void setUtsOnuSlotId(Integer aUtsOnuSlotId) {
        setIndex(0, aUtsOnuSlotId);
    }

    public Integer getUtsOnuPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsOnuPortId(Integer aUtsOnuPortId) {
        setIndex(1, aUtsOnuPortId);
    }

    public Integer getUtsOnuLogicalPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsOnuLogicalPortId(Integer aUtsOnuLogicalPortId) {
        setIndex(2, aUtsOnuLogicalPortId);
    }

    public Integer getUtsOnuCtcExtOamEnable() {
        return (Integer) getProperty(utsOnuCtcExtOamEnable).getValue();
    }

    public void setUtsOnuCtcExtOamEnable(Integer aUtsOnuCtcExtOamEnable) {
        getProperty(utsOnuCtcExtOamEnable).setValue(aUtsOnuCtcExtOamEnable);
    }

    public String getUtsOnuDescription() {
        return (String) getProperty(utsOnuDescription).getValue();
    }

    public void setUtsOnuDescription(String aUtsOnuDescription) {
        getProperty(utsOnuDescription).setValue(aUtsOnuDescription);
    }

    public Integer getUtsOnuAdminStatus() {
        return (Integer) getProperty(utsOnuAdminStatus).getValue();
    }

    public void setUtsOnuAdminStatus(Integer aUtsOnuAdminStatus) {
        getProperty(utsOnuAdminStatus).setValue(aUtsOnuAdminStatus);
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
        prepareRead(getProperty(utsOnuCtcExtOamEnable));
        prepareRead(getProperty(utsOnuDescription));
        prepareRead(getProperty(utsOnuAdminStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsOnuCtcExtOamEnable));
        prepareRead(getProperty(utsOnuDescription));
        prepareRead(getProperty(utsOnuAdminStatus));

        Vector v = loadAll(new int[]{1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    OnuConfigWoOamTable bean = (OnuConfigWoOamTable) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsOnuSlotId()).append("/").append(bean.getUtsOnuPortId()).append("/").append(bean.getUtsOnuLogicalPortId()).toString();
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
        prepareSave(getProperty(utsOnuCtcExtOamEnable));
        prepareSave(getProperty(utsOnuDescription));
        prepareSave(getProperty(utsOnuAdminStatus));

        return save();
    }

    public String toString() {
        return (new StringBuffer().append(getUtsOnuSlotId()).append("-").append(getUtsOnuPortId()).append("-").append(getUtsOnuLogicalPortId()).toString());
    }

}