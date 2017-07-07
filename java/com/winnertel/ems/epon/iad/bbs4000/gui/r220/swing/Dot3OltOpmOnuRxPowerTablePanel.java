/**
 * Created by Zhou Chao, 2010/4/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r220.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3OltOpmOnuRxPowerTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3OltOpmOnuRxPowerTablePanel extends UPanel {

    private JLabel tfUtsDot3OltOpmOnuRxPower = new JLabel();

    private IntegerTextField tfUtsDot3OltOpmOnuRxPowerMinThreshold = new IntegerTextField();
    private IntegerTextField tfUtsDot3OltOpmOnuRxPowerMaxThreshold = new IntegerTextField();

    private final String utsDot3OltOpmOnuRxPower = fStringMap.getString("utsDot3OltOpmOnuRxPower") + " : ";
    private final String utsDot3OltOpmOnuRxPowerMinThreshold = fStringMap.getString("utsDot3OltOpmOnuRxPowerMinThreshold") + " : ";
    private final String utsDot3OltOpmOnuRxPowerMaxThreshold = fStringMap.getString("utsDot3OltOpmOnuRxPowerMaxThreshold") + " : ";

    public Dot3OltOpmOnuRxPowerTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPower));
        baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPower);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerMinThreshold));
        tfUtsDot3OltOpmOnuRxPowerMinThreshold.setName(fStringMap.getString("utsDot3OltOpmOnuRxPowerMinThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMinThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOpmOnuRxPowerMaxThreshold));
        tfUtsDot3OltOpmOnuRxPowerMaxThreshold.setName(fStringMap.getString("utsDot3OltOpmOnuRxPowerMaxThreshold"));
        baseInfoPanel.add(tfUtsDot3OltOpmOnuRxPowerMaxThreshold);
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
        Dot3OltOpmOnuRxPowerTable mbean = (Dot3OltOpmOnuRxPowerTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3OltOpmOnuRxPower.setText(mbean.getUtsDot3OltOpmOnuRxPower().toString());
        tfUtsDot3OltOpmOnuRxPowerMinThreshold.setValue(mbean.getUtsDot3OltOpmOnuRxPowerMinThreshold());
        tfUtsDot3OltOpmOnuRxPowerMaxThreshold.setValue(mbean.getUtsDot3OltOpmOnuRxPowerMaxThreshold());
    }

    public void updateModel() {
        Dot3OltOpmOnuRxPowerTable mbean = (Dot3OltOpmOnuRxPowerTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3OltOpmOnuRxPowerMinThreshold(new Integer(tfUtsDot3OltOpmOnuRxPowerMinThreshold.getValue()));
        mbean.setUtsDot3OltOpmOnuRxPowerMaxThreshold(new Integer(tfUtsDot3OltOpmOnuRxPowerMaxThreshold.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}