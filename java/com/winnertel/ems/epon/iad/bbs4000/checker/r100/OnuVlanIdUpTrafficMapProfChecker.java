package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuVlanIdUpTrafficMapProfChecker extends BaseChecker{
	
	public OnuVlanIdUpTrafficMapProfChecker(IApplication app){
		super(app);
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuVlanIdUpTrafficMapProfTable mbean = (OnuVlanIdUpTrafficMapProfTable) selectedMibBeans[0];

		    if(mbean.getOnuVlanIdUpTrafficMapProfIndex1()!= null && mbean.getOnuVlanIdUpTrafficMapProfIndex1()==1&&mbean.getOnuVlanIdUpTrafficMapProfIndex2()!= null && mbean.getOnuVlanIdUpTrafficMapProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
