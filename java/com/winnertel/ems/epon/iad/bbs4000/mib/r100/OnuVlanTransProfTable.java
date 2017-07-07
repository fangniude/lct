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

public class OnuVlanTransProfTable extends SnmpMibBean {

    public static final String onuVlanTransProfIndex1 = "onuVlanTransProfIndex1";
    public static final String onuVlanTransProfIndex2 = "onuVlanTransProfIndex2";
    public static final String onuVlanTransProfileName = "onuVlanTransProfileName";
    public static final String onuVlanTransProfDownstreamMode = "onuVlanTransProfDownstreamMode";
    public static final String onuVlanTransProfInputTPID = "onuVlanTransProfInputTPID";
    public static final String onuVlanTransProfOutputTPID = "onuVlanTransProfOutputTPID";
    public static final String onuVlanTransProfFilterOuterPriority = "onuVlanTransProfFilterOuterPriority";
    public static final String onuVlanTransProfFilterOuterVID = "onuVlanTransProfFilterOuterVID";
    public static final String onuVlanTransProfFilterOuterTPIDDE = "onuVlanTransProfFilterOuterTPIDDE";
    public static final String onuVlanTransProfFilterInnerPriority = "onuVlanTransProfFilterInnerPriority";
    public static final String onuVlanTransProfFilterInnerVID = "onuVlanTransProfFilterInnerVID";
    public static final String onuVlanTransProfFilterInnerTPIDDE = "onuVlanTransProfFilterInnerTPIDDE";
    public static final String onuVlanTransProfFilterEthertype = "onuVlanTransProfFilterEthertype";
    public static final String onuVlanTransProfTreatmentTagsRemove = "onuVlanTransProfTreatmentTagsRemove";
    public static final String onuVlanTransProfTreatmentOuterPriority = "onuVlanTransProfTreatmentOuterPriority";
    public static final String onuVlanTransProfTreatmentOuterVID = "onuVlanTransProfTreatmentOuterVID";
    public static final String onuVlanTransProfTreatmentOuterTPIDDE = "onuVlanTransProfTreatmentOuterTPIDDE";
    public static final String onuVlanTransProfTreatmentInnerPriority = "onuVlanTransProfTreatmentInnerPriority";
    public static final String onuVlanTransProfTreatmentInnerVID = "onuVlanTransProfTreatmentInnerVID";
    public static final String onuVlanTransProfTreatmentInnerTPIDDE = "onuVlanTransProfTreatmentInnerTPIDDE";
    public static final String onuVlanTransProfTreatmentTagsMode = "onuVlanTransProfTreatmentTagsMode";

    public OnuVlanTransProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuVlanTransProfIndex1, new SnmpMibBeanProperty(onuVlanTransProfIndex1, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.1", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfIndex2, new SnmpMibBeanProperty(onuVlanTransProfIndex2, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.2", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfileName, new SnmpMibBeanProperty(onuVlanTransProfileName, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.3", ISnmpConstant.STRING));
        initProperty(onuVlanTransProfDownstreamMode, new SnmpMibBeanProperty(onuVlanTransProfDownstreamMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.4", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfInputTPID, new SnmpMibBeanProperty(onuVlanTransProfInputTPID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.5", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfOutputTPID, new SnmpMibBeanProperty(onuVlanTransProfOutputTPID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.6", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfFilterOuterPriority, new SnmpMibBeanProperty(onuVlanTransProfFilterOuterPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.7", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfFilterOuterVID, new SnmpMibBeanProperty(onuVlanTransProfFilterOuterVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.8", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfFilterOuterTPIDDE, new SnmpMibBeanProperty(onuVlanTransProfFilterOuterTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.9", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfFilterInnerPriority, new SnmpMibBeanProperty(onuVlanTransProfFilterInnerPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.10", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfFilterInnerVID, new SnmpMibBeanProperty(onuVlanTransProfFilterInnerVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.11", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfFilterInnerTPIDDE, new SnmpMibBeanProperty(onuVlanTransProfFilterInnerTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.12", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfFilterEthertype, new SnmpMibBeanProperty(onuVlanTransProfFilterEthertype, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.13", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfTreatmentTagsRemove, new SnmpMibBeanProperty(onuVlanTransProfTreatmentTagsRemove, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.14", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfTreatmentOuterPriority, new SnmpMibBeanProperty(onuVlanTransProfTreatmentOuterPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.15", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfTreatmentOuterVID, new SnmpMibBeanProperty(onuVlanTransProfTreatmentOuterVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.16", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfTreatmentOuterTPIDDE, new SnmpMibBeanProperty(onuVlanTransProfTreatmentOuterTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.17", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfTreatmentInnerPriority, new SnmpMibBeanProperty(onuVlanTransProfTreatmentInnerPriority, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.18", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfTreatmentInnerVID, new SnmpMibBeanProperty(onuVlanTransProfTreatmentInnerVID, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.19", ISnmpConstant.GAUGE));
        initProperty(onuVlanTransProfTreatmentInnerTPIDDE, new SnmpMibBeanProperty(onuVlanTransProfTreatmentInnerTPIDDE, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.20", ISnmpConstant.INTEGER));
        initProperty(onuVlanTransProfTreatmentTagsMode, new SnmpMibBeanProperty(onuVlanTransProfTreatmentTagsMode, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.21", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.2.12.1.22", ISnmpConstant.INTEGER));
    }

    public Long getOnuVlanTransProfIndex1() {
        return (Long) getIndex(0);
    }

    public void setOnuVlanTransProfIndex1(Long aOnuVlanTransProfIndex1) {
        setIndex(0, aOnuVlanTransProfIndex1);
    }

    public Long getOnuVlanTransProfIndex2() {
        return (Long) getIndex(1);
    }

    public void setOnuVlanTransProfIndex2(Long aOnuVlanTransProfIndex2) {
        setIndex(1, aOnuVlanTransProfIndex2);
    }

    public String getOnuVlanTransProfileName() {
        return (String) getProperty(onuVlanTransProfileName).getValue();
    }

    public void setOnuVlanTransProfileName(String aOnuVlanTransProfileName) {
        getProperty(onuVlanTransProfileName).setValue(aOnuVlanTransProfileName);
    }

    public Integer getOnuVlanTransProfDownstreamMode() {
        return (Integer) getProperty(onuVlanTransProfDownstreamMode).getValue();
    }

    public void setOnuVlanTransProfDownstreamMode(Integer aOnuVlanTransProfDownstreamMode) {
        getProperty(onuVlanTransProfDownstreamMode).setValue(aOnuVlanTransProfDownstreamMode);
    }

    public Long getOnuVlanTransProfInputTPID() {
        return (Long) getProperty(onuVlanTransProfInputTPID).getValue();
    }

    public void setOnuVlanTransProfInputTPID(Long aOnuVlanTransProfInputTPID) {
        getProperty(onuVlanTransProfInputTPID).setValue(aOnuVlanTransProfInputTPID);
    }

    public Long getOnuVlanTransProfOutputTPID() {
        return (Long) getProperty(onuVlanTransProfOutputTPID).getValue();
    }

    public void setOnuVlanTransProfOutputTPID(Long aOnuVlanTransProfOutputTPID) {
        getProperty(onuVlanTransProfOutputTPID).setValue(aOnuVlanTransProfOutputTPID);
    }

    public Long getOnuVlanTransProfFilterOuterPriority() {
        return (Long) getProperty(onuVlanTransProfFilterOuterPriority).getValue();
    }

    public void setOnuVlanTransProfFilterOuterPriority(Long aOnuVlanTransProfFilterOuterPriority) {
        getProperty(onuVlanTransProfFilterOuterPriority).setValue(aOnuVlanTransProfFilterOuterPriority);
    }

    public Long getOnuVlanTransProfFilterOuterVID() {
        return (Long) getProperty(onuVlanTransProfFilterOuterVID).getValue();
    }

    public void setOnuVlanTransProfFilterOuterVID(Long aOnuVlanTransProfFilterOuterVID) {
        getProperty(onuVlanTransProfFilterOuterVID).setValue(aOnuVlanTransProfFilterOuterVID);
    }

    public Long getOnuVlanTransProfFilterInnerPriority() {
        return (Long) getProperty(onuVlanTransProfFilterInnerPriority).getValue();
    }

    public void setOnuVlanTransProfFilterInnerPriority(Long aOnuVlanTransProfFilterInnerPriority) {
        getProperty(onuVlanTransProfFilterInnerPriority).setValue(aOnuVlanTransProfFilterInnerPriority);
    }

    public Long getOnuVlanTransProfFilterInnerVID() {
        return (Long) getProperty(onuVlanTransProfFilterInnerVID).getValue();
    }

    public void setOnuVlanTransProfFilterInnerVID(Long aOnuVlanTransProfFilterInnerVID) {
        getProperty(onuVlanTransProfFilterInnerVID).setValue(aOnuVlanTransProfFilterInnerVID);
    }

    public Long getOnuVlanTransProfFilterEthertype() {
        return (Long) getProperty(onuVlanTransProfFilterEthertype).getValue();
    }

    public void setOnuVlanTransProfFilterEthertype(Long aOnuVlanTransProfFilterEthertype) {
        getProperty(onuVlanTransProfFilterEthertype).setValue(aOnuVlanTransProfFilterEthertype);
    }

    public Integer getOnuVlanTransProfTreatmentTagsRemove() {
        return (Integer) getProperty(onuVlanTransProfTreatmentTagsRemove).getValue();
    }

    public void setOnuVlanTransProfTreatmentTagsRemove(Integer aOnuVlanTransProfTreatmentTagsRemove) {
        getProperty(onuVlanTransProfTreatmentTagsRemove).setValue(aOnuVlanTransProfTreatmentTagsRemove);
    }

    public Long getOnuVlanTransProfTreatmentOuterPriority() {
        return (Long) getProperty(onuVlanTransProfTreatmentOuterPriority).getValue();
    }

    public void setOnuVlanTransProfTreatmentOuterPriority(Long aOnuVlanTransProfTreatmentOuterPriority) {
        getProperty(onuVlanTransProfTreatmentOuterPriority).setValue(aOnuVlanTransProfTreatmentOuterPriority);
    }

    public Long getOnuVlanTransProfTreatmentOuterVID() {
        return (Long) getProperty(onuVlanTransProfTreatmentOuterVID).getValue();
    }

    public void setOnuVlanTransProfTreatmentOuterVID(Long aOnuVlanTransProfTreatmentOuterVID) {
        getProperty(onuVlanTransProfTreatmentOuterVID).setValue(aOnuVlanTransProfTreatmentOuterVID);
    }

    public Long getOnuVlanTransProfTreatmentInnerPriority() {
        return (Long) getProperty(onuVlanTransProfTreatmentInnerPriority).getValue();
    }

    public void setOnuVlanTransProfTreatmentInnerPriority(Long aOnuVlanTransProfTreatmentInnerPriority) {
        getProperty(onuVlanTransProfTreatmentInnerPriority).setValue(aOnuVlanTransProfTreatmentInnerPriority);
    }

    public Long getOnuVlanTransProfTreatmentInnerVID() {
        return (Long) getProperty(onuVlanTransProfTreatmentInnerVID).getValue();
    }

    public void setOnuVlanTransProfTreatmentInnerVID(Long aOnuVlanTransProfTreatmentInnerVID) {
        getProperty(onuVlanTransProfTreatmentInnerVID).setValue(aOnuVlanTransProfTreatmentInnerVID);
    }

    public Integer getOnuVlanTransProfTreatmentInnerTPIDDE() {
        return (Integer) getProperty(onuVlanTransProfTreatmentInnerTPIDDE).getValue();
    }

    public void setOnuVlanTransProfTreatmentInnerTPIDDE(Integer aOnuVlanTransProfTreatmentInnerTPIDDE) {
        getProperty(onuVlanTransProfTreatmentInnerTPIDDE).setValue(aOnuVlanTransProfTreatmentInnerTPIDDE);
    }

    public Integer getOnuVlanTransProfTreatmentTagsMode() {
        return (Integer) getProperty(onuVlanTransProfTreatmentTagsMode).getValue();
    }

    public void setOnuVlanTransProfTreatmentTagsMode(Integer aOnuVlanTransProfTreatmentTagsMode) {
        getProperty(onuVlanTransProfTreatmentTagsMode).setValue(aOnuVlanTransProfTreatmentTagsMode);
    }

    public Integer getOnuVlanTransProfFilterInnerTPIDDE() {
        return (Integer) getProperty(onuVlanTransProfFilterInnerTPIDDE).getValue();
    }

    public void setOnuVlanTransProfFilterInnerTPIDDE(Integer aOnuVlanTransProfFilterInnerTPIDDE) {
        getProperty(onuVlanTransProfFilterInnerTPIDDE).setValue(aOnuVlanTransProfFilterInnerTPIDDE);
    }

    public Integer getOnuVlanTransProfTreatmentOuterTPIDDE() {
        return (Integer) getProperty(onuVlanTransProfTreatmentOuterTPIDDE).getValue();
    }

    public void setOnuVlanTransProfTreatmentOuterTPIDDE(Integer aOnuVlanTransProfTreatmentOuterTPIDDE) {
        getProperty(onuVlanTransProfTreatmentOuterTPIDDE).setValue(aOnuVlanTransProfTreatmentOuterTPIDDE);
    }

    public Integer getOnuVlanTransProfFilterOuterTPIDDE() {
        return (Integer) getProperty(onuVlanTransProfFilterOuterTPIDDE).getValue();
    }

    public void setOnuVlanTransProfFilterOuterTPIDDE(Integer aOnuVlanTransProfFilterOuterTPIDDE) {
        getProperty(onuVlanTransProfFilterOuterTPIDDE).setValue(aOnuVlanTransProfFilterOuterTPIDDE);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanTransProfileName));
        prepareRead(super.getProperty(onuVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(onuVlanTransProfInputTPID));
        prepareRead(super.getProperty(onuVlanTransProfOutputTPID));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentTagsMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuVlanTransProfileName));
        prepareRead(super.getProperty(onuVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(onuVlanTransProfInputTPID));
        prepareRead(super.getProperty(onuVlanTransProfOutputTPID));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(onuVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(onuVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(onuVlanTransProfTreatmentTagsMode));

        return loadAll(new int[]{2, 2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuVlanTransProfileName));
        prepareSave(getProperty(onuVlanTransProfDownstreamMode));
        prepareSave(getProperty(onuVlanTransProfInputTPID));
        prepareSave(getProperty(onuVlanTransProfOutputTPID));
        prepareSave(getProperty(onuVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(onuVlanTransProfFilterOuterVID));
        prepareSave(getProperty(onuVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(onuVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(onuVlanTransProfFilterInnerVID));
        prepareSave(getProperty(onuVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(onuVlanTransProfFilterEthertype));
        prepareSave(getProperty(onuVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(onuVlanTransProfTreatmentTagsMode));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuVlanTransProfileName));
        prepareSave(getProperty(onuVlanTransProfDownstreamMode));
        prepareSave(getProperty(onuVlanTransProfInputTPID));
        prepareSave(getProperty(onuVlanTransProfOutputTPID));
        prepareSave(getProperty(onuVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(onuVlanTransProfFilterOuterVID));
        prepareSave(getProperty(onuVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(onuVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(onuVlanTransProfFilterInnerVID));
        prepareSave(getProperty(onuVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(onuVlanTransProfFilterEthertype));
        prepareSave(getProperty(onuVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(onuVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(onuVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(onuVlanTransProfTreatmentTagsMode));

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
        return getOnuVlanTransProfileName();
    }

}