package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.ProfileOnuBean;
import com.winnertel.lct.batch.bean.ProfileUniBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

    int[] utsDot3OnuEtherPortVlanModeVList = new int[]{0, 1,
//            2, 3,
            4};
    String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
//            fStringMap.getString("translation"),
//            fStringMap.getString("n1aggregation"),
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
        ponPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("PON_Port")));

        ponPanel.add(pon1);
        ponPanel.add(pon2);
        ponPanel.add(pon3);
        ponPanel.add(pon4);

        NTLayout onuLayout = new NTLayout(1, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel onuPanel = new JPanel();
        onuPanel.setLayout(onuLayout);
        onuPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_PON_port_config")));

        onuPanel.add(new JLabel(upMaxBwLabel));
        onuPanel.add(upMaxBwF);
        onuPanel.add(new HSpacer());

        onuPanel.add(new JLabel(downMaxBwLabel));
        onuPanel.add(downMaxBwF);
        onuPanel.add(new HSpacer());

        Vector columnNames = new Vector();
        columnNames.addAll(Arrays.asList("ID", fStringMap.getString("utsDot3OnuEtherPortVlanMode"), fStringMap.getString("utsDot3OnuEtherPortVlanTag"), fStringMap.getString("utsDot3OnuEtherPortVlanTPID"), fStringMap.getString("passVlan"), fStringMap.getString("upPir"), fStringMap.getString("downPir")));
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
        uniTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        uniTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        uniTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox(utsDot3OnuEtherPortVlanModeTList)));

        uniTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox(new Object[]{"0x8100", "0x9100"})));

        NTLayout uniLayout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel uniPanel = new JPanel();
        uniPanel.setLayout(uniLayout);
        uniPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_UNI_port_config")));
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
//        System.out.println("test");
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
        if (pon1.isSelected()) {
            save(1);
        }
        if (pon2.isSelected()) {
            save(2);
        }
        if (pon3.isSelected()) {
            save(3);
        }
        if (pon4.isSelected()) {
            save(4);
        }
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

    private void save(int i) {
        try {
            XmlProxy proxy = new XmlProxy(fApplication.getSnmpProxy().getTargetHost());

            ProfileOnuBean onu = new ProfileOnuBean(proxy);
            onu.setId(i + "-1");
            onu.setDbaSlaEnable("1");
            int upMaxBw = upMaxBwF.getValue();
            int downMaxBw = downMaxBwF.getValue();
            if (upMaxBw <= 0 && downMaxBw <= 0) {
                onu.setDbaSlaEnable("0");
            } else {
                onu.setDbaSlaEnable("1");
                onu.setUpMaxBw(String.valueOf(upMaxBw));
                onu.setDownMaxBw(String.valueOf(downMaxBw));
            }
            onu.add();
            setModel(onu);
            onu.setId(i + "-1");
            if (upMaxBw <= 0 && downMaxBw <= 0) {
                onu.setDbaSlaEnable("0");
            } else {
                onu.setDbaSlaEnable("1");
                onu.setUpMaxBw(String.valueOf(upMaxBw));
                onu.setDownMaxBw(String.valueOf(downMaxBw));
            }

            TableModel model = uniTable.getModel();
            for (int j = 0; j < 4; j++) {
                ProfileUniBean uni = new ProfileUniBean(proxy);
                uni.setId(i + "-1-" + (j + 1));
                Object mode = model.getValueAt(j, 1);
                Object vlan = model.getValueAt(j, 2);
                Object tpid = model.getValueAt(j, 3);
                Object passVlan = model.getValueAt(j, 4);
                Object upPir = model.getValueAt(j, 5);
                Object dsPir = model.getValueAt(j, 6);

                if (mode != null || vlan != null || passVlan != null || tpid != null || upPir != null || dsPir != null) {
                    uni.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[getIndexFromValue(utsDot3OnuEtherPortVlanModeTList, String.valueOf(mode))]));
                    if ("1".equals(uni.getVlanMode())) {
                        uni.setVlanTag(String.valueOf(vlan));
                        uni.setVlanTpid(String.valueOf(tpid));
                    } else if ("4".equals(uni.getVlanMode())) {
                        uni.setVlanTag(String.valueOf(vlan));
                        uni.setVlanTpid(String.valueOf(tpid));
                        uni.setPassVlan(String.valueOf(passVlan));
                    }
                    if (upPir != null) {
                        uni.setPolicingEnable("1");
                        uni.setPolicingCir(String.valueOf(upPir));
                        uni.setPolicingCbs("1000");
                        uni.setPolicingEbs("1000");
                    } else {
                        uni.setPolicingEnable("0");
                    }

                    if (dsPir != null) {
                        uni.setDsEnable("1");
                        uni.setDsPir(String.valueOf(dsPir));
                        uni.setDsCir(String.valueOf(dsPir));
                    } else {
                        uni.setDsEnable("0");
                    }
                    uni.add();
                }
            }
        } catch (MibBeanException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterUpdateModel() {
        super.afterUpdateModel();
        SnmpTablePane snmpTablePane = (SnmpTablePane) this.getTable().getParent().getParent().getParent();
        ProfilePanel profilePanel = (ProfilePanel) snmpTablePane.getParent().getParent().getParent();
        profilePanel.refresh();
    }

    public int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i].equals(v))
                return i;
        }

        return 0;
    }
}
