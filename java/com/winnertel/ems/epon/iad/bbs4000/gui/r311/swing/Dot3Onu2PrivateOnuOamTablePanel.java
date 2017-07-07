package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2PrivateOnuOamTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2PrivateOnuOamTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2PrivateOnuOamTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2MacAgingTimeModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2MacAgingTimeDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimePortId = new JLabel();

	private JLabel tfUtsDot3Onu2MacAgingTimeLogicalPortId = new JLabel();

	private int[] utsDot3Onu2PrivateOnuOamRstpVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2PrivateOnuOamRstpTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2PrivateOnuOamRstp = new JComboBox(
			utsDot3Onu2PrivateOnuOamRstpTList);
	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos0 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos1 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos2 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos3 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos4 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos5 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos6 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamCos7 = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamMirrorToPort = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamMirroredPort1 = new IntegerTextField();
	
	private int[] utsDot3Onu2PrivateOnuOamPortIsolateVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2PrivateOnuOamPortIsolateTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2PrivateOnuOamPortIsolate = new JComboBox(
			utsDot3Onu2PrivateOnuOamPortIsolateTList);

	private int[] utsDot3Onu2PrivateOnuOamMirroredPort1ModeVList = new int[] {
			1, 3, 2, };
	private String[] utsDot3Onu2PrivateOnuOamMirroredPort1ModeTList = new String[] {
			fStringMap.getString("rx-mirror"), fStringMap.getString("both"),
			fStringMap.getString("tx-mirror"), };
	private JComboBox tfUtsDot3Onu2PrivateOnuOamMirroredPort1Mode = new JComboBox(
			utsDot3Onu2PrivateOnuOamMirroredPort1ModeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamMirroredPort2 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateOnuOamMirroredPort2ModeVList = new int[] {
			1, 3, 2, };
	private String[] utsDot3Onu2PrivateOnuOamMirroredPort2ModeTList = new String[] {
			fStringMap.getString("rx-mirror"), fStringMap.getString("both"),
			fStringMap.getString("tx-mirror"), };
	private JComboBox tfUtsDot3Onu2PrivateOnuOamMirroredPort2Mode = new JComboBox(
			utsDot3Onu2PrivateOnuOamMirroredPort2ModeTList);
	private IntegerTextField tfUtsDot3Onu2PrivateOnuOamMirroredPort3 = new IntegerTextField();

	private int[] utsDot3Onu2PrivateOnuOamMirroredPort3ModeVList = new int[] {
			1, 3, 2, };
	private String[] utsDot3Onu2PrivateOnuOamMirroredPort3ModeTList = new String[] {
			fStringMap.getString("rx-mirror"), fStringMap.getString("both"),
			fStringMap.getString("tx-mirror"), };
	private JComboBox tfUtsDot3Onu2PrivateOnuOamMirroredPort3Mode = new JComboBox(
			utsDot3Onu2PrivateOnuOamMirroredPort3ModeTList);

	private final String utsDot3Onu2MacAgingTimeModuleId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeModuleId")
			+ " : ";
//	private final String utsDot3Onu2MacAgingTimeDeviceId = fStringMap
//			.getString("utsDot3Onu2MacAgingTimeDeviceId")
//			+ " : ";
	private final String utsDot3Onu2MacAgingTimePortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimePortId")
			+ " : ";
	private final String utsDot3Onu2MacAgingTimeLogicalPortId = fStringMap
			.getString("utsDot3Onu2MacAgingTimeLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamRstp = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamRstp")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos0 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos0")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos1 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos1")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos2 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos2")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos3 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos3")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos4 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos4")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos5 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos5")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos6 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos6")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamCos7 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamCos7")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirrorToPort = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirrorToPort")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort1 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort1")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort1Mode = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort1Mode")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort2 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort2")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort2Mode = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort2Mode")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort3 = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort3")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamMirroredPort3Mode = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamMirroredPort3Mode")
			+ " : ";
	private final String utsDot3Onu2PrivateOnuOamPortIsolate = fStringMap
			.getString("utsDot3Onu2PrivateOnuOamPortIsolate")
			+ " : ";
	
	public Dot3Onu2PrivateOnuOamTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(20, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimePortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimePortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2MacAgingTimeLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2MacAgingTimeLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamRstp));
		tfUtsDot3Onu2PrivateOnuOamRstp.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamRstp"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamRstp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos0));
		tfUtsDot3Onu2PrivateOnuOamCos0.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos0"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos0);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos1));
		tfUtsDot3Onu2PrivateOnuOamCos1.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos1"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos2));
		tfUtsDot3Onu2PrivateOnuOamCos2.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos2"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos2);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos3));
		tfUtsDot3Onu2PrivateOnuOamCos3.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos3"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos4));
		tfUtsDot3Onu2PrivateOnuOamCos4.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos4"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos4);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos5));
		tfUtsDot3Onu2PrivateOnuOamCos5.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos5"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos5);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos6));
		tfUtsDot3Onu2PrivateOnuOamCos6.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos6"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos6);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamCos7));
		tfUtsDot3Onu2PrivateOnuOamCos7.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamCos7"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamCos7);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamMirrorToPort));
		tfUtsDot3Onu2PrivateOnuOamMirrorToPort.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirrorToPort"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirrorToPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort1));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort1.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort1"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort1Mode));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort1Mode.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort1Mode"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort1Mode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort2));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort2.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort2"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort2);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort2Mode));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort2Mode.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort2Mode"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort2Mode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort3));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort3.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort3"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3Onu2PrivateOnuOamMirroredPort3Mode));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort3Mode.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamMirroredPort3Mode"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamMirroredPort3Mode);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2PrivateOnuOamPortIsolate));
		tfUtsDot3Onu2PrivateOnuOamPortIsolate.setName(fStringMap
				.getString("utsDot3Onu2PrivateOnuOamPortIsolate"));
		baseInfoPanel.add(tfUtsDot3Onu2PrivateOnuOamPortIsolate);
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

		tfUtsDot3Onu2PrivateOnuOamCos0.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos1.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos2.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos3.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos4.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos5.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos6.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamCos7.setValueScope(0, 7);

		tfUtsDot3Onu2PrivateOnuOamMirrorToPort.setValueScope(1, 4);

		tfUtsDot3Onu2PrivateOnuOamMirroredPort1.setValueScope(0, 4);

		tfUtsDot3Onu2PrivateOnuOamMirroredPort2.setValueScope(0, 4);

		tfUtsDot3Onu2PrivateOnuOamMirroredPort3.setValueScope(0, 4);

	}

	public void refresh() {

		Dot3Onu2PrivateOnuOamTable mbean = (Dot3Onu2PrivateOnuOamTable) getModel();

		tfUtsDot3Onu2MacAgingTimeModuleId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeModuleId().toString());
//		tfUtsDot3Onu2MacAgingTimeDeviceId.setText(mbean
//				.getUtsDot3Onu2MacAgingTimeDeviceId().toString());
		tfUtsDot3Onu2MacAgingTimePortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimePortId().toString());
		tfUtsDot3Onu2MacAgingTimeLogicalPortId.setText(mbean
				.getUtsDot3Onu2MacAgingTimeLogicalPortId().toString());
		tfUtsDot3Onu2PrivateOnuOamRstp.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2PrivateOnuOamRstpVList, mbean
						.getUtsDot3Onu2PrivateOnuOamRstp().intValue()));
		tfUtsDot3Onu2PrivateOnuOamCos0.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos0().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos1.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos1().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos2.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos2().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos3.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos3().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos4.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos4().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos5.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos5().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos6.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos6().intValue());
		tfUtsDot3Onu2PrivateOnuOamCos7.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamCos7().intValue());
		tfUtsDot3Onu2PrivateOnuOamMirrorToPort.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamMirrorToPort().intValue());
		tfUtsDot3Onu2PrivateOnuOamMirroredPort1.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamMirroredPort1().intValue());
		tfUtsDot3Onu2PrivateOnuOamMirroredPort1Mode
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateOnuOamMirroredPort1ModeVList, mbean
								.getUtsDot3Onu2PrivateOnuOamMirroredPort1Mode()
								.intValue()));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort2.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamMirroredPort2().intValue());
		tfUtsDot3Onu2PrivateOnuOamMirroredPort2Mode
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateOnuOamMirroredPort2ModeVList, mbean
								.getUtsDot3Onu2PrivateOnuOamMirroredPort2Mode()
								.intValue()));
		tfUtsDot3Onu2PrivateOnuOamMirroredPort3.setValue(mbean
				.getUtsDot3Onu2PrivateOnuOamMirroredPort3().intValue());
		tfUtsDot3Onu2PrivateOnuOamMirroredPort3Mode
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateOnuOamMirroredPort3ModeVList, mbean
								.getUtsDot3Onu2PrivateOnuOamMirroredPort3Mode()
								.intValue()));
		tfUtsDot3Onu2PrivateOnuOamPortIsolate
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2PrivateOnuOamPortIsolateVList, mbean
								.getUtsDot3Onu2PrivateOnuOamPortIsolate()
								.intValue()));

	}

	public void updateModel() {

		Dot3Onu2PrivateOnuOamTable mbean = (Dot3Onu2PrivateOnuOamTable) getModel();

		mbean
				.setUtsDot3Onu2PrivateOnuOamRstp(new Integer(
						utsDot3Onu2PrivateOnuOamRstpVList[tfUtsDot3Onu2PrivateOnuOamRstp
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateOnuOamCos0(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos0.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos1(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos1.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos2(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos2.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos3(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos3.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos4(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos4.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos5(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos5.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos6(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos6.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamCos7(new Integer(
				tfUtsDot3Onu2PrivateOnuOamCos7.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamMirrorToPort(new Integer(
				tfUtsDot3Onu2PrivateOnuOamMirrorToPort.getValue()));
		mbean.setUtsDot3Onu2PrivateOnuOamMirroredPort1(new Integer(
				tfUtsDot3Onu2PrivateOnuOamMirroredPort1.getValue()));
		mbean
				.setUtsDot3Onu2PrivateOnuOamMirroredPort1Mode(new Integer(
						utsDot3Onu2PrivateOnuOamMirroredPort1ModeVList[tfUtsDot3Onu2PrivateOnuOamMirroredPort1Mode
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateOnuOamMirroredPort2(new Integer(
				tfUtsDot3Onu2PrivateOnuOamMirroredPort2.getValue()));
		mbean
				.setUtsDot3Onu2PrivateOnuOamMirroredPort2Mode(new Integer(
						utsDot3Onu2PrivateOnuOamMirroredPort2ModeVList[tfUtsDot3Onu2PrivateOnuOamMirroredPort2Mode
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2PrivateOnuOamMirroredPort3(new Integer(
				tfUtsDot3Onu2PrivateOnuOamMirroredPort3.getValue()));
		mbean
				.setUtsDot3Onu2PrivateOnuOamMirroredPort3Mode(new Integer(
						utsDot3Onu2PrivateOnuOamMirroredPort3ModeVList[tfUtsDot3Onu2PrivateOnuOamMirroredPort3Mode
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2PrivateOnuOamPortIsolate(new Integer(
						utsDot3Onu2PrivateOnuOamPortIsolateVList[tfUtsDot3Onu2PrivateOnuOamPortIsolate
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
