package com.winnertel.ems.epon.iad.bbs4000.checker.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PowerPropertyTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class SwitchPowerChecker extends BaseChecker {

	private IApplication fApplication;
	public SwitchPowerChecker(IApplication app) {
		super(app);
		fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {

	    PowerPropertyTable board = (PowerPropertyTable)selectedMibBeans[0];

        if(board.getPowerCardRedundancyStatus() == null || (board.getPowerCardRedundancyStatus() != 1 && board.getPowerCardRedundancyStatus() != 2))//
        {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Switch_Over_Not_Active_Standby");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }

        return true;
    }

}
