package com.winnertel.em.standard.device;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.em.standard.resource.DocumentLoader;
import org.jdom.Element;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DvmUtil {
    private static final ILogger fgLogger = LoggerController.createLogger(DvmUtil.class);

    private static final String DVM_PACKAGE = "com/winnertel/em/standard/resource/dvm/";


    /**
     * Updated by Rex due to MR raised from field.
     * <p/>
     * In R3.1.0 patch policy, we have emspatch.jar which has higher priority than classes,
     * but once the  DVM_PACKAGE was included in the file, the NMS will have no way to get
     * the others under classes/DVM_PACKAGE/, so we need to improve it according to our patch
     * policy.
     *
     * @return
     */
    public static Map getDeviceManagerMap() {
        Map dvmMap = new HashMap();
        try {
            loadMapping(DVM_PACKAGE, dvmMap);
            loadMapping("classes/" + DVM_PACKAGE, dvmMap);
        } catch (Exception ex) {
            fgLogger.error("Error in get device manager map", ex);
        }

        return dvmMap;
    }

    private static void loadMapping(String aName, Map dvmMap) throws Exception {
        InputStream is = getResourceAsStream(aName);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String entry = null;
            while ((entry = br.readLine()) != null) {
                if (entry.endsWith(".xml")) {
                    Element eProduct = DocumentLoader.buildDocument(getUrl(aName + entry));
                    if (eProduct != null) {
                        String name = eProduct.getAttributeValue("name");
                        String path = eProduct.getAttributeValue("path");
                        if (dvmMap.containsKey(name)) {
                            continue;
                        }
                        dvmMap.put(name, path);
                    }
                }
            }
        }
    }


    public static Map getDeviceManagerVersionInfo(String aProductName) {
        Map dvmMap = new HashMap();
        try {
            URL fileUrl = getUrl(DVM_PACKAGE + aProductName + ".xml");
            Element eProduct = DocumentLoader.buildDocument(fileUrl);
            if (eProduct != null) {
                String productPath = eProduct.getAttributeValue("path");
                List eDvmList = eProduct.getChildren("DeviceManager");
                if (eDvmList != null) {
                    int versionCount = eDvmList.size();
                    for (int i = 0; i < versionCount; i++) {
                        Element eDvm = (Element) eDvmList.get(i);
                        dvmMap.put(eDvm.getAttributeValue("version"),
                                productPath + eDvm.getAttributeValue("path"));
                    }
                }
            }
        } catch (Exception ex) {
            fgLogger.error("Error in get device manager map", ex);
        }

        return dvmMap;
    }


    public static boolean setDvmResourcePathAndVersion(IApplication anApp, IDeviceManager aDvm,
                                                       String aType, String aNodeVer) {
        // find a device manager that product name matches with aType
        // and system version matches aNodeVer
        String fileName = DVM_PACKAGE + aType + ".xml";
        URL url = getUrl(fileName);
        if (url == null) {
            return false;
        }

        Element eProduct = DocumentLoader.buildDocument(url);
        if (eProduct == null) {
            return false;
        }

        aNodeVer = setDefaultNodeVersion(aNodeVer);
        fgLogger.debug("Node version of " + aDvm.getName() + " is " + aNodeVer);

        String productName = eProduct.getAttributeValue("name");
        String productPath = eProduct.getAttributeValue("path");
        Element eDvm = null;
        if (productName.equals(aType)) {
            List eDvmList = eProduct.getChildren("DeviceManager");
            Iterator itDvm = eDvmList.iterator();
            boolean found = false;
            List eVerList = null;
            Iterator itVer = null;
            while (itDvm.hasNext() && !found) {
                eDvm = (Element) itDvm.next();
                eVerList = eDvm.getChild("VersionInfo").getChildren("Version");
                itVer = eVerList.iterator();
                while (itVer.hasNext() && !found) {
                    Element eVersion = (Element) itVer.next();
                    if ("System".equals(eVersion.getAttributeValue("key"))) {
                        String s = eVersion.getAttributeValue("value");
                        //The node version is supported.
                        if (compareVersion(s, aNodeVer)) {
                            found = true;
                            break;
                        }
                    }
                } // while (itVer.hasNext())
            } // while (itDvm.hasNext())

            if (found) {
//                aDvm.setVersion(eDvm.getAttributeValue("version"));
                aDvm.setVersion(aNodeVer);
                aDvm.setResourcePath(productPath + eDvm.getAttributeValue("path"));
                // set version info
                itVer = eVerList.iterator();
                Properties props = new Properties();
                while (itVer.hasNext()) {
                    Element eVersion = (Element) itVer.next();
                    props.setProperty(eVersion.getAttributeValue("key"),
                            eVersion.getAttributeValue("value"));
                }
                aDvm.setVersionInfo(props);

                Element eCommunitySelector = eProduct.getChild("CommunitySelector");
                if (eCommunitySelector != null) {
                    String commSelector = eCommunitySelector.getAttributeValue("class");
                    aDvm.setCommunitySelector(InstanceCreator.instantiateBaseAction(anApp, commSelector));
                }

                Element eStartupTask = eDvm.getChild("StartupTask");
                if (eStartupTask != null) {
                    String startupTask = eStartupTask.getAttributeValue("class");
                    aDvm.setStartupTask(InstanceCreator.instantiateTask(startupTask, anApp, aDvm));
                }

                Element eShutdownTask = eDvm.getChild("ShutdownTask");
                if (eShutdownTask != null) {
                    String shutdownTask = eShutdownTask.getAttributeValue("class");
                    aDvm.setShutdownTask(InstanceCreator.instantiateTask(shutdownTask, anApp, aDvm));
                }

                Element eGuiStyle = eDvm.getChild("GuiStyle");
                if (eGuiStyle != null) {
                    String guiStyle = eGuiStyle.getAttributeValue("style");
                    if ("embedded".equals(guiStyle)) {
                        anApp.setGUIStyle(IApplication.EMBEDDED_STYLE);
                    }
                }

                // set image
                // TODO: put the image path to config file
                String imageName = DVM_PACKAGE + aType + ".png";
                URL imageUrl = getUrl(imageName);
                if (imageUrl != null) {
                    aDvm.setImage(new ImageIcon(imageUrl));
                }
                return true;
            }
        } // if (productName.equals(aType))

        return false;
    }

    protected static boolean compareVersion(String version, String neVersion) {
        if (version == null || version.equals("*")) {
            return true;
        } else {
            version = version.replace(',', ';');

            StringTokenizer st1 = new StringTokenizer(version, ";");
            while (st1.hasMoreTokens()) {
                String ver = st1.nextToken();

                if (ver.indexOf("-") != -1) {
                    StringTokenizer st = new StringTokenizer(ver, "-");
                    String minVer = st.nextToken();
                    String maxVer = st.nextToken();
                    if (compare(neVersion, minVer) >= 0 && compare(neVersion, maxVer) <= 0) {
                        return true;
                    }
                } else {
                    if (neVersion.equals(ver)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected static int compare(String s1, String s2) {
        if (s1 == null && s2 == null) return 0;

        if (s1 == null && s2 != null) return -1;

        if (s1 != null && s2 == null) return 1;

        StringTokenizer st1 = new StringTokenizer(s1, ".");
        StringTokenizer st2 = new StringTokenizer(s2, ".");
        if (st1.countTokens() == st2.countTokens()) {
            while (st2.hasMoreTokens()) {
                int ret = compare(st1.nextToken().toCharArray(), st2.nextToken().toCharArray());

                if (ret != 0) return ret;
            }

            return 0;
        } else if (st1.countTokens() >= st2.countTokens()) {
            while (st2.hasMoreTokens()) {
                int ret = compare(st1.nextToken().toCharArray(), st2.nextToken().toCharArray());

                if (ret != 0) return ret;
            }

            return 1;
        } else {
            while (st1.hasMoreElements()) {
                int ret = compare(st1.nextToken().toCharArray(), st2.nextToken().toCharArray());

                if (ret != 0) return ret;
            }

            return -1;
        }
    }

    protected static int compare(char[] b1, char[] b2) {
        if (b1 == null && b2 == null) return 0;
        if (b1 != null && b2 == null) return 1;
        if (b1 == null && b2 != null) return -1;

        if (b1.length > b2.length) return 1;
        if (b1.length < b2.length) return -1;

        for (int i = 0; i < b1.length; i++) {
            if (b1[i] > b2[i]) return 1;
            if (b1[i] < b2[i]) return -1;
        }

        return 0;
    }

    private static URL getUrl(String aName) {
        return DvmUtil.class.getClassLoader().getResource(aName);
    }

    private static InputStream getResourceAsStream(String aName) {
        return DvmUtil.class.getClassLoader().getResourceAsStream(aName);
    }


    public static int convertSnmpVersion(String aVersion) {
        if ("v2".equals(aVersion) || "v2c".equals(aVersion)) {
            return ISnmpConstant.VERSION2C;
        } else {
            return ISnmpConstant.VERSION1;
        }
    }


    public static String setDefaultNodeVersion(String aNodeVer) {
        // default node version is 1.0.0.0
        if (aNodeVer == null || aNodeVer.length() == 0
                || aNodeVer.equalsIgnoreCase("null")) {
            aNodeVer = "1.0.0.0";
        }

        return aNodeVer;
    }
}
