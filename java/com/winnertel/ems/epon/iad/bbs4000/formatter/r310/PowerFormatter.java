package com.winnertel.ems.epon.iad.bbs4000.formatter.r310;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

/**
 * This file is used for Power option which unit is 0.1uW.
 * @author hz03696
 *
 */
public class PowerFormatter extends SnmpFieldFormatter {

    public PowerFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);
        
        if(value == null) return "0";
        
        Double powValue = 10 * java.lang.Math
				.log10(value / 10000.0);
        
        if (Double.isInfinite(powValue) || Double.isNaN(powValue))
			return 0D;

        DecimalFormat df2  = new DecimalFormat("##0.00");
        return df2.format(powValue);
    }
}

