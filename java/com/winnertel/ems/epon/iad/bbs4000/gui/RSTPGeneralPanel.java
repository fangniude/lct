package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.RSTPGeneral;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The RSTPGeneralPanel class. Created by DVM Creator
 */
public class RSTPGeneralPanel extends UPanel
{

	private JLabel tfUtsEponDot1dStpBridgeVlanID = new JLabel();

	private IntegerTextField tfUtsDot1dStpPriority = new IntegerTextField();

	private IntegerTextField tfUtsDot1dStpBridgeMaxAge = new IntegerTextField();

	private IntegerTextField tfUtsDot1dStpBridgeHelloTime = new IntegerTextField();

	private IntegerTextField tfUtsDot1dStpBridgeForwardDelay = new IntegerTextField();

	private final String utsEponDot1dStpBridgeVlanID = fStringMap
			.getString("utsEponDot1dStpBridgeVlanID")
			+ " : ";

	private final String utsDot1dStpPriority = fStringMap
			.getString("utsDot1dStpPriority")
			+ " : ";

	private final String utsDot1dStpBridgeMaxAge = fStringMap
			.getString("utsDot1dStpBridgeMaxAge")
			+ " : ";

	private final String utsDot1dStpBridgeHelloTime = fStringMap
			.getString("utsDot1dStpBridgeHelloTime")
			+ " : ";

	private final String utsDot1dStpBridgeForwardDelay = fStringMap
			.getString("utsDot1dStpBridgeForwardDelay")
			+ " : ";

	public RSTPGeneralPanel(IApplication app)
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

		baseInfoPanel.add(new JLabel(utsEponDot1dStpBridgeVlanID));
		baseInfoPanel.add(tfUtsEponDot1dStpBridgeVlanID);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot1dStpPriority));
		tfUtsDot1dStpPriority.setName(fStringMap
				.getString("utsDot1dStpPriority"));
		baseInfoPanel.add(tfUtsDot1dStpPriority);
		baseInfoPanel.add(new HSpacer());


		baseInfoPanel.add(new JLabel(utsDot1dStpBridgeMaxAge));
		tfUtsDot1dStpBridgeMaxAge.setName(fStringMap
				.getString("utsDot1dStpBridgeMaxAge"));
		baseInfoPanel.add(tfUtsDot1dStpBridgeMaxAge);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot1dStpBridgeHelloTime));
		tfUtsDot1dStpBridgeHelloTime.setName(fStringMap
				.getString("utsDot1dStpBridgeHelloTime"));
		baseInfoPanel.add(tfUtsDot1dStpBridgeHelloTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot1dStpBridgeForwardDelay));
		tfUtsDot1dStpBridgeForwardDelay.setName(fStringMap
				.getString("utsDot1dStpBridgeForwardDelay"));
		baseInfoPanel.add(tfUtsDot1dStpBridgeForwardDelay);
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

		tfUtsDot1dStpPriority.setValueScope(0, 65535);

		tfUtsDot1dStpBridgeMaxAge.setValueScope(6, 40);

		tfUtsDot1dStpBridgeHelloTime.setValueScope(1, 10);

		tfUtsDot1dStpBridgeForwardDelay.setValueScope(4, 30);

	}

	public void refresh()
	{

		RSTPGeneral mbean = (RSTPGeneral) getModel();

		tfUtsEponDot1dStpBridgeVlanID.setText(mbean
				.getUtsEponDot1dStpBridgeVlanID().toString());
		tfUtsDot1dStpPriority.setValue(mbean.getUtsDot1dStpPriority()
				.intValue());
		tfUtsDot1dStpBridgeMaxAge.setValue(mbean.getUtsDot1dStpBridgeMaxAge()
				.intValue());
		tfUtsDot1dStpBridgeHelloTime.setValue(mbean
				.getUtsDot1dStpBridgeHelloTime().intValue());
		tfUtsDot1dStpBridgeForwardDelay.setValue(mbean
				.getUtsDot1dStpBridgeForwardDelay().intValue());
	}

	public void updateModel()
	{
		RSTPGeneral mbean = (RSTPGeneral) getModel();

		mbean.setUtsDot1dStpPriority(new Integer(tfUtsDot1dStpPriority
				.getValue()));

		mbean.setUtsDot1dStpBridgeMaxAge(new Integer(tfUtsDot1dStpBridgeMaxAge
				.getValue()));
		mbean.setUtsDot1dStpBridgeHelloTime(new Integer(
				tfUtsDot1dStpBridgeHelloTime.getValue()));
		mbean.setUtsDot1dStpBridgeForwardDelay(new Integer(
				tfUtsDot1dStpBridgeForwardDelay.getValue()));
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
