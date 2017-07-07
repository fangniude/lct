package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.OnuPowerMeasureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The PortDiagnosisMBeanPanel class. Created by DVM Creator
 */
public class OnuPowerMeasureMBeanPanel extends UPanel {
	private JLabel tfutsDot3OnuOpticalPowerModuleId = new JLabel();
//	private JLabel tfutsDot3OnuOpticalPowerDeviceId = new JLabel();
	private JLabel tfutsDot3OnuOpticalPowerPortId = new JLabel();
  private JLabel tfUtsDot3OnuOpticalPowerLogicalPortId = new JLabel();
  private int[] vList = new int[] {1, 2};
  private String[] tList = new String[]{fStringMap.getString("enable"), fStringMap.getString("disable")};
  private JComboBox tfUtsDot3OnuOpticalPowerAdmin = new JComboBox(tList);

	private final String utsDot3OnuOpticalPowerModuleId = fStringMap.getString("utsDot3OnuOpticalPowerModuleId") + " : ";
//	private final String utsDot3OnuOpticalPowerDeviceId = fStringMap.getString("utsDot3OnuOpticalPowerDeviceId") + " : ";
	private final String utsDot3OnuOpticalPowerPortId = fStringMap.getString("utsDot3OnuOpticalPowerPortId") + " : ";
  private final String utsDot3OnuOpticalPowerLogicalPortId = fStringMap.getString("utsDot3OnuOpticalPowerLogicalPortId") + " : ";
  private final String utsDot3OnuOpticalPowerAdmin = fStringMap.getString("utsDot3OnuOpticalPowerAdmin") + " : ";

	public OnuPowerMeasureMBeanPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuOpticalPowerModuleId));
		baseInfoPanel.add(tfutsDot3OnuOpticalPowerModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOpticalPowerPortId));
		baseInfoPanel.add(tfutsDot3OnuOpticalPowerPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOpticalPowerLogicalPortId));
		baseInfoPanel.add(tfUtsDot3OnuOpticalPowerLogicalPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuOpticalPowerAdmin));
		baseInfoPanel.add(tfUtsDot3OnuOpticalPowerAdmin);
		baseInfoPanel.add(new HSpacer());

		add( baseInfoPanel, BorderLayout.CENTER );
	}

	protected void initForm() {
	}

	public void refresh() {
    OnuPowerMeasureMBean mbean = (OnuPowerMeasureMBean) getModel();
		if ( mbean == null ) return;

		tfutsDot3OnuOpticalPowerModuleId.setText("" + mbean.getUtsDot3OnuOpticalPowerModuleId());
//		tfutsDot3OnuOpticalPowerDeviceId.setText(mbean.getUtsDot3OnuOpticalPowerDeviceId().toString());
		tfutsDot3OnuOpticalPowerPortId.setText("" + mbean.getUtsDot3OnuOpticalPowerPortId());
    tfUtsDot3OnuOpticalPowerLogicalPortId.setText("" + mbean.getUtsDot3OnuOpticalPowerLogicalPortId());
		tfUtsDot3OnuOpticalPowerAdmin.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsDot3OnuOpticalPowerAdmin()));
	}

	public void updateModel() {
    OnuPowerMeasureMBean mbean = (OnuPowerMeasureMBean) getModel();

    mbean.setUtsDot3OnuOpticalPowerAdmin(vList[tfUtsDot3OnuOpticalPowerAdmin.getSelectedIndex()]);
  }

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
}
