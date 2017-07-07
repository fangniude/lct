package com.winnertel.em.framework.util.log;

public class LoggerController {
    private static ILoggerFactory fFactory = new Log4jLoggerFactory();

    public static void registerLoggerFactory(ILoggerFactory factory) {
        fFactory = factory != null ? factory : new Log4jLoggerFactory();
    }

    public static ILogger createLogger(Class clazz) {
        return fFactory.createLogger(clazz);
    }

    public static void shutdown() {
        fFactory.shutdown();
    }
}
