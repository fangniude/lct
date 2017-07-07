package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class DotHexFormatter extends SnmpFieldFormatter {
    public DotHexFormatter(IApplication anApplication) {
        super(anApplication);
    } // BridgeIdFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            byte b = value[i];
            if (b >= 0 && b < 16) {
                result.append('0');
            }

            int bi = value[i] & 0xff;
            result.append(Integer.toHexString(bi).toUpperCase());

            if (i < value.length - 1) {
                result.append(".");
            }
        }
        return result.toString();
    }
} // BridgeIdFormatter
