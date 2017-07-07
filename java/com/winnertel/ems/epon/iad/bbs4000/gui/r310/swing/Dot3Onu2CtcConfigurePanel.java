package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;


import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2CtcConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dot3Onu2CtcConfigurePanel extends UPanel implements ActionListener {

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

    //private int[] utsDot3Onu2CtcMulticastSwitchVList = new int[]{1, 2, 3,};
    //private String[] utsDot3Onu2CtcMulticastSwitchTList = new String[]{
    //        fStringMap.getString("special-snooping"),
    //        fStringMap.getString("control-snooping"),
    //        fStringMap.getString("standard-snooping"),
    //};
    //private JComboBox tfUtsDot3Onu2CtcMulticastSwitch = new JComboBox(utsDot3Onu2CtcMulticastSwitchTList);

    //// NE problem, can not change it's value by SNMP, remove it.
    //private int[] utsDot3Onu2CtcMCastControlTypeVList = new int[]{0, 1, 2,};
    //private String[] utsDot3Onu2CtcMCastControlTypeTList = new String[]{
    //        fStringMap.getString("gda-mac-sa-mac"),
    //        fStringMap.getString("gda-mac-mvlan"),
    //        fStringMap.getString("gda-mac-only"),
    //};
    //private JComboBox tfUtsDot3Onu2CtcMCastControlType = new JComboBox(utsDot3Onu2CtcMCastControlTypeTList);

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2, /*3, 4*/};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning"),
            /* fStringMap.getString("aes48"),
             fStringMap.getString("aes32"), */
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    //private IntegerTextField tfUtsDot3Onu2CtcFDBAgingTime = new IntegerTextField();

    //private IntegerTextField tfUsDot3Onu2CtcPVid = new IntegerTextField();

    //private JCheckBox tfMaxMacEnable = new JCheckBox("");
    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();

    //private PortBitMapPanel tfUtsDot3Onu2CtcVoIPPortLock = new PortBitMapPanel(8);
    //private PortBitMapPanel tfUtsDot3Onu2CtcE1PortLock = new PortBitMapPanel(1);

    //private int[] fastLeaveVList = new int[]{1, 2,};
    //private String[] fastLeaveTList = new String[]{
    //        fStringMap.getString("disable"),
    //        fStringMap.getString("enable"),
    //};
    //private JComboBox tfUtsDot3Onu2FastLeaveAdminControl = new JComboBox(fastLeaveTList);

    //private int[] ethernetPortAlarmReversionVList = new int[]{1, 2,};
    //private String[] ethernetPortAlarmReversionTList = new String[]{
    //        fStringMap.getString("disable"),
    //        fStringMap.getString("enable"),
    //};
    //private JComboBox tfUtsDot3Onu2EthernetPortAlarmReversion = new JComboBox(ethernetPortAlarmReversionTList);

    //private int[] multicastFilterVList = new int[]{1, 2,};
    //private String[] multicastFilterTList = new String[]{
    //        fStringMap.getString("disable"),
    //        fStringMap.getString("enable"),
    //};
    //private JComboBox tfUtsDot3Onu2MulticastFilter = new JComboBox(multicastFilterTList);

    //private int[] flexQinQSwitchVList = new int[]{1, 2,};
    //private String[] flexQinQSwitchTList = new String[]{
    //        fStringMap.getString("disable"),
    //        fStringMap.getString("enable"),
    //};
    //private JComboBox tfUtsDot3Onu2FlexQinQSwitch = new JComboBox(flexQinQSwitchTList);

//    private int[] utsDot3Onu2SNumberValidVList = new int[]{1, 2,};
//    private String[] utsDot3Onu2SNumberValidTList = new String[]{
//            fStringMap.getString("invalid"),
//            fStringMap.getString("valid"),
//    };
//    private JComboBox tfUtsDot3Onu2SNumberValid = new JComboBox(utsDot3Onu2SNumberValidTList);
//
//    private StringTextField tfUtsDot3Onu2SNumberForService = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xUserName = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xPassword = new StringTextField();

//    private StringTextField tfUtsDot3Onu2LoidAuthLoid = new StringTextField();
//    private StringTextField tfUtsDot3Onu2LoidAuthPassword = new StringTextField();


    private int[] utsDot3OnuCatvSwitchVList = new int[]{1, 2,};
    private String[] utsDot3OnuCatvSwitchTList = new String[]{
            fStringMap.getString("catvOn"),
            fStringMap.getString("catvOff"),
    };
    private JComboBox tfUtsDot3OnuCatvSwitch = new JComboBox(utsDot3OnuCatvSwitchTList);


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
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress");
    //private final String utsDot3Onu2CtcVoIPPortLock = fStringMap.getString("utsDot3Onu2CtcVoIPPortLock");
    //private final String utsDot3Onu2CtcE1PortLock = fStringMap.getString("utsDot3Onu2CtcE1PortLock");
    //private final String utsDot3Onu2FastLeaveAdminControl = fStringMap.getString("utsDot3Onu2FastLeaveAdminControl");
    //private final String utsDot3Onu2EthernetPortAlarmReversion = "utsDot3Onu2EthernetPortAlarmReversion"; //added by Zhou Chao, 2008/8/4
    //private final String utsDot3Onu2MulticastFilter = "utsDot3Onu2MulticastFilter"; //added by Zhou Chao, 2008/8/4
    //private final String utsDot3Onu2FlexQinQSwitch = fStringMap.getString("utsDot3Onu2FlexQinQSwitch") + ": ";
    private final String utsDot3Onu2SNumberValid = fStringMap.getString("utsDot3Onu2SNumberValid") + ": ";
    private final String utsDot3Onu2SNumberForService = fStringMap.getString("utsDot3Onu2SNumberForService") + ": ";
    private final String utsDot3Onu2dot1xUserName = fStringMap.getString("utsDot3Onu2dot1xUserName") + ": ";
    private final String utsDot3Onu2dot1xPassword = fStringMap.getString("utsDot3Onu2dot1xPassword") + ": ";
//    private final String utsDot3Onu2LoidAuthLoid = fStringMap.getString("utsDot3Onu2LoidAuthLoid") + ": ";
//    private final String utsDot3Onu2LoidAuthPassword = fStringMap.getString("utsDot3Onu2LoidAuthPassword") + ": ";
    private final String utsDot3OnuCatvSwitch = fStringMap.getString("utsDot3OnuCatvSwitch") + ": ";

    public Dot3Onu2CtcConfigurePanel(IApplication app) {
        super(app);
        setModel(new Dot3Onu2CtcConfigure(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5); //modified by Zhou Chao, 2008/8/4
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        //baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

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

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMulticastSwitch));
        //tfUtsDot3Onu2CtcMulticastSwitch.setName(fStringMap.getString("utsDot3Onu2CtcMulticastSwitch"));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcMulticastSwitch);
        //baseInfoPanel.add(new HSpacer());

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

        //baseInfoPanel.add(new JLabel(utsDot3Onu2FastLeaveAdminControl));
        //tfUtsDot3Onu2FastLeaveAdminControl.setName(fStringMap.getString("utsDot3Onu2FastLeaveAdminControl"));
        //baseInfoPanel.add(tfUtsDot3Onu2FastLeaveAdminControl);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2EthernetPortAlarmReversion));
        //tfUtsDot3Onu2EthernetPortAlarmReversion.setName(fStringMap.getString("utsDot3Onu2EthernetPortAlarmReversion"));
        //baseInfoPanel.add(tfUtsDot3Onu2EthernetPortAlarmReversion);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2MulticastFilter));
        //tfUtsDot3Onu2MulticastFilter.setName(fStringMap.getString("utsDot3Onu2MulticastFilter"));
        //baseInfoPanel.add(tfUtsDot3Onu2MulticastFilter);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2FlexQinQSwitch));
        //tfUtsDot3Onu2FlexQinQSwitch.setName(fStringMap.getString("utsDot3Onu2FlexQinQSwitch"));
        //baseInfoPanel.add(tfUtsDot3Onu2FlexQinQSwitch);
        //baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberValid));
//        tfUtsDot3Onu2SNumberValid.addActionListener(this);
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

//        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthLoid));
//        tfUtsDot3Onu2LoidAuthLoid.setName(fStringMap.getString("utsDot3Onu2LoidAuthLoid"));
//        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthLoid);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthPassword));
//        tfUtsDot3Onu2LoidAuthPassword.setName(fStringMap.getString("utsDot3Onu2LoidAuthPassword"));
//        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthPassword);
//        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3OnuCatvSwitch));
        tfUtsDot3OnuCatvSwitch.addActionListener(this);
        tfUtsDot3OnuCatvSwitch.setName(fStringMap.getString("utsDot3OnuCatvSwitch"));
        baseInfoPanel.add(tfUtsDot3OnuCatvSwitch);
        baseInfoPanel.add(new HSpacer());


        //tfUtsDot3Onu2CtcE1PortLock.setBorder(BorderFactory.createTitledBorder(utsDot3Onu2CtcE1PortLock));
        //tfUtsDot3Onu2CtcVoIPPortLock.setBorder(BorderFactory.createTitledBorder(utsDot3Onu2CtcVoIPPortLock));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        //allPanel.setBorder(BorderFactory.createEtchedBorder());
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        //allPanel.add(tfUtsDot3Onu2CtcE1PortLock);
        //allPanel.add(tfUtsDot3Onu2CtcVoIPPortLock);

        setLayout(new BorderLayout());
        add(new JScrollPane(allPanel), BorderLayout.CENTER);

        //setPreferredSize(new Dimension(500, 550));
    }

    protected void initForm() {
        //tfUtsDot3Onu2CtcFDBAgingTime.setValueScope(0, 1048);
        //tfUsDot3Onu2CtcPVid.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 64); //modified by Zhou Chao, 2008/8/25
    }

    public boolean validateFrom() {
//        if (tfUtsDot3Onu2SNumberForService.isEnabled() && tfUtsDot3Onu2SNumberForService.getValue().trim().equals("")) {
//            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_SN_Number_Is_Null"));
//            return false;
//        }

    	Dot3Onu2CtcConfigure currentOject = (Dot3Onu2CtcConfigure) getModel();
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
//                        if (b.getUtsDot3Onu2CtcLogicalPortId() != logicalPortId && b.getUtsDot3Onu2SNumberForService().equals(SN))
//                        {
//                            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Same_SN_Number"));
//                            return false;
//                        }
//                    }
//                }
//            }

            //check if the PON port has SN Switch enalbe.
//            Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
//            portBean.setUtsDot3OltModuleId(currentOject.getUtsDot3Onu2CtcModuleId());
//            portBean.setUtsDot3OltDeviceId(1);
//            portBean.setUtsDot3OltPortId(currentOject.getUtsDot3Onu2CtcPortId());
//
//            BeanService.refreshBean(fApplication, portBean);
//            if (portBean.getUtsDot3OltPortONUSNumberSwitch() != null && portBean.getUtsDot3OltPortONUSNumberSwitch() != 2)
//            { //SN Switch is disable.
//                MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Port_SN_Switch_Disable"));
//                return false;
//            }
//        }

        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();
        if ((mbean.getUtsDot3Onu2CtcFECMode() != null) && (mbean.getUtsDot3Onu2CtcFECMode() != utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]))
        {
            int result = MessageDialog.showConfirmDialog(fApplication, fStringMap.getString("Change_FECMOde_ONU_reboot"));
            return result == JOptionPane.OK_OPTION;
        }

        return true;
    }

    public void refresh() {
    	Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcModuleId.setText(mbean.getUtsDot3Onu2CtcModuleId().toString());
        //tfUtsDot3Onu2CtcDeviceId.setText(mbean.getUtsDot3Onu2CtcDeviceId().toString());
        tfUtsDot3Onu2CtcPortId.setText(mbean.getUtsDot3Onu2CtcPortId().toString());
        tfUtsDot3Onu2CtcLogicalPortId.setText(mbean.getUtsDot3Onu2CtcLogicalPortId().toString());
        tfUtsDot3Onu2CtcAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAdminVList, mbean.getUtsDot3Onu2CtcAdmin()));
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

        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());
        //tfUtsDot3Onu2CtcVoIPPortLock.setValue(mbean.getUtsDot3Onu2CtcVoIPPortLock());
        //tfUtsDot3Onu2CtcE1PortLock.setValue(mbean.getUtsDot3Onu2CtcE1PortLock());
        //tfUtsDot3Onu2FastLeaveAdminControl.setSelectedIndex(getIndexFromValue(fastLeaveVList, mbean.getUtsDot3Onu2FastLeaveAdminControl()));
        //tfUtsDot3Onu2EthernetPortAlarmReversion.setSelectedIndex(getIndexFromValue(ethernetPortAlarmReversionVList, mbean.getUtsDot3Onu2EthernetPortAlarmReversion()));
        //tfUtsDot3Onu2MulticastFilter.setSelectedIndex(getIndexFromValue(multicastFilterVList, mbean.getUtsDot3Onu2MulticastFilter()));
        //tfUtsDot3Onu2FlexQinQSwitch.setSelectedIndex(getIndexFromValue(flexQinQSwitchVList, mbean.getUtsDot3Onu2FlexQinQSwitch()));

//        tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, mbean.getUtsDot3Onu2SNumberValid() != null ? mbean.getUtsDot3Onu2SNumberValid() : 1));
//        tfUtsDot3Onu2SNumberForService.setText(mbean.getUtsDot3Onu2SNumberForService() != null ? mbean.getUtsDot3Onu2SNumberForService() : "");
        tfUtsDot3Onu2dot1xUserName.setText(mbean.getUtsDot3Onu2dot1xUserName() != null ? mbean.getUtsDot3Onu2dot1xUserName() : "");
        tfUtsDot3Onu2dot1xPassword.setText(mbean.getUtsDot3Onu2dot1xPassword() != null ? mbean.getUtsDot3Onu2dot1xPassword() : "");

//        tfUtsDot3Onu2LoidAuthLoid.setText(mbean.getUtsDot3Onu2LoidAuthLoid() != null ? mbean.getUtsDot3Onu2LoidAuthLoid() : "");
//        tfUtsDot3Onu2LoidAuthPassword.setText(mbean.getUtsDot3Onu2LoidAuthPassword() != null ? mbean.getUtsDot3Onu2LoidAuthPassword() : "");
        tfUtsDot3OnuCatvSwitch.setSelectedIndex(getIndexFromValue(utsDot3OnuCatvSwitchVList, mbean.getUtsDot3OnuCatvSwitch() != null ? mbean.getUtsDot3OnuCatvSwitch() : 1));
    }

    public void updateModel() {
    	Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();
        if (mbean == null)
            return;

        if (mbean.getUtsDot3Onu2CtcAdmin() != utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcAdmin(utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]);
            return; //added by Zhou Chao, 2009/5/27 (for NMS00066934)
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

        //if ( mbean.getUtsDot3Onu2CtcFDBAgingTime() != tfUtsDot3Onu2CtcFDBAgingTime.getValue() ) {
        //  mbean.setUtsDot3Onu2CtcFDBAgingTime(tfUtsDot3Onu2CtcFDBAgingTime.getValue());
        //}

        //if (mbean.getUtsDot3Onu2CtcPVid() != tfUsDot3Onu2CtcPVid.getValue()) {
        //    mbean.setUtsDot3Onu2CtcPVid(tfUsDot3Onu2CtcPVid.getValue());
        //}

        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());
        //mbean.setUtsDot3Onu2CtcVoIPPortLock(tfUtsDot3Onu2CtcVoIPPortLock.getValue());
        //mbean.setUtsDot3Onu2CtcE1PortLock(tfUtsDot3Onu2CtcE1PortLock.getValue());
        //mbean.setUtsDot3Onu2FastLeaveAdminControl(fastLeaveVList[tfUtsDot3Onu2FastLeaveAdminControl.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2EthernetPortAlarmReversion(ethernetPortAlarmReversionVList[tfUtsDot3Onu2EthernetPortAlarmReversion.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2MulticastFilter(multicastFilterVList[tfUtsDot3Onu2MulticastFilter.getSelectedIndex()]);
        //mbean.setUtsDot3Onu2FlexQinQSwitch(flexQinQSwitchVList[tfUtsDot3Onu2FlexQinQSwitch.getSelectedIndex()]);

        //mbean.setUtsDot3Onu2SNumberValid(utsDot3Onu2SNumberValidVList[tfUtsDot3Onu2SNumberValid.getSelectedIndex()]);
//        if (tfUtsDot3Onu2SNumberForService.isEnabled())
//            mbean.setUtsDot3Onu2SNumberForService(tfUtsDot3Onu2SNumberForService.getText());
//        else
//            mbean.setUtsDot3Onu2SNumberForService("");//empty stirng to disable the SN service.

        mbean.setUtsDot3Onu2dot1xUserName(tfUtsDot3Onu2dot1xUserName.getText());
        mbean.setUtsDot3Onu2dot1xPassword(tfUtsDot3Onu2dot1xPassword.getText());

//        mbean.setUtsDot3Onu2LoidAuthLoid(tfUtsDot3Onu2LoidAuthLoid.getText());
//        mbean.setUtsDot3Onu2LoidAuthPassword(tfUtsDot3Onu2LoidAuthPassword.getText());
        mbean.setUtsDot3OnuCatvSwitch(utsDot3OnuCatvSwitchVList[tfUtsDot3OnuCatvSwitch.getSelectedIndex()]);
    }

    public void afterUpdateModel() {
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
//        if (tfUtsDot3Onu2SNumberValid.getSelectedIndex() == 1) {
//            tfUtsDot3Onu2SNumberForService.setEnabled(true);
//        } else {
//            tfUtsDot3Onu2SNumberForService.setEnabled(false);
//            tfUtsDot3Onu2SNumberForService.setValue("");
//        }
    }

}

class PortBitMapPanel extends JPanel {

    private int bytes = 0;
    private JCheckBox[] boxes = null;

    public PortBitMapPanel(int bytes) {
        this.bytes = bytes;
        init();
    }

    protected void init() {
        int cols = bytes * 2;
        NTLayout layout = new NTLayout(cols, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        int count = bytes * 8;
        boxes = new JCheckBox[count];
        for (int i = 0; i < count; i++) {
            boxes[i] = new JCheckBox("Port " + (i + 1));
            add(boxes[i]);
        }
    }

    public byte[] getValue() {
        byte[] b = new byte[bytes];
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isSelected()) {
                int index = i / 8;
                int mask = (int) Math.pow(2, i % 8);
                b[index] = (byte) (b[index] + mask);
            }
        }

        return b;
    }

    public void setValue(byte[] b) {
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < 8; j++) {
                    int index = i * 8 + j;
                    int mask = (int) Math.pow(2, j);
                    if ((b[i] & mask) != 0) {
                        boxes[index].setSelected(true);
                    } else {
                        boxes[index].setSelected(false);
                    }
                }
            }
        }
    }

}
