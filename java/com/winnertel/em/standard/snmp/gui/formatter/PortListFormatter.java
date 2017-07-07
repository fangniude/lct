package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class PortListFormatter extends SnmpFieldFormatter {
    public PortListFormatter(IApplication anApplication) {
        super(anApplication);
    } // PortListFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (((value[i] >>> (7 - j)) & 0x01) == 1) {
                    sb.append(i * 8 + j + 1);
                    sb.append(",");
                }
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    } // format
} // PortListFormatter
