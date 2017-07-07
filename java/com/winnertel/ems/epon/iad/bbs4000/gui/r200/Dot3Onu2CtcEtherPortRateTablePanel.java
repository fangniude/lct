/**
 * Modified by Zhou Chao
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcEtherPortRateTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Dot3Onu2CtcEtherPortRateTablePanel extends UPanel {

    private JLabel tfUtsDot3OnuModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuDeviceId = new JLabel();
    private JLabel tfUtsDot3OnuPortId = new JLabel();
    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

    private int[] utsDot3OnuEtherPortPauseVList = new int[]{1, 2,};
    private String[] utsDot3OnuEtherPortPauseTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3OnuEtherPortPause = new JComboBox(utsDot3OnuEtherPortPauseTList);

    private int[] utsDot3OnuEtherPortPolicingEnableVList = new int[]{2, 1,};
    private String[] utsDot3OnuEtherPortPolicingEnableTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3OnuEtherPortPolicingEnable = new JComboBox(utsDot3OnuEtherPortPolicingEnableTList);

    private JComboBox tfUtsDot3OnuEtherPortPolicingCIR = null;
    private JComboBox tfUtsDot3OnuEtherPortPolicingCBS = null;

    private IntegerTextField tfUtsDot3OnuEtherPortPolicingEBS = new IntegerTextField();

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + ": ";
    //private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + ": ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + ": ";
    private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + ": ";
    private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + ": ";
    private final String utsDot3OnuEtherPortPause = fStringMap.getString("utsDot3OnuEtherPortPause") + ": ";
    private final String utsDot3OnuEtherPortPolicingEnable = fStringMap.getString("utsDot3OnuEtherPortPolicingEnable") + ": ";
    private final String utsDot3OnuEtherPortPolicingCIR = fStringMap.getString("utsDot3OnuEtherPortPolicingCIR") + ": ";
    private final String utsDot3OnuEtherPortPolicingCBS = fStringMap.getString("utsDot3OnuEtherPortPolicingCBS") + ": ";
    private final String utsDot3OnuEtherPortPolicingEBS = fStringMap.getString("utsDot3OnuEtherPortPolicingEBS") + ": ";

    private BBS4000NE bbs4000NE;

    public Dot3Onu2CtcEtherPortRateTablePanel(IApplication app) {
        super(app);
        bbs4000NE = new BBS4000NE(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
        baseInfoPanel.add(tfUtsDot3OnuModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
        //baseInfoPanel.add(tfUtsDot3OnuDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
        baseInfoPanel.add(tfUtsDot3OnuPortId);
        baseInfoPanel.add(new HSpacer());

        //tfUtsDot3OnuLogicalPortId.setModel(new DefaultComboBoxModel(getLogicalPortList()));
        baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPause));
        tfUtsDot3OnuEtherPortPause.setName(fStringMap.getString("utsDot3OnuEtherPortPause"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPause);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEnable));
        tfUtsDot3OnuEtherPortPolicingEnable.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEnable"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEnable);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3OnuEtherPortPolicingEnable.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemevent) {
                toggleEnableDisable();
            }
        });

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCIR));
        Vector tmpVec = new Vector(127);
        for (int i = 1000; i <= 127000; i += 1000) {
            tmpVec.add(new Integer(i));
        }
        tfUtsDot3OnuEtherPortPolicingCIR = new JComboBox(tmpVec);
        tfUtsDot3OnuEtherPortPolicingCIR.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCIR"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCIR);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCBS));
        tmpVec = new Vector();
        for (int i = 0; i <= 65280; i += 256) {
            tmpVec.add(new Integer(i));
        }
        tfUtsDot3OnuEtherPortPolicingCBS = new JComboBox(tmpVec);
        tfUtsDot3OnuEtherPortPolicingCBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCBS"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEBS));
        tfUtsDot3OnuEtherPortPolicingEBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEBS"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEBS);
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
        tfUtsDot3OnuEtherPortPolicingEBS.setValueScope(0, 512);
    }

    public boolean validateFrom() {
        return true;
    }

    public void toggleEnableDisable() {
        if (tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex() == 0) {
            tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(false);
            tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(false);
            tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(false);
        } else {
            tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(true);
            tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(true);
            tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(true);
        }
    }

    public void refresh() {
        Dot3Onu2CtcEtherPortRateTable mbean = (Dot3Onu2CtcEtherPortRateTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        //tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
        tfUtsDot3OnuPortId.setText("" + mbean.getUtsDot3OnuPortId());
        //tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
        tfUtsDot3OnuLogicalPortId.setText("" + mbean.getUtsDot3OnuLogicalPortId());
        tfUtsDot3OnuEtherPortIndex.setText("" + mbean.getUtsDot3OnuEtherPortIndex());
        tfUtsDot3OnuEtherPortPause.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPauseVList, mbean.getUtsDot3OnuEtherPortPause()));
        tfUtsDot3OnuEtherPortPolicingEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPolicingEnableVList, mbean.getUtsDot3OnuEtherPortPolicingEnable()));

        int tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCIR() / 1000 - 1;
        tfUtsDot3OnuEtherPortPolicingCIR.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);

        tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCBS() / 256; //modified by Zhou Chao
        tfUtsDot3OnuEtherPortPolicingCBS.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);

        tfUtsDot3OnuEtherPortPolicingEBS.setValue(mbean.getUtsDot3OnuEtherPortPolicingEBS());

        toggleEnableDisable();
    }

    public void updateModel() {
        Dot3Onu2CtcEtherPortRateTable mbean = (Dot3Onu2CtcEtherPortRateTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3OnuEtherPortPause(utsDot3OnuEtherPortPauseVList[tfUtsDot3OnuEtherPortPause.getSelectedIndex()]);
        mbean.setUtsDot3OnuEtherPortPolicingEnable(utsDot3OnuEtherPortPolicingEnableVList[tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex()]);
        mbean.setUtsDot3OnuEtherPortPolicingCIR((Integer) tfUtsDot3OnuEtherPortPolicingCIR.getSelectedItem());
        mbean.setUtsDot3OnuEtherPortPolicingCBS((Integer) tfUtsDot3OnuEtherPortPolicingCBS.getSelectedItem());
        mbean.setUtsDot3OnuEtherPortPolicingEBS(tfUtsDot3OnuEtherPortPolicingEBS.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}