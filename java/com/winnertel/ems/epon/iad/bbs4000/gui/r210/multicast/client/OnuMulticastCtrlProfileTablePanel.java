/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.standard.Application;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.Vector;

public class OnuMulticastCtrlProfileTablePanel extends UPanel {

    private OnuMulticastCtrlApplication app = null;

    private JPanel infoPane = null;
    private JScrollPane listPane = null;
    private JList list = null;
    private JTable table = null;
    private JScrollPane tablePane = null;

    private JPanel buttonPane = null;
    private JButton btnAddProfile;
    private JButton btnDeleteProfile;
    private JButton btnAddProfileData;
    private JButton btnDeleteProfileData;
    private JButton btnRefresh;

    public OnuMulticastCtrlProfileTablePanel(IApplication app) {
        super(app);
        init();
        doRefresh();
    }

    public void initGui() {
        if (app == null)
            app = OnuMulticastCtrlApplication.getInstance();
        app.setNodeName(fApplication.getActiveDeviceManager().getName());

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), getString("Multicast Profile"), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.black));
        add(getInfoPane(), BorderLayout.CENTER);
        add(getButtonPane(), BorderLayout.SOUTH);
        //setSize(640, 480);
    }

    public OnuMulticastCtrlApplication getApp() {
        return app;
    }

    protected void initForm() {
    }

    private JPanel getInfoPane() {
        if (infoPane == null) {
            infoPane = new JPanel();
            infoPane.setLayout(new BorderLayout());
            infoPane.add(getListPane(), BorderLayout.WEST);
            infoPane.add(getTablePane(), BorderLayout.CENTER);
        }

        return infoPane;
    }

    private JScrollPane getListPane() {
        if (listPane == null) {
            listPane = new JScrollPane();
            listPane.setViewportView(getList());
            listPane.setPreferredSize(new Dimension(256, 200));
        }

        return listPane;
    }

    private JScrollPane getTablePane() {
        if (tablePane == null) {
            tablePane = new JScrollPane();
            tablePane.setViewportView(getTableObject());
        }

        return tablePane;
    }

    private JList getList() {
        if (list == null) {
            list = new JList(getApp().getOnuMulticastCtrlProfileName());
            list.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (list.getSelectedIndex() >= 0)
                        btnDeleteProfile.setEnabled(true);
                    if (!e.getValueIsAdjusting()) {
                        doRefreshProfileData();
                    }
                }
            });
        }

        return list;
    }

    private JTable getTableObject() {
        if (table == null) {
            table = new JTable(new OnuMulticastCtrlProfileTableModel(fApplication));
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (table.getSelectedRow() >= 0)
                        btnDeleteProfileData.setEnabled(true);
                }
            });
        }

        return table;
    }

    private JPanel getButtonPane() {
        if (buttonPane == null) {
            buttonPane = new JPanel(new BorderLayout());
            buttonPane.setBorder(BorderFactory.createEtchedBorder());
            JPanel leftPane = new JPanel();
            leftPane.add(getAddProfileButton(), null);
            leftPane.add(getDeleteProfileButton(), null);
            JPanel centerPane = new JPanel();
            JPanel rightPane = new JPanel();
            rightPane.add(getAddProfileDataButton(), null);
            rightPane.add(getDeleteProfileDataButton(), null);
            rightPane.add(getRefreshButton(), null);
            buttonPane.add(leftPane, BorderLayout.WEST);
            buttonPane.add(centerPane, BorderLayout.CENTER);
            buttonPane.add(rightPane, BorderLayout.EAST);
        }

        return buttonPane;
    }
    
    private boolean checkPermission( String anActionId ) {
        if ( fApplication.isDebug() || anActionId == null || anActionId.length() == 0 ) {
            return true;
        }

        final ISecurityManager securityManager = fApplication.getSecurityManager();
        final ISession session = fApplication.getSession();
        if ( !securityManager.isAuthorized( session, anActionId ) ) {
            MessageDialog.showPermissionDeniedDialog( fApplication );
            return false;
        } else {
            return true;
        }
    }

    private JButton getAddProfileButton() {
        if (btnAddProfile == null) {
            btnAddProfile = new JButton();
            btnAddProfile.setText(getString("Add Profile"));
            btnAddProfile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doAddProfile();
                }
            });
        }

        return btnAddProfile;
    }

    private JButton getDeleteProfileButton() {
        if (btnDeleteProfile == null) {
            btnDeleteProfile = new JButton();
            btnDeleteProfile.setText(getString("Delete Profile"));
            btnDeleteProfile.setEnabled(false);
            btnDeleteProfile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doDeleteProfile();
                }
            });
        }

        return btnDeleteProfile;
    }

    private JButton getAddProfileDataButton() {
        if (btnAddProfileData == null) {
            btnAddProfileData = new JButton();
            btnAddProfileData.setText(getString("Add"));
            btnAddProfileData.setEnabled(false);
            btnAddProfileData.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doAddProfileData();
                }
            });
        }

        return btnAddProfileData;
    }

    private JButton getDeleteProfileDataButton() {
        if (btnDeleteProfileData == null) {
            btnDeleteProfileData = new JButton();
            btnDeleteProfileData.setText(getString("Delete"));
            btnDeleteProfileData.setEnabled(false);
            btnDeleteProfileData.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doDeleteProfileData();
                }
            });
        }

        return btnDeleteProfileData;
    }

    private JButton getRefreshButton() {
        if (btnRefresh == null) {
            btnRefresh = new JButton();
            btnRefresh.setText(getString("Refresh"));
            btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doRefresh();
                }
            });
        }

        return btnRefresh;
    }

    private void retrieveData() {
        retrieveProfile();
        retrieveProfileData();
    }

    private void retrieveProfile() {
        Vector profileList = getApp().getOnuMulticastCtrlProfileName();
        if (profileList != null) {
            getList().removeAll();
            getList().setListData(profileList);
            getList().repaint();
        }
    }

    private void retrieveProfileData() {
        if (getList().getSelectedIndex() >= 0) {
            String selectedProfile = (String) getList().getSelectedValue();
            if (selectedProfile != null) {
                OnuMulticastCtrlProfileTableModel model = getApp().retrieveOnuMulticastCtrlProfileTableModelById(fApplication, selectedProfile);
                if (model != null) {
                    getTableObject().setModel(model);
                    getTableObject().repaint();
                }
            }
        } else {
            getTableObject().setModel(new OnuMulticastCtrlProfileTableModel(fApplication));
            getTableObject().repaint();
        }
    }

    private void doAddProfile() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlProfile" ) ) return;
        OnuMulticastCtrlProfileTabelAddPanel ui = new OnuMulticastCtrlProfileTabelAddPanel(this, getString("Add Profile"), true, fApplication, app);
        ui.setVisible(true);

        /*
        OnuMulticastCtrlProfileModel model = ui.getModel();
        if (model != null)
            addProfileProcess(model);
        */
    }

    public void addProfileProcess(OnuMulticastCtrlProfileModel model) {
        if (model == null)
            return;

        //DB-Operation
        boolean result = true;
        result = getApp().addOnuMulticastCtrlProfileProcess(model);
        if (result) {
            doRefresh();
            list.setSelectedValue(model.getProfile(), true);
        }
    }

    private void doDeleteProfile() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlProfile" ) ) return;
        String profileName = (String) list.getSelectedValue();
        if (profileName == null)
            return;

        //DB-Operation
        boolean result = true;
        result = getApp().deleteOnuMulticastCtrlProfileProcess(profileName);
        if (result) {
            doRefresh();
        }
    }

    private void doAddProfileData() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlProfile" ) ) return;
        OnuMulticastCtrlProfileTabelAddPanel ui = new OnuMulticastCtrlProfileTabelAddPanel(this, getString("Add"), true, fApplication, app);
        ui.setVisible(true);

        /*
        OnuMulticastCtrlProfileModel model = ui.getModel();
        if (model != null)
            addProfileDataProcess(model);
        */
    }

    public void addProfileDataProcess(OnuMulticastCtrlProfileModel model) {
        if (model == null)
            return;

        //DB-Operation
        boolean result = true;
        result = getApp().addOnuMulticastCtrlProfileProcess(model);
        if (result) {
            doRefreshProfileData();
            list.setSelectedValue(model.getProfile(), true);
        }
    }

    private void doDeleteProfileData() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlProfile" ) ) return;
        OnuMulticastCtrlProfileTableModel tableModel = (OnuMulticastCtrlProfileTableModel) table.getModel();
        if (tableModel == null)
            return;

        if (table.getSelectedRow() < 0)
            return;

        OnuMulticastCtrlProfileModel model = tableModel.getRow(table.getSelectedRow());
        if (model == null)
            return;

        //DB-Operation
        boolean result = true;
        result = getApp().deleteOnuMulticastCtrlProfileProcess(model);
        if (result) {
            doRefresh();
            if (table.getModel().getRowCount() <= 0)
                doRefreshProfile();
        }
    }

    private void doRefresh() {
        retrieveData();
        btnAddProfileData.setEnabled(!(list.getModel().getSize() <= 0));
        btnDeleteProfileData.setEnabled(false);
    }

    private void doRefreshProfile() {
        retrieveProfile();
        btnAddProfileData.setEnabled(!(list.getModel().getSize() <= 0));
        btnDeleteProfileData.setEnabled(false);
    }

    private void doRefreshProfileData() {
        retrieveProfileData();
        btnAddProfileData.setEnabled(!(list.getModel().getSize() <= 0));
        btnDeleteProfileData.setEnabled(false);
    }

    public void refresh() {
    }

    public void updateModel() {
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
    }

    public static void main(String[] args) { //for test
        Application app = new Application(new Locale("en", "US"));
        OnuMulticastCtrlProfileTablePanel panel = new OnuMulticastCtrlProfileTablePanel(app);
        panel.setVisible(true);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}