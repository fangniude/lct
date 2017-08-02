package com.winnertel.ems.epon.iad;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuInfoTable;
import com.winnertel.ems.epon.iad.common.MainApplet;
import com.winnertel.ems.epon.iad.inventory.gui.InventoryPanel;
import com.winnertel.ems.epon.iad.inventory.mib.ONUMBean;
import com.winnertel.ems.epon.iad.inventory.mib.OnuCtcBean;
import com.winnertel.ems.epon.iad.inventory.model.InventoryDataResource;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.ems.epon.iad.util.GuiUtils;
import com.winnertel.ems.epon.iad.util.task.TaskManager;
import com.winnertel.em.broadband.common.util.OEMClientUtils;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.gui.util.GlobalStringMap;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.em.standard.snmp.task.RefreshAllTask;
import com.winnertel.em.standard.util.gui.input.resource.ResourceBundleProxy;
import com.winnertel.ems.epon.gui.dm.GeponDvMWorkFrame;
import com.winnertel.inms.topoui.UTopoUIContext;
import com.winnertel.snmp.snmp2.DefaultSASAppletStub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;

public class IADManager extends JApplet {

    Properties aParamMap = null;
    Properties omcdParmMap = null;
    static boolean DEBUG = false; //modify this item if merge code.
    String aReadCommunity = "";
    String aWriteCommunity = "";
    String aSnmpVersion = "";
    String aSnmpPort = "";
    SnmpProxy snmpProxy = null;
    ISnmpParameter snmpParameter = null;

    private HashMap dvmCache = new HashMap();

    public IADManager() {
        aParamMap = new Properties();
        aReadCommunity = "public";
        aWriteCommunity = "public";
        aSnmpVersion = "v2";
        aSnmpPort = "161";
        snmpProxy = null;
    }

    public Properties getOmcdParmMap() {
        return omcdParmMap;
    }

    public String getNodeLabel() {
        return OEMClientUtils.getLabelByNEType(omcdParmMap.getProperty("type")) + "_" + omcdParmMap.getProperty("neName");
    }

    public String getNodeName() {
        return omcdParmMap.getProperty("name");
    }

    InventoryPanel dialog;

    public void showInventory() {
        if (dialog == null) {
            dialog = new InventoryPanel(this, fStringMap, false);
            this.addChildWindow(dialog);
            dialog.pack();
            GuiUtils.center(dialog);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        } else {
            dialog.dispose();
        }

        dialog.setVisible(true);
        dialog.toFront();

        Vector v = getInventoryBeans();

        dialog.setInventoryDataSource(new InventoryDataResource(snmpProxy, getNodeName(), getNodeLabel(), v, fStringMap)); //modified by Zhou Chao, 2010/5/17
    }

    public IADManager(Properties prop) {
        aParamMap = new Properties();
        aReadCommunity = "public";
        aWriteCommunity = "public";
        aSnmpVersion = "v2";
        aSnmpPort = "161";
        snmpProxy = null;
        omcdParmMap = prop;
    }

    private Properties getTopoProperties() {
        Properties prop = null;
        if (DEBUG) {
            prop = new Properties();
            prop.setProperty("USER_NAME", "root");
            prop.setProperty("SERVER_NAME", "172.21.185.104");
            prop.setProperty("RMI_PORT", "1099");
            prop.setProperty("SERVER_PORT", "9090");
            prop.setProperty("country_abbr", "CN");
            prop.setProperty("language_abbr", "zh");
            //prop.setProperty("country_abbr", "US");
            //prop.setProperty("language_abbr", "english");
        } else {
            prop = UTopoUIContext.getInstance().getUIProperties();
            //added by Zhou Chao, 2009/6/30 -- begin
            String language = "";
            String country = "";
            if ( "true".equalsIgnoreCase(System.getProperty("dvm.mode.lct"))) {
                language = Locale.getDefault().getLanguage();
                country = Locale.getDefault().getCountry();
            } else {
                Properties uiProp = UTopoUIContext.getInstance().getUIProperties();
                language = uiProp.getProperty("language_abbr");
                country = uiProp.getProperty("country_abbr");
            }
            prop.setProperty("language_abbr", language);
            prop.setProperty("country_abbr", country);
            //added by Zhou Chao, 2009/6/30 -- end
        }

        return prop;
    }

    public void init() {
        if (omcdParmMap == null)
            return;

        Properties prop = getTopoProperties();
        System.out.println("IAD Properties:" + prop);
        System.out.println("omcd properties:" + omcdParmMap);
        String webPort = "9090";
        String aNodeIPAddress = omcdParmMap.getProperty("ipAddress");
        String aUserName = prop.getProperty("USER_NAME");
        String aFEHostIp = prop.getProperty("SERVER_NAME");
        String aFEHostName = prop.getProperty("SERVER_NAME");
        String aClientHostIP = null;
        String aClientHostName = null;
        String aLanguage = "";

        if (prop.getProperty("language_abbr") != null && prop.getProperty("language_abbr").trim().length() > 0) { //added by Zhou Chao, 2009/3/14
            aLanguage = prop.getProperty("language_abbr");
        } else {
            if (prop.getProperty("LANGUAGE") == null || prop.getProperty("LANGUAGE").trim().length() == 0)
                aLanguage = "en";
            else
                aLanguage = prop.getProperty("LANGUAGE").equalsIgnoreCase("chinese") ? "zh" : "en";
        }
        String aCountry = prop.getProperty("country_abbr");
        String aRmiPort = prop.getProperty("RMI_PORT");
        webPort = prop.getProperty("SERVER_PORT");
        try {
            aClientHostIP = InetAddress.getLocalHost().getHostAddress();
            aClientHostName = InetAddress.getLocalHost().getHostName();

            if (omcdParmMap.get("getCommunity") != null && omcdParmMap.get("writeCommunity") != null) {
                aReadCommunity = (String) omcdParmMap.get("getCommunity");
                aWriteCommunity = (String) omcdParmMap.get("writeCommunity");
            } else {
                aReadCommunity = "public";
                aWriteCommunity = "private";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (aNodeIPAddress != null)
            aParamMap.setProperty("NodeIPAddress", aNodeIPAddress);
        aParamMap.setProperty("ReadCommunity", aReadCommunity);
        aParamMap.setProperty("WriteCommunity", aWriteCommunity);
        aParamMap.setProperty("SnmpVersion", aSnmpVersion);
        aParamMap.setProperty("SnmpPort", aSnmpPort);
        aParamMap.setProperty("UserName", aUserName);
        aParamMap.setProperty("FEHostIp", aFEHostIp);
        aParamMap.setProperty("FEHostName", aFEHostName);
        aParamMap.setProperty("ClientHostIP", aClientHostIP);
        aParamMap.setProperty("ClientHostName", aClientHostName);
        aParamMap.setProperty("Language", aLanguage);
        aParamMap.setProperty("Country", aCountry);
        aParamMap.setProperty("RmiPort", aRmiPort);
        aParamMap.setProperty("WebPort", webPort);

        String name = omcdParmMap.getProperty("name") != null ? omcdParmMap.getProperty("name") : omcdParmMap.getProperty("neName");
        aParamMap.setProperty("MoNameList", name);
        aParamMap.setProperty("FocusMoName", name);

        if (DEBUG) {
            aParamMap.setProperty("Debug", "true");
            aParamMap.setProperty("swVersion", "1.1");
            aParamMap.setProperty("MoNameList", "ONU200a");
        }

        String urlStr = "http://" + aFEHostName + ":" + webPort + "/classes";
        DefaultSASAppletStub sasStub = new DefaultSASAppletStub ();
        sasStub.setParameter("SAS_PORT_DIR", "html");
        sasStub.setParameter("snmpAgentPort", aSnmpPort);
        sasStub.setParameter("PORT", "1575");
        sasStub.setParameter("CODEBASE", urlStr);
        sasStub.setParameter("DOCUMENTBASE", urlStr);
        try {
            URL codebase = new URL(urlStr);
            sasStub.setCodeBase(codebase);
            sasStub.setDocumentBase(codebase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setStub(sasStub);

        initContext();
    }

    protected void initSnmpProxy() {
        snmpProxy = new SnmpProxy(snmpParameter);
    }

    public void setSnmpParameter(ISnmpParameter snmpParameter) {
        this.snmpParameter = snmpParameter;
    }

    public SnmpProxy getSnmpProxy() {
        return snmpProxy;
    }

    protected void initContext() {
        initStringMap(initLocale()); //com/winnertel/em/standard/resource/GlobalStringMap
        initSnmpProxy();
    }

    private IStringMap fStringMap = null;

    private Locale initLocale() {
        Locale fLocale;
        String language = aParamMap.getProperty("Language");
        if (language.equals("zh")) {
            fLocale = new Locale("zh", "CN");
        } else {
            fLocale = new Locale("en", "US");
        }
        ResourceBundleProxy.getInstance().setLocale(fLocale);

        return fLocale;
    }

    public void initStringMap(Locale aLocale) {
        fStringMap = new GlobalStringMap(aLocale);
    }

    public Vector getInventoryBeans() {
        Task t = null;

        String neType = omcdParmMap.getProperty("neType", "");
        String neVersion = omcdParmMap.getProperty("swVersion", "");
        if (neType.startsWith("BBS1000") && neVersion.startsWith("2.3")) {
            t = new RefreshAllTask(new ONUMBean(snmpProxy));
        } else if (neType.startsWith("BBS4000") && neVersion.startsWith("1.0.")) { //added by Zhou Chao, 2009/1/5
            t = new RefreshAllTask(new GponOnuBean(snmpProxy));
        } else if (neType.startsWith("BBS4000") && neVersion.startsWith("4.0.")) { //added by Zhou Chao, 2010/5/17
            t = new RefreshAllTask(new OnuInfoTable(snmpProxy));
        } else {
            t = new RefreshAllTask(new OnuCtcBean(snmpProxy));
        }

        TaskManager tm = new TaskManager();
        Vector results = null;
        try {
            results = (Vector) tm.executeTask(t, dialog);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        if (results == null)
            return new Vector();
        else
            return results;
    }

    public void addChildWindow(Window childWindow) {
        Object o = this.getOmcdParmMap().get("parentFrame");
//        if (o instanceof UTAbstractWorkFrame) {
//            ((UTAbstractWorkFrame) o).addChildWindow(childWindow);
//        } else if (o instanceof GeponDvMWorkFrame) {
            ((GeponDvMWorkFrame) o).addChildWindow(childWindow);

    }

    public MainApplet getDvmFrame(Object key) {
        return (MainApplet) dvmCache.get(key);
    }

    public void setDvmFrame(Object key, MainApplet dvm) {
        dvmCache.put(key, dvm);
    }

    public void showDVM(ISnmpParameter snmpParameter, String title, String neType) {
        showDVM(snmpParameter, title, neType, null);
    }

    public void showDVM(ISnmpParameter snmpParameter, String title, String neType, String version) {
        setVisible(false);
        aParamMap.setProperty(MainApplet.PARAM_MO_NAME, title);
        aParamMap.setProperty("neType", neType);

        if (version != null)
            aParamMap.setProperty("swVersion", version);

        aParamMap.setProperty("ReadCommunity", snmpParameter.getReadCommunity());
        aParamMap.setProperty("WriteCommunity", snmpParameter.getWriteCommunity());
        aParamMap.setProperty("GUIStyle", "embedded");
        aParamMap.setProperty("DisplayName", title);

        if (DEBUG) {
            MainApplet.openManagedDVM(true, aParamMap, snmpParameter, title);
        /*
        } else if (DebugMode.isDebug()) { //added by Zhou Chao, 2009/3/14
            aParamMap.setProperty("Debug", "true");
            aParamMap.setProperty("name", neType);
            aParamMap.setProperty("MoNameList", neType);
            aParamMap.setProperty("FocusMoName", neType);
            MainApplet.openManagedDVM(true, aParamMap, snmpParameter, title);
        */
        } else {
            MainApplet applet = getDvmFrame(title);
            if (applet == null) {
                applet = new MainApplet(true);
                DefaultSASAppletStub sasStub = new DefaultSASAppletStub();
                applet.setStub(sasStub);
                applet.setParameterMap(aParamMap);
                ((SnmpParameter)snmpParameter).setClient(true);
                applet.setSnmpParameter(snmpParameter);

                JFrame frame = (JFrame) applet.getTopMostFrame();
                frame.setTitle(title);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                applet.init();
                applet.start();
                frame.toFront();
                frame.setVisible(true);
                applet.launch();

                setDvmFrame(title, applet);
                addChildWindow(frame);   //to let parent window manage the frame
                System.out.println("[MainApplet], add the frame to parent");

                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowListener(applet, fStringMap));
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setSize(screenSize);//added by Yang Yizai for NMS00066632

                URL url = IADManager.class.getResource("/resources/epon/DvMRes/images/mainFrameIcon.gif");
                if (url != null) {
                    frame.setIconImage(new ImageIcon(url).getImage());
                }
            } else {
                applet.getTopMostFrame().toFront();
                applet.getTopMostFrame().setVisible(true);
                applet.initFocus();
            }
        }
    }

    String getOnuCommunity(String community, String moduleId, String portId, String onuId) {
        StringBuffer sb = new StringBuffer(community);

        return sb.toString();
    }

    public static void main(String args[]) {
        Properties prop = new Properties();
        prop.put("neType", "BBS1000+");
        prop.put("neName", "10.4.32.119");
        prop.put("ipAddress", "10.4.32.119");
        prop.put("getCommunity", "public");
        prop.put("writeCommunity", "private");

        IADManager applet = new IADManager(prop);
        applet.showInventory();
    }

    @Override
    public String getParameter(String name) {
        String parameter = aParamMap.getProperty(name);
        if (parameter == null) {
            return super.getParameter(name);
        }
        return parameter;
    }

}

class WindowListener extends WindowAdapter {

    MainApplet applet;
    IStringMap fStringMap;

    public WindowListener(MainApplet applet, IStringMap stringMap) {
        this.applet = applet;
        fStringMap = stringMap;
    }

    public void windowClosing(WindowEvent e) {
        //no active device manager in current application.
        if (applet.fApplication.getActiveDeviceManager() == null) {
            onClose();
            return;
        }

        boolean save = Boolean.valueOf(applet.fApplication.getActiveDeviceManager().getProperties().getProperty("configChanged", "false"));
        if (save) {
            String msg = fStringMap.getString("Msg_Cfm_Save_Cfg");
            String title = fStringMap.getString("Please Confirm");
            int iReturn = JOptionPane.showConfirmDialog(applet.fApplication.getTopMostFrame(), msg, title, JOptionPane.YES_NO_CANCEL_OPTION);

            if (iReturn == JOptionPane.OK_OPTION) {
                Task t = new SaveTask();
                t.setCancelable(true);

                try {
                    Object o = applet.fApplication.getTaskManager().executeTask(t);
                    if (Boolean.TRUE != o) {
                        MessageDialog.showOperationFailedDialog(applet.fApplication);
                    }
                } catch (Exception ex) {
                    MessageDialog.showOperationFailedDialog(applet.fApplication);
                }
            } else if (iReturn == JOptionPane.CANCEL_OPTION) { //don't close dvm.
                return;
            }
        } else {
            String msg = fStringMap.getString("Msg_Cfm_Exit_Dvm");
            String title = fStringMap.getString("Please Confirm");
            int iReturn = JOptionPane.showConfirmDialog(applet.fApplication.getTopMostFrame(), msg, title, JOptionPane.OK_CANCEL_OPTION);
            if (iReturn != JOptionPane.OK_OPTION) {
                return;
            }
        }

        onClose();
    }

    protected void onClose() {
        applet.getTopMostFrame().setVisible(false);
    }

    class SaveTask extends Task {

        public Object execute() throws Exception {
            int timeout = applet.fApplication.getSnmpProxy().getTimeout();
            int retries = applet.fApplication.getSnmpProxy().getRetries();

            try {
                //save the configuration data.(sysMaintWriteMemory)
                String[] oidList = null;
                if(applet.getParameter("neType").startsWith("CLT")){
                    oidList = new String[]{".1.3.6.1.4.1.17409.2.4.1.3.8.0"};
                }else {
                    oidList = new String[]{".1.3.6.1.4.1.45121.1.3.10.100.106.1.9.0"};
                }
                Integer[] valList = new Integer[]{1};
                byte[] typeList = new byte[]{2};

                applet.fApplication.getSnmpProxy().setTimeout(3);
                applet.fApplication.getSnmpProxy().setRetries(1);
                applet.fApplication.getSnmpProxy().saveRow(oidList, valList, typeList);
            } catch (Exception e) {
                e.printStackTrace();
                return Boolean.FALSE;
            } finally {
                applet.fApplication.getSnmpProxy().setTimeout(timeout);
                applet.fApplication.getSnmpProxy().setRetries(retries);
            }

            return Boolean.TRUE;
        }

    }

}