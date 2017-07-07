package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r310.UtsOnuFWUpgradeScheduleTimeFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.PerformanceManagementConfigTable;
import com.winnertel.ems.epon.iad.got6000.util.DateAndTimeUtil;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.platform.client.swing.calendar.CalendarComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

public class PerformanceManagementConfigTablePanel extends UPanel {
	
	private IntegerTextField tfUtsMeasurementId = new IntegerTextField();
	
	private CalendarComboBox timeset = new CalendarComboBox(false, true );
	
	private int[] utsMeasurementGranularityVList = new int[] { 1, 2, };

	private String[] utsMeasurementGranularityTList = new String[] {
			fStringMap.getString("15"), fStringMap.getString("1440"), };

	private JComboBox tfUtsMeasurementGranularity = new JComboBox(
			utsMeasurementGranularityTList);
	
	private int[] utsMeasurementMOVList = new int[] { 1, 2, 3, };

	private String[] utsMeasurementMOTList = new String[] {
			fStringMap.getString("pon"), fStringMap.getString("onu"), fStringMap.getString("eth"), };

	private JComboBox tfUtsMeasurementMO = new JComboBox(
			utsMeasurementMOTList);
	
	private int[] utsMeasurementStateVList = new int[] { 1, 2, };

	private String[] utsMeasurementStateTList = new String[] {
			fStringMap.getString("Open"), fStringMap.getString("Close"), };

	private JComboBox tfUtsMeasurementState = new JComboBox(
			utsMeasurementStateTList);

	
	private final String utsMeasurementId = fStringMap
			.getString("utsMeasurementId")
			+ " : ";
	
	private final String utsStartTime = fStringMap
			.getString("utsStartTime")
			+ " : ";
	
	private final String utsMeasurementGranularity = fStringMap
			.getString("utsMeasurementGranularity")
			+ " : ";
	
	private final String utsMeasurementMO = fStringMap
			.getString("utsMeasurementMO")
			+ " : ";
	
	private final String utsMeasurementState = fStringMap
			.getString("utsMeasurementState")
			+ " : ";

//	private SnmpApplyButton btApply;
//
//	private SnmpRefreshButton btRefresh;

	public PerformanceManagementConfigTablePanel(IApplication app) {
		super(app);
		setModel(new PerformanceManagementConfigTable(app.getSnmpProxy()));
		init();
	}

	public void initGui() {

//		btApply = new SnmpApplyButton(fApplication, this);
//		btApply.getAction()
//				.putValue(BaseAction.ID, "Modify_OltPerformanceManagementConfigTable");
//		btRefresh = new SnmpRefreshButton(fApplication, this);
//		JPanel buttonsPanel = new JPanel();
//		buttonsPanel.add(btApply);
//		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsMeasurementId));
		tfUtsMeasurementId.setName(fStringMap
	        .getString("utsMeasurementId"));
	    baseInfoPanel.add(tfUtsMeasurementId);
	    baseInfoPanel.add(new HSpacer());

	    baseInfoPanel.add(new JLabel(utsStartTime));
	    timeset.setName(fStringMap
	        .getString("utsStartTime"));
	    baseInfoPanel.add(timeset);
	    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMeasurementGranularity));
		tfUtsMeasurementGranularity.setName(fStringMap
				.getString("utsMeasurementGranularity"));
		baseInfoPanel.add(tfUtsMeasurementGranularity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMeasurementMO));
		tfUtsMeasurementMO.setName(fStringMap
				.getString("utsMeasurementMO"));
		baseInfoPanel.add(tfUtsMeasurementMO);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsMeasurementState));
		tfUtsMeasurementState.setName(fStringMap
				.getString("utsMeasurementState"));
		baseInfoPanel.add(tfUtsMeasurementState);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

//		add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm() {

	}

	public void refresh() {

		PerformanceManagementConfigTable mbean = (PerformanceManagementConfigTable) getModel();
		BeanService.refreshBean(fApplication, mbean);

		timeset.getCalendarPicker().setDate(new Date());
	}

	public void updateModel() {

		PerformanceManagementConfigTable mbean = (PerformanceManagementConfigTable) getModel();
		
		if (mbean == null)
            return;
		
		mbean.setEpPonIf2ExtManageStatId(tfUtsMeasurementId.getValue());
		mbean.setEpPonIf2ExtManageStatStartTime(UtsOnuFWUpgradeScheduleTimeFormatter.format(timeset.getCalendarPicker().getTimeValue()));
		mbean.setEpPonIf2ExtManageStatMeasureCyc(new Integer(
				utsMeasurementGranularityVList[tfUtsMeasurementGranularity
						.getSelectedIndex()]));
		mbean.setEpPonIf2ExtManageStatMO(new Integer(
				utsMeasurementMOVList[tfUtsMeasurementMO
						.getSelectedIndex()]));
		mbean.setEpPonIf2ExtManageStatTaskState(new Integer(
				utsMeasurementStateVList[tfUtsMeasurementState
						.getSelectedIndex()]));
		
	}


	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
