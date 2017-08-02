package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuOltVlanTransProfTable class.
 * Created by QuickDVM
 */
public class OnuOltVlanTransProfTable extends SnmpMibBean {
    public static final String onuOltVlanTransProfSlotNo = "onuOltVlanTransProfSlotNo";
    public static final String onuOltVlanTransProfPortNo = "onuOltVlanTransProfPortNo";
    public static final String onuOltVlanTransProfLogicalPortNo = "onuOltVlanTransProfLogicalPortNo";
    public static final String onuOltVlanTransProfOnuUniPortNo = "onuOltVlanTransProfOnuUniPortNo";
    public static final String onuOltVlanTransProfIndex1 = "onuOltVlanTransProfIndex1";
    public static final String onuOltVlanTransProfIndex2 = "onuOltVlanTransProfIndex2";
    public static final String onuOltVlanTransProfileName = "onuOltVlanTransProfileName";
    public static final String onuOltVlanTransProfDownstreamMode = "onuOltVlanTransProfDownstreamMode";
    public static final String onuOltVlanTransProfInputTPID = "onuOltVlanTransProfInputTPID";
    public static final String onuOltVlanTransProfOutputTPID = "onuOltVlanTransProfOutputTPID";
    public static final String onuOltVlanTransProfFilterOuterPriority = "onuOltVlanTransProfFilterOuterPriority";
    public static final String onuOltVlanTransProfFilterOuterVID = "onuOltVlanTransProfFilterOuterVID";
    public static final String onuOltVlanTransProfFilterOuterTPIDDE = "onuOltVlanTransProfFilterOuterTPIDDE";
    public static final String onuOltVlanTransProfFilterInnerPriority = "onuOltVlanTransProfFilterInnerPriority";
    public static final String onuOltVlanTransProfFilterInnerVID = "onuOltVlanTransProfFilterInnerVID";
    public static final String onuOltVlanTransProfFilterInnerTPIDDE = "onuOltVlanTransProfFilterInnerTPIDDE";
    public static final String onuOltVlanTransProfFilterEthertype = "onuOltVlanTransProfFilterEthertype";
    public static final String onuOltVlanTransProfTreatmentTagsRemove = "onuOltVlanTransProfTreatmentTagsRemove";
    public static final String onuOltVlanTransProfTreatmentOuterPriority = "onuOltVlanTransProfTreatmentOuterPriority";
    public static final String onuOltVlanTransProfTreatmentOuterVID = "onuOltVlanTransProfTreatmentOuterVID";
    public static final String onuOltVlanTransProfTreatmentOuterTPIDDE = "onuOltVlanTransProfTreatmentOuterTPIDDE";
    public static final String onuOltVlanTransProfTreatmentInnerPriority = "onuOltVlanTransProfTreatmentInnerPriority";
    public static final String onuOltVlanTransProfTreatmentInnerVID = "onuOltVlanTransProfTreatmentInnerVID";
    public static final String onuOltVlanTransProfTreatmentInnerTPIDDE = "onuOltVlanTransProfTreatmentInnerTPIDDE";
    public static final String onuOltVlanTransProfTreatmentTagsMode = "onuOltVlanTransProfTreatmentTagsMode";

    public OnuOltVlanTransProfTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
       
        initProperty(onuOltVlanTransProfSlotNo, new SnmpMibBeanProperty(onuOltVlanTransProfSlotNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.1", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfPortNo, new SnmpMibBeanProperty(onuOltVlanTransProfPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.2", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfLogicalPortNo, new SnmpMibBeanProperty(onuOltVlanTransProfLogicalPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.3", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfOnuUniPortNo, new SnmpMibBeanProperty(onuOltVlanTransProfOnuUniPortNo,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.4", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfIndex1, new SnmpMibBeanProperty(onuOltVlanTransProfIndex1,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.10", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfIndex2, new SnmpMibBeanProperty(onuOltVlanTransProfIndex2,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.11", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfileName, new SnmpMibBeanProperty(onuOltVlanTransProfileName,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.12", ISnmpConstant.STRING));
        initProperty(onuOltVlanTransProfDownstreamMode, new SnmpMibBeanProperty(onuOltVlanTransProfDownstreamMode,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.13", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfInputTPID, new SnmpMibBeanProperty(onuOltVlanTransProfInputTPID,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.14", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfOutputTPID, new SnmpMibBeanProperty(onuOltVlanTransProfOutputTPID,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.15", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfFilterOuterPriority,
                new SnmpMibBeanProperty(onuOltVlanTransProfFilterOuterPriority,
                        ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.16", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfFilterOuterVID, new SnmpMibBeanProperty(onuOltVlanTransProfFilterOuterVID,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.17", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfFilterOuterTPIDDE, new SnmpMibBeanProperty(
                onuOltVlanTransProfFilterOuterTPIDDE, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.18", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfFilterInnerPriority,
                new SnmpMibBeanProperty(onuOltVlanTransProfFilterInnerPriority,
                        ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.19", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfFilterInnerVID, new SnmpMibBeanProperty(onuOltVlanTransProfFilterInnerVID,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.20", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfFilterInnerTPIDDE, new SnmpMibBeanProperty(
                onuOltVlanTransProfFilterInnerTPIDDE, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.21", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfFilterEthertype, new SnmpMibBeanProperty(onuOltVlanTransProfFilterEthertype,
                ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.22", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfTreatmentTagsRemove,
                new SnmpMibBeanProperty(onuOltVlanTransProfTreatmentTagsRemove,
                        ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.23", ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfTreatmentOuterPriority, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentOuterPriority, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.24",
                ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfTreatmentOuterVID, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentOuterVID, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.25", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfTreatmentOuterTPIDDE, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentOuterTPIDDE, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.26",
                ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfTreatmentInnerPriority, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentInnerPriority, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.27",
                ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfTreatmentInnerVID, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentInnerVID, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.28", ISnmpConstant.GAUGE));
        initProperty(onuOltVlanTransProfTreatmentInnerTPIDDE, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentInnerTPIDDE, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.29",
                ISnmpConstant.INTEGER));
        initProperty(onuOltVlanTransProfTreatmentTagsMode, new SnmpMibBeanProperty(
                onuOltVlanTransProfTreatmentTagsMode, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.30", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1000.2.1.100",
                ISnmpConstant.INTEGER));

    }



    public Integer getOnuOltVlanTransProfSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuOltVlanTransProfSlotNo(Integer aOnuOltVlanTransProfSlotNo) {
        setIndex(0, aOnuOltVlanTransProfSlotNo);
    }

    public Integer getOnuOltVlanTransProfPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuOltVlanTransProfPortNo(Integer aOnuOltVlanTransProfPortNo) {
        setIndex(1, aOnuOltVlanTransProfPortNo);
    }

    public Integer getOnuOltVlanTransProfLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuOltVlanTransProfLogicalPortNo(Integer aOnuOltVlanTransProfLogicalPortNo) {
        setIndex(2, aOnuOltVlanTransProfLogicalPortNo);
    }
    
    public Integer getOnuOltVlanTransProfOnuUniPortNo() {
        return (Integer) getIndex(3);
    }

    public void setOnuOltVlanTransProfOnuUniPortNo(Integer aOnuOltVlanTransProfOnuUniPortNo) {
        setIndex(3, aOnuOltVlanTransProfOnuUniPortNo);
    }
    

    public Long getOnuOltVlanTransProfIndex1() {
        return (Long) getIndex(4);
    }

    public void setOnuOltVlanTransProfIndex1(Long aOnuOltVlanTransProfIndex1) {
        setIndex(4, aOnuOltVlanTransProfIndex1);
    }
    
    public Long getOnuOltVlanTransProfIndex2() {
        return (Long) getIndex(5);
    }

    public void setOnuOltVlanTransProfIndex2(Long aOltVlanTransProfIndex2) {
        setIndex(5, aOltVlanTransProfIndex2);
    }


    public String getOnuOltVlanTransProfileName() {
        return ((String) getProperty(onuOltVlanTransProfileName).getValue()).trim();
    }

    public void setOnuOltVlanTransProfileName(String aOnuOltVlanTransProfileName) {
        getProperty(onuOltVlanTransProfileName).setValue(aOnuOltVlanTransProfileName);
    }

    public Integer getOnuOltVlanTransProfDownstreamMode() {
        return (Integer) getProperty(onuOltVlanTransProfDownstreamMode).getValue();
    }

    public void setOnuOltVlanTransProfDownstreamMode(Integer aOnuOltVlanTransProfDownstreamMode) {
        getProperty(onuOltVlanTransProfDownstreamMode).setValue(aOnuOltVlanTransProfDownstreamMode);
    }

    public Long getOnuOltVlanTransProfInputTPID() {
        return (Long) getProperty(onuOltVlanTransProfInputTPID).getValue();
    }

    public void setOnuOltVlanTransProfInputTPID(Long aOnuOltVlanTransProfInputTPID) {
        getProperty(onuOltVlanTransProfInputTPID).setValue(aOnuOltVlanTransProfInputTPID);
    }

    public Long getOnuOltVlanTransProfOutputTPID() {
        return (Long) getProperty(onuOltVlanTransProfOutputTPID).getValue();
    }

    public void setOnuOltVlanTransProfOutputTPID(Long aOnuOltVlanTransProfOutputTPID) {
        getProperty(onuOltVlanTransProfOutputTPID).setValue(aOnuOltVlanTransProfOutputTPID);
    }

    public Long getOnuOltVlanTransProfFilterOuterPriority() {
        return (Long) getProperty(onuOltVlanTransProfFilterOuterPriority).getValue();
    }

    public void setOnuOltVlanTransProfFilterOuterPriority(Long aOnuOltVlanTransProfFilterOuterPriority) {
        getProperty(onuOltVlanTransProfFilterOuterPriority).setValue(aOnuOltVlanTransProfFilterOuterPriority);
    }

    public Long getOnuOltVlanTransProfFilterOuterVID() {
        return (Long) getProperty(onuOltVlanTransProfFilterOuterVID).getValue();
    }

    public void setOnuOltVlanTransProfFilterOuterVID(Long aOnuOltVlanTransProfFilterOuterVID) {
        getProperty(onuOltVlanTransProfFilterOuterVID).setValue(aOnuOltVlanTransProfFilterOuterVID);
    }

    public Integer getOnuOltVlanTransProfFilterOuterTPIDDE() {
        return (Integer) getProperty(onuOltVlanTransProfFilterOuterTPIDDE).getValue();
    }

    public void setOnuOltVlanTransProfFilterOuterTPIDDE(Integer aOnuOltVlanTransProfFilterOuterTPIDDE) {
        getProperty(onuOltVlanTransProfFilterOuterTPIDDE).setValue(aOnuOltVlanTransProfFilterOuterTPIDDE);
    }

    public Long getOnuOltVlanTransProfFilterInnerPriority() {
        return (Long) getProperty(onuOltVlanTransProfFilterInnerPriority).getValue();
    }

    public void setOnuOltVlanTransProfFilterInnerPriority(Long aOnuOltVlanTransProfFilterInnerPriority) {
        getProperty(onuOltVlanTransProfFilterInnerPriority).setValue(aOnuOltVlanTransProfFilterInnerPriority);
    }

    public Long getOnuOltVlanTransProfFilterInnerVID() {
        return (Long) getProperty(onuOltVlanTransProfFilterInnerVID).getValue();
    }

    public void setOnuOltVlanTransProfFilterInnerVID(Long aOnuOltVlanTransProfFilterInnerVID) {
        getProperty(onuOltVlanTransProfFilterInnerVID).setValue(aOnuOltVlanTransProfFilterInnerVID);
    }

    public Integer getOnuOltVlanTransProfFilterInnerTPIDDE() {
        return (Integer) getProperty(onuOltVlanTransProfFilterInnerTPIDDE).getValue();
    }

    public void setOnuOltVlanTransProfFilterInnerTPIDDE(Integer aOnuOltVlanTransProfFilterInnerTPIDDE) {
        getProperty(onuOltVlanTransProfFilterInnerTPIDDE).setValue(aOnuOltVlanTransProfFilterInnerTPIDDE);
    }

    public Long getOnuOltVlanTransProfFilterEthertype() {
        return (Long) getProperty(onuOltVlanTransProfFilterEthertype).getValue();
    }

    public void setOnuOltVlanTransProfFilterEthertype(Long aOnuOltVlanTransProfFilterEthertype) {
        getProperty(onuOltVlanTransProfFilterEthertype).setValue(aOnuOltVlanTransProfFilterEthertype);
    }

    public Integer getOnuOltVlanTransProfTreatmentTagsRemove() {
        return (Integer) getProperty(onuOltVlanTransProfTreatmentTagsRemove).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentTagsRemove(Integer aOnuOltVlanTransProfTreatmentTagsRemove) {
        getProperty(onuOltVlanTransProfTreatmentTagsRemove).setValue(aOnuOltVlanTransProfTreatmentTagsRemove);
    }

    public Long getOnuOltVlanTransProfTreatmentOuterPriority() {
        return (Long) getProperty(onuOltVlanTransProfTreatmentOuterPriority).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentOuterPriority(Long aOnuOltVlanTransProfTreatmentOuterPriority) {
        getProperty(onuOltVlanTransProfTreatmentOuterPriority).setValue(aOnuOltVlanTransProfTreatmentOuterPriority);
    }

    public Long getOnuOltVlanTransProfTreatmentOuterVID() {
        return (Long) getProperty(onuOltVlanTransProfTreatmentOuterVID).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentOuterVID(Long aOnuOltVlanTransProfTreatmentOuterVID) {
        getProperty(onuOltVlanTransProfTreatmentOuterVID).setValue(aOnuOltVlanTransProfTreatmentOuterVID);
    }

    public Integer getOnuOltVlanTransProfTreatmentOuterTPIDDE() {
        return (Integer) getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentOuterTPIDDE(Integer aOnuOltVlanTransProfTreatmentOuterTPIDDE) {
        getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE).setValue(aOnuOltVlanTransProfTreatmentOuterTPIDDE);
    }

    public Long getOnuOltVlanTransProfTreatmentInnerPriority() {
        return (Long) getProperty(onuOltVlanTransProfTreatmentInnerPriority).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentInnerPriority(Long aOnuOltVlanTransProfTreatmentInnerPriority) {
        getProperty(onuOltVlanTransProfTreatmentInnerPriority).setValue(aOnuOltVlanTransProfTreatmentInnerPriority);
    }

    public Long getOnuOltVlanTransProfTreatmentInnerVID() {
        return (Long) getProperty(onuOltVlanTransProfTreatmentInnerVID).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentInnerVID(Long aOnuOltVlanTransProfTreatmentInnerVID) {
        getProperty(onuOltVlanTransProfTreatmentInnerVID).setValue(aOnuOltVlanTransProfTreatmentInnerVID);
    }

    public Integer getOnuOltVlanTransProfTreatmentInnerTPIDDE() {
        return (Integer) getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentInnerTPIDDE(Integer aOnuOltVlanTransProfTreatmentInnerTPIDDE) {
        getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE).setValue(aOnuOltVlanTransProfTreatmentInnerTPIDDE);
    }

    public Integer getOnuOltVlanTransProfTreatmentTagsMode() {
        return (Integer) getProperty(onuOltVlanTransProfTreatmentTagsMode).getValue();
    }

    public void setOnuOltVlanTransProfTreatmentTagsMode(Integer aOnuOltVlanTransProfTreatmentTagsMode) {
        getProperty(onuOltVlanTransProfTreatmentTagsMode).setValue(aOnuOltVlanTransProfTreatmentTagsMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(onuOltVlanTransProfileName));
        prepareRead(super.getProperty(onuOltVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(onuOltVlanTransProfInputTPID));
        prepareRead(super.getProperty(onuOltVlanTransProfOutputTPID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentTagsMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(onuOltVlanTransProfileName));
        prepareRead(super.getProperty(onuOltVlanTransProfDownstreamMode));
        prepareRead(super.getProperty(onuOltVlanTransProfInputTPID));
        prepareRead(super.getProperty(onuOltVlanTransProfOutputTPID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterVID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterOuterTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerVID));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterInnerTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfFilterEthertype));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentTagsRemove));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterVID));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerPriority));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerVID));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE));
        prepareRead(super.getProperty(onuOltVlanTransProfTreatmentTagsMode));

        return loadAll(new int[] { 1, 1, 1,1, 2, 2 });
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuOltVlanTransProfileName));
        prepareSave(getProperty(onuOltVlanTransProfDownstreamMode));
        prepareSave(getProperty(onuOltVlanTransProfInputTPID));
        prepareSave(getProperty(onuOltVlanTransProfOutputTPID));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterVID));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerVID));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfFilterEthertype));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentTagsMode));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuOltVlanTransProfileName));
        prepareSave(getProperty(onuOltVlanTransProfDownstreamMode));
        prepareSave(getProperty(onuOltVlanTransProfInputTPID));
        prepareSave(getProperty(onuOltVlanTransProfOutputTPID));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterPriority));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterVID));
        prepareSave(getProperty(onuOltVlanTransProfFilterOuterTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerPriority));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerVID));
        prepareSave(getProperty(onuOltVlanTransProfFilterInnerTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfFilterEthertype));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentTagsRemove));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterPriority));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterVID));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentOuterTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerPriority));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerVID));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentInnerTPIDDE));
        prepareSave(getProperty(onuOltVlanTransProfTreatmentTagsMode));
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
