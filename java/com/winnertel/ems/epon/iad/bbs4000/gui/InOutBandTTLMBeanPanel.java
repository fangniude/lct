/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.InOutBandTTLMBean;
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

import javax.swing.*;
import java.awt.*;

/**
 * The InOutBandTTLMBeanPanel class.
 * Created by DVM Creator
 */
public class InOutBandTTLMBeanPanel extends UPanel {

	private IntegerTextField tfUtsBBSMgmtTrafficInBandTTL = new IntegerTextField();

	private IntegerTextField tfUtsBBSMgmtTrafficOutBandTTL = new IntegerTextField();

	private final String utsBBSMgmtTrafficInBandTTL = fStringMap
			.getString("utsBBSMgmtTrafficInBandTTL")
			+ " : ";

	private final String utsBBSMgmtTrafficOutBandTTL = fStringMap
			.getString("utsBBSMgmtTrafficOutBandTTL")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public InOutBandTTLMBeanPanel(IApplication app) {
		super(app);
		setModel(new InOutBandTTLMBean(app.getSnmpProxy()));
		init();
	}

	public void initGui() {

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_InOutBandTTLMBean");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBBSMgmtTrafficInBandTTL));
		tfUtsBBSMgmtTrafficInBandTTL.setName(fStringMap
				.getString("utsBBSMgmtTrafficInBandTTL"));
		baseInfoPanel.add(tfUtsBBSMgmtTrafficInBandTTL);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSMgmtTrafficOutBandTTL));
		tfUtsBBSMgmtTrafficOutBandTTL.setName(fStringMap
				.getString("utsBBSMgmtTrafficOutBandTTL"));
		baseInfoPanel.add(tfUtsBBSMgmtTrafficOutBandTTL);
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
		tfUtsBBSMgmtTrafficInBandTTL.setValueScope(1, 255);

		tfUtsBBSMgmtTrafficOutBandTTL.setValueScope(1, 255);

	}

	public void refresh() {
		InOutBandTTLMBean mbean = (InOutBandTTLMBean) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsBBSMgmtTrafficInBandTTL.setValue(mbean.getUtsBBSMgmtTrafficInBandTTL().intValue());
		tfUtsBBSMgmtTrafficOutBandTTL.setValue(mbean.getUtsBBSMgmtTrafficOutBandTTL().intValue());
	}

	public void updateModel() {

		InOutBandTTLMBean mbean = (InOutBandTTLMBean) getModel();

		mbean.setUtsBBSMgmtTrafficInBandTTL(new Integer(tfUtsBBSMgmtTrafficInBandTTL.getValue()));
		mbean.setUtsBBSMgmtTrafficOutBandTTL(new Integer(tfUtsBBSMgmtTrafficOutBandTTL.getValue()));
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
