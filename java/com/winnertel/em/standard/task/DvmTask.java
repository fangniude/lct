package com.winnertel.em.standard.task;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.task.Task;

public abstract class DvmTask extends Task {
    protected IApplication fApplication = null;

    protected IDeviceManager fDeviceManager = null;


    public DvmTask(IApplication anApplication, IDeviceManager aDeviceManager) {
        fApplication = anApplication;
        fDeviceManager = aDeviceManager;
    }
}
