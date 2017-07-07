package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03842
 * Date: 2007-4-9
 * Time: 20:47:15
 * To change this template use File | Settings | File Templates.
 */
public class HexFormatter  extends SnmpFieldFormatter {
    public HexFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try{
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return "0x" + Integer.toHexString(value.intValue()).toUpperCase();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
