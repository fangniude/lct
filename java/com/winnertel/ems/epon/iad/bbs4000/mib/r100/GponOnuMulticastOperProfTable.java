package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The GponOnuMulticastOperProfTable class.
 * Created by QuickDVM
 */
public class GponOnuMulticastOperProfTable extends SnmpMibBean {

    public static final String onuMulticastOperProfileIndex = "onuMulticastOperProfileIndex";
    public static final String onuMulticastOperProfileName = "onuMulticastOperProfileName";
    public static final String onuMulticastOperProfIgmpVersion = "onuMulticastOperProfIgmpVersion";
    public static final String onuMulticastOperProfMulticastControlMode = "onuMulticastOperProfMulticastControlMode";
    public static final String onuMulticastOperProfFastLeaveMode = "onuMulticastOperProfFastLeaveMode";
    public static final String onuMulticastOperProfUpstreamIGMPTCI = "onuMulticastOperProfUpstreamIGMPTCI";
    public static final String onuMulticastOperProfUpstreamIGMPTagControl = "onuMulticastOperProfUpstreamIGMPTagControl";
    public static final String onuMulticastOperProfMaxSimultaneousGroup = "onuMulticastOperProfMaxSimultaneousGroup";
    public static final String onuMulticastOperProfMulticastTagStrip = "onuMulticastOperProfMulticastTagStrip";

    public GponOnuMulticastOperProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuMulticastOperProfileIndex, new SnmpMibBeanProperty(
                onuMulticastOperProfileIndex,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.1", ISnmpConstant.GAUGE));
        initProperty(onuMulticastOperProfileName, new SnmpMibBeanProperty(
                onuMulticastOperProfileName,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.2", ISnmpConstant.STRING));
        initProperty(onuMulticastOperProfIgmpVersion, new SnmpMibBeanProperty(
                onuMulticastOperProfIgmpVersion,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.3", ISnmpConstant.INTEGER));
        initProperty(onuMulticastOperProfMulticastControlMode,
                new SnmpMibBeanProperty(
                        onuMulticastOperProfMulticastControlMode,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.4",
                        ISnmpConstant.INTEGER));
        initProperty(onuMulticastOperProfFastLeaveMode,
                new SnmpMibBeanProperty(onuMulticastOperProfFastLeaveMode,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.5",
                        ISnmpConstant.INTEGER));
        initProperty(onuMulticastOperProfUpstreamIGMPTCI,
                new SnmpMibBeanProperty(onuMulticastOperProfUpstreamIGMPTCI,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.6",
                        ISnmpConstant.GAUGE));
        initProperty(onuMulticastOperProfUpstreamIGMPTagControl,
                new SnmpMibBeanProperty(
                        onuMulticastOperProfUpstreamIGMPTagControl,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.7",
                        ISnmpConstant.GAUGE));
        initProperty(onuMulticastOperProfMaxSimultaneousGroup,
                new SnmpMibBeanProperty(
                        onuMulticastOperProfMaxSimultaneousGroup,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.8",
                        ISnmpConstant.GAUGE));
        initProperty(onuMulticastOperProfMulticastTagStrip,
                new SnmpMibBeanProperty(onuMulticastOperProfMulticastTagStrip,
                        ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.9",
                        ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
                ".1.3.6.1.4.1.41355.1.3.10.5.2.25.1.10", ISnmpConstant.INTEGER));

    }

    public Long getOnuMulticastOperProfileIndex() {
        return (Long) getIndex(0);
    }

    public void setOnuMulticastOperProfileIndex(Long aOnuMulticastOperProfileIndex) {
        setIndex(0, aOnuMulticastOperProfileIndex);
    }

    public String getOnuMulticastOperProfileName() {
        return (String) getProperty(onuMulticastOperProfileName).getValue();
    }

    public void setOnuMulticastOperProfileName(String aOnuMulticastOperProfileName) {
        getProperty(onuMulticastOperProfileName).setValue(aOnuMulticastOperProfileName);
    }

    public Integer getOnuMulticastOperProfIgmpVersion() {
        return (Integer) getProperty(onuMulticastOperProfIgmpVersion).getValue();
    }

    public void setOnuMulticastOperProfIgmpVersion(Integer aOnuMulticastOperProfIgmpVersion) {
        getProperty(onuMulticastOperProfIgmpVersion).setValue(aOnuMulticastOperProfIgmpVersion);
    }

    public Integer getOnuMulticastOperProfMulticastControlMode() {
        return (Integer) getProperty(onuMulticastOperProfMulticastControlMode).getValue();
    }

    public void setOnuMulticastOperProfMulticastControlMode(Integer aOnuMulticastOperProfMulticastControlMode) {
        getProperty(onuMulticastOperProfMulticastControlMode).setValue(aOnuMulticastOperProfMulticastControlMode);
    }

    public Integer getOnuMulticastOperProfFastLeaveMode() {
        return (Integer) getProperty(onuMulticastOperProfFastLeaveMode).getValue();
    }

    public void setOnuMulticastOperProfFastLeaveMode(Integer aOnuMulticastOperProfFastLeaveMode) {
        getProperty(onuMulticastOperProfFastLeaveMode).setValue(aOnuMulticastOperProfFastLeaveMode);
    }

    public Long getOnuMulticastOperProfUpstreamIGMPTCI() {
        return (Long) getProperty(onuMulticastOperProfUpstreamIGMPTCI)
                .getValue();
    }

    public void setOnuMulticastOperProfUpstreamIGMPTCI(Long aOnuMulticastOperProfUpstreamIGMPTCI) {
        getProperty(onuMulticastOperProfUpstreamIGMPTCI).setValue(aOnuMulticastOperProfUpstreamIGMPTCI);
    }

    public Long getOnuMulticastOperProfUpstreamIGMPTagControl() {
        return (Long) getProperty(onuMulticastOperProfUpstreamIGMPTagControl).getValue();
    }

    public void setOnuMulticastOperProfUpstreamIGMPTagControl(Long aOnuMulticastOperProfUpstreamIGMPTagControl) {
        getProperty(onuMulticastOperProfUpstreamIGMPTagControl).setValue(aOnuMulticastOperProfUpstreamIGMPTagControl);
    }

    public Long getOnuMulticastOperProfMaxSimultaneousGroup() {
        return (Long) getProperty(onuMulticastOperProfMaxSimultaneousGroup).getValue();
    }

    public void setOnuMulticastOperProfMaxSimultaneousGroup(Long aOnuMulticastOperProfMaxSimultaneousGroup) {
        getProperty(onuMulticastOperProfMaxSimultaneousGroup).setValue(aOnuMulticastOperProfMaxSimultaneousGroup);
    }

    public Integer getOnuMulticastOperProfMulticastTagStrip() {
        return (Integer) getProperty(onuMulticastOperProfMulticastTagStrip).getValue();
    }

    public void setOnuMulticastOperProfMulticastTagStrip(Integer aOnuMulticastOperProfMulticastTagStrip) {
        getProperty(onuMulticastOperProfMulticastTagStrip).setValue(
                aOnuMulticastOperProfMulticastTagStrip);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuMulticastOperProfileName));
        prepareRead(super.getProperty(onuMulticastOperProfIgmpVersion));
        prepareRead(super.getProperty(onuMulticastOperProfMulticastControlMode));
        prepareRead(super.getProperty(onuMulticastOperProfFastLeaveMode));
        prepareRead(super.getProperty(onuMulticastOperProfUpstreamIGMPTCI));
        prepareRead(super
                .getProperty(onuMulticastOperProfUpstreamIGMPTagControl));
        prepareRead(super.getProperty(onuMulticastOperProfMaxSimultaneousGroup));
        prepareRead(super.getProperty(onuMulticastOperProfMulticastTagStrip));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuMulticastOperProfileName));
        prepareRead(super.getProperty(onuMulticastOperProfIgmpVersion));
        prepareRead(super.getProperty(onuMulticastOperProfMulticastControlMode));
        prepareRead(super.getProperty(onuMulticastOperProfFastLeaveMode));
        prepareRead(super.getProperty(onuMulticastOperProfUpstreamIGMPTCI));
        prepareRead(super
                .getProperty(onuMulticastOperProfUpstreamIGMPTagControl));
        prepareRead(super.getProperty(onuMulticastOperProfMaxSimultaneousGroup));
        prepareRead(super.getProperty(onuMulticastOperProfMulticastTagStrip));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuMulticastOperProfileName));
        prepareSave(getProperty(onuMulticastOperProfIgmpVersion));
        prepareSave(getProperty(onuMulticastOperProfMulticastControlMode));
        prepareSave(getProperty(onuMulticastOperProfFastLeaveMode));
        prepareSave(getProperty(onuMulticastOperProfUpstreamIGMPTCI));
        prepareSave(getProperty(onuMulticastOperProfUpstreamIGMPTagControl));
        prepareSave(getProperty(onuMulticastOperProfMaxSimultaneousGroup));
        prepareSave(getProperty(onuMulticastOperProfMulticastTagStrip));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuMulticastOperProfileName));
        prepareSave(getProperty(onuMulticastOperProfIgmpVersion));
        prepareSave(getProperty(onuMulticastOperProfMulticastControlMode));
        prepareSave(getProperty(onuMulticastOperProfFastLeaveMode));
        prepareSave(getProperty(onuMulticastOperProfUpstreamIGMPTCI));
        prepareSave(getProperty(onuMulticastOperProfUpstreamIGMPTagControl));
        prepareSave(getProperty(onuMulticastOperProfMaxSimultaneousGroup));
        prepareSave(getProperty(onuMulticastOperProfMulticastTagStrip));
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOnuMulticastOperProfileName();
    }

}