package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class ProfileChooser extends JPanel implements ActionListener {

    private IApplication fApplication = null;
    private DvmStringMap fStringMap = null;

    private int selectionMode = ListSelectionModel.SINGLE_SELECTION;
    private String profile = null;
    private SnmpTable fTable = null;
    private UPanel fPanel = null;
    private SnmpDialog fDialog = null;

    private SnmpMibBean selectedProfile = null;
    private long selectedProfileIndex = -1;

    private JTextField profileField = null;
    private JButton browseButton = new JButton("...");

    public ProfileChooser(IApplication app) {
        fApplication = app;
        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        initialize();
    }

    public ProfileChooser(IApplication app, String profile) {
        this(app);
        setProfile(profile);
    }

    private void initialize() {
        NTLayout layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 0, 0);
        setLayout(layout);
        profileField = new JTextField();
        profileField.setEditable(false);
        profileField.setPreferredSize(new Dimension(200, 24));
        add(profileField);

        browseButton.setPreferredSize(new Dimension(20, 24));
        browseButton.setFocusPainted(false);
        browseButton.addActionListener(this);
        add(browseButton);
    }

    public int getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(int selectionMode) {
        this.selectionMode = selectionMode;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public SnmpMibBean getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(SnmpMibBean row) {
        selectedProfile = row;
        profileField.setText(selectedProfile.toString());
        if (row.getIndex(0) instanceof Integer)
            selectedProfileIndex = ((Integer) row.getIndex(0)).longValue();
        else
            selectedProfileIndex = (Long) row.getIndex(0);
    }

    public long getSelectedProfileIndex() {
        return selectedProfileIndex;
    }

    /*
   In order to show the profile name when setSelectedProfileIndex(int) method is
   invoke, the refresh() must be called first.
    */
    public void setSelectedProfileIndex(long index) {
        if (fTable == null) {
            selectedProfileIndex = index;
            profileField.setText("" + index);
            return;
        }

        for (int i = 0; i < fTable.getRowCount(); i++) {
            SnmpTableModel model = (SnmpTableModel) fTable.getModel();
            SnmpMibBean bean = model.getRow(i);

            if (bean.getIndex(0).toString().equals(String.valueOf(index))) {
                profileField.setText(bean.toString());
                selectedProfileIndex = index;
                fTable.clearSelection();
                fTable.getSelectionModel().setSelectionInterval(i, i);
                return;
            }
        }

        selectedProfileIndex = index;
        profileField.setText("" + index);
    }

    private void processProfileChangedEvent() {
        if (fPanel == null || !fPanel.getName().equals(profile)) {
            ViewComposer composer = (ViewComposer) fApplication.getActiveDeviceManager().getProperties().get("ViewComposer");

            if (composer == null) {
                composer = new ViewComposer(fApplication);
                fApplication.getActiveDeviceManager().getProperties().put("ViewComposer", composer);
            }

            Window win = SwingUtilities.getWindowAncestor(this);
            if (win == null) {
                throw new NullPointerException("The Owner Window is Null.");
            }

            fPanel = composer.composeIconSnmpTablePane(profile, win);
            fPanel.setName(profile);

            fTable = fPanel.getTable();

            //clear the old data in previous panel.
            selectedProfile = null;
            selectedProfileIndex = -1;
            profileField.setText("");
        }
    }

    public void refresh() {
        processProfileChangedEvent();
        fPanel.refresh();

        SnmpTableModel model = (SnmpTableModel) fTable.getModel();
        if (selectedProfileIndex != -1) {
            setSelectedProfileIndex(selectedProfileIndex);
        } else {
            if (fTable.getRowCount() > 0) {
                selectedProfile = model.getRow(0);
                if (selectedProfile.getIndex(0) instanceof Integer)
                    selectedProfileIndex = ((Integer) selectedProfile.getIndex(0)).longValue();
                else
                    selectedProfileIndex = (Long) selectedProfile.getIndex(0);
                profileField.setText(selectedProfile.toString());
            }
        }
    }

    private SnmpDialog getSnmpDialog() {
        if (fDialog == null) {
            Window win = SwingUtilities.getWindowAncestor(this);
            fDialog = new SnmpDialog(win);
            fTable.addMouseListener(fDialog);
        }

        return fDialog;
    }

    public boolean isEnabled() {
        return browseButton.isEnabled();
    }

    public void setEnabled(boolean b) {
        browseButton.setEnabled(b);
    }

    private void showChooserDialog() {
        fDialog = getSnmpDialog();

        fDialog.repaintSnmpTablePane();//paint the new fPanel in SnmpDialog.

        //set default selected row if no row is selected.
        if (fTable.getRowCount() > 0 && fTable.getSelectedRow() == -1)
            fTable.getSelectionModel().setSelectionInterval(0, 0);

        int option = fDialog.showChooserDialog();

        if (option == SnmpDialog.APPROVE_OPTION) {
            if (fTable.getSelectedRow() != -1) {
                SnmpTableModel model = (SnmpTableModel) fTable.getModel();
                selectedProfile = model.getRow(fTable.getSelectedRow());
                if (selectedProfile.getIndex(0) instanceof Integer)
                    selectedProfileIndex = ((Integer) selectedProfile.getIndex(0)).longValue();
                else
                    selectedProfileIndex = (Long) selectedProfile.getIndex(0);
                profileField.setText(selectedProfile.toString());
            }
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        showChooserDialog();
    }

    class SnmpDialog extends JDialog implements ActionListener, MouseListener {
        final static int APPROVE_OPTION = 1;
        final static int CANCEL_OPTION = 0;
        int returnValue = CANCEL_OPTION;

        JPanel panel = null;

        public SnmpDialog(Window win) {
            super(win, Dialog.ModalityType.DOCUMENT_MODAL);
            init();
        }

        protected void init() {
            Container contentPane = getContentPane();
            contentPane.setLayout(new BorderLayout());

            JPanel controlPane = new JPanel();
            JButton btn = new JButton(fStringMap.getString("OK"));
            btn.setActionCommand("ok");
            btn.addActionListener(this);
            controlPane.add(btn);

            btn = new JButton(fStringMap.getString("Cancel"));
            btn.setActionCommand("cancel");
            btn.addActionListener(this);
            controlPane.add(btn);
            contentPane.add(controlPane, BorderLayout.SOUTH);

//            contentPane.add(fPanel, BorderLayout.CENTER);
            setPreferredSize(new Dimension(600, 400));
            setResizable(false);
        }

        public void repaintSnmpTablePane() {
            Container contentPane = getContentPane();

            if (panel == null || panel != fPanel) {
                if (panel != null) {
                    contentPane.remove(panel);
                }

                if (fPanel != null) {
                    contentPane.add(fPanel, BorderLayout.CENTER);
                    setTitle(fStringMap.getString("Choose Profile") + " - " + fStringMap.getString(fPanel.getName()));
                } else {
                    setTitle(fStringMap.getString("Choose Profile"));
                }

                panel = fPanel;
            }
        }

        public int showChooserDialog() {
            pack();
            setLocationRelativeTo(fApplication.getTopMostFrame());
            setVisible(true);

            return returnValue;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ok")) {
                if (fTable.getSelectedRowCount() > 0) {
                    setVisible(false);
                    returnValue = APPROVE_OPTION;
                }
            } else if (e.getActionCommand().equals("cancel")) {
                setVisible(false);
                returnValue = CANCEL_OPTION;
            } else if (e.getActionCommand().equals("refresh")) {
                ProfileChooser.this.refresh();
            }
        }

        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                if (fTable.getSelectedRowCount() > 0) {
                    setVisible(false);
                    returnValue = APPROVE_OPTION;
                }
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

}