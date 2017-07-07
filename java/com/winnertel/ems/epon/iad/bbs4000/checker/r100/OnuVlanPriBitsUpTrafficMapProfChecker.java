package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanPriBitsUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuVlanPriBitsUpTrafficMapProfChecker extends BaseChecker {

	public OnuVlanPriBitsUpTrafficMapProfChecker(IApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuVlanPriBitsUpTrafficMapProfTable mbean = (OnuVlanPriBitsUpTrafficMapProfTable) selectedMibBeans[0];

		    if(mbean.getOnuVlanPriBitsUpTrafficMapProfIndex1() != null && mbean.getOnuVlanPriBitsUpTrafficMapProfIndex1()==1&&mbean.getOnuVlanPriBitsUpTrafficMapProfIndex2() != null && mbean.getOnuVlanPriBitsUpTrafficMapProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
