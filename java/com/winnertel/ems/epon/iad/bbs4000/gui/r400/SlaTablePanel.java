/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SlaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class SlaTablePanel extends UPanel {

/*
    private JLabel tfSlaIndex = new JLabel();
*/

    private IntegerTextField tfSlaDsFixedBW = new IntegerTextField();
    private IntegerTextField tfSlaDsPeakBW = new IntegerTextField();
    private IntegerTextField tfSlaDsCommittedBW = new IntegerTextField();
    private IntegerTextField tfSlaUsFixedBW = new IntegerTextField();
    private IntegerTextField tfSlaUsPeakBW = new IntegerTextField();
    private IntegerTextField tfSlaUsCommittedBW = new IntegerTextField();

/*
    private final String slaIndex = fStringMap.getString("slaIndex") + " : ";
*/
    private final String slaDsFixedBW = fStringMap.getString("slaDsFixedBW") + " : ";
    private final String slaDsPeakBW = fStringMap.getString("slaDsPeakBW") + " : ";
    private final String slaDsCommittedBW = fStringMap.getString("slaDsCommittedBW") + " : ";
    private final String slaUsFixedBW = fStringMap.getString("slaUsFixedBW") + " : ";
    private final String slaUsPeakBW = fStringMap.getString("slaUsPeakBW") + " : ";
    private final String slaUsCommittedBW = fStringMap.getString("slaUsCommittedBW") + " : ";

    public SlaTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(slaIndex));
        baseInfoPanel.add(tfSlaIndex);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(slaDsFixedBW));
        tfSlaDsFixedBW.setName(fStringMap.getString("slaDsFixedBW"));
        baseInfoPanel.add(tfSlaDsFixedBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(slaDsPeakBW));
        tfSlaDsPeakBW.setName(fStringMap.getString("slaDsPeakBW"));
        baseInfoPanel.add(tfSlaDsPeakBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(slaDsCommittedBW));
        tfSlaDsCommittedBW.setName(fStringMap.getString("slaDsCommittedBW"));
        baseInfoPanel.add(tfSlaDsCommittedBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(slaUsFixedBW));
        tfSlaUsFixedBW.setName(fStringMap.getString("slaUsFixedBW"));
        baseInfoPanel.add(tfSlaUsFixedBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(slaUsPeakBW));
        tfSlaUsPeakBW.setName(fStringMap.getString("slaUsPeakBW"));
        baseInfoPanel.add(tfSlaUsPeakBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(slaUsCommittedBW));
        tfSlaUsCommittedBW.setName(fStringMap.getString("slaUsCommittedBW"));
        baseInfoPanel.add(tfSlaUsCommittedBW);
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
        SlaTable mbean = (SlaTable) getModel();
        if (mbean == null)
            return;

/*
        tfSlaIndex.setText(mbean.getSlaIndex() != null ? mbean.getSlaIndex().toString() : "");
*/
        tfSlaDsFixedBW.setValue(mbean.getSlaDsFixedBW());
        tfSlaDsPeakBW.setValue(mbean.getSlaDsPeakBW());
        tfSlaDsCommittedBW.setValue(mbean.getSlaDsCommittedBW());
        tfSlaUsFixedBW.setValue(mbean.getSlaUsFixedBW());
        tfSlaUsPeakBW.setValue(mbean.getSlaUsPeakBW());
        tfSlaUsCommittedBW.setValue(mbean.getSlaUsCommittedBW());

    }

    public void updateModel() {
        SlaTable mbean = (SlaTable) getModel();
        if (mbean == null)
            return;

        mbean.setSlaDsFixedBW(new Integer(tfSlaDsFixedBW.getValue()));
        mbean.setSlaDsPeakBW(new Integer(tfSlaDsPeakBW.getValue()));
        mbean.setSlaDsCommittedBW(new Integer(tfSlaDsCommittedBW.getValue()));
        mbean.setSlaUsFixedBW(new Integer(tfSlaUsFixedBW.getValue()));
        mbean.setSlaUsPeakBW(new Integer(tfSlaUsPeakBW.getValue()));
        mbean.setSlaUsCommittedBW(new Integer(tfSlaUsCommittedBW.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}