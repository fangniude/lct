/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class PortAclListTable extends SnmpMibBean {

    public static final String aclDeviceIndex = "aclDeviceIndex";
    public static final String aclCardIndex = "aclCardIndex";
    public static final String aclPortIndex = "aclPortIndex";
    public static final String portAclListIndex = "portAclListIndex";
    public static final String aclPortDirection = "aclPortDirection";
    //public static final String aclAction = "aclAction";
    //public static final String aclActionParameter = "aclActionParameter";

    public PortAclListTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(aclDeviceIndex, new SnmpMibBeanProperty(aclDeviceIndex, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.1", ISnmpConstant.INTEGER));
        initProperty(aclCardIndex, new SnmpMibBeanProperty(aclCardIndex, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.2", ISnmpConstant.INTEGER));
        initProperty(aclPortIndex, new SnmpMibBeanProperty(aclPortIndex, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.3", ISnmpConstant.INTEGER));
        initProperty(portAclListIndex, new SnmpMibBeanProperty(portAclListIndex, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.4", ISnmpConstant.INTEGER));
        initProperty(aclPortDirection, new SnmpMibBeanProperty(aclPortDirection, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.5", ISnmpConstant.OCTETS));
        //initProperty(aclAction, new SnmpMibBeanProperty(aclAction, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.6", ISnmpConstant.INTEGER));
        //initProperty(aclActionParameter, new SnmpMibBeanProperty(aclActionParameter, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.7", ISnmpConstant.OCTETS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.3.2.3.1.6", ISnmpConstant.INTEGER));
    }

    public Integer getAclDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setAclDeviceIndex(Integer aAclDeviceIndex) {
        setIndex(0, aAclDeviceIndex);
    }

    public Integer getAclCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setAclCardIndex(Integer aAclCardIndex) {
        setIndex(1, aAclCardIndex);
    }

    public Integer getAclPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setAclPortIndex(Integer aAclPortIndex) {
        setIndex(2, aAclPortIndex);
    }

    public Integer getPortAclListIndex() {
        return (Integer) getIndex(3);
    }

    public void setPortAclListIndex(Integer aPortAclListIndex) {
        setIndex(3, aPortAclListIndex);
    }

    public byte[] getAclPortDirection() {
        return (byte[]) getProperty(aclPortDirection).getValue();
    }

    public void setAclPortDirection(byte[] aAclPortDirection) {
        getProperty(aclPortDirection).setValue(aAclPortDirection);
    }

    /*
    public Integer getAclAction() {
        return (Integer) getProperty(aclAction).getValue();
    }

    public void setAclAction(Integer aAclAction) {
        getProperty(aclAction).setValue(aAclAction);
    }

    public byte[] getAclActionParameter() {
        return (byte[]) getProperty(aclActionParameter).getValue();
    }

    public void setAclActionParameter(byte[] aAclActionParameter) {
        getProperty(aclActionParameter).setValue(aAclActionParameter);
    }
    */

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(aclPortDirection));
        //prepareRead(getProperty(aclAction));
        //prepareRead(getProperty(aclActionParameter));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(aclPortDirection));
        //prepareRead(getProperty(aclAction));
        //prepareRead(getProperty(aclActionParameter));

        return loadAll(new int[]{1, 1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(aclPortDirection));
        //prepareSave(getProperty(aclAction));
        //prepareSave(getProperty(aclActionParameter));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(aclPortDirection));

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