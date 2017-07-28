package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class ProfileEditPanel extends UPanel {

    private final String upMaxBwLabel = fStringMap.getString("utsDot3OnuUpstreamPir") + ": ";
    private final String downMaxBwLabel = fStringMap.getString("utsDot3OnuDownstreamPir") + ": ";

    private JCheckBox pon1 = new JCheckBox("PON 1");
    private JCheckBox pon2 = new JCheckBox("PON 2");
    private JCheckBox pon3 = new JCheckBox("PON 3");
    private JCheckBox pon4 = new JCheckBox("PON 4");
    private IntegerTextField upMaxBwF = new IntegerTextField();
    private IntegerTextField downMaxBwF = new IntegerTextField();

    int[] utsDot3OnuEtherPortVlanModeVList = new int[]{0, 1, 2, 3, 4};
    String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
            fStringMap.getString("translation"),
            fStringMap.getString("n1aggregation"),
            fStringMap.getString("trunk")
    };

    private JTable uniTable = new JTable();


    public ProfileEditPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel ponPanel = new JPanel();
        NTLayout ponLayout = new NTLayout(1, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ponPanel.setLayout(ponLayout);
        ponPanel.setBorder(BorderFactory.createTitledBorder("PON Port"));

        ponPanel.add(pon1);
        ponPanel.add(pon2);
        ponPanel.add(pon3);
        ponPanel.add(pon4);

        NTLayout onuLayout = new NTLayout(1, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel onuPanel = new JPanel();
        onuPanel.setLayout(onuLayout);
        onuPanel.setBorder(BorderFactory.createTitledBorder("ONU PON口配置"));

        onuPanel.add(new JLabel(upMaxBwLabel));
        onuPanel.add(upMaxBwF);
        onuPanel.add(new HSpacer());

        onuPanel.add(new JLabel(downMaxBwLabel));
        onuPanel.add(downMaxBwF);
        onuPanel.add(new HSpacer());

        Vector columnNames = new Vector();
        columnNames.addAll(Arrays.asList("ID", "VLAN模式", "VLAN", "VLAN TPID", "下行最大速率(Kbps)"));
        Vector data = new Vector();
        for (int i = 0; i < 4; i++) {
            Vector<Object> row = new Vector<>();
            row.add("" + (i + 1));
            data.add(row);
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        uniTable = new JTable(tableModel);
        uniTable.setPreferredScrollableViewportSize(new Dimension(400, 65));

        uniTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        uniTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        uniTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox(utsDot3OnuEtherPortVlanModeTList)));

        NTLayout uniLayout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel uniPanel = new JPanel();
        uniPanel.setLayout(uniLayout);
        uniPanel.setBorder(BorderFactory.createTitledBorder("ONU网口配置"));
        uniPanel.add(new JScrollPane(uniTable));

        baseInfoPanel.add(ponPanel);
        baseInfoPanel.add(onuPanel);
        baseInfoPanel.add(uniPanel);

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
        upMaxBwF.setValueScope(1, 1000000);
        upMaxBwF.setDefaultValue(100000);
        downMaxBwF.setValueScope(1, 1000000);
        downMaxBwF.setDefaultValue(100000);
    }

    public void refresh() {
//        if (SnmpAction.IType.MODIFY.equals(fCommand)) {
//            OnuCfgBean m = (OnuCfgBean) getModel();
//            if (m == null) {
//                throw new RuntimeException("error");
//            }
//
//            idField.setEditable(false);
//            idField.setValue(m.getId());
//            setNullableIntField(upMaxBwF, m.getUpMaxBw());
//            setNullableIntField(downMaxBwF, m.getDownMaxBw());
//            setNullableIntField(upCommittedBwF, m.getUpCommittedBw());
//            setNullableIntField(downCommittedBwF, m.getDownCommittedBw());
//            setNullableIntField(upFixBwF, m.getUpFixBw());
//            setNullableIntField(upBurstSizeF, m.getUpBurstSize());
//            setNullableIntField(downBurstSizeF, m.getDownBurstSize());
//            setNullableIntField(upPriorityF, m.getUpPriority());
//
//            mxuIpAddressF.setValue(fromHexIp(m.getMxuIpAddress()));
//            mxuIpMaskF.setValue(fromHexIp(m.getMxuIpMask()));
//            mxuGatewayF.setValue(fromHexIp(m.getMxuGateway()));
//            mxuCVlanF.setValue(fromHexShort(m.getMxuCVlan()));
//            mxuSVlanF.setValue(fromHexShort(m.getMxuSVlan()));
//            mxuPriorityF.setValue(fromHexByte(m.getMxuPriority()));
//        }
    }

    public void updateModel() {
//        OnuCfgBean model;
//        if (SnmpAction.IType.ADD.equals(fCommand)) {
//            model = new OnuCfgBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
//            model.setId(String.valueOf(idField.getValue()));
//            setModel(model);
//        } else {
//            model = (OnuCfgBean) getModel();
//        }
//        model.setUpMaxBw(String.valueOf(upMaxBwF.getValue()));
//        model.setDownMaxBw(String.valueOf(downMaxBwF.getValue()));
//        model.setUpCommittedBw(String.valueOf(upCommittedBwF.getValue()));
//        model.setDownCommittedBw(String.valueOf(downCommittedBwF.getValue()));
//        model.setUpFixBw(String.valueOf(upFixBwF.getValue()));
//        model.setUpBurstSize(String.valueOf(upBurstSizeF.getValue()));
//        model.setDownBurstSize(String.valueOf(downBurstSizeF.getValue()));
//        model.setUpPriority(String.valueOf(upPriorityF.getValue()));
//
//        model.setMxuIpAddress(toHexIp(mxuIpAddressF.getValue()));
//        model.setMxuIpMask(toHexIp(mxuIpAddressF.getValue()));
//        model.setMxuGateway(toHexIp(mxuIpAddressF.getValue()));
//        model.setMxuCVlan(toHexShort(mxuCVlanF.getValue()));
//        model.setMxuSVlan(toHexShort(mxuSVlanF.getValue()));
//        model.setMxuPriority(toHexByte(mxuPriorityF.getValue()));
    }

}
