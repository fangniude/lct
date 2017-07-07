/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UtsOnuFWUpgradeManualResultTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The UtsOnuFWUpgradeManualResultTablePanel class. Created by DVM Creator
 */
public class UtsOnuFWUpgradeManualResultTablePanel extends UPanel {

    private JLabel tfUtsOnuFWUpgradeManualResultModule = new JLabel();

    private JLabel tfUtsOnuFWUpgradeManualResultPort = new JLabel();

    private JLabel tfUtsOnuFWUpgradeManualResultLport = new JLabel();

    private int[] utsOnuFWUpgradeManualResultCompVList = new int[] { 3, 5, 4, 1, 2, };
    private String[] utsOnuFWUpgradeManualResultCompTList = new String[] { fStringMap.getString("unified"), fStringMap.getString("bootloader"), fStringMap.getString("voip"), fStringMap.getString("pon"), fStringMap.getString("switch"), };
    private JComboBox tfUtsOnuFWUpgradeManualResultComp = new JComboBox(utsOnuFWUpgradeManualResultCompTList);
    private JLabel tfUtsOnuFWUpgradeManualResultTargetVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeManualResultCurrentVersion = new JLabel();

    private JLabel tfUtsOnuFWUpgradeManualResultCurrentUpgStatus = new JLabel();

    private JLabel tfUtsOnuFWUpgradeManualResultFailReason = new JLabel();

    private int[] utsOnuFWUpgradeManualResultCommitVList = new int[] { 1, 2, };
    private String[] utsOnuFWUpgradeManualResultCommitTList = new String[] { fStringMap.getString("true"), fStringMap.getString("false"), };
    private JComboBox tfUtsOnuFWUpgradeManualResultCommit = new JComboBox(utsOnuFWUpgradeManualResultCommitTList);

    private final String utsOnuFWUpgradeManualResultModule = fStringMap.getString("utsOnuFWUpgradeManualResultModule") + " : ";
    private final String utsOnuFWUpgradeManualResultPort = fStringMap.getString("utsOnuFWUpgradeManualResultPort") + " : ";
    private final String utsOnuFWUpgradeManualResultLport = fStringMap.getString("utsOnuFWUpgradeManualResultLport") + " : ";
    private final String utsOnuFWUpgradeManualResultComp = fStringMap.getString("utsOnuFWUpgradeManualResultComp") + " : ";
    private final String utsOnuFWUpgradeManualResultTargetVersion = fStringMap.getString("utsOnuFWUpgradeManualResultTargetVersion") + " : ";
    private final String utsOnuFWUpgradeManualResultCurrentVersion = fStringMap.getString("utsOnuFWUpgradeManualResultCurrentVersion") + " : ";
    private final String utsOnuFWUpgradeManualResultCurrentUpgStatus = fStringMap.getString("utsOnuFWUpgradeManualResultCurrentUpgStatus") + " : ";
    private final String utsOnuFWUpgradeManualResultFailReason = fStringMap.getString("utsOnuFWUpgradeManualResultFailReason") + " : ";
    private final String utsOnuFWUpgradeManualResultCommit = fStringMap.getString("utsOnuFWUpgradeManualResultCommit") + " : ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public UtsOnuFWUpgradeManualResultTablePanel(IApplication app) {
	super(app);
	setModel(new UtsOnuFWUpgradeManualResultTable(app.getSnmpProxy()));
	init();
    }

    public void initGui() {

	btApply = new SnmpApplyButton(fApplication, this);
	btApply.getAction().putValue(BaseAction.ID, "Modify_UtsOnuFWUpgradeManualResultTable");
	btRefresh = new SnmpRefreshButton(fApplication, this);
	JPanel buttonsPanel = new JPanel();
	buttonsPanel.add(btApply);
	buttonsPanel.add(btRefresh);

	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultModule));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultModule);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultPort));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultPort);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultLport));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultLport);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultComp));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultComp);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultTargetVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultTargetVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultCurrentVersion));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultCurrentVersion);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultCurrentUpgStatus));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultCurrentUpgStatus);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultFailReason));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultFailReason);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualResultCommit));
	tfUtsOnuFWUpgradeManualResultCommit.setName(fStringMap.getString("utsOnuFWUpgradeManualResultCommit"));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualResultCommit);
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

    }

    public void refresh() {

	UtsOnuFWUpgradeManualResultTable mbean = (UtsOnuFWUpgradeManualResultTable) getModel();
	BeanService.refreshBean(fApplication, mbean);

	tfUtsOnuFWUpgradeManualResultModule.setText(mbean.getUtsOnuFWUpgradeManualResultModule().toString());
	tfUtsOnuFWUpgradeManualResultPort.setText(mbean.getUtsOnuFWUpgradeManualResultPort().toString());
	tfUtsOnuFWUpgradeManualResultLport.setText(mbean.getUtsOnuFWUpgradeManualResultLport().toString());
	tfUtsOnuFWUpgradeManualResultComp.setSelectedIndex(getIndexFromValue(utsOnuFWUpgradeManualResultCompVList, mbean.getUtsOnuFWUpgradeManualResultComp().intValue()));
	tfUtsOnuFWUpgradeManualResultTargetVersion.setText(mbean.getUtsOnuFWUpgradeManualResultTargetVersion());
	tfUtsOnuFWUpgradeManualResultCurrentVersion.setText(mbean.getUtsOnuFWUpgradeManualResultCurrentVersion());
	tfUtsOnuFWUpgradeManualResultCurrentUpgStatus.setText(mbean.getUtsOnuFWUpgradeManualResultCurrentUpgStatus());
	tfUtsOnuFWUpgradeManualResultFailReason.setText(mbean.getUtsOnuFWUpgradeManualResultFailReason());
	tfUtsOnuFWUpgradeManualResultCommit.setSelectedIndex(getIndexFromValue(utsOnuFWUpgradeManualResultCommitVList, mbean.getUtsOnuFWUpgradeManualResultCommit().intValue()));

    }

    public void updateModel() {

	UtsOnuFWUpgradeManualResultTable mbean = (UtsOnuFWUpgradeManualResultTable) getModel();

	mbean.setUtsOnuFWUpgradeManualResultCommit(new Integer(utsOnuFWUpgradeManualResultCommitVList[tfUtsOnuFWUpgradeManualResultCommit.getSelectedIndex()]));

    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}
	return 0;
    }

}
