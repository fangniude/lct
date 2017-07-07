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

public class AclRuleTable extends SnmpMibBean {

    public static final String aclRuleIndex = "aclRuleIndex";
    public static final String matchedSourseMac = "matchedSourseMac";
    public static final String matchedDestinationMac = "matchedDestinationMac";
    public static final String matchedVlanId = "matchedVlanId";
    public static final String matchedEthernetType = "matchedEthernetType";
    public static final String matchedSourseIP = "matchedSourseIP";
    public static final String matchedDestinationIP = "matchedDestinationIP";
    public static final String matchedIpMessageType = "matchedIpMessageType";
    public static final String matchedDscp = "matchedDscp";
    public static final String matchedSoursePort = "matchedSoursePort";
    public static final String matchedDestinationPort = "matchedDestinationPort";
    public static final String matchedFieldSelection = "matchedFieldSelection";
    public static final String aclAction = "aclAction";
    public static final String aclActionParameter = "aclActionParameter";

    public AclRuleTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(aclRuleIndex, new SnmpMibBeanProperty(aclRuleIndex, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.1", ISnmpConstant.INTEGER));
        initProperty(matchedSourseMac, new SnmpMibBeanProperty(matchedSourseMac, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.2", ISnmpConstant.MAC_ADDRESS));
        initProperty(matchedDestinationMac, new SnmpMibBeanProperty(matchedDestinationMac, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.3", ISnmpConstant.MAC_ADDRESS));
        initProperty(matchedVlanId, new SnmpMibBeanProperty(matchedVlanId, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.4", ISnmpConstant.INTEGER));
        initProperty(matchedEthernetType, new SnmpMibBeanProperty(matchedEthernetType, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.5", ISnmpConstant.INTEGER));
        initProperty(matchedSourseIP, new SnmpMibBeanProperty(matchedSourseIP, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.6", ISnmpConstant.IP_ADDRESS));
        initProperty(matchedDestinationIP, new SnmpMibBeanProperty(matchedDestinationIP, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.7", ISnmpConstant.IP_ADDRESS));
        initProperty(matchedIpMessageType, new SnmpMibBeanProperty(matchedIpMessageType, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.8", ISnmpConstant.INTEGER));
        initProperty(matchedDscp, new SnmpMibBeanProperty(matchedDscp, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.9", ISnmpConstant.INTEGER));
        initProperty(matchedSoursePort, new SnmpMibBeanProperty(matchedSoursePort, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.10", ISnmpConstant.INTEGER));
        initProperty(matchedDestinationPort, new SnmpMibBeanProperty(matchedDestinationPort, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.11", ISnmpConstant.INTEGER));

        initProperty(matchedFieldSelection, new SnmpMibBeanProperty(matchedFieldSelection, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.13", ISnmpConstant.OCTETS));
        initProperty(aclAction, new SnmpMibBeanProperty(aclAction, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.14", ISnmpConstant.INTEGER));
        initProperty(aclActionParameter, new SnmpMibBeanProperty(aclActionParameter, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.15", ISnmpConstant.OCTETS));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.3.2.2.1.12", ISnmpConstant.INTEGER));
    }

    public Integer getAclRuleIndex() {
        return (Integer) getIndex(0);
    }

    public void setAclRuleIndex(Integer aAclRuleIndex) {
        setIndex(0, aAclRuleIndex);
    }

    public byte[] getMatchedSourseMac() {
        return (byte[]) getProperty(matchedSourseMac).getValue();
    }

    public void setMatchedSourseMac(byte[] aMatchedSourseMac) {
        getProperty(matchedSourseMac).setValue(aMatchedSourseMac);
    }

    public byte[] getMatchedDestinationMac() {
        return (byte[]) getProperty(matchedDestinationMac).getValue();
    }

    public void setMatchedDestinationMac(byte[] aMatchedDestinationMac) {
        getProperty(matchedDestinationMac).setValue(aMatchedDestinationMac);
    }

    public Integer getMatchedVlanId() {
        return (Integer) getProperty(matchedVlanId).getValue();
    }

    public void setMatchedVlanId(Integer aMatchedVlanId) {
        getProperty(matchedVlanId).setValue(aMatchedVlanId);
    }

    public Integer getMatchedEthernetType() {
        return (Integer) getProperty(matchedEthernetType).getValue();
    }

    public void setMatchedEthernetType(Integer aMatchedEthernetType) {
        getProperty(matchedEthernetType).setValue(aMatchedEthernetType);
    }

    public String getMatchedSourseIP() {
        return (String) getProperty(matchedSourseIP).getValue();
    }

    public void setMatchedSourseIP(String aMatchedSourseIP) {
        getProperty(matchedSourseIP).setValue(aMatchedSourseIP);
    }

    public String getMatchedDestinationIP() {
        return (String) getProperty(matchedDestinationIP).getValue();
    }

    public void setMatchedDestinationIP(String aMatchedDestinationIP) {
        getProperty(matchedDestinationIP).setValue(aMatchedDestinationIP);
    }

    public Integer getMatchedIpMessageType() {
        return (Integer) getProperty(matchedIpMessageType).getValue();
    }

    public void setMatchedIpMessageType(Integer aMatchedIpMessageType) {
        getProperty(matchedIpMessageType).setValue(aMatchedIpMessageType);
    }

    public Integer getMatchedDscp() {
        return (Integer) getProperty(matchedDscp).getValue();
    }

    public void setMatchedDscp(Integer aMatchedDscp) {
        getProperty(matchedDscp).setValue(aMatchedDscp);
    }

    public Integer getMatchedSoursePort() {
        return (Integer) getProperty(matchedSoursePort).getValue();
    }

    public void setMatchedSoursePort(Integer aMatchedSoursePort) {
        getProperty(matchedSoursePort).setValue(aMatchedSoursePort);
    }

    public Integer getMatchedDestinationPort() {
        return (Integer) getProperty(matchedDestinationPort).getValue();
    }

    public void setMatchedDestinationPort(Integer aMatchedDestinationPort) {
        getProperty(matchedDestinationPort).setValue(aMatchedDestinationPort);
    }

    public byte[] getMatchedFieldSelection() {
        return (byte[]) getProperty(matchedFieldSelection).getValue();
    }

    public void setMatchedFieldSelection(byte[] aMatchedFieldSelection) {
        getProperty(matchedFieldSelection).setValue(aMatchedFieldSelection);
    }

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

    public byte[] getAclActionValue() {
        return (byte[]) getProperty(aclActionParameter).getValue();
    }

    public void setAclActionValue(byte[] aAclActionParameter) {
        getProperty(aclActionParameter).setValue(aAclActionParameter);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(matchedSourseMac));
        prepareRead(getProperty(matchedDestinationMac));
        prepareRead(getProperty(matchedVlanId));
        prepareRead(getProperty(matchedEthernetType));
        prepareRead(getProperty(matchedSourseIP));
        prepareRead(getProperty(matchedDestinationIP));
        prepareRead(getProperty(matchedIpMessageType));
        prepareRead(getProperty(matchedDscp));
        prepareRead(getProperty(matchedSoursePort));
        prepareRead(getProperty(matchedDestinationPort));
        prepareRead(getProperty(matchedFieldSelection));
        prepareRead(getProperty(aclAction));
        prepareRead(getProperty(aclActionParameter));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(matchedSourseMac));
        prepareRead(getProperty(matchedDestinationMac));
        prepareRead(getProperty(matchedVlanId));
        prepareRead(getProperty(matchedEthernetType));
        prepareRead(getProperty(matchedSourseIP));
        prepareRead(getProperty(matchedDestinationIP));
        prepareRead(getProperty(matchedIpMessageType));
        prepareRead(getProperty(matchedDscp));
        prepareRead(getProperty(matchedSoursePort));
        prepareRead(getProperty(matchedDestinationPort));
        prepareRead(getProperty(matchedFieldSelection));
        prepareRead(getProperty(aclAction));
        prepareRead(getProperty(aclActionParameter));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(matchedSourseMac));
        prepareSave(getProperty(matchedDestinationMac));
        prepareSave(getProperty(matchedVlanId));
        prepareSave(getProperty(matchedEthernetType));
        prepareSave(getProperty(matchedSourseIP));
        prepareSave(getProperty(matchedDestinationIP));
        prepareSave(getProperty(matchedIpMessageType));
        prepareSave(getProperty(matchedDscp));
        prepareSave(getProperty(matchedSoursePort));
        prepareSave(getProperty(matchedDestinationPort));
        prepareSave(getProperty(matchedFieldSelection));
        prepareSave(getProperty(aclAction));
        prepareSave(getProperty(aclActionParameter));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(matchedSourseMac));
        prepareSave(getProperty(matchedDestinationMac));
        prepareSave(getProperty(matchedVlanId));
        prepareSave(getProperty(matchedEthernetType));
        prepareSave(getProperty(matchedSourseIP));
        prepareSave(getProperty(matchedDestinationIP));
        prepareSave(getProperty(matchedIpMessageType));
        prepareSave(getProperty(matchedDscp));
        prepareSave(getProperty(matchedSoursePort));
        prepareSave(getProperty(matchedDestinationPort));
        prepareSave(getProperty(matchedFieldSelection));
        prepareSave(getProperty(aclAction));
        prepareSave(getProperty(aclActionParameter));

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