package com.winnertel.em.framework.util.log;

import org.apache.log4j.*;

public class Log4jLoggerFactory implements ILoggerFactory {
    public Log4jLoggerFactory() {
        this(true);
    }

    public Log4jLoggerFactory(boolean doBasicConfig) {
        super();
        if (doBasicConfig) {
            Appender tAppender = new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
            Logger tLogger = LogManager.getLoggerRepository().getRootLogger();
            tLogger.addAppender(tAppender);
            tLogger.setLevel(Level.INFO);
        }
    }

    public ILogger createLogger(Class clazz) {
        return new Log4jLogger(clazz);
    }

    public void shutdown() {
        LogManager.shutdown();
    }
}
