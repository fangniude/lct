package com.winnertel.ems.epon.iad.common.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.common.mib.SwitchGeneralMBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Description: re-fact this class for ONU404I
 * 
 * Copyright: Copyright(c) 2007 Company: UTStarcom Date: 2007-11-28 Time:
 * ����11:05:41
 * 
 * @author Tsinyun
 * @version 1.0
 */
public class SwitchGeneralConfigPanel extends UPanel implements ActionListener {

    JButton EraseConfigfileButton = new JButton(fStringMap.getString("Erase Config File"));
    JButton SaveConfigfileButton = new JButton(fStringMap.getString("Save Config File"));
    JButton ResetNodeButton = new JButton(fStringMap.getString("Reset Node"));
    JButton DownloadImageFileToNodeButton = new JButton(fStringMap.getString("Download Image File To Node"));
    JButton DownloadConfigFileToNodeButton = new JButton(fStringMap.getString("Download Config File To Node"));
    JButton UploadConfigFileFromNodeButton = new JButton(fStringMap.getString("Upload Config File to TFTP Server"));

    private IPAddressField tftpserveripText = new IPAddressField();

    JButton tftpserverIPApplyButton = new JButton(fStringMap.getString("Apply"));
    JButton tftpserverRefreshButton = new JButton(fStringMap.getString("Refresh"));

    JLabel statusLabel = new JLabel("");
//    JLabel softwareversionvalue = new JLabel(" ");

    final static String resetnodecmd = "resetnodecmd";
    final static String eraseconfigcmd = "eraseconfigcmd";
    final static String saveconfigcmd = "saveconfigcmd";
    final static String downloadimagecmd = "downloadimagecmd";
    final static String downloadconfigcmd = "downloadconfigcmd";
    final static String uploadimagecmd = "uploadimagecmd";
    final static String uploadconfigcmd = "uploadconfigcmd";

    public SwitchGeneralConfigPanel(IApplication app) {
        super(app);
        setModel(new SwitchGeneralMBean(app.getSnmpProxy()));
        initGui();
    }

    protected void initGui() {

        ResetNodeButton.setActionCommand(resetnodecmd);
        ResetNodeButton.addActionListener(this);

        EraseConfigfileButton.setActionCommand(eraseconfigcmd);
        EraseConfigfileButton.addActionListener(this);

        SaveConfigfileButton.setActionCommand(saveconfigcmd);
        SaveConfigfileButton.addActionListener(this);

        DownloadImageFileToNodeButton.setActionCommand(downloadimagecmd);
        DownloadImageFileToNodeButton.addActionListener(this);

        DownloadConfigFileToNodeButton.setActionCommand(downloadconfigcmd);
        DownloadConfigFileToNodeButton.addActionListener(this);

        UploadConfigFileFromNodeButton.setActionCommand(uploadconfigcmd);
        UploadConfigFileFromNodeButton.addActionListener(this);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
        
//        baseInfoPanel.add(new JLabel(fStringMap.getString("Software Version") + ":"));
//        softwareversionvalue.setText("");
//        baseInfoPanel.add(softwareversionvalue);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(fStringMap.getString("TFTP Server IPAddress") + ":"));
        baseInfoPanel.add(tftpserveripText);
        baseInfoPanel.add(new HSpacer());

        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SwitchGeneralInformation");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        baseInfoPanel.add(btApply);
        baseInfoPanel.add(btRefresh);
        baseInfoPanel.add(new HSpacer());

        JPanel ConfigFilePanel = new JPanel();
        layout = new NTLayout(5, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ConfigFilePanel.setLayout(layout);

        ConfigFilePanel.add(EraseConfigfileButton);
        ConfigFilePanel.add(new HSpacer());

        ConfigFilePanel.add(SaveConfigfileButton);
        ConfigFilePanel.add(new HSpacer());

        ConfigFilePanel.add(DownloadConfigFileToNodeButton);
        ConfigFilePanel.add(new HSpacer());

        ConfigFilePanel.add(UploadConfigFileFromNodeButton);
        ConfigFilePanel.add(new HSpacer());
        
        ConfigFilePanel.add(DownloadImageFileToNodeButton);
        ConfigFilePanel.add(new HSpacer());
        
        ConfigFilePanel.setBorder(BorderFactory.createEtchedBorder());
        // Reset Node..
        JPanel ResetNodePanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ResetNodePanel.setLayout(layout);
        ResetNodePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Node Reset")));

        ResetNodePanel.add(ResetNodeButton);
        ResetNodePanel.add(new JLabel(""));
        ResetNodePanel.add(new HSpacer());

        JPanel statusPanel = new JPanel();
        layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        statusPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Operation Result")));
        statusPanel.setLayout(layout);
        statusPanel.add(statusLabel);
        statusPanel.add(new HSpacer());

//        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
//        SnmpTablePane tablepanel = (SnmpTablePane) composer.composeSnmpTablePane("File System Table");
//        tablepanel.setPreferredSize(new Dimension(100, 100));
//        add(tablepanel, BorderLayout.SOUTH);
//        tablepanel.refresh();

        // all panel goes here..
        JPanel filePanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        filePanel.setLayout(layout);
        filePanel.add(baseInfoPanel);
        filePanel.add(ConfigFilePanel);
        filePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("File Management")));
                
        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(filePanel);
        allPanel.add(statusPanel);
        allPanel.add(ResetNodePanel);
//        allPanel.add(tablepanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

    }

    public void updateModel() {
        SwitchGeneralMBean mbean = (SwitchGeneralMBean) getModel();
        mbean.setSysMaintTftpServer(tftpserveripText.getIPString());
    }

    public void refresh() {
        SwitchGeneralMBean mbean = (SwitchGeneralMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

       // softwareversionvalue.setText(mbean.getSysInfoSoftwareVer());
        tftpserveripText.setValue(mbean.getSysMaintTftpServer());

        // retrieve the data successfully.
        if (mbean.getSysMaintOperation() != null) {
            if (mbean.getSysMaintOperation() == 0) // Initial state.
            {
                statusLabel.setText(fStringMap.getString("No Operation Record."));
                return;
            }
            // file is transfering.
            if (mbean.getSysMaintOperResult().intValue() == 1) {
                // start the thread to refresh the button state.
                new ResultThread().start();
            } else {
                statusLabel.setText(compose(mbean));
            }
        } else {
            statusLabel.setText(fStringMap.getString("No Operation Record."));
        }
    }

    private int showConfirmDialog() {
        String msg = fStringMap.getString("Msg_Confirm");
        String title = fStringMap.getString("Titel_Confirm");
        return JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(), msg, title, JOptionPane.OK_CANCEL_OPTION);
    }

    private void showOKMessageDialog() {
        String msg = fStringMap.getString("Msg_Success");
        JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
    }

    private void showFailMessageDialog() {
        String msg = fStringMap.getString("Msg_Failed");
        JOptionPane.showMessageDialog(fApplication.getTopMostFrame(), msg);
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
    
    public void actionPerformed(ActionEvent event) {
    	if ( !checkPermission( "Modify_SwitchGeneralInformation" ) ) return;
    	
        final SwitchGeneralMBean mbean = (SwitchGeneralMBean) getModel();
        if (event.getActionCommand().equalsIgnoreCase(resetnodecmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;

            mbean.setSysMaintReset(new Integer(1));
            
            try {
                String msg = fStringMap.getString("Msg_Close_Window");
                MessageDialog.showInfoMessageDialog(fApplication, msg);
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.reset();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);
                showOKMessageDialog();
                fApplication.getTopMostFrame().dispatchEvent(
                        new WindowEvent(fApplication.getTopMostFrame(), WindowEvent.WINDOW_CLOSING));
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            }
            
        }

        if (event.getActionCommand().equalsIgnoreCase(eraseconfigcmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;

            mbean.setSysMaintEraseFile(new Integer(2));
            try {
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.eraseConfig_ImageFile();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);

                showOKMessageDialog();
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            }

        }

        if (event.getActionCommand().equalsIgnoreCase(saveconfigcmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;
            mbean.setSysMaintWriteMemory(new Integer(1));
            try {
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.writeMemory();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);

                showOKMessageDialog();
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            }
        }

        if (event.getActionCommand().equalsIgnoreCase(downloadconfigcmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;

            String msg = fStringMap.getString("Msg_Input_Filename");
            String tftpconfigfilelocation = JOptionPane.showInputDialog(fApplication.getTopMostFrame(), msg,
                    "flash:/onuImage/CONFIG.REG");
            if (tftpconfigfilelocation == null)
                return;

            mbean.setSysMaintRemoteFile(tftpconfigfilelocation);
            mbean.setSysMaintLocalFile(new Integer(2));
            mbean.setSysMaintOperation(new Integer(3));

            try {
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.download_Upload_files();
                        new ResultThread().start();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);

                showOKMessageDialog();
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            }
        }

        if (event.getActionCommand().equalsIgnoreCase(uploadconfigcmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;

            String msg = fStringMap.getString("Msg_Input_Filename");
            String tftpconfigfilelocation = JOptionPane.showInputDialog(fApplication.getTopMostFrame(), msg,
                    "flash:/onuImage/CONFIG.REG");
            if (tftpconfigfilelocation == null)
                return;

            mbean.setSysMaintRemoteFile(tftpconfigfilelocation);
            mbean.setSysMaintLocalFile(new Integer(2));
            mbean.setSysMaintOperation(new Integer(1));
            try {
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.download_Upload_files();
                        new ResultThread().start();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);

                showOKMessageDialog();
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            }
            
           
        }

        if (event.getActionCommand().equalsIgnoreCase(downloadimagecmd)) {

            if (showConfirmDialog() != JOptionPane.OK_OPTION)
                return;
            String msg = fStringMap.getString("Msg_Input_Filename");
            String tftpconfigfilelocation = JOptionPane.showInputDialog(fApplication.getTopMostFrame(), msg,
                    "flash:/onuImage/vxworks.z");
            if (tftpconfigfilelocation == null)
                return;

            int timeout = fApplication.getSnmpProxy().getTimeout();
            fApplication.getSnmpProxy().setTimeout(60);
            mbean.setSysMaintRemoteFile(tftpconfigfilelocation);
            mbean.setSysMaintLocalFile(new Integer(1));
            mbean.setSysMaintOperation(new Integer(3));

            try {
                Task task = new Task() {
                    public Object execute() throws Exception {
                        mbean.download_Upload_files();
                        new ResultThread().start();
                        return null;
                    }
                };
                task.setCancelable(false);
                fApplication.getTaskManager().executeTask(task);

                showOKMessageDialog();
            } catch (Exception e) {
                showFailMessageDialog();
                e.printStackTrace();
            } finally {
                fApplication.getSnmpProxy().setTimeout(timeout);
            }
        }
    }

    private String compose(SwitchGeneralMBean mbean) {
        StringBuffer sb = new StringBuffer();

        if (mbean.getSysMaintOperation() == 1) {
            sb.append(fStringMap.getString("uploadToTftp"));
        } else if (mbean.getSysMaintOperation() == 2) {
            sb.append(fStringMap.getString("uploadToFtp"));
        } else if (mbean.getSysMaintOperation() == 3) {
            sb.append(fStringMap.getString("downloadFromTftp"));
        } else if (mbean.getSysMaintOperation() == 4) {
            sb.append(fStringMap.getString("downloadFromFtp"));
        } else {
            return fStringMap.getString("No Operation Record.");
        }

        sb.append(mbean.getSysMaintRemoteFile()).append("......");

        if (mbean.getSysMaintOperResult() == 0) {
            return fStringMap.getString("No Operation Record.");
        } else if (mbean.getSysMaintOperResult() == 1) {
            sb.append(fStringMap.getString("operating"));
        } else if (mbean.getSysMaintOperResult() == 2) {
            sb.append(fStringMap.getString("success"));
        } else {
            sb.append(fStringMap.getString("failure"));
        }

        return sb.toString();
    }

    private class ResultThread extends Thread {
        public static final int TYPE_UPLOAD_IMAGE = 1;

        public static final int TYPE_DOWNLOAD_IMAGE = 2;

        public static final int TYPE_UPLOAD_CONFIG = 3;

        public static final int TYPE_DOWNLOAD_CONFIG = 4;

        public ResultThread() {
        }

        public void run() {
            // disable all the related buttons.
            SwitchGeneralConfigPanel.this.EraseConfigfileButton.setEnabled(false);
            SwitchGeneralConfigPanel.this.SaveConfigfileButton.setEnabled(false);
            SwitchGeneralConfigPanel.this.ResetNodeButton.setEnabled(false);
            SwitchGeneralConfigPanel.this.DownloadImageFileToNodeButton.setEnabled(false);
            SwitchGeneralConfigPanel.this.DownloadConfigFileToNodeButton.setEnabled(false);
            SwitchGeneralConfigPanel.this.UploadConfigFileFromNodeButton.setEnabled(false);

            SwitchGeneralMBean mbean = (SwitchGeneralMBean) getModel();

            while (true) {
                long time = System.currentTimeMillis();
                try {
                    mbean.retrieve();
                    statusLabel.setText(compose(mbean));

                    Thread.sleep(1000);

                    // the file is transferring and not timeout(10min).
                    if (mbean.getSysMaintOperResult().intValue() == 1 && (System.currentTimeMillis() - time) < 600000) {
                        continue;
                    } else {
                        Thread.sleep(5000);
                        statusLabel.setText(compose(mbean));
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //enable all the related buttons.
            SwitchGeneralConfigPanel.this.EraseConfigfileButton.setEnabled(true);
            SwitchGeneralConfigPanel.this.SaveConfigfileButton.setEnabled(true);
            SwitchGeneralConfigPanel.this.ResetNodeButton.setEnabled(true);
            SwitchGeneralConfigPanel.this.DownloadImageFileToNodeButton.setEnabled(true);
            SwitchGeneralConfigPanel.this.DownloadConfigFileToNodeButton.setEnabled(true);
            SwitchGeneralConfigPanel.this.UploadConfigFileFromNodeButton.setEnabled(true);
        }
    }
}
