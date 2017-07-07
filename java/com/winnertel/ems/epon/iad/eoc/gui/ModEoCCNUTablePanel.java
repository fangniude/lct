package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNUTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCCNUTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUTablePanel extends UPanel {

    private JLabel tfModEoCCNUCBATCardIndex = new JLabel();

    private JLabel tfModEoCCNUIndex = new JLabel();

    private MacAddressField tfModEoCCNUMACAddress = new MacAddressField();

    private int[] modEoCCNUOnlineStatusVList = new int[]{
            0, 1,};
    private String[] modEoCCNUOnlineStatusTList = new String[]{
            fStringMap.getString("offline"),
            fStringMap.getString("online"),
    };
    private JComboBox tfModEoCCNUOnlineStatus = new JComboBox(modEoCCNUOnlineStatusTList);
    private JLabel tfModEoCCNUModelNumber = new JLabel();

    private JLabel tfModEoCCNUPortAmount = new JLabel();

    private int[] modEoCCNUAuthorizationStateVList = new int[]{
            1, 0,};
    private String[] modEoCCNUAuthorizationStateTList = new String[]{
            fStringMap.getString("authorized"),
            fStringMap.getString("not-authorized"),
    };
    private JComboBox tfModEoCCNUAuthorizationState = new JComboBox(modEoCCNUAuthorizationStateTList);
    private JLabel tfModEoCCNUSoftwareVersion = new JLabel();

    private IntegerTextField tfModEoCCNUReset = new IntegerTextField();

    private JLabel tfModEoCCNURFAttenuation = new JLabel();

    private JLabel tfModEoCCNURFDownstreamQuality = new JLabel();

    private JLabel tfModEoCCNURFUpstreamQuality = new JLabel();

    private JLabel tfModEoCCNUPhyDownstreamRate = new JLabel();

    private JLabel tfModEoCCNUPhyUpstreamRate = new JLabel();

    private IntegerTextField tfModEoCCNUConfigurationSaving = new IntegerTextField();

    private int[] modEoCCNUConfigurationResultVList = new int[]{
            2, 1, 0,};
    private String[] modEoCCNUConfigurationResultTList = new String[]{
            fStringMap.getString("failed"),
            fStringMap.getString("running"),
            fStringMap.getString("success"),
    };
    private JComboBox tfModEoCCNUConfigurationResult = new JComboBox(modEoCCNUConfigurationResultTList);


    private final String modEoCCNUCBATCardIndex = fStringMap.getString("modEoCCNUCBATCardIndex") + " : ";
    private final String modEoCCNUIndex = fStringMap.getString("modEoCCNUIndex") + " : ";
    private final String modEoCCNUMACAddress = fStringMap.getString("modEoCCNUMACAddress") + " : ";
    private final String modEoCCNUOnlineStatus = fStringMap.getString("modEoCCNUOnlineStatus") + " : ";
    private final String modEoCCNUModelNumber = fStringMap.getString("modEoCCNUModelNumber") + " : ";
    private final String modEoCCNUPortAmount = fStringMap.getString("modEoCCNUPortAmount") + " : ";
    private final String modEoCCNUAuthorizationState = fStringMap.getString("modEoCCNUAuthorizationState") + " : ";
    private final String modEoCCNUSoftwareVersion = fStringMap.getString("modEoCCNUSoftwareVersion") + " : ";
    private final String modEoCCNUReset = fStringMap.getString("modEoCCNUReset") + " : ";
    private final String modEoCCNURFAttenuation = fStringMap.getString("modEoCCNURFAttenuation") + " : ";
    private final String modEoCCNURFDownstreamQuality = fStringMap.getString("modEoCCNURFDownstreamQuality") + " : ";
    private final String modEoCCNURFUpstreamQuality = fStringMap.getString("modEoCCNURFUpstreamQuality") + " : ";
    private final String modEoCCNUPhyDownstreamRate = fStringMap.getString("modEoCCNUPhyDownstreamRate") + " : ";
    private final String modEoCCNUPhyUpstreamRate = fStringMap.getString("modEoCCNUPhyUpstreamRate") + " : ";
    private final String modEoCCNUConfigurationSaving = fStringMap.getString("modEoCCNUConfigurationSaving") + " : ";
    private final String modEoCCNUConfigurationResult = fStringMap.getString("modEoCCNUConfigurationResult") + " : ";


    public ModEoCCNUTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(16, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCNUCBATCardIndex));
        baseInfoPanel.add(tfModEoCCNUCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUIndex));
        baseInfoPanel.add(tfModEoCCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUMACAddress));
        baseInfoPanel.add(tfModEoCCNUMACAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUOnlineStatus));
        baseInfoPanel.add(tfModEoCCNUOnlineStatus);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUModelNumber));
        baseInfoPanel.add(tfModEoCCNUModelNumber);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPortAmount));
        baseInfoPanel.add(tfModEoCCNUPortAmount);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUAuthorizationState));
        baseInfoPanel.add(tfModEoCCNUAuthorizationState);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUSoftwareVersion));
        baseInfoPanel.add(tfModEoCCNUSoftwareVersion);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUReset));
        tfModEoCCNUReset.setName(fStringMap.getString("modEoCCNUReset"));
        baseInfoPanel.add(tfModEoCCNUReset);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNURFAttenuation));
        baseInfoPanel.add(tfModEoCCNURFAttenuation);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNURFDownstreamQuality));
        baseInfoPanel.add(tfModEoCCNURFDownstreamQuality);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNURFUpstreamQuality));
        baseInfoPanel.add(tfModEoCCNURFUpstreamQuality);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPhyDownstreamRate));
        baseInfoPanel.add(tfModEoCCNUPhyDownstreamRate);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUPhyUpstreamRate));
        baseInfoPanel.add(tfModEoCCNUPhyUpstreamRate);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUConfigurationSaving));
        tfModEoCCNUConfigurationSaving.setName(fStringMap.getString("modEoCCNUConfigurationSaving"));
        baseInfoPanel.add(tfModEoCCNUConfigurationSaving);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUConfigurationResult));
        baseInfoPanel.add(tfModEoCCNUConfigurationResult);
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


        tfModEoCCNUMACAddress.setEditable(false);


    }

    public void refresh() {

        ModEoCCNUTable mbean = (ModEoCCNUTable) getModel();

        tfModEoCCNUCBATCardIndex.setText(mbean.getModEoCCNUCBATCardIndex().toString());
        tfModEoCCNUIndex.setText(mbean.getModEoCCNUIndex().toString());
        tfModEoCCNUMACAddress.setValue(mbean.getModEoCCNUMACAddress());
        tfModEoCCNUOnlineStatus.setSelectedIndex(getIndexFromValue(modEoCCNUOnlineStatusVList, mbean.getModEoCCNUOnlineStatus().intValue()));
        tfModEoCCNUModelNumber.setText(mbean.getModEoCCNUModelNumber());
        tfModEoCCNUPortAmount.setText(mbean.getModEoCCNUPortAmount().toString());
        tfModEoCCNUAuthorizationState.setSelectedIndex(getIndexFromValue(modEoCCNUAuthorizationStateVList, mbean.getModEoCCNUAuthorizationState().intValue()));
        tfModEoCCNUSoftwareVersion.setText(mbean.getModEoCCNUSoftwareVersion());
        tfModEoCCNUReset.setValue(mbean.getModEoCCNUReset().intValue());
        tfModEoCCNURFAttenuation.setText(mbean.getModEoCCNURFAttenuation().toString());
        tfModEoCCNURFDownstreamQuality.setText(mbean.getModEoCCNURFDownstreamQuality().toString());
        tfModEoCCNURFUpstreamQuality.setText(mbean.getModEoCCNURFUpstreamQuality().toString());
        tfModEoCCNUPhyDownstreamRate.setText(mbean.getModEoCCNUPhyDownstreamRate().toString());
        tfModEoCCNUPhyUpstreamRate.setText(mbean.getModEoCCNUPhyUpstreamRate().toString());
        tfModEoCCNUConfigurationSaving.setValue(mbean.getModEoCCNUConfigurationSaving().intValue());
        tfModEoCCNUConfigurationResult.setSelectedIndex(getIndexFromValue(modEoCCNUConfigurationResultVList, mbean.getModEoCCNUConfigurationResult().intValue()));

    }

    public void updateModel() {

        ModEoCCNUTable mbean = (ModEoCCNUTable) getModel();


        mbean.setModEoCCNUReset(new Integer(tfModEoCCNUReset.getValue()));


        mbean.setModEoCCNUConfigurationSaving(new Integer(tfModEoCCNUConfigurationSaving.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}