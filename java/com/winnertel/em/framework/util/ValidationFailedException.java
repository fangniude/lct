package com.winnertel.em.framework.util;

public class ValidationFailedException extends BaseException {
    public ValidationFailedException(String msg) {
        super(msg);
    }

    public ValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
