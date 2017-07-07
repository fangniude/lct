package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.GeneralConfiguration;
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
//import com.winnertel.ems.epon.iad.bbs4000.mib.PortBasedVLAN;

/**
 * The GeneralConfigurationPanel class. Created by DVM Creator
 */
public class GeneralConfigurationPanel extends UPanel
{

	private int[] utsBBSBPDUTerminationVList = new int[]
	{ 2, 1, };

	private String[] utsBBSBPDUTerminationTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsBBSBPDUTermination = new JComboBox(
			utsBBSBPDUTerminationTList);

	private int[] utsBBSSysSoftwareRateLimitingVList = new int[]
	{ 2, 1, };

	private String[] utsBBSSysSoftwareRateLimitingTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsBBSSysSoftwareRateLimiting = new JComboBox(
			utsBBSSysSoftwareRateLimitingTList);

//	private int[] utsBBSSysHardwareRateLimitingVList = new int[]
//	{ 2, 1, };

//	private String[] utsBBSSysHardwareRateLimitingTList = new String[]
//	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

//	private JComboBox tfUtsBBSSysHardwareRateLimiting = new JComboBox(
//			utsBBSSysHardwareRateLimitingTList);

	private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdTotal = new IntegerTextField();

	private IntegerTextField tfUtsBBSSysCpuUtilityAlarmThresholdPerTask = new IntegerTextField();

	private IntegerTextField tfUtsBBSSysMemoryUtilityAlarmThreshold = new IntegerTextField();

	private IntegerTextField tfUtsBBSSysARPAgingTime = new IntegerTextField();

	private IntegerTextField tfUtsBBSSysMACAgingTime = new IntegerTextField();

	private int[] utsPonSysLogicalPortStrictBingingVList = new int[]
	{ 1, 2, };

	private String[] utsPonSysLogicalPortStrictBingingTList = new String[]
	{ fStringMap.getString("enabled"), fStringMap.getString("disabled"), };

	private JComboBox tfUtsPonSysLogicalPortStrictBinging = new JComboBox(
			utsPonSysLogicalPortStrictBingingTList);

	private IntegerTextField tfUtsPonSysOltMACAgingTime = new IntegerTextField();

	private int[] utsPonSysOlpModeVList = new int[]
	{ 2, 1, };

	private String[] utsPonSysOlpModeTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsPonSysOlpMode = new JComboBox(utsPonSysOlpModeTList);

	private StringTextField tfUtsBBSVlanVPNTPID = new StringTextField();

	private int[] utsBBSVlanVPNPRISourceVList = new int[]
	{ 2, 1, };

	private String[] utsBBSVlanVPNPRISourceTList = new String[]
	{ fStringMap.getString("llid"), fStringMap.getString("customertag"), };

	private JComboBox tfUtsBBSVlanVPNPRISource = new JComboBox(
			utsBBSVlanVPNPRISourceTList);

    private IntegerTextField tfUtsBBSMaxFrameSize = new IntegerTextField();

    private final String utsBBSBPDUTermination = fStringMap
			.getString("utsBBSBPDUTermination")
			+ " : ";

	private final String utsBBSSysSoftwareRateLimiting = fStringMap
			.getString("utsBBSSysSoftwareRateLimiting")
			+ " : ";

//	private final String utsBBSSysHardwareRateLimiting = fStringMap
//			.getString("utsBBSSysHardwareRateLimiting")
//			+ " : ";

	private final String utsBBSSysCpuUtilityAlarmThresholdTotal = fStringMap
			.getString("utsBBSSysCpuUtilityAlarmThresholdTotal")
			+ " : ";

	private final String utsBBSSysCpuUtilityAlarmThresholdPerTask = fStringMap
			.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask")
			+ " : ";

	private final String utsBBSSysMemoryUtilityAlarmThreshold = fStringMap
			.getString("utsBBSSysMemoryUtilityAlarmThreshold")
			+ " : ";

	private final String utsBBSSysARPAgingTime = fStringMap
			.getString("utsBBSSysARPAgingTime")
			+ " : ";

	private final String utsBBSSysMACAgingTime = fStringMap
			.getString("utsBBSSysMACAgingTime")
			+ " : ";

	private final String utsPonSysLogicalPortStrictBinging = fStringMap
			.getString("utsPonSysLogicalPortStrictBinging")
			+ " : ";

	private final String utsPonSysOltMACAgingTime = fStringMap
			.getString("utsPonSysOltMACAgingTime")
			+ " : ";

	private final String utsPonSysOlpMode = fStringMap
			.getString("utsPonSysOlpMode")
			+ " : ";

	private final String utsBBSVlanVPNTPID = fStringMap
			.getString("utsBBSVlanVPNTPID")
			+ " : ";

	private final String utsBBSVlanVPNPRISource = fStringMap
			.getString("utsBBSVlanVPNPRISource")
			+ " : ";

	private final String utsBBSMaxFrameSize = fStringMap
			.getString("utsBBSMaxFrameSize")
			+ " : ";

    private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public GeneralConfigurationPanel(IApplication app)
	{
		super(app);
		setModel(new GeneralConfiguration(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{
		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID,
				"Modify_GeneralConfiguration");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBBSBPDUTermination));
		tfUtsBBSBPDUTermination.setName(fStringMap
				.getString("utsBBSBPDUTermination"));
		baseInfoPanel.add(tfUtsBBSBPDUTermination);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysSoftwareRateLimiting));
		tfUtsBBSSysSoftwareRateLimiting.setName(fStringMap
				.getString("utsBBSSysSoftwareRateLimiting"));
		baseInfoPanel.add(tfUtsBBSSysSoftwareRateLimiting);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsBBSSysHardwareRateLimiting));
//		tfUtsBBSSysHardwareRateLimiting.setName(fStringMap
//				.getString("utsBBSSysHardwareRateLimiting"));
//		baseInfoPanel.add(tfUtsBBSSysHardwareRateLimiting);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdTotal));
		tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setName(fStringMap
				.getString("utsBBSSysCpuUtilityAlarmThresholdTotal"));
		baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdTotal);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysCpuUtilityAlarmThresholdPerTask));
		tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setName(fStringMap
				.getString("utsBBSSysCpuUtilityAlarmThresholdPerTask"));
		baseInfoPanel.add(tfUtsBBSSysCpuUtilityAlarmThresholdPerTask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysMemoryUtilityAlarmThreshold));
		tfUtsBBSSysMemoryUtilityAlarmThreshold.setName(fStringMap
				.getString("utsBBSSysMemoryUtilityAlarmThreshold"));
		baseInfoPanel.add(tfUtsBBSSysMemoryUtilityAlarmThreshold);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysARPAgingTime));
		tfUtsBBSSysARPAgingTime.setName(fStringMap
				.getString("utsBBSSysARPAgingTime"));
		baseInfoPanel.add(tfUtsBBSSysARPAgingTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBBSSysMACAgingTime));
		tfUtsBBSSysMACAgingTime.setName(fStringMap
				.getString("utsBBSSysMACAgingTime"));
		baseInfoPanel.add(tfUtsBBSSysMACAgingTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsPonSysLogicalPortStrictBinging));
		tfUtsPonSysLogicalPortStrictBinging.setName(fStringMap
				.getString("utsPonSysLogicalPortStrictBinging"));
		baseInfoPanel.add(tfUtsPonSysLogicalPortStrictBinging);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsPonSysOltMACAgingTime));
		tfUtsPonSysOltMACAgingTime.setName(fStringMap
				.getString("utsPonSysOltMACAgingTime"));
		baseInfoPanel.add(tfUtsPonSysOltMACAgingTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsPonSysOlpMode));
		tfUtsPonSysOlpMode.setName(fStringMap.getString("utsPonSysOlpMode"));
		baseInfoPanel.add(tfUtsPonSysOlpMode);
		baseInfoPanel.add(new HSpacer());

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

	protected void initForm()
	{
		tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValueScope(0, 100);

		tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValueScope(0, 100);

		tfUtsBBSSysMemoryUtilityAlarmThreshold.setValueScope(0, 100);

		tfUtsBBSSysARPAgingTime.setValueScope(30, 65535);

		tfUtsBBSSysMACAgingTime.setValueScope(0, 65535);

		tfUtsPonSysOltMACAgingTime.setValueScope(10, 65535);

//		tfUtsBBSVlanVPNTPID.setValueScope(1, 65535);
    tfUtsBBSVlanVPNTPID.setEnabled(false);
    
    tfUtsBBSVlanVPNPRISource.setEnabled(false);

    tfUtsBBSSysSoftwareRateLimiting.setEnabled(false);

    tfUtsBBSMaxFrameSize.setValueScope(64,16368);
	}

	public boolean validateFrom() {
		// OLT MAC Aging time
		int sysMacAgingTime = tfUtsBBSSysMACAgingTime.getValue();
		if ( sysMacAgingTime != 0 && !(sysMacAgingTime >= 10 && sysMacAgingTime <= 65535 ) ) {
      String error = fStringMap.getString("Err_MAC_Aging_Time_Is_Invalid");
			MessageDialog.showInfoMessageDialog( fApplication, error );
			return false;
		}

		return true;
	}

	public void refresh()
	{

		GeneralConfiguration mbean = (GeneralConfiguration) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsBBSBPDUTermination.setSelectedIndex(getIndexFromValue(
				utsBBSBPDUTerminationVList, mbean.getUtsBBSBPDUTermination().intValue()));

//		Only when all utsEponDot1qVlanStpBridgeEnable=2: disable(2)
//		Can set utsBBSBPDUTermination to 1: enable(1)
//		try {
//			tfUtsBBSBPDUTermination.setEnabled( true );
//
//			PortBasedVLAN portVLanMBean = new PortBasedVLAN( fApplication.getSnmpProxy() );
//			Vector vLanVec = portVLanMBean.retrieveAll();
//			for ( int i = 0; i < vLanVec.size(); i++ ) {
//				PortBasedVLAN tmpPortVLan = (PortBasedVLAN)vLanVec.elementAt(i);
//				int tmpVlanStpBridge = tmpPortVLan.getUtsEponDot1qVlanStpBridgeEnable().intValue();
//				if ( tmpVlanStpBridge != 2 ) {
//					tfUtsBBSBPDUTermination.setEnabled( false );
//				}
//			}
//		}
//		catch ( Exception ex) {
//			ex.printStackTrace();
//		}
		
		tfUtsBBSSysSoftwareRateLimiting.setSelectedIndex(getIndexFromValue(
				utsBBSSysSoftwareRateLimitingVList, mbean.getUtsBBSSysSoftwareRateLimiting().intValue()));

//		tfUtsBBSSysHardwareRateLimiting.setSelectedIndex(getIndexFromValue(
//				utsBBSSysHardwareRateLimitingVList, mbean.getUtsBBSSysHardwareRateLimiting().intValue()));

		tfUtsBBSSysCpuUtilityAlarmThresholdTotal.setValue(mbean
				.getUtsBBSSysCpuUtilityAlarmThresholdTotal().intValue());
		tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.setValue(mbean
				.getUtsBBSSysCpuUtilityAlarmThresholdPerTask().intValue());
		tfUtsBBSSysMemoryUtilityAlarmThreshold.setValue(mbean
				.getUtsBBSSysMemoryUtilityAlarmThreshold().intValue());
		tfUtsBBSSysARPAgingTime.setValue(mbean.getUtsBBSSysARPAgingTime().intValue());
		tfUtsBBSSysMACAgingTime.setValue(mbean.getUtsBBSSysMACAgingTime().intValue());
		tfUtsPonSysLogicalPortStrictBinging.setSelectedIndex(getIndexFromValue(
				utsPonSysLogicalPortStrictBingingVList, mbean.getUtsPonSysLogicalPortStrictBinging().intValue()));
		tfUtsPonSysOltMACAgingTime.setValue(mbean.getUtsPonSysOltMACAgingTime().intValue());
		tfUtsPonSysOlpMode.setSelectedIndex(getIndexFromValue(
				utsPonSysOlpModeVList, mbean.getUtsPonSysOlpMode().intValue()));
		tfUtsBBSVlanVPNTPID.setValue(Integer.toHexString(mbean.getUtsBBSVlanVPNTPID().intValue()));
		tfUtsBBSVlanVPNPRISource.setSelectedIndex(getIndexFromValue(
				utsBBSVlanVPNPRISourceVList, mbean.getUtsBBSVlanVPNPRISource()
						.intValue()));
        tfUtsBBSMaxFrameSize.setValue(mbean.getUtsBBSMaxFrameSize()
						.intValue());

	}

	public void updateModel()
	{
		GeneralConfiguration mbean = (GeneralConfiguration) getModel();

		mbean.setUtsBBSBPDUTermination(new Integer(
				utsBBSBPDUTerminationVList[tfUtsBBSBPDUTermination
						.getSelectedIndex()]));
		mbean.setUtsBBSSysSoftwareRateLimiting(new Integer(
						utsBBSSysSoftwareRateLimitingVList[tfUtsBBSSysSoftwareRateLimiting
								.getSelectedIndex()]));
//		mbean.setUtsBBSSysHardwareRateLimiting(new Integer(
//						utsBBSSysHardwareRateLimitingVList[tfUtsBBSSysHardwareRateLimiting
//								.getSelectedIndex()]));
		mbean.setUtsBBSSysCpuUtilityAlarmThresholdTotal(new Integer(
				tfUtsBBSSysCpuUtilityAlarmThresholdTotal.getValue()));
		mbean.setUtsBBSSysCpuUtilityAlarmThresholdPerTask(new Integer(
				tfUtsBBSSysCpuUtilityAlarmThresholdPerTask.getValue()));
		mbean.setUtsBBSSysMemoryUtilityAlarmThreshold(new Integer(
				tfUtsBBSSysMemoryUtilityAlarmThreshold.getValue()));
		mbean.setUtsBBSSysARPAgingTime(new Integer(tfUtsBBSSysARPAgingTime
				.getValue()));
		mbean.setUtsBBSSysMACAgingTime(new Integer(tfUtsBBSSysMACAgingTime
				.getValue()));
		mbean.setUtsPonSysLogicalPortStrictBinging(new Integer(
						utsPonSysLogicalPortStrictBingingVList[tfUtsPonSysLogicalPortStrictBinging
								.getSelectedIndex()]));
		mbean.setUtsPonSysOltMACAgingTime(new Integer(
				tfUtsPonSysOltMACAgingTime.getValue()));
		mbean.setUtsPonSysOlpMode(new Integer(
				utsPonSysOlpModeVList[tfUtsPonSysOlpMode.getSelectedIndex()]));
		mbean.setUtsBBSVlanVPNTPID(Integer.valueOf(tfUtsBBSVlanVPNTPID.getValue(),16));
        mbean.setUtsBBSMaxFrameSize(new Integer(tfUtsBBSMaxFrameSize.getValue()));
	}

	public int getIndexFromValue(int[] list, int v)
	{
		for (int i = 0; i != list.length; i++)
		{
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
