package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2OPTDTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2OPTDTablePanel extends UPanel {

	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisModuleId = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisDeviceId = new JLabel();

	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisPortId = new JLabel();

	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisTemperature = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisVoltage = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisTxPower = new JLabel();
	
	private JLabel tfUtsDot3OnuOpticalTransceiverDiagnosisRxPower = new JLabel();

	private int[] utsDot3OnuOpticalTransceiverDiagnosisAlarmOperationVList = new int[] {
			2, 1, };
	private String[] utsDot3OnuOpticalTransceiverDiagnosisAlarmOperationTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
	private JComboBox tfUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation = new JComboBox(
			utsDot3OnuOpticalTransceiverDiagnosisAlarmOperationTList);
	
	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning = new IntegerTextField();

//	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm = new IntegerTextField();
//
//	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm = new IntegerTextField();
//
//	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning = new IntegerTextField();
//
//	private IntegerTextField tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning = new IntegerTextField();

	private int[] utsDot3OnuOpticalTransceiverDiagnosisPmSwitchVList = new int[] {
			1, 2, };
	private String[] utsDot3OnuOpticalTransceiverDiagnosisPmSwitchTList = new String[] {
			fStringMap.getString("enable"), fStringMap.getString("disable"),};
	private JComboBox tfUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch = new JComboBox(
			utsDot3OnuOpticalTransceiverDiagnosisPmSwitchTList);
	
	private final String utsDot3OnuOpticalTransceiverDiagnosisModuleId = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisModuleId")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisDeviceId = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisDeviceId")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisPortId = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisPortId")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTemperature = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTemperature")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisVoltage = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltage")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxPower = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPower")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisRxPower = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPower")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning")
			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning")
			+ " : ";
//	private final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm = fStringMap
//			.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm")
//			+ " : ";
//	private final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm = fStringMap
//			.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm")
//			+ " : ";
//	private final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning = fStringMap
//			.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning")
//			+ " : ";
//	private final String utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning = fStringMap
//			.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning")
//			+ " : ";
	private final String utsDot3OnuOpticalTransceiverDiagnosisPmSwitch = fStringMap
			.getString("utsDot3OnuOpticalTransceiverDiagnosisPmSwitch")
			+ " : ";
	
	
	public Dot3Onu2OPTDTablePanel(IApplication app) {
		super(app);
		setModel(new Dot3Onu2OPTDTable(app.getSnmpProxy()));
		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisModuleId));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisModuleId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisDeviceId));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisDeviceId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisPortId));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTemperature));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTemperature);
		baseInfoPanel.add(new HSpacer());
		
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisVoltage));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltage);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxPower));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPower);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisRxPower));
		baseInfoPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPower);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation));
		tfUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisAlarmOperation"));
		baseInfoPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisPmSwitch));
		tfUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisPmSwitch"));
		baseInfoPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch);
		baseInfoPanel.add(new HSpacer());

		JPanel anotherPanel = new JPanel();
		layout = new NTLayout(3, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		anotherPanel.setLayout(layout);
		anotherPanel.setBorder(BorderFactory.createEtchedBorder());

		anotherPanel.add(getTempPanel());
		anotherPanel.add(getVoltagePanel());

		anotherPanel.add(getTxPowerPanel());
//		anotherPanel.add(getRxPowerPanel());

		anotherPanel.add(getBiasPanel());
		anotherPanel.add(new HSpacer());
		JPanel allPanel = new JPanel();
		layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(anotherPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
	}

	public JPanel getTempPanel() {
		JPanel tempPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		tempPanel.setLayout(layout);
		tempPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("temp")));
		
		tempPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm"));
		tempPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm);

		tempPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm"));
		tempPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm);

		tempPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTempHighWarning"));
		tempPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning);

		tempPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTempLowWarning"));
		tempPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning);

		return tempPanel;
	}

	public JPanel getVoltagePanel() {
		JPanel voltagePanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		voltagePanel.setLayout(layout);
		voltagePanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("voltage")));
		
		voltagePanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm"));
		voltagePanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm);

		voltagePanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm"));
		voltagePanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm);

		voltagePanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning"));
		voltagePanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning);

		voltagePanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning"));
		voltagePanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning);
		return voltagePanel;
	}

	public JPanel getBiasPanel() {
		JPanel biasPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		biasPanel.setLayout(layout);
		biasPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("bias")));

		biasPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm"));
		biasPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm);

		biasPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm"));
		biasPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm);

		biasPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning"));
		biasPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning);

		biasPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning"));
		biasPanel.add(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning);

		return biasPanel;
	}

	public JPanel getTxPowerPanel() {
		JPanel txPowerPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		txPowerPanel.setLayout(layout);
		txPowerPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("txPower")));

		txPowerPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm"));
		txPowerPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm);

		txPowerPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm"));
		txPowerPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm);

		txPowerPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning"));
		txPowerPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning);

		txPowerPanel.add(new JLabel(
				utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning));
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning
				.setName(fStringMap
						.getString("utsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning"));
		txPowerPanel
				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning);
		return txPowerPanel;

	}

//	public JPanel getRxPowerPanel() {
//		JPanel rxPowerPanel = new JPanel();
//		NTLayout layout = new NTLayout(4, 2, NTLayout.FILL, NTLayout.CENTER, 5,
//				5);
//		layout.setMargins(6, 10, 6, 10);
//		rxPowerPanel.setLayout(layout);
//		rxPowerPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
//				.getString("rxPower")));
//		rxPowerPanel.add(new JLabel(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm));
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm
//				.setName(fStringMap
//						.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm"));
//		rxPowerPanel
//				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm);
//
//		rxPowerPanel.add(new JLabel(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm));
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm
//				.setName(fStringMap
//						.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm"));
//		rxPowerPanel
//				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm);
//
//		rxPowerPanel.add(new JLabel(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning));
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning
//				.setName(fStringMap
//						.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning"));
//		rxPowerPanel
//				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning);
//
//		rxPowerPanel.add(new JLabel(
//				utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning));
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning
//				.setName(fStringMap
//						.getString("utsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning"));
//		rxPowerPanel
//				.add(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning);
//
//		return rxPowerPanel;
//	}

	protected void initForm() {

	}

	public void refresh() {
		Dot3Onu2OPTDTable mbean = (Dot3Onu2OPTDTable) getModel();

		tfUtsDot3OnuOpticalTransceiverDiagnosisModuleId.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisModuleId().toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisDeviceId.setText(mbean.getUtsDot3OnuOpticalTransceiverDiagnosisDeviceId().toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisPortId.setText(mbean.getUtsDot3OnuOpticalTransceiverDiagnosisPortId().toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId.setText(mbean.getUtsDot3OnuOpticalTransceiverDiagnosisLogicalPortId().toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisTemperature.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisTemperature().toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltage.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisVoltage()
				.toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent()
				.toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPower.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisTxPower()
				.toString());
		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPower.setText(mbean
				.getUtsDot3OnuOpticalTransceiverDiagnosisRxPower()
				.toString());	
//		tfUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3OnuOpticalTransceiverDiagnosisAlarmOperationVList,
//						mbean
//								.getUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation()
//								.intValue()));
//		tfUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3OnuOpticalTransceiverDiagnosisPmSwitchVList,
//						mbean
//								.getUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch()
//								.intValue()));
//		
//		
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning()
//				.intValue());
//		
//		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning
//				.setValue(mbean
//						.getUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning()
//						.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning()
//				.intValue());
//		
//		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning()
//				.intValue());
//		 
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning
//				.setValue(mbean
//						.getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning()
//						.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning()
//				.intValue());
		 
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm()
//				.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning
//				.setValue(mbean
//						.getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning()
//						.intValue());
//		tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning.setValue(mbean
//				.getUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning()
//				.intValue());

	}

	public void updateModel() {

		Dot3Onu2OPTDTable mbean = (Dot3Onu2OPTDTable) getModel();

//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation(new Integer(
//						utsDot3OnuOpticalTransceiverDiagnosisAlarmOperationVList[tfUtsDot3OnuOpticalTransceiverDiagnosisAlarmOperation
//								.getSelectedIndex()]));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch(new Integer(
//						utsDot3OnuOpticalTransceiverDiagnosisPmSwitchVList[tfUtsDot3OnuOpticalTransceiverDiagnosisPmSwitch
//								.getSelectedIndex()]));
//		
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighAlarm
//						.getValue() * 256);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowAlarm
//						.getValue() * 256);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisTempHighWarning
//								.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisTempLowWarning
//								.getValue()));
//		
//		
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighAlarm
//						.getValue() * 1000);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowAlarm
//						.getValue() * 1000);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageHighWarning
//								.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisVoltageLowWarning
//								.getValue()));
//		 
//		
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighAlarm
//						.getValue() * 1000);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm(tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowAlarm
//						.getValue() * 1000);
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisBiasHighWarning
//								.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisBiasLowWarning
//								.getValue()));	
//
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm(format(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighAlarm
//						.getValue()));
//
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm(format(tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowAlarm
//						.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerHighWarning
//								.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisTxPowerLowWarning
//								.getValue()));
		
		
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm(format(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighAlarm
//						.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm(format(tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowAlarm
//						.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerHighWarning
//								.getValue()));
//		mbean
//				.setUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning(new Integer(
//						tfUtsDot3OnuOpticalTransceiverDiagnosisRxPowerLowWarning
//								.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

	int format(int value) {
		double d = Math.pow(10, value / (double) 10) * 10000;

		return (int) Math.round(d);
	}
}
