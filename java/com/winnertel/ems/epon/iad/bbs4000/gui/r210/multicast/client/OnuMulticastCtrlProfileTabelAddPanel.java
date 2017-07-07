/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.base.IPAddressDataLayer;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

public class OnuMulticastCtrlProfileTabelAddPanel extends JDialog {

    private static IApplication fApplication = null;
    private OnuMulticastCtrlApplication app = null;
    private JComponent parent = null;

    private JPanel mainPane = null;
    private JPanel buttonPane = null;
    private JButton btnOk = null;
    private JButton btnCancel = null;
    private JPanel infoPane = null;

    private OnuMulticastCtrlProfileModel model = null;

    private int dialogType = 1; //1: addProfileData dialog, 2: addProfileName dialog

    private JTextField profileNameField = null;
    private JComboBox profileField = null;
    private JTextField vlanField = null;
    private IPAddressField groupStartField = null;
    private IPAddressField groupEndField = null;
    private JComboBox authTypeField = null;

    private int[] utsDot3OnuAuthTypeVList = new int[]{1, 3, 2,};
    String[] utsDot3OnuAuthTypeTList = null;

    public OnuMulticastCtrlProfileTabelAddPanel(JComponent parent, String title, boolean modal, IApplication fApplication, OnuMulticastCtrlApplication app) {
        super(fApplication.getTopMostFrame(), title, modal);
        this.parent = parent;
        this.fApplication = fApplication;
        this.app = app;
        dialogType = getString("Add").equals(title) ? 1 : 2;
        utsDot3OnuAuthTypeTList = new String[]{getString("permit"), getString("preview"), getString("deny"),};
        initialize();
    }

    private void initialize() {
        setResizable(false);
        setContentPane(getMainPane());
        pack();
        setParentCenter(fApplication.getTopMostFrame(), this);
    }

    public OnuMulticastCtrlProfileModel getModel() {
        return model;
    }

    private JPanel getMainPane() {
        if (mainPane == null) {
            mainPane = new JPanel();
            mainPane.setLayout(new BorderLayout());
            mainPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.black));
            mainPane.add(getInfoPane(), BorderLayout.CENTER);
            mainPane.add(getButtonPane(), BorderLayout.SOUTH);
        }

        return mainPane;
    }

    private JPanel getButtonPane() {
        if (buttonPane == null) {
            buttonPane = new JPanel();
            buttonPane.add(getOkButton(), null);
            buttonPane.add(getCancelButton(), null);
        }

        return buttonPane;
    }

    private JButton getOkButton() {
        if (btnOk == null) {
            btnOk = new JButton();
            btnOk.setText(getString("Apply"));
            btnOk.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doOk();
                }
            });
        }

        return btnOk;
    }

    private JButton getCancelButton() {
        if (btnCancel == null) {
            btnCancel = new JButton();
            btnCancel.setText(getString("Close"));
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doCancel();
                }
            });
        }

        return btnCancel;
    }

    private JPanel getInfoPane() {
        if (infoPane == null) {
            JLabel lblProfile = new JLabel();
            JLabel lblVlan = new JLabel();
            JLabel lblGroupStart = new JLabel();
            JLabel lblGroupEnd = new JLabel();
            JLabel lblAuthType = new JLabel();

            lblProfile.setText(getString("Profile") + ": ");
            lblVlan.setText(getString("MultiCast VLAN") + ": ");
            lblGroupStart.setText(getString("MultiCast Group Start") + ": ");
            lblGroupEnd.setText(getString("MultiCast Group End") + ": ");
            lblAuthType.setText(getString("Authentication Type") + ": ");

            infoPane = new JPanel(new NTLayout(5, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5));

            infoPane.add(new HSpacer());
            infoPane.add(lblProfile, null);
            infoPane.add(new HSpacer());
            if (dialogType == 1)
                infoPane.add(getProfileField(), null);
            else
                infoPane.add(getProfileNameField(), null);
            infoPane.add(new HSpacer());

            infoPane.add(new HSpacer());
            infoPane.add(lblVlan, null);
            infoPane.add(new HSpacer());
            infoPane.add(getVlanField(), null);
            infoPane.add(new HSpacer());

            infoPane.add(new HSpacer());
            infoPane.add(lblGroupStart, null);
            infoPane.add(new HSpacer());
            infoPane.add(getGroupStartField(), null);
            infoPane.add(new HSpacer());

            infoPane.add(new HSpacer());
            infoPane.add(lblGroupEnd, null);
            infoPane.add(new HSpacer());
            infoPane.add(getGroupEndField(), null);
            infoPane.add(new HSpacer());

            infoPane.add(new HSpacer());
            infoPane.add(lblAuthType, null);
            infoPane.add(new HSpacer());
            infoPane.add(getAuthTypeField(), null);
            infoPane.add(new HSpacer());
        }

        return infoPane;
    }

    private JTextField getProfileNameField() {
        if (profileNameField == null) {
            profileNameField = new JTextField();
        }
        profileNameField.setText("");

        return profileNameField;
    }

    private JComboBox getProfileField() {
        if (profileField == null) {
            profileField = new JComboBox();
        }
        profileField.removeAllItems();
        Vector v = app.getOnuMulticastCtrlProfileName();
        for (int i = 0; i < v.size(); i++)
            profileField.addItem(v.get(i));

        return profileField;
    }

    private JTextField getVlanField() {
        if (vlanField == null) {
            vlanField = new JTextField();
        }

        return vlanField;
    }

    private IPAddressField getGroupStartField() {
        if (groupStartField == null) {
            groupStartField = new IPAddressField(IPAddressDataLayer.IPMULTICAST);
        }

        return groupStartField;
    }

    private IPAddressField getGroupEndField() {
        if (groupEndField == null) {
            groupEndField = new IPAddressField(IPAddressDataLayer.IPMULTICAST);
        }

        return groupEndField;
    }

    private JComboBox getAuthTypeField() {
        if (authTypeField == null) {
            authTypeField = new JComboBox(utsDot3OnuAuthTypeTList);
        }

        return authTypeField;
    }

    private void doOk() {
        String profile = (dialogType == 1 ? (profileField.getSelectedIndex() >= 0 ? profileField.getSelectedItem().toString() : "") : profileNameField.getText());
        String vlan = vlanField.getText();
        String groupStart = groupStartField.getIPString();
        String groupEnd = groupEndField.getIPString();
        String authType = authTypeField.getSelectedIndex() >= 0 ? authTypeField.getSelectedItem().toString() : "";
        if (authType != null && authType.length() > 0)
            authType = String.valueOf(utsDot3OnuAuthTypeVList[getIndexFromValue(utsDot3OnuAuthTypeTList, authTypeField.getSelectedItem().toString())]);

        String message = "";
        if (profile == null || profile.trim().equals("")) {
            message = (dialogType == 1 ? getString("Please select a Profile!") : getString("Please intput Profile Name!"));
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        profile = profile.trim();

        if (vlan == null || vlan.trim().equals("")) {
            message = getString("Please input MultiCast VLAN!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        vlan = vlan.trim();

        if (groupStart == null || groupStart.trim().equals("")) {
            message = getString("Please input MultiCast Group Start!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        groupStart = groupStart.trim();

        if (groupEnd == null || groupEnd.trim().equals("")) {
            message = getString("Please input MultiCast Group End!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        groupEnd = groupEnd.trim();

        if (authType == null || authType.trim().equals("")) {
            message = getString("Please select an Authentication Type!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        authType = authType.trim();

        model = new OnuMulticastCtrlProfileModel(profile, Integer.parseInt(vlan), groupStart, groupEnd, Integer.parseInt(authType));
        //dispose();
        if (dialogType == 1) {
            try {
                ((OnuMulticastCtrlProfileTablePanel) parent).addProfileDataProcess(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ((OnuMulticastCtrlProfileTablePanel) parent).addProfileProcess(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doCancel() {
        model = null;
        dispose();
    }

    private int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] != null && v != null && list[i].equals(v))
                return i;
        }

        return 0;
    }

    public static void setParentCenter(Component parent, Component component) {
        if (parent == null || component == null)
            return;

        Dimension parentSize = parent.getSize();
        Dimension preferredSize = component.getPreferredSize();
        Dimension realSize = component.getSize();
        int width = preferredSize.width > realSize.width ? preferredSize.width : realSize.width;
        int height = preferredSize.height > realSize.height ? preferredSize.height : realSize.height;
        component.setLocation((parentSize.width > width ? parentSize.width - width : width - parentSize.width) / 2, (parentSize.height > height ? parentSize.height - height : height - parentSize.height) / 2);
    }

    /*
    public static void setScreenCenter(Component component) {
        if (component == null)
            return;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension preferredSize = component.getPreferredSize();
        Dimension realSize = component.getSize();
        int width = preferredSize.width > realSize.width ? preferredSize.width : realSize.width;
        int height = preferredSize.height > realSize.height ? preferredSize.height : realSize.height;
        component.setLocation((screenSize.width > width ? screenSize.width - width : width - screenSize.width) / 2, (screenSize.height > height ? screenSize.height - height : height - screenSize.height) / 2);
    }
    */

    public static String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fApplication.getActiveDeviceManager().getGuiComposer().getString(s);
    }

}