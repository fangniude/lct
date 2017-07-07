package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3DbaOltTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dot3DbaOltTablePanel class. Created by DVM Creator
 */
public class Dot3DbaOltTablePanel extends UPanel
{

	private JLabel tfIfIndex = new JLabel();

	private int[] utsDot3DbaOltAlgorithmVList = new int[]
	{ 1, 5, };

	private String[] utsDot3DbaOltAlgorithmTList = new String[]
	{ fStringMap.getString("internalEqualShare"),
			fStringMap.getString("plato"), };

	private JComboBox tfUtsDot3DbaOltAlgorithm = new JComboBox(
			utsDot3DbaOltAlgorithmTList);

	private IntegerTextField tfUtsDot3DbaOltDiscoverySize = new IntegerTextField();

	private IntegerTextField tfUtsDot3DbaOltDiscoveryFreq = new IntegerTextField();

	private IntegerTextField tfUtsDot3DbaOltCycleSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3DbaOltPlatoCycleSize = new IntegerTextField();

	private IntegerTextField tfUtsDot3DbaOltPlatoDiscoveryFreq = new IntegerTextField();

	private final String ifIndex = fStringMap.getString("ifIndex") + " : ";

	private final String utsDot3DbaOltAlgorithm = fStringMap
			.getString("utsDot3DbaOltAlgorithm")
			+ " : ";

	private final String utsDot3DbaOltDiscoverySize = fStringMap
			.getString("utsDot3DbaOltDiscoverySize")
			+ " : ";

	private final String utsDot3DbaOltDiscoveryFreq = fStringMap
			.getString("utsDot3DbaOltDiscoveryFreq")
			+ " : ";

	private final String utsDot3DbaOltCycleSize = fStringMap
			.getString("utsDot3DbaOltCycleSize")
			+ " : ";

	private final String utsDot3DbaOltPlatoCycleSize = fStringMap
			.getString("utsDot3DbaOltPlatoCycleSize")
			+ " : ";

	private final String utsDot3DbaOltPlatoDiscoveryFreq = fStringMap
			.getString("utsDot3DbaOltPlatoDiscoveryFreq")
			+ " : ";

	public Dot3DbaOltTablePanel(IApplication app)
	{
		super(app);
		setModel(new Dot3DbaOltTable(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3DbaOltAlgorithm));
		tfUtsDot3DbaOltAlgorithm.setName(fStringMap
				.getString("utsDot3DbaOltAlgorithm"));
		baseInfoPanel.add(tfUtsDot3DbaOltAlgorithm);
		baseInfoPanel.add(new HSpacer());

        tfUtsDot3DbaOltAlgorithm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int index = tfUtsDot3DbaOltAlgorithm.getSelectedIndex();
                if(index == 0){
                    tfUtsDot3DbaOltDiscoverySize.setEnabled(true);
                    tfUtsDot3DbaOltDiscoveryFreq.setEnabled(true);
                    tfUtsDot3DbaOltCycleSize.setEnabled(true);
                }
                else if(index == 1){
                    tfUtsDot3DbaOltDiscoverySize.setEnabled(false);
                    tfUtsDot3DbaOltDiscoveryFreq.setEnabled(false);
                    tfUtsDot3DbaOltCycleSize.setEnabled(false);
                }
            }
        });

		baseInfoPanel.add(new JLabel(utsDot3DbaOltDiscoverySize));
		tfUtsDot3DbaOltDiscoverySize.setName(fStringMap
				.getString("utsDot3DbaOltDiscoverySize"));
		baseInfoPanel.add(tfUtsDot3DbaOltDiscoverySize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3DbaOltDiscoveryFreq));
		tfUtsDot3DbaOltDiscoveryFreq.setName(fStringMap
				.getString("utsDot3DbaOltDiscoveryFreq"));
		baseInfoPanel.add(tfUtsDot3DbaOltDiscoveryFreq);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3DbaOltCycleSize));
		tfUtsDot3DbaOltCycleSize.setName(fStringMap
				.getString("utsDot3DbaOltCycleSize"));
		baseInfoPanel.add(tfUtsDot3DbaOltCycleSize);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3DbaOltPlatoCycleSize));
//		tfUtsDot3DbaOltPlatoCycleSize.setName(fStringMap
//				.getString("utsDot3DbaOltPlatoCycleSize"));
//		baseInfoPanel.add(tfUtsDot3DbaOltPlatoCycleSize);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3DbaOltPlatoDiscoveryFreq));
//		tfUtsDot3DbaOltPlatoDiscoveryFreq.setName(fStringMap
//				.getString("utsDot3DbaOltPlatoDiscoveryFreq"));
//		baseInfoPanel.add(tfUtsDot3DbaOltPlatoDiscoveryFreq);
//		baseInfoPanel.add(new HSpacer());

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

		tfUtsDot3DbaOltDiscoverySize.setValueScope(0, 65535);

		tfUtsDot3DbaOltDiscoveryFreq.setValueScope(0, 65535);

		tfUtsDot3DbaOltCycleSize.setValueScope(16384, 131072);

		tfUtsDot3DbaOltPlatoCycleSize.setValueScope(1, 255);

		tfUtsDot3DbaOltPlatoDiscoveryFreq.setValueScope(1, 255);

	}

	public void refresh()
	{

		Dot3DbaOltTable mbean = (Dot3DbaOltTable) getModel();

        tfIfIndex.setText(ConfigUtility.formatIfIndex(mbean.getIfIndex().toString()));
		tfUtsDot3DbaOltAlgorithm.setSelectedIndex(getIndexFromValue(
				utsDot3DbaOltAlgorithmVList, mbean.getUtsDot3DbaOltAlgorithm()
						.intValue()));
		tfUtsDot3DbaOltDiscoverySize.setValue(mbean
				.getUtsDot3DbaOltDiscoverySize().intValue());
		tfUtsDot3DbaOltDiscoveryFreq.setValue(mbean
				.getUtsDot3DbaOltDiscoveryFreq().intValue());
		tfUtsDot3DbaOltCycleSize.setValue(mbean.getUtsDot3DbaOltCycleSize()
				.intValue());
//		tfUtsDot3DbaOltPlatoCycleSize.setValue(mbean
//				.getUtsDot3DbaOltPlatoCycleSize().intValue());
//		tfUtsDot3DbaOltPlatoDiscoveryFreq.setValue(mbean
//				.getUtsDot3DbaOltPlatoDiscoveryFreq().intValue());

	}

	public void updateModel()
	{

		Dot3DbaOltTable mbean = (Dot3DbaOltTable) getModel();

		mbean.setUtsDot3DbaOltAlgorithm(new Integer(
				utsDot3DbaOltAlgorithmVList[tfUtsDot3DbaOltAlgorithm
						.getSelectedIndex()]));
        if(tfUtsDot3DbaOltAlgorithm.getSelectedIndex() == 0){
            mbean.setUtsDot3DbaOltDiscoverySize(new Integer(
                    tfUtsDot3DbaOltDiscoverySize.getValue()));
            mbean.setUtsDot3DbaOltDiscoveryFreq(new Integer(
                    tfUtsDot3DbaOltDiscoveryFreq.getValue()));
            mbean.setUtsDot3DbaOltCycleSize(new Integer(tfUtsDot3DbaOltCycleSize
                    .getValue()));
        }
//		mbean.setUtsDot3DbaOltPlatoCycleSize(new Integer(
//				tfUtsDot3DbaOltPlatoCycleSize.getValue()));
//		mbean.setUtsDot3DbaOltPlatoDiscoveryFreq(new Integer(
//				tfUtsDot3DbaOltPlatoDiscoveryFreq.getValue()));
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
