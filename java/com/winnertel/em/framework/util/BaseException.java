package com.winnertel.em.framework.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class BaseException extends Exception {
    // If this exception is wrapped around another it is stored here.
    private Throwable fWrapee;

    /**
     * Default ctor. Creates an exception with an empty string ("")
     * as its message.
     */
    public BaseException() {
        this("");
    }

    /**
     * Ctor specifying the message.
     *
     * @param msg The message.
     */
    public BaseException(String msg) {
        super(msg != null ? msg : "");
    }

    /**
     * Ctor specifying an exception that this one should
     * be wrapped around.
     *
     * @param aWrapee The wrapped exception.
     */
    public BaseException(Throwable aWrapee) {
        super(getMessageFromException(aWrapee));
        fWrapee = aWrapee;
    }


    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }


    public String toString() {
        if (fWrapee != null) {
            return fWrapee.toString();
        }
        return super.toString();
    }

    public void printStackTrace() {
        if (fWrapee != null) {
            fWrapee.printStackTrace();
        } else {
            super.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream aOutputStream) {
        if (fWrapee != null) {
            fWrapee.printStackTrace(aOutputStream);
        } else {
            super.printStackTrace(aOutputStream);
        }
    }

    public void printStackTrace(PrintWriter aWriter) {
        if (fWrapee != null) {
            fWrapee.printStackTrace(aWriter);
        } else {
            super.printStackTrace(aWriter);
        }
    }

    private static String getMessageFromException(Throwable aThrowable) {
        String result = "";
        if (aThrowable != null) {
            String msg = aThrowable.getMessage();
            if (msg != null) {
                result = msg;
            }
        }
        return result;
    }
}
