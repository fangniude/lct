package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import com.winnertel.ems.epon.iad.bbs1000.gui.swing.OnuTreePanel;
import com.winnertel.ems.epon.iad.bbs1000.mib.r341.UtsOnuFWUpgradeScheduleTable;
import com.winnertel.ems.epon.iad.bbs4000.formatter.r310.UtsOnuFWUpgradeScheduleTimeFormatter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.platform.client.swing.calendar.CalendarPicker;

import javax.swing.*;
import java.awt.*;

//import jbc.beans.JbcDateTimeChooser;

public class UtsOnuFWUpgradeScheduleTablePanel extends UPanel {

	private OnuTreePanel onuTreePanel;

//	private JbcDateTimeChooser tfUtsOnuFWUpgradeScheduleTime = new JbcDateTimeChooser();
    private CalendarPicker tfUtsOnuFWUpgradeScheduleTime = new CalendarPicker(true);

	private String[] SNTPTimeZoneVlist = new String[] { "-12:0", "-11:0",
			"-10:0", "-9:0", "-8:0", "-7:0", "-6:0", "-5:0", "-4:0", "-3:30",
			"-3:0", "-2:0", "-1:0", "+0:0", "+1:0", "+2:0", "+3:0", "+3:30",
			"+4:0", "+4:30", "+5:0", "+5:30", "+5:45", "+6:0", "+6:30", "+7:0",
			"+8:0", "+9:0", "+9:30", "+10:0", "+11:0", "+12:0", "+13:0" };
	private String[] SNTPTimeZoneTlist = new String[] {
			"(GMT -12:00) Eniwetok,Kwajalein",
			"(GMT -11:00) Midway Island, Samoa",
			"(GMT -10:00) Hawaii",
			"(GMT -09:00) Alaska",
			"(GMT -08:00) Pacific Time(US, Canada); Tijuana",
			"(GMT -07:00) Arizona,Mountain Time (US, Canada)",
			"(GMT -06:00) Central Time (US, Canada)",
			"(GMT -05:00) Eastern Time (US, Canada)",
			"(GMT -04:00) Atlantic Time (Canada)",
			"(GMT -03:30) Newfoundland",
			"(GMT -03:00) Buenos Aires, Georgetown",
			"(GMT -02:00) Mid-Atlantic",
			"(GMT -01:00) Cape Verde Is",
			"(GMT) Casablanca, Monrovia,Greenwich Mean Time  Dublin, Edinburgh, Lisbon, London",
			"(GMT +01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna",
			"(GMT +02:00) Athens, Bucharest, Istanbul, Minsk",
			"(GMT +03:00) Moscow, St. Petersburg, Volgograd",
			"(GMT +03:30) Tehran", "(GMT +04:00) Abu Dhabi, Muscat",
			"(GMT +04:30) Kabul", "(GMT +05:00) Islamabad, Karachi, Tashkent",
			"(GMT +05:30) Calcutta,Chennai,Mumbai,New Delhi",
			"(GMT +05:45) Kathmandu",
			"(GMT +06:00) Almaty, Novosibirsk,Rangoon", "(GMT +06:30) Rangoon",
			"(GMT +07:00) Bangkok, Hanoi, Jakarta",
			"(GMT +08:00) Beijing, Chongqing, Hong Kong, Urumqi",
			"(GMT +09:00) Osaka, Sapporo, Tokyo",
			"(GMT +09:30) Adelaide,Darwin",
			"(GMT +10:00) Canberra, Melbourne, Sydney",
			"(GMT +11:00) Magadan, Solomon Is., New Caledonia",
			"(GMT +12:00) Auckland, Fiji, Kamchatka, Marshal Is.",
			"(GMT +13:00) Nuku'alfoa" };

	private JComboBox tfUtsGponNeAttrCfgTimeZone = new JComboBox(
			SNTPTimeZoneTlist);

	// private StringTextField tfUtsOnuFWUpgradeScheduleTime = new
	// StringTextField();

	private IntegerTextField tfUtsOnuFWUpgradeScheduleDuration = new IntegerTextField();

	// private StringTextField tfUtsOnuFWUpgradeScheduleOnuList = new
	// StringTextField();

	// private int[] utsOnuFWUpgradeScheduleUpgradeActionVList = new int[] { 1,
	// 2, };
	// private String[] utsOnuFWUpgradeScheduleUpgradeActionTList = new String[]
	// { fStringMap.getString("normal"), fStringMap.getString("force"), };
	// private JComboBox tfUtsOnuFWUpgradeScheduleUpgradeAction = new
	// JComboBox(utsOnuFWUpgradeScheduleUpgradeActionTList);

	private JCheckBox tfUtsOnuFWUpgradeScheduleUpgradeAction = new JCheckBox(
			fStringMap.getString("force"));

	// private StringTextField tfUtsOnuFWUpgradeScheduleCurrentStatus = new
	// StringTextField();

	// private int[] utsOnuFWUpgradeScheduleRowStatusVList = new int[] { 1, 2,
	// 5, 4, 3, 6, };
	// private String[] utsOnuFWUpgradeScheduleRowStatusTList = new String[] {
	// fStringMap.getString("active"), fStringMap.getString("notInService"),
	// fStringMap.getString("createAndWait"),
	// fStringMap.getString("createAndGo"), fStringMap.getString("notReady"),
	// fStringMap.getString("destroy"), };
	// private JComboBox tfUtsOnuFWUpgradeScheduleRowStatus = new
	// JComboBox(utsOnuFWUpgradeScheduleRowStatusTList);

	private final String utsOnuFWUpgradeScheduleTime = fStringMap
			.getString("utsOnuFWUpgradeScheduleTime")
			+ " : ";
	private final String utsOnuFWUpgradeScheduleDuration = fStringMap
			.getString("utsOnuFWUpgradeScheduleDuration")
			+ " : ";
	private final String utsOnuFWUpgradeScheduleOnuList = fStringMap
			.getString("utsOnuFWUpgradeScheduleOnuList")
			+ " : ";
	private final String utsOnuFWUpgradeScheduleUpgradeAction = fStringMap
			.getString("utsOnuFWUpgradeScheduleUpgradeAction")
			+ " : ";

	// private final String utsOnuFWUpgradeScheduleCurrentStatus =
	// fStringMap.getString("utsOnuFWUpgradeScheduleCurrentStatus") + " : ";

	public UtsOnuFWUpgradeScheduleTablePanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(5, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		JPanel timePanel = new JPanel();
		layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		timePanel.setLayout(layout);
		timePanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("Schedule_Configure")));

		timePanel.add(new JLabel(utsOnuFWUpgradeScheduleTime));
		timePanel.add(tfUtsOnuFWUpgradeScheduleTime);
		timePanel.add(new HSpacer());

		timePanel.add(new JLabel(utsOnuFWUpgradeScheduleDuration));
		timePanel.add(tfUtsOnuFWUpgradeScheduleDuration);
		timePanel.add(new HSpacer());

		JPanel optionPanel = new JPanel();
		layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.FILL, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		optionPanel.setLayout(layout);
		optionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap
				.getString("Upgrade_Mode")));
		optionPanel.add(new JLabel(utsOnuFWUpgradeScheduleUpgradeAction));
		optionPanel.add(tfUtsOnuFWUpgradeScheduleUpgradeAction);
		optionPanel.add(new HSpacer());

		JPanel onuListPanel = new JPanel();
		layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
		layout.setMargins(6, 10, 6, 10);
		onuListPanel.setLayout(layout);
		onuListPanel.setBorder(BorderFactory
				.createTitledBorder(utsOnuFWUpgradeScheduleOnuList));
		// onuListPanel.add(new JLabel(utsOnuFWUpgradeScheduleOnuList));
		onuTreePanel = new OnuTreePanel(fApplication);
		onuListPanel.add(onuTreePanel);

		baseInfoPanel.add(timePanel);
		baseInfoPanel.add(optionPanel);
		baseInfoPanel.add(onuListPanel);

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		setLayout(new BorderLayout());
		add(allPanel, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(500, 550));

	}

	protected void initForm() {

		tfUtsOnuFWUpgradeScheduleDuration.setValueScope(10, 600);
		tfUtsOnuFWUpgradeScheduleDuration.setDefaultValue(30);

	}

	public void refresh() {
		onuTreePanel.init();
	}

	public void updateModel() {

		setModel(new UtsOnuFWUpgradeScheduleTable(fApplication.getSnmpProxy()));

		UtsOnuFWUpgradeScheduleTable mbean = (UtsOnuFWUpgradeScheduleTable) getModel();

		mbean
				.setUtsOnuFWUpgradeScheduleTime(UtsOnuFWUpgradeScheduleTimeFormatter
						.format(tfUtsOnuFWUpgradeScheduleTime.getTimeValue()));

		mbean.setUtsOnuFWUpgradeScheduleDuration(new Integer(
				tfUtsOnuFWUpgradeScheduleDuration.getValue()));
		if (tfUtsOnuFWUpgradeScheduleUpgradeAction.isSelected()) { // force
			mbean.setUtsOnuFWUpgradeScheduleUpgradeAction(new Integer(2));
		} else {
			mbean.setUtsOnuFWUpgradeScheduleUpgradeAction(new Integer(1));
		}

		byte[] bitmap = onuTreePanel.getSelectedOnuBitMap();
		mbean.setUtsOnuFWUpgradeScheduleOnuList(bitmap);

	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}

}
