/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.VlanTypeTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The VlanTypeTableMBeanPanel class.
 * Created by DVM Creator
 */
public class VlanTypeTableMBeanPanel extends UPanel {

	private IntegerTextField tfVlanTypeNewSVLAN = new IntegerTextField();

	private IntegerTextField tfVlanTypeNewCVLAN = new IntegerTextField();

	private int[] vlanTypeVList = new int[] { 3, 1, 4, 5, 2, 6, };
	private String[] vlanTypeTList = new String[] {
			fStringMap.getString("types-n-1-s"),
			fStringMap.getString("types-1-1-s"),
			fStringMap.getString("types-n-1-s-c"),
			fStringMap.getString("types-n-1-s-cs"),
			fStringMap.getString("types-1-1-s-c"),
			fStringMap.getString("types-TLS"), };
	private JComboBox tfVlanType = new JComboBox(vlanTypeTList);

	private final String vlanTypeNewSVLAN = fStringMap
			.getString("vlanTypeNewSVLAN")
			+ " : ";
	private final String vlanTypeNewCVLAN = fStringMap
			.getString("vlanTypeNewCVLAN")
			+ " : ";
	private final String vlanType = fStringMap.getString("vlanType") + " : ";

	public VlanTypeTableMBeanPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(vlanTypeNewSVLAN));
		baseInfoPanel.add(tfVlanTypeNewSVLAN);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(vlanTypeNewCVLAN));
		baseInfoPanel.add(tfVlanTypeNewCVLAN);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(vlanType));
		tfVlanType.setName(fStringMap.getString("vlanType"));
		baseInfoPanel.add(tfVlanType);
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
		tfVlanTypeNewSVLAN.setValueScope(0, 4095);
		tfVlanTypeNewCVLAN.setValueScope(0, 4095);
	}

	public void refresh() {
		if (SnmpAction.IType.ADD.equals(fCommand)){
			tfVlanTypeNewCVLAN.setEnabled(true);
			tfVlanTypeNewSVLAN.setEnabled(true);
			return;
		}
		else{
			tfVlanTypeNewCVLAN.setEnabled(false);
			tfVlanTypeNewSVLAN.setEnabled(false);	
		}
		VlanTypeTableMBean mbean = (VlanTypeTableMBean) getModel();
		tfVlanTypeNewSVLAN.setText(mbean.getVlanTypeNewSVLAN().toString());
		tfVlanTypeNewCVLAN.setText(mbean.getVlanTypeNewCVLAN().toString());
		tfVlanType.setSelectedIndex(getIndexFromValue(vlanTypeVList, mbean
				.getVlanType().intValue()));
		
	}

	public void updateModel() {
              
        if (SnmpAction.IType.ADD.equals(fCommand))  
        	setModel(new VlanTypeTableMBean(fApplication.getSnmpProxy()));
         VlanTypeTableMBean mbean = (VlanTypeTableMBean) getModel();
         if (SnmpAction.IType.ADD.equals(fCommand)) {
		  mbean.setVlanTypeNewCVLAN(new Integer(tfVlanTypeNewCVLAN.getValue()));
		  mbean.setVlanTypeNewSVLAN(new Integer(tfVlanTypeNewSVLAN.getValue()));
          }
         mbean.setVlanType(new Integer(vlanTypeVList[tfVlanType.getSelectedIndex()]));
    }

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
