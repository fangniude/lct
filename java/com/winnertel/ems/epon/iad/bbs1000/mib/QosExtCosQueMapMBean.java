package com.winnertel.ems.epon.iad.bbs1000.mib;


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
 * The QosExtCosQueMapMBean class.
 * Created by QuickDVM
 */
public class QosExtCosQueMapMBean extends SnmpMibBean {
    public static final String utsMLSQosExtCosPriority = "utsMLSQosExtCosPriority";
    public static final String utsMLSQosExtCosQueueNum = "utsMLSQosExtCosQueueNum";

    ISnmpProxy proxy;
    public QosExtCosQueMapMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        proxy = aSnmpProxy;
        init();
    }

    protected void init() {
        initProperty(utsMLSQosExtCosPriority, new SnmpMibBeanProperty(utsMLSQosExtCosPriority, ".1.3.6.1.4.1.45121.1800.2.4.1.1.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsMLSQosExtCosQueueNum, new SnmpMibBeanProperty(utsMLSQosExtCosQueueNum, ".1.3.6.1.4.1.45121.1800.2.4.1.1.1.1.2", ISnmpConstant.INTEGER));

    }


    public Integer getUtsMLSQosExtCosPriority() {
        return (Integer) getIndex(0);
    }

    public void setUtsMLSQosExtCosPriority(Integer aUtsMLSQosExtCosPriority) {
        setIndex(0, aUtsMLSQosExtCosPriority);
    }


    public Integer getUtsMLSQosExtCosQueueNum() {
        return (Integer) getProperty(utsMLSQosExtCosQueueNum).getValue();
    }

    public void setUtsMLSQosExtCosQueueNum(Integer aUtsMLSQosExtCosQueueNum) {
        getProperty(utsMLSQosExtCosQueueNum).setValue(aUtsMLSQosExtCosQueueNum);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsMLSQosExtCosQueueNum));

        return load();
    }
    public Vector retrieveAll() throws MibBeanException
	{
        prepareRead(super.getProperty(utsMLSQosExtCosQueueNum));
		return loadAll(new int[]
		{ 1});
	}

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsMLSQosExtCosQueueNum));

        return save();
    }

    public boolean delete() throws MibBeanException {
        QosExtCosQueMapMBean mbean = new QosExtCosQueMapMBean(proxy);
        for(int i=0;i<8;i++){
            mbean.setUtsMLSQosExtCosPriority(new Integer(i));

            mbean.setUtsMLSQosExtCosQueueNum(new Integer(i/2));
            mbean.prepareSave(mbean.getProperty(utsMLSQosExtCosPriority));
            mbean.prepareSave(mbean.getProperty(utsMLSQosExtCosQueueNum));
            mbean.save();
        }
        return true;
    }

}
