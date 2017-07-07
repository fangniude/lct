package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATDevStatusGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.platform.client.swing.calendar.CalendarPicker;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * The ModEoCCBATDevStatusGroupPanel class. Created by DVM Creator
 */
public class ModEoCCBATDevStatusGroupPanel extends UPanel {

    private int[] modEoCCBATAdminAlarmDetectionControlVList = new int[]{3, 2,
            1,};
    private String[] modEoCCBATAdminAlarmDetectionControlTList = new String[]{
            fStringMap.getString("detectionEnabledAndRegenerate"),
            fStringMap.getString("detectionEnabled"),
            fStringMap.getString("detectionDisabled"),};
    private JComboBox tfModEoCCBATAdminAlarmDetectionControl = new JComboBox(
            modEoCCBATAdminAlarmDetectionControlTList);
    // private JLabel tfModEoCCBATAdminStatus = new JLabel();
    JCheckBox cb1 = new JCheckBox();
    JCheckBox cb2 = new JCheckBox();
    JCheckBox cb3 = new JCheckBox();

    private JLabel tfModEoCCBATAdminInternalTemperature = new JLabel();

    private int[] modEoCCBATAdminTamperStatusVList = new int[]{2, 1,};
    private String[] modEoCCBATAdminTamperStatusTList = new String[]{
            fStringMap.getString("compromised"),
            fStringMap.getString("intact"),};
    private JComboBox tfModEoCCBATAdminTamperStatus = new JComboBox(
            modEoCCBATAdminTamperStatusTList);
    private CalendarPicker tfModEoCCBATAdminDateAndTime = new CalendarPicker(true);

    private int[] modEoCCBATAdminResetCauseVList = new int[]{1, 5, 3, 2, 4,};
    private String[] modEoCCBATAdminResetCauseTList = new String[]{
            fStringMap.getString("modEoCCBATAdminResetCauseVList_other"),
            fStringMap.getString("modEoCCBATAdminResetCauseVList_craft"),
            fStringMap.getString("modEoCCBATAdminResetCauseVList_command"),
            fStringMap.getString("modEoCCBATAdminResetCauseVList_powerup"),
            fStringMap.getString("modEoCCBATAdminResetCauseVList_watchdog"),};
    private JComboBox tfModEoCCBATAdminResetCause = new JComboBox(
            modEoCCBATAdminResetCauseTList);

    private int[] modEoCCBATAdminConfigurationResultVList = new int[]{2, 1,
            0,};
    private String[] modEoCCBATAdminConfigurationResultTList = new String[]{
            fStringMap
                    .getString("modEoCCBATAdminConfigurationResultTList_failed"),
            fStringMap
                    .getString("modEoCCBATAdminConfigurationResultTList_running"),
            fStringMap
                    .getString("modEoCCBATAdminConfigurationResultTList_success"),};
    private JComboBox tfModEoCCBATAdminConfigurationResult = new JComboBox(
            modEoCCBATAdminConfigurationResultTList);

    private final String modEoCCBATAdminAlarmDetectionControl = fStringMap
            .getString("modEoCCBATAdminAlarmDetectionControl") + " : ";
    private final String modEoCCBATAdminStatus = fStringMap
            .getString("modEoCCBATAdminStatus") + " : ";
    private final String modEoCCBATAdminInternalTemperature = fStringMap
            .getString("modEoCCBATAdminInternalTemperature") + " : ";
    private final String modEoCCBATAdminTamperStatus = fStringMap
            .getString("modEoCCBATAdminTamperStatus") + " : ";
    private final String modEoCCBATAdminDateAndTime = fStringMap
            .getString("modEoCCBATAdminDateAndTime") + " : ";
    private final String modEoCCBATAdminResetCause = fStringMap
            .getString("modEoCCBATAdminResetCause") + " : ";
    private final String modEoCCBATAdminConfigurationResult = fStringMap
            .getString("modEoCCBATAdminConfigurationResult") + " : ";

    //	JButton btReset;
//	JButton btSave;
    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public ModEoCCBATDevStatusGroupPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCBATDevStatusGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID,
                "Modify_ModEoCCBATDevStatusGroup");
        btRefresh = new SnmpRefreshButton(fApplication, this);

		/*btReset = new JButton(fStringMap.getString("ResetCBat"));
        BaseAction resetAction = new BaseAction(fApplication) {
			@Override
			public void executeAction(ActionEvent e) throws Exception {
				// TODO Auto-generated method stub
				try {
					if (MessageDialog.showConfirmOperationDialog(fApplication)) {
						fApplication.getTaskManager().executeTask(new Task() {

							public Object execute() throws Exception {
								ModEoCCBATDevStatusGroup resetBean = (ModEoCCBATDevStatusGroup) getModel();
								resetBean.resetCBat();
								return null;
							}
						});
					}
				} catch (Exception e1) {
					MessageDialog.showOperationFailedDialog(fApplication);
					e1.printStackTrace();
				}

			}
		};
		resetAction.putValue(BaseAction.ID, "Reset_ModEoCCBATDevStatusGroup");
		btReset.addActionListener(resetAction);

		btSave = new JButton(fStringMap.getString("saveConfig"));
		BaseAction saveAction = new BaseAction(fApplication) {
			@Override
			public void executeAction(ActionEvent e) throws Exception {
				// TODO Auto-generated method stub

				try {
					if (MessageDialog.showConfirmOperationDialog(fApplication)) {
						fApplication.getTaskManager().executeTask(new Task() {

							public Object execute() throws Exception {
								ModEoCCBATDevStatusGroup resetBean = (ModEoCCBATDevStatusGroup) getModel();
								resetBean.saveConfig();
								return null;
							}
						});
					}
				} catch (Exception e1) {
					MessageDialog.showOperationFailedDialog(fApplication);
					e1.printStackTrace();
				}
			}
		};
		saveAction.putValue(BaseAction.ID, "Save_ModEoCCBATDevStatusGroup");
		btSave.addActionListener(saveAction);*/

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
//		buttonsPanel.add(btReset);
//		buttonsPanel.add(btSave);

        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminAlarmDetectionControl));
        tfModEoCCBATAdminAlarmDetectionControl.setName(fStringMap
                .getString("modEoCCBATAdminAlarmDetectionControl"));
        baseInfoPanel.add(tfModEoCCBATAdminAlarmDetectionControl);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminStatus));

        { // add status panel

            JPanel statusPanel = new JPanel();
            NTLayout layout1 = new NTLayout(1, 3, NTLayout.FILL,
                    NTLayout.CENTER, 5, 5);
            layout1.setMargins(6, 10, 6, 10);
            statusPanel.setLayout(layout1);
            // statusPanel.setBorder(BorderFactory.createEtchedBorder());

            cb1.setText(fStringMap.getString("modEoCCBATAdminStatus_Bit0"));
            cb1.setEnabled(false);

            cb2.setText(fStringMap.getString("modEoCCBATAdminStatus_Bit1"));
            cb2.setEnabled(false);

            cb3.setText(fStringMap.getString("modEoCCBATAdminStatus_Bit2"));
            cb3.setEnabled(false);

            statusPanel.add(cb1);
            statusPanel.add(cb2);
            statusPanel.add(cb3);

            baseInfoPanel.add(statusPanel);
        }
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminInternalTemperature));
        baseInfoPanel.add(tfModEoCCBATAdminInternalTemperature);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminTamperStatus));
        tfModEoCCBATAdminTamperStatus.setEnabled(false);
        baseInfoPanel.add(tfModEoCCBATAdminTamperStatus);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(modEoCCBATAdminDateAndTime));
//        tfModEoCCBATAdminDateAndTime
//                .setChooserType(JbcDateTimeChooser.CHOOSER_DATETIME);
        tfModEoCCBATAdminDateAndTime.setName(fStringMap
                .getString("modEoCCBATAdminDateAndTime"));
        baseInfoPanel.add(tfModEoCCBATAdminDateAndTime);
        baseInfoPanel.add(new HSpacer());

		/*
		 * baseInfoPanel.add(new JLabel(modEoCCBATAdminReset));
		 * tfModEoCCBATAdminReset
		 * .setName(fStringMap.getString("modEoCCBATAdminReset"));
		 * baseInfoPanel.add(tfModEoCCBATAdminReset); baseInfoPanel.add(new
		 * HSpacer());
		 */

        baseInfoPanel.add(new JLabel(modEoCCBATAdminResetCause));
        tfModEoCCBATAdminResetCause.setEnabled(false);
        baseInfoPanel.add(tfModEoCCBATAdminResetCause);
        baseInfoPanel.add(new HSpacer());

		/*
		 * baseInfoPanel.add(new JLabel(modEoCCBATAdminConfigurationSaving));
		 * tfModEoCCBATAdminConfigurationSaving
		 * .setName(fStringMap.getString("modEoCCBATAdminConfigurationSaving"));
		 * baseInfoPanel.add(tfModEoCCBATAdminConfigurationSaving);
		 * baseInfoPanel.add(new HSpacer());
		 */

        baseInfoPanel.add(new JLabel(modEoCCBATAdminConfigurationResult));
        tfModEoCCBATAdminConfigurationResult.setEnabled(false);
        baseInfoPanel.add(tfModEoCCBATAdminConfigurationResult);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);

    }

    protected void initForm() {

    }

    private byte[] oldDateTime = null;

    public void refresh() {

        ModEoCCBATDevStatusGroup mbean = (ModEoCCBATDevStatusGroup) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCBATAdminAlarmDetectionControl
                .setSelectedIndex(getIndexFromValue(
                        modEoCCBATAdminAlarmDetectionControlVList, mbean
                        .getModEoCCBATAdminAlarmDetectionControl()
                        .intValue()));
        byte[] adminStatus = mbean.getModEoCCBATAdminStatus();
        setAdminStatus(adminStatus);
        // tfModEoCCBATAdminStatus.setText();
        tfModEoCCBATAdminInternalTemperature.setText(mbean
                .getModEoCCBATAdminInternalTemperature().toString());
        tfModEoCCBATAdminTamperStatus.setSelectedIndex(getIndexFromValue(
                modEoCCBATAdminTamperStatusVList, mbean
                .getModEoCCBATAdminTamperStatus().intValue()));

        oldDateTime = mbean.getModEoCCBATAdminDateAndTime();
        tfModEoCCBATAdminDateAndTime.setDate(new Date(getDateTime(oldDateTime)));
        tfModEoCCBATAdminResetCause.setSelectedIndex(getIndexFromValue(
                modEoCCBATAdminResetCauseVList, mbean
                .getModEoCCBATAdminResetCause().intValue()));
        tfModEoCCBATAdminConfigurationResult
                .setSelectedIndex(getIndexFromValue(
                        modEoCCBATAdminConfigurationResultVList, mbean
                        .getModEoCCBATAdminConfigurationResult()
                        .intValue()));

    }

    public void updateModel() {

        ModEoCCBATDevStatusGroup mbean = (ModEoCCBATDevStatusGroup) getModel();

        mbean.setModEoCCBATAdminAlarmDetectionControl(new Integer(
                modEoCCBATAdminAlarmDetectionControlVList[tfModEoCCBATAdminAlarmDetectionControl
                        .getSelectedIndex()]));
        mbean.setModEoCCBATAdminDateAndTime(getDateTime());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

    long getDateTime(byte[] time) {
        if (time != null) {
            int year = bytes2Int(time[0], time[1]);
            int month = (time[2] & 0xFF) - 1;
            int day = time[3] & 0xFF;
            int hour = time[4] & 0xFF;
            int minute = time[5] & 0xFF;
            int second = time[6] & 0xFF;

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day, hour, minute, second);

            // byte direction = (byte)(time[8] & 0xFF);
            // int offset = (direction==0x2d?-1:1)* ( time[9] & 0xFF);
            // SimpleTimeZone tz=new SimpleTimeZone(offset,"" );
            // calendar.setTimeZone(tz);

            return calendar.getTimeInMillis();
        }

        return 0;
    }

    byte[] getDateTime() {

        byte[] b = new byte[11];

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(tfModEoCCBATAdminDateAndTime.getTimeValue());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        b[0] = (byte) ((year & 0xFF00) >> 8);
        b[1] = (byte) (year & 0xFF);
        b[2] = (byte) month;
        b[3] = (byte) day;
        b[4] = (byte) hour;
        b[5] = (byte) minute;
        b[6] = (byte) second;

        if (oldDateTime != null && oldDateTime.length == 11) {
            b[8] = oldDateTime[8];
            b[9] = oldDateTime[9];
            b[10] = oldDateTime[10];
        } else {
            // b[8] =0x2b;
        }

        return b;
    }

    static int bytes2Int(byte b1, byte b2) {
        int value = (b1 & 0xFF) << 8;

        return value | (b2 & 0xFF);
    }

    private void setAdminStatus(byte[] b) {
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);

        if (b != null && b.length > 0) {
            byte b0 = b[0];
            cb1.setSelected((b0 & 0x01) == 0x01);
            cb2.setSelected((b0 & 0x02) == 0x02);
            cb3.setSelected((b0 & 0x04) == 0x04);

        }
    }
}