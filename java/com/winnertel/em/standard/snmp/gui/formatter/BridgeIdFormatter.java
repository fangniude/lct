package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class BridgeIdFormatter extends SnmpFieldFormatter {
    public BridgeIdFormatter(IApplication anApplication) {
        super(anApplication);
    } // BridgeIdFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();
        String priority = Integer.toHexString(value[0] & 0xff);
        String priority1 = Integer.toHexString(value[1] & 0xff);
        if (priority1.length() == 1) {
            priority = priority + "0" + priority1;
        } else {
            priority = priority + priority1;
        }
        result.append(Integer.parseInt(priority, 16));
        result.append(".");
        for (int i = 2; i < value.length; i++) {
            byte b = value[i];
            if (b >= 0 && b < 16) {
                result.append('0');
            }

            int bi = value[i] & 0xff;
            result.append(Integer.toHexString(bi).toUpperCase());

            if (i < value.length - 1) {
                result.append(":");
            }
        }
        return result.toString();
    }
} // BridgeIdFormatter
