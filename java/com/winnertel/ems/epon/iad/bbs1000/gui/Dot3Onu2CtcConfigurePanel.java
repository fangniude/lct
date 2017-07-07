package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcConfigure;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2CtcConfigurePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcAdminVList = new int[]{1, 2};
    private String[] utsDot3Onu2CtcAdminTList = new String[]{
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfUtsDot3Onu2CtcAdmin = new JComboBox(utsDot3Onu2CtcAdminTList);

    private int[] utsDot3Onu2CtcFECModeVList = new int[]{2, 3,};
    private String[] utsDot3Onu2CtcFECModeTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsDot3Onu2CtcFECMode = new JComboBox(utsDot3Onu2CtcFECModeTList);

    /**
     * NE problem, can not change it's value by SNMP, remove it.
     * private int[] utsDot3Onu2CtcMCastControlTypeVList = new int[]{
     * 0, 1, 2,  };
     * private String[] utsDot3Onu2CtcMCastControlTypeTList = new String[]{
     * fStringMap.getString("gda-mac-sa-mac"),
     * fStringMap.getString("gda-mac-mvlan"),
     * fStringMap.getString("gda-mac-only"),
     * };
     * private JComboBox tfUtsDot3Onu2CtcMCastControlType = new JComboBox(utsDot3Onu2CtcMCastControlTypeTList);
     */

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning")
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    //private IntegerTextField tfUtsDot3Onu2CtcFDBAgingTime = new IntegerTextField();

    //private IntegerTextField tfUsDot3Onu2CtcPVid = new IntegerTextField();

    //private JCheckBox tfMaxMacEnable = new JCheckBox("");
    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();

    //private int[] lockVList = new int[]{1, 2};
    //private String[] lockTList = new String[]{fStringMap.getString("locked"), fStringMap.getString("unlocked")};
    //private JComboBox tfUtsDot3Onu2CtcVoIPPortLock = new JComboBox(lockTList);
    //private JComboBox tfUtsDot3Onu2CtcE1PortLock = new JComboBox(lockTList);

    private final String utsDot3Onu2CtcModuleId = fStringMap.getString("utsDot3Onu2CtcModuleId") + ": ";
    //private final String utsDot3Onu2CtcDeviceId = fStringMap.getString("utsDot3Onu2CtcDeviceId") + ": ";
    private final String utsDot3Onu2CtcPortId = fStringMap.getString("utsDot3Onu2CtcPortId") + ": ";
    private final String utsDot3Onu2CtcLogicalPortId = fStringMap.getString("utsDot3Onu2CtcLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcAdmin = fStringMap.getString("utsDot3Onu2CtcAdmin") + ": ";
    private final String utsDot3Onu2CtcFECMode = fStringMap.getString("utsDot3Onu2CtcFECMode") + ": ";
    //private final String utsDot3Onu2CtcMulticastSwitch = fStringMap.getString("utsDot3Onu2CtcMulticastSwitch") + ": ";
    //private final String utsDot3Onu2CtcMCastControlType = fStringMap.getString("utsDot3Onu2CtcMCastControlType") + ": ";
    private final String utsDot3Onu2CtcEncryptTraffic = fStringMap.getString("utsDot3Onu2CtcEncryptTraffic") + ": ";
    //private final String utsDot3Onu2CtcFDBAgingTime = fStringMap.getString("utsDot3Onu2CtcFDBAgingTime") + ": ";
    //private final String utsDot3Onu2CtcPVid = fStringMap.getString("utsDot3Onu2CtcPVid") + ": ";
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress") + ": ";
    //private final String utsDot3Onu2CtcVoIPPortLock = fStringMap.getString("utsDot3Onu2CtcVoIPPortLock") + ": ";
    //private final String utsDot3Onu2CtcE1PortLock = fStringMap.getString("utsDot3Onu2CtcE1PortLock") + ": ";

    public Dot3Onu2CtcConfigurePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcDeviceId));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAdmin));
        tfUtsDot3Onu2CtcAdmin.setName(fStringMap.getString("utsDot3Onu2CtcAdmin"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAdmin);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFECMode));
        tfUtsDot3Onu2CtcFECMode.setName(fStringMap.getString("utsDot3Onu2CtcFECMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcFECMode);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMCastControlType));
        //tfUtsDot3Onu2CtcMCastControlType.setName(fStringMap.getString("utsDot3Onu2CtcMCastControlType"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcMCastControlType);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcEncryptTraffic));
        tfUtsDot3Onu2CtcEncryptTraffic.setName(fStringMap.getString("utsDot3Onu2CtcEncryptTraffic"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcEncryptTraffic);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcFDBAgingTime));
        //tfUtsDot3Onu2CtcFDBAgingTime.setName(fStringMap.getString("utsDot3Onu2CtcFDBAgingTime"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcFDBAgingTime);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPVid));
        //tfUsDot3Onu2CtcPVid.setName(fStringMap.getString("utsDot3Onu2CtcPVid"));
        //baseInfoPanel.add(tfUsDot3Onu2CtcPVid);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMaxMacAddress));
        tfUtsDot3Onu2CtcMaxMacAddress.setName(fStringMap.getString("utsDot3Onu2CtcMaxMacAddress"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMaxMacAddress);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcVoIPPortLock));
        //tfUtsDot3Onu2CtcVoIPPortLock.setName(fStringMap.getString("utsDot3Onu2CtcVoIPPortLock"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcVoIPPortLock);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcE1PortLock));
        //tfUtsDot3Onu2CtcE1PortLock.setName(fStringMap.getString("utsDot3Onu2CtcE1PortLock"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcE1PortLock);
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
        //tfUtsDot3Onu2CtcFDBAgingTime.setValueScope(0, 1048);
        //tfUsDot3Onu2CtcPVid.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 1022);
    }

    public void refresh() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();

        tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
        //tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
        tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
        tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());
        tfUtsDot3Onu2CtcAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAdminVList, mbean.getUtsDot3Onu2CtcAdmin()));
        tfUtsDot3Onu2CtcFECMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFECModeVList, mbean.getUtsDot3Onu2CtcFECMode()));
        //tfUtsDot3Onu2CtcMCastControlType.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMCastControlTypeVList, mbean.getUtsDot3Onu2CtcMCastControlType()));
        tfUtsDot3Onu2CtcEncryptTraffic.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcEncryptTrafficVList, mbean.getUtsDot3Onu2CtcEncryptTraffic()));
        //tfUtsDot3Onu2CtcFDBAgingTime.setValue(mbean.getUtsDot3Onu2CtcFDBAgingTime());
        //tfUsDot3Onu2CtcPVid.setValue(mbean.getUtsDot3Onu2CtcPVid());

        boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin() == 1;
        tfUtsDot3Onu2CtcFECMode.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcEncryptTraffic.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcFDBAgingTime.setEnabled(adminStatusUpOrNot);
        //tfUsDot3Onu2CtcPVid.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());

        //tfUtsDot3Onu2CtcVoIPPortLock.setSelectedIndex(getIndexFromValue(lockVList, mbean.getUtsDot3Onu2CtcVoIPPortLock()));
        //tfUtsDot3Onu2CtcE1PortLock.setSelectedIndex(getIndexFromValue(lockVList, mbean.getUtsDot3Onu2CtcE1PortLock()));
    }

    public boolean validateFrom() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();

        //added by Zhou Chao, 2008/12/9
        if (mbean.getUtsDot3Onu2CtcAdmin() != utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]) {
            if (mbean.getUtsDot3Onu2CtcAdmin() == 1) {
                if (MessageDialog.showConfirmDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_disable_port")) != JOptionPane.OK_OPTION)
                    return false;
            }
        }

        return true;
    }

    public void updateModel() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();

        if (mbean.getUtsDot3Onu2CtcAdmin() != utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcAdmin(utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]);
            return; //added by Zhou Chao, 2009/5/27 (for NMS00066934)
        }

        if (mbean.getUtsDot3Onu2CtcFECMode() != utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcFECMode(utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]);
        }

        //mbean.setUtsDot3Onu2CtcMCastControlType(utsDot3Onu2CtcMCastControlTypeVList[tfUtsDot3Onu2CtcMCastControlType.getSelectedIndex()]);
        if (mbean.getUtsDot3Onu2CtcEncryptTraffic() != utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcEncryptTraffic(utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]);
        }

        //if (mbean.getUtsDot3Onu2CtcFDBAgingTime() != tfUtsDot3Onu2CtcFDBAgingTime.getValue()) {
        //  mbean.setUtsDot3Onu2CtcFDBAgingTime(tfUtsDot3Onu2CtcFDBAgingTime.getValue());
        //}

        //if (mbean.getUtsDot3Onu2CtcPVid() != tfUsDot3Onu2CtcPVid.getValue()) {
        //  mbean.setUtsDot3Onu2CtcPVid(tfUsDot3Onu2CtcPVid.getValue());
        //}

        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());
        //mbean.setUtsDot3Onu2CtcVoIPPortLock(lockVList[tfUtsDot3Onu2CtcVoIPPortLock.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2CtcE1PortLock(lockVList[tfUtsDot3Onu2CtcE1PortLock.getSelectedIndex()]);
    }

    public void afterUpdateModel() {
        refresh();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}