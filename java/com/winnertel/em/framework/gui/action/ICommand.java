package com.winnertel.em.framework.gui.action;

import com.winnertel.em.framework.util.BaseException;

public interface ICommand {
    public boolean execute() throws BaseException;
}
