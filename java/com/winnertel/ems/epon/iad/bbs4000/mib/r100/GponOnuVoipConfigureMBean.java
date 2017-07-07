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

public class GponOnuVoipConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgOnuVoIPBindingType = "onuCfgOnuVoIPBindingType";
    public static final String onuCfgOnuVoIPUserName = "onuCfgOnuVoIPUserName";
    public static final String onuCfgOnuVoIPPassword = "onuCfgOnuVoIPPassword";
    public static final String onuCfgOnuVoIPServiceProfileIndex = "onuCfgOnuVoIPServiceProfileIndex";

    public GponOnuVoipConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuVoIPBindingType, new SnmpMibBeanProperty(onuCfgOnuVoIPBindingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.53", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuVoIPUserName, new SnmpMibBeanProperty(onuCfgOnuVoIPUserName, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.54", ISnmpConstant.STRING));
        initProperty(onuCfgOnuVoIPPassword, new SnmpMibBeanProperty(onuCfgOnuVoIPPassword, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.55", ISnmpConstant.STRING));
        initProperty(onuCfgOnuVoIPServiceProfileIndex, new SnmpMibBeanProperty(onuCfgOnuVoIPServiceProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.56", ISnmpConstant.GAUGE));

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

    public Integer getOnuCfgOnuVoIPBindingType() {
        return (Integer) getProperty(onuCfgOnuVoIPBindingType).getValue();
    }

    public void setOnuCfgOnuVoIPBindingType(Integer aOnuCfgOnuVoIPBindingType) {
        getProperty(onuCfgOnuVoIPBindingType).setValue(aOnuCfgOnuVoIPBindingType);
    }

    public String getOnuCfgOnuVoIPUserName() {
        return ((String) getProperty(onuCfgOnuVoIPUserName).getValue()).trim();
    }

    public void setOnuCfgOnuVoIPUserName(String aOnuCfgOnuVoIPUserName) {
        getProperty(onuCfgOnuVoIPUserName).setValue(aOnuCfgOnuVoIPUserName);
    }

    public String getOnuCfgOnuVoIPPassword() {
        return ((String) getProperty(onuCfgOnuVoIPPassword).getValue()).trim();
    }

    public void setOnuCfgOnuVoIPPassword(String aOnuCfgOnuVoIPPassword) {
        getProperty(onuCfgOnuVoIPPassword).setValue(aOnuCfgOnuVoIPPassword);
    }

    public Long getOnuCfgOnuVoIPServiceProfileIndex() {
        return (Long) getProperty(onuCfgOnuVoIPServiceProfileIndex).getValue();
    }

    public void setOnuCfgOnuVoIPServiceProfileIndex(Long aOnuCfgOnuVoIPServiceProfileIndex) {
        getProperty(onuCfgOnuVoIPServiceProfileIndex).setValue(aOnuCfgOnuVoIPServiceProfileIndex);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuVoIPBindingType));
        prepareRead(getProperty(onuCfgOnuVoIPUserName));
        prepareRead(getProperty(onuCfgOnuVoIPPassword));
        prepareRead(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuVoIPBindingType));
        prepareRead(getProperty(onuCfgOnuVoIPUserName));
        prepareRead(getProperty(onuCfgOnuVoIPPassword));
        prepareRead(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgOnuVoIPBindingType));
        prepareSave(getProperty(onuCfgOnuVoIPUserName));
        prepareSave(getProperty(onuCfgOnuVoIPPassword));
        prepareSave(getProperty(onuCfgOnuVoIPServiceProfileIndex));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgOnuVoIPBindingType));
        prepareSave(getProperty(onuCfgOnuVoIPUserName));
        prepareSave(getProperty(onuCfgOnuVoIPPassword));
        prepareSave(getProperty(onuCfgOnuVoIPServiceProfileIndex));

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