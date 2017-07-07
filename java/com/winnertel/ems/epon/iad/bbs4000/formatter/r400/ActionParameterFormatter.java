package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-5
 * Time: 14:42:18
 */
public class ActionParameterFormatter extends SnmpFieldFormatter {

    public ActionParameterFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (data != null && data.length > 0) {
                switch(data[0]) {
                    case 0x01:
                        return "801.1p";
                    case 0x02:
                        return "VLAN ID";
                    case 0x03:
                        return "TOS PRECEDENCE";
                    case 0x04:
                        return "DSCP";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}