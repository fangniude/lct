package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuMacFilterPreassignProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuMacFilterPreassignProChecker extends BaseChecker {

	public OnuMacFilterPreassignProChecker(IApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuMacFilterPreassignProTable mbean = (OnuMacFilterPreassignProTable) selectedMibBeans[0];

		    if(mbean.getOnuMacFilterPreassignProfileIndex() != null && mbean.getOnuMacFilterPreassignProfileIndex()==1) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
