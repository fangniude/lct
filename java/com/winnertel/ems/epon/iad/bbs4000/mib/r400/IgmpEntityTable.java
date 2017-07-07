/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class IgmpEntityTable extends SnmpMibBean {

    public static final String igmpDeviceIndex = "igmpDeviceIndex";
    public static final String igmpMode = "igmpMode";
    public static final String maxQueryResponseTime = "maxQueryResponseTime";
    public static final String robustVariable = "robustVariable";
    public static final String queryInterval = "queryInterval";
    public static final String lastMemberQueryInterval = "lastMemberQueryInterval";
    public static final String lastMemberQueryCount = "lastMemberQueryCount";
    public static final String igmpVersion = "igmpVersion";

    public IgmpEntityTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(igmpDeviceIndex, new SnmpMibBeanProperty(igmpDeviceIndex, ".1.3.6.1.4.1.17409.2.3.6.1.1.1", ISnmpConstant.INTEGER));
        initProperty(igmpMode, new SnmpMibBeanProperty(igmpMode, ".1.3.6.1.4.1.17409.2.3.6.1.1.2", ISnmpConstant.INTEGER));
        initProperty(maxQueryResponseTime, new SnmpMibBeanProperty(maxQueryResponseTime, ".1.3.6.1.4.1.17409.2.3.6.1.1.3", ISnmpConstant.INTEGER));
        initProperty(robustVariable, new SnmpMibBeanProperty(robustVariable, ".1.3.6.1.4.1.17409.2.3.6.1.1.4", ISnmpConstant.INTEGER));
        initProperty(queryInterval, new SnmpMibBeanProperty(queryInterval, ".1.3.6.1.4.1.17409.2.3.6.1.1.5", ISnmpConstant.INTEGER));
        initProperty(lastMemberQueryInterval, new SnmpMibBeanProperty(lastMemberQueryInterval, ".1.3.6.1.4.1.17409.2.3.6.1.1.6", ISnmpConstant.INTEGER));
        initProperty(lastMemberQueryCount, new SnmpMibBeanProperty(lastMemberQueryCount, ".1.3.6.1.4.1.17409.2.3.6.1.1.7", ISnmpConstant.INTEGER));
        initProperty(igmpVersion, new SnmpMibBeanProperty(igmpVersion, ".1.3.6.1.4.1.17409.2.3.6.1.1.8", ISnmpConstant.INTEGER));
    }

    public Integer getIgmpDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setIgmpDeviceIndex(Integer aIgmpDeviceIndex) {
        setIndex(0, aIgmpDeviceIndex);
    }

    public Integer getIgmpMode() {
        return (Integer) getProperty(igmpMode).getValue();
    }

    public void setIgmpMode(Integer aIgmpMode) {
        getProperty(igmpMode).setValue(aIgmpMode);
    }

    public Integer getMaxQueryResponseTime() {
        return (Integer) getProperty(maxQueryResponseTime).getValue();
    }

    public void setMaxQueryResponseTime(Integer aMaxQueryResponseTime) {
        getProperty(maxQueryResponseTime).setValue(aMaxQueryResponseTime);
    }

    public Integer getRobustVariable() {
        return (Integer) getProperty(robustVariable).getValue();
    }

    public void setRobustVariable(Integer aRobustVariable) {
        getProperty(robustVariable).setValue(aRobustVariable);
    }

    public Integer getQueryInterval() {
        return (Integer) getProperty(queryInterval).getValue();
    }

    public void setQueryInterval(Integer aQueryInterval) {
        getProperty(queryInterval).setValue(aQueryInterval);
    }

    public Integer getLastMemberQueryInterval() {
        return (Integer) getProperty(lastMemberQueryInterval).getValue();
    }

    public void setLastMemberQueryInterval(Integer aLastMemberQueryInterval) {
        getProperty(lastMemberQueryInterval).setValue(aLastMemberQueryInterval);
    }

    public Integer getLastMemberQueryCount() {
        return (Integer) getProperty(lastMemberQueryCount).getValue();
    }

    public void setLastMemberQueryCount(Integer aLastMemberQueryCount) {
        getProperty(lastMemberQueryCount).setValue(aLastMemberQueryCount);
    }

    public Integer getIgmpVersion() {
        return (Integer) getProperty(igmpVersion).getValue();
    }

    public void setIgmpVersion(Integer aIgmpVersion) {
        getProperty(igmpVersion).setValue(aIgmpVersion);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(igmpMode));
        prepareRead(getProperty(maxQueryResponseTime));
        prepareRead(getProperty(robustVariable));
        prepareRead(getProperty(queryInterval));
        prepareRead(getProperty(lastMemberQueryInterval));
        prepareRead(getProperty(lastMemberQueryCount));
        prepareRead(getProperty(igmpVersion));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(igmpMode));
        prepareRead(getProperty(maxQueryResponseTime));
        prepareRead(getProperty(robustVariable));
        prepareRead(getProperty(queryInterval));
        prepareRead(getProperty(lastMemberQueryInterval));
        prepareRead(getProperty(lastMemberQueryCount));
        prepareRead(getProperty(igmpVersion));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(igmpMode));
        prepareSave(getProperty(maxQueryResponseTime));
        prepareSave(getProperty(robustVariable));
        prepareSave(getProperty(queryInterval));
        prepareSave(getProperty(lastMemberQueryInterval));
        prepareSave(getProperty(lastMemberQueryCount));
        prepareSave(getProperty(igmpVersion));

        return save();
    }

}