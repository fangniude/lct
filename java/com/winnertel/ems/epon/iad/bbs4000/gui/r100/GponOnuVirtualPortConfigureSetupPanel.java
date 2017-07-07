/**
 * Created by Zhou Chao, 2008/9/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVirtualPortConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GponOnuVirtualPortConfigureSetupPanel extends UPanel {

    private JComboBox tfOnuVirtualPortCfgSlotNo = new JComboBox();
    private JComboBox tfOnuVirtualPortCfgPortNo = new JComboBox();
    private JComboBox tfOnuVirtualPortCfgLogicalPortNo = new JComboBox();
    private JComboBox tfOnuVirtualPortCfgVirtualPortNo = new JComboBox();

    private int[] onuVirtualPortCfgAdministrativeStateVList = new int[]{1, 2,};
    private String[] onuVirtualPortCfgAdministrativeStateTList = new String[]{
            fStringMap.getString("unlock"),
            fStringMap.getString("lock"),
    };
    private JComboBox tfOnuVirtualPortCfgAdministrativeState = new JComboBox(onuVirtualPortCfgAdministrativeStateTList);

    //private int[] onuVirtualPortCfgOperationalStateVList = new int[]{1, 2,};
    //private String[] onuVirtualPortCfgOperationalStateTList = new String[]{
    //        fStringMap.getString("enabled"),
    //        fStringMap.getString("disabled"),
    //};
    //private JComboBox tfOnuVirtualPortCfgOperationalState = new JComboBox(onuVirtualPortCfgOperationalStateTList);

    //private LongTextField tfOnuVirtualPortCfgTcontIndex = new LongTextField();

    //private LongTextField tfOnuVirtualPortCfgMacLimit = new LongTextField();

    private ProfileChooser tfOnuVirtualPortCfgOltVLANTranslationProfileIndex = new ProfileChooser(fApplication);

    //private JLabel tfOnuVirtualPortCfgOltGEMPortNo = new JLabel();
    //private JLabel tfOnuVirtualPortCfgOltAllocID = new JLabel();

    private ProfileChooser tfOnuVirtualPortCfgOnuMACFilterProfileIndex = new ProfileChooser(fApplication);

    private ProfileChooser tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex = new ProfileChooser(fApplication);

    //private ProfileChooser tfOnuVirtualPortCfgOnuVlanFilterProfileIndex = new ProfileChooser(fApplication); //(Reserved)

    private final String onuVirtualPortCfgSlotNo = fStringMap.getString("onuVirtualPortCfgSlotNo") + ": ";
    private final String onuVirtualPortCfgPortNo = fStringMap.getString("onuVirtualPortCfgPortNo") + ": ";
    private final String onuVirtualPortCfgLogicalPortNo = fStringMap.getString("onuVirtualPortCfgLogicalPortNo") + ": ";
    private final String onuVirtualPortCfgVirtualPortNo = fStringMap.getString("onuVirtualPortCfgVirtualPortNo") + ": ";
    private final String onuVirtualPortCfgAdministrativeState = fStringMap.getString("onuVirtualPortCfgAdministrativeState") + ": ";
    //private final String onuVirtualPortCfgOperationalState = fStringMap.getString("onuVirtualPortCfgOperationalState") + ": ";
    //private final String onuVirtualPortCfgTcontIndex = fStringMap.getString("onuVirtualPortCfgTcontIndex") + ": ";
    //private final String onuVirtualPortCfgMacLimit = fStringMap.getString("onuVirtualPortCfgMacLimit") + ": ";
    private final String onuVirtualPortCfgOltVLANTranslationProfileName = fStringMap.getString("onuVirtualPortCfgoltVLANTranslationProfileName") + ": ";
    //private final String onuVirtualPortCfgOltGEMPortNo = fStringMap.getString("onuVirtualPortCfgOltGEMPortNo") + ": ";
    //private final String onuVirtualPortCfgOltAllocID = fStringMap.getString("onuVirtualPortCfgOltAllocID") + ": ";
    private final String onuVirtualPortCfgOnuMACFilterProfileName = fStringMap.getString("onuVirtualPortCfgOnuMACFilterProfileName") + ": ";
    private final String onuVirtualPortCfgOnuMACFilterPreassignProfileName = fStringMap.getString("onuVirtualPortCfgOnuMACFilterPreassignProfileName") + ": ";
    //private final String onuVirtualPortCfgOnuVlanFilterProfileName = fStringMap.getString("onuVirtualPortCfgOnuVlanFilterProfileName") + ": "; //(Reserved)

    private BBS4000NE ne = null;

    private int previousAdminState = -1;

    public GponOnuVirtualPortConfigureSetupPanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        setModel(new GponOnuVirtualPortConfigureMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgSlotNo));
        baseInfoPanel.add(tfOnuVirtualPortCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgPortNo));
        baseInfoPanel.add(tfOnuVirtualPortCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuVirtualPortCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgVirtualPortNo));
        baseInfoPanel.add(tfOnuVirtualPortCfgVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgAdministrativeState));
        tfOnuVirtualPortCfgAdministrativeState.setName(fStringMap.getString("onuVirtualPortCfgAdministrativeState"));
        baseInfoPanel.add(tfOnuVirtualPortCfgAdministrativeState);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOperationalState));
        baseInfoPanel.add(tfOnuVirtualPortCfgOperationalState);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgTcontIndex));
        baseInfoPanel.add(tfOnuVirtualPortCfgTcontIndex);
        baseInfoPanel.add(new HSpacer());
        */

        /*
        baseInfoPanel.add(new JLabel(onuVirtualPortCfgMacLimit));
        baseInfoPanel.add(tfOnuVirtualPortCfgMacLimit);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOltVLANTranslationProfileName));
        tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.setName(fStringMap.getString("onuVirtualPortCfgoltVLANTranslationProfileName"));
        tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.setProfile("OltVlanTransProfTable_Panel");
        baseInfoPanel.add(tfOnuVirtualPortCfgOltVLANTranslationProfileIndex);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOltGEMPortNo));
        baseInfoPanel.add(tfOnuVirtualPortCfgOltGEMPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOltAllocID));
        baseInfoPanel.add(tfOnuVirtualPortCfgOltAllocID);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOnuMACFilterProfileName));
        tfOnuVirtualPortCfgOnuMACFilterProfileIndex.setName(fStringMap.getString("onuVirtualPortCfgOnuMACFilterProfileName"));
        tfOnuVirtualPortCfgOnuMACFilterProfileIndex.setProfile("GponOnuMacFilterProfTable_Panel");
        baseInfoPanel.add(tfOnuVirtualPortCfgOnuMACFilterProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOnuMACFilterPreassignProfileName));
        tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.setName(fStringMap.getString("onuVirtualPortCfgOnuMACFilterPreassignProfileName"));
        tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.setProfile("OnuMacFilterPreassignProTable_Panel");
        baseInfoPanel.add(tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex);
        baseInfoPanel.add(new HSpacer());

        /* (Reserved)
        baseInfoPanel.add(new JLabel(onuVirtualPortCfgOnuVlanFilterProfileName));
        tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.setName(fStringMap.getString("onuVirtualPortCfgOnuVlanFilterProfileName"));
        tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.setProfile("OnuVlanFilterProfileTable_Panel");
        baseInfoPanel.add(tfOnuVirtualPortCfgOnuVlanFilterProfileIndex);
        baseInfoPanel.add(new HSpacer());
        */

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
        //tfOnuVirtualPortCfgTcontIndex.setValueScope(1, 6);
        //tfOnuVirtualPortCfgMacLimit.setValueScope(1, 1024);
    }

    public void refresh() {
        //-------------------
        //Slot
        tfOnuVirtualPortCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuVirtualPortCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuVirtualPortCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                tfOnuEthUniCfgSlotNo.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuVirtualPortCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuVirtualPortCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuVirtualPortCfgLogicalPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
            tfOnuVirtualPortCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //Virtual Port
        tfOnuVirtualPortCfgVirtualPortNo.removeAllItems();
        for (int i = 1; i <= 40; i++) {
            tfOnuVirtualPortCfgVirtualPortNo.addItem(fStringMap.getString("VP") + " " + i);
        }
        //-------------------

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVirtualPortCfgSlotNo.setEnabled(true);
            tfOnuVirtualPortCfgPortNo.setEnabled(true);
            tfOnuVirtualPortCfgLogicalPortNo.setEnabled(true);
            tfOnuVirtualPortCfgVirtualPortNo.setEnabled(true);

            tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.refresh();
            tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.setSelectedProfileIndex(1);

            tfOnuVirtualPortCfgOnuMACFilterProfileIndex.refresh();
            tfOnuVirtualPortCfgOnuMACFilterProfileIndex.setSelectedProfileIndex(1);

            tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.refresh();
            tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.setSelectedProfileIndex(1);

            /* (Reserved)
            tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.refresh();
            tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.setSelectedProfileIndex(1);
            */

            return;
        } else {
            tfOnuVirtualPortCfgSlotNo.setEnabled(false);
            tfOnuVirtualPortCfgPortNo.setEnabled(false);
            tfOnuVirtualPortCfgLogicalPortNo.setEnabled(false);
            tfOnuVirtualPortCfgVirtualPortNo.setEnabled(false);
        }

        GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfOnuVirtualPortCfgSlotNo.setSelectedItem((mbean.getOnuVirtualPortCfgSlotNo() != null) ? mbean.getOnuVirtualPortCfgSlotNo().toString() : "");
        tfOnuVirtualPortCfgPortNo.setSelectedItem((mbean.getOnuVirtualPortCfgPortNo() != null) ? mbean.getOnuVirtualPortCfgPortNo().toString() : "");
        tfOnuVirtualPortCfgLogicalPortNo.setSelectedItem((mbean.getOnuVirtualPortCfgLogicalPortNo() != null) ? mbean.getOnuVirtualPortCfgLogicalPortNo().toString() : "");
        tfOnuVirtualPortCfgVirtualPortNo.setSelectedItem((mbean.getOnuVirtualPortCfgVirtualPortNo() != null) ? mbean.getOnuVirtualPortCfgVirtualPortNo().toString() : "");

        tfOnuVirtualPortCfgAdministrativeState.setEnabled(mbean.getOnuVirtualPortCfgAdministrativeState() != null);
        tfOnuVirtualPortCfgAdministrativeState.setSelectedIndex(getIndexFromValue(onuVirtualPortCfgAdministrativeStateVList, (mbean.getOnuVirtualPortCfgAdministrativeState() != null) ? mbean.getOnuVirtualPortCfgAdministrativeState() : 0));
        previousAdminState = tfOnuVirtualPortCfgAdministrativeState.getSelectedIndex();

        //tfOnuVirtualPortCfgOperationalState.setSelectedIndex(getIndexFromValue(onuVirtualPortCfgOperationalStateVList, (mbean.getOnuVirtualPortCfgOperationalState() != null) ? mbean.getOnuVirtualPortCfgOperationalState() : 0));
        //tfOnuVirtualPortCfgTcontIndex.setValue((mbean.getOnuVirtualPortCfgTcontIndex() != null) ? mbean.getOnuVirtualPortCfgTcontIndex() : 0);
        //tfOnuVirtualPortCfgMacLimit.setValue((mbean.getOnuVirtualPortCfgMacLimit() != null) ? mbean.getOnuVirtualPortCfgMacLimit() : 4);

        tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.refresh();
        tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.setEnabled(mbean.getOnuVirtualPortCfgoltVLANTranslationProfileIndex() != null);
        tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.setSelectedProfileIndex(mbean.getOnuVirtualPortCfgoltVLANTranslationProfileIndex());

        //tfOnuVirtualPortCfgOltGEMPortNo.setText(mbean.getOnuVirtualPortCfgOltGEMPortNo().toString());
        //tfOnuVirtualPortCfgOltAllocID.setText(mbean.getOnuVirtualPortCfgOltAllocID().toString());

        tfOnuVirtualPortCfgOnuMACFilterProfileIndex.refresh();
        tfOnuVirtualPortCfgOnuMACFilterProfileIndex.setEnabled(mbean.getOnuVirtualPortCfgOnuMACFilterProfileIndex() != null);
        tfOnuVirtualPortCfgOnuMACFilterProfileIndex.setSelectedProfileIndex(mbean.getOnuVirtualPortCfgOnuMACFilterProfileIndex());

        tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.refresh();
        tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.setEnabled(mbean.getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex() != null);
        tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.setSelectedProfileIndex(mbean.getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex());

        /* (Reserved)
        tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.refresh();
        tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.setEnabled(mbean.getOnuVirtualPortCfgOnuVlanFilterProfileIndex() != null);
        tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.setSelectedProfileIndex(mbean.getOnuVirtualPortCfgOnuVlanFilterProfileIndex());
        */
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuVirtualPortConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOnuVirtualPortCfgSlotNo(getSelectedSlotId());
            mbean.setOnuVirtualPortCfgPortNo(getSelectedPortId());
            mbean.setOnuVirtualPortCfgLogicalPortNo(getSelectedOnuId());
            mbean.setOnuVirtualPortCfgVirtualPortNo(getSelectedVpId());
        }

        if (tfOnuVirtualPortCfgAdministrativeState.isEnabled() && tfOnuVirtualPortCfgAdministrativeState.getSelectedIndex() != previousAdminState) {
            previousAdminState = tfOnuVirtualPortCfgAdministrativeState.getSelectedIndex();
            mbean.setOnuVirtualPortCfgAdministrativeState(onuVirtualPortCfgAdministrativeStateVList[tfOnuVirtualPortCfgAdministrativeState.getSelectedIndex()]);
        }

        //mbean.setOnuVirtualPortCfgMacLimit(tfOnuVirtualPortCfgMacLimit.getValue());

        if (tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.isEnabled())
            mbean.setOnuVirtualPortCfgoltVLANTranslationProfileIndex(tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.getSelectedProfileIndex() < 0 ? 1 : tfOnuVirtualPortCfgOltVLANTranslationProfileIndex.getSelectedProfileIndex());

        if (tfOnuVirtualPortCfgOnuMACFilterProfileIndex.isEnabled())
            mbean.setOnuVirtualPortCfgOnuMACFilterProfileIndex(tfOnuVirtualPortCfgOnuMACFilterProfileIndex.getSelectedProfileIndex() < 0 ? 1 : tfOnuVirtualPortCfgOnuMACFilterProfileIndex.getSelectedProfileIndex());

        if (tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.isEnabled())
            mbean.setOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex(tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.getSelectedProfileIndex() < 0 ? 1 : tfOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex.getSelectedProfileIndex());

        /* (Reserved)
        if (tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.isEnabled())
            mbean.setOnuVirtualPortCfgOnuVlanFilterProfileIndex(tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.getSelectedProfileIndex() < 0 ? 1 : tfOnuVirtualPortCfgOnuVlanFilterProfileIndex.getSelectedProfileIndex());
        */
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuVirtualPortCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuVirtualPortCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuVirtualPortCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuVirtualPortCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuVirtualPortCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuVirtualPortCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedVpId() {
        if (tfOnuVirtualPortCfgVirtualPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuVirtualPortCfgVirtualPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}