package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class BytesFormatter extends SnmpFieldFormatter {
    //    DvmStringMap fStringMap = null;
    public BytesFormatter(IApplication anApplication) {
        super(anApplication);
//        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        StringBuffer sb = new StringBuffer();

        if (value != null) {
            for (int i = 0; i < value.length - 1; i++) {
                sb.append(new Integer((int) value[i]));
                sb.append(".");
            }
            sb.append(new Integer((int) value[value.length - 1]));
            return sb.toString();
        } else
            return null;
    }
}


