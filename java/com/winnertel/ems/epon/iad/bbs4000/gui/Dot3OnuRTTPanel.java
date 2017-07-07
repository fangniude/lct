package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuRTT;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3OnuRTTPanel class. Created by DVM Creator
 */
public class Dot3OnuRTTPanel extends UPanel
{

	private JLabel tfUtsDot3OnuRTT = new JLabel();

	private final String utsDot3OnuRTT = fStringMap.getString("utsDot3OnuRTT")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public Dot3OnuRTTPanel(IApplication app)
	{
		super(app);
		setModel(new Dot3OnuRTT(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_Dot3OnuRTT");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuRTT));
		baseInfoPanel.add(tfUtsDot3OnuRTT);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

		add(buttonsPanel, BorderLayout.SOUTH);

	}

	protected void initForm()
	{

	}

	public void refresh()
	{

//		Dot3OnuRTT mbean = (Dot3OnuRTT) getModel();
//		BeanService.refreshBean(fApplication, mbean);
//
//		tfUtsDot3OnuRTT.setText(mbean.getUtsDot3OnuRTT().toString());

	}

	public int getIndexFromValue(int[] list, int v)
	{
		for (int i = 0; i != list.length; i++)
		{
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
