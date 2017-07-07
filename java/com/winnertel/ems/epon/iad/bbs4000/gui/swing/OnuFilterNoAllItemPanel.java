/**
 * Created by Zhou Chao, 2008/9/30 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnuFilterNoAllItemPanel extends OnuFilterPanel implements ActionListener {

    public OnuFilterNoAllItemPanel(IApplication app) {
        super(app);
    }

    protected void init() {
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createTitledBorder(getString("Filter")));

        JPanel conditionPanel = new JPanel(new FlowLayout());
        conditionPanel.add(new Label(getString("Module ID") + ": "));
        conditionPanel.add(cmbModule);
        conditionPanel.add(new Label(getString("Port ID") + ": "));
        conditionPanel.add(cmbPort);
        conditionPanel.add(new Label(getString("Logical Port ID") + ": "));
        conditionPanel.add(cmbLogicalPort);

        add(conditionPanel, null);
        add(new HSpacer());
        add(getRefreshButton(), null);

        cmbModule.removeActionListener(this);
        cmbModule.removeAllItems();


        BaseModuleType fModuleType = new ModuleType();
        //        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        //        if (bean != null) {
        //            Vector list = BeanService.refreshTableBean(fApplication, bean);
        if (fSlotList != null) {
            for (int i = 0; i < fSlotList.size(); i++) {
                BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
                if (card != null) {
                    if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
                    } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
                    }
                    //else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                    //   cmbModule.addItem(getString("Slot") + " " +
                    //   card.getUtsEponModuleBoardPhyId() + " - GEM");
                    //}
                }
            }
        }
        cmbModule.addActionListener(this);

        // Port
        cmbPort.removeAllItems();
        //  cmbPort.addItem(getString("All"));
        for (int i = 1; i <= fPortCount; i++) {
            cmbPort.addItem(getString("Port") + " " + i);
        }

        // Logical Port
        cmbLogicalPort.removeAllItems();
        cmbLogicalPort.addItem(getString("All"));
        for (int i = 1; i <= fOnuCount; i++) {
            cmbLogicalPort.addItem(getString("ONU") + " " + i);
        }

        cmbModule.addActionListener(this);
        cmbPort.addActionListener(this);
        cmbLogicalPort.addActionListener(this);
    }

    public void refresh() {
        Integer module = (Integer) fCustomCache.get(OnuFilterPanel.SLOT_ID);
        Integer port = (Integer) fCustomCache.get(OnuFilterPanel.PORT_ID);
        Integer onu = (Integer) fCustomCache.get(OnuFilterPanel.ONU_ID);

        if (cmbModule.getSelectedIndex() == 0) {
            cmbModule.setSelectedIndex(0);
        }

        setSelectedOnu(String.format("%s-%s-%s", module < 1 ? 1 : module, port < 1 ? 1 : port, onu < 1 ? 1 : onu));
        if (port == 0) {
            cmbPort.setSelectedIndex(0);
        }
        if (onu == 0) {
            cmbLogicalPort.setSelectedIndex(1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        fCustomCache.put(OnuFilterPanel.SLOT_ID, getSelectedSlotId());
        fCustomCache.put(OnuFilterPanel.PORT_ID, getSelectedPortId());
        fCustomCache.put(OnuFilterPanel.ONU_ID, getSelectedOnuId());

        if (cmbPort.getItemCount() == 0) {
            cmbPort.setEnabled(false);
        } else {
            cmbPort.setEnabled(true);
        }

        if (cmbLogicalPort.getItemCount() == 0) {
            cmbLogicalPort.setEnabled(false);
        } else {
            cmbLogicalPort.setEnabled(true);
        }
    }

    public int getSelectedSlotId() {
        if (cmbModule.getSelectedItem() != null) {
            String item = (String) cmbModule.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }
        return 0;
    }

    public int getSelectedPortId() {
        if (cmbPort.getSelectedItem() != null) {
            String item = (String) cmbPort.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }
        return 0;
    }
}