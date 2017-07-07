package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.GeneralConfiguration;

import javax.swing.*;
import java.awt.*;

//modified by Zhou Chao, 2008/12/9
public class GeneralConfigurationPanel extends UPanel {

    private int[] utsBBSBPDUTerminationVList = new int[]{2, 1,};
    private String[] utsBBSBPDUTerminationTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsBBSBPDUTermination = new JComboBox(utsBBSBPDUTerminationTList);

    private int[] utsBBSSysSoftwareRateLimitingVList = new int[]{2, 1,};
    private String[] utsBBSSysSoftwareRateLimitingTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsBBSSysSoftwareRateLimiting = new JComboBox(utsBBSSysSoftwareRateLimitingTList);

    /*
    private int[] utsBBSSysHardwareRateLimitingVList = new int[]{2, 1,};
    private String[] utsBBSSysHardwareRateLimitingTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsBBSSysHardwareRateLimiting = new JComboBox(utsBBSSysHardwareRateLimitingTList);
    */

    private IntegerTextField tfUtsBBSSysARPAgingTime = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysMACAgingTime = new IntegerTextField();

    /*
    private IntegerTextField tfUtsBBSOnuByteErrorWindow = new IntegerTextField();
    private IntegerTextField tfUtsBBSOnuByteErrorThresholdMin = new IntegerTextField();
    private IntegerTextField tfUtsPonSysOltMACAgingTime = new IntegerTextField();

    private int[] utsPonSysOlpModeVList = new int[]{2, 1,};
    private String[] utsPonSysOlpModeTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsPonSysOlpMode = new JComboBox(utsPonSysOlpModeTList);
    */

    private StringTextField tfUtsPonSysDot1adTPID = new StringTextField();

    private final String utsBBSBPDUTermination = fStringMap.getString("utsBBSBPDUTermination") + ": ";
    private final String utsBBSSysSoftwareRateLimiting = fStringMap.getString("utsBBSSysSoftwareRateLimiting") + ": ";
    //private final String utsBBSSysHardwareRateLimiting = fStringMap.getString("utsBBSSysHardwareRateLimiting") + ": ";
    private final String utsBBSSysARPAgingTime = fStringMap.getString("utsBBSSysARPAgingTime") + ": ";
    private final String utsBBSSysMACAgingTime = fStringMap.getString("utsBBSSysMACAgingTime") + ": ";
    //private final String utsPonSysOltMACAgingTime = fStringMap.getString("utsPonSysOltMACAgingTime") + ": ";
    //private final String utsPonSysOlpMode = fStringMap.getString("utsPonSysOlpMode") + ": ";
    private final String utsPonSysDot1adTPID = fStringMap.getString("utsPonSysDot1adTPID") + ": ";

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
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsPonSysOltMACAgingTime));
        tfUtsPonSysOltMACAgingTime.setName(fStringMap.getString("utsPonSysOltMACAgingTime"));
        baseInfoPanel.add(tfUtsPonSysOltMACAgingTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysOlpMode));
        tfUtsPonSysOlpMode.setName(fStringMap.getString("utsPonSysOlpMode"));
        baseInfoPanel.add(tfUtsPonSysOlpMode);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(utsPonSysDot1adTPID));
        tfUtsPonSysDot1adTPID.setName(fStringMap.getString("utsPonSysDot1adTPID"));
        baseInfoPanel.add(tfUtsPonSysDot1adTPID);
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
        tfUtsBBSSysARPAgingTime.setValueScope(30, 65535);
        tfUtsBBSSysMACAgingTime.setValueScope(0, 65535);
        /*
        tfUtsBBSOnuByteErrorWindow.setValueScope(1, 20);
        tfUtsBBSOnuByteErrorThresholdMin.setValueScope(1, 300);
        tfUtsPonSysOltMACAgingTime.setValueScope(10, 65535);
        tfUtsPonSysDot1adTPID.setValueScope(1, 65535);
        */
        tfUtsPonSysDot1adTPID.setEnabled(false);
        tfUtsBBSSysSoftwareRateLimiting.setEnabled(false);
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

        tfUtsBBSBPDUTermination.setSelectedIndex(getIndexFromValue(utsBBSBPDUTerminationVList, mbean.getUtsBBSBPDUTermination()));

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

        tfUtsBBSSysSoftwareRateLimiting.setSelectedIndex(getIndexFromValue(utsBBSSysSoftwareRateLimitingVList, mbean.getUtsBBSSysSoftwareRateLimiting()));
        //tfUtsBBSSysHardwareRateLimiting.setSelectedIndex(getIndexFromValue(utsBBSSysHardwareRateLimitingVList, mbean.getUtsBBSSysHardwareRateLimiting()));
        tfUtsBBSSysARPAgingTime.setValue(mbean.getUtsBBSSysARPAgingTime());
        tfUtsBBSSysMACAgingTime.setValue(mbean.getUtsBBSSysMACAgingTime());
        /*
        tfUtsPonSysOltMACAgingTime.setValue(mbean.getUtsPonSysOltMACAgingTime());
        tfUtsPonSysOlpMode.setSelectedIndex(getIndexFromValue(utsPonSysOlpModeVList, mbean.getUtsPonSysOlpMode()));
        tfUtsBBSOnuByteErrorWindow.setValue(mbean.getUtsBBSOnuByteErrorWindow());
        tfUtsBBSOnuByteErrorThresholdMin.setValue(mbean.getUtsBBSOnuByteErrorThresholdMin());
        */
        tfUtsPonSysDot1adTPID.setValue(Integer.toHexString(mbean.getUtsPonSysDot1adTPID()));
    }

    public void updateModel() {
        GeneralConfiguration mbean = (GeneralConfiguration) getModel();
        if (mbean == null)
            return;

        mbean.setUtsBBSBPDUTermination(utsBBSBPDUTerminationVList[tfUtsBBSBPDUTermination.getSelectedIndex()]);
        mbean.setUtsBBSSysSoftwareRateLimiting(utsBBSSysSoftwareRateLimitingVList[tfUtsBBSSysSoftwareRateLimiting.getSelectedIndex()]);
        //mbean.setUtsBBSSysHardwareRateLimiting(utsBBSSysHardwareRateLimitingVList[tfUtsBBSSysHardwareRateLimiting.getSelectedIndex()]);
        mbean.setUtsBBSSysARPAgingTime(tfUtsBBSSysARPAgingTime.getValue());
        mbean.setUtsBBSSysMACAgingTime(tfUtsBBSSysMACAgingTime.getValue());
        /*
        mbean.setUtsPonSysOltMACAgingTime(tfUtsPonSysOltMACAgingTime.getValue());
        mbean.setUtsBBSOnuByteErrorWindow(tfUtsBBSOnuByteErrorWindow.getValue());
        mbean.setUtsBBSOnuByteErrorThresholdMin(tfUtsBBSOnuByteErrorThresholdMin.getValue());
        mbean.setUtsPonSysOlpMode(utsPonSysOlpModeVList[tfUtsPonSysOlpMode.getSelectedIndex()]);
        */
        if (tfUtsPonSysDot1adTPID.isEnabled()) {
            mbean.setUtsPonSysDot1adTPID(Integer.valueOf(tfUtsPonSysDot1adTPID.getValue(), 16));
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}