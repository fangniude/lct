/**
 * Created by Zhou Chao, 2008/8/4 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcConfigure;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Dot3Onu2CtcConfigurePanel extends UPanel implements ActionListener {

    private JLabel tfUtsDot3OnuCtcModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuCtcDeviceId = new JLabel();
    private JLabel tfUtsDot3OnuCtcPortId = new JLabel();
    private JLabel tfUtsDot3OnuCtcLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcAdminVList = new int[]{1, 2,};
    private String[] utsDot3Onu2CtcAdminTList = new String[]{
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfUtsDot3Onu2CtcAdmin = new JComboBox(utsDot3Onu2CtcAdminTList);

    private int[] utsDot3OnuFECModeVList = new int[]{2, 3,};
    private String[] utsDot3OnuFECModeTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsDot3OnuFECMode = new JComboBox(utsDot3OnuFECModeTList);

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2, 3, /*4*/};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning"),
            fStringMap.getString("aes48"),
            /*fStringMap.getString("aes32"),*/
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    private IntegerTextField tfUsDot3Onu2CtcPVid = new IntegerTextField();

    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();

    private int[] utsDot3Onu2EthernetPortAlarmReversionVList = new int[]{1, 2,};
    private String[] utsDot3Onu2EthernetPortAlarmReversionTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3Onu2EthernetPortAlarmReversion = new JComboBox(utsDot3Onu2EthernetPortAlarmReversionTList);

    private int[] utsDot3Onu2SNumberValidVList = new int[]{1, 2,};
    private String[] utsDot3Onu2SNumberValidTList = new String[]{
            fStringMap.getString("invalid"),
            fStringMap.getString("valid"),
    };
    private JComboBox tfUtsDot3Onu2SNumberValid = new JComboBox(utsDot3Onu2SNumberValidTList);

    private StringTextField tfUtsDot3Onu2SNumberForService = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xUserName = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xPassword = new StringTextField();

    //private StringTextField tfUtsDot3Onu2LoidAuthLoid = new StringTextField();
    //private StringTextField tfUtsDot3Onu2LoidAuthPassword = new StringTextField();

    /*
    private int[] utsDot3OnuCatvSwitchVList = new int[]{1, 2,};
    private String[] utsDot3OnuCatvSwitchTList = new String[]{
            fStringMap.getString("catvOn"),
            fStringMap.getString("catvOff"),
    };
    private JComboBox tfUtsDot3OnuCatvSwitch = new JComboBox(utsDot3OnuCatvSwitchTList);
    */

    private final String utsDot3OnuCtcModuleId = fStringMap.getString("utsDot3OnuCtcModuleId") + ": ";
    //private final String utsDot3OnuCtcDeviceId = fStringMap.getString("utsDot3OnuCtcDeviceId") + ": ";
    private final String utsDot3OnuCtcPortId = fStringMap.getString("utsDot3OnuCtcPortId") + ": ";
    private final String utsDot3OnuCtcLogicalPortId = fStringMap.getString("utsDot3OnuCtcLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcAdmin = fStringMap.getString("utsDot3Onu2CtcAdmin") + ": ";
    private final String utsDot3OnuFECMode = fStringMap.getString("utsDot3OnuFECMode") + ": ";
    private final String utsDot3Onu2CtcEncryptTraffic = fStringMap.getString("utsDot3Onu2CtcEncryptTraffic") + ": ";
    private final String utsDot3Onu2CtcPVid = fStringMap.getString("utsDot3Onu2CtcPVid") + ": ";
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress");
    private final String utsDot3Onu2EthernetPortAlarmReversion = fStringMap.getString("utsDot3Onu2EthernetPortAlarmReversion");
    private final String utsDot3Onu2SNumberValid = fStringMap.getString("utsDot3Onu2SNumberValid") + ": ";
    private final String utsDot3Onu2SNumberForService = fStringMap.getString("utsDot3Onu2SNumberForService") + ": ";
    private final String utsDot3Onu2dot1xUserName = fStringMap.getString("utsDot3Onu2dot1xUserName") + ": ";
    private final String utsDot3Onu2dot1xPassword = fStringMap.getString("utsDot3Onu2dot1xPassword") + ": ";
    //private final String utsDot3Onu2LoidAuthLoid = fStringMap.getString("utsDot3Onu2LoidAuthLoid") + ": ";
    //private final String utsDot3Onu2LoidAuthPassword = fStringMap.getString("utsDot3Onu2LoidAuthPassword") + ": ";
    //private final String utsDot3OnuCatvSwitch = fStringMap.getString("utsDot3OnuCatvSwitch") + ": ";

    public Dot3Onu2CtcConfigurePanel(IApplication app) {
        super(app);
        setModel(new Dot3Onu2CtcConfigure(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcModuleId));
        baseInfoPanel.add(tfUtsDot3OnuCtcModuleId);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(utsDot3OnuCtcDeviceId));
        baseInfoPanel.add(tfUtsDot3OnuCtcDeviceId);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcPortId));
        baseInfoPanel.add(tfUtsDot3OnuCtcPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuCtcLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAdmin));
        tfUtsDot3Onu2CtcAdmin.setName(fStringMap.getString("utsDot3Onu2CtcAdmin"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAdmin);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuFECMode));
        tfUtsDot3OnuFECMode.setName(fStringMap.getString("utsDot3OnuFECMode"));
        baseInfoPanel.add(tfUtsDot3OnuFECMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcEncryptTraffic));
        tfUtsDot3Onu2CtcEncryptTraffic.setName(fStringMap.getString("utsDot3Onu2CtcEncryptTraffic"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcEncryptTraffic);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPVid));
        tfUsDot3Onu2CtcPVid.setName(fStringMap.getString("utsDot3Onu2CtcPVid"));
        baseInfoPanel.add(tfUsDot3Onu2CtcPVid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMaxMacAddress));
        tfUtsDot3Onu2CtcMaxMacAddress.setName(fStringMap.getString("utsDot3Onu2CtcMaxMacAddress"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMaxMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2EthernetPortAlarmReversion));
        tfUtsDot3Onu2EthernetPortAlarmReversion.setName(fStringMap.getString("utsDot3Onu2EthernetPortAlarmReversion"));
        baseInfoPanel.add(tfUtsDot3Onu2EthernetPortAlarmReversion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2SNumberValid));
        tfUtsDot3Onu2SNumberValid.addActionListener(this);
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

        /*
        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthLoid));
        tfUtsDot3Onu2LoidAuthLoid.setName(fStringMap.getString("utsDot3Onu2LoidAuthLoid"));
        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthLoid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthPassword));
        tfUtsDot3Onu2LoidAuthPassword.setName(fStringMap.getString("utsDot3Onu2LoidAuthPassword"));
        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthPassword);
        baseInfoPanel.add(new HSpacer());
        */

        /*
        baseInfoPanel.add(new JLabel(utsDot3OnuCatvSwitch));
        tfUtsDot3OnuCatvSwitch.addActionListener(this);
        tfUtsDot3OnuCatvSwitch.setName(fStringMap.getString("utsDot3OnuCatvSwitch"));
        baseInfoPanel.add(tfUtsDot3OnuCatvSwitch);
        baseInfoPanel.add(new HSpacer());
        */

        JPanel allPanel = new JPanel();
        layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);

        setLayout(new BorderLayout());
        add(new JScrollPane(allPanel), BorderLayout.CENTER);
    }

    protected void initForm() {
        tfUsDot3Onu2CtcPVid.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 100);
    }

    public boolean validateFrom() {
        if (tfUtsDot3Onu2SNumberForService.isEnabled() && tfUtsDot3Onu2SNumberForService.getValue().trim().equals("")) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_SN_Number_Is_Null"));
            return false;
        }

        Dot3Onu2CtcConfigure currentOject = (Dot3Onu2CtcConfigure) getModel();
        if (tfUtsDot3Onu2SNumberForService.isEnabled()) {
            int moduleId = currentOject.getUtsDot3OnuCtcModuleId();
            int portId = currentOject.getUtsDot3OnuCtcPortId();
            String SN = tfUtsDot3Onu2SNumberForService.getText();
            int logicalPortId = currentOject.getUtsDot3OnuCtcLogicalPortId();
            Dot3Onu2CtcConfigure bean = new Dot3Onu2CtcConfigure(fApplication.getSnmpProxy());
            Vector beans = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < beans.size(); i++) {
                Dot3Onu2CtcConfigure b = (Dot3Onu2CtcConfigure) beans.get(i);
                if (b.getUtsDot3Onu2SNumberValid() != 1) {
                    if (b.getUtsDot3OnuCtcModuleId() == moduleId && b.getUtsDot3OnuCtcPortId() == portId) {
                        if (b.getUtsDot3OnuCtcLogicalPortId() != logicalPortId && b.getUtsDot3Onu2SNumberForService().equals(SN)) {
                            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Same_SN_Number"));
                            return false;
                        }
                    }
                }
            }
        }

        Dot3Onu2CtcValidOnuMacTable onuMac = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
        onuMac.setUtsDot3OnuValidOnuMacModuleId(currentOject.getUtsDot3OnuCtcModuleId());
        onuMac.setUtsDot3OnuValidOnuMacDeviceId(1);
        onuMac.setUtsDot3OnuValidOnuMacPortId(currentOject.getUtsDot3OnuCtcPortId());
        onuMac.setUtsDot3OnuValidOnuMacAppLPortId(currentOject.getUtsDot3OnuCtcLogicalPortId());

        BeanService.refreshBean(fApplication, onuMac);

        if (onuMac.getUtsDot3ValidOnuMacAddr() != null && !ConfigUtility.OctetToMacAddress(onuMac.getUtsDot3ValidOnuMacAddr()).equals("00-00-00-00-00-00") && tfUtsDot3Onu2SNumberForService.isEnabled()) {
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_ONU_MAC_Was_Bound"));
            return false;
        }

        return true;
    }

    public void refresh() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();
        if (mbean == null)
            return;

        tfUtsDot3OnuCtcModuleId.setText(mbean.getUtsDot3OnuCtcModuleId().toString());
        //tfUtsDot3OnuCtcDeviceId.setText(mbean.getUtsDot3OnuCtcDeviceId().toString());
        tfUtsDot3OnuCtcPortId.setText(mbean.getUtsDot3OnuCtcPortId().toString());
        tfUtsDot3OnuCtcLogicalPortId.setText(mbean.getUtsDot3OnuCtcLogicalPortId().toString());

        tfUtsDot3Onu2CtcAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAdminVList, mbean.getUtsDot3Onu2CtcAdmin()));
        tfUtsDot3OnuFECMode.setSelectedIndex(getIndexFromValue(utsDot3OnuFECModeVList, mbean.getUtsDot3OnuFECMode()));
        tfUtsDot3Onu2CtcEncryptTraffic.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcEncryptTrafficVList, mbean.getUtsDot3Onu2CtcEncryptTraffic()));
        tfUsDot3Onu2CtcPVid.setValue(mbean.getUtsDot3Onu2CtcPVid());
        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());
        tfUtsDot3Onu2EthernetPortAlarmReversion.setSelectedIndex(getIndexFromValue(utsDot3Onu2EthernetPortAlarmReversionVList, mbean.getUtsDot3Onu2EthernetPortAlarmReversion() != null ? mbean.getUtsDot3Onu2EthernetPortAlarmReversion() : 1));
        tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, mbean.getUtsDot3Onu2SNumberValid() != null ? mbean.getUtsDot3Onu2SNumberValid() : 1));
        tfUtsDot3Onu2SNumberForService.setText(mbean.getUtsDot3Onu2SNumberForService() != null ? mbean.getUtsDot3Onu2SNumberForService() : "");
        tfUtsDot3Onu2dot1xUserName.setText(mbean.getUtsDot3Onu2dot1xUserName() != null ? mbean.getUtsDot3Onu2dot1xUserName() : "");
        tfUtsDot3Onu2dot1xPassword.setText(mbean.getUtsDot3Onu2dot1xPassword() != null ? mbean.getUtsDot3Onu2dot1xPassword() : "");
        //tfUtsDot3Onu2LoidAuthLoid.setText(mbean.getUtsDot3Onu2LoidAuthLoid() != null ? mbean.getUtsDot3Onu2LoidAuthLoid() : "");
        //tfUtsDot3Onu2LoidAuthPassword.setText(mbean.getUtsDot3Onu2LoidAuthPassword() != null ? mbean.getUtsDot3Onu2LoidAuthPassword() : "");
        //tfUtsDot3OnuCatvSwitch.setSelectedIndex(getIndexFromValue(utsDot3OnuCatvSwitchVList, mbean.getUtsDot3OnuCatvSwitch() != null ? mbean.getUtsDot3OnuCatvSwitch() : 1));

        boolean adminStatusUpOrNot = (mbean.getUtsDot3Onu2CtcAdmin() == 1);
        tfUtsDot3OnuFECMode.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcEncryptTraffic.setEnabled(adminStatusUpOrNot);
        tfUsDot3Onu2CtcPVid.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcMaxMacAddress.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2EthernetPortAlarmReversion.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2SNumberValid.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2SNumberForService.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2dot1xUserName.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2dot1xPassword.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2LoidAuthLoid.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3Onu2LoidAuthPassword.setEnabled(adminStatusUpOrNot);
        //tfUtsDot3OnuCatvSwitch.setEnabled(adminStatusUpOrNot);
    }

    public void updateModel() {
        Dot3Onu2CtcConfigure mbean = (Dot3Onu2CtcConfigure) getModel();
        if (mbean == null)
            return;

        if (mbean.getUtsDot3Onu2CtcAdmin() != utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcAdmin(utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]);
            return;
        }

        if (mbean.getUtsDot3OnuFECMode() != utsDot3OnuFECModeVList[tfUtsDot3OnuFECMode.getSelectedIndex()]) {
            mbean.setUtsDot3OnuFECMode(utsDot3OnuFECModeVList[tfUtsDot3OnuFECMode.getSelectedIndex()]);
        }

        if (mbean.getUtsDot3Onu2CtcEncryptTraffic() != utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcEncryptTraffic(utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]);
        }

        if (mbean.getUtsDot3Onu2CtcPVid() != tfUsDot3Onu2CtcPVid.getValue()) {
            mbean.setUtsDot3Onu2CtcPVid(tfUsDot3Onu2CtcPVid.getValue());
        }

        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());
        mbean.setUtsDot3Onu2EthernetPortAlarmReversion(utsDot3Onu2EthernetPortAlarmReversionVList[tfUtsDot3Onu2EthernetPortAlarmReversion.getSelectedIndex()]);
        mbean.setUtsDot3Onu2SNumberValid(utsDot3Onu2SNumberValidVList[tfUtsDot3Onu2SNumberValid.getSelectedIndex()]);
        mbean.setUtsDot3Onu2SNumberForService(tfUtsDot3Onu2SNumberForService.isEnabled() ? tfUtsDot3Onu2SNumberForService.getText() : "");
        mbean.setUtsDot3Onu2dot1xUserName(tfUtsDot3Onu2dot1xUserName.getText());
        mbean.setUtsDot3Onu2dot1xPassword(tfUtsDot3Onu2dot1xPassword.getText());
        //mbean.setUtsDot3Onu2LoidAuthLoid(tfUtsDot3Onu2LoidAuthLoid.getText());
        //mbean.setUtsDot3Onu2LoidAuthPassword(tfUtsDot3Onu2LoidAuthPassword.getText());
        //mbean.setUtsDot3OnuCatvSwitch(utsDot3OnuCatvSwitchVList[tfUtsDot3OnuCatvSwitch.getSelectedIndex()]);
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

    public void actionPerformed(ActionEvent e) {
        if (tfUtsDot3Onu2SNumberValid.getSelectedIndex() == 1) {
            tfUtsDot3Onu2SNumberForService.setEnabled(true);
        } else {
            tfUtsDot3Onu2SNumberForService.setEnabled(false);
        }
    }

}