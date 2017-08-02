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
public class ONUEPonStatesTableMBean extends SnmpMibBean {
    public static final String utsPonIfExtIndex = "utsPonIfExtIndex";
    public static final String utsPonIfExtStatsFramePonTxOk = "utsPonIfExtStatsFramePonTxOk";
    public static final String utsPonIfExtStatsFramePonRxOk = "utsPonIfExtStatsFramePonRxOk";
    public static final String utsPonIfExtStatsFramePonRxErr = "utsPonIfExtStatsFramePonRxErr";
    public static final String utsPerfStaClearAll = "utsPerfStaClearAll";

    private String onuLabel;

    public ONUEPonStatesTableMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsPonIfExtIndex, new SnmpMibBeanProperty(utsPonIfExtIndex, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsPonIfExtStatsFramePonTxOk, new SnmpMibBeanProperty(utsPonIfExtStatsFramePonTxOk, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.80", ISnmpConstant.COUNTER64));
        initProperty(utsPonIfExtStatsFramePonRxOk, new SnmpMibBeanProperty(utsPonIfExtStatsFramePonRxOk, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.81", ISnmpConstant.COUNTER64));
        initProperty(utsPonIfExtStatsFramePonRxErr, new SnmpMibBeanProperty(utsPonIfExtStatsFramePonRxErr, ".1.3.6.1.4.1.45121.1800.4.2.1.1.1.1.82", ISnmpConstant.COUNTER64));
        initProperty(utsPerfStaClearAll, new SnmpMibBeanProperty(utsPerfStaClearAll, ".1.3.6.1.4.1.45121.1800.4.4.1.1", ISnmpConstant.INTEGER));

    }


    public Integer getUtsPonIfExtIndex() {
        return (Integer) getIndex(0);
    }

    public void setUtsPonIfExtIndex(Integer aUtsPonIfExtIndex) {
        setIndex(0, aUtsPonIfExtIndex);
    }
    public BigInteger getUtsPonIfExtStatsFramePonTxOk() {
        return (BigInteger) getProperty(utsPonIfExtStatsFramePonTxOk).getValue();
    }

    public void setUtsPonIfExtStatsFramePonTxOk(BigInteger aUtsPonIfExtStatsFramePonTxOk) {
        getProperty(utsPonIfExtStatsFramePonTxOk).setValue(aUtsPonIfExtStatsFramePonTxOk);
    }

    public BigInteger getUtsPonIfExtStatsFramePonRxOk() {
        return (BigInteger) getProperty(utsPonIfExtStatsFramePonRxOk).getValue();
    }

    public void setUtsPonIfExtStatsFramePonRxOk(BigInteger aUtsPonIfExtStatsFramePonRxOk) {
        getProperty(utsPonIfExtStatsFramePonRxOk).setValue(aUtsPonIfExtStatsFramePonRxOk);
    }

    public BigInteger getUtsPonIfExtStatsFramePonRxErr() {
        return (BigInteger) getProperty(utsPonIfExtStatsFramePonRxErr).getValue();
    }

    public void setUtsPonIfExtStatsFramePonRxErr(BigInteger aUtsPonIfExtStatsFramePonRxErr) {
        getProperty(utsPonIfExtStatsFramePonRxErr).setValue(aUtsPonIfExtStatsFramePonRxErr);
    }
    public void setUtsPerfStaClearAll(Integer aUtsPerfStaClearAll) {
        getProperty(utsPerfStaClearAll).setValue(aUtsPerfStaClearAll);
    }

    public String getOnuLabel()
    {
      return onuLabel;
    }

    public void setOnuLabel(String s)
    {
      onuLabel = s;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonTxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonRxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonRxErr));

        boolean b = load();
//        if(!DebugMode.isDebug())
//        {
//          try
//          {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//            String ifIndex = com.winnertel.ems.epon.util.ConfigUtility.formatIfIndex("" + getUtsPonIfExtIndex());
//
//            setOnuLabel(onuMgmtMgr.getOnuLabel(neName, ifIndex));
//          }
//          catch(Exception e)
//          {
//            e.printStackTrace();
//          }
//        }

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonTxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonRxOk));
        prepareRead(super.getProperty(utsPonIfExtStatsFramePonRxErr));

        Vector v = loadAll(new int[]{1});
        Vector resultv = new Vector();

        if(v!=null){
            for(int i=0;i<v.size();i++){
                ONUEPonStatesTableMBean one = (ONUEPonStatesTableMBean)v.get(i);
                Integer index = one.getUtsPonIfExtIndex();
                String strindex = ConfigUtility.formatIfIndex(index.toString());
                if(strindex.split("/").length==3)
                    resultv.add(one);
            }
        }

//        if(!DebugMode.isDebug())
//        {
//          try
//          {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//
//            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//
//            for(int i = 0; i < resultv.size(); i++)
//            {
//              ONUEPonStatesTableMBean bean = (ONUEPonStatesTableMBean)resultv.get(i);
//
//              String key = neName + com.winnertel.ems.epon.util.ConfigUtility.formatIfIndex("" + bean.getUtsPonIfExtIndex());
//              if(map.get(key) != null)
//              {
//                bean.setOnuLabel((String)map.get(key));
//              }
//            }
//          }
//          catch(Exception e)
//          {
//            e.printStackTrace();
//          }
//        }

        return resultv;
    }

    public boolean delete()throws MibBeanException{
        ONUEPonStatesTableMBean mbean = new ONUEPonStatesTableMBean(fSnmpProxy);
        mbean.retrieveAll();
        mbean.setUtsPerfStaClearAll(new Integer(5));
        mbean.prepareSave(mbean.getProperty(utsPerfStaClearAll));
        mbean.save();
        return true;
    }


}
