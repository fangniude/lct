package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;

public abstract class SnmpTask extends Task {
    private SnmpMibBean fMibBean = null;


    public SnmpTask(SnmpMibBean aMibBean) {
        fMibBean = aMibBean;
    }


    public SnmpMibBean getMibBean() {
        return fMibBean;
    }
}
