/**
 * Created by Zhou Chao, 2008/9/28
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuNetworkConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgOnuMacAddress = "onuCfgOnuMacAddress";
    public static final String onuCfgOnuDHCPMode = "onuCfgOnuDHCPMode";
    public static final String onuCfgOnuIPAddress = "onuCfgOnuIPAddress";
    public static final String onuCfgOnuIPMask = "onuCfgOnuIPMask";
    public static final String onuCfgOnuDefaultGateway = "onuCfgOnuDefaultGateway";
    public static final String onuCfgMacLimit = "onuCfgMacLimit";
    public static final String onuCfgOnuFastLeaveCapability = "onuCfgOnuFastLeaveCapability";

    public GponOnuNetworkConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuMacAddress, new SnmpMibBeanProperty(onuCfgOnuMacAddress, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.42", ISnmpConstant.MAC_ADDRESS));
        initProperty(onuCfgOnuDHCPMode, new SnmpMibBeanProperty(onuCfgOnuDHCPMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.43", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuIPAddress, new SnmpMibBeanProperty(onuCfgOnuIPAddress, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.44", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgOnuIPMask, new SnmpMibBeanProperty(onuCfgOnuIPMask, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.45", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgOnuDefaultGateway, new SnmpMibBeanProperty(onuCfgOnuDefaultGateway, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.46", ISnmpConstant.IP_ADDRESS));
        initProperty(onuCfgMacLimit, new SnmpMibBeanProperty(onuCfgMacLimit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.48", ISnmpConstant.GAUGE));
        initProperty(onuCfgOnuFastLeaveCapability, new SnmpMibBeanProperty(onuCfgOnuFastLeaveCapability, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.50", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.57", ISnmpConstant.INTEGER));
    }

    public Integer getOnuCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuCfgSlotNo(Integer aOnuCfgSlotNo) {
        setIndex(0, aOnuCfgSlotNo);
    }

    public Integer getOnuCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuCfgPortNo(Integer aOnuCfgPortNo) {
        setIndex(1, aOnuCfgPortNo);
    }

    public Integer getOnuCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuCfgLogicalPortNo(Integer aOnuCfgLogicalPortNo) {
        setIndex(2, aOnuCfgLogicalPortNo);
    }

    public byte[] getOnuCfgOnuMacAddress() {
        return (byte[]) getProperty(onuCfgOnuMacAddress).getValue();
    }

    public void setOnuCfgOnuMacAddress(byte[] aOnuCfgOnuMacAddress) {
        getProperty(onuCfgOnuMacAddress).setValue(aOnuCfgOnuMacAddress);
    }

    public Integer getOnuCfgOnuDHCPMode() {
        return (Integer) getProperty(onuCfgOnuDHCPMode).getValue();
    }

    public void setOnuCfgOnuDHCPMode(Integer aOnuCfgOnuDHCPMode) {
        getProperty(onuCfgOnuDHCPMode).setValue(aOnuCfgOnuDHCPMode);
    }

    public String getOnuCfgOnuIPAddress() {
        return (String) getProperty(onuCfgOnuIPAddress).getValue();
    }

    public void setOnuCfgOnuIPAddress(String aOnuCfgOnuIPAddress) {
        getProperty(onuCfgOnuIPAddress).setValue(aOnuCfgOnuIPAddress);
    }

    public String getOnuCfgOnuIPMask() {
        return (String) getProperty(onuCfgOnuIPMask).getValue();
    }

    public void setOnuCfgOnuIPMask(String aOnuCfgOnuIPMask) {
        getProperty(onuCfgOnuIPMask).setValue(aOnuCfgOnuIPMask);
    }

    public String getOnuCfgOnuDefaultGateway() {
        return (String) getProperty(onuCfgOnuDefaultGateway).getValue();
    }

    public void setOnuCfgOnuDefaultGateway(String aOnuCfgOnuDefaultGateway) {
        getProperty(onuCfgOnuDefaultGateway).setValue(aOnuCfgOnuDefaultGateway);
    }

    public Long getOnuCfgMacLimit() {
        return (Long) getProperty(onuCfgMacLimit).getValue();
    }

    public void setOnuCfgMacLimit(Long aOnuCfgMacLimit) {
        getProperty(onuCfgMacLimit).setValue(aOnuCfgMacLimit);
    }

    public Long getOnuCfgOnuFastLeaveCapability() {
        return (Long) getProperty(onuCfgOnuFastLeaveCapability).getValue();
    }

    public void setOnuCfgOnuFastLeaveCapability(Long aOnuCfgOnuFastLeaveCapability) {
        getProperty(onuCfgOnuFastLeaveCapability).setValue(aOnuCfgOnuFastLeaveCapability);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuMacAddress));
        prepareRead(getProperty(onuCfgOnuDHCPMode));
        prepareRead(getProperty(onuCfgOnuIPAddress));
        prepareRead(getProperty(onuCfgOnuIPMask));
        prepareRead(getProperty(onuCfgOnuDefaultGateway));
        prepareRead(getProperty(onuCfgMacLimit));
        prepareRead(getProperty(onuCfgOnuFastLeaveCapability));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuMacAddress));
        prepareRead(getProperty(onuCfgOnuDHCPMode));
        prepareRead(getProperty(onuCfgOnuIPAddress));
        prepareRead(getProperty(onuCfgOnuIPMask));
        prepareRead(getProperty(onuCfgOnuDefaultGateway));
        prepareRead(getProperty(onuCfgMacLimit));
        prepareRead(getProperty(onuCfgOnuFastLeaveCapability));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgOnuDHCPMode));
        prepareSave(getProperty(onuCfgOnuIPAddress));
        prepareSave(getProperty(onuCfgOnuIPMask));
        prepareSave(getProperty(onuCfgOnuDefaultGateway));
        prepareSave(getProperty(onuCfgMacLimit));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgOnuDHCPMode));
        prepareSave(getProperty(onuCfgOnuIPAddress));
        prepareSave(getProperty(onuCfgOnuIPMask));
        prepareSave(getProperty(onuCfgOnuDefaultGateway));
        prepareSave(getProperty(onuCfgMacLimit));

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