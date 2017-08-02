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

public class Onu2CtcCombinedFeaturesIadOperation extends SnmpMibBean {

    public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
    public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
    public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
    public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";

    public static final String utsDot3Onu2CtcIadOperation = "utsDot3Onu2CtcIadOperation";

    public Onu2CtcCombinedFeaturesIadOperation(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.1", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.2", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.3", ISnmpConstant.INTEGER));
        initProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcCombinedFeaturesLogicalPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.4", ISnmpConstant.INTEGER));

        initProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation, new SnmpMibBeanProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.34.1.332", ISnmpConstant.INTEGER));
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

    public Integer getUtsDot3Onu2CtcIadOperation() {
        return (Integer) getProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation).getValue();
    }

    public void setUtsDot3Onu2CtcIadOperation(Integer aUtsDot3Onu2CtcIadOperation) {
        getProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation).setValue(aUtsDot3Onu2CtcIadOperation);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(Onu2CtcCombinedFeaturesIadOperation.utsDot3Onu2CtcIadOperation));

        return save();
    }

}