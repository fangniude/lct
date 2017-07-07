/*
 * @(#)DeleteMacAddressChecker.java
 * Created on 2006-10-25, ����03:00:33
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.MACAddressTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * TODO: add function declaration here
 *
 * @version 1.0.0, 2006-10-25
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class DeleteMacAddressChecker extends BaseChecker {

	IApplication fApplication;

	public DeleteMacAddressChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans)
	{
		MACAddressTable mbean = (MACAddressTable)selectedMibBeans[0];
		
		Integer intfType = mbean.getUtsLagExtLinkAggMacIntfType();
		
		if ( intfType.intValue() == 3 ) {
      String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Delete_CPU_MAC");
			MessageDialog.showInfoMessageDialog( fApplication, error );
			return false;
		}
		
		return true;
	}
}
