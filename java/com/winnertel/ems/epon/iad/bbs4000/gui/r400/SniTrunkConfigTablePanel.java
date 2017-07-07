package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniAttributeTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniTrunkConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SniTrunkConfigTablePanel class.
 * Created by DVM Creator
 */
public class SniTrunkConfigTablePanel extends UPanel {

    private IntegerTextField tfSniTrunkGroupConfigIndex = new IntegerTextField();

    private StringTextField tfSniTrunkGroupConfigName = new StringTextField();

    JPanel memberPanel = new JPanel();
    JCheckBox[] portList = new JCheckBox[52];

    private int[] sniTrunkGroupConfigPolicyVList = new int[]{1, 2, 3, 4, 5, 6};

    private String[] sniTrunkGroupConfigPolicyTList = new String[] {
            fStringMap.getString("srcMac"), fStringMap.getString("destMac"),
            fStringMap.getString("srcMacNDestMac"), fStringMap.getString("srcIp"),
            fStringMap.getString("destIp"), fStringMap.getString("srcIpNDestIp"),};

    private JComboBox tfSniTrunkGroupConfigPolicy = new JComboBox(sniTrunkGroupConfigPolicyTList);

    private final String sniTrunkGroupConfigIndex = fStringMap.getString("sniTrunkGroupConfigIndex") + " : ";
    private final String sniTrunkGroupConfigName = fStringMap.getString("sniTrunkGroupConfigName") + " : ";
    private final String sniTrunkGroupConfigPolicy = fStringMap.getString("sniTrunkGroupConfigPolicy") + " : ";

    public SniTrunkConfigTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniTrunkGroupConfigIndex));
        baseInfoPanel.add(tfSniTrunkGroupConfigIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniTrunkGroupConfigName));
        tfSniTrunkGroupConfigName.setName(fStringMap.getString("sniTrunkGroupConfigName"));
        baseInfoPanel.add(tfSniTrunkGroupConfigName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(sniTrunkGroupConfigPolicy));
        tfSniTrunkGroupConfigPolicy.setName(fStringMap.getString("sniTrunkGroupConfigPolicy"));
        baseInfoPanel.add(tfSniTrunkGroupConfigPolicy);
        baseInfoPanel.add(new HSpacer());

        memberPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("sniTrunkGroupConfigMember")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(memberPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfSniTrunkGroupConfigName.setLenScope(0, 255);
    }

    public void refresh() {
        memberPanel.removeAll();

        //get all the uplink port.
        SniAttributeTable bean = new SniAttributeTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, bean);
        portList = new JCheckBox[v.size()];

        NTLayout layout = new NTLayout(v.size()/4, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        memberPanel.setLayout(layout);

        for(int i = 0; i < v.size(); i++) {
            SniAttributeTable row = (SniAttributeTable)v.get(i);

            portList[i] = new JCheckBox(row.getSniAttributeCardIndex() + "/" + row.getSniAttributePortIndex());
            memberPanel.add(portList[i]);

            if(i % 4 == 3) {
                memberPanel.add(new HSpacer());
            }
        }

        if(SnmpAction.IType.ADD.equals(fCommand)) {
            tfSniTrunkGroupConfigIndex.setEnabled(true);

            //disable the ports which are included in all the trunks already.
            SnmpTableModel model = (SnmpTableModel)fTable.getModel();
            for(int i = 0; i < model.getRowCount(); i++) {
                SniTrunkConfigTable row = (SniTrunkConfigTable)model.getRow(i);

                byte[] value = row.getSniTrunkGroupConfigMember();

                if(value != null) {
                    for(int j = 0; j < value.length/4; j++) {
                        if(value[j*4+1] != 0) {
                            for (JCheckBox aPortList : portList) {
                                if (aPortList.getText().equals(value[j*4+1] + "/" + value[j*4+2])) {
                                    aPortList.setEnabled(false);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            tfSniTrunkGroupConfigIndex.setEnabled(false);

            SniTrunkConfigTable mbean = (SniTrunkConfigTable) getModel();

            //disable the ports which are included in others trunks already.
            SnmpTableModel model = (SnmpTableModel)fTable.getModel();
            for(int i = 0; i < model.getRowCount(); i++) {
                SniTrunkConfigTable row = (SniTrunkConfigTable)model.getRow(i);

                if(!row.getSniTrunkGroupConfigIndex().equals(mbean.getSniTrunkGroupConfigIndex())) {
                    byte[] value = row.getSniTrunkGroupConfigMember();

                    if(value != null) {
                        for(int j = 0; j < value.length/4; j++) {
                            if(value[j*4+1] != 0) {
                                for (JCheckBox aPortList : portList) {
                                    if (aPortList.getText().equals(value[j*4+1] + "/" + value[j*4+2])) {
                                        aPortList.setEnabled(false);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }


            tfSniTrunkGroupConfigIndex.setText(mbean.getSniTrunkGroupConfigIndex().toString());
            tfSniTrunkGroupConfigName.setValue(mbean.getSniTrunkGroupConfigName());
            setTrunkMember(mbean.getSniTrunkGroupConfigMember());
            tfSniTrunkGroupConfigPolicy.setSelectedIndex(getIndexFromValue(sniTrunkGroupConfigPolicyVList, mbean.getSniTrunkGroupConfigPolicy()));
        }
    }

    public void updateModel() {

        if(SnmpAction.IType.ADD.equals(fCommand)) setModel(new SniTrunkConfigTable(fApplication.getSnmpProxy()));

        SniTrunkConfigTable mbean = (SniTrunkConfigTable) getModel();

        if(SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setSniTrunkGroupConfigIndex(tfSniTrunkGroupConfigIndex.getValue());
        }

        mbean.setSniTrunkGroupConfigName(tfSniTrunkGroupConfigName.getValue());
        mbean.setSniTrunkGroupConfigMember(getTrunkMember());
        mbean.setSniTrunkGroupConfigPolicy(sniTrunkGroupConfigPolicyVList[tfSniTrunkGroupConfigPolicy.getSelectedIndex()]);
    }

    byte[] getTrunkMember() {
        Vector v = new Vector();

        for(int i = 0; i < portList.length; i++) {
            if(portList[i].isSelected()) {
                v.add(portList[i].getText());
            }
        }


        byte[] value = new byte[v.size()*4];
        for(int i = 0; i < v.size(); i++) {
                String label = (String)v.get(i);

                value[i * 4] = 1;
                value[i * 4 + 1] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
                value[i * 4 + 2] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));
                value[i * 4 + 3] = 0;
        }

        return value;
    }

    void setTrunkMember(byte[] member) {
        if(member == null || member.length < 1) return;

        int offset =0;
        int count = member.length/4;
        for(int i = 0; i < count; i++) {
            String port = member[i * 4 + 1] + "/" + member[i * 4 + 2];

            for(int j = offset; j < portList.length; j++) {
                offset++;
                if(portList[j].getText().equals(port)) {
                    portList[j].setSelected(true);
                    break;
                }
            }
        }
    }

    void disableTrunkMember(byte[] member) {
        if(member == null || member.length < 1) return;

        int offset =0;
        int count = member.length/4;
        for(int i = 0; i < count; i++) {
            String port = member[i * 4 + 1] + "/" + member[i * 4 + 2];

            for(int j = offset; j < portList.length; j++) {
                offset++;
                if(portList[j].getText().equals(port)) {
                    portList[j].setEnabled(false);
                    break;
                }
            }
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
