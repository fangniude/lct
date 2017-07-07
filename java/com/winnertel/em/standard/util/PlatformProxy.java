package com.winnertel.em.standard.util;

import com.winnertel.common.notification.UEventPoolImpl;
import com.winnertel.common.notification.UNotificationEvent;
import com.winnertel.common.notification.UNotificationFilter;
import com.winnertel.common.notification.UNotificationServer;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.IMainApplet;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.util.INotificationHandler;
import com.winnertel.em.framework.util.IPlatformProxy;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.MainApplet;
import com.winnertel.inms.topodb.UWrapperOfTopoAPI;
import com.winnertel.nms.logdb.LogMgr;
import com.winnertel.nms.logdb.PBDefinition;
import com.winnertel.nms.logdb.UserOPLog;
import com.winnertel.nms.logdb.UserOPLogMgr;
import com.winnertel.nms.securitydb.AuthMgr;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.nms.topodb.ULTopoAPI;
import org.apache.commons.collections.SequencedHashMap;

import java.rmi.Naming;
import java.util.ArrayList;

public class PlatformProxy implements IPlatformProxy {
    private ILogger fLogger = LoggerController.createLogger(PlatformProxy.class);

    private static AuthMgr fAuthMgr;
    private static ULTopoAPI fTopoAPI;
    private static LogMgr fLogMgr;

    private static UNotificationServer fNotificationServer;
    private static SequencedHashMap fNotificationHandlerList = new SequencedHashMap();

    private String fRmiHost = "localhost";
    private String fRmiPort = "1099";

    public PlatformProxy(IApplication anApplication) {
        IMainApplet mainApplet = (IMainApplet) anApplication.getMainApplet();

        fRmiHost = mainApplet.getParameter(MainApplet.PARAM_FE_IP);
        fRmiPort = mainApplet.getParameter(MainApplet.PARAM_RMI_PORT);

        initRemoteApi();
    }

    public PlatformProxy( String RmiHost, String RmiPort ) {
        fRmiHost = RmiHost;
        fRmiPort = RmiPort;

        initRemoteApi();
    }

    private void initRemoteApi() {
        try {
            fAuthMgr = (AuthMgr) Naming.lookup(getRmiUrl() + "AuthMgr");
            fTopoAPI = (ULTopoAPI) Naming.lookup(getRmiUrl() + UWrapperOfTopoAPI.API_NAME);
            fLogMgr = (LogMgr) Naming.lookup(getRmiUrl() + PBDefinition.LogMgrFEAPI);
            fNotificationServer = (UNotificationServer) Naming.lookup(getRmiUrl() + UNotificationServer.API_NAME);
        } catch (Exception ex) {
            fLogger.error("Error in lookup remote api", ex);
        }
    }

    private String getRmiUrl() {
        return "rmi://" + "192.168.6.158" + ":" + fRmiPort + "/";
    }

    public ULManagedObject getManagedObject(String aName) {
        ULManagedObject theMO = null;
        try {
            theMO = fTopoAPI.getByName(aName);
        } catch (Exception ex) {
            fLogger.error("Error in get MO " + aName + " from " + getRmiUrl(), ex);
        }
        return theMO;
    }


    public boolean log(ILogInfo aLogInfo) {


        try {
            UserOPLogMgr theOpLogMgr = fLogMgr.getUserOPLogMgrAPI();
            UserOPLog aRecord = new UserOPLog(aLogInfo.getLevel(), aLogInfo.getHostIp(),
                    aLogInfo.getHostName(), aLogInfo.getUser(),
                    aLogInfo.getOperationObject(), aLogInfo.getOperation(),
                    aLogInfo.getAnnotation());
            switch (aLogInfo.getStatus()) {
                case ILogInfo.COMPLETED:
                    aRecord.setLogStatus(UserOPLog.OK);
                    break;
                case ILogInfo.FAILED:
                    aRecord.setLogStatus(UserOPLog.FAILED);
                    break;
            }
            aRecord.setTime(aLogInfo.getTime());
            aRecord = theOpLogMgr.log(aRecord);
            if (aRecord != null) {
                return true;
            }
        } catch (Exception ex) {
            fLogger.error("Error in writing log", ex);
        }

        return false;
    }

    public boolean isAuthorized(String userId, String privilegeId) {
        try {
            return fAuthMgr.getAuthorizationMgrAPI().isAuthorized(userId, privilegeId);
        } catch (Exception ex) {
            fLogger.error("Error in authorize privilege " + privilegeId + " to user " + userId, ex);
            return false;
        }
    }


    public boolean registerNotificationHandler(UNotificationFilter aFilter, final INotificationHandler aHandler) {
        String eventType = String.valueOf(aFilter.getEventType());
        if (fNotificationHandlerList.containsKey(eventType)) {
            NotificationThread thread = (NotificationThread) fNotificationHandlerList.get(eventType);
            thread.addHandler(aHandler);
            return true;
        }

        UEventPoolImpl eventPool = null;
        try {
            eventPool = new UEventPoolImpl(fNotificationServer);
            fNotificationServer.setNotificationFilter(eventPool.getID(), aFilter);

            NotificationThread thread = new NotificationThread(eventPool);
            thread.addHandler(aHandler);
            thread.start();
            fNotificationHandlerList.put(eventType, thread);
            return true;
        } catch (Exception ex) {
            fLogger.error("Failed to register notification filter", ex);
            return false;
        }
    }

    public boolean deregisterNotificationHandler(UNotificationFilter aFilter, INotificationHandler aHandler) {
        String eventType = String.valueOf(aFilter.getEventType());
        if (fNotificationHandlerList.containsKey(eventType)) {
            NotificationThread thread = (NotificationThread) fNotificationHandlerList.get(eventType);
            thread.removeHandler(aHandler);
            // TODO: ?? if no handler in the thread, destroy the thread ??
            return true;
        }

        return false;
    }

    private class NotificationThread extends Thread {
        private UEventPoolImpl fEventPool;
        private ArrayList fHandlerList = new ArrayList();

        public NotificationThread(UEventPoolImpl aEventPool) {
            fEventPool = aEventPool;
        }


        public void addHandler(INotificationHandler aHandler) {
            fHandlerList.add(aHandler);
        }

        public void removeHandler(INotificationHandler aHandler) {
            fHandlerList.remove(aHandler);
        }


        public void run() {
            while (true) {
                try {
                    UNotificationEvent event = fEventPool.getEvent();

                    if (event == null) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                        continue;
                    }

                    Object[] handerArray = fHandlerList.toArray();
                    for (int i = 0; i < handerArray.length; i++) {
                        INotificationHandler handler = (INotificationHandler) handerArray[i];
                        try {
                            handler.handleNotification(event);
                        } catch (Exception ex) {
                            fLogger.error("Error in handle notification", ex);
                        }
                    }
                } catch (Exception ex) {
                    fLogger.error("Error in notification handler thead", ex);
                }
            }
        }
    }


}
