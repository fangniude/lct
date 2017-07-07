package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMacFilterProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class GponOnuMacFilterProfChecker extends BaseChecker{
	
	public GponOnuMacFilterProfChecker(IApplication app){
		super(app);
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		 String error = "";
		 GponOnuMacFilterProfTable mbean = (GponOnuMacFilterProfTable) selectedMibBeans[0];

		    if(mbean.getOnuMacFilterProfIndex1() != null && mbean.getOnuMacFilterProfIndex1()==1&&mbean.getOnuMacFilterProfIndex2()!=null&&mbean.getOnuMacFilterProfIndex2()==0) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }

		    return true;
		  }
}
