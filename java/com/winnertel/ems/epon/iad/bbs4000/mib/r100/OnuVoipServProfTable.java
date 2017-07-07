/**
 * Title          :   OnuVoipServProfTable.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * @author Shen Dayong
 *         Create on 2008-10-2
 *         Modify by HZ21044
 */

public class OnuVoipServProfTable extends SnmpMibBean {

    public static final String voipServiceProfileIndex = "voipServiceProfileIndex";
    public static final String onuVoipServProfileName = "onuVoipServProfileName";
    public static final String onuVoIPVirtualPortNo = "onuVoIPVirtualPortNo";
    public static final String onuVoIPConfigMethod = "onuVoIPConfigMethod";
    public static final String onuVoIPConfigServerAddress = "onuVoIPConfigServerAddress";

    public OnuVoipServProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVoipServProfileName, new SnmpMibBeanProperty(onuVoipServProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.20.1.2", ISnmpConstant.STRING));
        initProperty(onuVoIPVirtualPortNo, new SnmpMibBeanProperty(onuVoIPVirtualPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.2.20.1.3", ISnmpConstant.INTEGER));
        initProperty(onuVoIPConfigMethod, new SnmpMibBeanProperty(onuVoIPConfigMethod, ".1.3.6.1.4.1.41355.1.3.10.5.2.20.1.4", ISnmpConstant.INTEGER));
        initProperty(onuVoIPConfigServerAddress, new SnmpMibBeanProperty(onuVoIPConfigServerAddress, ".1.3.6.1.4.1.41355.1.3.10.5.2.20.1.5", ISnmpConstant.IP_ADDRESS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.20.1.6", ISnmpConstant.INTEGER));
    }

    public Long getVoipServiceProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setVoipServiceProfileIndex(Long aVoipServiceProfileIndex) {
        setIndex(0, aVoipServiceProfileIndex);
    }

    public String getOnuVoipServProfileName() {
        return (String) getProperty(onuVoipServProfileName).getValue();
    }

    public void setOnuVoipServProfileName(String aOnuVoipServProfileName) {
        getProperty(onuVoipServProfileName).setValue(aOnuVoipServProfileName);
    }

    public Integer getOnuVoIPVirtualPortNo() {
        return (Integer) getProperty(onuVoIPVirtualPortNo).getValue();
    }

    public void setOnuVoIPVirtualPortNo(Integer aOnuVoIPVirtualPortNo) {
        getProperty(onuVoIPVirtualPortNo).setValue(aOnuVoIPVirtualPortNo);
    }

    public Integer getOnuVoIPConfigMethod() {
        return (Integer) getProperty(onuVoIPConfigMethod).getValue();
    }

    public void setOnuVoIPConfigMethod(Integer aOnuVoIPConfigMethod) {
        getProperty(onuVoIPConfigMethod).setValue(aOnuVoIPConfigMethod);
    }

    public String getOnuVoIPConfigServerAddress() {
        return (String) getProperty(onuVoIPConfigServerAddress).getValue();
    }

    public void setOnuVoIPConfigServerAddress(String aOnuVoIPConfigServerAddress) {
        getProperty(onuVoIPConfigServerAddress).setValue(aOnuVoIPConfigServerAddress);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuVoipServProfileName));
        prepareRead(super.getProperty(onuVoIPVirtualPortNo));
        prepareRead(super.getProperty(onuVoIPConfigMethod));
        prepareRead(super.getProperty(onuVoIPConfigServerAddress));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuVoipServProfileName));
        prepareRead(super.getProperty(onuVoIPVirtualPortNo));
        prepareRead(super.getProperty(onuVoIPConfigMethod));
        prepareRead(super.getProperty(onuVoIPConfigServerAddress));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVoipServProfileName));
        prepareSave(getProperty(onuVoIPVirtualPortNo));
        prepareSave(getProperty(onuVoIPConfigMethod));
        prepareSave(getProperty(onuVoIPConfigServerAddress));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVoipServProfileName));
        prepareSave(getProperty(onuVoIPVirtualPortNo));
        prepareSave(getProperty(onuVoIPConfigMethod));
        prepareSave(getProperty(onuVoIPConfigServerAddress));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuVoipServProfileName();
    }

}