package com.winnertel.ems.epon.iad.bbs4000.checker.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PONProtectionMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class SwitchPonProtectionChecker extends BaseChecker
{
	IApplication fApplication;
	public SwitchPonProtectionChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans)
	{
		PONProtectionMBean mbean = (PONProtectionMBean) selectedMibBeans[0];

    if(mbean.getUtsPonTrunckProtectionRowStatus() == 2)
    {
      String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Pon_Is_Not_Protected");
			MessageDialog.showInfoMessageDialog( fApplication, error );
   		return false;
		}

    return true;
	}
}
