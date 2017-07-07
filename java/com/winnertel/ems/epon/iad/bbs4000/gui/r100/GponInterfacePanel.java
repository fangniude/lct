package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.SNTPGroupMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GponInterfacePanel extends UPanel implements ActionListener {

    private JComboBox moduleList = new JComboBox();

    private SnmpTablePane qosTablePanel;

    public GponInterfacePanel(IApplication app) {
        super(app);
        setModel(new SNTPGroupMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel filterPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 2, NTLayout.LEFT, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        filterPanel.setLayout(layout);
        filterPanel.setBorder(BorderFactory.createTitledBorder("filter"));
        filterPanel.add(moduleList);
        filterPanel.add(new HSpacer());

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        qosTablePanel = (SnmpTablePane) composer1.composeSnmpTablePane("Interface_table");

        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.NORTH);
        add(qosTablePanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        moduleList.removeActionListener(this);
        moduleList.removeAllItems();

        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);

        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);

            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem("Slot " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem("Slot " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }
        }

        if (moduleList.getItemCount() > 0)
            moduleList.setSelectedIndex(0);

        moduleList.addActionListener(this);

        //force the table pane refresh the data.
        actionPerformed(null);
//    qosTablePanel.refresh();
    }

    public void updateModel() {
    }

    public void actionPerformed(ActionEvent e) {
        InterfaceTableMBean bean = (InterfaceTableMBean) qosTablePanel.getModel();
        if (moduleList.getSelectedIndex() != -1) {
            String item = (String) moduleList.getSelectedItem();
            int ifIndex = ConfigUtility.generateIfIndex(item.split(" ")[1] + "/1");

            bean.setIndex(0, ifIndex);
            bean.setRowsToFetch(4);
            bean.setIfDescr(item.split(" ")[3]);
            qosTablePanel.refresh();
        }
    }

}