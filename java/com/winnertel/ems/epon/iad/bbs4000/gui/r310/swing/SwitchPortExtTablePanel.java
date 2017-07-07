package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.formatter.SwitchInterfaceIndexFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.SwitchPortExtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The SwitchPortExtTablePanel class. Created by DVM Creator
 */
public class SwitchPortExtTablePanel extends UPanel {

	private JLabel tfUtsSwitchPortExtIfNum = new JLabel();

	private int[] utsSwitchPortExtACLDefActionVList = new int[] { 1, 2, };

	private String[] utsSwitchPortExtACLDefActionTList = new String[] {
			fStringMap.getString("preConfiguration"),
			fStringMap.getString("noPreConfiguration"), };

	private JComboBox tfUtsSwitchPortExtACLDefAction = new JComboBox(
			utsSwitchPortExtACLDefActionTList);

	private int[] utsSwitchPortExtAdmFlowControlRxVList = new int[] { 2, 1, };

	private String[] utsSwitchPortExtAdmFlowControlRxTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsSwitchPortExtAdmFlowControlRx = new JComboBox(
			utsSwitchPortExtAdmFlowControlRxTList);

	private int[] utsSwitchPortExtAdmFlowControlTxVList = new int[] { 2, 1, };

	private String[] utsSwitchPortExtAdmFlowControlTxTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsSwitchPortExtAdmFlowControlTx = new JComboBox(
			utsSwitchPortExtAdmFlowControlTxTList);

//	private int[] utsSwitchPortExtIpMuticastFilterVList = new int[] { 2, 1, };

//	private String[] utsSwitchPortExtIpMuticastFilterTList = new String[] {
//			fStringMap.getString("disable"), fStringMap.getString("enable"), };

//	private JComboBox tfUtsSwitchPortExtIpMuticastFilter = new JComboBox(
//			utsSwitchPortExtIpMuticastFilterTList);

	private final String utsSwitchPortExtIfNum = fStringMap
			.getString("utsSwitchPortExtIfNum")
			+ " : ";

	private final String utsSwitchPortExtACLDefAction = fStringMap
			.getString("utsSwitchPortExtACLDefAction")
			+ " : ";

	private final String utsSwitchPortExtAdmFlowControlRx = fStringMap
			.getString("utsSwitchPortExtAdmFlowControlRx")
			+ " : ";

	private final String utsSwitchPortExtAdmFlowControlTx = fStringMap
			.getString("utsSwitchPortExtAdmFlowControlTx")
			+ " : ";

//	private final String utsSwitchPortExtIpMuticastFilter = fStringMap
//			.getString("utsSwitchPortExtIpMuticastFilter")
//			+ " : ";

	public SwitchPortExtTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtIfNum));
		baseInfoPanel.add(tfUtsSwitchPortExtIfNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtACLDefAction));
		tfUtsSwitchPortExtACLDefAction.setName(fStringMap
				.getString("utsSwitchPortExtACLDefAction"));
		baseInfoPanel.add(tfUtsSwitchPortExtACLDefAction);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtAdmFlowControlRx));
		tfUtsSwitchPortExtAdmFlowControlRx.setName(fStringMap
				.getString("utsSwitchPortExtAdmFlowControlRx"));
		baseInfoPanel.add(tfUtsSwitchPortExtAdmFlowControlRx);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtAdmFlowControlTx));
		tfUtsSwitchPortExtAdmFlowControlTx.setName(fStringMap
				.getString("utsSwitchPortExtAdmFlowControlTx"));
		baseInfoPanel.add(tfUtsSwitchPortExtAdmFlowControlTx);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsSwitchPortExtIpMuticastFilter));
//		tfUtsSwitchPortExtIpMuticastFilter.setName(fStringMap
//				.getString("utsSwitchPortExtIpMuticastFilter"));
//		baseInfoPanel.add(tfUtsSwitchPortExtIpMuticastFilter);
//		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

	}

	protected void initForm() {

	}

	public void refresh() {
		SwitchPortExtTable mbean = (SwitchPortExtTable) getModel();

		tfUtsSwitchPortExtIfNum.setText(SwitchInterfaceIndexFormatter
				.format(mbean.getUtsSwitchPortExtIfNum()));
		tfUtsSwitchPortExtACLDefAction.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtACLDefActionVList, mbean
						.getUtsSwitchPortExtACLDefAction().intValue()));
		tfUtsSwitchPortExtAdmFlowControlRx.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtAdmFlowControlRxVList, mbean
						.getUtsSwitchPortExtAdmFlowControlRx().intValue()));
		tfUtsSwitchPortExtAdmFlowControlTx.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtAdmFlowControlTxVList, mbean
						.getUtsSwitchPortExtAdmFlowControlTx().intValue()));
//		tfUtsSwitchPortExtIpMuticastFilter.setSelectedIndex(getIndexFromValue(
//				utsSwitchPortExtIpMuticastFilterVList, mbean
//						.getUtsSwitchPortExtIpMuticastFilter().intValue()));
	}

	public void updateModel() {
		SwitchPortExtTable mbean = (SwitchPortExtTable) getModel();

		mbean
				.setUtsSwitchPortExtACLDefAction(new Integer(
						utsSwitchPortExtACLDefActionVList[tfUtsSwitchPortExtACLDefAction
								.getSelectedIndex()]));
		mbean
				.setUtsSwitchPortExtAdmFlowControlRx(new Integer(
						utsSwitchPortExtAdmFlowControlRxVList[tfUtsSwitchPortExtAdmFlowControlRx
								.getSelectedIndex()]));
		mbean
				.setUtsSwitchPortExtAdmFlowControlTx(new Integer(
						utsSwitchPortExtAdmFlowControlTxVList[tfUtsSwitchPortExtAdmFlowControlTx
								.getSelectedIndex()]));
//		mbean
//				.setUtsSwitchPortExtIpMuticastFilter(new Integer(
//						utsSwitchPortExtIpMuticastFilterVList[tfUtsSwitchPortExtIpMuticastFilter
//								.getSelectedIndex()]));
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
