package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class OnLineLTMSlotFilterPanel extends JPanel implements ActionListener {

    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    protected Vector lsnrList = new Vector();
    private JComboBox moduleList = new JComboBox();

    private Map fCustomCache;
    private Vector<BBS1000CardMibBean> fSlotList;

    public OnLineLTMSlotFilterPanel(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
        initData();
        init();
    }

    private void initData() {
        fCustomCache = fApplication.getActiveDeviceManager().getCustomCache();

        if (!Boolean.TRUE.equals(fCustomCache.get(BBS1000OnuFilterPanel.IS_INITIAL))) {
            BBS1000OnuFilterPanel.initCache(fApplication);
        }

        fSlotList = (Vector<BBS1000CardMibBean>) fCustomCache.get(BBS1000OnuFilterPanel.SLOT_LIST);
    }

    private void init() {
        NTLayout layout = new NTLayout(1, 2, NTLayout.LEFT, NTLayout.FILL, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createTitledBorder(getString("Filter")));

        addModule();
        add(moduleList);
        add(new HSpacer());
    }

    private void addModule() {
        //remove all the listeners.
        for (int i = 0; i < lsnrList.size(); i++) {
            moduleList.removeActionListener((ActionListener) lsnrList.get(i));
        }
        //Module
        moduleList.removeActionListener(this);
        moduleList.removeAllItems();
        moduleList.addItem(getString("All"));
        ModuleType fModuleType = new ModuleType();
        if (fSlotList != null) {
            for (int i = 0; i < fSlotList.size(); i++) {
                BBS1000CardMibBean card = fSlotList.get(i);
                if (card != null) {
                    if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                        moduleList.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - LTM");
                    }
                }
            }
        }

        moduleList.addActionListener(this);
    }

    public void refresh() {
        Integer module = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.SLOT_ID);

        int itemCount = moduleList.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) moduleList.getItemAt(i);
            if (item.startsWith(getString("Slot") + " " + module + " -")) {
                moduleList.setSelectedIndex(i);
                return;
            }
        }

        if (moduleList.getItemCount() > 1) {
            moduleList.setSelectedIndex(1); //select 2nd item.
        }
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

    /**
     * return the all the slot.
     *
     * @return
     */
    public int[] getAllSlotId() {
        int[] result = new int[moduleList.getItemCount() - 1];

        for (int i = 1; i < moduleList.getItemCount(); i++) {
            String item = (String) moduleList.getSelectedItem();
            result[i - 1] = Integer.parseInt(item.split(" ")[1]);
        }

        return result;
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
        fCustomCache.put(BBS1000OnuFilterPanel.SLOT_ID, getSelectedSlotId());
    }
}