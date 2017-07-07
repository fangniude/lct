package com.winnertel.ems.epon.iad.bbs4000.mib;

/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The MSTPMapTableMBean class.
 * Created by QuickDVM
 */
public class MSTPMapTableMBean extends SnmpMibBean {
    public static final String mstpMapMSTiID = "mstpMapMSTiID";
    public static final String mstpMapVlanRangeIndex = "mstpMapVlanRangeIndex";
    public static final String mstpMapVlanMin = "mstpMapVlanMin";
    public static final String mstpMapVlanMax = "mstpMapVlanMax";


    public MSTPMapTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(mstpMapMSTiID, new SnmpMibBeanProperty(mstpMapMSTiID, ".1.3.6.1.2.1.17.10.12.1.1", ISnmpConstant.INTEGER));
        initProperty(mstpMapVlanRangeIndex, new SnmpMibBeanProperty(mstpMapVlanRangeIndex, ".1.3.6.1.2.1.17.10.12.1.2", ISnmpConstant.INTEGER));
        initProperty(mstpMapVlanMin, new SnmpMibBeanProperty(mstpMapVlanMin, ".1.3.6.1.2.1.17.10.12.1.3", ISnmpConstant.INTEGER));
        initProperty(mstpMapVlanMax, new SnmpMibBeanProperty(mstpMapVlanMax, ".1.3.6.1.2.1.17.10.12.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.2.1.17.10.12.1.9", ISnmpConstant.INTEGER));

    }


    public Integer getMstpMapMSTiID() {
        return new Integer(((Integer) getIndex(0)).intValue()-1);
    }

    public void setMstpMapMSTiID(Integer aMstpMapMSTiID) {
        setIndex(0, new Integer(aMstpMapMSTiID.intValue()+1));
    }


    public Integer getMstpMapVlanRangeIndex() {
        return (Integer) getIndex(1);
    }

    public void setMstpMapVlanRangeIndex(Integer aMstpMapVlanRangeIndex) {
        setIndex(1, aMstpMapVlanRangeIndex);
    }


    public Integer getMstpMapVlanMin() {
        return (Integer) getProperty(mstpMapVlanMin).getValue();
    }

    public void setMstpMapVlanMin(Integer aMstpMapVlanMin) {
        getProperty(mstpMapVlanMin).setValue(aMstpMapVlanMin);
    }

    public Integer getMstpMapVlanMax() {
        return (Integer) getProperty(mstpMapVlanMax).getValue();
    }

    public void setMstpMapVlanMax(Integer aMstpMapVlanMax) {
        getProperty(mstpMapVlanMax).setValue(aMstpMapVlanMax);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(mstpMapVlanMin));
        prepareRead(super.getProperty(mstpMapVlanMax));


        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(mstpMapVlanMin));
        prepareRead(super.getProperty(mstpMapVlanMax));


        return loadAll(new int[]{1, 1});
    }


    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(mstpMapVlanMin));
        prepareSave(getProperty(mstpMapVlanMax));


        return save();
    }


    public boolean add() throws MibBeanException {
        prepareSave(getProperty(mstpMapVlanMin));
        prepareSave(getProperty(mstpMapVlanMax));
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
