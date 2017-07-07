package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OuiFormatter extends SnmpFieldFormatter {

    public OuiFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        return format(value);
    }

    public static String format(byte[] value) {
        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        sb.append(format(value[0])).append(".").append(format(value[1])).append(".").append(format(value[2]));

        return sb.toString().trim();
    }

    static String format(byte b) {
        String s = Integer.toHexString(b&0xFF).toUpperCase();

        return s.length() < 2? "0"+s : s;
    }
}

