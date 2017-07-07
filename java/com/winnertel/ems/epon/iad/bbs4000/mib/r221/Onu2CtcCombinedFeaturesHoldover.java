/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Onu2CtcCombinedFeaturesHoldover extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcHoldoverAction = "utsDot3Onu2CtcHoldoverAction";
    public static final String utsDot3Onu2CtcHoldoverTime = "utsDot3Onu2CtcHoldoverTime";
    public static final String utsDot3Onu2CtcActivePonifAdminActivePon = "utsDot3Onu2CtcActivePonifAdminActivePon";
    //public static final String utsDot3Onu2CtcTftpOamCommit = "utsDot3Onu2CtcTftpOamCommit";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCombinedFeaturesHoldover(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.7", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.8", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.9", ISnmpConstant.INTEGER));
        //initProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesModuleId(Integer aUtsDot3Onu2CtcCombinedFeaturesModuleId) {
        setIndex(0, aUtsDot3Onu2CtcCombinedFeaturesModuleId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesDeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesDeviceId(Integer aUtsDot3Onu2CtcCombinedFeaturesDeviceId) {
        setIndex(1, aUtsDot3Onu2CtcCombinedFeaturesDeviceId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesPortId() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesPortId) {
        setIndex(2, aUtsDot3Onu2CtcCombinedFeaturesPortId);
    }

    public Integer getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId() {
        return (Integer) getIndex(3);
    }

    public void setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId) {
        setIndex(3, aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
    }

    public Integer getUtsDot3Onu2CtcHoldoverAction() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction).getValue();
    }

    public void setUtsDot3Onu2CtcHoldoverAction(Integer aUtsDot3Onu2CtcHoldoverAction) {
        getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction).setValue(aUtsDot3Onu2CtcHoldoverAction);
    }

    public Integer getUtsDot3Onu2CtcHoldoverTime() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime).getValue();
    }

    public void setUtsDot3Onu2CtcHoldoverTime(Integer aUtsDot3Onu2CtcHoldoverTime) {
        getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime).setValue(aUtsDot3Onu2CtcHoldoverTime);
    }

    public Integer getUtsDot3Onu2CtcActivePonifAdminActivePon() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon).getValue();
    }

    public void setUtsDot3Onu2CtcActivePonifAdminActivePon(Integer aUtsDot3Onu2CtcActivePonifAdminActivePon) {
        getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon).setValue(aUtsDot3Onu2CtcActivePonifAdminActivePon);
    }

    //public Integer getUtsDot3Onu2CtcTftpOamCommit() {
    //    return (Integer) getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit).getValue();
    //}
    //
    //public void setUtsDot3Onu2CtcTftpOamCommit(Integer aUtsDot3Onu2CtcTftpOamCommit) {
    //    getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit).setValue(aUtsDot3Onu2CtcTftpOamCommit);
    //}

    //added by Zhouchao, 2011/8/26
    public String getOnuLabel() {
        return onuLabel;
    }

    //added by Zhouchao, 2011/8/26
    public void setOnuLabel(String label) {
        onuLabel = label;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon));
        //prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon));
        //prepareRead(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcCombinedFeaturesHoldover bean = (Onu2CtcCombinedFeaturesHoldover) v.get(i);
//                    //find the onu by module/port/logicalid
//                    String key = new StringBuilder(neName).append(bean.getUtsDot3Onu2CtcCombinedFeaturesModuleId()).append("/").append(bean.getUtsDot3Onu2CtcCombinedFeaturesPortId()).append("/").append(bean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId()).toString();
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
        prepareSave(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverAction));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcHoldoverTime));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcActivePonifAdminActivePon));
        //prepareSave(getProperty(Onu2CtcCombinedFeaturesHoldover.utsDot3Onu2CtcTftpOamCommit));

        return save();
    }

}