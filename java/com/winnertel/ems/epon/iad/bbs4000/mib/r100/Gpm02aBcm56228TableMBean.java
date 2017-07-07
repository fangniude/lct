/**
 * Created by Zhou Chao, 2009/2/21
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Gpm02aBcm56228TableMBean extends SnmpMibBean {

    public static final String utsGpm02aBcm56228ModuleId = "utsGpm02aBcm56228ModuleId";
    public static final String utsGpm02aBcm56228DeviceId = "utsGpm02aBcm56228DeviceId";
    public static final String utsGpm02aBcm56228SchedulingMode = "utsGpm02aBcm56228SchedulingMode";
    public static final String utsGpm02aBcm56228SchedulingWeight = "utsGpm02aBcm56228SchedulingWeight";

    public Gpm02aBcm56228TableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsGpm02aBcm56228ModuleId, new SnmpMibBeanProperty(utsGpm02aBcm56228ModuleId, ".1.3.6.1.4.1.41355.1.3.10.16.2.1.3.1.1", ISnmpConstant.INTEGER));
        initProperty(utsGpm02aBcm56228DeviceId, new SnmpMibBeanProperty(utsGpm02aBcm56228DeviceId, ".1.3.6.1.4.1.41355.1.3.10.16.2.1.3.1.2", ISnmpConstant.INTEGER));
        initProperty(utsGpm02aBcm56228SchedulingMode, new SnmpMibBeanProperty(utsGpm02aBcm56228SchedulingMode, ".1.3.6.1.4.1.41355.1.3.10.16.2.1.3.1.3", ISnmpConstant.INTEGER));
        initProperty(utsGpm02aBcm56228SchedulingWeight, new SnmpMibBeanProperty(utsGpm02aBcm56228SchedulingWeight, ".1.3.6.1.4.1.41355.1.3.10.16.2.1.3.1.4", ISnmpConstant.OCTETS));
    }

    public Integer getUtsGpm02aBcm56228ModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsGpm02aBcm56228ModuleId(Integer aUtsGpm02aBcm56228ModuleId) {
        setIndex(0, aUtsGpm02aBcm56228ModuleId);
    }

    public Integer getUtsGpm02aBcm56228DeviceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsGpm02aBcm56228DeviceId(Integer aUtsGpm02aBcm56228DeviceId) {
        setIndex(1, aUtsGpm02aBcm56228DeviceId);
    }

    public Integer getUtsGpm02aBcm56228SchedulingMode() {
        return (Integer) getProperty(utsGpm02aBcm56228SchedulingMode).getValue();
    }

    public void setUtsGpm02aBcm56228SchedulingMode(Integer aUtsGpm02aBcm56228SchedulingMode) {
        getProperty(utsGpm02aBcm56228SchedulingMode).setValue(aUtsGpm02aBcm56228SchedulingMode);
    }

    public byte[] getUtsGpm02aBcm56228SchedulingWeight() {
        return (byte[]) getProperty(utsGpm02aBcm56228SchedulingWeight).getValue();
    }

    public void setUtsGpm02aBcm56228SchedulingWeight(byte[] aUtsGpm02aBcm56228SchedulingWeight) {
        getProperty(utsGpm02aBcm56228SchedulingWeight).setValue(aUtsGpm02aBcm56228SchedulingWeight);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsGpm02aBcm56228SchedulingMode));
        prepareRead(getProperty(utsGpm02aBcm56228SchedulingWeight));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsGpm02aBcm56228SchedulingMode));
        prepareRead(getProperty(utsGpm02aBcm56228SchedulingWeight));

        return loadAll(new int[]{1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsGpm02aBcm56228SchedulingMode));
        prepareSave(getProperty(utsGpm02aBcm56228SchedulingWeight));

        return save();
    }

}