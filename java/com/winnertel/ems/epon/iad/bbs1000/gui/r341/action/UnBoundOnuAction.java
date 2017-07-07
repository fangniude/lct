package com.winnertel.ems.epon.iad.bbs1000.gui.r341.action;

import com.winnertel.ems.epon.iad.bbs1000.mib.r341.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UnBoundOnuAction extends SnmpAction {

	public UnBoundOnuAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws OperationFailedException,
			OperationCanceledException, OperationFinishedWithoutLogException {

		int selectedRowCount = fTable.getSelectedRowCount();
		if (selectedRowCount == 0) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}

		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		Dot3Onu2CtcValidOnuMacTable bean = (Dot3Onu2CtcValidOnuMacTable)tableModel.getRow(fTable.getSelectedRow());

		String mac = OctetToMacAddress(bean.getUtsDot3ValidOnuMacAddr());
		if (mac.equals("00:00:00:00:00:00")) {
			return;
		}

//		 if (!MessageDialog.showConfirmOperationDialog(fApplication)) {
//		 throw new OperationCanceledException("Reset ONU action canceled");
//		 }
		int inputvalue = NO_OPTION;
		if(isBindOnePort(mac)) {
			inputvalue = showConfirmOperationDialog(fApplication, getString(fApplication, "Please Confirm"));
			if (inputvalue == CLOSED_OPTION) {
				throw new OperationCanceledException("Unbind ONU operation canceled");
			}
		}
		
		Task t = new SnmpActionTask(bean, inputvalue);
		t.setWaitPrompt(fApplication.getGlobalStringMap().getString(
				"Please wait while configuring NE"));
		try {
			Boolean result = (Boolean) fApplication.getTaskManager()
					.executeTask(t);
			if (!result.booleanValue()) {
				throw new OperationFailedException(
						"Unbind ONU operation failed");
			}
			new RefreshAllCommand(fApplication, fTable).execute();
		} catch (Exception ex) {
			MessageDialog.showOperationFailedDialog(fApplication);
			throw new OperationFailedException(
					"Unbind ONU operation failed");
		} finally {
			MibBeanIdFormatter idFormatter = fTable.getRowIdFormatter();
			if (idFormatter != null) {
				OperationObject oo = idFormatter.format(bean, tableModel
						.getRowText(fTable.getSelectedRow()));
				// set operation object to device manager
				OperationObject currentOo = fApplication
						.getActiveDeviceManager().getOperationObject();
				currentOo.setChassis(oo.getChassis());
				currentOo.setBoard(oo.getBoard());
				currentOo.setPort(oo.getPort());
			}
		}

	}

	public static String OctetToMacAddress(byte[] value) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			byte b = value[i];
			if (b >= 0 && b < 16) {
				sb.append('0');
			}

			int bi = value[i] & 0xff;
			sb.append(Integer.toHexString(bi).toUpperCase());

			if (i < value.length - 1) {
				sb.append(":");
			}
		}

		return sb.toString();
	}
	
	public boolean isBindOnePort(String macAddress) {
//		if (!DebugMode.isDebug()) {
//			try {
//				OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility
//						.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//				List<ONUDevice> onuDevices = onuMgmtMgr
//						.getOnulistByMacAddress(macAddress.replaceAll(":", "-"));
//				if (onuDevices == null || onuDevices.size() == 1)
//					return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				MessageDialog.showErrorMessageDialog(fApplication, fApplication
//						.getActiveDeviceManager().getGuiComposer().getString(
//								"Failed_clear_onu_in_database"));
//			}
//			return false;
//		}
		return false;
	}

	class SnmpActionTask extends Task {

		Dot3Onu2CtcValidOnuMacTable bean = null;
		int isClearData = NO_OPTION;

		public SnmpActionTask(Dot3Onu2CtcValidOnuMacTable tbean, int isClearData) {
			bean = tbean;
			this.isClearData = isClearData;
		}

		public Object execute() throws Exception {
			// return bean.resetONU() ? Boolean.TRUE : Boolean.FALSE;
			byte[] mac = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
			bean.setUtsDot3ValidOnuMacAddr(mac);
			Boolean nodeRes = bean.modify();
			if(nodeRes && (isClearData == YES_OPTION)) {
//				if (!DebugMode.isDebug()) {
//		            try {
//		                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//		                String index = bean.getUtsDot3OnuValidOnuMacModuleId() + "-" + bean.getUtsDot3OnuValidOnuMacPortId() + "-" + bean.getUtsDot3OnuValidOnuMacAppLPortId();
//		                onuMgmtMgr.unBindOnu(fApplication.getSnmpProxy().getTargetHost(), index);
//		            } catch (Exception e) {
//		                e.printStackTrace();
//		                MessageDialog.showErrorMessageDialog(fApplication, fApplication.getActiveDeviceManager()
//		            			.getGuiComposer().getString("Failed_clear_onu_in_database"));
//		            }
//		        }
				
				return true;
			}
			return false;
		}

	}
	
	
	
	
	public int showConfirmOperationDialog(IApplication anApplication, String title) {
		JDialog dialog = createConfirmDialog((Frame)anApplication.getTopMostFrame(), title);
		dialog.setSize(new Dimension(360, 150));
		
		dialog.setResizable(false);
		dialog.setLocationRelativeTo((Frame)anApplication.getTopMostFrame());
		
		dialog.show();
        dialog.dispose();

        return getInputValue();
		
	}
	
	public void setInputValue(Integer value) {
		inputvalue = value;
	}
	
	public int getInputValue() {
		return inputvalue;
	}
	
	private JCheckBox ckClear = new JCheckBox(fApplication.getActiveDeviceManager()
			.getGuiComposer().getString("Clear all the information including ONU label of this ONU."));
	private JLabel lbMessage = new JLabel(fApplication.getActiveDeviceManager()
			.getGuiComposer().getString("Are you sure unbind the ONU from port?"));
	private JButton btnYes = new JButton(fApplication.getActiveDeviceManager()
			.getGuiComposer().getString("Yes")), btnNo = new JButton(fApplication.getActiveDeviceManager()
					.getGuiComposer().getString("No"));
	private Integer inputvalue = 0;
    public static final int         YES_OPTION = 0;
    public static final int         NO_OPTION = 1;
    public static final int         CLOSED_OPTION = -1;

	public JDialog createConfirmDialog(Frame owner, String title) {
		JDialog dialog = new JDialog(owner, title, true);
		initDialog(dialog);
		return dialog;
	}
	
	private void initDialog(final JDialog dialog) {
		Container contentPane = dialog.getContentPane();
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(lbMessage, BorderLayout.CENTER);
		mainPanel.add(ckClear, BorderLayout.SOUTH);
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "", 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.black));
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(btnYes);
		btnPanel.add(btnNo);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mainPanel, BorderLayout.CENTER);
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		WindowAdapter adapter = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
            	setInputValue(CLOSED_OPTION);
            }
        };
        dialog.addWindowListener(adapter);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ckClear.isSelected())
					setInputValue(YES_OPTION);
				else 
					setInputValue(NO_OPTION);
				dialog.setVisible(false);
			}
		});
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInputValue(CLOSED_OPTION);
				dialog.setVisible(false);
			}
		});
	}


	private static String getString(IApplication anApplication, String aKey) {
		String s = anApplication.getGlobalStringMap().getString(aKey);
		if (s == null)
			s = "";

		s = s.replaceAll("\\\\r\\\\n", "\r\n");
		s = s.replaceAll("\\\\r", "\r\n");
		s = s.replaceAll("\\\\n", "\r\n");

		return s;
	}

}
