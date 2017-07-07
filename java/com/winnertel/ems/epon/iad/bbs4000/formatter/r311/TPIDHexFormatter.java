package com.winnertel.ems.epon.iad.bbs4000.formatter.r311;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class TPIDHexFormatter extends SnmpFieldFormatter {

    public TPIDHexFormatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return ((value.intValue() == 0 || value.intValue() == 65535) ? fApplication.getActiveDeviceManager().getGuiComposer().getString("adpot default value") 
            		: "0x" + Integer.toHexString(value.intValue()).toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
