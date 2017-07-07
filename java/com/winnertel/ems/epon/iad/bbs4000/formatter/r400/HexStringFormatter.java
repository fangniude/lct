/**
 * Created by Zhou Chao, 2010/4/15
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class HexStringFormatter extends SnmpFieldFormatter {

    public HexStringFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (data != null && data.length > 0) {
                String value = "";
                for (int i = 0; i < data.length; i++) {
                    if (i != 0)
                        value += " ";
                    value += "0x";
                    if ((0xFF & data[i]) < 16)
                        value += "0";
                    value += Integer.toHexString(0xFF & data[i]).toUpperCase();
                }

                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}