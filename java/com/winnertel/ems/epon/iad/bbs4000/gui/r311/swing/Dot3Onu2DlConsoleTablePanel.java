package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2DlConsoleTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3Onu2DlConsoleTablePanel class. Created by DVM Creator
 */
public class Dot3Onu2DlConsoleTablePanel extends UPanel {
	private JLabel tfUtsDot3Onu2Ctc3UniModuleId = new JLabel();

//	private JLabel tfUtsDot3Onu2Ctc3UniDeviceId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniLogicalPortId = new JLabel();

	private JLabel tfUtsDot3Onu2Ctc3UniPhyPortId = new JLabel();

	private int[] utsDot3Onu2DlConsoleStateVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2DlConsoleStateTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsDot3Onu2DlConsoleState = new JComboBox(
			utsDot3Onu2DlConsoleStateTList);
	private int[] utsDot3Onu2DlConsoleModeVList = new int[] { 1, 2, 4, 3, };
	private String[] utsDot3Onu2DlConsoleModeTList = new String[] {
			fStringMap.getString("tcpServer"),
			fStringMap.getString("tcpClient"),
			fStringMap.getString("settingDisable"),
			fStringMap.getString("udp"), };
	private JComboBox tfUtsDot3Onu2DlConsoleMode = new JComboBox(
			utsDot3Onu2DlConsoleModeTList);
	private int[] utsDot3Onu2DlConsoleBaudRateVList = new int[] { 11, 4, 3, 7,
			5, 12, 6, 9, 2, 1, 10, 8, };
	private String[] utsDot3Onu2DlConsoleBaudRateTList = new String[] {
			fStringMap.getString("bits57600"),
			fStringMap.getString("bits2400"), fStringMap.getString("bits1200"),
			fStringMap.getString("bits19200"),
			fStringMap.getString("bits4800"),
			fStringMap.getString("bits115200"),
			fStringMap.getString("bits9600"),
			fStringMap.getString("bits43000"), fStringMap.getString("bits600"),
			fStringMap.getString("bits300"), fStringMap.getString("bits56000"),
			fStringMap.getString("bits38400"), };
	private JComboBox tfUtsDot3Onu2DlConsoleBaudRate = new JComboBox(
			utsDot3Onu2DlConsoleBaudRateTList);
	private IntegerTextField tfUtsDot3Onu2DlConsoleDataBits = new IntegerTextField();

	private int[] utsDot3Onu2DlConsoleParityVList = new int[] { 2, 3, 1, };
	private String[] utsDot3Onu2DlConsoleParityTList = new String[] {
			fStringMap.getString("oddParity"),
			fStringMap.getString("evenParity"),
			fStringMap.getString("noParity"), };
	private JComboBox tfUtsDot3Onu2DlConsoleParity = new JComboBox(
			utsDot3Onu2DlConsoleParityTList);
	private int[] utsDot3Onu2DlConsoleStopBitsVList = new int[] { 1, 2, };
	private String[] utsDot3Onu2DlConsoleStopBitsTList = new String[] {
			fStringMap.getString("oneBit"), fStringMap.getString("twoBits"), };
	private JComboBox tfUtsDot3Onu2DlConsoleStopBits = new JComboBox(
			utsDot3Onu2DlConsoleStopBitsTList);
	private int[] utsDot3Onu2DlConsoleFlowControlVList = new int[] { 1, 3, 2, };
	private String[] utsDot3Onu2DlConsoleFlowControlTList = new String[] {
			fStringMap.getString("noControl"),
			fStringMap.getString("softwareControl"),
			fStringMap.getString("hardwareControl"), };
	private JComboBox tfUtsDot3Onu2DlConsoleFlowControl = new JComboBox(
			utsDot3Onu2DlConsoleFlowControlTList);
	private IPAddressField tfUtsDot3Onu2DlConsoleLocalIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2DlConsoleLocalPort = new IntegerTextField();

	private IPAddressField tfUtsDot3Onu2DlConsolePeerIp = new IPAddressField();

	private IntegerTextField tfUtsDot3Onu2DlConsolePeerPort = new IntegerTextField();

	private final String utsDot3Onu2Ctc3UniModuleId = fStringMap
			.getString("utsDot3Onu2Ctc3UniModuleId")
			+ " : ";
//	private final String utsDot3Onu2Ctc3UniDeviceId = fStringMap
//			.getString("utsDot3Onu2Ctc3UniDeviceId")
//			+ " : ";
	private final String utsDot3Onu2Ctc3UniPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniLogicalPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniLogicalPortId")
			+ " : ";
	private final String utsDot3Onu2Ctc3UniPhyPortId = fStringMap
			.getString("utsDot3Onu2Ctc3UniPhyPortId")
			+ " : ";

	private final String utsDot3Onu2DlConsoleState = fStringMap
			.getString("utsDot3Onu2DlConsoleState")
			+ " : ";
	private final String utsDot3Onu2DlConsoleMode = fStringMap
			.getString("utsDot3Onu2DlConsoleMode")
			+ " : ";
	private final String utsDot3Onu2DlConsoleBaudRate = fStringMap
			.getString("utsDot3Onu2DlConsoleBaudRate")
			+ " : ";
	private final String utsDot3Onu2DlConsoleDataBits = fStringMap
			.getString("utsDot3Onu2DlConsoleDataBits")
			+ " : ";
	private final String utsDot3Onu2DlConsoleParity = fStringMap
			.getString("utsDot3Onu2DlConsoleParity")
			+ " : ";
	private final String utsDot3Onu2DlConsoleStopBits = fStringMap
			.getString("utsDot3Onu2DlConsoleStopBits")
			+ " : ";
	private final String utsDot3Onu2DlConsoleFlowControl = fStringMap
			.getString("utsDot3Onu2DlConsoleFlowControl")
			+ " : ";
	private final String utsDot3Onu2DlConsoleLocalIp = fStringMap
			.getString("utsDot3Onu2DlConsoleLocalIp")
			+ " : ";
	private final String utsDot3Onu2DlConsoleLocalPort = fStringMap
			.getString("utsDot3Onu2DlConsoleLocalPort")
			+ " : ";
	private final String utsDot3Onu2DlConsolePeerIp = fStringMap
			.getString("utsDot3Onu2DlConsolePeerIp")
			+ " : ";
	private final String utsDot3Onu2DlConsolePeerPort = fStringMap
			.getString("utsDot3Onu2DlConsolePeerPort")
			+ " : ";

	public Dot3Onu2DlConsoleTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniModuleId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniModuleId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniDeviceId));
//		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniDeviceId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniLogicalPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2Ctc3UniPhyPortId));
		baseInfoPanel.add(tfUtsDot3Onu2Ctc3UniPhyPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleState));
		tfUtsDot3Onu2DlConsoleState.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleState"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleState);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleMode));
		tfUtsDot3Onu2DlConsoleMode.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleMode"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleBaudRate));
		tfUtsDot3Onu2DlConsoleBaudRate.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleBaudRate"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleBaudRate);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleDataBits));
		tfUtsDot3Onu2DlConsoleDataBits.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleDataBits"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleDataBits);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleParity));
		tfUtsDot3Onu2DlConsoleParity.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleParity"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleParity);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleStopBits));
		tfUtsDot3Onu2DlConsoleStopBits.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleStopBits"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleStopBits);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleFlowControl));
		tfUtsDot3Onu2DlConsoleFlowControl.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleFlowControl"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleFlowControl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleLocalIp));
		tfUtsDot3Onu2DlConsoleLocalIp.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleLocalIp"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleLocalIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsoleLocalPort));
		tfUtsDot3Onu2DlConsoleLocalPort.setName(fStringMap
				.getString("utsDot3Onu2DlConsoleLocalPort"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsoleLocalPort);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsolePeerIp));
		tfUtsDot3Onu2DlConsolePeerIp.setName(fStringMap
				.getString("utsDot3Onu2DlConsolePeerIp"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsolePeerIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2DlConsolePeerPort));
		tfUtsDot3Onu2DlConsolePeerPort.setName(fStringMap
				.getString("utsDot3Onu2DlConsolePeerPort"));
		baseInfoPanel.add(tfUtsDot3Onu2DlConsolePeerPort);
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

		tfUtsDot3Onu2DlConsoleDataBits.setValueScope(5, 8);

		tfUtsDot3Onu2DlConsoleLocalPort.setValueScope(1, 65535);

		tfUtsDot3Onu2DlConsolePeerPort.setValueScope(1, 65535);

	}

	public void refresh() {

		Dot3Onu2DlConsoleTable mbean = (Dot3Onu2DlConsoleTable) getModel();

		tfUtsDot3Onu2Ctc3UniModuleId.setText(mbean
				.getUtsDot3Onu2Ctc3UniModuleId().toString());
//		tfUtsDot3Onu2Ctc3UniDeviceId.setText(mbean
//				.getUtsDot3Onu2Ctc3UniDeviceId().toString());
		tfUtsDot3Onu2Ctc3UniPortId.setText(mbean.getUtsDot3Onu2Ctc3UniPortId()
				.toString());
		tfUtsDot3Onu2Ctc3UniLogicalPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniLogicalPortId().toString());
		tfUtsDot3Onu2Ctc3UniPhyPortId.setText(mbean
				.getUtsDot3Onu2Ctc3UniPhyPortId().toString());

		tfUtsDot3Onu2DlConsoleState.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleStateVList, mbean
						.getUtsDot3Onu2DlConsoleState().intValue()));
		tfUtsDot3Onu2DlConsoleMode.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleModeVList, mbean
						.getUtsDot3Onu2DlConsoleMode().intValue()));
		tfUtsDot3Onu2DlConsoleBaudRate.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleBaudRateVList, mbean
						.getUtsDot3Onu2DlConsoleBaudRate().intValue()));
		tfUtsDot3Onu2DlConsoleDataBits.setValue(mbean
				.getUtsDot3Onu2DlConsoleDataBits().intValue());
		tfUtsDot3Onu2DlConsoleParity.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleParityVList, mbean
						.getUtsDot3Onu2DlConsoleParity().intValue()));
		tfUtsDot3Onu2DlConsoleStopBits.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleStopBitsVList, mbean
						.getUtsDot3Onu2DlConsoleStopBits().intValue()));
		tfUtsDot3Onu2DlConsoleFlowControl.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2DlConsoleFlowControlVList, mbean
						.getUtsDot3Onu2DlConsoleFlowControl().intValue()));
		tfUtsDot3Onu2DlConsoleLocalIp.setValue(mbean
				.getUtsDot3Onu2DlConsoleLocalIp());
		tfUtsDot3Onu2DlConsoleLocalPort.setValue(mbean
				.getUtsDot3Onu2DlConsoleLocalPort().intValue());
		tfUtsDot3Onu2DlConsolePeerIp.setValue(mbean
				.getUtsDot3Onu2DlConsolePeerIp());
		tfUtsDot3Onu2DlConsolePeerPort.setValue(mbean
				.getUtsDot3Onu2DlConsolePeerPort().intValue());

	}

	public void updateModel() {

		Dot3Onu2DlConsoleTable mbean = (Dot3Onu2DlConsoleTable) getModel();

		mbean.setUtsDot3Onu2DlConsoleState(new Integer(
				utsDot3Onu2DlConsoleStateVList[tfUtsDot3Onu2DlConsoleState
						.getSelectedIndex()]));
		mbean.setUtsDot3Onu2DlConsoleMode(new Integer(
				utsDot3Onu2DlConsoleModeVList[tfUtsDot3Onu2DlConsoleMode
						.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2DlConsoleBaudRate(new Integer(
						utsDot3Onu2DlConsoleBaudRateVList[tfUtsDot3Onu2DlConsoleBaudRate
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2DlConsoleDataBits(new Integer(
				tfUtsDot3Onu2DlConsoleDataBits.getValue()));
		mbean.setUtsDot3Onu2DlConsoleParity(new Integer(
				utsDot3Onu2DlConsoleParityVList[tfUtsDot3Onu2DlConsoleParity
						.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2DlConsoleStopBits(new Integer(
						utsDot3Onu2DlConsoleStopBitsVList[tfUtsDot3Onu2DlConsoleStopBits
								.getSelectedIndex()]));
		mbean
				.setUtsDot3Onu2DlConsoleFlowControl(new Integer(
						utsDot3Onu2DlConsoleFlowControlVList[tfUtsDot3Onu2DlConsoleFlowControl
								.getSelectedIndex()]));
		mbean.setUtsDot3Onu2DlConsoleLocalIp(new String(
				tfUtsDot3Onu2DlConsoleLocalIp.getIPString()));
		mbean.setUtsDot3Onu2DlConsoleLocalPort(new Long(
				tfUtsDot3Onu2DlConsoleLocalPort.getValue()));
		mbean.setUtsDot3Onu2DlConsolePeerIp(new String(
				tfUtsDot3Onu2DlConsolePeerIp.getIPString()));
		mbean.setUtsDot3Onu2DlConsolePeerPort(new Long(
				tfUtsDot3Onu2DlConsolePeerPort.getValue()));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
