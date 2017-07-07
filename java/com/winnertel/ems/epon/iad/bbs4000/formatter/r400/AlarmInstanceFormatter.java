package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 7:00:26
 */
public class AlarmInstanceFormatter  extends SnmpFieldFormatter {

    public AlarmInstanceFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[])MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (value == null)
            return null;

        StringBuffer sb = new StringBuffer();

        int index = 0;

        if (value[1] == 0x3F)
            return "trunk" + value[2];

        if (value[0] > 0) {
            sb.append(value[0]);
        }

        if(value[1] != 0) {
            sb.append("/").append(value[1]);

            if(value[2] != 0) {
                sb.append("/").append(value[2]);

                if (value[4] != 0) {
                    sb.append("/").append(value[3]).append("/").append(value[4]);
                }
            }
        }

        return sb.toString();
    }

}