/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlHeadModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

public class OnuMulticastCtrlHeadTabelAddPanel extends JDialog {

    private static IApplication fApplication = null;
    private OnuMulticastCtrlApplication app = null;
    private JComponent parent = null;

    private JPanel mainPane = null;
    private JPanel buttonPane = null;
    private JButton btnOk = null;
    private JButton btnCancel = null;
    private JPanel infoPane = null;

    private OnuMulticastCtrlHeadModel model = null;

    private JComboBox moduleIdField = null;
    //private JComboBox deviceIdField = null;
    private JComboBox portIdField = null;
    private JComboBox logicalPortIdField = null;
    private JComboBox etherPortIndexField = null;
    private MultiItemSelector profileField = null;

    private BBS4000NE ne = null;

    private boolean isAdd = true;
    private OnuMulticastCtrlHeadModel bean = null;

    public OnuMulticastCtrlHeadTabelAddPanel(JComponent parent, String title, boolean modal, IApplication fApplication, OnuMulticastCtrlApplication app, OnuMulticastCtrlHeadModel bean) {
        super(fApplication.getTopMostFrame(), title, modal);
        this.parent = parent;
        this.fApplication = fApplication;
        this.app = app;
        isAdd = (bean == null);
        this.bean = bean;
        ne = new BBS4000NE(fApplication);
        initialize();
    }

    private void initialize() {
        setResizable(false);
        setContentPane(getMainPane());
        pack();
        setParentCenter(fApplication.getTopMostFrame(), this);
    }

    public OnuMulticastCtrlHeadModel getModel() {
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
                    doApply();
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
                    doClose();
                }
            });
        }

        return btnCancel;
    }

    private JPanel getInfoPane() {
        if (infoPane == null) {
            JLabel lblModuleId = new JLabel();
            //JLabel lblDeviceId = new JLabel();
            JLabel lblPortId = new JLabel();
            JLabel lblLogicalPortId = new JLabel();
            JLabel lblEtherPortIndex = new JLabel();
            JLabel lblProfile = new JLabel();

            lblModuleId.setText(getString("Module ID") + ": ");
            //lblDeviceId.setText(getString("Device ID") + ": ");
            lblPortId.setText(getString("Port ID") + ": ");
            lblLogicalPortId.setText(getString("Logical Port ID") + ": ");
            lblEtherPortIndex.setText(getString("UNI ID") + ": ");
            lblProfile.setText(getString("Profile") + ": ");

            if (isAdd)
                infoPane = new JPanel(new NTLayout(5, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5));
            else
                infoPane = new JPanel(new NTLayout(1, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5));

            if (isAdd) {
                infoPane.add(new HSpacer());
                infoPane.add(lblModuleId, null);
                infoPane.add(new HSpacer());
                //infoPane.add(isAdd ? getModuleIdField() : getModuleIdField(bean.getModuleId()), null);
                infoPane.add(getModuleIdField(), null);
                infoPane.add(new HSpacer());

                //infoPane.add(new HSpacer());
                //infoPane.add(lblDeviceId, null);
                //infoPane.add(new HSpacer());
                //infoPane.add(getDeviceIdField(), null);
                //infoPane.add(new HSpacer());

                infoPane.add(new HSpacer());
                infoPane.add(lblPortId, null);
                infoPane.add(new HSpacer());
                //infoPane.add(isAdd ? getPortIdField() : getPortIdField(bean.getPortId()), null);
                infoPane.add(getPortIdField(), null);
                infoPane.add(new HSpacer());

                infoPane.add(new HSpacer());
                infoPane.add(lblLogicalPortId, null);
                infoPane.add(new HSpacer());
                //infoPane.add(isAdd ? getLogicalPortIdField() : getLogicalPortIdField(bean.getLogicalPortId()), null);
                infoPane.add(getLogicalPortIdField(), null);
                infoPane.add(new HSpacer());

                infoPane.add(new HSpacer());
                infoPane.add(lblEtherPortIndex, null);
                infoPane.add(new HSpacer());
                //infoPane.add(isAdd ? getEtherPortIndexField() : getEtherPortIndexField(bean.getEtherPortIndex()), null);
                infoPane.add(getEtherPortIndexField(), null);
                infoPane.add(new HSpacer());
            }

            infoPane.add(new HSpacer());
            infoPane.add(lblProfile, null);
            infoPane.add(new HSpacer());
            infoPane.add(isAdd ? getProfileField() : getProfileField(bean.getProfile()), null);
            infoPane.add(new HSpacer());
            profileField.setPreferredSize(new Dimension(120, 24));
        }

        return infoPane;
    }

    private JComboBox getModuleIdField() {
        if (moduleIdField == null) {
            moduleIdField = new JComboBox();
            BaseModuleType fModuleType = new ModuleType();
            BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
            Vector list = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < list.size(); i++) {
                BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
                if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                    moduleIdField.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
                } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                    moduleIdField.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
                } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                    moduleIdField.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
                }*/
            }
        }
        moduleIdField.setEnabled(true);

        return moduleIdField;
    }

    private JComboBox getModuleIdField(int moduleId) {
        if (moduleIdField == null) {
            moduleIdField = new JComboBox();
            moduleIdField.addItem(moduleId);
        }
        moduleIdField.setEnabled(false);

        return moduleIdField;
    }

    /* reserved
    private JComboBox getDeviceIdField() {
    }
    */

    private JComboBox getPortIdField() {
        if (portIdField == null) {
            portIdField = new JComboBox();
            for (int i = 1; i <= ne.getPortCount(); i++) {
                portIdField.addItem(getString("Port") + " " + i);
            }
        }
        portIdField.setEnabled(true);

        return portIdField;
    }

    private JComboBox getPortIdField(int portId) {
        if (portIdField == null) {
            portIdField = new JComboBox();
            portIdField.addItem(portId);
        }
        portIdField.setEnabled(false);

        return portIdField;
    }

    private JComboBox getLogicalPortIdField() {
        if (logicalPortIdField == null) {
            logicalPortIdField = new JComboBox();
            for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
                logicalPortIdField.addItem(getString("ONT") + " " + i);
            }
        }
        logicalPortIdField.setEnabled(true);

        return logicalPortIdField;
    }

    private JComboBox getLogicalPortIdField(int logicalPortId) {
        if (logicalPortIdField == null) {
            logicalPortIdField = new JComboBox();
            logicalPortIdField.addItem(logicalPortId);
        }
        logicalPortIdField.setEnabled(false);

        return logicalPortIdField;
    }

    private JComboBox getEtherPortIndexField() {
        if (etherPortIndexField == null) {
            etherPortIndexField = new JComboBox();
            for (int i = 1; i <= 32; i++) {
                etherPortIndexField.addItem("UNI " + i);
            }
        }
        etherPortIndexField.setEnabled(true);

        return etherPortIndexField;
    }

    private JComboBox getEtherPortIndexField(int etherPortIndex) {
        if (etherPortIndexField == null) {
            etherPortIndexField = new JComboBox();
            etherPortIndexField.addItem(etherPortIndex);
        }
        etherPortIndexField.setEnabled(false);

        return etherPortIndexField;
    }

    private MultiItemSelector getProfileField() {
        if (profileField == null) {
            profileField = new MultiItemSelector();
        }
        profileField.setSelectionChoices(app.getOnuMulticastCtrlProfileName());

        return profileField;
    }

    /*
    private MultiItemSelector getProfileField(String[] profiles) {
        if (profileField == null) {
            profileField = new MultiItemSelector();
        }
        Vector v = new Vector();
        v.add(profiles);
        profileField.setSelectionChoices(v);

        return profileField;
    }
    */
    private MultiItemSelector getProfileField(String profile) {
        if (profileField == null) {
            profileField = new MultiItemSelector();
        }
        profileField.setSelectionChoices(app.getOnuMulticastCtrlProfileName());

        if (profile != null) {
            String[] s = profile.split(",");
            Vector v = new Vector();
            for (int i = 0; i < s.length; i++)
                v.addElement(s[i]);
            profileField.setSelectedChoices(v);
        }

        return profileField;
    }

    private void doApply() {
        int moduleId = isAdd ? getSelectedSlotId() : bean.getModuleId();
        int deviceId = 1;
        int portId = isAdd ? getSelectedPortId() : bean.getPortId();
        int logicalPortId = isAdd ? getSelectedLogicalPortId() : bean.getLogicalPortId();
        int etherPortIndex = isAdd ? getSelectedEtherPortIndex() : bean.getEtherPortIndex();
        String profile = "";
        for (int i = 0; i < profileField.getSelectedChoices().size(); i++) {
            if (i != 0)
                profile += ",";
            profile += profileField.getSelectedChoices().get(i);
        }

        String message = "";
        if (isAdd && moduleId < 0) {
            message = getString("Please select a Module ID!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        //if (isAdd && deviceId < 0) {
        //    message = getString("Please select a Device ID!");
        //    JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
        //    return;
        //}

        if (isAdd && portId < 0) {
            message = getString("Please select a Port ID!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        if (isAdd && logicalPortId < 0) {
            message = getString("Please select a Logical Port ID!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        if (isAdd && etherPortIndex < 0) {
            message = getString("Please select an UNI ID!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        if (profile == null || profile.equals("")) {
            message = getString("Please select a Profile at least!");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }
        profile = profile.trim();

        //check the index whether existed. if not then add it, else ignore.
        if (isAdd && findOnuMulticastCtrlHead(moduleId, deviceId, portId, logicalPortId, etherPortIndex)) {
            message = getString("Err_UNI_Exist");
            JOptionPane.showMessageDialog(this, message, getString("Warning"), JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        model = new OnuMulticastCtrlHeadModel(moduleId, deviceId, portId, logicalPortId, etherPortIndex, profile);
        try {
            if (isAdd)
                ((OnuMulticastCtrlHeadTablePanel) parent).addProcess(model);
            else
                ((OnuMulticastCtrlHeadTablePanel) parent).modifyProcess(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean findOnuMulticastCtrlHead(int moduleId, int deviceId, int portId, int logicalPortId, int etherPortIndex) {
        OnuMulticastCtrlHeadTableModel model = app.getOnuMulticastCtrlHeadTableModel(fApplication, moduleId, portId, logicalPortId, etherPortIndex);

        return (model != null && model.getRowCount() > 0);
    }

    private void doClose() {
        model = null;
        dispose();
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

    public static String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fApplication.getActiveDeviceManager().getGuiComposer().getString(s);
    }

    public int getSelectedSlotId() {
        if (moduleIdField.getSelectedItem() != null) {
            String item = (String) moduleIdField.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return -1;
    }

    public int getSelectedPortId() {
        if (portIdField.getSelectedItem() != null) {
            String item = (String) portIdField.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return -1;
    }

    public int getSelectedLogicalPortId() {
        if (logicalPortIdField.getSelectedItem() != null) {
            String item = (String) logicalPortIdField.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return -1;
    }

    public int getSelectedEtherPortIndex() {
        if (etherPortIndexField.getSelectedItem() != null) {
            String item = (String) etherPortIndexField.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return -1;
    }

}