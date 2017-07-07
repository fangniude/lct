package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.UtsDot3Onu2AlarmProfileSettingTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The UtsDot3Onu2AlarmProfileSettingTablePanel class. Created by DVM Creator
 */
public class UtsDot3Onu2AlarmProfileSettingTablePanel extends UPanel {

	private IntegerTextField tfUtsDot3Onu2AlarmProfileIndex = new IntegerTextField();

	private int[] utsDot3Onu2AlarmIdVList = new int[] { 272, 1025, 267, 12,
			273, 271, 11, 6, 274, 1282, 276, 5, 262, 270, 268, 1283, 773, 266,
			264, 513, 769, 4, 771, 265, 257, 770, 514, 772, 2, 1281, 3, 7, 9,
			259, 261, 269, 1, 275, 260, 263, 258, 10, };
	private String[] utsDot3Onu2AlarmIdTList = new String[] {
			fStringMap.getString("ponifTxBiasLowWarning"),
			fStringMap.getString("portPotsPortFail"),
			fStringMap.getString("ponifRxPowerHighWarning"),
			fStringMap.getString("onuPonifSwitch"),
			fStringMap.getString("ponifVccHighAlarmWarning"),
			fStringMap.getString("ponifTxBiasHighWarning"),
			fStringMap.getString("onuIadConnectionFail"),
			fStringMap.getString("onuPhysicalIntrusion"),
			fStringMap.getString("ponifVccLowWarning"),
			fStringMap.getString("portE1PortTimingUnlock"),
			fStringMap.getString("ponifTemperatureLowWarning"),
			fStringMap.getString("onuBatteryVoltageLow"),
			fStringMap.getString("ponifTxBiasLowAlarm"),
			fStringMap.getString("ponifTxPowerLowWarning"),
			fStringMap.getString("ponifRxPowerLowWarning"),
			fStringMap.getString("portE1PortLos"),
			fStringMap.getString("portEthPortCongestion"),
			fStringMap.getString("ponifTemperatureLowAlarm"),
			fStringMap.getString("ponifVccLowAlarm"),
			fStringMap.getString("cardCardAlarm"),
			fStringMap.getString("portEthPortAutoNegoFail"),
			fStringMap.getString("onuBatteryFailure"),
			fStringMap.getString("portEthPortFail"),
			fStringMap.getString("ponifTemperatureHighAlarm"),
			fStringMap.getString("ponifRxPowerHighAlarm"),
			fStringMap.getString("portEthPortLos"),
			fStringMap.getString("cardSelfTestFail"),
			fStringMap.getString("portEthPortLoopback"),
			fStringMap.getString("onuPowerAlarm"),
			fStringMap.getString("portE1PortFail"),
			fStringMap.getString("onuBatteryMissing"),
			fStringMap.getString("onuOnuSelfTestFailure"),
			fStringMap.getString("onuOnuTemperatureHighAlarm"),
			fStringMap.getString("ponifTxPowerHighAlarm"),
			fStringMap.getString("ponifTxBiasHighAlarm"),
			fStringMap.getString("ponifTxPowerHighWarning"),
			fStringMap.getString("onuEquipmentAlarm"),
			fStringMap.getString("ponifTemperatureHighWarning"),
			fStringMap.getString("ponifTxPowerLowAlarm"),
			fStringMap.getString("ponifVccHighAlarm"),
			fStringMap.getString("ponifRxPowerLowAlarm"),
			fStringMap.getString("onuOnuTemperatureLowAlarm"), };
	private JComboBox tfUtsDot3Onu2AlarmId = new JComboBox(
			utsDot3Onu2AlarmIdTList);
	private JLabel tfUtsDot3Onu2AlarmInstance = new JLabel("1");

	private int[] utsDot3Onu2AlarmAdminVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2AlarmAdminTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2AlarmAdmin = new JComboBox(
			utsDot3Onu2AlarmAdminTList);
	private IntegerTextField tfUtsDot3Onu2AlarmRaiseThreshold = new IntegerTextField();

	private IntegerTextField tfUtsDot3Onu2AlarmClearThreshold = new IntegerTextField();

	/*
	private int[] utsDot3Onu2AlarmProfileSettingRowStatusVList = new int[] { 1,
			2, 5, 4, 3, 6, };
	private String[] utsDot3Onu2AlarmProfileSettingRowStatusTList = new String[] {
			fStringMap.getString("active"),
			fStringMap.getString("notInService"),
			fStringMap.getString("createAndWait"),
			fStringMap.getString("createAndGo"),
			fStringMap.getString("notReady"), fStringMap.getString("destroy"), };
	private JComboBox tfUtsDot3Onu2AlarmProfileSettingRowStatus = new JComboBox(
			utsDot3Onu2AlarmProfileSettingRowStatusTList);
	*/

	private final String utsDot3Onu2AlarmProfileIndex = fStringMap
			.getString("utsDot3Onu2AlarmProfileIndex") + " : ";
	private final String utsDot3Onu2AlarmId = fStringMap
			.getString("utsDot3Onu2AlarmId") + " : ";
	private final String utsDot3Onu2AlarmInstance = fStringMap
			.getString("utsDot3Onu2AlarmInstance") + " : ";
	private final String utsDot3Onu2AlarmAdmin = fStringMap
			.getString("utsDot3Onu2AlarmAdmin") + " : ";
	private final String utsDot3Onu2AlarmRaiseThreshold = fStringMap
			.getString("utsDot3Onu2AlarmRaiseThreshold") + " : ";
	private final String utsDot3Onu2AlarmClearThreshold = fStringMap
			.getString("utsDot3Onu2AlarmClearThreshold") + " : ";

	public UtsDot3Onu2AlarmProfileSettingTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmProfileIndex));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmProfileIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmId));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmInstance));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmInstance);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmAdmin));
		tfUtsDot3Onu2AlarmAdmin.setName(fStringMap
				.getString("utsDot3Onu2AlarmAdmin"));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmAdmin);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmRaiseThreshold));
		tfUtsDot3Onu2AlarmRaiseThreshold.setName(fStringMap
				.getString("utsDot3Onu2AlarmRaiseThreshold"));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmRaiseThreshold);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmClearThreshold));
		tfUtsDot3Onu2AlarmClearThreshold.setName(fStringMap
				.getString("utsDot3Onu2AlarmClearThreshold"));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmClearThreshold);
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

	public void refresh() {
		if (SnmpAction.IType.ADD.equals(fCommand))
			return;
		UtsDot3Onu2AlarmProfileSettingTable mbean = (UtsDot3Onu2AlarmProfileSettingTable) getModel();

		tfUtsDot3Onu2AlarmProfileIndex.setText(mbean
				.getUtsDot3Onu2AlarmProfileIndex().toString());
		tfUtsDot3Onu2AlarmId.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2AlarmIdVList, mbean.getUtsDot3Onu2AlarmId()
						.intValue()));
		tfUtsDot3Onu2AlarmInstance.setText(mbean.getUtsDot3Onu2AlarmInstance()
				.toString());
		tfUtsDot3Onu2AlarmAdmin.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2AlarmAdminVList, mbean.getUtsDot3Onu2AlarmAdmin()
						.intValue()));
		tfUtsDot3Onu2AlarmRaiseThreshold.setValue(mbean
				.getUtsDot3Onu2AlarmRaiseThreshold().intValue());
		tfUtsDot3Onu2AlarmClearThreshold.setValue(mbean
				.getUtsDot3Onu2AlarmClearThreshold().intValue());
//		tfUtsDot3Onu2AlarmProfileSettingRowStatus
//				.setSelectedIndex(getIndexFromValue(
//						utsDot3Onu2AlarmProfileSettingRowStatusVList, mbean
//								.getUtsDot3Onu2AlarmProfileSettingRowStatus().intValue()));

	}

	public void updateModel() {
              
              if (SnmpAction.IType.ADD.equals(fCommand)){
            	  setModel(new UtsDot3Onu2AlarmProfileSettingTable(fApplication.getSnmpProxy()));
              }
              UtsDot3Onu2AlarmProfileSettingTable mbean = (UtsDot3Onu2AlarmProfileSettingTable) getModel();              
              if (SnmpAction.IType.ADD.equals(fCommand)) {
              //  here set the value of index
		          mbean.setUtsDot3Onu2AlarmProfileIndex(Integer.valueOf(tfUtsDot3Onu2AlarmProfileIndex.getValue()));
               }
             
              
      
      
      mbean.setUtsDot3Onu2AlarmAdmin(new Integer(utsDot3Onu2AlarmAdminVList[tfUtsDot3Onu2AlarmAdmin.getSelectedIndex()]));
      mbean.setUtsDot3Onu2AlarmRaiseThreshold( new Integer(tfUtsDot3Onu2AlarmRaiseThreshold.getValue()));
      mbean.setUtsDot3Onu2AlarmClearThreshold( new Integer(tfUtsDot3Onu2AlarmClearThreshold.getValue()));
//      mbean.setUtsDot3Onu2AlarmProfileSettingRowStatus(new Integer(utsDot3Onu2AlarmProfileSettingRowStatusVList[tfUtsDot3Onu2AlarmProfileSettingRowStatus.getSelectedIndex()]));

        
          }

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
