package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.IpRouteTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The IpRouteTablePanel class. Created by DVM Creator
 */
public class IpRouteTablePanel extends UPanel
{

	private JLabel tfUtsIpRouteEntryIndex = new JLabel();

	private int[] utsIpRouteEntryOwnerVList = new int[]
	{ 4, 1, 6, 3, 5, 2, };

	private String[] utsIpRouteEntryOwnerTList = new String[]
	{ fStringMap.getString("ospf"), fStringMap.getString("direct"),
			fStringMap.getString("other"), fStringMap.getString("rip"),
			fStringMap.getString("bgp"), fStringMap.getString("static"), };

	private JComboBox tfUtsIpRouteEntryOwner = new JComboBox(
			utsIpRouteEntryOwnerTList);

	private JLabel tfUtsIpRouteEntryIpAddr = new JLabel();

	private JLabel tfUtsIpRouteEntryIpMask = new JLabel();

	private int[] utsIpRouteEntryTypeVList = new int[]
	{ 6, 1, 5, 3, 4, 2, };

	private String[] utsIpRouteEntryTypeTList = new String[]
	{ fStringMap.getString("ospfnssa1"), fStringMap.getString("other"),
			fStringMap.getString("ospfnssa2"), fStringMap.getString("ospfe1"),
			fStringMap.getString("ospfe2"), fStringMap.getString("ospfia"), };

	private JComboBox tfUtsIpRouteEntryType = new JComboBox(
			utsIpRouteEntryTypeTList);

	private JLabel tfUtsIpRouteEntryCost = new JLabel();

	private JLabel tfUtsIpRouteEntryNextHop1 = new JLabel();

	private JLabel tfUtsIpRouteEntryNextHop2 = new JLabel();

	private JLabel tfUtsIpRouteEntryNextHop3 = new JLabel();

	private JLabel tfUtsIpRouteEntryNextHop4 = new JLabel();

	private JLabel tfUtsIpRouteEntryVlanId1 = new JLabel();

	private JLabel tfUtsIpRouteEntryVlanId2 = new JLabel();

	private JLabel tfUtsIpRouteEntryVlanId3 = new JLabel();

	private JLabel tfUtsIpRouteEntryVlanId4 = new JLabel();

	private final String utsIpRouteEntryIndex = fStringMap
			.getString("utsIpRouteEntryIndex")
			+ " : ";

	private final String utsIpRouteEntryOwner = fStringMap
			.getString("utsIpRouteEntryOwner")
			+ " : ";

	private final String utsIpRouteEntryIpAddr = fStringMap
			.getString("utsIpRouteEntryIpAddr")
			+ " : ";

	private final String utsIpRouteEntryIpMask = fStringMap
			.getString("utsIpRouteEntryIpMask")
			+ " : ";

	private final String utsIpRouteEntryType = fStringMap
			.getString("utsIpRouteEntryType")
			+ " : ";

	private final String utsIpRouteEntryCost = fStringMap
			.getString("utsIpRouteEntryCost")
			+ " : ";

	private final String utsIpRouteEntryNextHop1 = fStringMap
			.getString("utsIpRouteEntryNextHop1")
			+ " : ";

	private final String utsIpRouteEntryNextHop2 = fStringMap
			.getString("utsIpRouteEntryNextHop2")
			+ " : ";

	private final String utsIpRouteEntryNextHop3 = fStringMap
			.getString("utsIpRouteEntryNextHop3")
			+ " : ";

	private final String utsIpRouteEntryNextHop4 = fStringMap
			.getString("utsIpRouteEntryNextHop4")
			+ " : ";

	private final String utsIpRouteEntryVlanId1 = fStringMap
			.getString("utsIpRouteEntryVlanId1")
			+ " : ";

	private final String utsIpRouteEntryVlanId2 = fStringMap
			.getString("utsIpRouteEntryVlanId2")
			+ " : ";

	private final String utsIpRouteEntryVlanId3 = fStringMap
			.getString("utsIpRouteEntryVlanId3")
			+ " : ";

	private final String utsIpRouteEntryVlanId4 = fStringMap
			.getString("utsIpRouteEntryVlanId4")
			+ " : ";

	public IpRouteTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(14, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryIndex));
		baseInfoPanel.add(tfUtsIpRouteEntryIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryOwner));
		baseInfoPanel.add(tfUtsIpRouteEntryOwner);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryIpAddr));
		baseInfoPanel.add(tfUtsIpRouteEntryIpAddr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryIpMask));
		baseInfoPanel.add(tfUtsIpRouteEntryIpMask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryType));
		baseInfoPanel.add(tfUtsIpRouteEntryType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryCost));
		baseInfoPanel.add(tfUtsIpRouteEntryCost);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryNextHop1));
		baseInfoPanel.add(tfUtsIpRouteEntryNextHop1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryNextHop2));
		baseInfoPanel.add(tfUtsIpRouteEntryNextHop2);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryNextHop3));
		baseInfoPanel.add(tfUtsIpRouteEntryNextHop3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryNextHop4));
		baseInfoPanel.add(tfUtsIpRouteEntryNextHop4);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryVlanId1));
		baseInfoPanel.add(tfUtsIpRouteEntryVlanId1);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryVlanId2));
		baseInfoPanel.add(tfUtsIpRouteEntryVlanId2);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryVlanId3));
		baseInfoPanel.add(tfUtsIpRouteEntryVlanId3);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIpRouteEntryVlanId4));
		baseInfoPanel.add(tfUtsIpRouteEntryVlanId4);
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

		IpRouteTable mbean = (IpRouteTable) getModel();

		tfUtsIpRouteEntryIndex.setText(mbean.getUtsIpRouteEntryIndex()
				.toString());
		tfUtsIpRouteEntryOwner.setSelectedIndex(getIndexFromValue(
				utsIpRouteEntryOwnerVList, mbean.getUtsIpRouteEntryOwner()
						.intValue()));
		tfUtsIpRouteEntryIpAddr.setText(mbean.getUtsIpRouteEntryIpAddr());
		tfUtsIpRouteEntryIpMask.setText(mbean.getUtsIpRouteEntryIpMask());
		tfUtsIpRouteEntryType.setSelectedIndex(getIndexFromValue(
				utsIpRouteEntryTypeVList, mbean.getUtsIpRouteEntryType()
						.intValue()));
		tfUtsIpRouteEntryCost
				.setText(mbean.getUtsIpRouteEntryCost().toString());
		tfUtsIpRouteEntryNextHop1.setText(mbean.getUtsIpRouteEntryNextHop1());
		tfUtsIpRouteEntryNextHop2.setText(mbean.getUtsIpRouteEntryNextHop2());
		tfUtsIpRouteEntryNextHop3.setText(mbean.getUtsIpRouteEntryNextHop3());
		tfUtsIpRouteEntryNextHop4.setText(mbean.getUtsIpRouteEntryNextHop4());
		tfUtsIpRouteEntryVlanId1.setText(mbean.getUtsIpRouteEntryVlanId1()
				.toString());
		tfUtsIpRouteEntryVlanId2.setText(mbean.getUtsIpRouteEntryVlanId2()
				.toString());
		tfUtsIpRouteEntryVlanId3.setText(mbean.getUtsIpRouteEntryVlanId3()
				.toString());
		tfUtsIpRouteEntryVlanId4.setText(mbean.getUtsIpRouteEntryVlanId4()
				.toString());

	}

	public void updateModel()
	{

		IpRouteTable mbean = (IpRouteTable) getModel();
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
