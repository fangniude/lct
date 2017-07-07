/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuSystemConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GponOnuSystemConfigureSetupPanel extends UPanel {

    //------------------- MIB items -------------------
    private JComboBox tfOnuCfgSlotNo = new JComboBox();
    private JComboBox tfOnuCfgPortNo = new JComboBox();
    private JComboBox tfOnuCfgLogicalPortNo = new JComboBox();

    private StringTextField tfOnuCfgSerialNumber = new StringTextField();
    private StringTextField tfOnuCfgPassword = new StringTextField();

//    private int[] onuCfgPrimaryStatusVList = new int[]{1, 2, 3, 4, 5, 6,};
//    private String[] onuCfgPrimaryStatusTList = new String[]{
//            fStringMap.getString("inactive"),
//            fStringMap.getString("activatePending"),
//            fStringMap.getString("active"),
//            fStringMap.getString("deactivatePending"),
//            fStringMap.getString("disablePending"),
//            fStringMap.getString("disabled"),
//    };
//    private JComboBox tfOnuCfgPrimaryStatus = new JComboBox(onuCfgPrimaryStatusTList);
//
//    private JLabel tfOnuCfgOnuHardwareType = new JLabel();
//    private JLabel tfOnuCfgOnuHardwareRevision = new JLabel();

    private int[] onuCfgAdministrativeStateVList = new int[]{0, 1,};
    private String[] onuCfgAdministrativeStateTList = new String[]{
            fStringMap.getString("unlock"),
            fStringMap.getString("lock"),
    };
    private JComboBox tfOnuCfgAdministrativeState = new JComboBox(onuCfgAdministrativeStateTList);

//   private int[] onuCfgOperationalStateVList = new int[]{0, 1,};
//    private String[] onuCfgOperationalStateTList = new String[]{
//            fStringMap.getString("enabled"),
//            fStringMap.getString("disabled"),
//    };
//    private JComboBox tfOnuCfgOperationalState = new JComboBox(onuCfgOperationalStateTList);

//    private JLabel tfOnuCfgSysUpTime = new JLabel();
//    private JLabel tfOnuCfgOnuEqualizationDelay = new JLabel();
//    private JLabel tfOnuCfgVendorID = new JLabel();
//    private JLabel tfOnuCfgVersion = new JLabel();
//
//    private JLabel tfOnuCfgEquipmentID = new JLabel();
//
//    private int[] onuCfgOmccVersionVList = new int[]{128, 129, 130, 131, 132,};
//    private String[] onuCfgOmccVersionTList = new String[]{
//            fStringMap.getString("g-984-4"),
//            fStringMap.getString("g-984-4amd1"),
//            fStringMap.getString("g-984-4amd2"),
//            fStringMap.getString("g-984-4amd3"),
//            fStringMap.getString("g-984-42007to2008"),
//    };
//    private JComboBox tfOnuCfgOmccVersion = new JComboBox(onuCfgOmccVersionTList);

    private final String onuCfgSlotNo = fStringMap.getString("onuCfgSlotNo") + ": ";
    private final String onuCfgPortNo = fStringMap.getString("onuCfgPortNo") + ": ";
    private final String onuCfgLogicalPortNo = fStringMap.getString("onuCfgLogicalPortNo") + ": ";
    private final String onuCfgSerialNumber = fStringMap.getString("onuCfgSerialNumber") + ": ";
    private final String onuCfgPassword = fStringMap.getString("onuCfgPassword") + ": ";
//    private final String onuCfgPrimaryStatus = fStringMap.getString("onuCfgPrimaryStatus") + ": ";
//    private final String onuCfgOnuHardwareType = fStringMap.getString("onuCfgOnuHardwareType") + ": ";
    //    private final String onuCfgOnuHardwareRevision = fStringMap.getString("onuCfgOnuHardwareRevision") + ": ";
    private final String onuCfgAdministrativeState = fStringMap.getString("onuCfgAdministrativeState") + ": ";
//    private final String onuCfgOperationalState = fStringMap.getString("onuCfgOperationalState") + ": ";
//    private final String onuCfgSysUpTime = fStringMap.getString("onuCfgSysUpTime") + ": ";
//    private final String onuCfgOnuEqualizationDelay = fStringMap.getString("onuCfgOnuEqualizationDelay") + ": ";
//    private final String onuCfgVendorID = fStringMap.getString("onuCfgVendorID") + ": ";
//    private final String onuCfgVersion = fStringMap.getString("onuCfgVersion") + ": ";
//    private final String onuCfgEquipmentID = fStringMap.getString("onuCfgEquipmentID") + ": ";
//    private final String onuCfgOmccVersion = fStringMap.getString("onuCfgOmccVersion") + ": ";

    private BBS4000NE ne = null;

    private int previousAdminState = -1;

    public GponOnuSystemConfigureSetupPanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuCfgSlotNo));
        baseInfoPanel.add(tfOnuCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgPortNo));
        baseInfoPanel.add(tfOnuCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgSerialNumber));
        tfOnuCfgSerialNumber.setName(fStringMap.getString("onuCfgSerialNumber"));
        baseInfoPanel.add(tfOnuCfgSerialNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgPassword));
        tfOnuCfgPassword.setName(fStringMap.getString("onuCfgPassword"));
        baseInfoPanel.add(tfOnuCfgPassword);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(onuCfgPrimaryStatus));
//        baseInfoPanel.add(tfOnuCfgPrimaryStatus);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgOnuHardwareType));
//        baseInfoPanel.add(tfOnuCfgOnuHardwareType);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgOnuHardwareRevision));
//        baseInfoPanel.add(tfOnuCfgOnuHardwareRevision);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgAdministrativeState));
        tfOnuCfgAdministrativeState.setName(fStringMap.getString("onuCfgAdministrativeState"));
        baseInfoPanel.add(tfOnuCfgAdministrativeState);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(onuCfgOperationalState));
//        tfOnuCfgOperationalState.setName(fStringMap.getString("onuCfgOperationalState"));
//        baseInfoPanel.add(tfOnuCfgOperationalState);
//        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(onuCfgSysUpTime));
//        baseInfoPanel.add(tfOnuCfgSysUpTime);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgOnuEqualizationDelay));
//        baseInfoPanel.add(tfOnuCfgOnuEqualizationDelay);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgVendorID));
//        baseInfoPanel.add(tfOnuCfgVendorID);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgVersion));
//        baseInfoPanel.add(tfOnuCfgVersion);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgEquipmentID));
//        baseInfoPanel.add(tfOnuCfgEquipmentID);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(onuCfgOmccVersion));
//        baseInfoPanel.add(tfOnuCfgOmccVersion);
//        baseInfoPanel.add(new HSpacer());

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
    }

    public void refresh() {
        //-------------------
        //Slot
        tfOnuCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuCfgLogicalPortNo.removeAllItems();
        int count = ne.getPonSplitRatio();
        for (int i = 1; i <= count; i++) {
            tfOnuCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //-------------------

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuCfgSlotNo.setEnabled(true);
            tfOnuCfgPortNo.setEnabled(true);
            tfOnuCfgLogicalPortNo.setEnabled(true);
            tfOnuCfgPassword.setValue("00000000000000000000");
            tfOnuCfgAdministrativeState.setEnabled(false);
            return;
        } else {
            tfOnuCfgSlotNo.setEnabled(false);
            tfOnuCfgPortNo.setEnabled(false);
            tfOnuCfgLogicalPortNo.setEnabled(false);
            tfOnuCfgAdministrativeState.setEnabled(true);
        }

        GponOnuSystemConfigureMBean mbean = (GponOnuSystemConfigureMBean) getModel();
        if (mbean == null)
            return;
        tfOnuCfgSlotNo.setSelectedItem((mbean.getOnuCfgSlotNo() != null) ? mbean.getOnuCfgSlotNo().toString() : "");
        tfOnuCfgPortNo.setSelectedItem((mbean.getOnuCfgPortNo() != null) ? fStringMap.getString("Port") + " " + mbean.getOnuCfgPortNo().toString() : "");
        tfOnuCfgLogicalPortNo.setSelectedItem((mbean.getOnuCfgLogicalPortNo() != null) ?fStringMap.getString("ONT") + " " + mbean.getOnuCfgLogicalPortNo().toString() : "");

        tfOnuCfgSerialNumber.setEnabled(mbean.getOnuCfgSerialNumber() != null);
        tfOnuCfgSerialNumber.setValue((mbean.getOnuCfgSerialNumber() != null) ? mbean.getOnuCfgSerialNumber() : "");

        tfOnuCfgPassword.setEnabled(mbean.getOnuCfgPassword() != null);
        tfOnuCfgPassword.setValue((mbean.getOnuCfgPassword() != null) ? mbean.getOnuCfgPassword() : "00000000000000000000");

//        tfOnuCfgPrimaryStatus.setSelectedIndex(getIndexFromValue(onuCfgPrimaryStatusVList, (mbean.getOnuCfgPrimaryStatus() != null) ? mbean.getOnuCfgPrimaryStatus() : 0));
//        tfOnuCfgOnuHardwareType.setText((mbean.getOnuCfgOnuHardwareType() != null) ? mbean.getOnuCfgOnuHardwareType().toString() : "");
//        tfOnuCfgOnuHardwareRevision.setText((mbean.getOnuCfgOnuHardwareRevision() != null) ? mbean.getOnuCfgOnuHardwareRevision().toString() : "");

        tfOnuCfgAdministrativeState.setEnabled(mbean.getOnuCfgAdministrativeState() != null);
        tfOnuCfgAdministrativeState.setSelectedIndex(getIndexFromValue(onuCfgAdministrativeStateVList, (mbean.getOnuCfgAdministrativeState() != null) ? mbean.getOnuCfgAdministrativeState() : 0));
        previousAdminState = tfOnuCfgAdministrativeState.getSelectedIndex();

//        tfOnuCfgOperationalState.setSelectedIndex(getIndexFromValue(onuCfgOperationalStateVList, (mbean.getOnuCfgOperationalState() != null) ? mbean.getOnuCfgOperationalState() : 0));
//        tfOnuCfgSysUpTime.setText((mbean.getOnuCfgSysUpTime() != null) ? mbean.getOnuCfgSysUpTime().toString() : "");
//        tfOnuCfgOnuEqualizationDelay.setText((mbean.getOnuCfgOnuEqualizationDelay() != null) ? mbean.getOnuCfgOnuEqualizationDelay().toString() : "");
//        tfOnuCfgVendorID.setText((mbean.getOnuCfgVendorID() != null) ? mbean.getOnuCfgVendorID() : "");
//        tfOnuCfgVersion.setText((mbean.getOnuCfgVersion() != null) ? mbean.getOnuCfgVersion() : "");
//        tfOnuCfgEquipmentID.setText((mbean.getOnuCfgEquipmentID() != null) ? mbean.getOnuCfgEquipmentID() : "");
//        tfOnuCfgOmccVersion.setSelectedIndex(getIndexFromValue(onuCfgOmccVersionVList, (mbean.getOnuCfgOmccVersion() != null) ? mbean.getOnuCfgOmccVersion() : 0));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuSystemConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuSystemConfigureMBean mbean = (GponOnuSystemConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuCfgSlotNo(getSelectedSlotId());
            mbean.setOnuCfgPortNo(getSelectedPortId());
            mbean.setOnuCfgLogicalPortNo(getSelectedOnuId());
        }

        if (tfOnuCfgSerialNumber.isEnabled())
            mbean.setOnuCfgSerialNumber(tfOnuCfgSerialNumber.getValue());

        if (tfOnuCfgPassword.isEnabled())
            mbean.setOnuCfgPassword(tfOnuCfgPassword.getValue());

        if (tfOnuCfgAdministrativeState.isEnabled() && tfOnuCfgAdministrativeState.getSelectedIndex() != previousAdminState)
            mbean.setOnuCfgAdministrativeState(onuCfgAdministrativeStateVList[tfOnuCfgAdministrativeState.getSelectedIndex()]);

        //mbean.setOnuCfgOperationalState(onuCfgOperationalStateVList[tfOnuCfgOperationalState.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}