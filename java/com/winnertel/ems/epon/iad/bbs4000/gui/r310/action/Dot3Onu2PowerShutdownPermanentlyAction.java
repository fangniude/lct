package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing.Dot3Onu2OperationTablePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2OperationTable;
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

public class Dot3Onu2PowerShutdownPermanentlyAction extends SnmpAction {

	public Dot3Onu2PowerShutdownPermanentlyAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {
		if(fTable.getSelectedRowCount() < 1) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}
		
		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		Dot3Onu2CtcTable bean = (Dot3Onu2CtcTable)tableModel.getRow(fTable.getSelectedRow());

		if (fPanel == null || fPanel instanceof SnmpTablePane) {
			fPanel = new Dot3Onu2OperationTablePanel(fApplication);
			((Dot3Onu2OperationTablePanel) fPanel).setTable(fTable);
		}

		if (fDialog == null) {
			String title = fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("Dot3Onu2OperationTable_Panel");
			fDialog = new SnmpDialog(fApplication, title, "Modify", "A|Q");
			((SnmpDialog) fDialog).setTable(fTable);
			((SnmpDialog) fDialog).setPanel(fPanel);
			((SnmpDialog) fDialog)
					.setApplyId("Modify_Dot3Onu2OperationTable_Log");
		}

		Dot3Onu2OperationTable fBean = new Dot3Onu2OperationTable(this.fApplication.getSnmpProxy());

		fBean.setUtsDot3Onu2MacAgingTimeModuleId(bean.getUtsDot3Onu2CtcModuleId());
		fBean.setUtsDot3Onu2MacAgingTimeDeviceId(bean.getUtsDot3Onu2CtcDeviceId());
		fBean.setUtsDot3Onu2MacAgingTimePortId(bean.getUtsDot3Onu2CtcPortId());
		fBean.setUtsDot3Onu2MacAgingTimeLogicalPortId(bean.getUtsDot3Onu2CtcLogicalPortId());
		
		fBean.setUtsDot3Onu2PowerControlActions(new Integer(65535));
		fBean.setUtsDot3Onu2PowerControlMode(bean.getUtsDot3Onu2CtcRegisterStatus() == 1 ? 1 : 2); //����ONUȱʡ�õ���LLID,�����ù㲥LLID
//		fBean.setUtsDot3Onu2PowerControlOnuId(bean.getUtsDot3Onu2CtcRegisterStatus() == 1  ? null : bean.getUtsDot3Onu2CtcOnuMacAddr());  //Valid only on boardcast LLID mode.�ڵ���ʱ�ҵ�
		fBean.setUtsDot3Onu2PowerControlOnuId(getMacAddress(bean.getUtsDot3Onu2CtcOnuMacAddr()));  //Valid only on boardcast LLID mode.�ڵ���ʱ�ҵ�
		fBean.setUtsDot3Onu2PowerControlTxId(1);
		
		fPanel.setModel(fBean);
		fPanel.refresh();
		fDialog.pack();
		fDialog.show();

	}
	
	public byte[] getMacAddress(byte[] value) {
        if (value == null || (value.length < 14 && value.length != 6)) {
            return null;
        }

        byte[] mac = new byte[6];
        if (value.length >= 14)
            System.arraycopy(value, 8, mac, 0, 6);
        else
            System.arraycopy(value, 0, mac, 0, 6);

        return mac;
    }
}