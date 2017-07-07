package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;

public class BBS1000OnuNoAllFilterPanel extends BBS1000OnuFilterPanel {
	private static final long serialVersionUID = 7174562029759904572L;

	public BBS1000OnuNoAllFilterPanel(IApplication app) {
		super(app);
	}

	protected void init() {
		NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
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

        //Module
        cmbModule.removeActionListener(this);
        cmbModule.removeAllItems();
        ModuleType fModuleType = new ModuleType();
        if (fSlotList != null) {
            for (int i = 0; i < fSlotList.size(); i++) {
                BBS1000CardMibBean card = fSlotList.get(i);
                if (card != null) {
                    if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - LTM");
                    }
                }
            }
        }

        cmbModule.addActionListener(this);

		// Port
		cmbPort.removeAllItems();
		//cmbPort.addItem(getString("All"));
		for (int i = 1; i <= ne.getPortCount(); i++) {
			cmbPort.addItem(getString("Port") + " " + i);
		}

		// Logical Port
		cmbLogicalPort.removeAllItems();
		cmbLogicalPort.addItem(getString("All"));
		int count = ne.getPonSplitRatio();
		for (int i = 1; i <= count; i++) {
			cmbLogicalPort.addItem(getString("ONU") + " " + i);
		}

		cmbModule.addActionListener(this);
		cmbPort.addActionListener(this);
		cmbLogicalPort.addActionListener(this);
	}

	public void refresh() {
        Integer module = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.SLOT_ID);
        Integer port = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.PORT_ID);
        Integer onu = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.ONU_ID);

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

    public int[] getAllSlotId() {
        int[] result = new int[cmbModule.getItemCount()];

        for (int i = 0; i < cmbModule.getItemCount(); i++) {
            String item = (String) cmbModule.getItemAt(i);
            result[i] = Integer.parseInt(item.split(" ")[1]);
        }

        return result;
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
    
    public void actionPerformed(ActionEvent e) {
        fCustomCache.put(BBS1000OnuFilterPanel.SLOT_ID, getSelectedSlotId());
        fCustomCache.put(BBS1000OnuFilterPanel.PORT_ID, getSelectedPortId());
        fCustomCache.put(BBS1000OnuFilterPanel.ONU_ID, getSelectedOnuId());

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
}
