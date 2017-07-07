package com.winnertel.ems.lct;

import com.winnertel.nms.app.AppContext;
import com.winnertel.nms.helpsys.HelpUtilityHolder;
import com.winnertel.nms.helpsys.HelpresFileBuilderUtil;
import com.winnertel.nms.lite.logger.LoggerFactoryWrapper;
import com.winnertel.nms.util.UIStyleSetting;
import com.winnertel.platform.common.thread.ExecutorFactory;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

public class LctMain {

    //TODO: need configuration here
    public static Object[] getSupportedTypes() {
        return new String[]{"FBW2000"};
    }

    public static boolean isSupportedNode(LctNode node) {
        return true;
    }

    private static void initLocale() {
        try {
            SAXBuilder saxBuilder = new SAXBuilder(false);
            Document doc = saxBuilder.build( new FileInputStream( System.getProperty("user.dir") + "/conf/LiteReleaseInfo.xml" ));
            org.jdom.Element root = doc.getRootElement();

            //Read <Server>
            org.jdom.Element serverEle = root.getChild("Server");
            String language = serverEle.getChild("Language").getTextTrim();
            String country = serverEle.getChild("Country").getTextTrim();

            Locale.setDefault(new Locale(language, country));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JDOMException jdomex) {
            jdomex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static ResourceBundle res = null;

    public static String getString(String key) {
        try {
            if (res == null) {
                res = ResourceBundle.getBundle("com.winnertel.ems.lct.Res", Locale.getDefault());
            }
            return res.getString(key);
        } catch (Exception ex) {
            return key;
        }
    }



    public static void main(String[] args) {
        if( !AppContext.getContext().initialApp( args ) ) {
            System.exit(1);
        }
        try {
            File logDir = new File("logs");
            if( !logDir.exists() ) {
                logDir.mkdirs();
            }

            LoggerFactoryWrapper.rootDir = System.getProperty("user.dir") + "/";
            try {
                System.setErr(new PrintStream(new File("logs/stderr_lct.txt")));
                System.setOut(new PrintStream(new File("logs/stdout_lct.txt")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            initLocale();

            initOnlineHelp();

            initTimeHitter();

            startIdleChecker();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        UIStyleSetting.setStyle();
        LctLogin.show();

    }

    private static void initOnlineHelp() {
        ExecutorFactory.getInstance().createSingleExecutor("LctMain-initHelp").execute(new Runnable() {

                                                                                           @Override
                                                                                           public void run() {
                                                                                               String title = "Help";
                                                                                               String helpHome = "file:////" + System.getProperty("user.dir");
                                                                                               String helplang = "";
                                                                                               if (Locale.CHINA.equals(Locale.getDefault())) {
                                                                                                   helplang = "chinese";
                                                                                               } else {
                                                                                                   helplang = "english";
                                                                                               }
                                                                                               HelpresFileBuilderUtil.getInstance(helplang, System.getProperty("user.dir") + "/");
                                                                                               HelpUtilityHolder.init(helpHome, title, helplang);
                                                                                           }
                                                                                       }
        );
    }

    public static JFrame openDvm(LctNode node, JFrame parentFrame) {
        latestHitTime = 0;

        String nodeVersion = node.getNodeVersion();
        String deviceType = node.getNodeType();
        ILctLaunch aDvmFrame = null;
        String dvmFrameClass = NodeTypes.lookup(deviceType, nodeVersion);
        if (dvmFrameClass == null) {
            System.err.println("---Critical--- No such device configuration found!");
        }


        LctNeContext uiInfo = new LctNeContext(node);
        System.out.println("[DEBUG]-" + deviceType + "," + nodeVersion + "=" + dvmFrameClass);
        Object tFrame = null;
        try {
            tFrame = Class.forName(dvmFrameClass).newInstance();
            if (tFrame instanceof ILctLaunch) {
                aDvmFrame = (ILctLaunch) tFrame;
//                aDvmFrame.setParentFrame(parentFrame);
            } else {
                throw new Exception("Not a ILctLaunch instance...");
            }
        } catch (Exception e) {
            System.err.println("[LctMain.openDvm()]---Critical--- No avaliable device manager implementing found!");
            System.err.println(String.format("DeviceType=%s; NodeVersion=%s; dvmFrameClass=%s", new String[] {deviceType, nodeVersion, dvmFrameClass}) );
            e.printStackTrace();
        }

        if (aDvmFrame == null) {
            JOptionPane.showMessageDialog(null, getString("Support_Fail"));
            return null;
        }
        aDvmFrame.initLctContext(uiInfo);

        fCurrentActiveFrame = new LctFrame();
        aDvmFrame.setParentFrame(fCurrentActiveFrame);
        fCurrentActiveFrame.setLctComponent(aDvmFrame.getUI());
        fCurrentActiveFrame.setLctNode(node);


        showDvmAsDefault(fCurrentActiveFrame);
        latestHitTime = System.currentTimeMillis();
        fCurrentActiveFrame.setVisible(true);
        return fCurrentActiveFrame;
    }

    private static LctFrame fCurrentActiveFrame;

    public static LctNode getNodeByIp(String ipAddr) {
        return (LctNode) LctNodes.get(ipAddr);
    }

    public static boolean registerNode(LctNode node) {
        LctNodes.put(node.getNodeAddress(), node);

        return true;
    }

    private static Hashtable LctNodes = new Hashtable();

    private static void showDvmAsDefault(JFrame aFrame) {
        if (aFrame != null) {
            aFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

    private static AWTEventListener timehitterlistener = null;

    private static long SESSION_CHECK_INTERVAL = 1800 * 1000; //30 minutes

    private static long latestHitTime = 0;

    private static void initTimeHitter() {
        if (timehitterlistener == null) {
            timehitterlistener = new AWTEventListener() {
                public synchronized void eventDispatched(AWTEvent event) {
                    latestHitTime = System.currentTimeMillis();
                }
            };
            Toolkit.getDefaultToolkit().addAWTEventListener(timehitterlistener, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
        }
    }

    private static void startIdleChecker() {
        Thread theLockScreenChecker = new Thread() {
            public void run() {
                while (true) {
                    if ((System.currentTimeMillis() - latestHitTime > SESSION_CHECK_INTERVAL)) {
                        if (latestHitTime > 0) { //one device manager opened
                            fCurrentActiveFrame.dispose();
                            latestHitTime = System.currentTimeMillis();
                        } else {
                            try {
                                Thread.sleep(20 * 1000L);
                            } catch (Exception e) {
                            }
                        }
                    } else {
                        try {
                            Thread.sleep(20 * 1000L);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        theLockScreenChecker.start();
    }

    public static long getSessonCheckerInterval() {
        return SESSION_CHECK_INTERVAL;
    }

    public static void setSessonCheckerInterval(long session_check_interval) {
        SESSION_CHECK_INTERVAL = session_check_interval;
    }

    //TODO: need configuration here
    private static class NodeTypes {
        private static String lookup(String type, String version) {
            if ("FBW2000".equalsIgnoreCase(type) && "1.0.0".equalsIgnoreCase(version)) {
                return "com.winnertel.ems.lct.impl.FBW2000LCTApplet";
            }
            return null;
        }

    }
}