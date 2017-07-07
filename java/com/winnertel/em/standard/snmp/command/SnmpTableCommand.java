package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseCommand;
import com.winnertel.em.framework.util.BaseException;
import com.winnertel.em.standard.snmp.gui.SnmpTable;

public abstract class SnmpTableCommand extends BaseCommand {
    protected SnmpTable fTable = null;


    public SnmpTableCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication);
        fTable = aTable;
    }


    public boolean execute() throws BaseException {
        return false;
    }
}
