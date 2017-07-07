/**
 * Created by Zhou Chao, 2010/5/7
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniMacAddressTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class UniMacAddressTablePanel extends UPanel {

    private MacAddressField tfUniMacAddrIndex = new MacAddressField();
    private IntegerTextField tfUniMacAddrVlanIdIndex = new IntegerTextField();

    private int[] uniMacAddrTypeVList = new int[]{1, /*2, 3,*/};
    private String[] uniMacAddrTypeTList = new String[]{
            fStringMap.getString("static"), //1
//            fStringMap.getString("dynamic"), //2
//            fStringMap.getString("other"), //3
    };
    private JComboBox tfUniMacAddrType = new JComboBox(uniMacAddrTypeTList);
    private JComboBox tfUniMacAddrPortId = new JComboBox();

    private final String uniMacAddrIndex = fStringMap.getString("uniMacAddrIndex") + " : ";
    private final String uniMacAddrVlanIdIndex = fStringMap.getString("uniMacAddrVlanIdIndex") + " : ";
    private final String uniMacAddrType = fStringMap.getString("uniMacAddrType") + " : ";
    private final String uniMacAddrPortId = fStringMap.getString("uniMacAddrPortId") + " : ";

    public UniMacAddressTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(uniMacAddrIndex));
        baseInfoPanel.add(tfUniMacAddrIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMacAddrVlanIdIndex));
        baseInfoPanel.add(tfUniMacAddrVlanIdIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMacAddrType));
        tfUniMacAddrType.setEnabled(false);
        tfUniMacAddrType.setName(fStringMap.getString("uniMacAddrType"));
        baseInfoPanel.add(tfUniMacAddrType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMacAddrPortId));
        tfUniMacAddrPortId.setName(fStringMap.getString("uniMacAddrPortId"));
        baseInfoPanel.add(tfUniMacAddrPortId);
        baseInfoPanel.add(new HSpacer());


        for (int i = 0; i <4; i++) {
            tfUniMacAddrPortId.addItem("0/" + (i+1));
        }

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUniMacAddrIndex.setEditable(true);
            tfUniMacAddrVlanIdIndex.setEditable(true);
            return;
        } else {
            tfUniMacAddrIndex.setEditable(false);
            tfUniMacAddrVlanIdIndex.setEditable(false);
        }

        UniMacAddressTable mbean = (UniMacAddressTable) getModel();
        if (mbean == null)
            return;

        tfUniMacAddrIndex.setValue(mbean.getUniMacAddrIndex());
        tfUniMacAddrVlanIdIndex.setValue(mbean.getUniMacAddrVlanIdIndex());

        tfUniMacAddrType.setSelectedIndex(getIndexFromValue(uniMacAddrTypeVList, mbean.getUniMacAddrType()));
        setPort(mbean.getUniMacAddrPortId());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new UniMacAddressTable(fApplication.getSnmpProxy()));

        UniMacAddressTable mbean = (UniMacAddressTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUniMacAddrIndex(tfUniMacAddrIndex.getValue());
            mbean.setUniMacAddrVlanIdIndex(tfUniMacAddrVlanIdIndex.getValue());
        }

        mbean.setUniMacAddrType(new Integer(uniMacAddrTypeVList[tfUniMacAddrType.getSelectedIndex()]));
        mbean.setUniMacAddrPortId(getPort());
    }

    byte[] getPort() {
        byte[] port = new byte[2];

        String label = (String) tfUniMacAddrPortId.getSelectedItem();
        port[0] = (byte) Integer.parseInt(label.substring(0, label.indexOf('/')));
        port[1] = (byte) Integer.parseInt(label.substring(label.indexOf('/') + 1));

        return port;
    }

    void setPort(byte[] port) {
        if (port != null && port.length > 1) {
            tfUniMacAddrPortId.setSelectedItem(port[0] + "/" + port[1]);
        } else {
            tfUniMacAddrPortId.setSelectedItem(null);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}