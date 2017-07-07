package com.winnertel.em.standard;

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
import com.winnertel.em.standard.device.DeviceManager;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.gui.*;
import com.winnertel.em.standard.resource.ResourceManager;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.nms.lite.LiteContext;
import com.winnertel.nms.topodb.ULManagedObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.beans.Introspector;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;
import java.util.List;

public class MainApplet extends UApplet implements IMainApplet {

    private ILogger fLogger = LoggerController.createLogger(MainApplet.class);

    private boolean fStandAlone = false;

    private Properties fParameterMap = null;

    public Application fApplication = null;

    //there is no referenced.
    private MessageTable fMessageTable = null;

    private IEditorDialog fEditorDialog = null;

    protected ListOrderedMap fDeviceManagerMap = null;

    private ListOrderedMap fFunctionTreeMap = null;

    private JPanel fRightArea = null;

    private ISnmpParameter snmpParam = null;

    public static final String PARAM_IP_ADDRESS = "NodeIPAddress";
    public static final String PARAM_MO_VERSION = "swVersion";
    public static final String PARAM_READ_COMMUNITY = "ReadCommunity";
    public static final String PARAM_WRITE_COMMUNITY = "WriteCommunity";
    public static final String PARAM_SNMP_VERSION = "SnmpVersion";
    public static final String PARAM_SNMP_PORT = "SnmpPort";
    public static final String PARAM_MO_NAME_LIST = "MoNameList";
    public static final String PARAM_FOCUS_MO = "FocusMoName";
    public static final String PARAM_USER_NAME = "UserName";
    public static final String PARAM_FE_IP = "FEHostIp";
    public static final String PARAM_FE_NAME = "FEHostName";
    public static final String PARAM_CLIENT_IP = "ClientHostIP";
    public static final String PARAM_CLIENT_NAME = "ClientHostName";
    public static final String PARAM_LANGUAGE = "Language";
    public static final String PARAM_COUNTRY = "Country";
    public static final String PARAM_RMI_PORT = "RmiPort";
    public static final String PARAM_WEB_PORT = "WebPort";
    public static final String PARAM_GUI_STYLE = "GUIStyle";
    public static final String PARAM_DEBUG = "Debug";

    public static final String PARAM_PROXYED_IP_ADDRESS = "NodeProxyedIPAddress";
    public static final String PARAM_PROXY_DVM_TYPE = "ProxyDVMType";
    public static final String PARAM_PROXY_DVM_VERSION = "ProxyDVMVersion";

    private String[] fTreeNameList = {
            FunctionTreeNode.IType.CM,
            FunctionTreeNode.IType.FM,
            FunctionTreeNode.IType.PM,
            FunctionTreeNode.IType.CPE,
            FunctionTreeNode.IType.UG,
    };

    private boolean initialized;

    private boolean bProxyDVM = false;

    public MainApplet() {
        this(false);
    }

    public MainApplet(boolean isStandalone) {
        super();
        fStandAlone = isStandalone;

        if (isStandAlone()) {
            final JFrame frame = new JFrame();
            frame.getContentPane().add(this, BorderLayout.CENTER);

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    stop();
                    destroy();
                    frame.dispose();
                    System.exit(0);
                }
            });
        }
    }

    public MainApplet(boolean isStandalone, boolean bProxy) {
        super();
        fStandAlone = isStandalone;
        bProxyDVM = bProxy;

        final JFrame frame = new JFrame();
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                getTopMostFrame().setVisible(false);
            }
        });
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
        initApplication();
        initSession();
        initSnmpProxy();
        fApplication.startUp();
        createDeviceManagerList();
    }

    protected void initLogger() {
        //LoggerController.registerLoggerFactory(new Log4jLoggerFactory(false));
        //Layout patternLayout = new PatternLayout("%-5p %c %x - %m%n");
        //Appender consoleAppender = new ConsoleAppender(patternLayout);
        //BasicConfigurator.configure(consoleAppender);
        if (isDebug()) {
            Logger tLogger = LogManager.getLoggerRepository().getRootLogger();
            tLogger.setLevel(Level.DEBUG);
        }
    }

    private boolean isDebug() {
        return Boolean.valueOf(getParameter(PARAM_DEBUG));
    }


    protected void initApplication() {
        fApplication = new Application(getLocale());
        fApplication.setMainApplet(this);
        fApplication.setTopMostFrame(getTopMostFrame());
        if (isDebug() || LiteContext.isLCTModel() ) {
            fApplication.setDebug(true);
        } else {
            fApplication.setDebug(false);
        }
//        if ("embedded".equals(getParameter(PARAM_GUI_STYLE))) {
            fApplication.setGUIStyle(Application.EMBEDDED_STYLE);
//        } else {
//            fApplication.setGUIStyle(Application.POPUP_STYLE);
//        }
    }

    protected void initEditorDialog() {
        if (fApplication.getGUIStyle() == Application.EMBEDDED_STYLE) {
            fEditorDialog = new EmbeddedEditorDialog(fApplication, fRightArea);
        } else {
            fEditorDialog = new EditorDialog(fApplication);
        }

    }

    protected void initSession() {
        ISession session = new Session(getParameter(PARAM_USER_NAME));
        if (isStandAlone()) {
            InetAddress localAddress = null;
            try {
                localAddress = InetAddress.getLocalHost();
                session.setHostIp(localAddress.getHostAddress());
                session.setHostName(localAddress.getHostName());
            } catch (UnknownHostException ex) {
            }
        } else {
            session.setHostIp(getParameter(PARAM_CLIENT_IP));
            session.setHostName(getParameter(PARAM_CLIENT_NAME));
        }
        fApplication.setSession(session);
    }

    protected void initSnmpProxy() {

        if( snmpParam != null) {
            SnmpProxy snmpProxy = new SnmpProxy(snmpParam);
            fApplication.setSnmpProxy(snmpProxy);
        } else {
        	SnmpParameter snmpParameter = new SnmpParameter();
        	snmpParameter.setClient(true);
        	snmpParameter.setTargetHost("192.168.6.100");
        	snmpParameter.setTargetPort(161);
        	snmpParam = (ISnmpParameter)snmpParameter;
        	SnmpProxy snmpProxy = new SnmpProxy(snmpParam);
            fApplication.setSnmpProxy(snmpProxy);
		}

    }

    public void setSnmpParameter(ISnmpParameter param) {
        this.snmpParam = param;
    }


    public Frame getTopMostFrame() {
        return GuiUtil.getParentFrame(this);
    }

    private JTextField tfSearch = new JTextField();
    private JPanel searchflow = new JPanel( new BorderLayout());

    private void onSearch() {
        //TODO: On ISearch
        String text = tfSearch.getText();


        if( activedTree != null ) {
            Enumeration<TreePath> openedPaths = activedTree.getExpandedDescendants( new TreePath(activedTree.getModel().getRoot()));
            if ( openedPaths != null ) {
                while (openedPaths.hasMoreElements()) {
                    activedTree.collapsePath( openedPaths.nextElement() );
                }
            }


            Vector<TreePath> paths = fApplication.getActiveDeviceManager().getGuiComposer().search( (FunctionTreeNode)activedTree.getModel().getRoot(), text );
            for( TreePath path : paths ) {
                activedTree.expandPath(path);
            }

            activedTree.updateUI();
        }

    }

    public void start() {
        super.start();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // add function tree and shelf view
        JSplitPane spHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.setPreferredSize(new Dimension(200, 0));
        JScrollPane scrollPane = new JScrollPane();

        fFunctionTreeMap = new ListOrderedMap();

        JPanel panel = new JPanel( new BorderLayout( ) );

        //---------- support search key
        searchflow.add(tfSearch, BorderLayout.CENTER);
        tfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSearch();
            }
        });
        JButton close = new JButton( new ImageIcon( getClass().getResource("/com/winnertel/ems/fm/client/close.gif")));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchflow.setVisible(false);
            }
        });
        searchflow.add( close, BorderLayout.EAST);
        panel.add( searchflow, BorderLayout.NORTH );
        //---------- support search key

        panel.add( tabbedPane, BorderLayout.CENTER );

        spHorizontal.add(panel, JSplitPane.LEFT);
        spHorizontal.add(scrollPane, JSplitPane.RIGHT);
        fRightArea = new JPanel(new BorderLayout());
        scrollPane.getViewport().add(fRightArea);
        spHorizontal.setOneTouchExpandable(true);

        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (initialized) {
                    tabChanged( tabbedPane );
                }
            }
        });


        contentPane.add(spHorizontal, BorderLayout.CENTER);

        initEditorDialog();

        if (fDeviceManagerMap != null) {
            for (int x = 0; x < fDeviceManagerMap.size(); x++) {
                IDeviceManager dvm = (IDeviceManager) fDeviceManagerMap.getValue(x);
                int nameCount = fTreeNameList.length;
                List treeTypes = dvm.getGuiComposer().getFunctionTreeTypes();
                if (treeTypes == null || treeTypes.size() == 0) {
                    continue;
                }
                for (int i = 0; i < nameCount; i++) {
                    if (treeTypes.contains(fTreeNameList[i])) {
                        UTree tree = createFunctionTree(dvm);
                        if (tree != null) {
                            fFunctionTreeMap.put(fTreeNameList[i], tree);

                            JScrollPane spTree = new JScrollPane((UTree) fFunctionTreeMap.get(fTreeNameList[i]));
                            spTree.setAutoscrolls(true);
                            String tabName = fApplication.getGlobalStringMap().getString(fTreeNameList[i]);
                            tabbedPane.add( tabName, spTree);

                            if( activedTree == null ) {
                                activedTree = tree ;
                            }

                        }
                    }
                }
            }
        }

        setActiveDeviceManager(null);
    }

    protected void tabChanged( final JTabbedPane tabbedPane ) {
        getEditorDialog().getTabbedPane().removeAll();

        int selectedIndex = tabbedPane.getModel().getSelectedIndex();
        JScrollPane jScrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
        activedTree = (UTree) jScrollPane.getViewport().getComponents()[0];
        activedTree.clearSelection();
    }

    private UTree activedTree;

    private UTree createFunctionTree(IDeviceManager aDvm) {
        FunctionTreeNodeObject userObject = new FunctionTreeNodeObject(aDvm, PARAM_FOCUS_MO, aDvm.getDisplayName(), null, null, FunctionTreeNodeObject.ME);
        final UTree functionTree = new UTree(new FunctionTreeNode(userObject));

        functionTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                TreePath selectedPath = treeSelectionEvent.getNewLeadSelectionPath();
                if (selectedPath == null) {
                    return;
                }
                FunctionTreeNode node = (FunctionTreeNode) selectedPath.getLastPathComponent();
                functionTree.setSelectionPath(selectedPath);
                FunctionTreeNodeObject tUserObject = (FunctionTreeNodeObject) node.getUserObject();
                BaseAction act = tUserObject.getExecutor();
                if (act != null) {
                    ActionEvent event = new ActionEvent(node, ActionEvent.ACTION_PERFORMED,
                            (String) act.getValue(BaseAction.ID));
                    act.actionPerformed(event);
                }
            }
        });
        return functionTree;
    }

    public void launch() {
        if (fDeviceManagerMap == null)
            return;
        if (!initialized) {
            // create gui components for each device manager
            for (int x = 0; x < fDeviceManagerMap.size(); x++) {
                IDeviceManager dvm = (IDeviceManager) fDeviceManagerMap.getValue(x);
                dvm.startup();
                createGuiComponent(dvm);
            }

            // set function trees
            int treeCount = fTreeNameList.length;
            for (int i = 0; i < treeCount; i++) {
                UTree tree = (UTree) fFunctionTreeMap.get(fTreeNameList[i]);
                if (tree != null) {
                    FunctionTreeNode node = (FunctionTreeNode) tree.getModel().getRoot();
                    tree.expandPath(new TreePath(node.getPath()));
                }
            }

            if (getParameter(PARAM_FOCUS_MO) != null)
                setActiveDeviceManager((IDeviceManager) fDeviceManagerMap.get(getParameter(PARAM_FOCUS_MO)));
            else if (fDeviceManagerMap.size() > 0)
                setActiveDeviceManager((IDeviceManager) fDeviceManagerMap.getValue(0));

            initialized = true;
            initFocus();
        }
    }

    //TODO: Used by ShelfView
    public void launchUI(IDeviceManager dvm) {
        if (!initialized) {
            launch();
        } else {
            createGuiComponent(dvm);
        }
    }

    protected void createGuiComponent(IDeviceManager aDvm) {
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


            // set shelf view
            /*if (aDvm.getShelfViewPane() == null) {
                try {
                    new Thread() {
                        public void run() {
                            UPanel shelfView = aDvm.getGuiComposer().composeShelfView();
                            if (shelfView == null) {
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
            }*/
        }

        invalidate();
        validate();
        repaint();

        if (fApplication.getSnmpProxy().getWriteCommunity() == null && aDvm != null && aDvm.getCommunitySelector() != null) {
            aDvm.getCommunitySelector().actionPerformed(null);
        }
    }

    protected void createDeviceManagerList() {
        Collection moList = parseMoList();
        if (moList.size() == 0) {
            return;
        }

        fDeviceManagerMap = new ListOrderedMap();
        Iterator it = moList.iterator();
        while (it.hasNext()) {
            IDeviceManager dvm = new DeviceManager(fApplication);
            String moName = (String) it.next();
            ULManagedObject mo = fApplication.getPlatformProxy().getManagedObject(moName);
            if (mo == null) {
                fLogger.error("Can't find MO info for " + moName);
                continue;
            }

            // 1. get version from parameters
            String nodeVer = getParameter(MainApplet.PARAM_MO_VERSION);
            if (null == nodeVer) {
                // 2. if not find in parameters, get nodeVersion from platform
                Properties props = mo.getProperties();
                nodeVer = props.getProperty("nodeVersion");
                if (nodeVer == null) {
                    if (isDebug()) {
                        nodeVer = getParameter("swVersion");
                    } else {
                        // 3. if not find yet, get swVersion from platform
                        nodeVer = props.getProperty("swVersion");
                    }
                }
            }
            nodeVer = DvmUtil.setDefaultNodeVersion(nodeVer);
            dvm.setName(moName);
            dvm.setDisplayName(mo.getDisplayName());

            String type = this.getParameter("neType");
            if (type == null) {
                type = mo.getType();
            }
            dvm.setType(type);
            if (isProxyDVM()) {
                type = getParameter(PARAM_PROXY_DVM_TYPE);
                nodeVer = getParameter(PARAM_PROXY_DVM_VERSION);
                dvm.setDisplayName(getParameter(PARAM_PROXY_DVM_TYPE) + "_" + getParameter(PARAM_PROXYED_IP_ADDRESS));
            }

            if (DvmUtil.setDvmResourcePathAndVersion(fApplication, dvm, type, nodeVer)) {
                ResourceManager rm = new ResourceManager(dvm.getResourcePath(), fApplication, getLocale());
                dvm.setResourceManager(rm);
                dvm.setGuiComposer(new GuiComposer(fApplication, rm));
                if (fDeviceManagerMap != null)
                fDeviceManagerMap.put(moName, dvm);
            } else {
                fLogger.error("Can't find configuration file for " + moName);
            }
            if (isProxyDVM()) {
                dvm.setReadCommunity(getParameter(PARAM_READ_COMMUNITY));
                dvm.setWriteCommunity(getParameter(PARAM_WRITE_COMMUNITY));
            } else {
                dvm.setReadCommunity(mo.getProperties().getProperty("community"));
                dvm.setWriteCommunity(mo.getProperties().getProperty("writeCommunity"));
            }

            //dvm.setSnmpVersion(DvmUtil.convertSnmpVersion(mo.getProperties().getProperty("snmpVersion")));
            //dvm.setTargetPort(Integer.parseInt(mo.getProperties().getProperty("snmpPort")));

            OperationObject oo = new OperationObject();

            String label = getParameter("DisplayName");
            if (label != null) {
                oo.setManagedObject(label);
            } else {
                oo.setManagedObject(mo.getDisplayName());
            }

            dvm.setOperationObject(oo);

            dvm.setProperties(mo.getProperties());
        }

        // set device manager list to application
        if (fDeviceManagerMap != null) {
            IDeviceManager[] dvmList = new IDeviceManager[fDeviceManagerMap.size()];
            fDeviceManagerMap.values().toArray(dvmList);
            fApplication.setDeviceManagerList(dvmList);
        } else {
            fApplication.setDeviceManagerList(null);
        }
    }

    public void setProxyDVM(boolean b) {
        bProxyDVM = b;
    }

    public boolean isProxyDVM() {
        return bProxyDVM;
    }

    private Collection parseMoList() {
        Collection moList = new ArrayList();

        String paramMo = getParameter(PARAM_MO_NAME_LIST);
        if (paramMo != null) {
            StringTokenizer st = new StringTokenizer(paramMo, ",");
            while (st.hasMoreTokens()) {
                moList.add(st.nextToken());
            }
        }

        return moList;
    }

    public void stop() {
        super.stop();
    }

    public void destroy() {
        super.destroy();

        initialized = false;
        if (fFunctionTreeMap != null)
        fFunctionTreeMap.clear();

        // clear resources used by device manager
        if (fDeviceManagerMap != null) {
        int dvmCount = fDeviceManagerMap.size();
        for (int i = 0; i < dvmCount; i++) {
            IDeviceManager dvm = (IDeviceManager) fDeviceManagerMap.getValue(i);
            ((GuiComposer) dvm.getGuiComposer()).destroy();
        }
        fDeviceManagerMap.clear();
        }

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

        if (isProxyDVM()) {
            openedAppletMap.remove(mappedKey);
        }
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

        String language = getParameter(PARAM_LANGUAGE);
        String country = getParameter(PARAM_COUNTRY);
        try {
            result = new Locale(language, country);
        } catch (Exception ex) {
            result = super.getLocale();
        }

        return result;
    }

    public String getParameter(String name) {
        return (fParameterMap != null ? fParameterMap.getProperty(name) : null);
        /*if (isStandAlone() || isProxyDVM()) {
            return fParameterMap.getProperty(name);
        } else {
            String value = super.getParameter(name);

            if (value == null) {
                value = fParameterMap.getProperty(name);
            }

            System.out.println("Get the value of " + name + ": " + value);

            return value;
        }*/
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
            return new URL("http://" + getParameter(PARAM_FE_IP) + ":" + getParameter(PARAM_WEB_PORT));
        } catch (Exception ex) {
            fLogger.error("Document base is invalid");
            return null;
        }
    }

    public URL getCodeBase() {
        try {
            return new URL("http://" + getParameter(PARAM_FE_IP) + ":" + getParameter(PARAM_WEB_PORT) + "/classes");
        } catch (Exception ex) {
            fLogger.error("Document base is invalid");
            return null;
        }
    }

    /**
     * The main entry when running is stand alone mode
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        MainApplet applet = new MainApplet(true);
        applet.setParameterMap(parseArguments(args));
        JFrame frame = (JFrame) applet.getTopMostFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applet.init();
        applet.start();
        frame.setVisible(true);
        applet.launch();
    }

    private static Map openedAppletMap = new HashMap();
    private Object mappedKey;

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
    public static void openManagedDVM(boolean bStandAlone, Properties newDVMPara, ISnmpParameter snmpParameter, String title) {
        MainApplet applet = null;
        applet = (MainApplet) openedAppletMap.get(title);
        if (applet == null) {
            applet = new MainApplet(bStandAlone, false);
            applet.setParameterMap(newDVMPara);
            applet.setSnmpParameter(snmpParameter);
            JFrame frame = (JFrame) applet.getTopMostFrame();
            frame.setTitle(title);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            applet.init();
            applet.start();
            openedAppletMap.put(title, applet);
            frame.setVisible(true);
            applet.launch();
        } else {
            applet.getTopMostFrame().setVisible(true);
            applet.initFocus();
        }
        applet.setMappedKey(title);
    }


    private void setMappedKey(Object key) {
        mappedKey = key;
    }

    private void registerKeyStroke() {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "cancel.search");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('F', InputEvent.CTRL_MASK), "search");
        getRootPane().getActionMap().put("search", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                if( searchflow.isVisible()) {
                    closeSearchWidget();
                } else {
                    openSearchWidget();
                }

            }
        });
        getRootPane().getActionMap().put("cancel.search", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                closeSearchWidget();
            }
        });
        searchflow.setVisible(false);
    }

    private void closeSearchWidget() {
        searchflow.setVisible(false);
        searchflow.getParent().validate();
        fApplication.getActiveDeviceManager().getGuiComposer().stopSearch();
    }

    private void openSearchWidget() {
        searchflow.setVisible(true);
        searchflow.getParent().validate();
        tfSearch.setText("");
        tfSearch.requestFocus();
    }

    public void initFocus() {

        registerKeyStroke();

        if (fRightArea != null) {
            fRightArea.requestFocus();
        }

    }

    private static Properties parseArguments(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No argument passed to main method");
        }

        Properties paramList = new Properties();
        try {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                StringTokenizer st = new StringTokenizer(arg, "=");
                paramList.put(st.nextToken(), st.nextToken());
            }
        } catch (Exception ex) {
            showUsage();
        }

        return paramList;
    }

    private static void showUsage() {
        System.out.println("Usage: java MainApplet " + "param1=value1 param2=value2 ...");
    }

}