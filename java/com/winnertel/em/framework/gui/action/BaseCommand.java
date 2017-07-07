package com.winnertel.em.framework.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.util.BaseException;

public abstract class BaseCommand implements ICommand {
    protected IApplication fApplication = null;


    public BaseCommand(IApplication aApplication) {
        fApplication = aApplication;
    }


    public abstract boolean execute() throws BaseException;
}

