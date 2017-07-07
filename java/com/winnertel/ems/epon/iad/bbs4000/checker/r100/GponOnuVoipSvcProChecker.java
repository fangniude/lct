package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipSvcProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class GponOnuVoipSvcProChecker extends BaseChecker{
	
	public GponOnuVoipSvcProChecker(IApplication app){
		super(app);
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		String error = "";
		GponOnuVoipSvcProTable mbean = (GponOnuVoipSvcProTable) selectedMibBeans[0];

		    if(mbean.getOnuVoipSvcProfileIndex() != null && mbean.getOnuVoipSvcProfileIndex()==1) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }

		    return true;
		  }

}
