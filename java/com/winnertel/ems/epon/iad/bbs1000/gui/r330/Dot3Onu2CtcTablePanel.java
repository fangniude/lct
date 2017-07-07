/**
 * Created by Zhou Chao, 2008/12/10
 */

package com.winnertel.ems.epon.iad.bbs1000.gui.r330;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2CtcTablePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcAdminVList = new int[]{1, 2,};
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

    /*
    private int[] utsDot3Onu2CtcMulticastSwitchVList = new int[]{1, 2, 3,};
    private String[] utsDot3Onu2CtcMulticastSwitchTList = new String[]{
            fStringMap.getString("special-snooping"),
            fStringMap.getString("control-snooping"),
            fStringMap.getString("standard-snooping"),
    };
    private JComboBox tfUtsDot3Onu2CtcMulticastSwitch = new JComboBox(utsDot3Onu2CtcMulticastSwitchTList);
    */

    /*
    // NE problem, can not change it's value by SNMP, remove it.
    private int[] utsDot3Onu2CtcMCastControlTypeVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcMCastControlTypeTList = new String[]{
            fStringMap.getString("gda-mac-sa-mac"),
            fStringMap.getString("gda-mac-mvlan"),
            fStringMap.getString("gda-mac-only"),
    };
    private JComboBox tfUtsDot3Onu2CtcMCastControlType = new JComboBox(utsDot3Onu2CtcMCastControlTypeTList);
    */

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning")
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    //private IntegerTextField tfUtsDot3Onu2CtcFDBAgingTime = new IntegerTextField();
    //private IntegerTextField tfUtsDot3Onu2CtcPVid = new IntegerTextField();

    //private JCheckBox tfMaxMacEnable = new JCheckBox("");

    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();

    //private int[] lockVList = new int[]{1, 2};
    //private String[] lockTList = new String[]{fStringMap.getString("locked"), fStringMap.getString("unlocked")};
    //private JComboBox tfUtsDot3Onu2CtcVoIPPortLock = new JComboBox(lockTList);
    //private JComboBox tfUtsDot3Onu2CtcE1PortLock = new JComboBox(lockTList);

//    private int[] utsDot3Onu2SNumberValidVList = new int[]{1, 2,};
//    private String[] utsDot3Onu2SNumberValidTList = new String[]{
//            fStringMap.getString("invalid"), //1
//            fStringMap.getString("valid"), //2
//    };
//    private JComboBox tfUtsDot3Onu2SNumberValid = new JComboBox(utsDot3Onu2SNumberValidTList);
//
//    private StringTextField tfUtsDot3Onu2SNumberForService = new StringTextField();

    private StringTextField tfUtsDot3Onu2dot1xUserName = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xPassword = new StringTextField();

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
    //private final String utsDot3Onu2CtcPVid = fStringMap.getString( "utsDot3Onu2CtcPVid" ) + ": ";
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress") + ": ";
    //private final String utsDot3Onu2CtcVoIPPortLock = fStringMap.getString("utsDot3Onu2CtcVoIPPortLock") + ": ";
    //private final String utsDot3Onu2CtcE1PortLock = fStringMap.getString("utsDot3Onu2CtcE1PortLock") + ": ";
    private final String utsDot3Onu2SNumberValid = fStringMap.getString("utsDot3Onu2SNumberValid") + ": ";
    private final String utsDot3Onu2SNumberForService = fStringMap.getString("utsDot3Onu2SNumberForService") + ": ";
    private final String utsDot3Onu2dot1xUserName = fStringMap.getString("utsDot3Onu2dot1xUserName") + ": ";
    private final String utsDot3Onu2dot1xPassword = fStringMap.getString("utsDot3Onu2dot1xPassword") + ": ";

    private int oldAdminStatus = 0;

    public Dot3Onu2CtcTablePanel(IApplication app) {
        super(app);
        setModel(new Dot3Onu2CtcTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        /*
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMulticastSwitch));
        tfUtsDot3Onu2CtcMulticastSwitch.setName(fStringMap.getString("utsDot3Onu2CtcMulticastSwitch"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMulticastSwitch);
        baseInfoPanel.add(new HSpacer());
        */

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
        //tfUtsDot3Onu2CtcPVid.setName(fStringMap.getString("utsDot3Onu2CtcPVid"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcPVid);
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

//        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberValid));
//        tfUtsDot3Onu2SNumberValid.setName(fStringMap.getString("utsDot3Onu2SNumberValid"));
//        baseInfoPanel.add(tfUtsDot3Onu2SNumberValid);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberForService));
//        tfUtsDot3Onu2SNumberForService.setName(fStringMap.getString("utsDot3Onu2SNumberForService"));
//        baseInfoPanel.add(tfUtsDot3Onu2SNumberForService);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2dot1xUserName));
        tfUtsDot3Onu2dot1xUserName.setName(fStringMap.getString("utsDot3Onu2dot1xUserName"));
        baseInfoPanel.add(tfUtsDot3Onu2dot1xUserName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2dot1xPassword));
        tfUtsDot3Onu2dot1xPassword.setName(fStringMap.getString("utsDot3Onu2dot1xPassword"));
        baseInfoPanel.add(tfUtsDot3Onu2dot1xPassword);
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
        //tfUtsDot3Onu2CtcFDBAgingTime.setValueScope(0, 1048);
        //tfUtsDot3Onu2CtcPVid.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 100);

//        tfUtsDot3Onu2SNumberValid.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                tfUtsDot3Onu2SNumberForService.setEnabled(!(tfUtsDot3Onu2SNumberValid.getSelectedIndex() == 0));
//            }
//        });
    }

    public boolean validateFrom() {
//        if (tfUtsDot3Onu2SNumberForService.isEnabled() && tfUtsDot3Onu2SNumberForService.getValue().trim().equals("")) {
//            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_SN_Number_Is_Null"));
//            return false;
//        }
//
//        Dot3Onu2CtcTable currentOject = (Dot3Onu2CtcTable) getModel();
//        if (tfUtsDot3Onu2SNumberForService.isEnabled()) {
//            int moduleId = currentOject.getUtsDot3Onu2CtcModuleId();
//            int portId = currentOject.getUtsDot3Onu2CtcPortId();
//            String SN = tfUtsDot3Onu2SNumberForService.getText();
//            int logicalPortId = currentOject.getUtsDot3Onu2CtcLogicalPortId();
//            Dot3Onu2CtcTable bean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
//            Vector beans = BeanService.refreshTableBean(fApplication, bean);
//            for (int i = 0; i < beans.size(); i++) {
//                Dot3Onu2CtcTable b = (Dot3Onu2CtcTable) beans.get(i);
//                if (b.getUtsDot3Onu2SNumberValid() != 1) {
//                    if (b.getUtsDot3Onu2CtcModuleId() == moduleId && b.getUtsDot3Onu2CtcPortId() == portId) {
//                        if (b.getUtsDot3Onu2CtcLogicalPortId() != logicalPortId && b.getUtsDot3Onu2SNumberForService().equals(SN)) {
//                            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Same_SN_Number"));
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//
//        Dot3Onu2CtcValidOnuMacTable onuMac = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
//        onuMac.setUtsDot3OnuValidOnuMacModuleId(currentOject.getUtsDot3Onu2CtcModuleId());
//        onuMac.setUtsDot3OnuValidOnuMacDeviceId(1);
//        onuMac.setUtsDot3OnuValidOnuMacPortId(currentOject.getUtsDot3Onu2CtcPortId());
//        onuMac.setUtsDot3OnuValidOnuMacAppLPortId(currentOject.getUtsDot3Onu2CtcLogicalPortId());
//
//        BeanService.refreshBean(fApplication, onuMac);
//
//        if (onuMac.getUtsDot3ValidOnuMacAddr() != null && !ConfigUtility.OctetToMacAddress(onuMac.getUtsDot3ValidOnuMacAddr()).equals("00-00-00-00-00-00") && tfUtsDot3Onu2SNumberForService.isEnabled()) {
//            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_ONU_MAC_Was_Bound"));
//            return false;
//        }

        return true;
    }

    public void refresh() {
        Dot3Onu2CtcTable mbean = (Dot3Onu2CtcTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
        //tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
        tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
        tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());

        tfUtsDot3Onu2CtcAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAdminVList, mbean.getUtsDot3Onu2CtcAdmin()));
        //tfUtsDot3Onu2CtcMCastControlType.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMCastControlTypeVList, mbean.getUtsDot3Onu2CtcMCastControlType()));
        oldAdminStatus = mbean.getUtsDot3Onu2CtcAdmin();
        boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin() == 1;
        tfUtsDot3Onu2CtcFECMode.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcFECMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFECModeVList, mbean.getUtsDot3Onu2CtcFECMode()));
        //tfUtsDot3Onu2CtcMulticastSwitch.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcMulticastSwitch.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMulticastSwitchVList, mbean.getUtsDot3Onu2CtcMulticastSwitch()));
        tfUtsDot3Onu2CtcEncryptTraffic.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcEncryptTraffic.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcEncryptTrafficVList, mbean.getUtsDot3Onu2CtcEncryptTraffic()));
        //tfUtsDot3Onu2CtcFDBAgingTime.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcFDBAgingTime.setValue(mbean.getUtsDot3Onu2CtcFDBAgingTime());
        //tfUtsDot3Onu2CtcPVid.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcPVid.setValue(mbean.getUtsDot3Onu2CtcPVid());
        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());
        //tfUtsDot3Onu2CtcVoIPPortLock.setSelectedIndex(getIndexFromValue(lockVList, mbean.getUtsDot3Onu2CtcVoIPPortLock()));
        //tfUtsDot3Onu2CtcE1PortLock.setSelectedIndex(getIndexFromValue(lockVList, mbean.getUtsDot3Onu2CtcE1PortLock()));
//        tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, mbean.getUtsDot3Onu2SNumberValid() != null ? mbean.getUtsDot3Onu2SNumberValid() : 1));
//        tfUtsDot3Onu2SNumberForService.setText(mbean.getUtsDot3Onu2SNumberForService() != null ? mbean.getUtsDot3Onu2SNumberForService() : "");
        tfUtsDot3Onu2dot1xUserName.setText(mbean.getUtsDot3Onu2dot1xUserName() != null ? mbean.getUtsDot3Onu2dot1xUserName() : "");
        tfUtsDot3Onu2dot1xPassword.setText(mbean.getUtsDot3Onu2dot1xPassword() != null ? mbean.getUtsDot3Onu2dot1xPassword() : "");
    }

    public void updateModel() {
        Dot3Onu2CtcTable mbean = (Dot3Onu2CtcTable) getModel();
        if (mbean == null)
            return;

        int newAdminStatus = utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()];
        if (oldAdminStatus != newAdminStatus) {
            mbean.setUtsDot3Onu2CtcAdmin(newAdminStatus);
            return; //added by Zhou Chao, 2009/5/27 (for NMS00066934)
        }

        if (mbean.getUtsDot3Onu2CtcFECMode() != utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]) { //added by Zhou Chao, 2009/4/3 (for NMS00066057)
            if (MessageDialog.showConfirmDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Msg_cfm_set_fecmode")) != JOptionPane.OK_OPTION)
                return;
            mbean.setUtsDot3Onu2CtcFECMode(utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]);
        }
        //mbean.setUtsDot3Onu2CtcMulticastSwitch(utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2CtcMCastControlType(utsDot3Onu2CtcMCastControlTypeVList[tfUtsDot3Onu2CtcMCastControlType.getSelectedIndex()]);
        if (mbean.getUtsDot3Onu2CtcEncryptTraffic() != utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcEncryptTraffic(utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]);
        }
        //mbean.setUtsDot3Onu2CtcFDBAgingTime(tfUtsDot3Onu2CtcFDBAgingTime.getValue());
        //mbean.setUtsDot3Onu2CtcPVid(tfUtsDot3Onu2CtcPVid.getValue());
        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());
        //mbean.setUtsDot3Onu2CtcVoIPPortLock(lockVList[tfUtsDot3Onu2CtcVoIPPortLock.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2CtcE1PortLock(lockVList[tfUtsDot3Onu2CtcE1PortLock.getSelectedIndex()]);
//        mbean.setUtsDot3Onu2SNumberValid(utsDot3Onu2SNumberValidVList[tfUtsDot3Onu2SNumberValid.getSelectedIndex()]);
//        if (tfUtsDot3Onu2SNumberForService.isEnabled())
//            mbean.setUtsDot3Onu2SNumberForService(tfUtsDot3Onu2SNumberForService.getText());
        mbean.setUtsDot3Onu2dot1xUserName(tfUtsDot3Onu2dot1xUserName.getText());
        mbean.setUtsDot3Onu2dot1xPassword(tfUtsDot3Onu2dot1xPassword.getText());
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