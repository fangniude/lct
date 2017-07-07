package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.ems.epon.snmp.SnmpUtility;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-7
 * Time: 10:13:25
 * To change this template use File | Settings | File Templates.
 */
public class DHCPPoolNameFormatter  extends SnmpFieldFormatter {

    public DHCPPoolNameFormatter(IApplication anApplication)
    {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception
    {
        String value = (String) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        return SnmpUtility.generateStringIndex(value);
    }
}
