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
public class OnuGponAclExtIntfConfigTable extends SnmpMibBean {

    private static final String onuGponAclExtIntfConfigIntfNum = "onuGponAclExtIntfConfigIntfNum";
    private static final String onuGponAclExtIntfConfigIntfModule = "onuGponAclExtIntfConfigIntfModule";
    private static final String onuGponAclExtIntfConfigIntfPort = "onuGponAclExtIntfConfigIntfPort";
    private static final String onuGponAclExtIntfConfigIntfLagGrpId = "onuGponAclExtIntfConfigIntfLagGrpId";
    private static final String onuGponAclExtIntfConfigIntfFilterType = "onuGponAclExtIntfConfigIntfFilterType";
    private static final String onuGponAclExtIntfConfigApplProfileId = "onuGponAclExtIntfConfigApplProfileId";
    private static final String onuGponAclExtIntfConfigFlowDirection = "onuGponAclExtIntfConfigFlowDirection";
    private static final String onuGponAclExtIntfConfigOnuId = "onuGponAclExtIntfConfigOnuId";
    private static final String onuGponAclExtIntfConfigVPId = "onuGponAclExtIntfConfigVPId";

    public OnuGponAclExtIntfConfigTable(ISnmpProxy snmpProxy) {
        super(snmpProxy);
        init();
    }

    protected void init() {

        initProperty(onuGponAclExtIntfConfigIntfNum, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigIntfNum, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.1",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigIntfModule, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigIntfModule, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.5",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigIntfPort, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigIntfPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.6",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigIntfLagGrpId, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigIntfLagGrpId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.7",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigIntfFilterType, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigIntfFilterType, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.8",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigApplProfileId, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigApplProfileId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.9",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigFlowDirection, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigFlowDirection, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.4",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigOnuId, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigOnuId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.2",
                ISnmpConstant.INTEGER));
        initProperty(onuGponAclExtIntfConfigVPId, new SnmpMibBeanProperty(
                onuGponAclExtIntfConfigVPId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.3",
                ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.3.1.100", ISnmpConstant.INTEGER));
    }
    
    public String getOnuGponAclExtIntfConfigIntfNum() {
        int i = (Integer) getIndex(0);
        if (i < 48)
            return "" + ((i - 1) / 4 + 1 + "/" + ((i % 4 == 0) ? 4 : (i % 4)));
        else if (i == 5000)
            return "CPU Port";
        else {
            return "lg" + (i - 48);
        }
    }
    
    public void setOnuGponAclExtIntfConfigIntfNum(Integer aOnuGponAclExtIntfConfigIntfNum){
        setIndex(0,aOnuGponAclExtIntfConfigIntfNum);
    }
    
    public void setOnuGponAclExtIntfConfigOnuId (Integer aOnuGponAclExtIntfConfigOnuId ){
        setIndex(1,aOnuGponAclExtIntfConfigOnuId);
    }
    
    public Integer getOnuGponAclExtIntfConfigOnuId () {
        return (Integer) getIndex(1);
    }
    
    public Integer getOnuGponAclExtIntfConfigVPId() {
        return (Integer) getIndex(2);
    }
    
    public void setOnuGponAclExtIntfConfigVPId(Integer aOnuGponAclExtIntfConfigVPId){
        setIndex(2,aOnuGponAclExtIntfConfigVPId);
    }
    
    public Integer getOnuGponAclExtIntfConfigFlowDirection() {
        return (Integer) getIndex(3);
    }

    public void setOnuGponAclExtIntfConfigFlowDirection(Integer aOnuGponAclExtIntfConfigFlowDirection) {
        setIndex(3, aOnuGponAclExtIntfConfigFlowDirection);
    }
    
    public Integer getOnuGponAclExtIntfConfigIntfModule() {
        return (Integer) getProperty(onuGponAclExtIntfConfigIntfModule).getValue();
    }

    public void setOnuGponAclExtIntfConfigIntfModule(Integer aOnuGponAclExtIntfConfigIntfModule) {
        getProperty(onuGponAclExtIntfConfigIntfModule).setValue(aOnuGponAclExtIntfConfigIntfModule);
    }
    
    public Integer getOnuGponAclExtIntfConfigIntfPort() {
        return (Integer) getProperty(onuGponAclExtIntfConfigIntfPort).getValue();
    }

    public void setOnuGponAclExtIntfConfigIntfPort(Integer aOnuGponAclExtIntfConfigIntfPort) {
        getProperty(onuGponAclExtIntfConfigIntfPort).setValue(aOnuGponAclExtIntfConfigIntfPort);
    }
    
    public Integer getOnuGponAclExtIntfConfigIntfLagGrpId() {
        return (Integer) getProperty(onuGponAclExtIntfConfigIntfLagGrpId).getValue();
    }

    public void setOnuGponAclExtIntfConfigIntfLagGrpId(Integer aOnuGponAclExtIntfConfigIntfLagGrpId) {
        getProperty(onuGponAclExtIntfConfigIntfLagGrpId).setValue(aOnuGponAclExtIntfConfigIntfLagGrpId);
    }
    
    public Integer getOnuGponAclExtIntfConfigIntfFilterType() {
        return (Integer) getProperty(onuGponAclExtIntfConfigIntfFilterType).getValue();
    }

    public void setOnuGponAclExtIntfConfigIntfFilterType(Integer aOnuGponAclExtIntfConfigIntfFilterType) {
        getProperty(onuGponAclExtIntfConfigIntfFilterType).setValue(aOnuGponAclExtIntfConfigIntfFilterType);
    }
    
    public Integer getOnuGponAclExtIntfConfigApplProfileId() {
        return (Integer) getProperty(onuGponAclExtIntfConfigApplProfileId).getValue();
    }

    public void setOnuGponAclExtIntfConfigApplProfileId(Integer aOnuGponAclExtIntfConfigApplProfileId) {
        getProperty(onuGponAclExtIntfConfigApplProfileId).setValue(aOnuGponAclExtIntfConfigApplProfileId);
    }
    
    
    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfModule));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfPort));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfLagGrpId));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfFilterType));
        prepareRead(getProperty(onuGponAclExtIntfConfigApplProfileId));
        prepareRead(getProperty(onuGponAclExtIntfConfigFlowDirection));
        return load();
        
    }
    
    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfModule));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfPort));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfLagGrpId));
        prepareRead(getProperty(onuGponAclExtIntfConfigIntfFilterType));
        prepareRead(getProperty(onuGponAclExtIntfConfigApplProfileId));
        prepareRead(getProperty(onuGponAclExtIntfConfigFlowDirection));
        return loadAll(new int[]{1,1,1,1});
    }
    
    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuGponAclExtIntfConfigApplProfileId));
//        prepareSave(getProperty(onuGponAclExtIntfConfigFlowDirection));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));
        int old_time = fSnmpProxy.getTimeout();
        try{
            fSnmpProxy.setTimeout(30);
            
            return save();
        }
        finally{
            fSnmpProxy.setTimeout(old_time);
        }
    }
    
    public boolean add() throws MibBeanException {
//        prepareSave(getProperty(onuGponAclExtIntfConfigFlowDirection));
        prepareSave(getProperty(onuGponAclExtIntfConfigApplProfileId));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));
        int old_time = fSnmpProxy.getTimeout();
        try{
            fSnmpProxy.setTimeout(30);
            return save();
        }
        finally{
            fSnmpProxy.setTimeout(old_time);
        }
    }
    
    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        int old_time = fSnmpProxy.getTimeout();
        try{
            fSnmpProxy.setTimeout(30);
            return save();
        }
        finally{
            fSnmpProxy.setTimeout(old_time);
        }
    }

}
