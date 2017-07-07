package com.winnertel.ems.epon.iad.bbs4000.checker.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltGponProtocolProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;


public class OltGponProtocolProfChecker extends BaseChecker{
	
	public OltGponProtocolProfChecker(IApplication app){
		super(app);
	}
	
	 public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		 if(selectedMibBeans==null||selectedMibBeans.length==0)return true;
		    String error = "";
		    OltGponProtocolProfTable mbean = (OltGponProtocolProfTable) selectedMibBeans[0];

		    if(mbean.getOltGponProtocolProfProtocolPofileIndex() != null && mbean.getOltGponProtocolProfProtocolPofileIndex()==1) {
		      error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Set_Default_Profile");
		      MessageDialog.showErrorMessageDialog(getApplication(), error);
		      return false;
		    }

		    return true;
		  }
}
