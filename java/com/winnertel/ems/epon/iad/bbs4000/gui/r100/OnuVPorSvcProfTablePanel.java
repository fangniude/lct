/**
 * Modified by Zhou Chao, 2008/9/30
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVPorSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuVPorSvcProfTablePanel extends UPanel {

    private IndexAutoGenField tfVirtualPortServiceProfileIndex = new IndexAutoGenField(fApplication, 1);

    private StringTextField tfOnuVPorSvcProfileName = new StringTextField();

    //private JLabel tfUpstreamTrafficMappingType = new JLabel();

    private int[] typeOfServiceVList = new int[]{1, 2, 3, 4, 5, 6, 7, 8,};
    private String[] typeOfServiceTList = new String[]{
            fStringMap.getString("data"),
            fStringMap.getString("iptv"),
            fStringMap.getString("video-on-demand"),
            fStringMap.getString("voIP"),
            fStringMap.getString("t1"),
            fStringMap.getString("e1"),
            fStringMap.getString("hpna"),
            fStringMap.getString("others"),
    };
    private JComboBox tfTypeOfService = new JComboBox(typeOfServiceTList);

    private int[] encryptionModeVList = new int[]{1, 2,};
    private String[] encryptionModeTList = new String[]{
            fStringMap.getString("enabled"),
            fStringMap.getString("disabled"),
    };
    private JComboBox tfEncryptionMode = new JComboBox(encryptionModeTList);

    private ProfileChooser tfOnuVPortSvcProfUpstreamBandwidthProfileIndex = new ProfileChooser(fApplication);

    private JComboBox tfUpstreamFlowPriority = new JComboBox();

    private JComboBox tfUpstreamFlowWeight = new JComboBox();

    private LongTextField tfUpstreamRateControlSchedulerProfileIndex = new LongTextField();

    private ProfileChooser tfDownstreamBandwidthProfileIndex = new ProfileChooser(fApplication);

    private int[] downstreamQueuingSchedulingTypeVList = new int[]{1, 0,};
    private String[] downstreamQueuingSchedulingTypeTList = new String[]{
            fStringMap.getString("flow-based"),
            fStringMap.getString("priority-controlled")
    };
    private JComboBox tfDownstreamQueuingSchedulingType = new JComboBox(downstreamQueuingSchedulingTypeTList);

    private JComboBox tfDownstreamFlowPriority = new JComboBox();

    private final String virtualPortServiceProfileIndex = fStringMap.getString("virtualPortServiceProfileIndex") + ": ";
    private final String onuVPorSvcProfileName = fStringMap.getString("onuVPorSvcProfileName") + ": ";
    //private final String upstreamTrafficMappingType = fStringMap.getString("upstreamTrafficMappingType") + ": ";
    private final String typeOfService = fStringMap.getString("typeOfService") + ": ";
    private final String encryptionMode = fStringMap.getString("encryptionMode") + ": ";
    private final String upstreamFlowPriority = fStringMap.getString("upstreamFlowPriority") + ": ";
    private final String upstreamFlowWeight = fStringMap.getString("upstreamFlowWeight") + ": ";
    private final String upstreamRateControlSchedulerProfileIndex = fStringMap.getString("upstreamRateControlSchedulerProfileIndex") + ": ";
    private final String downstreamBandwidthProfileIndex = fStringMap.getString("downstreamBandwidthProfileIndex") + ": ";
    private final String downstreamQueuingSchedulingType = fStringMap.getString("downstreamQueuingSchedulingType") + ": ";
    private final String downstreamFlowPriority = fStringMap.getString("downstreamFlowPriority") + ": ";
    private final String onuVPortSvcProfUpstreamBandwidthProfileIndex = fStringMap.getString("onuVPortSvcProfUpstreamBandwidthProfileIndex") + ": ";

    public OnuVPorSvcProfTablePanel(IApplication app) {
        super(app);
        setModel(new OnuVPorSvcProfTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(virtualPortServiceProfileIndex));
        baseInfoPanel.add(tfVirtualPortServiceProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVPorSvcProfileName));
        tfOnuVPorSvcProfileName.setName(fStringMap.getString("onuVPorSvcProfileName"));
        tfOnuVPorSvcProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuVPorSvcProfileName);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(upstreamTrafficMappingType));
        //baseInfoPanel.add(tfUpstreamTrafficMappingType);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(typeOfService));
        tfTypeOfService.setName(fStringMap.getString("typeOfService"));
        baseInfoPanel.add(tfTypeOfService);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(encryptionMode));
        tfEncryptionMode.setName(fStringMap.getString("encryptionMode"));
        baseInfoPanel.add(tfEncryptionMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVPortSvcProfUpstreamBandwidthProfileIndex));
        tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.setName(fStringMap.getString("onuVPortSvcProfUpstreamBandwidthProfileIndex"));
        baseInfoPanel.add(tfOnuVPortSvcProfUpstreamBandwidthProfileIndex);
        tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.setProfile("OnuBwProfTable_Panel");
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upstreamFlowPriority));
        tfUpstreamFlowPriority.setName(fStringMap.getString("upstreamFlowPriority"));
        baseInfoPanel.add(tfUpstreamFlowPriority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upstreamFlowWeight));
        tfUpstreamFlowWeight.setName(fStringMap.getString("upstreamFlowWeight"));
        baseInfoPanel.add(tfUpstreamFlowWeight);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upstreamRateControlSchedulerProfileIndex));
        tfUpstreamRateControlSchedulerProfileIndex.setName(fStringMap.getString("upstreamRateControlSchedulerProfileIndex"));
        baseInfoPanel.add(tfUpstreamRateControlSchedulerProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(downstreamBandwidthProfileIndex));
        tfDownstreamBandwidthProfileIndex.setName(fStringMap.getString("downstreamBandwidthProfileIndex"));
        tfDownstreamBandwidthProfileIndex.setProfile("OnuBwProfTable_Panel");
        baseInfoPanel.add(tfDownstreamBandwidthProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(downstreamQueuingSchedulingType));
        tfDownstreamQueuingSchedulingType.setName(fStringMap.getString("downstreamQueuingSchedulingType"));
        baseInfoPanel.add(tfDownstreamQueuingSchedulingType);
        baseInfoPanel.add(new HSpacer());

//        tfDownstreamQueuingSchedulingType.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                if (downstreamQueuingSchedulingTypeVList[tfDownstreamQueuingSchedulingType.getSelectedIndex()] == 1) {
//                    tfUpstreamFlowPriority.setEnabled(true);
//                    tfUpstreamFlowWeight.setEnabled(true);
//                    tfDownstreamFlowPriority.setEnabled(true);
//                } else {
//                    tfUpstreamFlowPriority.setEnabled(false);
//                    tfUpstreamFlowWeight.setEnabled(false);
//                    tfDownstreamFlowPriority.setEnabled(false);
//                }
//            }
//        });

        baseInfoPanel.add(new JLabel(downstreamFlowPriority));
        tfDownstreamFlowPriority.setName(fStringMap.getString("downstreamFlowPriority"));
        baseInfoPanel.add(tfDownstreamFlowPriority);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        for (long i = 0; i <= 7; i++) {
            tfDownstreamFlowPriority.addItem(i);
            tfUpstreamFlowPriority.addItem(i);
        }

        for (long i = 0; i <= 255; i++)
            tfUpstreamFlowWeight.addItem(i);
        tfUpstreamFlowWeight.setSelectedItem(1);
    }

    protected void initForm() {
        tfUpstreamRateControlSchedulerProfileIndex.setValueScope(1, 128);
        tfVirtualPortServiceProfileIndex.setValueScope(0, 2, 128);
    }

    public void refresh() {
        tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.refresh();
        tfDownstreamBandwidthProfileIndex.refresh();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfVirtualPortServiceProfileIndex.setEnabled(true);
            tfVirtualPortServiceProfileIndex.setTable(fTable);
            tfVirtualPortServiceProfileIndex.refresh();
            tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.setSelectedProfileIndex(1);
            tfDownstreamBandwidthProfileIndex.setSelectedProfileIndex(1);
            return;
        } else {
            tfVirtualPortServiceProfileIndex.setEnabled(false);
        }

//        if (downstreamQueuingSchedulingTypeVList[tfDownstreamQueuingSchedulingType.getSelectedIndex()] == 1) {
//            tfUpstreamFlowPriority.setEnabled(true);
//            tfUpstreamFlowWeight.setEnabled(true);
//            tfDownstreamFlowPriority.setEnabled(true);
//        } else {
//            tfUpstreamFlowPriority.setEnabled(false);
//            tfUpstreamFlowWeight.setEnabled(false);
//            tfDownstreamFlowPriority.setEnabled(false);
//        }

        OnuVPorSvcProfTable mbean = (OnuVPorSvcProfTable) getModel();
        if (mbean == null)
            return;

        tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.setSelectedProfileIndex(mbean.getOnuVPortSvcProfUpstreamBandwidthProfileIndex());
        tfDownstreamBandwidthProfileIndex.setSelectedProfileIndex(mbean.getDownstreamBandwidthProfileIndex());

        String sValue = "";
        long lValue = 0;

        tfVirtualPortServiceProfileIndex.setValue(0, mbean.getVirtualPortServiceProfileIndex());

        try {
            sValue = mbean.getOnuVPorSvcProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuVPorSvcProfileName.setValue(sValue);

        try {
            lValue = mbean.getTypeOfService();
        } catch (Exception e) {
            lValue = 0;
        }
        tfTypeOfService.setSelectedIndex(getIndexFromValue(typeOfServiceVList, lValue));

        try {
            lValue = mbean.getEncryptionMode();
        } catch (Exception e) {
            lValue = 0;
        }
        tfEncryptionMode.setSelectedIndex(getIndexFromValue(encryptionModeVList, lValue));

        try {
            lValue = mbean.getUpstreamFlowPriority();
        } catch (Exception e) {
            lValue = 0;
        }
        tfUpstreamFlowPriority.setSelectedItem(lValue);

        try {
            lValue = mbean.getUpstreamFlowWeight();
        } catch (Exception e) {
            lValue = 0;
        }
        tfUpstreamFlowWeight.setSelectedItem(lValue);

        try {
            lValue = mbean.getUpstreamRateControlSchedulerProfileIndex();
        } catch (Exception e) {
            lValue = 0;
        }
        tfUpstreamRateControlSchedulerProfileIndex.setValue(lValue);

        //iValue = mbean.getDownstreamBandwidthProfileIndex();
        //tfDownstreamBandwidthProfileIndex.setValue(iValue);
        int iValue2 = 0;
        try {
            iValue2 = getIndexFromValue(downstreamQueuingSchedulingTypeVList, mbean.getDownstreamQueuingSchedulingType());
        } catch (Exception e) {
            iValue2 = 0;
        }
        tfDownstreamQueuingSchedulingType.setSelectedIndex(iValue2);
        try {
            lValue = mbean.getDownstreamFlowPriority();
        } catch (Exception e) {
            lValue = 0;
        }
        tfDownstreamFlowPriority.setSelectedItem(lValue);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuVPorSvcProfTable(fApplication.getSnmpProxy()));

        OnuVPorSvcProfTable mbean = (OnuVPorSvcProfTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setVirtualPortServiceProfileIndex(tfVirtualPortServiceProfileIndex.getValue(0));
            mbean.setOnuVPorSvcProfileName(tfOnuVPorSvcProfileName.getValue());
        }

        mbean.setOnuVPorSvcProfileName(tfOnuVPorSvcProfileName.getValue());

        mbean.setTypeOfService(typeOfServiceVList[tfTypeOfService.getSelectedIndex()]);

        mbean.setEncryptionMode(encryptionModeVList[tfEncryptionMode.getSelectedIndex()]);

        mbean.setOnuVPortSvcProfUpstreamBandwidthProfileIndex(tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuVPortSvcProfUpstreamBandwidthProfileIndex.getSelectedProfileIndex() : 1);

        mbean.setUpstreamRateControlSchedulerProfileIndex(tfUpstreamRateControlSchedulerProfileIndex.getValue());

        mbean.setDownstreamBandwidthProfileIndex(tfDownstreamBandwidthProfileIndex.getSelectedProfileIndex() >= 0 ? tfDownstreamBandwidthProfileIndex.getSelectedProfileIndex() : 1);

        mbean.setDownstreamQueuingSchedulingType(downstreamQueuingSchedulingTypeVList[tfDownstreamQueuingSchedulingType.getSelectedIndex()]);

//        if (downstreamQueuingSchedulingTypeVList[tfDownstreamQueuingSchedulingType.getSelectedIndex()] == 1) {
            mbean.setUpstreamFlowPriority(Long.parseLong(tfUpstreamFlowPriority.getSelectedItem().toString()));
            mbean.setUpstreamFlowWeight(Long.parseLong((tfUpstreamFlowWeight.getSelectedItem().toString())));
            mbean.setDownstreamFlowPriority(Long.parseLong(tfDownstreamFlowPriority.getSelectedItem().toString()));
//        }
    }

    public void afterUpdateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfVirtualPortServiceProfileIndex.increaseIndexValue();
        }
    }

    public int getIndexFromValue(int[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}