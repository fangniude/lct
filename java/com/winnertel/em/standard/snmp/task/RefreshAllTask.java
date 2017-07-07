package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;

public class RefreshAllTask extends Task {
    private SnmpMibBean fMibBean = null;


    public RefreshAllTask(SnmpMibBean aMibBean) {
        fMibBean = aMibBean;
    }


    public Object execute() throws Exception {
        return fMibBean.retrieveAll();
    }
}
