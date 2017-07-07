package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SystemGlobalObjects;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.platform.client.swing.calendar.CalendarPicker;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

//import jbc.beans.JbcDateTimeChooser;

public class SystemGlobalObjectsPanel extends UPanel {

//    private JbcDateTimeChooser tfSystemTime = new JbcDateTimeChooser();
    private CalendarPicker tfSystemTime = new CalendarPicker(true);

    private final String systemTime = fStringMap.getString("systemTime") + " : ";

    public SystemGlobalObjectsPanel(IApplication app) {
        super(app);
        setModel(new SystemGlobalObjects(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SystemGlobalObjects");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel timePanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        timePanel.setLayout(layout);
        timePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("System_Global")));

        timePanel.add(new JLabel(systemTime));
//        tfSystemTime.setChooserType(JbcDateTimeChooser.CHOOSER_DATETIME);
        tfSystemTime.setPreferredSize(new Dimension(400, 24));
        tfSystemTime.setName(fStringMap.getString("systemTime"));
        timePanel.add(tfSystemTime);
        timePanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(timePanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        SystemGlobalObjects mbean = (SystemGlobalObjects) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);
        tfSystemTime.setDate(new Date(getDateTime(mbean.getSystemTime())));
    }

    public void updateModel() {
        SystemGlobalObjects mbean = (SystemGlobalObjects) getModel();
        if (mbean == null)
            return;

        mbean.setSystemTime(getDateTime());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    long getDateTime(byte[] time) {
        if(time != null) {
            int year = bytes2Int(time[0], time[1]);
            int month = (time[2] & 0xFF) - 1;
            int day = time[3] & 0xFF;
            int hour = time[4] & 0xFF;
            int minute = time[5] & 0xFF;
            int second = time[6] & 0xFF;

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day, hour, minute, second);

            return calendar.getTimeInMillis();
        }

        return 0;
    }

    byte[] getDateTime() {

        byte[] b = new byte[11];

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(tfSystemTime.getTimeValue());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        b[0] = (byte)((year & 0xFF00) >> 8);
        b[1] = (byte)(year & 0xFF);
        b[2] = (byte)month;
        b[3] = (byte)day;
        b[4] = (byte)hour;
        b[5] = (byte)minute;
        b[6] = (byte)second;

        return b;
    }

    public static String format(byte[] time) {
        if(time == null || time.length < 1) return null;

        StringBuffer sb = new StringBuffer();
        //1970-1-1,0:0:41.0,+0:00
        sb.append(bytes2Int(time[0], time[1])).append("-").append(time[2]).append("-").append(time[3]).append(", ").append(time[4]).append(":").append(time[5]).append(":").append(time[6]).append(".").append(time[7]).append(", ");

        sb.append((char)time[8]).append(time[9]).append(":").append(time[10]);

        if(time.length > 11) {
            sb.append(":").append(time[11]);
        }

        return sb.toString();
    }

    static int bytes2Int(byte b1, byte b2) {
        int value = (b1&0xFF) << 8;

        return value | (b2&0xFF);
    }

}