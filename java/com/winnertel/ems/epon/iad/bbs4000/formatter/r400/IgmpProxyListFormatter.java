package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-7
 * Time: 7:05:50
 */
public class IgmpProxyListFormatter extends SnmpFieldFormatter {

    public IgmpProxyListFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] obj = (byte[])MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null)
            return null;

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < obj.length; i++) {
            for(int j = 0; j < 8; j++) {
                if((obj[i] & (0x80>>j)) != 0) {
                    sb.append(i*8 + j + 1).append(",");
                }
            }
        }

        if(sb.length() > 0) {
            return sb.substring(0, sb.length()-1);
        }
        return sb.toString();
    }

}