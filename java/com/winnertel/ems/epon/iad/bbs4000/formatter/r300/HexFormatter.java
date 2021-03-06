/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class HexFormatter extends SnmpFieldFormatter {

    public HexFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return ((value.intValue() == 0 || value.intValue() == 65535) ? " " : "0x" + Integer.toHexString(value.intValue()).toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}