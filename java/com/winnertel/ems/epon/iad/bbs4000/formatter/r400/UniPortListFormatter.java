package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-3
 * Time: 9:33:16
 * To change this template use File | Settings | File Templates.
 */
public class UniPortListFormatter extends SnmpFieldFormatter {

    public UniPortListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < value.length/2; i++) {
            if(value[i*2+1] > 0) {
                sb.append(value[i*2]).append("/").append(value[i*2+1]);

                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}

