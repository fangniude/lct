package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

public class OlsFormatter extends SnmpFieldFormatter {
    public OlsFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        
        double temp = ((Integer)MibBeanUtil.getSimpleProperty(aMibBean, aProperty))*0.1;
        DecimalFormat format = new DecimalFormat("0.000");
        
        return format.format(temp);
       
    }
}
