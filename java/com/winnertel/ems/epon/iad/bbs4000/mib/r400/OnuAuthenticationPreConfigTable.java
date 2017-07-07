/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuAuthenticationPreConfigTable extends SnmpMibBean {

    public static final String onuAuthenOnuId = "onuAuthenOnuId";
    public static final String onuAuthenMacAddress = "onuAuthenMacAddress";
    public static final String onuAuthenAction = "onuAuthenAction";
    public static final String onuAuthenRowStatus = "onuAuthenRowStatus";

    public OnuAuthenticationPreConfigTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuAuthenOnuId, new SnmpMibBeanProperty(onuAuthenOnuId, ".1.3.6.1.4.1.17409.2.3.4.5.2.1.1", ISnmpConstant.INTEGER));
        initProperty(onuAuthenMacAddress, new SnmpMibBeanProperty(onuAuthenMacAddress, ".1.3.6.1.4.1.17409.2.3.4.5.2.1.2", ISnmpConstant.OCTETS));
        initProperty(onuAuthenAction, new SnmpMibBeanProperty(onuAuthenAction, ".1.3.6.1.4.1.17409.2.3.4.5.2.1.3", ISnmpConstant.INTEGER));

        initProperty(onuAuthenRowStatus, new SnmpMibBeanProperty(onuAuthenRowStatus, ".1.3.6.1.4.1.17409.2.3.4.5.2.1.4", ISnmpConstant.INTEGER));
    }

    public Integer getOnuAuthenOnuId() {
        return (Integer) getIndex(0);
    }

    public void setOnuAuthenOnuId(Integer aOnuAuthenOnuId) {
        setIndex(0, aOnuAuthenOnuId);
    }

    public byte[] getOnuAuthenMacAddress() {
        return (byte[]) getProperty(onuAuthenMacAddress).getValue();
    }

    public void setOnuAuthenMacAddress(byte[] aOnuAuthenMacAddress) {
        getProperty(onuAuthenMacAddress).setValue(aOnuAuthenMacAddress);
    }

    public Integer getOnuAuthenAction() {
        return (Integer) getProperty(onuAuthenAction).getValue();
    }

    public void setOnuAuthenAction(Integer aOnuAuthenAction) {
        getProperty(onuAuthenAction).setValue(aOnuAuthenAction);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuAuthenMacAddress));
        prepareRead(getProperty(onuAuthenAction));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuAuthenMacAddress));
        prepareRead(getProperty(onuAuthenAction));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuAuthenMacAddress));
        prepareSave(getProperty(onuAuthenAction));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuAuthenMacAddress));
        prepareSave(getProperty(onuAuthenAction));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}