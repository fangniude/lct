package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.EponModuleBoardTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The EponModuleBoardTablePanel class. Created by DVM Creator
 */
public class EponModuleBoardTablePanel extends UPanel
{

	private JLabel tfUtsEponModuleBoardPhyId = new JLabel();

//  private int[] utsEponModuleAdminStateVList = new int[]
//	{ 1, 2, 8};

//	private String[] utsEponModuleAdminStateTList = new String[]
//	{ fStringMap.getString("locked"), fStringMap.getString("unlocked"),
//			fStringMap.getString("reset")};
//
//	private JComboBox tfUtsEponModuleAdminState = new JComboBox(
//			utsEponModuleAdminStateTList);

	private final String utsEponModuleBoardPhyId = fStringMap
			.getString("utsEponModuleBoardPhyId")
			+ " : ";

//	private final String utsEponModuleAdminState = fStringMap
//			.getString("utsEponModuleAdminState")
//			+ " : ";

  private IntegerTextField tfUtsEponModuleBoardTempUpLimit = new IntegerTextField();

  private final String utsEponModuleBoardTempUpLimit = fStringMap.getString("utsEponModuleBoardTempUpLimit") + " : ";

  private IntegerTextField tfUtsEponModuleBoardTempUpClearLimit = new IntegerTextField();

  private final String utsEponModuleBoardTempUpClearLimit = fStringMap.getString("utsEponModuleBoardTempUpClearLimit") + " : ";

	public EponModuleBoardTablePanel(IApplication app)
	{
		super(app);

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
		baseInfoPanel.add(new JLabel(utsEponModuleBoardPhyId));
		baseInfoPanel.add(tfUtsEponModuleBoardPhyId);
		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsEponModuleAdminState));
//		baseInfoPanel.add(tfUtsEponModuleAdminState);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponModuleBoardTempUpLimit));
		baseInfoPanel.add(tfUtsEponModuleBoardTempUpLimit);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponModuleBoardTempUpClearLimit));
		baseInfoPanel.add(tfUtsEponModuleBoardTempUpClearLimit);
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
		tfUtsEponModuleBoardTempUpLimit.setValueScope(45, 70);
		tfUtsEponModuleBoardTempUpClearLimit.setValueScope(45, 70);
	}

	public void refresh()
	{
		EponModuleBoardTable mbean = (EponModuleBoardTable) getModel();

		tfUtsEponModuleBoardPhyId.setText(mbean.getUtsEponModuleBoardPhyId().toString());

//    tfUtsEponModuleAdminState.setSelectedIndex(getIndexFromValue(
//				utsEponModuleAdminStateVList, mbean.getUtsEponModuleAdminState()
//						.intValue()));

    tfUtsEponModuleBoardTempUpLimit.setValue(mbean.getUtsEponModuleBoardTempUpLimit().intValue());
    tfUtsEponModuleBoardTempUpClearLimit.setValue(mbean.getUtsEponModuleBoardTempUpClearLimit().intValue());
	}

	public boolean validateFrom() {
		int upLimit = tfUtsEponModuleBoardTempUpLimit.getValue();
		int upClearLimit = tfUtsEponModuleBoardTempUpClearLimit.getValue();

		if ( upLimit <= upClearLimit ) {
      String msg = fStringMap.getString("Err_UpLimitTemp_Should_Greater_Than_clearLimit");
      MessageDialog.showErrorMessageDialog(fApplication, msg);

      return false;
		}

		return true;
	}

	public void updateModel()
	{
		EponModuleBoardTable mbean = (EponModuleBoardTable) getModel();

//    mbean.setUtsEponModuleAdminState(new Integer(
//        utsEponModuleAdminStateVList[tfUtsEponModuleAdminState
//            .getSelectedIndex()]));

    mbean.setUtsEponModuleBoardTempUpLimit(new Integer(tfUtsEponModuleBoardTempUpLimit.getValue()));
    mbean.setUtsEponModuleBoardTempUpClearLimit(new Integer(tfUtsEponModuleBoardTempUpClearLimit.getValue()));
	}

//	public int getIndexFromValue(int[] list, int v)
//	{
//		for (int i = 0; i != list.length; i++)
//		{
//			if (list[i] == v)
//				return i;
//		}
//		return 0;
//	}
}
