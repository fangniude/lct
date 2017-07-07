package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-10-26
 * Time: 18:32:06
 * To change this template use File | Settings | File Templates.
 */
public class HelloTimeFormatter  extends SnmpFieldFormatter {
    public HelloTimeFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {

        Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        return new Double(value.doubleValue()*0.01);
    }
} // ElapsedTimeFormatter