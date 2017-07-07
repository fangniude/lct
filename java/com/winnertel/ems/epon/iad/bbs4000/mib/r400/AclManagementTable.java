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

public class AclManagementTable extends SnmpMibBean {

    public static final String aclListIndex = "aclListIndex";
    public static final String aclDescription = "aclDescription";
    public static final String aclRuleList = "aclRuleList";

    public AclManagementTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(aclListIndex, new SnmpMibBeanProperty(aclListIndex, ".1.3.6.1.4.1.17409.2.3.3.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(aclDescription, new SnmpMibBeanProperty(aclDescription, ".1.3.6.1.4.1.17409.2.3.3.2.1.1.2", ISnmpConstant.STRING));
        initProperty(aclRuleList, new SnmpMibBeanProperty(aclRuleList, ".1.3.6.1.4.1.17409.2.3.3.2.1.1.3", ISnmpConstant.OCTETS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.3.2.1.1.4", ISnmpConstant.INTEGER));
    }

    public Integer getAclListIndex() {
        return (Integer) getIndex(0);
    }

    public void setAclListIndex(Integer aAclListIndex) {
        setIndex(0, aAclListIndex);
    }

    public String getAclDescription() {
        return (String) getProperty(aclDescription).getValue();
    }

    public void setAclDescription(String aAclDescription) {
        getProperty(aclDescription).setValue(aAclDescription);
    }

    public byte[] getAclRuleList() {
        return (byte[]) getProperty(aclRuleList).getValue();
    }

    public void setAclRuleList(byte[] aAclRuleList) {
        getProperty(aclRuleList).setValue(aAclRuleList);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(aclDescription));
        prepareRead(getProperty(aclRuleList));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(aclDescription));
        prepareRead(getProperty(aclRuleList));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(aclDescription));
        prepareSave(getProperty(aclRuleList));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(aclDescription));
        prepareSave(getProperty(aclRuleList));

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