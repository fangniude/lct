package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.GeneralConfiguration;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

//modified by Zhou Chao, 2008/12/9
public class GeneralConfigurationPanel extends UPanel {

    private int[] vList = new int[]{2, 1,};
    private String[] tList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };

    private JComboBox tfUtsBBSBPDUTermination = new JComboBox(tList);
    private JComboBox tfUtsBBSSysSoftwareRateLimiting = new JComboBox(tList);
    //private JComboBox tfUtsBBSSysHardwareRateLimiting = new JComboBox(tList);

    private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdTotal = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdPerTask = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysMemoryUtilityAlarmThreshold = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysARPAgingTime = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysMACAgingTime = new IntegerTextField();

    //private IntegerTextField tfUtsBBSOnuByteErrorWindow = new IntegerTextField();
    //private IntegerTextField tfUtsBBSOnuByteErrorThresholdMin = new IntegerTextField();

    //private JComboBox tfUtsPonSysLogicalPortStrictBinging = new JComboBox(tList);

    //private IntegerTextField tfUtsPonSysOltMACAgingTime = new IntegerTextField();

    //private JComboBox tfUtsPonSysOlpMode = new JComboBox(tList);

    private StringTextField tfUtsBBSVlanVPNTPID = new StringTextField();

    private int[] utsBBSVlanVPNPRISourceVList = new int[]{1, 2,};
    private String[] utsBBSVlanVPNPRISourceTList = new String[]{
            fStringMap.getString("customertag"),
            fStringMap.getString("llid"),
    };
    private JComboBox tfUtsBBSVlanVPNPRISource = new JComboBox(utsBBSVlanVPNPRISourceTList);

    private IntegerTextField tfUtsBBSMaxFrameSize = new IntegerTextField();

    private JComboBox tfUtsBBSMgmtGratuitousArpLearning = new JComboBox(tList);

    private IPAddressField tfUtsBBSMgmtIgmpProxySourceIP = new IPAddressField();

    private IntegerTextField tfUtsBBSMgmtUplinkBandwidthThreshold = new IntegerTextField();
    private IntegerTextField tfUtsBBSMgmtUniBandwidthThreshold = new IntegerTextField();
    //private IntegerTextField tfUtsBBSMgmtIGMProxySourceInnerVLAN = new IntegerTextField();
    //private IntegerTextField tfUtsBBSMgmtIGMProxySourceOuterVLAN = new IntegerTextField();

    private int[] utsBBSMgmtONUSNumberSwitchVList = new int[]{1, 2,};
    private String[] utsBBSMgmtONUSNumberSwitchTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfUtsBBSMgmtONUSNumberSwitch = new JComboBox(utsBBSMgmtONUSNumberSwitchTList);

    private final String utsBBSBPDUTermination = fStringMap.getString("utsBBSBPDUTermination") + ": ";
    private final String utsBBSSysSoftwareRateLimiting = fStringMap.getString("utsBBSSysSoftwareRateLimiting") + ": ";
    //private final String utsBBSSysHardwareRateLimiting = fStringMap.getString("utsBBSSysHardwareRateLimiting") + ": ";
    private final String utsBBSSysCpuUtilityAlarmThresholdTotal = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal") + ": ";
    private final String utsBBSSysCpuUtilityAlarmThresholdPerTask = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask") + ": ";
    private final String utsBBSSysMemoryUtilityAlarmThreshold = fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold") + ": ";
    private final String utsBBSSysARPAgingTime = fStringMap.getString("utsBBSSysARPAgingTime") + ": ";
    private final String utsBBSSysMACAgingTime = fStringMap.getString("utsBBSSysMACAgingTime") + ": ";
    //private final String utsBBSOnuByteErrorWindow = fStringMap.getString("utsBBSOnuByteErrorWindow") + ": ";
    //private final String utsBBSOnuByteErrorThresholdMin = fStringMap.getString("utsBBSOnuByteErrorThresholdMin") + ": ";
    //private final String utsPonSysLogicalPortStrictBinging = fStringMap.getString("utsPonSysLogicalPortStrictBinging") + ": ";
    //private final String utsPonSysOltMACAgingTime = fStringMap.getString("utsPonSysOltMACAgingTime") + ": ";
    //private final String utsPonSysOlpMode = fStringMap.getString("utsPonSysOlpMode") + ": ";
    private final String utsBBSVlanVPNTPID = fStringMap.getString("utsBBSVlanVPNTPID") + ": ";
    private final String utsBBSVlanVPNPRISource = fStringMap.getString("utsBBSVlanVPNPRISource") + ": ";
    private final String utsBBSMaxFrameSize = fStringMap.getString("utsBBSMaxFrameSize") + ": ";
    private final String utsBBSMgmtGratuitousArpLearning = fStringMap.getString("utsBBSMgmtGratuitousArpLearning") + ": ";
    private final String utsBBSMgmtIgmpProxySourceIP = fStringMap.getString("utsBBSMgmtIgmpProxySourceIP") + ": ";
    private final String utsBBSMgmtUplinkBandwidthThreshold = fStringMap.getString("utsBBSMgmtUplinkBandwidthThreshold") + ": ";
    private final String utsBBSMgmtUniBandwidthThreshold = fStringMap.getString("utsBBSMgmtUniBandwidthThreshold") + ": ";
    //private final String utsBBSMgmtIGMProxySourceInnerVLAN = fStringMap.getString("utsBBSMgmtIGMProxySourceInnerVLAN") + ": ";
    //private final String utsBBSMgmtIGMProxySourceOuterVLAN = fStringMap.getString("utsBBSMgmtIGMProxySourceOuterVLAN") + ": ";
    private final String utsBBSMgmtONUSNumberSwitch = fStringMap.getString("utsBBSMgmtONUSNumberSwitch") + ": ";

    public GeneralConfigurationPanel(IApplication app) {
        super(app);
        setModel(new GeneralConfiguration(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_GeneralConfiguration");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsBBSBPDUTermination));
        tfUtsBBSBPDUTermination.setName(fStringMap.getString("utsBBSBPDUTermination"));
        baseInfoPanel.add(tfUtsBBSBPDUTermination);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysSoftwareRateLimiting));
        tfUtsBBSSysSoftwareRateLimiting.setName(fStringMap.getString("utsBBSSysSoftwareRateLimiting"));
        baseInfoPanel.add(tfUtsBBSSysSoftwareRateLimiting);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsBBSSysHardwareRateLimiting));
        //tfUtsBBSSysHardwareRateLimiting.setName(fStringMap.getString("utsBBSSysHardwareRateLimiting"));
        //baseInfoPanel.add(tfUtsBBSSysHardwareRateLimiting);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdTotal));
        tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal"));
        baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdTotal);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdPerTask));
        tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask"));
        baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysMemoryUtilityAlarmThreshold));
        tfUtsBBSSysMemoryUtilityAlarmThreshold.setName(fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold"));
        baseInfoPanel.add(tfUtsBBSSysMemoryUtilityAlarmThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysARPAgingTime));
        tfUtsBBSSysARPAgingTime.setName(fStringMap.getString("utsBBSSysARPAgingTime"));
        baseInfoPanel.add(tfUtsBBSSysARPAgingTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSSysMACAgingTime));
        tfUtsBBSSysMACAgingTime.setName(fStringMap.getString("utsBBSSysMACAgingTime"));
        baseInfoPanel.add(tfUtsBBSSysMACAgingTime);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(utsBBSOnuByteErrorWindow));
        tfUtsBBSOnuByteErrorWindow.setName(fStringMap.getString("utsBBSOnuByteErrorWindow"));
        baseInfoPanel.add(tfUtsBBSOnuByteErrorWindow);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSOnuByteErrorThresholdMin));
        tfUtsBBSOnuByteErrorThresholdMin.setName(fStringMap.getString("utsBBSOnuByteErrorThresholdMin"));
        baseInfoPanel.add(tfUtsBBSOnuByteErrorThresholdMin);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysLogicalPortStrictBinging));
        tfUtsPonSysLogicalPortStrictBinging.setName(fStringMap.getString("utsPonSysLogicalPortStrictBinging"));
        baseInfoPanel.add(tfUtsPonSysLogicalPortStrictBinging);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysOltMACAgingTime));
        tfUtsPonSysOltMACAgingTime.setName(fStringMap.getString("utsPonSysOltMACAgingTime"));
        baseInfoPanel.add(tfUtsPonSysOltMACAgingTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysOlpMode));
        tfUtsPonSysOlpMode.setName(fStringMap.getString("utsPonSysOlpMode"));
        baseInfoPanel.add(tfUtsPonSysOlpMode);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(utsBBSVlanVPNTPID));
        tfUtsBBSVlanVPNTPID.setName(fStringMap.getString("utsBBSVlanVPNTPID"));
        baseInfoPanel.add(tfUtsBBSVlanVPNTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSVlanVPNPRISource));
        baseInfoPanel.add(tfUtsBBSVlanVPNPRISource);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMaxFrameSize));
        baseInfoPanel.add(tfUtsBBSMaxFrameSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtGratuitousArpLearning));
        tfUtsBBSMgmtGratuitousArpLearning.setName(fStringMap.getString("utsBBSMgmtGratuitousArpLearning"));
        baseInfoPanel.add(tfUtsBBSMgmtGratuitousArpLearning);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtIgmpProxySourceIP));
        tfUtsBBSMgmtIgmpProxySourceIP.setName(fStringMap.getString("utsBBSMgmtIgmpProxySourceIP"));
        baseInfoPanel.add(tfUtsBBSMgmtIgmpProxySourceIP);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtUplinkBandwidthThreshold));
        tfUtsBBSMgmtUplinkBandwidthThreshold.setName(fStringMap.getString("utsBBSMgmtUplinkBandwidthThreshold"));
        baseInfoPanel.add(tfUtsBBSMgmtUplinkBandwidthThreshold);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtUniBandwidthThreshold));
        tfUtsBBSMgmtUniBandwidthThreshold.setName(fStringMap.getString("utsBBSMgmtUniBandwidthThreshold"));
        baseInfoPanel.add(tfUtsBBSMgmtUniBandwidthThreshold);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(utsBBSMgmtIGMProxySourceInnerVLAN));
        tfUtsBBSMgmtIGMProxySourceInnerVLAN.setName(fStringMap.getString("utsBBSMgmtUplinkBandwidthThreshold"));
        baseInfoPanel.add(tfUtsBBSMgmtIGMProxySourceInnerVLAN);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtIGMProxySourceOuterVLAN));
        tfUtsBBSMgmtIGMProxySourceOuterVLAN.setName(fStringMap.getString("utsBBSMgmtUniBandwidthThreshold"));
        baseInfoPanel.add(tfUtsBBSMgmtIGMProxySourceOuterVLAN);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(utsBBSMgmtONUSNumberSwitch));
        tfUtsBBSMgmtONUSNumberSwitch.setName(fStringMap.getString("utsBBSMgmtONUSNumberSwitch"));
        baseInfoPanel.add(tfUtsBBSMgmtONUSNumberSwitch);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("General_Configuration")));
        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
        tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValueScope(0, 100);
        tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValueScope(0, 100);
        tfUtsBBSSysMemoryUtilityAlarmThreshold.setValueScope(0, 1000);
        tfUtsBBSSysARPAgingTime.setValueScope(30, 65535);
        tfUtsBBSSysMACAgingTime.setValueScope(0, 65535);
        /*
        tfUtsBBSOnuByteErrorWindow.setValueScope(1, 20);
        tfUtsBBSOnuByteErrorThresholdMin.setValueScope(1, 300);
        tfUtsPonSysOltMACAgingTime.setValueScope(10, 65535);
        tfUtsBBSVlanVPNTPID.setValueScope(1, 65535);
        */
        tfUtsBBSVlanVPNTPID.setEnabled(false);
        tfUtsBBSVlanVPNPRISource.setEnabled(false);
        tfUtsBBSSysSoftwareRateLimiting.setEnabled(false);
        tfUtsBBSMaxFrameSize.setValueScope(64, 16368);
        tfUtsBBSMgmtUplinkBandwidthThreshold.setValueScope(0, 100);
        tfUtsBBSMgmtUniBandwidthThreshold.setValueScope(0, 100);
        /*
        tfUtsBBSMgmtIGMProxySourceInnerVLAN.setValueScope(0, 4094);
        tfUtsBBSMgmtIGMProxySourceOuterVLAN.setValueScope(0, 4094);
        */
    }

    public boolean validateFrom() {
        // OLT MAC Aging time
        int sysMacAgingTime = tfUtsBBSSysMACAgingTime.getValue();
        if (sysMacAgingTime != 0 && !(sysMacAgingTime >= 10 && sysMacAgingTime <= 65535)) {
            String error = fStringMap.getString("Err_MAC_Aging_Time_Is_Invalid");
            MessageDialog.showInfoMessageDialog(fApplication, error);
            return false;
        }

        return true;
    }

    public void refresh() {
        GeneralConfiguration mbean = (GeneralConfiguration) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfUtsBBSBPDUTermination.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSBPDUTermination()));

        /*
        // Only when all utsEponDot1qVlanStpBridgeEnable = 2: disable(2)
        // Can set utsBBSBPDUTermination to 1: enable(1)
        try {
            tfUtsBBSBPDUTermination.setEnabled(true);
            PortBasedVLAN portVLanMBean = new PortBasedVLAN(fApplication.getSnmpProxy());
            Vector vLanVec = portVLanMBean.retrieveAll();
            for (int i = 0; i < vLanVec.size(); i++) {
                PortBasedVLAN tmpPortVLan = (PortBasedVLAN) vLanVec.elementAt(i);
                int tmpVlanStpBridge = tmpPortVLan.getUtsEponDot1qVlanStpBridgeEnable().intValue();
                if (tmpVlanStpBridge != 2) {
                    tfUtsBBSBPDUTermination.setEnabled(false);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        */

        tfUtsBBSSysSoftwareRateLimiting.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSSysSoftwareRateLimiting()));
        //tfUtsBBSSysHardwareRateLimiting.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSSysHardwareRateLimiting()));

        tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValue(mbean.getUtsBBSSysCpuUtilityAlarmThresholdTotal());
        tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValue(mbean.getUtsBBSSysCpuUtilityAlarmThresholdPerTask());
        tfUtsBBSSysMemoryUtilityAlarmThreshold.setValue(mbean.getUtsBBSSysMemoryUtilityAlarmThreshold());
        tfUtsBBSSysARPAgingTime.setValue(mbean.getUtsBBSSysARPAgingTime());
        tfUtsBBSSysMACAgingTime.setValue(mbean.getUtsBBSSysMACAgingTime());
        /*
        tfUtsPonSysLogicalPortStrictBinging.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsPonSysLogicalPortStrictBinging()));
        tfUtsPonSysOltMACAgingTime.setValue(mbean.getUtsPonSysOltMACAgingTime());
        tfUtsPonSysOlpMode.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsPonSysOlpMode()));
        tfUtsBBSOnuByteErrorWindow.setValue(mbean.getUtsBBSOnuByteErrorWindow());
        tfUtsBBSOnuByteErrorThresholdMin.setValue(mbean.getUtsBBSOnuByteErrorThresholdMin());
        */
        tfUtsBBSVlanVPNTPID.setValue(Integer.toHexString(mbean.getUtsBBSVlanVPNTPID()));
        tfUtsBBSVlanVPNPRISource.setSelectedIndex(getIndexFromValue(utsBBSVlanVPNPRISourceVList, mbean.getUtsBBSVlanVPNPRISource()));
        tfUtsBBSMaxFrameSize.setValue(mbean.getUtsBBSMaxFrameSize());
        tfUtsBBSMgmtGratuitousArpLearning.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSMgmtGratuitousArpLearning()));
        tfUtsBBSMgmtIgmpProxySourceIP.setValue(mbean.getUtsBBSMgmtIgmpProxySourceIP());

        if (mbean.getUtsBBSMgmtUplinkBandwidthThreshold() != null)
            tfUtsBBSMgmtUplinkBandwidthThreshold.setValue(mbean.getUtsBBSMgmtUplinkBandwidthThreshold() / 10);

        if (mbean.getUtsBBSMgmtUniBandwidthThreshold() != null)
            tfUtsBBSMgmtUniBandwidthThreshold.setValue(mbean.getUtsBBSMgmtUniBandwidthThreshold() / 10);

        /*
        if (mbean.getUtsBBSMgmtIGMProxySourceInnerVLAN() != null)
            tfUtsBBSMgmtIGMProxySourceInnerVLAN.setValue(mbean.getUtsBBSMgmtIGMProxySourceInnerVLAN());

        if (mbean.getUtsBBSMgmtIGMProxySourceOuterVLAN() != null)
            tfUtsBBSMgmtIGMProxySourceOuterVLAN.setValue(mbean.getUtsBBSMgmtIGMProxySourceOuterVLAN());
        */

        tfUtsBBSMgmtONUSNumberSwitch.setSelectedIndex(getIndexFromValue(utsBBSMgmtONUSNumberSwitchVList, mbean.getUtsBBSMgmtONUSNumberSwitch() != null ? mbean.getUtsBBSMgmtONUSNumberSwitch() : 1));
    }

    public void updateModel() {
        GeneralConfiguration mbean = (GeneralConfiguration) getModel();
        if (mbean == null)
            return;

        mbean.setUtsBBSBPDUTermination(vList[tfUtsBBSBPDUTermination.getSelectedIndex()]);
        mbean.setUtsBBSSysSoftwareRateLimiting(vList[tfUtsBBSSysSoftwareRateLimiting.getSelectedIndex()]);
        //mbean.setUtsBBSSysHardwareRateLimiting(vList[tfUtsBBSSysHardwareRateLimiting.getSelectedIndex()]);
        mbean.setUtsBBSSysCpuUtilityAlarmThresholdTotal(tfUtsBBSSysCpuUtilityAlarmThresholdTotal.getValue());
        mbean.setUtsBBSSysCpuUtilityAlarmThresholdPerTask(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.getValue());
        mbean.setUtsBBSSysMemoryUtilityAlarmThreshold(tfUtsBBSSysMemoryUtilityAlarmThreshold.getValue());
        mbean.setUtsBBSSysARPAgingTime(tfUtsBBSSysARPAgingTime.getValue());
        mbean.setUtsBBSSysMACAgingTime(tfUtsBBSSysMACAgingTime.getValue());
        /*
        mbean.setUtsPonSysLogicalPortStrictBinging(vList[tfUtsPonSysLogicalPortStrictBinging.getSelectedIndex()]);
        mbean.setUtsPonSysOltMACAgingTime(tfUtsPonSysOltMACAgingTime.getValue());
        mbean.setUtsBBSOnuByteErrorWindow(tfUtsBBSOnuByteErrorWindow.getValue());
        mbean.setUtsBBSOnuByteErrorThresholdMin(tfUtsBBSOnuByteErrorThresholdMin.getValue());
        mbean.setUtsPonSysOlpMode(vList[tfUtsPonSysOlpMode.getSelectedIndex()]);
        */
        mbean.setUtsBBSVlanVPNTPID(Integer.valueOf(tfUtsBBSVlanVPNTPID.getValue(), 16));
        mbean.setUtsBBSMaxFrameSize(tfUtsBBSMaxFrameSize.getValue());
        mbean.setUtsBBSMgmtGratuitousArpLearning(vList[tfUtsBBSMgmtGratuitousArpLearning.getSelectedIndex()]);
        mbean.setUtsBBSMgmtIgmpProxySourceIP(tfUtsBBSMgmtIgmpProxySourceIP.getIPString());
        mbean.setUtsBBSMgmtUplinkBandwidthThreshold(tfUtsBBSMgmtUplinkBandwidthThreshold.getValue() * 10);
        mbean.setUtsBBSMgmtUniBandwidthThreshold(tfUtsBBSMgmtUniBandwidthThreshold.getValue() * 10);
        /*
        mbean.setUtsBBSMgmtIGMProxySourceInnerVLAN(tfUtsBBSMgmtIGMProxySourceInnerVLAN.getValue());
        mbean.setUtsBBSMgmtIGMProxySourceOuterVLAN(tfUtsBBSMgmtIGMProxySourceOuterVLAN.getValue());
        */
        mbean.setUtsBBSMgmtONUSNumberSwitch(utsBBSMgmtONUSNumberSwitchVList[tfUtsBBSMgmtONUSNumberSwitch.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}