package com.winnertel.em.framework.util.log;

public interface ILoggerFactory {
    ILogger createLogger(Class clazz);

    void shutdown();
}
