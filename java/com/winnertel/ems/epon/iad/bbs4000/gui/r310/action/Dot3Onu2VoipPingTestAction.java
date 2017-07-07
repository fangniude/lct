package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing.Dot3Onu2VoipPingTestMPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipIadTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipPingTestTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class Dot3Onu2VoipPingTestAction extends SnmpAction {

	public Dot3Onu2VoipPingTestAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		if(fTable.getSelectedRowCount() < 1) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		Dot3Onu2VoipIadTable bean = (Dot3Onu2VoipIadTable)tableModel.getRow(fTable.getSelectedRow());

		if (fPanel == null || fPanel instanceof SnmpTablePane) {
			fPanel = new Dot3Onu2VoipPingTestMPanel(fApplication);
//			((Dot3Onu2VoipPingTestMPanel) fPanel).setTable(fTable);
		}

		if (fDialog == null) {
			String title = fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("Dot3Onu2VoipPingTestTable_Panel");
			fDialog = new SnmpDialog(fApplication, title, "Refresh", "R|Q");
			((SnmpDialog) fDialog).setTable(fTable);
			((SnmpDialog) fDialog).setPanel(fPanel);
			((SnmpDialog) fDialog)
					.setApplyId("Modify_Dot3onu2VoipPingTestTable_Log");
		}

		Dot3Onu2VoipPingTestTable fBean = new Dot3Onu2VoipPingTestTable(this.fApplication.getSnmpProxy());

		fBean.setUtsDot3Onu2VoipModuleId(bean.getUtsDot3Onu2CtcCombinedFeaturesModuleId());
		fBean.setUtsDot3Onu2VoipDeviceId(bean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId());
		fBean.setUtsDot3Onu2VoipPortId(bean.getUtsDot3Onu2CtcCombinedFeaturesPortId());
		fBean.setUtsDot3Onu2VoipLogicalPortId(bean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId());
		
		fPanel.setModel(fBean);
		fPanel.refresh();
		fDialog.pack();
		fDialog.show();

	}
}