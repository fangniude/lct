package com.winnertel.ems.epon.iad.bbs4000.formatter.r221;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class McTagStripeEntryFormatter extends SnmpFieldFormatter {

    public McTagStripeEntryFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer number = (Integer) MibBeanUtil.getSimpleProperty(mibBean, "utsDot3OnuEtherPortMcTagStripeNumber");

        if(number == null || number.intValue() < 1) return null;

        byte[] values = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
        StringBuffer sb = new StringBuffer();
        int postion = 0;
        
        for(int i = 0; i < number; i++) {
            int mVlan = ((values[i*4]&0xFF)<<8) | (values[i*4+1]&0xFF);
            int uVlan = ((values[i*4+2]&0xFF)<<8) | (values[i*4+3]&0xFF);

            sb.append("[").append(mVlan).append(",").append(uVlan).append("] ");
            if(mVlan != 0 || uVlan != 0) postion = sb.length();
        }

        if(sb.length() > 0) {
            int bit = sb.indexOf("[", postion);
            if(bit != -1 ) sb.delete(bit, sb.length());
        }

        return sb.toString();
    }

}
