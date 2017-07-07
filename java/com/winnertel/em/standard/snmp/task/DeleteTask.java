package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class DeleteTask extends SnmpTask {
    public DeleteTask(SnmpMibBean aMibBean) {
        super(aMibBean);
    }


    public Object execute() throws Exception {
        return getMibBean().delete() ? Boolean.TRUE : Boolean.FALSE;
    }
}
