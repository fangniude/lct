package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.standard.Application;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.BBS1000OnuFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client.OnuMulticastCtrlApplication;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client.OnuMulticastCtrlHeadTableModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client.OnuMulticastCtrlProfileTableModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlHeadModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlModel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuCtcMulticastCtrlTable;

public class OnuMulticastCtrlHeadTablePanel extends UPanel implements ActionListener {

    private BBS1000OnuFilterPanel filterPane = null;

    private OnuMulticastCtrlApplication app = null;

    private JTable table = null;
    private JScrollPane tablePane = null;

    private JPanel buttonPane = null;
    private JButton btnAdd;
    private JButton btnModify;
    private JButton btnDelete;
    private JButton btnRefresh;

    public OnuMulticastCtrlHeadTablePanel(IApplication app) {
        super(app);
        init();
        doRefresh();
    }

    public void initGui() {
        if (app == null)
            app = OnuMulticastCtrlApplication.getInstance();
        app.setNodeName(fApplication.getActiveDeviceManager().getName());

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), getString("Multicast Control"), TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.black));
        add(getFilterPane(), BorderLayout.NORTH);
        add(getTablePane(), BorderLayout.CENTER);
        add(getButtonPane(), BorderLayout.SOUTH);
        //setSize(640, 300);
    }

    public OnuMulticastCtrlApplication getApp() {
        return app;
    }

    protected void initForm() {
    }

    private BBS1000OnuFilterPanel getFilterPane() {
        if (filterPane == null) {
            filterPane = new BBS1000OnuFilterPanel(fApplication);
            filterPane.addActionListener(this);
        }
        filterPane.refresh();

        return filterPane;
    }

    public void actionPerformed(ActionEvent e) {
        doRefresh(filterPane.getSelectedSlotId(), filterPane.getSelectedPortId(), filterPane.getSelectedOnuId());
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

    private JScrollPane getTablePane() {
        if (tablePane == null) {
            tablePane = new JScrollPane();
            tablePane.setViewportView(getTableObject());
            //tablePane.setPreferredSize(new Dimension(385, 150));
        }

        return tablePane;
    }

    private JTable getTableObject() {
        if (table == null) {
            table = new JTable(new OnuMulticastCtrlHeadTableModel(fApplication));
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (table.getSelectedRow() >= 0)
                        btnDelete.setEnabled(true);
                }
            });
        }

        return table;
    }

    private JPanel getButtonPane() {
        if (buttonPane == null) {
            buttonPane = new JPanel();
            buttonPane.setBorder(BorderFactory.createEtchedBorder());
            buttonPane.add(getAddButton(), null);
            buttonPane.add(getModifyButton(), null);
            buttonPane.add(getDeleteButton(), null);
            buttonPane.add(getRefreshButton(), null);
        }

        return buttonPane;
    }

    private JButton getAddButton() {
        if (btnAdd == null) {
            btnAdd = new JButton();
            btnAdd.setText(getString("Add"));
            btnAdd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doAdd();
                }
            });
        }

        return btnAdd;
    }

    private JButton getModifyButton() {
        if (btnModify == null) {
            btnModify = new JButton();
            btnModify.setText(getString("Modify"));
            btnModify.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doModify();
                }
            });
        }

        return btnModify;
    }

    private JButton getDeleteButton() {
        if (btnDelete == null) {
            btnDelete = new JButton();
            btnDelete.setText(getString("Delete"));
            btnDelete.setEnabled(false);
            btnDelete.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doDelete();
                }
            });
        }

        return btnDelete;
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
        OnuMulticastCtrlHeadTableModel model = getApp().getOnuMulticastCtrlHeadTableModel(fApplication);
        if (model != null) {
            getTableObject().setModel(model);
            getTableObject().repaint();
        }
    }

    private void retrieveData(int moduleId, int portId, int logicalPortId) {
        OnuMulticastCtrlHeadTableModel model = getApp().getOnuMulticastCtrlHeadTableModel(fApplication, moduleId, portId, logicalPortId);
        if (model != null) {
            getTableObject().setModel(model);
            getTableObject().repaint();
        }
    }

    private void doAdd() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlHead" ) ) return;
        OnuMulticastCtrlHeadTabelAddPanel ui = new OnuMulticastCtrlHeadTabelAddPanel(this, getString("Add"), true, fApplication, app, null);
        ui.setVisible(true);
    }

    public boolean addProcess(OnuMulticastCtrlHeadModel model) {
        if (model == null)
            return false;

        //construct OnuMulticastCtrlModel
        OnuMulticastCtrlModel multicastCtrlModel = new OnuMulticastCtrlModel();
        multicastCtrlModel.setModuleId(model.getModuleId());
        multicastCtrlModel.setDeviceId(model.getDeviceId());
        multicastCtrlModel.setPortId(model.getPortId());
        multicastCtrlModel.setLogicalPortId(model.getLogicalPortId());
        multicastCtrlModel.setEtherPortIndex(model.getEtherPortIndex());
        multicastCtrlModel.setProfile(model.getProfile());

        //MIB-Operation
        boolean result = false;
        OnuMulticastCtrlProfileTableModel profileData = getApp().getOnuMulticastCtrlProfileTableModelById(fApplication, model.getProfile()); //get data (list) from table 'OnuMulticastCtrlProfile' by 'profile'
        if (profileData != null) {
            for (int i = 0; i < profileData.getRowCount(); i++) {
                OnuCtcMulticastCtrlTable bean = new OnuCtcMulticastCtrlTable(fApplication.getSnmpProxy());
                OnuMulticastCtrlProfileModel profileModel = profileData.getRow(i);

                multicastCtrlModel.getProfileData().add(profileModel);

                //head
                bean.setUtsDot3OnuModuleId(model.getModuleId());
                bean.setUtsDot3OnuDeviceId(model.getDeviceId());
                bean.setUtsDot3OnuPortId(model.getPortId());
                bean.setUtsDot3OnuLogicalPortId(model.getLogicalPortId());
                bean.setUtsDot3OnuEtherPortIndex(model.getEtherPortIndex());

                //profile
                bean.setUtsDot3OnuMCastVlan(profileModel.getVlan());
                bean.setUtsDot3OnuMCastGroupStart(profileModel.getGroupStart());
                bean.setUtsDot3OnuMCastGroupEnd(profileModel.getGroupEnd());
                bean.setUtsDot3OnuAuthType(profileModel.getAuthType());

                try {
                    result = bean.add();
                } catch (MibBeanException e) {
                    result = false;
                    e.printStackTrace();
                    break;
                }
            }
        }

        //DB-Operation
        if (result)
            result = getApp().addOnuMulticastCtrlHeadProcess(multicastCtrlModel);

        doRefresh();

        return result;
    }

    private void doModify() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlHead" ) ) return;
        OnuMulticastCtrlHeadTableModel model = (OnuMulticastCtrlHeadTableModel) getTableObject().getModel();
        int selectedRow = getTableObject().getSelectedRow();
        if (selectedRow < 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }
        OnuMulticastCtrlHeadModel bean = model.getRow(selectedRow);

        OnuMulticastCtrlHeadTabelAddPanel ui = new OnuMulticastCtrlHeadTabelAddPanel(this, getString("Modify"), true, fApplication, app, bean);
        ui.setVisible(true);
    }

    public boolean modifyProcess(OnuMulticastCtrlHeadModel model) {
        if (deleteProcess(model))
            return addProcess(model);

        return false;
    }

    private void doDelete() {
    	if ( !checkPermission( "Modify_OnuMulticastCtrlHead" ) ) return;
        OnuMulticastCtrlHeadTableModel tableModel = (OnuMulticastCtrlHeadTableModel) table.getModel();
        if (tableModel == null)
            return;

        if (table.getSelectedRow() < 0)
            return;

        OnuMulticastCtrlHeadModel model = tableModel.getRow(table.getSelectedRow());

        deleteProcess(model);
    }

    private boolean deleteProcess(OnuMulticastCtrlHeadModel model) {
        if (model == null)
            return false;

        //construct OnuMulticastCtrlModel
        OnuMulticastCtrlModel multicastCtrlModel = new OnuMulticastCtrlModel();
        multicastCtrlModel.setModuleId(model.getModuleId());
        multicastCtrlModel.setDeviceId(model.getDeviceId());
        multicastCtrlModel.setPortId(model.getPortId());
        multicastCtrlModel.setLogicalPortId(model.getLogicalPortId());
        multicastCtrlModel.setEtherPortIndex(model.getEtherPortIndex());
        multicastCtrlModel.setProfile(model.getProfile());

        //MIB-Operation
        boolean result = true;
        OnuMulticastCtrlProfileTableModel profileData = getApp().getOnuMulticastCtrlProfileTableModelById(fApplication, model.getProfile()); //get data (list) from table 'OnuMulticastCtrlProfile' by 'profile'
        if (profileData != null) {
            for (int i = 0; i < profileData.getRowCount(); i++) {
                if (!result)
                    break;

                OnuCtcMulticastCtrlTable bean = new OnuCtcMulticastCtrlTable(fApplication.getSnmpProxy());
                OnuMulticastCtrlProfileModel profileModel = profileData.getRow(i);
                multicastCtrlModel.getProfileData().add(profileModel);

                //head
                bean.setUtsDot3OnuModuleId(model.getModuleId());
                bean.setUtsDot3OnuDeviceId(model.getDeviceId());
                bean.setUtsDot3OnuPortId(model.getPortId());
                bean.setUtsDot3OnuLogicalPortId(model.getLogicalPortId());
                bean.setUtsDot3OnuEtherPortIndex(model.getEtherPortIndex());

                //profile
                bean.setUtsDot3OnuMCastVlan(profileModel.getVlan());
                bean.setUtsDot3OnuMCastGroupStart(profileModel.getGroupStart());
                //bean.setUtsDot3OnuMCastGroupEnd(profileModel.getGroupEnd());
                //bean.setUtsDot3OnuAuthType(profileModel.getAuthType());

                try {
                    result = bean.delete();
                } catch (MibBeanException e) {
                    result = false;
                    e.printStackTrace();
                }
            }
        }

        //DB-Operation
        if (result)
            result = getApp().deleteOnuMulticastCtrlHeadProcess(multicastCtrlModel);

        doRefresh();

        return result;
    }

    private void doRefresh() {
        retrieveData();
        btnDelete.setEnabled(false);
    }

    private void doRefresh(int moduleId, int portId, int logicalPortId) {
        retrieveData(moduleId, portId, logicalPortId);
        btnDelete.setEnabled(false);
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
        OnuMulticastCtrlHeadTablePanel panel = new OnuMulticastCtrlHeadTablePanel(app);
        panel.setVisible(true);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
