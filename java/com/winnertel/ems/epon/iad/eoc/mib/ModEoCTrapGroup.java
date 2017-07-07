package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The ModEoCTrapGroup class.
 * Created by QuickDVM
 */
public class ModEoCTrapGroup extends SnmpMibBean {
    public static final String modEoCTrapMaxTimes = "modEoCTrapMaxTimes";
    public static final String modEoCTrapMinInterval = "modEoCTrapMinInterval";
    public static final String modEoCTrapMaxInterval = "modEoCTrapMaxInterval";
    public static final String modEoCTrapVertion = "modEoCTrapVertion";

    public ModEoCTrapGroup(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCTrapMaxTimes, new SnmpMibBeanProperty(modEoCTrapMaxTimes, ".1.3.6.1.4.1.17409.2.4.8.1", ISnmpConstant.INTEGER));
        initProperty(modEoCTrapMinInterval, new SnmpMibBeanProperty(modEoCTrapMinInterval, ".1.3.6.1.4.1.17409.2.4.8.2", ISnmpConstant.INTEGER));
        initProperty(modEoCTrapMaxInterval, new SnmpMibBeanProperty(modEoCTrapMaxInterval, ".1.3.6.1.4.1.17409.2.4.8.3", ISnmpConstant.INTEGER));
        initProperty(modEoCTrapVertion, new SnmpMibBeanProperty(modEoCTrapVertion, ".1.3.6.1.4.1.17409.2.4.8.4", ISnmpConstant.STRING));

    }


    public Integer getModEoCTrapMaxTimes() {
        return (Integer) getProperty(modEoCTrapMaxTimes).getValue();
    }

    public void setModEoCTrapMaxTimes(Integer aModEoCTrapMaxTimes) {
        getProperty(modEoCTrapMaxTimes).setValue(aModEoCTrapMaxTimes);
    }

    public Integer getModEoCTrapMinInterval() {
        return (Integer) getProperty(modEoCTrapMinInterval).getValue();
    }

    public void setModEoCTrapMinInterval(Integer aModEoCTrapMinInterval) {
        getProperty(modEoCTrapMinInterval).setValue(aModEoCTrapMinInterval);
    }

    public Integer getModEoCTrapMaxInterval() {
        return (Integer) getProperty(modEoCTrapMaxInterval).getValue();
    }

    public void setModEoCTrapMaxInterval(Integer aModEoCTrapMaxInterval) {
        getProperty(modEoCTrapMaxInterval).setValue(aModEoCTrapMaxInterval);
    }

    public String getModEoCTrapVertion() {
        return (String) getProperty(modEoCTrapVertion).getValue();
    }

    public void setModEoCTrapVertion(String aModEoCTrapVertion) {
        getProperty(modEoCTrapVertion).setValue(aModEoCTrapVertion);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCTrapMaxTimes));
        prepareRead(super.getProperty(modEoCTrapMinInterval));
        prepareRead(super.getProperty(modEoCTrapMaxInterval));
        prepareRead(super.getProperty(modEoCTrapVertion));

        return load();
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCTrapMaxTimes));
        prepareSave(getProperty(modEoCTrapMinInterval));
        prepareSave(getProperty(modEoCTrapMaxInterval));

        return save();
    }


}