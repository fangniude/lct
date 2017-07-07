package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPRelay;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The DHCPRelayPanel class. Created by DVM Creator
 */
public class DHCPRelayPanel extends UPanel {

	UPanel dhcprelayInnerPanel;
	UPanel tablepanel1;
	
	public DHCPRelayPanel(IApplication app) {
		super(app);
		init();
	}
	public void initGui() {
		JPanel allPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		allPanel.setLayout(layout);
		dhcprelayInnerPanel = new DHCPRelayPanel_Inner(fApplication);
//		dhcprelayInnerPanel.setPreferredSize(new Dimension(100, 200));

		IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
		tablepanel1 = (SnmpTablePane) composer.composeSnmpTablePane("DHCPRelayServerTable_Panel");

		allPanel.add(dhcprelayInnerPanel);
		allPanel.add(tablepanel1);
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
	}

	public void refresh() {
		dhcprelayInnerPanel.refresh();
		tablepanel1.refresh();
	}

	public class DHCPRelayPanel_Inner extends UPanel {

		private int[] utsDHCPRelayOption82VList = new int[] { 2, 1, };

		private String[] utsDHCPRelayOption82TList = new String[] { fStringMap.getString("disable"), fStringMap.getString("enable"), };

		private JComboBox tfUtsDHCPRelayOption82 = new JComboBox(utsDHCPRelayOption82TList);

		private int[] utsDHCPRelayInforChkVList = new int[] { 2, 1, };

		private String[] utsDHCPRelayInforChkTList = new String[] { fStringMap.getString("disable"), fStringMap.getString("enable"), };

		private JComboBox tfUtsDHCPRelayInforChk = new JComboBox(utsDHCPRelayInforChkTList);

		private int[] utsDHCPRelayPolicyVList = new int[] { 1, 2, 3, };

		private String[] utsDHCPRelayPolicyTList = new String[] { fStringMap.getString("drop"), fStringMap.getString("keep"),
				fStringMap.getString("replace"), };

		private JComboBox tfUtsDHCPRelayPolicy = new JComboBox(utsDHCPRelayPolicyTList);

		private IntegerTextField tfUtsDHCPRelayMaxhop = new IntegerTextField();

		private final String utsDHCPRelayOption82 = fStringMap.getString("utsDHCPRelayOption82") + " : ";

		private final String utsDHCPRelayInforChk = fStringMap.getString("utsDHCPRelayInforChk") + " : ";

		private final String utsDHCPRelayPolicy = fStringMap.getString("utsDHCPRelayPolicy") + " : ";

		private final String utsDHCPRelayMaxhop = fStringMap.getString("utsDHCPRelayMaxhop") + " : ";

		private SnmpApplyButton btApply;

		private SnmpRefreshButton btRefresh;

		public DHCPRelayPanel_Inner(IApplication app) {
			super(app);
			setModel(new DHCPRelay(app.getSnmpProxy()));
			init();
		}

		public void initGui() {

			btApply = new SnmpApplyButton(fApplication, this);
			btApply.getAction().putValue(BaseAction.ID, "Modify_DHCPRelay");
			btRefresh = new SnmpRefreshButton(fApplication, this);
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.add(btApply);
			buttonsPanel.add(btRefresh);

			JPanel baseInfoPanel = new JPanel();
			NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
			layout.setMargins(6, 10, 6, 10);
			baseInfoPanel.setLayout(layout);
			baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

			baseInfoPanel.add(new JLabel(utsDHCPRelayOption82));
			tfUtsDHCPRelayOption82.setName(fStringMap.getString("utsDHCPRelayOption82"));
			baseInfoPanel.add(tfUtsDHCPRelayOption82);
			baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(utsDHCPRelayInforChk));
			tfUtsDHCPRelayInforChk.setName(fStringMap.getString("utsDHCPRelayInforChk"));
			baseInfoPanel.add(tfUtsDHCPRelayInforChk);
			baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(utsDHCPRelayPolicy));
			tfUtsDHCPRelayPolicy.setName(fStringMap.getString("utsDHCPRelayPolicy"));
			baseInfoPanel.add(tfUtsDHCPRelayPolicy);
			baseInfoPanel.add(new HSpacer());

			baseInfoPanel.add(new JLabel(utsDHCPRelayMaxhop));
			tfUtsDHCPRelayMaxhop.setName(fStringMap.getString("utsDHCPRelayMaxhop"));
			baseInfoPanel.add(tfUtsDHCPRelayMaxhop);
			baseInfoPanel.add(new HSpacer());

			JPanel allPanel = new JPanel();
			layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
			layout.setMargins(6, 10, 6, 10);
			allPanel.setLayout(layout);
			allPanel.add(baseInfoPanel);
			allPanel.add(new VSpacer());
			allPanel.add(buttonsPanel);

			setLayout(new BorderLayout());
			add(allPanel, BorderLayout.CENTER);
		}

		protected void initForm() {
			tfUtsDHCPRelayMaxhop.setValueScope(1, 15);
		}

		public void refresh() {

			DHCPRelay mbean = (DHCPRelay) getModel();
			BeanService.refreshBean(fApplication, mbean);

			tfUtsDHCPRelayOption82.setSelectedIndex(getIndexFromValue(utsDHCPRelayOption82VList, mbean.getUtsDHCPRelayOption82().intValue()));
			tfUtsDHCPRelayInforChk.setSelectedIndex(getIndexFromValue(utsDHCPRelayInforChkVList, mbean.getUtsDHCPRelayInforChk().intValue()));
			tfUtsDHCPRelayPolicy.setSelectedIndex(getIndexFromValue(utsDHCPRelayPolicyVList, mbean.getUtsDHCPRelayPolicy().intValue()));
			tfUtsDHCPRelayMaxhop.setValue(mbean.getUtsDHCPRelayMaxhop().intValue());
		}

		public void updateModel() {
			DHCPRelay mbean = (DHCPRelay) getModel();

			mbean.setUtsDHCPRelayOption82(new Integer(utsDHCPRelayOption82VList[tfUtsDHCPRelayOption82.getSelectedIndex()]));
			mbean.setUtsDHCPRelayInforChk(new Integer(utsDHCPRelayInforChkVList[tfUtsDHCPRelayInforChk.getSelectedIndex()]));
			mbean.setUtsDHCPRelayPolicy(new Integer(utsDHCPRelayPolicyVList[tfUtsDHCPRelayPolicy.getSelectedIndex()]));
			mbean.setUtsDHCPRelayMaxhop(new Integer(tfUtsDHCPRelayMaxhop.getValue()));
		}

		public int getIndexFromValue(int[] list, int v) {
			for (int i = 0; i != list.length; i++) {
				if (list[i] == v)
					return i;
			}
			return 0;
		}
	}
}