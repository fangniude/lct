package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import java.awt.BorderLayout;

import com.winnertel.em.framework.IApplication;

public class BBS1000OnuNoAllTablePane extends BBS1000OnuTablePane {
	private static final long serialVersionUID = 6297424301340980220L;

	public BBS1000OnuNoAllTablePane(IApplication app) {
		super(app);
	}

	public void initGui() {
		filterPane = new BBS1000OnuNoAllFilterPanel(fApplication);
		filterPane.addActionListener(this);
        refreshButton = filterPane.getRefreshButton();

		// IGuiComposer composer1 =
		// fApplication.getActiveDeviceManager().getGuiComposer();
		// snmpPanel = (SnmpTablePane)
		// composer1.composeSnmpTablePane("Dot3Onu2TrafficProfTable_Panel");

		setLayout(new BorderLayout());
		add(filterPane, BorderLayout.NORTH);
		// add(snmpPanel, BorderLayout.CENTER);
	}

	String[] getIndex(String panel) {
		String[] index = null;

		if (panel.equals("OnuSelectiveQinQ_Panel")) {
			index = new String[8];

			// fill the index.
			if (filterPane.getSelectedSlotId() != 0) {
				index[0] = "" + filterPane.getSelectedSlotId();
				index[1] = "1";

				index[2] = "" + filterPane.getSelectedPortId();
				if (filterPane.getSelectedOnuId() == 0) {
					index[3] = "1";
				} else {
					index[3] = "" + filterPane.getSelectedOnuId();
				}

				index[4] = "0";
				index[5] = "0";
				index[6] = "0";
				index[7] = "0";
			}
		} else if (panel.equals("Dot3Onu2CtcClassifiAppTable_Panel")) {
			index = new String[7];

			// fill the index.

				index[0] = "" + filterPane.getSelectedSlotId();
				index[1] = "1";

				index[2] = "" + filterPane.getSelectedPortId();
				if (filterPane.getSelectedOnuId() == 0) {
					index[3] = "1";
				} else {
					index[3] = "" + filterPane.getSelectedOnuId();
				}

				index[4] = "0";
				index[5] = "0";
				index[6] = "0";
		} else if (panel.equals("Onu2CtcAlarmReportingTable_Panel")) {
			index = new String[4];

			// fill the index.
			index[0] = "" + filterPane.getSelectedSlotId();
			index[1] = "1";

			index[2] = "" + filterPane.getSelectedPortId();
			if (filterPane.getSelectedOnuId() == 0) {
				index[3] = "1";
			} else {
				index[3] = "" + filterPane.getSelectedOnuId();
			}
			// index[4] = "0";
			// index[5] = "0";
		} else if (panel.equals("Dot3Onu2CtcEtherPortTable_Panel")
				|| panel.equals("OnuCtcBandCtrlTable_Panel")
				|| panel.equals("Dot3Olt2VlanStackingTable_Panel")
				|| panel.equals("PonVlanTranslationTable_Panel")
				|| panel.equals("OnuCtcMulticastStatForUserPortTable_Panel")
				|| panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel")
				|| panel.equals("UNIMulticastConfigure_Panel")
				|| panel.equals("VlanModeConfigMBean_Panel")
				|| panel.equals("Dot3Onu2CtcEtherPortRateTable_Panel")
				|| panel.equals("Dot3Onu2CtcPortsCftTable_Panel")
				|| panel.equals("Onu2CtcPotsCfgTable_Panel")
				|| panel.equals("UNIDataServiceMBean_Panel")
				|| panel.equals("UNIIPTVServiceMBean_Panel")) {
			index = new String[5];

			// fill the index.
			index[0] = "" + filterPane.getSelectedSlotId();
			index[1] = "1";

			index[2] = "" + filterPane.getSelectedPortId();
			if (filterPane.getSelectedOnuId() == 0) {
				index[3] = "1";
			} else {
				index[3] = "" + filterPane.getSelectedOnuId();
			}

			index[4] = "0";

		} else if (panel.equals("Dot3OnuSwitchTable_Panel")
				|| panel.equals("Dot3UnboundOnuTable_Panel")
				|| panel.equals("OnuConfigWoOamTable_Panel")
				|| panel.equals("Dot3OltOpmOnuRxPowerTable_Panel")) {
			index = new String[3];
			index[0] = "" + filterPane.getSelectedSlotId();

			index[1] = "" + filterPane.getSelectedPortId();
			if (filterPane.getSelectedOnuId() == 0) {
				index[2] = "0";
			} else {
				index[2] = "" + (filterPane.getSelectedOnuId() - 1);
			}
		} else {
			index = new String[4];

			// fill the index.
			index[0] = "" + filterPane.getSelectedSlotId();
			index[1] = "1";

			index[2] = "" + filterPane.getSelectedPortId();
			if (filterPane.getSelectedOnuId() == 0) {
				index[3] = "0";
			} else {
				index[3] = "" + (filterPane.getSelectedOnuId() - 1);
			}
		}

		return index;
	}
}
