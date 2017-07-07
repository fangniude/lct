/**
 * Created by Zhou Chao, 2010/5/27
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class BaseQosPolicySpBandwidthRangeFormatter extends SnmpFieldFormatter {

    public BaseQosPolicySpBandwidthRangeFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (data != null && data.length > 0) {
                StringBuffer sb = new StringBuffer();
                if (data.length % 4 == 0) {
                    byte[] result = new byte[data.length / 4];
                    for (int i = 0; i < result.length; i++) {
                        byte[] value = new byte[4];
                        System.arraycopy(data, i * 4, value, 0, 4);
                        int n = 0;
                        for (int j = 0; j < value.length; j++)
                            n += (((int) value[j]) & 0xFF) << (8 * (value.length - 1 - j));
                        if (i != 0)
                            sb.append("|");
                        sb.append(n);
                    }
                } else {
                    sb.append("0");
                }

                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}