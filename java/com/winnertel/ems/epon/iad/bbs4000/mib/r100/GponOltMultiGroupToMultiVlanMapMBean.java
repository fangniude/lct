/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOltMultiGroupToMultiVlanMapMBean extends SnmpMibBean {

    public static final String oltMultiGrouptoMultiVlanMapIndex = "oltMultiGrouptoMultiVlanMapIndex";
    public static final String oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart = "oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart";
    public static final String oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop = "oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop";
    public static final String oltMultiGrouptoMultiVlanMapVlanID = "oltMultiGrouptoMultiVlanMapVlanID";

    public GponOltMultiGroupToMultiVlanMapMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltMultiGrouptoMultiVlanMapIndex, new SnmpMibBeanProperty(oltMultiGrouptoMultiVlanMapIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.16.1.1", ISnmpConstant.GAUGE));
        initProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart, new SnmpMibBeanProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart, ".1.3.6.1.4.1.45121.1.3.10.5.2.16.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop, new SnmpMibBeanProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop, ".1.3.6.1.4.1.45121.1.3.10.5.2.16.1.3", ISnmpConstant.IP_ADDRESS));
        initProperty(oltMultiGrouptoMultiVlanMapVlanID, new SnmpMibBeanProperty(oltMultiGrouptoMultiVlanMapVlanID, ".1.3.6.1.4.1.45121.1.3.10.5.2.16.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.2.16.1.5", ISnmpConstant.INTEGER));
    }

    public Long getOltMultiGrouptoMultiVlanMapIndex() {
        return (Long) getIndex(0);
    }

    public void setOltMultiGrouptoMultiVlanMapIndex(Long aOltMultiGrouptoMultiVlanMapIndex) {
        setIndex(0, aOltMultiGrouptoMultiVlanMapIndex);
    }

    public String getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart() {
        return (String) getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart).getValue();
    }

    public void setOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart(String aOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart) {
        getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart).setValue(aOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart);
    }

    public String getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop() {
        return (String) getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop).getValue();
    }

    public void setOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop(String aOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop) {
        getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop).setValue(aOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop);
    }

    public Integer getOltMultiGrouptoMultiVlanMapVlanID() {
        return (Integer) getProperty(oltMultiGrouptoMultiVlanMapVlanID).getValue();
    }

    public void setOltMultiGrouptoMultiVlanMapVlanID(Integer aOltMultiGrouptoMultiVlanMapVlanID) {
        getProperty(oltMultiGrouptoMultiVlanMapVlanID).setValue(aOltMultiGrouptoMultiVlanMapVlanID);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart));
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop));
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapVlanID));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart));
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop));
        prepareRead(getProperty(oltMultiGrouptoMultiVlanMapVlanID));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart));
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop));
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapVlanID));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart));
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop));
        prepareSave(getProperty(oltMultiGrouptoMultiVlanMapVlanID));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}