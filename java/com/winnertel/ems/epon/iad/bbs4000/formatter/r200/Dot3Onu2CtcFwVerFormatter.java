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
 * The Dot3Onu2CtcFwVerFormatter class.
 * "xxxx :4
 * version:6
 * xxxx : 2
 *
 * @author Rox Liu
 */
public class Dot3Onu2CtcFwVerFormatter extends SnmpFieldFormatter {

    public Dot3Onu2CtcFwVerFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        String onuVendor = "";
        byte[] b = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, "utsDot3Onu2CtcOnuVendor");
        for (int i = 0; i < 4; i++) {
            if (b[i] < 32) b[i] = 32;
        }
        onuVendor = new String(b, 0, 4, "ISO-8859-1");
        if (onuVendor != null && onuVendor.trim().length() > 0 && onuVendor.trim().equalsIgnoreCase("FH")) {
            return "D000";
        }

        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (value == null || value.length == 0) return "";
        StringBuffer sb = new StringBuffer();
        try {/*
            //if (value[4] != 0) sb.append(value[4]);
            if (value.length > 5) sb.append(value[5] & 0xFF).append(".");
            //if (value[6] != 0) sb.append(value[6]);
            if (value.length > 7) sb.append(value[7] & 0xFF).append(".");
            //if (value[8] != 0) sb.append(value[8]);
            if (value.length > 9) sb.append(value[9] & 0xFF);*/
        	for(int i=0;i<value.length-1;i++){
        		int ai = value[i] & 0xff;
        		String s = Integer.toHexString(ai);
        		if(s.length()<2){
        			sb.append("0");
        		}
        		sb.append(s).append(".");
        	}
        	int bi = value[value.length-1] & 0xff;
        	String se = Integer.toHexString(bi);
        	if(se.length()<2){
        		sb.append("0");
        	}
        	sb.append(se);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}