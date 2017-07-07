package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OltPonLinkCfgTable extends SnmpMibBean {

    public static final String oltPonLinkCfgSlotNo = "oltPonLinkCfgSlotNo";
    public static final String oltPonLinkCfgPortNo = "oltPonLinkCfgPortNo";
    public static final String oltPonLinkCfgAdministrativeState = "oltPonLinkCfgAdministrativeState";
    public static final String oltPonLinkCfgOperationalState = "oltPonLinkCfgOperationalState";
    public static final String oltPonLinkCfgProtocolProfileIndex = "oltPonLinkCfgProtocolProfileIndex";
    public static final String oltPonLinkCfgOnuDiscoveryMode = "oltPonLinkCfgOnuDiscoveryMode";
    public static final String oltPonLinkCfgOnuDiscoveryInterval = "oltPonLinkCfgOnuDiscoveryInterval";
    public static final String oltPonLinkCfgCycleTime = "oltPonLinkCfgCycleTime";

    public OltPonLinkCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltPonLinkCfgSlotNo, new SnmpMibBeanProperty(oltPonLinkCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.1", ISnmpConstant.INTEGER));
        initProperty(oltPonLinkCfgPortNo, new SnmpMibBeanProperty(oltPonLinkCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.2", ISnmpConstant.INTEGER));
        initProperty(oltPonLinkCfgAdministrativeState, new SnmpMibBeanProperty(oltPonLinkCfgAdministrativeState, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.3", ISnmpConstant.INTEGER));
        initProperty(oltPonLinkCfgOperationalState, new SnmpMibBeanProperty(oltPonLinkCfgOperationalState, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.4", ISnmpConstant.INTEGER));
        initProperty(oltPonLinkCfgProtocolProfileIndex, new SnmpMibBeanProperty(oltPonLinkCfgProtocolProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.5", ISnmpConstant.GAUGE));
        initProperty(oltPonLinkCfgOnuDiscoveryMode, new SnmpMibBeanProperty(oltPonLinkCfgOnuDiscoveryMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.6", ISnmpConstant.INTEGER));
        initProperty(oltPonLinkCfgOnuDiscoveryInterval, new SnmpMibBeanProperty(oltPonLinkCfgOnuDiscoveryInterval, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.7", ISnmpConstant.GAUGE));
        initProperty(oltPonLinkCfgCycleTime, new SnmpMibBeanProperty(oltPonLinkCfgCycleTime, ".1.3.6.1.4.1.41355.1.3.10.5.1.3.1.8", ISnmpConstant.GAUGE));
    }

    public Integer getOltPonLinkCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOltPonLinkCfgSlotNo(Integer aOltPonLinkCfgSlotNo) {
        setIndex(0, aOltPonLinkCfgSlotNo);
    }

    public Integer getOltPonLinkCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOltPonLinkCfgPortNo(Integer aOltPonLinkCfgPortNo) {
        setIndex(1, aOltPonLinkCfgPortNo);
    }

    public Integer getOltPonLinkCfgAdministrativeState() {
        return (Integer) getProperty(oltPonLinkCfgAdministrativeState).getValue();
    }

    public void setOltPonLinkCfgAdministrativeState(Integer aOltPonLinkCfgAdministrativeState) {
        getProperty(oltPonLinkCfgAdministrativeState).setValue(aOltPonLinkCfgAdministrativeState);
    }

    public Integer getOltPonLinkCfgOperationalState() {
        return (Integer) getProperty(oltPonLinkCfgOperationalState).getValue();
    }

    public void setOltPonLinkCfgOperationalState(Integer aOltPonLinkCfgOperationalState) {
        getProperty(oltPonLinkCfgOperationalState).setValue(aOltPonLinkCfgOperationalState);
    }

    public Long getOltPonLinkCfgProtocolProfileIndex() {
        return (Long) getProperty(oltPonLinkCfgProtocolProfileIndex).getValue();
    }

    public void setOltPonLinkCfgProtocolProfileIndex(Long aOltPonLinkCfgProtocolProfileIndex) {
        getProperty(oltPonLinkCfgProtocolProfileIndex).setValue(aOltPonLinkCfgProtocolProfileIndex);
    }

    public Integer getOltPonLinkCfgOnuDiscoveryMode() {
        return (Integer) getProperty(oltPonLinkCfgOnuDiscoveryMode).getValue();
    }

    public void setOltPonLinkCfgOnuDiscoveryMode(Integer aOltPonLinkCfgOnuDiscoveryMode) {
        getProperty(oltPonLinkCfgOnuDiscoveryMode).setValue(aOltPonLinkCfgOnuDiscoveryMode);
    }

    public Long getOltPonLinkCfgOnuDiscoveryInterval() {
        return (Long) getProperty(oltPonLinkCfgOnuDiscoveryInterval).getValue();
    }

    public void setOltPonLinkCfgOnuDiscoveryInterval(Long aOltPonLinkCfgOnuDiscoveryInterval) {
        getProperty(oltPonLinkCfgOnuDiscoveryInterval).setValue(aOltPonLinkCfgOnuDiscoveryInterval);
    }

    public Long getOltPonLinkCfgCycleTime() {
        return (Long) getProperty(oltPonLinkCfgCycleTime).getValue();
    }

    public void setOltPonLinkCfgCycleTime(Long aOltPonLinkCfgCycleTime) {
        getProperty(oltPonLinkCfgCycleTime).setValue(aOltPonLinkCfgCycleTime);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(oltPonLinkCfgAdministrativeState));
        prepareRead(getProperty(oltPonLinkCfgOperationalState));
        prepareRead(getProperty(oltPonLinkCfgProtocolProfileIndex));
        prepareRead(getProperty(oltPonLinkCfgOnuDiscoveryMode));
        prepareRead(getProperty(oltPonLinkCfgOnuDiscoveryInterval));
        prepareRead(getProperty(oltPonLinkCfgCycleTime));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(oltPonLinkCfgAdministrativeState));
        prepareRead(getProperty(oltPonLinkCfgOperationalState));
        prepareRead(getProperty(oltPonLinkCfgProtocolProfileIndex));
        prepareRead(getProperty(oltPonLinkCfgOnuDiscoveryMode));
        prepareRead(getProperty(oltPonLinkCfgOnuDiscoveryInterval));
        prepareRead(getProperty(oltPonLinkCfgCycleTime));

        return loadAll(new int[]{1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltPonLinkCfgAdministrativeState));
        prepareSave(getProperty(oltPonLinkCfgProtocolProfileIndex));
        prepareSave(getProperty(oltPonLinkCfgOnuDiscoveryMode));
        prepareSave(getProperty(oltPonLinkCfgOnuDiscoveryInterval));
        prepareSave(getProperty(oltPonLinkCfgCycleTime));

        return save();
    }

}