package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs4000.mib.RSTPPort;
import com.winnertel.ems.epon.iad.bbs1000.formatter.IfIdFormatter;

import javax.swing.*;
import java.awt.*;

public class RSTPPortPanel extends UPanel
{
	private JLabel tfUtsEponDot1dStpPortIntfIndex = new JLabel();

	private JLabel tfUtsEponDot1dStpPortVlanID = new JLabel();

	private IntegerTextField tfUtsEponDot1dStpPortPriority = new IntegerTextField();

	private IntegerTextField tfUtsEponDot1dStpPortPathCost = new IntegerTextField();

	private int[] utsEponDot1dStpPortFastEnableVList = new int[]
	{ 2, 1, };

	private String[] utsEponDot1dStpPortFastEnableTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsEponDot1dStpPortFastEnable = new JComboBox(
			utsEponDot1dStpPortFastEnableTList);

	private final String utsEponDot1dStpPortIntfIndex = fStringMap
			.getString("utsEponDot1dStpPortIntfIndex")
			+ " : ";

	private final String utsEponDot1dStpPortVlanID = fStringMap
			.getString("utsEponDot1dStpPortVlanID")
			+ " : ";

	private final String utsEponDot1dStpPortPriority = fStringMap
			.getString("utsEponDot1dStpPortPriority")
			+ " : ";

	private final String utsEponDot1dStpPortPathCost = fStringMap
			.getString("utsEponDot1dStpPortPathCost")
			+ " : ";

	private final String utsEponDot1dStpPortFastEnable = fStringMap
			.getString("utsEponDot1dStpPortFastEnable")
			+ " : ";

	public RSTPPortPanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsEponDot1dStpPortIntfIndex));
		baseInfoPanel.add(tfUtsEponDot1dStpPortIntfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponDot1dStpPortVlanID));
		baseInfoPanel.add(tfUtsEponDot1dStpPortVlanID);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponDot1dStpPortPriority));
		tfUtsEponDot1dStpPortPriority.setName(fStringMap
				.getString("utsEponDot1dStpPortPriority"));
		baseInfoPanel.add(tfUtsEponDot1dStpPortPriority);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponDot1dStpPortPathCost));
		tfUtsEponDot1dStpPortPathCost.setName(fStringMap
				.getString("utsEponDot1dStpPortPathCost"));
		baseInfoPanel.add(tfUtsEponDot1dStpPortPathCost);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponDot1dStpPortFastEnable));
		tfUtsEponDot1dStpPortFastEnable.setName(fStringMap
				.getString("utsEponDot1dStpPortFastEnable"));
		baseInfoPanel.add(tfUtsEponDot1dStpPortFastEnable);
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
		tfUtsEponDot1dStpPortPriority.setValueScope(0, 240);
		tfUtsEponDot1dStpPortPathCost.setValueScope(1, 20000000);
	}

	public void refresh()
	{
		RSTPPort mbean = (RSTPPort) getModel();

		tfUtsEponDot1dStpPortIntfIndex.setText(IfIdFormatter.format(mbean
				.getUtsEponDot1dStpPortIntfIndex()));
		tfUtsEponDot1dStpPortVlanID.setText(mbean
				.getUtsEponDot1dStpPortVlanID().toString());
		tfUtsEponDot1dStpPortPriority.setValue(mbean
				.getUtsEponDot1dStpPortPriority().intValue());
		tfUtsEponDot1dStpPortPathCost.setValue(mbean
				.getUtsEponDot1dStpPortPathCost().intValue());
		tfUtsEponDot1dStpPortFastEnable.setSelectedIndex(getIndexFromValue(
				utsEponDot1dStpPortFastEnableVList, mbean
						.getUtsEponDot1dStpPortFastEnable().intValue()));
	}

	public void updateModel()
	{
		RSTPPort mbean = (RSTPPort) getModel();

		mbean.setUtsEponDot1dStpPortPriority(new Integer(
				tfUtsEponDot1dStpPortPriority.getValue()));

		mbean.setUtsEponDot1dStpPortPathCost(new Integer(
				tfUtsEponDot1dStpPortPathCost.getValue()));

		mbean
				.setUtsEponDot1dStpPortFastEnable(new Integer(
						utsEponDot1dStpPortFastEnableVList[tfUtsEponDot1dStpPortFastEnable
								.getSelectedIndex()]));
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
