package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

/**
 * @author Yang Yizai , 2009-3-9
 */

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuOlsCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The GponOnuOlsCfgTablePanel class.
 * Created by DVM Creator
 */
public class GponOnuOlsCfgTablePanel extends UPanel {

    private JLabel tfOnuOlsCfgSlotNo = new JLabel();
    private JLabel tfOnuOlsCfgPortNo = new JLabel();
    private JLabel tfOnuOlsCfgLogicalPortNo = new JLabel();
    private JLabel tfOnuOlsTemperature = new JLabel();
    private JLabel tfOnuOlsVoltage = new JLabel();
    private JLabel tfOnuOlsBiasCurrent = new JLabel();
    private JLabel tfOnuOlsTxPower = new JLabel();
    private JLabel tfOnuOlsRxPower = new JLabel();
    private IntegerTextField tfOnuOlsTempThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsTempThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsVoltageThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsVoltageThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsBiasCurrentThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsBiasCurrentThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsTxPowerThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsTxPowerThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsRxPowerThresholdAlarmHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsRxPowerThresholdAlarmLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsTempThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsTempThresholdWarningLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsVoltageThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsVoltageThresholdWarningLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsBiasCurrentThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsBiasCurrentThresholdWarningLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsTxPowerThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsTxPowerThresholdWarningLo = new IntegerTextField();
    private IntegerTextField tfOnuOlsRxPowerThresholdWarningHi = new IntegerTextField();
    private IntegerTextField tfOnuOlsRxPowerThresholdWarningLo = new IntegerTextField();
    private int[] onuOlsEnableVList = new int[]{1,0};
    private String[] onuOlsEnableTList = new String[]{fStringMap.getString("enable"),fStringMap.getString("disable")};
    private JComboBox tfOnuOlsEnable = new JComboBox(onuOlsEnableTList);

    private final String onuOlsCfgSlotNo = fStringMap.getString("onuOlsCfgSlotNo") + " : ";
    private final String onuOlsCfgPortNo = fStringMap.getString("onuOlsCfgPortNo") + " : ";
    private final String onuOlsCfgLogicalPortNo = fStringMap.getString("onuOlsCfgLogicalPortNo") + " : ";
    private final String onuOlsTemperature = fStringMap.getString("onuOlsTemperature") + " : ";
    private final String onuOlsVoltage = fStringMap.getString("onuOlsVoltage") + " : ";
    private final String onuOlsBiasCurrent = fStringMap.getString("onuOlsBiasCurrent") + " : ";
    private final String onuOlsTxPower = fStringMap.getString("onuOlsTxPower") + " : ";
    private final String onuOlsRxPower = fStringMap.getString("onuOlsRxPower") + " : ";
    private final String onuOlsTempThresholdAlarmHi = fStringMap.getString("onuOlsTempThresholdAlarmHi") + " : ";
    private final String onuOlsTempThresholdAlarmLo = fStringMap.getString("onuOlsTempThresholdAlarmLo") + " : ";
    private final String onuOlsVoltageThresholdAlarmHi = fStringMap.getString("onuOlsVoltageThresholdAlarmHi") + " : ";
    private final String onuOlsVoltageThresholdAlarmLo = fStringMap.getString("onuOlsVoltageThresholdAlarmLo") + " : ";
    private final String onuOlsBiasCurrentThresholdAlarmHi = fStringMap.getString("onuOlsBiasCurrentThresholdAlarmHi")
            + " : ";
    private final String onuOlsBiasCurrentThresholdAlarmLo = fStringMap.getString("onuOlsBiasCurrentThresholdAlarmLo")
            + " : ";
    private final String onuOlsTxPowerThresholdAlarmHi = fStringMap.getString("onuOlsTxPowerThresholdAlarmHi") + " : ";
    private final String onuOlsTxPowerThresholdAlarmLo = fStringMap.getString("onuOlsTxPowerThresholdAlarmLo") + " : ";
    private final String onuOlsRxPowerThresholdAlarmHi = fStringMap.getString("onuOlsRxPowerThresholdAlarmHi") + " : ";
    private final String onuOlsRxPowerThresholdAlarmLo = fStringMap.getString("onuOlsRxPowerThresholdAlarmLo") + " : ";
    private final String onuOlsTempThresholdWarningHi = fStringMap.getString("onuOlsTempThresholdWarningHi") + " : ";
    private final String onuOlsTempThresholdWarningLo = fStringMap.getString("onuOlsTempThresholdWarningLo") + " : ";
    private final String onuOlsVoltageThresholdWarningHi = fStringMap.getString("onuOlsVoltageThresholdWarningHi")
            + " : ";
    private final String onuOlsVoltageThresholdWarningLo = fStringMap.getString("onuOlsVoltageThresholdWarningLo")
            + " : ";
    private final String onuOlsBiasCurrentThresholdWarningHi = fStringMap
            .getString("onuOlsBiasCurrentThresholdWarningHi")
            + " : ";
    private final String onuOlsBiasCurrentThresholdWarningLo = fStringMap
            .getString("onuOlsBiasCurrentThresholdWarningLo")
            + " : ";
    private final String onuOlsTxPowerThresholdWarningHi = fStringMap.getString("onuOlsTxPowerThresholdWarningHi")
            + " : ";
    private final String onuOlsTxPowerThresholdWarningLo = fStringMap.getString("onuOlsTxPowerThresholdWarningLo")
            + " : ";
    private final String onuOlsRxPowerThresholdWarningHi = fStringMap.getString("onuOlsRxPowerThresholdWarningHi")
            + " : ";
    private final String onuOlsRxPowerThresholdWarningLo = fStringMap.getString("onuOlsRxPowerThresholdWarningLo")
            + " : ";
    private final String onuOlsEnable = fStringMap.getString("onuOlsEnable") + " : ";

    public GponOnuOlsCfgTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.LEFT, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel alarmPanel = new JPanel();
        
        layout = new NTLayout(5, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        alarmPanel.setLayout(layout);
        
        alarmPanel.add(new JLabel(onuOlsTempThresholdAlarmHi));
        tfOnuOlsTempThresholdAlarmHi.setName(fStringMap.getString("onuOlsTempThresholdAlarmHi"));
        alarmPanel.add(tfOnuOlsTempThresholdAlarmHi);

        alarmPanel.add(new JLabel(onuOlsTempThresholdAlarmLo));
        tfOnuOlsTempThresholdAlarmLo.setName(fStringMap.getString("onuOlsTempThresholdAlarmLo"));
        alarmPanel.add(tfOnuOlsTempThresholdAlarmLo);

        alarmPanel.add(new JLabel(onuOlsVoltageThresholdAlarmHi));
        tfOnuOlsVoltageThresholdAlarmHi.setName(fStringMap.getString("onuOlsVoltageThresholdAlarmHi"));
        alarmPanel.add(tfOnuOlsVoltageThresholdAlarmHi);

        alarmPanel.add(new JLabel(onuOlsVoltageThresholdAlarmLo));
        tfOnuOlsVoltageThresholdAlarmLo.setName(fStringMap.getString("onuOlsVoltageThresholdAlarmLo"));
        alarmPanel.add(tfOnuOlsVoltageThresholdAlarmLo);

        alarmPanel.add(new JLabel(onuOlsBiasCurrentThresholdAlarmHi));
        tfOnuOlsBiasCurrentThresholdAlarmHi.setName(fStringMap.getString("onuOlsBiasCurrentThresholdAlarmHi"));
        alarmPanel.add(tfOnuOlsBiasCurrentThresholdAlarmHi);

        alarmPanel.add(new JLabel(onuOlsBiasCurrentThresholdAlarmLo));
        tfOnuOlsBiasCurrentThresholdAlarmLo.setName(fStringMap.getString("onuOlsBiasCurrentThresholdAlarmLo"));
        alarmPanel.add(tfOnuOlsBiasCurrentThresholdAlarmLo);

        alarmPanel.add(new JLabel(onuOlsTxPowerThresholdAlarmHi));
        tfOnuOlsTxPowerThresholdAlarmHi.setName(fStringMap.getString("onuOlsTxPowerThresholdAlarmHi"));
        alarmPanel.add(tfOnuOlsTxPowerThresholdAlarmHi);

        alarmPanel.add(new JLabel(onuOlsTxPowerThresholdAlarmLo));
        tfOnuOlsTxPowerThresholdAlarmLo.setName(fStringMap.getString("onuOlsTxPowerThresholdAlarmLo"));
        alarmPanel.add(tfOnuOlsTxPowerThresholdAlarmLo);

        alarmPanel.add(new JLabel(onuOlsRxPowerThresholdAlarmHi));
        tfOnuOlsRxPowerThresholdAlarmHi.setName(fStringMap.getString("onuOlsRxPowerThresholdAlarmHi"));
        alarmPanel.add(tfOnuOlsRxPowerThresholdAlarmHi);

        alarmPanel.add(new JLabel(onuOlsRxPowerThresholdAlarmLo));
        tfOnuOlsRxPowerThresholdAlarmLo.setName(fStringMap.getString("onuOlsRxPowerThresholdAlarmLo"));
        alarmPanel.add(tfOnuOlsRxPowerThresholdAlarmLo);
        
        alarmPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("alarmPanel")));
        
        JPanel warningPanel = new JPanel();
        warningPanel.setLayout(layout);
        warningPanel.add(new JLabel(onuOlsTempThresholdWarningHi));
        tfOnuOlsTempThresholdWarningHi.setName(fStringMap.getString("onuOlsTempThresholdWarningHi"));
        warningPanel.add(tfOnuOlsTempThresholdWarningHi);

        warningPanel.add(new JLabel(onuOlsTempThresholdWarningLo));
        tfOnuOlsTempThresholdWarningLo.setName(fStringMap.getString("onuOlsTempThresholdWarningLo"));
        warningPanel.add(tfOnuOlsTempThresholdWarningLo);

        warningPanel.add(new JLabel(onuOlsVoltageThresholdWarningHi));
        tfOnuOlsVoltageThresholdWarningHi.setName(fStringMap.getString("onuOlsVoltageThresholdWarningHi"));
        warningPanel.add(tfOnuOlsVoltageThresholdWarningHi);

        warningPanel.add(new JLabel(onuOlsVoltageThresholdWarningLo));
        tfOnuOlsVoltageThresholdWarningLo.setName(fStringMap.getString("onuOlsVoltageThresholdWarningLo"));
        warningPanel.add(tfOnuOlsVoltageThresholdWarningLo);

        warningPanel.add(new JLabel(onuOlsBiasCurrentThresholdWarningHi));
        tfOnuOlsBiasCurrentThresholdWarningHi.setName(fStringMap.getString("onuOlsBiasCurrentThresholdWarningHi"));
        warningPanel.add(tfOnuOlsBiasCurrentThresholdWarningHi);

        warningPanel.add(new JLabel(onuOlsBiasCurrentThresholdWarningLo));
        tfOnuOlsBiasCurrentThresholdWarningLo.setName(fStringMap.getString("onuOlsBiasCurrentThresholdWarningLo"));
        warningPanel.add(tfOnuOlsBiasCurrentThresholdWarningLo);

        warningPanel.add(new JLabel(onuOlsTxPowerThresholdWarningHi));
        tfOnuOlsTxPowerThresholdWarningHi.setName(fStringMap.getString("onuOlsTxPowerThresholdWarningHi"));
        warningPanel.add(tfOnuOlsTxPowerThresholdWarningHi);

        warningPanel.add(new JLabel(onuOlsTxPowerThresholdWarningLo));
        tfOnuOlsTxPowerThresholdWarningLo.setName(fStringMap.getString("onuOlsTxPowerThresholdWarningLo"));
        warningPanel.add(tfOnuOlsTxPowerThresholdWarningLo);

        warningPanel.add(new JLabel(onuOlsRxPowerThresholdWarningHi));
        tfOnuOlsRxPowerThresholdWarningHi.setName(fStringMap.getString("onuOlsRxPowerThresholdWarningHi"));
        warningPanel.add(tfOnuOlsRxPowerThresholdWarningHi);

        warningPanel.add(new JLabel(onuOlsRxPowerThresholdWarningLo));
        tfOnuOlsRxPowerThresholdWarningLo.setName(fStringMap.getString("onuOlsRxPowerThresholdWarningLo"));
        warningPanel.add(tfOnuOlsRxPowerThresholdWarningLo);
        
        warningPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("warningPanel")));
      
        JPanel enablePanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.LEFT, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        
        enablePanel.add(new JLabel(onuOlsEnable));
        tfOnuOlsEnable.setName(fStringMap.getString("onuOlsEnable"));
        enablePanel.add(tfOnuOlsEnable);
        enablePanel.add(new HSpacer());
        
        baseInfoPanel.add(enablePanel);
        baseInfoPanel.add(alarmPanel);
        baseInfoPanel.add(warningPanel);
        
        add( baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {

    }

    public void refresh() {

        GponOnuOlsCfgTable mbean = (GponOnuOlsCfgTable) getModel();

        tfOnuOlsCfgSlotNo.setText(mbean.getOnuOlsCfgSlotNo().toString());
        tfOnuOlsCfgPortNo.setText(mbean.getOnuOlsCfgPortNo().toString());
        tfOnuOlsCfgLogicalPortNo.setText(mbean.getOnuOlsCfgLogicalPortNo().toString());
        tfOnuOlsTemperature.setText(mbean.getOnuOlsTemperature().toString());
        tfOnuOlsVoltage.setText(mbean.getOnuOlsVoltage().toString());
        tfOnuOlsBiasCurrent.setText(mbean.getOnuOlsBiasCurrent().toString());
        tfOnuOlsTxPower.setText(mbean.getOnuOlsTxPower().toString());
        tfOnuOlsRxPower.setText(mbean.getOnuOlsRxPower().toString());
        tfOnuOlsTempThresholdAlarmHi.setValue(mbean.getOnuOlsTempThresholdAlarmHi().intValue());
        tfOnuOlsTempThresholdAlarmLo.setValue(mbean.getOnuOlsTempThresholdAlarmLo().intValue());
        tfOnuOlsVoltageThresholdAlarmHi.setValue(mbean.getOnuOlsVoltageThresholdAlarmHi().intValue());
        tfOnuOlsVoltageThresholdAlarmLo.setValue(mbean.getOnuOlsVoltageThresholdAlarmLo().intValue());
        tfOnuOlsBiasCurrentThresholdAlarmHi.setValue(mbean.getOnuOlsBiasCurrentThresholdAlarmHi().intValue());
        tfOnuOlsBiasCurrentThresholdAlarmLo.setValue(mbean.getOnuOlsBiasCurrentThresholdAlarmLo().intValue());
        tfOnuOlsTxPowerThresholdAlarmHi.setValue(mbean.getOnuOlsTxPowerThresholdAlarmHi().intValue());
        tfOnuOlsTxPowerThresholdAlarmLo.setValue(mbean.getOnuOlsTxPowerThresholdAlarmLo().intValue());
        tfOnuOlsRxPowerThresholdAlarmHi.setValue(mbean.getOnuOlsRxPowerThresholdAlarmHi().intValue());
        tfOnuOlsRxPowerThresholdAlarmLo.setValue(mbean.getOnuOlsRxPowerThresholdAlarmLo().intValue());
        tfOnuOlsTempThresholdWarningHi.setValue(mbean.getOnuOlsTempThresholdWarningHi().intValue());
        tfOnuOlsTempThresholdWarningLo.setValue(mbean.getOnuOlsTempThresholdWarningLo().intValue());
        tfOnuOlsVoltageThresholdWarningHi.setValue(mbean.getOnuOlsVoltageThresholdWarningHi().intValue());
        tfOnuOlsVoltageThresholdWarningLo.setValue(mbean.getOnuOlsVoltageThresholdWarningLo().intValue());
        tfOnuOlsBiasCurrentThresholdWarningHi.setValue(mbean.getOnuOlsBiasCurrentThresholdWarningHi().intValue());
        tfOnuOlsBiasCurrentThresholdWarningLo.setValue(mbean.getOnuOlsBiasCurrentThresholdWarningLo().intValue());
        tfOnuOlsTxPowerThresholdWarningHi.setValue(mbean.getOnuOlsTxPowerThresholdWarningHi().intValue());
        tfOnuOlsTxPowerThresholdWarningLo.setValue(mbean.getOnuOlsTxPowerThresholdWarningLo().intValue());
        tfOnuOlsRxPowerThresholdWarningHi.setValue(mbean.getOnuOlsRxPowerThresholdWarningHi().intValue());
        tfOnuOlsRxPowerThresholdWarningLo.setValue(mbean.getOnuOlsRxPowerThresholdWarningLo().intValue());
        tfOnuOlsEnable.setSelectedIndex(getIndexFromValue(onuOlsEnableVList, mbean.getOnuOlsEnable().intValue()));

    }

    public void updateModel() {

        GponOnuOlsCfgTable mbean = (GponOnuOlsCfgTable) getModel();

        mbean.setOnuOlsTempThresholdAlarmHi(new Integer(tfOnuOlsTempThresholdAlarmHi.getValue()));
        mbean.setOnuOlsTempThresholdAlarmLo(new Integer(tfOnuOlsTempThresholdAlarmLo.getValue()));
        mbean.setOnuOlsVoltageThresholdAlarmHi(new Integer(tfOnuOlsVoltageThresholdAlarmHi.getValue()));
        mbean.setOnuOlsVoltageThresholdAlarmLo(new Integer(tfOnuOlsVoltageThresholdAlarmLo.getValue()));
        mbean.setOnuOlsBiasCurrentThresholdAlarmHi(new Integer(tfOnuOlsBiasCurrentThresholdAlarmHi.getValue()));
        mbean.setOnuOlsBiasCurrentThresholdAlarmLo(new Integer(tfOnuOlsBiasCurrentThresholdAlarmLo.getValue()));
        mbean.setOnuOlsTxPowerThresholdAlarmHi(new Integer(tfOnuOlsTxPowerThresholdAlarmHi.getValue()));
        mbean.setOnuOlsTxPowerThresholdAlarmLo(new Integer(tfOnuOlsTxPowerThresholdAlarmLo.getValue()));
        mbean.setOnuOlsRxPowerThresholdAlarmHi(new Integer(tfOnuOlsRxPowerThresholdAlarmHi.getValue()));
        mbean.setOnuOlsRxPowerThresholdAlarmLo(new Integer(tfOnuOlsRxPowerThresholdAlarmLo.getValue()));
        mbean.setOnuOlsTempThresholdWarningHi(new Integer(tfOnuOlsTempThresholdWarningHi.getValue()));
        mbean.setOnuOlsTempThresholdWarningLo(new Integer(tfOnuOlsTempThresholdWarningLo.getValue()));
        mbean.setOnuOlsVoltageThresholdWarningHi(new Integer(tfOnuOlsVoltageThresholdWarningHi.getValue()));
        mbean.setOnuOlsVoltageThresholdWarningLo(new Integer(tfOnuOlsVoltageThresholdWarningLo.getValue()));
        mbean.setOnuOlsBiasCurrentThresholdWarningHi(new Integer(tfOnuOlsBiasCurrentThresholdWarningHi.getValue()));
        mbean.setOnuOlsBiasCurrentThresholdWarningLo(new Integer(tfOnuOlsBiasCurrentThresholdWarningLo.getValue()));
        mbean.setOnuOlsTxPowerThresholdWarningHi(new Integer(tfOnuOlsTxPowerThresholdWarningHi.getValue()));
        mbean.setOnuOlsTxPowerThresholdWarningLo(new Integer(tfOnuOlsTxPowerThresholdWarningLo.getValue()));
        mbean.setOnuOlsRxPowerThresholdWarningHi(new Integer(tfOnuOlsRxPowerThresholdWarningHi.getValue()));
        mbean.setOnuOlsRxPowerThresholdWarningLo(new Integer(tfOnuOlsRxPowerThresholdWarningLo.getValue()));
        mbean.setOnuOlsEnable(onuOlsEnableVList[tfOnuOlsEnable.getSelectedIndex()]);

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
