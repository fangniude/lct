package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3boundOnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3UnboundOnuTablePanel class. Created by DVM Creator
 */
public class Dot3boundOnuTablePanel extends UPanel
{

	private JLabel tfUtsDot3UnboundOnuModuleId = new JLabel();

	private JLabel tfUtsDot3UnboundOnuPortId = new JLabel();

	private JLabel tfUtsDot3UnboundOnuLlid = new JLabel();

	private MacAddressField tfUtsDot3UnboundOnuPonMacAddr = new MacAddressField();

	private final String utsDot3UnboundOnuModuleId = fStringMap
			.getString("utsDot3UnboundOnuModuleId")
			+ " : ";

	private final String utsDot3UnboundOnuPortId = fStringMap
			.getString("utsDot3UnboundOnuPortId")
			+ " : ";

	private final String utsDot3UnboundOnuLlid = fStringMap
			.getString("utsDot3UnboundOnuLlid")
			+ " : ";

	private final String utsDot3UnboundOnuPonMacAddr = fStringMap
			.getString("utsDot3UnboundOnuPonMacAddr")
			+ " : ";

	public Dot3boundOnuTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuModuleId));
		baseInfoPanel.add(tfUtsDot3UnboundOnuModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuPortId));
		baseInfoPanel.add(tfUtsDot3UnboundOnuPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuLlid));
		baseInfoPanel.add(tfUtsDot3UnboundOnuLlid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuPonMacAddr));
		tfUtsDot3UnboundOnuPonMacAddr.setValue( "00:00:00:00:00:00" );
		baseInfoPanel.add(tfUtsDot3UnboundOnuPonMacAddr);
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

//		tfUtsDot3UnboundOnuPonMacAddr.setEditable(false);

	}

	public void refresh()
	{
		Dot3boundOnuTable mbean = (Dot3boundOnuTable) getModel();

		tfUtsDot3UnboundOnuModuleId.setText(mbean.getUtsDot3DbaSlaModuleId().toString());
		tfUtsDot3UnboundOnuPortId.setText(mbean.getUtsDot3DbaSlaPortId().toString());
		tfUtsDot3UnboundOnuLlid.setText(mbean.getUtsDot3DbaSlaLogicalPortId().toString());
		tfUtsDot3UnboundOnuPonMacAddr.setValue(mbean.getUtsDot3DbaSlaBindingMacAddress());
	}

	public void updateModel()
	{

//		Dot3boundOnuTable mbean = (Dot3boundOnuTable) getModel();

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