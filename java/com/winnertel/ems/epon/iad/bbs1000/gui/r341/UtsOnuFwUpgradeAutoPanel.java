package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs1000.mib.r341.UtsOnuFWUpgradeAutoBean;

public class UtsOnuFwUpgradeAutoPanel extends UPanel {

	private OnuTreePanel onuTreePanel;

	private int[] utsOnuFWUpgradeAutoOptionVList = new int[] { 1, 2, };
	private String[] utsOnuFWUpgradeAutoOptionTList = new String[] {
			fStringMap.getString("normal"), // 1
			fStringMap.getString("force"), // 2
	};
	private JComboBox tfUtsOnuFWUpgradeAutoOption = new JComboBox(
			utsOnuFWUpgradeAutoOptionTList);

	// private StringTextField tfUtsOnuFWUpgradeAutoCurrentStatus = new
	// StringTextField();

	private final String utsOnuFWUpgradeAutoOption = fStringMap
			.getString("utsOnuFWUpgradeAutoOption")
			+ " : ";
	// private final String utsOnuFWUpgradeAutoCurrentStatus =
	// fStringMap.getString("utsOnuFWUpgradeAutoCurrentStatus") + " : ";
	private final String utsOnuFWUpgradeAutoPortListBitMap = fStringMap
			.getString("utsOnuFWUpgradeAutoPortListBitMap")
			+ " : ";

	// private JButton upgradeResultButton = new
	// JButton(fStringMap.getString("upgradeResultButton"));

	private SnmpApplyButton btApply;
	private SnmpRefreshButton btRefresh;

	public UtsOnuFwUpgradeAutoPanel(IApplication app) {
		super(app);
		setModel(new UtsOnuFWUpgradeAutoBean(fApplication.getSnmpProxy()));
		super.init();
	}

	@Override
	protected void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoOption));
		tfUtsOnuFWUpgradeAutoOption.setName(fStringMap
				.getString("utsOnuFWUpgradeAutoOption"));
		baseInfoPanel.add(tfUtsOnuFWUpgradeAutoOption);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoCurrentStatus));
		// tfUtsOnuFWUpgradeAutoCurrentStatus.setName(fStringMap.getString("utsOnuFWUpgradeAutoCurrentStatus"));
		// baseInfoPanel.add(tfUtsOnuFWUpgradeAutoCurrentStatus);
		// baseInfoPanel.add(new HSpacer());
		// tfUtsOnuFWUpgradeAutoCurrentStatus.setEnabled(false);

		// JPanel ontInfoPanel = new JPanel();
		// layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
		// layout.setMargins(6, 10, 6, 10);
		// ontInfoPanel.setLayout(layout);
		// ontInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsOnuFWUpgradeAutoPortListBitMap));
		baseInfoPanel.add(new HSpacer());
		baseInfoPanel.add(new HSpacer());
		onuTreePanel = new OnuTreePanel(fApplication);
		baseInfoPanel.add(onuTreePanel);

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		// allPanel.add(ontInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID,
				"Modify_UtsOnuFwUpgradeManual");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		// upgradeResultButton.addActionListener(new
		// ShowOnuFWUpgradeManualResultAction(fApplication));
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);
		// buttonsPanel.add(upgradeResultButton);

		add(buttonsPanel, BorderLayout.SOUTH);

	}

	@Override
	protected void initForm() {

		super.initForm();
	}

	@Override
	public void refresh() {
		onuTreePanel.init();
	}

	public void updateModel() {
		UtsOnuFWUpgradeAutoBean mbean = (UtsOnuFWUpgradeAutoBean) getModel();
		if (mbean == null)
			return;

		byte[] bitmap = onuTreePanel.getSelectedOnuBitMap();
		mbean.setUtsOnuFWUpgradeAutoPortListBitMap(bitmap);
		// mbean.setGponSysCfgIgmpProxyRoutingMode(gponSysCfgIgmpProxyRoutingModeVList[tfGponSysCfgIgmpProxyRoutingMode.getSelectedIndex()]);
		mbean
				.setUtsOnuFWUpgradeAutoOption(utsOnuFWUpgradeAutoOptionVList[tfUtsOnuFWUpgradeAutoOption
						.getSelectedIndex()]);
		// mbean.setUtsOnuFWUpgradeAutoCurrentStatus(tfUtsOnuFWUpgradeAutoCurrentStatus.getValue());

	}

	public boolean validateFrom() {

		return true;
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

}
