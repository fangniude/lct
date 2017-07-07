package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AlarmStatusFormatter extends SnmpFieldFormatter {

    public AlarmStatusFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null || value.length < 1) return null;

        StringBuffer sb = new StringBuffer();
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        if((value[0] & 0x80) != 0) {
            sb.append(composer.getString("critical")).append(" ") ;
        }

        if((value[0] & 0x40) != 0) {
            sb.append(composer.getString("major")).append(" ") ;
        }

        if((value[0] & 0x20) != 0) {
            sb.append(composer.getString("minor")).append(" ") ;
        }

        if((value[0] & 0x10) != 0) {
            sb.append(composer.getString("warning")).append(" ") ;
        }

        if(sb.length() == 0) {
            return composer.getString("none");
        }
        
        return sb.toString().trim();
    }
}

