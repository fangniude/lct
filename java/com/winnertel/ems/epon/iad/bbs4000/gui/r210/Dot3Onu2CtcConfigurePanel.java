package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3Onu2CtcConfigurePanel extends UPanel {

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

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2,};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning"),
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();
    private IntegerTextField tfUsDot3Onu2CtcPVid = new IntegerTextField();

    private int[] ethernetPortAlarmReversionVList = new int[]{1, 2,};
    private String[] ethernetPortAlarmReversionTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3Onu2EthernetPortAlarmReversion = new JComboBox(ethernetPortAlarmReversionTList);

    private IntegerTextField tfUtsDot3Onu2SNumberValid = new IntegerTextField();
    private StringTextField tfUtsDot3Onu2SNumberForService = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xUserName = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xPassword = new StringTextField();
    
    private final String utsDot3Onu2CtcModuleId = fStringMap.getString("utsDot3Onu2CtcModuleId") + ": ";
    //private final String utsDot3Onu2CtcDeviceId = fStringMap.getString("utsDot3Onu2CtcDeviceId") + ": ";
    private final String utsDot3Onu2CtcPortId = fStringMap.getString("utsDot3Onu2CtcPortId") + ": ";
    private final String utsDot3Onu2CtcLogicalPortId = fStringMap.getString("utsDot3Onu2CtcLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcAdmin = fStringMap.getString("utsDot3Onu2CtcAdmin") + ": ";
    private final String utsDot3Onu2CtcFECMode = fStringMap.getString("utsDot3Onu2CtcFECMode") + ": ";
    private final String utsDot3Onu2CtcEncryptTraffic = fStringMap.getString("utsDot3Onu2CtcEncryptTraffic") + ": ";
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress") + ": ";
    private final String utsDot3Onu2CtcPVid = fStringMap.getString("utsDot3Onu2CtcPVid") + ": ";
    private final String utsDot3Onu2EthernetPortAlarmReversion = fStringMap.getString("utsDot3Onu2EthernetPortAlarmReversion") + ": ";

    private final String utsDot3Onu2SNumberValid = fStringMap.getString("utsDot3Onu2SNumberValid")+ " : ";
    private final String utsDot3Onu2SNumberForService = fStringMap.getString("utsDot3Onu2SNumberForService")+ " : ";
    private final String utsDot3Onu2dot1xUserName = fStringMap.getString("utsDot3Onu2dot1xUserName")+ " : ";
    private final String utsDot3Onu2dot1xPassword = fStringMap.getString("utsDot3Onu2dot1xPassword")+ " : ";
    
    public Dot3Onu2CtcConfigurePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcEncryptTraffic));
        tfUtsDot3Onu2CtcEncryptTraffic.setName(fStringMap.getString("utsDot3Onu2CtcEncryptTraffic"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcEncryptTraffic);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMaxMacAddress));
        tfUtsDot3Onu2CtcMaxMacAddress.setName(fStringMap.getString("utsDot3Onu2CtcMaxMacAddress"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMaxMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPVid));
        tfUsDot3Onu2CtcPVid.setName(fStringMap.getString("utsDot3Onu2CtcPVid"));
        baseInfoPanel.add(tfUsDot3Onu2CtcPVid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2EthernetPortAlarmReversion));
        tfUtsDot3Onu2EthernetPortAlarmReversion.setName(fStringMap.getString("utsDot3Onu2EthernetPortAlarmReversion"));
        baseInfoPanel.add(tfUtsDot3Onu2EthernetPortAlarmReversion);
        baseInfoPanel.add(new HSpacer());
        /////
        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberValid));
        tfUtsDot3Onu2SNumberValid.setName(fStringMap.getString("utsDot3Onu2SNumberValid"));
        baseInfoPanel.add(tfUtsDot3Onu2SNumberValid);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberForService));
        tfUtsDot3Onu2SNumberForService.setName(fStringMap.getString("utsDot3Onu2SNumberForService"));
        baseInfoPanel.add(tfUtsDot3Onu2SNumberForService);
        baseInfoPanel.add(new HSpacer());
        
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
        tfUsDot3Onu2CtcPVid.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 100); //modified by Zhou Chao, 2008/8/25
    }

    public void refresh() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();

        tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
        //tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
        tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
        tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());
        //tfUtsDot3Onu2CtcAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAdminVList, mbean.getUtsDot3Onu2CtcAdmin()));
        tfUtsDot3Onu2CtcFECMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFECModeVList, mbean.getUtsDot3Onu2CtcFECMode()));
        //tfUtsDot3Onu2CtcMulticastSwitch.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMulticastSwitchVList, mbean.getUtsDot3Onu2CtcMulticastSwitch()));
        //tfUtsDot3Onu2CtcMCastControlType.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcMCastControlTypeVList, mbean.getUtsDot3Onu2CtcMCastControlType()));
        tfUtsDot3Onu2CtcEncryptTraffic.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcEncryptTrafficVList, mbean.getUtsDot3Onu2CtcEncryptTraffic()));
        //tfUtsDot3Onu2CtcFDBAgingTime.setValue(mbean.getUtsDot3Onu2CtcFDBAgingTime());
        //tfUsDot3Onu2CtcPVid.setValue(mbean.getUtsDot3Onu2CtcPVid());

        boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin() == 1;
        tfUtsDot3Onu2CtcFECMode.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcMulticastSwitch.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcEncryptTraffic.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2CtcFDBAgingTime.setEnabled(adminStatusUpOrNot);
        //tfUsDot3Onu2CtcPVid.setEnabled(adminStatusUpOrNot);
        tfUsDot3Onu2CtcPVid.setValue(mbean.getUtsDot3Onu2CtcPVid());
        tfUsDot3Onu2CtcPVid.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());
        tfUtsDot3Onu2EthernetPortAlarmReversion.setSelectedIndex(getIndexFromValue(ethernetPortAlarmReversionVList, mbean.getUtsDot3Onu2EthernetPortAlarmReversion()));
        tfUtsDot3Onu2SNumberValid.setValue(mbean.getUtsDot3Onu2SNumberValid());
        tfUtsDot3Onu2SNumberForService.setValue(mbean.getUtsDot3Onu2SNumberForService());
        tfUtsDot3Onu2dot1xUserName.setValue(mbean.getUtsDot3Onu2dot1xUserName());
        tfUtsDot3Onu2dot1xPassword.setValue(mbean.getUtsDot3Onu2dot1xUserName());
    
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
        }

        if (mbean.getUtsDot3Onu2CtcFECMode() != utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcFECMode(utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]);
        }

        //if (mbean.getUtsDot3Onu2CtcMulticastSwitch() != utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch.getSelectedIndex()]) {
        //    mbean.setUtsDot3Onu2CtcMulticastSwitch(utsDot3Onu2CtcMulticastSwitchVList[tfUtsDot3Onu2CtcMulticastSwitch.getSelectedIndex()]);
        //}

        //mbean.setUtsDot3Onu2CtcMCastControlType(utsDot3Onu2CtcMCastControlTypeVList[tfUtsDot3Onu2CtcMCastControlType.getSelectedIndex()]);

        if (mbean.getUtsDot3Onu2CtcEncryptTraffic() != utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcEncryptTraffic(utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]);
        }

        //if (mbean.getUtsDot3Onu2CtcFDBAgingTime() != tfUtsDot3Onu2CtcFDBAgingTime.getValue()) {
        //  mbean.setUtsDot3Onu2CtcFDBAgingTime(tfUtsDot3Onu2CtcFDBAgingTime.getValue());
        //}

        if (mbean.getUtsDot3Onu2CtcPVid() != tfUsDot3Onu2CtcPVid.getValue()) {
            mbean.setUtsDot3Onu2CtcPVid(tfUsDot3Onu2CtcPVid.getValue());
        }

        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());
        //mbean.setUtsDot3Onu2CtcVoIPPortLock(tfUtsDot3Onu2CtcVoIPPortLock.getValue());
        //mbean.setUtsDot3Onu2CtcE1PortLock(tfUtsDot3Onu2CtcE1PortLock.getValue());
        //mbean.setUtsDot3Onu2FastLeaveAdminControl(fastLeaveVList[tfUtsDot3Onu2FastLeaveAdminControl.getSelectedIndex()]);
        mbean.setUtsDot3Onu2EthernetPortAlarmReversion(ethernetPortAlarmReversionVList[tfUtsDot3Onu2EthernetPortAlarmReversion.getSelectedIndex()]); //added by Zhou Chao, 2008/8/4
        //mbean.setUtsDot3Onu2MulticastFilter(multicastFilterVList[tfUtsDot3Onu2MulticastFilter.getSelectedIndex()]); //added by Zhou Chao, 2008/8/4
        mbean.setUtsDot3Onu2SNumberValid(tfUtsDot3Onu2SNumberValid.getValue());
        mbean.setUtsDot3Onu2SNumberForService(tfUtsDot3Onu2SNumberForService.getValue());
        mbean.setUtsDot3Onu2dot1xUserName(tfUtsDot3Onu2dot1xUserName.getValue());
        mbean.setUtsDot3Onu2dot1xPassword(tfUtsDot3Onu2dot1xPassword.getValue());
    
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