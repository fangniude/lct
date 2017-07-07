package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.Dot3OnuEtherPortVlanN1Panel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.Dot3OnuEtherPortVlanTrunkPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UNIDataServiceMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class UNIDataServiceMBeanPanel extends UPanel implements ActionListener {
	private JLabel tfUtsDot3OnuModuleId = new JLabel();

//	private Integer[] portList = new Integer[] { 1, 2, 3, 4 };
	private JLabel tfUtsDot3OnuPortId = new JLabel();

	private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();

	private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

	private int[] utsDot3OnuEtherPortPhyAdminCtrlVList = new int[] { 2, 1, };
	private String[] utsDot3OnuEtherPortPhyAdminCtrlTList = new String[] {
			fStringMap.getString("activate"),
			fStringMap.getString("deactivate"), };
	private JComboBox tfUtsDot3OnuEtherPortPhyAdminCtrl = new JComboBox(
			utsDot3OnuEtherPortPhyAdminCtrlTList);

	private int[] utsDot3OnuEtherPortAutoNegAdminCtrlVList = new int[] { 2, 1, };
	private String[] utsDot3OnuEtherPortAutoNegAdminCtrlTList = new String[] {
			fStringMap.getString("activate"),
			fStringMap.getString("deactivate"), };
	private JComboBox tfUtsDot3OnuEtherPortAutoNegAdminCtrl = new JComboBox(
			utsDot3OnuEtherPortAutoNegAdminCtrlTList);

	private int[] utsDot3OnuEtherPortPauseVList = new int[] { 1, 2, };
	private String[] utsDot3OnuEtherPortPauseTList = new String[] {
			fStringMap.getString("disable"), fStringMap.getString("enable"), };
	private JComboBox tfUtsDot3OnuEtherPortPause = new JComboBox(
			utsDot3OnuEtherPortPauseTList);

	private int[] utsDot3OnuEtherPortPolicingEnableVList = new int[] { 1, 2, };
	private String[] utsDot3OnuEtherPortPolicingEnableTList = new String[] {
			fStringMap.getString("enable"), fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OnuEtherPortPolicingEnable = new JComboBox(
			utsDot3OnuEtherPortPolicingEnableTList);

	private JComboBox tfUtsDot3OnuEtherPortPolicingCIR = null;

	private JComboBox tfUtsDot3OnuEtherPortPolicingCBS = null;

	private IntegerTextField tfUtsDot3OnuEtherPortPolicingEBS = new IntegerTextField();

	private int[] utsDot3OnuEtherPortVlanModeVList = new int[] { 1, 2, 3, /** 4,*/ 5,
			6 };
	private String[] utsDot3OnuEtherPortVlanModeTList = new String[] {
			fStringMap.getString("transparent"), fStringMap.getString("tag"),
			fStringMap.getString("translation"),
//			fStringMap.getString("vlanStacking"),
			fStringMap.getString("n1aggregation"),
			fStringMap.getString("trunk") };
	private JComboBox tfUtsDot3OnuEtherPortVlanMode = new JComboBox(
			utsDot3OnuEtherPortVlanModeTList);

	private IntegerTextField tfUtsDot3OnuEtherPortVlanTag = new IntegerTextField();

	private StringTextField tfUtsDot3OnuEtherPortVlanTPID = new StringTextField();

	private JComboBox tfUtsDot3OnuEtherPortVlanNaggregationNumber = new JComboBox();

	private int[] vList = new int[] { 1, 2, };
	private String[] tList = new String[] { fStringMap.getString("enable"),
			fStringMap.getString("disable"), };
	private JComboBox tfUtsDot3OnuEtherPortDSPolicingEnable = new JComboBox(
			tList);

	private JComboBox tfUtsDot3OnuEtherPortDSPolicingCIR = null;

	private JComboBox tfUtsDot3OnuEtherPortDSPolicingPIR = null;

	private Dot3OnuEtherPortVlanPanel vlanPanel = null;
	private Dot3OnuEtherPortVlanN1Panel[] n1PanelList = new Dot3OnuEtherPortVlanN1Panel[6];
	private Dot3OnuEtherPortVlanTrunkPanel trunkPanel = null;

	JTabbedPane tabbedPane = null;

	private final String utsDot3OnuModuleId = fStringMap
			.getString("utsDot3OnuModuleId")
			+ " : ";
	private final String utsDot3OnuPortId = fStringMap
			.getString("utsDot3OnuPortId")
			+ " : ";
	private final String utsDot3OnuLogicalPortId = fStringMap
			.getString("utsDot3OnuLogicalPortId")
			+ " : ";
	private final String utsDot3OnuEtherPortIndex = fStringMap
			.getString("utsDot3OnuEtherPortIndex")
			+ " : ";

	private final String utsDot3OnuEtherPortPhyAdminCtrl = fStringMap
			.getString("utsDot3OnuEtherPortPhyAdminCtrl")
			+ " : ";
	private final String utsDot3OnuEtherPortAutoNegAdminCtrl = fStringMap
			.getString("utsDot3OnuEtherPortAutoNegAdminCtrl")
			+ " : ";
	private final String utsDot3OnuEtherPortPause = fStringMap
			.getString("utsDot3OnuEtherPortPause")
			+ " : ";
	private final String utsDot3OnuEtherPortPolicingEnable = fStringMap
			.getString("utsDot3OnuEtherPortPolicingEnable")
			+ " : ";
	private final String utsDot3OnuEtherPortPolicingCIR = fStringMap
			.getString("utsDot3OnuEtherPortPolicingCIR")
			+ " : ";
	private final String utsDot3OnuEtherPortPolicingCBS = fStringMap
			.getString("utsDot3OnuEtherPortPolicingCBS")
			+ " : ";
	private final String utsDot3OnuEtherPortPolicingEBS = fStringMap
			.getString("utsDot3OnuEtherPortPolicingEBS")
			+ " : ";

	private final String utsDot3OnuEtherPortVlanMode = fStringMap
			.getString("utsDot3OnuEtherPortVlanMode")
			+ " : ";
	private final String utsDot3OnuEtherPortVlanTag = fStringMap
			.getString("utsDot3OnuEtherPortVlanTag")
			+ " : ";
	private final String utsDot3OnuEtherPortVlanTPID = fStringMap
			.getString("utsDot3OnuEtherPortVlanTPID")
			+ " : ";
	private final String utsDot3OnuEtherPortVlanNaggregationNumber = fStringMap
			.getString("utsDot3OnuEtherPortVlanNaggregationNumber")
			+ " : ";

	private final String utsDot3OnuEtherPortDSPolicingEnable = fStringMap
			.getString("utsDot3OnuEtherPortDSPolicingEnable")
			+ " : ";
	private final String utsDot3OnuEtherPortDSPolicingCIR = fStringMap
			.getString("utsDot3OnuEtherPortDSPolicingCIR")
			+ " : ";
	private final String utsDot3OnuEtherPortDSPolicingPIR = fStringMap
			.getString("utsDot3OnuEtherPortDSPolicingPIR")
			+ " : ";

//	BBS4000NE bbs4000NE;

	public UNIDataServiceMBeanPanel(IApplication app) {
		super(app);

//		bbs4000NE = new BBS4000NE(app);

		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(18, 3, NTLayout.FILL, NTLayout.TOP, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
		baseInfoPanel.add(tfUtsDot3OnuModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
		baseInfoPanel.add(tfUtsDot3OnuPortId);
		baseInfoPanel.add(new HSpacer());

//		tfUtsDot3OnuLogicalPortId.setModel(new DefaultComboBoxModel(
//				getLogicalPortList()));
		baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPhyAdminCtrl));
		tfUtsDot3OnuEtherPortPhyAdminCtrl.setName(fStringMap
				.getString("utsDot3OnuEtherPortPhyAdminCtrl"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPhyAdminCtrl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortAutoNegAdminCtrl));
		tfUtsDot3OnuEtherPortAutoNegAdminCtrl.setName(fStringMap
				.getString("utsDot3OnuEtherPortAutoNegAdminCtrl"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortAutoNegAdminCtrl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPause));
		tfUtsDot3OnuEtherPortPause.setName(fStringMap
				.getString("utsDot3OnuEtherPortPause"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPause);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanMode));
		tfUtsDot3OnuEtherPortVlanMode.setName(fStringMap
				.getString("utsDot3OnuEtherPortVlanMode"));
		tfUtsDot3OnuEtherPortVlanMode.addActionListener(this);
		baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTag));
		tfUtsDot3OnuEtherPortVlanTag.setName(fStringMap
				.getString("utsDot3OnuEtherPortVlanTag"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTag);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTPID));
		tfUtsDot3OnuEtherPortVlanTPID.setName(fStringMap
				.getString("utsDot3OnuEtherPortVlanTPID"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTPID);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel
				.add(new JLabel(utsDot3OnuEtherPortVlanNaggregationNumber));
		for (int i = 1; i < 6; i++) {
			tfUtsDot3OnuEtherPortVlanNaggregationNumber.addItem(Integer
					.valueOf(i));
		}

		tfUtsDot3OnuEtherPortVlanNaggregationNumber.setName(fStringMap
				.getString(utsDot3OnuEtherPortVlanNaggregationNumber));
		tfUtsDot3OnuEtherPortVlanNaggregationNumber.addActionListener(this);
		baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanNaggregationNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEnable));
		tfUtsDot3OnuEtherPortPolicingEnable.setName(fStringMap
				.getString("utsDot3OnuEtherPortPolicingEnable"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEnable);
		baseInfoPanel.add(new HSpacer());

		tfUtsDot3OnuEtherPortPolicingEnable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemevent) {
				toggleEnableDisable();
			}
		});

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCIR));
		Vector tmpVec = new Vector(127);
		for (int i = 1000; i <= 127000; i += 1000) {
			tmpVec.add(new Integer(i));
		}
		tfUtsDot3OnuEtherPortPolicingCIR = new JComboBox(tmpVec);
		tfUtsDot3OnuEtherPortPolicingCIR.setName(fStringMap
				.getString("utsDot3OnuEtherPortPolicingCIR"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCIR);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCBS));
		tmpVec = new Vector();
		for (int i = 1536; i <= 65280; i += 256) {
            tmpVec.add(new Integer(i));
        } 
		tfUtsDot3OnuEtherPortPolicingCBS = new JComboBox(tmpVec);
		tfUtsDot3OnuEtherPortPolicingCBS.setName(fStringMap
				.getString("utsDot3OnuEtherPortPolicingCBS"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCBS);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEBS));
		tfUtsDot3OnuEtherPortPolicingEBS.setName(fStringMap
				.getString("utsDot3OnuEtherPortPolicingEBS"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEBS);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingEnable));
		tfUtsDot3OnuEtherPortDSPolicingEnable.setName(fStringMap
				.getString("utsDot3OnuEtherPortDSPolicingEnable"));
		tfUtsDot3OnuEtherPortDSPolicingEnable.addActionListener(this);
		baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingEnable);
		baseInfoPanel.add(new HSpacer());

		tmpVec = new Vector();
		for (int i = 0; i <= 1000; i += 128) {
			tmpVec.add(new Integer(i));
		}
		for (int i = 1000; i <= 16777215; i += 1000) {
			tmpVec.add(i);
		}
		tfUtsDot3OnuEtherPortDSPolicingCIR = new JComboBox(tmpVec);
		tfUtsDot3OnuEtherPortDSPolicingPIR = new JComboBox(tmpVec);
		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingCIR));
		tfUtsDot3OnuEtherPortDSPolicingCIR.setName(fStringMap
				.getString("utsDot3OnuEtherPortDSPolicingCIR"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingCIR);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingPIR));
		tfUtsDot3OnuEtherPortDSPolicingPIR.setName(fStringMap
				.getString("utsDot3OnuEtherPortDSPolicingPIR"));
		baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingPIR);
		baseInfoPanel.add(new HSpacer());

		// VLAN Setting
		vlanPanel = new Dot3OnuEtherPortVlanPanel(fApplication);

		tabbedPane = new JTabbedPane();
		tabbedPane.add(fStringMap.getString("Basic_Info"), baseInfoPanel);
		tabbedPane.add(fStringMap.getString("VLAN_Translation_Panel"),
				vlanPanel);

		trunkPanel = new Dot3OnuEtherPortVlanTrunkPanel(fApplication);
		tabbedPane.add(fStringMap.getString("VLAN_Trunk"), trunkPanel);

		for (int i = 0; i < 3; i++) {
			JPanel panel = new JPanel(new BorderLayout());
			n1PanelList[i * 2] = new Dot3OnuEtherPortVlanN1Panel(fApplication);
			n1PanelList[i * 2].setBorder(BorderFactory
					.createTitledBorder(fStringMap
							.getString("vlan-aggregation")
							+ (i * 2 + 1)));
			panel.add(n1PanelList[i * 2], BorderLayout.NORTH);

			n1PanelList[i * 2 + 1] = new Dot3OnuEtherPortVlanN1Panel(
					fApplication);
			n1PanelList[i * 2 + 1].setBorder(BorderFactory
					.createTitledBorder(fStringMap
							.getString("vlan-aggregation")
							+ (i * 2 + 2)));
			panel.add(n1PanelList[i * 2 + 1], BorderLayout.CENTER);
			tabbedPane.add(fStringMap.getString("vlan-aggregation")
					+ (i * 2 + 1) + ("-") + (i * 2 + 2), panel);
		}
		n1PanelList[n1PanelList.length - 1].setVisible(false);
		
		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);
	}

	protected void initForm() {
		tfUtsDot3OnuEtherPortVlanTag.setValueScope(1, 4094);
//		tfUtsDot3OnuEtherPortPolicingEBS.setValueScope(0, 16777215);
		tfUtsDot3OnuEtherPortPolicingEBS.setValueScope(0, 1522);
	}

	public boolean validateFrom() {
		try {
			Integer theValue = Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID
					.getText(), 16);
			if (theValue.intValue() < 0 || theValue.intValue() > 65535) {
				MessageDialog.showInfoMessageDialog(fApplication,
						utsDot3OnuEtherPortVlanTPID
								+ fStringMap.getString("Err_hex"));
				return false;
			}
		} catch (Exception e) {
			MessageDialog.showInfoMessageDialog(fApplication,
					utsDot3OnuEtherPortVlanTPID
							+ fStringMap.getString("Err_hex"));
			return false;
		}

		if (tabbedPane.isEnabledAt(1)
				&& (isNull(vlanPanel.getVlanTranslation()))) {
			MessageDialog.showInfoMessageDialog(fApplication, fStringMap
					.getString("Err_Vlan_Translation_0"));
			return false;
		}
		
		if (tabbedPane.isEnabledAt(2) && (isNull(trunkPanel.getValue()))) {
			MessageDialog.showInfoMessageDialog(fApplication, fStringMap
					.getString("Err_Vlan_Trunk_0"));
			return false;
		}

		return true;
	}

	public void refresh() {
		UNIDataServiceMBean mbean = (UNIDataServiceMBean) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
		tfUtsDot3OnuPortId.setText("" + mbean.getUtsDot3OnuPortId());
		tfUtsDot3OnuLogicalPortId.setText(""
				+ mbean.getUtsDot3OnuLogicalPortId());
		tfUtsDot3OnuEtherPortIndex.setText(""
				+ mbean.getUtsDot3OnuEtherPortIndex());

		if (mbean.getUtsDot3OnuEtherPortPhyAdminCtrl() != null) {
			tfUtsDot3OnuEtherPortPhyAdminCtrl
					.setSelectedIndex(getIndexFromValue(
							utsDot3OnuEtherPortPhyAdminCtrlVList, mbean
									.getUtsDot3OnuEtherPortPhyAdminCtrl()
									.intValue()));
		}
		if (mbean.getUtsDot3OnuEtherPortAutoNegAdminCtrl() != null) {
			tfUtsDot3OnuEtherPortAutoNegAdminCtrl
					.setSelectedIndex(getIndexFromValue(
							utsDot3OnuEtherPortAutoNegAdminCtrlVList, mbean
									.getUtsDot3OnuEtherPortAutoNegAdminCtrl()
									.intValue()));
		}
		if (mbean.getUtsDot3OnuEtherPortPause() != null) {
			tfUtsDot3OnuEtherPortPause.setSelectedIndex(getIndexFromValue(
					utsDot3OnuEtherPortPauseVList, mbean
							.getUtsDot3OnuEtherPortPause().intValue()));
		}

		tfUtsDot3OnuEtherPortVlanMode.setSelectedIndex(getIndexFromValue(
				utsDot3OnuEtherPortVlanModeVList, mbean
						.getUtsDot3OnuEtherPortVlanMode().intValue()));
		tfUtsDot3OnuEtherPortVlanTag.setValue(mbean
				.getUtsDot3OnuEtherPortVlanTag().intValue());
		tfUtsDot3OnuEtherPortVlanTPID.setValue(Integer.toHexString(mbean
				.getUtsDot3OnuEtherPortVlanTPID().intValue()));
		vlanPanel.setVlanTranslation(mbean
				.getUtsDot3OnuEtherPortVlanTranslation());

		if (mbean.getUtsDot3OnuEtherPortVlanNaggregationNumber() != null) {
			tfUtsDot3OnuEtherPortVlanNaggregationNumber.setSelectedItem(mbean
					.getUtsDot3OnuEtherPortVlanNaggregationNumber());
		}

		byte value[] = mbean.getUtsDot3OnuEtherPortVlanNaggregation();
        if(value != null && value.length > 0) {
            for(int i = 0; i < n1PanelList.length - 1; i++) {
                byte n1[] = new byte[44];
                System.arraycopy(value, i * 44, n1, 0, n1.length);
                n1PanelList[i].setValue(n1);
            }

        }

		trunkPanel.setValue(mbean.getUtsDot3OnuEtherPortVlanTrunk());

		tfUtsDot3OnuEtherPortPolicingEnable.setSelectedIndex(getIndexFromValue(
				utsDot3OnuEtherPortPolicingEnableVList, mbean
						.getUtsDot3OnuEtherPortPolicingEnable().intValue()));

		int tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCIR().intValue() / 1000 - 1;
		tfUtsDot3OnuEtherPortPolicingCIR
				.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);

		tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCBS().intValue() / 256 - 1;
		tfUtsDot3OnuEtherPortPolicingCBS
				.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);

		tfUtsDot3OnuEtherPortPolicingEBS.setValue(mbean
				.getUtsDot3OnuEtherPortPolicingEBS().intValue());

		tfUtsDot3OnuEtherPortDSPolicingEnable
				.setSelectedIndex(getIndexFromValue(vList, mbean
						.getUtsDot3OnuEtherPortDSPolicingEnable()));
		tfUtsDot3OnuEtherPortDSPolicingCIR.setSelectedItem(mbean
				.getUtsDot3OnuEtherPortDSPolicingCIR());
		tfUtsDot3OnuEtherPortDSPolicingPIR.setSelectedItem(mbean
				.getUtsDot3OnuEtherPortDSPolicingPIR());
		
		toggleEnableDisable();
	}

	public void updateModel() {
		UNIDataServiceMBean mbean = (UNIDataServiceMBean) getModel();

		mbean
				.setUtsDot3OnuEtherPortPhyAdminCtrl(new Integer(
						utsDot3OnuEtherPortPhyAdminCtrlVList[tfUtsDot3OnuEtherPortPhyAdminCtrl
								.getSelectedIndex()]));
		mbean
				.setUtsDot3OnuEtherPortAutoNegAdminCtrl(new Integer(
						utsDot3OnuEtherPortAutoNegAdminCtrlVList[tfUtsDot3OnuEtherPortAutoNegAdminCtrl
								.getSelectedIndex()]));
		mbean.setUtsDot3OnuEtherPortPause(new Integer(
				utsDot3OnuEtherPortPauseVList[tfUtsDot3OnuEtherPortPause
						.getSelectedIndex()]));

		mbean.setUtsDot3OnuEtherPortVlanMode(new Integer(
				utsDot3OnuEtherPortVlanModeVList[tfUtsDot3OnuEtherPortVlanMode
						.getSelectedIndex()]));

		if (tfUtsDot3OnuEtherPortVlanTag.isEnabled())
			mbean.setUtsDot3OnuEtherPortVlanTag(new Integer(
					tfUtsDot3OnuEtherPortVlanTag.getValue()));

		if (tfUtsDot3OnuEtherPortVlanTPID.isEnabled())
			mbean.setUtsDot3OnuEtherPortVlanTPID(Integer.valueOf(
					tfUtsDot3OnuEtherPortVlanTPID.getText(), 16));

		if (tfUtsDot3OnuEtherPortVlanNaggregationNumber.isEnabled()) {
			mbean
					.setUtsDot3OnuEtherPortVlanNaggregationNumber((Integer) tfUtsDot3OnuEtherPortVlanNaggregationNumber
							.getSelectedItem());

			byte value[] = new byte[512];
			for(int i = 0; i < n1PanelList.length; i++) {
				if (n1PanelList[i].isEnabled()) {
					byte n1[] = n1PanelList[i].getValue();
					System.arraycopy(n1, 0, value, i * 44, n1.length);
				}
			}

			mbean.setUtsDot3OnuEtherPortVlanNaggregation(value);
		}

		if (tabbedPane.isEnabledAt(1)) {
			mbean.setUtsDot3OnuEtherPortVlanTranslation(vlanPanel
					.getVlanTranslation());
		}

		if (tabbedPane.isEnabledAt(2)) {
			mbean.setUtsDot3OnuEtherPortVlanTrunk(trunkPanel.getValue());
		}

		mbean
				.setUtsDot3OnuEtherPortPolicingEnable(new Integer(
						utsDot3OnuEtherPortPolicingEnableVList[tfUtsDot3OnuEtherPortPolicingEnable
								.getSelectedIndex()]));
		if (tfUtsDot3OnuEtherPortPolicingCIR.isEnabled()) {
			mbean
					.setUtsDot3OnuEtherPortPolicingCIR((Integer) tfUtsDot3OnuEtherPortPolicingCIR
							.getSelectedItem());
		}

		if (tfUtsDot3OnuEtherPortPolicingCBS.isEnabled()) {
			mbean
					.setUtsDot3OnuEtherPortPolicingCBS((Integer) tfUtsDot3OnuEtherPortPolicingCBS
							.getSelectedItem());
		}
		if (tfUtsDot3OnuEtherPortPolicingEBS.isEnabled())
			mbean.setUtsDot3OnuEtherPortPolicingEBS(new Integer(
					tfUtsDot3OnuEtherPortPolicingEBS.getValue()));

		mbean
				.setUtsDot3OnuEtherPortDSPolicingEnable(vList[tfUtsDot3OnuEtherPortDSPolicingEnable
						.getSelectedIndex()]);

		if (tfUtsDot3OnuEtherPortDSPolicingCIR.isEnabled()) {
			mbean.setUtsDot3OnuEtherPortDSPolicingCIR(new Integer(
					tfUtsDot3OnuEtherPortDSPolicingCIR.getSelectedItem()
							.toString()));
		}

		if (tfUtsDot3OnuEtherPortDSPolicingPIR.isEnabled()) {
			mbean.setUtsDot3OnuEtherPortDSPolicingPIR(new Integer(
					tfUtsDot3OnuEtherPortDSPolicingPIR.getSelectedItem()
							.toString()));
		}
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

	boolean isNull(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			if (b[i] != 0)
				return false;
		}

		return true;
	}

	public void toggleEnableDisable() {
		if (tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex() == 1) {
			tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(false);
			tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(false);
			tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(false);
		} else {
			tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(true);
			tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(true);
			tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(true);
		}
	}

//	public void actionPerformed(ActionEvent e) {
//		if (tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex() == 0) {//
//			tfUtsDot3OnuEtherPortVlanTag.setEnabled(false);
//			tfUtsDot3OnuEtherPortVlanTPID.setEnabled(false);
//			vlanPanel.setEnabled(false);
//		} else if (tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex() == 1) {
//			tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
//			tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
//			vlanPanel.setEnabled(false);
//		} else {
//			tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
//			tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
//			vlanPanel.setEnabled(true);
//		}
//
//		if (tfUtsDot3OnuEtherPortDSPolicingEnable.getSelectedIndex() == 0) {
//			tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(true);
//			tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(true);
//		} else {
//			tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(false);
//			tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(false);
//		}
//	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfUtsDot3OnuEtherPortVlanMode) {
			int mode = tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex();
			if (mode == 0) {
				tfUtsDot3OnuEtherPortVlanTag.setEnabled(false);
				tfUtsDot3OnuEtherPortVlanTPID.setEnabled(false);
				tfUtsDot3OnuEtherPortVlanTPID.setValue("0");
				tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, false);
				fireNumberChangedEvent(false);
			} else if (mode == 1) {
				tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
				tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, false);
				fireNumberChangedEvent(false);
//			} else if (mode == 2 || mode == 3) {
			} else if (mode == 2) {
				tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
				tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setEnabledAt(2, false);
				fireNumberChangedEvent(false);
//			} else if (mode == 4) {
			} else if (mode == 3) {
				tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
				tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(true);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, false);
				fireNumberChangedEvent(true);
			} else {
				tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
				tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
				tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, true);
				fireNumberChangedEvent(false);
			}
		} else if (e.getSource() != tfUtsDot3OnuEtherPortDSPolicingEnable) {
			fireNumberChangedEvent(true);
		} else if (e.getSource() == tfUtsDot3OnuEtherPortDSPolicingEnable) {
			if (tfUtsDot3OnuEtherPortDSPolicingEnable.getSelectedIndex() == 0) {
	            tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(true);
	            tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(true);
	        } else {
	            tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(false);
	            tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(false);
	        }
		}
	}

	void fireNumberChangedEvent(boolean isEnable) {
		Integer number = (Integer) tfUtsDot3OnuEtherPortVlanNaggregationNumber
				.getSelectedItem();
		if (number == null) {
			number = 0;
		}
		for (int i = 0; i < n1PanelList.length; i++) {
			n1PanelList[i].setEnabled(isEnable && i < number.intValue());
		}

		for (int i = 0; i < 3; i++) {
			tabbedPane.setEnabledAt(i + 3, isEnable
					&& i < (number.intValue() - 1) / 2 + 1);
		}
	}
}