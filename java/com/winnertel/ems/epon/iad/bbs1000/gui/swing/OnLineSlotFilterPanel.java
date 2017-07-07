package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.SystemInfoMBean;

import javax.swing.*;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OnLineSlotFilterPanel extends JPanel implements ActionListener{

    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    protected Vector lsnrList = new Vector();
    private JComboBox moduleList = new JComboBox();

    public OnLineSlotFilterPanel(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
        init();
    }

    private void init() {
        NTLayout layout = new NTLayout(1, 2, NTLayout.LEFT, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createTitledBorder(getString("Filter")));

        add(moduleList);
        add(new HSpacer());
        moduleList.addActionListener(this);
    }

    public void refresh() {
        //remove all the listeners.
        for (int i = 0; i < lsnrList.size(); i++) {
            moduleList.removeActionListener((ActionListener) lsnrList.get(i));
        }
        moduleList.removeActionListener(this);

        moduleList.removeAllItems();
        moduleList.addItem(getString("All"));
        ModuleType fModuleType = new ModuleType();
        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS1000CardMibBean card = (BBS1000CardMibBean) list.get(i);
            if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
            	SystemInfoMBean sysBean = new SystemInfoMBean(fApplication.getSnmpProxy());
            	try {
            		sysBean.retrieve();
					if (!sysBean.getSysObjectID().equals("FBW2000")) {
						moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - LTM");
					}
				} catch (MibBeanException e) {
					e.printStackTrace();
				}
            } else if (fModuleType.isGSMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GSM");
            }
        }

        Object module = fApplication.getActiveDeviceManager().getProperties().getProperty("OnLineSlotFilterPanel.moduleId");
        if(module != null)
          moduleList.setSelectedItem(module);
        else if (moduleList.getItemCount() > 1)
            moduleList.setSelectedIndex(1); //select 2nd item.


        //add all the listeners.
        for (int i = 0; i < lsnrList.size(); i++) {
            moduleList.addActionListener((ActionListener) lsnrList.get(i));
        }
        moduleList.addActionListener(this);
    }

    /**
     * return the selected slot id. 0 means all the slot.
     *
     * @return
     */
    public int getSelectedSlotId() {
        if (moduleList.getSelectedIndex() == 0) {
            return 0;
        } else {
            String item = (String) moduleList.getSelectedItem();
            return Integer.parseInt(item.split(" ")[1]);
        }
    }

    public void addActionListener(ActionListener l) {
        if (!lsnrList.contains(l)) {
            lsnrList.add(l);
            moduleList.addActionListener(l);
        }
    }

    public void removeActionListener(ActionListener l) {
        lsnrList.remove(l);
        moduleList.removeActionListener(l);
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
    }

  public void actionPerformed(ActionEvent e) {
    fApplication.getActiveDeviceManager().getProperties().setProperty("OnLineSlotFilterPanel.moduleId", (String)moduleList.getSelectedItem());
  }
}