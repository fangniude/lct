package com.winnertel.em.framework.util.log;

public interface ILogger {
    public void debug(Object message);

    public void debug(Object message, Throwable th);

    public void info(Object message);

    public void info(Object message, Throwable th);

    public void warn(Object message);

    public void warn(Object message, Throwable th);

    public void error(Object message);

    public void error(Object message, Throwable th);

    boolean isDebugEnabled();

    boolean isInfoEnabled();
}
