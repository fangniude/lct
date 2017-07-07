package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.OnuScheduleUpgradeTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.OnuUpgradeMethodMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class OnuScheduleUpgradeTablePanel extends UPanel implements ActionListener {

    private OnuTreePanel onuTreePanel;

    private IntegerTextField tfUtsDot3OnuFWUpgradeResultStartingMinute = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuFWUpgradeResultStartingHour = new IntegerTextField();
    private IntegerTextField tfUtsDot3OnuFWUpgradeResultDuration = new IntegerTextField();

//    private String[] utsDot3OnuFWUpgradeOptionTList = new String[]{
//        fStringMap.getString("normal"),
//        fStringMap.getString("force"),
//    };
    private JCheckBox tfUtsDot3OnuFWUpgradeOption = new JCheckBox(fStringMap.getString("force"));
    //   private JComboBox tfUtsDot3OnuFWUpgradeOption = new JComboBox(utsDot3OnuFWUpgradeOptionTList);

    private JRadioButton utButton = new JRadioButton(fStringMap.getString("ut-mode"));
    private JRadioButton ctcButton = new JRadioButton(fStringMap.getString("ctc-mode"));
    private JCheckBox tfUtsDot3OnuFWUpgradeActCommitFlag = new JCheckBox(fStringMap.getString("utsDot3OnuFWUpgradeActCommitFlag"));

    private final String utsDot3OnuFWUpgradeResultStartingHour = fStringMap.getString("utsDot3OnuFWUpgradeResultStartingHour") + " : ";
    private final String utsDot3OnuFWUpgradeResultStartingMinute = fStringMap.getString("utsDot3OnuFWUpgradeResultStartingMinute") + " : ";
    private final String utsDot3OnuFWUpgradeDuration = fStringMap.getString("utsDot3OnuFWUpgradeDuration") + " : ";

    public OnuScheduleUpgradeTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel timePanel = new JPanel();
        layout = new NTLayout(2, 4, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        timePanel.setLayout(layout);
        timePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Schedule_Configure")));

        timePanel.add(new JLabel(utsDot3OnuFWUpgradeResultStartingHour));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultStartingHour);
        timePanel.add(new JLabel(utsDot3OnuFWUpgradeResultStartingMinute));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultStartingMinute);

        timePanel.add(new JLabel(utsDot3OnuFWUpgradeDuration));
        timePanel.add(tfUtsDot3OnuFWUpgradeResultDuration);
        timePanel.add(new HSpacer());
        timePanel.add(new HSpacer());

        JPanel optionPanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        optionPanel.setLayout(layout);
        optionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Upgrade_Option")));
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

        baseInfoPanel.add(timePanel);
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
        this.setPreferredSize(new Dimension(500, 500));
    }

    protected void initForm() {
        tfUtsDot3OnuFWUpgradeResultStartingHour.setValueScope(0, 23);
        tfUtsDot3OnuFWUpgradeResultStartingHour.setDefaultValue(0);
        tfUtsDot3OnuFWUpgradeResultStartingMinute.setValueScope(0, 59);
        tfUtsDot3OnuFWUpgradeResultStartingMinute.setDefaultValue(0);
        tfUtsDot3OnuFWUpgradeResultDuration.setValueScope(10, 600);
        tfUtsDot3OnuFWUpgradeResultDuration.setDefaultValue(30);
    }

    public void refresh() {
        onuTreePanel.init();
        actionPerformed(null);
    }

    public boolean validateFrom() {
        int hour = tfUtsDot3OnuFWUpgradeResultStartingHour.getValue();
        int minu = tfUtsDot3OnuFWUpgradeResultStartingMinute.getValue();
        int dura = tfUtsDot3OnuFWUpgradeResultDuration.getValue();

        int begin = hour * 60 + minu;
        int end = begin + dura;


        SnmpTableModel model = (SnmpTableModel) fTable.getModel();
        model.getDataVector();
        Vector v = model.getDataVector();

        for(int i = 0; i < v.size(); i++) {
            OnuScheduleUpgradeTable one = (OnuScheduleUpgradeTable) v.get(i);
            int tempHour = one.getUtsDot3OnuFWUpgradeStartingHour().intValue();
            int tempMinu = one.getUtsDot3OnuFWUpgradeStartingMinute().intValue();
            int tempDura = one.getUtsDot3OnuFWUpgradeDuration().intValue();
            int tempBegin = tempHour * 60 + tempMinu;
            int tempEnd = tempBegin + tempDura + 1;
            if((begin > tempBegin && begin < tempEnd) || (end > tempBegin && end < tempEnd)) {
                String str = fStringMap.getString("Err_Schedule_Time_Is_Wrong");
                MessageDialog.showErrorMessageDialog(fApplication, str);
                return false;
            }
        }

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

        //
        byte[] bitmap = onuTreePanel.getSelectedOnuBitMap();
        OnuScheduleUpgradeTable mbean = new OnuScheduleUpgradeTable(fApplication.getSnmpProxy());
        mbean.setUtsDot3OnuFWUpgradeStartingHour(new Integer(tfUtsDot3OnuFWUpgradeResultStartingHour.getValue()));
        mbean.setUtsDot3OnuFWUpgradeStartingMinute(new Integer(tfUtsDot3OnuFWUpgradeResultStartingMinute.getValue()));
        mbean.setUtsDot3OnuFWUpgradePortListBitMap(bitmap);
        mbean.setUtsDot3OnuFWUpgradeDuration(new Integer(tfUtsDot3OnuFWUpgradeResultDuration.getValue()));
        //      mbean.setUtsDot3OnuFWUpgradeOption(new Integer(tfUtsDot3OnuFWUpgradeOption.getSelectedIndex()+1));
        if(tfUtsDot3OnuFWUpgradeOption.isSelected()) { //force
            mbean.setUtsDot3OnuFWUpgradeOption(new Integer(2));
        } else {
            mbean.setUtsDot3OnuFWUpgradeOption(new Integer(1));
        }

        if(ctcButton.isSelected()) {
            if(tfUtsDot3OnuFWUpgradeActCommitFlag.isSelected()) {
                mbean.setUtsDot3OnuFWUpgradeActCommitFlag(1);
            } else {
                mbean.setUtsDot3OnuFWUpgradeActCommitFlag(0);
            }
        }
        
        setModel(mbean);
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        tfUtsDot3OnuFWUpgradeActCommitFlag.setEnabled(ctcButton.isSelected());
    }
}
