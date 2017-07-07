/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2DbaGlbTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2TrafficProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The aaPanel class. Created by DVM Creator
 */
public class Dot3Onu2TrafficProfTablePanel extends UPanel {

	private JLabel tfUtsDot3OnuTProfModuleId = new JLabel();

	// private JLabel tfUtsDot3OnuTProfDeviceId = new JLabel();

	private JLabel tfUtsDot3OnuTProfPortId = new JLabel();

	private JLabel tfUtsDot3OnuTProfLogicalPortId = new JLabel();

	private IntegerTextField tfUtsDot3OnuUpstreamPir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamPir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamCir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamCir = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamMaxBurstSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuDownstreamMaxBurstSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamWeight = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamFir = new IntegerTextField();

	private int[] utsDot3OnuShaperActionVList = new int[] { 3, 2, 1, };
	private String[] utsDot3OnuShaperActionTList = new String[] {
			fStringMap.getString("pir"), fStringMap.getString("cir"),
			fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OnuShaperAction = new JComboBox(
			utsDot3OnuShaperActionTList);

  private int[] utsDot3OnuPolicingActionVList = new int[]{
    5, 4, 1, 2, 3, 6, };
  private String[] utsDot3OnuPolicingActionTList = new String[]{
    fStringMap.getString("drop-cir"),
    fStringMap.getString("mark-cir-drop-pir"),
    fStringMap.getString("disable"),
    fStringMap.getString("mark-cir"),
    fStringMap.getString("mark-pir"),
    fStringMap.getString("drop-pir"),
  };
  private JComboBox tfUtsDot3OnuUpsPolicingAction = new JComboBox(utsDot3OnuPolicingActionTList);
  private JComboBox tfUtsDot3OnuDownsPolicingAction = new JComboBox(utsDot3OnuPolicingActionTList);

	private final String utsDot3OnuTProfModuleId = fStringMap
			.getString("utsDot3OnuTProfModuleId")
			+ " : ";
	// private final String utsDot3OnuTProfDeviceId =
	// fStringMap.getString("utsDot3OnuTProfDeviceId") + " : ";
	private final String utsDot3OnuTProfPortId = fStringMap
			.getString("utsDot3OnuTProfPortId")
			+ " : ";
	private final String utsDot3OnuTProfLogicalPortId = fStringMap
			.getString("utsDot3OnuTProfLogicalPortId")
			+ " : ";
	private final String utsDot3OnuUpstreamPir = fStringMap
			.getString("utsDot3OnuUpstreamPir")
			+ " : ";
	private final String utsDot3OnuDownstreamPir = fStringMap
			.getString("utsDot3OnuDownstreamPir")
			+ " : ";
	private final String utsDot3OnuUpstreamCir = fStringMap
			.getString("utsDot3OnuUpstreamCir")
			+ " : ";
	private final String utsDot3OnuDownstreamCir = fStringMap
			.getString("utsDot3OnuDownstreamCir")
			+ " : ";
	private final String utsDot3OnuUpstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuUpstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuDownstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuDownstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuUpstreamWeight = fStringMap
			.getString("utsDot3OnuUpstreamWeight")
			+ " : ";
	private final String utsDot3OnuUpstreamFir = fStringMap
			.getString("utsDot3OnuUpstreamFir")
			+ " : ";
	private final String utsDot3OnuShaperAction = fStringMap
			.getString("utsDot3OnuShaperAction")
			+ " : ";

  private final String utsDot3OnuUpsPolicingAction = fStringMap.getString("utsDot3OnuUpsPolicingAction") + " : ";
  private final String utsDot3OnuDownsPolicingAction = fStringMap.getString("utsDot3OnuDownsPolicingAction") + " : ";

	public Dot3Onu2TrafficProfTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(14, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuTProfModuleId));
		baseInfoPanel.add(tfUtsDot3OnuTProfModuleId);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuTProfDeviceId));
		// baseInfoPanel.add(tfUtsDot3OnuTProfDeviceId);
		// baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuTProfPortId));
		baseInfoPanel.add(tfUtsDot3OnuTProfPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuTProfLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuTProfLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamPir));
		tfUtsDot3OnuUpstreamPir.setName(fStringMap
				.getString("utsDot3OnuUpstreamPir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamPir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamPir));
		tfUtsDot3OnuDownstreamPir.setName(fStringMap
				.getString("utsDot3OnuDownstreamPir"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamPir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamCir));
		tfUtsDot3OnuUpstreamCir.setName(fStringMap
				.getString("utsDot3OnuUpstreamCir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamCir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamCir));
		tfUtsDot3OnuDownstreamCir.setName(fStringMap
				.getString("utsDot3OnuDownstreamCir"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamCir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamMaxBurstSize));
		tfUtsDot3OnuUpstreamMaxBurstSize.setName(fStringMap
				.getString("utsDot3OnuUpstreamMaxBurstSize"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamMaxBurstSize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamMaxBurstSize));
		tfUtsDot3OnuDownstreamMaxBurstSize.setName(fStringMap
				.getString("utsDot3OnuDownstreamMaxBurstSize"));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamMaxBurstSize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamWeight));
		tfUtsDot3OnuUpstreamWeight.setName(fStringMap
				.getString("utsDot3OnuUpstreamWeight"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamWeight);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamFir));
		tfUtsDot3OnuUpstreamFir.setName(fStringMap
				.getString("utsDot3OnuUpstreamFir"));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamFir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuShaperAction));
		tfUtsDot3OnuShaperAction.setName(fStringMap
				.getString("utsDot3OnuShaperAction"));
		baseInfoPanel.add(tfUtsDot3OnuShaperAction);
		baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OnuUpsPolicingAction));
    tfUtsDot3OnuUpsPolicingAction.setName(fStringMap.getString("utsDot3OnuUpsPolicingAction"));
    baseInfoPanel.add(tfUtsDot3OnuUpsPolicingAction);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OnuDownsPolicingAction));
    tfUtsDot3OnuDownsPolicingAction.setName(fStringMap.getString("utsDot3OnuDownsPolicingAction"));
    baseInfoPanel.add(tfUtsDot3OnuDownsPolicingAction);
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
		tfUtsDot3OnuUpstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuDownstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuUpstreamWeight.setValueScope(1, 10);
		tfUtsDot3OnuUpstreamFir.setValueScope(0, 1000000);
	}

	public boolean validateFrom() {
		if (tfUtsDot3OnuUpstreamCir.getValue() > tfUtsDot3OnuUpstreamPir
				.getValue()) {
			String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		if (tfUtsDot3OnuDownstreamCir.getValue() > tfUtsDot3OnuDownstreamPir
				.getValue()) {
			String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		//
		Dot3Onu2TrafficProfTable model = (Dot3Onu2TrafficProfTable) getModel();

		int module = model.getUtsDot3OnuTProfModuleId().intValue();
		int port = model.getUtsDot3OnuTProfPortId().intValue();
		int onu = model.getUtsDot3OnuTProfLogicalPortId().intValue();

		Dot3Onu2TrafficProfTable mbean = new Dot3Onu2TrafficProfTable(
				fApplication.getSnmpProxy());
		int usTotalCommit = 0;
		int dsTotalCommit = 0;

		/* The port ifIndex is the previous row data. */
		mbean.setUtsDot3OnuTProfModuleId(model.getUtsDot3OnuTProfModuleId());
		mbean.setUtsDot3OnuTProfDeviceId(model.getUtsDot3OnuTProfDeviceId());
		mbean.setUtsDot3OnuTProfPortId(model.getUtsDot3OnuTProfPortId());
		mbean.setUtsDot3OnuTProfLogicalPortId(new Integer(0));

		mbean.setRowsToFetch(64);
		Vector v = BeanService.refreshTableBean(fApplication, mbean);

		if (v != null) {
			for (int i = 0; i < v.size(); i++) {
				Dot3Onu2TrafficProfTable one = (Dot3Onu2TrafficProfTable) v
						.get(i);
				if (one.getUtsDot3OnuTProfModuleId().intValue() == module
						&& one.getUtsDot3OnuTProfPortId().intValue() == port
						&& one.getUtsDot3OnuTProfLogicalPortId().intValue() != onu) {
					usTotalCommit += one.getUtsDot3OnuUpstreamCir().intValue();
					dsTotalCommit += one.getUtsDot3OnuDownstreamCir()
							.intValue();
				}
			}

			int usLeftCommit = 1000000 - usTotalCommit;
			int dsLeftCommit = 1000000 - dsTotalCommit;
			if (tfUtsDot3OnuUpstreamCir.getValue() > usLeftCommit) {
				String error = fStringMap
						.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
						+ module
						+ "/"
						+ port
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
						+ "\r\n"
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3")
						+ +usLeftCommit
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");

				MessageDialog.showErrorMessageDialog(fApplication, error);
				return false;
			}

			if (tfUtsDot3OnuDownstreamCir.getValue() > dsLeftCommit) {
				String error = fStringMap
						.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
						+ module
						+ "/"
						+ port
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2")
						+ "\r\n"
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_3")
						+ +usLeftCommit
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_4");
				MessageDialog.showErrorMessageDialog(fApplication, error);
				return false;
			}
		}
		return true;
	}

	public void refresh() {
        tfUtsDot3OnuUpstreamFir.setEnabled(true);
		Dot3Onu2TrafficProfTable mbean = (Dot3Onu2TrafficProfTable) getModel();
		
		Dot3Olt2DbaGlbTable bean = new Dot3Olt2DbaGlbTable(fApplication.getSnmpProxy());
		Vector dbas = BeanService.refreshTableBean(fApplication, bean);
		for(int i = 0 ; i<dbas.size(); i++){
		    Dot3Olt2DbaGlbTable dba = (Dot3Olt2DbaGlbTable)dbas.get(i);
		    if(dba.getUtsDot3OltModuleId().intValue()==mbean.getUtsDot3OnuTProfModuleId().intValue())
		    {
		        if(dba.getUtsDot3OltDbaMode().intValue()!=2)
		            tfUtsDot3OnuUpstreamFir.setEnabled(false);
		    }
		}
		
		tfUtsDot3OnuTProfModuleId.setText(mbean.getUtsDot3OnuTProfModuleId()
				.toString());
		// tfUtsDot3OnuTProfDeviceId.setText(mbean.getUtsDot3OnuTProfDeviceId().toString());
		tfUtsDot3OnuTProfPortId.setText(mbean.getUtsDot3OnuTProfPortId()
				.toString());
		tfUtsDot3OnuTProfLogicalPortId.setText(mbean
				.getUtsDot3OnuTProfLogicalPortId().toString());
		tfUtsDot3OnuUpstreamPir.setValue(mbean.getUtsDot3OnuUpstreamPir()
				.intValue());
		tfUtsDot3OnuDownstreamPir.setValue(mbean.getUtsDot3OnuDownstreamPir()
				.intValue());
		tfUtsDot3OnuUpstreamCir.setValue(mbean.getUtsDot3OnuUpstreamCir()
				.intValue());
		tfUtsDot3OnuDownstreamCir.setValue(mbean.getUtsDot3OnuDownstreamCir()
				.intValue());
		tfUtsDot3OnuUpstreamMaxBurstSize.setValue(mbean
				.getUtsDot3OnuUpstreamMaxBurstSize().intValue());
		tfUtsDot3OnuDownstreamMaxBurstSize.setValue(mbean
				.getUtsDot3OnuDownstreamMaxBurstSize().intValue());
		tfUtsDot3OnuUpstreamWeight.setValue(mbean.getUtsDot3OnuUpstreamWeight()
				.intValue());
		tfUtsDot3OnuUpstreamFir.setValue(mbean.getUtsDot3OnuUpstreamFir()
				.intValue());
		tfUtsDot3OnuShaperAction.setSelectedIndex(getIndexFromValue(
				utsDot3OnuShaperActionVList, mbean.getUtsDot3OnuShaperAction()
						.intValue()));
    tfUtsDot3OnuUpsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuUpsPolicingAction().intValue()));
    tfUtsDot3OnuDownsPolicingAction.setSelectedIndex(getIndexFromValue(utsDot3OnuPolicingActionVList, mbean.getUtsDot3OnuDownsPolicingAction().intValue()));
  }

	public void updateModel() {
		Dot3Onu2TrafficProfTable mbean = (Dot3Onu2TrafficProfTable) getModel();

		mbean.setUtsDot3OnuUpstreamPir(new Integer(tfUtsDot3OnuUpstreamPir
				.getValue()));
		mbean.setUtsDot3OnuDownstreamPir(new Integer(tfUtsDot3OnuDownstreamPir
				.getValue()));
		mbean.setUtsDot3OnuUpstreamCir(new Integer(tfUtsDot3OnuUpstreamCir
				.getValue()));
		mbean.setUtsDot3OnuDownstreamCir(new Integer(tfUtsDot3OnuDownstreamCir
				.getValue()));
		mbean.setUtsDot3OnuUpstreamMaxBurstSize(new Integer(
				tfUtsDot3OnuUpstreamMaxBurstSize.getValue()));
		mbean.setUtsDot3OnuDownstreamMaxBurstSize(new Integer(
				tfUtsDot3OnuDownstreamMaxBurstSize.getValue()));
		mbean.setUtsDot3OnuUpstreamWeight(new Integer(
				tfUtsDot3OnuUpstreamWeight.getValue()));
		if(tfUtsDot3OnuUpstreamFir.isEnabled()) {
	        mbean.setUtsDot3OnuUpstreamFir(new Integer(tfUtsDot3OnuUpstreamFir.getValue()));
		}
		
		if(utsDot3OnuShaperActionVList[tfUtsDot3OnuShaperAction.getSelectedIndex()] != mbean.getUtsDot3OnuShaperAction()) {
	        mbean.setUtsDot3OnuShaperAction(new Integer(utsDot3OnuShaperActionVList[tfUtsDot3OnuShaperAction.getSelectedIndex()]));
		}
		
		if(utsDot3OnuPolicingActionVList[tfUtsDot3OnuUpsPolicingAction.getSelectedIndex()] != mbean.getUtsDot3OnuUpsPolicingAction()) {
		    mbean.setUtsDot3OnuUpsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuUpsPolicingAction.getSelectedIndex()]));
		}
		
		if(utsDot3OnuPolicingActionVList[tfUtsDot3OnuDownsPolicingAction.getSelectedIndex()] != mbean.getUtsDot3OnuDownsPolicingAction()) {
		    mbean.setUtsDot3OnuDownsPolicingAction(new Integer(utsDot3OnuPolicingActionVList[tfUtsDot3OnuDownsPolicingAction.getSelectedIndex()]));
		}
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
