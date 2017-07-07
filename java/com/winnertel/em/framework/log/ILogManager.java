package com.winnertel.em.framework.log;

import com.winnertel.em.framework.gui.ILogable;

public interface ILogManager extends ILogable {

    public ILogInfo getLogInfo();

    public ILogInfo getLogInfo(String aLogId);

}
