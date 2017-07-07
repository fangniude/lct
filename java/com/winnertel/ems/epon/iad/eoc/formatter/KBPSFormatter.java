package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-8-17
 * Time: 15:00:50
 * To change this template use File | Settings | File Templates.
 */
public class KBPSFormatter extends SnmpFieldFormatter {

    public KBPSFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);

        if (value == null) return "";

        DecimalFormat df2 = new DecimalFormat("##0.000");
        double b = value / (double) 1000;
        return df2.format(b);
    }
}
