package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipIadTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2VoipIadTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2VoipIadTablePanel extends UPanel {

	private JLabel tfUtsDot3Onu2VoipModuleId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2VoipIadMac = new JLabel();

	private int[] utsDot3Onu2VoipIadCurrentProtocolVList = new int[] { 0, 1, };
	private String[] utsDot3Onu2VoipIadCurrentProtocolTList = new String[] {
			fStringMap.getString("h248"), fStringMap.getString("sip"), };
	private JComboBox tfUtsDot3Onu2VoipIadCurrentProtocol = new JComboBox(
			utsDot3Onu2VoipIadCurrentProtocolTList);
	private JLabel tfUtsDot3Onu2VoipIadSwVerion = new JLabel();

	private JLabel tfUtsDot3Onu2VoipIadSwDate = new JLabel();

	private JLabel tfUtsDot3Onu2VoipIadPortNum = new JLabel();

	private int[] utsDot3Onu2VoipIadOperStatusVList = new int[] { 3, 0, 4, 2,
			1, };
	private String[] utsDot3Onu2VoipIadOperStatusTList = new String[] {
			fStringMap.getString("de-register"),
			fStringMap.getString("registering"),
			fStringMap.getString("iadRebooting"),
			fStringMap.getString("iadFault"),
			fStringMap.getString("registered"), };
	private JComboBox tfUtsDot3Onu2VoipIadOperStatus = new JComboBox(
			utsDot3Onu2VoipIadOperStatusTList);
	private int[] utsDot3Onu2VoipIadOperationVList = new int[] { 0, 2, 1, };
	private String[] utsDot3Onu2VoipIadOperationTList = new String[] {
			fStringMap.getString("reregisterToSoftswitch"),
			fStringMap.getString("voiceModuleReset"),
			fStringMap.getString("deregisterFromSoftswitch"), };
	private JComboBox tfUtsDot3Onu2VoipIadOperation = new JComboBox(
			utsDot3Onu2VoipIadOperationTList);
	private int[] utsDot3Onu2VoipIadConfiguredProtocolVList = new int[] { 3, 2, };
	private String[] utsDot3Onu2VoipIadConfiguredProtocolTList = new String[] {
			fStringMap.getString("h248"), fStringMap.getString("sip"), };
	private JComboBox tfUtsDot3Onu2VoipIadConfiguredProtocol = new JComboBox(
			utsDot3Onu2VoipIadConfiguredProtocolTList);

	private final String utsDot3Onu2VoipModuleId = fStringMap
			.getString("utsDot3Onu2VoipModuleId")
			+ " : ";
	private final String utsDot3Onu2VoipDeviceId = fStringMap
			.getString("utsDot3Onu2VoipDeviceId")
			+ " : ";
	private final String utsDot3Onu2VoipPortId = fStringMap
			.getString("utsDot3Onu2VoipPortId")
			+ " : ";
	private final String utsDot3Onu2VoipLogicalPortId = fStringMap
			.getString("utsDot3Onu2VoipLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2VoipIadMac = fStringMap
			.getString("utsDot3Onu2VoipIadMac")
			+ " : ";
	private final String utsDot3Onu2VoipIadCurrentProtocol = fStringMap
			.getString("utsDot3Onu2VoipIadCurrentProtocol")
			+ " : ";
	private final String utsDot3Onu2VoipIadSwVerion = fStringMap
			.getString("utsDot3Onu2VoipIadSwVerion")
			+ " : ";
	private final String utsDot3Onu2VoipIadSwDate = fStringMap
			.getString("utsDot3Onu2VoipIadSwDate")
			+ " : ";
	private final String utsDot3Onu2VoipIadPortNum = fStringMap
			.getString("utsDot3Onu2VoipIadPortNum")
			+ " : ";
	private final String utsDot3Onu2VoipIadOperStatus = fStringMap
			.getString("utsDot3Onu2VoipIadOperStatus")
			+ " : ";
	private final String utsDot3Onu2VoipIadOperation = fStringMap
			.getString("utsDot3Onu2VoipIadOperation")
			+ " : ";
	private final String utsDot3Onu2VoipIadConfiguredProtocol = fStringMap
			.getString("utsDot3Onu2VoipIadConfiguredProtocol")
			+ " : ";

	public Dot3Onu2VoipIadTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2VoipDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2VoipLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadMac));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadMac);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadCurrentProtocol));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadCurrentProtocol);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadSwVerion));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadSwVerion);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadSwDate));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadSwDate);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadPortNum));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadPortNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadOperStatus));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadOperStatus);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadOperation));
		tfUtsDot3Onu2VoipIadOperation.setName(fStringMap
				.getString("utsDot3Onu2VoipIadOperation"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadOperation);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2VoipIadConfiguredProtocol));
		tfUtsDot3Onu2VoipIadConfiguredProtocol.setName(fStringMap
				.getString("utsDot3Onu2VoipIadConfiguredProtocol"));
		baseInfoPanel.add(tfUtsDot3Onu2VoipIadConfiguredProtocol);
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

//		tfUtsDot3Onu2VoipIadMac.setEditable(false);

	}

	public void refresh() {

		Dot3Onu2VoipIadTable mbean = (Dot3Onu2VoipIadTable) getModel();

		tfUtsDot3Onu2VoipModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId()
				.toString());
		tfUtsDot3Onu2VoipDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId()
				.toString());
		tfUtsDot3Onu2VoipPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId()
				.toString());
		tfUtsDot3Onu2VoipLogicalPortId.setText(mbean
				.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());
		tfUtsDot3Onu2VoipIadMac.setText(OctetToMacAddress(mbean.getUtsDot3Onu2CtcIadInfoMacAddr()));
		tfUtsDot3Onu2VoipIadCurrentProtocol.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipIadCurrentProtocolVList, mbean
						.getUtsDot3Onu2CtcIadInfoSupportedProtocol().intValue()));
		tfUtsDot3Onu2VoipIadCurrentProtocol.setEnabled(false);
		tfUtsDot3Onu2VoipIadSwVerion.setText(mbean
				.getUtsDot3Onu2CtcIadInfoSoftwareVer());
		tfUtsDot3Onu2VoipIadSwDate.setText(mbean.getUtsDot3Onu2CtcIadInfoSoftwareDate());
		tfUtsDot3Onu2VoipIadPortNum.setText(mbean
				.getUtsDot3Onu2CtcIadInfoVoipUserCount().toString());
		tfUtsDot3Onu2VoipIadOperStatus.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipIadOperStatusVList, mbean
						.getUtsDot3Onu2CtcH248IadOperationStaus().intValue()));
		tfUtsDot3Onu2VoipIadOperStatus.setEnabled(false);
		tfUtsDot3Onu2VoipIadOperation.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2VoipIadOperationVList, mbean
						.getUtsDot3Onu2CtcIadOperation().intValue()));
		tfUtsDot3Onu2VoipIadConfiguredProtocol
				.setSelectedIndex(getIndexFromValue(
						utsDot3Onu2VoipIadConfiguredProtocolVList, mbean
								.getUtsDot3Onu2CtcConfiguredVoipProtocol()
								.intValue()));

	}

	public void updateModel() {

		Dot3Onu2VoipIadTable mbean = (Dot3Onu2VoipIadTable) getModel();

		mbean.setUtsDot3Onu2CtcIadOperation(new Integer(
				utsDot3Onu2VoipIadOperationVList[tfUtsDot3Onu2VoipIadOperation
						.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2CtcConfiguredVoipProtocol(new Integer(
						utsDot3Onu2VoipIadConfiguredProtocolVList[tfUtsDot3Onu2VoipIadConfiguredProtocol
								.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	public static String OctetToMacAddress(byte[] value) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            byte b = value[i];
            if (b >= 0 && b < 16) {
                sb.append('0');
            }

            int bi = value[i] & 0xff;
            sb.append(Integer.toHexString(bi).toUpperCase());

            if (i < value.length - 1) {
                sb.append(":");
            }
        }

        return sb.toString();
    }

}
