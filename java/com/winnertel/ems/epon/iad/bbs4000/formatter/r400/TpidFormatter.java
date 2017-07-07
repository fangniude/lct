package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class TpidFormatter extends SnmpFieldFormatter {
    public TpidFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try{
            byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

            if(value == null) return null;

            StringBuffer sb = new StringBuffer("0x");

            for(int i = 0; i < value.length; i++) {
                String s = Integer.toHexString(value[i] & 0xFF);

                if(s.length() < 2) sb.append("0");

                sb.append(s);
            }

            return sb.toString();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
