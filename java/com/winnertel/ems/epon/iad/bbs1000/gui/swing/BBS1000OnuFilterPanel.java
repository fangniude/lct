package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class BBS1000OnuFilterPanel extends JPanel implements ActionListener {
    public static final String IS_INITIAL = "epon_dvm_filter_is_initial";
    public static final String LEVEL = "epon_dvm_filter_level";
    public static final String SLOT_LIST = "epon_dvm_filter_slot";
    public static final String PORT_COUNT = "epon_dvm_filter_port";
    public static final String ONU_COUNT = "epon_dvm_filter_onu";

    public static final String SLOT_ID = "OnuFilterPanel.moduleId";
    public static final String PORT_ID = "OnuFilterPanel.portId";
    public static final String ONU_ID = "OnuFilterPanel.onuId";

    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    protected JComboBox cmbModule = new JComboBox();
    protected JComboBox cmbPort = new JComboBox();
    protected JComboBox cmbLogicalPort = new JComboBox();

    protected JButton btnRefresh = null;
    protected BBS1000NE ne = null;

    protected Map fCustomCache;
    protected Vector<BBS1000CardMibBean> fSlotList;
    protected Integer fPortCount;
    protected Integer fOnuCount;

    public BBS1000OnuFilterPanel(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
        ne = new BBS1000NE(fApplication);
        initData();
        init();
    }

    private void initData() {
        fCustomCache = fApplication.getActiveDeviceManager().getCustomCache();

        if (!Boolean.TRUE.equals(fCustomCache.get(IS_INITIAL))) {
            initCache(fApplication);
        }

        fSlotList = (Vector<BBS1000CardMibBean>) fCustomCache.get(SLOT_LIST);
        fPortCount = (Integer) fCustomCache.get(PORT_COUNT);
        fOnuCount = (Integer) fCustomCache.get(ONU_COUNT);
    }

    protected static void initCache(IApplication aApplication) {
        BBS1000CardMibBean bean = new BBS1000CardMibBean(aApplication.getSnmpProxy());
        Vector<BBS1000CardMibBean> slotList = BeanService.refreshTableBean(aApplication, bean);

        Map cache = aApplication.getActiveDeviceManager().getCustomCache();
        cache.put(SLOT_LIST, slotList);

        BBS4000NE ne = new BBS4000NE(aApplication);
        cache.put(PORT_COUNT, ne.getPortCount());
        cache.put(ONU_COUNT, ne.getPonSplitRatio());

        cache.put(IS_INITIAL, Boolean.TRUE);

        cache.put(BBS1000OnuFilterPanel.SLOT_ID, 1);
        cache.put(BBS1000OnuFilterPanel.PORT_ID, 1);
        cache.put(BBS1000OnuFilterPanel.ONU_ID, 1);
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

        //Module
        cmbModule.removeActionListener(this);
        cmbModule.removeAllItems();
        cmbModule.addItem(getString("All"));
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

        //Port
        cmbPort.removeAllItems();
        cmbPort.addItem(getString("All"));
        for (int i = 1; i <= ne.getPortCount(); i++) {
            cmbPort.addItem(getString("Port") + " " + i);
        }

        //Logical Port
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

    public JButton getRefreshButton() {
        if (btnRefresh == null) {
            btnRefresh = new JButton();
            btnRefresh.setText(getString("Refresh"));
        }

        return btnRefresh;
    }

    public void refresh() {
        Integer module = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.SLOT_ID);
        Integer port = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.PORT_ID);
        Integer onu = (Integer) fCustomCache.get(BBS1000OnuFilterPanel.ONU_ID);

        if (cmbModule.getSelectedIndex() == 0) {
            cmbModule.setSelectedIndex(1);
        }

        setSelectedOnu(String.format("%s-%s-%s", module, port, onu));
        if (port == 0) {
            cmbPort.setSelectedIndex(1);
        }
        if (onu == 0) {
            cmbLogicalPort.setSelectedIndex(0);
        }
    }

    public int[] getAllSlotId() {
        int[] result = new int[cmbModule.getItemCount() - 1];

        for (int i = 1; i < cmbModule.getItemCount(); i++) {
            String item = (String) cmbModule.getItemAt(i);
            result[i - 1] = Integer.parseInt(item.split(" ")[1]);
        }

        return result;
    }

    public int getSelectedSlotId() {
        if (cmbModule.getSelectedIndex() != 0 && cmbModule.getSelectedItem() != null) {
            String item = (String) cmbModule.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (cmbPort.getSelectedIndex() != 0 && cmbPort.getSelectedItem() != null) {
            String item = (String) cmbPort.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (cmbLogicalPort.getSelectedIndex() != 0 && cmbLogicalPort.getSelectedItem() != null) {
            String item = (String) cmbLogicalPort.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public void addActionListener(ActionListener l) {
        btnRefresh.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        btnRefresh.removeActionListener(l);
    }

    public void actionPerformed(ActionEvent e) {
        fCustomCache.put(BBS1000OnuFilterPanel.SLOT_ID, getSelectedSlotId());
        fCustomCache.put(BBS1000OnuFilterPanel.PORT_ID, getSelectedPortId());
        fCustomCache.put(BBS1000OnuFilterPanel.ONU_ID, getSelectedOnuId());

        if (cmbModule.getSelectedIndex() == 0) {
            if (cmbPort.getItemCount() > 0) {
                cmbPort.setSelectedIndex(0);
                cmbPort.setEnabled(false);
            }
        } else {
            cmbPort.setEnabled(true);
        }
        if (cmbPort.getSelectedIndex() == 0) {
            if (cmbLogicalPort.getItemCount() > 0) {
                cmbLogicalPort.setSelectedIndex(0);
                cmbLogicalPort.setEnabled(false);
            }
        } else {
            cmbLogicalPort.setEnabled(true);
        }
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
    }

    public void setSelectedOnu(String string) {
        String[] split = string.split("-");

        // 1. set slot
        int itemCount = cmbModule.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbModule.getItemAt(i);
            if (item.startsWith(getString("Slot") + " " + split[0] + " -")) {
                cmbModule.setSelectedIndex(i);
            }
        }

        itemCount = cmbPort.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbPort.getItemAt(i);
            if (item.startsWith(getString("Port") + " " + split[1])) {
                cmbPort.setSelectedIndex(i);
            }
        }

        itemCount = cmbLogicalPort.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbLogicalPort.getItemAt(i);
            if (item.startsWith(getString("ONU") + " " + split[2])) {
                cmbLogicalPort.setSelectedIndex(i);
                return;
            }
        }
    }
}