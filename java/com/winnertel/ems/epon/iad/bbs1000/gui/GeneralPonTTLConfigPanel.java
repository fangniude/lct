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
import com.winnertel.ems.epon.iad.bbs1000.mib.GeneralPonTTLConfig;

import javax.swing.*;
import java.awt.*;

//modified by Zhou Chao, 2008/12/10
public class GeneralPonTTLConfigPanel extends UPanel {

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

    //private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdTotal = new IntegerTextField();
    //private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdPerTask = new IntegerTextField();
    //private IntegerTextField tfUtsBBSSysMemoryUtilityAlarmThreshold = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysARPAgingTime = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysMACAgingTime = new IntegerTextField();

    private final String utsBBSBPDUTermination = fStringMap.getString("utsBBSBPDUTermination") + ": ";
    private final String utsBBSSysSoftwareRateLimiting = fStringMap.getString("utsBBSSysSoftwareRateLimiting") + ": ";
    //private final String utsBBSSysCpuUtilityAlarmThresholdTotal = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal") + ": ";
    //private final String utsBBSSysCpuUtilityAlarmThresholdPerTask = fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask") + ": ";
    //private final String utsBBSSysMemoryUtilityAlarmThreshold = fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold") + ": ";
    private final String utsBBSSysARPAgingTime = fStringMap.getString("utsBBSSysARPAgingTime") + ": ";
    private final String utsBBSSysMACAgingTime = fStringMap.getString("utsBBSSysMACAgingTime") + ": ";

    private int[] ponSystemGroupVList = new int[]{2, 1,};
    private String[] ponSystemGroupTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfutsPonSysLocalAuthentication = new JComboBox(ponSystemGroupTList);
    private JComboBox tfutsPonSysLogicalPortStrictBinging = new JComboBox(ponSystemGroupTList);

    private IntegerTextField tfutsPonSysOltMACAgingTime = new IntegerTextField();
    private IntegerTextField tfutsPonSysOnuAuthTimeOut = new IntegerTextField();
    private StringTextField tfutsPonSysDot1adTPID = new StringTextField();

    private final String utsPonSysLocalAuthentication = fStringMap.getString("utsPonSysLocalAuthentication") + ": ";
    private final String utsPonSysLogicalPortStrictBinging = fStringMap.getString("utsPonSysLogicalPortStrictBinging") + ": ";
    private final String utsPonSysOltMACAgingTime = fStringMap.getString("utsPonSysOltMACAgingTime") + ": ";
    private final String utsPonSysOnuAuthTimeOut = fStringMap.getString("utsPonSysOnuAuthTimeOut") + ": ";
    private final String utsPonSysDot1adTPID = fStringMap.getString("utsPonSysDot1adTPID") + ": ";

    private IntegerTextField tfUtsBBSMgmtTrafficTTL = new IntegerTextField();

    private final String utsBBSMgmtTrafficTTL = fStringMap.getString("utsBBSMgmtTrafficTTL") + ": ";

    private int oldLogicalPortStrictBinging = 0; //added by Zhou Chao, 2009/1/6

    public GeneralPonTTLConfigPanel(IApplication app) {
        super(app);
        setModel(new GeneralPonTTLConfig(app.getSnmpProxy()));
        init();
    }

    protected void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_GeneralGPonTTLConfig");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel generalPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        generalPanel.setLayout(layout);
        generalPanel.setBorder(BorderFactory.createEtchedBorder());

        generalPanel.add(new JLabel(utsBBSBPDUTermination));
        tfUtsBBSBPDUTermination.setName(fStringMap.getString("utsBBSBPDUTermination"));
        generalPanel.add(tfUtsBBSBPDUTermination);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysSoftwareRateLimiting));
        tfUtsBBSSysSoftwareRateLimiting.setName(fStringMap.getString("utsBBSSysSoftwareRateLimiting"));
        generalPanel.add(tfUtsBBSSysSoftwareRateLimiting);
        generalPanel.add(new HSpacer());

        /*
        generalPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdTotal));
        tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdTotal"));
        generalPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdTotal);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdPerTask));
        tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setName(fStringMap.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask"));
        generalPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysMemoryUtilityAlarmThreshold));
        tfUtsBBSSysMemoryUtilityAlarmThreshold.setName(fStringMap.getString("utsBBSSysMemoryUtilityAlarmThreshold"));
        generalPanel.add(tfUtsBBSSysMemoryUtilityAlarmThreshold);
        generalPanel.add(new HSpacer());
        */

        generalPanel.add(new JLabel(utsBBSSysARPAgingTime));
        tfUtsBBSSysARPAgingTime.setName(fStringMap.getString("utsBBSSysARPAgingTime"));
        generalPanel.add(tfUtsBBSSysARPAgingTime);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysMACAgingTime));
        tfUtsBBSSysMACAgingTime.setName(fStringMap.getString("utsBBSSysMACAgingTime"));
        generalPanel.add(tfUtsBBSSysMACAgingTime);
        generalPanel.add(new HSpacer());

        generalPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("General_Configuration")));

        JPanel ponPanel = new JPanel();
        layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ponPanel.setLayout(layout);
        ponPanel.setBorder(BorderFactory.createEtchedBorder());

        ponPanel.add(new JLabel(utsPonSysLocalAuthentication));
        ponPanel.add(tfutsPonSysLocalAuthentication);
        ponPanel.add(new HSpacer());

        ponPanel.add(new JLabel(utsPonSysLogicalPortStrictBinging));
        ponPanel.add(tfutsPonSysLogicalPortStrictBinging);
        ponPanel.add(new HSpacer());

        ponPanel.add(new JLabel(utsPonSysOltMACAgingTime));
        ponPanel.add(tfutsPonSysOltMACAgingTime);
        ponPanel.add(new HSpacer());

        ponPanel.add(new JLabel(utsPonSysOnuAuthTimeOut));
        ponPanel.add(tfutsPonSysOnuAuthTimeOut);
        ponPanel.add(new HSpacer());

        ponPanel.add(new JLabel(utsPonSysDot1adTPID));
        tfutsPonSysDot1adTPID.setName(fStringMap.getString("utsPonSysDot1adTPID"));
        ponPanel.add(tfutsPonSysDot1adTPID);
        ponPanel.add(new HSpacer());

        ponPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("PonSystemGroup_Panel")));

        JPanel ttlPanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ttlPanel.setLayout(layout);
        ttlPanel.setBorder(BorderFactory.createEtchedBorder());

        ttlPanel.add(new JLabel(utsBBSMgmtTrafficTTL));
        tfUtsBBSMgmtTrafficTTL.setName(fStringMap.getString("utsBBSMgmtTrafficTTL"));
        ttlPanel.add(tfUtsBBSMgmtTrafficTTL);
        ttlPanel.add(new HSpacer());
        ttlPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("InBand_OutBand_TTL")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(generalPanel);
        allPanel.add(ponPanel);
        allPanel.add(ttlPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
        //tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValueScope(0, 100);
        //tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValueScope(0, 100);
        //tfUtsBBSSysMemoryUtilityAlarmThreshold.setValueScope(0, 1000);
        tfUtsBBSSysARPAgingTime.setValueScope(30, 65535);
        tfUtsBBSSysMACAgingTime.setValueScope(0, 65535);
        tfUtsBBSSysSoftwareRateLimiting.setEnabled(false);

        tfutsPonSysOltMACAgingTime.setValueScope(0, 2400);
        tfutsPonSysOnuAuthTimeOut.setValueScope(1, 6000);
    }

    public boolean validateFrom() {
        int sysMacAgingTime = tfUtsBBSSysMACAgingTime.getValue();
        if (sysMacAgingTime != 0 && !(sysMacAgingTime >= 10 && sysMacAgingTime <= 65535)) {
            String error = fStringMap.getString("Err_MAC_Aging_Time_Is_Invalid");
            MessageDialog.showInfoMessageDialog(fApplication, error);
            return false;
        }
        try {
            Integer theValue = Integer.valueOf(tfutsPonSysDot1adTPID.getText(), 16);
            if (theValue < 0 || theValue > 65535) {
                MessageDialog.showInfoMessageDialog(fApplication, utsPonSysDot1adTPID + fStringMap.getString("Err_hex"));
                return false;
            }
        } catch (Exception e) {
            MessageDialog.showInfoMessageDialog(fApplication, utsPonSysDot1adTPID + fStringMap.getString("Err_hex"));
            return false;
        }

        return true;
    }

    public void refresh() {
        GeneralPonTTLConfig mbean = (GeneralPonTTLConfig) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfUtsBBSBPDUTermination.setSelectedIndex(getIndexFromValue(utsBBSBPDUTerminationVList, mbean.getUtsBBSBPDUTermination()));
        tfUtsBBSSysSoftwareRateLimiting.setSelectedIndex(getIndexFromValue(utsBBSSysSoftwareRateLimitingVList, mbean.getUtsBBSSysSoftwareRateLimiting()));
        tfUtsBBSSysARPAgingTime.setValue(mbean.getUtsBBSSysARPAgingTime());
        tfUtsBBSSysMACAgingTime.setValue(mbean.getUtsBBSSysMACAgingTime());

        tfutsPonSysLocalAuthentication.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysLocalAuthentication()));
        tfutsPonSysLogicalPortStrictBinging.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysLogicalPortStrictBinging()));
        oldLogicalPortStrictBinging = mbean.getUtsPonSysLogicalPortStrictBinging();
        tfutsPonSysOltMACAgingTime.setValue(mbean.getUtsPonSysOltMACAgingTime());
        tfutsPonSysOnuAuthTimeOut.setValue(mbean.getUtsPonSysOnuAuthTimeOut());
        tfutsPonSysDot1adTPID.setValue(Integer.toHexString(mbean.getUtsPonSysDot1adTPID()));
        tfUtsBBSMgmtTrafficTTL.setValue(mbean.getUtsBBSMgmtTrafficTTL());
    }

    public void updateModel() {
        GeneralPonTTLConfig mbean = (GeneralPonTTLConfig) getModel();
        if (mbean == null)
            return;

        mbean.setUtsBBSBPDUTermination(utsBBSBPDUTerminationVList[tfUtsBBSBPDUTermination.getSelectedIndex()]);
        mbean.setUtsBBSSysSoftwareRateLimiting(utsBBSSysSoftwareRateLimitingVList[tfUtsBBSSysSoftwareRateLimiting.getSelectedIndex()]);
        mbean.setUtsBBSSysARPAgingTime(tfUtsBBSSysARPAgingTime.getValue());
        mbean.setUtsBBSSysMACAgingTime(tfUtsBBSSysMACAgingTime.getValue());

        mbean.setUtsPonSysLocalAuthentication(ponSystemGroupVList[tfutsPonSysLocalAuthentication.getSelectedIndex()]);
        int newLogicalPortStrictBinging = ponSystemGroupVList[tfutsPonSysLogicalPortStrictBinging.getSelectedIndex()];
        if (oldLogicalPortStrictBinging != newLogicalPortStrictBinging) {
            mbean.setUtsPonSysLogicalPortStrictBinging(newLogicalPortStrictBinging);
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Info_Take_Effect_After_OLT_Port_Reset"));
        }
        mbean.setUtsPonSysOltMACAgingTime(tfutsPonSysOltMACAgingTime.getValue());
        mbean.setUtsPonSysOnuAuthTimeOut(tfutsPonSysOnuAuthTimeOut.getValue());
        mbean.setUtsPonSysDot1adTPID(Integer.valueOf(tfutsPonSysDot1adTPID.getValue(), 16));
        mbean.setUtsBBSMgmtTrafficTTL(tfUtsBBSMgmtTrafficTTL.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}