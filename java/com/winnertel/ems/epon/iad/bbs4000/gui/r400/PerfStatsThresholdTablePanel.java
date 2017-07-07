/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PerfStatsThresholdTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class PerfStatsThresholdTablePanel extends UPanel {

    private LongTextField tfPerfStatsThresholdDeviceIndex = new LongTextField();
    private LongTextField tfPerfStatsThresholdCardIndex = new LongTextField();
    private IntegerTextField tfPerfStatsThresholdPortIndex = new IntegerTextField();
    private IntegerTextField tfPerfStatsThresholdTypeIndex = new IntegerTextField();

    private LongTextField tfPerfStatsThresholdUpper = new LongTextField();
    private LongTextField tfPerfStatsThresholdLower = new LongTextField();

    private final String perfStatsThresholdDeviceIndex = fStringMap.getString("perfStatsThresholdDeviceIndex") + " : ";
    private final String perfStatsThresholdCardIndex = fStringMap.getString("perfStatsThresholdCardIndex") + " : ";
    private final String perfStatsThresholdPortIndex = fStringMap.getString("perfStatsThresholdPortIndex") + " : ";
    private final String perfStatsThresholdTypeIndex = fStringMap.getString("perfStatsThresholdTypeIndex") + " : ";
    private final String perfStatsThresholdUpper = fStringMap.getString("perfStatsThresholdUpper") + " : ";
    private final String perfStatsThresholdLower = fStringMap.getString("perfStatsThresholdLower") + " : ";

    public PerfStatsThresholdTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(perfStatsThresholdDeviceIndex));
        baseInfoPanel.add(tfPerfStatsThresholdDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStatsThresholdCardIndex));
        baseInfoPanel.add(tfPerfStatsThresholdCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStatsThresholdPortIndex));
        baseInfoPanel.add(tfPerfStatsThresholdPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStatsThresholdTypeIndex));
        baseInfoPanel.add(tfPerfStatsThresholdTypeIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStatsThresholdUpper));
        tfPerfStatsThresholdUpper.setName(fStringMap.getString("perfStatsThresholdUpper"));
        baseInfoPanel.add(tfPerfStatsThresholdUpper);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStatsThresholdLower));
        tfPerfStatsThresholdLower.setName(fStringMap.getString("perfStatsThresholdLower"));
        baseInfoPanel.add(tfPerfStatsThresholdLower);
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
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfPerfStatsThresholdDeviceIndex.setEditable(true);
            tfPerfStatsThresholdCardIndex.setEditable(true);
            tfPerfStatsThresholdPortIndex.setEditable(true);
            tfPerfStatsThresholdTypeIndex.setEditable(true);
            return;
        } else {
            tfPerfStatsThresholdDeviceIndex.setEditable(false);
            tfPerfStatsThresholdCardIndex.setEditable(false);
            tfPerfStatsThresholdPortIndex.setEditable(false);
            tfPerfStatsThresholdTypeIndex.setEditable(false);
        }

        PerfStatsThresholdTable mbean = (PerfStatsThresholdTable) getModel();
        if (mbean == null)
            return;

        tfPerfStatsThresholdDeviceIndex.setValue(mbean.getPerfStatsThresholdDeviceIndex());
        tfPerfStatsThresholdCardIndex.setValue(mbean.getPerfStatsThresholdCardIndex());
        tfPerfStatsThresholdPortIndex.setValue(mbean.getPerfStatsThresholdPortIndex());
        tfPerfStatsThresholdTypeIndex.setValue(mbean.getPerfStatsThresholdTypeIndex());

        tfPerfStatsThresholdUpper.setValue(mbean.getPerfStatsThresholdUpper().intValue());
        tfPerfStatsThresholdLower.setValue(mbean.getPerfStatsThresholdLower().intValue());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new PerfStatsThresholdTable(fApplication.getSnmpProxy()));

        PerfStatsThresholdTable mbean = (PerfStatsThresholdTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setPerfStatsThresholdDeviceIndex(new Long(tfPerfStatsThresholdDeviceIndex.getValue()));
            mbean.setPerfStatsThresholdCardIndex(new Long(tfPerfStatsThresholdCardIndex.getValue()));
            mbean.setPerfStatsThresholdPortIndex(new Integer(tfPerfStatsThresholdPortIndex.getValue()));
            mbean.setPerfStatsThresholdTypeIndex(new Integer(tfPerfStatsThresholdTypeIndex.getValue()));
        }

        mbean.setPerfStatsThresholdUpper(BigInteger.valueOf(tfPerfStatsThresholdUpper.getValue()));
        mbean.setPerfStatsThresholdLower(BigInteger.valueOf(tfPerfStatsThresholdLower.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}