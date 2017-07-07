package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.HistoryAlarmTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The HistoryAlarmTablePanel class. Created by DVM Creator
 */
public class HistoryAlarmTablePanel extends UPanel {

	private JLabel tfUtsBbsAlarmHistorySequenceNumber = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryProbableCause = new JLabel();

	private JLabel tfUtsBbsAlarmHistorySpecificProblem = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryEntityType = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryEntityInstance = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryFirstOccurenceTime = new JLabel();

	private int[] utsBbsAlarmHistoryClassVList = new int[] { 4, 2, 3, 5, 1, 0, };
	private String[] utsBbsAlarmHistoryClassTList = new String[] {
			fStringMap.getString("processing"), fStringMap.getString("qos"),
			fStringMap.getString("equipment"),
			fStringMap.getString("environment"),
			fStringMap.getString("communication"),
			fStringMap.getString("classNone"), };
	private JComboBox tfUtsBbsAlarmHistoryClass = new JComboBox(
			utsBbsAlarmHistoryClassTList);
	private int[] utsBbsAlarmHistorySeverityVList = new int[] { 3, 2, 1, 4, 5,
			0, };
	private String[] utsBbsAlarmHistorySeverityTList = new String[] {
			fStringMap.getString("minor"), fStringMap.getString("major"),
			fStringMap.getString("critical"), fStringMap.getString("warning"),
			fStringMap.getString("clear"), fStringMap.getString("sevnone"), };
	private JComboBox tfUtsBbsAlarmHistorySeverity = new JComboBox(
			utsBbsAlarmHistorySeverityTList);
	private JLabel tfUtsBbsAlarmHistoryCorrelationId = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryAdditionalText = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryRaisingNumber = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryLastOccurenceTime = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryRepeats = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryVersionId = new JLabel();

	private JLabel tfUtsBbsAlarmHistorySessionId = new JLabel();

	private JLabel tfUtsBbsAlarmHistoryClearTime = new JLabel();

	private int[] utsBbsAlarmHistoryClearFlagVList = new int[] { 1, 2, };
	private String[] utsBbsAlarmHistoryClearFlagTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsBbsAlarmHistoryClearFlag = new JComboBox(
			utsBbsAlarmHistoryClearFlagTList);

	private final String utsBbsAlarmHistorySequenceNumber = fStringMap
			.getString("utsBbsAlarmHistorySequenceNumber")
			+ " : ";
	private final String utsBbsAlarmHistoryProbableCause = fStringMap
			.getString("utsBbsAlarmHistoryProbableCause")
			+ " : ";
	private final String utsBbsAlarmHistorySpecificProblem = fStringMap
			.getString("utsBbsAlarmHistorySpecificProblem")
			+ " : ";
	private final String utsBbsAlarmHistoryEntityType = fStringMap
			.getString("utsBbsAlarmHistoryEntityType")
			+ " : ";
	private final String utsBbsAlarmHistoryEntityInstance = fStringMap
			.getString("utsBbsAlarmHistoryEntityInstance")
			+ " : ";
	private final String utsBbsAlarmHistoryFirstOccurenceTime = fStringMap
			.getString("utsBbsAlarmHistoryFirstOccurenceTime")
			+ " : ";
	private final String utsBbsAlarmHistoryClass = fStringMap
			.getString("utsBbsAlarmHistoryClass")
			+ " : ";
	private final String utsBbsAlarmHistorySeverity = fStringMap
			.getString("utsBbsAlarmHistorySeverity")
			+ " : ";
	private final String utsBbsAlarmHistoryCorrelationId = fStringMap
			.getString("utsBbsAlarmHistoryCorrelationId")
			+ " : ";
	private final String utsBbsAlarmHistoryAdditionalText = fStringMap
			.getString("utsBbsAlarmHistoryAdditionalText")
			+ " : ";
	private final String utsBbsAlarmHistoryRaisingNumber = fStringMap
			.getString("utsBbsAlarmHistoryRaisingNumber")
			+ " : ";
	private final String utsBbsAlarmHistoryLastOccurenceTime = fStringMap
			.getString("utsBbsAlarmHistoryLastOccurenceTime")
			+ " : ";
	private final String utsBbsAlarmHistoryRepeats = fStringMap
			.getString("utsBbsAlarmHistoryRepeats")
			+ " : ";
	private final String utsBbsAlarmHistoryVersionId = fStringMap
			.getString("utsBbsAlarmHistoryVersionId")
			+ " : ";
	private final String utsBbsAlarmHistorySessionId = fStringMap
			.getString("utsBbsAlarmHistorySessionId")
			+ " : ";
	private final String utsBbsAlarmHistoryClearTime = fStringMap
			.getString("utsBbsAlarmHistoryClearTime")
			+ " : ";
	private final String utsBbsAlarmHistoryClearFlag = fStringMap
			.getString("utsBbsAlarmHistoryClearFlag")
			+ " : ";

	public HistoryAlarmTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistorySequenceNumber));
		baseInfoPanel.add(tfUtsBbsAlarmHistorySequenceNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryProbableCause));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryProbableCause);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistorySpecificProblem));
		baseInfoPanel.add(tfUtsBbsAlarmHistorySpecificProblem);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryEntityType));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryEntityType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryEntityInstance));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryEntityInstance);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryFirstOccurenceTime));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryFirstOccurenceTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryClass));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryClass);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistorySeverity));
		baseInfoPanel.add(tfUtsBbsAlarmHistorySeverity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryCorrelationId));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryCorrelationId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryAdditionalText));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryAdditionalText);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryRaisingNumber));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryRaisingNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryLastOccurenceTime));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryLastOccurenceTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryRepeats));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryRepeats);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryVersionId));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryVersionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistorySessionId));
		baseInfoPanel.add(tfUtsBbsAlarmHistorySessionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryClearTime));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryClearTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsAlarmHistoryClearFlag));
		baseInfoPanel.add(tfUtsBbsAlarmHistoryClearFlag);
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

		HistoryAlarmTable mbean = (HistoryAlarmTable) getModel();

		tfUtsBbsAlarmHistorySequenceNumber.setText(mbean
				.getUtsBbsAlarmHistorySequenceNumber().toString());
		tfUtsBbsAlarmHistoryProbableCause.setText(mbean
				.getUtsBbsAlarmHistoryProbableCause().toString());
		tfUtsBbsAlarmHistorySpecificProblem.setText(mbean
				.getUtsBbsAlarmHistorySpecificProblem().toString());
		tfUtsBbsAlarmHistoryEntityType.setText(mbean
				.getUtsBbsAlarmHistoryEntityType().toString());
		tfUtsBbsAlarmHistoryEntityInstance.setText(mbean
				.getUtsBbsAlarmHistoryEntityInstance().toString());
		tfUtsBbsAlarmHistoryFirstOccurenceTime.setText(mbean
				.getUtsBbsAlarmHistoryFirstOccurenceTime().toString());
		tfUtsBbsAlarmHistoryClass.setSelectedIndex(getIndexFromValue(
				utsBbsAlarmHistoryClassVList, mbean
						.getUtsBbsAlarmHistoryClass().intValue()));
		tfUtsBbsAlarmHistorySeverity.setSelectedIndex(getIndexFromValue(
				utsBbsAlarmHistorySeverityVList, mbean
						.getUtsBbsAlarmHistorySeverity().intValue()));
		tfUtsBbsAlarmHistoryCorrelationId.setText(mbean
				.getUtsBbsAlarmHistoryCorrelationId().toString());
		tfUtsBbsAlarmHistoryAdditionalText.setText(mbean
				.getUtsBbsAlarmHistoryAdditionalText());
		tfUtsBbsAlarmHistoryRaisingNumber.setText(mbean
				.getUtsBbsAlarmHistoryRaisingNumber().toString());
		tfUtsBbsAlarmHistoryLastOccurenceTime.setText(mbean
				.getUtsBbsAlarmHistoryLastOccurenceTime().toString());
		tfUtsBbsAlarmHistoryRepeats.setText(mbean
				.getUtsBbsAlarmHistoryRepeats().toString());
		tfUtsBbsAlarmHistoryVersionId.setText(mbean
				.getUtsBbsAlarmHistoryVersionId().toString());
		tfUtsBbsAlarmHistorySessionId.setText(mbean
				.getUtsBbsAlarmHistorySessionId().toString());
		tfUtsBbsAlarmHistoryClearTime.setText(mbean
				.getUtsBbsAlarmHistoryClearTime().toString());
		tfUtsBbsAlarmHistoryClearFlag.setSelectedIndex(getIndexFromValue(
				utsBbsAlarmHistoryClearFlagVList, mbean
						.getUtsBbsAlarmHistoryClearFlag().intValue()));

	}

	public void updateModel() {

		HistoryAlarmTable mbean = (HistoryAlarmTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
