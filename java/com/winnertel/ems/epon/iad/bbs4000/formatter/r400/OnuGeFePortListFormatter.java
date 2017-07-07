package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuGeFePortListFormatter extends SnmpFieldFormatter {

    public OnuGeFePortListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        //fixed slot.
        if((value[0] & 0xFF) == 0xFF) {
            for(int i = 1; i < value.length; i++) {
                int mask = 0x80;
                for(int j = 0; j < 8; j++) {
                    if((value[i] & mask) != 0) {
                        sb.append((i-1) * 8 + j + 1).append(" ");
                    }
                    mask = mask >> 1;
                }
            }
        } else {
            for(int i = 0; i < value.length/9; i++) {
                for(int j = 1; j < 9; j++) {
                    int mask = 0x80;
                    for(int k = 0; k < 8; k++) {
                        if((value[i*9+j] & mask) != 0) {
                            sb.append(value[i*9]).append("/").append((j-1)*8 + k).append(" ");
                        }
                        mask = mask >> 1;
                    }
                }
            }
        }

        return sb.toString().trim();
    }
}

