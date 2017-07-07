package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnLineSlotFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.IntfRateControlTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SNTPGroupMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GponIntfRateControlTablePanel extends UPanel implements ActionListener {

    private OnLineSlotFilterPanel modulePanel = null;

    private SnmpTablePane snmpPanel;

    public GponIntfRateControlTablePanel(IApplication app) {
        super(app);
        setModel(new SNTPGroupMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        modulePanel = new OnLineSlotFilterPanel(fApplication);
        modulePanel.addActionListener(this);

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        snmpPanel = (SnmpTablePane) composer1.composeSnmpTablePane("IntfRateControlTable_Panel");

        setLayout(new BorderLayout());
        add(modulePanel, BorderLayout.NORTH);
        add(snmpPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        modulePanel.refresh();
        //force the table pane refresh the data.
        actionPerformed(null);
//    qosTablePanel.refresh();
    }

    public void updateModel() {
    }

    public void actionPerformed(ActionEvent e) {
        IntfRateControlTable bean = (IntfRateControlTable) snmpPanel.getModel();
        if (modulePanel.getSelectedSlotId() == 0) {//select all
            bean.setIndex(0, "0");
            bean.setIndex(1, "4");

            bean.setRowsToFetch(0); //set 0 to disable this attribute.
        } else {
            bean.setIndex(0, "" + (modulePanel.getSelectedSlotId() - 1));
            bean.setIndex(1, "4");

            bean.setRowsToFetch(4);
        }

        snmpPanel.refresh();
    }

}