/**
 * Modified by Zhou Chao
 */

package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class BytesToStringFormatter extends SnmpFieldFormatter {

    public BytesToStringFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (MibBeanUtil.getSimpleProperty(aMibBean, aProperty) instanceof String) {
            String value = (String) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return (value != null ? (new String(value)).trim() : new String(""));
        } else {
            byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return (value != null ? (new String(value)).trim() : new String(""));
        }
    }

}