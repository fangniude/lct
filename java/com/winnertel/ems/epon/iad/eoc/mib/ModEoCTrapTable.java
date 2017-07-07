package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCTrapTable class.
 * Created by QuickDVM
 */
public class ModEoCTrapTable extends SnmpMibBean {
    public static final String modEoCTrapIndex = "modEoCTrapIndex";
    public static final String modEoCTrapIP = "modEoCTrapIP";
    public static final String modEoCTrapCommunity = "modEoCTrapCommunity";
//    public static final String modEoCTrapStatus = "modEoCTrapStatus";


    public ModEoCTrapTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCTrapIndex, new SnmpMibBeanProperty(modEoCTrapIndex, ".1.3.6.1.4.1.17409.2.4.8.5.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCTrapIP, new SnmpMibBeanProperty(modEoCTrapIP, ".1.3.6.1.4.1.17409.2.4.8.5.1.2", ISnmpConstant.IP_ADDRESS));
        initProperty(modEoCTrapCommunity, new SnmpMibBeanProperty(modEoCTrapCommunity, ".1.3.6.1.4.1.17409.2.4.8.5.1.3", ISnmpConstant.STRING));
//        initProperty(modEoCTrapStatus, new SnmpMibBeanProperty(modEoCTrapStatus, ".1.3.6.1.4.1.17409.2.4.8.5.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.4.8.5.1.5", ISnmpConstant.INTEGER));


    }


    public Integer getModEoCTrapIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCTrapIndex(Integer aModEoCTrapIndex) {
        setIndex(0, aModEoCTrapIndex);
    }


    public String getModEoCTrapIP() {
        return (String) getProperty(modEoCTrapIP).getValue();
    }

    public void setModEoCTrapIP(String aModEoCTrapIP) {
        getProperty(modEoCTrapIP).setValue(aModEoCTrapIP);
    }

    public String getModEoCTrapCommunity() {
        return (String) getProperty(modEoCTrapCommunity).getValue();
    }

    public void setModEoCTrapCommunity(String aModEoCTrapCommunity) {
        getProperty(modEoCTrapCommunity).setValue(aModEoCTrapCommunity);
    }

//    public Integer getModEoCTrapStatus() {
//        return (Integer) getProperty(modEoCTrapStatus).getValue();
//    }
//
//    public void setModEoCTrapStatus(Integer aModEoCTrapStatus) {
//        getProperty(modEoCTrapStatus).setValue(aModEoCTrapStatus);
//    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCTrapIP));
        prepareRead(super.getProperty(modEoCTrapCommunity));
//        prepareRead(super.getProperty(modEoCTrapStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCTrapIP));
        prepareRead(super.getProperty(modEoCTrapCommunity));
//        prepareRead(super.getProperty(modEoCTrapStatus));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCTrapIP));
        prepareSave(getProperty(modEoCTrapCommunity));
//        prepareSave(getProperty(modEoCTrapStatus));

        super.setRowStatus(new Integer(1));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }


    public boolean add() throws MibBeanException {

        prepareSave(getProperty(modEoCTrapIP));
        prepareSave(getProperty(modEoCTrapCommunity));
//        prepareSave(getProperty(modEoCTrapStatus));

        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }


    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

}
