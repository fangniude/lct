package com.winnertel.ems.epon.iad.common;

import com.winnertel.em.framework.IMainApplet;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.ILogable;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UApplet;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.UTree;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.Application;
import com.winnertel.em.standard.Session;
import com.winnertel.em.standard.device.DeviceManager;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.gui.EditorDialog;
import com.winnertel.em.standard.gui.EmbeddedEditorDialog;
import com.winnertel.em.standard.gui.GlobalShelfView;
import com.winnertel.em.standard.gui.GuiComposer;
import com.winnertel.em.standard.gui.IpMenuBar;
import com.winnertel.em.standard.gui.MessageTable;
import com.winnertel.em.standard.resource.ResourceManager;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.inms.topoui.UTopoUIContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Introspector;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * The MainApplet class.
 */
public class MainApplet extends UApplet implements IMainApplet {

    private ILogger fLogger = LoggerController.createLogger(MainApplet.class);
    private boolean fStandAlone = false;
    private Properties fParameterMap = null;
    public Application fApplication = null;
    private IDeviceManager dvm = null;
    private MessageTable fMessageTable = null;
    private IEditorDialog fEditorDialog = null;
    private ListOrderedMap fFunctionTreeMap = null;
    private JPanel fRightArea = null;
    private ISnmpParameter snmpParam = null;

    public static final String PARAM_MO_NAME = "MoName";
    public static final String PARAM_MO_LABEL = "DisplayName";
    public static final String PARAM_MO_TYPE = "neType";
    public static final String PARAM_MO_VERSION = "swVersion";
    public static final String PARAM_IP_ADDRESS = "NodeIPAddress";
    public static final String PARAM_READ_COMMUNITY = "ReadCommunity";
    public static final String PARAM_WRITE_COMMUNITY = "WriteCommunity";
    public static final String PARAM_SNMP_VERSION = "SnmpVersion";
    public static final String PARAM_SNMP_PORT = "SnmpPort";
    public static final String PARAM_USER_NAME = "UserName";
    public static final String PARAM_FE_IP = "FEHostIp";
    public static final String PARAM_FE_NAME = "FEHostName";
    public static final String PARAM_CLIENT_IP = "ClientHostIP";
    public static final String PARAM_CLIENT_NAME = "ClientHostName";
    public static final String PARAM_LANGUAGE = "Language";
    public static final String PARAM_COUNTRY = "Country";
    public static final String PARAM_WEB_PORT = "WebPort";
    public static final String PARAM_GUI_STYLE = "GUIStyle";
    public static final String PARAM_DEBUG = "Debug";

    private String[] fTreeNameList = {
            FunctionTreeNode.IType.CM,
            FunctionTreeNode.IType.FM,
            FunctionTreeNode.IType.PM,
            FunctionTreeNode.IType.CPE,
    };

    private boolean initialized;

    public MainApplet() {
        this(false);
    }

    public MainApplet(boolean isStandalone) {
        super();
        fStandAlone = isStandalone;

        if (isStandAlone()) {
            final JFrame frame = new JFrame();
            frame.getContentPane().add(this, BorderLayout.CENTER);

//            frame.addWindowListener(new WindowAdapter() {
//                public void windowClosing(WindowEvent e) {
//                    stop();
//                    destroy();
//                    frame.dispose();
//                    System.exit(0);
//                }
//            });
        }
    }

    public boolean isStandAlone() {
        return fStandAlone;
    }

    public JApplet getGui() {
        return this;
    }

    public void callInit() {
        super.init();
    }

    public void init() {
        super.init();

        initLogger();
        initFont();
        initApplication();
        initSession();
        initSnmpProxy();
        fApplication.startUp();
        initOptionPaneButtonText();
        createDeviceManager();
        //setMainFrameTitle();
    }

    protected void initLogger() {
        if (isDebug()) {
            Logger tLogger = LogManager.getLoggerRepository().getRootLogger();
            tLogger.setLevel(Level.DEBUG);
        }
    }

    private boolean isDebug() {
        return Boolean.valueOf(getParameter(MainApplet.PARAM_DEBUG));
    }

    protected void initFont() {
//        GuiUtil.initFont();
    }

    protected void initApplication() {
        fApplication = new Application(getLocale());
        fApplication.setMainApplet(this);
        fApplication.setTopMostFrame(getTopMostFrame());
        if (isDebug()) {
            fApplication.setDebug(true);
        } else {
            fApplication.setDebug(false);
        }
        if ("embedded".equals(getParameter(MainApplet.PARAM_GUI_STYLE))) {
            fApplication.setGUIStyle(Application.EMBEDDED_STYLE);
        } else {
            fApplication.setGUIStyle(Application.POPUP_STYLE);
        }
    }

    protected void initEditorDialog() {
        if (fApplication.getGUIStyle() == Application.EMBEDDED_STYLE) {
            fEditorDialog = new EmbeddedEditorDialog(fApplication, fRightArea);
        } else {
            fEditorDialog = new EditorDialog(fApplication);
        }
    }

    protected void initSession() {
        ISession session = new Session(getParameter(MainApplet.PARAM_USER_NAME));
        if (isStandAlone()) {
            InetAddress localAddress = null;
            try {
                localAddress = InetAddress.getLocalHost();
                session.setHostIp(localAddress.getHostAddress());
                session.setHostName(localAddress.getHostName());
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        } else {
            session.setHostIp(getParameter(MainApplet.PARAM_CLIENT_IP));
            session.setHostName(getParameter(MainApplet.PARAM_CLIENT_NAME));
        }
        fApplication.setSession(session);
    }

    protected void initSnmpProxy() {
        if (snmpParam == null) { //modified by Zhou Chao, 2009/3/14
            String host = getParameter(MainApplet.PARAM_IP_ADDRESS);
            int port = Integer.parseInt(getParameter(MainApplet.PARAM_SNMP_PORT));
            if (isStandAlone()) {
                snmpParam = new SnmpParameter(host, port);
            } else {
                snmpParam = new SnmpParameter(host, port, true);
            }

            ((SnmpParameter) snmpParam).setReadCommunity(getParameter(MainApplet.PARAM_READ_COMMUNITY));
            ((SnmpParameter) snmpParam).setWriteCommunity(getParameter(MainApplet.PARAM_WRITE_COMMUNITY));
            ((SnmpParameter) snmpParam).setSnmpVersion(DvmUtil.convertSnmpVersion(getParameter(MainApplet.PARAM_SNMP_VERSION)));
        }
        SnmpProxy snmpProxy = new SnmpProxy(snmpParam);
        fApplication.setSnmpProxy(snmpProxy);
    }

    public void setSnmpParameter(ISnmpParameter param) {
        this.snmpParam = param;
    }

    private void initOptionPaneButtonText() {
        if ("en".equals(getLocale().getLanguage())) {
            UIManager.put("OptionPane.yesButtonText", "Yes");
            UIManager.put("OptionPane.noButtonText", "No");
            UIManager.put("OptionPane.cancelButtonText", "Cancel");
            UIManager.put("OptionPane.okButtonText", "OK");
            UIManager.put("OptionPane.messageDialogTitle", "Message");
        }
    }

    public Frame getTopMostFrame() {
        return GuiUtil.getParentFrame(this);
    }

    public void start() {
        super.start();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // add function tree and shelf view
        JSplitPane spHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.setPreferredSize(new Dimension(200, 0));
        JScrollPane scrollPane = new JScrollPane();

        fFunctionTreeMap = new ListOrderedMap();

        spHorizontal.add(tabbedPane, JSplitPane.LEFT);
        spHorizontal.add(scrollPane, JSplitPane.RIGHT);
        fRightArea = new JPanel(new BorderLayout());
        scrollPane.getViewport().add(fRightArea);
        spHorizontal.setOneTouchExpandable(true);

        // add message window
        // Removed by SuPeng's request
        /*
        JSplitPane spVertical = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        spVertical.add( spHorizontal, JSplitPane.TOP );
        MessageTable msgTable = new MessageTable( fApplication );
        msgTable.setBackground( Color.white );
        fMessageTable = msgTable;
        int logPaneHeight = 120;
        JScrollPane spMW = new JScrollPane( msgTable );
        spMW.setAutoscrolls( true );
        spMW.setPreferredSize( new Dimension( 0, logPaneHeight ) );
        spVertical.add( spMW, JSplitPane.BOTTOM );
        spVertical.setOneTouchExpandable( true );
        spVertical.setDividerLocation( getHeight() - logPaneHeight );

        contentPane.add( spVertical, BorderLayout.CENTER );
        */
        contentPane.add(spHorizontal, BorderLayout.CENTER);

        initEditorDialog();

        List treeTypes = dvm.getGuiComposer().getFunctionTreeTypes();
        if (treeTypes != null) {
            for (int i = 0; i < fTreeNameList.length; i++) {
                if (treeTypes.contains(fTreeNameList[i])) {
                    UTree tree = createFunctionTree(dvm);
                    if (tree != null) {
                        fFunctionTreeMap.put(fTreeNameList[i], tree);

                        JScrollPane spTree = new JScrollPane((UTree) fFunctionTreeMap.get(fTreeNameList[i]));
                        spTree.setAutoscrolls(true);
                        tabbedPane.add(fApplication.getGlobalStringMap().getString(fTreeNameList[i]), spTree);
                    }
                }
            }
        }

        setActiveDeviceManager(null);
    }

    private UTree createFunctionTree(IDeviceManager aDvm) {
        FunctionTreeNodeObject userObject = new FunctionTreeNodeObject(aDvm, aDvm.getName(), aDvm.getDisplayName(), null, null, FunctionTreeNodeObject.ME);
        final UTree functionTree = new UTree(new FunctionTreeNode(userObject));

        //revert back to use mouse adapter.
        functionTree.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!SwingUtilities.isLeftMouseButton(e)) {
                    return;
                }

                TreePath selectedPath = functionTree.getPathForLocation(e.getX(), e.getY());
                if (selectedPath == null) {
                    return;
                }

                FunctionTreeNode node = (FunctionTreeNode) selectedPath.getLastPathComponent();
                functionTree.setSelectionPath(selectedPath);
                FunctionTreeNodeObject tUserObject = (FunctionTreeNodeObject) node.getUserObject();
                BaseAction act = tUserObject.getExecutor();
                if (act != null) {
                    ActionEvent event = new ActionEvent(node, ActionEvent.ACTION_PERFORMED, (String) act.getValue(BaseAction.ID));
                    act.actionPerformed(event);
                }
            }
        });

        return functionTree;
    }

    public void launch() {
        if (!initialized) {
            long start = System.currentTimeMillis();

            dvm.startup();
            createGuiComponent(dvm);

            // set function trees
            int treeCount = fTreeNameList.length;
            for (int i = 0; i < treeCount; i++) {
                UTree tree = (UTree) fFunctionTreeMap.get(fTreeNameList[i]);
                if (tree != null) {
                    FunctionTreeNode node = (FunctionTreeNode) tree.getModel().getRoot();
                    tree.expandPath(new TreePath(node.getPath()));
                }
            }

            setActiveDeviceManager(dvm);

            initialized = true;
            initFocus();

            System.out.println("###########Total time " + (System.currentTimeMillis() - start));
        }
    }

    private void createGuiComponent(IDeviceManager aDvm) {
        IGuiComposer composer = aDvm.getGuiComposer();

        if (aDvm.getMenuBar() == null) {
            aDvm.setMenuBar(composer.composeMenuBar("default"));
        }
        if (aDvm.getToolBar() == null) {
            aDvm.setToolBar(composer.composeToolBar("default"));
        }

        int treeCount = fTreeNameList.length;
        for (int i = 0; i < treeCount; i++) {
            String type = fTreeNameList[i];
            FunctionTreeNode node = composer.composeFunctionTreeNode(aDvm, type);
            if (node != null) {
                aDvm.setFunctionTreeNode(type, node);
            }
        }
    }

    public synchronized void setActiveDeviceManager(final IDeviceManager aDvm) {
        IDeviceManager activeDvm = fApplication.getActiveDeviceManager();
        if (aDvm != null && activeDvm == aDvm) {
            return;
        }

        // remove original menu bar and tool bar
        setJMenuBar(null);
        if (activeDvm != null && activeDvm.getToolBar() != null) {
            getContentPane().remove(activeDvm.getToolBar());
        }

        // set active dvm
        fApplication.setActiveDeviceManager(aDvm);

        if (aDvm == null) {
            // user clicked on the IP node
            setShelfView(new GlobalShelfView(fApplication));
            setJMenuBar(new IpMenuBar(fApplication));
        } else {
            // set menu bar
            if (aDvm.getMenuBar() != null) {
                // setJMenuBar method will remove the original menu bar
                setJMenuBar(aDvm.getMenuBar());
            }

            // set tool bar
            if (aDvm.getToolBar() != null) {
                getContentPane().add(aDvm.getToolBar(), BorderLayout.NORTH);
            }

            // set snmp proxy properties
            // move here by Lin Xuncai, because shelfView.refresh() should use right community.
            //ISnmpProxy snmpProxy = fApplication.getSnmpProxy();
            //snmpProxy.setReadCommunity( aDvm.getReadCommunity() );
            //snmpProxy.setWriteCommunity( aDvm.getWriteCommunity() );
            //snmpProxy.setSnmpVersion(aDvm.getSnmpVersion());
            //snmpProxy.setTargetPort(aDvm.getTargetPort());

            // set shelf view
            if (aDvm.getShelfViewPane() == null) {
                // create shelf view
                try {
                    new Thread() {
                        public void run() {
                            UPanel shelfView = aDvm.getGuiComposer().composeShelfView();
                            if (shelfView == null) {
                                // make a fake shelf view
                                shelfView = UPanel.createInstance(fApplication);
                            }
                            shelfView.refresh();
                            aDvm.setShelfViewPane(shelfView);
                            setShelfView(aDvm.getShelfViewPane());
                        }
                    }.start();
                } catch (Exception ex) {
                    fLogger.error("Error in creating shelf view", ex);
                }
            }
        }

        invalidate();
        validate();
        repaint();

        if (fApplication.getSnmpProxy().getWriteCommunity() == null && aDvm != null && aDvm.getCommunitySelector() != null) {
            aDvm.getCommunitySelector().actionPerformed(null);
        }
    }

    private void createDeviceManager() {
        dvm = new DeviceManager(fApplication);
        String moName = getParameter(MainApplet.PARAM_MO_NAME);
        String moVersion = getParameter(MainApplet.PARAM_MO_VERSION);
        if (moVersion == null) {
            moVersion = getParameter("swVersion");
        }
        moVersion = DvmUtil.setDefaultNodeVersion(moVersion);
        dvm.setName(moName);
        dvm.setDisplayName(getParameter(MainApplet.PARAM_MO_LABEL));
        if ("true".equalsIgnoreCase(System.getProperty("dvm.lct.on"))) {
            dvm.setDisplayName(getParameter(MainApplet.PARAM_MO_TYPE) + "_" + getParameter(MainApplet.PARAM_MO_LABEL));
        } else {
            dvm.setDisplayName(UTopoUIContext.getInstance().getMOTypeLabel(getParameter(MainApplet.PARAM_MO_TYPE)) + "_" + getParameter(MainApplet.PARAM_MO_LABEL));
        }
        String type = getParameter(MainApplet.PARAM_MO_TYPE);
        dvm.setType(type);

        if (DvmUtil.setDvmResourcePathAndVersion(fApplication, dvm, type, moVersion)) {
            ResourceManager rm = new ResourceManager(dvm.getResourcePath(), fApplication, getLocale());
            dvm.setResourceManager(rm);
            dvm.setGuiComposer(new GuiComposer(fApplication, rm));
        } else {
            fLogger.error("Can't find configuration file for " + moName);
        }

        dvm.setReadCommunity(getParameter(MainApplet.PARAM_READ_COMMUNITY));
        dvm.setWriteCommunity(getParameter(MainApplet.PARAM_WRITE_COMMUNITY));

        OperationObject oo = new OperationObject();
        oo.setManagedObject(getParameter(MainApplet.PARAM_MO_LABEL));
        dvm.setOperationObject(oo);

        dvm.setProperties(new Properties());

        // set device manager list to application
        IDeviceManager[] dvmList = new IDeviceManager[]{dvm};
        fApplication.setDeviceManagerList(dvmList);
    }

    public void stop() {
        super.stop();
    }

    public void destroy() {
        super.destroy();

        fFunctionTreeMap.clear();

        // destroy caches
        Introspector.flushCaches();
        PropertyUtils.clearDescriptors();

        setJMenuBar(null);
        if (fEditorDialog != null) {
            fEditorDialog.getTabbedPane().removeAll();
            fEditorDialog.dispose();
        }
        //This code phase has moved to Application.shutdown()

        // destroy SNMP resources
//        CommonHandleBag.destroy(fApplication.getActiveDeviceManager());
//        CommonHandleBag.destroy(this);

        fApplication.shutDown();

        // destroy gui resources
        destroyComponents(this.getContentPane());
    }

    private void destroyComponents(Container aParent) {
        Component[] childArray = aParent.getComponents();
        int childCount = childArray.length;
        for (int i = 0; i < childCount; i++) {
            Component child = childArray[i];
            if (child instanceof Container) {
                destroyComponents((Container) child);
            }
            aParent.remove(child);
        }
    }

    public UTree getFunctionTree(String aType) {
        if (fFunctionTreeMap.containsKey(aType)) {
            return (UTree) fFunctionTreeMap.get(aType);
        } else {
            return null;
        }
    }

    public void setShelfView(UPanel aShelfView) {
        fRightArea.removeAll();
        fRightArea.add(aShelfView, BorderLayout.CENTER);
        fRightArea.validate();
        fRightArea.repaint();
    }

    public IEditorDialog getEditorDialog() {
        return fEditorDialog;
    }

    public ILogable getMessageWindow() {
        return fMessageTable;
    }

    public Locale getLocale() {
        Locale result = null;

        String language = getParameter(MainApplet.PARAM_LANGUAGE);
        String country = getParameter(MainApplet.PARAM_COUNTRY);
        try {
            result = new Locale(language, country);
        } catch (Exception ex) {
            result = super.getLocale();
        }

        return result;
    }

    public String getParameter(String name) {
        if (isStandAlone()) {
            return fParameterMap.getProperty(name);
        } else {
            String value = null;
            try {
                value = super.getParameter(name);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (value == null) {
                value = fParameterMap.getProperty(name);
            }

            System.out.println("Get the value of " + name + ": " + value);

            return value;
        }
    }

    public Properties getParameter() {
        return (Properties) fParameterMap.clone();
    }

    public void setParameterMap(Properties aParamMap) {
        if (aParamMap == null || aParamMap.size() == 0) {
            throw new IllegalArgumentException("Null or empty parameter list passed");
        }

        fParameterMap = aParamMap;
    }

    public URL getDocumentBase() {
        try {
            return new URL("http://" + getParameter(MainApplet.PARAM_FE_IP) + ":" + getParameter(MainApplet.PARAM_WEB_PORT));
        } catch (Exception ex) {
            fLogger.error("Document base is invalid");
            return null;
        }
    }

    public URL getCodeBase() {
        try {
            return new URL("http://" + getParameter(MainApplet.PARAM_FE_IP) + ":" + getParameter(MainApplet.PARAM_WEB_PORT) + "/classes");
        } catch (Exception ex) {
            fLogger.error("Document base is invalid");
            return null;
        }
    }

    /**
     * <b>Purpose</b> <p>
     * Open a new DVM which is managed by the opening one.
     *
     * @param newDVMPara Including all the parameters from the manager DVM <p>
     *                   and added parameters as follow: <p>
     *                   PARAM_PROXY_DVM_TYPE,
     *                   PARAM_PROXY_DVM_VERSION <p>
     *                   and updated parameters as follow: <p>
     *                   PARAM_READ_COMMUNITY,
     *                   PARAM_WRITE_COMMUNITY
     */
    public static void openManagedDVM(boolean bStandAlone, Properties newDVMPara) {
        MainApplet applet = new MainApplet(bStandAlone);
        applet.setParameterMap(newDVMPara);

        String host = newDVMPara.getProperty(MainApplet.PARAM_IP_ADDRESS);
        int port = Integer.parseInt(newDVMPara.getProperty(MainApplet.PARAM_SNMP_PORT));
        SnmpParameter snmpParameter = new SnmpParameter(host, port, true);
        snmpParameter.setReadCommunity(newDVMPara.getProperty(MainApplet.PARAM_READ_COMMUNITY));
        snmpParameter.setWriteCommunity(newDVMPara.getProperty(MainApplet.PARAM_WRITE_COMMUNITY));
        applet.setSnmpParameter(snmpParameter);

        JFrame frame = (JFrame) applet.getTopMostFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applet.init();
        applet.start();
        frame.toFront();
        frame.setVisible(true);
        applet.launch();
    }

    public static void openManagedDVM(boolean bStandAlone, Properties newDVMPara, ISnmpParameter snmpParameter, String title) {
        MainApplet applet = new MainApplet(bStandAlone);
        applet.setParameterMap(newDVMPara);
        applet.setSnmpParameter(snmpParameter);

        JFrame frame = (JFrame) applet.getTopMostFrame();
        frame.setTitle(title);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applet.init();
        applet.start();
        frame.toFront();
        frame.setVisible(true);
        applet.launch();
    }

    public void initFocus() {
        if (fRightArea != null)
            fRightArea.requestFocus();
    }

}