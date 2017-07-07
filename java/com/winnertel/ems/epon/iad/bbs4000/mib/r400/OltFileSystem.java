package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OltFileSystem extends SnmpMibBean {

    //public static final String fileIndex = "fileIndex";
    public static final String filePath = "filePath";
    public static final String fileName = "fileName";
    public static final String fileSize = "fileSize";
    public static final String fileModifyTime = "fileModifyTime";
    public static final String fileManagementAction = "fileManagementAction";
    public static final String fileAttribute = "fileAttribute";

    public OltFileSystem(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(filePath, new SnmpMibBeanProperty(filePath, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.1", ISnmpConstant.STRING));
        initProperty(fileName, new SnmpMibBeanProperty(fileName, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.2", ISnmpConstant.STRING));
        initProperty(fileSize, new SnmpMibBeanProperty(fileSize, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.3", ISnmpConstant.COUNTER));
        initProperty(fileModifyTime, new SnmpMibBeanProperty(fileModifyTime, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.4", ISnmpConstant.OCTETS));
        initProperty(fileManagementAction, new SnmpMibBeanProperty(fileManagementAction, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.5", ISnmpConstant.INTEGER));
        initProperty(fileAttribute, new SnmpMibBeanProperty(fileAttribute, ".1.3.6.1.4.1.17409.2.3.1.6.2.1.6", ISnmpConstant.INTEGER));
    }

    /*
    public byte[] getFileIndex() {
        return (byte[]) getIndex(0);
    }

    public void setFileIndex(byte[] aFileIndex) {
        setIndex(0, aFileIndex);
    }
    */

    public byte[] getFilePath() {
        return (byte[]) getIndex(0);
    }

    public void setFilePath(byte[] aFilePath) {
        setIndex(0, aFilePath);
    }

    public byte[] getFileName() {
        return (byte[]) getIndex(1);
    }

    public void setFileName(byte[] aFileName) {
        setIndex(1, aFileName);
    }

    public Long getFileSize() {
        return (Long) getProperty(fileSize).getValue();
    }

    public void setFileSize(Long aFileSize) {
        getProperty(fileSize).setValue(aFileSize);
    }

    public byte[] getFileModifyTime() {
        return (byte[]) getProperty(fileModifyTime).getValue();
    }

    public void setFileModifyTime(byte[] aFileModifyTime) {
        getProperty(fileModifyTime).setValue(aFileModifyTime);
    }

    public Integer getFileManagementAction() {
        return (Integer) getProperty(fileManagementAction).getValue();
    }

    public void setFileManagementAction(Integer aFileManagementAction) {
        getProperty(fileManagementAction).setValue(aFileManagementAction);
    }

    public Integer getFileAttribute() {
        return (Integer) getProperty(fileAttribute).getValue();
    }

    public void setFileAttribute(Integer aFileAttribute) {
        getProperty(fileAttribute).setValue(aFileAttribute);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(fileSize));
        prepareRead(getProperty(fileModifyTime));
        prepareRead(getProperty(fileAttribute));
        prepareRead(getProperty(fileAttribute));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(fileSize));
        prepareRead(getProperty(fileModifyTime));
//        prepareRead(getProperty(fileAttribute));
        prepareRead(getProperty(fileAttribute));

        return loadAll(new int[]{-1, -1});
    }

    public boolean delete() throws MibBeanException {
        setFileManagementAction(2);
        prepareSave(getProperty(fileManagementAction));

        return save();
    }
}