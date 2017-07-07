package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.IgmpSnoopCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The IgmpSnoopCfgTablePanel class. Created by DVM Creator
 */
public class IgmpSnoopCfgTablePanel extends UPanel
{

	private JLabel tfUtsIgmpSnoopVlanId = new JLabel();

	private IntegerTextField tfUtsIgmpSnoopLastMembAgeTmr = new IntegerTextField();

	private IntegerTextField tfUtsIgmpSnoopMCAgeTmr = new IntegerTextField();

	private IntegerTextField tfUtsIgmpSnoopRouterAgeTmr = new IntegerTextField();

	private IntegerTextField tfUtsIgmpSnoopSrcOnlyMcAgeTmr = new IntegerTextField();

	private final String utsIgmpSnoopVlanId = fStringMap
			.getString("utsIgmpSnoopVlanId")
			+ " : ";

	private final String utsIgmpSnoopLastMembAgeTmr = fStringMap
			.getString("utsIgmpSnoopLastMembAgeTmr")
			+ " : ";

	private final String utsIgmpSnoopMCAgeTmr = fStringMap
			.getString("utsIgmpSnoopMCAgeTmr")
			+ " : ";

	private final String utsIgmpSnoopRouterAgeTmr = fStringMap
			.getString("utsIgmpSnoopRouterAgeTmr")
			+ " : ";

	private final String utsIgmpSnoopSrcOnlyMcAgeTmr = fStringMap
			.getString("utsIgmpSnoopSrcOnlyMcAgeTmr")
			+ " : ";

	public IgmpSnoopCfgTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsIgmpSnoopVlanId));
		baseInfoPanel.add(tfUtsIgmpSnoopVlanId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpSnoopLastMembAgeTmr));
		tfUtsIgmpSnoopLastMembAgeTmr.setName(fStringMap
				.getString("utsIgmpSnoopLastMembAgeTmr"));
		baseInfoPanel.add(tfUtsIgmpSnoopLastMembAgeTmr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpSnoopMCAgeTmr));
		tfUtsIgmpSnoopMCAgeTmr.setName(fStringMap
				.getString("utsIgmpSnoopMCAgeTmr"));
		baseInfoPanel.add(tfUtsIgmpSnoopMCAgeTmr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpSnoopRouterAgeTmr));
		tfUtsIgmpSnoopRouterAgeTmr.setName(fStringMap
				.getString("utsIgmpSnoopRouterAgeTmr"));
		baseInfoPanel.add(tfUtsIgmpSnoopRouterAgeTmr);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpSnoopSrcOnlyMcAgeTmr));
		tfUtsIgmpSnoopSrcOnlyMcAgeTmr.setName(fStringMap
				.getString("utsIgmpSnoopSrcOnlyMcAgeTmr"));
		baseInfoPanel.add(tfUtsIgmpSnoopSrcOnlyMcAgeTmr);
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

		tfUtsIgmpSnoopLastMembAgeTmr.setValueScope(1, 65535);

		tfUtsIgmpSnoopMCAgeTmr.setValueScope(1, 65535);

		tfUtsIgmpSnoopRouterAgeTmr.setValueScope(1, 65535);

		tfUtsIgmpSnoopSrcOnlyMcAgeTmr.setValueScope(1, 65535);

	}

	public void refresh()
	{

		IgmpSnoopCfgTable mbean = (IgmpSnoopCfgTable) getModel();

		tfUtsIgmpSnoopVlanId.setText(mbean.getUtsIgmpSnoopVlanId().toString());
		tfUtsIgmpSnoopLastMembAgeTmr.setValue(mbean
				.getUtsIgmpSnoopLastMembAgeTmr().intValue());
		tfUtsIgmpSnoopMCAgeTmr.setValue(mbean.getUtsIgmpSnoopMCAgeTmr()
				.intValue());
		tfUtsIgmpSnoopRouterAgeTmr.setValue(mbean.getUtsIgmpSnoopRouterAgeTmr()
				.intValue());
		tfUtsIgmpSnoopSrcOnlyMcAgeTmr.setValue(mbean
				.getUtsIgmpSnoopSrcOnlyMcAgeTmr().intValue());

	}

	public void updateModel()
	{

		IgmpSnoopCfgTable mbean = (IgmpSnoopCfgTable) getModel();

		mbean.setUtsIgmpSnoopLastMembAgeTmr(new Integer(
				tfUtsIgmpSnoopLastMembAgeTmr.getValue()));
		mbean.setUtsIgmpSnoopMCAgeTmr(new Integer(tfUtsIgmpSnoopMCAgeTmr
				.getValue()));
		mbean.setUtsIgmpSnoopRouterAgeTmr(new Integer(
				tfUtsIgmpSnoopRouterAgeTmr.getValue()));
		mbean.setUtsIgmpSnoopSrcOnlyMcAgeTmr(new Integer(
				tfUtsIgmpSnoopSrcOnlyMcAgeTmr.getValue()));
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
