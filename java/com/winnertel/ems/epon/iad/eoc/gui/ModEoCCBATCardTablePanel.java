package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATCardTable;
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
 * The ModEoCCBATCardTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCCBATCardTablePanel extends UPanel {

    private JLabel tfModEoCCBATCardIndex = new JLabel();

    private MacAddressField tfModEoCCBATCardMACAddress = new MacAddressField();

    private int[] modEoCCBATCardOnlineStatusVList = new int[]{
            0, 1,};
    private String[] modEoCCBATCardOnlineStatusTList = new String[]{
            fStringMap.getString("offline"),
            fStringMap.getString("online"),
    };
    private JComboBox tfModEoCCBATCardOnlineStatus = new JComboBox(modEoCCBATCardOnlineStatusTList);
    private JLabel tfModEoCCBATCardModelNumber = new JLabel();

    private JLabel tfModEoCCBATCardSoftwareVersion = new JLabel();

    private int[] modEoCCBATCardResetVList = new int[]{
            2, 1,};
    private String[] modEoCCBATCardResetTList = new String[]{
            fStringMap.getString("false"),
            fStringMap.getString("true"),
    };
    private JComboBox tfModEoCCBATCardReset = new JComboBox(modEoCCBATCardResetTList);
    private IntegerTextField tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck = new IntegerTextField();

//    private MacAddressField tfModEoCCBATCardUpLinkDeviceMACAddress = new MacAddressField();

//    private IntegerTextField tfModEoCCBATCardUpLinkDevicePortNumber = new IntegerTextField();

    private IntegerTextField tfModEoCCBATCardConfigurationSaving = new IntegerTextField();

    private final String modEoCCBATCardIndex = fStringMap.getString("modEoCCBATCardIndex") + " : ";
    private final String modEoCCBATCardMACAddress = fStringMap.getString("modEoCCBATCardMACAddress") + " : ";
    private final String modEoCCBATCardOnlineStatus = fStringMap.getString("modEoCCBATCardOnlineStatus") + " : ";
    private final String modEoCCBATCardModelNumber = fStringMap.getString("modEoCCBATCardModelNumber") + " : ";
    private final String modEoCCBATCardSoftwareVersion = fStringMap.getString("modEoCCBATCardSoftwareVersion") + " : ";
    private final String modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck = fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck") + " : ";
    private final String modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck = fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck") + " : ";
//    private final String modEoCCBATCardUpLinkDeviceMACAddress = fStringMap.getString("modEoCCBATCardUpLinkDeviceMACAddress") + " : ";
//    private final String modEoCCBATCardUpLinkDevicePortNumber = fStringMap.getString("modEoCCBATCardUpLinkDevicePortNumber") + " : ";


    public ModEoCCBATCardTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATCardIndex));
        baseInfoPanel.add(tfModEoCCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardMACAddress));
        baseInfoPanel.add(tfModEoCCBATCardMACAddress);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardOnlineStatus));
        baseInfoPanel.add(tfModEoCCBATCardOnlineStatus);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardModelNumber));
        baseInfoPanel.add(tfModEoCCBATCardModelNumber);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardSoftwareVersion));
        baseInfoPanel.add(tfModEoCCBATCardSoftwareVersion);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(modEoCCBATCardReset));
        tfModEoCCBATCardReset.setName(fStringMap.getString("modEoCCBATCardReset"));
        baseInfoPanel.add(tfModEoCCBATCardReset);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck));
        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck.setName(fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck"));
        baseInfoPanel.add(tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck));
        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck.setName(fStringMap.getString("modEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck"));
        baseInfoPanel.add(tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck);
        baseInfoPanel.add(new HSpacer());


//        baseInfoPanel.add(new JLabel(modEoCCBATCardUpLinkDeviceMACAddress));
//        tfModEoCCBATCardUpLinkDeviceMACAddress.setName(fStringMap.getString("modEoCCBATCardUpLinkDeviceMACAddress"));
//        baseInfoPanel.add(tfModEoCCBATCardUpLinkDeviceMACAddress);
//        baseInfoPanel.add(new HSpacer());
//
//
//        baseInfoPanel.add(new JLabel(modEoCCBATCardUpLinkDevicePortNumber));
//        tfModEoCCBATCardUpLinkDevicePortNumber.setName(fStringMap.getString("modEoCCBATCardUpLinkDevicePortNumber"));
//        baseInfoPanel.add(tfModEoCCBATCardUpLinkDevicePortNumber);
//        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(modEoCCBATCardConfigurationSaving));
        tfModEoCCBATCardConfigurationSaving.setName(fStringMap.getString("modEoCCBATCardConfigurationSaving"));
        baseInfoPanel.add(tfModEoCCBATCardConfigurationSaving);
        baseInfoPanel.add(new HSpacer());
        */

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

        tfModEoCCBATCardMACAddress.setEditable(false);
        tfModEoCCBATCardOnlineStatus.setEnabled(false);

        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck.setValueScope(0, 2147483647);

        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck.setValueScope(0, 2147483647);


    }

    public void refresh() {

        ModEoCCBATCardTable mbean = (ModEoCCBATCardTable) getModel();

        if (mbean == null)
            return;

        tfModEoCCBATCardIndex.setText(mbean.getModEoCCBATCardIndex().toString());
        tfModEoCCBATCardMACAddress.setValue(mbean.getModEoCCBATCardMACAddress());
        tfModEoCCBATCardOnlineStatus.setSelectedIndex(getIndexFromValue(modEoCCBATCardOnlineStatusVList, mbean.getModEoCCBATCardOnlineStatus().intValue()));
        tfModEoCCBATCardModelNumber.setText(mbean.getModEoCCBATCardModelNumber());
        tfModEoCCBATCardSoftwareVersion.setText(mbean.getModEoCCBATCardSoftwareVersion());
        tfModEoCCBATCardReset.setSelectedIndex(getIndexFromValue(modEoCCBATCardResetVList, mbean.getModEoCCBATCardReset().intValue()));
        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck.setValue(mbean.getModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck().intValue());
        tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck.setValue(mbean.getModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck().intValue());
//        byte[] mac=mbean.getModEoCCBATCardUpLinkDeviceMACAddress();
//        if(mac==null || mac.length==0){
//            tfModEoCCBATCardUpLinkDeviceMACAddress.setValue("");    
//        }
//        else{
//            tfModEoCCBATCardUpLinkDeviceMACAddress.setValue(mac);
//        }
//        tfModEoCCBATCardUpLinkDevicePortNumber.setValue(mbean.getModEoCCBATCardUpLinkDevicePortNumber().intValue());
        tfModEoCCBATCardConfigurationSaving.setValue(mbean.getModEoCCBATCardConfigurationSaving().intValue());
    }

    public void updateModel() {

        ModEoCCBATCardTable mbean = (ModEoCCBATCardTable) getModel();


        mbean.setModEoCCBATCardReset(new Integer(modEoCCBATCardResetVList[tfModEoCCBATCardReset.getSelectedIndex()]));
        mbean.setModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck(new Integer(tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalBeforeAck.getValue()));
        mbean.setModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck(new Integer(tfModEoCCBATCardUpLinkBroadcastFrameSendIntervalAfterAck.getValue()));
//        mbean.setModEoCCBATCardUpLinkDeviceMACAddress(tfModEoCCBATCardUpLinkDeviceMACAddress.getValue());
//        mbean.setModEoCCBATCardUpLinkDevicePortNumber(new Integer(tfModEoCCBATCardUpLinkDevicePortNumber.getValue()));
        mbean.setModEoCCBATCardConfigurationSaving(new Integer(tfModEoCCBATCardConfigurationSaving.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}