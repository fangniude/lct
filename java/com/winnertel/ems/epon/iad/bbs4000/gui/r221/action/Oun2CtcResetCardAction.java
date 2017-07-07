package com.winnertel.ems.epon.iad.bbs4000.gui.r221.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesResetCard;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oun2CtcResetCardAction extends SnmpAction {

	public Oun2CtcResetCardAction(IApplication anApplication) {
		super(anApplication);
	}

	public void executeAction(ActionEvent e) throws Exception {
		int selectedRowCount = fTable.getSelectedRowCount();
		if (selectedRowCount == 0) {
			MessageDialog.showSelectRowDialog(fApplication);
			return;
		}

		SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
		SnmpMibBean bean = tableModel.getRow(fTable.getSelectedRow());

		if (bean != null) {
			showDialog(bean);
		}
	}

	private void showDialog(SnmpMibBean bean) {
		Onu2CtcResetCardDialog resetCardDialog = (Onu2CtcResetCardDialog) fApplication
				.getActiveDeviceManager().getProperties().get(
						"Oun2CtcResetCardAction");

		if (resetCardDialog == null) {
			Window win = SwingUtilities.getWindowAncestor(fApplication
					.getTopMostFrame());
			resetCardDialog = new Onu2CtcResetCardDialog(win);
			resetCardDialog.setTitle(fApplication.getGlobalStringMap()
					.getString("Reset"));
			resetCardDialog.setLocationRelativeTo(fApplication
					.getTopMostFrame());
			resetCardDialog.setDefaultValue(bean);
			fApplication.getActiveDeviceManager().getProperties().put(
					"Oun2CtcResetCardAction", resetCardDialog);
		}

		resetCardDialog.setVisible(true);
		resetCardDialog.toFront();

	}

	class Onu2CtcResetCardDialog extends JDialog implements ActionListener {

		private Onu2CtcResetCardDialog thisDialog = null;

		private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
		// private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new
		// JLabel();
		private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
		private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

		private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"utsDot3Onu2CtcCombinedFeaturesModuleId")
				+ ": ";
		private final String utsDot3Onu2CtcCombinedFeaturesPortId = fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"utsDot3Onu2CtcCombinedFeaturesPortId")
				+ ": ";
		private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"utsDot3Onu2CtcCombinedFeaturesLogicalPortId")
				+ ": ";

		private final String utsDot3Onu2CtcMduResetCardCardNumber = fApplication
				.getActiveDeviceManager().getGuiComposer().getString(
						"utsDot3Onu2CtcMduResetCardCardNumber")
				+ ": ";

		JPanel panel = null;

		private int[] utsDot3Onu2CtcMduResetCardCardNumberVList = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, };
		private Integer[] utsDot3Onu2CtcMduResetCardCardNumberTList = new Integer[] {
				1, 2, 3, 4, 5, 6, 7, 8 };
		private JComboBox tfUtsDot3Onu2CtcMduResetCardCardNumber = new JComboBox(
				utsDot3Onu2CtcMduResetCardCardNumberTList);

		Onu2CtcCombinedFeaturesResetCard mBean;
		private String oldSpecId = null;

		// public static void main(String[] args) {
		// Onu2CtcResetCardDialog dialog = new Onu2CtcResetCardDialog();
		// // dialog.setSize(new Dimension(300, 200));
		// dialog.show();
		// }

		public Onu2CtcResetCardDialog() {
			super(null, Dialog.ModalityType.DOCUMENT_MODAL);
			init();
			thisDialog = this;
		}

		public Onu2CtcResetCardDialog(Window win) {
			super(win, Dialog.ModalityType.DOCUMENT_MODAL);
			init();
			thisDialog = this;
		}

		protected void init() {
			Container contentPane = getContentPane();
			contentPane.setLayout(new BorderLayout());

			JPanel baseInfoPanel = new JPanel();
			NTLayout layout = new NTLayout(4, 3, NTLayout.FILL,
					NTLayout.CENTER, 5, 5);
			layout.setMargins(6, 10, 6, 10);
			baseInfoPanel.setLayout(layout);
			baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

			baseInfoPanel
					.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesModuleId));
			baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesModuleId);
			baseInfoPanel.add(new HSpacer());

			// baseInfoPanel.add(new
			// JLabel(utsDot3Onu2CtcCombinedFeaturesDeviceId));
			// baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesDeviceId);
			// baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesPortId));
			baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesPortId);
			baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(
					utsDot3Onu2CtcCombinedFeaturesLogicalPortId));
			baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
			baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduResetCardCardNumber));
			// tfUtsDot3Onu2CtcMduResetCardCardNumber.setName(fStringMap.getString("utsDot3Onu2CtcMduResetCardCardNumber"));
			baseInfoPanel.add(tfUtsDot3Onu2CtcMduResetCardCardNumber);
			baseInfoPanel.add(new HSpacer());

			contentPane.add(baseInfoPanel, BorderLayout.CENTER);

			JPanel controlPane = new JPanel();
			JButton btn = new JButton(fApplication.getGlobalStringMap()
					.getString("Apply"));
			btn.setActionCommand("ok");
			btn.addActionListener(this);
			controlPane.add(btn);

			btn = new JButton(fApplication.getGlobalStringMap().getString(
					"Close"));
			btn.setActionCommand("cancel");
			btn.addActionListener(this);
			controlPane.add(btn);
			contentPane.add(controlPane, BorderLayout.SOUTH);

			setSize(new Dimension(230, 200));
			setResizable(false);
		}

		public void setDefaultValue(SnmpMibBean bean) {
			mBean = (Onu2CtcCombinedFeaturesResetCard) bean;
			tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mBean
					.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
			tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mBean
					.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
			tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mBean
					.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId()
					.toString());
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("ok")) {
				doResetCard();
				// setVisible(false);
			} else if (e.getActionCommand().equals("cancel")) {
				setVisible(false);
			}
			this.dispose();
		}

		public void doResetCard() {
			try {
				Task t = new ResetTask(mBean);
				t.setWaitPrompt(fApplication.getGlobalStringMap().getString(
						"Please wait while configuring NE"));
				try {
					Boolean result = (Boolean) fApplication.getTaskManager()
							.executeTask(t);
					if (!result.booleanValue()) {
						throw new OperationFailedException(
								"Restart Auto Negotiation operation failed");
					}
					new RefreshAllCommand(fApplication, fTable).execute();
				} catch (Exception ex) {
					MessageDialog.showOperationFailedDialog(fApplication);
					throw new OperationFailedException(
							"Restart Auto Negotiation operation failed");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		class ResetTask extends Task {

			Onu2CtcCombinedFeaturesResetCard mbean = null;

			public ResetTask(Onu2CtcCombinedFeaturesResetCard table) {
				mbean = table;
			}

			public Object execute() throws Exception {
				mBean
						.setUtsDot3Onu2CtcMduResetCardCardNumber(utsDot3Onu2CtcMduResetCardCardNumberVList[tfUtsDot3Onu2CtcMduResetCardCardNumber
								.getSelectedIndex()]);
				mBean.setUtsDot3Onu2CtcMduResetCardReset(1); // reset(1)
				mBean.modify();

				return mBean.modify();
			}

		}

	}

}