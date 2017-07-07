package com.winnertel.ems.epon.iad.bbs1000.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.QosExtDscpMutMapTable;
import com.winnertel.ems.epon.iad.bbs1000.formatter.SwitchInterfaceIndexFormatter;

/**
 * The QosExtDscpMutMapTablePanel class. Created by DVM Creator
 */
public class QosExtDscpMutMapTablePanel extends UPanel
{
  private JLabel tfUtsMLSQosExtDscpMutMapIntfIndex = new JLabel();
	private JLabel tfUtsMLSQosExtDscpMutMapDscpVal = new JLabel();

	private IntegerTextField tfUtsMLSQosExtDscpMutMapMutVal = new IntegerTextField();

  private final String utsMLSQosExtDscpMutMapIntfIndex = fStringMap.getString("utsMLSQosExtDscpMutMapIntfIndex") + " : ";
	private final String utsMLSQosExtDscpMutMapDscpVal = fStringMap
			.getString("utsMLSQosExtDscpMutMapDscpVal")
			+ " : ";

	private final String utsMLSQosExtDscpMutMapMutVal = fStringMap
			.getString("utsMLSQosExtDscpMutMapMutVal")
			+ " : ";

	public QosExtDscpMutMapTablePanel(IApplication app)
	{
		super(app);
        setModel(new QosExtDscpMutMapTable(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

    baseInfoPanel.add(new JLabel(utsMLSQosExtDscpMutMapIntfIndex));
    baseInfoPanel.add(tfUtsMLSQosExtDscpMutMapIntfIndex);
    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpMutMapDscpVal));
		baseInfoPanel.add(tfUtsMLSQosExtDscpMutMapDscpVal);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpMutMapMutVal));
		tfUtsMLSQosExtDscpMutMapMutVal.setName(fStringMap
				.getString("utsMLSQosExtDscpMutMapMutVal"));
		baseInfoPanel.add(tfUtsMLSQosExtDscpMutMapMutVal);
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

		tfUtsMLSQosExtDscpMutMapMutVal.setValueScope(0, 63);

	}

	public void refresh()
	{
		QosExtDscpMutMapTable mbean = (QosExtDscpMutMapTable) getModel();

    tfUtsMLSQosExtDscpMutMapIntfIndex.setText(SwitchInterfaceIndexFormatter.format(mbean.getUtsMLSQosExtDscpMutMapIntfIndex()));
		tfUtsMLSQosExtDscpMutMapDscpVal.setText(mbean.getUtsMLSQosExtDscpMutMapDscpVal().toString());
		tfUtsMLSQosExtDscpMutMapMutVal.setValue(mbean.getUtsMLSQosExtDscpMutMapMutVal().intValue());
	}

	public void updateModel()
	{
		QosExtDscpMutMapTable mbean = (QosExtDscpMutMapTable) getModel();

		mbean.setUtsMLSQosExtDscpMutMapMutVal(new Integer(tfUtsMLSQosExtDscpMutMapMutVal.getValue()));
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
