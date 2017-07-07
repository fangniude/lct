package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * @author Yang Yizai , 2009-2-25
 */
public class GponAclExtIntfConfigTable extends SnmpMibBean {

    private static final String utsGponAclExtIntfConfigIntfNum = "utsGponAclExtIntfConfigIntfNum";
    private static final String utsGponAclExtIntfConfigIntfModule = "utsGponAclExtIntfConfigIntfModule";
    private static final String utsGponAclExtIntfConfigIntfPort = "utsGponAclExtIntfConfigIntfPort";
    private static final String utsGponAclExtIntfConfigIntfLagGrpId = "utsGponAclExtIntfConfigIntfLagGrpId";
    private static final String utsGponAclExtIntfConfigIntfFilterType = "utsGponAclExtIntfConfigIntfFilterType";
    private static final String utsGponAclExtIntfConfigApplProfileId = "utsGponAclExtIntfConfigApplProfileId";
    private static final String utsGponAclExtIntfConfigFlowDirection = "utsGponAclExtIntfConfigFlowDirection";
    private static final String utsGponAclExtIntfConfigOnuId = "utsGponAclExtIntfConfigOnuId";
    private static final String utsGponAclExtIntfConfigVPId = "utsGponAclExtIntfConfigVPId";

    public GponAclExtIntfConfigTable(ISnmpProxy snmpProxy) {
        super(snmpProxy);
        init();
    }

    protected void init() {

        initProperty(utsGponAclExtIntfConfigIntfNum, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigIntfNum, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.201",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigIntfModule, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigIntfModule, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.216",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigIntfPort, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigIntfPort, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.221",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigIntfLagGrpId, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigIntfLagGrpId, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.226",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigIntfFilterType, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigIntfFilterType, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.231",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigApplProfileId, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigApplProfileId, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.236",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigFlowDirection, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigFlowDirection, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.241",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigOnuId, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigOnuId, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.206",
                ISnmpConstant.INTEGER));
        initProperty(utsGponAclExtIntfConfigVPId, new SnmpMibBeanProperty(
                utsGponAclExtIntfConfigVPId, ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.211",
                ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
                ".1.3.6.1.4.1.41355.1800.2.4.2.201.201.300", ISnmpConstant.INTEGER));
    }
    
    public String getUtsGponAclExtIntfConfigIntfNum() {
        int i = (Integer) getIndex(0);
        if (i < 48)
            return "" + ((i - 1) / 4 + 1 + "/" + ((i % 4 == 0) ? 4 : (i % 4)));
        else if (i == 5000)
            return "CPU Port";
        else {
            return "lg" + (i - 48);
        }
    }
    
    public void setUtsGponAclExtIntfConfigIntfNum(Integer aUtsGponAclExtIntfConfigIntfNum){
        setIndex(0,aUtsGponAclExtIntfConfigIntfNum);
    }
    
    public void setUtsGponAclExtIntfConfigOnuId (Integer aUtsGponAclExtIntfConfigOnuId ){
        setIndex(1,aUtsGponAclExtIntfConfigOnuId);
    }
    
    public Integer getUtsGponAclExtIntfConfigOnuId () {
        return (Integer) getIndex(1);
    }
    
    public Integer getUtsGponAclExtIntfConfigVPId() {
        return (Integer) getIndex(2);
    }
    
    public void setUtsGponAclExtIntfConfigVPId(Integer aUtsGponAclExtIntfConfigVPId){
        setIndex(2,aUtsGponAclExtIntfConfigVPId);
    }
    
    public Integer getUtsGponAclExtIntfConfigFlowDirection() {
        return (Integer) getIndex(3);
    }

    public void setUtsGponAclExtIntfConfigFlowDirection(Integer aUtsGponAclExtIntfConfigFlowDirection) {
        setIndex(3, aUtsGponAclExtIntfConfigFlowDirection);
    }
    
    public Integer getUtsGponAclExtIntfConfigIntfModule() {
        return (Integer) getProperty(utsGponAclExtIntfConfigIntfModule).getValue();
    }

    public void setUtsGponAclExtIntfConfigIntfModule(Integer aUtsGponAclExtIntfConfigIntfModule) {
        getProperty(utsGponAclExtIntfConfigIntfModule).setValue(aUtsGponAclExtIntfConfigIntfModule);
    }
    
    public Integer getUtsGponAclExtIntfConfigIntfPort() {
        return (Integer) getProperty(utsGponAclExtIntfConfigIntfPort).getValue();
    }

    public void setUtsGponAclExtIntfConfigIntfPort(Integer aUtsGponAclExtIntfConfigIntfPort) {
        getProperty(utsGponAclExtIntfConfigIntfPort).setValue(aUtsGponAclExtIntfConfigIntfPort);
    }
    
    public Integer getUtsGponAclExtIntfConfigIntfLagGrpId() {
        return (Integer) getProperty(utsGponAclExtIntfConfigIntfLagGrpId).getValue();
    }

    public void setUtsGponAclExtIntfConfigIntfLagGrpId(Integer aUtsGponAclExtIntfConfigIntfLagGrpId) {
        getProperty(utsGponAclExtIntfConfigIntfLagGrpId).setValue(aUtsGponAclExtIntfConfigIntfLagGrpId);
    }
    
    public Integer getUtsGponAclExtIntfConfigIntfFilterType() {
        return (Integer) getProperty(utsGponAclExtIntfConfigIntfFilterType).getValue();
    }

    public void setUtsGponAclExtIntfConfigIntfFilterType(Integer aUtsGponAclExtIntfConfigIntfFilterType) {
        getProperty(utsGponAclExtIntfConfigIntfFilterType).setValue(aUtsGponAclExtIntfConfigIntfFilterType);
    }
    
    public Integer getUtsGponAclExtIntfConfigApplProfileId() {
        return (Integer) getProperty(utsGponAclExtIntfConfigApplProfileId).getValue();
    }

    public void setUtsGponAclExtIntfConfigApplProfileId(Integer aUtsGponAclExtIntfConfigApplProfileId) {
        getProperty(utsGponAclExtIntfConfigApplProfileId).setValue(aUtsGponAclExtIntfConfigApplProfileId);
    }
    
//    public Integer getUtsGponAclExtIntfConfigFlowDirection() {
//        return (Integer) getProperty(utsGponAclExtIntfConfigFlowDirection).getValue();
//    }
//
//    public void setUtsGponAclExtIntfConfigFlowDirection(Integer aUtsGponAclExtIntfConfigFlowDirection) {
//        getProperty(utsGponAclExtIntfConfigFlowDirection).setValue(aUtsGponAclExtIntfConfigFlowDirection);
//    }
    
    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfModule));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfPort));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfLagGrpId));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfFilterType));
        prepareRead(getProperty(utsGponAclExtIntfConfigApplProfileId));
        prepareRead(getProperty(utsGponAclExtIntfConfigFlowDirection));
        return load();
        
    }
    
    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfModule));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfPort));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfLagGrpId));
        prepareRead(getProperty(utsGponAclExtIntfConfigIntfFilterType));
        prepareRead(getProperty(utsGponAclExtIntfConfigApplProfileId));
        prepareRead(getProperty(utsGponAclExtIntfConfigFlowDirection));
        return loadAll(new int[]{1,1,1,1});
    }
    
    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsGponAclExtIntfConfigApplProfileId));
        prepareSave(getProperty(utsGponAclExtIntfConfigFlowDirection));

        return save();
    }
    
    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsGponAclExtIntfConfigFlowDirection));
        prepareSave(getProperty(utsGponAclExtIntfConfigApplProfileId));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
    
    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}
