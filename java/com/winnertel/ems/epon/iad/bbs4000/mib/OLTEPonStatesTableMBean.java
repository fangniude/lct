package com.winnertel.ems.epon.iad.bbs4000.mib;


/*
    * Copyright (c) 2002-2005 UTStarcom, Inc.
    * All rights reserved.
    */

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The ONUEPonStatesTableMBean class.
 * Created by QuickDVM
 */
public class OLTEPonStatesTableMBean extends SnmpMibBean {
    public static final String utsPonIfExtIndex = "utsPonIfExtIndex";
    public static final String utsPonIfExtStatsFrameSysTxOk = "utsPonIfExtStatsFrameSysTxOk";
    public static final String utsPonIfExtStatsFrameSysRxOk = "utsPonIfExtStatsFrameSysRxOk";
    public static final String utsPonIfExtStatsFrameSysRxErr = "utsPonIfExtStatsFrameSysRxErr";
    public static final String utsPerfStaClearAll = "utsPerfStaClearAll";

    ISnmpProxy Proxy;

    public OLTEPonStatesTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        Proxy = aSnmpProxy;
        init();
    }

    protected void init() {
        initProperty(utsPonIfExtIndex, new SnmpMibBeanProperty(utsPonIfExtIndex, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsPonIfExtStatsFrameSysTxOk, new SnmpMibBeanProperty(utsPonIfExtStatsFrameSysTxOk, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.83", ISnmpConstant.COUNTER64));
        initProperty(utsPonIfExtStatsFrameSysRxOk, new SnmpMibBeanProperty(utsPonIfExtStatsFrameSysRxOk, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.84", ISnmpConstant.COUNTER64));
        initProperty(utsPonIfExtStatsFrameSysRxErr, new SnmpMibBeanProperty(utsPonIfExtStatsFrameSysRxErr, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.85", ISnmpConstant.COUNTER64));
        initProperty(utsPerfStaClearAll, new SnmpMibBeanProperty(utsPerfStaClearAll, ".1.3.6.1.4.1.45121.1800.4.4.1.1", ISnmpConstant.INTEGER));

    }


    public Integer getUtsPonIfExtIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsPonIfExtIndex(Integer aUtsPonIfExtIndex) {
        setIndex(0, aUtsPonIfExtIndex);
    }
    public BigInteger getUtsPonIfExtStatsFrameSysTxOk() {
        return (BigInteger) getProperty(utsPonIfExtStatsFrameSysTxOk).getValue();
    }

    public void setUtsPonIfExtStatsFrameSysTxOk(BigInteger aUtsPonIfExtStatsFrameSysTxOk) {
        getProperty(utsPonIfExtStatsFrameSysTxOk).setValue(aUtsPonIfExtStatsFrameSysTxOk);
    }

    public BigInteger getUtsPonIfExtStatsFrameSysRxOk() {
        return (BigInteger) getProperty(utsPonIfExtStatsFrameSysRxOk).getValue();
    }

    public void setUtsPonIfExtStatsFrameSysRxOk(BigInteger aUtsPonIfExtStatsFrameSysRxOk) {
        getProperty(utsPonIfExtStatsFrameSysRxOk).setValue(aUtsPonIfExtStatsFrameSysRxOk);
    }

    public BigInteger getUtsPonIfExtStatsFrameSysRxErr() {
        return (BigInteger) getProperty(utsPonIfExtStatsFrameSysRxErr).getValue();
    }

    public void setUtsPonIfExtStatsFrameSysRxErr(BigInteger aUtsPonIfExtStatsFrameSysRxErr) {
        getProperty(utsPonIfExtStatsFrameSysRxErr).setValue(aUtsPonIfExtStatsFrameSysRxErr);
    }
    public void setUtsPerfStaClearAll(Integer aUtsPerfStaClearAll) {
        getProperty(utsPerfStaClearAll).setValue(aUtsPerfStaClearAll);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysTxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysRxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysRxErr));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
      if(getUtsPonIfExtIndex() != null)
      {
        int ifIndex = getUtsPonIfExtIndex().intValue();
        ifIndex += 29664;
        Vector v = new Vector(4);
        for(int i = 0; i < 4; i++)
        {
          Integer index = new Integer(ifIndex);
          OLTEPonStatesTableMBean bean = new OLTEPonStatesTableMBean(fSnmpProxy);
          bean.setUtsPonIfExtIndex(index);
          bean.retrieve();
          ifIndex += 1024;

          v.add(bean);
        }

        return v;
      }
      else
      {
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysTxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysRxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFrameSysRxErr));

        this.setRowsToFetch(132);

        Vector v = loadAll(new int[]{1});
        Vector resultv = new Vector();

        if(v!=null){
            for(int i=0;i<v.size();i++){
                OLTEPonStatesTableMBean one = (OLTEPonStatesTableMBean)v.get(i);
                Integer index = one.getUtsPonIfExtIndex();
                String strindex = ConfigUtility.formatIfIndex(index.toString());
                if(strindex.split("/").length<3)
                    resultv.add(one);
            }
        }

        return resultv;
      }
    }

    public boolean delete()throws MibBeanException{
        OLTEPonStatesTableMBean mbean = new OLTEPonStatesTableMBean(Proxy);
        mbean.retrieveAll();
        mbean.setUtsPerfStaClearAll(new Integer(4));
        mbean.prepareSave(mbean.getProperty(utsPerfStaClearAll));
        mbean.save();
        return true;
    }


}
