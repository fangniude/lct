/**
 * Created by Zhou Chao, 2009/10/28
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r216;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OnuDbaProfileTable extends SnmpMibBean {

    public static final String utsDot3DbaProfileId = "utsDot3DbaProfileId";
    public static final String utsDot3DbaProfileName = "utsDot3DbaProfileName";
    public static final String utsDot3DbaProfileUpCir = "utsDot3DbaProfileUpCir";
    public static final String utsDot3DbaProfileUpFir = "utsDot3DbaProfileUpFir";
    public static final String utsDot3DbaProfileUpPir = "utsDot3DbaProfileUpPir";
    public static final String utsDot3DbaProfileUpBurst = "utsDot3DbaProfileUpBurst";
    public static final String utsDot3DbaProfileUpPriority = "utsDot3DbaProfileUpPriority";
    public static final String utsDot3DbaProfileDownCir = "utsDot3DbaProfileDownCir";
    public static final String utsDot3DbaProfileDownPir = "utsDot3DbaProfileDownPir";
    public static final String utsDot3DbaProfileDownBurst = "utsDot3DbaProfileDownBurst";

    public OnuDbaProfileTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3DbaProfileId, new SnmpMibBeanProperty(utsDot3DbaProfileId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileName, new SnmpMibBeanProperty(utsDot3DbaProfileName, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.2", ISnmpConstant.STRING));
        initProperty(utsDot3DbaProfileUpCir, new SnmpMibBeanProperty(utsDot3DbaProfileUpCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileUpFir, new SnmpMibBeanProperty(utsDot3DbaProfileUpFir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.4", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileUpPir, new SnmpMibBeanProperty(utsDot3DbaProfileUpPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.5", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileUpBurst, new SnmpMibBeanProperty(utsDot3DbaProfileUpBurst, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.6", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileUpPriority, new SnmpMibBeanProperty(utsDot3DbaProfileUpPriority, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.7", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileDownCir, new SnmpMibBeanProperty(utsDot3DbaProfileDownCir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.8", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileDownPir, new SnmpMibBeanProperty(utsDot3DbaProfileDownPir, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.9", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaProfileDownBurst, new SnmpMibBeanProperty(utsDot3DbaProfileDownBurst, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.10", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.36.1.100", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3DbaProfileId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3DbaProfileId(Integer aUtsDot3DbaProfileId) {
        setIndex(0, aUtsDot3DbaProfileId);
    }

    public String getUtsDot3DbaProfileName() {
        return (String) getProperty(utsDot3DbaProfileName).getValue();
    }

    public void setUtsDot3DbaProfileName(String aUtsDot3DbaProfileName) {
        getProperty(utsDot3DbaProfileName).setValue(aUtsDot3DbaProfileName);
    }

    public Integer getUtsDot3DbaProfileUpCir() {
        return (Integer) getProperty(utsDot3DbaProfileUpCir).getValue();
    }

    public void setUtsDot3DbaProfileUpCir(Integer aUtsDot3DbaProfileUpCir) {
        getProperty(utsDot3DbaProfileUpCir).setValue(aUtsDot3DbaProfileUpCir);
    }

    public Integer getUtsDot3DbaProfileUpFir() {
        return (Integer) getProperty(utsDot3DbaProfileUpFir).getValue();
    }

    public void setUtsDot3DbaProfileUpFir(Integer aUtsDot3DbaProfileUpFir) {
        getProperty(utsDot3DbaProfileUpFir).setValue(aUtsDot3DbaProfileUpFir);
    }

    public Integer getUtsDot3DbaProfileUpPir() {
        return (Integer) getProperty(utsDot3DbaProfileUpPir).getValue();
    }

    public void setUtsDot3DbaProfileUpPir(Integer aUtsDot3DbaProfileUpPir) {
        getProperty(utsDot3DbaProfileUpPir).setValue(aUtsDot3DbaProfileUpPir);
    }

    public Integer getUtsDot3DbaProfileUpBurst() {
        return (Integer) getProperty(utsDot3DbaProfileUpBurst).getValue();
    }

    public void setUtsDot3DbaProfileUpBurst(Integer aUtsDot3DbaProfileUpBurst) {
        getProperty(utsDot3DbaProfileUpBurst).setValue(aUtsDot3DbaProfileUpBurst);
    }

    public Integer getUtsDot3DbaProfileUpPriority() {
        return (Integer) getProperty(utsDot3DbaProfileUpPriority).getValue();
    }

    public void setUtsDot3DbaProfileUpPriority(Integer aUtsDot3DbaProfileUpPriority) {
        getProperty(utsDot3DbaProfileUpPriority).setValue(aUtsDot3DbaProfileUpPriority);
    }

    public Integer getUtsDot3DbaProfileDownCir() {
        return (Integer) getProperty(utsDot3DbaProfileDownCir).getValue();
    }

    public void setUtsDot3DbaProfileDownCir(Integer aUtsDot3DbaProfileDownCir) {
        getProperty(utsDot3DbaProfileDownCir).setValue(aUtsDot3DbaProfileDownCir);
    }

    public Integer getUtsDot3DbaProfileDownPir() {
        return (Integer) getProperty(utsDot3DbaProfileDownPir).getValue();
    }

    public void setUtsDot3DbaProfileDownPir(Integer aUtsDot3DbaProfileDownPir) {
        getProperty(utsDot3DbaProfileDownPir).setValue(aUtsDot3DbaProfileDownPir);
    }

    public Integer getUtsDot3DbaProfileDownBurst() {
        return (Integer) getProperty(utsDot3DbaProfileDownBurst).getValue();
    }

    public void setUtsDot3DbaProfileDownBurst(Integer aUtsDot3DbaProfileDownBurst) {
        getProperty(utsDot3DbaProfileDownBurst).setValue(aUtsDot3DbaProfileDownBurst);
    }

    public boolean retrieve() throws MibBeanException {
        //prepareRead(getProperty(utsDot3DbaProfileId));
        prepareRead(getProperty(utsDot3DbaProfileName));
        prepareRead(getProperty(utsDot3DbaProfileUpCir));
        prepareRead(getProperty(utsDot3DbaProfileUpFir));
        prepareRead(getProperty(utsDot3DbaProfileUpPir));
        prepareRead(getProperty(utsDot3DbaProfileUpBurst));
        prepareRead(getProperty(utsDot3DbaProfileUpPriority));
        prepareRead(getProperty(utsDot3DbaProfileDownCir));
        prepareRead(getProperty(utsDot3DbaProfileDownPir));
        prepareRead(getProperty(utsDot3DbaProfileDownBurst));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        //prepareRead(getProperty(utsDot3DbaProfileId));
        prepareRead(getProperty(utsDot3DbaProfileName));
        prepareRead(getProperty(utsDot3DbaProfileUpCir));
        prepareRead(getProperty(utsDot3DbaProfileUpFir));
        prepareRead(getProperty(utsDot3DbaProfileUpPir));
        prepareRead(getProperty(utsDot3DbaProfileUpBurst));
        prepareRead(getProperty(utsDot3DbaProfileUpPriority));
        prepareRead(getProperty(utsDot3DbaProfileDownCir));
        prepareRead(getProperty(utsDot3DbaProfileDownPir));
        prepareRead(getProperty(utsDot3DbaProfileDownBurst));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3DbaProfileName));
        prepareSave(getProperty(utsDot3DbaProfileUpCir));
        prepareSave(getProperty(utsDot3DbaProfileUpFir));
        prepareSave(getProperty(utsDot3DbaProfileUpPir));
        prepareSave(getProperty(utsDot3DbaProfileUpBurst));
        prepareSave(getProperty(utsDot3DbaProfileUpPriority));
        prepareSave(getProperty(utsDot3DbaProfileDownCir));
        prepareSave(getProperty(utsDot3DbaProfileDownPir));
        prepareSave(getProperty(utsDot3DbaProfileDownBurst));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(utsDot3DbaProfileName));
        prepareSave(getProperty(utsDot3DbaProfileUpCir));
        prepareSave(getProperty(utsDot3DbaProfileUpFir));
        prepareSave(getProperty(utsDot3DbaProfileUpPir));
        prepareSave(getProperty(utsDot3DbaProfileUpBurst));
        prepareSave(getProperty(utsDot3DbaProfileUpPriority));
        prepareSave(getProperty(utsDot3DbaProfileDownCir));
        prepareSave(getProperty(utsDot3DbaProfileDownPir));
        prepareSave(getProperty(utsDot3DbaProfileDownBurst));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public String toString() {
        return getUtsDot3DbaProfileName();
    }

}