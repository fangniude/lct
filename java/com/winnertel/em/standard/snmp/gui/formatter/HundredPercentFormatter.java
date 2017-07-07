package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class HundredPercentFormatter extends SnmpFieldFormatter {
    public HundredPercentFormatter(IApplication anApplication) {
        super(anApplication);
    } // BridgeIdFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();
        result.append((((float) value.intValue()) / 100.0));
        result.append("%");

        return result.toString();
    }
} // BridgeIdFormatter
