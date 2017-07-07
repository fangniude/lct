/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3OnuClassifiImportTable class.
 * Created by QuickDVM
 */
public class Dot3OnuClassifiImportTable extends SnmpMibBean {
  public static final String utsDot3OnuClassifiImportClassId = "utsDot3OnuClassifiImportClassId";
  public static final String utsDot3OnuClassifiImportFileName = "utsDot3OnuClassifiImportFileName";


  public Dot3OnuClassifiImportTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsDot3OnuClassifiImportClassId, new SnmpMibBeanProperty(utsDot3OnuClassifiImportClassId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.21.1.1", ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuClassifiImportFileName, new SnmpMibBeanProperty(utsDot3OnuClassifiImportFileName, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.21.1.2", ISnmpConstant.STRING));
    initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.21.1.3", ISnmpConstant.INTEGER));

  }


  public Integer getUtsDot3OnuClassifiImportClassId() {
    return (Integer) getIndex(0);
  }

  public void setUtsDot3OnuClassifiImportClassId(Integer aUtsDot3OnuClassifiImportClassId) {
    setIndex(0, aUtsDot3OnuClassifiImportClassId);
  }


  public String getUtsDot3OnuClassifiImportFileName() {
    return (String) getProperty(utsDot3OnuClassifiImportFileName).getValue();
  }

  public void setUtsDot3OnuClassifiImportFileName(String aUtsDot3OnuClassifiImportFileName) {
    getProperty(utsDot3OnuClassifiImportFileName).setValue(aUtsDot3OnuClassifiImportFileName);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiImportFileName));


    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsDot3OnuClassifiImportFileName));


    return loadAll(new int[]{1
    });
  }


  public boolean add() throws MibBeanException {
    super.setRowStatus(new Integer(4));
    prepareSave(getProperty(utsDot3OnuClassifiImportClassId));
    prepareSave(getProperty(utsDot3OnuClassifiImportFileName));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }


  public boolean delete() throws MibBeanException {
    super.setRowStatus(new Integer(6));
    prepareSave(getProperty(ROW_STATUS));
    return save();
  }

}
