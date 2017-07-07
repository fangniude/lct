package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMulticastOperProfTable;
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

/**
 * The GponOnuMulticastOperProfTablePanel class.
 * Created by DVM Creator
 */
public class GponOnuMulticastOperProfTablePanel extends UPanel {

    private IndexAutoGenField tfOnuMulticastOperProfileIndex = new IndexAutoGenField(fApplication,1);

    private StringTextField tfOnuMulticastOperProfileName = new StringTextField();

    private int[] onuMulticastOperProfIgmpVersionVList = new int[]{2, 1, 3,};
    private String[] onuMulticastOperProfIgmpVersionTList = new String[]{
            fStringMap.getString("igmp-version-2"),
            fStringMap.getString("igmp-version-1"),
            fStringMap.getString("igmp-version-3"),};
    private JComboBox tfOnuMulticastOperProfIgmpVersion = new JComboBox(
            onuMulticastOperProfIgmpVersionTList);
    private int[] onuMulticastOperProfMulticastControlModeVList = new int[]{
            2, 1, 3, 5, 4,};
    private String[] onuMulticastOperProfMulticastControlModeTList = new String[]{
            fStringMap.getString("standard-IGMP-snooping-with-proxy"),
            fStringMap.getString("standard-transparent-IGMP-snooping-only"),
            fStringMap.getString("standard-IGMP-proxy-reporting"),
            fStringMap.getString("ctc-controllable-mode"),
            fStringMap.getString("ctc-distributed-mode"),};
    private JComboBox tfOnuMulticastOperProfMulticastControlMode = new JComboBox(
            onuMulticastOperProfMulticastControlModeTList);
    private int[] onuMulticastOperProfFastLeaveModeVList = new int[]{1, 2,};
    private String[] onuMulticastOperProfFastLeaveModeTList = new String[]{
            fStringMap.getString("enabled"), fStringMap.getString("disabled"),};
    private JComboBox tfOnuMulticastOperProfFastLeaveMode = new JComboBox(
            onuMulticastOperProfFastLeaveModeTList);
    private IntegerTextField tfOnuMulticastOperProfUpstreamIGMPTCI = new IntegerTextField();

    private JComboBox tfOnuMulticastOperProfUpstreamIGMPTagControl = new JComboBox();

    private IntegerTextField tfOnuMulticastOperProfMaxSimultaneousGroup = new IntegerTextField();

    private int[] onuMulticastOperProfMulticastTagStripVList = new int[]{2,
            1,};
    private String[] onuMulticastOperProfMulticastTagStripTList = new String[]{
            fStringMap.getString("strip"), fStringMap.getString("not-strip"),};
    private JComboBox tfOnuMulticastOperProfMulticastTagStrip = new JComboBox(
            onuMulticastOperProfMulticastTagStripTList);

    private final String onuMulticastOperProfileIndex = fStringMap
            .getString("onuMulticastOperProfileIndex")
            + " : ";
    private final String onuMulticastOperProfileName = fStringMap
            .getString("onuMulticastOperProfileName")
            + " : ";
    private final String onuMulticastOperProfIgmpVersion = fStringMap
            .getString("onuMulticastOperProfIgmpVersion")
            + " : ";
    private final String onuMulticastOperProfMulticastControlMode = fStringMap
            .getString("onuMulticastOperProfMulticastControlMode")
            + " : ";
    private final String onuMulticastOperProfFastLeaveMode = fStringMap
            .getString("onuMulticastOperProfFastLeaveMode")
            + " : ";
    private final String onuMulticastOperProfUpstreamIGMPTCI = fStringMap
            .getString("onuMulticastOperProfUpstreamIGMPTCI")
            + " : ";
    private final String onuMulticastOperProfUpstreamIGMPTagControl = fStringMap
            .getString("onuMulticastOperProfUpstreamIGMPTagControl")
            + " : ";
    private final String onuMulticastOperProfMaxSimultaneousGroup = fStringMap
            .getString("onuMulticastOperProfMaxSimultaneousGroup")
            + " : ";
    private final String onuMulticastOperProfMulticastTagStrip = fStringMap
            .getString("onuMulticastOperProfMulticastTagStrip")
            + " : ";

    public GponOnuMulticastOperProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER,
                5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfileIndex));
        baseInfoPanel.add(tfOnuMulticastOperProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfileName));
        tfOnuMulticastOperProfileName.setName(fStringMap
                .getString("onuMulticastOperProfileName"));
        tfOnuMulticastOperProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuMulticastOperProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfIgmpVersion));
        tfOnuMulticastOperProfIgmpVersion.setName(fStringMap
                .getString("onuMulticastOperProfIgmpVersion"));
        tfOnuMulticastOperProfIgmpVersion.setSelectedIndex(getIndexFromValue(onuMulticastOperProfIgmpVersionVList, 2));
        baseInfoPanel.add(tfOnuMulticastOperProfIgmpVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfMulticastControlMode));
        tfOnuMulticastOperProfMulticastControlMode.setName(fStringMap
                .getString("onuMulticastOperProfMulticastControlMode"));
        tfOnuMulticastOperProfMulticastControlMode.setSelectedIndex(getIndexFromValue(onuMulticastOperProfMulticastControlModeVList, 4));
        baseInfoPanel.add(tfOnuMulticastOperProfMulticastControlMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfFastLeaveMode));
        tfOnuMulticastOperProfFastLeaveMode.setName(fStringMap
                .getString("onuMulticastOperProfFastLeaveMode"));
        baseInfoPanel.add(tfOnuMulticastOperProfFastLeaveMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfUpstreamIGMPTCI));
        tfOnuMulticastOperProfUpstreamIGMPTCI.setName(fStringMap
                .getString("onuMulticastOperProfUpstreamIGMPTCI"));
        tfOnuMulticastOperProfUpstreamIGMPTCI.setValue(0);
        baseInfoPanel.add(tfOnuMulticastOperProfUpstreamIGMPTCI);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel
                .add(new JLabel(onuMulticastOperProfUpstreamIGMPTagControl));
        tfOnuMulticastOperProfUpstreamIGMPTagControl.setName(fStringMap
                .getString("onuMulticastOperProfUpstreamIGMPTagControl"));
        for (long i = 0; i <= 4; i++) {
            tfOnuMulticastOperProfUpstreamIGMPTagControl.addItem(i);
        }
        tfOnuMulticastOperProfUpstreamIGMPTagControl.setSelectedItem(4);
        baseInfoPanel.add(tfOnuMulticastOperProfUpstreamIGMPTagControl);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfMaxSimultaneousGroup));
        tfOnuMulticastOperProfMaxSimultaneousGroup.setName(fStringMap
                .getString("onuMulticastOperProfMaxSimultaneousGroup"));
        baseInfoPanel.add(tfOnuMulticastOperProfMaxSimultaneousGroup);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMulticastOperProfMulticastTagStrip));
        tfOnuMulticastOperProfMulticastTagStrip.setName(fStringMap
                .getString("onuMulticastOperProfMulticastTagStrip"));
        baseInfoPanel.add(tfOnuMulticastOperProfMulticastTagStrip);
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

        tfOnuMulticastOperProfileIndex.setValueScope(0,2, 256);
        tfOnuMulticastOperProfMaxSimultaneousGroup.setValueScope(0, 65535);
      //  tfOnuMulticastOperProfUpstreamIGMPTCI.setValueScope(0, 32767);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuMulticastOperProfileIndex.setTable(fTable);
            tfOnuMulticastOperProfileIndex.setEnabled(true);
            tfOnuMulticastOperProfileIndex.refresh();
            return;
        } else {
            tfOnuMulticastOperProfileIndex.setEnabled(false);
        }
        GponOnuMulticastOperProfTable mbean = (GponOnuMulticastOperProfTable) getModel();

        tfOnuMulticastOperProfileIndex.setValue(0,mbean
                .getOnuMulticastOperProfileIndex());
        tfOnuMulticastOperProfileName.setValue(mbean
                .getOnuMulticastOperProfileName());
        tfOnuMulticastOperProfIgmpVersion.setSelectedIndex(getIndexFromValue(
                onuMulticastOperProfIgmpVersionVList, mbean
                .getOnuMulticastOperProfIgmpVersion().intValue()));
        tfOnuMulticastOperProfMulticastControlMode
                .setSelectedIndex(getIndexFromValue(
                        onuMulticastOperProfMulticastControlModeVList, mbean
                        .getOnuMulticastOperProfMulticastControlMode()
                        .intValue()));
        tfOnuMulticastOperProfFastLeaveMode.setSelectedIndex(getIndexFromValue(
                onuMulticastOperProfFastLeaveModeVList, mbean
                .getOnuMulticastOperProfFastLeaveMode().intValue()));
        tfOnuMulticastOperProfUpstreamIGMPTCI.setValue(mbean
                .getOnuMulticastOperProfUpstreamIGMPTCI().intValue());
        tfOnuMulticastOperProfUpstreamIGMPTagControl.setSelectedItem(mbean
                .getOnuMulticastOperProfUpstreamIGMPTagControl());
        tfOnuMulticastOperProfMaxSimultaneousGroup.setValue(mbean
                .getOnuMulticastOperProfMaxSimultaneousGroup().intValue());
        tfOnuMulticastOperProfMulticastTagStrip
                .setSelectedIndex(getIndexFromValue(
                        onuMulticastOperProfMulticastTagStripVList, mbean
                        .getOnuMulticastOperProfMulticastTagStrip()
                        .intValue()));


    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuMulticastOperProfTable(fApplication.getSnmpProxy()));

        GponOnuMulticastOperProfTable mbean = (GponOnuMulticastOperProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuMulticastOperProfileIndex(tfOnuMulticastOperProfileIndex.getValue(0));
        }
        mbean.setOnuMulticastOperProfileName(new String(tfOnuMulticastOperProfileName.getValue()));
        mbean.setOnuMulticastOperProfIgmpVersion(new Integer(onuMulticastOperProfIgmpVersionVList[tfOnuMulticastOperProfIgmpVersion.getSelectedIndex()]));
        mbean.setOnuMulticastOperProfMulticastControlMode(new Integer(onuMulticastOperProfMulticastControlModeVList[tfOnuMulticastOperProfMulticastControlMode.getSelectedIndex()]));
        mbean.setOnuMulticastOperProfFastLeaveMode(new Integer(onuMulticastOperProfFastLeaveModeVList[tfOnuMulticastOperProfFastLeaveMode.getSelectedIndex()]));
        mbean.setOnuMulticastOperProfUpstreamIGMPTCI(new Long(tfOnuMulticastOperProfUpstreamIGMPTCI.getValue()));
        mbean.setOnuMulticastOperProfUpstreamIGMPTagControl(new Long(tfOnuMulticastOperProfUpstreamIGMPTagControl.getSelectedItem().toString()));
        mbean.setOnuMulticastOperProfMaxSimultaneousGroup(new Long(tfOnuMulticastOperProfMaxSimultaneousGroup.getValue()));
        mbean.setOnuMulticastOperProfMulticastTagStrip(new Integer(onuMulticastOperProfMulticastTagStripVList[tfOnuMulticastOperProfMulticastTagStrip.getSelectedIndex()]));


    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuMulticastOperProfileIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
