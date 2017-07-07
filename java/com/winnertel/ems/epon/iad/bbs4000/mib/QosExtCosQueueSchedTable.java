package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class QosExtCosQueueSchedTable extends SnmpMibBean {

    public static final String utsMLSQosExtCosQueueSchedIntfIndex = "utsMLSQosExtCosQueueSchedIntfIndex";
    public static final String utsMLSQosExtCosQueueSchedModuleId = "utsMLSQosExtCosQueueSchedModuleId";
    public static final String utsMLSQosExtCosQueueSchedPortId = "utsMLSQosExtCosQueueSchedPortId";
    public static final String utsMLSQosExtCosQueueSchedLagPortId = "utsMLSQosExtCosQueueSchedLagPortId";
    public static final String utsMLSQosExtCosQueueSchedQueueNum = "utsMLSQosExtCosQueueSchedQueueNum";
    public static final String utsMLSQosExtCosQueueSchedWeight = "utsMLSQosExtCosQueueSchedWeight";
    public static final String utsMLSQosExtCosQueueSchedMode = "utsMLSQosExtCosQueueSchedMode";

    ISnmpProxy proxy;

    public QosExtCosQueueSchedTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        proxy = aSnmpProxy;
        init();
    }

    protected void init() {
        initProperty(utsMLSQosExtCosQueueSchedIntfIndex, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedIntfIndex, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedModuleId, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedModuleId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.2", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedPortId, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedPortId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.3", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedLagPortId, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedLagPortId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.4", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedQueueNum, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedQueueNum, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.5", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedWeight, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedWeight, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.6", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueSchedMode, new SnmpMibBeanProperty(utsMLSQosExtCosQueueSchedMode, ".1.3.6.1.4.1.41355.1800.2.4.1.1.2.1.7", ISnmpConstant.INTEGER));
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
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedModuleId).getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedModuleId(Integer aUtsMLSQosExtCosQueueSchedModuleId) {
        getProperty(utsMLSQosExtCosQueueSchedModuleId).setValue(aUtsMLSQosExtCosQueueSchedModuleId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedPortId() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedPortId).getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedPortId(Integer aUtsMLSQosExtCosQueueSchedPortId) {
        getProperty(utsMLSQosExtCosQueueSchedPortId).setValue(aUtsMLSQosExtCosQueueSchedPortId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedLagPortId() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedLagPortId).getValue();
    }

    public void setUtsMLSQosExtCosQueueSchedLagPortId(Integer aUtsMLSQosExtCosQueueSchedLagPortId) {
        getProperty(utsMLSQosExtCosQueueSchedLagPortId).setValue(aUtsMLSQosExtCosQueueSchedLagPortId);
    }

    public Integer getUtsMLSQosExtCosQueueSchedWeight() {
        return (Integer) getProperty(utsMLSQosExtCosQueueSchedWeight).getValue();
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
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedModuleId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedPortId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedLagPortId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedWeight));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        //added by Zhouchao, 2011/1/27 -- begin
        Vector invalidPorts = new Vector();

        EthIfExtTable portMBean = new EthIfExtTable(fSnmpProxy);
        Vector portVec = portMBean.retrieveRealAll();
        // remove layer-3 ports and add vlan IDs
        for (int n = 0; n < portVec.size(); n++) {
            EthIfExtTable tmpL2PortTbl = (EthIfExtTable) portVec.elementAt(n);
            String portName = tmpL2PortTbl.getUtsEthIfExtModuleId() + "/" + tmpL2PortTbl.getUtsEthIfExtPortId();
            int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType();
            int switchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode();
            if (tmpPortType == 1) {
                // remove layer-3 ports
                if (switchMode == 2) {
                    invalidPorts.add(portName);
                }
            }
        }

        // remove L2 port that in Link Aggregation set
        LinkAggregation lgMBean = new LinkAggregation(fSnmpProxy);
        Vector lgVec = lgMBean.retrieveAll();
        if (lgVec == null)
            lgVec = new Vector(0);
        for (int m = 0; m < lgVec.size(); m++) {
            LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(m);
            String[] ports = com.winnertel.ems.epon.iad.bbs4000.ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
            for (int t = 0; t < ports.length; t++) {
                invalidPorts.add(ports[t]);
            }
        }
        //added by Zhouchao, 2011/1/27 -- end

        Vector v = null;

        prepareRead(getProperty(utsMLSQosExtCosQueueSchedModuleId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedPortId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedLagPortId));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedWeight));
        prepareRead(getProperty(utsMLSQosExtCosQueueSchedMode));

        v = loadAll(new int[]{1, 1});

        //added by Zhou Chao, 2011/1/27 -- begin
        int i = 0;
        while (i < v.size()) {
            String portName = ((QosExtCosQueueSchedTable) v.get(i)).getUtsMLSQosExtCosQueueSchedModuleId() + "/" + ((QosExtCosQueueSchedTable) v.get(i)).getUtsMLSQosExtCosQueueSchedPortId();
            if (invalidPorts.indexOf(portName) >= 0) {
                v.remove(i);
            } else {
                i++;
            }
        }
        //added by Zhou Chao, 2011/1/27 -- end

        return v;
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
                QosExtCosQueueSchedTable one = (QosExtCosQueueSchedTable) v.get(i);
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