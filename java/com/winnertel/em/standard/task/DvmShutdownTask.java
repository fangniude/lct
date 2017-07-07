package com.winnertel.em.standard.task;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;

public abstract class DvmShutdownTask extends DvmTask {

    public DvmShutdownTask(IApplication anApplication, IDeviceManager aDeviceManager) {
        super(anApplication, aDeviceManager);
    }

}
