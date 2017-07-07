/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Vendor ID:2
 * Chip model:2
 * Revision:1
 * IC_Version/date:3
 *
 * @author Rox Liu
 */
public class Dot3Onu2CtcChipsetIdFormatter extends SnmpFieldFormatter {

    public Dot3Onu2CtcChipsetIdFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aProperty.equals("utsDot3Onu2CtcChipVendor")) {
            String onuVendor = "";
            byte[] b = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, "utsDot3Onu2CtcOnuVendor");
            for (int i = 0; i < 4; i++) {
                if (b[i] < 32) b[i] = 32;
            }
            onuVendor = new String(b, 0, 4, "ISO-8859-1");
            if (onuVendor != null && onuVendor.trim().length() > 0 && onuVendor.trim().equalsIgnoreCase("FH")) {
                return "02-03";
            }
        }

        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (isNull(value)) {
            return "Unknown";
        }
        if (aProperty.equals("utsDot3Onu2CtcChipVendor")) {
            return new String(value, 0, 2);
            //return getHexStr( value[0]) + "-" + getHexStr(value[1]);
        } else if (aProperty.equals("utsDot3Onu2CtcChipModel")) {
            //return new String(value, 2, 2);
            return getHexStr(value[2]) + getHexStr(value[3]);
        } else if (aProperty.equals("utsDot3Onu2CtcChipRevision")) {
            return getHexStr(value[4]);
        } else if (aProperty.equals("utsDot3Onu2CtcChipVer")) {
            StringBuffer sb = new StringBuffer();
            sb.append(getHexStr(value[5])).append("/").append(getHexStr(value[6])).append("/").append(getHexStr(value[7]));
            return sb.toString();
        }

        return "Unknown";
    }

    private String getHexStr(byte bt) {
        String tmpStr = Integer.toHexString(bt & 255);
        return (tmpStr.length() <= 1 ? "0" + tmpStr : tmpStr).toUpperCase();
    }

    private boolean isNull(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0)
                return false;
        }

        return true;
    }

}