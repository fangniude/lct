package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniAttributeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class SniAttributeTablePanel extends UPanel {

    private JLabel tfSniAttributeDeviceIndex = new JLabel();

    private JLabel tfSniAttributeCardIndex = new JLabel();

    private JLabel tfSniAttributePortIndex = new JLabel();

    private StringTextField tfSniPortName = new StringTextField();

    private int[] sniAdminStatusVList = new int[]{
            3, 1, 2,};
    private String[] sniAdminStatusTList = new String[]{
            fStringMap.getString("testing"),
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfSniAdminStatus = new JComboBox(sniAdminStatusTList);
    private int[] sniAutoNegotiationModeVList = new int[]{
            6, 4, 5, 3, 2, 1, 7,};
    private String[] sniAutoNegotiationModeTList = new String[]{
            fStringMap.getString("full-1000"),
            fStringMap.getString("half-100"),
            fStringMap.getString("full-100"),
            fStringMap.getString("full-10"),
            fStringMap.getString("half-10"),
            fStringMap.getString("auto-negotiate"),
            fStringMap.getString("full-10000"),
    };
    private JComboBox tfSniAutoNegotiationMode = new JComboBox(sniAutoNegotiationModeTList);
    private int[] sniPerfStats15minuteEnableVList = new int[]{
            1, 2,};
    private String[] sniPerfStats15minuteEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfSniPerfStats15minuteEnable = new JComboBox(sniPerfStats15minuteEnableTList);
    private int[] sniPerfStats24hourEnableVList = new int[]{
            1, 2,};
    private String[] sniPerfStats24hourEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfSniPerfStats24hourEnable = new JComboBox(sniPerfStats24hourEnableTList);

    private IntegerTextField tfSniMacAddrLearnMaxNum = new IntegerTextField();

    private int[] sniIsolationEnableVList = new int[]{
            1, 2,};
    private String[] sniIsolationEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfSniIsolationEnable = new JComboBox(sniIsolationEnableTList);


    private final String sniAttributeDeviceIndex = fStringMap.getString("sniAttributeDeviceIndex") + " : ";
    private final String sniAttributeCardIndex = fStringMap.getString("sniAttributeCardIndex") + " : ";
    private final String sniAttributePortIndex = fStringMap.getString("sniAttributePortIndex") + " : ";
    private final String sniPortName = fStringMap.getString("sniPortName") + " : ";
    private final String sniAdminStatus = fStringMap.getString("sniAdminStatus") + " : ";
    private final String sniAutoNegotiationMode = fStringMap.getString("sniAutoNegotiationMode") + " : ";
    private final String sniPerfStats15minuteEnable = fStringMap.getString("sniPerfStats15minuteEnable") + " : ";
    private final String sniPerfStats24hourEnable = fStringMap.getString("sniPerfStats24hourEnable") + " : ";
    private final String sniMacAddrLearnMaxNum = fStringMap.getString("sniMacAddrLearnMaxNum") + " : ";
    private final String sniIsolationEnable = fStringMap.getString("sniIsolationEnable") + " : ";


    public SniAttributeTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniAttributeDeviceIndex));
        baseInfoPanel.add(tfSniAttributeDeviceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniAttributeCardIndex));
        baseInfoPanel.add(tfSniAttributeCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniAttributePortIndex));
        baseInfoPanel.add(tfSniAttributePortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniPortName));
        tfSniPortName.setName(fStringMap.getString("sniPortName"));
        baseInfoPanel.add(tfSniPortName);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniAdminStatus));
        tfSniAdminStatus.setName(fStringMap.getString("sniAdminStatus"));
        baseInfoPanel.add(tfSniAdminStatus);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniAutoNegotiationMode));
        tfSniAutoNegotiationMode.setName(fStringMap.getString("sniAutoNegotiationMode"));
        baseInfoPanel.add(tfSniAutoNegotiationMode);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniPerfStats15minuteEnable));
        tfSniPerfStats15minuteEnable.setName(fStringMap.getString("sniPerfStats15minuteEnable"));
        baseInfoPanel.add(tfSniPerfStats15minuteEnable);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniPerfStats24hourEnable));
        tfSniPerfStats24hourEnable.setName(fStringMap.getString("sniPerfStats24hourEnable"));
        baseInfoPanel.add(tfSniPerfStats24hourEnable);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniMacAddrLearnMaxNum));
        tfSniMacAddrLearnMaxNum.setName(fStringMap.getString("sniMacAddrLearnMaxNum"));
        baseInfoPanel.add(tfSniMacAddrLearnMaxNum);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniIsolationEnable));
        tfSniIsolationEnable.setName(fStringMap.getString("sniIsolationEnable"));
        baseInfoPanel.add(tfSniIsolationEnable);
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


        tfSniPortName.setLenScope(0, 255);


    }

    public void refresh() {

        SniAttributeTable mbean = (SniAttributeTable) getModel();

        tfSniAttributeDeviceIndex.setText(mbean.getSniAttributeDeviceIndex().toString());
        tfSniAttributeCardIndex.setText(mbean.getSniAttributeCardIndex().toString());
        tfSniAttributePortIndex.setText(mbean.getSniAttributePortIndex().toString());
        tfSniPortName.setValue(mbean.getSniPortName());
        tfSniAdminStatus.setSelectedIndex(getIndexFromValue(sniAdminStatusVList, mbean.getSniAdminStatus().intValue()));
        tfSniAutoNegotiationMode.setSelectedIndex(getIndexFromValue(sniAutoNegotiationModeVList, mbean.getSniAutoNegotiationMode().intValue()));
        tfSniPerfStats15minuteEnable.setSelectedIndex(getIndexFromValue(sniPerfStats15minuteEnableVList, mbean.getSniPerfStats15minuteEnable().intValue()));
        tfSniPerfStats24hourEnable.setSelectedIndex(getIndexFromValue(sniPerfStats24hourEnableVList, mbean.getSniPerfStats24hourEnable().intValue()));
        tfSniMacAddrLearnMaxNum.setValue(mbean.getSniMacAddrLearnMaxNum().intValue());
        tfSniIsolationEnable.setSelectedIndex(getIndexFromValue(sniIsolationEnableVList, mbean.getSniIsolationEnable().intValue()));

    }

    public void updateModel() {
        SniAttributeTable mbean = (SniAttributeTable) getModel();

        mbean.setSniPortName(tfSniPortName.getValue());
        mbean.setSniAdminStatus(new Integer(sniAdminStatusVList[tfSniAdminStatus.getSelectedIndex()]));

        mbean.setSniAutoNegotiationMode(new Integer(sniAutoNegotiationModeVList[tfSniAutoNegotiationMode.getSelectedIndex()]));
        mbean.setSniPerfStats15minuteEnable(new Integer(sniPerfStats15minuteEnableVList[tfSniPerfStats15minuteEnable.getSelectedIndex()]));
        mbean.setSniPerfStats24hourEnable(new Integer(sniPerfStats24hourEnableVList[tfSniPerfStats24hourEnable.getSelectedIndex()]));
        mbean.setSniMacAddrLearnMaxNum(new Integer(tfSniMacAddrLearnMaxNum.getValue()));
        mbean.setSniIsolationEnable(new Integer(sniIsolationEnableVList[tfSniIsolationEnable.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
