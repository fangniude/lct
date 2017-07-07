/**
 * Created by Zhou Chao, 2010/5/26
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class QosGlobalSetTable extends SnmpMibBean {

    public static final String qosGlobalSetDeviceIndex = "qosGlobalSetDeviceIndex";
    public static final String qosGlobalSetMaxQueueCount = "qosGlobalSetMaxQueueCount";
    public static final String qosGlobalSetMode = "qosGlobalSetMode";

    public QosGlobalSetTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(qosGlobalSetDeviceIndex, new SnmpMibBeanProperty(qosGlobalSetDeviceIndex, ".1.3.6.1.4.1.17409.2.3.8.1.1.1", ISnmpConstant.INTEGER));
        initProperty(qosGlobalSetMaxQueueCount, new SnmpMibBeanProperty(qosGlobalSetMaxQueueCount, ".1.3.6.1.4.1.17409.2.3.8.1.1.2", ISnmpConstant.INTEGER));
        initProperty(qosGlobalSetMode, new SnmpMibBeanProperty(qosGlobalSetMode, ".1.3.6.1.4.1.17409.2.3.8.1.1.3", ISnmpConstant.INTEGER));
    }

    public Integer getQosGlobalSetDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setQosGlobalSetDeviceIndex(Integer aQosGlobalSetDeviceIndex) {
        setIndex(0, aQosGlobalSetDeviceIndex);
    }

    public Integer getQosGlobalSetMaxQueueCount() {
        return (Integer) getProperty(qosGlobalSetMaxQueueCount).getValue();
    }

    public void setQosGlobalSetMaxQueueCount(Integer aQosGlobalSetMaxQueueCount) {
        getProperty(qosGlobalSetMaxQueueCount).setValue(aQosGlobalSetMaxQueueCount);
    }

    public Integer getQosGlobalSetMode() {
        return (Integer) getProperty(qosGlobalSetMode).getValue();
    }

    public void setQosGlobalSetMode(Integer aQosGlobalSetMode) {
        getProperty(qosGlobalSetMode).setValue(aQosGlobalSetMode);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(qosGlobalSetMaxQueueCount));
        prepareRead(getProperty(qosGlobalSetMode));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(qosGlobalSetMaxQueueCount));
        prepareRead(getProperty(qosGlobalSetMode));

        return loadAll(new int[]{1});
    }

}