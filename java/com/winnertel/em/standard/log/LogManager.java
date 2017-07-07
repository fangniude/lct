package com.winnertel.em.standard.log;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.log.ILogManager;

import java.util.Date;
import java.util.Map;

public class LogManager implements ILogManager {
    private IApplication fApplication;

    private Map fLogMap;
    private boolean fInitialized;


    public LogManager(IApplication anApplication) {
        fApplication = anApplication;
    }


    public void writeLog(ILogInfo aLogInfo) {
        fApplication.getPlatformProxy().log(aLogInfo);
    }


    public ILogInfo getLogInfo() {
        ILogInfo result = new LogInfo();
        fillDataToLogInfo(result);

        return result;
    }

    public ILogInfo getLogInfo(String aLogId) {
        if (aLogId == null) {
            return null;
        }

        if (!fInitialized) {
            initLogMap();
        }

        Object obj = fLogMap.get(aLogId);

        if (obj != null) {
            LogInfo logInfo = (LogInfo) obj;
            logInfo = (LogInfo) logInfo.clone();
            fillDataToLogInfo(logInfo);
            return logInfo;
        }

        return null;
    }

    private void initLogMap() {
        fLogMap = fApplication.getActiveDeviceManager().getResourceManager().loadLogMap();
        fInitialized = true;
    }


    private void fillDataToLogInfo(ILogInfo aLogInfo) {
        ISession session = fApplication.getSession();
        aLogInfo.setHostIp(session.getHostIp());
        aLogInfo.setHostName(session.getHostName());
        aLogInfo.setUser(session.getUser());
        aLogInfo.setTime(new Date());
        aLogInfo.setOperationObject(fApplication.getActiveDeviceManager().getOperationObject().toString());
    }
}
