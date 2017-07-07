package com.winnertel.em.standard.snmp.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import org.apache.commons.collections.SequencedHashMap;

public abstract class MibBeanIdFormatter {
    protected String fPattern;
    protected IApplication fApplication;


    protected MibBeanIdFormatter(IApplication aApplication, String aPattern) {
        fApplication = aApplication;
        fPattern = aPattern;
    }


    public abstract OperationObject format(SnmpMibBean aMibBean, SequencedHashMap aRowData);
}
