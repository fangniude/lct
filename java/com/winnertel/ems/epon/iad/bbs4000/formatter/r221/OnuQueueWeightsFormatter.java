package com.winnertel.ems.epon.iad.bbs4000.formatter.r221;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuQueueWeightsFormatter extends SnmpFieldFormatter {

    public OnuQueueWeightsFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        byte[] values = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
        if(values == null) return null;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < values.length/2; i++) {
            int value = ((values[i*2]&0xFF)<<8) | (values[i*2+1]&0xFF);

            sb.append(value).append("|");
        }

        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}
