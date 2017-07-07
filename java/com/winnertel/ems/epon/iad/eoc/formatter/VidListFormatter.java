package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-7-12
 * Time: 18:23:08
 * To change this template use File | Settings | File Templates.
 */
public class VidListFormatter extends SnmpFieldFormatter {

    public VidListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null) return null;

        byte[] tmpObj = (byte[]) obj;

        StringBuffer sb = new StringBuffer();

        int portIdx = 0;
        for (int i = 0; i < tmpObj.length; i = i + 1) {

            for (int j = 0; j < 8; j++) {

                if ((tmpObj[i] & (0x80 >> j)) == (0x80 >> j)) {
                    sb.append(portIdx);
                    sb.append(" ");
                }

                portIdx = portIdx + 1;
            }
        }

        return sb.toString();
    }
}
