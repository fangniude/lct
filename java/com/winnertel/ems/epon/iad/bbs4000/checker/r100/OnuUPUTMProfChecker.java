package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPUTMProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuUPUTMProfChecker extends BaseChecker {

	public OnuUPUTMProfChecker(IApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuUPUTMProfTable mbean = (OnuUPUTMProfTable) selectedMibBeans[0];

		    if(mbean.getOnuUsrPortUpTrafficMapProfIndex1() != null && mbean.getOnuUsrPortUpTrafficMapProfIndex1()==1&&mbean.getOnuUsrPortUpTrafficMapProfIndex2() != null && mbean.getOnuUsrPortUpTrafficMapProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
