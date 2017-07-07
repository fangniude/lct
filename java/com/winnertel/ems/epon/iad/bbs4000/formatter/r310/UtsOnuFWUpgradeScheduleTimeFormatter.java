package com.winnertel.ems.epon.iad.bbs4000.formatter.r310;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtsOnuFWUpgradeScheduleTimeFormatter extends SnmpFieldFormatter {

    public UtsOnuFWUpgradeScheduleTimeFormatter(IApplication anApplication) {
	super(anApplication);
    }

    @Override
    public String format(SnmpMibBean aMibBean, String aProperty) {

	byte[] time = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

	return byteToString(time);
    }

    public static String format(byte[] aOnuCfgPassword) {
	return byteToString(aOnuCfgPassword);
    }

    public static byte[] format(Long aTime) {
	byte[] result = new byte[11];

	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(aTime);

	int year = calendar.get(Calendar.YEAR);
	result[0] = (byte) (year >> 8);
	result[1] = (byte) (year & 0x00FF);

	result[2] = (byte) (calendar.get(Calendar.MONTH) + 1);
	result[3] = (byte) calendar.get(Calendar.DAY_OF_MONTH);
	result[4] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
	result[5] = (byte) calendar.get(Calendar.MINUTE);
	result[6] = (byte) calendar.get(Calendar.SECOND);
	result[7] = 0;
	result[8] = 0;
	result[9] = 0;
	result[10] = 0;

	return result;
    }

    private static String byteToString(byte[] aByteTime) {
	Calendar calendar = Calendar.getInstance();

	int year = (aByteTime[0] << 8) + (aByteTime[1] & 0x00FF);
	calendar.set(Calendar.YEAR, year);
	calendar.set(Calendar.MONTH, aByteTime[2] - 1);
	calendar.set(Calendar.DAY_OF_MONTH, aByteTime[3]);
	calendar.set(Calendar.HOUR_OF_DAY, aByteTime[4]);
	calendar.set(Calendar.MINUTE, aByteTime[5]);
	calendar.set(Calendar.SECOND, aByteTime[6]);
	// calendar.set(Calendar.YEAR, year);
	// calendar.set(Calendar.YEAR, year);
	// calendar.set(Calendar.YEAR, year);
	// calendar.set(Calendar.YEAR, year);
	// calendar.set(Calendar.YEAR, year);

	SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
	String result = df.format(calendar.getTime());

	return result;
    }

}