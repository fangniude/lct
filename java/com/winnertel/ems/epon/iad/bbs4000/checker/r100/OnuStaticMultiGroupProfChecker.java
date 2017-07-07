package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuStaticMultiGroupProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class OnuStaticMultiGroupProfChecker extends BaseChecker {

	public OnuStaticMultiGroupProfChecker(IApplication app) {
		super(app);
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		OnuStaticMultiGroupProfTable mbean = (OnuStaticMultiGroupProfTable) selectedMibBeans[0];

		    if(mbean.getOnuStaticMultiGroupProfIndex1() != null && mbean.getOnuStaticMultiGroupProfIndex1()==1&&mbean.getOnuStaticMultiGroupProfIndex2() != null && mbean.getOnuStaticMultiGroupProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }
		    return true;
	}

}
