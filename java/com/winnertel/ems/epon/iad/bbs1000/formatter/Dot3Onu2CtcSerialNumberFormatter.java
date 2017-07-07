/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs1000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.inventory.OnuMODHelper;

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

                return OnuMODHelper.convertHwType(new String(value, 4, 4, "ISO-8859-1"));
            } else if (aProperty.equals("utsDot3Onu2CtcOnuMacAddr")) {
                byte[] mac = new byte[6];
                System.arraycopy(value, 8, mac, 0, 6);

                return ConfigUtility.OctetToMacAddress(mac);
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
        if (value == null || value.length < 14) {
            return null;
        }

        byte[] mac = new byte[6];
        System.arraycopy(value, 8, mac, 0, 6);
        return ConfigUtility.OctetToMacAddress(mac);
    }

}