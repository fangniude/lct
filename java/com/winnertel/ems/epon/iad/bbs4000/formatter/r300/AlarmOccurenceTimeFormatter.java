package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AlarmOccurenceTimeFormatter extends SnmpFieldFormatter {

    public AlarmOccurenceTimeFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] utcTime = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(utcTime == null || utcTime.length == 0) {
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        //1970-1-1,0:0:41.0,+0:00
        sb.append(bytes2Int(utcTime[0], utcTime[1])).append("-").append(utcTime[2]).append("-").append(utcTime[3]).append(", ").append(utcTime[4]).append(":").append(utcTime[5]).append(":").append(utcTime[6]).append(".").append(utcTime[7]).append(", ");

        sb.append((char)utcTime[8]).append(utcTime[9]).append(":").append(utcTime[10]);

        if(utcTime.length > 11) {
            sb.append(":").append(utcTime[11]);
        }

        return sb.toString();
    }

    int bytes2Int(byte b1, byte b2) {
        int value = (b1&0xFF) << 8;

        return value | (b2&0xFF);
    }
}

