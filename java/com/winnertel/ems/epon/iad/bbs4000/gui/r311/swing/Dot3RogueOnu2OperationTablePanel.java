package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PortDiagnosisTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2CapabilitiesTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2OperationTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Dot3RogueOnu2OperationTablePanel extends UPanel {
	
	private IntegerTextField tfUtsDot3Onu2PowerControlActions = new IntegerTextField();

	private int[] utsDot3Onu2PowerControlModeVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2PowerControlModeTList = new String[] {
			fStringMap.getString("unicast-llid"),
			fStringMap.getString("broadcast-llid"), };
	private JComboBox tfUtsDot3Onu2PowerControlMode = new JComboBox(
			utsDot3Onu2PowerControlModeTList);
	private JComboBox tfUtsDot3Onu2PowerControlOnuId = new JComboBox();

	private int[] utsDot3Onu2PowerControlTxIdVList = new int[] { 1, 3, 2, };
	private String[] utsDot3Onu2PowerControlTxIdTList = new String[] {
			fStringMap.getString("active-tx"), fStringMap.getString("both-tx"),
			fStringMap.getString("standby-tx"), };
	private JComboBox tfUtsDot3Onu2PowerControlTxId = new JComboBox(
			utsDot3Onu2PowerControlTxIdTList);
	
//	private int[] shutdownIdVList = new int[] { 1, 2, };
	private String[] shutdownIdTList = new String[] {
			fStringMap.getString("ShutdownTemporarily"), fStringMap.getString("ShutdownPermanently"), };
	private JComboBox tfshutdownId = new JComboBox(shutdownIdTList);

	private final String utsDot3Onu2PowerControlActions = fStringMap
			.getString("utsDot3Onu2PowerControlActions")
			+ " : ";
	private final String utsDot3RogueOnu2PowerControlActions = fStringMap
			.getString("utsDot3RogueOnu2PowerControlActions")
			+ " : ";

	private final String utsDot3Onu2PowerControlMode = fStringMap
			.getString("utsDot3Onu2PowerControlMode")
			+ " : ";
	private final String utsDot3Onu2PowerControlOnuId = fStringMap
			.getString("utsDot3Onu2PowerControlOnuId")
			+ " : ";
	private final String utsDot3Onu2PowerControlTxId = fStringMap
			.getString("utsDot3Onu2PowerControlTxId")
			+ " : ";
	
	Map rogueOnuList = new HashMap();

	public Dot3RogueOnu2OperationTablePanel(IApplication app) {
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
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlOnuId));
		tfUtsDot3Onu2PowerControlOnuId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlOnuId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlOnuId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3RogueOnu2PowerControlActions));
		tfshutdownId.setName(fStringMap
				.getString("utsDot3RogueOnu2PowerControlActions"));
		baseInfoPanel.add(tfshutdownId);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlActions));
		tfUtsDot3Onu2PowerControlActions.setName(fStringMap
				.getString("utsDot3Onu2PowerControlActions"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlActions);
		baseInfoPanel.add(new HSpacer());


		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlMode));
		tfUtsDot3Onu2PowerControlMode.setName(fStringMap
				.getString("utsDot3Onu2PowerControlMode"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2PowerControlTxId));
		tfUtsDot3Onu2PowerControlTxId.setName(fStringMap
				.getString("utsDot3Onu2PowerControlTxId"));
		baseInfoPanel.add(tfUtsDot3Onu2PowerControlTxId);
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
		tfUtsDot3Onu2PowerControlActions.setValueScope(1, 65534);
		tfshutdownId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tfshutdownId.getSelectedIndex() == 0) {
					tfUtsDot3Onu2PowerControlActions.setEnabled(true);
				}
				else {
					tfUtsDot3Onu2PowerControlActions.setEnabled(false);
				}
			}
		});

	}


	public void refresh() {

		Dot3Olt2PortDiagnosisTable mbean = (Dot3Olt2PortDiagnosisTable) getModel();
		
		//0007ba397134,0007ba397134
		byte[] onus = mbean.getUtsDot3OltPortLaserAlwaysOnOnuLocationRogueOnu();
		tfUtsDot3Onu2PowerControlOnuId.removeAllItems();
		
		List<String> macList = new ArrayList<String>();
		for(int i = 0; onus!=null && onus.length > 12 && i < onus.length; i = i + 13) {
			byte[] mac = new byte[12];
			System.arraycopy(onus, i, mac, 0, 12);
			String smac = Byte.toString(mac[11]) + Byte.toString(mac[10]) + "-" + Byte.toString(mac[9]) + Byte.toString(mac[8]) + "-" +
				Byte.toString(mac[7]) + Byte.toString(mac[6]) + "-" + Byte.toString(mac[5]) + Byte.toString(mac[4]) + "-" + 
				Byte.toString(mac[3]) + Byte.toString(mac[2]) + "-" + Byte.toString(mac[1]) + Byte.toString(mac[0]);
			macList.add(smac);
			tfUtsDot3Onu2PowerControlOnuId.addItem(smac);
		}
		rogueOnuList.clear();
		if (macList.size() != 0) {
			try {
				Dot3Onu2CtcTable ctcBean = new Dot3Onu2CtcTable(fApplication
						.getSnmpProxy());
				Vector ctcVect = ctcBean.retrieveAll();

				for (int i = 0; i < ctcVect.size(); i++) {
					Dot3Onu2CtcTable tBean = (Dot3Onu2CtcTable) ctcVect.get(i);
					String mac = com.winnertel.ems.epon.iad.bbs4000.formatter.r200.Dot3Onu2CtcSerialNumberFormatter
							.getMacAddress(tBean.getUtsDot3Onu2CtcOnuMacAddr());
					for (String tmac : macList) {
						if (tmac.equalsIgnoreCase(mac)
								&& tBean.getUtsDot3Onu2CtcRegisterStatus() == 1)
							rogueOnuList.put(mac, tBean);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		tfUtsDot3Onu2PowerControlMode.setSelectedIndex(0); //���е���LLID
//		tfUtsDot3Onu2PowerControlMode.setEnabled(false);
		tfUtsDot3Onu2PowerControlTxId.setSelectedIndex(0);

	}
	
	public boolean validateFrom() {
		//��ѯONU������: 
		try {
			if(rogueOnuList.get(tfUtsDot3Onu2PowerControlOnuId.getSelectedItem().toString()) == null) {
				String msg = fStringMap.getString("Error_RogueONU_Shutdown");
				MessageDialog.showErrorMessageDialog(fApplication, msg);
				return false;
			}
			
			Dot3Onu2CtcTable tBean = (Dot3Onu2CtcTable) rogueOnuList.get(tfUtsDot3Onu2PowerControlOnuId.getSelectedItem().toString());
			Dot3Onu2CapabilitiesTable cBean = new Dot3Onu2CapabilitiesTable(fApplication.getSnmpProxy());
			cBean.setUtsDot3Onu2CapabilitiesModuleId(tBean.getUtsDot3Onu2CtcModuleId());
			cBean.setUtsDot3Onu2CapabilitiesDeviceId(tBean.getUtsDot3Onu2CtcDeviceId());
			cBean.setUtsDot3Onu2CapabilitiesPortId(tBean.getUtsDot3Onu2CtcPortId());
			cBean.setUtsDot3Onu2CapabilitiesLogicalPortId(tBean.getUtsDot3Onu2CtcLogicalPortId());
			cBean.retrieve();
			if(cBean.getUtsDot3Onu2CapabilitiesVersion() == 1 || cBean.getUtsDot3Onu2CapabilitiesVersion() == 3)
				return true;
			else {
				String msg = fStringMap.getString("Error_Capabilities_Version_Shutdown");
				MessageDialog.showErrorMessageDialog(fApplication, msg);
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        return true;
    }

	public void updateModel() {

//		Dot3Onu2OperationTable mbean = (Dot3Onu2OperationTable) getModel();
		Dot3Onu2OperationTable mbean = new Dot3Onu2OperationTable(fApplication.getSnmpProxy());

		Dot3Onu2CtcTable tBean = (Dot3Onu2CtcTable) rogueOnuList.get(tfUtsDot3Onu2PowerControlOnuId.getSelectedItem().toString());
		
		mbean.setUtsDot3Onu2MacAgingTimeModuleId(tBean.getUtsDot3Onu2CtcModuleId());
		mbean.setUtsDot3Onu2MacAgingTimeDeviceId(tBean.getUtsDot3Onu2CtcDeviceId());
		mbean.setUtsDot3Onu2MacAgingTimePortId(tBean.getUtsDot3Onu2CtcPortId());
		mbean.setUtsDot3Onu2MacAgingTimeLogicalPortId(tBean.getUtsDot3Onu2CtcLogicalPortId());
		
		if(tfshutdownId.getSelectedIndex() == 0) {
			mbean.setUtsDot3Onu2PowerControlActions(new Integer(
					tfUtsDot3Onu2PowerControlActions.getValue()));
		}
		else {
			mbean.setUtsDot3Onu2PowerControlActions(65535);
		}
		mbean.setUtsDot3Onu2PowerControlMode(new Integer(
				utsDot3Onu2PowerControlModeVList[tfUtsDot3Onu2PowerControlMode
						.getSelectedIndex()]));
//		if(tfUtsDot3Onu2PowerControlOnuId.isEnabled()) {
//			mbean.setUtsDot3Onu2PowerControlOnuId(tfUtsDot3Onu2PowerControlOnuId
//				.getValue());
//		}
		mbean.setUtsDot3Onu2PowerControlTxId(new Integer(
				utsDot3Onu2PowerControlTxIdVList[tfUtsDot3Onu2PowerControlTxId
						.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
