/**
 * Created by Zhou Chao, 2010/4/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r220.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r220.UplinkOpmDataTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.DoubleTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UplinkOpmDataTablePanel extends UPanel {

    private JLabel tfUtsUplinkOpmDataRxPower = new JLabel();
    private JLabel tfUtsUplinkOpmDataTxPower = new JLabel();

    private DoubleTextField tfUtsUplinkOpmRxPowerMinThreshold = new DoubleTextField();
    private DoubleTextField tfUtsUplinkOpmRxPowerMaxThreshold = new DoubleTextField();
    private DoubleTextField tfUtsUplinkOpmTxPowerMinThreshold = new DoubleTextField();
    private DoubleTextField tfUtsUplinkOpmTxPowerMaxThreshold = new DoubleTextField();

    private final String utsUplinkOpmDataRxPower = fStringMap.getString("utsUplinkOpmDataRxPower") + " : ";
    private final String utsUplinkOpmDataTxPower = fStringMap.getString("utsUplinkOpmDataTxPower") + " : ";
    private final String utsUplinkOpmRxPowerMinThreshold = fStringMap.getString("utsUplinkOpmRxPowerMinThreshold") + " : ";
    private final String utsUplinkOpmRxPowerMaxThreshold = fStringMap.getString("utsUplinkOpmRxPowerMaxThreshold") + " : ";
    private final String utsUplinkOpmTxPowerMinThreshold = fStringMap.getString("utsUplinkOpmTxPowerMinThreshold") + " : ";
    private final String utsUplinkOpmTxPowerMaxThreshold = fStringMap.getString("utsUplinkOpmTxPowerMaxThreshold") + " : ";

    public UplinkOpmDataTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsUplinkOpmDataRxPower));
        baseInfoPanel.add(tfUtsUplinkOpmDataRxPower);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsUplinkOpmDataTxPower));
        baseInfoPanel.add(tfUtsUplinkOpmDataTxPower);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsUplinkOpmRxPowerMinThreshold));
        tfUtsUplinkOpmRxPowerMinThreshold.setName(fStringMap.getString("utsUplinkOpmRxPowerMinThreshold"));
        baseInfoPanel.add(tfUtsUplinkOpmRxPowerMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsUplinkOpmRxPowerMaxThreshold));
        tfUtsUplinkOpmRxPowerMaxThreshold.setName(fStringMap.getString("utsUplinkOpmRxPowerMaxThreshold"));
        baseInfoPanel.add(tfUtsUplinkOpmRxPowerMaxThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsUplinkOpmTxPowerMinThreshold));
        tfUtsUplinkOpmTxPowerMinThreshold.setName(fStringMap.getString("utsUplinkOpmTxPowerMinThreshold"));
        baseInfoPanel.add(tfUtsUplinkOpmTxPowerMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsUplinkOpmTxPowerMaxThreshold));
        tfUtsUplinkOpmTxPowerMaxThreshold.setName(fStringMap.getString("utsUplinkOpmTxPowerMaxThreshold"));
        baseInfoPanel.add(tfUtsUplinkOpmTxPowerMaxThreshold);
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
        tfUtsUplinkOpmRxPowerMinThreshold.setValueScope(-40, 8.1);
        tfUtsUplinkOpmRxPowerMaxThreshold.setValueScope(-40, 8.1);
        tfUtsUplinkOpmTxPowerMinThreshold.setValueScope(-40, 8.1);
        tfUtsUplinkOpmTxPowerMaxThreshold.setValueScope(-40, 8.1);
    }

    public void refresh() {
        UplinkOpmDataTable mbean = (UplinkOpmDataTable) getModel();
        if (mbean == null)
            return;

        tfUtsUplinkOpmDataRxPower.setText(mbean.getUtsUplinkOpmDataRxPower().toString());
        tfUtsUplinkOpmDataTxPower.setText(mbean.getUtsUplinkOpmDataTxPower().toString());

        tfUtsUplinkOpmRxPowerMinThreshold.setValue(mbean.getUtsUplinkOpmRxPowerMinThreshold());
        tfUtsUplinkOpmRxPowerMaxThreshold.setValue(mbean.getUtsUplinkOpmRxPowerMaxThreshold());
        tfUtsUplinkOpmTxPowerMinThreshold.setValue(mbean.getUtsUplinkOpmTxPowerMinThreshold());
        tfUtsUplinkOpmTxPowerMaxThreshold.setValue(mbean.getUtsUplinkOpmTxPowerMaxThreshold());
    }

    public void updateModel() {
        UplinkOpmDataTable mbean = (UplinkOpmDataTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsUplinkOpmRxPowerMinThreshold(new Double(tfUtsUplinkOpmRxPowerMinThreshold.getValue()));
        mbean.setUtsUplinkOpmRxPowerMaxThreshold(new Double(tfUtsUplinkOpmRxPowerMaxThreshold.getValue()));
        mbean.setUtsUplinkOpmTxPowerMinThreshold(new Double(tfUtsUplinkOpmTxPowerMinThreshold.getValue()));
        mbean.setUtsUplinkOpmTxPowerMaxThreshold(new Double(tfUtsUplinkOpmTxPowerMaxThreshold.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}