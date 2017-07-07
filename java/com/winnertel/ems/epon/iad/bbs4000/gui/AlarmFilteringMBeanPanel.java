package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.AlarmFilteringMBean;
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
import java.util.regex.Pattern;

/**
 * The AlarmFilteringMBeanPanel class.
 * Created by DVM Creator
 */
public class AlarmFilteringMBeanPanel extends UPanel {

//    private IntegerTextField tfUtAlarmFilteringType = new IntegerTextField();
//    private int[] UtAlarmFilteringTypeVlist = new int[]{0,1,2,3,4};
//    private String[] UtAlarmFilteringTypeTlist = new String[] {"Communication Alarm",
//                                                               "Equipment Alarm",
//                                                               "Environment Alarm",
//                                                               "Processing Error",
//                                                               "QoS Alarm"};
//    private JComboBox comboUtAlarmFilteringType = new JComboBox(UtAlarmFilteringTypeTlist);

    private JCheckBox[] chUtAlarmFilteringTypelist = new JCheckBox[5];

//    private IntegerTextField tfUtAlarmFilteringSeverity = new IntegerTextField();
    private int[] UtAlarmFilteringSeverityVlist = new int[]{ 0, 1, 2, 3, 4 };
    private String[] UtAlarmFilteringSeverityTlist = new String[]{ fStringMap.getString("alarmLevelNone"), 
    															   fStringMap.getString("alarmLevelWarning"),
    															   fStringMap.getString("alarmLevelMinor"),
    															   fStringMap.getString("alarmLevelMajor"),
    															   fStringMap.getString("alarmLevelCritical"),
    															   };
  
    private JComboBox comboUtAlarmFilteringSeverity = new JComboBox(UtAlarmFilteringSeverityTlist);


    private final String utAlarmFilteringType = fStringMap.getString("utAlarmFilteringType") + " : ";
    private final String utAlarmFilteringSeverity = fStringMap.getString("utAlarmFilteringSeverity") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public AlarmFilteringMBeanPanel(IApplication app) {
        super(app);
        setModel(new AlarmFilteringMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_AlarmFilteringMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());


        baseInfoPanel.add(new JLabel(utAlarmFilteringSeverity));
//        tfUtAlarmFilteringSeverity.setName(fStringMap.getString("utAlarmFilteringSeverity"));
//        baseInfoPanel.add(tfUtAlarmFilteringSeverity);
        
        baseInfoPanel.add(comboUtAlarmFilteringSeverity);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utAlarmFilteringType));
//        tfUtAlarmFilteringType.setName(fStringMap.getString("utAlarmFilteringType"));
//        baseInfoPanel.add(tfUtAlarmFilteringType);

//        baseInfoPanel.add(comboUtAlarmFilteringType);
        JPanel typeChoice = new JPanel();
        layout = new NTLayout(3, 2, NTLayout.LEFT, NTLayout.FILL, 5, 3);
        typeChoice.setLayout(layout);

        chUtAlarmFilteringTypelist[0] = new JCheckBox( fStringMap.getString("alarmTypeCommunication"));
        chUtAlarmFilteringTypelist[1] = new JCheckBox( fStringMap.getString("alarmTypeEquipment"));
        chUtAlarmFilteringTypelist[2] = new JCheckBox( fStringMap.getString("alarmTypeEnvironmental"));
        chUtAlarmFilteringTypelist[3] = new JCheckBox( fStringMap.getString("alarmTypeProcessingError"));
        chUtAlarmFilteringTypelist[4] = new JCheckBox( fStringMap.getString("alarmTypeQualityOfService"));
        chUtAlarmFilteringTypelist[0].setSelected(false);
        chUtAlarmFilteringTypelist[1].setSelected(false);
        chUtAlarmFilteringTypelist[2].setSelected(false);
        chUtAlarmFilteringTypelist[3].setSelected(false);
        chUtAlarmFilteringTypelist[4].setSelected(false);
        typeChoice.add(chUtAlarmFilteringTypelist[0]);
        typeChoice.add(chUtAlarmFilteringTypelist[1]);
        typeChoice.add(chUtAlarmFilteringTypelist[2]);
        typeChoice.add(chUtAlarmFilteringTypelist[3]);
        typeChoice.add(chUtAlarmFilteringTypelist[4]);
        typeChoice.setBorder(BorderFactory.createEtchedBorder());
        baseInfoPanel.add(typeChoice);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Alarm_Filter")));
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
//        tfUtAlarmFilteringType.setValueScope(-2147483648, 2147483647);

//        tfUtAlarmFilteringSeverity.setValueScope(-2147483648, 2147483647);

//        AlarmFilteringMBean mbean = new AlarmFilteringMBean(fApplication.getSnmpProxy());
//        comboUtAlarmFilteringType.setSelectedIndex(mbean.getUtAlarmFilteringType().intValue());
//        comboUtAlarmFilteringSeverity.setSelectedIndex(mbean.getUtAlarmFilteringSeverity().intValue());
    }

    public void refresh() {

        AlarmFilteringMBean mbean = (AlarmFilteringMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

//        comboUtAlarmFilteringType.setSelectedIndex(getIndexFromValue(UtAlarmFilteringTypeVlist, mbean.getUtAlarmFilteringType().intValue()));
        comboUtAlarmFilteringSeverity.setSelectedIndex(getIndexFromValue(UtAlarmFilteringSeverityVlist, mbean.getUtAlarmFilteringSeverity().intValue()));
        String type = mbean.getUtAlarmFilteringType();
        chUtAlarmFilteringTypelist[0].setSelected(false);
        chUtAlarmFilteringTypelist[1].setSelected(false);
        chUtAlarmFilteringTypelist[2].setSelected(false);
        chUtAlarmFilteringTypelist[3].setSelected(false);
        chUtAlarmFilteringTypelist[4].setSelected(false);

        generateType(type);
    }

    public void updateModel() {

        AlarmFilteringMBean mbean = (AlarmFilteringMBean) getModel();

        String str = "";
        if (chUtAlarmFilteringTypelist[0].isSelected() == true)
            str += "2";
        if (chUtAlarmFilteringTypelist[1].isSelected() == true)
            str += ";3";
        if (chUtAlarmFilteringTypelist[2].isSelected() == true)
            str += ";4";
        if (chUtAlarmFilteringTypelist[3].isSelected() == true)
            str += ";10";
        if (chUtAlarmFilteringTypelist[4].isSelected() == true)
            str += ";11";

        mbean.setUtAlarmFilteringSeverity(new Integer(UtAlarmFilteringSeverityVlist[comboUtAlarmFilteringSeverity.getSelectedIndex()]));
        mbean.setUtAlarmFilteringType(str);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    private void generateType(String s) {
    	if (!Pattern.matches("^-?\\d+$", s)) return;

        String tempStr = Integer.toHexString(Integer.parseInt(s));
        int i = Integer.parseInt(tempStr.substring(5), 16);

        if ((i & 4) == 0) {
            chUtAlarmFilteringTypelist[0].setSelected(true);
        }
        if ((i & 8) == 0) {
            chUtAlarmFilteringTypelist[1].setSelected(true);
        }
        if ((i & 16) == 0) {
            chUtAlarmFilteringTypelist[2].setSelected(true);
        }
        if ((i & 1024) == 0) {
            chUtAlarmFilteringTypelist[3].setSelected(true);
        }
        if ((i & 2048) == 0) {
            chUtAlarmFilteringTypelist[4].setSelected(true);
        }
    }


}
