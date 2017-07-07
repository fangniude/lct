package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The ModEoCVLANTable class.
 * Created by QuickDVM
 */
public class ModEoCVLANTable extends EocBaseSnmpMibBean {
    public static final String modEoCVLANIndex = "modEoCVLANIndex";
    public static final String modEoCVLANName = "modEoCVLANName";
    public static final String modEoCVLANFlag = "modEoCVLANFlag";


    public ModEoCVLANTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(modEoCVLANIndex, new SnmpMibBeanProperty(modEoCVLANIndex, MIB_Head1 + ".9.7.1.1", ISnmpConstant.INTEGER));
        initProperty(modEoCVLANName, new SnmpMibBeanProperty(modEoCVLANName, MIB_Head1 + ".9.7.1.2", ISnmpConstant.STRING));
        initProperty(modEoCVLANFlag, new SnmpMibBeanProperty(modEoCVLANFlag, MIB_Head1 + ".9.7.1.3", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, MIB_Head1 + ".9.7.1.4", ISnmpConstant.INTEGER));

    }


    public Integer getModEoCVLANIndex() {
        return (Integer) getIndex(0);
    }

    public void setModEoCVLANIndex(Integer aModEoCVLANIndex) {
        setIndex(0, aModEoCVLANIndex);
    }


    public String getModEoCVLANName() {
        return (String) getProperty(modEoCVLANName).getValue();
    }

    public void setModEoCVLANName(String aModEoCVLANName) {
        getProperty(modEoCVLANName).setValue(aModEoCVLANName);
    }

    public Integer getModEoCVLANFlag() {
        return (Integer) getProperty(modEoCVLANFlag).getValue();
    }

    public void setModEoCVLANFlag(Integer aModEoCVLANFlag) {
        getProperty(modEoCVLANFlag).setValue(aModEoCVLANFlag);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(modEoCVLANName));
        prepareRead(super.getProperty(modEoCVLANFlag));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(modEoCVLANName));
        prepareRead(super.getProperty(modEoCVLANFlag));


        return loadAll(new int[]{1
        });
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(modEoCVLANName));
        prepareSave(getProperty(modEoCVLANFlag));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(modEoCVLANName));
        prepareSave(getProperty(modEoCVLANFlag));

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
    
