/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuInfoTable extends SnmpMibBean {

    public static final String onuDeviceIndex = "onuDeviceIndex";
    public static final String onuName = "onuName";
    public static final String onuType = "onuType";
    public static final String onuIpAddress = "onuIpAddress";
    public static final String onuIpSubnetMask = "onuIpSubnetMask";
    public static final String onuIpGateway = "onuIpGateway";
    public static final String onuMacAddress = "onuMacAddress";
    public static final String onuOperationStatus = "onuOperationStatus";
    public static final String onuAdminStatus = "onuAdminStatus";
    public static final String onuChipVendor = "onuChipVendor";
    public static final String onuChipType = "onuChipType";
    public static final String onuChipVersion = "onuChipVersion";
    public static final String onuSoftwareVersion = "onuSoftwareVersion";
    public static final String onuFirmwareVersion = "onuFirmwareVersion";
    public static final String onuTestDistance = "onuTestDistance";
    public static final String onuLlidId = "onuLlidId";
    public static final String resetONU = "resetONU";
    public static final String onuTimeSinceLastRegister = "onuTimeSinceLastRegister";
    public static final String onuMgmtCvlan = "onuMgmtCvlan" ;
    public static final String onuMgmtSvlan = "onuMgmtSvlan" ;
    public static final String onuMgmtPriority = "onuMgmtPriority" ;
    public static final String onuMgmtSnmpTrapHost = "onuMgmtSnmpTrapHost" ;
    public static final String onuMgmtSnmpCommunityForRead = "onuMgmtSnmpCommunityForRead" ;
    public static final String onuMgmtSnmpCommunityForWrite = "onuMgmtSnmpCommunityForWrite" ;

    public OnuInfoTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuDeviceIndex, new SnmpMibBeanProperty(onuDeviceIndex, ".1.3.6.1.4.1.17409.2.3.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(onuName, new SnmpMibBeanProperty(onuName, ".1.3.6.1.4.1.17409.2.3.4.1.1.2", ISnmpConstant.STRING));
        initProperty(onuType, new SnmpMibBeanProperty(onuType, ".1.3.6.1.4.1.17409.2.3.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(onuIpAddress, new SnmpMibBeanProperty(onuIpAddress, ".1.3.6.1.4.1.17409.2.3.4.1.1.4", ISnmpConstant.IP_ADDRESS));
        initProperty(onuIpSubnetMask, new SnmpMibBeanProperty(onuIpSubnetMask, ".1.3.6.1.4.1.17409.2.3.4.1.1.5", ISnmpConstant.IP_ADDRESS));
        initProperty(onuIpGateway, new SnmpMibBeanProperty(onuIpGateway, ".1.3.6.1.4.1.17409.2.3.4.1.1.6", ISnmpConstant.IP_ADDRESS));
        initProperty(onuMacAddress, new SnmpMibBeanProperty(onuMacAddress, ".1.3.6.1.4.1.17409.2.3.4.1.1.7", ISnmpConstant.OCTETS));
        initProperty(onuOperationStatus, new SnmpMibBeanProperty(onuOperationStatus, ".1.3.6.1.4.1.17409.2.3.4.1.1.8", ISnmpConstant.INTEGER));
        initProperty(onuAdminStatus, new SnmpMibBeanProperty(onuAdminStatus, ".1.3.6.1.4.1.17409.2.3.4.1.1.9", ISnmpConstant.INTEGER));
        initProperty(onuChipVendor, new SnmpMibBeanProperty(onuChipVendor, ".1.3.6.1.4.1.17409.2.3.4.1.1.10", ISnmpConstant.STRING));
        initProperty(onuChipType, new SnmpMibBeanProperty(onuChipType, ".1.3.6.1.4.1.17409.2.3.4.1.1.11", ISnmpConstant.STRING));
        initProperty(onuChipVersion, new SnmpMibBeanProperty(onuChipVersion, ".1.3.6.1.4.1.17409.2.3.4.1.1.12", ISnmpConstant.STRING));
        initProperty(onuSoftwareVersion, new SnmpMibBeanProperty(onuSoftwareVersion, ".1.3.6.1.4.1.17409.2.3.4.1.1.13", ISnmpConstant.STRING));
        initProperty(onuFirmwareVersion, new SnmpMibBeanProperty(onuFirmwareVersion, ".1.3.6.1.4.1.17409.2.3.4.1.1.14", ISnmpConstant.STRING));
        initProperty(onuTestDistance, new SnmpMibBeanProperty(onuTestDistance, ".1.3.6.1.4.1.17409.2.3.4.1.1.15", ISnmpConstant.INTEGER));
        initProperty(onuLlidId, new SnmpMibBeanProperty(onuLlidId, ".1.3.6.1.4.1.17409.2.3.4.1.1.16", ISnmpConstant.INTEGER));

        initProperty(resetONU, new SnmpMibBeanProperty(resetONU, ".1.3.6.1.4.1.17409.2.3.4.1.1.17", ISnmpConstant.INTEGER));
        initProperty(onuTimeSinceLastRegister, new SnmpMibBeanProperty(onuTimeSinceLastRegister, ".1.3.6.1.4.1.17409.2.3.4.1.1.18", ISnmpConstant.COUNTER));
        initProperty( onuMgmtCvlan, new SnmpMibBeanProperty( onuMgmtCvlan, ".1.3.6.1.4.1.17409.2.3.4.1.1.19", ISnmpConstant.INTEGER));
        initProperty( onuMgmtSvlan, new SnmpMibBeanProperty( onuMgmtSvlan, ".1.3.6.1.4.1.17409.2.3.4.1.1.20", ISnmpConstant.INTEGER));
        initProperty( onuMgmtPriority, new SnmpMibBeanProperty( onuMgmtPriority, ".1.3.6.1.4.1.17409.2.3.4.1.1.21", ISnmpConstant.INTEGER));
        initProperty( onuMgmtSnmpTrapHost, new SnmpMibBeanProperty( onuMgmtSnmpTrapHost, ".1.3.6.1.4.1.17409.2.3.4.1.1.22", ISnmpConstant.IP_ADDRESS));
        initProperty( onuMgmtSnmpCommunityForRead, new SnmpMibBeanProperty( onuMgmtSnmpCommunityForRead, ".1.3.6.1.4.1.17409.2.3.4.1.1.23", ISnmpConstant.STRING));
        initProperty( onuMgmtSnmpCommunityForWrite, new SnmpMibBeanProperty( onuMgmtSnmpCommunityForWrite, ".1.3.6.1.4.1.17409.2.3.4.1.1.24", ISnmpConstant.STRING));
    }

    public Integer getOnuDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setOnuDeviceIndex(Integer aOnuDeviceIndex) {
        setIndex(0, aOnuDeviceIndex);
    }

    public String getOnuName() {
        return (String) getProperty(onuName).getValue();
    }

    public void setOnuName(String aOnuName) {
        getProperty(onuName).setValue(aOnuName);
    }

    public Integer getOnuType() {
        return (Integer) getProperty(onuType).getValue();
    }

    public void setOnuType(Integer aOnuType) {
        getProperty(onuType).setValue(aOnuType);
    }

    public String getOnuIpAddress() {
        return (String) getProperty(onuIpAddress).getValue();
    }

    public void setOnuIpAddress(String aOnuIpAddress) {
        getProperty(onuIpAddress).setValue(aOnuIpAddress);
    }

    public String getOnuIpSubnetMask() {
        return (String) getProperty(onuIpSubnetMask).getValue();
    }

    public void setOnuIpSubnetMask(String aOnuIpSubnetMask) {
        getProperty(onuIpSubnetMask).setValue(aOnuIpSubnetMask);
    }

    public String getOnuIpGateway() {
        return (String) getProperty(onuIpGateway).getValue();
    }

    public void setOnuIpGateway(String aOnuIpGateway) {
        getProperty(onuIpGateway).setValue(aOnuIpGateway);
    }

    public byte[] getOnuMacAddress() {
        return (byte[]) getProperty(onuMacAddress).getValue();
    }

    public void setOnuMacAddress(byte[] aOnuMacAddress) {
        getProperty(onuMacAddress).setValue(aOnuMacAddress);
    }

    public Integer getOnuOperationStatus() {
        return (Integer) getProperty(onuOperationStatus).getValue();
    }

    public void setOnuOperationStatus(Integer aOnuOperationStatus) {
        getProperty(onuOperationStatus).setValue(aOnuOperationStatus);
    }

    public Integer getOnuAdminStatus() {
        return (Integer) getProperty(onuAdminStatus).getValue();
    }

    public void setOnuAdminStatus(Integer aOnuAdminStatus) {
        getProperty(onuAdminStatus).setValue(aOnuAdminStatus);
    }

    public String getOnuChipVendor() {
        return (String) getProperty(onuChipVendor).getValue();
    }

    public void setOnuChipVendor(String aOnuChipVendor) {
        getProperty(onuChipVendor).setValue(aOnuChipVendor);
    }

    public String getOnuChipType() {
        return (String) getProperty(onuChipType).getValue();
    }

    public void setOnuChipType(String aOnuChipType) {
        getProperty(onuChipType).setValue(aOnuChipType);
    }

    public String getOnuChipVersion() {
        return (String) getProperty(onuChipVersion).getValue();
    }

    public void setOnuChipVersion(String aOnuChipVersion) {
        getProperty(onuChipVersion).setValue(aOnuChipVersion);
    }

    public String getOnuSoftwareVersion() {
        return (String) getProperty(onuSoftwareVersion).getValue();
    }

    public void setOnuSoftwareVersion(String aOnuSoftwareVersion) {
        getProperty(onuSoftwareVersion).setValue(aOnuSoftwareVersion);
    }

    public String getOnuFirmwareVersion() {
        return (String) getProperty(onuFirmwareVersion).getValue();
    }

    public void setOnuFirmwareVersion(String aOnuFirmwareVersion) {
        getProperty(onuFirmwareVersion).setValue(aOnuFirmwareVersion);
    }

    public Integer getOnuTestDistance() {
        return (Integer) getProperty(onuTestDistance).getValue();
    }

    public void setOnuTestDistance(Integer aOnuTestDistance) {
        getProperty(onuTestDistance).setValue(aOnuTestDistance);
    }

    public Integer getOnuLlidId() {
        return (Integer) getProperty(onuLlidId).getValue();
    }

    public void setOnuLlidId(Integer aOnuLlidId) {
        getProperty(onuLlidId).setValue(aOnuLlidId);
    }

    public Integer getResetONU() {
        return (Integer) getProperty(resetONU).getValue();
    }

    public void setResetONU(Integer aResetONU) {
        getProperty(resetONU).setValue(aResetONU);
    }

    public boolean resetONU() throws MibBeanException {
        setResetONU(1);
        prepareSave(getProperty(resetONU));

        return save();
    }

    public Long getOnuTimeSinceLastRegister() {
        return (Long)getProperty(onuTimeSinceLastRegister).getValue();
    }

    public void setOnuTimeSinceLastRegister(Long aOnuTimeSinceLastRegister) {
        getProperty(onuTimeSinceLastRegister).setValue(aOnuTimeSinceLastRegister);
    }

    public Integer getOnuMgmtCvlan(){
        return ( Integer) getProperty( onuMgmtCvlan ).getValue();
    }
    public void setOnuMgmtCvlan( Integer aOnuMgmtCvlan ) {
              getProperty( onuMgmtCvlan ).setValue( aOnuMgmtCvlan );
    }

    public Integer getOnuMgmtSvlan(){
        return ( Integer) getProperty( onuMgmtSvlan ).getValue();
    }
    public void setOnuMgmtSvlan( Integer aOnuMgmtSvlan ) {
              getProperty( onuMgmtSvlan ).setValue( aOnuMgmtSvlan );
    }

    public Integer getOnuMgmtPriority(){
        return ( Integer) getProperty( onuMgmtPriority ).getValue();
    }
    public void setOnuMgmtPriority( Integer aOnuMgmtPriority ) {
              getProperty( onuMgmtPriority ).setValue( aOnuMgmtPriority );
    }

    public String getOnuMgmtSnmpTrapHost(){
        return ( String) getProperty( onuMgmtSnmpTrapHost ).getValue();
    }
    public void setOnuMgmtSnmpTrapHost( String aOnuMgmtSnmpTrapHost ) {
              getProperty( onuMgmtSnmpTrapHost ).setValue( aOnuMgmtSnmpTrapHost );
    }

    public String getOnuMgmtSnmpCommunityForRead(){
        return ( String) getProperty( onuMgmtSnmpCommunityForRead ).getValue();
    }
    public void setOnuMgmtSnmpCommunityForRead( String aOnuMgmtSnmpCommunityForRead ) {
              getProperty( onuMgmtSnmpCommunityForRead ).setValue( aOnuMgmtSnmpCommunityForRead );
    }

    public String getOnuMgmtSnmpCommunityForWrite(){
        return ( String) getProperty( onuMgmtSnmpCommunityForWrite ).getValue();
    }
    public void setOnuMgmtSnmpCommunityForWrite( String aOnuMgmtSnmpCommunityForWrite ) {
              getProperty( onuMgmtSnmpCommunityForWrite ).setValue( aOnuMgmtSnmpCommunityForWrite );
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuName));
        prepareRead(getProperty(onuType));
        prepareRead(getProperty(onuIpAddress));
        prepareRead(getProperty(onuIpSubnetMask));
        prepareRead(getProperty(onuIpGateway));
        prepareRead(getProperty(onuMacAddress));
        prepareRead(getProperty(onuOperationStatus));
        prepareRead(getProperty(onuAdminStatus));
        prepareRead(getProperty(onuChipVendor));
        prepareRead(getProperty(onuChipType));
        prepareRead(getProperty(onuChipVersion));
        prepareRead(getProperty(onuSoftwareVersion));
        prepareRead(getProperty(onuFirmwareVersion));
        prepareRead(getProperty(onuTestDistance));
        prepareRead(getProperty(onuLlidId));
        prepareRead(getProperty(onuTimeSinceLastRegister));
        prepareRead(getProperty(onuMgmtCvlan));
        prepareRead(getProperty(onuMgmtSvlan));
        prepareRead(getProperty(onuMgmtPriority));
        prepareRead(getProperty(onuMgmtSnmpTrapHost));
        prepareRead(getProperty(onuMgmtSnmpCommunityForRead));
        prepareRead(getProperty(onuMgmtSnmpCommunityForWrite));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuName));
        prepareRead(getProperty(onuType));
        prepareRead(getProperty(onuIpAddress));
        prepareRead(getProperty(onuIpSubnetMask));
        prepareRead(getProperty(onuIpGateway));
        prepareRead(getProperty(onuMacAddress));
        prepareRead(getProperty(onuOperationStatus));
        prepareRead(getProperty(onuAdminStatus));
        prepareRead(getProperty(onuChipVendor));
        prepareRead(getProperty(onuChipType));
        prepareRead(getProperty(onuChipVersion));
        prepareRead(getProperty(onuSoftwareVersion));
        prepareRead(getProperty(onuFirmwareVersion));
        prepareRead(getProperty(onuTestDistance));
        prepareRead(getProperty(onuLlidId));
        prepareRead(getProperty(onuTimeSinceLastRegister));
        prepareRead(getProperty(onuMgmtCvlan));
        prepareRead(getProperty(onuMgmtSvlan));
        prepareRead(getProperty(onuMgmtPriority));
        prepareRead(getProperty(onuMgmtSnmpTrapHost));
        prepareRead(getProperty(onuMgmtSnmpCommunityForRead));
        prepareRead(getProperty(onuMgmtSnmpCommunityForWrite));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuName));
        prepareSave(getProperty(onuIpAddress));
        prepareSave(getProperty(onuIpSubnetMask));
        prepareSave(getProperty(onuIpGateway));
        prepareSave(getProperty(onuAdminStatus));
        //prepareSave(getProperty(onuLlidId));
        prepareSave(getProperty(onuMgmtCvlan));
        prepareSave(getProperty(onuMgmtSvlan));
        prepareSave(getProperty(onuMgmtPriority));
        prepareSave(getProperty(onuMgmtSnmpTrapHost));
        prepareSave(getProperty(onuMgmtSnmpCommunityForRead));
        prepareSave(getProperty(onuMgmtSnmpCommunityForWrite));

        return save();
    }

    public Vector retrieveByPonOdn(int oltId, int cardId, int portId) throws MibBeanException {
        setRowsToFetch(64); //max port number is 64

        int onuDeviceIndexBegin = ((oltId & 0x000000FF) << 24) + ((cardId & 0x000000FF) << 16) + ((portId & 0x000000FF) << 8);
        int onuDeviceIndexEnd = ((oltId & 0x000000FF) << 24) + ((cardId & 0x000000FF) << 16) + (((portId + 1) & 0x000000FF) << 8);
        setOnuDeviceIndex(onuDeviceIndexBegin);

        prepareRead(getProperty(onuName));
        prepareRead(getProperty(onuType));
        prepareRead(getProperty(onuIpAddress));
        prepareRead(getProperty(onuIpSubnetMask));
        prepareRead(getProperty(onuIpGateway));
        prepareRead(getProperty(onuMacAddress));
        prepareRead(getProperty(onuOperationStatus));
        prepareRead(getProperty(onuAdminStatus));
        prepareRead(getProperty(onuChipVendor));
        prepareRead(getProperty(onuChipType));
        prepareRead(getProperty(onuChipVersion));
        prepareRead(getProperty(onuSoftwareVersion));
        prepareRead(getProperty(onuFirmwareVersion));
        prepareRead(getProperty(onuTestDistance));
        prepareRead(getProperty(onuLlidId));
        prepareRead(getProperty(onuMgmtCvlan));
        prepareRead(getProperty(onuMgmtSvlan));
        prepareRead(getProperty(onuMgmtPriority));
        prepareRead(getProperty(onuMgmtSnmpTrapHost));
        prepareRead(getProperty(onuMgmtSnmpCommunityForRead));
        prepareRead(getProperty(onuMgmtSnmpCommunityForWrite));

        Vector result = new Vector();
        Vector data = loadAll(new int[]{1});
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                OnuInfoTable bean = (OnuInfoTable) data.get(i);
                if (bean.getOnuDeviceIndex() < onuDeviceIndexEnd)
                    result.add(bean);
            }
        }

        return result;
    }

    public OnuInfoTable retrieveByIP(String ip) throws MibBeanException {
        Vector allOnuVec = retrieveAll();
        for (int i=0;i<allOnuVec.size();i++){
            OnuInfoTable oneOnu = (OnuInfoTable)allOnuVec.get(i);
            if (ip.equalsIgnoreCase(oneOnu.getOnuIpAddress())){
                return oneOnu;
            }
        }
        return null;
    }
}