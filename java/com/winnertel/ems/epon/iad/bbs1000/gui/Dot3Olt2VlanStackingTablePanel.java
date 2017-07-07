package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2VlanStackingTable;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Dot3Olt2VlanStackingTablePanel extends UPanel {

    private JComboBox tfUtsDot3OltVlanStackingModuleId = new JComboBox();
    //private JComboBox tfUtsDot3OltVlanStackingDeviceId = new JComboBox();
    private JComboBox tfUtsDot3OltVlanStackingPortId = new JComboBox();
    private JComboBox tfUtsDot3Olt2VlanStackingLogicalPortId = new JComboBox();

    private IntegerTextField tfUtsDot3Olt2VlanStackingCVlanId = new IntegerTextField();
    private IntegerTextField tfUtsDot3Olt2VlanStackingSVlanId = new IntegerTextField();

    private int[] utsDot3Olt2VlanStackingPriModeVList = new int[]{1, 2,};
    private String[] utsDot3Olt2VlanStackingPriModeTList = new String[]{
            fStringMap.getString("copy"),
            fStringMap.getString("zero"),
    };
    private JComboBox tfUtsDot3Olt2VlanStackingPriMode = new JComboBox(utsDot3Olt2VlanStackingPriModeTList);

    private JComboBox tfUtsDot3Olt2VlanStackingSVlanPri = new JComboBox();

    private final String utsDot3OltVlanStackingModuleId = fStringMap.getString("utsDot3OltVlanStackingModuleId") + ": ";
    //private final String utsDot3OltVlanStackingDeviceId = fStringMap.getString("utsDot3OltVlanStackingDeviceId") + ": ";
    private final String utsDot3OltVlanStackingPortId = fStringMap.getString("utsDot3OltVlanStackingPortId") + ": ";
    private final String utsDot3Olt2VlanStackingLogicalPortId = fStringMap.getString("utsDot3Olt2VlanStackingLogicalPortId") + ": ";
    private final String utsDot3Olt2VlanStackingCVlanId = fStringMap.getString("utsDot3Olt2VlanStackingCVlanId") + ": ";
    private final String utsDot3Olt2VlanStackingSVlanId = fStringMap.getString("utsDot3Olt2VlanStackingSVlanId") + ": ";
    private final String utsDot3Olt2VlanStackingPriMode = fStringMap.getString("utsDot3Olt2VlanStackingPriMode") + ": ";
    private final String utsDot3Olt2VlanStackingSVlanPri = fStringMap.getString("utsDot3Olt2VlanStackingSVlanPri") + ": ";

    public Dot3Olt2VlanStackingTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OltVlanStackingModuleId));
        baseInfoPanel.add(tfUtsDot3OltVlanStackingModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltVlanStackingDeviceId));
        //baseInfoPanel.add(tfUtsDot3OltVlanStackingDeviceId);
        //baseInfoPanel.add(new HSpacer());

        BBS1000NE ne = new BBS1000NE(fApplication);
        for (int i = 0; i < ne.getPortCount(); i++) {
            tfUtsDot3OltVlanStackingPortId.addItem(i + 1);
        }
        baseInfoPanel.add(new JLabel(utsDot3OltVlanStackingPortId));
        baseInfoPanel.add(tfUtsDot3OltVlanStackingPortId);
        baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < ne.getPonSplitRatio(); i++) {
            tfUtsDot3Olt2VlanStackingLogicalPortId.addItem(i + 1);
        }
        baseInfoPanel.add(new JLabel(utsDot3Olt2VlanStackingLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Olt2VlanStackingLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Olt2VlanStackingCVlanId));
        tfUtsDot3Olt2VlanStackingCVlanId.setName(fStringMap.getString("utsDot3Olt2VlanStackingCVlanId"));
        baseInfoPanel.add(tfUtsDot3Olt2VlanStackingCVlanId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Olt2VlanStackingSVlanId));
        tfUtsDot3Olt2VlanStackingSVlanId.setName(fStringMap.getString("utsDot3Olt2VlanStackingSVlanId"));
        baseInfoPanel.add(tfUtsDot3Olt2VlanStackingSVlanId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Olt2VlanStackingPriMode));
        tfUtsDot3Olt2VlanStackingPriMode.setName(fStringMap.getString("utsDot3Olt2VlanStackingPriMode"));
        baseInfoPanel.add(tfUtsDot3Olt2VlanStackingPriMode);
        baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < 8; i++) {
            tfUtsDot3Olt2VlanStackingSVlanPri.addItem(i);
        }
        baseInfoPanel.add(new JLabel(utsDot3Olt2VlanStackingSVlanPri));
        tfUtsDot3Olt2VlanStackingSVlanPri.setName(fStringMap.getString("utsDot3Olt2VlanStackingSVlanPri"));
        baseInfoPanel.add(tfUtsDot3Olt2VlanStackingSVlanPri);
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
        tfUtsDot3Olt2VlanStackingCVlanId.setValueScope(1, 4094);
        tfUtsDot3Olt2VlanStackingSVlanId.setValueScope(1, 4094);
    }

    public void refresh() {
        tfUtsDot3OltVlanStackingModuleId.removeAllItems();
        ModuleType fModuleType = new ModuleType();
        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS1000CardMibBean card = (BBS1000CardMibBean) list.get(i);
            if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                tfUtsDot3OltVlanStackingModuleId.addItem(card.getUtsEponModuleBoardPhyId());
            }
        }
    }

    public boolean validateFrom() {
        if (tfUtsDot3OltVlanStackingModuleId.getSelectedItem() == null) {
            String error = fStringMap.getString("Err_Module_Id_Is_Null");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        if (tfUtsDot3Olt2VlanStackingCVlanId.getValue() == tfUtsDot3Olt2VlanStackingSVlanId.getValue()) {
            String error = fStringMap.getString("Err_CVlan_SVlan_Same");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        Dot3Olt2VlanStackingTable bean = new Dot3Olt2VlanStackingTable(fApplication.getSnmpProxy());
        bean.setRowsPerFetch(50);
        bean.setIndexPrefix("" + tfUtsDot3OltVlanStackingModuleId.getSelectedItem());
        Vector v = BeanService.refreshTableBean(fApplication, bean);

        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                Dot3Olt2VlanStackingTable one = (Dot3Olt2VlanStackingTable) v.get(i);
                if (one.getUtsDot3Olt2VlanStackingCVlanId() == tfUtsDot3Olt2VlanStackingCVlanId.getValue()) {
                    String error = fStringMap.getString("Err_CVlan_Is_Used");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }

                //if (one.getUtsDot3Olt2VlanStackingSVlanId() == tfUtsDot3Olt2VlanStackingSVlanId.getValue()) {
                //    String error = fStringMap.getString("Err_SVlan_Is_Used");
                //    MessageDialog.showErrorMessageDialog(fApplication, error);
                //    return false;
                //}
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new Dot3Olt2VlanStackingTable(fApplication.getSnmpProxy()));

        Dot3Olt2VlanStackingTable mbean = (Dot3Olt2VlanStackingTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUtsDot3OltVlanStackingModuleId((Integer) tfUtsDot3OltVlanStackingModuleId.getSelectedItem());
            mbean.setUtsDot3OltVlanStackingDeviceId(1);
            mbean.setUtsDot3OltVlanStackingPortId((Integer) tfUtsDot3OltVlanStackingPortId.getSelectedItem());
            mbean.setUtsDot3Olt2VlanStackingLogicalPortId((Integer) tfUtsDot3Olt2VlanStackingLogicalPortId.getSelectedItem());
            mbean.setUtsDot3Olt2VlanStackingCVlanId(tfUtsDot3Olt2VlanStackingCVlanId.getValue());
        }

        mbean.setUtsDot3Olt2VlanStackingSVlanId(tfUtsDot3Olt2VlanStackingSVlanId.getValue());
        mbean.setUtsDot3Olt2VlanStackingPriMode(utsDot3Olt2VlanStackingPriModeVList[tfUtsDot3Olt2VlanStackingPriMode.getSelectedIndex()]);
        mbean.setUtsDot3Olt2VlanStackingSVlanPri((Integer) tfUtsDot3Olt2VlanStackingSVlanPri.getSelectedItem());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}