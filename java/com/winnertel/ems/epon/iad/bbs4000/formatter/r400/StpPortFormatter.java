package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-5
 * Time: 15:47:11
 */
public class StpPortFormatter extends SnmpFieldFormatter {
    public StpPortFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value != null) {
            return format(value);
        }

        return null;
    }

    public static String format(Long value) {
        return "0x" + Integer.toHexString(value.intValue()).toUpperCase();
    }
}
