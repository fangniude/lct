package com.winnertel.ems.epon.iad.bbs4000.mib.r221;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuScheduleUpgradeResultTable extends SnmpMibBean {
    public static final String utsDot3OnuFWUpgradeResultIndex = "utsDot3OnuFWUpgradeResultIndex";
    public static final String utsDot3OnuFWUpgradeResultUpgMode = "utsDot3OnuFWUpgradeResultUpgMode";
    public static final String utsDot3OnuFWUpgradeResultStartingHour = "utsDot3OnuFWUpgradeResultStartingHour";
    public static final String utsDot3OnuFWUpgradeResultStartingMinute = "utsDot3OnuFWUpgradeResultStartingMinute";
    public static final String utsDot3OnuFWUpgradeResultModule = "utsDot3OnuFWUpgradeResultModule";
    public static final String utsDot3OnuFWUpgradeResultPort = "utsDot3OnuFWUpgradeResultPort";
    public static final String utsDot3OnuFWUpgradeResultLogicalPort = "utsDot3OnuFWUpgradeResultLogicalPort";
    public static final String utsDot3OnuFWUpgradeResultStatus = "utsDot3OnuFWUpgradeResultStatus";
    public static final String utsDot3OnuFWUpgradeResultStationId = "utsDot3OnuFWUpgradeResultStationId";
    public static final String utsDot3OnuFWUpgradeResultTargetVer = "utsDot3OnuFWUpgradeResultTargetVer";
    public static final String utsDot3OnuFWUpgradeResultCurrVer = "utsDot3OnuFWUpgradeResultCurrVer";
    public static final String utsDot3OnuFWUpgradeResultFinalState = "utsDot3OnuFWUpgradeResultFinalState";
    public static final String utsDot3CtcTftpOamUpgradeResultIfCommitted = "utsDot3CtcTftpOamUpgradeResultIfCommitted";

    public OnuScheduleUpgradeResultTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3OnuFWUpgradeResultIndex, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultIndex, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultUpgMode, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultUpgMode, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultStartingHour, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultStartingHour, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultStartingMinute, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultStartingMinute, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultModule, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultModule, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultPort, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultPort, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultLogicalPort, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultLogicalPort, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultStatus, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3OnuFWUpgradeResultStationId, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultStationId, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.9", ISnmpConstant.STRING));
        initProperty(utsDot3OnuFWUpgradeResultTargetVer, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultTargetVer, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.10", ISnmpConstant.STRING));
        initProperty(utsDot3OnuFWUpgradeResultCurrVer, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultCurrVer, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.11", ISnmpConstant.STRING));
        initProperty(utsDot3OnuFWUpgradeResultFinalState, new SnmpMibBeanProperty(utsDot3OnuFWUpgradeResultFinalState, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.12", ISnmpConstant.STRING));
        initProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted, new SnmpMibBeanProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted, ".1.3.6.1.4.1.41355.1800.2.3.1.7.4.1.1.13", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3OnuFWUpgradeResultIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3OnuFWUpgradeResultIndex(Integer aUtsDot3OnuFWUpgradeResultIndex) {
        setIndex(0, aUtsDot3OnuFWUpgradeResultIndex);
    }

    public Integer getUtsDot3OnuFWUpgradeResultUpgMode() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultUpgMode).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultUpgMode(Integer aUtsDot3OnuFWUpgradeResultUpgMode) {
        getProperty(utsDot3OnuFWUpgradeResultUpgMode).setValue(aUtsDot3OnuFWUpgradeResultUpgMode);
    }

    public Integer getUtsDot3OnuFWUpgradeResultStartingHour() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultStartingHour).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultStartingHour(Integer aUtsDot3OnuFWUpgradeResultStartingHour) {
        getProperty(utsDot3OnuFWUpgradeResultStartingHour).setValue(aUtsDot3OnuFWUpgradeResultStartingHour);
    }

    public Integer getUtsDot3OnuFWUpgradeResultStartingMinute() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultStartingMinute).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultStartingMinute(Integer aUtsDot3OnuFWUpgradeResultStartingMinute) {
        getProperty(utsDot3OnuFWUpgradeResultStartingMinute).setValue(aUtsDot3OnuFWUpgradeResultStartingMinute);
    }

    public Integer getUtsDot3OnuFWUpgradeResultModule() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultModule).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultModule(Integer aUtsDot3OnuFWUpgradeResultModule) {
        getProperty(utsDot3OnuFWUpgradeResultModule).setValue(aUtsDot3OnuFWUpgradeResultModule);
    }

    public Integer getUtsDot3OnuFWUpgradeResultPort() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultPort).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultPort(Integer aUtsDot3OnuFWUpgradeResultPort) {
        getProperty(utsDot3OnuFWUpgradeResultPort).setValue(aUtsDot3OnuFWUpgradeResultPort);
    }

    public Integer getUtsDot3OnuFWUpgradeResultLogicalPort() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultLogicalPort).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultLogicalPort(Integer aUtsDot3OnuFWUpgradeResultLogicalPort) {
        getProperty(utsDot3OnuFWUpgradeResultLogicalPort).setValue(aUtsDot3OnuFWUpgradeResultLogicalPort);
    }

    public Integer getUtsDot3OnuFWUpgradeResultStatus() {
        return (Integer) getProperty(utsDot3OnuFWUpgradeResultStatus).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultStatus(Integer aUtsDot3OnuFWUpgradeResultStatus) {
        getProperty(utsDot3OnuFWUpgradeResultStatus).setValue(aUtsDot3OnuFWUpgradeResultStatus);
    }

    public String getUtsDot3OnuFWUpgradeResultStationId() {
        return (String) getProperty(utsDot3OnuFWUpgradeResultStationId).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultStationId(String aUtsDot3OnuFWUpgradeResultStationId) {
        getProperty(utsDot3OnuFWUpgradeResultStationId).setValue(aUtsDot3OnuFWUpgradeResultStationId);
    }

    public String getUtsDot3OnuFWUpgradeResultTargetVer() {
        return (String) getProperty(utsDot3OnuFWUpgradeResultTargetVer).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultTargetVer(String aUtsDot3OnuFWUpgradeResultTargetVer) {
        getProperty(utsDot3OnuFWUpgradeResultTargetVer).setValue(aUtsDot3OnuFWUpgradeResultTargetVer);
    }

    public String getUtsDot3OnuFWUpgradeResultCurrVer() {
        return (String) getProperty(utsDot3OnuFWUpgradeResultCurrVer).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultCurrVer(String aUtsDot3OnuFWUpgradeResultCurrVer) {
        getProperty(utsDot3OnuFWUpgradeResultCurrVer).setValue(aUtsDot3OnuFWUpgradeResultCurrVer);
    }

    public String getUtsDot3OnuFWUpgradeResultFinalState() {
        return (String) getProperty(utsDot3OnuFWUpgradeResultFinalState).getValue();
    }

    public void setUtsDot3OnuFWUpgradeResultFinalState(String aUtsDot3OnuFWUpgradeResultFinalState) {
        getProperty(utsDot3OnuFWUpgradeResultFinalState).setValue(aUtsDot3OnuFWUpgradeResultFinalState);
    }

    public Integer getUtsDot3CtcTftpOamUpgradeResultIfCommitted() {
        return (Integer)getProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted).getValue();
    }

    public void setUtsDot3CtcTftpOamUpgradeResultIfCommitted(Integer aUtsDot3CtcTftpOamUpgradeResultIfCommitted) {
        getProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted).setValue(aUtsDot3CtcTftpOamUpgradeResultIfCommitted);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultUpgMode));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStartingHour));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStartingMinute));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultModule));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultPort));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultLogicalPort));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStatus));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStationId));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultTargetVer));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultCurrVer));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultFinalState));
        prepareRead(super.getProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultUpgMode));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStartingHour));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStartingMinute));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultModule));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultPort));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultLogicalPort));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStatus));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultStationId));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultTargetVer));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultCurrVer));
        prepareRead(super.getProperty(utsDot3OnuFWUpgradeResultFinalState));
        prepareRead(super.getProperty(utsDot3CtcTftpOamUpgradeResultIfCommitted));

        Vector v = loadAll(new int[]{1});
        //filter the manual upgrade result items.
        if(v != null)
        {
          int i = 0;
          while(i < v.size())
          {
            OnuScheduleUpgradeResultTable bean = (OnuScheduleUpgradeResultTable)v.get(i);
            if(bean.getUtsDot3OnuFWUpgradeResultUpgMode().intValue() != 2) //2-schedule
              v.remove(i);
            else
              i++;
          }
        }

        return v;
    }
}
