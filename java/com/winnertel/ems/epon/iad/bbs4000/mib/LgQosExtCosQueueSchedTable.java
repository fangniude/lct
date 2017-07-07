package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The QosExtCosQueueSchedTable class. Created by QuickDVM
 */
public class LgQosExtCosQueueSchedTable extends SnmpMibBean {
    public static final String utsMLSQosExtCosQueueSchedIntfIndex = "utsMLSQosExtCosQueueSchedIntfIndex";

    public static final String utsMLSQosExtCosQueueSchedModuleId = "utsMLSQosExtCosQueueSchedModuleId";

    public static final String utsMLSQosExtCosQueueSchedPortId = "utsMLSQosExtCosQueueSchedPortId";

    public static final String utsMLSQosExtCosQueueSchedLagPortId = "utsMLSQosExtCosQueueSchedLagPortId";

    public static final String utsMLSQosExtCosQueueSchedQueueNum = "utsMLSQosExtCosQueueSchedQueueNum";

    public static final String utsMLSQosExtCosQueueSchedWeight = "utsMLSQosExtCosQueueSchedWeight";

    public static final String utsMLSQosExtCosQueueSchedMode = "utsMLSQosExtCosQueueSchedMode";

    public LgQosExtCosQueueSchedTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsMLSQosExtCosQueueSchedIntfIndex,
                new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedIntfIndex,
                        ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.1",
                        ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedModuleId,
                new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedModuleId,
                        ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.2",
                        ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedPortId, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedPortId,
                ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedLagPortId,
                new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedLagPortId,
                        ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.4",
                        ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedQueueNum,
                new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedQueueNum,
                        ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.5",
                        ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedWeight, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedWeight,
                ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.6", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedMode, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedMode,
                ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.7", ISnmpConstant.INTEGER));

    }

    public Integer getUtsMLSQosExtCosQueueSchedIntfIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsMLSQosExtCosQueueSchedIntfIndex(Integer aUtsMLSQosExtCosQueueSchedIntfIndex) {

        setIndex(0, aUtsMLSQosExtCosQueueSchedIntfIndex);
    }

    public Integer getUtsMLSQosExtCosQueueSchedQueueNum() {
        return (Integer) getIndex(1);
    }

    public void setUtsMLSQosExtCosQueueSchedQueueNum(Integer aUtsMLSQosExtCosQueueSchedQueueNum) {
        setIndex(1, aUtsMLSQosExtCosQueueSchedQueueNum);
    }

    public Integer getUtsMLSQosExtCosQueueSchedModuleId() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedModuleId)
                .getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedModuleId(Integer aUtsMLSQosExtCosQueueSchedModuleId) {
        getProperty(utsMLSQosExtCosQueueSchedModuleId).setValue(aUtsMLSQosExtCosQueueSchedModuleId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedPortId() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedPortId)
                .getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedPortId(Integer aUtsMLSQosExtCosQueueSchedPortId) {
        getProperty(utsMLSQosExtCosQueueSchedPortId).setValue(aUtsMLSQosExtCosQueueSchedPortId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedLagPortId() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedLagPortId)
                .getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedLagPortId(Integer aUtsMLSQosExtCosQueueSchedLagPortId) {
        getProperty(utsMLSQosExtCosQueueSchedLagPortId).setValue(aUtsMLSQosExtCosQueueSchedLagPortId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedWeight() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedWeight)
                .getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedWeight(Integer aUtsMLSQosExtCosQueueSchedWeight) {
        getProperty(utsMLSQosExtCosQueueSchedWeight).setValue(aUtsMLSQosExtCosQueueSchedWeight);
    }

    public Integer getUtsMLSQosExtCosQueueSchedMode() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedMode).getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedMode(Integer aUtsMLSQosExtCosQueueSchedMode) {
        getProperty(utsMLSQosExtCosQueueSchedMode).setValue(aUtsMLSQosExtCosQueueSchedMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedModuleId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedPortId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedLagPortId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedWeight));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedModuleId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedPortId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedLagPortId));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedWeight));
        prepareRead(super.getProperty(utsMLSQosExtCosQueueSchedMode));

        setRowsToFetch(96);
        return loadAll(new int[]
        {1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsMLSQosExtCosQueueSchedWeight));
        prepareSave(getProperty(utsMLSQosExtCosQueueSchedMode));

        return save();
    }

    public boolean delete() throws MibBeanException {
        this.setIndex(0, "" + (getUtsMLSQosExtCosQueueSchedModuleId().intValue() - 1) * 4);
        this.setIndex(1, "7");

        Vector v = this.retrieveAll();
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                LgQosExtCosQueueSchedTable one = (LgQosExtCosQueueSchedTable) v.get(i);
                one.setUtsMLSQosExtCosQueueSchedMode(new Integer(4));
                int index = Integer.parseInt(one.getIndex(1).toString());
                index = (index + 1) * 2;
                if (index == 16) index = 0;
                one.setUtsMLSQosExtCosQueueSchedWeight(new Integer(index));
                one.prepareSave(one.getProperty(utsMLSQosExtCosQueueSchedMode));
                one.prepareSave(one.getProperty(utsMLSQosExtCosQueueSchedWeight));
                one.save();
            }
        }
        return true;
    }


}
