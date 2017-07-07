package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class MinuteToDayFomatter extends SnmpFieldFormatter {
    DvmStringMap fStringMap = null;

    public MinuteToDayFomatter(IApplication anApplication) {
        super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        Long value = null;
        try {
            value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        } catch (Exception ex) {
            value = new Long(((Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty)).intValue());
        }

        if (value == null)
            return null;
        String time = "";
        long days = value.longValue() / (60 * 24);
        if (days != 0) {
            time = time + days + fStringMap.getString("days") + ",";
        }
        long hours = (value.longValue() - days * (60 * 24)) / (60);
        time = time + hours + fStringMap.getString("hours") + ",";
        long minutes = (value.longValue() - days * (60 * 24) - hours * 60);
        time = time + minutes + fStringMap.getString("minutes");

        return time;
    }
}
