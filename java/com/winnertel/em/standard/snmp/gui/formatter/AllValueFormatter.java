package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class AllValueFormatter extends SnmpFieldFormatter {
    DvmStringMap fStringMap = null;

    public AllValueFormatter(IApplication anApplication) {
        super(anApplication);
    } // BridgeIdFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());

        Object value = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();

        if (value instanceof Integer) {
            Integer intValue;
            intValue = (Integer) value;
            if (intValue.intValue() == 0) {
                result.append(fStringMap.getString("All"));
            } else {
                result.append(intValue);
            }
        } else if (value instanceof Long) {
            Long longValue;
            longValue = (Long) value;
            if (longValue.intValue() == 0) {
                result.append(fStringMap.getString("All"));
            } else {
                result.append(longValue);
            }
        }
        return result.toString();
    }
} // BridgeIdFormatter
