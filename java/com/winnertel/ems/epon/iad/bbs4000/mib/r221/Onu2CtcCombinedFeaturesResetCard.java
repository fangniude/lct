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

public class Onu2CtcCombinedFeaturesResetCard extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcMduResetCardCardNumber = "utsDot3Onu2CtcMduResetCardCardNumber";
    public static final String utsDot3Onu2CtcMduResetCardReset = "utsDot3Onu2CtcMduResetCardReset";

    private String onuLabel = null; //added by Zhouchao, 2011/8/26

    public Onu2CtcCombinedFeaturesResetCard(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.5", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.6", ISnmpConstant.INTEGER));
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

    public Integer getUtsDot3Onu2CtcMduResetCardCardNumber() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber).getValue();
    }

    public void setUtsDot3Onu2CtcMduResetCardCardNumber(Integer aUtsDot3Onu2CtcMduResetCardCardNumber) {
        getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber).setValue(aUtsDot3Onu2CtcMduResetCardCardNumber);
    }

    public Integer getUtsDot3Onu2CtcMduResetCardReset() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset).getValue();
    }

    public void setUtsDot3Onu2CtcMduResetCardReset(Integer aUtsDot3Onu2CtcMduResetCardReset) {
        getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset).setValue(aUtsDot3Onu2CtcMduResetCardReset);
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
        prepareRead(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber));
        prepareRead(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset));

        Vector v = loadAll(new int[]{1, 1, 1, 1});

        //added by Zhouchao, 2011/8/26
//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//                Map map = onuMgmtMgr.getOnuLabelMap(neName);
//                for (int i = 0; i < v.size(); i++) {
//                    Onu2CtcCombinedFeaturesResetCard bean = (Onu2CtcCombinedFeaturesResetCard) v.get(i);
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
        prepareSave(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardCardNumber));
        prepareSave(getProperty(Onu2CtcCombinedFeaturesResetCard.utsDot3Onu2CtcMduResetCardReset));

        return save();
    }

}