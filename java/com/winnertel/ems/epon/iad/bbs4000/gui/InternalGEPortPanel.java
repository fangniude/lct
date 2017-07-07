package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.InternalGEPort;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The InternalGEPortPanel class. Created by DVM Creator
 */
public class InternalGEPortPanel extends UPanel
{

	private int[] utsIntfRateControlUplinkSpeedVList = new int[]
	{ 100, 1000, 10, };

	private String[] utsIntfRateControlUplinkSpeedTList = new String[]
	{ fStringMap.getString("hundred-mega"), fStringMap.getString("giga-mega"),
			fStringMap.getString("ten-mega"), };

	private JComboBox tfUtsIntfRateControlUplinkSpeed = new JComboBox(
			utsIntfRateControlUplinkSpeedTList);

	private int[] utsIntfRateControlVlanIngressFilterVList = new int[]
	{ 2, 1, };

	private String[] utsIntfRateControlVlanIngressFilterTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsIntfRateControlVlanIngressFilter = new JComboBox(
			utsIntfRateControlVlanIngressFilterTList);

	private int[] utsIntfRateControlUplinkTranceiverTypeVList = new int[]
	{ 1, 2, };

	private String[] utsIntfRateControlUplinkTranceiverTypeTList = new String[]
	{ fStringMap.getString("optical"), fStringMap.getString("copper"), };

	private JComboBox tfUtsIntfRateControlUplinkTranceiverType = new JComboBox(
			utsIntfRateControlUplinkTranceiverTypeTList);

	private int[] utsIntfRateControlAutoNegotiationVList = new int[]
	{ 2, 1, };

	private String[] utsIntfRateControlAutoNegotiationTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsIntfRateControlAutoNegotiation = new JComboBox(
			utsIntfRateControlAutoNegotiationTList);

	private final String utsIntfRateControlUplinkSpeed = fStringMap
			.getString("utsIntfRateControlUplinkSpeed")
			+ " : ";

	private final String utsIntfRateControlVlanIngressFilter = fStringMap
			.getString("utsIntfRateControlVlanIngressFilter")
			+ " : ";

	private final String utsIntfRateControlUplinkTranceiverType = fStringMap
			.getString("utsIntfRateControlUplinkTranceiverType")
			+ " : ";

	private final String utsIntfRateControlAutoNegotiation = fStringMap
			.getString("utsIntfRateControlAutoNegotiation")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public InternalGEPortPanel(IApplication app)
	{
		super(app);
		setModel(new InternalGEPort(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID, "Modify_InternalGEPort");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsIntfRateControlUplinkSpeed));
		tfUtsIntfRateControlUplinkSpeed.setName(fStringMap
				.getString("utsIntfRateControlUplinkSpeed"));
		baseInfoPanel.add(tfUtsIntfRateControlUplinkSpeed);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIntfRateControlVlanIngressFilter));
		tfUtsIntfRateControlVlanIngressFilter.setName(fStringMap
				.getString("utsIntfRateControlVlanIngressFilter"));
		baseInfoPanel.add(tfUtsIntfRateControlVlanIngressFilter);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIntfRateControlUplinkTranceiverType));
		baseInfoPanel.add(tfUtsIntfRateControlUplinkTranceiverType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIntfRateControlAutoNegotiation));
		tfUtsIntfRateControlAutoNegotiation.setName(fStringMap
				.getString("utsIntfRateControlAutoNegotiation"));
		baseInfoPanel.add(tfUtsIntfRateControlAutoNegotiation);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
        allPanel.add(buttonsPanel);
        allPanel.add(new VSpacer());



        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        SnmpTablePane tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("SwitchPortExtTable_Panel");
        tablepanel1.setPreferredSize(new Dimension(100, 300));

        allPanel.add(tablepanel1);

        setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);

        tablepanel1.refresh();
	}

	protected void initForm()
	{

	}

	public void refresh()
	{

//		InternalGEPort mbean = (InternalGEPort) getModel();
//		BeanService.refreshBean(fApplication, mbean);
//
//		tfUtsIntfRateControlUplinkSpeed.setSelectedIndex(getIndexFromValue(
//				utsIntfRateControlUplinkSpeedVList, mbean.getUtsIntfRateControlUplinkSpeed().intValue()));
//		tfUtsIntfRateControlVlanIngressFilter
//				.setSelectedIndex(getIndexFromValue(utsIntfRateControlVlanIngressFilterVList, mbean
//								.getUtsIntfRateControlVlanIngressFilter().intValue()));
//		tfUtsIntfRateControlUplinkTranceiverType.setSelectedIndex(getIndexFromValue(
//						utsIntfRateControlUplinkTranceiverTypeVList, mbean
//								.getUtsIntfRateControlUplinkTranceiverType().intValue()));
//		tfUtsIntfRateControlAutoNegotiation.setSelectedIndex(getIndexFromValue(
//				utsIntfRateControlAutoNegotiationVList, mbean
//						.getUtsIntfRateControlAutoNegotiation().intValue()));

	}

	public void updateModel()
	{

		InternalGEPort mbean = (InternalGEPort) getModel();

		mbean.setUtsIntfRateControlUplinkSpeed(new Integer(
						utsIntfRateControlUplinkSpeedVList[tfUtsIntfRateControlUplinkSpeed
								.getSelectedIndex()]));
		mbean.setUtsIntfRateControlVlanIngressFilter(new Integer(
						utsIntfRateControlVlanIngressFilterVList[tfUtsIntfRateControlVlanIngressFilter
								.getSelectedIndex()]));

		mbean.setUtsIntfRateControlAutoNegotiation(new Integer(
						utsIntfRateControlAutoNegotiationVList[tfUtsIntfRateControlAutoNegotiation
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