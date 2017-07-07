package com.winnertel.em.standard.util;

import com.winnertel.common.notification.UNotificationFilter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.ILogable;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.util.INotificationHandler;
import com.winnertel.em.framework.util.IPlatformProxy;
import com.winnertel.nms.topodb.ULManagedObject;

import java.lang.reflect.Constructor;

/**
 * This proxy works for LCT runtime.
 */
public class MockPlatformProxy implements IPlatformProxy {

    private IApplication fApplication;

    public MockPlatformProxy(IApplication fApp) {
        fApplication = fApp;
    }

    private ILogable lctLogger = null;

    private ILogable getLCTOPLogger() {
         if (lctLogger == null) {
             String loggerClazz = fApplication.getMainApplet().getParameter(
                     "NE_LCT_LOGGER");
             try {
                 if (loggerClazz != null && loggerClazz.length() > 0) {
                     Class clazz = Class.forName(loggerClazz);
                     Constructor constructor = clazz.getConstructor(IApplication.class);
                     if( constructor != null ) {
                         lctLogger = (ILogable) constructor.newInstance( fApplication );
                     }
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 System.err.print(" Initialize LCT OP Logger Error");
             }
         }
         return lctLogger;
     }

    @Override
    public boolean log(ILogInfo aLogInfo) {
        ILogable logger = getLCTOPLogger( );
        if( logger != null ) {
            logger.writeLog(aLogInfo);
            return true;
        }
        return false;
    }

    @Override
    public boolean registerNotificationHandler(UNotificationFilter aFilter, INotificationHandler aHandler) {
        return true;
    }

    @Override
    public boolean deregisterNotificationHandler(UNotificationFilter aFilter, INotificationHandler aHandler) {
        return true;
    }

    @Override
    public boolean isAuthorized(String userId, String privilegeId) {
        return true;
    }

    /**
     * This method is called by MainApplet.createDeviveManagerList() in framework.
     * the ILctLaunch should implement createDeviveManagerList, instead of framework call stack.
     * @param aName
     * @return
     */
    @Override
    public ULManagedObject getManagedObject(String aName) {
        return null;
    }
}
