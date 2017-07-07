package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniAttributeTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniMacAddressTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SniMacAddressTablePanel class.
 * Created by DVM Creator
 */
public class SniMacAddressTablePanel extends UPanel {

    private MacAddressField tfSniMacAddrIndex = new MacAddressField();

    private IntegerTextField tfSniMacAddrVlanIdIndex = new IntegerTextField();

    private JComboBox tfSniMacAddrPortId = new JComboBox();

    private final String sniMacAddrIndex = fStringMap.getString("sniMacAddrIndex") + " : ";
    private final String sniMacAddrVlanIdIndex = fStringMap.getString("sniMacAddrVlanIdIndex") + " : ";
    private final String sniMacAddrPortId = fStringMap.getString("sniMacAddrPortId") + " : ";


    public SniMacAddressTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniMacAddrIndex));
        baseInfoPanel.add(tfSniMacAddrIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniMacAddrVlanIdIndex));
        baseInfoPanel.add(tfSniMacAddrVlanIdIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniMacAddrPortId));
        tfSniMacAddrPortId.setName(fStringMap.getString("sniMacAddrPortId"));
        baseInfoPanel.add(tfSniMacAddrPortId);
        baseInfoPanel.add(new HSpacer());


        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfSniMacAddrVlanIdIndex.setValueScope(1, 4095);
    }

    public void refresh() {
        tfSniMacAddrPortId.removeAllItems();

        //get all the uplink port.
        SniAttributeTable bean = new SniAttributeTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, bean);

        for(int i = 0; i < v.size(); i++) {
            SniAttributeTable row = (SniAttributeTable)v.get(i);
            tfSniMacAddrPortId.addItem(row.getSniAttributeCardIndex() + "/" + row.getSniAttributePortIndex());
        }

        if(SnmpAction.IType.ADD.equals(fCommand)) {
            tfSniMacAddrIndex.setEditable(true);
            return;
        } else {
            tfSniMacAddrIndex.setEditable(false);
        }
        
        SniMacAddressTable mbean = (SniMacAddressTable) getModel();

        tfSniMacAddrIndex.setValue(mbean.getSniMacAddrIndex());
        tfSniMacAddrVlanIdIndex.setValue(mbean.getSniMacAddrVlanIdIndex());

        setPortId(mbean.getSniMacAddrPortId().intValue());
    }

    public void updateModel() {

        if(SnmpAction.IType.ADD.equals(fCommand)) setModel(new SniMacAddressTable(fApplication.getSnmpProxy()));

        SniMacAddressTable mbean = (SniMacAddressTable) getModel();

        if(SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setSniMacAddrIndex(tfSniMacAddrIndex.getValue());
        }

        mbean.setSniMacAddrVlanIdIndex(tfSniMacAddrVlanIdIndex.getValue());
        mbean.setSniMacAddrPortId(new Long(getPortId()));
    }

    int getPortId() {
        String label = (String)tfSniMacAddrPortId.getSelectedItem();

        int module = Integer.parseInt(label.substring(0, label.indexOf('/')));
        int port = Integer.parseInt(label.substring(label.indexOf('/')+1));

        int portId = 0;

        portId = portId | (module << 16);
        portId = portId | (port << 8);

        return portId;
    }

    void setPortId(int index) {
        int[] port = new int[4];

        for(int i = 0; i < port.length; i++) {
            port[port.length-1-i] = index & 0xFF;
            index = index >> 8;
        }

        tfSniMacAddrPortId.setSelectedItem(port[1] + "/" + port[2]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
