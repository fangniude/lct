package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniMirrorTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniTrunkConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * The SniMirrorTablePanel class.
 * Created by DVM Creator
 */
public class SniMirrorTablePanel extends UPanel implements ActionListener {

    private IntegerTextField tfSniMirrorGroupIndex = new IntegerTextField();

    private StringTextField tfSniMirrorGroupName = new StringTextField();

    private JComboBox tfSniMirrorGroupDstPortList = new JComboBox();

    JPanel srcInPanel = new JPanel();
    JPanel srcOutPanel = new JPanel();

    private JCheckBox[] tfSniMirrorGroupSrcInPortList = null;
    private JCheckBox[] tfSniMirrorGroupSrcOutPortList = null;

    private final String sniMirrorGroupIndex = fStringMap.getString("sniMirrorGroupIndex") + " : ";
    private final String sniMirrorGroupName = fStringMap.getString("sniMirrorGroupName") + " : ";
    private final String sniMirrorGroupDstPortList = fStringMap.getString("sniMirrorGroupDstPortList") + " : ";

    public SniMirrorTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniMirrorGroupIndex));
        baseInfoPanel.add(tfSniMirrorGroupIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(sniMirrorGroupName));
        tfSniMirrorGroupName.setName(fStringMap.getString("sniMirrorGroupName"));
        baseInfoPanel.add(tfSniMirrorGroupName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(sniMirrorGroupDstPortList));
        tfSniMirrorGroupDstPortList.setName(fStringMap.getString("sniMirrorGroupDstPortList"));
        baseInfoPanel.add(tfSniMirrorGroupDstPortList);
        baseInfoPanel.add(new HSpacer());

        srcInPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("sniMirrorGroupSrcInPortList")));

        srcOutPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("sniMirrorGroupSrcOutPortList")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(srcInPanel);
        allPanel.add(srcOutPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfSniMirrorGroupName.setLenScope(0, 255);
    }

    public void refresh() {
        tfSniMirrorGroupDstPortList.removeActionListener(this);
        tfSniMirrorGroupDstPortList.removeAllItems();
        Vector portList = new Vector();
        BoardTable board = new BoardTable(fApplication.getSnmpProxy());

        Vector v = BeanService.refreshTableBean(fApplication, board);

        for (Object aV : v) {
            BoardTable row = (BoardTable) aV;

            if (row.getType() == 3) {//uplink
                for (int j = 1; j < 5; j++) {
                    tfSniMirrorGroupDstPortList.addItem(row.getCardIndex() + "/" + j);
                    portList.add(row.getCardIndex() + "/" + j);
                }
            } else if (row.getType() == 2) {//gepon
                for (int j = 1; j < 5; j++) {
                    portList.add(row.getCardIndex() + "/" + j);
                }
            }
        }

        SniTrunkConfigTable trunk = new SniTrunkConfigTable(fApplication.getSnmpProxy());
        v = BeanService.refreshTableBean(fApplication, trunk);
        for (Object aV : v) {
            SniTrunkConfigTable row = (SniTrunkConfigTable) aV;

            byte[] value = row.getSniTrunkGroupConfigMember();

            if (value != null) {
                for (int j = 0; j < value.length / 4; j++) {
                    if (value[j * 4 + 1] != 0) {
                        portList.remove(value[j * 4 + 1] + "/" + value[j * 4 + 2]);
                    }
                }
            }

            portList.add("trunk" + row.getSniTrunkGroupConfigIndex());
        }

        tfSniMirrorGroupDstPortList.addActionListener(this);
        tfSniMirrorGroupSrcInPortList = new JCheckBox[portList.size()];
        tfSniMirrorGroupSrcOutPortList = new JCheckBox[portList.size()];

        srcInPanel.removeAll();
        srcOutPanel.removeAll();
        NTLayout layout = new NTLayout(portList.size() / 4 + 1, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        srcInPanel.setLayout(layout);
        layout = new NTLayout(portList.size() / 4 + 1, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        srcOutPanel.setLayout(layout);

        for (int i = 0; i < portList.size(); i++) {
            tfSniMirrorGroupSrcInPortList[i] = new JCheckBox((String) portList.get(i));
            srcInPanel.add(tfSniMirrorGroupSrcInPortList[i]);

            tfSniMirrorGroupSrcOutPortList[i] = new JCheckBox((String) portList.get(i));
            srcOutPanel.add(tfSniMirrorGroupSrcOutPortList[i]);

            if (i % 4 == 3) {
                srcInPanel.add(new HSpacer());
                srcOutPanel.add(new HSpacer());
            }
        }

        //validate the port list status.
        actionPerformed(null);

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfSniMirrorGroupIndex.setEnabled(true);
            return;
        } else {
            tfSniMirrorGroupIndex.setEnabled(false);
        }

        SniMirrorTable mbean = (SniMirrorTable) getModel();

        tfSniMirrorGroupIndex.setValue(mbean.getSniMirrorGroupIndex());
        tfSniMirrorGroupName.setValue(mbean.getSniMirrorGroupName());
        setPort(mbean.getSniMirrorGroupDstPortList());
        setPortList(tfSniMirrorGroupSrcInPortList, mbean.getSniMirrorGroupSrcInPortList());
        setPortList(tfSniMirrorGroupSrcOutPortList, mbean.getSniMirrorGroupSrcOutPortList());
    }

    public boolean validateFrom() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            SnmpTableModel model = (SnmpTableModel) fTable.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                SniMirrorTable row = (SniMirrorTable) model.getRow(i);

                if (row.getSniMirrorGroupIndex() == tfSniMirrorGroupIndex.getValue()) {
                    String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Row_In_Table");
                    MessageDialog.showInfoMessageDialog(fApplication, error);
                    return false;
                }
            }
        }

        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new SniMirrorTable(fApplication.getSnmpProxy()));

        SniMirrorTable mbean = (SniMirrorTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setSniMirrorGroupIndex(tfSniMirrorGroupIndex.getValue());
        }

        mbean.setSniMirrorGroupName(tfSniMirrorGroupName.getValue());
        mbean.setSniMirrorGroupDstPortList(getPort());
        mbean.setSniMirrorGroupSrcInPortList(getPortList(tfSniMirrorGroupSrcInPortList));
        mbean.setSniMirrorGroupSrcOutPortList(getPortList(tfSniMirrorGroupSrcOutPortList));

    }

    byte[] getPort() {
        byte[] port = new byte[4];

        String label = (String) tfSniMirrorGroupDstPortList.getSelectedItem();
        port[0] = 1;
        port[1] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
        port[2] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));

        return port;
    }

    void setPort(byte[] port) {
        if (port != null && port.length > 3) {
            tfSniMirrorGroupDstPortList.setSelectedItem(port[1] + "/" + port[2]);
        } else {
            tfSniMirrorGroupDstPortList.setSelectedItem(null);
        }
    }

    byte[] getPortList(JCheckBox[] portList) {
        Vector v = new Vector();

        for (JCheckBox port : portList) {
            if (port.isEnabled() && port.isSelected()) {
                v.add(port.getText());
            }
        }

        byte[] value = new byte[v.size() * 4];
        for (int i = 0; i < v.size(); i++) {
            String label = (String) v.get(i);

            value[i * 4] = 1;

            if (label.startsWith("trunk")) {
                value[i * 4 + 1] = (byte) 0x3F;
                value[i * 4 + 2] = (byte) Integer.parseInt(label.substring(5));
            } else {
                value[i * 4 + 1] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
                value[i * 4 + 2] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));
            }

            value[i * 4 + 3] = 0;
        }

        return value;
    }

    void setPortList(JCheckBox[] portList, byte[] value) {
        if (value == null || value.length < 1) return;

        int offset = 0;
        int count = value.length / 4;
        for (int i = 0; i < count; i++) {
            String port;
            if (value[i * 4 + 1] == 0x3F) {//trunk
                port = "trunk" + value[i * 4 + 2];

            } else {
                port = value[i * 4 + 1] + "/" + value[i * 4 + 2];
            }

            for (int j = offset; j < portList.length; j++) {
                offset++;
                if (portList[j].getText().equals(port)) {
                    portList[j].setSelected(true);
                    break;
                }
            }
        }
    }

    void disablePortList(JCheckBox[] portList, String port) {
        for (JCheckBox box : portList) {

            if (box.getText().equals(port)) {
                box.setEnabled(false);
            } else {
                box.setEnabled(true);
            }
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        disablePortList(tfSniMirrorGroupSrcInPortList, (String) tfSniMirrorGroupDstPortList.getSelectedItem());
        disablePortList(tfSniMirrorGroupSrcOutPortList, (String) tfSniMirrorGroupDstPortList.getSelectedItem());
    }

}