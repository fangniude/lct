package com.winnertel.em.framework.util;

public class OperationCanceledException extends BaseException {
    public OperationCanceledException(String aMessage) {
        super(aMessage);
    }

    public OperationCanceledException(String aMessage, Throwable aWrapee) {
        super(aMessage, aWrapee);
    }
}
