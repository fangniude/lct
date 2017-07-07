/**
 * Created by Zhou Chao, 2010/1/13
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcAlarmReportingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcAlarmReportingTablePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcAlarmReportingModuleId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcAlarmReportingDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcAlarmReportingPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcAlarmReportingLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcAlarmReportingAlarmIdVList = new int[]{
            1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 513, 514, 769, 770, 771, 772, 773, 1025, 1281, 1282, 1283,};
    private String[] utsDot3Onu2CtcAlarmReportingAlarmIdTList = new String[]{
            fStringMap.getString("onuEquipmentAlarm"), //1
            fStringMap.getString("onuPowerAlarm"), //2
            fStringMap.getString("onuBatteryMissing"), //3
            fStringMap.getString("onuBatteryFailure"), //4
            fStringMap.getString("onuBatteryVoltageLow"), //5
            fStringMap.getString("onuPhysicalIntrusion"), //6
            fStringMap.getString("onuOnuSelfTestFailure"), //7
            fStringMap.getString("onuOnuTemperatureHighAlarm"), //9
            fStringMap.getString("onuOnuTemperatureLowAlarm"), //10
            fStringMap.getString("onuIadConnectionFail"), //11
            fStringMap.getString("onuPonifSwitch"), //12
            fStringMap.getString("ponifRxPowerHighAlarm"), //257
            fStringMap.getString("ponifRxPowerLowAlarm"), //258
            fStringMap.getString("ponifTxPowerHighAlarm"), //259
            fStringMap.getString("ponifTxPowerLowAlarm"), //260
            fStringMap.getString("ponifTxBiasHighAlarm"), //261
            fStringMap.getString("ponifTxBiasLowAlarm"), //262
            fStringMap.getString("ponifVccHighAlarm"), //263
            fStringMap.getString("ponifVccLowAlarm"), //264
            fStringMap.getString("ponifTemperatureHighAlarm"), //265
            fStringMap.getString("ponifTemperatureLowAlarm"), //266
            fStringMap.getString("ponifRxPowerHighWarning"), //267
            fStringMap.getString("ponifRxPowerLowWarning"), //268
            fStringMap.getString("ponifTxPowerHighWarning"), //269
            fStringMap.getString("ponifTxPowerLowWarning"), //270
            fStringMap.getString("ponifTxBiasHighWarning"), //271
            fStringMap.getString("ponifTxBiasLowWarning"), //272
            fStringMap.getString("ponifVccHighAlarmWarning"), //273
            fStringMap.getString("ponifVccLowWarning"), //274
            fStringMap.getString("ponifTemperatureHighWarning"), //275
            fStringMap.getString("ponifTemperatureLowWarning"), //276
            fStringMap.getString("cardCardAlarm"), //513
            fStringMap.getString("cardSelfTestFail"), //514
            fStringMap.getString("portEthPortAutoNegoFail"), //769
            fStringMap.getString("portEthPortLos"), //770
            fStringMap.getString("portEthPortFail"), //771
            fStringMap.getString("portEthPortLoopback"), //772
            fStringMap.getString("portEthPortCongestion"), //773
            fStringMap.getString("portPotsPortFail"), //1025
            fStringMap.getString("portE1PortFail"), //1281
            fStringMap.getString("portE1PortTimingUnlock"), //1282
            fStringMap.getString("portE1PortLos"), //1283
    };
    private JComboBox tfUtsDot3Onu2CtcAlarmReportingAlarmId = new JComboBox(utsDot3Onu2CtcAlarmReportingAlarmIdTList);
    private JLabel tfUtsDot3Onu2CtcAlarmReportingOnuPortId = new JLabel();

    private int[] utsDot3Onu2CtcAlarmReportingAlarmObjectsVList = new int[]{
            1, 2, 3, 4,};
    private String[] utsDot3Onu2CtcAlarmReportingAlarmObjectsTList = new String[]{
            fStringMap.getString("onu"),
            fStringMap.getString("ponif"),
            fStringMap.getString("card"),
            fStringMap.getString("port"),
    };
    private JComboBox tfUtsDot3Onu2CtcAlarmReportingAlarmObjects = new JComboBox(utsDot3Onu2CtcAlarmReportingAlarmObjectsTList);

    private int[] utsDot3Onu2CtcAlarmReportingAlarmAdminVList = new int[]{
            1, 2,};
    private String[] utsDot3Onu2CtcAlarmReportingAlarmAdminTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3Onu2CtcAlarmReportingAlarmAdmin = new JComboBox(utsDot3Onu2CtcAlarmReportingAlarmAdminTList);

    private int[] utsDot3Onu2CtcAlarmReportingThresholdSupportVList = new int[]{
            1, 2,};
    private String[] utsDot3Onu2CtcAlarmReportingThresholdSupportTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3Onu2CtcAlarmReportingThresholdSupport = new JComboBox(utsDot3Onu2CtcAlarmReportingThresholdSupportTList);

    private IntegerTextField tfUtsDot3Onu2CtcAlarmReportingThresholdRaise = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcAlarmReportingThresholdClear = new IntegerTextField();

    private final String utsDot3Onu2CtcAlarmReportingModuleId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingModuleId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingDeviceId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingDeviceId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingPortId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingPortId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingLogicalPortId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingAlarmId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingOnuPortId = fStringMap.getString("utsDot3Onu2CtcAlarmReportingOnuPortId") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingAlarmObjects = fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmObjects") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingAlarmAdmin = fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmAdmin") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingThresholdSupport = fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdSupport") + ": ";
    private final String utsDot3Onu2CtcAlarmReportingThresholdRaise = fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdRaise");
    private final String utsDot3Onu2CtcAlarmReportingThresholdClear = fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdClear");
    
    private JLabel thresholdRaiseLabel = new JLabel(utsDot3Onu2CtcAlarmReportingThresholdRaise + ": ");
    private JLabel thresholdClearLabel = new JLabel(utsDot3Onu2CtcAlarmReportingThresholdClear + ": ");

    public Onu2CtcAlarmReportingTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingModuleId);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingDeviceId));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingDeviceId);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingAlarmId));
        tfUtsDot3Onu2CtcAlarmReportingAlarmId.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmId"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingAlarmId);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingOnuPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingOnuPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingAlarmObjects));
        tfUtsDot3Onu2CtcAlarmReportingAlarmObjects.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmObjects"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingAlarmObjects);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingAlarmAdmin));
        tfUtsDot3Onu2CtcAlarmReportingAlarmAdmin.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingAlarmAdmin"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingAlarmAdmin);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcAlarmReportingThresholdSupport));
        tfUtsDot3Onu2CtcAlarmReportingThresholdSupport.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdSupport"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingThresholdSupport);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(thresholdRaiseLabel);
        tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdRaise"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingThresholdRaise);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(thresholdClearLabel);
        tfUtsDot3Onu2CtcAlarmReportingThresholdClear.setName(fStringMap.getString("utsDot3Onu2CtcAlarmReportingThresholdClear"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcAlarmReportingThresholdClear);
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
    	
    }
    
    public boolean validateFrom() {
		Integer alarmId = new Integer(
				utsDot3Onu2CtcAlarmReportingAlarmIdVList[tfUtsDot3Onu2CtcAlarmReportingAlarmId
						.getSelectedIndex()]);
		
		Integer thresholdRaise = tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.getValue();
		Integer thresholdClear = tfUtsDot3Onu2CtcAlarmReportingThresholdClear.getValue();
		//For temperature threshold, the unit is 1/256 degree. The range is -128 C to 128 C. 
		if (alarmId == 9 || alarmId == 10 || alarmId == 265 || alarmId == 266
				|| alarmId == 275 || alarmId == 276) {
			if (thresholdRaise > 128 || thresholdRaise < -128) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("temperatureThresholdRaise"));
				return false;
			}
			if (thresholdClear > 128 || thresholdClear < -128) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("temperatureThresholdClear"));
				return false;
			}
		}

		//For power voltage threshold, the unit is 100 uV. The range is 0 to 6.55 v. 
		if (alarmId == 5 || alarmId == 263 || alarmId == 264 || alarmId == 273
				|| alarmId == 274) {
			if (thresholdRaise > 6550 || thresholdRaise < 0) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("powerVoltageThresholdRaise"));
				return false;
			}
			if (thresholdClear > 6550 || thresholdClear < 0) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("powerVoltageThresholdClear"));
				return false;
			}
		}

		//For bias current threshold, the unit is 2 uA. The range is 0 to 131 mA. 
		if (alarmId == 261 || alarmId == 262 || alarmId == 271
				|| alarmId == 272) {
			if (thresholdRaise > 131 || thresholdRaise < 0) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("biasCurrentThresholdRaise"));
				return false;
			}
			if (thresholdClear > 131 || thresholdClear < 0) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("biasCurrentThresholdClear"));
				return false;
			}
		}

		//For Tx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW. 
		if (alarmId == 259 || alarmId == 260 || alarmId == 269
				|| alarmId == 270) {
			if (thresholdRaise > 8 || thresholdRaise < -40) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("txPowerThresholdRaise"));
				return false;
			}
			if (thresholdClear > 8 || thresholdClear < -40) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("txPowerThresholdClear"));
				return false;
			}
		}

		//For Rx power threshold, the unit is 0.1uW. The range is 0 to 6.5535mW. 
		if (alarmId == 257 || alarmId == 258 || alarmId == 267
				|| alarmId == 268) {
			if (thresholdRaise > 8 || thresholdRaise < -40) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("rxPowerThresholdRaise"));
				return false;
			}
			if (thresholdClear > 8 || thresholdClear < -40) {
				MessageDialog.showErrorMessageDialog(fApplication, fStringMap
						.getString("rxPowerThresholdClear"));
				return false;
			}
		}
		
		return true;
    }

    public void refresh() {
        Onu2CtcAlarmReportingTable mbean = (Onu2CtcAlarmReportingTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcAlarmReportingModuleId.setText(mbean.getUtsDot3Onu2CtcAlarmReportingModuleId().toString());
        tfUtsDot3Onu2CtcAlarmReportingDeviceId.setText(mbean.getUtsDot3Onu2CtcAlarmReportingDeviceId().toString());
        tfUtsDot3Onu2CtcAlarmReportingPortId.setText(mbean.getUtsDot3Onu2CtcAlarmReportingPortId().toString());
        tfUtsDot3Onu2CtcAlarmReportingLogicalPortId.setText(mbean.getUtsDot3Onu2CtcAlarmReportingLogicalPortId().toString());
        tfUtsDot3Onu2CtcAlarmReportingAlarmId.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAlarmReportingAlarmIdVList, mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId().intValue()));
        tfUtsDot3Onu2CtcAlarmReportingAlarmId.setEnabled(false);
        tfUtsDot3Onu2CtcAlarmReportingOnuPortId.setText(mbean.getUtsDot3Onu2CtcAlarmReportingOnuPortId().toString());
        tfUtsDot3Onu2CtcAlarmReportingAlarmObjects.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAlarmReportingAlarmObjectsVList, mbean.getUtsDot3Onu2CtcAlarmReportingAlarmObjects().intValue()));
        tfUtsDot3Onu2CtcAlarmReportingAlarmAdmin.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAlarmReportingAlarmAdminVList, mbean.getUtsDot3Onu2CtcAlarmReportingAlarmAdmin().intValue()));
        tfUtsDot3Onu2CtcAlarmReportingThresholdSupport.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcAlarmReportingThresholdSupportVList, mbean.getUtsDot3Onu2CtcAlarmReportingThresholdSupport().intValue()));
        
		if (mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 9
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 10
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 265
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 266
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 275
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 276
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 5
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 263
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 264
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 273
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 274
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 261
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 262
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 271
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 272
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 259
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 260
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 269
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 270
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 257
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 258
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 267
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 268) {
			tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.setEnabled(false);
			tfUtsDot3Onu2CtcAlarmReportingThresholdClear.setEnabled(false);
		}
		else {
			tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.setEnabled(true);
			tfUtsDot3Onu2CtcAlarmReportingThresholdClear.setEnabled(true);
			tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.setValue(mbean.getUtsDot3Onu2CtcAlarmReportingThresholdRaise().intValue());
	        tfUtsDot3Onu2CtcAlarmReportingThresholdClear.setValue(mbean.getUtsDot3Onu2CtcAlarmReportingThresholdClear().intValue());
		}
		
		String unit = getUnit(mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId().intValue());

		thresholdRaiseLabel.setText(utsDot3Onu2CtcAlarmReportingThresholdRaise + unit + ": ");
		thresholdClearLabel.setText(utsDot3Onu2CtcAlarmReportingThresholdClear + unit + ": ");
		thresholdRaiseLabel.updateUI();
		thresholdClearLabel.updateUI();
    }

    public void updateModel() {
        Onu2CtcAlarmReportingTable mbean = (Onu2CtcAlarmReportingTable) getModel();
        if (mbean == null)
            return;

//        mbean.setUtsDot3Onu2CtcAlarmReportingAlarmId(new Integer(utsDot3Onu2CtcAlarmReportingAlarmIdVList[tfUtsDot3Onu2CtcAlarmReportingAlarmId.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcAlarmReportingAlarmObjects(new Integer(utsDot3Onu2CtcAlarmReportingAlarmObjectsVList[tfUtsDot3Onu2CtcAlarmReportingAlarmObjects.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcAlarmReportingAlarmAdmin(new Integer(utsDot3Onu2CtcAlarmReportingAlarmAdminVList[tfUtsDot3Onu2CtcAlarmReportingAlarmAdmin.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcAlarmReportingThresholdSupport(new Integer(utsDot3Onu2CtcAlarmReportingThresholdSupportVList[tfUtsDot3Onu2CtcAlarmReportingThresholdSupport.getSelectedIndex()]));
        if (mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 9
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 10
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 265
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 266
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 275
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 276
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 5
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 263
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 264
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 273
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 274
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 261
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 262
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 271
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 272
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 259
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 260
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 269
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 270
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 257
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 258
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 267
				&& mbean.getUtsDot3Onu2CtcAlarmReportingAlarmId() != 268) {
			mbean
					.setUtsDot3Onu2CtcAlarmReportingThresholdRaise(mbean
							.getUtsDot3Onu2CtcAlarmReportingThresholdRaise()
							.intValue());
			mbean
					.setUtsDot3Onu2CtcAlarmReportingThresholdClear(mbean
							.getUtsDot3Onu2CtcAlarmReportingThresholdClear()
							.intValue());
		} else {
			mbean.setUtsDot3Onu2CtcAlarmReportingThresholdRaiseDisplay(new Integer(
					tfUtsDot3Onu2CtcAlarmReportingThresholdRaise.getValue()));
			mbean.setUtsDot3Onu2CtcAlarmReportingThresholdClearDisplay(new Integer(
					tfUtsDot3Onu2CtcAlarmReportingThresholdClear.getValue()));
		}
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
    
    public String getUnit(int alarmId) {
		if (alarmId == 9 || alarmId == 10 || alarmId == 265 || alarmId == 266
				|| alarmId == 275 || alarmId == 276) {
			return "(��)";
		}
		if (alarmId == 5 || alarmId == 263 || alarmId == 264 || alarmId == 273
				|| alarmId == 274) {
			return "(mV)";
		}
		if (alarmId == 261 || alarmId == 262 || alarmId == 271
				|| alarmId == 272) {
			return "(mA)";
		}
		if (alarmId == 259 || alarmId == 260 || alarmId == 269
				|| alarmId == 270) {
			return "(dB)";
		}
		if (alarmId == 257 || alarmId == 258 || alarmId == 267
				|| alarmId == 268) {
			return "(dB)";
		}
		return "";
    }

}