/**
 * Created by Zhou Chao, 2010/4/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r220;

import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class IntfRateControlTable extends SnmpMibBean {

    public static final String ifIndex = "ifIndex";

    public static final String utsIntfRateControlModuleId = "utsIntfRateControlModuleId";
    public static final String utsIntfRateControlPortId = "utsIntfRateControlPortId";
    public static final String utsIntfRateControlMcastEnable = "utsIntfRateControlMcastEnable";
    public static final String utsIntfRateControlMcastLimit = "utsIntfRateControlMcastLimit";
    public static final String utsIntfRateControlBcastEnable = "utsIntfRateControlBcastEnable";
    public static final String utsIntfRateControlBcastLimit = "utsIntfRateControlBcastLimit";
    public static final String utsIntfRateControlUnicastEnable = "utsIntfRateControlUnicastEnable";
    public static final String utsIntfRateControlUnicastLimit = "utsIntfRateControlUnicastLimit";
    public static final String utsIntfRateLimitIngressBandwidth = "utsIntfRateLimitIngressBandwidth";
    public static final String utsIntfRateLimitEgressBandwidth = "utsIntfRateLimitEgressBandwidth";
    //public static final String utsIntfRateControlMaxFrameSize = "utsIntfRateControlMaxFrameSize";
    public static final String utsIntfRateControlIsolationCtrl = "utsIntfRateControlIsolationCtrl";
    public static final String utsIntfRateControlUplinkSpeed = "utsIntfRateControlUplinkSpeed";
    public static final String utsIntfRateControlVlanIngressFilter = "utsIntfRateControlVlanIngressFilter";
    public static final String utsIntfRateControlUplinkTranceiverType = "utsIntfRateControlUplinkTranceiverType";
    public static final String utsIntfRateControlAutoNegotiation = "utsIntfRateControlAutoNegotiation";
    public static final String utsIntfRateLimitIngressBurstSize = "utsIntfRateLimitIngressBurstSize";
    public static final String utsIntfRateLimitEgressBurstSize = "utsIntfRateLimitEgressBurstSize";
    public static final String utsIntfRateControlUplinkDuplexStatus = "utsIntfRateControlUplinkDuplexStatus";
    //public static final String utsIntfSfpType = "utsIntfSfpType";
    public static final String utsIntfRateControlUplinkPortMode = "utsIntfRateControlUplinkPortMode";

    public IntfRateControlTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex, ".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

        initProperty(utsIntfRateControlModuleId, new SnmpMibBeanProperty(utsIntfRateControlModuleId, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlPortId, new SnmpMibBeanProperty(utsIntfRateControlPortId, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlMcastEnable, new SnmpMibBeanProperty(utsIntfRateControlMcastEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlMcastLimit, new SnmpMibBeanProperty(utsIntfRateControlMcastLimit, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlBcastEnable, new SnmpMibBeanProperty(utsIntfRateControlBcastEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlBcastLimit, new SnmpMibBeanProperty(utsIntfRateControlBcastLimit, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUnicastEnable, new SnmpMibBeanProperty(utsIntfRateControlUnicastEnable, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.7", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUnicastLimit, new SnmpMibBeanProperty(utsIntfRateControlUnicastLimit, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.8", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateLimitIngressBandwidth, new SnmpMibBeanProperty(utsIntfRateLimitIngressBandwidth, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.9", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateLimitEgressBandwidth, new SnmpMibBeanProperty(utsIntfRateLimitEgressBandwidth, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.10", ISnmpConstant.INTEGER));
        //initProperty(utsIntfRateControlMaxFrameSize, new SnmpMibBeanProperty(utsIntfRateControlMaxFrameSize, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.11", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlIsolationCtrl, new SnmpMibBeanProperty(utsIntfRateControlIsolationCtrl, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.12", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUplinkSpeed, new SnmpMibBeanProperty(utsIntfRateControlUplinkSpeed, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.13", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlVlanIngressFilter, new SnmpMibBeanProperty(utsIntfRateControlVlanIngressFilter, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.14", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUplinkTranceiverType, new SnmpMibBeanProperty(utsIntfRateControlUplinkTranceiverType, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.15", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlAutoNegotiation, new SnmpMibBeanProperty(utsIntfRateControlAutoNegotiation, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.16", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateLimitIngressBurstSize, new SnmpMibBeanProperty(utsIntfRateLimitIngressBurstSize, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.17", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateLimitEgressBurstSize, new SnmpMibBeanProperty(utsIntfRateLimitEgressBurstSize, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.18", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUplinkDuplexStatus, new SnmpMibBeanProperty(utsIntfRateControlUplinkDuplexStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.19", ISnmpConstant.INTEGER));
        //initProperty(utsIntfSfpType, new SnmpMibBeanProperty(utsIntfSfpType, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.20", ISnmpConstant.INTEGER));
        initProperty(utsIntfRateControlUplinkPortMode, new SnmpMibBeanProperty(utsIntfRateControlUplinkPortMode, ".1.3.6.1.4.1.45121.1800.2.2.1.5.3.1.1.20", ISnmpConstant.INTEGER));
    }

    public Integer getIfIndex() {
        return ConfigUtility.generateIfIndex(getIndex(0) + "/" + getIndex(1));
    }

    public void setIfIndex(Integer aIfIndex) {
        String index = ConfigUtility.formatIfIndex(aIfIndex.toString());
        setIndex(0, new Integer(index.substring(0, index.indexOf("/"))));
        setIndex(1, new Integer(index.substring(index.indexOf("/") + 1, index.length())));
    }

    public Integer getUtsIntfRateControlModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsIntfRateControlModuleId(Integer aUtsIntfRateControlModuleId) {
        setIndex(0, aUtsIntfRateControlModuleId);
    }

    public Integer getUtsIntfRateControlPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsIntfRateControlPortId(Integer aUtsIntfRateControlPortId) {
        setIndex(1, aUtsIntfRateControlPortId);
    }

    public Integer getUtsIntfRateControlMcastEnable() {
        return (Integer) getProperty(utsIntfRateControlMcastEnable).getValue();
    }

    public void setUtsIntfRateControlMcastEnable(Integer aUtsIntfRateControlMcastEnable) {
        getProperty(utsIntfRateControlMcastEnable).setValue(aUtsIntfRateControlMcastEnable);
    }

    public Integer getUtsIntfRateControlMcastLimit() {
        return (Integer) getProperty(utsIntfRateControlMcastLimit).getValue();
    }

    public void setUtsIntfRateControlMcastLimit(Integer aUtsIntfRateControlMcastLimit) {
        getProperty(utsIntfRateControlMcastLimit).setValue(aUtsIntfRateControlMcastLimit);
    }

    public Integer getUtsIntfRateControlBcastEnable() {
        return (Integer) getProperty(utsIntfRateControlBcastEnable).getValue();
    }

    public void setUtsIntfRateControlBcastEnable(Integer aUtsIntfRateControlBcastEnable) {
        getProperty(utsIntfRateControlBcastEnable).setValue(aUtsIntfRateControlBcastEnable);
    }

    public Integer getUtsIntfRateControlBcastLimit() {
        return (Integer) getProperty(utsIntfRateControlBcastLimit).getValue();
    }

    public void setUtsIntfRateControlBcastLimit(Integer aUtsIntfRateControlBcastLimit) {
        getProperty(utsIntfRateControlBcastLimit).setValue(aUtsIntfRateControlBcastLimit);
    }

    public Integer getUtsIntfRateControlUnicastEnable() {
        return (Integer) getProperty(utsIntfRateControlUnicastEnable).getValue();
    }

    public void setUtsIntfRateControlUnicastEnable(Integer aUtsIntfRateControlUnicastEnable) {
        getProperty(utsIntfRateControlUnicastEnable).setValue(aUtsIntfRateControlUnicastEnable);
    }

    public Integer getUtsIntfRateControlUnicastLimit() {
        return (Integer) getProperty(utsIntfRateControlUnicastLimit).getValue();
    }

    public void setUtsIntfRateControlUnicastLimit(Integer aUtsIntfRateControlUnicastLimit) {
        getProperty(utsIntfRateControlUnicastLimit).setValue(aUtsIntfRateControlUnicastLimit);
    }

    public Integer getUtsIntfRateLimitIngressBandwidth() {
        return (Integer) getProperty(utsIntfRateLimitIngressBandwidth).getValue();
    }

    public void setUtsIntfRateLimitIngressBandwidth(Integer aUtsIntfRateLimitIngressBandwidth) {
        getProperty(utsIntfRateLimitIngressBandwidth).setValue(aUtsIntfRateLimitIngressBandwidth);
    }

    public Integer getUtsIntfRateLimitEgressBandwidth() {
        return (Integer) getProperty(utsIntfRateLimitEgressBandwidth).getValue();
    }

    public void setUtsIntfRateLimitEgressBandwidth(Integer aUtsIntfRateLimitEgressBandwidth) {
        getProperty(utsIntfRateLimitEgressBandwidth).setValue(aUtsIntfRateLimitEgressBandwidth);
    }

    /*
    public Integer getUtsIntfRateControlMaxFrameSize() {
        return (Integer) getProperty(utsIntfRateControlMaxFrameSize).getValue();
    }

    public void setUtsIntfRateControlMaxFrameSize(Integer aUtsIntfRateControlMaxFrameSize) {
        getProperty(utsIntfRateControlMaxFrameSize).setValue(aUtsIntfRateControlMaxFrameSize);
    }
    */

    public Integer getUtsIntfRateControlIsolationCtrl() {
        return (Integer) getProperty(utsIntfRateControlIsolationCtrl).getValue();
    }

    public void setUtsIntfRateControlIsolationCtrl(Integer aUtsIntfRateControlIsolationCtrl) {
        getProperty(utsIntfRateControlIsolationCtrl).setValue(aUtsIntfRateControlIsolationCtrl);
    }

    public Integer getUtsIntfRateControlUplinkSpeed() {
        return (Integer) getProperty(utsIntfRateControlUplinkSpeed).getValue();
    }

    public void setUtsIntfRateControlUplinkSpeed(Integer aUtsIntfRateControlUplinkSpeed) {
        getProperty(utsIntfRateControlUplinkSpeed).setValue(aUtsIntfRateControlUplinkSpeed);
    }

    public Integer getUtsIntfRateControlVlanIngressFilter() {
        return (Integer) getProperty(utsIntfRateControlVlanIngressFilter).getValue();
    }

    public void setUtsIntfRateControlVlanIngressFilter(Integer aUtsIntfRateControlVlanIngressFilter) {
        getProperty(utsIntfRateControlVlanIngressFilter).setValue(aUtsIntfRateControlVlanIngressFilter);
    }

    public Integer getUtsIntfRateControlUplinkTranceiverType() {
        return (Integer) getProperty(utsIntfRateControlUplinkTranceiverType).getValue();
    }

    public void setUtsIntfRateControlUplinkTranceiverType(Integer aUtsIntfRateControlUplinkTranceiverType) {
        getProperty(utsIntfRateControlUplinkTranceiverType).setValue(aUtsIntfRateControlUplinkTranceiverType);
    }

    public Integer getUtsIntfRateControlAutoNegotiation() {
        return (Integer) getProperty(utsIntfRateControlAutoNegotiation).getValue();
    }

    public void setUtsIntfRateControlAutoNegotiation(Integer aUtsIntfRateControlAutoNegotiation) {
        getProperty(utsIntfRateControlAutoNegotiation).setValue(aUtsIntfRateControlAutoNegotiation);
    }

    public Integer getUtsIntfRateLimitIngressBurstSize() {
        return (Integer) getProperty(utsIntfRateLimitIngressBurstSize).getValue();
    }

    public void setUtsIntfRateLimitIngressBurstSize(Integer aUtsIntfRateLimitIngressBurstSize) {
        getProperty(utsIntfRateLimitIngressBurstSize).setValue(aUtsIntfRateLimitIngressBurstSize);
    }

    public Integer getUtsIntfRateLimitEgressBurstSize() {
        return (Integer) getProperty(utsIntfRateLimitEgressBurstSize).getValue();
    }

    public void setUtsIntfRateLimitEgressBurstSize(Integer aUtsIntfRateLimitEgressBurstSize) {
        getProperty(utsIntfRateLimitEgressBurstSize).setValue(aUtsIntfRateLimitEgressBurstSize);
    }

    public Integer getUtsIntfRateControlUplinkDuplexStatus() {
        return (Integer) getProperty(utsIntfRateControlUplinkDuplexStatus).getValue();
    }

    public void setUtsIntfRateControlUplinkDuplexStatus(Integer aUtsIntfRateControlUplinkDuplexStatus) {
        getProperty(utsIntfRateControlUplinkDuplexStatus).setValue(aUtsIntfRateControlUplinkDuplexStatus);
    }

    /*
    public Integer getUtsIntfSfpType() {
        return (Integer) getProperty(utsIntfSfpType).getValue();
    }

    public void setUtsIntfSfpType(Integer aUtsIntfSfpType) {
        getProperty(utsIntfSfpType).setValue(aUtsIntfSfpType);
    }
    */

    public Integer getUtsIntfRateControlUplinkPortMode() {
        return (Integer) getProperty(utsIntfRateControlUplinkPortMode).getValue();
    }

    public void setUtsIntfRateControlUplinkPortMode(Integer aUtsIntfRateControlUplinkPortMode) {
        getProperty(utsIntfRateControlUplinkPortMode).setValue(aUtsIntfRateControlUplinkPortMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsIntfRateControlMcastEnable));
        prepareRead(getProperty(utsIntfRateControlMcastLimit));
        prepareRead(getProperty(utsIntfRateControlBcastEnable));
        prepareRead(getProperty(utsIntfRateControlBcastLimit));
        prepareRead(getProperty(utsIntfRateControlUnicastEnable));
        prepareRead(getProperty(utsIntfRateControlUnicastLimit));
        prepareRead(getProperty(utsIntfRateLimitIngressBandwidth));
        prepareRead(getProperty(utsIntfRateLimitEgressBandwidth));
        //prepareRead(getProperty(utsIntfRateControlMaxFrameSize));
        prepareRead(getProperty(utsIntfRateControlIsolationCtrl));
        prepareRead(getProperty(utsIntfRateControlUplinkSpeed));
        prepareRead(getProperty(utsIntfRateControlVlanIngressFilter));
        prepareRead(getProperty(utsIntfRateControlUplinkTranceiverType));
        prepareRead(getProperty(utsIntfRateControlAutoNegotiation));
        prepareRead(getProperty(utsIntfRateLimitIngressBurstSize));
        prepareRead(getProperty(utsIntfRateLimitEgressBurstSize));
        prepareRead(getProperty(utsIntfRateControlUplinkDuplexStatus));
        //prepareRead(getProperty(utsIntfSfpType));
        prepareRead(getProperty(utsIntfRateControlUplinkPortMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
/*
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
*/

        Vector v = null;

        prepareRead(getProperty(utsIntfRateControlMcastEnable));
        prepareRead(getProperty(utsIntfRateControlMcastLimit));
        prepareRead(getProperty(utsIntfRateControlBcastEnable));
        prepareRead(getProperty(utsIntfRateControlBcastLimit));
        prepareRead(getProperty(utsIntfRateControlUnicastEnable));
        prepareRead(getProperty(utsIntfRateControlUnicastLimit));
        prepareRead(getProperty(utsIntfRateLimitIngressBandwidth));
        prepareRead(getProperty(utsIntfRateLimitEgressBandwidth));
        //prepareRead(getProperty(utsIntfRateControlMaxFrameSize));
        prepareRead(getProperty(utsIntfRateControlIsolationCtrl));
        prepareRead(getProperty(utsIntfRateControlUplinkSpeed));
        prepareRead(getProperty(utsIntfRateControlVlanIngressFilter));
        prepareRead(getProperty(utsIntfRateControlUplinkTranceiverType));
        prepareRead(getProperty(utsIntfRateControlAutoNegotiation));
        prepareRead(getProperty(utsIntfRateLimitIngressBurstSize));
        prepareRead(getProperty(utsIntfRateLimitEgressBurstSize));
        prepareRead(getProperty(utsIntfRateControlUplinkDuplexStatus));
        //prepareRead(getProperty(utsIntfSfpType));
        prepareRead(getProperty(utsIntfRateControlUplinkPortMode));

        v = loadAll(new int[]{1, 1});
        //v = loadAll2(new int[]{1, 1});

/*
        //added by Zhou Chao, 2011/1/27 -- begin
        for (int i = v.size() - 1; i >= 0; i--) {
            if (!checkIfIndex(((IntfRateControlTable) v.get(i)).getIfIndex(), invalidPorts))
                v.remove(i);
        }
        //added by Zhou Chao, 2011/1/27 -- end
*/

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsIntfRateControlMcastEnable));
        prepareSave(getProperty(utsIntfRateControlMcastLimit));
        prepareSave(getProperty(utsIntfRateControlBcastEnable));
        prepareSave(getProperty(utsIntfRateControlBcastLimit));
        prepareSave(getProperty(utsIntfRateControlUnicastEnable));
        prepareSave(getProperty(utsIntfRateControlUnicastLimit));
        prepareSave(getProperty(utsIntfRateLimitIngressBandwidth));
        prepareSave(getProperty(utsIntfRateLimitEgressBandwidth));
        //prepareSave(getProperty(utsIntfRateControlMaxFrameSize));
        prepareSave(getProperty(utsIntfRateControlUplinkSpeed));
        prepareSave(getProperty(utsIntfRateControlVlanIngressFilter));
        prepareSave(getProperty(utsIntfRateLimitIngressBurstSize));
        prepareSave(getProperty(utsIntfRateLimitEgressBurstSize));
        prepareSave(getProperty(utsIntfRateControlAutoNegotiation));
        prepareSave(getProperty(utsIntfRateControlUplinkDuplexStatus));
        //prepareSave(getProperty(utsIntfSfpType));
        prepareSave(getProperty(utsIntfRateControlUplinkPortMode));

        return save();
    }

/*
    //added by Zhou Chao, 2011/1/27
    public boolean checkIfIndex(Integer i, Vector invalidPorts) {
        // bits 28-27, 00 - L2, 01 - L3 VLAN, 10/11 - reserved.
        int highBits = i >>> 27;

        if (highBits == 0) {
            // this interface is a port or link aggregation.
            int bits = 67108864; // bit 26
            int bitsAnd = i & bits;
            if (bitsAnd != 0) {
                // this is a link aggregation interface.
                bits = 133693440; // bits 26-19
                bitsAnd = i & bits;
                int groupId = (bitsAnd >>> 19) - 128;
                //returnStr = "lg" + groupId;
                return true;
            } else {
                int delta = 1023; // 0-9
                int logicalPort = i & delta;

                i >>= 10;
                delta = 31; // 10-14
                int port = i & delta;

                i >>= 5;
                delta = 15;
                int module = i & delta; //15-18
                if (logicalPort == 0) {
                    String returnStr = module + "/" + port;
                    int t = invalidPorts.indexOf(returnStr);
                    if (t >= 0)
                        return false;
                } else {
                    //returnStr = module + "/" + port + "/" + logicalPort;
                    return false;
                }
            }
        } else if (highBits == 1) {
            // this interface is a VLAN.
            int bits = 134184960; // bits 26-15
            int bitsAnd = i & bits;
            int vlanId = bitsAnd >>> 15;
            //returnStr = "vlan" + vlanId;
            return true;
        } else if ((highBits == 2) || (highBits == 3)) {
            // reserved for future use.
            //returnStr = "unknown";
            return false;
        }

        return true;
    }
*/

}