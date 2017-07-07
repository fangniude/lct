/*
 * @(#)ResetONUChecker.java
 * Created on 2006-11-16, ����01:43:26
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Only allow to reset registered ONUs
 *
 * @version 1.0.0, 2006-11-16
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class ResetONUChecker extends BaseChecker {
	IApplication fApplication;

	public ResetONUChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
		Dot3OnuTable thisOnuTbl = (Dot3OnuTable)selectedMibBeans[0];
		
//		Name:	utsDot3OnuRegistrationState
//		Value list:	1: unregistered(1) 
//	 	2: pending(2) 
//	 	3: registered(3) 
		int regState = thisOnuTbl.getUtsDot3OnuRegistrationState().intValue();
		if ( regState != 3 ) {
      String err = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Reset_Unregistered_Onu");
			MessageDialog.showInfoMessageDialog( fApplication, err );
			return false;
		}

		return true;
	}
}
