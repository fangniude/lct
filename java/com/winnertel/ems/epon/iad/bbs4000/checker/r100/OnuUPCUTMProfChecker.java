package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPCUTMProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuUPCUTMProfChecker extends BaseChecker {

	public OnuUPCUTMProfChecker(IApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuUPCUTMProfTable mbean = (OnuUPCUTMProfTable) selectedMibBeans[0];

		    if(mbean.getOnuUsrPortCoSUpTrafficMapProfIndex1() != null && mbean.getOnuUsrPortCoSUpTrafficMapProfIndex1()==1&&mbean.getOnuUsrPortCoSUpTrafficMapProfIndex2() != null && mbean.getOnuUsrPortCoSUpTrafficMapProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
