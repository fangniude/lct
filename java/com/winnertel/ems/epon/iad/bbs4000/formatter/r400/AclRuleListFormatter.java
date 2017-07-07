/**
 * Created by Zhou Chao, 2010/4/16
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AclRuleListFormatter extends SnmpFieldFormatter {

    public AclRuleListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (data != null && data.length > 0) {
                StringBuffer buf = new StringBuffer();
                for (int i = 0; i < data.length; i++) {
                    int n = 0x80;
                    for (int j = 0; j < 8; j++) {
                        if ((data[i] & n) != 0)
                            buf.append(i * 8 + j + 1).append(",");
                        n = n >> 1;
                    }
                }
                if (buf.length() > 0)
                    buf.deleteCharAt(buf.length() - 1);

                return buf;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}