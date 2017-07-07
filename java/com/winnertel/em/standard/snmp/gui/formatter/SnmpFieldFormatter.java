package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public abstract class SnmpFieldFormatter {
    protected IApplication fApplication = null;


    public SnmpFieldFormatter(IApplication anApplication) {
        fApplication = anApplication;
    }


    public abstract Object format(SnmpMibBean aMibBean, String aProperty) throws Exception;
}
