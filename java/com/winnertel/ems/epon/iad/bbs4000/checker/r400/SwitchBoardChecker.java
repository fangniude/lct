package com.winnertel.ems.epon.iad.bbs4000.checker.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class SwitchBoardChecker extends BaseChecker {

	private IApplication fApplication;
	public SwitchBoardChecker(IApplication app) {
		super(app);
		fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {

	    BoardTable board = (BoardTable)selectedMibBeans[0];

        if(board.getType() == null || board.getType() != 1)//
        {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Switch_Over_Not_CSM");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }
        
        if(board.getAttribute() == null || (board.getAttribute() != 1 && board.getAttribute() != 2))//
        {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Switch_Over_Not_Active_Standby");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }

        return true;
    }

}
