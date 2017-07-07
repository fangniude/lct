/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GponOnuEthUniCfgPanel extends UPanel {

    private JComboBox tfOnuEthUniCfgSlotNo = new JComboBox();
    private JComboBox tfOnuEthUniCfgPortNo = new JComboBox();
    private JComboBox tfOnuEthUniCfgLogicalPortNo = new JComboBox();
    private JComboBox tfOnuEthUniCfgPhysicalPortNo = new JComboBox();

    private int[] onuEthUniCfgAdministrativeStateVList = new int[]{1, 2,};
    private String[] onuEthUniCfgAdministrativeStateTList = new String[]{
            fStringMap.getString("unlock"),
            fStringMap.getString("lock"),
    };
    private JComboBox tfOnuEthUniCfgAdministrativeState = new JComboBox(onuEthUniCfgAdministrativeStateTList);

    /*
    private int[] onuEthUniCfgOperationalStateVList = new int[]{1, 2, 3,};
    private String[] onuEthUniCfgOperationalStateTList = new String[]{
            fStringMap.getString("enabled"),
            fStringMap.getString("disabled"),
            fStringMap.getString("unknown"),
    };
    private JComboBox tfOnuEthUniCfgOperationalState = new JComboBox(onuEthUniCfgOperationalStateTList);
    */

    private ProfileChooser tfOnuEthUniCfgOnuVLANTranslationProfileIndex = new ProfileChooser(fApplication);

    private ProfileChooser tfOnuEthUniCfgOnuMulticastOperationProfileIndex = new ProfileChooser(fApplication);

    private ProfileChooser tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex = new ProfileChooser(fApplication);

    private ProfileChooser tfOnuEthUniCfgEthernetUNIProfileIndex = new ProfileChooser(fApplication);

    private int[] onuEthUniCfgLoopbackVList = new int[]{1, 4,};
    private String[] onuEthUniCfgLoopbackTList = new String[]{
            fStringMap.getString("noLoopback"),
            fStringMap.getString("loop3"),
    };
    private JComboBox tfOnuEthUniCfgLoopback = new JComboBox(onuEthUniCfgLoopbackTList);
    //private JLabel tfOnuEthUniCfgSensedType = new JLabel();

    /*
    private int[] onuEthUniCfgIndConfigurationVList = new int[]{0, 1, 2, 3, 17, 18, 19,};
    private String[] onuEthUniCfgIndConfigurationTList = new String[]{
            fStringMap.getString("unknown"),
            fStringMap.getString("fullDuplex10BaseT"),
            fStringMap.getString("fullDuplex100BaseT"),
            fStringMap.getString("gigabitEthernetFullDuplex"),
            fStringMap.getString("halfDuplex10BaseT"),
            fStringMap.getString("halfDuplex100BaseT"),
            fStringMap.getString("gigabitEthernetHalfDuplex"),
    };
    private JComboBox tfOnuEthUniCfgIndConfiguration = new JComboBox(onuEthUniCfgIndConfigurationTList);
    */

    private ProfileChooser tfOnuEthUniCfgOnuMACFilterProfileIndex = new ProfileChooser(fApplication);

    private ProfileChooser tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex = new ProfileChooser(fApplication);

    private LongTextField tfOnuEthUniCfgmacLimit = new LongTextField();

    private ProfileChooser tfOnuEthUniCfgOnuVlanFilterProfileIndex = new ProfileChooser(fApplication);

    private final String onuEthUniCfgSlotNo = fStringMap.getString("onuEthUniCfgSlotNo") + ": ";
    private final String onuEthUniCfgPortNo = fStringMap.getString("onuEthUniCfgPortNo") + ": ";
    private final String onuEthUniCfgLogicalPortNo = fStringMap.getString("onuEthUniCfgLogicalPortNo") + ": ";
    private final String onuEthUniCfgPhysicalPortNo = fStringMap.getString("onuEthUniCfgPhysicalPortNo") + ": ";
    private final String onuEthUniCfgAdministrativeState = fStringMap.getString("onuEthUniCfgAdministrativeState") + ": ";
    //private final String onuEthUniCfgOperationalState = fStringMap.getString("onuEthUniCfgOperationalState") + ": ";
    private final String onuEthUniCfgOnuVLANTranslationProfileName = fStringMap.getString("onuEthUniCfgOnuVLANTranslationProfileName") + ": ";
    private final String onuEthUniCfgOnuMulticastOperationProfileName = fStringMap.getString("onuEthUniCfgOnuMulticastOperationProfileName") + ": ";
    private final String onuEthUniCfgOnuStaticMulticastGroupsProfileName = fStringMap.getString("onuEthUniCfgOnuStaticMulticastGroupsProfileName") + ": ";
    private final String onuEthUniCfgEthernetUNIProfileName = fStringMap.getString("onuEthUniCfgEthernetUNIProfileName") + ": ";
    private final String onuEthUniCfgLoopback = fStringMap.getString("onuEthUniCfgLoopback") + ": ";
    //private final String onuEthUniCfgSensedType = fStringMap.getString("onuEthUniCfgSensedType") + ": ";
    //private final String onuEthUniCfgIndConfiguration = fStringMap.getString("onuEthUniCfgIndConfiguration") + ": ";
    private final String onuEthUniCfgOnuMACFilterProfileName = fStringMap.getString("onuEthUniCfgOnuMACFilterProfileName") + ": ";
    private final String onuEthUniCfgOnuMACFilterPreassignProfileName = fStringMap.getString("onuEthUniCfgOnuMACFilterPreassignProfileName") + ": ";
    private final String onuEthUniCfgmacLimit = fStringMap.getString("onuEthUniCfgmacLimit") + ": ";
    private final String onuEthUniCfgOnuVlanFilterProfileName = fStringMap.getString("onuEthUniCfgOnuVlanFilterProfileName") + ": ";
    private BBS4000NE ne = null;

    public GponOnuEthUniCfgPanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(14, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuEthUniCfgSlotNo));
        baseInfoPanel.add(tfOnuEthUniCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgPortNo));
        baseInfoPanel.add(tfOnuEthUniCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuEthUniCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgPhysicalPortNo));
        baseInfoPanel.add(tfOnuEthUniCfgPhysicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgAdministrativeState));
        tfOnuEthUniCfgAdministrativeState.setName(fStringMap.getString("onuEthUniCfgAdministrativeState"));
        baseInfoPanel.add(tfOnuEthUniCfgAdministrativeState);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuEthUniCfgOperationalState));
        //baseInfoPanel.add(tfOnuEthUniCfgOperationalState);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuVLANTranslationProfileName));
        tfOnuEthUniCfgOnuVLANTranslationProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuVLANTranslationProfileName"));
        tfOnuEthUniCfgOnuVLANTranslationProfileIndex.setProfile("OnuVlanTransProfTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuVLANTranslationProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuMulticastOperationProfileName));
        tfOnuEthUniCfgOnuMulticastOperationProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuMulticastOperationProfileName"));
        tfOnuEthUniCfgOnuMulticastOperationProfileIndex.setProfile("GponOnuMulticastOperProfTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuMulticastOperationProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuStaticMulticastGroupsProfileName));
        tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuStaticMulticastGroupsProfileName"));
        tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.setProfile("OnuStaticMultiGroupProfTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgEthernetUNIProfileName));
        tfOnuEthUniCfgEthernetUNIProfileIndex.setName(fStringMap.getString("onuEthUniCfgEthernetUNIProfileName"));
        tfOnuEthUniCfgEthernetUNIProfileIndex.setProfile("OnuEthUniCfgProTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgEthernetUNIProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgLoopback));
        tfOnuEthUniCfgLoopback.setName(fStringMap.getString("onuEthUniCfgLoopback"));
        baseInfoPanel.add(tfOnuEthUniCfgLoopback);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuEthUniCfgSensedType));
        baseInfoPanel.add(tfOnuEthUniCfgSensedType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgIndConfiguration));
        baseInfoPanel.add(tfOnuEthUniCfgIndConfiguration);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuMACFilterProfileName));
        tfOnuEthUniCfgOnuMACFilterProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuMACFilterProfileName"));
        tfOnuEthUniCfgOnuMACFilterProfileIndex.setProfile("GponOnuMacFilterProfTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuMACFilterProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuMACFilterPreassignProfileName));
        tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuMACFilterPreassignProfileName"));
        tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.setProfile("OnuMacFilterPreassignProTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgmacLimit));
        tfOnuEthUniCfgmacLimit.setName(fStringMap.getString("onuEthUniCfgmacLimit"));
        baseInfoPanel.add(tfOnuEthUniCfgmacLimit);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEthUniCfgOnuVlanFilterProfileName));
        tfOnuEthUniCfgOnuVlanFilterProfileIndex.setName(fStringMap.getString("onuEthUniCfgOnuVlanFilterProfileName"));
        tfOnuEthUniCfgOnuVlanFilterProfileIndex.setProfile("OnuVlanFilterProfileTable_Panel");
        baseInfoPanel.add(tfOnuEthUniCfgOnuVlanFilterProfileIndex);
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
        tfOnuEthUniCfgmacLimit.setValueScope(1, 512);
    }

    public void refresh() {
        //-------------------
        //Slot
        tfOnuEthUniCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuEthUniCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuEthUniCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                tfOnuEthUniCfgSlotNo.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuEthUniCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuEthUniCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuEthUniCfgLogicalPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
            tfOnuEthUniCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //Physical Port
        tfOnuEthUniCfgPhysicalPortNo.removeAllItems();
        for (int i = 1; i <= 128; i++) {
            tfOnuEthUniCfgPhysicalPortNo.addItem(fStringMap.getString("UNI") + " " + i);
        }
        //-------------------

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuEthUniCfgSlotNo.setEnabled(true);
            tfOnuEthUniCfgPortNo.setEnabled(true);
            tfOnuEthUniCfgLogicalPortNo.setEnabled(true);
            tfOnuEthUniCfgPhysicalPortNo.setEnabled(true);

            tfOnuEthUniCfgOnuVLANTranslationProfileIndex.refresh();
            tfOnuEthUniCfgOnuVLANTranslationProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgOnuMulticastOperationProfileIndex.refresh();
            tfOnuEthUniCfgOnuMulticastOperationProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.refresh();
            tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgEthernetUNIProfileIndex.refresh();
            tfOnuEthUniCfgEthernetUNIProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgOnuMACFilterProfileIndex.refresh();
            tfOnuEthUniCfgOnuMACFilterProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.refresh();
            tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.setSelectedProfileIndex(1);

            tfOnuEthUniCfgOnuVlanFilterProfileIndex.refresh();
            tfOnuEthUniCfgOnuVlanFilterProfileIndex.setSelectedProfileIndex(1);

            return;
        } else {
            tfOnuEthUniCfgSlotNo.setEnabled(false);
            tfOnuEthUniCfgPortNo.setEnabled(false);
            tfOnuEthUniCfgLogicalPortNo.setEnabled(false);
            tfOnuEthUniCfgPhysicalPortNo.setEnabled(false);
        }

        GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) getModel();
        if (mbean == null)
            return;

        tfOnuEthUniCfgSlotNo.setSelectedItem((mbean.getOnuEthUniCfgSlotNo() != null) ? mbean.getOnuEthUniCfgSlotNo().toString() : "");
        tfOnuEthUniCfgPortNo.setSelectedItem((mbean.getOnuEthUniCfgPortNo() != null) ? mbean.getOnuEthUniCfgPortNo().toString() : "");
        tfOnuEthUniCfgLogicalPortNo.setSelectedItem((mbean.getOnuEthUniCfgLogicalPortNo() != null) ? mbean.getOnuEthUniCfgLogicalPortNo().toString() : "");
        tfOnuEthUniCfgPhysicalPortNo.setSelectedItem((mbean.getOnuEthUniCfgPhysicalPortNo() != null) ? mbean.getOnuEthUniCfgPhysicalPortNo().toString() : "");

        tfOnuEthUniCfgAdministrativeState.setEnabled(mbean.getOnuEthUniCfgAdministrativeState() != null);
        tfOnuEthUniCfgAdministrativeState.setSelectedIndex(getIndexFromValue(onuEthUniCfgAdministrativeStateVList, mbean.getOnuEthUniCfgAdministrativeState() != null ? mbean.getOnuEthUniCfgAdministrativeState() : -1));

        //tfOnuEthUniCfgOperationalState.setSelectedIndex(getIndexFromValue(onuEthUniCfgOperationalStateVList, mbean.getOnuEthUniCfgOperationalState() != null ? mbean.getOnuEthUniCfgOperationalState() : -1));

        tfOnuEthUniCfgOnuVLANTranslationProfileIndex.refresh();
        tfOnuEthUniCfgOnuVLANTranslationProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex() != null);
        tfOnuEthUniCfgOnuVLANTranslationProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex());

        tfOnuEthUniCfgOnuMulticastOperationProfileIndex.refresh();
        tfOnuEthUniCfgOnuMulticastOperationProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex() != null);
        tfOnuEthUniCfgOnuMulticastOperationProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex());

        tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.refresh();
        tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex() != null);
        tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex());

        tfOnuEthUniCfgEthernetUNIProfileIndex.refresh();
        tfOnuEthUniCfgEthernetUNIProfileIndex.setEnabled(mbean.getOnuEthUniCfgEthernetUNIProfileIndex() != null);
        tfOnuEthUniCfgEthernetUNIProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgEthernetUNIProfileIndex());

        tfOnuEthUniCfgLoopback.setEnabled(mbean.getOnuEthUniCfgLoopback() != null);
        tfOnuEthUniCfgLoopback.setSelectedIndex(getIndexFromValue(onuEthUniCfgLoopbackVList, mbean.getOnuEthUniCfgLoopback()));

        //tfOnuEthUniCfgSensedType.setText(mbean.getOnuEthUniCfgSensedType() != null ? mbean.getOnuEthUniCfgSensedType().toString() : "");
        //tfOnuEthUniCfgIndConfiguration.setSelectedIndex(getIndexFromValue(onuEthUniCfgIndConfigurationVList, mbean.getOnuEthUniCfgIndConfiguration() != null ? mbean.getOnuEthUniCfgIndConfiguration() : -1));

        tfOnuEthUniCfgOnuMACFilterProfileIndex.refresh();
        tfOnuEthUniCfgOnuMACFilterProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuMACFilterProfileIndex() != null);
        tfOnuEthUniCfgOnuMACFilterProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuMACFilterProfileIndex());

        tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.refresh();
        tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex() != null);
        tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex());

        tfOnuEthUniCfgmacLimit.setEnabled(mbean.getOnuEthUniCfgmacLimit() != null);
        tfOnuEthUniCfgmacLimit.setValue(mbean.getOnuEthUniCfgmacLimit() != null ? mbean.getOnuEthUniCfgmacLimit() : 4);

        tfOnuEthUniCfgOnuVlanFilterProfileIndex.refresh();
        tfOnuEthUniCfgOnuVlanFilterProfileIndex.setEnabled(mbean.getOnuEthUniCfgOnuVlanFilterProfileIndex() != null);
        tfOnuEthUniCfgOnuVlanFilterProfileIndex.setSelectedProfileIndex(mbean.getOnuEthUniCfgOnuVlanFilterProfileIndex());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuEthUniCfgMBean(fApplication.getSnmpProxy()));

        GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuEthUniCfgSlotNo(getSelectedSlotId());
            mbean.setOnuEthUniCfgPortNo(getSelectedPortId());
            mbean.setOnuEthUniCfgLogicalPortNo(getSelectedOnuId());
            mbean.setOnuEthUniCfgPhysicalPortNo(getSelectedVpId());
        }

        if (tfOnuEthUniCfgAdministrativeState.isEnabled()) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgAdministrativeState() != onuEthUniCfgAdministrativeStateVList[tfOnuEthUniCfgAdministrativeState.getSelectedIndex()])
                mbean.setOnuEthUniCfgAdministrativeState(onuEthUniCfgAdministrativeStateVList[tfOnuEthUniCfgAdministrativeState.getSelectedIndex()]);
        }

        if (tfOnuEthUniCfgOnuVLANTranslationProfileIndex.isEnabled() && tfOnuEthUniCfgOnuVLANTranslationProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex() != tfOnuEthUniCfgOnuVLANTranslationProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgOnuVLANTranslationProfileIndex(tfOnuEthUniCfgOnuVLANTranslationProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgOnuMulticastOperationProfileIndex.isEnabled() && tfOnuEthUniCfgOnuMulticastOperationProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex() != tfOnuEthUniCfgOnuMulticastOperationProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgOnuMulticastOperationProfileIndex(tfOnuEthUniCfgOnuMulticastOperationProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.isEnabled() && tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex() != tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex(tfOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgEthernetUNIProfileIndex.isEnabled() && tfOnuEthUniCfgEthernetUNIProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgEthernetUNIProfileIndex() != tfOnuEthUniCfgEthernetUNIProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgEthernetUNIProfileIndex(tfOnuEthUniCfgEthernetUNIProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgLoopback.isEnabled()) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgLoopback() != onuEthUniCfgLoopbackVList[tfOnuEthUniCfgLoopback.getSelectedIndex()])
                mbean.setOnuEthUniCfgLoopback(onuEthUniCfgLoopbackVList[tfOnuEthUniCfgLoopback.getSelectedIndex()]);
        }

        if (tfOnuEthUniCfgOnuMACFilterProfileIndex.isEnabled() && tfOnuEthUniCfgOnuMACFilterProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgOnuMACFilterProfileIndex() != tfOnuEthUniCfgOnuMACFilterProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgOnuMACFilterProfileIndex(tfOnuEthUniCfgOnuMACFilterProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.isEnabled() && tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.getSelectedProfileIndex() >= 0) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex() != tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.getSelectedProfileIndex())
                mbean.setOnuEthUniCfgOnuMACFilterPreassignProfileIndex(tfOnuEthUniCfgOnuMACFilterPreassignProfileIndex.getSelectedProfileIndex());
        }

        if (tfOnuEthUniCfgmacLimit.isEnabled()) {
            if (SnmpAction.IType.ADD.equals(fCommand) || SnmpAction.IType.MODIFY.equals(fCommand) && mbean.getOnuEthUniCfgmacLimit() != tfOnuEthUniCfgmacLimit.getValue())
                mbean.setOnuEthUniCfgmacLimit(tfOnuEthUniCfgmacLimit.getValue());
        }

        if (tfOnuEthUniCfgOnuVlanFilterProfileIndex.isEnabled())
            mbean.setOnuEthUniCfgOnuVlanFilterProfileIndex(tfOnuEthUniCfgOnuVlanFilterProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuEthUniCfgOnuVlanFilterProfileIndex.getSelectedProfileIndex() : 1);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuEthUniCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuEthUniCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuEthUniCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuEthUniCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuEthUniCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuEthUniCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedVpId() {
        if (tfOnuEthUniCfgPhysicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuEthUniCfgPhysicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}