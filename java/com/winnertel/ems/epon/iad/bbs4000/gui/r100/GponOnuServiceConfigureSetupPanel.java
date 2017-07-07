/**
 * Created by Zhou Chao, 2008/9/30 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuServiceConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GponOnuServiceConfigureSetupPanel extends UPanel {

    //------------------- MIB items -------------------
    private JLabel tfOnuCfgSlotNo = new JLabel();
    private JLabel tfOnuCfgPortNo = new JLabel();
    private JLabel tfOnuCfgLogicalPortNo = new JLabel();

    private long[] onuCfgServiceSubscriptionVList = new long[]{1, 2, 4,};
    private String[] onuCfgServiceSubscriptionTList = new String[]{
            fStringMap.getString("data"),
            fStringMap.getString("voip"),
            fStringMap.getString("iptv"),
    };
    private JComboBox tfOnuCfgServiceSubscription = new JComboBox(onuCfgServiceSubscriptionTList);

    private int[] onuCfgUpstreamTrafficMappingTypeVList = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
    private String[] onuCfgUpstreamTrafficMappingTypeTList = new String[]{
            fStringMap.getString("userPort2"),
            fStringMap.getString("vlanId"),
            fStringMap.getString("vlanPriorityBits"),
            fStringMap.getString("vlanIdAndPriorityBits"),
            fStringMap.getString("ethernetType"),
            fStringMap.getString("dscpValue"),
            fStringMap.getString("userPortVlanPriorityBits"),
            fStringMap.getString("userPortDscp"),
            fStringMap.getString("cucNPBridgeFiltering"),
            fStringMap.getString("cucNMBridgMapping"),
    };
    private JComboBox tfOnuCfgUpstreamTrafficMappingType = new JComboBox(onuCfgUpstreamTrafficMappingTypeTList);

    private ProfileChooser tfOnuCfgUpstreamTrafficMappingProfileIndex = new ProfileChooser(fApplication);

    private int[] onuCfgTcontVirtualPortBindingTypeVList = new int[]{1, 2,};
    private String[] onuCfgTcontVirtualPortBindingTypeTList = new String[]{
            fStringMap.getString("profile-based"),
            fStringMap.getString("detailed"),
    };
    private JComboBox tfOnuCfgTcontVirtualPortBindingType = new JComboBox(onuCfgTcontVirtualPortBindingTypeTList);

    private ProfileChooser tfOnuCfgTcontVirtualPortBindingProfileIndex = new ProfileChooser(fApplication);

    //private int[] onuCfgSecurityCapabilityVList = new int[]{2, 1,};
    //private String[] onuCfgSecurityCapabilityTList = new String[]{
    //        fStringMap.getString("AES"),
    //        fStringMap.getString("Reserved"),
    //};
    //private JComboBox tfOnuCfgSecurityCapability = new JComboBox(onuCfgSecurityCapabilityTList);

    private long[] onuCfgSecurityModeVList = new long[]{2, 1,};
    private String[] onuCfgSecurityModeTList = new String[]{
            fStringMap.getString("AES algorithm"),
            fStringMap.getString("Reserved"),
    };
    private JComboBox tfOnuCfgSecurityMode = new JComboBox(onuCfgSecurityModeTList);

    /*
    private int[] onuCfgOnuMulticastFilterModeVList = new int[]{1, 2, 3, 4,};
    private String[] onuCfgOnuMulticastFilterModeTList = new String[]{
            fStringMap.getString("Standard Distributed"),
            fStringMap.getString("CTC Distributed"),
            fStringMap.getString("CTC Central-Controlled"),
            fStringMap.getString("Disabled"),
    };
    private JComboBox tfOnuCfgOnuMulticastFilterMode = new JComboBox(onuCfgOnuMulticastFilterModeTList);

    private LongTextField tfOnuCfgOnuMulticastGemPortNo = new LongTextField();

    private ProfileChooser tfOnuCfgOnuStaticMulticastGroupsProfileIndex = new ProfileChooser(fApplication);
    */

    private final String onuCfgSlotNo = fStringMap.getString("onuCfgSlotNo") + ": ";
    private final String onuCfgPortNo = fStringMap.getString("onuCfgPortNo") + ": ";
    private final String onuCfgLogicalPortNo = fStringMap.getString("onuCfgLogicalPortNo") + ": ";
    private final String onuCfgServiceSubscription = fStringMap.getString("onuCfgServiceSubscription") + ": ";
    private final String onuCfgUpstreamTrafficMappingType = fStringMap.getString("onuCfgUpstreamTrafficMappingType") + ": ";
    private final String onuCfgUpstreamTrafficMappingProfileName = fStringMap.getString("onuCfgUpstreamTrafficMappingProfileName") + ": ";
    private final String onuCfgTcontVirtualPortBindingType = fStringMap.getString("onuCfgTcontVirtualPortBindingType") + ": ";
    private final String onuCfgTcontVirtualPortBindingProfileName = fStringMap.getString("onuCfgTcontVirtualPortBindingProfileName") + ": ";
    //private final String onuCfgSecurityCapability = fStringMap.getString("onuCfgSecurityCapability") + ": ";
    private final String onuCfgSecurityMode = fStringMap.getString("onuCfgSecurityMode") + ": ";

    //private final String onuCfgOnuMulticastFilterMode = fStringMap.getString("onuCfgOnuMulticastFilterMode") + ": ";
    //private final String onuCfgOnuMulticastGemPortNo = fStringMap.getString("onuCfgOnuMulticastGemPortNo") + ": ";
    //private final String onuCfgOnuStaticMulticastGroupsProfileName = fStringMap.getString("onuCfgOnuStaticMulticastGroupsProfileName") + ": ";

    public GponOnuServiceConfigureSetupPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuCfgSlotNo));
        baseInfoPanel.add(tfOnuCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgPortNo));
        baseInfoPanel.add(tfOnuCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgServiceSubscription));
        tfOnuCfgServiceSubscription.setName(fStringMap.getString("onuCfgServiceSubscription"));
        baseInfoPanel.add(tfOnuCfgServiceSubscription);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgUpstreamTrafficMappingType));
        tfOnuCfgUpstreamTrafficMappingType.setName(fStringMap.getString("onuCfgUpstreamTrafficMappingType"));
        baseInfoPanel.add(tfOnuCfgUpstreamTrafficMappingType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgUpstreamTrafficMappingProfileName));
        tfOnuCfgUpstreamTrafficMappingProfileIndex.setName(fStringMap.getString("onuCfgUpstreamTrafficMappingProfileName"));
        //set profile in 'ItemListener'
        baseInfoPanel.add(tfOnuCfgUpstreamTrafficMappingProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTcontVirtualPortBindingType));
        tfOnuCfgTcontVirtualPortBindingType.setName(fStringMap.getString("onuCfgTcontVirtualPortBindingType"));
        baseInfoPanel.add(tfOnuCfgTcontVirtualPortBindingType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTcontVirtualPortBindingProfileName));
        tfOnuCfgTcontVirtualPortBindingProfileIndex.setName(fStringMap.getString("onuCfgTcontVirtualPortBindingProfileName"));
        tfOnuCfgTcontVirtualPortBindingProfileIndex.setProfile("OnuTcontVPortBindProfTable_Panel");
        baseInfoPanel.add(tfOnuCfgTcontVirtualPortBindingProfileIndex);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuCfgSecurityCapability));
        //baseInfoPanel.add(tfOnuCfgSecurityCapability);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgSecurityMode));
        tfOnuCfgSecurityMode.setName(fStringMap.getString("onuCfgSecurityMode"));
        baseInfoPanel.add(tfOnuCfgSecurityMode);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuCfgOnuMulticastFilterMode));
        tfOnuCfgOnuMulticastFilterMode.setName(fStringMap.getString("onuCfgOnuMulticastFilterMode"));
        baseInfoPanel.add(tfOnuCfgOnuMulticastFilterMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuMulticastGemPortNo));
        tfOnuCfgOnuMulticastGemPortNo.setName(fStringMap.getString("onuCfgOnuMulticastGemPortNo"));
        baseInfoPanel.add(tfOnuCfgOnuMulticastGemPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgOnuStaticMulticastGroupsProfileName));
        tfOnuCfgOnuStaticMulticastGroupsProfileIndex.setName(fStringMap.getString("onuCfgOnuStaticMulticastGroupsProfileName"));
        tfOnuCfgOnuStaticMulticastGroupsProfileIndex.setProfile("OnuStaticMultiGroupProfTable_Panel");
        baseInfoPanel.add(tfOnuCfgOnuStaticMulticastGroupsProfileIndex);
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

        tfOnuCfgUpstreamTrafficMappingType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int type = onuCfgUpstreamTrafficMappingTypeVList[tfOnuCfgUpstreamTrafficMappingType.getSelectedIndex()];
                /**
                 * Upstream Traffic Mapping Profile Table
                 *   upstreamTrafficMappingType
                 *     1: ONU User Port (table: OnuUPUTMProfTable_Panel, panel: com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPUTMProfTablePanel)
                 *     2: ONU VLAN ID (table: , panel: )
                 *     3: ONU VLAN Priority Bits (table: , panel: )
                 *     4: ONU VLAN ID and VLAN Priority Bits (table: , panel: )
                 *     5, 6: (reserved) ()
                 *     7, 8: ONU User Port and CoS (table: OnuUPCUTMProfTable_Panel, panel: com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPCUTMProfTablePanel)
                 */
                if (type == 1) {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(true);
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setProfile("OnuUPUTMProfTable_Panel");
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.refresh();
                } else if (type == 2) {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(true);
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setProfile("OnuVlanIdUpTrafficMapProfTable_Panel");
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.refresh();
                } else if (type == 3) {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(true);
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setProfile("OnuVlanPriBitsUpTrafficMapProfTable_Panel");
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.refresh();
                } else if (type == 4) {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(true);
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setProfile("OnuVlanIdVlanPriBitUpTrafficMapProfTable_Panel");
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.refresh();
                } else if (type == 7 || type == 8) {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(true);
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setProfile("OnuUPCUTMProfTable_Panel");
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.refresh();
                } else {
                    tfOnuCfgUpstreamTrafficMappingProfileIndex.setEnabled(false);
                }
            }
        });
    }

    protected void initForm() {
        //tfOnuCfgSecurityMode.setValueScope(1, 255);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuCfgUpstreamTrafficMappingType.setSelectedIndex(2); //default onuCfgUpstreamTrafficMappingType is '3'

            tfOnuCfgTcontVirtualPortBindingProfileIndex.refresh();
            tfOnuCfgTcontVirtualPortBindingProfileIndex.setSelectedProfileIndex(1);

            return;
        }

        GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) getModel();
        if (mbean == null)
            return;

        tfOnuCfgSlotNo.setText((mbean.getOnuCfgSlotNo() != null) ? mbean.getOnuCfgSlotNo().toString() : "");
        tfOnuCfgPortNo.setText((mbean.getOnuCfgPortNo() != null) ? mbean.getOnuCfgPortNo().toString() : "");
        tfOnuCfgLogicalPortNo.setText((mbean.getOnuCfgLogicalPortNo() != null) ? mbean.getOnuCfgLogicalPortNo().toString() : "");

        tfOnuCfgServiceSubscription.setEnabled(mbean.getOnuCfgServiceSubscription() != null);
        tfOnuCfgServiceSubscription.setSelectedIndex(getIndexFromValue(onuCfgServiceSubscriptionVList, (mbean.getOnuCfgServiceSubscription() != null) ? mbean.getOnuCfgServiceSubscription() : 0));

        tfOnuCfgUpstreamTrafficMappingType.setEnabled(mbean.getOnuCfgUpstreamTrafficMappingType() != null);
        tfOnuCfgUpstreamTrafficMappingType.setSelectedIndex(getIndexFromValue(onuCfgUpstreamTrafficMappingTypeVList, (mbean.getOnuCfgUpstreamTrafficMappingType() != null) ? mbean.getOnuCfgUpstreamTrafficMappingType() : 3));

        tfOnuCfgUpstreamTrafficMappingProfileIndex.setSelectedProfileIndex(mbean.getOnuCfgUpstreamTrafficMappingProfileIndex());

        tfOnuCfgTcontVirtualPortBindingType.setEnabled(mbean.getOnuCfgTcontVirtualPortBindingType() != null);
        tfOnuCfgTcontVirtualPortBindingType.setSelectedIndex(getIndexFromValue(onuCfgTcontVirtualPortBindingTypeVList, (mbean.getOnuCfgTcontVirtualPortBindingType() != null) ? mbean.getOnuCfgTcontVirtualPortBindingType() : 1));

        tfOnuCfgTcontVirtualPortBindingProfileIndex.refresh();
        tfOnuCfgTcontVirtualPortBindingProfileIndex.setEnabled(mbean.getOnuCfgTcontVirtualPortBindingProfileIndex() != null);
        tfOnuCfgTcontVirtualPortBindingProfileIndex.setSelectedProfileIndex(mbean.getOnuCfgTcontVirtualPortBindingProfileIndex());

        //tfOnuCfgSecurityCapability.setText((mbean.getOnuCfgSecurityCapability() != null) ? mbean.getOnuCfgSecurityCapability().toString() : "");

        tfOnuCfgServiceSubscription.setEnabled(mbean.getOnuCfgServiceSubscription() != null);
        tfOnuCfgSecurityMode.setSelectedIndex(getIndexFromValue(onuCfgSecurityModeVList, (mbean.getOnuCfgSecurityMode() != null) ? mbean.getOnuCfgSecurityMode() : 0));

        //tfOnuCfgOnuStaticMulticastGroupsProfileIndex.refresh();
        //tfOnuCfgOnuStaticMulticastGroupsProfileIndex.setSelectedProfileIndex(mbean.getOnuCfgOnuStaticMulticastGroupsProfileIndex());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuServiceConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //...
        }

        if (tfOnuCfgServiceSubscription.isEnabled())
            mbean.setOnuCfgServiceSubscription(onuCfgServiceSubscriptionVList[tfOnuCfgServiceSubscription.getSelectedIndex()]);

        if (tfOnuCfgUpstreamTrafficMappingType.isEnabled())
            mbean.setOnuCfgUpstreamTrafficMappingType(onuCfgUpstreamTrafficMappingTypeVList[tfOnuCfgUpstreamTrafficMappingType.getSelectedIndex()]);

        if (tfOnuCfgUpstreamTrafficMappingProfileIndex.isEnabled())
            mbean.setOnuCfgUpstreamTrafficMappingProfileIndex(tfOnuCfgUpstreamTrafficMappingProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuCfgUpstreamTrafficMappingProfileIndex.getSelectedProfileIndex() : 1);

        if (tfOnuCfgTcontVirtualPortBindingType.isEnabled())
            mbean.setOnuCfgTcontVirtualPortBindingType(onuCfgTcontVirtualPortBindingTypeVList[tfOnuCfgTcontVirtualPortBindingType.getSelectedIndex()]);

        if (tfOnuCfgTcontVirtualPortBindingProfileIndex.isEnabled())
            mbean.setOnuCfgTcontVirtualPortBindingProfileIndex(tfOnuCfgTcontVirtualPortBindingProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuCfgTcontVirtualPortBindingProfileIndex.getSelectedProfileIndex() : 1);

        if (tfOnuCfgSecurityMode.isEnabled())
            mbean.setOnuCfgSecurityMode(onuCfgSecurityModeVList[tfOnuCfgSecurityMode.getSelectedIndex()]);

        //mbean.setOnuCfgOnuStaticMulticastGroupsProfileIndex(tfOnuCfgOnuStaticMulticastGroupsProfileIndex.getSelectedProfileIndex() >= 0 ? tfOnuCfgOnuStaticMulticastGroupsProfileIndex.getSelectedProfileIndex() : 1);
    }

    public int getIndexFromValue(int[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getIndexFromValue(long[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}