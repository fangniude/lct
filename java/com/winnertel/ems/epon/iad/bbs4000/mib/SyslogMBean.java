package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SyslogMBean class.
 * Created by QuickDVM
 */
public class SyslogMBean extends SnmpMibBean {
    public static final String utsSyslogFormat = "utsSyslogFormat";
    public static final String utsSyslogConsoleSeverity = "utsSyslogConsoleSeverity";
    public static final String utsSyslogFlashSeverity = "utsSyslogFlashSeverity";

    public SyslogMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsSyslogFormat, new SnmpMibBeanProperty(utsSyslogFormat, ".1.3.6.1.4.1.45121.1800.2.1.1.3.1.1", ISnmpConstant.INTEGER));
        initProperty(utsSyslogConsoleSeverity, new SnmpMibBeanProperty(utsSyslogConsoleSeverity, ".1.3.6.1.4.1.45121.1800.2.1.1.3.1.2", ISnmpConstant.INTEGER));
        initProperty(utsSyslogFlashSeverity, new SnmpMibBeanProperty(utsSyslogFlashSeverity, ".1.3.6.1.4.1.45121.1800.2.1.1.3.1.3", ISnmpConstant.INTEGER));

    }


    public Integer getUtsSyslogFormat() {
        return (Integer) getProperty(utsSyslogFormat).getValue();
    }

    public void setUtsSyslogFormat(Integer aUtsSyslogFormat) {
        getProperty(utsSyslogFormat).setValue(aUtsSyslogFormat);
    }

    public Integer getUtsSyslogConsoleSeverity() {
        return (Integer) getProperty(utsSyslogConsoleSeverity).getValue();
    }

    public void setUtsSyslogConsoleSeverity(Integer aUtsSyslogConsoleSeverity) {
        getProperty(utsSyslogConsoleSeverity).setValue(aUtsSyslogConsoleSeverity);
    }

    public Integer getUtsSyslogFlashSeverity() {
        return (Integer) getProperty(utsSyslogFlashSeverity).getValue();
    }

    public void setUtsSyslogFlashSeverity(Integer aUtsSyslogFlashSeverity) {
        getProperty(utsSyslogFlashSeverity).setValue(aUtsSyslogFlashSeverity);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsSyslogFormat));
        prepareRead(super.getProperty(utsSyslogConsoleSeverity));
        prepareRead(super.getProperty(utsSyslogFlashSeverity));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsSyslogFormat));
        prepareSave(getProperty(utsSyslogConsoleSeverity));
        prepareSave(getProperty(utsSyslogFlashSeverity));

        return save();
    }


}
