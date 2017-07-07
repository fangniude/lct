package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-7
 * Time: 15:49:54
 * To change this template use File | Settings | File Templates.
 */
public class AlarmLogInformationFormatter extends SnmpFieldFormatter {

    public AlarmLogInformationFormatter(IApplication anApplication) {
        super(anApplication);
    }

    private static final String[] AlarmType = new String[]{
            "NOMINAL",
            "HIHI",
            "HI",
            "LO",
            "LOLO",
            "Discrete Major",
            "Discrete Minor"

    };

    //Discrete
    public final static String modEoCCBATAdminTamperStatus_OID = "1.3.6.1.4.1.17409.2.4.1.3.4";
    public final static String modEoCCBATCardOnlineStatus_OID = "1.3.6.1.4.1.17409.2.4.3.2.1.3";
    public final static String modEoCCNUOnlineStatus_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.4";

    //Analog
    public final static String modEoCCNURFAttenuation_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.10";
    public final static String modEoCCNURFDownstreamQuality_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.11";
    public final static String modEoCCNURFUpstreamQuality_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.12";
    public final static String modEoCCNUPhyDownstreamRate_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.13";
    public final static String modEoCCNUPhyUpstreamRate_OID = "1.3.6.1.4.1.17409.2.4.5.2.4.1.14";

    //
    public final static String[][] allOID = new String[][]{
            /*OID,DisplayString,DisplayFormat,obj num,valuenum or isDiscrete */
            {modEoCCNURFAttenuation_OID, "modEoCCNURFAttenuation", "%0%-%1%", "2", "0"},
            {modEoCCNURFDownstreamQuality_OID, "modEoCCNURFDownstreamQuality", "%0%-%1%", "2", "0"},
            {modEoCCNURFUpstreamQuality_OID, "modEoCCNURFUpstreamQuality", "%0%-%1%", "2", "0"},
            {modEoCCNUPhyDownstreamRate_OID, "modEoCCNUPhyDownstreamRate", "%0%-%1%", "2", "0"},
            {modEoCCNUPhyUpstreamRate_OID, "modEoCCNUPhyUpstreamRate", "%0%-%1%", "2", "0"},

            {modEoCCBATAdminTamperStatus_OID, "modEoCCBATAdminTamperStatus", "", "0", "1"},
            {modEoCCBATCardOnlineStatus_OID, "modEoCCBATCardOnlineStatus", "", "1", "1"},
            {modEoCCNUOnlineStatus_OID, "modEoCCNUOnlineStatus", "%0%-%1%", "2", "1"}
    };

    /**
     * �澯��¼��Ϣ�����ֽڴ����������£�
     * �ֽ� 1��8: �澯����ʱ��(POSIX��ʽ�������Ч�ֽ���ǰ,��32λ��
     * չ��64λ�Է�ֹ2038������)
     * �ֽ� 9: �澯����(ö�٣�������)
     * �ֽ� 10��m: �澯����Ķ����ʶ��(��������ASN.1��)
     * �ֽ� n��z: �澯����ֵ (��������ASN.1��)
     * <p/>
     * �澯ö�����ͣ�
     * 1 NOMINAL
     * 2 HIHI
     * 3 HI
     * 4 LO
     * 5 LOLO
     * 6 Discrete Major
     * 7 Discrete Minor
     */
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null) return null;

        byte[] tmpObj = (byte[]) obj;
        String retStr = "";

        //aProperty
//        if (tmpObj.length >= 8) {
        if ("alarmLogTime".equals(aProperty)) {
            byte[] posixTime = new byte[8];
            System.arraycopy(tmpObj, 0, posixTime, 0, 8);
            long longSeconds = bytes2long(posixTime);
            Date date = new Date();
            date.setTime(longSeconds * 1000L);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
            retStr = dateFormat.format(date);
        } else if ("alarmLogType".equals(aProperty)) {
            int alarmType = tmpObj[8];
            if (alarmType > 0 && alarmType <= AlarmType.length)
                retStr = AlarmType[alarmType - 1];

        } else if ("alarmLogMessage".equals(aProperty)) {
            int oidByteLen = tmpObj.length - 9 - 2;
            //if(tmpObj.length>oidLen+9) {
            //oid begin at 10
            byte[] oidByte = new byte[oidByteLen];
            if (oidByteLen > 0) {
                System.arraycopy(tmpObj, 9 + 2, oidByte, 0, oidByteLen);
                int[] oidInt = new int[oidByteLen];

                int intPos = 0;
                oidInt[intPos++] = 1;
                oidInt[intPos++] = 3;

                oidInt[intPos] = 0;
                for (int i = 1; i < oidByteLen; i++) {
                    if ((oidByte[i] & 0x80) == 0x80) {
                        oidInt[intPos] = (oidInt[intPos] << 7) | (oidByte[i] & 0x7F);
                    } else {
                        oidInt[intPos] = (oidInt[intPos] << 7) | oidByte[i];
                        intPos = intPos + 1;
                        if (intPos >= oidByteLen) {
                            break; //protect array    
                        }
                        oidInt[intPos] = 0;
                    }
                }

                String oidStr = "";
                for (int i = 0; i < intPos; i++) {
                    oidStr = oidStr + oidInt[i] + ".";
                }

                //UTSnmpOID oid=new UTSnmpOID(oidInt);
                //String oidStr=oid.toString();

                retStr = (String) formatAsStr(oidStr);

                /*
                if ((oidStr.indexOf(modEoCCBATAdminTamperStatus_OID)>=0)||
                        (oidStr.indexOf(modEoCCBATCardOnlineStatus_OID)>=0)||
                        (oidStr.indexOf(modEoCCNUOnlineStatus_OID)>=0)){
                    String alarmValue=DiscreteAlarmValueFormatter.getLastOIDItem(oidStr);
                    retStr=retStr+" "+ alarmValue;
                }
                else{

                }  */
            }
        }

        return retStr;
    }

    public Object formatAsStr(String tmpObj) throws Exception {

        String[] allNum = tmpObj.split("[.]");
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        String retStr = tmpObj;

        for (int i = 0; i < allOID.length; i++) {
            int pos1 = tmpObj.indexOf(allOID[i][0]);

            if (pos1 >= 00) {

                retStr = composer.getString(allOID[i][1]);

                String[] oidNum = allOID[i][0].split("[.]");
                String[] indexNum = null;
                int indexNum_len = Integer.parseInt(allOID[i][3]);
                if (allNum.length >= oidNum.length + indexNum_len && indexNum_len > 0) {
                    indexNum = new String[indexNum_len];
                    for (int k = 0; k < indexNum_len; k++) {
                        indexNum[k] = allNum[oidNum.length + k];
                    }
                }
                if (indexNum != null) {
                    //String strIdx=tmpObj.substring(pos1+allOID[i][0].length());
                    //retStr= allOID[i][1] + strIdx;
                    String indexStr = new String(allOID[i][2]);
                    for (int k = 0; k < indexNum.length; k++) {
                        indexStr = indexStr.replaceAll("%" + k + "%", String.valueOf(indexNum[k]));
                    }

                    if (indexStr.length() > 0) {
                        retStr = retStr + ":" + indexStr;
                    }

                }

                int valueNum_len = Integer.parseInt(allOID[i][4]);
                if (valueNum_len > 0) {
                    if (allNum.length >= oidNum.length + indexNum_len + valueNum_len + 2) {
                        String tmpValue = DiscreteAlarmValueFormatter.getValueAs(
                                composer, allOID[i][0], allNum[oidNum.length + indexNum_len + valueNum_len + 2 - 1]);
                        retStr = retStr + " (" + tmpValue + ")";
                    }
                }

                break;
            }

        }


        return retStr;
    }

    private static long bytes2long(byte[] b) {

        int mask = 0xff;
        int temp = 0;
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res <<= 8;
            temp = b[i] & mask;
            res |= temp;
        }
        return res;
    }

}
