package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.lct.batch.proxy.XmlDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class InputOutputPanel extends UPanel {
    private JLabel inputL = new JLabel("导入文件:");
    private JLabel outputL = new JLabel("导出文件:");
    private JLabel syncL = new JLabel("将OLT的配置数据同步到小工具:");

    private StringTextField inputField = new StringTextField(50);
    private StringTextField outputField = new StringTextField(50);

    private JButton inputFileButton = new JButton(fStringMap.getString("选择..."));
    private JButton outputFileButton = new JButton(fStringMap.getString("选择..."));

    private JButton inputButton = new JButton(fStringMap.getString("input"));
    private JButton outputButton = new JButton(fStringMap.getString("output"));
    private JButton syncButton = new JButton(fStringMap.getString("同步"));

    public InputOutputPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel inputPanel = new JPanel();
        NTLayout inputLayout = new NTLayout(3, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        inputLayout.setMargins(6, 10, 6, 10);
        inputPanel.setLayout(inputLayout);
        inputPanel.setBorder(BorderFactory.createEtchedBorder());

        inputPanel.add(outputL);
        inputPanel.add(outputField);
        inputPanel.add(outputFileButton);
        inputPanel.add(outputButton);
        inputPanel.add(new HSpacer());

        inputPanel.add(inputL);
        inputPanel.add(inputField);
        inputPanel.add(inputFileButton);
        inputPanel.add(inputButton);
        inputPanel.add(new HSpacer());

        NTLayout syncLayout = new NTLayout(2, 10, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        syncLayout.setMargins(6, 10, 6, 10);
        JPanel syncPanel = new JPanel();
        syncPanel.setLayout(syncLayout);
        syncPanel.setBorder(BorderFactory.createTitledBorder("将系统运行的数据分别同步到<批量配置>中的<OLT配置>和<ONU配置>界面"));

        syncPanel.add(new HSpacer());
        syncPanel.add(new JLabel("批量配置界面"));
        syncPanel.add(syncButton);
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());
        syncPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        allPanel.setLayout(new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5));
        allPanel.add(inputPanel);
        allPanel.add(syncPanel);

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);

        inputFileButton.addActionListener(this::inputChooser);
        outputFileButton.addActionListener(this::outputChooser);

        inputButton.addActionListener(this::input);
        outputButton.addActionListener(this::output);
        syncButton.addActionListener(this::sync);
    }

    private void input(ActionEvent actionEvent) {
        String path = inputField.getValue();
        File file = new File(path);
        if (file.exists()) {
            XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
            try {
                db.input(file);
                MessageDialog.showInfoMessageDialog(fApplication, "导入成功");
            } catch (RuntimeException e) {
                MessageDialog.showErrorMessageDialog(fApplication, "导入失败");
            }
        } else {
            MessageDialog.showErrorMessageDialog(fApplication, "请选择导入的文件");
        }
    }

    private void output(ActionEvent actionEvent) {
        String path = outputField.getValue();
        File file = new File(path);
        if (file.exists()) {
            int i = MessageDialog.showConfirmDialog(fApplication, "文件已经存在，确认覆盖？");
            if (i == JOptionPane.OK_OPTION) {
                doOutput(file);
            }
        } else {
            doOutput(file);
        }
    }

    private void sync(ActionEvent actionEvent) {
        XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
        try {
            db.sync();
            MessageDialog.showInfoMessageDialog(fApplication, "同步成功");
        } catch (RuntimeException e) {
            MessageDialog.showErrorMessageDialog(fApplication, "同步失败");
        }
    }

    private void doOutput(File file) {
        XmlDataBase db = XmlDataBase.getInstance(fApplication.getSnmpProxy().getTargetHost());
        try {
            db.output(file);
            if (file.length() > 0 && file.lastModified() > System.currentTimeMillis() - 5000) {
                MessageDialog.showInfoMessageDialog(fApplication, "导出成功");
            } else {
                if (file.exists()) {
                    file.delete();
                }
                MessageDialog.showErrorMessageDialog(fApplication, "导出失败");
            }
        } catch (RuntimeException e) {
            if (file.exists()) {
                file.delete();
            }
            MessageDialog.showErrorMessageDialog(fApplication, "导出失败");
        }
    }

    private void inputChooser(ActionEvent actionEvent) {
        File confDir = new File(String.format("data%s%s%sconf%s", File.separator, fApplication.getSnmpProxy().getTargetHost(), File.separator, File.separator));
        if (!confDir.exists()) {
            confDir.mkdirs();
        }
        JFileChooser fileChooser = new JFileChooser(confDir);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            inputField.setValue(file.getAbsolutePath());
        }
    }

    private void outputChooser(ActionEvent actionEvent) {
        File confDir = new File(String.format("data%s%s%sconf%s", File.separator, fApplication.getSnmpProxy().getTargetHost(), File.separator, File.separator));
        if (!confDir.exists()) {
            confDir.mkdirs();
        }
        JFileChooser fileChooser = new JFileChooser(confDir);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            outputField.setValue(file.getAbsolutePath());
        }
    }

    public void refresh() {

    }

    public void updateModel() {

    }
}
