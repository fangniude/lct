package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.QosExtDscpCosMapTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The QosExtDscpCosMapTablePanel class. Created by DVM Creator
 */
public class QosExtDscpCosMapTablePanel extends UPanel
{
//  private JLabel tfUtsMLSQosExtDscpCosMapIntfIndex = new JLabel();
	private JLabel tfUtsMLSQosExtDscpCosMapDscpVal = new JLabel();

	private IntegerTextField tfUtsMLSQosExtDscpCosMapCosVal = new IntegerTextField();

//  private final String utsMLSQosExtDscpCosMapIntfIndex = fStringMap.getString("utsMLSQosExtDscpCosMapIntfIndex") + " : ";
	private final String utsMLSQosExtDscpCosMapDscpVal = fStringMap
			.getString("utsMLSQosExtDscpCosMapDscpVal")
			+ " : ";
	private final String utsMLSQosExtDscpCosMapCosVal = fStringMap
			.getString("utsMLSQosExtDscpCosMapCosVal")
			+ " : ";

	public QosExtDscpCosMapTablePanel(IApplication app)
	{
		super(app);
        setModel(new QosExtDscpCosMapTable(app.getSnmpProxy()));

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

//    baseInfoPanel.add(new JLabel(utsMLSQosExtDscpCosMapIntfIndex));
//    baseInfoPanel.add(tfUtsMLSQosExtDscpCosMapIntfIndex);
//    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpCosMapDscpVal));
		baseInfoPanel.add(tfUtsMLSQosExtDscpCosMapDscpVal);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpCosMapCosVal));
		tfUtsMLSQosExtDscpCosMapCosVal.setName(fStringMap
				.getString("utsMLSQosExtDscpCosMapCosVal"));
		baseInfoPanel.add(tfUtsMLSQosExtDscpCosMapCosVal);
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
		tfUtsMLSQosExtDscpCosMapCosVal.setValueScope(0, 7);
	}

	public void refresh()
	{
		QosExtDscpCosMapTable mbean = (QosExtDscpCosMapTable) getModel();

//    tfUtsMLSQosExtDscpCosMapIntfIndex.setText(SwitchInterfaceIndexFormatter.format(mbean.getUtsMLSQosExtDscpCosMapIntfIndex()));
		tfUtsMLSQosExtDscpCosMapDscpVal.setText(mbean
				.getUtsMLSQosExtDscpCosMapDscpVal().toString());
		tfUtsMLSQosExtDscpCosMapCosVal.setValue(mbean
				.getUtsMLSQosExtDscpCosMapCosVal().intValue());
	}

	public void updateModel()
	{

		QosExtDscpCosMapTable mbean = (QosExtDscpCosMapTable) getModel();

		mbean.setUtsMLSQosExtDscpCosMapCosVal(new Integer(
				tfUtsMLSQosExtDscpCosMapCosVal.getValue()));
	}
}
