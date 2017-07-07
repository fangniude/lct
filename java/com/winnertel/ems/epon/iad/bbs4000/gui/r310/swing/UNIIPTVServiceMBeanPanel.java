package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanListPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UNIIPTVServiceMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UNIIPTVServiceMBeanPanel extends UPanel implements ActionListener {

	private JLabel tfUtsDot3OnuModuleId = new JLabel();
	// private JLabel tfUtsDot3OnuDeviceId = new JLabel();

	private JLabel tfUtsDot3OnuPortId = new JLabel();

	private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

	private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

	private IntegerTextField tfUtsDot3OnuEtherPortMaxMVlanNum = new IntegerTextField();

	private IntegerTextField tfUtsDot3OnuEtherPortMaxMcGroupNum = new IntegerTextField();

	private int[] utsDot3OnuEtherPortMcTagStripeVList = new int[] { 1, 2, 3 };
	private String[] utsDot3OnuEtherPortMcTagStripeTList = new String[] {
			fStringMap.getString("stripe"), fStringMap.getString("noStripe"),
			fStringMap.getString("translate"), };
	private JComboBox tfUtsDot3OnuEtherPortMcTagStripe = new JComboBox(
			utsDot3OnuEtherPortMcTagStripeTList);

	private JComboBox tfUtsDot3OnuEtherPortMcTagStripeNumber = new JComboBox();

	private IntegerTextField[] stripeVlanList = new IntegerTextField[16];

	private Dot3OnuEtherPortVlanListPanel vlanListPanel = null;

	private final String utsDot3OnuModuleId = fStringMap
			.getString("utsDot3OnuModuleId")
			+ ": ";
	// private final String utsDot3OnuDeviceId =
	// fStringMap.getString("utsDot3OnuDeviceId") + ": ";
	private final String utsDot3OnuPortId = fStringMap
			.getString("utsDot3OnuPortId")
			+ ": ";
	private final String utsDot3OnuLogicalPortId = fStringMap
			.getString("utsDot3OnuLogicalPortId")
			+ ": ";
	private final String utsDot3OnuEtherPortIndex = fStringMap
			.getString("utsDot3OnuEtherPortIndex")
			+ ": ";
	private final String utsDot3OnuEtherPortMaxMVlanNum = fStringMap
			.getString("utsDot3OnuEtherPortMaxMVlanNum")
			+ ": ";
	private final String utsDot3OnuEtherPortMaxMcGroupNum = fStringMap
			.getString("utsDot3OnuEtherPortMaxMcGroupNum")
			+ ": ";
	private final String utsDot3OnuEtherPortMcTagStripe = fStringMap
			.getString("utsDot3OnuEtherPortMcTagStripe")
			+ ": ";
	private final String utsDot3OnuEtherPortMcTagStripeNumber = fStringMap
			.getString("utsDot3OnuEtherPortMcTagStripeNumber")
			+ ": ";
	private JLabel[] stripeVlanLabelList = new JLabel[16];

	public UNIIPTVServiceMBeanPanel(IApplication app) {
		super(app);
		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 5, NTLayout.FILL, NTLayout.CENTER, 5, 3);
		layout.setMargins(3, 5, 3, 5);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
		baseInfoPanel.add(tfUtsDot3OnuModuleId);

		baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
		baseInfoPanel.add(tfUtsDot3OnuPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMaxMVlanNum));
		tfUtsDot3OnuEtherPortMaxMVlanNum.setName(fStringMap
				.getString("utsDot3OnuEtherPortMaxMVlanNum"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortMaxMVlanNum);

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMaxMcGroupNum));
		tfUtsDot3OnuEtherPortMaxMcGroupNum.setName(fStringMap
				.getString("utsDot3OnuEtherPortMaxMcGroupNum"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortMaxMcGroupNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMcTagStripe));
		tfUtsDot3OnuEtherPortMcTagStripe.setName(fStringMap
				.getString("utsDot3OnuEtherPortMcTagStripe"));
		tfUtsDot3OnuEtherPortMcTagStripe.addActionListener(this);
		baseInfoPanel.add(tfUtsDot3OnuEtherPortMcTagStripe);
		
		for (int i = 1; i < 9; i++) {
			tfUtsDot3OnuEtherPortMcTagStripeNumber.addItem(i);
		}

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMcTagStripeNumber));
		tfUtsDot3OnuEtherPortMcTagStripeNumber.setName(fStringMap
				.getString("utsDot3OnuEtherPortMcTagStripeNumber"));
		tfUtsDot3OnuEtherPortMcTagStripeNumber.addActionListener(this);
		baseInfoPanel.add(tfUtsDot3OnuEtherPortMcTagStripeNumber);
		baseInfoPanel.add(new HSpacer());

		JPanel entryVlanPanel = new JPanel();
		layout = new NTLayout(8, 5, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(3, 10, 3, 10);
		entryVlanPanel.setLayout(layout);
		entryVlanPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("utsDot3OnuEtherPortMcTagStripeEntry")));
		for (int i = 0; i < 8; i++) {
			stripeVlanList[i * 2] = new IntegerTextField();
			stripeVlanList[i * 2 + 1] = new IntegerTextField();

			stripeVlanLabelList[i * 2] = new JLabel(fStringMap
					.getString("multicast_vlan")
					+ (i + 1));
			stripeVlanLabelList[i * 2 + 1] = new JLabel(fStringMap
					.getString("user_vlan")
					+ (i + 1));

			entryVlanPanel.add(stripeVlanLabelList[i * 2]);
			entryVlanPanel.add(stripeVlanList[i * 2]);
			entryVlanPanel.add(stripeVlanLabelList[i * 2 + 1]);
			entryVlanPanel.add(stripeVlanList[i * 2 + 1]);
			entryVlanPanel.add(new HSpacer());
		}

		vlanListPanel = new Dot3OnuEtherPortVlanListPanel(fApplication);
		vlanListPanel.setPreferredSize(new Dimension(400, 210));
		// baseInfoPanel.add(new
		// JLabel(fStringMap.getString("Multicast_Vlan_Panel")));
		vlanListPanel.setName(fStringMap.getString("Multicast_Vlan_Panel"));

		JPanel allPanel = new JPanel();
		layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(3, 10, 3, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(entryVlanPanel);
		allPanel.add(new JLabel(fStringMap.getString("Multicast_Vlan_List")
				+ ":"));
		allPanel.add(vlanListPanel);
//		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
	}

	protected void initForm() {
		tfUtsDot3OnuEtherPortMaxMcGroupNum.setValueScope(4, 1024);

		for (int i = 0; i < stripeVlanList.length; i++) {
			stripeVlanList[i].setValueScope(1, 4094);
		}

		tfUtsDot3OnuEtherPortMcTagStripeNumber.setSelectedIndex(0);
	}

	public boolean validateFrom() {
		if (tfUtsDot3OnuEtherPortMcTagStripeNumber.isEnabled()) {
			Integer num = (Integer) tfUtsDot3OnuEtherPortMcTagStripeNumber
					.getSelectedItem();

			if (num != null) {
				for (int i = 0; i < num; i++) {
					int mvlan = stripeVlanList[i * 2].getValue();
					int uvlan = stripeVlanList[i * 2 + 1].getValue();
					if (mvlan == 0) {
						MessageDialog
								.showInfoMessageDialog(
										fApplication,
										fStringMap.getString("multicast_vlan")
												+ fStringMap
														.getString("Err_Multicast_Vlan_Value"));
						return false;
					}
					if (uvlan == 0) {
						MessageDialog
								.showInfoMessageDialog(
										fApplication,
										fStringMap.getString("user_vlan")
												+ fStringMap
														.getString("Err_User_Vlan_Value"));
						return false;
					}
				}
			}
		}
        
        return true;
	}

	public void refresh() {
		for (int i = 0; i < stripeVlanList.length; i++) {
			stripeVlanList[i].setText("");
		}
		
		UNIIPTVServiceMBean mbean = (UNIIPTVServiceMBean) getModel();

		tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
		// tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
		tfUtsDot3OnuPortId.setText("" + mbean.getUtsDot3OnuPortId());
		// tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
		tfUtsDot3OnuLogicalPortId.setText(""
				+ mbean.getUtsDot3OnuLogicalPortId());
		tfUtsDot3OnuEtherPortIndex.setText(""
				+ mbean.getUtsDot3OnuEtherPortIndex());
		tfUtsDot3OnuEtherPortMaxMVlanNum.setValue(mbean
				.getUtsDot3OnuEtherPortMaxMVlanNum().intValue());
		tfUtsDot3OnuEtherPortMaxMVlanNum.setEnabled(false);
		tfUtsDot3OnuEtherPortMaxMcGroupNum.setValue(mbean
				.getUtsDot3OnuEtherPortMaxMcGroupNum().intValue());
		vlanListPanel.setMulticastVlanList(mbean
				.getUtsDot3OnuEtherPortMVlanList());
		tfUtsDot3OnuEtherPortMcTagStripe.setSelectedIndex(getIndexFromValue(
				utsDot3OnuEtherPortMcTagStripeVList, mbean
						.getUtsDot3OnuEtherPortMcTagStripe()));
		vlanListPanel.setMulticastVlanList(mbean
				.getUtsDot3OnuEtherPortMVlanList());

		if (mbean.getUtsDot3OnuEtherPortMcTagStripeNumber() != null) {
			tfUtsDot3OnuEtherPortMcTagStripeNumber.setSelectedItem(mbean
					.getUtsDot3OnuEtherPortMcTagStripeNumber());
		}
		setStripeEntry(mbean.getUtsDot3OnuEtherPortMcTagStripeEntry());
	}

	public void updateModel() {
		UNIIPTVServiceMBean mbean = (UNIIPTVServiceMBean) getModel();

		mbean.setUtsDot3OnuEtherPortMaxMcGroupNum(new Integer(
				tfUtsDot3OnuEtherPortMaxMcGroupNum.getValue()));
		mbean.setUtsDot3OnuEtherPortMVlanList(vlanListPanel
				.getMulticastVlanList());
		mbean
				.setUtsDot3OnuEtherPortMcTagStripe(utsDot3OnuEtherPortMcTagStripeVList[tfUtsDot3OnuEtherPortMcTagStripe
						.getSelectedIndex()]);
		if (tfUtsDot3OnuEtherPortMcTagStripeNumber.isEnabled()
				&& tfUtsDot3OnuEtherPortMcTagStripeNumber.getSelectedItem() != null) {
			mbean
					.setUtsDot3OnuEtherPortMcTagStripeNumber((Integer) tfUtsDot3OnuEtherPortMcTagStripeNumber
							.getSelectedItem());
			mbean.setUtsDot3OnuEtherPortMcTagStripeEntry(getStripeEntry());
		}
	}

	private byte[] getStripeEntry() {
		byte[] entry = new byte[32];

		Integer num = (Integer) tfUtsDot3OnuEtherPortMcTagStripeNumber
				.getSelectedItem();

		if (num != null) {
			for (int i = 0; i < num; i++) {
				int mvlan = stripeVlanList[i * 2].getValue();
				int uvlan = stripeVlanList[i * 2 + 1].getValue();

				entry[i * 4] = (byte) ((mvlan & 0xFF00) >> 8);
				entry[i * 4 + 1] = (byte) (mvlan & 0xFF);
				entry[i * 4 + 2] = (byte) ((uvlan & 0xFF00) >> 8);
				entry[i * 4 + 3] = (byte) (uvlan & 0xFF);
			}
		}

		return entry;
	}

	private void setStripeEntry(byte[] entry) {
		if (entry == null || entry.length < 32)
			return;

		for (int i = 0; i < 8; i++) {
			stripeVlanList[i * 2].setValue(((entry[i * 4] & 0xFF) << 8)
					| (entry[i * 4 + 1] & 0xFF));
			stripeVlanList[i * 2 + 1].setValue(((entry[i * 4 + 2] & 0xFF) << 8)
					| (entry[i * 4 + 3] & 0xFF));
		}
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfUtsDot3OnuEtherPortMcTagStripe) {
			fireSelectedItemChangedEvent();
		}

		if (e.getSource() == tfUtsDot3OnuEtherPortMcTagStripeNumber) {
			fireSelectedItemChangedEvent();
		}
	}

	private void fireSelectedItemChangedEvent() {
		boolean enable = tfUtsDot3OnuEtherPortMcTagStripe.getSelectedIndex() == 2;
		int number = tfUtsDot3OnuEtherPortMcTagStripeNumber.getSelectedIndex();

		tfUtsDot3OnuEtherPortMcTagStripeNumber.setEnabled(enable);
		for (int i = 0; i < 8; i++) {
			stripeVlanLabelList[i * 2].setEnabled(i <= number && enable);
			stripeVlanList[i * 2].setEnabled(i <= number && enable);

			stripeVlanLabelList[i * 2 + 1].setEnabled(i <= number && enable);
			stripeVlanList[i * 2 + 1].setEnabled(i <= number && enable);
		}
	}

}