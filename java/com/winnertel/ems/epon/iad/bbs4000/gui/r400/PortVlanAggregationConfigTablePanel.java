package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortVlanAggregationConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

/**
 * The PortVlanAggregationConfigTablePanel class.
 * Created by DVM Creator
 */
public class PortVlanAggregationConfigTablePanel extends UPanel implements ActionListener {

    EponDeviceIndexPanel deviceIndex = null;
    private IntegerTextField tfPortAggregationVidIndex = new IntegerTextField();

    //private StringTextField tfAggregationVidList = new StringTextField();

    private JList AggregationVidList = new JList();
    private Vector vlanVector = new Vector(512);

    private JButton addButton = new JButton();
    private JButton removeButton = new JButton();
    
    private final String portAggregationVidIndex = fStringMap.getString("portAggregationVidIndex") + " : ";
    private final String aggregationVidList = fStringMap.getString("aggregationVidList") + " : ";


    public PortVlanAggregationConfigTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel totalPanel = new JPanel();
        NTLayout layout1 = new NTLayout(3, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        totalPanel.setLayout(layout1);
        totalPanel.setBorder(BorderFactory.createEtchedBorder());

        deviceIndex = new EponDeviceIndexPanel(fStringMap,fApplication);
        totalPanel.add(deviceIndex);


        JPanel baseInfoPanel = new JPanel();
        NTLayout layout2 = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout2);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(portAggregationVidIndex));
        baseInfoPanel.add(tfPortAggregationVidIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(aggregationVidList));

        totalPanel.add(baseInfoPanel);


        JPanel baseInfoPanel2 = new JPanel();
        NTLayout layout3 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout3.setMargins(6, 10, 6, 10);
        baseInfoPanel2.setLayout(layout3);
        baseInfoPanel2.setBorder(BorderFactory.createEtchedBorder());


        JPanel buttonPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        buttonPanel.setLayout(layout);
        buttonPanel.add(new HSpacer());
        buttonPanel.add(new HSpacer());

        URL url = getClass().getResource("images/icon_add.gif");
        if (url != null) {
            addButton.setIcon(new ImageIcon(url));
        } else {
            addButton.setText("+");
        }
        addButton.setPreferredSize(new Dimension(20, 20));
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        url = getClass().getResource("images/icon_delete.gif");
        if (url != null) {
            removeButton.setIcon(new ImageIcon(url));
        } else {
            removeButton.setText("+");
        }
        removeButton.setPreferredSize(new Dimension(20, 20));
        removeButton.addActionListener(this);
        buttonPanel.add(removeButton);
        buttonPanel.add(new HSpacer());
        buttonPanel.add(new HSpacer());

        JPanel mVlanListPanel = new JPanel();
        BorderLayout layout4 = new BorderLayout();
        layout4.setHgap(10);
        mVlanListPanel.setLayout(layout4);
        //    mVlanListPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Multicast_Vlan_Panel")));

        //    mutilcastVlanList.setPreferredSize(new Dimension(180, 200));
        //    mutilcastVlanList.setBorder(BorderFactory.createEtchedBorder());
        JScrollPane mutilcastVlanListPane = new JScrollPane(AggregationVidList);
        mutilcastVlanListPane.setPreferredSize(new Dimension(180, 200));
        mutilcastVlanListPane.setBorder(BorderFactory.createEtchedBorder());

        mVlanListPanel.add(mutilcastVlanListPane, BorderLayout.CENTER);
        mVlanListPanel.add(buttonPanel, BorderLayout.EAST);

        //setLayout(new BorderLayout());
        baseInfoPanel2.add(new JScrollPane(mVlanListPanel));

        //setPreferredSize(new Dimension(450, 550));

        //totalPanel.add(baseInfoPanel2);
        baseInfoPanel.add(baseInfoPanel2);

        setLayout(new BorderLayout());
        add(totalPanel, BorderLayout.CENTER);


    }

    protected void initForm() {
        deviceIndex.initData();
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) return;

        PortVlanAggregationConfigTable mbean = (PortVlanAggregationConfigTable) getModel();

        deviceIndex.setEponDeviceIndex(mbean.getPvaDeviceIndex());
        deviceIndex.setOnuCardId(mbean.getPvaCardIndex());
        deviceIndex.setOnuPortId(mbean.getPvaPortIndex());
        tfPortAggregationVidIndex.setText(mbean.getPortAggregationVidIndex().toString());
        //tfAggregationVidList.setValue(mbean.getAggregationVidList());
        // tfAggregationRowStatus.setSelectedIndex(getIndexFromValue(aggregationRowStatusVList,mbean.getAggregationRowStatus().intValue()));

    }

    public boolean validateFrom() {
        if (SnmpAction.IType.ADD.equals(fCommand)){
            if (!deviceIndex.validateFrom()){
                return false;
            }
        }

        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new PortVlanAggregationConfigTable(fApplication.getSnmpProxy()));

        PortVlanAggregationConfigTable mbean = (PortVlanAggregationConfigTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setPvaDeviceIndex((int)deviceIndex.getEponDeviceIndex());
            mbean.setPvaCardIndex((int)deviceIndex.getOnuCardId());
            mbean.setPvaPortIndex(deviceIndex.getOnuPortId());
            mbean.setPortAggregationVidIndex(tfPortAggregationVidIndex.getValue());
        }


        mbean.setAggregationVidList(getMulticastVlanList());
        //   mbean.setAggregationRowStatus(new Integer(aggregationRowStatusVList[tfAggregationRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public byte[] getMulticastVlanList() {
        byte[] b = new byte[512];

        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        try {
            for (int i = 0; i < vlanVector.size(); i++) {
                int portId = Integer.parseInt((String) vlanVector.get(i));
                int idx_byte = portId / 8 ;
                int idx_bit = 7- (portId % 8) ;

                b[idx_byte]=(byte) (b[idx_byte] | (1<<idx_bit));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            //if(vlanVector.size() > 64)
            //{
            //  JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Vlan_Id_Is_More_Than_64"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            //  return;
            //}

            String input = JOptionPane.showInputDialog(this, fStringMap.getString("Msg_Input_Vlan_Id"), "1");
            if (input == null) return;

            try {
                int vlanId = Integer.parseInt(input.trim());
                if (vlanId < 0 || vlanId > 4095) {
                    JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
                    return;
                }

                insertVlanId(vlanId);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            }
        } else if (source == removeButton) {
            removeSelectedVlanId();
        }
    }

    protected void insertVlanId(int vlanId) {
        if (vlanVector.contains("" + vlanId)) {
            JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Exist"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            return;
        }

        vlanVector.add("" + vlanId);
        AggregationVidList.setListData(vlanVector);

        AggregationVidList.setSelectedValue("" + vlanId, true);
    }

    protected void removeSelectedVlanId() {
        Object[] vlan = AggregationVidList.getSelectedValues();

        for (int i = 0; i < vlan.length; i++) {
            vlanVector.remove(vlan[i]);
        }

        AggregationVidList.setListData(vlanVector);

        if (vlanVector.size() > 0) {
            AggregationVidList.setSelectedIndex(vlanVector.size() - 1);
        }
    }
    

}