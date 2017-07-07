package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-7
 * Time: 6:23:27
 */
public class TenthIntegerFormatter extends SnmpFieldFormatter {

    public TenthIntegerFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Number value = (Number)MibBeanUtil.getSimpleProperty(mibBean, property);

        if(value == null) return "0";

        return value.intValue()/10;
//        DecimalFormat df2  = new DecimalFormat("##0.00");
//        double b = value/(double)100;
//        return df2.format(b);
    }
}
