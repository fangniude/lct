package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

public class UplinkOpmDataFormatter extends SnmpFieldFormatter {

    public UplinkOpmDataFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);

        DecimalFormat df2  = new DecimalFormat("0.##");


        if("utsUplinkOpmDataTxPower".equals(property) || "utsUplinkOpmDataRxPower".equals(property)) {
            if(value == -2147483648) {
                return "N/A";
            }
        }

        double b = value/(double)1000;
        return df2.format(b);

//        if("utsUplinkOpmDataTxPower".equals(property)) {
//            double b = 10 * Math.log10(value/(double)10000);
//            return df2.format(b);
//        } else {
//            double b = value/(double)1000;
//            return df2.format(b);
//        }
    }

}
