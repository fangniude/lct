package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing.OltVlanBatchConfigScalarsPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.event.ActionEvent;

public class OltVlanBatchConfigAction extends SnmpAction {

	public OltVlanBatchConfigAction(IApplication anApplication) {
        super(anApplication);
    }
	
	public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
		if (fPanel == null || fPanel instanceof SnmpTablePane) {
			fPanel = new OltVlanBatchConfigScalarsPanel(fApplication);
			((OltVlanBatchConfigScalarsPanel) fPanel).setTable(fTable);
		}
		
		if (fDialog == null) {
			String title = fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("VlanBatchConfigScalars");
			fDialog = new SnmpDialog(fApplication, title, "Batch Add", "A|Q");
			((SnmpDialog) fDialog).setTable(fTable);
			((SnmpDialog) fDialog).setPanel(fPanel);
			((SnmpDialog) fDialog)
					.setApplyId("Modify_OltVlanBatchConfigScalars");
			((SnmpDialog) fDialog).setMask("A|Q", false);
		}

//		fPanel.setModel(bean);
		fPanel.refresh();
		fDialog.pack();
		fDialog.show();

    }

}
