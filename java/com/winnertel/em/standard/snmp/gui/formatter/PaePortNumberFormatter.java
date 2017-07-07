package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class PaePortNumberFormatter extends SnmpFieldFormatter {
    public PaePortNumberFormatter(IApplication anApplication) {
        super(anApplication);
    } // PaePortNumberFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();

        int composedId = value.intValue();
        int moduleId = (composedId & 0xFFFF0000) >>> 16;
        int portId = composedId & 0x0000FFFF;
        sb.append(moduleId + "-" + portId);

        return sb.toString();
    }
} // PaePortNumberFormatter
