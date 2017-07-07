/**
 * Created by Zhou Chao, 2010/5/27
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class BaseQosPolicyWeightOctetFormatter extends SnmpFieldFormatter {

    public BaseQosPolicyWeightOctetFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (data != null && data.length > 0) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < data.length; i++) {
                    if (i != 0)
                        sb.append("|");
                    sb.append(((int) data[i]) & 0xFF);
                }

                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}