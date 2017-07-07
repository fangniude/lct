package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class HexLongFormatter  extends SnmpFieldFormatter {
    public HexLongFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try{
            Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return "0x" + Long.toHexString(value.longValue()).toUpperCase();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
