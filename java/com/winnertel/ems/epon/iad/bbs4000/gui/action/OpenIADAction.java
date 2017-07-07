/**
 * @(#)NEFileMgmtAction.java
 * Created on 2006-10-24, ????02:02:17
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Modified by Zhou Chao
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.IADManager;
import com.winnertel.ems.epon.iad.snmp.OltSnmpParameter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.standard.MainApplet;
import com.winnertel.nms.lite.util.APIUtil;
import com.winnertel.nms.topodb.ULManagedObject;
import org.jdom.JDOMException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class OpenIADAction extends BaseAction {

    private Properties frameParamMap = new Properties();
    private String aReadCommunity = "public";
    private String aWriteCommunity = "private";
    private String aSnmpVersion = "v2";
    private String aSnmpPort = "161";
    private String language = "en";
    private String country = "US";

    public OpenIADAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws Exception {
        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
            return;

        if ("true".equalsIgnoreCase(System.getProperty("dvm.mode.lct")))
            initLocale();

        //Check the privilege.
        if (!fApplication.isDebug()) {
            final ISecurityManager securityManager = fApplication.getSecurityManager();
            final ISession session = fApplication.getSession();
            if (!securityManager.isAuthorized(session, "IAD_Mgt")) {
                MessageDialog.showPermissionDeniedDialog(fApplication);

                //write operation log for recording privilege checking failure
                ILogInfo log = fApplication.getLogManager().getLogInfo("CPE_MGMT_Privilege_Check");
                log.setStatus(ILogInfo.FAILED);
                fApplication.getLogManager().writeLog(log);

                return;
            }
        }

        String neType = fApplication.getActiveDeviceManager().getType();
        String neName = fApplication.getActiveDeviceManager().getName();

        if ( "true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
            ULManagedObject mo = fApplication.getPlatformProxy().getManagedObject(neType);
            if (mo != null) {
                if (mo.getProperties() != null && mo.getProperties().size() > 0) {
                    frameParamMap.put("neType", mo.getProperties().getProperty("type"));
                    frameParamMap.put("type", mo.getProperties().getProperty("type"));
                    frameParamMap.setProperty("swVersion", mo.getProperties().getProperty("swVersion"));
                    frameParamMap.setProperty("name", mo.getProperties().getProperty("name"));
                    frameParamMap.put("neName", neName);
                    frameParamMap.put("ipAddress", neName);

                    aReadCommunity = mo.getProperties().getProperty("community");
                    aWriteCommunity = mo.getProperties().getProperty("writeCommunity");
                } else {
                    //isDebug
                    if (fApplication.getMainApplet().getGui() != null) {
                        frameParamMap.put("neType", fApplication.getMainApplet().getGui().getParameter("neType"));
                        frameParamMap.put("type", fApplication.getMainApplet().getGui().getParameter("neType"));
                        frameParamMap.setProperty("swVersion", fApplication.getMainApplet().getGui().getParameter("swVersion"));
                        frameParamMap.setProperty("name", fApplication.getMainApplet().getGui().getParameter("neName"));
                        frameParamMap.put("neName", fApplication.getMainApplet().getGui().getParameter("neName"));
                        frameParamMap.put("ipAddress", fApplication.getMainApplet().getGui().getParameter("NodeIPAddress"));

                        //aReadCommunity = mo.getProperties().getProperty("community");
                        //aWriteCommunity = mo.getProperties().getProperty("writeCommunity");
                    }
                }
            }
        }
        frameParamMap.setProperty("getCommunity", aReadCommunity);
        frameParamMap.setProperty("writeCommunity", aWriteCommunity);
        frameParamMap.setProperty("SnmpVersion", aSnmpVersion);
        frameParamMap.setProperty("SnmpPort", aSnmpPort);
        frameParamMap.setProperty(MainApplet.PARAM_COUNTRY, country);
        frameParamMap.setProperty(MainApplet.PARAM_LANGUAGE, language);

        frameParamMap.setProperty("OperationFlow", neName);
        frameParamMap.put("parentFrame", fApplication.getTopMostFrame());

        //String neName = fApplication.getActiveDeviceManager().getName();

        Properties tmpProp = null;
        if ("true".equalsIgnoreCase(System.getProperty("dvm.mode.lct")))
            tmpProp = frameParamMap;
        else
            tmpProp = APIUtil.getTopoAPI().getMEByMoName(neName).getProperties();

        if (tmpProp != null) {
            tmpProp.setProperty("OperationFlow", neName);
            tmpProp.put("parentFrame", fApplication.getTopMostFrame());

            IADManager iadMgr = new IADManager(tmpProp);

            OltSnmpParameter snmpProxyParameter = null;
            if ( "true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
                snmpProxyParameter = new OltSnmpParameter(null, null) {
                    public void update() {
                        setTargetHost(fApplication.getActiveDeviceManager().getName());
                        setTargetPort(161);
                        setSnmpVersion(getSnmpVersion());
                        setReadCommunity(aReadCommunity);
                        setWriteCommunity(aWriteCommunity);
                    }
                };
            } else {
                snmpProxyParameter = new OltSnmpParameter(iadMgr, neName);
            }
            iadMgr.setSnmpParameter(snmpProxyParameter);
            iadMgr.init();
            iadMgr.showInventory();
        }
    }

    private void initLocale() {
        try {
            org.jdom.input.SAXBuilder saxBuilder = new org.jdom.input.SAXBuilder(false);
            File confFile = new File(System.getProperty("user.dir") + "/conf/LiteReleaseInfo.xml");
            InputStream in = confFile.toURL().openStream();
            org.jdom.Document doc = saxBuilder.build(in);
            org.jdom.Element root = doc.getRootElement();

            //read <Server>
            org.jdom.Element serverEle = root.getChild("Server");
            language = serverEle.getChild("Language").getTextTrim();
            country = serverEle.getChild("Country").getTextTrim();

            Locale.setDefault(new Locale(language, country));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JDOMException jdomex) {
            jdomex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}