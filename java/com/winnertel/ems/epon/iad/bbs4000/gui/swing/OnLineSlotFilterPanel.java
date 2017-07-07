package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class OnLineSlotFilterPanel extends JPanel implements ActionListener {

    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    protected Vector lsnrList = new Vector();
    private JComboBox moduleList = new JComboBox();


    private Map fCustomCache;
    private Vector<BBS4000CardMibBean> fSlotList;

    public OnLineSlotFilterPanel(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
        initData();
        init();
    }

    private void initData() {
        fCustomCache = fApplication.getActiveDeviceManager().getCustomCache();

        if (!Boolean.TRUE.equals(fCustomCache.get(OnuFilterPanel.IS_INITIAL))) {
            OnuFilterPanel.initCache(fApplication);
        }

        fSlotList = (Vector<BBS4000CardMibBean>) fCustomCache.get(OnuFilterPanel.SLOT_LIST);
    }


    private void init() {
        NTLayout layout = new NTLayout(1, 2, NTLayout.LEFT, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createTitledBorder(getString("Filter")));

        addModule();

        add(moduleList);
        add(new HSpacer());
        moduleList.addActionListener(this);
    }

    private void addModule() {
        //remove all the listeners.
        for (int i = 0; i < lsnrList.size(); i++) {
            moduleList.removeActionListener((ActionListener) lsnrList.get(i));
        }
        moduleList.removeActionListener(this);

        moduleList.removeAllItems();
        if (hasAllOption) {
            moduleList.addItem(getString("All"));
        }
        BaseModuleType fModuleType = new ModuleType();

        for (int i = 0; i < fSlotList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
//            } else if (fModuleType.isEPM04BModule(card.getUtsEponModuleBoardType())) {
//                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM04B");
            } else if (fModuleType.isXGMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - XGM");
            } else if (fModuleType.isOSMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - OSM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            }
        }


        //add all the listeners.
        for (int i = 0; i < lsnrList.size(); i++) {
            moduleList.addActionListener((ActionListener) lsnrList.get(i));
        }
        moduleList.addActionListener(this);
    }

    public void refresh() {


        Integer module = (Integer) fCustomCache.get(OnuFilterPanel.SLOT_ID);

        int itemCount = moduleList.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) moduleList.getItemAt(i);
            if (item.startsWith(getString("Slot") + " " + module + " -")) {
                moduleList.setSelectedIndex(i);
                return;
            }
        }

        if (hasAllOption) {
            if (moduleList.getItemCount() > 1) {
                moduleList.setSelectedIndex(1); //select 2nd item.
            }
        } else {
            if (moduleList.getItemCount() > 0) {
                moduleList.setSelectedIndex(0); //select 2nd item.
            }
        }

        //        Object module = fApplication.getActiveDeviceManager().getProperties().getProperty("OnLineSlotFilterPanel.moduleId");
        //        int oldModule = OnuFilterPanel.getOldSelectedIndex(moduleList, module);
        //        if (oldModule > 0) {
        //            moduleList.setSelectedItem(module);
        //        } else if (hasAllOption) {
        //            if (moduleList.getItemCount() > 1) {
        //                moduleList.setSelectedIndex(1); //select 2nd item.
        //            }
        //        } else {
        //            if (moduleList.getItemCount() > 0) {
        //                moduleList.setSelectedIndex(0); //select 2nd item.
        //            }
        //        }


    }

    /**
     * return the selected slot id. 0 means all the slot.
     *
     * @return
     */
    public int getSelectedSlotId() {
        if (moduleList.getSelectedIndex() == 0) {
            if (hasAllOption) {
                return 0;
            } else {
                String item = (String) moduleList.getSelectedItem();
                return Integer.parseInt(item.split(" ")[1]);
            }
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
        fCustomCache.put(OnuFilterPanel.SLOT_ID, getSelectedSlotId());
    }

    /**
     * Added by Rex to have the component has 'All' option.
     *
     * @return
     */
    public boolean hasAllOption() {
        return hasAllOption;
    }

    public void setAllOption(boolean hasAll) {
        hasAllOption = hasAll;
    }

    private boolean hasAllOption = true;
}