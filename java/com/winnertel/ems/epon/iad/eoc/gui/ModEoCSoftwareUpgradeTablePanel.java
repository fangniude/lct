package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCSoftwareUpgradeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCSoftwareUpgradeTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCSoftwareUpgradeTablePanel extends UPanel {

    private JLabel tfModEoCSoftwareUpgradeCBATCardIndex = new JLabel();

    private JLabel tfModEoCSoftwareUpgradeCNUIndex = new JLabel();

    //private MacAddressField tfModEoCSoftwareUpgradeMACAddress = new MacAddressField();

    private int[] modEoCSoftwareUpgradeDevTypeVList = new int[]{
            1, 2, 3,
            //4, 5, 6, 7,
    };
    private String[] modEoCSoftwareUpgradeDevTypeTList = new String[]{
            fStringMap.getString("cbat"),
            fStringMap.getString("cbat-card"),
            fStringMap.getString("cnu"),
            //fStringMap.getString("other"),
            //fStringMap.getString("reserved1"),
            //fStringMap.getString("reserved2"),
            //fStringMap.getString("reserved3"),
    };
    private JComboBox tfModEoCSoftwareUpgradeDevType = new JComboBox(modEoCSoftwareUpgradeDevTypeTList);
    private StringTextField tfModEoCSoftwareUpgradeFileName = new StringTextField();

    private int[] modEoCSoftwareUpgradeProceedVList = new int[]{
            1, 2,
            //3,
    };
    private String[] modEoCSoftwareUpgradeProceedTList = new String[]{
            fStringMap.getString("download"),
            fStringMap.getString("upgrade"),
            //fStringMap.getString("upload"),
    };
    private JComboBox tfModEoCSoftwareUpgradeProceed = new JComboBox(modEoCSoftwareUpgradeProceedTList);

    private final String modEoCSoftwareUpgradeCBATCardIndex = fStringMap.getString("modEoCSoftwareUpgradeCBATCardIndex") + " : ";
    private final String modEoCSoftwareUpgradeCNUIndex = fStringMap.getString("modEoCSoftwareUpgradeCNUIndex") + " : ";
    private final String modEoCSoftwareUpgradeDevType = fStringMap.getString("modEoCSoftwareUpgradeDevType") + " : ";
    private final String modEoCSoftwareUpgradeFileName = fStringMap.getString("modEoCSoftwareUpgradeFileName") + " : ";
    private final String modEoCSoftwareUpgradeProceed = fStringMap.getString("modEoCSoftwareUpgradeProceed") + " : ";


    public ModEoCSoftwareUpgradeTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeCBATCardIndex));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeCNUIndex));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeCNUIndex);
        baseInfoPanel.add(new HSpacer());


        //baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeMACAddress));
        //tfModEoCSoftwareUpgradeMACAddress.setName(fStringMap.getString("modEoCSoftwareUpgradeMACAddress"));
        //baseInfoPanel.add(tfModEoCSoftwareUpgradeMACAddress);
        //baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeDevType));
        tfModEoCSoftwareUpgradeDevType.setName(fStringMap.getString("modEoCSoftwareUpgradeDevType"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeDevType);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeFileName));
        tfModEoCSoftwareUpgradeFileName.setName(fStringMap.getString("modEoCSoftwareUpgradeFileName"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeFileName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCSoftwareUpgradeProceed));
        tfModEoCSoftwareUpgradeProceed.setName(fStringMap.getString("modEoCSoftwareUpgradeProceed"));
        baseInfoPanel.add(tfModEoCSoftwareUpgradeProceed);
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


        tfModEoCSoftwareUpgradeFileName.setLenScope(1, 255);


    }

    public void refresh() {

        ModEoCSoftwareUpgradeTable mbean = (ModEoCSoftwareUpgradeTable) getModel();

        tfModEoCSoftwareUpgradeCBATCardIndex.setText(mbean.getModEoCSoftwareUpgradeCBATCardIndex().toString());
        tfModEoCSoftwareUpgradeCNUIndex.setText(mbean.getModEoCSoftwareUpgradeCNUIndex().toString());
        //tfModEoCSoftwareUpgradeMACAddress.setValue(mbean.getModEoCSoftwareUpgradeMACAddress());
        if ("0".equals(mbean.getModEoCSoftwareUpgradeCBATCardIndex().toString())) {
            tfModEoCSoftwareUpgradeDevType.setSelectedIndex(getIndexFromValue(modEoCSoftwareUpgradeDevTypeVList, 1));
        } else if ("0".equals(mbean.getModEoCSoftwareUpgradeCNUIndex().toString())) {
            tfModEoCSoftwareUpgradeDevType.setSelectedIndex(getIndexFromValue(modEoCSoftwareUpgradeDevTypeVList, 2));
        } else {
            tfModEoCSoftwareUpgradeDevType.setSelectedIndex(getIndexFromValue(modEoCSoftwareUpgradeDevTypeVList, 3));
        }
        tfModEoCSoftwareUpgradeDevType.disable();
        tfModEoCSoftwareUpgradeFileName.setValue(mbean.getModEoCSoftwareUpgradeFileName());
        tfModEoCSoftwareUpgradeProceed.setSelectedIndex(getIndexFromValue(modEoCSoftwareUpgradeProceedVList, mbean.getModEoCSoftwareUpgradeProceed().intValue()));
    }

    public void updateModel() {

        ModEoCSoftwareUpgradeTable mbean = (ModEoCSoftwareUpgradeTable) getModel();


        //mbean.setModEoCSoftwareUpgradeMACAddress(tfModEoCSoftwareUpgradeMACAddress.getValue());
        mbean.setModEoCSoftwareUpgradeDevType(new Integer(modEoCSoftwareUpgradeDevTypeVList[tfModEoCSoftwareUpgradeDevType.getSelectedIndex()]));
        mbean.setModEoCSoftwareUpgradeFileName(tfModEoCSoftwareUpgradeFileName.getValue());
        mbean.setModEoCSoftwareUpgradeProceed(new Integer(modEoCSoftwareUpgradeProceedVList[tfModEoCSoftwareUpgradeProceed.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
