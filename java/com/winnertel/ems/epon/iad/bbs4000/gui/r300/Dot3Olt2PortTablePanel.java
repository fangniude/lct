/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Dot3Olt2PortTablePanel extends UPanel {

    private JLabel tfUtsDot3OltModuleId = new JLabel();
    //private JLabel tfUtsDot3OltDeviceId = new JLabel();
    private JLabel tfUtsDot3OltPortId = new JLabel();

    private int[] utsDot3OltAdminStatusVList = new int[]{1, 2,};
    private String[] utsDot3OltAdminStatusTList = new String[]{
            fStringMap.getString("up"),
            fStringMap.getString("down"),
    };
    private JComboBox tfUtsDot3OltAdminStatus = new JComboBox(utsDot3OltAdminStatusTList);

    /*
    private int[] utsDot3OltTxFECEnableVList = new int[]{1, 2,};
    private String[] utsDot3OltTxFECEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfUtsDot3OltTxFECEnable = new JComboBox(utsDot3OltTxFECEnableTList);

    private int[] utsDot3OltTransceiverTxVList = new int[]{1, 2,};
    private String[] utsDot3OltTransceiverTxTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox tfUtsDot3OltTransceiverTx = new JComboBox(utsDot3OltTransceiverTxTList);

    private int[] utsDot3OltTransceiverRxVList = new int[]{1, 2,};
    private String[] utsDot3OltTransceiverRxTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox tfUtsDot3OltTransceiverRx = new JComboBox(utsDot3OltTransceiverRxTList);

    private int[] utsDot3OltONUP2PEnableVList = new int[]{1, 2,};
    private String[] utsDot3OltONUP2PEnableTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfUtsDot3OltONUP2PEnable = new JComboBox(utsDot3OltONUP2PEnableTList);
    */

    private IntegerTextField tfUtsDot3OltMPCPGateBackoffTime = new IntegerTextField();

    private int[] utsDot3OltP2pEnableVList = new int[]{1, 2,};
    private String[] utsDot3OltP2pEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsDot3OltP2pEnable = new JComboBox(utsDot3OltP2pEnableTList);

    private int[] utsDot3OltOlpPortVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8,};
    private String[] utsDot3OltOlpPortTList = new String[]{
            fStringMap.getString("disable"),
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
    };
    private JComboBox tfUtsDot3OltOlpPort = new JComboBox(utsDot3OltOlpPortTList);

    /*
    private int[] utsDot3OltPortLoopbackDetectionVList = new int[]{1, 2,};
    private String[] utsDot3OltPortLoopbackDetectionTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3OltPortLoopbackDetection = new JComboBox(utsDot3OltPortLoopbackDetectionTList);

    private int[] utsDot3OltPortLoopbackDetectionControlVList = new int[]{1, 2,};
    private String[] utsDot3OltPortLoopbackDetectionControlTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3OltPortLoopbackDetectionControl = new JComboBox(utsDot3OltPortLoopbackDetectionControlTList);

    private JLabel tfUtsDot3OltPortTransmissionPower = new JLabel();
    private JLabel tfUtsDot3OltPortReceivingPower = new JLabel();
    private JLabel tfUtsDot3OltPortRealtimeMulticastTraffic = new JLabel();
    private JLabel tfUtsDot3OltPortSupplyVoltage = new JLabel();
    private JLabel tfUtsDot3OltPortCurrentBias = new JLabel();
    private JLabel tfUtsDot3OltPortCurrentTemperature = new JLabel();
    */

    private int[] utsDot3OltPortFlexQinQSwitchVList = new int[]{1, 2,}; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    private String[] utsDot3OltPortFlexQinQSwitchTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    }; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    private JComboBox tfUtsDot3OltPortFlexQinQSwitch = new JComboBox(utsDot3OltPortFlexQinQSwitchTList); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    private int[] utsDot3OltPortONUSNumberSwitchVList = new int[]{1,2};
    private String[] utsDot3OltPortONUSNumberSwitchTList = new String[]{fStringMap.getString("disable"),fStringMap.getString("enable")};
    private JComboBox tfUtsDot3OltPortONUSNumberSwitch = new JComboBox(utsDot3OltPortONUSNumberSwitchTList);

    private final String utsDot3OltModuleId = fStringMap.getString("utsDot3OltModuleId") + ": ";
    //private final String utsDot3OltDeviceId = fStringMap.getString("utsDot3OltDeviceId") + ": ";
    private final String utsDot3OltPortId = fStringMap.getString("utsDot3OltPortId") + ": ";
    private final String utsDot3OltAdminStatus = fStringMap.getString("utsDot3OltAdminStatus") + ": ";
    //private final String utsDot3OltTxFECEnable = fStringMap.getString("utsDot3OltTxFECEnable") + ": ";
    //private final String utsDot3OltTransceiverTx = fStringMap.getString("utsDot3OltTransceiverTx") + ": ";
    //private final String utsDot3OltTransceiverRx = fStringMap.getString("utsDot3OltTransceiverRx") + ": ";
    //private final String utsDot3OltONUP2PEnable = fStringMap.getString("utsDot3OltONUP2PEnable") + ": ";
    private final String utsDot3OltMPCPGateBackoffTime = fStringMap.getString("utsDot3OltMPCPGateBackoffTime") + ": ";
    private final String utsDot3OltP2pEnable = fStringMap.getString("utsDot3OltP2pEnable") + ": ";
    private final String utsDot3OltOlpPort = fStringMap.getString("utsDot3OltOlpPort") + ": ";
    //private final String utsDot3OltPortLoopbackDetection = fStringMap.getString("utsDot3OltPortLoopbackDetection") + ": ";
    //private final String utsDot3OltPortLoopbackDetectionControl = fStringMap.getString("utsDot3OltPortLoopbackDetectionControl") + ": ";
    //private final String utsDot3OltPortTransmissionPower = fStringMap.getString("utsDot3OltPortTransmissionPower") + ": ";
    //private final String utsDot3OltPortReceivingPower = fStringMap.getString("utsDot3OltPortReceivingPower") + ": ";
    //private final String utsDot3OltPortRealtimeMulticastTraffic = fStringMap.getString("utsDot3OltPortRealtimeMulticastTraffic") + ": ";
    //private final String utsDot3OltPortSupplyVoltage = fStringMap.getString("utsDot3OltPortSupplyVoltage") + ": ";
    //private final String utsDot3OltPortCurrentBias = fStringMap.getString("utsDot3OltPortCurrentBias") + ": ";
    //private final String utsDot3OltPortCurrentTemperature = fStringMap.getString("utsDot3OltPortCurrentTemperature") + ": ";
    private final String utsDot3OltPortFlexQinQSwitch = fStringMap.getString("utsDot3OltPortFlexQinQSwitch") + ": "; //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
    private final String utsDot3OltPortONUSNumberSwitch = fStringMap.getString("utsDot3OltPortONUSNumberSwitch") + ":";
    private boolean isONUSNumberSwitchChanged = false;
    public Dot3Olt2PortTablePanel(IApplication app) {
        super(app);
        setModel(new Dot3Olt2PortTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5); //modified by Zhou Chao, 2008/8/2
        layout.setMargins(7, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OltModuleId));
        baseInfoPanel.add(tfUtsDot3OltModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltDeviceId));
        //baseInfoPanel.add(tfUtsDot3OltDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltPortId));
        baseInfoPanel.add(tfUtsDot3OltPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltAdminStatus));
        tfUtsDot3OltAdminStatus.setName(fStringMap.getString("utsDot3OltAdminStatus"));
        baseInfoPanel.add(tfUtsDot3OltAdminStatus);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltTxFECEnable));
        //tfUtsDot3OltTxFECEnable.setName(fStringMap.getString("utsDot3OltTxFECEnable"));
        //baseInfoPanel.add(tfUtsDot3OltTxFECEnable);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltTransceiverTx));
        //tfUtsDot3OltTransceiverTx.setName(fStringMap.getString("utsDot3OltTransceiverTx"));
        //baseInfoPanel.add(tfUtsDot3OltTransceiverTx);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltTransceiverRx));
        //tfUtsDot3OltTransceiverRx.setName(fStringMap.getString("utsDot3OltTransceiverRx"));
        //baseInfoPanel.add(tfUtsDot3OltTransceiverRx);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltONUP2PEnable));
        //tfUtsDot3OltONUP2PEnable.setName(fStringMap.getString("utsDot3OltONUP2PEnable"));
        //baseInfoPanel.add(tfUtsDot3OltONUP2PEnable);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltMPCPGateBackoffTime));
        tfUtsDot3OltMPCPGateBackoffTime.setName(fStringMap.getString("utsDot3OltMPCPGateBackoffTime"));
        baseInfoPanel.add(tfUtsDot3OltMPCPGateBackoffTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltP2pEnable));
        tfUtsDot3OltP2pEnable.setName(utsDot3OltP2pEnable);
        baseInfoPanel.add(tfUtsDot3OltP2pEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltOlpPort));
        tfUtsDot3OltOlpPort.setName(utsDot3OltOlpPort);
        baseInfoPanel.add(tfUtsDot3OltOlpPort);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortLoopbackDetection));
        //tfUtsDot3OltPortLoopbackDetection.setName(utsDot3OltPortLoopbackDetection);
        //baseInfoPanel.add(tfUtsDot3OltPortLoopbackDetection);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortLoopbackDetectionControl));
        //tfUtsDot3OltPortLoopbackDetectionControl.setName(utsDot3OltPortLoopbackDetectionControl);
        //baseInfoPanel.add(tfUtsDot3OltPortLoopbackDetectionControl);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortTransmissionPower));
        //baseInfoPanel.add(tfUtsDot3OltPortTransmissionPower);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortReceivingPower));
        //baseInfoPanel.add(tfUtsDot3OltPortReceivingPower);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortRealtimeMulticastTraffic));
        //baseInfoPanel.add(tfUtsDot3OltPortRealtimeMulticastTraffic);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortSupplyVoltage));
        //baseInfoPanel.add(tfUtsDot3OltPortSupplyVoltage);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortCurrentBias));
        //baseInfoPanel.add(tfUtsDot3OltPortCurrentBias);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OltPortCurrentTemperature));
        //baseInfoPanel.add(tfUtsDot3OltPortCurrentTemperature);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OltPortFlexQinQSwitch)); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        tfUtsDot3OltPortFlexQinQSwitch.setName(utsDot3OltPortFlexQinQSwitch); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        baseInfoPanel.add(tfUtsDot3OltPortFlexQinQSwitch); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        baseInfoPanel.add(new HSpacer()); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)

        baseInfoPanel.add(new JLabel(utsDot3OltPortONUSNumberSwitch));
        tfUtsDot3OltPortONUSNumberSwitch.setName(utsDot3OltPortONUSNumberSwitch);
        baseInfoPanel.add(tfUtsDot3OltPortONUSNumberSwitch);
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
        tfUtsDot3OltMPCPGateBackoffTime.setValueScope(0, 31);
    }

    public void refresh() {
        Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();

        tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
        //tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
        tfUtsDot3OltPortId.setText(mbean.getUtsDot3OltPortId().toString());
        tfUtsDot3OltAdminStatus.setSelectedIndex(getIndexFromValue(utsDot3OltAdminStatusVList, mbean.getUtsDot3OltAdminState().intValue()));
        //tfUtsDot3OltTxFECEnable.setSelectedIndex(getIndexFromValue(utsDot3OltTxFECEnableVList, mbean.getUtsDot3OltTxFECEnable().intValue()));
        //tfUtsDot3OltTransceiverTx.setSelectedIndex(getIndexFromValue(utsDot3OltTransceiverTxVList, mbean.getUtsDot3OltTransceiverTx().intValue()));
        //tfUtsDot3OltTransceiverRx.setSelectedIndex(getIndexFromValue(utsDot3OltTransceiverRxVList, mbean.getUtsDot3OltTransceiverRx().intValue()));
        //tfUtsDot3OltONUP2PEnable.setSelectedIndex(getIndexFromValue(utsDot3OltONUP2PEnableVList, mbean.getUtsDot3OltONUP2PEnable().intValue()));
        tfUtsDot3OltMPCPGateBackoffTime.setValue(mbean.getUtsDot3OltMPCPGateBackoffTime().intValue());
        tfUtsDot3OltP2pEnable.setSelectedIndex(getIndexFromValue(utsDot3OltP2pEnableVList, mbean.getUtsDot3OltP2pEnable().intValue()));
        tfUtsDot3OltOlpPort.setSelectedIndex(getIndexFromValue(utsDot3OltOlpPortVList, mbean.getUtsDot3OltOlpPort().intValue()));
        //tfUtsDot3OltPortLoopbackDetection.setSelectedIndex(getIndexFromValue(utsDot3OltPortLoopbackDetectionVList, mbean.getUtsDot3OltPortLoopbackDetection().intValue()));
        //tfUtsDot3OltPortLoopbackDetectionControl.setSelectedIndex(getIndexFromValue(utsDot3OltPortLoopbackDetectionControlVList, mbean.getUtsDot3OltPortLoopbackDetectionControl().intValue()));
        //tfUtsDot3OltPortTransmissionPower.setText(mbean.getUtsDot3OltPortTransmissionPower().toString());
        //tfUtsDot3OltPortReceivingPower.setText(mbean.getUtsDot3OltPortReceivingPower().toString());
        //tfUtsDot3OltPortRealtimeMulticastTraffic.setText(mbean.getUtsDot3OltPortRealtimeMulticastTraffic().toString());
        //tfUtsDot3OltPortSupplyVoltage.setText(mbean.getUtsDot3OltPortSupplyVoltage().toString());
        //tfUtsDot3OltPortCurrentBias.setText(mbean.getUtsDot3OltPortCurrentBias().toString());
        //tfUtsDot3OltPortCurrentTemperature.setText(mbean.getUtsDot3OltPortCurrentTemperature().toString());
        tfUtsDot3OltPortFlexQinQSwitch.setSelectedIndex(getIndexFromValue(utsDot3OltPortFlexQinQSwitchVList, mbean.getUtsDot3OltPortFlexQinQSwitch().intValue())); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        tfUtsDot3OltPortONUSNumberSwitch.setSelectedIndex(getIndexFromValue(utsDot3OltPortONUSNumberSwitchVList, mbean.getUtsDot3OltPortONUSNumberSwitch().intValue()));
    }

    public boolean validateFrom() {
        Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();

        Dot3Olt2PortTable bean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
        bean.setUtsDot3OltModuleId(new Integer(mbean.getUtsDot3OltModuleId().intValue() - 1));
        bean.setUtsDot3OltDeviceId(new Integer(1));
        bean.setUtsDot3OltPortId(new Integer(4));

        Vector v = BeanService.refreshTableBean(fApplication, bean);
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                Dot3Olt2PortTable one = (Dot3Olt2PortTable) v.get(i);
                if ((!one.getUtsDot3OltPortId().equals(mbean.getUtsDot3OltPortId())) && one.getUtsDot3OltOlpPort().intValue() == utsDot3OltOlpPortVList[tfUtsDot3OltOlpPort.getSelectedIndex()] && one.getUtsDot3OltOlpPort().intValue() != 0) {
                    String error = fStringMap.getString("Err_Olp_Is_Used");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
        }

        return true;
    }

    public void updateModel() {
        Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();

        // if change Admin Status from Up(1) to Down(2), reset all ONUs under it.
        if (mbean.getUtsDot3OltAdminState().intValue() == 1 && utsDot3OltAdminStatusVList[tfUtsDot3OltAdminStatus.getSelectedIndex()] == 2) {
            try {
                Dot3Onu2CtcTable onuTblMBean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
                String thisOnuModuleId = mbean.getUtsDot3OltModuleId().toString();
                String thisOnuDeviceId = mbean.getUtsDot3OltDeviceId().toString();
                String thisOnuPortId = mbean.getUtsDot3OltPortId().toString();
                onuTblMBean.setIndex(0, mbean.getUtsDot3OltModuleId());
                onuTblMBean.setIndex(1, mbean.getUtsDot3OltDeviceId());
                onuTblMBean.setIndex(2, mbean.getUtsDot3OltPortId());
                onuTblMBean.setIndexPrefix(thisOnuModuleId + "." + thisOnuDeviceId + "." + thisOnuPortId);

                Vector onuTblAllValues = onuTblMBean.retrieveAll();
                for (int i = 0; i < onuTblAllValues.size(); i++) {
                    Dot3Onu2CtcTable tmpOnuTblMBean = (Dot3Onu2CtcTable) onuTblAllValues.get(i);

                    // only reset ONUs with register(1) state
                    // if register state is not 1: register(1), prompt error message.
                    if (tmpOnuTblMBean.getUtsDot3Onu2CtcRegisterStatus().intValue() != 1) {
                        continue;
                    }

                    tmpOnuTblMBean.setUtsDot3Onu2CtcReset(new Integer(1));
                    tmpOnuTblMBean.resetONU();
                }
            } catch (MibBeanException e) {
                e.printStackTrace();
            }
        }

        mbean.setUtsDot3OltAdminState(new Integer(utsDot3OltAdminStatusVList[tfUtsDot3OltAdminStatus.getSelectedIndex()]));
        //mbean.setUtsDot3OltTxFECEnable(new Integer(utsDot3OltTxFECEnableVList[tfUtsDot3OltTxFECEnable.getSelectedIndex()]));
        //mbean.setUtsDot3OltTransceiverTx(new Integer(utsDot3OltTransceiverTxVList[tfUtsDot3OltTransceiverTx.getSelectedIndex()]));
        //mbean.setUtsDot3OltTransceiverRx(new Integer(utsDot3OltTransceiverRxVList[tfUtsDot3OltTransceiverRx.getSelectedIndex()]));
        //mbean.setUtsDot3OltONUP2PEnable(new Integer(utsDot3OltONUP2PEnableVList[tfUtsDot3OltONUP2PEnable.getSelectedIndex()]));
        mbean.setUtsDot3OltMPCPGateBackoffTime(new Integer(tfUtsDot3OltMPCPGateBackoffTime.getValue()));
        mbean.setUtsDot3OltP2pEnable(new Integer(utsDot3OltP2pEnableVList[tfUtsDot3OltP2pEnable.getSelectedIndex()]));
        mbean.setUtsDot3OltOlpPort(new Integer(utsDot3OltOlpPortVList[tfUtsDot3OltOlpPort.getSelectedIndex()]));
        //mbean.setUtsDot3OltPortLoopbackDetection(new Integer(utsDot3OltPortLoopbackDetectionVList[tfUtsDot3OltPortLoopbackDetection.getSelectedIndex()]));
        //mbean.setUtsDot3OltPortLoopbackDetectionControl(new Integer(utsDot3OltPortLoopbackDetectionControlVList[tfUtsDot3OltPortLoopbackDetectionControl.getSelectedIndex()]));
        //mbean.setUtsDot3OltPortTransmissionPower(new Integer(tfUtsDot3OltPortTransmissionPower.getText()));
        //mbean.setUtsDot3OltPortReceivingPower(new Integer(tfUtsDot3OltPortReceivingPower.getText()));
        //mbean.setUtsDot3OltPortRealtimeMulticastTraffic(new Integer(tfUtsDot3OltPortRealtimeMulticastTraffic.getText()));
        //mbean.setUtsDot3OltPortSupplyVoltage(new Integer(tfUtsDot3OltPortSupplyVoltage.getText()));
        //mbean.setUtsDot3OltPortCurrentBias(new Integer(tfUtsDot3OltPortCurrentBias.getText()));
        //mbean.setUtsDot3OltPortCurrentTemperature(new Integer(tfUtsDot3OltPortCurrentTemperature.getText()));
        mbean.setUtsDot3OltPortFlexQinQSwitch(new Integer(utsDot3OltPortFlexQinQSwitchVList[tfUtsDot3OltPortFlexQinQSwitch.getSelectedIndex()])); //added by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
        if(utsDot3OltPortONUSNumberSwitchVList[tfUtsDot3OltPortONUSNumberSwitch.getSelectedIndex()]!=mbean.getUtsDot3OltPortONUSNumberSwitch())
            isONUSNumberSwitchChanged = true;
        else isONUSNumberSwitchChanged = false;
        mbean.setUtsDot3OltPortONUSNumberSwitch(new Integer(utsDot3OltPortONUSNumberSwitchVList[tfUtsDot3OltPortONUSNumberSwitch.getSelectedIndex()]));
    }
    
    public void afterUpdateModel() {
       if(isONUSNumberSwitchChanged)
        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Info_Take_Effect_After_Register"));
      }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}