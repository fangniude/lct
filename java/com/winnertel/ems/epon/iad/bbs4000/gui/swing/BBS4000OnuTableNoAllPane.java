package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;

import java.awt.*;

public class BBS4000OnuTableNoAllPane extends BBS4000OnuTablePane {

	public BBS4000OnuTableNoAllPane(IApplication app) {
		super(app);
	}

	public void initGui() {
		filterPane = new OnuFilterNoAllItemPanel(fApplication);
		filterPane.addActionListener(this);
        refreshButton = filterPane.getRefreshButton();
		setLayout(new BorderLayout());
		add(filterPane, BorderLayout.NORTH);
	}

	String[] getIndex(String panel) {
		String[] index = null;
		if (panel.equals("Dot3Onu2CtcEtherPortTable_Panel")
				|| panel.equals("OnuCtcBandCtrlTable_Panel")
				|| panel.equals("Dot3Olt2VlanStackingTable_Panel")
				|| panel.equals("PonVlanTranslationTable_Panel")
				|| panel.equals("OnuCtcMulticastStatForUserPortTable_Panel")
				|| panel.equals("Dot3Onu2CtcMulticastCtrlTable_Panel")
				|| panel.equals("UNIMulticastConfigure_Panel")
				|| panel.equals("VlanModeConfigMBean_Panel")
				|| panel.equals("VlanModeConfigMBean500_Panel")
				|| panel.equals("Dot3Onu2CtcEtherPortRateTable_Panel")
				|| panel.equals("Dot3Onu2CtcPortsCftTable_Panel")
				|| panel.equals("Onu2CtcPotsCfgTable_Panel")
				|| panel.equals("UNIDataServiceMBean_Panel")
				|| panel.equals("UNIIPTVServiceMBean_Panel")
				|| panel.equals("Dot3Onu2Ctc3UniTable_Panel")
				|| panel.equals("Dot3Onu2DlConsoleTable_Panel")
				|| panel.equals("Dot3Onu2PrivateUniOamTable_Panel")
				|| panel.equals("Dot3Onu2PrivateUniStatsTable_Panel")
				|| panel.equals("Dot3Onu2PrivateUniFlowAclQosTable_Panel")) {
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
		}

		return index;
	}
}
