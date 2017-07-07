package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.UtsDot3Onu2AlarmProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The UtsDot3Onu2AlarmProfileTablePanel class. Created by DVM Creator
 */
public class UtsDot3Onu2AlarmProfileTablePanel extends UPanel {

	private StringTextField tfUtsDot3Onu2AlarmProfileIndex = new StringTextField();

	private StringTextField tfUtsDot3Onu2AlarmProfileName = new StringTextField();

	/*
	private int[] utsDot3Onu2AlarmProfileRowStatusVList = new int[] { 1, 2, 5,
			4, 3, 6, };
	private String[] utsDot3Onu2AlarmProfileRowStatusTList = new String[] {
			fStringMap.getString("active"),
			fStringMap.getString("notInService"),
			fStringMap.getString("createAndWait"),
			fStringMap.getString("createAndGo"),
			fStringMap.getString("notReady"), fStringMap.getString("destroy"), };
	private JComboBox tfUtsDot3Onu2AlarmProfileRowStatus = new JComboBox(
			utsDot3Onu2AlarmProfileRowStatusTList);
	*/

	private final String utsDot3Onu2AlarmProfileIndex = fStringMap
			.getString("utsDot3Onu2AlarmProfileIndex") + " : ";
	private final String utsDot3Onu2AlarmProfileName = fStringMap
			.getString("utsDot3Onu2AlarmProfileName") + " : ";

	public UtsDot3Onu2AlarmProfileTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmProfileIndex));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmProfileIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2AlarmProfileName));
		tfUtsDot3Onu2AlarmProfileName.setName(fStringMap
				.getString("utsDot3Onu2AlarmProfileName"));
		baseInfoPanel.add(tfUtsDot3Onu2AlarmProfileName);
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

	protected void initForm() {

		tfUtsDot3Onu2AlarmProfileName.setLenScope(1, 64);

	}

	public void refresh() {
		if (SnmpAction.IType.ADD.equals(fCommand))
			return;
		UtsDot3Onu2AlarmProfileTable mbean = (UtsDot3Onu2AlarmProfileTable) getModel();

		tfUtsDot3Onu2AlarmProfileIndex.setText(mbean
				.getUtsDot3Onu2AlarmProfileIndex().toString());
		tfUtsDot3Onu2AlarmProfileName.setValue(mbean
				.getUtsDot3Onu2AlarmProfileName());
//		tfUtsDot3Onu2AlarmProfileRowStatus.setSelectedIndex(getIndexFromValue(
//				utsDot3Onu2AlarmProfileRowStatusVList, mbean
//						.getUtsDot3Onu2AlarmProfileRowStatus().intValue()));

	}

	public void updateModel() {
              
              if (SnmpAction.IType.ADD.equals(fCommand))  setModel(new UtsDot3Onu2AlarmProfileTable(fApplication.getSnmpProxy()));
              
                  UtsDot3Onu2AlarmProfileTable mbean = (UtsDot3Onu2AlarmProfileTable) getModel();
              
              if (SnmpAction.IType.ADD.equals(fCommand)) {
              //  here set the value of index
		            mbean.setUtsDot3Onu2AlarmProfileIndex(Integer.valueOf(tfUtsDot3Onu2AlarmProfileIndex.getValue()));
               }
             
              
      mbean.setUtsDot3Onu2AlarmProfileName( new String(tfUtsDot3Onu2AlarmProfileName.getValue()));
//    mbean.setUtsDot3Onu2AlarmProfileRowStatus(new Integer(utsDot3Onu2AlarmProfileRowStatusVList[tfUtsDot3Onu2AlarmProfileRowStatus.getSelectedIndex()]));

        
          }

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
