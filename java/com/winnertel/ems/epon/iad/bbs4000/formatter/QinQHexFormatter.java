/**
 * Created by Zhou Chao, 2008/10/17
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class QinQHexFormatter extends SnmpFieldFormatter {

    public QinQHexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (value == null || value == 0 || (value == 0xffff))
                return fApplication.getActiveDeviceManager().getGuiComposer().getString("No Limited");
            return "0x" + Integer.toHexString(value).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}