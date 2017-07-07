package com.winnertel.em.framework.task;

public interface ITaskManager {

    public Object executeTask(Task aTask) throws Exception;

    public Object executeTaskInBackground(Task aTask) throws Exception;

}
