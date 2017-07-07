/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r310.UtsOnuFWUpgradeScheduleTimeFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UtsOnuFWUpgradeScheduleResultTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The UtsOnuFWUpgradeScheduleResultTablePanel class. Created by DVM Creator
 */
public class UtsOnuFWUpgradeScheduleResultTablePanel extends UPanel {

    private JLabel tfUtsOnuFWUpgradeScheduleResultTime = new JLabel();

    private int[] utsOnuFWUpgradeScheduleResultCompVList = new int[] { 3, 5, 4, 1, 2, };
    private String[] utsOnuFWUpgradeScheduleResultCompTList = new String[] { fStringMap.getString("unified"), fStringMap.getString("bootloader"), fStringMap.getString("voip"), fStringMap.getString("pon"), fStringMap.getString("switch"), };
    private JComboBox tfUtsOnuFWUpgradeScheduleResultComp = new JComboBox(utsOnuFWUpgradeScheduleResultCompTList);
    private JLabel tfUtsOnuFWUpgradeScheduleResultModule = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultPort = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultLport = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultTargetVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultCurrentVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultCurrentUpgStatus = new JLabel();

    private JLabel tfUtsOnuFWUpgradeScheduleResultFailReason = new JLabel();

    private final String utsOnuFWUpgradeScheduleResultTime = fStringMap.getString("utsOnuFWUpgradeScheduleResultTime") + " : ";
    private final String utsOnuFWUpgradeScheduleResultComp = fStringMap.getString("utsOnuFWUpgradeScheduleResultComp") + " : ";
    private final String utsOnuFWUpgradeScheduleResultModule = fStringMap.getString("utsOnuFWUpgradeScheduleResultModule") + " : ";
    private final String utsOnuFWUpgradeScheduleResultPort = fStringMap.getString("utsOnuFWUpgradeScheduleResultPort") + " : ";
    private final String utsOnuFWUpgradeScheduleResultLport = fStringMap.getString("utsOnuFWUpgradeScheduleResultLport") + " : ";
    private final String utsOnuFWUpgradeScheduleResultTargetVersion = fStringMap.getString("utsOnuFWUpgradeScheduleResultTargetVersion") + " : ";
    private final String utsOnuFWUpgradeScheduleResultCurrentVersion = fStringMap.getString("utsOnuFWUpgradeScheduleResultCurrentVersion") + " : ";
    private final String utsOnuFWUpgradeScheduleResultCurrentUpgStatus = fStringMap.getString("utsOnuFWUpgradeScheduleResultCurrentUpgStatus") + " : ";
    private final String utsOnuFWUpgradeScheduleResultFailReason = fStringMap.getString("utsOnuFWUpgradeScheduleResultFailReason") + " : ";

    public UtsOnuFWUpgradeScheduleResultTablePanel(IApplication app) {
	super(app);

	init();
    }

    public void initGui() {

	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultTime));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultTime);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultComp));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultComp);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultModule));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultModule);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultPort));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultPort);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultLport));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultLport);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultTargetVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultTargetVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultCurrentVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultCurrentVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultCurrentUpgStatus));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultCurrentUpgStatus);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeScheduleResultFailReason));
	baseInfoPanel.add(tfUtsOnuFWUpgradeScheduleResultFailReason);
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

	UtsOnuFWUpgradeScheduleResultTable mbean = (UtsOnuFWUpgradeScheduleResultTable) getModel();

	tfUtsOnuFWUpgradeScheduleResultTime.setText(UtsOnuFWUpgradeScheduleTimeFormatter.format(mbean.getUtsOnuFWUpgradeScheduleResultTime()));
	tfUtsOnuFWUpgradeScheduleResultComp.setSelectedIndex(getIndexFromValue(utsOnuFWUpgradeScheduleResultCompVList, mbean.getUtsOnuFWUpgradeScheduleResultComp().intValue()));
	tfUtsOnuFWUpgradeScheduleResultModule.setText(mbean.getUtsOnuFWUpgradeScheduleResultModule().toString());
	tfUtsOnuFWUpgradeScheduleResultPort.setText(mbean.getUtsOnuFWUpgradeScheduleResultPort().toString());
	tfUtsOnuFWUpgradeScheduleResultLport.setText(mbean.getUtsOnuFWUpgradeScheduleResultLport().toString());
	tfUtsOnuFWUpgradeScheduleResultTargetVersion.setText(mbean.getUtsOnuFWUpgradeScheduleResultTargetVersion());
	tfUtsOnuFWUpgradeScheduleResultCurrentVersion.setText(mbean.getUtsOnuFWUpgradeScheduleResultCurrentVersion());
	tfUtsOnuFWUpgradeScheduleResultCurrentUpgStatus.setText(mbean.getUtsOnuFWUpgradeScheduleResultCurrentUpgStatus());
	tfUtsOnuFWUpgradeScheduleResultFailReason.setText(mbean.getUtsOnuFWUpgradeScheduleResultFailReason());

    }

    public void updateModel() {

	UtsOnuFWUpgradeScheduleResultTable mbean = (UtsOnuFWUpgradeScheduleResultTable) getModel();

    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}
	return 0;
    }

}
