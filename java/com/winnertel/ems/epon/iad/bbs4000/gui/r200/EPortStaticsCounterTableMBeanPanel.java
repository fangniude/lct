package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.EPortStaticsCounterTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The OnuIfExtTablePanel class. Created by DVM Creator
 */
public class EPortStaticsCounterTableMBeanPanel extends UPanel
{
	private int[] utsEthIfPMStatusVList = new int[]
	{ 1, 2, };

	private String[] utsEthIfPMStatusTList = new String[]
	{ fStringMap.getString("enable"), fStringMap.getString("disable")};

	private JComboBox tfUtsEthIfPMStatus = new JComboBox(
			utsEthIfPMStatusTList);

	private final String utsEthIfPMStatus = fStringMap
			.getString("utsEthIfPMStatus")
			+ " : ";

	public EPortStaticsCounterTableMBeanPanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsEthIfPMStatus));
		baseInfoPanel.add(tfUtsEthIfPMStatus);
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

	protected void initForm()
	{
	}

	public void refresh()
	{
		EPortStaticsCounterTableMBean mbean = (EPortStaticsCounterTableMBean) getModel();

		tfUtsEthIfPMStatus.setSelectedIndex(getIndexFromValue(
				utsEthIfPMStatusVList, mbean.getUtsEthIfPMStatus().intValue()));
	}

	public void updateModel()
	{
		EPortStaticsCounterTableMBean mbean = (EPortStaticsCounterTableMBean) getModel();

		mbean.setUtsEthIfPMStatus(new Integer(
				utsEthIfPMStatusVList[tfUtsEthIfPMStatus.getSelectedIndex()]));
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
