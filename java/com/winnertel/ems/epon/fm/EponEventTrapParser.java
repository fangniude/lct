package com.winnertel.ems.epon.fm;

import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.ems.fm.FMUtil;
import com.winnertel.ems.fm.eventdb.Event;
import com.winnertel.ems.fm.trap.EventParser;
import com.winnertel.ems.fm.trap.EventParserResource;
import com.winnertel.ems.fm.trap.TrapUtil;
import com.winnertel.ems.fm.trap.helper.SnmpV2CAdaptor;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.alertdb.UEventAPI;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.util.Locale;
import java.util.Properties;

public class EponEventTrapParser implements TrapParser {

//    static EponLogger log = LoggerUtility.getLogger(EponEventTrapParser.class.getName());

    private SnmpV2CAdaptor v2cAdaptor;

    // private EventParserResource parserResource;

    public EponEventTrapParser() {
        FMUtil.setGenerateUnparsedEvent(false);
        v2cAdaptor = new SnmpV2CAdaptor();

        // init event parser resource.
        initParserResource("FBW3000");
        initParserResource("FBW2000");
//        initParserResource("BBS1000+");
        initParserResource("FBW5000");

        System.out.println("init EponEventTrapFilter.");
    }

    protected EventParserResource initParserResource(String neType) {
        String fileName = null;
        if (neType.equalsIgnoreCase("FBW3000") || neType.equalsIgnoreCase("FBW2000") ) {
            fileName = getFileName("bbs1000");
        } else if (neType.equals("FBW5000")) {
            fileName = getFileName("bbs4000");
        }

        EventParserResource parserResource = new EventParserResource(fileName);
        TrapUtil.setEventParserResourceHash(neType, parserResource);

        return parserResource;
    }

    protected String getFileName(String prefix) {
        StringBuffer sb = new StringBuffer("conf/epon/fm/event_epon_").append(prefix.toLowerCase());

        String lang = Locale.getDefault().getLanguage();
        // chinese
        if (lang != null && lang.equalsIgnoreCase("Chinese")) {
            sb.append("_zh.parsers");
        } else {
            sb.append(".parsers");
        }

        return sb.toString();
    }

    protected EventParserResource getEventParserResource(String neType) {
        EventParserResource parserResource = null;

        parserResource = TrapUtil.getEventParserResourceHash(neType);
        if (parserResource == null) {
            parserResource = initParserResource(neType);
        }

        return parserResource;
    }

    public Event parseToEvent(SnmpPDU pdu) {
        return generateEvent(pdu);
    }

    public void parse(SnmpPDU pdu) {
        generateEventAndInsert(pdu);
    }

    public Event generateEvent(SnmpPDU pdu) {
        try {
            pdu = (SnmpPDU) v2cAdaptor.applyTrapFilter(pdu);
        } catch (Exception e) {
            System.err.println("generateEvent(), Exception: " + e.getMessage());
        }

        // utFault trap
        if (".1.3.6.1.4.1.41355.1800.3.2.0".equals(pdu.getEnterprise().getVarObject())) {
            if (pdu.getSpecificType() == 13) { // replace module diag status
                pdu = replaceDiagSttus(pdu, 2);
            }

            // replace IGMP Proxy Status
            if (pdu.getSpecificType() == 402) {
                pdu = replaceIgmpProxySttus(pdu, 5);
            }

            // replace IGMP Proxy Status
            if (pdu.getSpecificType() == 17) {
                pdu = replacePowerSlotNumber(pdu, 2);
                pdu = replacePowerSlotStatus(pdu, 3);
            }

            // trap utsEponOnuBerThresholdEvent or utsEponOnuFerThresholdEvent
            if (pdu.getSpecificType() == 1014 || pdu.getSpecificType() == 1015) {
                pdu = replaceLinkDirection(pdu);
            }

            // trap utsEponUplinkBandwidthBeyondEvent or
            // utsEponOnuUniBandwidthBeyondEvent
            if (pdu.getSpecificType() == 1500 || pdu.getSpecificType() == 1502) {
                pdu = replacePortDirection(pdu);
            }

            // added by Zhou Chao, 2009/3/4 -- begin
            // trap utsEponSNumberNotConfigureEvent
            if (pdu.getSpecificType() == 1508) {
                pdu = replaceMacAddress(pdu, 4);
                pdu = replaceONUSNumber(pdu, 5);
            }

            // trap utsEponSNumberNotMatchEvent
            if (pdu.getSpecificType() == 1510) {
                pdu = replaceMacAddress(pdu, 5);
                pdu = replaceONUSNumber(pdu, 6);
                pdu = replaceONUSNumber(pdu, 7);
            }

            // trap utsEponSNumberDuplicateEvent
            if (pdu.getSpecificType() == 1512) {
                pdu = replaceMacAddress(pdu, 5);
                pdu = replaceONUSNumber(pdu, 6);
            }
            // added by Zhou Chao, 2009/3/4 -- end
        }

        // onu2024 trap
//        if (".1.3.6.1.4.1.41355.1.3.10.100.2.2.1.0".equals(pdu.getEnterprise().getVarObject())) {
//            // trap swIpFilterRejectTrap
//            if (pdu.getSpecificType() == 40) {
//                pdu = replaceIpFilterRejectAttr(pdu);
//            }
//
//            // trap swPowerStatusChangeTrap
//            if (pdu.getSpecificType() == 1) {
//                pdu = replacePowerStatusChangeAttr(pdu);
//            }
//
//            // trap PSE counsumption power
//            if (pdu.getSpecificType() == 45 || pdu.getSpecificType() == 46) {
//                pdu = replacePseCounsumptionPowerAttr(pdu);
//            }
//
//            // trap pethPsePortOnOffNotification
//            if (pdu.getSpecificType() == 43) {
//                pdu = replacePsePortOnOffNotificationAttr(pdu);
//            }
//        }

        try {
            // generate event
            Event evt = createEvent(pdu);
            if (evt != null) {
                Event temp = filterEvent(evt);
                if (temp != null) {
                    // EventAPI.addEvent(temp);
                    return temp;
                }
            }
        } catch (Exception e) {
            System.err.println("exception in generateEvent(), " + e.getMessage());
        }

        return null;
    }

    /**
     * Call back of trap filter
     * 
     * @param pdu
     */
    public void generateEventAndInsert(SnmpPDU pdu) {
        Event event = generateEvent(pdu);
        if (event != null) {
            UEventAPI.addEvent(event);
        }
    }

    Event createEvent(SnmpPDU snmppdu) {
        System.out.println("createEvent(), start");
        String neName = null;
        String neType = null;
        try {
            String ip = snmppdu.getAgentAddr();
            Properties prop = UTopoAPI.getAPI().getNodeProperties( UTopoAPI.getAPI().getNodeNameByIP( ip ) );
//            Properties prop = ServerUtility.getNePropertiesByIpAddr(ip);

            if (prop == null) {
                neName = ip;
                neType = "BBS1000";
            } else {
                neName = prop.getProperty("name", ip);
                neType = prop.getProperty("neType", "BBS1000");
            }

            System.out.println("IP=" + ip + "; moName=" + neName + "; Type=" + neType);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }

        EventParserResource parserResource = getEventParserResource(neType);
        if (parserResource == null) {
            System.err.println("The corresponding EventParserResource is null, ignore this PDU.");
            return null;
        }

        EventParser EventParser = null;
        String s = null;
        if (snmppdu.getVersion() == 2 || snmppdu.getVersion() == 1) {
            try {
                String s1 = snmppdu.getVariableBinding(1).getVariable().toString();
                String s3 = s1.substring(s1.lastIndexOf(".") + 1, s1.length());
                if (s3.equals("0")) {
                    s = s1.substring(0, s1.lastIndexOf("."));
                } else {
                    s = s1;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.err.println("TrapOID parsing error, " + exception.getMessage());
                s = null;
            }
            if (s == null) {
                System.err.println("Trap OID is null, can not get the parser.");
                return null;
            }
            EventParser = parserResource.getParser(s, true);
        } else {
            String s2 = snmppdu.getEnterprise().toString();
            String s4 = snmppdu.getSpecificType() + "";
            int i = snmppdu.getTrapType();
            if (i < 6) {
                EventParser = parserResource.getParser(i + "", false);
            } else {
                EventParser = parserResource.getParser(s2, s4);
            }
        }

        if (EventParser == null) {
            System.err.println("No corresponding parser for this PDU, ignore it.");
            return null;
        }

        long t1 = System.currentTimeMillis();
        Event Event = new Event();
        Event.setCreateTime(System.currentTimeMillis());
        Event = EventParser.parseTrap(Event, snmppdu);
        long t2 = System.currentTimeMillis();
        System.out.println("timed used in creating event: time(ms) = " + (t2 - t1) + ", eventId = " + Event.getEventId());

        return Event;
    }

    protected SnmpPDU replaceDiagSttus(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = "pass";
            } else if (var.equals("2")) {
                var = "fail";
            } else if (var.equals("3")) {
                var = "dead";
            } else if (var.equals("4")) {
                var = "nonpresent";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace the diagnose Status: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replaceIgmpProxySttus(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = "leave";
            } else if (var.equals("2")) {
                var = "query";
            } else if (var.equals("3")) {
                var = "query-to";
            } else if (var.equals("4")) {
                var = "listener";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace the IGMP Proxy Status: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePowerSlotStatus(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();
            if (var.equals("0")) {
                var = "empty";
            } else if (var.equals("1")) {
                var = "installed-not-work";
            } else if (var.equals("2")) {
                var = "install-and-work";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace Power Slot Status: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePowerSlotNumber(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = "low slot";
            } else if (var.equals("2")) {
                var = "upper slot";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace the Power Slot Number: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replaceIpFilterRejectAttr(SnmpPDU pdu) {
        try {
            // replace trapIpFilterRejectIp
            SnmpVarBind varbind = pdu.getVariableBinding(3);
            String var = varbind.getVariable().toString();
            var = ConfigUtility.transIntToIP(Integer.parseInt(var));
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.IPADDRESS);
            pdu.setVariable(3, test);
            // replace trapIpFilterRejectMode
            varbind = pdu.getVariableBinding(2);
            var = varbind.getVariable().toString();
            int mode = Integer.parseInt(var);
            if (mode == 1) {
                var = "web";
            } else if (mode == 2) {
                var = "snmp";
            } else {
                var = "telnet";
            }
            test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(2, test);
        } catch (Exception err) {
            System.err.println("Can't replace IP Filter Reject Attributes: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePowerStatusChangeAttr(SnmpPDU pdu) {
        try {
            // replace swIndivPowerIndex
            SnmpVarBind varbind = pdu.getVariableBinding(3);
            String var = varbind.getVariable().toString();
            int index = Integer.parseInt(var);
            if (index == 1) {
                var = "internalPower";
            } else {
                var = "externalPower";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(3, test);
            // replace swIndivPowerStatus
            varbind = pdu.getVariableBinding(4);
            var = varbind.getVariable().toString();
            int statu = Integer.parseInt(var);
            if (statu == 1) {
                var = "notPresent";
            } else if (statu == 2) {
                var = "green";
            } else {
                var = "red";
            }
            test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(4, test);
        } catch (Exception err) {
            System.err.println("Can't replace Power Status Change Attributes: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePseCounsumptionPowerAttr(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(2);
            String var = varbind.getVariable().toString();
            var = var + " Watts";
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(2, test);
        } catch (Exception err) {
            System.err.println("Can't replace Pse Counsumption Power Attributes: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePsePortOnOffNotificationAttr(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(2);
            String var = varbind.getVariable().toString();
            int status = Integer.parseInt(var);
            // replace pethPsePortDetectionStatus
            if (status == 1) {
                var = "disabled";
            } else if (status == 2) {
                var = "searching";
            } else if (status == 3) {
                var = "deliveringPower";
            } else if (status == 4) {
                var = "fault";
            } else if (status == 5) {
                var = "test";
            } else {
                var = "otherFault";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(2, test);
        } catch (Exception err) {
            System.err.println("Can't replace Pse Port On/Off Notification Attributes: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replaceLinkDirection(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(5);
            String var = varbind.getVariable().toString();
            int direction = Integer.parseInt(var);
            // replace pethPsePortDetectionStatus
            if (direction == 1) {
                var = "UpStream";
            } else if (direction == 2) {
                var = "DownStream";
            } else {
                var = "Unknown";
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(5, test);
        } catch (Exception err) {
            System.err.println("Can't replace Link Direction Attributes: " + err.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replacePortDirection(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(4);
            String var = varbind.getVariable().toString();
            int direction = Integer.parseInt(var);
            // replace pethPsePortDetectionStatus
            if (direction == 1) {
                var = "Ingress";
            } else if (direction == 2) {
                var = "Egress";
            }

            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(4, test);
        } catch (Exception err) {
            System.err.println("Can't replace Link Direction Attributes: " + err.getMessage());
        }

        return pdu;
    }

    // added by Zhou Chao, 2009/3/4
    protected SnmpPDU replaceMacAddress(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();

            if (var.indexOf("-") >= 0)
                return pdu;

            var = toMac(var);
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace the MacAddress: " + err.getMessage());
        }

        return pdu;
    }

    public static String toMac(String s) {
        StringBuffer sb = new StringBuffer();

        if (s != null) {
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length; j++) {
                int n = (int) c[j];
                String str = Integer.toHexString(n).toUpperCase();
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str).append("-");
            }

            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    // added by Zhou Chao, 2009/3/4
    protected SnmpPDU replaceONUSNumber(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();
            byte[] value = null;
            byte[] user = null;
            byte[] pass = null;
            value = var.getBytes();

            int n = 0, j = 0, k = 0;

            // extract username
            for (n = j; n < value.length; n++) { // 0~15
                if (value[n] == 0) {
                    k = n;
                    break;
                }
            }
            // check username
            if (j == k && j == 0) {
                var = "null/null";
                SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
                pdu.setVariable(i, test);

                return pdu; // if the username is invalid then return
                            // immediately
            }
            // set username
            user = new byte[k - j];
            for (n = 0; n < (k - j); n++)
                user[n] = value[n + j];

            // trim '0x00'
            for (n = k; n < value.length; n++) {
                if (value[n] != 0) {
                    j = n;
                    break;
                }
            }

            // extract password
            for (n = j; n < value.length; n++) { // 16~31
                if (value[n] == 0) {
                    k = n;
                    break;
                }
            }
            // check password
            if (j == k) {
                var = new String(user) + "/null";
            } else {
                // set password
                pass = new byte[k - j];
                for (n = 0; n < (k - j); n++)
                    pass[n] = value[n + j];
                var = new String(user) + "/" + new String(pass);
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.err.println("Can't replace the ONUSNumber: " + err.getMessage());
        }

        return pdu;
    }

    protected Event filterEvent(Event evt) {
        String ip = evt.getSource();
        Properties prop = null;
        try {
            prop = UTopoAPI.getAPI().getNodeProperties(UTopoAPI.getAPI().getNodeNameByIP(ip));
//            prop = ServerUtility.getNePropertiesByIpAddr(ip);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        String moName = null;
        String moType = null;

        if (prop == null) {
            System.err.println("received pdu from unmanged NE :" + ip);
            return null;
        } else {
            moName = prop.getProperty("name", ip);
            moType = prop.getProperty("neType", "BBS1000");
        }

        System.out.println("NE IP=" + ip + "; moName=" + moName + "; Ne Type=" + moType);

        if (moName != null) {
            evt.setNeId(moName);
            evt.setNeName(moName);
            String source = moName + "_" + evt.getEntityType() + "_" + evt.getEntityInstance();
            evt.setSource(source);
        }
        if (moType != null) {
            evt.setNeType(moType);
        }

        return evt;
    }

    public String toString() {
        return "EponEventTrapParser";
    }

}