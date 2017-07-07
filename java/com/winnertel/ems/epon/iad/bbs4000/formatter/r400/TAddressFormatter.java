/**
 * Created by Zhou Chao, 2010/6/29
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class TAddressFormatter extends SnmpFieldFormatter {

    public TAddressFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (value == null || value.length < 8)
            return null;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 4; i++) {
            int bi = value[i] & 0xff;
            sb.append(bi);
            if (i < 3) {
                sb.append(".");
            }
        }
        int n = 0;
        for (int i = 4; i < 8; i++) {
            int bi = value[i] & 0xff;
            n += bi;
        }
        if (n > 0) {
            sb.append(":");
            sb.append(String.valueOf(n));
        }

        return sb.toString().trim();
    }

}