package com.winnertel.em.standard.task;

import com.winnertel.em.framework.task.ITaskInfo;

public class TaskInfo implements ITaskInfo {
    private String fId = null;

    private String fTaskClass = null;


    public TaskInfo(String aId, String aTaskClass) {
        fId = aId;
        fTaskClass = aTaskClass;
    }


    public String getId() {
        return fId;
    }


    public String getTaskClass() {
        return fTaskClass;
    }
}
