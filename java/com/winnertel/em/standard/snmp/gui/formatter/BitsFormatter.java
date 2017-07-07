package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;


public abstract class BitsFormatter extends SnmpFieldFormatter {
    public BitsFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }
        int index;
        StringBuffer buffer = new StringBuffer();
        Loop:
        for (int i = 0; i < value.length; i++) {
            byte octet = value[i];
            for (int j = 0; j < 8; j++) {
                if ((octet & (1 << (7 - j))) != 0) {
                    index = (i * 8) + j;
                    if (index >= getLength()) {
                        break Loop;
                    }
                    if (get(index) != null) {
                        buffer.append(get(index) + ",");
                    }
                }
            }
        }
        if (buffer.length() <= 0) {
            buffer.append("Unknown");
        } else {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }

    protected abstract String get(int index);

    protected abstract int getLength();

}
