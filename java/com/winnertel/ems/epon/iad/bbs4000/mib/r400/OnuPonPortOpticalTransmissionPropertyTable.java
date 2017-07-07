/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuPonPortOpticalTransmissionPropertyTable extends SnmpMibBean {

    public static final String onuPonPortOpticalTransmissionPropertyDeviceIndex = "onuPonPortOpticalTransmissionPropertyDeviceIndex";
    //public static final String onuPonPortOpticalTransmissionPropertyCardIndex = "onuPonPortOpticalTransmissionPropertyCardIndex";
    //public static final String onuPonPortOpticalTransmissionPropertyPortIndex = "onuPonPortOpticalTransmissionPropertyPortIndex";
    public static final String onuReceivedOpticalPower = "onuReceivedOpticalPower";
    public static final String onuTramsmittedOpticalPower = "onuTramsmittedOpticalPower";
    public static final String onuBiasCurrent = "onuBiasCurrent";
    public static final String onuWorkingVoltage = "onuWorkingVoltage";
    public static final String onuWorkingTemperature = "onuWorkingTemperature";

    public OnuPonPortOpticalTransmissionPropertyTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuPonPortOpticalTransmissionPropertyDeviceIndex, new SnmpMibBeanProperty(onuPonPortOpticalTransmissionPropertyDeviceIndex, ".1.3.6.1.4.1.17409.2.3.4.2.1.1", ISnmpConstant.INTEGER));
        //initProperty(onuPonPortOpticalTransmissionPropertyCardIndex, new SnmpMibBeanProperty(onuPonPortOpticalTransmissionPropertyCardIndex, ".1.3.6.1.4.1.17409.2.3.4.2.1.2", ISnmpConstant.INTEGER));
        //initProperty(onuPonPortOpticalTransmissionPropertyPortIndex, new SnmpMibBeanProperty(onuPonPortOpticalTransmissionPropertyPortIndex, ".1.3.6.1.4.1.17409.2.3.4.2.1.3", ISnmpConstant.INTEGER));
        initProperty(onuReceivedOpticalPower, new SnmpMibBeanProperty(onuReceivedOpticalPower, ".1.3.6.1.4.1.17409.2.3.4.2.1.4", ISnmpConstant.INTEGER));
        initProperty(onuTramsmittedOpticalPower, new SnmpMibBeanProperty(onuTramsmittedOpticalPower, ".1.3.6.1.4.1.17409.2.3.4.2.1.5", ISnmpConstant.INTEGER));
        initProperty(onuBiasCurrent, new SnmpMibBeanProperty(onuBiasCurrent, ".1.3.6.1.4.1.17409.2.3.4.2.1.6", ISnmpConstant.INTEGER));
        initProperty(onuWorkingVoltage, new SnmpMibBeanProperty(onuWorkingVoltage, ".1.3.6.1.4.1.17409.2.3.4.2.1.7", ISnmpConstant.INTEGER));
        initProperty(onuWorkingTemperature, new SnmpMibBeanProperty(onuWorkingTemperature, ".1.3.6.1.4.1.17409.2.3.4.2.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getOnuPonPortOpticalTransmissionPropertyDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setOnuPonPortOpticalTransmissionPropertyDeviceIndex(Integer aOnuPonPortOpticalTransmissionPropertyDeviceIndex) {
        setIndex(0, aOnuPonPortOpticalTransmissionPropertyDeviceIndex);
    }

    /*
    public Integer getOnuPonPortOpticalTransmissionPropertyCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setOnuPonPortOpticalTransmissionPropertyCardIndex(Integer aOnuPonPortOpticalTransmissionPropertyCardIndex) {
        setIndex(1, aOnuPonPortOpticalTransmissionPropertyCardIndex);
    }

    public Integer getOnuPonPortOpticalTransmissionPropertyPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setOnuPonPortOpticalTransmissionPropertyPortIndex(Integer aOnuPonPortOpticalTransmissionPropertyPortIndex) {
        setIndex(2, aOnuPonPortOpticalTransmissionPropertyPortIndex);
    }
    */

    public Integer getOnuReceivedOpticalPower() {
        return (Integer) getProperty(onuReceivedOpticalPower).getValue();
    }

    public void setOnuReceivedOpticalPower(Integer aOnuReceivedOpticalPower) {
        getProperty(onuReceivedOpticalPower).setValue(aOnuReceivedOpticalPower);
    }

    public Integer getOnuTramsmittedOpticalPower() {
        return (Integer) getProperty(onuTramsmittedOpticalPower).getValue();
    }

    public void setOnuTramsmittedOpticalPower(Integer aOnuTramsmittedOpticalPower) {
        getProperty(onuTramsmittedOpticalPower).setValue(aOnuTramsmittedOpticalPower);
    }

    public Integer getOnuBiasCurrent() {
        return (Integer) getProperty(onuBiasCurrent).getValue();
    }

    public void setOnuBiasCurrent(Integer aOnuBiasCurrent) {
        getProperty(onuBiasCurrent).setValue(aOnuBiasCurrent);
    }

    public Integer getOnuWorkingVoltage() {
        return (Integer) getProperty(onuWorkingVoltage).getValue();
    }

    public void setOnuWorkingVoltage(Integer aOnuWorkingVoltage) {
        getProperty(onuWorkingVoltage).setValue(aOnuWorkingVoltage);
    }

    public Integer getOnuWorkingTemperature() {
        return (Integer) getProperty(onuWorkingTemperature).getValue();
    }

    public void setOnuWorkingTemperature(Integer aOnuWorkingTemperature) {
        getProperty(onuWorkingTemperature).setValue(aOnuWorkingTemperature);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuReceivedOpticalPower));
        prepareRead(getProperty(onuTramsmittedOpticalPower));
        prepareRead(getProperty(onuBiasCurrent));
        prepareRead(getProperty(onuWorkingVoltage));
        prepareRead(getProperty(onuWorkingTemperature));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuReceivedOpticalPower));
        prepareRead(getProperty(onuTramsmittedOpticalPower));
        prepareRead(getProperty(onuBiasCurrent));
        prepareRead(getProperty(onuWorkingVoltage));
        prepareRead(getProperty(onuWorkingTemperature));

        //return loadAll(new int[]{1, 1, 1});
        return loadAll(new int[]{1});
    }

}