/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class SniTrunkGroupManagementPanel extends UPanel {

    SnmpTablePane tablepanel1;
    SnmpTablePane tablepanel2;

    public SniTrunkGroupManagementPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel allPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        allPanel.setLayout(layout);

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("SniTrunkConfigTable");
        tablepanel1.setPreferredSize(new Dimension(100, 200));
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("SniTrunkConfigTable")));

        IGuiComposer composer2 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel2 = (SnmpTablePane) composer2.composeSnmpTablePane("SniTrunkTable");
        tablepanel2.setPreferredSize(new Dimension(100, 200));
        tablepanel2.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("SniTrunkTable")));
        allPanel.add(tablepanel1);
        allPanel.add(new VSpacer());
        allPanel.add(tablepanel2);
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);

        tablepanel1.refresh();
        tablepanel2.refresh();

        this.setPreferredSize(new Dimension(100, 200));
    }

    protected void initForm() {
    }

    public void refresh() {
    }

    public void updateModel() {
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}