package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class TimeFormatter extends SnmpFieldFormatter {
    public TimeFormatter(IApplication anApplication) {
        super(anApplication);
    } // TimeTicksFormatter

    private String f(int b) {
        if (b < 10) return "0" + b;
        else return b + "";
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        IStringMap fStringMap = fApplication.getGlobalStringMap();
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        return (1900 + value[5]) + "-" + f(1 + (int) value[4]) + "-" + f(value[3]) + "  " +
                f(value[2]) + ":" + f(value[1]) + ":" + f(value[0]);

    }
} // TimeTicksFormatter
