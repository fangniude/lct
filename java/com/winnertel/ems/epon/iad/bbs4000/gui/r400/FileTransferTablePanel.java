package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.FileTransferTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 16:31:08
 */
public class FileTransferTablePanel extends UPanel implements ActionListener {
    private int[] fileTransferProtocolTypeVList = new int[] {1, 2};
    private String[] fileTransferProtocolTypeTList = new String[] {
            fStringMap.getString("ftp"), fStringMap.getString("tftp")
    };
    private JComboBox tfFileTransferProtocolType = new JComboBox(fileTransferProtocolTypeTList);
    private IPAddressField tfServerIpAddress = new IPAddressField();
    private StringTextField tfFtpUserName = new StringTextField();
    private StringTextField tfFtpUserPassword = new StringTextField();
    private StringTextField tfTransferFileSrcNamePath = new StringTextField();
    private StringTextField tfTransferFileDstNamePath = new StringTextField();

    private int[] transferActionVList = new int[] {2, 3};
    private String[] transferActionTList = new String[] {
            fStringMap.getString("put-file"), fStringMap.getString("get-file")
    };
    private JComboBox tfTransferAction = new JComboBox(transferActionTList);

    private final String fileTransferProtocolType = fStringMap.getString("fileTransferProtocolType") + " : ";
    private final String serverIpAddress = fStringMap.getString("serverIpAddress") + " : ";
    private final String ftpUserName = fStringMap.getString("ftpUserName") + " : ";
    private final String ftpUserPassword = fStringMap.getString("ftpUserPassword") + " : ";
    private final String transferFileSrcNamePath = fStringMap.getString("transferFileSrcNamePath") + " : ";
    private final String transferFileDstNamePath = fStringMap.getString("transferFileDstNamePath") + " : ";
    private final String transferAction = fStringMap.getString("transferAction") + " : ";

    public FileTransferTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(fileTransferProtocolType));
        tfFileTransferProtocolType.addActionListener(this);
        tfFileTransferProtocolType.setEnabled(false);
        tfFileTransferProtocolType.setName(fStringMap.getString("fileTransferProtocolType"));
        baseInfoPanel.add(tfFileTransferProtocolType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(serverIpAddress));
        tfServerIpAddress.setName(fStringMap.getString("serverIpAddress"));
        baseInfoPanel.add(tfServerIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ftpUserName));
        tfFtpUserName.setName(fStringMap.getString("ftpUserName"));
        baseInfoPanel.add(tfFtpUserName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ftpUserPassword));
        tfFtpUserPassword.setName(fStringMap.getString("ftpUserPassword"));
        baseInfoPanel.add(tfFtpUserPassword);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(transferFileSrcNamePath));
        tfTransferFileSrcNamePath.setName(fStringMap.getString("transferFileSrcNamePath"));
        baseInfoPanel.add(tfTransferFileSrcNamePath);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(transferFileDstNamePath));
        tfTransferFileDstNamePath.setName(fStringMap.getString("transferFileDstNamePath"));
        baseInfoPanel.add(tfTransferFileDstNamePath);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(transferAction));
        tfTransferAction.setName(fStringMap.getString("transferAction"));
        baseInfoPanel.add(tfTransferAction);
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
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            return;
        }

        FileTransferTable mbean = (FileTransferTable) getModel();
        if (mbean == null)
            return;

        tfFileTransferProtocolType.setSelectedIndex(getIndexFromValue(fileTransferProtocolTypeVList, mbean.getFileTransferProtocolType()));
        tfServerIpAddress.setValue(mbean.getServerIpAddress());
        tfFtpUserName.setValue(mbean.getFtpUserName());
        tfFtpUserPassword.setValue(mbean.getFtpUserPassword());
        tfTransferFileSrcNamePath.setValue(mbean.getTransferFileSrcNamePath());
        tfTransferFileDstNamePath.setValue(mbean.getTransferFileDstNamePath());
        tfTransferAction.setSelectedIndex(getIndexFromValue(transferActionVList, mbean.getTransferAction()));

        //
        actionPerformed(null);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new FileTransferTable(fApplication.getSnmpProxy()));

        FileTransferTable mbean = (FileTransferTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            if(fTable.getRowCount() > 0) {
                SnmpTableModel model = (SnmpTableModel)fTable.getModel();
                FileTransferTable row = (FileTransferTable)model.getRow(fTable.getRowCount() - 1);

                mbean.setFileTransferIndex(row.getFileTransferIndex() + 1);
            } else {
                mbean.setFileTransferIndex(1);
            }
        }

        mbean.setFileTransferProtocolType(fileTransferProtocolTypeVList[tfFileTransferProtocolType.getSelectedIndex()]);
        mbean.setServerIpAddress(tfServerIpAddress.getIPString());
        if(tfFtpUserName.isEnabled()) {
            mbean.setFtpUserName(tfFtpUserName.getValue());
        }
        if(tfFtpUserPassword.isEnabled()) {
            mbean.setFtpUserPassword(tfFtpUserPassword.getValue());
        }
        mbean.setTransferFileSrcNamePath(tfTransferFileSrcNamePath.getValue());
        mbean.setTransferFileDstNamePath(tfTransferFileDstNamePath.getValue());
        mbean.setTransferAction(transferActionVList[tfTransferAction.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        if(tfFileTransferProtocolType.getSelectedIndex() == 0) {//ftp
            tfFtpUserName.setEnabled(true);
            tfFtpUserPassword.setEnabled(true);
        } else {
            tfFtpUserName.setEnabled(false);
            tfFtpUserPassword.setEnabled(false);
        }

    }
}