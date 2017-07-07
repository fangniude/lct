package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable;
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

public class Dot3Onu2CtcTablePanel extends UPanel implements ActionListener {
    private JLabel tfUtsDot3Onu2CtcModuleId = new JLabel();
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

    private int[] utsDot3Onu2CtcEncryptTrafficVList = new int[]{1, 2, /*3, 4*/};
    private String[] utsDot3Onu2CtcEncryptTrafficTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("ctc-churning"),
            /* fStringMap.getString("aes48"),
             fStringMap.getString("aes32"), */
    };
    private JComboBox tfUtsDot3Onu2CtcEncryptTraffic = new JComboBox(utsDot3Onu2CtcEncryptTrafficTList);

    private IntegerTextField tfUtsDot3Onu2CtcMaxMacAddress = new IntegerTextField();

    private int[] utsDot3Onu2SNumberValidVList = new int[]{1, 2,};
    private String[] utsDot3Onu2SNumberValidTList = new String[]{
            fStringMap.getString("invalid"),
            fStringMap.getString("valid"),
    };
    private JComboBox tfUtsDot3Onu2SNumberValid = new JComboBox(utsDot3Onu2SNumberValidTList);

    private StringTextField tfUtsDot3Onu2SNumberForService = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xUserName = new StringTextField();
    private StringTextField tfUtsDot3Onu2dot1xPassword = new StringTextField();

    private StringTextField tfUtsDot3Onu2LoidAuthLoid = new StringTextField();
    private StringTextField tfUtsDot3Onu2LoidAuthPassword = new StringTextField();

    private final String utsDot3Onu2CtcModuleId = fStringMap.getString("utsDot3Onu2CtcModuleId") + ": ";
    private final String utsDot3Onu2CtcPortId = fStringMap.getString("utsDot3Onu2CtcPortId") + ": ";
    private final String utsDot3Onu2CtcLogicalPortId = fStringMap.getString("utsDot3Onu2CtcLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcAdmin = fStringMap.getString("utsDot3Onu2CtcAdmin") + ": ";
    private final String utsDot3Onu2CtcFECMode = fStringMap.getString("utsDot3Onu2CtcFECMode") + ": ";
    private final String utsDot3Onu2CtcEncryptTraffic = fStringMap.getString("utsDot3Onu2CtcEncryptTraffic") + ": ";
    private final String utsDot3Onu2CtcMaxMacAddress = fStringMap.getString("utsDot3Onu2CtcMaxMacAddress");
    private final String utsDot3Onu2SNumberValid = fStringMap.getString("utsDot3Onu2SNumberValid") + ": ";
    private final String utsDot3Onu2SNumberForService = fStringMap.getString("utsDot3Onu2SNumberForService") + ": ";
    private final String utsDot3Onu2dot1xUserName = fStringMap.getString("utsDot3Onu2dot1xUserName") + ": ";
    private final String utsDot3Onu2dot1xPassword = fStringMap.getString("utsDot3Onu2dot1xPassword") + ": ";
    private final String utsDot3Onu2LoidAuthLoid = fStringMap.getString("utsDot3Onu2LoidAuthLoid") + " : ";
    private final String utsDot3Onu2LoidAuthPassword = fStringMap.getString("utsDot3Onu2LoidAuthPassword") + " : ";

    public Dot3Onu2CtcTablePanel(IApplication app) {
        super(app);
        setModel(new Dot3Onu2CtcTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5); //modified by Zhou Chao, 2008/8/4
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcModuleId);
        baseInfoPanel.add(new HSpacer());

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

        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthLoid));
        tfUtsDot3Onu2LoidAuthLoid.setName(fStringMap.getString("utsDot3Onu2LoidAuthLoid"));
        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthLoid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthPassword));
        tfUtsDot3Onu2LoidAuthPassword.setName(fStringMap.getString("utsDot3Onu2LoidAuthPassword"));
        baseInfoPanel.add(tfUtsDot3Onu2LoidAuthPassword);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);

        setLayout(new BorderLayout());
        add(new JScrollPane(allPanel), BorderLayout.CENTER);
    }

    protected void initForm() {
        tfUtsDot3Onu2CtcMaxMacAddress.setValueScope(0, 100);
    }

    public boolean validateFrom() {
        if(tfUtsDot3Onu2SNumberForService.isEnabled() && tfUtsDot3Onu2SNumberForService.getValue().trim().equals("")) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_SN_Number_Is_Null"));
            return false;
        }

        Dot3Onu2CtcTable currentOject = (Dot3Onu2CtcTable) getModel();
        if (tfUtsDot3Onu2SNumberForService.isEnabled()) {
            int moduleId = currentOject.getUtsDot3Onu2CtcModuleId();
            int portId = currentOject.getUtsDot3Onu2CtcPortId();
            String SN = tfUtsDot3Onu2SNumberForService.getText();
            int logicalPortId = currentOject.getUtsDot3Onu2CtcLogicalPortId();
            Dot3Onu2CtcTable bean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
            Vector beans = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < beans.size(); i++) {
                Dot3Onu2CtcTable b = (Dot3Onu2CtcTable) beans.get(i);
                if (b.getUtsDot3Onu2SNumberValid() != 1) {
                    if (b.getUtsDot3Onu2CtcModuleId() == moduleId && b.getUtsDot3Onu2CtcPortId() == portId) {
                        if (b.getUtsDot3Onu2CtcLogicalPortId() != logicalPortId && b.getUtsDot3Onu2SNumberForService().equals(SN)) {
                            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Same_SN_Number"));
                            return false;
                        }
                    }
                }
            }

            //check if the PON port has SN Switch enalbe.
            Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
            portBean.setUtsDot3OltModuleId(currentOject.getUtsDot3Onu2CtcModuleId());
            portBean.setUtsDot3OltDeviceId(1);
            portBean.setUtsDot3OltPortId(currentOject.getUtsDot3Onu2CtcPortId());

            BeanService.refreshBean(fApplication, portBean);
            if(portBean.getUtsDot3OltPortONUSNumberSwitch() != null && portBean.getUtsDot3OltPortONUSNumberSwitch() != 2) { //SN Switch is disable.
                MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Port_SN_Switch_Disable"));
                return false;
            }
        }

        Dot3Onu2CtcTable mbean = (Dot3Onu2CtcTable) getModel();
        if((mbean.getUtsDot3Onu2CtcFECMode()!=null)&&(mbean.getUtsDot3Onu2CtcFECMode()!=utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()])) {
            int result = MessageDialog.showConfirmDialog(fApplication,fStringMap.getString("Change_FECMOde_ONU_reboot"));
            return result == JOptionPane.OK_OPTION;
        }

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
        tfUtsDot3Onu2CtcFECMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcFECModeVList, mbean.getUtsDot3Onu2CtcFECMode()));
        tfUtsDot3Onu2CtcEncryptTraffic.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcEncryptTrafficVList, mbean.getUtsDot3Onu2CtcEncryptTraffic()));

        boolean adminStatusUpOrNot = mbean.getUtsDot3Onu2CtcAdmin() == 1;
        tfUtsDot3Onu2CtcFECMode.setEnabled(adminStatusUpOrNot);
        tfUtsDot3Onu2CtcEncryptTraffic.setEnabled(adminStatusUpOrNot);

        tfUtsDot3Onu2CtcMaxMacAddress.setValue(mbean.getUtsDot3Onu2CtcMaxMacAddress());

        if(mbean.getUtsDot3Onu2SNumberForService() == null || mbean.getUtsDot3Onu2SNumberForService().equals("")) {
            tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, 1)); //1 - invalid
        } else {
            tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, 2)); //2 - valid
        }
        tfUtsDot3Onu2SNumberValid.setSelectedIndex(getIndexFromValue(utsDot3Onu2SNumberValidVList, mbean.getUtsDot3Onu2SNumberValid() != null ? mbean.getUtsDot3Onu2SNumberValid() : 1));
        tfUtsDot3Onu2SNumberForService.setValue(mbean.getUtsDot3Onu2SNumberForService() != null ? mbean.getUtsDot3Onu2SNumberForService() : "");
        tfUtsDot3Onu2dot1xUserName.setValue(mbean.getUtsDot3Onu2dot1xUserName() != null ? mbean.getUtsDot3Onu2dot1xUserName() : "");
        tfUtsDot3Onu2dot1xPassword.setValue(mbean.getUtsDot3Onu2dot1xPassword() != null ? mbean.getUtsDot3Onu2dot1xPassword() : "");
//        tfUtsDot3Onu2LoidAuthLoid.setValue(mbean.getUtsDot3Onu2LoidAuthLoid());
//        tfUtsDot3Onu2LoidAuthPassword.setValue(mbean.getUtsDot3Onu2LoidAuthPassword());
    }

    public void updateModel() {
        Dot3Onu2CtcTable mbean = (Dot3Onu2CtcTable) getModel();
        if (mbean == null)
            return;

        if (mbean.getUtsDot3Onu2CtcAdmin() != utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcAdmin(utsDot3Onu2CtcAdminVList[tfUtsDot3Onu2CtcAdmin.getSelectedIndex()]);
            return;
        }

        if (mbean.getUtsDot3Onu2CtcFECMode() != utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcFECMode(utsDot3Onu2CtcFECModeVList[tfUtsDot3Onu2CtcFECMode.getSelectedIndex()]);
        }

        if (mbean.getUtsDot3Onu2CtcEncryptTraffic() != utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]) {
            mbean.setUtsDot3Onu2CtcEncryptTraffic(utsDot3Onu2CtcEncryptTrafficVList[tfUtsDot3Onu2CtcEncryptTraffic.getSelectedIndex()]);
        }

        mbean.setUtsDot3Onu2CtcMaxMacAddress(tfUtsDot3Onu2CtcMaxMacAddress.getValue());

        if(tfUtsDot3Onu2SNumberForService.isEnabled())
            mbean.setUtsDot3Onu2SNumberForService(tfUtsDot3Onu2SNumberForService.getValue());
        else
            mbean.setUtsDot3Onu2SNumberForService("");//empty stirng to disable the SN service.

        mbean.setUtsDot3Onu2dot1xUserName(tfUtsDot3Onu2dot1xUserName.getValue());
        mbean.setUtsDot3Onu2dot1xPassword(tfUtsDot3Onu2dot1xPassword.getValue());
//        mbean.setUtsDot3Onu2LoidAuthLoid(tfUtsDot3Onu2LoidAuthLoid.getValue());
//        mbean.setUtsDot3Onu2LoidAuthPassword(tfUtsDot3Onu2LoidAuthPassword.getValue());
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
        if(tfUtsDot3Onu2SNumberValid.getSelectedIndex() == 1) {
            tfUtsDot3Onu2SNumberForService.setEnabled(true);
        } else {
            tfUtsDot3Onu2SNumberForService.setEnabled(false);
            tfUtsDot3Onu2SNumberForService.setValue("");
        }
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