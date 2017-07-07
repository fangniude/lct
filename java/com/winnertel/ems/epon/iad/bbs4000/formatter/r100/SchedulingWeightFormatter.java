/**
 * Created by Zhou Chao, 2009/2/21
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class SchedulingWeightFormatter extends SnmpFieldFormatter {

    public SchedulingWeightFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object objStr = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        byte[] value = null;
        if (objStr instanceof byte[])
            value = (byte[]) objStr;
        else if (objStr instanceof char[]) {
            value = new byte[((char[]) objStr).length];
            for (int i = 0; i < ((char[]) objStr).length; i++)
                value[i] = (byte) ((char[]) objStr)[i];
        } else if (objStr instanceof String)
            return format((String) objStr);

        return (value != null && value.length != 6 ? format(value) : null);
    }

    public static String format(byte[] value) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            byte b = value[i];
            if (b >= 0 && b < 16)
                sb.append('0');
            int bi = value[i] & 0xff;
            //sb.append(Integer.toHexString(bi).toUpperCase());
            sb.append(bi);
            if (i < value.length - 1)
                sb.append("|");
        }

        return sb.toString();
    }

    public static String format(String s) {
        StringBuffer sb = new StringBuffer();
        if (s != null) {
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length; j++) {
                int n = (int) c[j];
                //String str = Integer.toHexString(n).toUpperCase();
                String str = "" + n;
                if (str.length() == 1)
                    sb.append("0");
                sb.append(str).append("|");
            }
            if (sb.length() > 1)
                sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

}