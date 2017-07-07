package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class StringTrimFormatter extends SnmpFieldFormatter {
    public StringTrimFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        String value = (String) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (value != null)
            return value.trim();
        else
            return null;
    }
}


