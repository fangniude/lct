package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r300.AlarmOccurenceTimeFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OltFileSystem;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.DeleteAction;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpField;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.formatter.BytesToStringFormatter;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Vector;

public class OltFileSystemPanel extends UPanel implements ActionListener {
    String pwd = null;
    private JLabel tfCurrentPath = new JLabel();
    private final String currentPath = fStringMap.getString("currentPath") + " : ";

    public OltFileSystemPanel(IApplication app) {
        super(app);
        init();
        setModel(new OltFileSystem(fApplication.getSnmpProxy()));
    }

    protected void initGui() {
        setLayout(new BorderLayout());

        JPanel pwdPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        pwdPanel.setLayout(layout);
        pwdPanel.setBorder(BorderFactory.createEtchedBorder());

        pwdPanel.add(new JLabel(currentPath));
        pwdPanel.add(tfCurrentPath);
        pwdPanel.add(new HSpacer());

        //

        add(pwdPanel, BorderLayout.NORTH);
        add(initTablePane(), BorderLayout.CENTER);

//        SnmpAction resetAction = new ResetMultiOnuAction(fApplication);
//        resetAction.setPanel(this);
//        resetAction.setTable(fTable);
//        SnmpTableButton resetButton = new SnmpTableButton("Custom", fStringMap.getString("Reset"), resetAction);

        //
        JButton btRefresh = new JButton();
        btRefresh.addActionListener(this);
        btRefresh.setText(fStringMap.getString("Refresh"));

        SnmpAction deleteAction = new DeleteAction(fApplication);
        deleteAction.setPanel(this);
        deleteAction.setTable(fTable);
        JButton deleteButton = new JButton(deleteAction);
        deleteButton.setText(fStringMap.getString("Delete"));
        //
//        action = new ExportAction(fApplication);
//        action.setPanel(this);
//        action.setTable(fTable);
//        SnmpTableButton btExport = new SnmpTableButton(SnmpAction.IType.EXPORT, fStringMap.getString("Export"), action);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(btRefresh);
        panel.add(deleteButton);
        
        add(panel, BorderLayout.SOUTH);
    }

    private JScrollPane initTablePane() {
        Vector<SnmpField> vField = new Vector<SnmpField>();
        SnmpField field;
//        field = new SnmpField("filePath", fStringMap.getString("filePath"), null, (byte) 0, null, new BytesToStringFormatter(fApplication));
//        field.setMibProperty("filePath");
//        vField.add(field);

//      field = new SnmpField("ifOnuIndex", fStringMap.getString("ifOnuIndex"), null, (byte)0, null, new IfIndexFormatter(fApplication));
        field = new SnmpField("fileName", fStringMap.getString("fileName"), null, (byte) 0, null, new BytesToStringFormatter(fApplication));
        field.setMibProperty("fileName");
        vField.add(field);

        field = new SnmpField("fileSize", fStringMap.getString("fileSize"), null, (byte) 0, null, null);
        field.setMibProperty("fileSize");
        vField.add(field);

        field = new SnmpField("fileModifyTime", fStringMap.getString("fileModifyTime"), null, (byte) 4, null, new AlarmOccurenceTimeFormatter(fApplication));
        field.setMibProperty("fileModifyTime");
        vField.add(field);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", fStringMap.getString("file"));
        map.put("2", fStringMap.getString("dir"));
        field = new SnmpField("fileAttribute", fStringMap.getString("fileAttribute"), null, (byte) 0, map, null);
        field.setMibProperty("fileAttribute");
        vField.add(field);

        OltFileSystem bean = new OltFileSystem(fApplication.getSnmpProxy());
        SnmpTableModel model = new SnmpTableModel(vField, bean, null, false);
        fTable = new SnmpTable(model);
        fTable.setMultipleSelection(true);
        fTable.setName(fStringMap.getString("FileInfoMgmtTable"));
        fTable.getColumnModel().getColumn(0).setCellRenderer(new FileTableCellRender(model));
        
        // double click on a row will bring up the modify dialog
        fTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    SnmpTableModel model = (SnmpTableModel) fTable.getModel();

                    //
                    if (fTable.getSelectedRow() != -1) {
                        OltFileSystem file = (OltFileSystem) model.getRow(fTable.getSelectedRow());

                        String fileName = new String(file.getFileName());
                        if (fileName.equals("..") || file.getFileAttribute() == 2) {
                            ls(cdPath(fileName));
                        }
                    }
                }
            }
        });

        return new JScrollPane(fTable);
    }

    public void refresh() {
        ls(pwd);
    }

    void ls(String path) {
        try {
            OltFileSystem bean = (OltFileSystem) getModel();

            if (path != null) {
//                path += "/";
                byte[] index = new byte[path.length() + 1];
                index[0] = (byte) path.length();

                System.arraycopy(path.getBytes(), 0, index, 1, path.length());
                bean.setFilePath(index);
            } else {
                bean.setFilePath(null);
            }

            Vector all = BeanService.refreshTableBean(fApplication, bean);

            if (all.size() > 0) {
                OltFileSystem file = (OltFileSystem) all.get(0);

                pwd = new String(file.getFilePath());
                tfCurrentPath.setText(pwd);
            }

            SnmpTableModel model = (SnmpTableModel) fTable.getModel();
            model.setDataVector(all);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    String cdPath(String path) {
        if (path != null) {
            if (path.equals("..")) {
                return cdParentPath();
            } else {
                if (pwd == null || pwd.equals("")) {
                    pwd = path;
                } else {
                    if (pwd.endsWith("/")) {
                        pwd = pwd + path;
                    } else {
                        pwd = pwd + "/" + path;
                    }
                }
            }
        }

        return pwd;
    }

    String cdParentPath() {
        if (pwd == null) return null;

        if (pwd.endsWith("/")) {
            pwd = pwd.substring(0, pwd.length() - 1);
        }

        if (pwd.lastIndexOf('/') != -1) {
            pwd = pwd.substring(0, pwd.lastIndexOf('/'));
        } else {
            pwd = null;//null as root dir.
        }

        return pwd;
    }

    public void actionPerformed(ActionEvent e) {
        ls(pwd);
    }
}

class FileTableCellRender extends DefaultTableCellRenderer {
    public static Icon fileIcon = null;
    static Icon folderIcon = null;
    SnmpTableModel model;

    static {
        fileIcon = createImageIcon("images/file.gif");
        folderIcon = createImageIcon("images/folder.jpg");
    }

    public FileTableCellRender(SnmpTableModel model) {
        this.model = model;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        OltFileSystem file = (OltFileSystem)model.getRow(row);

        if(file.getFileAttribute() != null && file.getFileAttribute() == 2) {
            setIcon(folderIcon);
        } else {
            this.setIcon(fileIcon);
        }

        return this;
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileTableCellRender.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


}
