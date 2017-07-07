package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdVlanPriBitUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuVlanIdVlanPriBitUpTrafficMapProfChecker extends BaseChecker {

	public OnuVlanIdVlanPriBitUpTrafficMapProfChecker(IApplication app) {
		super(app);
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuVlanIdVlanPriBitUpTrafficMapProfTable mbean = (OnuVlanIdVlanPriBitUpTrafficMapProfTable) selectedMibBeans[0];

		    if(mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex1() != null && mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex1()==1&&mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex2() != null && mbean.getOnuVlanIdVlanPriBitUpTrafficMapProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
