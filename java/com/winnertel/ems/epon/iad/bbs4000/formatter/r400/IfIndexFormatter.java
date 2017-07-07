package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class IfIndexFormatter extends SnmpFieldFormatter {

    public IfIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < value.length/4; i++) {
            if(value[i*4+1] == 0x3F) {
                sb.append("trunk").append(value[i*4+2]);
            } else if(value[i*4+1] != 0) {
                sb.append(value[i*4+1]).append("/").append(value[i*4+2]);

                if(value[i*4+3] != 0) {
                    sb.append("/").append(value[i*4+3]);
                }
            }

            sb.append(" ");
        }

        return sb.toString().trim();
    }
}

