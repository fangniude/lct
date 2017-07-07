package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: GYF
 * Date: 2010-8-4
 * Time: 16:12:36
 * To change this template use File | Settings | File Templates.
 */
public class EocTpidFormatter extends SnmpFieldFormatter {
    public EocTpidFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

            if (value == null) return null;

            StringBuffer sb = new StringBuffer("0x");

            //for(int i = 0; i < value.length; i++) {
            String s = Integer.toHexString(value.intValue());

            if (s.length() < 2) sb.append("0");

            sb.append(s);
            //}

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
