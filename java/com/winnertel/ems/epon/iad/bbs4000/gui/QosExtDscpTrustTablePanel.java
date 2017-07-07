package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.formatter.SwitchInterfaceIndexFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.QosExtDscpTrustTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The QosExtDscpTrustTablePanel class. Created by DVM Creator
 */
public class QosExtDscpTrustTablePanel extends UPanel
{
	private JLabel tfUtsMLSQosExtDscpTrustIntfIndex = new JLabel();
	private int[] utsMLSQosExtDscpTrustModeVList = new int[]
	{ 1, 3, 2, };

	private String[] utsMLSQosExtDscpTrustModeTList = new String[]
	{ fStringMap.getString("not-trusted"),
			fStringMap.getString("ip-precedence"),
			fStringMap.getString("trust-dscp"), };

	private JComboBox tfUtsMLSQosExtDscpTrustMode = new JComboBox(
			utsMLSQosExtDscpTrustModeTList);

	private int[] utsMLSQosExtDscpTrustIntfQosCtrlVList = new int[]
	{ 2, 1, };

	private String[] utsMLSQosExtDscpTrustIntfQosCtrlTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsMLSQosExtDscpTrustIntfQosCtrl = new JComboBox(
			utsMLSQosExtDscpTrustIntfQosCtrlTList);

	private final String utsMLSQosExtDscpTrustIntfIndex = fStringMap
			.getString("utsMLSQosExtDscpTrustIntfIndex")
			+ " : ";

	private final String utsMLSQosExtDscpTrustMode = fStringMap
			.getString("utsMLSQosExtDscpTrustMode")
			+ " : ";

	private final String utsMLSQosExtDscpTrustIntfQosCtrl = fStringMap
			.getString("utsMLSQosExtDscpTrustIntfQosCtrl")
			+ " : ";

	public QosExtDscpTrustTablePanel(IApplication app)
	{
		super(app);
        setModel(new QosExtDscpTrustTable(app.getSnmpProxy()));
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

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpTrustIntfIndex));
		baseInfoPanel.add(tfUtsMLSQosExtDscpTrustIntfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpTrustMode));
		tfUtsMLSQosExtDscpTrustMode.setName(fStringMap
				.getString("utsMLSQosExtDscpTrustMode"));
		baseInfoPanel.add(tfUtsMLSQosExtDscpTrustMode);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsMLSQosExtDscpTrustIntfQosCtrl));
		tfUtsMLSQosExtDscpTrustIntfQosCtrl.setName(fStringMap
				.getString("utsMLSQosExtDscpTrustIntfQosCtrl"));
		baseInfoPanel.add(tfUtsMLSQosExtDscpTrustIntfQosCtrl);
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

		QosExtDscpTrustTable mbean = (QosExtDscpTrustTable) getModel();

    tfUtsMLSQosExtDscpTrustIntfIndex.setText(SwitchInterfaceIndexFormatter.format(mbean.getUtsMLSQosExtDscpTrustIntfIndex()));
		tfUtsMLSQosExtDscpTrustMode.setSelectedIndex(getIndexFromValue(
				utsMLSQosExtDscpTrustModeVList, mbean
						.getUtsMLSQosExtDscpTrustMode().intValue()));
		tfUtsMLSQosExtDscpTrustIntfQosCtrl.setSelectedIndex(getIndexFromValue(
				utsMLSQosExtDscpTrustIntfQosCtrlVList, mbean
						.getUtsMLSQosExtDscpTrustIntfQosCtrl().intValue()));

	}

	public void updateModel()
	{

		QosExtDscpTrustTable mbean = (QosExtDscpTrustTable) getModel();

		mbean.setUtsMLSQosExtDscpTrustMode(new Integer(
				utsMLSQosExtDscpTrustModeVList[tfUtsMLSQosExtDscpTrustMode
						.getSelectedIndex()]));
		mbean.setUtsMLSQosExtDscpTrustIntfQosCtrl(new Integer(
						utsMLSQosExtDscpTrustIntfQosCtrlVList[tfUtsMLSQosExtDscpTrustIntfQosCtrl
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
