package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EponModuleBoardTable class.
 * Created by QuickDVM
 */
public class FileSystemGroup extends SnmpMibBean {
    public static final String utsFileSystemCommand = "utsFileSystemCommand";
    public static final String utsFileSystemListDirectory = "utsFileSystemListDirectory";
    public static final String utsFileSystemListDirectoryResult = "utsFileSystemListDirectoryResult";
    public static final String utsFileSystemSrcFileName = "utsFileSystemSrcFileName";
    public static final String utsFileSystemDstFileName = "utsFileSystemDstFileName";
    public static final String utsFileSystemCommandStatus = "utsFileSystemCommandStatus";
    public static final String utsFileSystemCommandStationId = "utsFileSystemCommandStationId";
    public static final String utsFileSystemListDirectoryResultEndFlag = "utsFileSystemListDirectoryResultEndFlag";

    public static final int File_System_Command_List = 1;
    public static final int File_System_Command_Copy = 2;
    public static final int File_System_Command_Rename = 3;
    public static final int File_System_Command_Delete = 4;

    public static final int File_System_Command_Status_Success = 1;
    public static final int File_System_Command_Status_Fail = 0;

    public FileSystemGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsFileSystemCommand, new SnmpMibBeanProperty(utsFileSystemCommand, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.1", ISnmpConstant.INTEGER));
        initProperty(utsFileSystemListDirectory, new SnmpMibBeanProperty(utsFileSystemListDirectory, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.2", ISnmpConstant.STRING));
        initProperty(utsFileSystemListDirectoryResult, new SnmpMibBeanProperty(utsFileSystemListDirectoryResult, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.3", ISnmpConstant.STRING));
        initProperty(utsFileSystemSrcFileName, new SnmpMibBeanProperty(utsFileSystemSrcFileName, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.4", ISnmpConstant.STRING));
        initProperty(utsFileSystemDstFileName, new SnmpMibBeanProperty(utsFileSystemDstFileName, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.5", ISnmpConstant.STRING));
        initProperty(utsFileSystemCommandStatus, new SnmpMibBeanProperty(utsFileSystemCommandStatus, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.6", ISnmpConstant.INTEGER));
        initProperty(utsFileSystemCommandStationId, new SnmpMibBeanProperty(utsFileSystemCommandStationId, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.7", ISnmpConstant.STRING));
        initProperty(utsFileSystemListDirectoryResultEndFlag, new SnmpMibBeanProperty(utsFileSystemListDirectoryResultEndFlag, ".1.3.6.1.4.1.41355.1800.2.1.1.4.3.8", ISnmpConstant.INTEGER));
    }


    public Integer getUtsFileSystemCommand() {
      return (Integer) getProperty(utsFileSystemCommand).getValue();
    }

    public void setUtsFileSystemCommand(Integer aUtsFileSystemCommand) {
      getProperty(utsFileSystemCommand).setValue(aUtsFileSystemCommand);
    }

    public String getUtsFileSystemListDirectory() {
        return (String) getProperty(utsFileSystemListDirectory).getValue();
    }

    public void setUtsFileSystemListDirectory(String aUtsFileSystemListDirectory) {
        getProperty(utsFileSystemListDirectory).setValue(aUtsFileSystemListDirectory);
    }

    public String getUtsFileSystemListDirectoryResult() {
        return (String) getProperty(utsFileSystemListDirectoryResult).getValue();
    }

    public void setUtsFileSystemListDirectoryResult(String aUtsFileSystemListDirectoryResult) {
        getProperty(utsFileSystemListDirectoryResult).setValue(aUtsFileSystemListDirectoryResult);
    }

    public String getUtsFileSystemSrcFileName() {
        return (String) getProperty(utsFileSystemSrcFileName).getValue();
    }

    public void setUtsFileSystemSrcFileName(String aUtsFileSystemSrcFileName) {
        getProperty(utsFileSystemSrcFileName).setValue(aUtsFileSystemSrcFileName);
    }

    public String getUtsFileSystemDstFileName() {
        return (String) getProperty(utsFileSystemDstFileName).getValue();
    }

    public void setUtsFileSystemDstFileName(String aUtsFileSystemDstFileName) {
        getProperty(utsFileSystemDstFileName).setValue(aUtsFileSystemDstFileName);
    }

    public Integer getUtsFileSystemCommandStatus() {
        return (Integer) getProperty(utsFileSystemCommandStatus).getValue();
    }

    public void setUtsFileSystemCommandStatus(Integer aUtsFileSystemCommandStatus) {
        getProperty(utsFileSystemCommandStatus).setValue(aUtsFileSystemCommandStatus);
    }

    public String getUtsFileSystemCommandStationId() {
        return (String) getProperty(utsFileSystemCommandStationId).getValue();
    }

    public void setUtsFileSystemCommandStationId(String aUtsFileSystemCommandStationId) {
        getProperty(utsFileSystemCommandStationId).setValue(aUtsFileSystemCommandStationId);
    }

    public Integer getUtsFileSystemListDirectoryResultEndFlag() {
        return (Integer)getProperty(utsFileSystemListDirectoryResultEndFlag).getValue();
    }

    public void setUtsFileSystemListDirectoryResultEndFlag(Integer aUtsFileSystemListDirectoryResultEndFlag)
    {
        getProperty(utsFileSystemListDirectoryResultEndFlag).setValue(aUtsFileSystemListDirectoryResultEndFlag);
    }

    public boolean isEnd()
    {
      try
      {
        prepareRead(super.getProperty(utsFileSystemListDirectoryResultEndFlag));

        load();

        Integer i = getUtsFileSystemListDirectoryResultEndFlag();
        if(i != null && i == 2) //unremitting(2)
         return false;
      }
      catch(Exception e)
      {
      }
      return true;
    }
    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsFileSystemCommand));
        prepareRead(super.getProperty(utsFileSystemListDirectory));
        prepareRead(super.getProperty(utsFileSystemListDirectoryResult));
        prepareRead(super.getProperty(utsFileSystemSrcFileName));
        prepareRead(super.getProperty(utsFileSystemDstFileName));
        prepareRead(super.getProperty(utsFileSystemCommandStatus));
        prepareRead(super.getProperty(utsFileSystemCommandStationId));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsFileSystemCommand));
        prepareRead(super.getProperty(utsFileSystemListDirectory));
        prepareRead(super.getProperty(utsFileSystemListDirectoryResult));
        prepareRead(super.getProperty(utsFileSystemSrcFileName));
        prepareRead(super.getProperty(utsFileSystemDstFileName));
        prepareRead(super.getProperty(utsFileSystemCommandStatus));
        prepareRead(super.getProperty(utsFileSystemCommandStationId));

        return loadAll(new int[]{});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(super.getProperty(utsFileSystemCommand));
        prepareSave(super.getProperty(utsFileSystemListDirectory));
        prepareSave(super.getProperty(utsFileSystemListDirectoryResult));
        prepareSave(super.getProperty(utsFileSystemSrcFileName));
        prepareSave(super.getProperty(utsFileSystemDstFileName));
        prepareSave(super.getProperty(utsFileSystemCommandStatus));
        prepareSave(super.getProperty(utsFileSystemCommandStationId));

        return save();
    }
}
