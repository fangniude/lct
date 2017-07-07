package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class DateAndTimeFormatter extends SnmpFieldFormatter {

    public DateAndTimeFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] utcTime = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        return format(utcTime);
    }

    public static String format(byte[] time) {
        if(time == null || time.length < 1) return null;
        
        StringBuffer sb = new StringBuffer();
        //1970-1-1,0:0:41.0,+0:00
        sb.append(bytes2Int(time[0], time[1])).append("-").append(time[2]).append("-").append(time[3]).append(", ").append(time[4]).append(":").append(time[5]).append(":").append(time[6]).append(".").append(time[7]).append(", ");

        sb.append((char)time[8]).append(time[9]).append(":").append(time[10]);

        if(time.length > 11) {
            sb.append(":").append(time[11]);
        }

        return sb.toString();
    }

    static int bytes2Int(byte b1, byte b2) {
        int value = (b1&0xFF) << 8;

        return value | (b2&0xFF);
    }
}