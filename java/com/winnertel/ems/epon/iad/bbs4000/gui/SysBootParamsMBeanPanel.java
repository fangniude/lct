/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.SysBootParamsMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The SysBootParamsMBeanPanel class.
 * Created by DVM Creator
 */
public class SysBootParamsMBeanPanel extends UPanel {

	private int[] utsBBSSysBootMethodVList = new int[] { 2, 1, };

	private String[] utsBBSSysBootMethodTList = new String[] {
			fStringMap.getString("Flash"), fStringMap.getString("Ftp"), };

	private JComboBox tfUtsBBSSysBootMethod = new JComboBox(
			utsBBSSysBootMethodTList);

	private StringTextField tfUtsBBSSysBootFileName = new StringTextField();

	private IPAddressField tfUtsBBSOutBandInterfaceIpAddr = new IPAddressField();

	private IPAddressField tfUtsBBSOutbandInterfaceIpMask = new IPAddressField( IPAddressField.IPMASK );

	private IPAddressField tfUtsBBSOutbandInterfaceNextHop = new IPAddressField();

	private StringTextField tfUtsBBSBootFTPUserName = new StringTextField();

	private StringTextField tfUtsBBSBootFTPPassword = new StringTextField();

	private IPAddressField tfUtsBBSBootFTPServerIpAddress = new IPAddressField();

	private final String utsBBSSysBootMethod = fStringMap
			.getString("utsBBSSysBootMethod")
			+ " : ";

	private final String utsBBSSysBootFileName = fStringMap
			.getString("utsBBSSysBootFileName")
			+ " : ";

	private final String utsBBSOutBandInterfaceIpAddr = fStringMap
			.getString("utsBBSOutBandInterfaceIpAddr")
			+ " : ";

	private final String utsBBSOutbandInterfaceIpMask = fStringMap
			.getString("utsBBSOutbandInterfaceIpMask")
			+ " : ";

	private final String utsBBSOutbandInterfaceNextHop = fStringMap
			.getString("utsBBSOutbandInterfaceNextHop")
			+ " : ";

	private final String utsBBSBootFTPUserName = fStringMap
			.getString("utsBBSBootFTPUserName")
			+ " : ";

	private final String utsBBSBootFTPPassword = fStringMap
			.getString("utsBBSBootFTPPassword")
			+ " : ";

	private final String utsBBSBootFTPServerIpAddress = fStringMap
			.getString("utsBBSBootFTPServerIpAddress")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public SysBootParamsMBeanPanel(IApplication app) {
		super(app);
		setModel(new SysBootParamsMBean(app.getSnmpProxy()));
		init();
	}

	public void initGui() {

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction()
				.putValue(BaseAction.ID, "Modify_SysBootParamsMBean");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBBSSysBootMethod));
		tfUtsBBSSysBootMethod.setName(fStringMap.getString("utsBBSSysBootMethod"));
		tfUtsBBSSysBootMethod.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String strSel = e.getItem().toString();
				setFieldEditable( strSel );
			}
		});

		baseInfoPanel.add(tfUtsBBSSysBootMethod);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysBootFileName));
		tfUtsBBSSysBootFileName.setName(fStringMap
				.getString("utsBBSSysBootFileName"));
		baseInfoPanel.add(tfUtsBBSSysBootFileName);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSOutBandInterfaceIpAddr));
		tfUtsBBSOutBandInterfaceIpAddr.setName(fStringMap
				.getString("utsBBSOutBandInterfaceIpAddr"));
		baseInfoPanel.add(tfUtsBBSOutBandInterfaceIpAddr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSOutbandInterfaceIpMask));
		tfUtsBBSOutbandInterfaceIpMask.setName(fStringMap
				.getString("utsBBSOutbandInterfaceIpMask"));
		baseInfoPanel.add(tfUtsBBSOutbandInterfaceIpMask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSOutbandInterfaceNextHop));
		tfUtsBBSOutbandInterfaceNextHop.setName(fStringMap
				.getString("utsBBSOutbandInterfaceNextHop"));
		baseInfoPanel.add(tfUtsBBSOutbandInterfaceNextHop);
		baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsBBSBootFTPServerIpAddress));
    tfUtsBBSBootFTPServerIpAddress.setName(fStringMap
        .getString("utsBBSBootFTPServerIpAddress"));
    baseInfoPanel.add(tfUtsBBSBootFTPServerIpAddress);
    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSBootFTPUserName));
		tfUtsBBSBootFTPUserName.setName(fStringMap
				.getString("utsBBSBootFTPUserName"));
		baseInfoPanel.add(tfUtsBBSBootFTPUserName);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSBootFTPPassword));
		tfUtsBBSBootFTPPassword.setName(fStringMap
				.getString("utsBBSBootFTPPassword"));
		baseInfoPanel.add(tfUtsBBSBootFTPPassword);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm() {

		tfUtsBBSSysBootFileName.setLenScope(0, 63);

		tfUtsBBSBootFTPUserName.setLenScope(0, 23);

		tfUtsBBSBootFTPPassword.setLenScope(0, 15);

	}

	public void refresh() {

		SysBootParamsMBean mbean = (SysBootParamsMBean) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsBBSSysBootMethod.setSelectedIndex(getIndexFromValue(
				utsBBSSysBootMethodVList, mbean.getUtsBBSSysBootMethod()
						.intValue()));
		
		setFieldEditable( tfUtsBBSSysBootMethod.getSelectedItem().toString() );
		
		tfUtsBBSSysBootFileName.setValue(mbean.getUtsBBSSysBootFileName());
		tfUtsBBSOutBandInterfaceIpAddr.setValue(mbean
				.getUtsBBSOutBandInterfaceIpAddr());
		tfUtsBBSOutbandInterfaceIpMask.setValue(mbean
				.getUtsBBSOutbandInterfaceIpMask());
		tfUtsBBSOutbandInterfaceNextHop.setValue(mbean
				.getUtsBBSOutbandInterfaceNextHop());
		tfUtsBBSBootFTPUserName.setValue(mbean.getUtsBBSBootFTPUserName());
		tfUtsBBSBootFTPPassword.setValue(mbean.getUtsBBSBootFTPPassword());
		tfUtsBBSBootFTPServerIpAddress.setValue(mbean
				.getUtsBBSBootFTPServerIpAddress());

	}

	public void updateModel() {

		SysBootParamsMBean mbean = (SysBootParamsMBean) getModel();

		mbean.setUtsBBSSysBootMethod(new Integer(
				utsBBSSysBootMethodVList[tfUtsBBSSysBootMethod
						.getSelectedIndex()]));
		mbean.setUtsBBSSysBootFileName(new String(tfUtsBBSSysBootFileName
				.getValue()));
		mbean.setUtsBBSOutBandInterfaceIpAddr(new String(
				tfUtsBBSOutBandInterfaceIpAddr.getIPString()));
		mbean.setUtsBBSOutbandInterfaceIpMask(new String(
				tfUtsBBSOutbandInterfaceIpMask.getIPString()));
		mbean.setUtsBBSOutbandInterfaceNextHop(new String(
				tfUtsBBSOutbandInterfaceNextHop.getIPString()));
		mbean.setUtsBBSBootFTPUserName(new String(tfUtsBBSBootFTPUserName
				.getValue()));
		mbean.setUtsBBSBootFTPPassword(new String(tfUtsBBSBootFTPPassword
				.getValue()));
		mbean.setUtsBBSBootFTPServerIpAddress(new String(
				tfUtsBBSBootFTPServerIpAddress.getIPString()));
	}

	private void setFieldEditable( String bootMethodStr ) {
		
		String flashSel = fStringMap.getString("Flash");
		String ftpSel = fStringMap.getString("Ftp");
		
		if ( flashSel.equalsIgnoreCase( bootMethodStr )) {
			tfUtsBBSSysBootFileName.setEditable( true );
			
			tfUtsBBSBootFTPUserName.setEditable( false );
			tfUtsBBSBootFTPPassword.setEditable( false );
			tfUtsBBSBootFTPServerIpAddress.setEditable( false );
		} else if ( ftpSel.equalsIgnoreCase( bootMethodStr)) {
			tfUtsBBSSysBootFileName.setEditable( true );//NMS00068683
			
			tfUtsBBSBootFTPUserName.setEditable( true );
			tfUtsBBSBootFTPPassword.setEditable( true );
			tfUtsBBSBootFTPServerIpAddress.setEditable( true );
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
