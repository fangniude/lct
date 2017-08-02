package com.winnertel.ems.epon.fm;

import com.winnertel.ems.epon.global.ServerResourceManager;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.ems.fm.FMConstant;
import com.winnertel.ems.fm.FMUtil;
import com.winnertel.ems.fm.alarmdb.Alarm;
import com.winnertel.ems.fm.trap.AlarmParser;
import com.winnertel.ems.fm.trap.AlarmParserResource;
import com.winnertel.ems.fm.trap.SnmpUtil;
import com.winnertel.ems.fm.trap.TrapUtil;
import com.winnertel.ems.fm.trap.helper.SnmpV2CAdaptor;
import com.winnertel.inms.global.Global;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.nms.alertdb.UEventAPI;
import com.winnertel.snmp.snmp2.DefaultSnmpAPI;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.snmp.snmp2.SnmpVar;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.util.Hashtable;
import java.util.Properties;

public class EponAlarmTrapParser implements TrapParser {

    // protected static String parserFileName =
    protected static final boolean dropUnManagedNEAlarm = true;
    private SnmpV2CAdaptor v2cAdaptor;
    // private AlarmParserResource parserResource;
    private Hashtable probableCauses;

    public EponAlarmTrapParser() {
        FMUtil.setGenerateUnparsedEvent(false);
        v2cAdaptor = new SnmpV2CAdaptor();

        // init alarm parser resource.
        initParserResource("FBW3000");
        initParserResource("FBW2000");
        initParserResource("FBW5000");

        probableCauses = initProbableCause();

    }

    public Alarm parseToAlarm(SnmpPDU pdu) {
        return generateAlarm(pdu);
    }

    public void parse(SnmpPDU pdu) {
        generateAlarmAndInsert(pdu);
    }

    protected AlarmParserResource initParserResource(String neType) {
        String fileName = null;
        if (neType.equalsIgnoreCase("FBW3000") || neType.equalsIgnoreCase("FBW2000")) {
            fileName = getFileName("bbs1000");
        } else if (neType.equals("FBW5000")) {
            fileName = getFileName("bbs4000");
        } 

        AlarmParserResource parserResource = new AlarmParserResource(fileName);
        TrapUtil.setAlarmParserResourceHash(neType, parserResource);

        return parserResource;
    }

    protected String getFileName(String prefix) {
        StringBuffer sb = new StringBuffer("conf/epon/fm/alarm_epon_").append(prefix.toLowerCase());

        String lang = Global.getInstance().getLanguage();
        // chinese
        if (lang != null && lang.equalsIgnoreCase("Chinese")) {
            sb.append("_zh.parsers");
        } else {
            sb.append(".parsers");
        }

        return sb.toString();
    }

    protected AlarmParserResource getAlarmParserResource(String neType) {
        AlarmParserResource parserResource = null;

        parserResource = (AlarmParserResource) TrapUtil.getAlarmParserResourceHash(neType);
        if (parserResource == null) {
            parserResource = initParserResource(neType);
        }

        return parserResource;
    }

    void generateAlarmAndInsert(SnmpPDU pdu) {
        Alarm alarm = generateAlarm(pdu);
        if (alarm != null) {
            UEventAPI.addAlarm(alarm);
        }
    }

    /**
     * Generate the alarm according to pdu and add them into system.
     * 
     * @param pdu
     */
    Alarm generateAlarm(SnmpPDU pdu) {
        long t1 = 0, t2 = 0, t3 = 0, t4 = 0;
        t1 = System.currentTimeMillis();
        try {
            pdu = (SnmpPDU) v2cAdaptor.applyTrapFilter(pdu);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // utFault trap
        if (".1.3.6.1.4.1.45121.1800.3.2.0".equals(pdu.getEnterprise().getVarObject())) {
            if (pdu.getSpecificType() == 6 || pdu.getSpecificType() == 7) { // replace
                                                                            // fan
                                                                            // module
                pdu = replaceFanNumber(pdu);
            }

            if (pdu.getSpecificType() == 1002 || pdu.getSpecificType() == 1004 || pdu.getSpecificType() == 1005 || pdu.getSpecificType() == 1007) { // replace
                                                                                                                                                    // link
                                                                                                                                                    // direction
                pdu = replacePonLinkDirection(pdu);
            }

            if (pdu.getSpecificType() == 1016 || pdu.getSpecificType() == 1017) {
                pdu = replaceDosAttackInfo(pdu);
            }

            if (pdu.getSpecificType() == 305) {
//                pdu = replaceOnuId(pdu);
            }

            if (pdu.getSpecificType() == 1035 || pdu.getSpecificType() == 1036) {
                pdu = replaceMacAddress(pdu);
            }

            // trap utsEponSNumberNotConfigureAlarm
            if (pdu.getSpecificType() == 1508) {
                pdu = replaceMacAddress(pdu, 9);
                pdu = replaceONUSNumber(pdu, 10);
            }

            // trap utsEponSNumberNotMatchAlarm
            if (pdu.getSpecificType() == 1510) {
                pdu = replaceMacAddress(pdu, 10);
                pdu = replaceONUSNumber(pdu, 11);
                pdu = replaceONUSNumber(pdu, 12);
            }

            // trap utsEponSNumberDuplicateAlarm
            if (pdu.getSpecificType() == 1512) {
                pdu = replaceMacAddress(pdu, 10);
                pdu = replaceONUSNumber(pdu, 11);
            }
        }

        if (".1.3.6.1.4.1.45121.1.3.10.200.6.3.1.0".equals(pdu.getEnterprise().getVarObject())) {
            if (pdu.getSpecificType() == 16 || pdu.getSpecificType() == 18) {
                pdu = replaceBBS4000FanNumber(pdu);
            }

            if (pdu.getSpecificType() == 20 || pdu.getSpecificType() == 22) {
                pdu = replacePowerNumber(pdu);
            }
        }
        // String alarmId = null;
        Alarm ev = null;
        try {
            t2 = System.currentTimeMillis();
            ev = createAlarmEvent(pdu);
            if (ev != null) {
                ev = commonAttrbuteReplace(ev);
            }
            t3 = System.currentTimeMillis();

            // ev = replaceOnuMacAddress(ev, pdu);

            String community = pdu.getCommunity();
            // If the alarm is sent by ONU, add it to DB directly.
            if (community.indexOf("#OLTchassis:") != -1) {
                ev.setSeqNo(-1);// to avoid the alarm sychronization.
                UEventAPI.addAlarm(ev);

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        t4 = System.currentTimeMillis();
        System.out.println("Time used in creating alarm: " + (t3 - t2) + ", Time used in sending alarm:" + (t4 - t3) + ", total Time =" + (t4 - t1));

        return ev;
    }

    protected SnmpPDU replaceMacAddress(SnmpPDU pdu, int i) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(i);
            String var = varbind.getVariable().toString();

            if (var.indexOf(":") >= 0 || var.indexOf("-") >= 0)
                return pdu;

            var = toMac(var);
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(i, test);
        } catch (Exception err) {
            System.out.println("Can't replace the MacAddress: " + err.getMessage());
        }

        return pdu;
    }

    public String toMac(String s) {
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
            System.out.println("Can't replace the ONUSNumber: " + err.getMessage());
        }

        return pdu;
    }

    Alarm createAlarmEvent(SnmpPDU snmppdu) {
        String neName = null;
        String neType = null;
        try {
            String ip = snmppdu.getAgentAddr();
            Properties prop = UTopoAPI.getAPI().getNodeProperties( UTopoAPI.getAPI().getNodeNameByIP( ip ) );
//            Properties prop = ServerUtility.getNePropertiesByIpAddr(ip);

            if (prop == null) {
                if (dropUnManagedNEAlarm) {
                    System.out.println("Received alarm NE which is not managed, it is droped, ne=" + ip);
                    return null;
                } else {
                    neName = ip;
                    neType = "BBS1000";
                }
            } else {
                neName = prop.getProperty("name", ip);
                neType = prop.getProperty("neType", "BBS1000");
            }

            System.out.println("IP=" + ip + "; moName=" + neName + "; Type=" + neType);

            //
            if (".1.3.6.1.4.1.45121.1800.3.2.0".equals(snmppdu.getEnterprise().getVarObject())) {
                if (snmppdu.getSpecificType() == 1022 || snmppdu.getSpecificType() == 1023) {
                    String version = prop.getProperty("swVersion", "");

                    if ((neType.startsWith("BBS1000") && version.startsWith("2.3")) || (neType.equals("BBS4000") && version.equals("1.0.0"))) {
                        // do nothing.
                    } else {
                        snmppdu = replaceMemoryUsageNumber(snmppdu);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }

        AlarmParserResource parserResource = getAlarmParserResource(neType);

        if (parserResource == null) {
            System.out.println("The corresponding AlarmParserResource is null, ignore this PDU.");
            return null;
        }

        AlarmParser alarmParser = null;
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
                System.out.println("TrapOID parsing error, " + exception.getMessage());
                s = null;
            }
            if (s == null) {
                System.out.println("Trap OID is null, can not get the parser.");
                return null;
            }
            alarmParser = parserResource.getParser(s, true);
        } else {
            String s2 = snmppdu.getEnterprise().toString();
            String s4 = snmppdu.getSpecificType() + "";
            int i = snmppdu.getTrapType();
            if (i < 6) {
                alarmParser = parserResource.getParser(i + "", false);
            } else {
                alarmParser = parserResource.getParser(s2, s4);
            }
        }

        if (alarmParser == null) {
            System.out.println("No corresponding parser for this PDU, ignore it. enterprise :" + snmppdu.getEnterprise() + ";  specifictype :" + snmppdu.getSpecificType());
            return null;
        }

        long l = System.currentTimeMillis();
        Alarm Alarm = new Alarm();

        // Alarm.setCreateTime(System.currentTimeMillis());
        Alarm.setCreateTime(getTrapOccurTime(snmppdu));

        Alarm = alarmParser.parseTrap(Alarm, snmppdu);
        if (Alarm == null) {
            System.out.println("alarm parsed error, it is null.");
            return null;
        }
        Alarm.setId(1);

        Alarm.setNeName(neName);
        Alarm.setNeId(neName);
        // alarmid + entity to unify the alarm.
        // Alarm.setEntity(Alarm.getAlarmId() + "_" + Alarm.getEntity());
        String source = neName + "_" + Alarm.getEntityInstance();
        Alarm.setSource(source);
        Alarm.setNeType(neType);

        // alarmid + entityinstance to unify the alarm.
        // Alarm.setEntityInstance(Alarm.getAlarmId() + "_" +
        // Alarm.getEntityInstance());
        Alarm.setEntityInstance(Alarm.getEntityInstance());

        long l1 = System.currentTimeMillis();
        System.out.println("Time cost for parsing " + Alarm.getAlarmId() + " is " + (l1 - l));

        return Alarm;
    }

    private long getTrapOccurTime(SnmpPDU pdu) {
        long result = 0;
        int vbs = pdu.getVariableBindings().size();
        for (int i = 1; i < vbs; i++) {
            SnmpOID oid = pdu.getObjectID(i);
            SnmpVar value = pdu.getVariable(i);
            if (oid.toString().startsWith(".1.3.6.1.4.1.45121.2.3.2.2.2.1.2")) {
                result = SnmpUtil.getLongFromDataTimeByte(value.toBytes());
            }
        }

        return result;
    }

    /**
     * Replace alarm type and alarm severity and probablecause
     * 
     * @param alarm
     * @return the new alarm after replacement.
     */
    protected Alarm commonAttrbuteReplace(Alarm alarm) {
        System.out.println("Replace some attributes: " + alarm.getProperties());
        try {
            // Alarm severity
            // String alarmId = alarm.getAlarmId();
            // mapping alarm severity to
            int severity = alarm.getSeverity();
            if (severity == 4) { // FMConstant.NE_CRITICAL
                alarm.setSeverity(1);
            } else if (severity == 3) { // FMConstant.NE_MAJOR
                alarm.setSeverity(2);
            } else if (severity == 2) { // FMConstant.NE_MINOR
                alarm.setSeverity(3);
            } else if (severity == 1) { // FMConstant.NE_WARNING
                alarm.setSeverity(4);
            } else if ((severity == 0) || (severity == 5)) {
                alarm.setSeverity(5);
            } else {
                System.out.println("The alarm's severity is error, set to 5.");
                alarm.setSeverity(5);
            }

            // Alarm type
            int intType = Integer.parseInt(alarm.getCategory());
            if (intType == FMConstant.COMMUNICATION) {
                alarm.setCategory("communication");
            } else if (intType == FMConstant.EQUIPMENT) {
                alarm.setCategory("equipment");
            } else if (intType == FMConstant.ENVIRONMENT) {
                alarm.setCategory("environment");
            } else if (intType == FMConstant.PROCESSINGERROR) {
                alarm.setCategory("processingError");
            } else if (intType == FMConstant.QOS) {
                alarm.setCategory("qualityOfService");
            } else {
                System.out.println("The alarm's type is error, set to environment.");
                alarm.setCategory("environment");
            }

            // Alarm ProbableCause
            String strPC = alarm.getProbableCause();
            Object value = probableCauses.get(strPC);
            if (value == null) {
                alarm.setProbableCause(strPC);
            } else {
                alarm.setProbableCause(value.toString());
            }
        } catch (Exception e) {
            System.out.println("CommonAttributeReplace(), exception:" + e.getMessage());
            return alarm;
        }
        System.out.println("commonAttrbuteReplace(), after changing, properties:" + alarm.getProperties());

        return alarm;
    }

    protected Alarm replaceOnuMacAddress(Alarm alarm, SnmpPDU pdu) {
        // utFault trap
        if (".1.3.6.1.4.1.45121.1800.3.2.0".equals(pdu.getEnterprise().getVarObject())) {
            if (pdu.getSpecificType() == 6 || pdu.getSpecificType() == 7) { // replace
                                                                            // fan
                                                                            // module
                pdu = replaceFanNumber(pdu);
            }

            if (pdu.getSpecificType() == 1002 || pdu.getSpecificType() == 1004 || pdu.getSpecificType() == 1005 || pdu.getSpecificType() == 1007) { // replace
                                                                                                                                                    // fan
                                                                                                                                                    // module
                pdu = replacePonLinkDirection(pdu);
            }

            if (pdu.getSpecificType() == 1016 || pdu.getSpecificType() == 1017) {
                pdu = replaceDosAttackInfo(pdu);
            }

            if (pdu.getSpecificType() == 305) {
//                replaceOnuId(pdu);
            }
        }

        return alarm;
    }

    private Hashtable initProbableCause() {
        Hashtable table = new Hashtable();
        // NMS define
        table.put("14", ServerResourceManager.getString("Unavailable"));
        table.put("123", ServerResourceManager.getString("HighTemperature"));
        table.put("107", ServerResourceManager.getString("CoolingFanFailure"));
        table.put("62", ServerResourceManager.getString("ReplaceableUnitMissing"));
        table.put("58", ServerResourceManager.getString("PowerProblem"));
        table.put("236", ServerResourceManager.getString("LinkDown"));
        table.put("307", ServerResourceManager.getString("CommunicationProtocolError"));
        table.put("12", ServerResourceManager.getString("ExcessiveBER"));
        table.put("5", ServerResourceManager.getString("FramingError"));

        // 3G define
        table.put("15", ServerResourceManager.getString("Unavailable"));
        table.put("59", ServerResourceManager.getString("HighTemperature"));
        table.put("43", ServerResourceManager.getString("CoolingFanFailure"));
        table.put("29", ServerResourceManager.getString("ReplaceableUnitMissing"));
        table.put("25", ServerResourceManager.getString("PowerProblem"));
        table.put("516", ServerResourceManager.getString("LinkDown"));
        table.put("203", ServerResourceManager.getString("CommunicationProtocolError"));
        table.put("13", ServerResourceManager.getString("ExcessiveBER"));
        table.put("6", ServerResourceManager.getString("FramingError"));

        table.put("309", ServerResourceManager.getString("OnuSwitchOffline"));
        table.put("160", ServerResourceManager.getString("CPUUsageTooHigh"));
        table.put("161", ServerResourceManager.getString("MemoryUsageTooMuch"));

        // added by rox,
        table.put("515", ServerResourceManager.getString("LineInterfaceFailure"));
        table.put("552", ServerResourceManager.getString("SystemResourcesOverload"));

        return table;
    }

    public SnmpPDU replaceFanNumber(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(7);

            String var = varbind.getVariable().toString();
            if (var.equals("2")) {
                var = ServerResourceManager.getString("fan_rear");
            } else if (var.equals("4")) {
                var = ServerResourceManager.getString("fan_middle");
            } else if (var.equals("8")) {
                var = ServerResourceManager.getString("fan_front");
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(7, test);
        } catch (Exception err) {
            System.out.println("Can't replace the Fan Number: " + err.getMessage());
        }

        return pdu;
    }

    public SnmpPDU replaceBBS4000FanNumber(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(7);

            String var = varbind.getVariable().toString();
            if (var.equals("2")) {
                var = ServerResourceManager.getString("fan_left");
            } else if (var.equals("4")) {
                var = ServerResourceManager.getString("fan_middle");
            } else if (var.equals("8")) {
                var = ServerResourceManager.getString("fan_right");
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(7, test);
        } catch (Exception err) {
            System.out.println("Can't replace the Fan Number: " + err.getMessage());
        }

        return pdu;
    }

    public SnmpPDU replacePowerNumber(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(7);

            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = ServerResourceManager.getString("power_low");
            } else if (var.equals("2")) {
                var = ServerResourceManager.getString("power_upper");
            } else {
                var = ServerResourceManager.getString("power_unknown");
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(7, test);
        } catch (Exception err) {
            System.out.println("Can't replace the Fan Number: " + err.getMessage());
        }

        return pdu;
    }

    public SnmpPDU replacePonLinkDirection(SnmpPDU pdu) {
        try {
            SnmpVarBind varbind = pdu.getVariableBinding(11);

            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = ServerResourceManager.getString("link_upstream");
            } else if (var.equals("2")) {
                var = ServerResourceManager.getString("link_downstream");
            }
            SnmpVar test = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(11, test);
        } catch (Exception err) {
            System.out.println("Can't replace the Pon Link Direction: " + err.getMessage());
        }

        return pdu;
    }

    public SnmpPDU replaceDosAttackInfo(SnmpPDU pdu) {
        try {
            // AlarmAttackSource
            SnmpVarBind varbind = pdu.getVariableBinding(7);
            String var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = ServerResourceManager.getString("inband");
            } else if (var.equals("2")) {
                var = ServerResourceManager.getString("outband");
            }
            SnmpVar snmpVar = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(7, snmpVar);

            // AlarmAttackType
            varbind = pdu.getVariableBinding(8);
            var = varbind.getVariable().toString();
            if (var.equals("1")) {
                var = "TCP SYN";
            } else if (var.equals("2")) {
                var = "UDP";
            } else if (var.equals("3")) {
                var = "ICMP";
            } else if (var.equals("4")) {
                var = "DHCP";
            } else if (var.equals("5")) {
                var = "ARP";
            }

            snmpVar = SnmpVar.createVariable(var, DefaultSnmpAPI.STRING);
            pdu.setVariable(8, snmpVar);
        } catch (Exception err) {
            System.out.println("Can't replace the DOS attack info: " + err.getMessage());
        }

        return pdu;
    }

//    protected SnmpPDU replaceOnuId(SnmpPDU pdu) {
//        try {
//            String mac = ConfigUtility.OctetToMacAddress(pdu.getVariable(5).toString());
//            ONUDevice onu = OnuMgmtMgrImpl.getInstance().getOnuMOD(mac);
//
//            if (onu != null && !(onu.getOnuId() != 0)) {
//                pdu.setVariable(4, SnmpVar.createVariable(String.valueOf(onu.getOnuId()), DefaultSnmpAPI.STRING));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Can't replace ONU Attributes: " + e.getMessage());
//        }
//
//        return pdu;
//    }

    protected SnmpPDU replaceMacAddress(SnmpPDU pdu) {
        try {
            String mac = ConfigUtility.OctetToMacAddress(pdu.getVariable(10).toString());
            pdu.setVariable(10, SnmpVar.createVariable(mac, DefaultSnmpAPI.STRING));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't parse the ONU MAC address: " + e.getMessage());
        }

        return pdu;
    }

    protected SnmpPDU replaceMemoryUsageNumber(SnmpPDU pdu) {
        try {
            String usage = pdu.getVariable(7).toString();
            if (usage != null && usage.length() > 0) {
                if (usage.length() == 1) {
                    usage = "0." + usage;
                } else {
                    int len = usage.length();
                    usage = usage.substring(0, len - 1) + "." + usage.substring(len - 1, len);
                }

                pdu.setVariable(7, SnmpVar.createVariable(usage, DefaultSnmpAPI.STRING));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't parse the ONU MAC address: " + e.getMessage());
        }

        return pdu;
    }

    public String toString() {
        return "EponAlarmTrapParser";
    }

}