package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class ModuleHwVerFormatter extends SnmpFieldFormatter {

    public ModuleHwVerFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);

        return format(value);
    }


    public static String format(byte[] bytes) {
        if(bytes == null || bytes.length == 0) return "Ox00";

        StringBuffer sb = new StringBuffer("0x");

        for(int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toHexString(bytes[i] & 0xFF).toUpperCase());
        }

        return sb.toString();
    }
}
