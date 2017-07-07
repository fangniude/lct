package com.winnertel.em.framework.util.log;

import org.apache.log4j.Logger;

public class Log4jLogger implements ILogger {
    /**
     * Log4j logger to log to.
     */
    private Logger fLogger;

    /**
     * Ctor specifying the object requesting the logger. A
     * Log4J <TT>Logger</TT> is created using as a name the
     * fully qualified class of <TT>requester</TT>.
     *
     * @param    clazz    The class requesting a logger.
     * @throws IllegalArgumentException Thrown if <TT>clazz</TT> is <TT>null</TT>.
     */
    public Log4jLogger(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Empty requesterClass passed");
        }

        fLogger = Logger.getLogger(clazz);
    }

    /**
     * @see ILogger#debug(Object)
     */
    public void debug(Object message) {
        fLogger.debug(message);
    }

    /**
     * @see ILogger#debug(Object, Throwable)
     */
    public void debug(Object message, Throwable th) {
        fLogger.debug(message, th);
    }

    /**
     * @see ILogger#info(Object)
     */
    public void info(Object message) {
        fLogger.info(message);
    }

    /**
     * @see ILogger#info(Object, Throwable)
     */
    public void info(Object message, Throwable th) {
        fLogger.info(message, th);
    }

    /**
     * @see ILogger#warn(Object)
     */
    public void warn(Object message) {
        fLogger.warn(message);
    }

    /**
     * @see ILogger#warn(Object, Throwable)
     */
    public void warn(Object message, Throwable th) {
        fLogger.warn(message, th);
    }

    /**
     * @see ILogger#error(Object)
     */
    public void error(Object message) {
        fLogger.error(message);
    }

    /**
     * @see ILogger#error(Object, Throwable)
     */
    public void error(Object message, Throwable th) {
        fLogger.error(message, th);
    }

    /**
     * @see ILogger#isDebugEnabled()
     */
    public boolean isDebugEnabled() {
        return fLogger.isDebugEnabled();
    }

    /**
     * @see ILogger#isInfoEnabled()
     */
    public boolean isInfoEnabled() {
        return fLogger.isInfoEnabled();
    }
}
