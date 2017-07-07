package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.UtsOnuFWUpgradeManualBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtsOnuFwUpgradeManualPanel extends UPanel {

    private OnlineOnuTreePanel onuTreePanel;

    private int[] utsOnuFWUpgradeManualOptionVList = new int[] { 1, 2, };
    private String[] utsOnuFWUpgradeManualOptionTList = new String[] { fStringMap.getString("normal"), // 1
	    fStringMap.getString("force"), // 2
    };
    private JComboBox tfUtsOnuFWUpgradeManualOption = new JComboBox(utsOnuFWUpgradeManualOptionTList);

    private int[] utsOnuFWUpgradeManualActCommitFlagVList = new int[] { 0, 1, };
    private String[] utsOnuFWUpgradeManualActCommitFlagTList = new String[] { fStringMap.getString("activate"), // 1
	    fStringMap.getString("activateCommit"), // 2
    };
    private JComboBox tfUtsOnuFWUpgradeManualActCommitFlag = new JComboBox(utsOnuFWUpgradeManualActCommitFlagTList);

    private StringTextField tfUtsOnuFWUpgradeManualCurrentStatus = new StringTextField();

    private int[] utsOnuFWUpgradeManualManualStopVList = new int[] { 1, 2, };
    private String[] utsOnuFWUpgradeManualManualStopTList = new String[] { fStringMap.getString("true"), fStringMap.getString("false"), };
    private JComboBox tfUtsOnuFWUpgradeManualManualStop = new JComboBox(utsOnuFWUpgradeManualManualStopTList);

    private final String utsOnuFWUpgradeManualOption = fStringMap.getString("utsOnuFWUpgradeManualOption") + " : ";
    private final String utsOnuFWUpgradeManualActCommitFlag = fStringMap.getString("utsOnuFWUpgradeManualActCommitFlag") + " : ";
    private final String utsOnuFWUpgradeManualCurrentStatus = fStringMap.getString("utsOnuFWUpgradeManualCurrentStatus") + " : ";
    private final String utsOnuFWUpgradeManualPortListBitMap = fStringMap.getString("utsOnuFWUpgradeManualPortListBitMap") + " : ";
    private final String utsOnuFWUpgradeManualManualStop = fStringMap.getString("utsOnuFWUpgradeManualManualStop");

    // private JButton upgradeResultButton = new JButton(fStringMap.getString("upgradeResultButton"));

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;
    private JButton btnStop;
    private String currentStatus;

    public UtsOnuFwUpgradeManualPanel(IApplication app) {
	super(app);
	setModel(new UtsOnuFWUpgradeManualBean(fApplication.getSnmpProxy()));
	super.init();
    }

    @Override
    protected void initGui() {

	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(4, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualOption));
	tfUtsOnuFWUpgradeManualOption.setName(fStringMap.getString("utsOnuFWUpgradeManualOption"));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualOption);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualActCommitFlag));
	tfUtsOnuFWUpgradeManualActCommitFlag.setName(fStringMap.getString("utsOnuFWUpgradeManualActCommitFlag"));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualActCommitFlag);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualCurrentStatus));
	tfUtsOnuFWUpgradeManualCurrentStatus.setName(fStringMap.getString("utsOnuFWUpgradeManualCurrentStatus"));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualCurrentStatus);
	baseInfoPanel.add(new HSpacer());
	tfUtsOnuFWUpgradeManualCurrentStatus.setEditable(false);

	baseInfoPanel.add(new JLabel());
	tfUtsOnuFWUpgradeManualManualStop.setName(fStringMap.getString("utsOnuFWUpgradeManualManualStop"));
	baseInfoPanel.add(tfUtsOnuFWUpgradeManualManualStop);
	tfUtsOnuFWUpgradeManualManualStop.setVisible(false);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsOnuFWUpgradeManualPortListBitMap));
	baseInfoPanel.add(new HSpacer());
	baseInfoPanel.add(new HSpacer());
	baseInfoPanel.add(new HSpacer());
	baseInfoPanel.add(new HSpacer());
	baseInfoPanel.add(new HSpacer());

	onuTreePanel = new OnlineOnuTreePanel(fApplication);
	baseInfoPanel.add(onuTreePanel);

	JPanel allPanel = new JPanel();
	layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
	layout.setMargins(6, 10, 6, 10);
	allPanel.setLayout(layout);
	allPanel.add(baseInfoPanel);
	// allPanel.add(ontInfoPanel);
	setLayout(new BorderLayout());
	add(allPanel, BorderLayout.CENTER);

	btApply = new SnmpApplyButton(fApplication, this);
	btApply.getAction().putValue(BaseAction.ID, "Modify_UtsOnuFwUpgradeManual");
	btRefresh = new SnmpRefreshButton(fApplication, this);
	// upgradeResultButton.addActionListener(new ShowOnuFWUpgradeManualResultAction(fApplication));

	btnStop = new JButton(utsOnuFWUpgradeManualManualStop);
	btnStop.setEnabled(false);
	btnStop.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (!checkPermission("Modify_UtsOnuFwUpgradeManual"))
		    return;
		doStopUpgrade();
	    }
	});
	JPanel buttonsPanel = new JPanel();
	buttonsPanel.add(btApply);
	buttonsPanel.add(btnStop);
	buttonsPanel.add(btRefresh);
	// buttonsPanel.add(upgradeResultButton);

	add(buttonsPanel, BorderLayout.SOUTH);

    }

    @Override
    protected void initForm() {

	super.initForm();
	tfUtsOnuFWUpgradeManualOption.setSelectedIndex(1);
	tfUtsOnuFWUpgradeManualOption.setEnabled(false);
	tfUtsOnuFWUpgradeManualActCommitFlag.setSelectedIndex(1);
	tfUtsOnuFWUpgradeManualActCommitFlag.setEnabled(false);
    }

    @Override
    public void refresh() {
	onuTreePanel.init();
    }

    public void updateModel() {
	UtsOnuFWUpgradeManualBean mbean = (UtsOnuFWUpgradeManualBean) getModel();
	if (mbean == null)
	    return;
	mbean.setUtsOnuFWUpgradeManualPortListBitMap(onuTreePanel.getSelectedOnuBitMap());
	// mbean.setGponSysCfgIgmpProxyRoutingMode(gponSysCfgIgmpProxyRoutingModeVList[tfGponSysCfgIgmpProxyRoutingMode.getSelectedIndex()]);
	mbean.setUtsOnuFWUpgradeManualOption(utsOnuFWUpgradeManualOptionVList[tfUtsOnuFWUpgradeManualOption.getSelectedIndex()]);
	mbean.setUtsOnuFWUpgradeManualActCommitFlag(utsOnuFWUpgradeManualActCommitFlagVList[tfUtsOnuFWUpgradeManualActCommitFlag.getSelectedIndex()]);
	// mbean.setUtsOnuFWUpgradeManualCurrentStatus(tfUtsOnuFWUpgradeManualCurrentStatus.getValue());

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

    public void doStopUpgrade() {
	UtsOnuFWUpgradeManualBean mbean = (UtsOnuFWUpgradeManualBean) getModel();
	if (mbean == null)
	    return;
	mbean.setUtsOnuFWUpgradeManualManualStop(1);
	try {
	    mbean.doStop();
	} catch (Exception e) {
	}
    }

    private boolean checkPermission(String anActionId) {
	if (fApplication.isDebug() || anActionId == null || anActionId.length() == 0) {
	    return true;
	}

	final ISecurityManager securityManager = fApplication.getSecurityManager();
	final ISession session = fApplication.getSession();
	if (!securityManager.isAuthorized(session, anActionId)) {
	    MessageDialog.showPermissionDeniedDialog(fApplication);
	    return false;
	} else {
	    return true;
	}
    }

}
