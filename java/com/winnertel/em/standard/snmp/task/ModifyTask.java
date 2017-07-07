package com.winnertel.em.standard.snmp.task;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;


public class ModifyTask extends SnmpTask {
    public ModifyTask(SnmpMibBean aMibBean) {
        super(aMibBean);
    }


    public Object execute() throws Exception {
        return getMibBean().modify() ? Boolean.TRUE : Boolean.FALSE;
    }
}
