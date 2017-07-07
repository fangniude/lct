package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r400.DateAndTimeFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.EponSysCliMgmtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The EponSysCliMgmtTablePanel class. Created by DVM Creator
 */
public class EponSysCliMgmtTablePanel extends UPanel {

	private JLabel tfUtsEponSysCliSessionId = new JLabel();

	private JLabel tfUtsEponSysCliUserAccount = new JLabel();

	private JLabel tfUtsEponSysCliUserLoginTime = new JLabel();

	private JLabel tfUtsEponSysCliUserIdleTime = new JLabel();

	private JLabel tfUtsEponSysCliUserHostIp = new JLabel();

	private int[] utsEponSysCliUserLogoutForcelyVList = new int[] { 1, 2, };
	private String[] utsEponSysCliUserLogoutForcelyTList = new String[] {
			fStringMap.getString("true"), fStringMap.getString("false"), };
	private JComboBox tfUtsEponSysCliUserLogoutForcely = new JComboBox(
			utsEponSysCliUserLogoutForcelyTList);

	private final String utsEponSysCliSessionId = fStringMap
			.getString("utsEponSysCliSessionId")
			+ " : ";
	private final String utsEponSysCliUserAccount = fStringMap
			.getString("utsEponSysCliUserAccount")
			+ " : ";
	private final String utsEponSysCliUserLoginTime = fStringMap
			.getString("utsEponSysCliUserLoginTime")
			+ " : ";
	private final String utsEponSysCliUserIdleTime = fStringMap
			.getString("utsEponSysCliUserIdleTime")
			+ " : ";
	private final String utsEponSysCliUserHostIp = fStringMap
			.getString("utsEponSysCliUserHostIp")
			+ " : ";
	private final String utsEponSysCliUserLogoutForcely = fStringMap
			.getString("utsEponSysCliUserLogoutForcely")
			+ " : ";

	public EponSysCliMgmtTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsEponSysCliSessionId));
		baseInfoPanel.add(tfUtsEponSysCliSessionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponSysCliUserAccount));
		baseInfoPanel.add(tfUtsEponSysCliUserAccount);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponSysCliUserLoginTime));
		baseInfoPanel.add(tfUtsEponSysCliUserLoginTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponSysCliUserIdleTime));
		baseInfoPanel.add(tfUtsEponSysCliUserIdleTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponSysCliUserHostIp));
		baseInfoPanel.add(tfUtsEponSysCliUserHostIp);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEponSysCliUserLogoutForcely));
		tfUtsEponSysCliUserLogoutForcely.setName(fStringMap
				.getString("utsEponSysCliUserLogoutForcely"));
		baseInfoPanel.add(tfUtsEponSysCliUserLogoutForcely);
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

	}

	public void refresh() {

		EponSysCliMgmtTable mbean = (EponSysCliMgmtTable) getModel();

		tfUtsEponSysCliSessionId.setText(mbean.getUtsEponSysCliSessionId()
				.toString());
		tfUtsEponSysCliUserAccount.setText(mbean.getUtsEponSysCliUserAccount());
		tfUtsEponSysCliUserLoginTime.setText(DateAndTimeFormatter.format(mbean
				.getUtsEponSysCliUserLoginTime()));
		tfUtsEponSysCliUserIdleTime.setText(mbean
				.getUtsEponSysCliUserIdleTime().toString());
		tfUtsEponSysCliUserHostIp.setText(mbean.getUtsEponSysCliUserHostIp());
		tfUtsEponSysCliUserLogoutForcely.setSelectedIndex(getIndexFromValue(
				utsEponSysCliUserLogoutForcelyVList, mbean
						.getUtsEponSysCliUserLogoutForcely().intValue()));

	}

	public void updateModel() {

		EponSysCliMgmtTable mbean = (EponSysCliMgmtTable) getModel();

		mbean
				.setUtsEponSysCliUserLogoutForcely(new Integer(
						utsEponSysCliUserLogoutForcelyVList[tfUtsEponSysCliUserLogoutForcely
								.getSelectedIndex()]));

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
