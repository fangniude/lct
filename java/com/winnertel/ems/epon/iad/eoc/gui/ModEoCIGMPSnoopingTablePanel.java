package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCIGMPSnoopingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCIGMPSnoopingTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCIGMPSnoopingTablePanel extends UPanel {

    private JLabel tfModEoCIGMPSnoopingCBATCardIndex = new JLabel();

    private JLabel tfModEoCIGMPSnoopingCNUIndex = new JLabel();

    //private MacAddressField tfModEoCIGMPSnoopingDevMACAddress = new MacAddressField();

    private int[] modEoCIGMPSnoopingENVList = new int[]{
            0, 1,};
    private String[] modEoCIGMPSnoopingENTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfModEoCIGMPSnoopingEN = new JComboBox(modEoCIGMPSnoopingENTList);


    private final String modEoCIGMPSnoopingCBATCardIndex = fStringMap.getString("modEoCIGMPSnoopingCBATCardIndex") + " : ";
    private final String modEoCIGMPSnoopingCNUIndex = fStringMap.getString("modEoCIGMPSnoopingCNUIndex") + " : ";
    private final String modEoCIGMPSnoopingDevMACAddress = fStringMap.getString("modEoCIGMPSnoopingDevMACAddress") + " : ";
    private final String modEoCIGMPSnoopingEN = fStringMap.getString("modEoCIGMPSnoopingEN") + " : ";


    public ModEoCIGMPSnoopingTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCIGMPSnoopingCBATCardIndex));
        baseInfoPanel.add(tfModEoCIGMPSnoopingCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCIGMPSnoopingCNUIndex));
        baseInfoPanel.add(tfModEoCIGMPSnoopingCNUIndex);
        baseInfoPanel.add(new HSpacer());


        //baseInfoPanel.add(new JLabel(modEoCIGMPSnoopingDevMACAddress));
        //tfModEoCIGMPSnoopingDevMACAddress.setName(fStringMap.getString("modEoCIGMPSnoopingDevMACAddress"));
        //baseInfoPanel.add(tfModEoCIGMPSnoopingDevMACAddress);
        //baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCIGMPSnoopingEN));
        tfModEoCIGMPSnoopingEN.setName(fStringMap.getString("modEoCIGMPSnoopingEN"));
        baseInfoPanel.add(tfModEoCIGMPSnoopingEN);
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


    }

    public void refresh() {

        ModEoCIGMPSnoopingTable mbean = (ModEoCIGMPSnoopingTable) getModel();
        if (mbean == null)
            return;


        tfModEoCIGMPSnoopingCBATCardIndex.setText(mbean.getModEoCIGMPSnoopingCBATCardIndex().toString());
        tfModEoCIGMPSnoopingCNUIndex.setText(mbean.getModEoCIGMPSnoopingCNUIndex().toString());
        //tfModEoCIGMPSnoopingDevMACAddress.setValue(mbean.getModEoCIGMPSnoopingDevMACAddress());
        tfModEoCIGMPSnoopingEN.setSelectedIndex(getIndexFromValue(modEoCIGMPSnoopingENVList, mbean.getModEoCIGMPSnoopingEN().intValue()));

    }

    public void updateModel() {

        ModEoCIGMPSnoopingTable mbean = (ModEoCIGMPSnoopingTable) getModel();


        //mbean.setModEoCIGMPSnoopingDevMACAddress(tfModEoCIGMPSnoopingDevMACAddress.getValue());
        mbean.setModEoCIGMPSnoopingEN(new Integer(modEoCIGMPSnoopingENVList[tfModEoCIGMPSnoopingEN.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
