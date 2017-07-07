/*
 * @(#)DeleteMacAddressChecker.java
 * Created on 2006-10-25, ����03:00:33
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPMapTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 *
 * @version 1.0.0, 2006-10-25
 */
public class MSTPMapTableChecker extends BaseChecker {

	IApplication fApplication;

	public MSTPMapTableChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans)
	{
		MSTPMapTableMBean mbean = (MSTPMapTableMBean)selectedMibBeans[0];

    if(mbean.getMstpMapMSTiID().intValue() < 1){
      String err = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Cfg_MSTP_Manually");
			MessageDialog.showInfoMessageDialog( fApplication, err );
			return false;
		}

		return true;
	}
}
