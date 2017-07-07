package com.winnertel.em.framework.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public abstract class BaseChecker {

    protected IApplication fApplication = null;

    public BaseChecker(IApplication app) {
        fApplication = app;
    }

    protected IApplication getApplication() {
        return fApplication;
    }

    public abstract boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans);
}
