package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuSwitchTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Dot3OnuSwitchTablePanel extends UPanel {

    private JComboBox tfUtsDot3OnuSwitchModuleId = new JComboBox();

    private int[] utsDot3OnuSwitchPortVList = new int[]{
            1, 2, 3, 4, };
    private String[] utsDot3OnuSwitchPortTList = new String[]{
            "1", "2", "3", "4",
    };
    
    private JComboBox tfUtsDot3OnuSwitchPortId = new JComboBox(utsDot3OnuSwitchPortTList);

    private JComboBox tfUtsDot3OnuSwitchLlid = new JComboBox();

    private IPAddressField tfUtsDot3OnuSwitchIpAddress = new IPAddressField();

    private IntegerTextField tfUtsDot3OnuSwitchMngVlan = new IntegerTextField();

    private final String utsDot3OnuSwitchModuleId = fStringMap.getString("utsDot3OnuSwitchModuleId") + " : ";
    private final String utsDot3OnuSwitchPortId = fStringMap.getString("utsDot3OnuSwitchPortId") + " : ";
    private final String utsDot3OnuSwitchLlid = fStringMap.getString("utsDot3OnuSwitchLlid") + " : ";
    private final String utsDot3OnuSwitchIpAddress = fStringMap.getString("utsDot3OnuSwitchIpAddress") + " : ";
    private final String utsDot3OnuSwitchMngVlan = fStringMap.getString("utsDot3OnuSwitchMngVlan") + " : ";


    public Dot3OnuSwitchTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuSwitchModuleId));
        baseInfoPanel.add(tfUtsDot3OnuSwitchModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuSwitchPortId));
        baseInfoPanel.add(tfUtsDot3OnuSwitchPortId);
        baseInfoPanel.add(new HSpacer());

        for (int i = 1; i <= 64; i++)
            tfUtsDot3OnuSwitchLlid.addItem("" + i);

        baseInfoPanel.add(new JLabel(utsDot3OnuSwitchLlid));
        baseInfoPanel.add(tfUtsDot3OnuSwitchLlid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuSwitchIpAddress));
        baseInfoPanel.add(tfUtsDot3OnuSwitchIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuSwitchMngVlan));
        baseInfoPanel.add(tfUtsDot3OnuSwitchMngVlan);
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
        tfUtsDot3OnuSwitchMngVlan.setValueScope(1, 4094);
    }

    public void refresh() {
    	tfUtsDot3OnuSwitchModuleId.removeAllItems();
        String neType = fApplication.getActiveDeviceManager().getType();
        if (neType.equals("FBW3000") || neType.equals("FBW2000")) {
            ModuleType fModuleType = new ModuleType();
            BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
            Vector list = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < list.size(); i++) {
                BBS1000CardMibBean card = (BBS1000CardMibBean) list.get(i);
                if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                    tfUtsDot3OnuSwitchModuleId.addItem(card.getUtsEponModuleBoardPhyId());
                }
            }
        } else {
            ModuleType fModuleType = new ModuleType();
            BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
            Vector list = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < list.size(); i++) {
                BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
                if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                    tfUtsDot3OnuSwitchModuleId.addItem(card.getUtsEponModuleBoardPhyId());
                }
            }
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            
            
            return;
        }
        
        Dot3OnuSwitchTable mbean = (Dot3OnuSwitchTable) getModel();
        tfUtsDot3OnuSwitchModuleId.setSelectedItem(mbean.getUtsDot3OnuSwitchModuleId());
        tfUtsDot3OnuSwitchModuleId.setEnabled(false);
        tfUtsDot3OnuSwitchPortId.setSelectedIndex(getIndexFromValue(utsDot3OnuSwitchPortVList, mbean.getUtsDot3OnuSwitchPortId().intValue()));
        tfUtsDot3OnuSwitchPortId.setEnabled(false);
        tfUtsDot3OnuSwitchLlid.setSelectedItem("" + mbean.getUtsDot3OnuSwitchLlid());
        tfUtsDot3OnuSwitchLlid.setEnabled(false);
        tfUtsDot3OnuSwitchIpAddress.setValue(mbean.getUtsDot3OnuSwitchIpAddress());
        tfUtsDot3OnuSwitchMngVlan.setValue(mbean.getUtsDot3OnuSwitchMngVlan());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new Dot3OnuSwitchTable(fApplication.getSnmpProxy()));
        }

        Dot3OnuSwitchTable mbean = (Dot3OnuSwitchTable) getModel();
        mbean.setUtsDot3OnuSwitchModuleId(new Integer(tfUtsDot3OnuSwitchModuleId.getSelectedItem().toString()));
        mbean.setUtsDot3OnuSwitchPortId(new Integer((String) tfUtsDot3OnuSwitchPortId.getSelectedItem()));
        mbean.setUtsDot3OnuSwitchLlid(new Integer((String) tfUtsDot3OnuSwitchLlid.getSelectedItem()));
        mbean.setUtsDot3OnuSwitchIpAddress(tfUtsDot3OnuSwitchIpAddress.getIPString());
        mbean.setUtsDot3OnuSwitchMngVlan(new Integer(tfUtsDot3OnuSwitchMngVlan.getValue()));
    }


    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }
}
