/**
 * Created by Zhou Chao, 2010/6/22
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UniExtAttributeTable extends SnmpMibBean {

    public static final String uniExtAttributeCardIndex = "uniExtAttributeCardIndex";
    public static final String uniExtAttributePortIndex = "uniExtAttributePortIndex";
    public static final String uniPerfStats15minuteEnable = "uniPerfStats15minuteEnable";
    public static final String uniPerfStats24hourEnable = "uniPerfStats24hourEnable";
    public static final String uniLastChangeTime = "uniLastChangeTime";
    public static final String uniIsolationEnable = "uniIsolationEnable";
    public static final String uniMacAddrLearnMaxNum = "uniMacAddrLearnMaxNum";

    public UniExtAttributeTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(uniExtAttributeCardIndex, new SnmpMibBeanProperty(uniExtAttributeCardIndex, ".1.3.6.1.4.1.17409.2.3.5.7.1.1", ISnmpConstant.INTEGER));
        initProperty(uniExtAttributePortIndex, new SnmpMibBeanProperty(uniExtAttributePortIndex, ".1.3.6.1.4.1.17409.2.3.5.7.1.2", ISnmpConstant.INTEGER));
        initProperty(uniPerfStats15minuteEnable, new SnmpMibBeanProperty(uniPerfStats15minuteEnable, ".1.3.6.1.4.1.17409.2.3.5.7.1.3", ISnmpConstant.INTEGER));
        initProperty(uniPerfStats24hourEnable, new SnmpMibBeanProperty(uniPerfStats24hourEnable, ".1.3.6.1.4.1.17409.2.3.5.7.1.4", ISnmpConstant.INTEGER));
        initProperty(uniLastChangeTime, new SnmpMibBeanProperty(uniLastChangeTime, ".1.3.6.1.4.1.17409.2.3.5.7.1.5", ISnmpConstant.COUNTER));
        initProperty(uniIsolationEnable, new SnmpMibBeanProperty(uniIsolationEnable, ".1.3.6.1.4.1.17409.2.3.5.7.1.6", ISnmpConstant.INTEGER));
        initProperty(uniMacAddrLearnMaxNum, new SnmpMibBeanProperty(uniMacAddrLearnMaxNum, ".1.3.6.1.4.1.17409.2.3.5.7.1.7", ISnmpConstant.INTEGER));
    }

    public Integer getUniExtAttributeCardIndex() {
        return (Integer) getIndex(0);
    }

    public void setUniExtAttributeCardIndex(Integer aUniExtAttributeCardIndex) {
        setIndex(0, aUniExtAttributeCardIndex);
    }

    public Integer getUniExtAttributePortIndex() {
        return (Integer) getIndex(1);
    }

    public void setUniExtAttributePortIndex(Integer aUniExtAttributePortIndex) {
        setIndex(1, aUniExtAttributePortIndex);
    }

    public Integer getUniPerfStats15minuteEnable() {
        return (Integer) getProperty(uniPerfStats15minuteEnable).getValue();
    }

    public void setUniPerfStats15minuteEnable(Integer aUniPerfStats15minuteEnable) {
        getProperty(uniPerfStats15minuteEnable).setValue(aUniPerfStats15minuteEnable);
    }

    public Integer getUniPerfStats24hourEnable() {
        return (Integer) getProperty(uniPerfStats24hourEnable).getValue();
    }

    public void setUniPerfStats24hourEnable(Integer aUniPerfStats24hourEnable) {
        getProperty(uniPerfStats24hourEnable).setValue(aUniPerfStats24hourEnable);
    }

    public Long getUniLastChangeTime() {
        return (Long) getProperty(uniLastChangeTime).getValue();
    }

    public void setUniLastChangeTime(Long aUniLastChangeTime) {
        getProperty(uniLastChangeTime).setValue(aUniLastChangeTime);
    }

    public Integer getUniIsolationEnable() {
        return (Integer) getProperty(uniIsolationEnable).getValue();
    }

    public void setUniIsolationEnable(Integer aUniIsolationEnable) {
        getProperty(uniIsolationEnable).setValue(aUniIsolationEnable);
    }

    public Integer getUniMacAddrLearnMaxNum() {
        return (Integer) getProperty(uniMacAddrLearnMaxNum).getValue();
    }

    public void setUniMacAddrLearnMaxNum(Integer aUniMacAddrLearnMaxNum) {
        getProperty(uniMacAddrLearnMaxNum).setValue(aUniMacAddrLearnMaxNum);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(uniPerfStats15minuteEnable));
        prepareRead(getProperty(uniPerfStats24hourEnable));
        prepareRead(getProperty(uniLastChangeTime));
        prepareRead(getProperty(uniIsolationEnable));
        prepareRead(getProperty(uniMacAddrLearnMaxNum));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(uniPerfStats15minuteEnable));
        prepareRead(getProperty(uniPerfStats24hourEnable));
        prepareRead(getProperty(uniLastChangeTime));
        prepareRead(getProperty(uniIsolationEnable));
        prepareRead(getProperty(uniMacAddrLearnMaxNum));

        return loadAll(new int[]{1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(uniPerfStats15minuteEnable));
        prepareSave(getProperty(uniPerfStats24hourEnable));
        prepareSave(getProperty(uniIsolationEnable));
        prepareSave(getProperty(uniMacAddrLearnMaxNum));

        return save();
    }

}