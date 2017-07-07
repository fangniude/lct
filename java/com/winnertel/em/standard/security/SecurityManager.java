package com.winnertel.em.standard.security;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.nms.lite.LiteContext;
import com.winnertel.nms.securitydb.Privilege;
import com.winnertel.nms.securitydb.PrivilegeMgr;
import com.winnertel.nms.securitydb.SMMgr;
import com.winnertel.nms.sm.client.common.CommonClientAPI;
import com.winnertel.nms.sm.client.common.SMConstant;
import com.winnertel.nms.util.TableNameDef;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public final class SecurityManager implements ISecurityManager {
    private IApplication fApplication = null;

    private Map fSecurityMap = null;

    private ILogger fLogger = LoggerController.createLogger(SecurityManager.class);

    private PrivilegeMgr fPrivilegeMgr = null;

    public SecurityManager(IApplication aApplication) {
        fApplication = aApplication;
        fSecurityMap = new HashMap();
        init();
    }

    private void init() {
//        if (LiteContext.isLCTModel()) {
//            return;
//        }
//
//        SMMgr smmgr = (SMMgr) CommonClientAPI.getInstance().getAPI(SMConstant.SMSERVER_NAME);
//        if (smmgr == null) {
//            throw new IllegalArgumentException("NO SM Server found!!!");
//        }
//
//        // PrivilegeMgr privilegeMgr = null;
//
//        try {
//            fPrivilegeMgr = smmgr.getPrivilegeMgrAPI();
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        if (fPrivilegeMgr == null) {
//            throw new IllegalArgumentException("NO Privilege Management Server found!!!");
//        }

    }

    public boolean isAuthorized(ISession aSession, String anAction) {
        IDeviceManager dvm = fApplication.getActiveDeviceManager();
        if (dvm == null) {
            return true;
        }

        Map authMap = getSecurityMap(dvm.getName());
        if (authMap == null) {
            return true;
        }

        String privilege = (String) authMap.get(anAction);
        if (privilege == null) {
            return true;
        }

        loggerPrivilege(aSession, privilege);

        return fApplication.getPlatformProxy().isAuthorized(aSession.getUser(), privilege);
    }

    private void loggerPrivilege(ISession aSession, String privilege) {
        if (fPrivilegeMgr != null) {
            try {
                String condition = TableNameDef.TABLE_PRIVILEGE_PRIVILEGEID + "='" + privilege + "'";

                Privilege[] privileges = fPrivilegeMgr.readPrivilege(condition);
                if (privileges.length > 0) {
                    String privilegeName = privileges[0].getName();
                    fLogger.debug("User Name:" + aSession.getUser() + ", Privilege Name:" + privilegeName);
                    return;
                }
            } catch (Exception e) {// nothing to do
                fLogger.debug("Get Privilege Resource Failed!");
            }
        } else {
            fLogger.debug("The remote PrivilegeMgr is null");
        }
        fLogger.debug("User Name:" + aSession.getUser() + ", Privilege Name:" + privilege);
    }

    private Map getSecurityMap(String aMoName) {
        if (fSecurityMap.containsKey(aMoName)) {
            return (Map) fSecurityMap.get(aMoName);
        } else {
            Map cache = fApplication.getActiveDeviceManager().getResourceManager().loadAuthorizationMap();
            fSecurityMap.put(aMoName, cache);
            return cache;
        }
    }
}
