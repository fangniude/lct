package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class OidFormatter extends SnmpFieldFormatter {
    public OidFormatter(IApplication anApplication) {
        super(anApplication);
    } // OidFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        long[] value = (long[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            result.append(value[i]);
            if (i < (value.length - 1)) result.append(".");
        }
        return result.toString();
    }
} // OidFormatter
