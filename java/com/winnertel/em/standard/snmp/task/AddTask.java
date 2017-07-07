package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class AddTask extends SnmpTask {
    public AddTask(SnmpMibBean aMibBean) {
        super(aMibBean);
    }


    public Object execute() throws Exception {
        return getMibBean().add() ? Boolean.TRUE : Boolean.FALSE;
    }
}
