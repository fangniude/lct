package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCVLANPortTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

/**
 * The ModEoCVLANPortTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCVLANPortTablePanel extends UPanel implements ActionListener {

    private JLabel tfModEoCVLANCBATCardIndex = new JLabel();

    private JLabel tfModEoCVLANCNUIndex = new JLabel();

    private JLabel tfModEoCVLANPortIndex = new JLabel();

    private IntegerTextField tfModEoCVLANPortPVID = new IntegerTextField();

    private HexTextField tfModEoCVLANPortTPID = new HexTextField();

    private IntegerTextField tfModEoCVLANPortPrio = new IntegerTextField();

    //private StringTextField tfModEoCVLANPortVIDList = new StringTextField();

    //private StringTextField tfModEoCVLANPortUntaggedVIDList = new StringTextField();

    private JList VLANPortVIDList = new JList();
    private Vector VLANPortVIDVector = new Vector(512);

    private JButton VLANPortVID_addButton = new JButton();
    private JButton VLANPortVID_removeButton = new JButton();


    private JList VLANPortUntaggedVIDList = new JList();
    private Vector VLANPortUntaggedVIDVector = new Vector(512);

    private JButton VLANPortUntaggedVID_addButton = new JButton();
    private JButton VLANPortUntaggedVID_removeButton = new JButton();


    private int[] modEoCVLANPortModeVList = new int[]{
            1, 2, 0, 3,};
    private String[] modEoCVLANPortModeTList = new String[]{
            fStringMap.getString("access"),
            fStringMap.getString("trunk"),
            fStringMap.getString("transparent"),
            fStringMap.getString("hybrid"),
    };
    private JComboBox tfModEoCVLANPortMode = new JComboBox(modEoCVLANPortModeTList);


    private final String modEoCVLANCBATCardIndex = fStringMap.getString("modEoCVLANCBATCardIndex") + " : ";
    private final String modEoCVLANCNUIndex = fStringMap.getString("modEoCVLANCNUIndex") + " : ";
    private final String modEoCVLANPortIndex = fStringMap.getString("modEoCVLANPortIndex") + " : ";
    private final String modEoCVLANPortPVID = fStringMap.getString("modEoCVLANPortPVID") + " : ";
    private final String modEoCVLANPortTPID = fStringMap.getString("modEoCVLANPortTPID") + " : ";
    private final String modEoCVLANPortPrio = fStringMap.getString("modEoCVLANPortPrio") + " : ";
    private final String modEoCVLANPortVIDList = fStringMap.getString("modEoCVLANPortVIDList") + " : ";
    private final String modEoCVLANPortUntaggedVIDList = fStringMap.getString("modEoCVLANPortUntaggedVIDList") + " : ";
    private final String modEoCVLANPortMode = fStringMap.getString("modEoCVLANPortMode") + " : ";


    public ModEoCVLANPortTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCVLANCBATCardIndex));
        baseInfoPanel.add(tfModEoCVLANCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANCNUIndex));
        baseInfoPanel.add(tfModEoCVLANCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortIndex));
        baseInfoPanel.add(tfModEoCVLANPortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortPVID));
        tfModEoCVLANPortPVID.setName(fStringMap.getString("modEoCVLANPortPVID"));
        baseInfoPanel.add(tfModEoCVLANPortPVID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortTPID));
        tfModEoCVLANPortTPID.setName(fStringMap.getString("modEoCVLANPortTPID"));
        baseInfoPanel.add(tfModEoCVLANPortTPID);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortPrio));
        tfModEoCVLANPortPrio.setName(fStringMap.getString("modEoCVLANPortPrio"));
        baseInfoPanel.add(tfModEoCVLANPortPrio);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortVIDList));
        //tfModEoCVLANPortVIDList.setName(fStringMap.getString("modEoCVLANPortVIDList"));
        //baseInfoPanel.add(tfModEoCVLANPortVIDList);
        {
            JPanel buttonPanel = new JPanel();
            NTLayout layout_b = new NTLayout(6, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
            layout.setMargins(6, 10, 6, 10);
            buttonPanel.setLayout(layout_b);
            buttonPanel.add(new HSpacer());
            buttonPanel.add(new HSpacer());

            URL url = getClass().getResource("images/icon_add.gif");
            if (url != null) {
                VLANPortVID_addButton.setIcon(new ImageIcon(url));
            } else {
                VLANPortVID_addButton.setText("+");
            }
            VLANPortVID_addButton.setPreferredSize(new Dimension(20, 20));
            VLANPortVID_addButton.addActionListener(this);
            buttonPanel.add(VLANPortVID_addButton);

            url = getClass().getResource("images/icon_delete.gif");
            if (url != null) {
                VLANPortVID_removeButton.setIcon(new ImageIcon(url));
            } else {
                VLANPortVID_removeButton.setText("+");
            }
            VLANPortVID_removeButton.setPreferredSize(new Dimension(20, 20));
            VLANPortVID_removeButton.addActionListener(this);
            buttonPanel.add(VLANPortVID_removeButton);
            buttonPanel.add(new HSpacer());
            buttonPanel.add(new HSpacer());

            JPanel mVlanListPanel = new JPanel();
            BorderLayout layout4 = new BorderLayout();
            layout4.setHgap(10);
            mVlanListPanel.setLayout(layout4);
            JScrollPane mutilcastVlanListPane = new JScrollPane(VLANPortVIDList);
            mutilcastVlanListPane.setPreferredSize(new Dimension(180, 100));
            mutilcastVlanListPane.setBorder(BorderFactory.createEtchedBorder());

            mVlanListPanel.add(mutilcastVlanListPane, BorderLayout.CENTER);
            mVlanListPanel.add(buttonPanel, BorderLayout.EAST);

            baseInfoPanel.add(mVlanListPanel);
        }
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortUntaggedVIDList));
        //tfModEoCVLANPortUntaggedVIDList.setName(fStringMap.getString("modEoCVLANPortUntaggedVIDList"));
        //baseInfoPanel.add(tfModEoCVLANPortUntaggedVIDList);
        {
            JPanel buttonPanel = new JPanel();
            NTLayout layout_b = new NTLayout(6, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
            layout.setMargins(6, 10, 6, 10);
            buttonPanel.setLayout(layout_b);
            buttonPanel.add(new HSpacer());
            buttonPanel.add(new HSpacer());

            URL url = getClass().getResource("images/icon_add.gif");
            if (url != null) {
                VLANPortUntaggedVID_addButton.setIcon(new ImageIcon(url));
            } else {
                VLANPortUntaggedVID_addButton.setText("+");
            }
            VLANPortUntaggedVID_addButton.setPreferredSize(new Dimension(20, 20));
            VLANPortUntaggedVID_addButton.addActionListener(this);
            buttonPanel.add(VLANPortUntaggedVID_addButton);

            url = getClass().getResource("images/icon_delete.gif");
            if (url != null) {
                VLANPortUntaggedVID_removeButton.setIcon(new ImageIcon(url));
            } else {
                VLANPortUntaggedVID_removeButton.setText("+");
            }
            VLANPortUntaggedVID_removeButton.setPreferredSize(new Dimension(20, 20));
            VLANPortUntaggedVID_removeButton.addActionListener(this);
            buttonPanel.add(VLANPortUntaggedVID_removeButton);
            buttonPanel.add(new HSpacer());
            buttonPanel.add(new HSpacer());

            JPanel mVlanListPanel = new JPanel();
            BorderLayout layout4 = new BorderLayout();
            layout4.setHgap(10);
            mVlanListPanel.setLayout(layout4);
            JScrollPane mutilcastVlanListPane = new JScrollPane(VLANPortUntaggedVIDList);
            mutilcastVlanListPane.setPreferredSize(new Dimension(180, 100));
            mutilcastVlanListPane.setBorder(BorderFactory.createEtchedBorder());

            mVlanListPanel.add(mutilcastVlanListPane, BorderLayout.CENTER);
            mVlanListPanel.add(buttonPanel, BorderLayout.EAST);

            baseInfoPanel.add(mVlanListPanel);
        }

        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCVLANPortMode));
        tfModEoCVLANPortMode.setName(fStringMap.getString("modEoCVLANPortMode"));
        baseInfoPanel.add(tfModEoCVLANPortMode);
        baseInfoPanel.add(new HSpacer());


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


        tfModEoCVLANPortPVID.setValueScope(1, 4095);

        //tfModEoCVLANPortTPID.setValueScope(0, 65535);

        tfModEoCVLANPortPrio.setValueScope(0, 7);


    }

    public void refresh() {

        ModEoCVLANPortTable mbean = (ModEoCVLANPortTable) getModel();

        if (mbean == null)
            return;

        tfModEoCVLANCBATCardIndex.setText(mbean.getModEoCVLANCBATCardIndex().toString());
        tfModEoCVLANCNUIndex.setText(mbean.getModEoCVLANCNUIndex().toString());
        tfModEoCVLANPortIndex.setText(mbean.getModEoCVLANPortIndex().toString());
        tfModEoCVLANPortPVID.setValue(mbean.getModEoCVLANPortPVID().intValue());
        tfModEoCVLANPortTPID.setValue(Integer.toHexString(mbean.getModEoCVLANPortTPID().intValue()));
        tfModEoCVLANPortPrio.setValue(mbean.getModEoCVLANPortPrio().intValue());

        VLANPortVIDList.setListData(VLANPortVIDVector);
        VLANPortVIDList.setListData(VLANPortUntaggedVIDVector);

        parseVlanList(mbean.getModEoCVLANPortVIDList(), VLANPortVIDVector);
        VLANPortVIDList.setListData(VLANPortVIDVector);
        parseVlanList(mbean.getModEoCVLANPortUntaggedVIDList(), VLANPortUntaggedVIDVector);
        VLANPortUntaggedVIDList.setListData(VLANPortUntaggedVIDVector);

        tfModEoCVLANPortMode.setSelectedIndex(getIndexFromValue(modEoCVLANPortModeVList, mbean.getModEoCVLANPortMode().intValue()));

    }

    public void updateModel() {

        ModEoCVLANPortTable mbean = (ModEoCVLANPortTable) getModel();


        mbean.setModEoCVLANPortPVID(new Integer(tfModEoCVLANPortPVID.getValue()));
        mbean.setModEoCVLANPortTPID(Integer.valueOf(tfModEoCVLANPortTPID.getValue(), 16));
        mbean.setModEoCVLANPortPrio(new Integer(tfModEoCVLANPortPrio.getValue()));
        mbean.setModEoCVLANPortVIDList(getMulticastVlanList(VLANPortVIDVector));
        mbean.setModEoCVLANPortUntaggedVIDList(getMulticastVlanList(VLANPortUntaggedVIDVector));
        mbean.setModEoCVLANPortMode(new Integer(modEoCVLANPortModeVList[tfModEoCVLANPortMode.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public byte[] getMulticastVlanList(Vector vlanVector) {
        byte[] b = new byte[512];

        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        try {
            for (int i = 0; i < vlanVector.size(); i++) {
                int portId = Integer.parseInt((String) vlanVector.get(i));
                int idx_byte = portId / 8;
                int idx_bit = 7 - (portId % 8);

                b[idx_byte] = (byte) (b[idx_byte] | (1 << idx_bit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void parseVlanList(byte[] b, Vector vlanVector) {
        //byte[] b = new byte[512];

        //for (int i = 0; i < b.length; i++) {
        //    b[i] = 0;
        //}
        try {
            vlanVector.clear();
            if (b != null && b.length > 0) {

                int portIdx = 0;
                for (int i = 0; i < b.length; i = i + 1) {

                    for (int j = 0; j < 8; j++) {

                        if ((b[i] & (0x80 >> j)) == (0x80 >> j)) {
                            vlanVector.add(String.valueOf(portIdx));
                        }

                        portIdx = portIdx + 1;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return b;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == VLANPortVID_addButton) {
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
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            }
        } else if (source == VLANPortVID_removeButton) {
            removeSelectedVlanId();
        } else if (source == VLANPortUntaggedVID_addButton) {
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

                insertUntaggedVlanId(vlanId);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            }
        } else if (source == VLANPortUntaggedVID_removeButton) {
            removeSelectedUntaggedVlanId();
        }


    }

    protected void insertVlanId(int vlanId) {
        if (VLANPortVIDVector.contains("" + vlanId)) {
            JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Exist"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            return;
        }

        VLANPortVIDVector.add("" + vlanId);
        VLANPortVIDList.setListData(VLANPortVIDVector);

        VLANPortVIDList.setSelectedValue("" + vlanId, true);
    }

    protected void removeSelectedVlanId() {
        Object[] vlan = VLANPortVIDList.getSelectedValues();

        for (int i = 0; i < vlan.length; i++) {
            VLANPortVIDVector.remove(vlan[i]);
        }

        VLANPortVIDList.setListData(VLANPortVIDVector);

        if (VLANPortVIDVector.size() > 0) {
            VLANPortVIDList.setSelectedIndex(VLANPortVIDVector.size() - 1);
        }
    }

    protected void insertUntaggedVlanId(int vlanId) {
        if (VLANPortUntaggedVIDVector.contains("" + vlanId)) {
            JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Exist"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
            return;
        }

        VLANPortUntaggedVIDVector.add("" + vlanId);
        VLANPortUntaggedVIDList.setListData(VLANPortUntaggedVIDVector);

        VLANPortUntaggedVIDList.setSelectedValue("" + vlanId, true);
    }

    protected void removeSelectedUntaggedVlanId() {
        Object[] vlan = VLANPortUntaggedVIDList.getSelectedValues();

        for (int i = 0; i < vlan.length; i++) {
            VLANPortUntaggedVIDVector.remove(vlan[i]);
        }

        VLANPortUntaggedVIDList.setListData(VLANPortUntaggedVIDVector);

        if (VLANPortUntaggedVIDVector.size() > 0) {
            VLANPortUntaggedVIDList.setSelectedIndex(VLANPortUntaggedVIDVector.size() - 1);
        }
    }

}