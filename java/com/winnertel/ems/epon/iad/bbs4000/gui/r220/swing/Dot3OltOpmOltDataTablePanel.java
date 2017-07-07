/**
 * Created by Zhou Chao, 2010/4/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r220.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3OltOpmOltDataTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3OltOpmOltDataTablePanel extends UPanel {

    private JLabel tfUtsDot3OltOpmOltDataTemperature = new JLabel();
    private JLabel tfUtsDot3OltOpmOltDataVoltage = new JLabel();
    private JLabel tfUtsDot3OltOpmOltDataBiasCurrent = new JLabel();
    private JLabel tfUtsDot3OltOpmOltDataTxPower = new JLabel();

    private IntegerTextField tfUtsDot3OltOpmVoltageMinThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmVoltageMaxThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmBiasCurrentMinThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmBiasCurrentMaxThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmTemperatureMinThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmTemperatureMaxThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmTxPowerMinThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmTxPowerMaxThreshold = new IntegerTextField();

    private final String utsDot3OltOpmOltDataTemperature = fStringMap.getString("utsDot3OltOpmOltDataTemperature") + " : ";
    private final String utsDot3OltOpmOltDataVoltage = fStringMap.getString("utsDot3OltOpmOltDataVoltage") + " : ";
    private final String utsDot3OltOpmOltDataBiasCurrent = fStringMap.getString("utsDot3OltOpmOltDataBiasCurrent") + " : ";
    private final String utsDot3OltOpmOltDataTxPower = fStringMap.getString("utsDot3OltOpmOltDataTxPower") + " : ";
    private final String utsDot3OltOpmVoltageMinThreshold = fStringMap.getString("utsDot3OltOpmVoltageMinThreshold") + " : ";
    private final String utsDot3OltOpmVoltageMaxThreshold = fStringMap.getString("utsDot3OltOpmVoltageMaxThreshold") + " : ";
    private final String utsDot3OltOpmBiasCurrentMinThreshold = fStringMap.getString("utsDot3OltOpmBiasCurrentMinThreshold") + " : ";
    private final String utsDot3OltOpmBiasCurrentMaxThreshold = fStringMap.getString("utsDot3OltOpmBiasCurrentMaxThreshold") + " : ";
    private final String utsDot3OltOpmTemperatureMinThreshold = fStringMap.getString("utsDot3OltOpmTemperatureMinThreshold") + " : ";
    private final String utsDot3OltOpmTemperatureMaxThreshold = fStringMap.getString("utsDot3OltOpmTemperatureMaxThreshold") + " : ";
    private final String utsDot3OltOpmTxPowerMinThreshold = fStringMap.getString("utsDot3OltOpmTxPowerMinThreshold") + " : ";
    private final String utsDot3OltOpmTxPowerMaxThreshold = fStringMap.getString("utsDot3OltOpmTxPowerMaxThreshold") + " : ";

    public Dot3OltOpmOltDataTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataTemperature));
        baseInfoPanel.add(tfUtsDot3OltOpmOltDataTemperature);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataVoltage));
        baseInfoPanel.add(tfUtsDot3OltOpmOltDataVoltage);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataBiasCurrent));
        baseInfoPanel.add(tfUtsDot3OltOpmOltDataBiasCurrent);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOltDataTxPower));
        baseInfoPanel.add(tfUtsDot3OltOpmOltDataTxPower);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMinThreshold));
        tfUtsDot3OltOpmVoltageMinThreshold.setName(fStringMap.getString("utsDot3OltOpmVoltageMinThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmVoltageMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmVoltageMaxThreshold));
        tfUtsDot3OltOpmVoltageMaxThreshold.setName(fStringMap.getString("utsDot3OltOpmVoltageMaxThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmVoltageMaxThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmBiasCurrentMinThreshold));
        tfUtsDot3OltOpmBiasCurrentMinThreshold.setName(fStringMap.getString("utsDot3OltOpmBiasCurrentMinThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmBiasCurrentMaxThreshold));
        tfUtsDot3OltOpmBiasCurrentMaxThreshold.setName(fStringMap.getString("utsDot3OltOpmBiasCurrentMaxThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmBiasCurrentMaxThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmTemperatureMinThreshold));
        tfUtsDot3OltOpmTemperatureMinThreshold.setName(fStringMap.getString("utsDot3OltOpmTemperatureMinThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmTemperatureMaxThreshold));
        tfUtsDot3OltOpmTemperatureMaxThreshold.setName(fStringMap.getString("utsDot3OltOpmTemperatureMaxThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmTemperatureMaxThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMinThreshold));
        tfUtsDot3OltOpmTxPowerMinThreshold.setName(fStringMap.getString("utsDot3OltOpmTxPowerMinThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmTxPowerMaxThreshold));
        tfUtsDot3OltOpmTxPowerMaxThreshold.setName(fStringMap.getString("utsDot3OltOpmTxPowerMaxThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmTxPowerMaxThreshold);
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
        Dot3OltOpmOltDataTable mbean = (Dot3OltOpmOltDataTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3OltOpmOltDataTemperature.setText(mbean.getUtsDot3OltOpmOltDataTemperature().toString());
        tfUtsDot3OltOpmOltDataVoltage.setText(mbean.getUtsDot3OltOpmOltDataVoltage().toString());
        tfUtsDot3OltOpmOltDataBiasCurrent.setText(mbean.getUtsDot3OltOpmOltDataBiasCurrent().toString());
        tfUtsDot3OltOpmOltDataTxPower.setText(mbean.getUtsDot3OltOpmOltDataTxPower().toString());
        tfUtsDot3OltOpmVoltageMinThreshold.setValue(mbean.getUtsDot3OltOpmVoltageMinThreshold());
        tfUtsDot3OltOpmVoltageMaxThreshold.setValue(mbean.getUtsDot3OltOpmVoltageMaxThreshold());
        tfUtsDot3OltOpmBiasCurrentMinThreshold.setValue(mbean.getUtsDot3OltOpmBiasCurrentMinThreshold());
        tfUtsDot3OltOpmBiasCurrentMaxThreshold.setValue(mbean.getUtsDot3OltOpmBiasCurrentMaxThreshold());
        tfUtsDot3OltOpmTemperatureMinThreshold.setValue(mbean.getUtsDot3OltOpmTemperatureMinThreshold());
        tfUtsDot3OltOpmTemperatureMaxThreshold.setValue(mbean.getUtsDot3OltOpmTemperatureMaxThreshold());
        tfUtsDot3OltOpmTxPowerMinThreshold.setValue(mbean.getUtsDot3OltOpmTxPowerMinThreshold());
        tfUtsDot3OltOpmTxPowerMaxThreshold.setValue(mbean.getUtsDot3OltOpmTxPowerMaxThreshold());
    }

    public void updateModel() {
        Dot3OltOpmOltDataTable mbean = (Dot3OltOpmOltDataTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3OltOpmVoltageMinThreshold(new Integer(tfUtsDot3OltOpmVoltageMinThreshold.getValue()));
        mbean.setUtsDot3OltOpmVoltageMaxThreshold(new Integer(tfUtsDot3OltOpmVoltageMaxThreshold.getValue()));
        mbean.setUtsDot3OltOpmBiasCurrentMinThreshold(new Integer(tfUtsDot3OltOpmBiasCurrentMinThreshold.getValue()));
        mbean.setUtsDot3OltOpmBiasCurrentMaxThreshold(new Integer(tfUtsDot3OltOpmBiasCurrentMaxThreshold.getValue()));
        mbean.setUtsDot3OltOpmTemperatureMinThreshold(new Integer(tfUtsDot3OltOpmTemperatureMinThreshold.getValue()));
        mbean.setUtsDot3OltOpmTemperatureMaxThreshold(new Integer(tfUtsDot3OltOpmTemperatureMaxThreshold.getValue()));
        mbean.setUtsDot3OltOpmTxPowerMinThreshold(new Integer(tfUtsDot3OltOpmTxPowerMinThreshold.getValue()));
        mbean.setUtsDot3OltOpmTxPowerMaxThreshold(new Integer(tfUtsDot3OltOpmTxPowerMaxThreshold.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}