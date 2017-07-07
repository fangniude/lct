package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

/**
 * @author Yang Yizai , 2009-3-9
 */

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOltOlsCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The GponOltOlsCfgTablePanel class.
 * Created by DVM Creator
 */
public class GponOltOlsCfgTablePanel extends UPanel {

    private JLabel tfOltOlsCfgSlotNo = new JLabel();

    private JLabel tfOltOlsCfgPortNo = new JLabel();

    private JLabel tfOltOlsTemperature = new JLabel();

    private JLabel tfOltOlsVoltage = new JLabel();

    private JLabel tfOltOlsBiasCurrent = new JLabel();

    private JLabel tfOltOlsTxPower = new JLabel();

    private IntegerTextField tfOltOlsTempThresholdAlarmHi = new IntegerTextField();

    private IntegerTextField tfOltOlsTempThresholdAlarmLo = new IntegerTextField();

    private IntegerTextField tfOltOlsVoltageThresholdAlarmHi = new IntegerTextField();

    private IntegerTextField tfOltOlsVoltageThresholdAlarmLo = new IntegerTextField();

    private IntegerTextField tfOltOlsBiasCurrentThresholdAlarmHi = new IntegerTextField();

    private IntegerTextField tfOltOlsBiasCurrentThresholdAlarmLo = new IntegerTextField();

    private IntegerTextField tfOltOlsTxPowerThresholdAlarmHi = new IntegerTextField();

    private IntegerTextField tfOltOlsTxPowerThresholdAlarmLo = new IntegerTextField();

    private IntegerTextField tfOltOlsTempThresholdWarningHi = new IntegerTextField();

    private IntegerTextField tfOltOlsTempThresholdWarningLo = new IntegerTextField();

    private IntegerTextField tfOltOlsVoltageThresholdWarningHi = new IntegerTextField();

    private IntegerTextField tfOltOlsVoltageThresholdWarningLo = new IntegerTextField();

    private IntegerTextField tfOltOlsBiasCurrentThresholdWarningHi = new IntegerTextField();

    private IntegerTextField tfOltOlsBiasCurrentThresholdWarningLo = new IntegerTextField();

    private IntegerTextField tfOltOlsTxPowerThresholdWarningHi = new IntegerTextField();

    private IntegerTextField tfOltOlsTxPowerThresholdWarningLo = new IntegerTextField();

    private final String oltOlsCfgSlotNo = fStringMap.getString("oltOlsCfgSlotNo") + " : ";
    private final String oltOlsCfgPortNo = fStringMap.getString("oltOlsCfgPortNo") + " : ";
    private final String oltOlsTemperature = fStringMap.getString("oltOlsTemperature") + " : ";
    private final String oltOlsVoltage = fStringMap.getString("oltOlsVoltage") + " : ";
    private final String oltOlsBiasCurrent = fStringMap.getString("oltOlsBiasCurrent") + " : ";
    private final String oltOlsTxPower = fStringMap.getString("oltOlsTxPower") + " : ";
    private final String oltOlsTempThresholdAlarmHi = fStringMap.getString("oltOlsTempThresholdAlarmHi") + " : ";
    private final String oltOlsTempThresholdAlarmLo = fStringMap.getString("oltOlsTempThresholdAlarmLo") + " : ";
    private final String oltOlsVoltageThresholdAlarmHi = fStringMap.getString("oltOlsVoltageThresholdAlarmHi") + " : ";
    private final String oltOlsVoltageThresholdAlarmLo = fStringMap.getString("oltOlsVoltageThresholdAlarmLo") + " : ";
    private final String oltOlsBiasCurrentThresholdAlarmHi = fStringMap.getString("oltOlsBiasCurrentThresholdAlarmHi")
            + " : ";
    private final String oltOlsBiasCurrentThresholdAlarmLo = fStringMap.getString("oltOlsBiasCurrentThresholdAlarmLo")
            + " : ";
    private final String oltOlsTxPowerThresholdAlarmHi = fStringMap.getString("oltOlsTxPowerThresholdAlarmHi") + " : ";
    private final String oltOlsTxPowerThresholdAlarmLo = fStringMap.getString("oltOlsTxPowerThresholdAlarmLo") + " : ";
    private final String oltOlsTempThresholdWarningHi = fStringMap.getString("oltOlsTempThresholdWarningHi") + " : ";
    private final String oltOlsTempThresholdWarningLo = fStringMap.getString("oltOlsTempThresholdWarningLo") + " : ";
    private final String oltOlsVoltageThresholdWarningHi = fStringMap.getString("oltOlsVoltageThresholdWarningHi")
            + " : ";
    private final String oltOlsVoltageThresholdWarningLo = fStringMap.getString("oltOlsVoltageThresholdWarningLo")
            + " : ";
    private final String oltOlsBiasCurrentThresholdWarningHi = fStringMap
            .getString("oltOlsBiasCurrentThresholdWarningHi")
            + " : ";
    private final String oltOlsBiasCurrentThresholdWarningLo = fStringMap
            .getString("oltOlsBiasCurrentThresholdWarningLo")
            + " : ";
    private final String oltOlsTxPowerThresholdWarningHi = fStringMap.getString("oltOlsTxPowerThresholdWarningHi")
            + " : ";
    private final String oltOlsTxPowerThresholdWarningLo = fStringMap.getString("oltOlsTxPowerThresholdWarningLo")
            + " : ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public GponOltOlsCfgTablePanel(IApplication app) {
        super(app);
        setModel(new GponOltOlsCfgTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {


        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel alarmPanel = new JPanel();
        layout = new NTLayout(5, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        alarmPanel.setLayout(layout);

        alarmPanel.add(new JLabel(oltOlsTempThresholdAlarmHi));
        tfOltOlsTempThresholdAlarmHi.setName(fStringMap.getString("oltOlsTempThresholdAlarmHi"));
        alarmPanel.add(tfOltOlsTempThresholdAlarmHi);

        alarmPanel.add(new JLabel(oltOlsTempThresholdAlarmLo));
        tfOltOlsTempThresholdAlarmLo.setName(fStringMap.getString("oltOlsTempThresholdAlarmLo"));
        alarmPanel.add(tfOltOlsTempThresholdAlarmLo);

        alarmPanel.add(new JLabel(oltOlsVoltageThresholdAlarmHi));
        tfOltOlsVoltageThresholdAlarmHi.setName(fStringMap.getString("oltOlsVoltageThresholdAlarmHi"));
        alarmPanel.add(tfOltOlsVoltageThresholdAlarmHi);

        alarmPanel.add(new JLabel(oltOlsVoltageThresholdAlarmLo));
        tfOltOlsVoltageThresholdAlarmLo.setName(fStringMap.getString("oltOlsVoltageThresholdAlarmLo"));
        alarmPanel.add(tfOltOlsVoltageThresholdAlarmLo);

        alarmPanel.add(new JLabel(oltOlsBiasCurrentThresholdAlarmHi));
        tfOltOlsBiasCurrentThresholdAlarmHi.setName(fStringMap.getString("oltOlsBiasCurrentThresholdAlarmHi"));
        alarmPanel.add(tfOltOlsBiasCurrentThresholdAlarmHi);

        alarmPanel.add(new JLabel(oltOlsBiasCurrentThresholdAlarmLo));
        tfOltOlsBiasCurrentThresholdAlarmLo.setName(fStringMap.getString("oltOlsBiasCurrentThresholdAlarmLo"));
        alarmPanel.add(tfOltOlsBiasCurrentThresholdAlarmLo);

        alarmPanel.add(new JLabel(oltOlsTxPowerThresholdAlarmHi));
        tfOltOlsTxPowerThresholdAlarmHi.setName(fStringMap.getString("oltOlsTxPowerThresholdAlarmHi"));
        alarmPanel.add(tfOltOlsTxPowerThresholdAlarmHi);

        alarmPanel.add(new JLabel(oltOlsTxPowerThresholdAlarmLo));
        tfOltOlsTxPowerThresholdAlarmLo.setName(fStringMap.getString("oltOlsTxPowerThresholdAlarmLo"));
        alarmPanel.add(tfOltOlsTxPowerThresholdAlarmLo);

        alarmPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("alarmPanel")));
        
        JPanel warningPanel = new JPanel();
        warningPanel.setLayout(layout);
        
        warningPanel.add(new JLabel(oltOlsTempThresholdWarningHi));
        tfOltOlsTempThresholdWarningHi.setName(fStringMap.getString("oltOlsTempThresholdWarningHi"));
        warningPanel.add(tfOltOlsTempThresholdWarningHi);

        warningPanel.add(new JLabel(oltOlsTempThresholdWarningLo));
        tfOltOlsTempThresholdWarningLo.setName(fStringMap.getString("oltOlsTempThresholdWarningLo"));
        warningPanel.add(tfOltOlsTempThresholdWarningLo);

        warningPanel.add(new JLabel(oltOlsVoltageThresholdWarningHi));
        tfOltOlsVoltageThresholdWarningHi.setName(fStringMap.getString("oltOlsVoltageThresholdWarningHi"));
        warningPanel.add(tfOltOlsVoltageThresholdWarningHi);

        warningPanel.add(new JLabel(oltOlsVoltageThresholdWarningLo));
        tfOltOlsVoltageThresholdWarningLo.setName(fStringMap.getString("oltOlsVoltageThresholdWarningLo"));
        warningPanel.add(tfOltOlsVoltageThresholdWarningLo);

        warningPanel.add(new JLabel(oltOlsBiasCurrentThresholdWarningHi));
        tfOltOlsBiasCurrentThresholdWarningHi.setName(fStringMap.getString("oltOlsBiasCurrentThresholdWarningHi"));
        warningPanel.add(tfOltOlsBiasCurrentThresholdWarningHi);

        warningPanel.add(new JLabel(oltOlsBiasCurrentThresholdWarningLo));
        tfOltOlsBiasCurrentThresholdWarningLo.setName(fStringMap.getString("oltOlsBiasCurrentThresholdWarningLo"));
        warningPanel.add(tfOltOlsBiasCurrentThresholdWarningLo);

        warningPanel.add(new JLabel(oltOlsTxPowerThresholdWarningHi));
        tfOltOlsTxPowerThresholdWarningHi.setName(fStringMap.getString("oltOlsTxPowerThresholdWarningHi"));
        warningPanel.add(tfOltOlsTxPowerThresholdWarningHi);

        warningPanel.add(new JLabel(oltOlsTxPowerThresholdWarningLo));
        tfOltOlsTxPowerThresholdWarningLo.setName(fStringMap.getString("oltOlsTxPowerThresholdWarningLo"));
        warningPanel.add(tfOltOlsTxPowerThresholdWarningLo);

        baseInfoPanel.add(alarmPanel);
        baseInfoPanel.add(warningPanel);
        
        add( baseInfoPanel, BorderLayout.CENTER);

    }

    protected void initForm() {

    }

    public void refresh() {

        GponOltOlsCfgTable mbean = (GponOltOlsCfgTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfOltOlsCfgSlotNo.setText(mbean.getOltOlsCfgSlotNo().toString());
        tfOltOlsCfgPortNo.setText(mbean.getOltOlsCfgPortNo().toString());
        tfOltOlsTemperature.setText(mbean.getOltOlsTemperature().toString());
        tfOltOlsVoltage.setText(mbean.getOltOlsVoltage().toString());
        tfOltOlsBiasCurrent.setText(mbean.getOltOlsBiasCurrent().toString());
        tfOltOlsTxPower.setText(mbean.getOltOlsTxPower().toString());
        tfOltOlsTempThresholdAlarmHi.setValue(mbean.getOltOlsTempThresholdAlarmHi().intValue());
        tfOltOlsTempThresholdAlarmLo.setValue(mbean.getOltOlsTempThresholdAlarmLo().intValue());
        tfOltOlsVoltageThresholdAlarmHi.setValue(mbean.getOltOlsVoltageThresholdAlarmHi().intValue());
        tfOltOlsVoltageThresholdAlarmLo.setValue(mbean.getOltOlsVoltageThresholdAlarmLo().intValue());
        tfOltOlsBiasCurrentThresholdAlarmHi.setValue(mbean.getOltOlsBiasCurrentThresholdAlarmHi().intValue());
        tfOltOlsBiasCurrentThresholdAlarmLo.setValue(mbean.getOltOlsBiasCurrentThresholdAlarmLo().intValue());
        tfOltOlsTxPowerThresholdAlarmHi.setValue(mbean.getOltOlsTxPowerThresholdAlarmHi().intValue());
        tfOltOlsTxPowerThresholdAlarmLo.setValue(mbean.getOltOlsTxPowerThresholdAlarmLo().intValue());
        tfOltOlsTempThresholdWarningHi.setValue(mbean.getOltOlsTempThresholdWarningHi().intValue());
        tfOltOlsTempThresholdWarningLo.setValue(mbean.getOltOlsTempThresholdWarningLo().intValue());
        tfOltOlsVoltageThresholdWarningHi.setValue(mbean.getOltOlsVoltageThresholdWarningHi().intValue());
        tfOltOlsVoltageThresholdWarningLo.setValue(mbean.getOltOlsVoltageThresholdWarningLo().intValue());
        tfOltOlsBiasCurrentThresholdWarningHi.setValue(mbean.getOltOlsBiasCurrentThresholdWarningHi().intValue());
        tfOltOlsBiasCurrentThresholdWarningLo.setValue(mbean.getOltOlsBiasCurrentThresholdWarningLo().intValue());
        tfOltOlsTxPowerThresholdWarningHi.setValue(mbean.getOltOlsTxPowerThresholdWarningHi().intValue());
        tfOltOlsTxPowerThresholdWarningLo.setValue(mbean.getOltOlsTxPowerThresholdWarningLo().intValue());

    }

    public void updateModel() {

        GponOltOlsCfgTable mbean = (GponOltOlsCfgTable) getModel();

        mbean.setOltOlsTempThresholdAlarmHi(new Integer(tfOltOlsTempThresholdAlarmHi.getValue()*4));
        mbean.setOltOlsTempThresholdAlarmLo(new Integer(tfOltOlsTempThresholdAlarmLo.getValue()*4));
        mbean.setOltOlsVoltageThresholdAlarmHi(new Integer(tfOltOlsVoltageThresholdAlarmHi.getValue()*10000));
        mbean.setOltOlsVoltageThresholdAlarmLo(new Integer(tfOltOlsVoltageThresholdAlarmLo.getValue()*10000));
        mbean.setOltOlsBiasCurrentThresholdAlarmHi(new Integer(tfOltOlsBiasCurrentThresholdAlarmHi.getValue()*1000/2));
        mbean.setOltOlsBiasCurrentThresholdAlarmLo(new Integer(tfOltOlsBiasCurrentThresholdAlarmLo.getValue()*1000/2));
        mbean.setOltOlsTxPowerThresholdAlarmHi(new Integer(tfOltOlsTxPowerThresholdAlarmHi.getValue()*10));
        mbean.setOltOlsTxPowerThresholdAlarmLo(new Integer(tfOltOlsTxPowerThresholdAlarmLo.getValue()*10));
        mbean.setOltOlsTempThresholdWarningHi(new Integer(tfOltOlsTempThresholdWarningHi.getValue()*4));
        mbean.setOltOlsTempThresholdWarningLo(new Integer(tfOltOlsTempThresholdWarningLo.getValue()*4));
        mbean.setOltOlsVoltageThresholdWarningHi(new Integer(tfOltOlsVoltageThresholdWarningHi.getValue()*10000));
        mbean.setOltOlsVoltageThresholdWarningLo(new Integer(tfOltOlsVoltageThresholdWarningLo.getValue()*10000));
        mbean.setOltOlsBiasCurrentThresholdWarningHi(new Integer(tfOltOlsBiasCurrentThresholdWarningHi.getValue()*1000/2));
        mbean.setOltOlsBiasCurrentThresholdWarningLo(new Integer(tfOltOlsBiasCurrentThresholdWarningLo.getValue()*1000/2));
        mbean.setOltOlsTxPowerThresholdWarningHi(new Integer(tfOltOlsTxPowerThresholdWarningHi.getValue()*10));
        mbean.setOltOlsTxPowerThresholdWarningLo(new Integer(tfOltOlsTxPowerThresholdWarningLo.getValue()*10));

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
