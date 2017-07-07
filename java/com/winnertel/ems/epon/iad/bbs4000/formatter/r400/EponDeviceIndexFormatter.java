package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class EponDeviceIndexFormatter extends SnmpFieldFormatter {

    public EponDeviceIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null)
            return null;

        int index = 0;
        if (obj instanceof Long) {
            index = ((Long) obj).intValue();
        } else {
            index = ((Integer) obj).intValue();
        }

        return format(index);
    }

    public static String format(int index) {
        StringBuffer sb = new StringBuffer();
        if (index == 0){
            return "0";                                                                                             
        }
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = index & 0xFF;
            index = index >> 8;
        }

        if (array[1] == 0x3F)
            return "trunk" + array[2];

        if (array[0] > 0) {
            sb.append(array[0]);
        }

        if(array[1] != 0) {
            sb.append("/").append(array[1]);

            if(array[2] != 0) {
                sb.append("/").append(array[2]);

                if (array[3] != 0) {
                    sb.append("/").append(array[3]);
                }
            }
        }

        return sb.toString();
    }

}