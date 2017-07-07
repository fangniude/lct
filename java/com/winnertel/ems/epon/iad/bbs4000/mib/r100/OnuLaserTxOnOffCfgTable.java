/**
 * Created by Zhou Chao, 2009/10/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuLaserTxOnOffCfgTable extends SnmpMibBean {

    public static final String onuLaserTxOnOffCfgSlotNo = "onuLaserTxOnOffCfgSlotNo";
    public static final String onuLaserTxOnOffCfgPortNo = "onuLaserTxOnOffCfgPortNo";
    public static final String onuLaserTxOnOffCfgLogicalPortNo = "onuLaserTxOnOffCfgLogicalPortNo";
    public static final String onuLaserTxOnOffCfgSwitch = "onuLaserTxOnOffCfgSwitch";
    public static final String onuLaserTxOnOffCfgOnTimer = "onuLaserTxOnOffCfgOnTimer";
    public static final String onuLaserTxOnOffCfgLaserTxStatus = "onuLaserTxOnOffCfgLaserTxStatus";

    public OnuLaserTxOnOffCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuLaserTxOnOffCfgSlotNo, new SnmpMibBeanProperty(onuLaserTxOnOffCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.1", ISnmpConstant.INTEGER));
        initProperty(onuLaserTxOnOffCfgPortNo, new SnmpMibBeanProperty(onuLaserTxOnOffCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.2", ISnmpConstant.INTEGER));
        initProperty(onuLaserTxOnOffCfgLogicalPortNo, new SnmpMibBeanProperty(onuLaserTxOnOffCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.3", ISnmpConstant.INTEGER));
        initProperty(onuLaserTxOnOffCfgSwitch, new SnmpMibBeanProperty(onuLaserTxOnOffCfgSwitch, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.11", ISnmpConstant.INTEGER));
        initProperty(onuLaserTxOnOffCfgOnTimer, new SnmpMibBeanProperty(onuLaserTxOnOffCfgOnTimer, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.12", ISnmpConstant.GAUGE));
        initProperty(onuLaserTxOnOffCfgLaserTxStatus, new SnmpMibBeanProperty(onuLaserTxOnOffCfgLaserTxStatus, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.13", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.15.1.100", ISnmpConstant.INTEGER));
    }

    public Integer getOnuLaserTxOnOffCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuLaserTxOnOffCfgSlotNo(Integer aOnuLaserTxOnOffCfgSlotNo) {
        setIndex(0, aOnuLaserTxOnOffCfgSlotNo);
    }

    public Integer getOnuLaserTxOnOffCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuLaserTxOnOffCfgPortNo(Integer aOnuLaserTxOnOffCfgPortNo) {
        setIndex(1, aOnuLaserTxOnOffCfgPortNo);
    }

    public Integer getOnuLaserTxOnOffCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuLaserTxOnOffCfgLogicalPortNo(Integer aOnuLaserTxOnOffCfgLogicalPortNo) {
        setIndex(2, aOnuLaserTxOnOffCfgLogicalPortNo);
    }

    public Integer getOnuLaserTxOnOffCfgSwitch() {
        return (Integer) getProperty(onuLaserTxOnOffCfgSwitch).getValue();
    }

    public void setOnuLaserTxOnOffCfgSwitch(Integer aOnuLaserTxOnOffCfgSwitch) {
        getProperty(onuLaserTxOnOffCfgSwitch).setValue(aOnuLaserTxOnOffCfgSwitch);
    }

    public Long getOnuLaserTxOnOffCfgOnTimer() {
        return (Long) getProperty(onuLaserTxOnOffCfgOnTimer).getValue();
    }

    public void setOnuLaserTxOnOffCfgOnTimer(Long aOnuLaserTxOnOffCfgOnTimer) {
        getProperty(onuLaserTxOnOffCfgOnTimer).setValue(aOnuLaserTxOnOffCfgOnTimer);
    }

    public Integer getOnuLaserTxOnOffCfgLaserTxStatus() {
        return (Integer) getProperty(onuLaserTxOnOffCfgLaserTxStatus).getValue();
    }

    public void setOnuLaserTxOnOffCfgLaserTxStatus(Integer aOnuLaserTxOnOffCfgLaserTxStatus) {
        getProperty(onuLaserTxOnOffCfgLaserTxStatus).setValue(aOnuLaserTxOnOffCfgLaserTxStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuLaserTxOnOffCfgSwitch));
        prepareRead(getProperty(onuLaserTxOnOffCfgOnTimer));
        prepareRead(getProperty(onuLaserTxOnOffCfgLaserTxStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuLaserTxOnOffCfgSwitch));
        prepareRead(getProperty(onuLaserTxOnOffCfgOnTimer));
        prepareRead(getProperty(onuLaserTxOnOffCfgLaserTxStatus));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuLaserTxOnOffCfgSwitch));
        prepareSave(getProperty(onuLaserTxOnOffCfgOnTimer));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuLaserTxOnOffCfgSwitch));
        prepareSave(getProperty(onuLaserTxOnOffCfgOnTimer));
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