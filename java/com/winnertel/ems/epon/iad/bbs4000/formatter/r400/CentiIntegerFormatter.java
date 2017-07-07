package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

//import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 13:21:57
 */
public class CentiIntegerFormatter extends SnmpFieldFormatter {

    public CentiIntegerFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);

        if(value == null) return "0";

        return value/100;
//        DecimalFormat df2  = new DecimalFormat("##0.00");
//        double b = value/(double)100;
//        return df2.format(b);
    }
}
