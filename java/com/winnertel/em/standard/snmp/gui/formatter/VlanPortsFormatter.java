package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class VlanPortsFormatter extends SnmpFieldFormatter {
    public VlanPortsFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        boolean firstOne = true;
        for (int i = 0; i < value.length * 8; i++) {
            int byteIndex = i / 8;
            int bitIndex = 7 - i % 8;
            if (((value[byteIndex] >>> bitIndex) & 0x01) == 1) {
                if (!firstOne) {
                    sb.append(",");
                }
                if (firstOne) {
                    firstOne = false;
                }
                sb.append(String.valueOf(i + 1));
            }
        }

        return sb.toString();
    }
}
