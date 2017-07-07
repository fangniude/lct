package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipPingTestTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dot3Onu2VoipPingTestTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipPingTestTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private IPAddressField tfUtsDot3Onu2VoipPingTestDestIp = new IPAddressField(IPAddressField.IPAll);

//	private int[] utsDot3Onu2VoipPingTestActionVList = new int[] { 2, 1, };
//	private String[] utsDot3Onu2VoipPingTestActionTList = new String[] {
//			fStringMap.getString("stop"), fStringMap.getString("start"), };
//	private JComboBox tfUtsDot3Onu2VoipPingTestAction = new JComboBox(
//			utsDot3Onu2VoipPingTestActionTList);
	private IntegerTextField tfUtsDot3Onu2VoipPingTestTimes = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipPingTestPacketSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2VoipPingTestTimeout = new IntegerTextField();

	private final String utsDot3Onu2VoipModuleId = fStringMap
			.getString("utsDot3Onu2VoipModuleId")
			+ " : ";
//	private final String utsDot3Onu2VoipDeviceId = fStringMap
//			.getString("utsDot3Onu2VoipDeviceId")
//			+ " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap
			.getString("utsDot3Onu2VoipPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap
			.getString("utsDot3Onu2VoipLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2VoipPingTestDestIp = fStringMap
			.getString("utsDot3Onu2VoipPingTestDestIp")
			+ " : ";
//	private final String utsDot3Onu2VoipPingTestAction = fStringMap
//			.getString("utsDot3Onu2VoipPingTestAction")
//			+ " : ";
	private final String utsDot3Onu2VoipPingTestTimes = fStringMap
			.getString("utsDot3Onu2VoipPingTestTimes")
			+ " : ";
	private final String utsDot3Onu2VoipPingTestPacketSize = fStringMap
			.getString("utsDot3Onu2VoipPingTestPacketSize")
			+ " : ";
	private final String utsDot3Onu2VoipPingTestTimeout = fStringMap
			.getString("utsDot3Onu2VoipPingTestTimeout")
			+ " : ";

	private JButton btStart = new JButton(fStringMap.getString("Start"));
    private JButton btStop = new JButton(fStringMap.getString("Stop"));

	public Dot3Onu2VoipPingTestTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btStart);
        buttonsPanel.add(btStop);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 6, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());


		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new VSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTestDestIp));
		tfUtsDot3Onu2VoipPingTestDestIp.setName(fStringMap
				.getString("utsDot3Onu2VoipPingTestDestIp"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTestDestIp);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTestTimes));
		tfUtsDot3Onu2VoipPingTestTimes.setName(fStringMap
				.getString("utsDot3Onu2VoipPingTestTimes"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTestTimes);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTestPacketSize));
		tfUtsDot3Onu2VoipPingTestPacketSize.setName(fStringMap
				.getString("utsDot3Onu2VoipPingTestPacketSize"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTestPacketSize);
		baseInfoPanel.add(new VSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPingTestTimeout));
		tfUtsDot3Onu2VoipPingTestTimeout.setName(fStringMap
				.getString("utsDot3Onu2VoipPingTestTimeout"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPingTestTimeout);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm() {

		tfUtsDot3Onu2VoipPingTestTimes.setValueScope(1, 10);

		tfUtsDot3Onu2VoipPingTestPacketSize.setValueScope(1, 65535);

		tfUtsDot3Onu2VoipPingTestTimeout.setValueScope(1, 2000);

		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dot3Onu2VoipPingTestTable mbean = (Dot3Onu2VoipPingTestTable) getModel();
				mbean.setUtsDot3Onu2VoipPingTestAction(1);
				
				mbean.setUtsDot3Onu2VoipPingTestDestIp(new String(
						tfUtsDot3Onu2VoipPingTestDestIp.getIPString()));
				mbean.setUtsDot3Onu2VoipPingTestTimes(new Integer(
						tfUtsDot3Onu2VoipPingTestTimes.getValue()));
				mbean.setUtsDot3Onu2VoipPingTestPacketSize(new Integer(
						tfUtsDot3Onu2VoipPingTestPacketSize.getValue()));
				mbean.setUtsDot3Onu2VoipPingTestTimeout(new Integer(
						tfUtsDot3Onu2VoipPingTestTimeout.getValue()));
				
				OperationTask task = new OperationTask(mbean);

				task.setWaitPrompt(fApplication.getGlobalStringMap().getString(
						"Please wait while configuring NE"));
				try {
					Boolean result = (Boolean) fApplication.getTaskManager()
							.executeTask(task);

					if (!result.booleanValue()) {
						throw new OperationFailedException("Diagnosis operation failed");
					}
//
//					new RefreshAllCommand(fApplication, fTable).execute();
				} catch (Exception ex) {
					MessageDialog.showOperationFailedDialog(fApplication);
//					throw new OperationFailedException("Diagnosis operation failed");
				} finally {
				}
			}
		});
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dot3Onu2VoipPingTestTable mbean = (Dot3Onu2VoipPingTestTable) getModel();
				mbean.setUtsDot3Onu2VoipPingTestAction(2);

//				mbean.setUtsDot3Onu2VoipPingTestDestIp(new String(
//						tfUtsDot3Onu2VoipPingTestDestIp.getValue()));
//				mbean.setUtsDot3Onu2VoipPingTestTimes(new Integer(
//						tfUtsDot3Onu2VoipPingTestTimes.getValue()));
//				mbean.setUtsDot3Onu2VoipPingTestPacketSize(new Integer(
//						tfUtsDot3Onu2VoipPingTestPacketSize.getValue()));
//				mbean.setUtsDot3Onu2VoipPingTestTimeout(new Integer(
//						tfUtsDot3Onu2VoipPingTestTimeout.getValue()));
				
				OperationTask task = new OperationTask(mbean);

				task.setWaitPrompt(fApplication.getGlobalStringMap().getString(
						"Please wait while configuring NE"));
				try {
					Boolean result = (Boolean) fApplication.getTaskManager()
							.executeTask(task);

					if (!result.booleanValue()) {
						throw new OperationFailedException("Diagnosis operation failed");
					}
//
//					new RefreshAllCommand(fApplication, fTable).execute();
				} catch (Exception ex) {
					MessageDialog.showOperationFailedDialog(fApplication);
//					throw new OperationFailedException("Diagnosis operation failed");
				} finally {
				}
			}
		});
	}

	public void refresh() {

		Dot3Onu2VoipPingTestTable mbean = (Dot3Onu2VoipPingTestTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2VoipModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2VoipDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2VoipPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2VoipLogicalPortId().toString());
		if (mbean.getUtsDot3Onu2VoipPingTestDestIp() != null)
			tfUtsDot3Onu2VoipPingTestDestIp.setValue(mbean
					.getUtsDot3Onu2VoipPingTestDestIp());
//		tfUtsDot3Onu2VoipPingTestAction.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2VoipPingTestActionVList, mbean
//						.getUtsDot3Onu2VoipPingTestAction().intValue()));
		if (mbean.getUtsDot3Onu2VoipPingTestTimes() != null)
			tfUtsDot3Onu2VoipPingTestTimes.setValue(mbean
					.getUtsDot3Onu2VoipPingTestTimes().intValue());
		if (mbean.getUtsDot3Onu2VoipPingTestPacketSize() != null)
			tfUtsDot3Onu2VoipPingTestPacketSize.setValue(mbean
					.getUtsDot3Onu2VoipPingTestPacketSize().intValue());
		if (mbean.getUtsDot3Onu2VoipPingTestTimeout() != null)
			tfUtsDot3Onu2VoipPingTestTimeout.setValue(mbean
					.getUtsDot3Onu2VoipPingTestTimeout().intValue());

	}

	public void updateModel() {

		Dot3Onu2VoipPingTestTable mbean = (Dot3Onu2VoipPingTestTable) getModel();

		mbean.setUtsDot3Onu2VoipPingTestDestIp(new String(
				tfUtsDot3Onu2VoipPingTestDestIp.getIPString()));
//		mbean
//				.setUtsDot3Onu2VoipPingTestAction(new Integer(
//						utsDot3Onu2VoipPingTestActionVList[tfUtsDot3Onu2VoipPingTestAction
//								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2VoipPingTestTimes(new Integer(
				tfUtsDot3Onu2VoipPingTestTimes.getValue()));
		mbean.setUtsDot3Onu2VoipPingTestPacketSize(new Integer(
				tfUtsDot3Onu2VoipPingTestPacketSize.getValue()));
		mbean.setUtsDot3Onu2VoipPingTestTimeout(new Integer(
				tfUtsDot3Onu2VoipPingTestTimeout.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	class OperationTask extends Task {

		Dot3Onu2VoipPingTestTable fBean = null;

		public OperationTask(Dot3Onu2VoipPingTestTable bean) {
			fBean = bean;
		}

		public Object execute() throws Exception {
			return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
		}

	}

}