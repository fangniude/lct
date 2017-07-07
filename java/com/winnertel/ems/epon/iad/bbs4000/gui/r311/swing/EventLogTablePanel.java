package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.EventLogTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The EventLogTablePanel class. Created by DVM Creator
 */
public class EventLogTablePanel extends UPanel {

	private JLabel tfUtsBbsEventLogSequenceNumber = new JLabel();

	private JLabel tfUtsBbsEventLogEntityType = new JLabel();

	private JLabel tfUtsBbsEventLogEntityInstance = new JLabel();

	private JLabel tfUtsBbsEventLogOccurenceTime = new JLabel();

	private JLabel tfUtsBbsEventLogType = new JLabel();

	private JLabel tfUtsBbsEventLogInfo = new JLabel();

	private JLabel tfUtsBbsEventLogVersionId = new JLabel();

	private JLabel tfUtsBbsEventLogSessionId = new JLabel();

	private final String utsBbsEventLogSequenceNumber = fStringMap
			.getString("utsBbsEventLogSequenceNumber")
			+ " : ";
	private final String utsBbsEventLogEntityType = fStringMap
			.getString("utsBbsEventLogEntityType")
			+ " : ";
	private final String utsBbsEventLogEntityInstance = fStringMap
			.getString("utsBbsEventLogEntityInstance")
			+ " : ";
	private final String utsBbsEventLogOccurenceTime = fStringMap
			.getString("utsBbsEventLogOccurenceTime")
			+ " : ";
	private final String utsBbsEventLogType = fStringMap
			.getString("utsBbsEventLogType")
			+ " : ";
	private final String utsBbsEventLogInfo = fStringMap
			.getString("utsBbsEventLogInfo")
			+ " : ";
	private final String utsBbsEventLogVersionId = fStringMap
			.getString("utsBbsEventLogVersionId")
			+ " : ";
	private final String utsBbsEventLogSessionId = fStringMap
			.getString("utsBbsEventLogSessionId")
			+ " : ";

	public EventLogTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsBbsEventLogSequenceNumber));
		baseInfoPanel.add(tfUtsBbsEventLogSequenceNumber);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogEntityType));
		baseInfoPanel.add(tfUtsBbsEventLogEntityType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogEntityInstance));
		baseInfoPanel.add(tfUtsBbsEventLogEntityInstance);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogOccurenceTime));
		baseInfoPanel.add(tfUtsBbsEventLogOccurenceTime);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogType));
		baseInfoPanel.add(tfUtsBbsEventLogType);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogInfo));
		baseInfoPanel.add(tfUtsBbsEventLogInfo);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogVersionId));
		baseInfoPanel.add(tfUtsBbsEventLogVersionId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsBbsEventLogSessionId));
		baseInfoPanel.add(tfUtsBbsEventLogSessionId);
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

		EventLogTable mbean = (EventLogTable) getModel();

		tfUtsBbsEventLogSequenceNumber.setText(mbean
				.getUtsBbsEventLogSequenceNumber().toString());
		tfUtsBbsEventLogEntityType.setText(mbean.getUtsBbsEventLogEntityType()
				.toString());
		tfUtsBbsEventLogEntityInstance.setText(mbean
				.getUtsBbsEventLogEntityInstance().toString());
		tfUtsBbsEventLogOccurenceTime.setText(mbean
				.getUtsBbsEventLogOccurenceTime().toString());
		tfUtsBbsEventLogType.setText(mbean.getUtsBbsEventLogType().toString());
		tfUtsBbsEventLogInfo.setText(mbean.getUtsBbsEventLogInfo());
		tfUtsBbsEventLogVersionId.setText(mbean.getUtsBbsEventLogVersionId()
				.toString());
		tfUtsBbsEventLogSessionId.setText(mbean.getUtsBbsEventLogSessionId()
				.toString());

	}

	public void updateModel() {

		EventLogTable mbean = (EventLogTable) getModel();

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
