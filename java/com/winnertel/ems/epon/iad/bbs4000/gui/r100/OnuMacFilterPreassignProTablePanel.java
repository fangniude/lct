package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuMacFilterPreassignProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OnuMacFilterPreassignProTablePanel class.
 * Created by DVM Creator
 */
public class OnuMacFilterPreassignProTablePanel extends UPanel {

    private IndexAutoGenField tfOnuMacFilterPreassignProfileIndex = new IndexAutoGenField(fApplication,1);

    private StringTextField tfOnuMacFilterPreassignProfileName = new StringTextField();

    private int[] onuMacFilterPreassignProfIPv4MulticastVList = new int[]{2,
            1,};
    private String[] onuMacFilterPreassignProfIPv4MulticastTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfIPv4Multicast = new JComboBox(
            onuMacFilterPreassignProfIPv4MulticastTList);
    private int[] onuMacFilterPreassignProfIPv6MulticastVList = new int[]{2,
            1,};
    private String[] onuMacFilterPreassignProfIPv6MulticastTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfIPv6Multicast = new JComboBox(
            onuMacFilterPreassignProfIPv6MulticastTList);
    private int[] onuMacFilterPreassignProfIPv4BroadcastVList = new int[]{2,
            1,};
    private String[] onuMacFilterPreassignProfIPv4BroadcastTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfIPv4Broadcast = new JComboBox(
            onuMacFilterPreassignProfIPv4BroadcastTList);
    private int[] onuMacFilterPreassignProfRARPVList = new int[]{2, 1,};
    private String[] onuMacFilterPreassignProfRARPTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfRARP = new JComboBox(
            onuMacFilterPreassignProfRARPTList);
    private int[] onuMacFilterPreassignProfIPXVList = new int[]{2, 1,};
    private String[] onuMacFilterPreassignProfIPXTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfIPX = new JComboBox(
            onuMacFilterPreassignProfIPXTList);
    private int[] onuMacFilterPreassignProfNetBEUIVList = new int[]{2, 1,};
    private String[] onuMacFilterPreassignProfNetBEUITList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfNetBEUI = new JComboBox(
            onuMacFilterPreassignProfNetBEUITList);
    private int[] onuMacFilterPreassignProfAppleTalkVList = new int[]{2, 1,};
    private String[] onuMacFilterPreassignProfAppleTalkTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfAppleTalk = new JComboBox(
            onuMacFilterPreassignProfAppleTalkTList);
    private int[] onuMacFilterPreassignProfBridgeManagemenInformationVList = new int[]{
            2, 1,};
    private String[] onuMacFilterPreassignProfBridgeManagemenInformationTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfBridgeManagemenInformation = new JComboBox(
            onuMacFilterPreassignProfBridgeManagemenInformationTList);
    private int[] onuMacFilterPreassignProfARPVList = new int[]{2, 1,};
    private String[] onuMacFilterPreassignProfARPTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfARP = new JComboBox(
            onuMacFilterPreassignProfARPTList);
    private int[] onuMacFilterPreassignProfPPPoEBroadcastVList = new int[]{2,
            1,};
    private String[] onuMacFilterPreassignProfPPPoEBroadcastTList = new String[]{
            fStringMap.getString("filter"), fStringMap.getString("forward"),};
    private JComboBox tfOnuMacFilterPreassignProfPPPoEBroadcast = new JComboBox(
            onuMacFilterPreassignProfPPPoEBroadcastTList);
    private int[] onuMacFilterPreassignProfRowStatusVList = new int[]{1, 2,
            5, 4, 3, 6,};
    private String[] onuMacFilterPreassignProfRowStatusTList = new String[]{
            fStringMap.getString("active"),
            fStringMap.getString("notInService"),
            fStringMap.getString("createAndWait"),
            fStringMap.getString("createAndGo"),
            fStringMap.getString("notReady"), fStringMap.getString("destroy"),};
    private JComboBox tfOnuMacFilterPreassignProfRowStatus = new JComboBox(
            onuMacFilterPreassignProfRowStatusTList);

    private final String onuMacFilterPreassignProfileIndex = fStringMap
            .getString("onuMacFilterPreassignProfileIndex")
            + " : ";
    private final String onuMacFilterPreassignProfileName = fStringMap
            .getString("onuMacFilterPreassignProfileName")
            + " : ";
    private final String onuMacFilterPreassignProfIPv4Multicast = fStringMap
            .getString("onuMacFilterPreassignProfIPv4Multicast")
            + " : ";
    private final String onuMacFilterPreassignProfIPv6Multicast = fStringMap
            .getString("onuMacFilterPreassignProfIPv6Multicast")
            + " : ";
    private final String onuMacFilterPreassignProfIPv4Broadcast = fStringMap
            .getString("onuMacFilterPreassignProfIPv4Broadcast")
            + " : ";
    private final String onuMacFilterPreassignProfRARP = fStringMap
            .getString("onuMacFilterPreassignProfRARP")
            + " : ";
    private final String onuMacFilterPreassignProfIPX = fStringMap
            .getString("onuMacFilterPreassignProfIPX")
            + " : ";
    private final String onuMacFilterPreassignProfNetBEUI = fStringMap
            .getString("onuMacFilterPreassignProfNetBEUI")
            + " : ";
    private final String onuMacFilterPreassignProfAppleTalk = fStringMap
            .getString("onuMacFilterPreassignProfAppleTalk")
            + " : ";
    private final String onuMacFilterPreassignProfBridgeManagemenInformation = fStringMap
            .getString("onuMacFilterPreassignProfBridgeManagemenInformation")
            + " : ";
    private final String onuMacFilterPreassignProfARP = fStringMap
            .getString("onuMacFilterPreassignProfARP")
            + " : ";
    private final String onuMacFilterPreassignProfPPPoEBroadcast = fStringMap
            .getString("onuMacFilterPreassignProfPPPoEBroadcast")
            + " : ";

    public OnuMacFilterPreassignProTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER,
                5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfileIndex));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfileName));
        tfOnuMacFilterPreassignProfileName.setName(fStringMap
                .getString("onuMacFilterPreassignProfileName"));
        tfOnuMacFilterPreassignProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuMacFilterPreassignProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfIPv4Multicast));
        tfOnuMacFilterPreassignProfIPv4Multicast.setName(fStringMap
                .getString("onuMacFilterPreassignProfIPv4Multicast"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfIPv4Multicast);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfIPv6Multicast));
        tfOnuMacFilterPreassignProfIPv6Multicast.setName(fStringMap
                .getString("onuMacFilterPreassignProfIPv6Multicast"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfIPv6Multicast);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfIPv4Broadcast));
        tfOnuMacFilterPreassignProfIPv4Broadcast.setName(fStringMap
                .getString("onuMacFilterPreassignProfIPv4Broadcast"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfIPv4Broadcast);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfRARP));
        tfOnuMacFilterPreassignProfRARP.setName(fStringMap
                .getString("onuMacFilterPreassignProfRARP"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfRARP);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfIPX));
        tfOnuMacFilterPreassignProfIPX.setName(fStringMap
                .getString("onuMacFilterPreassignProfIPX"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfIPX);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfNetBEUI));
        tfOnuMacFilterPreassignProfNetBEUI.setName(fStringMap
                .getString("onuMacFilterPreassignProfNetBEUI"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfNetBEUI);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfAppleTalk));
        tfOnuMacFilterPreassignProfAppleTalk.setName(fStringMap
                .getString("onuMacFilterPreassignProfAppleTalk"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfAppleTalk);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(
                onuMacFilterPreassignProfBridgeManagemenInformation));
        tfOnuMacFilterPreassignProfBridgeManagemenInformation
                .setName(fStringMap
                        .getString("onuMacFilterPreassignProfBridgeManagemenInformation"));
        baseInfoPanel
                .add(tfOnuMacFilterPreassignProfBridgeManagemenInformation);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfARP));
        tfOnuMacFilterPreassignProfARP.setName(fStringMap
                .getString("onuMacFilterPreassignProfARP"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfARP);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMacFilterPreassignProfPPPoEBroadcast));
        tfOnuMacFilterPreassignProfPPPoEBroadcast.setName(fStringMap
                .getString("onuMacFilterPreassignProfPPPoEBroadcast"));
        baseInfoPanel.add(tfOnuMacFilterPreassignProfPPPoEBroadcast);
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

        tfOnuMacFilterPreassignProfileIndex.setValueScope(0,2, 32);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)){
            tfOnuMacFilterPreassignProfileIndex.setEnabled(true);
            tfOnuMacFilterPreassignProfileIndex.setTable(fTable);
            tfOnuMacFilterPreassignProfileIndex.refresh();
            return;
        }
        else
            tfOnuMacFilterPreassignProfileIndex.setEnabled(false);
            
        OnuMacFilterPreassignProTable mbean = (OnuMacFilterPreassignProTable) getModel();

        tfOnuMacFilterPreassignProfileIndex.setValue(0,mbean
                .getOnuMacFilterPreassignProfileIndex());
        tfOnuMacFilterPreassignProfileName.setValue(mbean
                .getOnuMacFilterPreassignProfileName());
        tfOnuMacFilterPreassignProfIPv4Multicast
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfIPv4MulticastVList, mbean
                        .getOnuMacFilterPreassignProfIPv4Multicast()
                        .intValue()));
        tfOnuMacFilterPreassignProfIPv6Multicast
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfIPv6MulticastVList, mbean
                        .getOnuMacFilterPreassignProfIPv6Multicast()
                        .intValue()));
        tfOnuMacFilterPreassignProfIPv4Broadcast
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfIPv4BroadcastVList, mbean
                        .getOnuMacFilterPreassignProfIPv4Broadcast()
                        .intValue()));
        tfOnuMacFilterPreassignProfRARP.setSelectedIndex(getIndexFromValue(
                onuMacFilterPreassignProfRARPVList, mbean
                .getOnuMacFilterPreassignProfRARP().intValue()));
        tfOnuMacFilterPreassignProfIPX.setSelectedIndex(getIndexFromValue(
                onuMacFilterPreassignProfIPXVList, mbean
                .getOnuMacFilterPreassignProfIPX().intValue()));
        tfOnuMacFilterPreassignProfNetBEUI.setSelectedIndex(getIndexFromValue(
                onuMacFilterPreassignProfNetBEUIVList, mbean
                .getOnuMacFilterPreassignProfNetBEUI().intValue()));
        tfOnuMacFilterPreassignProfAppleTalk
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfAppleTalkVList, mbean
                        .getOnuMacFilterPreassignProfAppleTalk()
                        .intValue()));
        tfOnuMacFilterPreassignProfBridgeManagemenInformation
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfBridgeManagemenInformationVList,
                        mbean
                                .getOnuMacFilterPreassignProfBridgeManagemenInformation()
                                .intValue()));
        tfOnuMacFilterPreassignProfARP.setSelectedIndex(getIndexFromValue(
                onuMacFilterPreassignProfARPVList, mbean
                .getOnuMacFilterPreassignProfARP().intValue()));
        tfOnuMacFilterPreassignProfPPPoEBroadcast
                .setSelectedIndex(getIndexFromValue(
                        onuMacFilterPreassignProfPPPoEBroadcastVList, mbean
                        .getOnuMacFilterPreassignProfPPPoEBroadcast()
                        .intValue()));


    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuMacFilterPreassignProTable(fApplication.getSnmpProxy()));

        OnuMacFilterPreassignProTable mbean = (OnuMacFilterPreassignProTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuMacFilterPreassignProfileIndex(tfOnuMacFilterPreassignProfileIndex.getValue(0));
        }

        mbean.setOnuMacFilterPreassignProfileName(new String(tfOnuMacFilterPreassignProfileName.getValue()));
        mbean.setOnuMacFilterPreassignProfIPv4Multicast(new Integer(onuMacFilterPreassignProfIPv4MulticastVList[tfOnuMacFilterPreassignProfIPv4Multicast.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfIPv6Multicast(new Integer(onuMacFilterPreassignProfIPv6MulticastVList[tfOnuMacFilterPreassignProfIPv6Multicast.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfIPv4Broadcast(new Integer(onuMacFilterPreassignProfIPv4BroadcastVList[tfOnuMacFilterPreassignProfIPv4Broadcast.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfRARP(new Integer(onuMacFilterPreassignProfRARPVList[tfOnuMacFilterPreassignProfRARP.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfIPX(new Integer(onuMacFilterPreassignProfIPXVList[tfOnuMacFilterPreassignProfIPX.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfNetBEUI(new Integer(onuMacFilterPreassignProfNetBEUIVList[tfOnuMacFilterPreassignProfNetBEUI.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfAppleTalk(new Integer(onuMacFilterPreassignProfAppleTalkVList[tfOnuMacFilterPreassignProfAppleTalk.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfBridgeManagemenInformation(new Integer(onuMacFilterPreassignProfBridgeManagemenInformationVList[tfOnuMacFilterPreassignProfBridgeManagemenInformation.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfARP(new Integer(onuMacFilterPreassignProfARPVList[tfOnuMacFilterPreassignProfARP.getSelectedIndex()]));
        mbean.setOnuMacFilterPreassignProfPPPoEBroadcast(new Integer(onuMacFilterPreassignProfPPPoEBroadcastVList[tfOnuMacFilterPreassignProfPPPoEBroadcast.getSelectedIndex()]));


    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuMacFilterPreassignProfileIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
