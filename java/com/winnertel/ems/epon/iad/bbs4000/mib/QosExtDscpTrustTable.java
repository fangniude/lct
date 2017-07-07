package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class QosExtDscpTrustTable extends SnmpMibBean {

    public static final String utsMLSQosExtDscpTrustIntfIndex = "utsMLSQosExtDscpTrustIntfIndex";
    public static final String utsMLSQosExtDscpTrustModuleId = "utsMLSQosExtDscpTrustModuleId";
    public static final String utsMLSQosExtDscpTrustPortId = "utsMLSQosExtDscpTrustPortId";
    public static final String utsMLSQosExtDscpTrustLagPortId = "utsMLSQosExtDscpTrustLagPortId";
    public static final String utsMLSQosExtDscpTrustMode = "utsMLSQosExtDscpTrustMode";
    public static final String utsMLSQosExtDscpTrustIntfQosCtrl = "utsMLSQosExtDscpTrustIntfQosCtrl";

    public QosExtDscpTrustTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsMLSQosExtDscpTrustIntfIndex, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustIntfIndex, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.1", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtDscpTrustModuleId, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustModuleId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.2", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtDscpTrustPortId, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustPortId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.3", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtDscpTrustLagPortId, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustLagPortId, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.4", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtDscpTrustMode, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustMode, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.5", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtDscpTrustIntfQosCtrl, new SnmpMibBeanProperty(utsMLSQosExtDscpTrustIntfQosCtrl, ".1.3.6.1.4.1.41355.1800.2.4.1.1.6.1.6", ISnmpConstant.INTEGER));
    }

    public Integer getUtsMLSQosExtDscpTrustIntfIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsMLSQosExtDscpTrustIntfIndex(Integer aUtsMLSQosExtDscpTrustIntfIndex) {
        setIndex(0, aUtsMLSQosExtDscpTrustIntfIndex);
    }

    public Integer getUtsMLSQosExtDscpTrustModuleId() {
        return (Integer) getProperty(utsMLSQosExtDscpTrustModuleId).getValue();
    }

    public void setUtsMLSQosExtDscpTrustModuleId(Integer aUtsMLSQosExtDscpTrustModuleId) {
        getProperty(utsMLSQosExtDscpTrustModuleId).setValue(aUtsMLSQosExtDscpTrustModuleId);
    }

    public Integer getUtsMLSQosExtDscpTrustPortId() {
        return (Integer) getProperty(utsMLSQosExtDscpTrustPortId).getValue();
    }

    public void setUtsMLSQosExtDscpTrustPortId(Integer aUtsMLSQosExtDscpTrustPortId) {
        getProperty(utsMLSQosExtDscpTrustPortId).setValue(aUtsMLSQosExtDscpTrustPortId);
    }

    public Integer getUtsMLSQosExtDscpTrustLagPortId() {
        return (Integer) getProperty(utsMLSQosExtDscpTrustLagPortId).getValue();
    }

    public void setUtsMLSQosExtDscpTrustLagPortId(Integer aUtsMLSQosExtDscpTrustLagPortId) {
        getProperty(utsMLSQosExtDscpTrustLagPortId).setValue(aUtsMLSQosExtDscpTrustLagPortId);
    }

    public Integer getUtsMLSQosExtDscpTrustMode() {
        return (Integer) getProperty(utsMLSQosExtDscpTrustMode).getValue();
    }

    public void setUtsMLSQosExtDscpTrustMode(Integer aUtsMLSQosExtDscpTrustMode) {
        getProperty(utsMLSQosExtDscpTrustMode).setValue(aUtsMLSQosExtDscpTrustMode);
    }

    public Integer getUtsMLSQosExtDscpTrustIntfQosCtrl() {
        return (Integer) getProperty(utsMLSQosExtDscpTrustIntfQosCtrl).getValue();
    }

    public void setUtsMLSQosExtDscpTrustIntfQosCtrl(Integer aUtsMLSQosExtDscpTrustIntfQosCtrl) {
        getProperty(utsMLSQosExtDscpTrustIntfQosCtrl).setValue(aUtsMLSQosExtDscpTrustIntfQosCtrl);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsMLSQosExtDscpTrustModuleId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustPortId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustLagPortId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustMode));
        prepareRead(getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

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

        prepareRead(getProperty(utsMLSQosExtDscpTrustModuleId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustPortId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustLagPortId));
        prepareRead(getProperty(utsMLSQosExtDscpTrustMode));
        prepareRead(getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

        v = loadAll(new int[]{1});

        //added by Zhou Chao, 2011/1/27 -- begin
        int i = 0;
        while (i < v.size()) {
            String portName = ((QosExtDscpTrustTable) v.get(i)).getUtsMLSQosExtDscpTrustModuleId() + "/" + ((QosExtDscpTrustTable) v.get(i)).getUtsMLSQosExtDscpTrustPortId();
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
        prepareSave(getProperty(utsMLSQosExtDscpTrustMode));
        prepareSave(getProperty(utsMLSQosExtDscpTrustIntfQosCtrl));

        return save();
    }

}