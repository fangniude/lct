package com.winnertel.ems.epon.iad.bbs4000.gui.r220.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PonSystemGroup;
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

import javax.swing.*;
import java.awt.*;

public class PonSystemGroupPanel extends UPanel {

    //private IntegerTextField tfutsPonSysVlanIdBase = new IntegerTextField();

    private int[] ponSystemGroupVList = new int[]{2, 1,};
    private String[] ponSystemGroupTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsPonSysLocalAuthentication = new JComboBox(ponSystemGroupTList);

    private JComboBox tfUtsPonSysLogicalPortStrictBinging = new JComboBox(ponSystemGroupTList);

    private int[] utsBBSMgmtOnuDisplayPolicyVList = new int[]{1, 2,};
    private String[] utsBBSMgmtOnuDisplayPolicyTList = new String[]{
            fStringMap.getString("onlineonly"),
            fStringMap.getString("allonu"),
    };
    private JComboBox tfUtsBBSMgmtOnuDisplayPolicy = new JComboBox(utsBBSMgmtOnuDisplayPolicyTList);

    //private JComboBox tfutsPonSysSlaSynchronization = new JComboBox(ponSystemGroupTList);

    private IntegerTextField tfUtsPonSysOltMACAgingTime = new IntegerTextField();
    private IntegerTextField tfUtsPonSysOnuAuthTimeOut = new IntegerTextField();

    //private JComboBox tfutsPonSysOlpMode = new JComboBox(ponSystemGroupTList);

    private StringTextField tfUtsPonSysDot1adTPID = new StringTextField();

    //private IntegerTextField tfUtsPonSysReceiveSensitivityMax = new IntegerTextField();
    //private IntegerTextField tfUtsPonSysOverloadOpticalPower = new IntegerTextField();

//    private int[] utsBBSMgmtONUSNumberSwitchVList = new int[]{1, 2,};
//    private String[] utsBBSMgmtONUSNumberSwitchTList = new String[]{
//            fStringMap.getString("disabled"),
//            fStringMap.getString("enabled"),
//    };
//    private JComboBox tfUtsBBSMgmtONUSNumberSwitch = new JComboBox(utsBBSMgmtONUSNumberSwitchTList);


    //private final String utsPonSysVlanIdBase = fStringMap.getString("utsPonSysVlanIdBase") + ": ";
    private final String utsPonSysLocalAuthentication = fStringMap.getString("utsPonSysLocalAuthentication") + ": ";
    private final String utsPonSysLogicalPortStrictBinging = fStringMap.getString("utsPonSysLogicalPortStrictBinging") + ": ";
    private final String utsBBSMgmtOnuDisplayPolicy = fStringMap.getString("utsBBSMgmtOnuDisplayPolicy") + ": ";
    //private final String utsPonSysSlaSynchronization = fStringMap.getString("utsPonSysSlaSynchronization") + ": ";
    private final String utsPonSysOltMACAgingTime = fStringMap.getString("utsPonSysOltMACAgingTime") + ": ";
    private final String utsPonSysOnuAuthTimeOut = fStringMap.getString("utsPonSysOnuAuthTimeOut") + ": ";
    private final String utsBBSMgmtONUSNumberSwitch = fStringMap.getString("utsBBSMgmtONUSNumberSwitch") + ": ";
    //private final String utsPonSysOlpMode = fStringMap.getString("utsPonSysOlpMode") + ": ";
    private final String utsPonSysDot1adTPID = fStringMap.getString("utsPonSysDot1adTPID") + ": ";
    //private final String utsPonSysReceiveSensitivityMax = fStringMap.getString("utsPonSysReceiveSensitivityMax") + ": ";
    //private final String utsPonSysOverloadOpticalPower = fStringMap.getString("utsPonSysOverloadOpticalPower") + ": ";
    private boolean isONUSNumberSwitchChanged = false;
    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    private int oldLogicalPortStrictBinging = 0; //added by Zhou Chao, 2009/1/15

    public PonSystemGroupPanel(IApplication app) {
        super(app);
        setModel(new PonSystemGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_PonSystemGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        //baseInfoPanel.add(new JLabel(fStringMap.getString(utsPonSysVlanIdBase)));
        //baseInfoPanel.add(tfutsPonSysVlanIdBase);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysLocalAuthentication));
        baseInfoPanel.add(tfUtsPonSysLocalAuthentication);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysLogicalPortStrictBinging));
        baseInfoPanel.add(tfUtsPonSysLogicalPortStrictBinging);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBBSMgmtOnuDisplayPolicy));
        baseInfoPanel.add(tfUtsBBSMgmtOnuDisplayPolicy);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(fStringMap.getString(utsPonSysSlaSynchronization)));
        //baseInfoPanel.add(tfutsPonSysSlaSynchronization);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysOltMACAgingTime));
        baseInfoPanel.add(tfUtsPonSysOltMACAgingTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysOnuAuthTimeOut));
        baseInfoPanel.add(tfUtsPonSysOnuAuthTimeOut);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsBBSMgmtONUSNumberSwitch));
//        tfUtsBBSMgmtONUSNumberSwitch.setName(fStringMap.getString("utsBBSMgmtONUSNumberSwitch"));
//        baseInfoPanel.add(tfUtsBBSMgmtONUSNumberSwitch);
//        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsPonSysOlpMode));
        //baseInfoPanel.add(tfutsPonSysOlpMode);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonSysDot1adTPID));
        baseInfoPanel.add(tfUtsPonSysDot1adTPID);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsPonSysReceiveSensitivityMax));
        //baseInfoPanel.add(tfUtsPonSysReceiveSensitivityMax);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsPonSysOverloadOpticalPower));
        //baseInfoPanel.add(tfUtsPonSysOverloadOpticalPower);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("PonSystemGroup_Panel")));
        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.SOUTH);
        add(allPanel, BorderLayout.CENTER);
    }

    public boolean validateFrom() {
        try {
            Integer theValue = Integer.valueOf(tfUtsPonSysDot1adTPID.getText(), 16);
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

    protected void initForm() {
        //tfutsPonSysVlanIdBase.setValueScope(2, 1005);
        tfUtsPonSysOltMACAgingTime.setValueScope(0, 2400);
        tfUtsPonSysOnuAuthTimeOut.setValueScope(1, 6000);
        //tfUtsPonSysDot1adTPID.setValueScope(1, 65535);
        //tfUtsPonSysReceiveSensitivityMax.setValueScope(-50, 0);
        //tfUtsPonSysOverloadOpticalPower.setValueScope(-50, 0);
    }

    public void refresh() {
        PonSystemGroup mbean = (PonSystemGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        //tfutsPonSysVlanIdBase.setValue(mbean.getUtsPonSysVlanIdBase());
        tfUtsPonSysLocalAuthentication.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysLocalAuthentication()));
        tfUtsPonSysLogicalPortStrictBinging.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysLogicalPortStrictBinging()));
        oldLogicalPortStrictBinging = mbean.getUtsPonSysLogicalPortStrictBinging();
        tfUtsBBSMgmtOnuDisplayPolicy.setSelectedIndex(getIndexFromValue(utsBBSMgmtOnuDisplayPolicyVList, mbean.getUtsBBSMgmtOnuDisplayPolicy()));
        //tfutsPonSysSlaSynchronization.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysSlaSynchronization()));
        tfUtsPonSysOltMACAgingTime.setValue(mbean.getUtsPonSysOltMACAgingTime());
        tfUtsPonSysOnuAuthTimeOut.setValue(mbean.getUtsPonSysOnuAuthTimeOut());
        //tfutsPonSysOlpMode.setSelectedIndex(getIndexFromValue(ponSystemGroupVList, mbean.getUtsPonSysOlpMode()));
//        tfUtsBBSMgmtONUSNumberSwitch.setSelectedIndex(getIndexFromValue(utsBBSMgmtONUSNumberSwitchVList, mbean.getUtsBBSMgmtONUSNumberSwitch() != null ? mbean.getUtsBBSMgmtONUSNumberSwitch() : 1));
        tfUtsPonSysDot1adTPID.setValue(Integer.toHexString(mbean.getUtsPonSysDot1adTPID()));
        //tfUtsPonSysReceiveSensitivityMax.setValue(mbean.getUtsPonSysReceiveSensitivityMax());
        //tfUtsPonSysOverloadOpticalPower.setValue(mbean.getUtsPonSysOverloadOpticalPower());
    }

    public void updateModel() {
        PonSystemGroup mbean = (PonSystemGroup) getModel();
        if (mbean == null)
            return;
//        if((utsBBSMgmtONUSNumberSwitchVList[tfUtsBBSMgmtONUSNumberSwitch.getSelectedIndex()]!=mbean.getUtsBBSMgmtONUSNumberSwitch().intValue())
//                ||ponSystemGroupVList[tfUtsPonSysLocalAuthentication.getSelectedIndex()]!=mbean.getUtsPonSysLocalAuthentication().intValue())
//            isONUSNumberSwitchChanged = true;
//        else isONUSNumberSwitchChanged = false;
        //mbean.setUtsPonSysVlanIdBase(tfutsPonSysVlanIdBase.getValue());
        mbean.setUtsPonSysLocalAuthentication(ponSystemGroupVList[tfUtsPonSysLocalAuthentication.getSelectedIndex()]);
        int newLogicalPortStrictBinging = ponSystemGroupVList[tfUtsPonSysLogicalPortStrictBinging.getSelectedIndex()];
        if (oldLogicalPortStrictBinging != newLogicalPortStrictBinging) {
            mbean.setUtsPonSysLogicalPortStrictBinging(newLogicalPortStrictBinging);
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Info_Take_Effect_After_OLT_Port_Reset"));
        }
        mbean.setUtsBBSMgmtOnuDisplayPolicy(utsBBSMgmtOnuDisplayPolicyVList[tfUtsBBSMgmtOnuDisplayPolicy.getSelectedIndex()]);
        //mbean.setUtsPonSysSlaSynchronization(ponSystemGroupVList[tfutsPonSysSlaSynchronization.getSelectedIndex()]);
        mbean.setUtsPonSysOltMACAgingTime(tfUtsPonSysOltMACAgingTime.getValue());
        mbean.setUtsPonSysOnuAuthTimeOut(tfUtsPonSysOnuAuthTimeOut.getValue());
        //mbean.setUtsPonSysOlpMode(ponSystemGroupVList[tfutsPonSysOlpMode.getSelectedIndex()]);
//        mbean.setUtsBBSMgmtONUSNumberSwitch(utsBBSMgmtONUSNumberSwitchVList[tfUtsBBSMgmtONUSNumberSwitch.getSelectedIndex()]);
        mbean.setUtsPonSysDot1adTPID(Integer.valueOf(tfUtsPonSysDot1adTPID.getText(), 16));
        //mbean.setUtsPonSysReceiveSensitivityMax(tfUtsPonSysReceiveSensitivityMax.getValue());
        //mbean.setUtsPonSysOverloadOpticalPower(tfUtsPonSysOverloadOpticalPower.getValue());
    }
    
//    public void afterUpdateModel() {
//        if(isONUSNumberSwitchChanged)
//         MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Info_Take_Effect_After_Register"));
//    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}