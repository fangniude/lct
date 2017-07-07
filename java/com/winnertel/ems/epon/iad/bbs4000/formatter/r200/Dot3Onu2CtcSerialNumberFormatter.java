package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.inventory.OnuMODHelper;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * The Dot3Onu2CtcSerialNumberFormatter class.
 * "Vendor ID:4
 * ONU model:4
 * ONU ID: ONU MAC address 6
 * Hardware version:8
 * Software version:16
 * "
 * For example:
 * ONU Serial Number :
 * Vendor ID : IMST
 * ONU Model : 8015
 * ONU ID    : 88-80-15-06-46-17
 * Hardware Version : 05.00.10.00.00.00.00.00
 * Software Version : 3f.8f.ff.45.02.00.00.00.02.00.00.22.05.00.10.22
 *
 * @author Rox Liu
 */

public class Dot3Onu2CtcSerialNumberFormatter extends SnmpFieldFormatter {

    public Dot3Onu2CtcSerialNumberFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        try {
            if (aProperty.equals("utsDot3Onu2CtcOnuVendor")) {
                for (int i = 0; i < 4; i++) {
                    if (value[i] < 32) value[i] = 32;
                }
                return new String(value, 0, 4, "ISO-8859-1");
            } else if (aProperty.equals("utsDot3Onu2CtcOnuModel")) {
                for (int i = 0; i < 4; i++) {
                    if (value[4 + i] < 32 || value[4 + i] > 126) value[4 + i] = 32;
                }
                //return getOnuType(new String(value, 4, 4, "ISO-8859-1")); //remarked by Zhou Chao
                return OnuMODHelper.convertHwType(new String(value, 4, 4, "ISO-8859-1")); //modified by Zhou Chao
            } else if (aProperty.equals("utsDot3Onu2CtcOnuMacAddr")) {
                return getMacAddress(value);
            } else if (aProperty.equals("utsDot3Onu2CtcOnuHardwareVer")) {
                for (int i = 0; i < 8; i++) {
                    if (value[14 + i] < 32 || value[14 + i] > 126) value[14 + i] = 32;
                }
                return new String(value, 14, 8).trim();
            } else if (aProperty.equals("utsDot3Onu2CtcOnuSoftwareVer")) {
                for (int i = 0; i < 16; i++) {
                    if (value[22 + i] < 32 || value[22 + i] > 126) value[22 + i] = 32;
                }

                return new String(value, 22, 16).trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Unknown";
    }

    public static String getMacAddress(byte[] value) {
        if (value == null || (value.length < 14 && value.length != 6)) {
            return null;
        }

        byte[] mac = new byte[6];
        if (value.length >= 14)
            System.arraycopy(value, 8, mac, 0, 6);
        else
            System.arraycopy(value, 0, mac, 0, 6);

        return ConfigUtility.OctetToMacAddress(mac);
    }

    /* remarked by Zhou Chao
    public static String getOnuType(String model) {
        if (model != null) {
            if (model.equals("A001"))
                return "ONU1001i";

            if (model.equals("A002"))
                return "ONU204i";

            if (model.equals("A003"))
                return "ONU404i";

            if (model.equals("A004"))
                return "ONU804i";

            if (model.equals("A005"))
                return "ONU208i";

            if (model.equals("A006"))
                return "ONU101i";

            if (model.equals("A007"))
                return "ONU2004i";

            if (model.equals("A008"))
                return "CLT2060";

            if (model.equals("A009"))
                return "ONU2024i";

            if (model.equals("A018"))
                return "ONU408t";

            if (model.equals("A019"))
                return "B1205-Y";

            if (model.equals("A022"))
                return "ONU4024t";
        }

        return "UNKNOWN";
    }
    */

}