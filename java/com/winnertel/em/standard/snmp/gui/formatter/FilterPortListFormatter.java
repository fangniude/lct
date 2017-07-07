package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class FilterPortListFormatter extends SnmpFieldFormatter {
    public FilterPortListFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        String value = (String) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null || value.length() != 26) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1') {
                sb.append(i + 1);
                sb.append(",");
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
