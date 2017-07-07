/**
 * Created by Zhou Chao, 2009/6/19
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class AcuExternalAlarmDescriptionFormatter extends SnmpFieldFormatter {

    public AcuExternalAlarmDescriptionFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            return ((value != null) ? (new String(value)) : "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}