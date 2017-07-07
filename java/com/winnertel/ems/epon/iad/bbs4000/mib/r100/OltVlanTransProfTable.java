/**
 * Title          :   OltVlanTransProfTable.java
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

public class OltVlanTransProfTable extends SnmpMibBean {

    public static final String oltVlanTransProfIndex1 = "oltVlanTransProfIndex1";
    public static final String oltVlanTransProfIndex2 = "oltVlanTransProfIndex2";
    public static final String oltVlanTransProfileName = "oltVlanTransProfileName";
    public static final String oltVlanTransProfDownstreamMode = "oltVlanTransProfDownstreamMode";
    public static final String oltVlanTransProfInputTPID = "oltVlanTransProfInputTPID";
    public static final String oltVlanTransProfOutputTPID = "oltVlanTransProfOutputTPID";
    public static final String oltVlanTransProfFilterOuterPriority = "oltVlanTransProfFilterOuterPriority";
    public static final String oltVlanTransProfFilterOuterVID = "oltVlanTransProfFilterOuterVID";
    public static final String oltVlanTransProfFilterOuterTPIDDE = "oltVlanTransProfFilterOuterTPIDDE";
    public static final String oltVlanTransProfFilterInnerPriority = "oltVlanTransProfFilterInnerPriority";
    public static final String oltVlanTransProfFilterInnerVID = "oltVlanTransProfFilterInnerVID";
    public static final String oltVlanTransProfFilterInnerTPIDDE = "oltVlanTransProfFilterInnerTPIDDE";
    public static final String oltVlanTransProfFilterEthertype = "oltVlanTransProfFilterEthertype";
    public static final String oltVlanTransProfTreatmentTagsRemove = "oltVlanTransProfTreatmentTagsRemove";
    public static final String oltVlanTransProfTreatmentOuterPriority = "oltVlanTransProfTreatmentOuterPriority";
    public static final String oltVlanTransProfTreatmentOuterVID = "oltVlanTransProfTreatmentOuterVID";
    public static final String oltVlanTransProfTreatmentOuterTPIDDE = "oltVlanTransProfTreatmentOuterTPIDDE";
    public static final String oltVlanTransProfTreatmentInnerPriority = "oltVlanTransProfTreatmentInnerPriority";
    public static final String oltVlanTransProfTreatmentInnerVID = "oltVlanTransProfTreatmentInnerVID";
    public static final String oltVlanTransProfTreatmentInnerTPIDDE = "oltVlanTransProfTreatmentInnerTPIDDE";
    public static final String oltVlanTransProfTreatmentTagsMode = "oltVlanTransProfTreatmentTagsMode";

    public OltVlanTransProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltVlanTransProfIndex1, new SnmpMibBeanProperty(oltVlanTransProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.1", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfIndex2, new SnmpMibBeanProperty(oltVlanTransProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.2", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfileName, new SnmpMibBeanProperty(oltVlanTransProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.3", ISnmpConstant.STRING));
        initProperty(oltVlanTransProfDownstreamMode, new SnmpMibBeanProperty(oltVlanTransProfDownstreamMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.4", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfInputTPID, new SnmpMibBeanProperty(oltVlanTransProfInputTPID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.5", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfOutputTPID, new SnmpMibBeanProperty(oltVlanTransProfOutputTPID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.6", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfFilterOuterPriority, new SnmpMibBeanProperty(oltVlanTransProfFilterOuterPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.7", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfFilterOuterVID, new SnmpMibBeanProperty(oltVlanTransProfFilterOuterVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.8", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfFilterOuterTPIDDE, new SnmpMibBeanProperty(oltVlanTransProfFilterOuterTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.9", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfFilterInnerPriority, new SnmpMibBeanProperty(oltVlanTransProfFilterInnerPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.10", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfFilterInnerVID, new SnmpMibBeanProperty(oltVlanTransProfFilterInnerVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.11", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfFilterInnerTPIDDE, new SnmpMibBeanProperty(oltVlanTransProfFilterInnerTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.12", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfFilterEthertype, new SnmpMibBeanProperty(oltVlanTransProfFilterEthertype, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.13", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfTreatmentTagsRemove, new SnmpMibBeanProperty(oltVlanTransProfTreatmentTagsRemove, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.14", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfTreatmentOuterPriority, new SnmpMibBeanProperty(oltVlanTransProfTreatmentOuterPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.15", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfTreatmentOuterVID, new SnmpMibBeanProperty(oltVlanTransProfTreatmentOuterVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.16", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfTreatmentOuterTPIDDE, new SnmpMibBeanProperty(oltVlanTransProfTreatmentOuterTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.17", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfTreatmentInnerPriority, new SnmpMibBeanProperty(oltVlanTransProfTreatmentInnerPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.18", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfTreatmentInnerVID, new SnmpMibBeanProperty(oltVlanTransProfTreatmentInnerVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.19", ISnmpConstant.GAUGE));
        initProperty(oltVlanTransProfTreatmentInnerTPIDDE, new SnmpMibBeanProperty(oltVlanTransProfTreatmentInnerTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.20", ISnmpConstant.INTEGER));
        initProperty(oltVlanTransProfTreatmentTagsMode, new SnmpMibBeanProperty(oltVlanTransProfTreatmentTagsMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.21", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.11.1.22", ISnmpConstant.INTEGER));
    }

    public Long getOltVlanTransProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOltVlanTransProfIndex1(Long aOltVlanTransProfIndex1) {
        setIndex(0, aOltVlanTransProfIndex1);
    }

    public Long getOltVlanTransProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOltVlanTransProfIndex2(Long aOltVlanTransProfIndex2) {
        setIndex(1, aOltVlanTransProfIndex2);
    }

    public String getOltVlanTransProfileName() {
        return (String) getProperty(oltVlanTransProfileName).getValue();
    }

    public void setOltVlanTransProfileName(String aOltVlanTransProfileName) {
        getProperty(oltVlanTransProfileName).setValue(aOltVlanTransProfileName);
    }

    public Integer getOltVlanTransProfDownstreamMode() {
        return (Integer) getProperty(oltVlanTransProfDownstreamMode).getValue();
    }

    public void setOltVlanTransProfDownstreamMode(Integer aOltVlanTransProfDownstreamMode) {
        getProperty(oltVlanTransProfDownstreamMode).setValue(aOltVlanTransProfDownstreamMode);
    }

    public Long getOltVlanTransProfInputTPID() {
        return (Long) getProperty(oltVlanTransProfInputTPID).getValue();
    }

    public void setOltVlanTransProfInputTPID(Long aOltVlanTransProfInputTPID) {
        getProperty(oltVlanTransProfInputTPID).setValue(aOltVlanTransProfInputTPID);
    }

    public Long getOltVlanTransProfOutputTPID() {
        return (Long) getProperty(oltVlanTransProfOutputTPID).getValue();
    }

    public void setOltVlanTransProfOutputTPID(Long aOltVlanTransProfOutputTPID) {
        getProperty(oltVlanTransProfOutputTPID).setValue(aOltVlanTransProfOutputTPID);
    }

    public Long getOltVlanTransProfFilterOuterPriority() {
        return (Long) getProperty(oltVlanTransProfFilterOuterPriority).getValue();
    }

    public void setOltVlanTransProfFilterOuterPriority(Long aOltVlanTransProfFilterOuterPriority) {
        getProperty(oltVlanTransProfFilterOuterPriority).setValue(aOltVlanTransProfFilterOuterPriority);
    }

    public Long getOltVlanTransProfFilterOuterVID() {
        return (Long) getProperty(oltVlanTransProfFilterOuterVID).getValue();
    }

    public void setOltVlanTransProfFilterOuterVID(Long aOltVlanTransProfFilterOuterVID) {
        getProperty(oltVlanTransProfFilterOuterVID).setValue(aOltVlanTransProfFilterOuterVID);
    }

    public Long getOltVlanTransProfFilterInnerPriority() {
        return (Long) getProperty(oltVlanTransProfFilterInnerPriority).getValue();
    }

    public void setOltVlanTransProfFilterInnerPriority(Long aOltVlanTransProfFilterInnerPriority) {
        getProperty(oltVlanTransProfFilterInnerPriority).setValue(aOltVlanTransProfFilterInnerPriority);
    }

    public Long getOltVlanTransProfFilterInnerVID() {
        return (Long) getProperty(oltVlanTransProfFilterInnerVID).getValue();
    }

    public void setOltVlanTransProfFilterInnerVID(Long aOltVlanTransProfFilterInnerVID) {
        getProperty(oltVlanTransProfFilterInnerVID).setValue(aOltVlanTransProfFilterInnerVID);
    }

    public Long getOltVlanTransProfFilterEthertype() {
        return (Long) getProperty(oltVlanTransProfFilterEthertype).getValue();
    }

    public void setOltVlanTransProfFilterEthertype(Long aOltVlanTransProfFilterEthertype) {
        getProperty(oltVlanTransProfFilterEthertype).setValue(aOltVlanTransProfFilterEthertype);
    }

    public Integer getOltVlanTransProfTreatmentTagsRemove() {
        return (Integer) getProperty(oltVlanTransProfTreatmentTagsRemove).getValue();
    }

    public void setOltVlanTransProfTreatmentTagsRemove(Integer aOltVlanTransProfTreatmentTagsRemove) {
        getProperty(oltVlanTransProfTreatmentTagsRemove).setValue(aOltVlanTransProfTreatmentTagsRemove);
    }

    public Long getOltVlanTransProfTreatmentOuterPriority() {
        return (Long) getProperty(oltVlanTransProfTreatmentOuterPriority).getValue();
    }

    public void setOltVlanTransProfTreatmentOuterPriority(Long aOltVlanTransProfTreatmentOuterPriority) {
        getProperty(oltVlanTransProfTreatmentOuterPriority).setValue(aOltVlanTransProfTreatmentOuterPriority);
    }

    public Long getOltVlanTransProfTreatmentOuterVID() {
        return (Long) getProperty(oltVlanTransProfTreatmentOuterVID).getValue();
    }

    public void setOltVlanTransProfTreatmentOuterVID(Long aOltVlanTransProfTreatmentOuterVID) {
        getProperty(oltVlanTransProfTreatmentOuterVID).setValue(aOltVlanTransProfTreatmentOuterVID);
    }

    public Long getOltVlanTransProfTreatmentInnerPriority() {
        return (Long) getProperty(oltVlanTransProfTreatmentInnerPriority).getValue();
    }

    public void setOltVlanTransProfTreatmentInnerPriority(Long aOltVlanTransProfTreatmentInnerPriority) {
        getProperty(oltVlanTransProfTreatmentInnerPriority).setValue(aOltVlanTransProfTreatmentInnerPriority);
    }

    public Long getOltVlanTransProfTreatmentInnerVID() {
        return (Long) getProperty(oltVlanTransProfTreatmentInnerVID).getValue();
    }

    public void setOltVlanTransProfTreatmentInnerVID(Long aOltVlanTransProfTreatmentInnerVID) {
        getProperty(oltVlanTransProfTreatmentInnerVID).setValue(aOltVlanTransProfTreatmentInnerVID);
    }

    public Integer getOltVlanTransProfTreatmentInnerTPIDDE() {
        return (Integer) getProperty(oltVlanTransProfTreatmentInnerTPIDDE).getValue();
    }

    public void setOltVlanTransProfTreatmentInnerTPIDDE(Integer aOltVlanTransProfTreatmentInnerTPIDDE) {
        getProperty(oltVlanTransProfTreatmentInnerTPIDDE).setValue(aOltVlanTransProfTreatmentInnerTPIDDE);
    }

    public Integer getOltVlanTransProfTreatmentTagsMode() {
        return (Integer) getProperty(oltVlanTransProfTreatmentTagsMode).getValue();
    }

    public void setOltVlanTransProfTreatmentTagsMode(Integer aOltVlanTransProfTreatmentTagsMode) {
        getProperty(oltVlanTransProfTreatmentTagsMode).setValue(aOltVlanTransProfTreatmentTagsMode);
    }

    public Integer getOltVlanTransProfFilterInnerTPIDDE() {
        return (Integer) getProperty(oltVlanTransProfFilterInnerTPIDDE).getValue();
    }

    public void setOltVlanTransProfFilterInnerTPIDDE(Integer aOltVlanTransProfFilterInnerTPIDDE) {
        getProperty(oltVlanTransProfFilterInnerTPIDDE).setValue(aOltVlanTransProfFilterInnerTPIDDE);
    }

    public Integer getOltVlanTransProfTreatmentOuterTPIDDE() {
        return (Integer) getProperty(oltVlanTransProfTreatmentOuterTPIDDE).getValue();
    }

    public void setOltVlanTransProfTreatmentOuterTPIDDE(Integer aOltVlanTransProfTreatmentOuterTPIDDE) {
        getProperty(oltVlanTransProfTreatmentOuterTPIDDE).setValue(aOltVlanTransProfTreatmentOuterTPIDDE);
    }

    public Integer getOltVlanTransProfFilterOuterTPIDDE() {
        return (Integer) getProperty(oltVlanTransProfFilterOuterTPIDDE).getValue();
    }

    public void setOltVlanTransProfFilterOuterTPIDDE(Integer aOltVlanTransProfFilterOuterTPIDDE) {
        getProperty(oltVlanTransProfFilterOuterTPIDDE).setValue(aOltVlanTransProfFilterOuterTPIDDE);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(oltVlanTransProfileName));
        prepareRead(super.getProperty(oltVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(oltVlanTransProfInputTPID));
        prepareRead(super.getProperty(oltVlanTransProfOutputTPID));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentTagsMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(oltVlanTransProfileName));
        prepareRead(super.getProperty(oltVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(oltVlanTransProfInputTPID));
        prepareRead(super.getProperty(oltVlanTransProfOutputTPID));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(oltVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(oltVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(oltVlanTransProfTreatmentTagsMode));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltVlanTransProfileName));
        prepareSave(getProperty(oltVlanTransProfDownstreamMode));
        prepareSave(getProperty(oltVlanTransProfInputTPID));
        prepareSave(getProperty(oltVlanTransProfOutputTPID));
        prepareSave(getProperty(oltVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(oltVlanTransProfFilterOuterVID));
        prepareSave(getProperty(oltVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(oltVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(oltVlanTransProfFilterInnerVID));
        prepareSave(getProperty(oltVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(oltVlanTransProfFilterEthertype));
        prepareSave(getProperty(oltVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(oltVlanTransProfTreatmentTagsMode));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(oltVlanTransProfileName));
        prepareSave(getProperty(oltVlanTransProfDownstreamMode));
        prepareSave(getProperty(oltVlanTransProfInputTPID));
        prepareSave(getProperty(oltVlanTransProfOutputTPID));
        prepareSave(getProperty(oltVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(oltVlanTransProfFilterOuterVID));
        prepareSave(getProperty(oltVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(oltVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(oltVlanTransProfFilterInnerVID));
        prepareSave(getProperty(oltVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(oltVlanTransProfFilterEthertype));
        prepareSave(getProperty(oltVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(oltVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(oltVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(oltVlanTransProfTreatmentTagsMode));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    //added by Zhou Chao, 2009/2/13
    public String toString() {
        return getOltVlanTransProfileName();
    }

}