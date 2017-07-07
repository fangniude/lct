/**
 * Created by Zhou Chao, 2008/12/2
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuPotsUniCfgMBean;
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

public class GponOnuPotsUniCfgPanel extends UPanel {

    private JComboBox tfOnuPotsUniCfgSlotNo = new JComboBox();
    private JComboBox tfOnuPotsUniCfgPortNo = new JComboBox();
    private JComboBox tfOnuPotsUniCfgLogicalPortNo = new JComboBox();
    private JComboBox tfOnuPotsUniCfgPhysicalPortNo = new JComboBox();

    private int[] onuPotsUniCfgAdministrativeStateVList = new int[]{1, 2,};
    private String[] onuPotsUniCfgAdministrativeStateTList = new String[]{
            fStringMap.getString("unlock"),
            fStringMap.getString("lock"),
    };
    private JComboBox tfOnuPotsUniCfgAdministrativeState = new JComboBox(onuPotsUniCfgAdministrativeStateTList);

    //private int[] onuPotsUniCfgOperationalStateVList = new int[]{1, 2, 3,};
    //private String[] onuPotsUniCfgOperationalStateTList = new String[]{
    //        fStringMap.getString("enabled"),
    //        fStringMap.getString("disabled"),
    //        fStringMap.getString("unknown"),
    //};
    //private JComboBox tfOnuPotsUniCfgOperationalState = new JComboBox(onuPotsUniCfgOperationalStateTList);

    private StringTextField tfOnuPotsUniCfgOnuVoIPUserName = new StringTextField();
    private StringTextField tfOnuPotsUniCfgOnuVoIPPassword = new StringTextField();

    private ProfileChooser tfOnuPotsUniCfgOnuVoIPServiceProfileIndex = new ProfileChooser(fApplication);

    //private int[] onuPotsUniCfgHookStateVList = new int[]{1, 2,};
    //private String[] onuPotsUniCfgHookStateTList = new String[]{
    //        fStringMap.getString("On Hook"),
    //        fStringMap.getString("Off Hook"),
    //};
    //private JComboBox tfOnuPotsUniCfgHookState = new JComboBox(onuPotsUniCfgHookStateTList);

    private final String onuPotsUniCfgSlotNo = fStringMap.getString("onuPotsUniCfgSlotNo") + ": ";
    private final String onuPotsUniCfgPortNo = fStringMap.getString("onuPotsUniCfgPortNo") + ": ";
    private final String onuPotsUniCfgLogicalPortNo = fStringMap.getString("onuPotsUniCfgLogicalPortNo") + ": ";
    private final String onuPotsUniCfgPhysicalPortNo = fStringMap.getString("onuPotsUniCfgPhysicalPortNo") + ": ";
    private final String onuPotsUniCfgAdministrativeState = fStringMap.getString("onuPotsUniCfgAdministrativeState") + ": ";
    //private final String onuPotsUniCfgOperationalState = fStringMap.getString("onuPotsUniCfgOperationalState") + ": ";
    private final String onuPotsUniCfgOnuVoIPUserName = fStringMap.getString("onuPotsUniCfgOnuVoIPUserName") + ": ";
    private final String onuPotsUniCfgOnuVoIPPassword = fStringMap.getString("onuPotsUniCfgOnuVoIPPassword") + ": ";
    private final String onuPotsUniCfgOnuVoIPServiceProfileName = fStringMap.getString("onuPotsUniCfgOnuVoIPServiceProfileName") + ": ";
    //private final String onuPotsUniCfgHookState = fStringMap.getString("onuPotsUniCfgHookState") + ": ";

    private BBS4000NE ne = null;

    public GponOnuPotsUniCfgPanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        setModel(new GponOnuPotsUniCfgMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgSlotNo));
        baseInfoPanel.add(tfOnuPotsUniCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgPortNo));
        baseInfoPanel.add(tfOnuPotsUniCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuPotsUniCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgPhysicalPortNo));
        baseInfoPanel.add(tfOnuPotsUniCfgPhysicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgAdministrativeState));
        tfOnuPotsUniCfgAdministrativeState.setName(fStringMap.getString("onuPotsUniCfgAdministrativeState"));
        baseInfoPanel.add(tfOnuPotsUniCfgAdministrativeState);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuPotsUniCfgOperationalState));
        //baseInfoPanel.add(tfOnuPotsUniCfgOperationalState);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgOnuVoIPUserName));
        tfOnuPotsUniCfgOnuVoIPUserName.setName(fStringMap.getString("onuPotsUniCfgOnuVoIPUserName"));
        baseInfoPanel.add(tfOnuPotsUniCfgOnuVoIPUserName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgOnuVoIPPassword));
        tfOnuPotsUniCfgOnuVoIPPassword.setName(fStringMap.getString("onuPotsUniCfgOnuVoIPPassword"));
        baseInfoPanel.add(tfOnuPotsUniCfgOnuVoIPPassword);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPotsUniCfgOnuVoIPServiceProfileName));
        tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.setName(fStringMap.getString("onuPotsUniCfgOnuVoIPServiceProfileName"));
        tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.setProfile("GponOnuVoipSvcProTable_Panel");
        baseInfoPanel.add(tfOnuPotsUniCfgOnuVoIPServiceProfileIndex);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuPotsUniCfgHookState));
        //baseInfoPanel.add(tfOnuPotsUniCfgHookState);
        //baseInfoPanel.add(new HSpacer());

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
        tfOnuPotsUniCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuPotsUniCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuPotsUniCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                tfOnuPotsUniCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuPotsUniCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuPotsUniCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuPotsUniCfgLogicalPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
            tfOnuPotsUniCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //Virtual Port
        tfOnuPotsUniCfgPhysicalPortNo.removeAllItems();
        for (int i = 1; i <= 40; i++) {
            tfOnuPotsUniCfgPhysicalPortNo.addItem(fStringMap.getString("VP") + " " + i);
        }
        //-------------------

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuPotsUniCfgSlotNo.setEnabled(true);
            tfOnuPotsUniCfgPortNo.setEnabled(true);
            tfOnuPotsUniCfgLogicalPortNo.setEnabled(true);
            tfOnuPotsUniCfgPhysicalPortNo.setEnabled(true);

            tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.refresh();
            tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.setSelectedProfileIndex(1);

            return;
        } else {
            tfOnuPotsUniCfgSlotNo.setEnabled(false);
            tfOnuPotsUniCfgPortNo.setEnabled(false);
            tfOnuPotsUniCfgLogicalPortNo.setEnabled(false);
            tfOnuPotsUniCfgPhysicalPortNo.setEnabled(false);
        }

        GponOnuPotsUniCfgMBean mbean = (GponOnuPotsUniCfgMBean) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfOnuPotsUniCfgSlotNo.setSelectedItem((mbean.getOnuPotsUniCfgSlotNo() != null) ? mbean.getOnuPotsUniCfgSlotNo().toString() : "");
        tfOnuPotsUniCfgPortNo.setSelectedItem((mbean.getOnuPotsUniCfgPortNo() != null) ? mbean.getOnuPotsUniCfgPortNo().toString() : "");
        tfOnuPotsUniCfgLogicalPortNo.setSelectedItem((mbean.getOnuPotsUniCfgLogicalPortNo() != null) ? mbean.getOnuPotsUniCfgLogicalPortNo().toString() : "");
        tfOnuPotsUniCfgPhysicalPortNo.setSelectedItem((mbean.getOnuPotsUniCfgPhysicalPortNo() != null) ? mbean.getOnuPotsUniCfgPhysicalPortNo().toString() : "");

        tfOnuPotsUniCfgAdministrativeState.setEnabled(mbean.getOnuPotsUniCfgAdministrativeState() != null);
        tfOnuPotsUniCfgAdministrativeState.setSelectedIndex(getIndexFromValue(onuPotsUniCfgAdministrativeStateVList, mbean.getOnuPotsUniCfgAdministrativeState() != null ? mbean.getOnuPotsUniCfgAdministrativeState() : -1));

        //tfOnuPotsUniCfgOperationalState.setSelectedIndex(getIndexFromValue(onuPotsUniCfgOperationalStateVList, mbean.getOnuPotsUniCfgOperationalState() != null ? mbean.getOnuPotsUniCfgOperationalState() : -1));

        tfOnuPotsUniCfgOnuVoIPUserName.setEnabled(mbean.getOnuPotsUniCfgOnuVoIPUserName() != null);
        tfOnuPotsUniCfgOnuVoIPUserName.setValue(mbean.getOnuPotsUniCfgOnuVoIPUserName() != null ? mbean.getOnuPotsUniCfgOnuVoIPUserName() : "voip");

        tfOnuPotsUniCfgOnuVoIPPassword.setEnabled(mbean.getOnuPotsUniCfgOnuVoIPPassword() != null);
        tfOnuPotsUniCfgOnuVoIPPassword.setValue(mbean.getOnuPotsUniCfgOnuVoIPPassword() != null ? mbean.getOnuPotsUniCfgOnuVoIPPassword() : "voip");

        tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.refresh();
        tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.setEnabled(mbean.getOnuPotsUniCfgOnuVoIPServiceProfileIndex() != null);
        tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.setSelectedProfileIndex(mbean.getOnuPotsUniCfgOnuVoIPServiceProfileIndex());

        //tfOnuPotsUniCfgHookState.setSelectedIndex(getIndexFromValue(onuPotsUniCfgHookStateVList, mbean.getOnuPotsUniCfgHookState() != null ? mbean.getOnuPotsUniCfgHookState() : -1));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuPotsUniCfgMBean(fApplication.getSnmpProxy()));

        GponOnuPotsUniCfgMBean mbean = (GponOnuPotsUniCfgMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOnuPotsUniCfgSlotNo(getSelectedSlotId());
            mbean.setOnuPotsUniCfgPortNo(getSelectedPortId());
            mbean.setOnuPotsUniCfgLogicalPortNo(getSelectedOnuId());
            mbean.setOnuPotsUniCfgPhysicalPortNo(getSelectedVpId());
        }

        if (tfOnuPotsUniCfgAdministrativeState.isEnabled())
            mbean.setOnuPotsUniCfgAdministrativeState(onuPotsUniCfgAdministrativeStateVList[tfOnuPotsUniCfgAdministrativeState.getSelectedIndex()]);

        if (tfOnuPotsUniCfgOnuVoIPUserName.isEnabled())
            mbean.setOnuPotsUniCfgOnuVoIPUserName(tfOnuPotsUniCfgOnuVoIPUserName.getValue());

        if (tfOnuPotsUniCfgOnuVoIPPassword.isEnabled())
            mbean.setOnuPotsUniCfgOnuVoIPPassword(tfOnuPotsUniCfgOnuVoIPPassword.getValue());

        if (tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.isEnabled())
            mbean.setOnuPotsUniCfgOnuVoIPServiceProfileIndex(tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuPotsUniCfgOnuVoIPServiceProfileIndex.getSelectedProfileIndex() : 1);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuPotsUniCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuPotsUniCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuPotsUniCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuPotsUniCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuPotsUniCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuPotsUniCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedVpId() {
        if (tfOnuPotsUniCfgPhysicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuPotsUniCfgPhysicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}