package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.OnuManualUpgradeMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.OnuUpgradeMethodMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnuManualUpgradePanel extends UPanel implements ActionListener {

    private OnuTreePanel onuTreePanel;

    private JCheckBox tfUtsDot3OnuFWUpgradeOption = new JCheckBox(fStringMap.getString("force"));

    private JRadioButton utButton = new JRadioButton(fStringMap.getString("ut-mode"));
    private JRadioButton ctcButton = new JRadioButton(fStringMap.getString("ctc-mode"));
    private JCheckBox tfUtsDot3OnuFWUpgradeActCommitFlag = new JCheckBox(fStringMap.getString("utsDot3OnuFWUpgradeActCommitFlag"));

//    private final String utsDot3OnuFWUpgradeOption = fStringMap.getString("utsDot3OnuFWUpgradeOption") + " : ";

    public OnuManualUpgradePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel optionPanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        optionPanel.setLayout(layout);
        optionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Upgrade_Mode")));
        optionPanel.add(tfUtsDot3OnuFWUpgradeOption);
        optionPanel.add(new HSpacer());

        ButtonGroup group = new ButtonGroup();
        utButton.setSelected(true);
        utButton.addActionListener(this);
        group.add(utButton);
        ctcButton.addActionListener(this);
        group.add(ctcButton);

        JPanel modePanel = new JPanel();
        layout = new NTLayout(3, 2, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        modePanel.setLayout(layout);
        modePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Upgrade_Mode")));
        modePanel.add(utButton);
        modePanel.add(new HSpacer());
        modePanel.add(ctcButton);
        modePanel.add(new HSpacer());
        modePanel.add(tfUtsDot3OnuFWUpgradeActCommitFlag);
        modePanel.add(new HSpacer());

        baseInfoPanel.add(optionPanel);
        baseInfoPanel.add(modePanel);
        onuTreePanel = new OnuTreePanel(fApplication);
        baseInfoPanel.add(onuTreePanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(400, 400));
    }

    protected void initForm() {
    }

    public void refresh() {
        onuTreePanel.init();
        actionPerformed(null);
    }

    public boolean validateFrom() {
        return true;
    }

    public void updateModel() {
        OnuUpgradeMethodMBean mode = new OnuUpgradeMethodMBean(fApplication.getSnmpProxy());
        if(utButton.isSelected()) {
            mode.setUtsDot3OnuUpgradeMethod(0);
        } else {
            mode.setUtsDot3OnuUpgradeMethod(1);
        }

        BeanService.modifyBean(fApplication, new ModifyTask(mode), true);

        byte[] bitmap = onuTreePanel.getSelectedOnuBitMap();
        OnuManualUpgradeMBean mbean = new OnuManualUpgradeMBean(fApplication.getSnmpProxy());

        mbean.setUtsDot3OnuFWUpgradeManualPortListBitMap(bitmap);

        if(tfUtsDot3OnuFWUpgradeOption.isSelected()) //force
        {
            mbean.setUtsDot3OnuFWUpgradeManualOption(2);
        }

        if(ctcButton.isSelected() && tfUtsDot3OnuFWUpgradeActCommitFlag.isSelected()) {
            mbean.setUtsDot3OnuFWUpgradeManualActCommitFlag(1);
        }


        setModel(mbean);
    }

    public void actionPerformed(ActionEvent e) {
        tfUtsDot3OnuFWUpgradeActCommitFlag.setEnabled(ctcButton.isSelected());
    }
}
