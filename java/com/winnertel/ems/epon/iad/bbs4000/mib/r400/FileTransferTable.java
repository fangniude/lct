package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class FileTransferTable extends SnmpMibBean {
    public static final String fileTransferIndex = "fileTransferIndex";
    public static final String fileTransferProtocolType = "fileTransferProtocolType";
    public static final String serverIpAddress = "serverIpAddress";
    public static final String ftpUserName = "ftpUserName";
    public static final String ftpUserPassword = "ftpUserPassword";
    public static final String transferFileSrcNamePath = "transferFileSrcNamePath";
    public static final String transferFileDstNamePath = "transferFileDstNamePath";
    public static final String transferAction = "transferAction";
    public static final String transferStatus = "transferStatus";

    public FileTransferTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(fileTransferIndex, new SnmpMibBeanProperty(fileTransferIndex, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.1", ISnmpConstant.INTEGER));
        initProperty(fileTransferProtocolType, new SnmpMibBeanProperty(fileTransferProtocolType, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.2", ISnmpConstant.INTEGER));
        initProperty(serverIpAddress, new SnmpMibBeanProperty(serverIpAddress, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.3", ISnmpConstant.IP_ADDRESS));
        initProperty(ftpUserName, new SnmpMibBeanProperty(ftpUserName, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.4", ISnmpConstant.STRING));
        initProperty(ftpUserPassword, new SnmpMibBeanProperty(ftpUserPassword, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.5", ISnmpConstant.STRING));
        initProperty(transferFileSrcNamePath, new SnmpMibBeanProperty(transferFileSrcNamePath, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.6", ISnmpConstant.STRING));
        initProperty(transferFileDstNamePath, new SnmpMibBeanProperty(transferFileDstNamePath, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.7", ISnmpConstant.STRING));
        initProperty(transferAction, new SnmpMibBeanProperty(transferAction, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.8", ISnmpConstant.INTEGER));
        initProperty(transferStatus, new SnmpMibBeanProperty(transferStatus, ".1.3.6.1.4.1.17409.2.3.1.6.1.1.9", ISnmpConstant.INTEGER));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.3.6.2.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getFileTransferIndex() {
        return (Integer) getIndex(0);
    }

    public void setFileTransferIndex(Integer aFileTransferIndex) {
        setIndex(0, aFileTransferIndex);
    }

    public Integer getFileTransferProtocolType() {
        return (Integer) getProperty(fileTransferProtocolType).getValue();
    }

    public void setFileTransferProtocolType(Integer aFileTransferProtocolType) {
        getProperty(fileTransferProtocolType).setValue(aFileTransferProtocolType);
    }

    public String getServerIpAddress() {
        return (String) getProperty(serverIpAddress).getValue();
    }

    public void setServerIpAddress(String aServerIpAddress) {
        getProperty(serverIpAddress).setValue(aServerIpAddress);
    }

    public String getFtpUserName() {
        return (String) getProperty(ftpUserName).getValue();
    }

    public void setFtpUserName(String aFtpUserName) {
        getProperty(ftpUserName).setValue(aFtpUserName);
    }

    public String getFtpUserPassword() {
        return (String) getProperty(ftpUserPassword).getValue();
    }

    public void setFtpUserPassword(String aFtpUserPassword) {
        getProperty(ftpUserPassword).setValue(aFtpUserPassword);
    }

    public String getTransferFileSrcNamePath() {
        return (String) getProperty(transferFileSrcNamePath).getValue();
    }

    public void setTransferFileSrcNamePath(String aTransferFileSrcNamePath) {
        getProperty(transferFileSrcNamePath).setValue(aTransferFileSrcNamePath);
    }

    public String getTransferFileDstNamePath() {
        return (String) getProperty(transferFileDstNamePath).getValue();
    }

    public void setTransferFileDstNamePath(String aTransferFileDstNamePath) {
        getProperty(transferFileDstNamePath).setValue(aTransferFileDstNamePath);
    }

    public Integer getTransferAction() {
        return (Integer) getProperty(transferAction).getValue();
    }

    public void setTransferAction(Integer aTransferAction) {
        getProperty(transferAction).setValue(aTransferAction);
    }

    public Integer getTransferStatus() {
        return (Integer) getProperty(transferStatus).getValue();
    }

    public void setTransferStatus(Integer aTransferStatus) {
        getProperty(transferStatus).setValue(aTransferStatus);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(fileTransferProtocolType));
        prepareRead(getProperty(serverIpAddress));
        prepareRead(getProperty(ftpUserName));
        prepareRead(getProperty(ftpUserPassword));
        prepareRead(getProperty(transferFileSrcNamePath));
        prepareRead(getProperty(transferFileDstNamePath));
        prepareRead(getProperty(transferAction));
        prepareRead(getProperty(transferStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(fileTransferProtocolType));
        prepareRead(getProperty(serverIpAddress));
        prepareRead(getProperty(ftpUserName));
        prepareRead(getProperty(ftpUserPassword));
        prepareRead(getProperty(transferFileSrcNamePath));
        prepareRead(getProperty(transferFileDstNamePath));
        prepareRead(getProperty(transferAction));
        prepareRead(getProperty(transferStatus));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareRead(getProperty(fileTransferProtocolType));
        prepareRead(getProperty(serverIpAddress));
        prepareRead(getProperty(ftpUserName));
        prepareRead(getProperty(ftpUserPassword));
        prepareRead(getProperty(transferFileSrcNamePath));
        prepareRead(getProperty(transferFileDstNamePath));
        prepareRead(getProperty(transferAction));

        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
}
