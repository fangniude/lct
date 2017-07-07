package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class StringIndexFormatter extends SnmpFieldFormatter {
    //    DvmStringMap fStringMap = null;
    public StringIndexFormatter(IApplication anApplication) {
        super(anApplication);
//        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (value == null) {
            return null;
        }

        String str = new String(value);
        //changed for not trim blank char.
        //for test
//        byte[] test = new byte[20];
//        for(int j=0; j<20; j++) {
//            test[j] = 0;
//        }
//        test[0] = ' ';
//        test[1] = ' ';
//        test[2] = 'a';
//        test[3] = 'b';
//        test[4] = ' ';
//        test[5] = ' ';
//        test[6] = '4';
//        test[7] = '6';
//
//        str = new String(test);

        byte[] strByte = str.getBytes();
        if (strByte != null) {
            if (strByte.length != 0) {
                int i = strByte.length - 1;
                for (; i >= 0; i--) {
                    if (strByte[i] != (byte) 0) {
                        break;
                    }
                }
                if (i == -1) {
                    str = "";
                } else if (i > 0) {
                    str = str.substring(0, i + 1);
                }
            }
        }

        return str;
    }
}


