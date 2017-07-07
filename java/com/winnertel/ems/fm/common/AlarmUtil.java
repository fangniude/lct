package com.winnertel.ems.fm.common;

import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.inms.topodb.UWrapperOfTopoAPI;
import com.winnertel.nms.lite.momodel.ManagedElement;
import com.winnertel.nms.lite.topo.TopoAPI;
import com.winnertel.nms.lite.util.APIUtil;
import com.winnertel.nms.topodb.ULManagedObject;

import java.awt.*;
import java.util.Properties;

public class AlarmUtil implements ConstantVar {
    private static Color criticalColor;
    private static Color majorColor;
    private static Color minorColor;
    private static Color warningColor;
    private static Color clearColor = null;
    private static Color unknownColor = null;

    static {
        try {
            criticalColor = getColor(CRITICAL);
            majorColor = getColor(MAJOR);
            minorColor = getColor(MINOR);
            warningColor = getColor(WARNING);

//            UFaultAPI faultapi = (UFaultAPI) EmsClientUtil.getAPI("UFaultAPI");
//            Hashtable neTable = faultapi.getAllTroubleShoots();
//            Hashtable redefineTable = (Hashtable) neTable.get("IP-DSLAM");
//            if (redefineTable != null) {
//                Enumeration keys = redefineTable.keys();
//                while (keys.hasMoreElements()) {
//                    String key = (String) keys.nextElement();
//                    com.utstar.ems.fm.TroubleShoot ts = (com.utstar.ems.fm.TroubleShoot) redefineTable.get(key);
//                    if (ts != null && ts.isSeverityRedefined()) {
//                        int severity = ts.getRefSeverity();
//                        int ipdslamSeverity = IPDslamTrapConstant.IPUNKNOW;
//                        switch (severity) {
//                        case WARNING:
//                            ipdslamSeverity = IPDslamTrapConstant.IPWARNING;
//                            break;
//                        case MINOR:
//                            ipdslamSeverity = IPDslamTrapConstant.IPMINOR;
//                            break;
//                        case MAJOR:
//                            ipdslamSeverity = IPDslamTrapConstant.IPMAJOR;
//                            break;
//                        case CRITICAL:
//                            ipdslamSeverity = IPDslamTrapConstant.IPCRITICAL;
//                            break;
//                        case CLEAR:
//                            ipdslamSeverity = IPDslamTrapConstant.IPCLEAR;
//                            break;
//                        default:
//                            ipdslamSeverity = IPDslamTrapConstant.IPUNKNOW;
//                            break;
//                        }
//                        SeverityRedefineWrapper.updateSeverity(key, ipdslamSeverity);
//                    }
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AlarmUtil() {
    }

    /**
     * Function to init the util
     */
    static public void init() {

    }

    /**
     * Function to refresh the color
     */
    static public void refreshColor() {
        try {
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to get the severity string
     * 
     * @return String severity string
     */

    static public String getStringSeverity(int severity) {
        switch (severity) {
        case CRITICAL:
            return "Critical";
        case MAJOR:
            return "Major";
        case MINOR:
            return "Minor";
        case WARNING:
            return "Warning";
        case CLEAR:
            return "Clear";
        default:
            return "Unknow";
        }
    }

    /**
     * Function to return the severity color
     * 
     * @return Color
     */

    static public Color getColor(int severity) {
        switch (severity) {
        case NO_RESPONSE:
            if (criticalColor == null)
                return new Color(255, 0, 0);
            else
                return criticalColor;
        case CRITICAL:
            if (criticalColor == null)
                return new Color(255, 0, 0);
            else
                return criticalColor;
        case MAJOR:
            if (majorColor == null)
                return new Color(255, 200, 0);
            else
                return majorColor;
        case MINOR:
            if (minorColor == null)
                return new Color(255, 255, 0);
            else
                return minorColor;
        case WARNING:
            if (warningColor == null)
                return new Color(0, 255, 255);
            else
                return warningColor;
        case CLEAR:
            if (clearColor == null)
                return new Color(51, 255, 51);
            else
                return clearColor;
        case UNKNOWN:
            if (unknownColor == null)
                return new Color(200, 200, 200);
            else
                return unknownColor;
        default:
            return null;
        }
    }

    /**
     * Convert severity string to severity level
     * 
     */
    static public int getIntSeverity(String severity) {
        if (severity.equalsIgnoreCase("Critical"))
            return CRITICAL;
        if (severity.equalsIgnoreCase("Major"))
            return MAJOR;
        if (severity.equalsIgnoreCase("Minor"))
            return MINOR;
        if (severity.equalsIgnoreCase("Warning"))
            return WARNING;
        if (severity.equalsIgnoreCase("Clear"))
            return CLEAR;
        return UNKNOW;
    }

    /**
     * GetNodeAddress from moName
     * 
     * @param nodeName
     *            String
     * @return String
     */
    public static String getNodeAddress(String nodeName) {
        String nodeAddr = null;
        try {
            ULManagedObject moInstance = getTopAPI().getByName(nodeName);
            if (moInstance != null) {
                Properties prop = moInstance.getProperties();
                nodeAddr = prop.getProperty("nodeAddr");
                if (nodeAddr == null) {
                    nodeAddr = prop.getProperty("ipAddress");
                }
            } else {
                // if not an ULManagedObject, such as B1205
                TopoAPI topoAPI = APIUtil.getTopoAPI();
                ManagedElement node = topoAPI.getMEByMoName(nodeName);
                if (node != null) {
                    nodeAddr = node.getIpAddress();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodeAddr;
    }

    public static UWrapperOfTopoAPI getTopAPI() {
        // if(GlobalFlags.IS_SERVER_SIDE){
        //
        // }

        return UTopoAPI.getAPI();

        // try {
        // if (UTopAPI == null)
        // return
        // (UTWrapperOfTopoAPI)HZUTNmsClientUtil.getBEAPI(UTWrapperOfTopoAPI.API_NAME);
        // else
        // return UTopAPI;
        // }
        // catch(Exception e){
        // e.printStackTrace();
        // return null;
        // }
    }
}
