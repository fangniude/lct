/**
 * Created by Zhou Chao, 2010/3/15
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UniPortRateLimitTable extends SnmpMibBean {

    public static final String uniPortRateLimitDeviceIndex = "uniPortRateLimitDeviceIndex";
    public static final String uniPortRateLimitCardIndex = "uniPortRateLimitCardIndex";
    public static final String uniPortRateLimitPortIndex = "uniPortRateLimitPortIndex";
    public static final String uniPortInCIR = "uniPortInCIR";
    public static final String uniPortInCBS = "uniPortInCBS";
    public static final String uniPortInEBS = "uniPortInEBS";
    public static final String uniPortOutCIR = "uniPortOutCIR";
    /*
    public static final String uniPortOutCBS = "uniPortOutCBS";
    public static final String uniPortOutPBS = "uniPortOutPBS";
    */
    public static final String uniPortOutPIR = "uniPortOutPIR";
    public static final String uniPortInRateLimitEnable = "uniPortInRateLimitEnable";
    public static final String uniPortOutRateLimitEnable = "uniPortOutRateLimitEnable";

    public UniPortRateLimitTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniPortRateLimitDeviceIndex, new SnmpMibBeanProperty(uniPortRateLimitDeviceIndex, ".1.3.6.1.4.1.17409.2.3.5.4.1.1", ISnmpConstant.INTEGER));
        initProperty(uniPortRateLimitCardIndex, new SnmpMibBeanProperty(uniPortRateLimitCardIndex, ".1.3.6.1.4.1.17409.2.3.5.4.1.2", ISnmpConstant.INTEGER));
        initProperty(uniPortRateLimitPortIndex, new SnmpMibBeanProperty(uniPortRateLimitPortIndex, ".1.3.6.1.4.1.17409.2.3.5.4.1.3", ISnmpConstant.INTEGER));
        initProperty(uniPortInCIR, new SnmpMibBeanProperty(uniPortInCIR, ".1.3.6.1.4.1.17409.2.3.5.4.1.4", ISnmpConstant.INTEGER));
        initProperty(uniPortInCBS, new SnmpMibBeanProperty(uniPortInCBS, ".1.3.6.1.4.1.17409.2.3.5.4.1.5", ISnmpConstant.INTEGER));
        initProperty(uniPortInEBS, new SnmpMibBeanProperty(uniPortInEBS, ".1.3.6.1.4.1.17409.2.3.5.4.1.6", ISnmpConstant.INTEGER));
        initProperty(uniPortOutCIR, new SnmpMibBeanProperty(uniPortOutCIR, ".1.3.6.1.4.1.17409.2.3.5.4.1.7", ISnmpConstant.INTEGER));
        /*
        initProperty(uniPortOutCBS, new SnmpMibBeanProperty(uniPortOutCBS, ".1.3.6.1.4.1.17409.2.3.5.4.1.8", ISnmpConstant.INTEGER));
        initProperty(uniPortOutPBS, new SnmpMibBeanProperty(uniPortOutPBS, ".1.3.6.1.4.1.17409.2.3.5.4.1.9", ISnmpConstant.INTEGER));
        */
        initProperty(uniPortOutPIR, new SnmpMibBeanProperty(uniPortOutPIR, ".1.3.6.1.4.1.17409.2.3.5.4.1.8", ISnmpConstant.INTEGER));
        initProperty(uniPortInRateLimitEnable, new SnmpMibBeanProperty(uniPortInRateLimitEnable, ".1.3.6.1.4.1.17409.2.3.5.4.1.9", ISnmpConstant.INTEGER));
        initProperty(uniPortOutRateLimitEnable, new SnmpMibBeanProperty(uniPortOutRateLimitEnable, ".1.3.6.1.4.1.17409.2.3.5.4.1.10", ISnmpConstant.INTEGER));
    }

    public Integer getUniPortRateLimitDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniPortRateLimitDeviceIndex(Integer aUniPortRateLimitDeviceIndex) {
        setIndex(0, aUniPortRateLimitDeviceIndex);
    }

    public Integer getUniPortRateLimitCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setUniPortRateLimitCardIndex(Integer aUniPortRateLimitCardIndex) {
        setIndex(1, aUniPortRateLimitCardIndex);
    }

    public Integer getUniPortRateLimitPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setUniPortRateLimitPortIndex(Integer aUniPortRateLimitPortIndex) {
        setIndex(2, aUniPortRateLimitPortIndex);
    }

    public Integer getUniPortInCIR() {
        return (Integer) getProperty(uniPortInCIR).getValue();
    }

    public void setUniPortInCIR(Integer aUniPortInCIR) {
        getProperty(uniPortInCIR).setValue(aUniPortInCIR);
    }

    public Integer getUniPortInCBS() {
        return (Integer) getProperty(uniPortInCBS).getValue();
    }

    public void setUniPortInCBS(Integer aUniPortInCBS) {
        getProperty(uniPortInCBS).setValue(aUniPortInCBS);
    }

    public Integer getUniPortInEBS() {
        return (Integer) getProperty(uniPortInEBS).getValue();
    }

    public void setUniPortInEBS(Integer aUniPortInEBS) {
        getProperty(uniPortInEBS).setValue(aUniPortInEBS);
    }

    public Integer getUniPortOutCIR() {
        return (Integer) getProperty(uniPortOutCIR).getValue();
    }

    public void setUniPortOutCIR(Integer aUniPortOutCIR) {
        getProperty(uniPortOutCIR).setValue(aUniPortOutCIR);
    }

    /*
    public Integer getUniPortOutCBS() {
        return (Integer) getProperty(uniPortOutCBS).getValue();
    }

    public void setUniPortOutCBS(Integer aUniPortOutCBS) {
        getProperty(uniPortOutCBS).setValue(aUniPortOutCBS);
    }

    public Integer getUniPortOutPBS() {
        return (Integer) getProperty(uniPortOutPBS).getValue();
    }

    public void setUniPortOutPBS(Integer aUniPortOutPBS) {
        getProperty(uniPortOutPBS).setValue(aUniPortOutPBS);
    }
    */

    public Integer getUniPortOutPIR() {
        return (Integer) getProperty(uniPortOutPIR).getValue();
    }

    public void setUniPortOutPIR(Integer aUniPortOutPIR) {
        getProperty(uniPortOutPIR).setValue(aUniPortOutPIR);
    }

    public Integer getUniPortInRateLimitEnable() {
        return (Integer) getProperty(uniPortInRateLimitEnable).getValue();
    }

    public void setUniPortInRateLimitEnable(Integer aUniPortInRateLimitEnable) {
        getProperty(uniPortInRateLimitEnable).setValue(aUniPortInRateLimitEnable);
    }

    public Integer getUniPortOutRateLimitEnable() {
        return (Integer) getProperty(uniPortOutRateLimitEnable).getValue();
    }

    public void setUniPortOutRateLimitEnable(Integer aUniPortOutRateLimitEnable) {
        getProperty(uniPortOutRateLimitEnable).setValue(aUniPortOutRateLimitEnable);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniPortInCIR));
        prepareRead(getProperty(uniPortInCBS));
        prepareRead(getProperty(uniPortInEBS));
        prepareRead(getProperty(uniPortOutCIR));
        /*
        prepareRead(getProperty(uniPortOutCBS));
        prepareRead(getProperty(uniPortOutPBS));
        */
        prepareRead(getProperty(uniPortOutPIR));
        prepareRead(getProperty(uniPortInRateLimitEnable));
        prepareRead(getProperty(uniPortOutRateLimitEnable));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniPortInCIR));
        prepareRead(getProperty(uniPortInCBS));
        prepareRead(getProperty(uniPortInEBS));
        prepareRead(getProperty(uniPortOutCIR));
        /*
        prepareRead(getProperty(uniPortOutCBS));
        prepareRead(getProperty(uniPortOutPBS));
        */
        prepareRead(getProperty(uniPortOutPIR));
        prepareRead(getProperty(uniPortInRateLimitEnable));
        prepareRead(getProperty(uniPortOutRateLimitEnable));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniPortInCIR));
        prepareSave(getProperty(uniPortInCBS));
        prepareSave(getProperty(uniPortInEBS));
        prepareSave(getProperty(uniPortOutCIR));
        /*
        prepareSave(getProperty(uniPortOutCBS));
        prepareSave(getProperty(uniPortOutPBS));
        */
        prepareSave(getProperty(uniPortOutPIR));
        prepareSave(getProperty(uniPortInRateLimitEnable));
        prepareSave(getProperty(uniPortOutRateLimitEnable));

        return save();
    }

}