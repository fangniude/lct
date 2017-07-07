package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.StringTokenizer;

public class AlarmFilteringMBean extends SnmpMibBean {

    public static final String utAlarmFilteringType = "utAlarmFilteringType";
    public static final String utAlarmFilteringSeverity = "utAlarmFilteringSeverity";

    public AlarmFilteringMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utAlarmFilteringType, new SnmpMibBeanProperty(utAlarmFilteringType, ".1.3.6.1.4.1.41355.1800.3.1.1.4.3.2", ISnmpConstant.INTEGER));
        initProperty(utAlarmFilteringSeverity, new SnmpMibBeanProperty(utAlarmFilteringSeverity, ".1.3.6.1.4.1.41355.1800.3.1.1.4.3.1", ISnmpConstant.INTEGER));
    }

    public String getUtAlarmFilteringType() {
        Integer type = (Integer) getProperty(utAlarmFilteringType).getValue();
        return ((type != null) ? (type.toString()) : "");
    }

    public void setUtAlarmFilteringType(String aUtAlarmFilteringType) {
        getProperty(utAlarmFilteringType).setValue(Integer.valueOf(getType(aUtAlarmFilteringType)));
    }

    public Integer getUtAlarmFilteringSeverity() {
        Integer value = (Integer) getProperty(utAlarmFilteringSeverity).getValue();
        return ((value != null) ? (Integer.valueOf(generateSeverity(value.toString()))) : -1);
    }

    public void setUtAlarmFilteringSeverity(Integer aUtAlarmFilteringSeverity) {
        getProperty(utAlarmFilteringSeverity).setValue(Integer.valueOf(getSeverity(aUtAlarmFilteringSeverity.toString())));
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utAlarmFilteringType));
        prepareRead(getProperty(utAlarmFilteringSeverity));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utAlarmFilteringType));
        prepareSave(getProperty(utAlarmFilteringSeverity));

        return save();
    }

    private String getSeverity(String s) {
        int tempInt = 0;
        int i = Integer.parseInt(s);
        if (i == 0) {
            tempInt = 0xFFFFFFFF;
        } else if (i == 1) {
            tempInt = 0xFFFFFFFD;
        } else if (i == 2) {
            tempInt = 0xFFFFFFF9;
        } else if (i == 3) {
            tempInt = 0xFFFFFFF1;
        } else if (i == 4) {
            tempInt = 0xFFFFFFE1;
        }

        String str = String.valueOf(tempInt);
        return str;
    }

    private String getType(String s) {
        int base = 0xfffff000;
        int b = 4095;
        StringTokenizer st = new StringTokenizer(s, ";");
        while (st.hasMoreElements()) {
            int tempInt = Integer.parseInt(st.nextElement().toString());
            int a = (int) Math.pow(2, tempInt);
            b = b - a;
        }
        b = base + b;

        String str = String.valueOf(b);

        return str;
    }

    private String generateSeverity(String s) {
        String str = "";
        int i = Integer.parseInt(s);
        String tempStr = Integer.toHexString(i);
        int tempInt = Integer.parseInt(tempStr.substring(6), 16);

        if (tempInt == 0xE1) {
            str = "4";
        } else if (tempInt == 0xF1) {
            str = "3";
        } else if (tempInt == 0xF9) {
            str = "2";
        } else if (tempInt == 0xFD) {
            str = "1";
        } else if (tempInt == 0xFF) {
            str = "0";
        } else {
            str = "-1";
        }

        return str;
    }

}