/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCapabilities2Table;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcCapabilities2TablePanel extends UPanel {

    private JLabel tfUtsDot3OnuCtcCapabilities2ModuleId = new JLabel();
    private JLabel tfUtsDot3OnuCtcCapabilities2DeviceId = new JLabel();
    private JLabel tfUtsDot3OnuCtcCapabilities2PortId = new JLabel();
    private JLabel tfUtsDot3OnuCtcCapabilities2LogicalPortId = new JLabel();

    private int[] utsDot3OnuCtcCapabilities2OnuTypeVList = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8,};
    private String[] utsDot3OnuCtcCapabilities2OnuTypeTList = new String[]{
            fStringMap.getString("sfu"), //0
            fStringMap.getString("hgu"), //1
            fStringMap.getString("sbu"), //2
            fStringMap.getString("boxEthMdu"), //3
            fStringMap.getString("miniCardEthMdu"), //4
            fStringMap.getString("boxCardDslMdu"), //5
            fStringMap.getString("chassisCardDslMdu"), //6
            fStringMap.getString("cardEthDslMdu"), //7
            fStringMap.getString("mtu"), //8
    };
    private JComboBox tfUtsDot3OnuCtcCapabilities2OnuType = new JComboBox(utsDot3OnuCtcCapabilities2OnuTypeTList);

    private int[] utsDot3OnuCtcCapabilities2MultiLlidVList = new int[]{
            2, 1,};
    private String[] utsDot3OnuCtcCapabilities2MultiLlidTList = new String[]{
            fStringMap.getString("notSupport"), //2
            fStringMap.getString("support"), //1
    };
    private JComboBox tfUtsDot3OnuCtcCapabilities2MultiLlid = new JComboBox(utsDot3OnuCtcCapabilities2MultiLlidTList);

    private int[] utsDot3OnuCtcCapabilities2ProtectionTypeVList = new int[]{
            0, 1, 2,};
    private String[] utsDot3OnuCtcCapabilities2ProtectionTypeTList = new String[]{
            fStringMap.getString("notSupport"), //0
            fStringMap.getString("typeC"), //1
            fStringMap.getString("typeD"), //2
    };
    private JComboBox tfUtsDot3OnuCtcCapabilities2ProtectionType = new JComboBox(utsDot3OnuCtcCapabilities2ProtectionTypeTList);

    private int[] utsDot3OnuCtcCapabilities2PonifNumVList = new int[]{
            1, 2,};
    private String[] utsDot3OnuCtcCapabilities2PonifNumTList = new String[]{
            fStringMap.getString("one"), //1
            fStringMap.getString("two"), //2
    };
    private JComboBox tfUtsDot3OnuCtcCapabilities2PonifNum = new JComboBox(utsDot3OnuCtcCapabilities2PonifNumTList);

    private JLabel tfUtsDot3OnuCtcCapabilities2SlotNum = new JLabel();
    private JLabel tfUtsDot3OnuCtcCapabilities2IntfAttribute = new JLabel();

    private int[] utsDot3OnuCtcCapabilities2BackupBatteryVList = new int[]{
            0, 1,};
    private String[] utsDot3OnuCtcCapabilities2BackupBatteryTList = new String[]{
            fStringMap.getString("noBackupBattery"), //0
            fStringMap.getString("backupBattery"), //1
    };
    private JComboBox tfUtsDot3OnuCtcCapabilities2BackupBattery = new JComboBox(utsDot3OnuCtcCapabilities2BackupBatteryTList);

    private final String utsDot3OnuCtcCapabilities2ModuleId = fStringMap.getString("utsDot3OnuCtcCapabilities2ModuleId") + ": ";
    private final String utsDot3OnuCtcCapabilities2DeviceId = fStringMap.getString("utsDot3OnuCtcCapabilities2DeviceId") + ": ";
    private final String utsDot3OnuCtcCapabilities2PortId = fStringMap.getString("utsDot3OnuCtcCapabilities2PortId") + ": ";
    private final String utsDot3OnuCtcCapabilities2LogicalPortId = fStringMap.getString("utsDot3OnuCtcCapabilities2LogicalPortId") + ": ";
    private final String utsDot3OnuCtcCapabilities2OnuType = fStringMap.getString("utsDot3OnuCtcCapabilities2OnuType") + ": ";
    private final String utsDot3OnuCtcCapabilities2MultiLlid = fStringMap.getString("utsDot3OnuCtcCapabilities2MultiLlid") + ": ";
    private final String utsDot3OnuCtcCapabilities2ProtectionType = fStringMap.getString("utsDot3OnuCtcCapabilities2ProtectionType") + ": ";
    private final String utsDot3OnuCtcCapabilities2PonifNum = fStringMap.getString("utsDot3OnuCtcCapabilities2PonifNum") + ": ";
    private final String utsDot3OnuCtcCapabilities2SlotNum = fStringMap.getString("utsDot3OnuCtcCapabilities2SlotNum") + ": ";
    private final String utsDot3OnuCtcCapabilities2IntfAttribute = fStringMap.getString("utsDot3OnuCtcCapabilities2IntfAttribute") + ": ";
    private final String utsDot3OnuCtcCapabilities2BackupBattery = fStringMap.getString("utsDot3OnuCtcCapabilities2BackupBattery") + ": ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public Onu2CtcCapabilities2TablePanel(IApplication app) {
        super(app);
        setModel(new Onu2CtcCapabilities2Table(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_Onu2CtcCapabilities2Table");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2ModuleId));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2ModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2DeviceId));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2DeviceId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2PortId));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2PortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2LogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2LogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2OnuType));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2OnuType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2MultiLlid));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2MultiLlid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2ProtectionType));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2ProtectionType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2PonifNum));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2PonifNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2SlotNum));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2SlotNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2IntfAttribute));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2IntfAttribute);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuCtcCapabilities2BackupBattery));
        baseInfoPanel.add(tfUtsDot3OnuCtcCapabilities2BackupBattery);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        Onu2CtcCapabilities2Table mbean = (Onu2CtcCapabilities2Table) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfUtsDot3OnuCtcCapabilities2ModuleId.setText(mbean.getUtsDot3OnuCtcCapabilities2ModuleId().toString());
        tfUtsDot3OnuCtcCapabilities2DeviceId.setText(mbean.getUtsDot3OnuCtcCapabilities2DeviceId().toString());
        tfUtsDot3OnuCtcCapabilities2PortId.setText(mbean.getUtsDot3OnuCtcCapabilities2PortId().toString());
        tfUtsDot3OnuCtcCapabilities2LogicalPortId.setText(mbean.getUtsDot3OnuCtcCapabilities2LogicalPortId().toString());
        tfUtsDot3OnuCtcCapabilities2OnuType.setSelectedIndex(getIndexFromValue(utsDot3OnuCtcCapabilities2OnuTypeVList, mbean.getUtsDot3OnuCtcCapabilities2OnuType().intValue()));
        tfUtsDot3OnuCtcCapabilities2MultiLlid.setSelectedIndex(getIndexFromValue(utsDot3OnuCtcCapabilities2MultiLlidVList, mbean.getUtsDot3OnuCtcCapabilities2MultiLlid().intValue()));
        tfUtsDot3OnuCtcCapabilities2ProtectionType.setSelectedIndex(getIndexFromValue(utsDot3OnuCtcCapabilities2ProtectionTypeVList, mbean.getUtsDot3OnuCtcCapabilities2ProtectionType().intValue()));
        tfUtsDot3OnuCtcCapabilities2PonifNum.setSelectedIndex(getIndexFromValue(utsDot3OnuCtcCapabilities2PonifNumVList, mbean.getUtsDot3OnuCtcCapabilities2PonifNum().intValue()));
        tfUtsDot3OnuCtcCapabilities2SlotNum.setText(mbean.getUtsDot3OnuCtcCapabilities2SlotNum().toString());
//        tfUtsDot3OnuCtcCapabilities2IntfAttribute.setText(mbean.getUtsDot3OnuCtcCapabilities2IntfAttribute());
        tfUtsDot3OnuCtcCapabilities2BackupBattery.setSelectedIndex(getIndexFromValue(utsDot3OnuCtcCapabilities2BackupBatteryVList, mbean.getUtsDot3OnuCtcCapabilities2BackupBattery().intValue()));
    }

    public void updateModel() {
        //Onu2CtcCapabilities2Table mbean = (Onu2CtcCapabilities2Table) getModel();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}