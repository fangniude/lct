package com.winnertel.ems.epon.iad.bbs4000.formatter.r310;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

/**
 * This file is used for Current option which unit is 2 uA.
 * @author hz03696
 *
 */
public class CurrentFormatter extends SnmpFieldFormatter {

    public CurrentFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);

        if(value == null) return "0";

        DecimalFormat df2  = new DecimalFormat("##0.00");
        double b = value/(double)500;
        return df2.format(b);
    }
}
