package com.winnertel.em.framework.task;

public abstract class Task {
    public static final byte INITAL = 0;
    public static final byte RUNNING = 1;
    public static final byte COMPLETED = 2;
    public static final byte CANCELED = 3;
    public static final byte FAILED = 4;

    private byte fStatus = INITAL;


    public abstract Object execute() throws Exception;

    /**
     * added 2 features by Rex.zhu at 2004-01-13
     * 1. determine the task can be canceled
     * 2. provide the alterablity of the wating prompt
     */
    private boolean fCancelable = true;

    public boolean isCancelable() {
        return fCancelable;
    }

    public void setCancelable(boolean cancelable) {
        fCancelable = cancelable;
    }


    private String fWaitPrompt = null;

    public String getWaitPrompt() {
        return fWaitPrompt;
    }

    public void setWaitPrompt(String newPrompt) {
        fWaitPrompt = newPrompt;
    }
    //end new feature implementation by Rex.zhu at 2004-01-13


    public byte getStatus() {
        return fStatus;
    }

    public void setStatus(byte aStatus) {
        fStatus = aStatus;
    }


    public void reset() {
        setWaitPrompt(null);
        setStatus(Task.INITAL);
    }
}
