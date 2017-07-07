/*
 * @(#)DeleteIfExtTblChecker.java
 * Created on 2006-11-3, ����06:36:56
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Vector;

/**
 * TODO: add function declaration here
 *
 * @version 1.0.0, 2006-11-3
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class DeleteIfExtTblChecker extends BaseChecker {

	IApplication fApplication;

	public DeleteIfExtTblChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}

	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans)
	{
		EthIfExtTable thisIfExtTblMBean = (EthIfExtTable) selectedMibBeans[0];

		try {
			// check if vlan is SuperVLAN
			EthIfExtTable ifExtMBean = new EthIfExtTable( fApplication.getSnmpProxy() );
			Vector ifExtVec = ifExtMBean.retrieveAll();
	
			String thisVLANIdx = ConfigUtility.formatIfIndex( thisIfExtTblMBean.getIfIndex().toString() ).substring(4);
	
			for ( int i = 0; i < ifExtVec.size(); i++ ) {
				EthIfExtTable tmpIfExtTbl = (EthIfExtTable)ifExtVec.elementAt(i);
				String tmpVLANId = tmpIfExtTbl.getUtsEthIfExtVlanId().toString();
				int tmpPortType = tmpIfExtTbl.getUtsEthIfExtPortType().intValue();
				if ( thisVLANIdx.equals( tmpVLANId ) && tmpPortType == 5 ) {
          IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
          String error = composer.getString("Err_Remove_Vlan_First_1") + thisVLANIdx + composer.getString("Err_Remove_Vlan_First_2");
					MessageDialog.showInfoMessageDialog( fApplication, error);
					return false;
				}
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}

		return true;
	}
}
