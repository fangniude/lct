/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UtsOnuFWUpgradeAutoResultTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The UtsOnuFWUpgradeAutoResultTablePanel class. Created by DVM Creator
 */
public class UtsOnuFWUpgradeAutoResultTablePanel extends UPanel {

    private JLabel tfUtsOnuFWUpgradeAutoResultModule = new JLabel();

    private JLabel tfUtsOnuFWUpgradeAutoResultPort = new JLabel();

    private JLabel tfUtsOnuFWUpgradeAutoResultLport = new JLabel();

    private int[] utsOnuFWUpgradeAutoResultCompVList = new int[] { 3, 5, 4, 1, 2, };
    private String[] utsOnuFWUpgradeAutoResultCompTList = new String[] { fStringMap.getString("unified"), fStringMap.getString("bootloader"), fStringMap.getString("voip"), fStringMap.getString("pon"), fStringMap.getString("switch"), };
    private JComboBox tfUtsOnuFWUpgradeAutoResultComp = new JComboBox(utsOnuFWUpgradeAutoResultCompTList);
    private JLabel tfUtsOnuFWUpgradeAutoResultTargetVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeAutoResultCurrentVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeAutoResultCurrentUpgStatus = new JLabel();

    private JLabel tfUtsOnuFWUpgradeAutoResultFailReason = new JLabel();

    private final String utsOnuFWUpgradeAutoResultModule = fStringMap.getString("utsOnuFWUpgradeAutoResultModule") + " : ";
    private final String utsOnuFWUpgradeAutoResultPort = fStringMap.getString("utsOnuFWUpgradeAutoResultPort") + " : ";
    private final String utsOnuFWUpgradeAutoResultLport = fStringMap.getString("utsOnuFWUpgradeAutoResultLport") + " : ";
    private final String utsOnuFWUpgradeAutoResultComp = fStringMap.getString("utsOnuFWUpgradeAutoResultComp") + " : ";
    private final String utsOnuFWUpgradeAutoResultTargetVersion = fStringMap.getString("utsOnuFWUpgradeAutoResultTargetVersion") + " : ";
    private final String utsOnuFWUpgradeAutoResultCurrentVersion = fStringMap.getString("utsOnuFWUpgradeAutoResultCurrentVersion") + " : ";
    private final String utsOnuFWUpgradeAutoResultCurrentUpgStatus = fStringMap.getString("utsOnuFWUpgradeAutoResultCurrentUpgStatus") + " : ";
    private final String utsOnuFWUpgradeAutoResultFailReason = fStringMap.getString("utsOnuFWUpgradeAutoResultFailReason") + " : ";

    public UtsOnuFWUpgradeAutoResultTablePanel(IApplication app) {
	super(app);

	init();
    }

    public void initGui() {

	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultModule));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultModule);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultPort));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultPort);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultLport));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultLport);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultComp));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultComp);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultTargetVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultTargetVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultCurrentVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultCurrentVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultCurrentUpgStatus));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultCurrentUpgStatus);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoResultFailReason));
	baseInfoPanel.add(tfUtsOnuFWUpgradeAutoResultFailReason);
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

    }

    public void refresh() {

	UtsOnuFWUpgradeAutoResultTable mbean = (UtsOnuFWUpgradeAutoResultTable) getModel();

	tfUtsOnuFWUpgradeAutoResultModule.setText(mbean.getUtsOnuFWUpgradeAutoResultModule().toString());
	tfUtsOnuFWUpgradeAutoResultPort.setText(mbean.getUtsOnuFWUpgradeAutoResultPort().toString());
	tfUtsOnuFWUpgradeAutoResultLport.setText(mbean.getUtsOnuFWUpgradeAutoResultLport().toString());
	tfUtsOnuFWUpgradeAutoResultComp.setSelectedIndex(getIndexFromValue(utsOnuFWUpgradeAutoResultCompVList, mbean.getUtsOnuFWUpgradeAutoResultComp().intValue()));
	tfUtsOnuFWUpgradeAutoResultTargetVersion.setText(mbean.getUtsOnuFWUpgradeAutoResultTargetVersion());
	tfUtsOnuFWUpgradeAutoResultCurrentVersion.setText(mbean.getUtsOnuFWUpgradeAutoResultCurrentVersion());
	tfUtsOnuFWUpgradeAutoResultCurrentUpgStatus.setText(mbean.getUtsOnuFWUpgradeAutoResultCurrentUpgStatus());
	tfUtsOnuFWUpgradeAutoResultFailReason.setText(mbean.getUtsOnuFWUpgradeAutoResultFailReason());

    }

    public void updateModel() {

	UtsOnuFWUpgradeAutoResultTable mbean = (UtsOnuFWUpgradeAutoResultTable) getModel();

    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}
	return 0;
    }

}
