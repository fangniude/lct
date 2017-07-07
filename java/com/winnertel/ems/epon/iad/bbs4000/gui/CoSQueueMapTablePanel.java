package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.CoSQueueMapTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The CoSQueueMapTablePanel class. Created by DVM Creator
 */
public class CoSQueueMapTablePanel extends UPanel
{

	private JLabel tfUtsMLSQosExtCosPriority = new JLabel();

	private String[] tfUtsMLSQosExtCosQueueNumList = new String[]
	{ "0", "1", "2", "3", "4", "5", "6", "7" };

	private JComboBox tfUtsMLSQosExtCosQueueNum = new JComboBox(
			tfUtsMLSQosExtCosQueueNumList);

	// private IntegerTextField tfUtsMLSQosExtCosQueueNum = new
	// IntegerTextField();

	private final String utsMLSQosExtCosPriority = fStringMap
			.getString("utsMLSQosExtCosPriority")
			+ " : ";

	private final String utsMLSQosExtCosQueueNum = fStringMap
			.getString("utsMLSQosExtCosQueueNum")
			+ " : ";

	public CoSQueueMapTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsMLSQosExtCosPriority));
		baseInfoPanel.add(tfUtsMLSQosExtCosPriority);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtCosQueueNum));
		tfUtsMLSQosExtCosQueueNum.setName(fStringMap
				.getString("utsMLSQosExtCosQueueNum"));
		tfUtsMLSQosExtCosQueueNum.setPreferredSize( new Dimension( 100,30 ) );
		baseInfoPanel.add(tfUtsMLSQosExtCosQueueNum);
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

		CoSQueueMapTable mbean = (CoSQueueMapTable) getModel();

		tfUtsMLSQosExtCosPriority.setText(mbean.getUtsMLSQosExtCosPriority()
				.toString());
		tfUtsMLSQosExtCosQueueNum.setSelectedIndex(mbean
				.getUtsMLSQosExtCosQueueNum().intValue());

	}

	public void updateModel()
	{

		CoSQueueMapTable mbean = (CoSQueueMapTable) getModel();

		mbean.setUtsMLSQosExtCosQueueNum(new Integer(
				tfUtsMLSQosExtCosQueueNumList[tfUtsMLSQosExtCosQueueNum
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
