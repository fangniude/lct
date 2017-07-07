package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class PaePortCapabilitiesFormatter extends SnmpFieldFormatter {
    public PaePortCapabilitiesFormatter(IApplication anApplication) {
        super(anApplication);
    } // PaePortCapabilitiesFormatter


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        String value = (String) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null) {
            return null;
        }
        byte[] bytes = value.getBytes();

        StringBuffer sb = new StringBuffer();
        if (bytes[0] == 0) sb.append("Authenticator");
        else sb.append("Supplicant");
        return sb.toString();
    } // format
} // PaePortCapabilitiesFormatter
