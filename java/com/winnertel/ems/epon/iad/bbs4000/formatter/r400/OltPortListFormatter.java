package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-7
 * Time: 6:36:36
 */
public class OltPortListFormatter extends SnmpFieldFormatter {

    public OltPortListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < value.length/4; i++) {
            sb.append(value[i*4]).append("/").append(value[i*4+1]).append("/").append(value[i*4+2]).append(" ");
        }

        return sb.toString().trim();
    }
}

