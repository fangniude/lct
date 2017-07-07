package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03842
 * Date: 2006-7-14
 * Time: 15:12:14
 * To change this template use File | Settings | File Templates.
 */
public class PasswordFormatter extends SnmpFieldFormatter {

    public PasswordFormatter(IApplication anApplication)
    {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception
    {
        return "******";
    }
}
