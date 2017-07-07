package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public abstract class SnmpTableFilter {
    /**
     * Determine whether a row(mib bean) is visible in table.
     *
     * @param aMibBean the bean to filter
     * @return true if the mib bean is filtered out, false otherwise
     */
    public abstract boolean filter(SnmpMibBean aMibBean);
}
