/*
 * @(#)OnuLinktestMBeanPanel.java
 * Created on 2006-10-20, ����04:01:30
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.OnuLinktestMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;

/**
 * The OnuLinktestMBeanPanel class.
 * Created by DVM Creator
 */
public class OnuLinktestMBeanPanel extends UPanel {

	private JLabel tfIfIndex = new JLabel();

	private IntegerTextField tfUtsDot3OnuOAMLinktestTotalFrame = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuOAMLinktestFrameSize = new IntegerTextField();

	private int[] utsDot3OnuOAMStartTestVList = new int[] { 2, 1, 3, };

	private String[] utsDot3OnuOAMStartTestTList = new String[] {
			fStringMap.getString("onulinktest"),
			fStringMap.getString("onuloopbacktest"),
			fStringMap.getString("onupingtest"), };

	private JComboBox tfUtsDot3OnuOAMStartTest = new JComboBox(
			utsDot3OnuOAMStartTestTList);

	private int[] utsDot3OnuOAMLinkTestStatusVList = new int[] { 3, 1, 2, };

	private String[] utsDot3OnuOAMLinkTestStatusTList = new String[] {
			fStringMap.getString("busy"), fStringMap.getString("success"),
			fStringMap.getString("failure"), };

	private JComboBox tfUtsDot3OnuOAMLinkTestStatus = new JComboBox(
			utsDot3OnuOAMLinkTestStatusTList);

	private StringTextField tfUtsDot3OnuOAMLinkTestStationId = new StringTextField();

	private StringTextField tfUtsDot3OnuOAMPingStationId = new StringTextField();

	private final String utsDot3OnuOAMLinktestTotalFrame = fStringMap
			.getString("utsDot3OnuOAMLinktestTotalFrame")
			+ " : ";

	private final String utsDot3OnuOAMLinktestFrameSize = fStringMap
			.getString("utsDot3OnuOAMLinktestFrameSize")
			+ " : ";

	public OnuLinktestMBeanPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestTotalFrame));
		tfUtsDot3OnuOAMLinktestTotalFrame.setName(fStringMap
				.getString("utsDot3OnuOAMLinktestTotalFrame"));
		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestTotalFrame);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOAMLinktestFrameSize));
		tfUtsDot3OnuOAMLinktestFrameSize.setName(fStringMap
				.getString("utsDot3OnuOAMLinktestFrameSize"));
		baseInfoPanel.add(tfUtsDot3OnuOAMLinktestFrameSize);
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

		tfUtsDot3OnuOAMLinktestTotalFrame.setValueScope(0, 1000);
		tfUtsDot3OnuOAMLinktestTotalFrame.setDefaultValue( 1 );

		tfUtsDot3OnuOAMLinktestFrameSize.setValueScope(60, 1514);

		tfUtsDot3OnuOAMLinkTestStationId.setLenScope(0, 16);

		tfUtsDot3OnuOAMPingStationId.setLenScope(0, 16);

	}

	public void refresh() {

		OnuLinktestMBean mbean = (OnuLinktestMBean) getModel();

		tfIfIndex.setText(mbean.getIfOnuIndex().toString());

		tfUtsDot3OnuOAMLinktestFrameSize.setValue(mbean.getUtsDot3OnuOAMLinktestFrameSize().intValue());

		tfUtsDot3OnuOAMLinkTestStatus.setSelectedIndex(getIndexFromValue(
				utsDot3OnuOAMLinkTestStatusVList, mbean.getUtsDot3OnuOAMLinkTestStatus().intValue()));

		tfUtsDot3OnuOAMLinkTestStationId.setValue(mbean.getUtsDot3OnuOAMLinkTestStationId());
	}

	public void updateModel() {

		try {
			OnuLinktestMBean mbean = (OnuLinktestMBean) getModel();
	
			mbean.setUtsDot3OnuOAMLinktestTotalFrame(new Integer(
					tfUtsDot3OnuOAMLinktestTotalFrame.getValue()));
	
			mbean.setUtsDot3OnuOAMLinktestFrameSize(new Integer(
					tfUtsDot3OnuOAMLinktestFrameSize.getValue()));
	
			mbean.setUtsDot3OnuOAMStartTest( new Integer("2") );
	
			String emsServerIp = InetAddress.getLocalHost().getHostAddress();
			mbean.setUtsDot3OnuOAMLinkTestStationId(emsServerIp);

		} catch (Exception ex) {
			ex.printStackTrace();
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
