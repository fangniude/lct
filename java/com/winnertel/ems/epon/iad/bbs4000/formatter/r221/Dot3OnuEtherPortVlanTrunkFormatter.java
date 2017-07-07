package com.winnertel.ems.epon.iad.bbs4000.formatter.r221;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuEtherPortVlanTrunkFormatter extends SnmpFieldFormatter {

    public Dot3OnuEtherPortVlanTrunkFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        byte[] values = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
        if(values == null || values.length < 1) return null;

        StringBuffer sb = new StringBuffer();
        int postion = 0;

        for(int i = 0; i < 16; i++) {
            int tpid = ((values[i*4]&0xFF)<<8) | (values[i*4+1]&0xFF);
            int tag = ((values[i*4+2]&0xFF)<<8) | (values[i*4+3]&0xFF);
            String s = Integer.toHexString(tpid);
            sb.append("[");
            if(s.length() % 2 != 0) {
                sb.append("0x0");
            } else {
                sb.append("0x");
            }
            
            sb.append(s).append(",").append(tag).append("],");
            if(tpid != 0 || tag != 0) postion = sb.length();
        }

        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
            int bit = sb.indexOf("[0x", postion) - 1;
            sb.delete(bit, sb.length());
        }

        return sb.toString();
    }
}
