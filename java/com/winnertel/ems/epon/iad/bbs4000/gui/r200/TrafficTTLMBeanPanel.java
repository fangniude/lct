/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.TrafficTTLMBean;
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
public class TrafficTTLMBeanPanel extends UPanel {

	private IntegerTextField tfUtsBBSMgmtTrafficTTL = new IntegerTextField();

	private final String utsBBSMgmtTrafficTTL = fStringMap.getString("utsBBSMgmtTrafficTTL") + " : ";

	private SnmpApplyButton btApply;
	private SnmpRefreshButton btRefresh;

	public TrafficTTLMBeanPanel(IApplication app) {
		super(app);
		setModel(new TrafficTTLMBean(app.getSnmpProxy()));
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
		NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBBSMgmtTrafficTTL));
		tfUtsBBSMgmtTrafficTTL.setName(fStringMap.getString("utsBBSMgmtTrafficTTL"));
		baseInfoPanel.add(tfUtsBBSMgmtTrafficTTL);
		baseInfoPanel.add(new HSpacer());
		baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("InBand_OutBand_TTL")));
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
		tfUtsBBSMgmtTrafficTTL.setValueScope(1, 255);
	}

	public void refresh() {
		TrafficTTLMBean mbean = (TrafficTTLMBean) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsBBSMgmtTrafficTTL.setValue(mbean.getUtsBBSMgmtTrafficTTL().intValue());
	}

	public void updateModel() {
		TrafficTTLMBean mbean = (TrafficTTLMBean) getModel();

		mbean.setUtsBBSMgmtTrafficTTL(new Integer(tfUtsBBSMgmtTrafficTTL.getValue()));
	}
}
