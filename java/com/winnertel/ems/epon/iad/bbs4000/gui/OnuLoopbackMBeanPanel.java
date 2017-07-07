/*
 * @(#)OnuLookbackMBeanPanel.java
 * Created on 2006-10-20, ����03:03:16
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.OnuLoopbackMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * TODO: add function declaration here
 * 
 * @version 1.0.0, 2006-10-20
 * @author ZhouTao(zhoutao@utstar.com)
 */
public class OnuLoopbackMBeanPanel extends UPanel {

	private JLabel tfIfIndex = new JLabel();

	private String[] utsDot3OnuRegistrationStateTList = new String[] {
			fStringMap.getString("pending"),
			fStringMap.getString("unregistered"),
			fStringMap.getString("registered"), };

	private int[] utsDot3OnuPonLoopbackTestStatusVList = new int[] { 1, 2, };

	private String[] utsDot3OnuPonLoopbackTestStatusTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsDot3OnuPonLoopbackTestStatus = new JComboBox(
			utsDot3OnuPonLoopbackTestStatusTList);

	private IntegerTextField tfUtsDot3OnuPonLoopbackTestVlanId = new IntegerTextField();

	private final String ifIndex = fStringMap.getString("ifIndex") + " : ";

	private final String utsDot3OnuRegistrationState = fStringMap
			.getString("utsDot3OnuRegistrationState")
			+ " : ";

	private final String utsDot3OnuPonLoopbackTestStatus = fStringMap
			.getString("utsDot3OnuPonLoopbackTestStatus")
			+ " : ";

	private final String utsDot3OnuPonLoopbackTestVlanId = fStringMap
			.getString("utsDot3OnuPonLoopbackTestVlanId")
			+ " : ";

	public OnuLoopbackMBeanPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuPonLoopbackTestStatus));
		tfUtsDot3OnuPonLoopbackTestStatus.setName(fStringMap
				.getString("utsDot3OnuPonLoopbackTestStatus"));
		baseInfoPanel.add(tfUtsDot3OnuPonLoopbackTestStatus);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuPonLoopbackTestVlanId));
		tfUtsDot3OnuPonLoopbackTestVlanId.setName(fStringMap
				.getString("utsDot3OnuPonLoopbackTestVlanId"));
		baseInfoPanel.add(tfUtsDot3OnuPonLoopbackTestVlanId);
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
		tfUtsDot3OnuPonLoopbackTestVlanId.setValueScope(1, 4094);
	}

	public void refresh() {

		OnuLoopbackMBean mbean = (OnuLoopbackMBean) getModel();
		
		tfIfIndex.setText( ConfigUtility.formatIfIndex(mbean.getIfOnuIndex().toString()) );

		// make reverse selection of loopback test status, and set it disable.
		tfUtsDot3OnuPonLoopbackTestStatus.setSelectedIndex(getIndexFromValue(
				utsDot3OnuPonLoopbackTestStatusVList, 3 - mbean.getUtsDot3OnuPonLoopbackTestStatus().intValue()));
		tfUtsDot3OnuPonLoopbackTestStatus.setEnabled( false );

		tfUtsDot3OnuPonLoopbackTestVlanId.setValue(mbean.getUtsDot3OnuPonLoopbackTestVlanId().intValue());
	}

	public void updateModel() {

		OnuLoopbackMBean mbean = (OnuLoopbackMBean) getModel();

		mbean.setUtsDot3OnuPonLoopbackTestStatus( new Integer(utsDot3OnuPonLoopbackTestStatusVList[tfUtsDot3OnuPonLoopbackTestStatus.getSelectedIndex()]) );

		mbean.setUtsDot3OnuPonLoopbackTestVlanId( new Integer(tfUtsDot3OnuPonLoopbackTestVlanId.getValue()) );
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
