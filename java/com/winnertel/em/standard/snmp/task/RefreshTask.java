package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;

public class RefreshTask extends Task {
    private SnmpMibBean fMibBean = null;


    public RefreshTask(SnmpMibBean aMibBean) {
        fMibBean = aMibBean;
    }


    public Object execute() throws Exception {
        fMibBean.retrieve();
        return null;
    }
}
