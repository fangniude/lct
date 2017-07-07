package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AlarmVersionIdFormatter extends SnmpFieldFormatter {

    public AlarmVersionIdFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null) return null;

        long version = value.longValue();
        int[] array = new int[4];

        for(int i = 0; i < 4; i++) {
            array[3-i] = (int)(version & 0xFF);
            version = version >> 8;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(array[0]).append(".").append(array[1]).append(".").append(array[2]).append(".").append(array[3]);
        
        return sb.toString();
    }
}

