/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniMirrorTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
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

public class UniMirrorTablePanel extends UPanel implements ActionListener {

    private IntegerTextField tfUniMirrorGroupIndex = new IntegerTextField();

    private StringTextField tfUniMirrorGroupName = new StringTextField();
    private JComboBox tfUniMirrorGroupDstPortList = new JComboBox();
    private JCheckBox[] tfUniMirrorGroupSrcInPortList = new JCheckBox[4];
    private JCheckBox[] tfUniMirrorGroupSrcOutPortList = new JCheckBox[4];

    private final String uniMirrorGroupIndex = fStringMap.getString("uniMirrorGroupIndex") + " : ";
    private final String uniMirrorGroupName = fStringMap.getString("uniMirrorGroupName") + " : ";
    private final String uniMirrorGroupDstPortList = fStringMap.getString("uniMirrorGroupDstPortList") + " : ";

    public UniMirrorTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(uniMirrorGroupIndex));
        baseInfoPanel.add(tfUniMirrorGroupIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMirrorGroupName));
        tfUniMirrorGroupName.setName(fStringMap.getString("uniMirrorGroupName"));
        baseInfoPanel.add(tfUniMirrorGroupName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMirrorGroupDstPortList));
        tfUniMirrorGroupDstPortList.setName(fStringMap.getString("uniMirrorGroupDstPortList"));
        baseInfoPanel.add(tfUniMirrorGroupDstPortList);
        baseInfoPanel.add(new HSpacer());

        JPanel srcInPanel = new JPanel();
        JPanel srcOutPanel = new JPanel();
        layout = new NTLayout(1, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        srcInPanel.setLayout(layout);
        srcOutPanel.setLayout(layout);

        srcInPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("uniMirrorGroupSrcInPortList")));
        srcOutPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("uniMirrorGroupSrcOutPortList")));

        tfUniMirrorGroupDstPortList.addItem("0/0");
        for (int i = 0; i <4; i++) {
            tfUniMirrorGroupDstPortList.addItem("0/" + (i+1));

            tfUniMirrorGroupSrcInPortList[i] = new JCheckBox("0/" + (i+1));
            srcInPanel.add(tfUniMirrorGroupSrcInPortList[i]);
            tfUniMirrorGroupSrcOutPortList[i] = new JCheckBox("0/" + (i+1));
            srcOutPanel.add(tfUniMirrorGroupSrcOutPortList[i]);
        }

        srcInPanel.add(new HSpacer());
        srcOutPanel.add(new HSpacer());

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
        tfUniMirrorGroupDstPortList.addActionListener(this);
        tfUniMirrorGroupName.setLenScope(0, 255);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUniMirrorGroupIndex.setEditable(true);
            return;
        } else {
            tfUniMirrorGroupIndex.setEditable(false);
        }

        UniMirrorTable mbean = (UniMirrorTable) getModel();
        if (mbean == null)
            return;

        tfUniMirrorGroupIndex.setValue(mbean.getUniMirrorGroupIndex());

        tfUniMirrorGroupName.setValue(mbean.getUniMirrorGroupName());
        setPort(mbean.getUniMirrorGroupDstPortList());
        setPortList(tfUniMirrorGroupSrcInPortList, mbean.getUniMirrorGroupSrcInPortList());
        setPortList(tfUniMirrorGroupSrcOutPortList, mbean.getUniMirrorGroupSrcOutPortList());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new UniMirrorTable(fApplication.getSnmpProxy()));

        UniMirrorTable mbean = (UniMirrorTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUniMirrorGroupIndex(tfUniMirrorGroupIndex.getValue());
        }

        mbean.setUniMirrorGroupName(tfUniMirrorGroupName.getValue());
        mbean.setUniMirrorGroupDstPortList(getPort());
        mbean.setUniMirrorGroupSrcInPortList(getPortList(tfUniMirrorGroupSrcInPortList));
        mbean.setUniMirrorGroupSrcOutPortList(getPortList(tfUniMirrorGroupSrcOutPortList));
    }

    byte[] getPort() {
        byte[] port = new byte[10];

        String label = (String) tfUniMirrorGroupDstPortList.getSelectedItem();
        port[0] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
        port[1] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));

        return port;
    }

    void setPort(byte[] port) {
        if (port != null && port.length > 1) {
            tfUniMirrorGroupDstPortList.setSelectedItem(port[0] + "/" + port[1]);
        } else {
            tfUniMirrorGroupDstPortList.setSelectedItem(null);
        }
    }

    byte[] getPortList(JCheckBox[] portList) {
        Vector v = new Vector();

        for (JCheckBox port : portList) {
            if (port.isEnabled() && port.isSelected()) {
                v.add(port.getText());
            }
        }

        byte[] value = new byte[10];
        for (int i = 0; i < v.size(); i++) {
            String label = (String) v.get(i);

            value[i * 2] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
            value[i * 2 + 1] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));
        }

        return value;
    }

    void setPortList(JCheckBox[] portList, byte[] value) {
        if (value == null || value.length < 1) return;

        int offset = 0;
        int count = value.length / 2;
        for (int i = 0; i < count & i < portList.length; i++) {
            String port = value[i * 2] + "/" + value[i * 2 + 1];

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
        disablePortList(tfUniMirrorGroupSrcInPortList, (String) tfUniMirrorGroupDstPortList.getSelectedItem());
        disablePortList(tfUniMirrorGroupSrcOutPortList, (String) tfUniMirrorGroupDstPortList.getSelectedItem());
    }
}