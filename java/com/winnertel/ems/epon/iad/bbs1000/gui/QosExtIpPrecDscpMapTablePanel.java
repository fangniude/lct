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
import com.winnertel.ems.epon.iad.bbs1000.mib.QosExtIpPrecDscpMapTable;
import com.winnertel.ems.epon.iad.bbs1000.formatter.SwitchInterfaceIndexFormatter;

/**
 * The QosExtIpPrecDscpMapTablePanel class. Created by DVM Creator
 */
public class QosExtIpPrecDscpMapTablePanel extends UPanel
{
  private JLabel tfUtsMLSQosExtIpPrecDscpMapIntfIndex = new JLabel();
	private JLabel tfUtsMLSQosExtIpPrecDscpMapIpPrecVal = new JLabel();

	private IntegerTextField tfUtsMLSQosExtIpPrecDscpMapDscpVal = new IntegerTextField();

  private final String utsMLSQosExtIpPrecDscpMapIntfIndex = fStringMap.getString("utsMLSQosExtIpPrecDscpMapIntfIndex") + " : ";
	private final String utsMLSQosExtIpPrecDscpMapIpPrecVal = fStringMap.getString("utsMLSQosExtIpPrecDscpMapIpPrecVal") + " : ";
	private final String utsMLSQosExtIpPrecDscpMapDscpVal = fStringMap.getString("utsMLSQosExtIpPrecDscpMapDscpVal") + " : ";

	public QosExtIpPrecDscpMapTablePanel(IApplication app)
	{
		super(app);
    setModel(new QosExtIpPrecDscpMapTable(app.getSnmpProxy()));
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

    baseInfoPanel.add(new JLabel(utsMLSQosExtIpPrecDscpMapIntfIndex));
    baseInfoPanel.add(tfUtsMLSQosExtIpPrecDscpMapIntfIndex);
    baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtIpPrecDscpMapIpPrecVal));
		baseInfoPanel.add(tfUtsMLSQosExtIpPrecDscpMapIpPrecVal);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtIpPrecDscpMapDscpVal));
		tfUtsMLSQosExtIpPrecDscpMapDscpVal.setName(fStringMap
				.getString("utsMLSQosExtIpPrecDscpMapDscpVal"));
		baseInfoPanel.add(tfUtsMLSQosExtIpPrecDscpMapDscpVal);
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
		tfUtsMLSQosExtIpPrecDscpMapDscpVal.setValueScope(0, 63);
	}

	public void refresh()
	{
		QosExtIpPrecDscpMapTable mbean = (QosExtIpPrecDscpMapTable) getModel();

    tfUtsMLSQosExtIpPrecDscpMapIntfIndex.setText(SwitchInterfaceIndexFormatter.format(mbean.getUtsMLSQosExtIpPrecDscpMapIntfIndex()));
		tfUtsMLSQosExtIpPrecDscpMapIpPrecVal.setText(mbean.getUtsMLSQosExtIpPrecDscpMapIpPrecVal().toString());
    tfUtsMLSQosExtIpPrecDscpMapDscpVal.setValue(mbean.getUtsMLSQosExtIpPrecDscpMapDscpVal().intValue());

	}

	public void updateModel()
	{
		QosExtIpPrecDscpMapTable mbean = (QosExtIpPrecDscpMapTable) getModel();

		mbean.setUtsMLSQosExtIpPrecDscpMapDscpVal(new Integer(tfUtsMLSQosExtIpPrecDscpMapDscpVal.getValue()));
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
