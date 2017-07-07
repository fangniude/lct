package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltGponProtocolProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OltGponProtocolProfTablePanel extends UPanel {

    private IndexAutoGenField tfOltGponProtocolProfProtocolPofileIndex = new IndexAutoGenField(fApplication,1);
    private StringTextField tfOltGponProtocolProfProfileName = new StringTextField();
    //private JLabel tfOltGponProtocolProfMinRoundTripPropagationDelay = new JLabel();
    //private JLabel tfOltGponProtocolProfMinONUResponseTime = new JLabel();
    //private JLabel tfOltGponProtocolProfNumberEqDMeasurementCycle = new JLabel();

    private int[] oltGponProtocolProfDefaultPowerLevelModeVList = new int[]{1, 2, 3,};
    private String[] oltGponProtocolProfDefaultPowerLevelModeTList = new String[]{
            fStringMap.getString("normal"),
            fStringMap.getString("threeDb"),
            fStringMap.getString("sixDb"),
    };
    private JComboBox tfOltGponProtocolProfDefaultPowerLevelMode = new JComboBox(oltGponProtocolProfDefaultPowerLevelModeTList);

    //private JLabel tfOltGponProtocolProfDriftControlInterval = new JLabel();
    //private JLabel tfOltGponProtocolProfDriftControlLimit = new JLabel();
    //private JLabel tfOltGponProtocolProfGuardBits = new JLabel();
    //private JLabel tfOltGponProtocolProfReportingGEMBlockSize = new JLabel();
    //private JLabel tfOltGponProtocolProfUpstreamBERInterval = new JLabel();
    //private JLabel tfOltGponProtocolProfDownstreamBERInterval = new JLabel();

    private long[] oltGponProtocolProfThresholdBERSFVList = new long[]{3,4,5,6,7,8};
    private String[] oltGponProtocolProfThresholdBERSFTList = new String[]{fStringMap.getString("10E-3BER"),fStringMap.getString("10E-4 BER"),fStringMap.getString("10E-5 BER"),fStringMap.getString("10E-6 BER"),
                                fStringMap.getString("10E-7 BER"),fStringMap.getString("10E-8 BER")};
    private JComboBox tfOltGponProtocolProfThresholdBERSF = new JComboBox(oltGponProtocolProfThresholdBERSFTList);
   
    private long[] oltGponProtocolProfThresholdBERSDVList = new long[]{4,5,6,7,8,9};
    private String[] oltGponProtocolProfThresholdBERSDTList = new String[]{fStringMap.getString("10E-4BER"),fStringMap.getString("10E-5 BER"),fStringMap.getString("10E-6 BER"),
            fStringMap.getString("10E-7 BER"),fStringMap.getString("10E-8 BER"),fStringMap.getString("10E-9 BER")};
    private JComboBox tfOltGponProtocolProfThresholdBERSD = new JComboBox(oltGponProtocolProfThresholdBERSDTList);

    //private JLabel tfOltGponProtocolProfAckTimeout = new JLabel();
    //private JLabel tfOltGponProtocolProfPlsMaxAllocSize = new JLabel();
    //private JLabel tfOltGponProtocolProfNumberTxPreamble = new JLabel();
    //private JLabel tfOltGponProtocolProfPreamblePatterns = new JLabel();

    private int[] oltGponProtocolProfFecTxEnableVList = new int[]{2, 1,};
    private String[] oltGponProtocolProfFecTxEnableTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfOltGponProtocolProfFecTxEnable = new JComboBox(oltGponProtocolProfFecTxEnableTList);

    private int[] oltGponProtocolProfKeyExchangeVList = new int[]{1, 2,};
    private String[] oltGponProtocolProfKeyExchangeTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOltGponProtocolProfKeyExchange = new JComboBox(oltGponProtocolProfKeyExchangeTList);

    private int[] oltGponProtocolProfPasswordRequestVList = new int[]{1, 2,};
    private String[] oltGponProtocolProfPasswordRequestTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOltGponProtocolProfPasswordRequest = new JComboBox(oltGponProtocolProfPasswordRequestTList);

    private int[] oltGponProtocolProfDisableOnuVList = new int[]{1, 2,};
    private String[] oltGponProtocolProfDisableOnuTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOltGponProtocolProfDisableOnu = new JComboBox(oltGponProtocolProfDisableOnuTList);

    private final String oltGponProtocolProfProtocolPofileIndex = fStringMap.getString("oltGponProtocolProfProtocolPofileIndex") + ": ";
    private final String oltGponProtocolProfProfileName = fStringMap.getString("oltGponProtocolProfProfileName") + ": ";
    private final String oltGponProtocolProfMinRoundTripPropagationDelay = fStringMap.getString("oltGponProtocolProfMinRoundTripPropagationDelay") + ": ";
    private final String oltGponProtocolProfMinONUResponseTime = fStringMap.getString("oltGponProtocolProfMinONUResponseTime") + ": ";
    private final String oltGponProtocolProfNumberEqDMeasurementCycle = fStringMap.getString("oltGponProtocolProfNumberEqDMeasurementCycle") + ": ";
    private final String oltGponProtocolProfDefaultPowerLevelMode = fStringMap.getString("oltGponProtocolProfDefaultPowerLevelMode") + ": ";
    private final String oltGponProtocolProfDriftControlInterval = fStringMap.getString("oltGponProtocolProfDriftControlInterval") + ": ";
    private final String oltGponProtocolProfDriftControlLimit = fStringMap.getString("oltGponProtocolProfDriftControlLimit") + ": ";
    private final String oltGponProtocolProfGuardBits = fStringMap.getString("oltGponProtocolProfGuardBits") + ": ";
    private final String oltGponProtocolProfReportingGEMBlockSize = fStringMap.getString("oltGponProtocolProfReportingGEMBlockSize") + ": ";
    private final String oltGponProtocolProfUpstreamBERInterval = fStringMap.getString("oltGponProtocolProfUpstreamBERInterval") + ": ";
    private final String oltGponProtocolProfDownstreamBERInterval = fStringMap.getString("oltGponProtocolProfDownstreamBERInterval") + ": ";
    private final String oltGponProtocolProfThresholdBERSF = fStringMap.getString("oltGponProtocolProfThresholdBERSF") + ": ";
    private final String oltGponProtocolProfThresholdBERSD = fStringMap.getString("oltGponProtocolProfThresholdBERSD") + ": ";
    private final String oltGponProtocolProfAckTimeout = fStringMap.getString("oltGponProtocolProfAckTimeout") + ": ";
    private final String oltGponProtocolProfPlsMaxAllocSize = fStringMap.getString("oltGponProtocolProfPlsMaxAllocSize") + ": ";
    private final String oltGponProtocolProfNumberTxPreamble = fStringMap.getString("oltGponProtocolProfNumberTxPreamble") + ": ";
    private final String oltGponProtocolProfPreamblePatterns = fStringMap.getString("oltGponProtocolProfPreamblePatterns") + ": ";
    private final String oltGponProtocolProfFecTxEnable = fStringMap.getString("oltGponProtocolProfFecTxEnable") + ": ";
    private final String oltGponProtocolProfKeyExchange = fStringMap.getString("oltGponProtocolProfKeyExchange") + ": ";
    private final String oltGponProtocolProfPasswordRequest = fStringMap.getString("oltGponProtocolProfPasswordRequest") + ": ";
    private final String oltGponProtocolProfDisableOnu = fStringMap.getString("oltGponProtocolProfDisableOnu") + ": ";

    public OltGponProtocolProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfProtocolPofileIndex));
        baseInfoPanel.add(tfOltGponProtocolProfProtocolPofileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfProfileName));
        tfOltGponProtocolProfProfileName.setName(fStringMap.getString("oltGponProtocolProfProfileName"));
        tfOltGponProtocolProfProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOltGponProtocolProfProfileName);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(oltGponProtocolProfMinRoundTripPropagationDelay));
        baseInfoPanel.add(tfOltGponProtocolProfMinRoundTripPropagationDelay);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfMinONUResponseTime));
        baseInfoPanel.add(tfOltGponProtocolProfMinONUResponseTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfNumberEqDMeasurementCycle));
        baseInfoPanel.add(tfOltGponProtocolProfNumberEqDMeasurementCycle);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(oltGponProtocolProfDefaultPowerLevelMode));
        tfOltGponProtocolProfDefaultPowerLevelMode.setName(fStringMap.getString("oltGponProtocolProfDefaultPowerLevelMode"));
        baseInfoPanel.add(tfOltGponProtocolProfDefaultPowerLevelMode);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(oltGponProtocolProfDriftControlInterval));
        baseInfoPanel.add(tfOltGponProtocolProfDriftControlInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfDriftControlLimit));
        baseInfoPanel.add(tfOltGponProtocolProfDriftControlLimit);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfGuardBits));
        baseInfoPanel.add(tfOltGponProtocolProfGuardBits);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfReportingGEMBlockSize));
        baseInfoPanel.add(tfOltGponProtocolProfReportingGEMBlockSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfUpstreamBERInterval));
        baseInfoPanel.add(tfOltGponProtocolProfUpstreamBERInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfDownstreamBERInterval));
        baseInfoPanel.add(tfOltGponProtocolProfDownstreamBERInterval);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(oltGponProtocolProfThresholdBERSF));
        tfOltGponProtocolProfThresholdBERSF.setName(fStringMap.getString("oltGponProtocolProfThresholdBERSF"));
        baseInfoPanel.add(tfOltGponProtocolProfThresholdBERSF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfThresholdBERSD));
        tfOltGponProtocolProfThresholdBERSD.setName(fStringMap.getString("oltGponProtocolProfThresholdBERSD"));
        baseInfoPanel.add(tfOltGponProtocolProfThresholdBERSD);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(oltGponProtocolProfAckTimeout));
        baseInfoPanel.add(tfOltGponProtocolProfAckTimeout);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfPlsMaxAllocSize));
        baseInfoPanel.add(tfOltGponProtocolProfPlsMaxAllocSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfNumberTxPreamble));
        baseInfoPanel.add(tfOltGponProtocolProfNumberTxPreamble);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfPreamblePatterns));
        baseInfoPanel.add(tfOltGponProtocolProfPreamblePatterns);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(oltGponProtocolProfFecTxEnable));
        tfOltGponProtocolProfFecTxEnable.setName(fStringMap.getString("oltGponProtocolProfFecTxEnable"));
        baseInfoPanel.add(tfOltGponProtocolProfFecTxEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltGponProtocolProfKeyExchange));
        baseInfoPanel.add(tfOltGponProtocolProfKeyExchange);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(oltGponProtocolProfPasswordRequest));
        tfOltGponProtocolProfPasswordRequest.setName(fStringMap.getString("oltGponProtocolProfPasswordRequest"));
        baseInfoPanel.add(tfOltGponProtocolProfPasswordRequest);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(oltGponProtocolProfDisableOnu));
        tfOltGponProtocolProfDisableOnu.setName(fStringMap.getString("oltGponProtocolProfDisableOnu"));
        baseInfoPanel.add(tfOltGponProtocolProfDisableOnu);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
//        for(int i=3;i<=8;i++){
//        	tfOltGponProtocolProfThresholdBERSF.addItem(i);
//        }
//        for(int i=4;i<=10;i++){
//        	tfOltGponProtocolProfThresholdBERSD.addItem(i);
//        	
//        	
//        }
        
    }

    protected void initForm() {
        tfOltGponProtocolProfProtocolPofileIndex.setValueScope(0,2, 32);
        tfOltGponProtocolProfThresholdBERSF.setSelectedIndex(getIndexFromValue(oltGponProtocolProfThresholdBERSFVList, 5));
        tfOltGponProtocolProfThresholdBERSD.setSelectedIndex(getIndexFromValue(oltGponProtocolProfThresholdBERSDVList, 9));
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltGponProtocolProfProtocolPofileIndex.setEnabled(true);
            tfOltGponProtocolProfProtocolPofileIndex.setTable(fTable);
            tfOltGponProtocolProfProtocolPofileIndex.refresh();
            return;
        } else
            tfOltGponProtocolProfProtocolPofileIndex.setEnabled(false);
        OltGponProtocolProfTable mbean = (OltGponProtocolProfTable) getModel();

        tfOltGponProtocolProfProtocolPofileIndex.setValue(0,mbean.getOltGponProtocolProfProtocolPofileIndex());
        tfOltGponProtocolProfProfileName.setValue(mbean.getOltGponProtocolProfProfileName());
        /*
        tfOltGponProtocolProfMinRoundTripPropagationDelay.setText(mbean.getOltGponProtocolProfMinRoundTripPropagationDelay().toString());
        tfOltGponProtocolProfMinONUResponseTime.setText(mbean.getOltGponProtocolProfMinONUResponseTime().toString());
        tfOltGponProtocolProfNumberEqDMeasurementCycle.setText(mbean.getOltGponProtocolProfNumberEqDMeasurementCycle().toString());
        */
        tfOltGponProtocolProfDefaultPowerLevelMode.setSelectedIndex(getIndexFromValue(oltGponProtocolProfDefaultPowerLevelModeVList, mbean.getOltGponProtocolProfDefaultPowerLevelMode().intValue()));
        /*
        tfOltGponProtocolProfDriftControlInterval.setText(mbean.getOltGponProtocolProfDriftControlInterval().toString());
        tfOltGponProtocolProfDriftControlLimit.setText(mbean.getOltGponProtocolProfDriftControlLimit().toString());
        tfOltGponProtocolProfGuardBits.setText(mbean.getOltGponProtocolProfGuardBits().toString());
        tfOltGponProtocolProfReportingGEMBlockSize.setText(mbean.getOltGponProtocolProfReportingGEMBlockSize().toString());
        tfOltGponProtocolProfUpstreamBERInterval.setText(mbean.getOltGponProtocolProfUpstreamBERInterval().toString());
        tfOltGponProtocolProfDownstreamBERInterval.setText(mbean.getOltGponProtocolProfDownstreamBERInterval().toString());
        */
        tfOltGponProtocolProfThresholdBERSF.setSelectedIndex(getIndexFromValue(oltGponProtocolProfThresholdBERSFVList, mbean.getOltGponProtocolProfThresholdBERSF()));
        tfOltGponProtocolProfThresholdBERSD.setSelectedIndex(getIndexFromValue(oltGponProtocolProfThresholdBERSDVList, mbean.getOltGponProtocolProfThresholdBERSD()));
        /*
        tfOltGponProtocolProfAckTimeout.setText(mbean.getOltGponProtocolProfAckTimeout().toString());
        tfOltGponProtocolProfPlsMaxAllocSize.setText(mbean.getOltGponProtocolProfPlsMaxAllocSize().toString());
        tfOltGponProtocolProfNumberTxPreamble.setText(mbean.getOltGponProtocolProfNumberTxPreamble());
        tfOltGponProtocolProfPreamblePatterns.setText(mbean.getOltGponProtocolProfPreamblePatterns().toString());
        */
        tfOltGponProtocolProfFecTxEnable.setSelectedIndex(getIndexFromValue(oltGponProtocolProfFecTxEnableVList, mbean.getOltGponProtocolProfFecTxEnable().intValue()));
        tfOltGponProtocolProfKeyExchange.setSelectedIndex(getIndexFromValue(oltGponProtocolProfKeyExchangeVList, mbean.getOltGponProtocolProfKeyExchange().intValue()));
        //tfOltGponProtocolProfPasswordRequest.setSelectedIndex(getIndexFromValue(oltGponProtocolProfPasswordRequestVList, mbean.getOltGponProtocolProfPasswordRequest().intValue()));
        tfOltGponProtocolProfDisableOnu.setSelectedIndex(getIndexFromValue(oltGponProtocolProfDisableOnuVList, mbean.getOltGponProtocolProfDisableOnu().intValue()));
        //tfOltGponProtocolProfRowStatus.setSelectedIndex(getIndexFromValue(oltGponProtocolProfRowStatusVList, mbean.getOltGponProtocolProfRowStatus().intValue()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OltGponProtocolProfTable(fApplication.getSnmpProxy()));
        OltGponProtocolProfTable mbean = (OltGponProtocolProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOltGponProtocolProfProtocolPofileIndex(tfOltGponProtocolProfProtocolPofileIndex.getValue(0));
        }

        mbean.setOltGponProtocolProfProfileName(tfOltGponProtocolProfProfileName.getValue());
        mbean.setOltGponProtocolProfDefaultPowerLevelMode(oltGponProtocolProfDefaultPowerLevelModeVList[tfOltGponProtocolProfDefaultPowerLevelMode.getSelectedIndex()]);
        mbean.setOltGponProtocolProfThresholdBERSF(oltGponProtocolProfThresholdBERSFVList[tfOltGponProtocolProfThresholdBERSF.getSelectedIndex()]);
        mbean.setOltGponProtocolProfThresholdBERSD(oltGponProtocolProfThresholdBERSDVList[tfOltGponProtocolProfThresholdBERSD.getSelectedIndex()]);
        mbean.setOltGponProtocolProfFecTxEnable(oltGponProtocolProfFecTxEnableVList[tfOltGponProtocolProfFecTxEnable.getSelectedIndex()]);
        mbean.setOltGponProtocolProfKeyExchange(new Integer(oltGponProtocolProfKeyExchangeVList[tfOltGponProtocolProfKeyExchange.getSelectedIndex()]));
        //mbean.setOltGponProtocolProfPasswordRequest(oltGponProtocolProfPasswordRequestVList[tfOltGponProtocolProfPasswordRequest.getSelectedIndex()]);
        mbean.setOltGponProtocolProfDisableOnu(oltGponProtocolProfDisableOnuVList[tfOltGponProtocolProfDisableOnu.getSelectedIndex()]);
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOltGponProtocolProfProtocolPofileIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
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