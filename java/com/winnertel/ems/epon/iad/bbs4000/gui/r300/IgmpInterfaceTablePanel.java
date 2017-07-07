package com.winnertel.ems.epon.iad.bbs4000.gui.r300;


import com.winnertel.ems.epon.iad.bbs4000.mib.IgmpInterfaceTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The IgmpInterfaceTablePanel class. Created by DVM Creator
 */
public class IgmpInterfaceTablePanel extends UPanel
{

	private JLabel tfUtsIgmpIntfIfIndex = new JLabel();

	private int[] utsIgmpIntfVersionVList = new int[]
	{ 2,3, 0, };

	private String[] utsIgmpIntfVersionTList = new String[]
	{ fStringMap.getString("version2"), fStringMap.getString("version3"), fStringMap.getString("disable-igmp"), };

	private JComboBox tfUtsIgmpIntfVersion = new JComboBox(
			utsIgmpIntfVersionTList);

	private JLabel tfUtsIgmpIntfQuerier = new JLabel();

	private JLabel tfUtsIgmpIntfGrpMembInterval = new JLabel();

	private IntegerTextField tfUtsIgmpIntfLastMembQueryIntvl = new IntegerTextField();

	private IntegerTextField tfUtsIgmpIntfQueryInterval = new IntegerTextField();

	private IntegerTextField tfUtsIgmpIntfQueryMaxRespTime = new IntegerTextField();

	private IntegerTextField tfUtsIgmpIntfRobustness = new IntegerTextField();

	private IntegerTextField tfUtsIgmpIntfStartupQueryIntval = new IntegerTextField();

	private IntegerTextField tfUtsIgmpIntfUnsolictReportIntval = new IntegerTextField();

	private JLabel tfUtsIgmpIntfGroups = new JLabel();

	private int[] utsIgmpIntfProxyStatusVList = new int[]
	{ 2, 1, };

	private String[] utsIgmpIntfProxyStatusTList = new String[]
	{ fStringMap.getString("disable"), fStringMap.getString("enable"), };

	private JComboBox tfUtsIgmpIntfProxyStatus = new JComboBox(
			utsIgmpIntfProxyStatusTList);

//	private int[] utsIgmpIntfStatusVList = new int[]
//	{ 1, 2 };

//	private String[] utsIgmpIntfStatusTList = new String[]
//	{ fStringMap.getString("enable"), fStringMap.getString("disable")};

//	private JComboBox tfUtsIgmpIntfStatus = new JComboBox(
//			utsIgmpIntfStatusTList);

	private final String utsIgmpIntfIfIndex = fStringMap
			.getString("utsIgmpIntfIfIndex")
			+ " : ";

	private final String utsIgmpIntfVersion = fStringMap
			.getString("utsIgmpIntfVersion")
			+ " : ";

	private final String utsIgmpIntfQuerier = fStringMap
			.getString("utsIgmpIntfQuerier")
			+ " : ";

	private final String utsIgmpIntfGrpMembInterval = fStringMap
			.getString("utsIgmpIntfGrpMembInterval")
			+ " : ";

	private final String utsIgmpIntfLastMembQueryIntvl = fStringMap
			.getString("utsIgmpIntfLastMembQueryIntvl")
			+ " : ";

	private final String utsIgmpIntfQueryInterval = fStringMap
			.getString("utsIgmpIntfQueryInterval")
			+ " : ";

	private final String utsIgmpIntfQueryMaxRespTime = fStringMap
			.getString("utsIgmpIntfQueryMaxRespTime")
			+ " : ";

	private final String utsIgmpIntfRobustness = fStringMap
			.getString("utsIgmpIntfRobustness")
			+ " : ";

	private final String utsIgmpIntfStartupQueryIntval = fStringMap
			.getString("utsIgmpIntfStartupQueryIntval")
			+ " : ";

	private final String utsIgmpIntfUnsolictReportIntval = fStringMap
			.getString("utsIgmpIntfUnsolictReportIntval")
			+ " : ";

	private final String utsIgmpIntfGroups = fStringMap
			.getString("utsIgmpIntfGroups")
			+ " : ";

	private final String utsIgmpIntfProxyStatus = fStringMap
			.getString("utsIgmpIntfProxyStatus")
			+ " : ";

//    private final String utsIgmpIntfStatus = fStringMap
//			.getString("utsIgmpIntfStatus")
//			+ " : ";

	public IgmpInterfaceTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsIgmpIntfIfIndex));
		baseInfoPanel.add(tfUtsIgmpIntfIfIndex);
		baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsIgmpIntfVersion));
		baseInfoPanel.add(tfUtsIgmpIntfVersion);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfQuerier));
		baseInfoPanel.add(tfUtsIgmpIntfQuerier);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfGrpMembInterval));
		baseInfoPanel.add(tfUtsIgmpIntfGrpMembInterval);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfLastMembQueryIntvl));
		tfUtsIgmpIntfLastMembQueryIntvl.setName(fStringMap
				.getString("utsIgmpIntfLastMembQueryIntvl"));
		baseInfoPanel.add(tfUtsIgmpIntfLastMembQueryIntvl);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfQueryInterval));
		tfUtsIgmpIntfQueryInterval.setName(fStringMap
				.getString("utsIgmpIntfQueryInterval"));
		baseInfoPanel.add(tfUtsIgmpIntfQueryInterval);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfQueryMaxRespTime));
		tfUtsIgmpIntfQueryMaxRespTime.setName(fStringMap
				.getString("utsIgmpIntfQueryMaxRespTime"));
		baseInfoPanel.add(tfUtsIgmpIntfQueryMaxRespTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfRobustness));
		tfUtsIgmpIntfRobustness.setName(fStringMap
				.getString("utsIgmpIntfRobustness"));
		baseInfoPanel.add(tfUtsIgmpIntfRobustness);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfStartupQueryIntval));
		tfUtsIgmpIntfStartupQueryIntval.setName(fStringMap
				.getString("utsIgmpIntfStartupQueryIntval"));
		baseInfoPanel.add(tfUtsIgmpIntfStartupQueryIntval);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfUnsolictReportIntval));
		tfUtsIgmpIntfUnsolictReportIntval.setName(fStringMap
				.getString("utsIgmpIntfUnsolictReportIntval"));
		baseInfoPanel.add(tfUtsIgmpIntfUnsolictReportIntval);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfGroups));
		baseInfoPanel.add(tfUtsIgmpIntfGroups);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIgmpIntfProxyStatus));
		tfUtsIgmpIntfProxyStatus.setName(fStringMap
				.getString("utsIgmpIntfProxyStatus"));
		baseInfoPanel.add(tfUtsIgmpIntfProxyStatus);
		baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsIgmpIntfStatus));
//		tfUtsIgmpIntfStatus.setName(fStringMap
//				.getString("utsIgmpIntfStatus"));
//		baseInfoPanel.add(tfUtsIgmpIntfStatus);
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
    tfUtsIgmpIntfQueryInterval.setValueScope(10, 3600);
		tfUtsIgmpIntfLastMembQueryIntvl.setValueScope(1, 3600);
		tfUtsIgmpIntfQueryMaxRespTime.setValueScope(10, 25);
		tfUtsIgmpIntfRobustness.setValueScope(2, 10);
		tfUtsIgmpIntfStartupQueryIntval.setValueScope(10, 3600);
		tfUtsIgmpIntfUnsolictReportIntval.setValueScope(10, 3600);
	}

	public void refresh()
	{
		if (SnmpAction.IType.ADD.equals(fCommand))
			return;
		IgmpInterfaceTable mbean = (IgmpInterfaceTable) getModel();

		tfUtsIgmpIntfIfIndex.setText(mbean.getUtsIgmpIntfIfIndex().toString());
		tfUtsIgmpIntfVersion.setSelectedIndex(getIndexFromValue(
				utsIgmpIntfVersionVList, mbean.getUtsIgmpIntfVersion()
						.intValue()));
		tfUtsIgmpIntfQuerier.setText(mbean.getUtsIgmpIntfQuerier());
		tfUtsIgmpIntfGrpMembInterval.setText(mbean
				.getUtsIgmpIntfGrpMembInterval().toString());
		tfUtsIgmpIntfLastMembQueryIntvl.setValue(mbean
				.getUtsIgmpIntfLastMembQueryIntvl().intValue());
		tfUtsIgmpIntfQueryInterval.setValue(mbean.getUtsIgmpIntfQueryInterval()
				.intValue());
		tfUtsIgmpIntfQueryMaxRespTime.setValue(mbean
				.getUtsIgmpIntfQueryMaxRespTime().intValue());
		tfUtsIgmpIntfRobustness.setValue(mbean.getUtsIgmpIntfRobustness()
				.intValue());
		tfUtsIgmpIntfStartupQueryIntval.setValue(mbean
				.getUtsIgmpIntfStartupQueryIntval().intValue());
		tfUtsIgmpIntfUnsolictReportIntval.setValue(mbean
				.getUtsIgmpIntfUnsolictReportIntval().intValue());
		tfUtsIgmpIntfGroups.setText(mbean.getUtsIgmpIntfGroups().toString());
		tfUtsIgmpIntfProxyStatus.setSelectedIndex(getIndexFromValue(
				utsIgmpIntfProxyStatusVList, mbean.getUtsIgmpIntfProxyStatus()
						.intValue()));

    tfUtsIgmpIntfProxyStatus.setEnabled(true);
    String name = mbean.getUtsIgmpIntfIfIndex().toString();
    if(name.startsWith("vlan"))
    {
      SuperSVITable svi = new SuperSVITable(fApplication.getSnmpProxy());
      Vector v = BeanService.refreshTableBean(fApplication, svi);

      int vlanId = Integer.parseInt(name.substring(4));
      for(int i = 0; i < v.size(); i++)
      {
        svi = (SuperSVITable)v.get(i);
        if(svi.getUtsIntfSuperSVIVlanId().intValue() == vlanId)
        {
          tfUtsIgmpIntfProxyStatus.setEnabled(false);
          break;
        }
      }
    }
	}

	public void updateModel()
	{
		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new IgmpInterfaceTable(fApplication.getSnmpProxy()));

		IgmpInterfaceTable mbean = (IgmpInterfaceTable) getModel();

		// if (SnmpAction.IType.ADD.equals(fCommand)) {
		// // here set the value of index
		// mbean.set??(new Integer(??.getValue()));
		// }

    mbean.setUtsIgmpIntfVersion(new Integer(utsIgmpIntfVersionVList[tfUtsIgmpIntfVersion.getSelectedIndex()]));
 		mbean.setUtsIgmpIntfLastMembQueryIntvl(new Integer(
				tfUtsIgmpIntfLastMembQueryIntvl.getValue()));
		mbean.setUtsIgmpIntfQueryInterval(new Integer(
				tfUtsIgmpIntfQueryInterval.getValue()));
		mbean.setUtsIgmpIntfQueryMaxRespTime(new Integer(
				tfUtsIgmpIntfQueryMaxRespTime.getValue()));
		mbean.setUtsIgmpIntfRobustness(new Integer(tfUtsIgmpIntfRobustness
				.getValue()));
		mbean.setUtsIgmpIntfStartupQueryIntval(new Integer(
				tfUtsIgmpIntfStartupQueryIntval.getValue()));
		mbean.setUtsIgmpIntfUnsolictReportIntval(new Integer(
				tfUtsIgmpIntfUnsolictReportIntval.getValue()));

		mbean.setUtsIgmpIntfProxyStatus(new Integer(
				utsIgmpIntfProxyStatusVList[tfUtsIgmpIntfProxyStatus
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