package com.winnertel.em.framework.util;

public class OperationFailedException extends BaseException {
    public OperationFailedException(String aMessage) {
        super(aMessage);
    }

    public OperationFailedException(String aMessage, Throwable aWrapee) {
        super(aMessage, aWrapee);
    }
}
