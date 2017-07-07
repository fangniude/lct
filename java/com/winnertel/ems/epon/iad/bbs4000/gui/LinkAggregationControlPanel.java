package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregationControl;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The LinkAggregationControlPanel class. Created by DVM Creator
 */
public class LinkAggregationControlPanel extends UPanel
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

	private JLabel tfUtsSwitchPortExtIfNum = new JLabel();

	private JLabel tfUtsSwitchPortExtModuleId = new JLabel();

	private JLabel tfUtsSwitchPortExtPortId = new JLabel();

	private JLabel tfUtsSwitchPortExtLAGId = new JLabel();

	private int[] utsSwitchPortExtPortTypeVList = new int[]
	{ 1, 2, };

	private String[] utsSwitchPortExtPortTypeTList = new String[]
	{ fStringMap.getString("gePort"), fStringMap.getString("lagPort"), };

	private JComboBox tfUtsSwitchPortExtPortType = new JComboBox(
			utsSwitchPortExtPortTypeTList);

	private int[] utsSwitchPortExtACLDefActionVList = new int[]
	{ 1, 2, };

	private String[] utsSwitchPortExtACLDefActionTList = new String[]
	{ fStringMap.getString("preConfiguration"),
			fStringMap.getString("noPreConfiguration"), };

	private JComboBox tfUtsSwitchPortExtACLDefAction = new JComboBox(
			utsSwitchPortExtACLDefActionTList);

	private int[] utsSwitchPortExtAdmFlowControlRxVList = new int[]
	{ 2, 1, };

	private String[] utsSwitchPortExtAdmFlowControlRxTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsSwitchPortExtAdmFlowControlRx = new JComboBox(
			utsSwitchPortExtAdmFlowControlRxTList);

	private int[] utsSwitchPortExtAdmFlowControlTxVList = new int[]
	{ 2, 1, };

	private String[] utsSwitchPortExtAdmFlowControlTxTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsSwitchPortExtAdmFlowControlTx = new JComboBox(
			utsSwitchPortExtAdmFlowControlTxTList);

	private int[] utsSwitchPortExtIpMuticastFilterVList = new int[]
	{ 2, 1, };

	private String[] utsSwitchPortExtIpMuticastFilterTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsSwitchPortExtIpMuticastFilter = new JComboBox(
			utsSwitchPortExtIpMuticastFilterTList);

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

	private final String utsSwitchPortExtIfNum = fStringMap
			.getString("utsSwitchPortExtIfNum")
			+ " : ";

	private final String utsSwitchPortExtModuleId = fStringMap
			.getString("utsSwitchPortExtModuleId")
			+ " : ";

	private final String utsSwitchPortExtPortId = fStringMap
			.getString("utsSwitchPortExtPortId")
			+ " : ";

	private final String utsSwitchPortExtLAGId = fStringMap
			.getString("utsSwitchPortExtLAGId")
			+ " : ";

	private final String utsSwitchPortExtPortType = fStringMap
			.getString("utsSwitchPortExtPortType")
			+ " : ";

	private final String utsSwitchPortExtACLDefAction = fStringMap
			.getString("utsSwitchPortExtACLDefAction")
			+ " : ";

	private final String utsSwitchPortExtAdmFlowControlRx = fStringMap
			.getString("utsSwitchPortExtAdmFlowControlRx")
			+ " : ";

	private final String utsSwitchPortExtAdmFlowControlTx = fStringMap
			.getString("utsSwitchPortExtAdmFlowControlTx")
			+ " : ";

	private final String utsSwitchPortExtIpMuticastFilter = fStringMap
			.getString("utsSwitchPortExtIpMuticastFilter")
			+ " : ";

	private SnmpApplyButton btApply;

	private SnmpRefreshButton btRefresh;

	public LinkAggregationControlPanel(IApplication app)
	{
		super(app);
		setModel(new LinkAggregationControl(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		btApply = new SnmpApplyButton(fApplication, this);
		btApply.getAction().putValue(BaseAction.ID,
				"Modify_LinkAggregationControl");
		btRefresh = new SnmpRefreshButton(fApplication, this);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(btApply);
		buttonsPanel.add(btRefresh);

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
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

		baseInfoPanel.add(new JLabel(utsSwitchPortExtIfNum));
		baseInfoPanel.add(tfUtsSwitchPortExtIfNum);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtModuleId));
		baseInfoPanel.add(tfUtsSwitchPortExtModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtPortId));
		baseInfoPanel.add(tfUtsSwitchPortExtPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtLAGId));
		baseInfoPanel.add(tfUtsSwitchPortExtLAGId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtPortType));
		baseInfoPanel.add(tfUtsSwitchPortExtPortType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtACLDefAction));
		tfUtsSwitchPortExtACLDefAction.setName(fStringMap
				.getString("utsSwitchPortExtACLDefAction"));
		baseInfoPanel.add(tfUtsSwitchPortExtACLDefAction);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtAdmFlowControlRx));
		tfUtsSwitchPortExtAdmFlowControlRx.setName(fStringMap
				.getString("utsSwitchPortExtAdmFlowControlRx"));
		baseInfoPanel.add(tfUtsSwitchPortExtAdmFlowControlRx);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtAdmFlowControlTx));
		tfUtsSwitchPortExtAdmFlowControlTx.setName(fStringMap
				.getString("utsSwitchPortExtAdmFlowControlTx"));
		baseInfoPanel.add(tfUtsSwitchPortExtAdmFlowControlTx);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsSwitchPortExtIpMuticastFilter));
		tfUtsSwitchPortExtIpMuticastFilter.setName(fStringMap
				.getString("utsSwitchPortExtIpMuticastFilter"));
		baseInfoPanel.add(tfUtsSwitchPortExtIpMuticastFilter);
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

		LinkAggregationControl mbean = (LinkAggregationControl) getModel();
		BeanService.refreshBean(fApplication, mbean);

		tfUtsIntfRateControlUplinkSpeed.setSelectedIndex(getIndexFromValue(
				utsIntfRateControlUplinkSpeedVList, mbean
						.getUtsIntfRateControlUplinkSpeed().intValue()));
		tfUtsIntfRateControlVlanIngressFilter
				.setSelectedIndex(getIndexFromValue(
						utsIntfRateControlVlanIngressFilterVList, mbean
								.getUtsIntfRateControlVlanIngressFilter()
								.intValue()));
		tfUtsIntfRateControlUplinkTranceiverType
				.setSelectedIndex(getIndexFromValue(
						utsIntfRateControlUplinkTranceiverTypeVList, mbean
								.getUtsIntfRateControlUplinkTranceiverType()
								.intValue()));
		tfUtsIntfRateControlAutoNegotiation.setSelectedIndex(getIndexFromValue(
				utsIntfRateControlAutoNegotiationVList, mbean
						.getUtsIntfRateControlAutoNegotiation().intValue()));
		tfUtsSwitchPortExtIfNum.setText(mbean.getUtsSwitchPortExtIfNum()
				.toString());
		tfUtsSwitchPortExtModuleId.setText(mbean.getUtsSwitchPortExtModuleId()
				.toString());
		tfUtsSwitchPortExtPortId.setText(mbean.getUtsSwitchPortExtPortId()
				.toString());
		tfUtsSwitchPortExtLAGId.setText(mbean.getUtsSwitchPortExtLAGId()
				.toString());
		tfUtsSwitchPortExtPortType.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtPortTypeVList, mbean
						.getUtsSwitchPortExtPortType().intValue()));
		tfUtsSwitchPortExtACLDefAction.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtACLDefActionVList, mbean
						.getUtsSwitchPortExtACLDefAction().intValue()));
		tfUtsSwitchPortExtAdmFlowControlRx.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtAdmFlowControlRxVList, mbean
						.getUtsSwitchPortExtAdmFlowControlRx().intValue()));
		tfUtsSwitchPortExtAdmFlowControlTx.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtAdmFlowControlTxVList, mbean
						.getUtsSwitchPortExtAdmFlowControlTx().intValue()));
		tfUtsSwitchPortExtIpMuticastFilter.setSelectedIndex(getIndexFromValue(
				utsSwitchPortExtIpMuticastFilterVList, mbean
						.getUtsSwitchPortExtIpMuticastFilter().intValue()));

	}

	public void updateModel()
	{

		LinkAggregationControl mbean = (LinkAggregationControl) getModel();

		mbean.setUtsIntfRateControlUplinkSpeed(new Integer(
						utsIntfRateControlUplinkSpeedVList[tfUtsIntfRateControlUplinkSpeed
								.getSelectedIndex()]));
		mbean.setUtsIntfRateControlVlanIngressFilter(new Integer(
						utsIntfRateControlVlanIngressFilterVList[tfUtsIntfRateControlVlanIngressFilter
								.getSelectedIndex()]));

		mbean.setUtsIntfRateControlAutoNegotiation(new Integer(
						utsIntfRateControlAutoNegotiationVList[tfUtsIntfRateControlAutoNegotiation
								.getSelectedIndex()]));

		mbean.setUtsSwitchPortExtACLDefAction(new Integer(
						utsSwitchPortExtACLDefActionVList[tfUtsSwitchPortExtACLDefAction
								.getSelectedIndex()]));
		mbean.setUtsSwitchPortExtAdmFlowControlRx(new Integer(
						utsSwitchPortExtAdmFlowControlRxVList[tfUtsSwitchPortExtAdmFlowControlRx
								.getSelectedIndex()]));
		mbean.setUtsSwitchPortExtAdmFlowControlTx(new Integer(
						utsSwitchPortExtAdmFlowControlTxVList[tfUtsSwitchPortExtAdmFlowControlTx
								.getSelectedIndex()]));
		mbean.setUtsSwitchPortExtIpMuticastFilter(new Integer(
						utsSwitchPortExtIpMuticastFilterVList[tfUtsSwitchPortExtIpMuticastFilter
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
