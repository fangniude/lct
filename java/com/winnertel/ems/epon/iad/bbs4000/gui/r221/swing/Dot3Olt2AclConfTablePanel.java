/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2AclConfTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The Dot3Olt2AclConfTablePanel class. Created by DVM Creator
 */
public class Dot3Olt2AclConfTablePanel extends UPanel {

    private JComboBox tfUtsDot3OltAclConfModuleId = null;

    // private JComboBox tfUtsDot3OltAclConfDeviceId = null;

    private JComboBox tfUtsDot3OltAclConfPonPort = null;

    private JComboBox tfUtsDot3OltAclConfLlidPort = null;

    private JComboBox tfUtsDot3OltAclConfProfId = null;

    // private int[] utsDot3OltAclConfDirectionVList = new int[] { 1, 2, };
    // private String[] utsDot3OltAclConfDirectionTList = new String[] { fStringMap.getString("upstream"), fStringMap.getString("downstream"), };
    // private JComboBox tfUtsDot3OltAclConfDirection = new JComboBox(utsDot3OltAclConfDirectionTList);

    // private IntegerTextField tfUtsDot3OltAclConfUpstream = new IntegerTextField();
    // private IntegerTextField tfUtsDot3OltAclConfDownstream = new IntegerTextField();

    private final String utsDot3OltAclConfModuleId = fStringMap.getString("utsDot3OltAclConfModuleId") + " : ";
    // private final String utsDot3OltAclConfDeviceId = fStringMap.getString("utsDot3OltAclConfDeviceId") + " : ";
    private final String utsDot3OltAclConfPonPort = fStringMap.getString("utsDot3OltAclConfPonPort") + " : ";
    private final String utsDot3OltAclConfLlidPort = fStringMap.getString("utsDot3OltAclConfLlidPort") + " : ";
    private final String utsDot3OltAclConfProfId = fStringMap.getString("utsDot3OltAclConfProfId") + " : ";

    // private final String utsDot3OltAclConfDirection = fStringMap.getString("utsDot3OltAclConfDir") + " : ";

    // private final String utsDot3OltAclConfUpstream = fStringMap.getString("utsDot3OltAclConfUpstream") + " : ";
    // private final String utsDot3OltAclConfDownstream = fStringMap.getString("utsDot3OltAclConfDownstream") + " : ";

    public Dot3Olt2AclConfTablePanel(IApplication app) {
	super(app);

	init();
    }

    public void initGui() {

	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	String[] list1 = new String[12];
	for (int i = 0; i < list1.length; i++) {
	    list1[i] = "" + (i + 1);
	}
	tfUtsDot3OltAclConfModuleId = new JComboBox(list1);
	baseInfoPanel.add(new JLabel(utsDot3OltAclConfModuleId));
	baseInfoPanel.add(tfUtsDot3OltAclConfModuleId);
	baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltAclConfDeviceId));
	// baseInfoPanel.add(tfUtsDot3OltAclConfDeviceId);
	// baseInfoPanel.add(new HSpacer());

	String[] list2 = new String[4];
	for (int i = 0; i < list2.length; i++) {
	    list2[i] = "" + (i + 1);
	}
	tfUtsDot3OltAclConfPonPort = new JComboBox(list2);
	baseInfoPanel.add(new JLabel(utsDot3OltAclConfPonPort));
	baseInfoPanel.add(tfUtsDot3OltAclConfPonPort);
	baseInfoPanel.add(new HSpacer());

	int ratio = new BBS4000NE(fApplication).getPonSplitRatio();
	String[] list3 = new String[ratio + 1];
	for (int i = 0; i < list3.length; i++) {
	    list3[i] = "" + i;
	}

	tfUtsDot3OltAclConfLlidPort = new JComboBox(list3);
	baseInfoPanel.add(new JLabel(utsDot3OltAclConfLlidPort));
	baseInfoPanel.add(tfUtsDot3OltAclConfLlidPort);
	baseInfoPanel.add(new HSpacer());

	tfUtsDot3OltAclConfProfId = new JComboBox(list3);
	baseInfoPanel.add(new JLabel(utsDot3OltAclConfProfId));
	baseInfoPanel.add(tfUtsDot3OltAclConfProfId);
	baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltAclConfDirection));
	// baseInfoPanel.add(tfUtsDot3OltAclConfDirection);
	// baseInfoPanel.add(new HSpacer());

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
    }

    public void refresh() {
	if (SnmpAction.IType.ADD.equals(fCommand)) {
	    tfUtsDot3OltAclConfProfId.removeAllItems();

	    AclExtProfileImportTable mbean = new AclExtProfileImportTable(fApplication.getSnmpProxy());
	    Vector v = BeanService.refreshTableBean(fApplication, mbean);
	    for (int i = 0; i < v.size(); i++) {
		AclExtProfileImportTable one = (AclExtProfileImportTable) v.get(i);
		if (one.getUtsAclExtProfileImportProfileId().intValue() > 32) {
		    tfUtsDot3OltAclConfProfId.addItem(one.getUtsAclExtProfileImportProfileId());
		}
	    }

	    tfUtsDot3OltAclConfModuleId.removeAllItems();
	    BBS4000NE ne = new BBS4000NE(fApplication);

	    v = ne.getEPMCardList();

	    for (int i = 0; i < v.size(); i++) {
		tfUtsDot3OltAclConfModuleId.addItem(v.get(i));
	    }
	}
    }

    public boolean validateFrom() {
	if (tfUtsDot3OltAclConfModuleId.getSelectedItem() == null) {
	    String error = fStringMap.getString("Err_Module_Id_Is_Null");
	    MessageDialog.showErrorMessageDialog(fApplication, error);
	    return false;
	}

	if (tfUtsDot3OltAclConfProfId.getSelectedItem() == null) {
	    String error = fStringMap.getString("Err_Profile_Id_Is_Null");
	    MessageDialog.showErrorMessageDialog(fApplication, error);
	    return false;
	}

	return true;
    }

    public void updateModel() {

	if (SnmpAction.IType.ADD.equals(fCommand))
	    setModel(new Dot3Olt2AclConfTable(fApplication.getSnmpProxy()));

	Dot3Olt2AclConfTable mbean = (Dot3Olt2AclConfTable) getModel();

	if (SnmpAction.IType.ADD.equals(fCommand)) {
	    mbean.setUtsDot3OltAclConfModuleId(new Integer((String) tfUtsDot3OltAclConfModuleId.getSelectedItem()));
	    mbean.setUtsDot3OltAclConfDeviceId(new Integer(1));
	    mbean.setUtsDot3OltAclConfPonPort(new Integer((String) tfUtsDot3OltAclConfPonPort.getSelectedItem()));
	    mbean.setUtsDot3OltAclConfLlidPort(new Integer((String) tfUtsDot3OltAclConfLlidPort.getSelectedItem()));
	    mbean.setUtsDot3OltAclConfProfId((Integer) tfUtsDot3OltAclConfProfId.getSelectedItem());
	    // mbean.setUtsDot3OltAclConfDir(new Integer(utsDot3OltAclConfDirectionVList[tfUtsDot3OltAclConfDirection.getSelectedIndex()]));
	}

	// mbean.setUtsDot3OltAclConfUpstream(new Integer(tfUtsDot3OltAclConfUpstream.getValue()));
	// mbean.setUtsDot3OltAclConfDownstream(new Integer(tfUtsDot3OltAclConfDownstream.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}
	return 0;
    }

}
