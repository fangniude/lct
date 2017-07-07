package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.ActiveAlarmTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ActiveTablePanel class. Created by DVM Creator
 */
public class ActiveAlarmTablePanel extends UPanel {

	private JLabel tfUtsBbsAlarmActiveSequenceNumber = new JLabel();

	private JLabel tfUtsBbsAlarmActiveProbableCause = new JLabel();

	private JLabel tfUtsBbsAlarmActiveSpecificProblem = new JLabel();

	private JLabel tfUtsBbsAlarmActiveEntityType = new JLabel();

	private JLabel tfUtsBbsAlarmActiveEntityInstance = new JLabel();

	private JLabel tfUtsBbsAlarmActiveFirstOccurenceTime = new JLabel();

	private int[] utsBbsAlarmActiveClassVList = new int[] { 4, 2, 3, 5, 1, 0, };
	private String[] utsBbsAlarmActiveClassTList = new String[] {
			fStringMap.getString("processing"), fStringMap.getString("qos"),
			fStringMap.getString("equipment"),
			fStringMap.getString("environment"),
			fStringMap.getString("communication"),
			fStringMap.getString("classNone"), };
	private JComboBox tfUtsBbsAlarmActiveClass = new JComboBox(
			utsBbsAlarmActiveClassTList);
	private int[] utsBbsAlarmActiveSeverityVList = new int[] { 3, 2, 1, 4, 5,
			0, };
	private String[] utsBbsAlarmActiveSeverityTList = new String[] {
			fStringMap.getString("minor"), fStringMap.getString("major"),
			fStringMap.getString("critical"), fStringMap.getString("warning"),
			fStringMap.getString("clear"), fStringMap.getString("sevnone"), };
	private JComboBox tfUtsBbsAlarmActiveSeverity = new JComboBox(
			utsBbsAlarmActiveSeverityTList);
	private int[] utsBbsAlarmActiveAcknowledgeVList = new int[] { 1, 2, };
	private String[] utsBbsAlarmActiveAcknowledgeTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsBbsAlarmActiveAcknowledge = new JComboBox(
			utsBbsAlarmActiveAcknowledgeTList);
	private JLabel tfUtsBbsAlarmActiveAdditionalText = new JLabel();

	private JLabel tfUtsBbsAlarmActiveRaisingNumber = new JLabel();

	private JLabel tfUtsBbsAlarmActiveLastOccurenceTime = new JLabel();

	private JLabel tfUtsBbsAlarmActiveRepeats = new JLabel();

	private JLabel tfUtsBbsAlarmActiveVersionId = new JLabel();

	private JLabel tfUtsBbsAlarmActiveSessionId = new JLabel();

	private int[] utsBbsAlarmActiveClearManuallyVList = new int[] { 1, 2, };
	private String[] utsBbsAlarmActiveClearManuallyTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsBbsAlarmActiveClearManually = new JComboBox(
			utsBbsAlarmActiveClearManuallyTList);

	private final String utsBbsAlarmActiveSequenceNumber = fStringMap
			.getString("utsBbsAlarmActiveSequenceNumber")
			+ " : ";
	private final String utsBbsAlarmActiveProbableCause = fStringMap
			.getString("utsBbsAlarmActiveProbableCause")
			+ " : ";
	private final String utsBbsAlarmActiveSpecificProblem = fStringMap
			.getString("utsBbsAlarmActiveSpecificProblem")
			+ " : ";
	private final String utsBbsAlarmActiveEntityType = fStringMap
			.getString("utsBbsAlarmActiveEntityType")
			+ " : ";
	private final String utsBbsAlarmActiveEntityInstance = fStringMap
			.getString("utsBbsAlarmActiveEntityInstance")
			+ " : ";
	private final String utsBbsAlarmActiveFirstOccurenceTime = fStringMap
			.getString("utsBbsAlarmActiveFirstOccurenceTime")
			+ " : ";
	private final String utsBbsAlarmActiveClass = fStringMap
			.getString("utsBbsAlarmActiveClass")
			+ " : ";
	private final String utsBbsAlarmActiveSeverity = fStringMap
			.getString("utsBbsAlarmActiveSeverity")
			+ " : ";
	private final String utsBbsAlarmActiveAcknowledge = fStringMap
			.getString("utsBbsAlarmActiveAcknowledge")
			+ " : ";
	private final String utsBbsAlarmActiveAdditionalText = fStringMap
			.getString("utsBbsAlarmActiveAdditionalText")
			+ " : ";
	private final String utsBbsAlarmActiveRaisingNumber = fStringMap
			.getString("utsBbsAlarmActiveRaisingNumber")
			+ " : ";
	private final String utsBbsAlarmActiveLastOccurenceTime = fStringMap
			.getString("utsBbsAlarmActiveLastOccurenceTime")
			+ " : ";
	private final String utsBbsAlarmActiveRepeats = fStringMap
			.getString("utsBbsAlarmActiveRepeats")
			+ " : ";
	private final String utsBbsAlarmActiveVersionId = fStringMap
			.getString("utsBbsAlarmActiveVersionId")
			+ " : ";
	private final String utsBbsAlarmActiveSessionId = fStringMap
			.getString("utsBbsAlarmActiveSessionId")
			+ " : ";
	private final String utsBbsAlarmActiveClearManually = fStringMap
			.getString("utsBbsAlarmActiveClearManually")
			+ " : ";

	public ActiveAlarmTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(16, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveSequenceNumber));
		baseInfoPanel.add(tfUtsBbsAlarmActiveSequenceNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveProbableCause));
		baseInfoPanel.add(tfUtsBbsAlarmActiveProbableCause);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveSpecificProblem));
		baseInfoPanel.add(tfUtsBbsAlarmActiveSpecificProblem);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveEntityType));
		baseInfoPanel.add(tfUtsBbsAlarmActiveEntityType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveEntityInstance));
		baseInfoPanel.add(tfUtsBbsAlarmActiveEntityInstance);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveFirstOccurenceTime));
		baseInfoPanel.add(tfUtsBbsAlarmActiveFirstOccurenceTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveClass));
		baseInfoPanel.add(tfUtsBbsAlarmActiveClass);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveSeverity));
		baseInfoPanel.add(tfUtsBbsAlarmActiveSeverity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveAcknowledge));
		tfUtsBbsAlarmActiveAcknowledge.setName(fStringMap
				.getString("utsBbsAlarmActiveAcknowledge"));
		baseInfoPanel.add(tfUtsBbsAlarmActiveAcknowledge);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveAdditionalText));
		baseInfoPanel.add(tfUtsBbsAlarmActiveAdditionalText);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveRaisingNumber));
		baseInfoPanel.add(tfUtsBbsAlarmActiveRaisingNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveLastOccurenceTime));
		baseInfoPanel.add(tfUtsBbsAlarmActiveLastOccurenceTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveRepeats));
		baseInfoPanel.add(tfUtsBbsAlarmActiveRepeats);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveVersionId));
		baseInfoPanel.add(tfUtsBbsAlarmActiveVersionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveSessionId));
		baseInfoPanel.add(tfUtsBbsAlarmActiveSessionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmActiveClearManually));
		tfUtsBbsAlarmActiveClearManually.setName(fStringMap
				.getString("utsBbsAlarmActiveClearManually"));
		baseInfoPanel.add(tfUtsBbsAlarmActiveClearManually);
		baseInfoPanel.add(new HSpacer());

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

		ActiveAlarmTable mbean = (ActiveAlarmTable) getModel();

//		tfUtsBbsAlarmActiveSequenceNumber.setText(mbean
//				.getUtsBbsAlarmActiveSequenceNumber().toString());
//		tfUtsBbsAlarmActiveProbableCause.setText(mbean
//				.getUtsBbsAlarmActiveProbableCause().toString());
//		tfUtsBbsAlarmActiveSpecificProblem.setText(mbean
//				.getUtsBbsAlarmActiveSpecificProblem().toString());
//		tfUtsBbsAlarmActiveEntityType.setText(mbean
//				.getUtsBbsAlarmActiveEntityType().toString());
//		tfUtsBbsAlarmActiveEntityInstance.setText(mbean
//				.getUtsBbsAlarmActiveEntityInstance().toString());
//		tfUtsBbsAlarmActiveFirstOccurenceTime.setText(mbean
//				.getUtsBbsAlarmActiveFirstOccurenceTime().toString());
//		tfUtsBbsAlarmActiveClass.setSelectedIndex(getIndexFromValue(
//				utsBbsAlarmActiveClassVList, mbean.getUtsBbsAlarmActiveClass()
//						.intValue()));
//		tfUtsBbsAlarmActiveSeverity.setSelectedIndex(getIndexFromValue(
//				utsBbsAlarmActiveSeverityVList, mbean
//						.getUtsBbsAlarmActiveSeverity().intValue()));
//		tfUtsBbsAlarmActiveAcknowledge.setSelectedIndex(getIndexFromValue(
//				utsBbsAlarmActiveAcknowledgeVList, mbean
//						.getUtsBbsAlarmActiveAcknowledge().intValue()));
//		tfUtsBbsAlarmActiveAdditionalText.setText(mbean
//				.getUtsBbsAlarmActiveAdditionalText());
//		tfUtsBbsAlarmActiveRaisingNumber.setText(mbean
//				.getUtsBbsAlarmActiveRaisingNumber().toString());
//		tfUtsBbsAlarmActiveLastOccurenceTime.setText(mbean
//				.getUtsBbsAlarmActiveLastOccurenceTime().toString());
//		tfUtsBbsAlarmActiveRepeats.setText(mbean.getUtsBbsAlarmActiveRepeats()
//				.toString());
//		tfUtsBbsAlarmActiveVersionId.setText(mbean
//				.getUtsBbsAlarmActiveVersionId().toString());
//		tfUtsBbsAlarmActiveSessionId.setText(mbean
//				.getUtsBbsAlarmActiveSessionId().toString());
//		tfUtsBbsAlarmActiveClearManually.setSelectedIndex(getIndexFromValue(
//				utsBbsAlarmActiveClearManuallyVList, mbean
//						.getUtsBbsAlarmActiveClearManually().intValue()));

	}

	public void updateModel() {

		ActiveAlarmTable mbean = (ActiveAlarmTable) getModel();

//		mbean
//				.setUtsBbsAlarmActiveAcknowledge(new Integer(
//						utsBbsAlarmActiveAcknowledgeVList[tfUtsBbsAlarmActiveAcknowledge
//								.getSelectedIndex()]));
//
//		mbean
//				.setUtsBbsAlarmActiveClearManually(new Integer(
//						utsBbsAlarmActiveClearManuallyVList[tfUtsBbsAlarmActiveClearManually
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