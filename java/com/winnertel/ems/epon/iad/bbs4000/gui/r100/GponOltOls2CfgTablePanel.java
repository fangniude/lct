package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOltOls2CfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The GponOltOls2CfgTablePanel class.
 * Created by DVM Creator
 */
public class GponOltOls2CfgTablePanel extends UPanel {

//    private JLabel tfOltOls2CfgSlotNo = new JLabel();
//    private JLabel tfOltOls2CfgPortNo = new JLabel();
//    private JLabel tfOltOls2CfgLogicalPortNo = new JLabel();
//    private JLabel tfOltOls2RxPower = new JLabel();
    private IntegerTextField tfOltOls2RxPowerThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOltOls2RxPowerThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOltOls2RxPowerThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOltOls2RxPowerThresholdWarningLo = new IntegerTextField();
    private int[] oltOls2EnableVList = new int[]{1,0};
    private String[] oltOls2EnableTList = new String[]{fStringMap.getString("enable"),fStringMap.getString("disable")};
    private JComboBox tfOltOls2Enable = new JComboBox(oltOls2EnableTList);

//    private final String oltOls2CfgSlotNo = fStringMap.getString("oltOls2CfgSlotNo") + " : ";
//    private final String oltOls2CfgPortNo = fStringMap.getString("oltOls2CfgPortNo") + " : ";
//    private final String oltOls2CfgLogicalPortNo = fStringMap.getString("oltOls2CfgLogicalPortNo") + " : ";
//    private final String oltOls2RxPower = fStringMap.getString("oltOls2RxPower") + " : ";
    private final String oltOls2RxPowerThresholdAlarmHi = fStringMap.getString("oltOls2RxPowerThresholdAlarmHi")
            + " : ";
    private final String oltOls2RxPowerThresholdAlarmLo = fStringMap.getString("oltOls2RxPowerThresholdAlarmLo")
            + " : ";
    private final String oltOls2RxPowerThresholdWarningHi = fStringMap.getString("oltOls2RxPowerThresholdWarningHi")
            + " : ";
    private final String oltOls2RxPowerThresholdWarningLo = fStringMap.getString("oltOls2RxPowerThresholdWarningLo")
            + " : ";
    private final String oltOls2Enable = fStringMap.getString("oltOls2Enable") + " : ";

    public GponOltOls2CfgTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//        baseInfoPanel.add(new JLabel(oltOls2CfgSlotNo));
//        baseInfoPanel.add(tfOltOls2CfgSlotNo);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(oltOls2CfgPortNo));
//        baseInfoPanel.add(tfOltOls2CfgPortNo);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(oltOls2CfgLogicalPortNo));
//        baseInfoPanel.add(tfOltOls2CfgLogicalPortNo);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(oltOls2RxPower));
//        baseInfoPanel.add(tfOltOls2RxPower);
//        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new JLabel(oltOls2Enable));
        tfOltOls2Enable.setName(fStringMap.getString("oltOls2Enable"));
        baseInfoPanel.add(tfOltOls2Enable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltOls2RxPowerThresholdAlarmHi));
        tfOltOls2RxPowerThresholdAlarmHi.setName(fStringMap.getString("oltOls2RxPowerThresholdAlarmHi"));
        baseInfoPanel.add(tfOltOls2RxPowerThresholdAlarmHi);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltOls2RxPowerThresholdAlarmLo));
        tfOltOls2RxPowerThresholdAlarmLo.setName(fStringMap.getString("oltOls2RxPowerThresholdAlarmLo"));
        baseInfoPanel.add(tfOltOls2RxPowerThresholdAlarmLo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltOls2RxPowerThresholdWarningHi));
        tfOltOls2RxPowerThresholdWarningHi.setName(fStringMap.getString("oltOls2RxPowerThresholdWarningHi"));
        baseInfoPanel.add(tfOltOls2RxPowerThresholdWarningHi);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltOls2RxPowerThresholdWarningLo));
        tfOltOls2RxPowerThresholdWarningLo.setName(fStringMap.getString("oltOls2RxPowerThresholdWarningLo"));
        baseInfoPanel.add(tfOltOls2RxPowerThresholdWarningLo);
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

        GponOltOls2CfgTable mbean = (GponOltOls2CfgTable) getModel();

//        tfOltOls2CfgSlotNo.setText(mbean.getOltOls2CfgSlotNo().toString());
//        tfOltOls2CfgPortNo.setText(mbean.getOltOls2CfgPortNo().toString());
//        tfOltOls2CfgLogicalPortNo.setText(mbean.getOltOls2CfgLogicalPortNo().toString());
//        tfOltOls2RxPower.setText(mbean.getOltOls2RxPower().toString());
        tfOltOls2RxPowerThresholdAlarmHi.setValue(mbean.getOltOls2RxPowerThresholdAlarmHi().intValue());
        tfOltOls2RxPowerThresholdAlarmLo.setValue(mbean.getOltOls2RxPowerThresholdAlarmLo().intValue());
        tfOltOls2RxPowerThresholdWarningHi.setValue(mbean.getOltOls2RxPowerThresholdWarningHi().intValue());
        tfOltOls2RxPowerThresholdWarningLo.setValue(mbean.getOltOls2RxPowerThresholdWarningLo().intValue());
        tfOltOls2Enable.setSelectedIndex(getIndexFromValue(oltOls2EnableVList, mbean.getOltOls2Enable().intValue()));

    }

    public void updateModel() {

        GponOltOls2CfgTable mbean = (GponOltOls2CfgTable) getModel();

        mbean.setOltOls2RxPowerThresholdAlarmHi(new Integer(tfOltOls2RxPowerThresholdAlarmHi.getValue()));
        mbean.setOltOls2RxPowerThresholdAlarmLo(new Integer(tfOltOls2RxPowerThresholdAlarmLo.getValue()));
        mbean.setOltOls2RxPowerThresholdWarningHi(new Integer(tfOltOls2RxPowerThresholdWarningHi.getValue()));
        mbean.setOltOls2RxPowerThresholdWarningLo(new Integer(tfOltOls2RxPowerThresholdWarningLo.getValue()));
        mbean.setOltOls2Enable(oltOls2EnableVList[tfOltOls2Enable.getSelectedIndex()]);

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
