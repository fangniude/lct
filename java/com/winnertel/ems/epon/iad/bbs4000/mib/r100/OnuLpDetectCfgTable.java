package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

/**
 * @author Yang Yizai , 2009-3-16
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;
/**
 * The OnuLpDetectCfgTable class.
 * Created by QuickDVM
 */
public class OnuLpDetectCfgTable extends SnmpMibBean {
    public static final String onuLpDetectCfgSlotNo = "onuLpDetectCfgSlotNo";
    public static final String onuLpDetectCfgPortNo = "onuLpDetectCfgPortNo";
    public static final String onuLpDetectCfgLogicalPortNo = "onuLpDetectCfgLogicalPortNo";
    public static final String onuLpDetectCfgEnable = "onuLpDetectCfgEnable";
    public static final String onuLpDetectCfgRecoveryTimer = "onuLpDetectCfgRecoveryTimer";

    public OnuLpDetectCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuLpDetectCfgSlotNo, new SnmpMibBeanProperty(onuLpDetectCfgSlotNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.1", ISnmpConstant.INTEGER));
        initProperty(onuLpDetectCfgPortNo, new SnmpMibBeanProperty(onuLpDetectCfgPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.2", ISnmpConstant.INTEGER));
        initProperty(onuLpDetectCfgLogicalPortNo, new SnmpMibBeanProperty(onuLpDetectCfgLogicalPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.3", ISnmpConstant.INTEGER));
        initProperty(onuLpDetectCfgEnable, new SnmpMibBeanProperty(onuLpDetectCfgEnable,
                ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.11", ISnmpConstant.INTEGER));
        initProperty(onuLpDetectCfgRecoveryTimer, new SnmpMibBeanProperty(onuLpDetectCfgRecoveryTimer,
                ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.12", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1.14.1.100",
                ISnmpConstant.INTEGER));

    }

    public Integer getOnuLpDetectCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuLpDetectCfgSlotNo(Integer aOnuLpDetectCfgSlotNo) {
        setIndex(0, aOnuLpDetectCfgSlotNo);
    }

    public Integer getOnuLpDetectCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuLpDetectCfgPortNo(Integer aOnuLpDetectCfgPortNo) {
        setIndex(1, aOnuLpDetectCfgPortNo);
    }

    public Integer getOnuLpDetectCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuLpDetectCfgLogicalPortNo(Integer aOnuLpDetectCfgLogicalPortNo) {
        setIndex(2, aOnuLpDetectCfgLogicalPortNo);
    }

    public Integer getOnuLpDetectCfgEnable() {
        return (Integer) getProperty(onuLpDetectCfgEnable).getValue();
    }

    public void setOnuLpDetectCfgEnable(Integer aOnuLpDetectCfgEnable) {
        getProperty(onuLpDetectCfgEnable).setValue(aOnuLpDetectCfgEnable);
    }

    public Long getOnuLpDetectCfgRecoveryTimer() {
        return (Long) getProperty(onuLpDetectCfgRecoveryTimer).getValue();
    }

    public void setOnuLpDetectCfgRecoveryTimer(Long aOnuLpDetectCfgRecoveryTimer) {
        getProperty(onuLpDetectCfgRecoveryTimer).setValue(aOnuLpDetectCfgRecoveryTimer);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuLpDetectCfgEnable));
        prepareRead(super.getProperty(onuLpDetectCfgRecoveryTimer));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuLpDetectCfgEnable));
        prepareRead(super.getProperty(onuLpDetectCfgRecoveryTimer));

        return loadAll(new int[] { 1, 1, 1 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuLpDetectCfgEnable));
        prepareSave(getProperty(onuLpDetectCfgRecoveryTimer));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuLpDetectCfgEnable));
        prepareSave(getProperty(onuLpDetectCfgRecoveryTimer));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}
