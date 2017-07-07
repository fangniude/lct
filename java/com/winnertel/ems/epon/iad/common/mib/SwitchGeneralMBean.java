package com.winnertel.ems.epon.iad.common.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;


 
public class SwitchGeneralMBean extends SnmpMibBean {

	public static final String sysMaintLocalFile = "sysMaintLocalFile";

	public static final String sysMaintRemoteFile = "sysMaintRemoteFile";

	public static final String sysMaintFileSize = "sysMaintFileSize";

	public static final String sysMaintTftpServer = "sysMaintTftpServer";

	public static final String sysMaintOperation = "sysMaintOperation";

	public static final String sysMaintTransSize = "sysMaintTransSize";

	public static final String sysMaintOperResult = "sysMaintOperResult";

	public static final String sysMaintEraseFile = "sysMaintEraseFile";

	public static final String sysMaintWriteMemory = "sysMaintWriteMemory";

	public static final String sysMaintReset = "sysMaintReset";

	/**
	 * @param aSnmpProxy
	 */
	public SwitchGeneralMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		
						
       	initProperty(sysMaintLocalFile, new SnmpMibBeanProperty(sysMaintLocalFile, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.1", ISnmpConstant.INTEGER));
        initProperty(sysMaintRemoteFile, new SnmpMibBeanProperty(sysMaintRemoteFile, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.2", ISnmpConstant.STRING));
        initProperty(sysMaintFileSize, new SnmpMibBeanProperty(sysMaintFileSize, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.3", ISnmpConstant.INTEGER));
        initProperty(sysMaintTftpServer, new SnmpMibBeanProperty(sysMaintTftpServer,  ".1.3.6.1.4.1.41355.1.3.10.100.106.1.4", ISnmpConstant.IP_ADDRESS));
        initProperty(sysMaintOperation, new SnmpMibBeanProperty(sysMaintOperation, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.5", ISnmpConstant.INTEGER));
        initProperty(sysMaintTransSize, new SnmpMibBeanProperty(sysMaintTransSize, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.6", ISnmpConstant.INTEGER));
        initProperty(sysMaintOperResult, new SnmpMibBeanProperty(sysMaintOperResult, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.7", ISnmpConstant.INTEGER));
        initProperty(sysMaintEraseFile, new SnmpMibBeanProperty(sysMaintEraseFile, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.8", ISnmpConstant.INTEGER));
        initProperty(sysMaintWriteMemory, new SnmpMibBeanProperty(sysMaintWriteMemory,  ".1.3.6.1.4.1.41355.1.3.10.100.106.1.9", ISnmpConstant.INTEGER));
        initProperty(sysMaintReset, new SnmpMibBeanProperty(sysMaintReset, ".1.3.6.1.4.1.41355.1.3.10.100.106.1.10", ISnmpConstant.INTEGER));

	}


	public Integer getSysMaintLocalFile() {
		return (Integer) getProperty(sysMaintLocalFile).getValue();
	}

	public void setSysMaintLocalFile(Integer aSysMaintLocalFile) {
		getProperty(sysMaintLocalFile).setValue(aSysMaintLocalFile);
	}

	public String getSysMaintRemoteFile() {
		return (String) getProperty(sysMaintRemoteFile).getValue();
	}

	public void setSysMaintRemoteFile(String aSysMaintRemoteFile) {
		getProperty(sysMaintRemoteFile).setValue(aSysMaintRemoteFile);
	}

	public Integer getSysMaintFileSize() {
		return (Integer) getProperty(sysMaintFileSize).getValue();
	}

	public void setSysMaintFileSize(Integer aSysMaintFileSize) {
		getProperty(sysMaintFileSize).setValue(aSysMaintFileSize);
	}

	public String getSysMaintTftpServer() {
		return (String) getProperty(sysMaintTftpServer).getValue();
	}

	public void setSysMaintTftpServer(String aSysMaintTftpServer) {
		getProperty(sysMaintTftpServer).setValue(aSysMaintTftpServer);
	}

	public Integer getSysMaintOperation() {
		return (Integer) getProperty(sysMaintOperation).getValue();
	}

	public void setSysMaintOperation(Integer aSysMaintOperation) {
		getProperty(sysMaintOperation).setValue(aSysMaintOperation);
	}

	public Integer getSysMaintTransSize() {
		return (Integer) getProperty(sysMaintTransSize).getValue();
	}

	public void setSysMaintTransSize(Integer aSysMaintTransSize) {
		getProperty(sysMaintTransSize).setValue(aSysMaintTransSize);
	}

	public Integer getSysMaintOperResult() {
		return (Integer) getProperty(sysMaintOperResult).getValue();
	}

	public void setSysMaintOperResult(Integer aSysMaintOperResult) {
		getProperty(sysMaintOperResult).setValue(aSysMaintOperResult);
	}

	public Integer getSysMaintEraseFile() {
		return (Integer) getProperty(sysMaintEraseFile).getValue();
	}

	public void setSysMaintEraseFile(Integer aSysMaintEraseFile) {
		getProperty(sysMaintEraseFile).setValue(aSysMaintEraseFile);
	}

	public Integer getSysMaintWriteMemory() {
		return (Integer) getProperty(sysMaintWriteMemory).getValue();
	}

	public void setSysMaintWriteMemory(Integer aSysMaintWriteMemory) {
		getProperty(sysMaintWriteMemory).setValue(aSysMaintWriteMemory);
	}

	public Integer getSysMaintReset() {
		return (Integer) getProperty(sysMaintReset).getValue();
	}

	public void setSysMaintReset(Integer aSysMaintReset) {
		getProperty(sysMaintReset).setValue(aSysMaintReset);
	}

	public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(sysMaintRemoteFile));
        prepareRead(super.getProperty(sysMaintFileSize));
		prepareRead(super.getProperty(sysMaintTftpServer));
		prepareRead(super.getProperty(sysMaintOperation));
		prepareRead(super.getProperty(sysMaintTransSize));
		prepareRead(super.getProperty(sysMaintOperResult));
		prepareRead(super.getProperty(sysMaintEraseFile));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(sysMaintTftpServer));
		return save();
	}

	public boolean reset() throws MibBeanException {
		prepareSave(getProperty(sysMaintReset));
		save();
		return true;
	}

	public boolean writeMemory() throws MibBeanException {
		prepareSave(getProperty(sysMaintWriteMemory));
		save();
		return true;
	}

	public boolean eraseConfig_ImageFile() throws MibBeanException {
		prepareSave(getProperty(sysMaintEraseFile));
		save();
		return true;
	}

	public boolean download_Upload_files() throws MibBeanException {
		prepareSave(getProperty(sysMaintLocalFile));
		prepareSave(getProperty(sysMaintRemoteFile));
		save();

		prepareSave(getProperty(sysMaintOperation));
		save();

		return true;
	}
}
