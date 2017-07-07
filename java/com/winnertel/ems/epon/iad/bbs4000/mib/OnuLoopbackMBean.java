/*
 * @(#)OnuLoopbackMBean.java
 * Created on 2006-10-20, ����02:33:14
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The OnuLoopbackMBean class.
 * Created by QuickDVM
 */
public class OnuLoopbackMBean extends SnmpMibBean {
	public static final String ifOnuIndex = "ifIndex";

	public static final String utsDot3OnuRegistrationState = "utsDot3OnuRegistrationState";

	public static final String utsDot3OnuPonLoopbackTestStatus = "utsDot3OnuPonLoopbackTestStatus";

	public static final String utsDot3OnuPonLoopbackTestVlanId = "utsDot3OnuPonLoopbackTestVlanId";

  private String onuLabel;

	public OnuLoopbackMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuRegistrationState, new SnmpMibBeanProperty(
				utsDot3OnuRegistrationState,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.4",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuPonLoopbackTestStatus, new SnmpMibBeanProperty(
				utsDot3OnuPonLoopbackTestStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.17",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPonLoopbackTestVlanId, new SnmpMibBeanProperty(
				utsDot3OnuPonLoopbackTestVlanId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.18",
				ISnmpConstant.INTEGER));
	}

	public Integer getIfOnuIndex() {
		return (Integer) getIndex(0);
	}

	public void setIfOnuIndex(Integer aIfOnuIndex) {
		setIndex(0, aIfOnuIndex);
	}

	public Integer getUtsDot3OnuRegistrationState() {
		return (Integer) getProperty(utsDot3OnuRegistrationState).getValue();
	}

	public void setUtsDot3OnuRegistrationState(
			Integer aUtsDot3OnuRegistrationState) {
		getProperty(utsDot3OnuRegistrationState).setValue(
				aUtsDot3OnuRegistrationState);
	}

	public Integer getUtsDot3OnuPonLoopbackTestStatus() {
		return (Integer) getProperty(utsDot3OnuPonLoopbackTestStatus)
				.getValue();
	}

	public void setUtsDot3OnuPonLoopbackTestStatus(
			Integer aUtsDot3OnuPonLoopbackTestStatus) {
		getProperty(utsDot3OnuPonLoopbackTestStatus).setValue(
				aUtsDot3OnuPonLoopbackTestStatus);
	}

	public Integer getUtsDot3OnuPonLoopbackTestVlanId() {
		return (Integer) getProperty(utsDot3OnuPonLoopbackTestVlanId)
				.getValue();
	}

	public void setUtsDot3OnuPonLoopbackTestVlanId(
			Integer aUtsDot3OnuPonLoopbackTestVlanId) {
		getProperty(utsDot3OnuPonLoopbackTestVlanId).setValue(
				aUtsDot3OnuPonLoopbackTestVlanId);
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
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestStatus));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestVlanId));

    boolean b = load();
//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//        String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//        String ifIndex = ConfigUtility.formatIfIndex("" + getIfOnuIndex());
//
//        setOnuLabel(onuMgmtMgr.getOnuLabel(neName, ifIndex));
//      }
//      catch(Exception e)
//      {
//        e.printStackTrace();
//      }
//    }

    return b;
	}

	public Vector retrieveAll() throws MibBeanException {

		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestStatus));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestVlanId));

    setRowsToFetch(128);
    
		Vector allMOs = loadAll(new int[] { 1 });
		Vector registeredOnus = new Vector();

		for ( int i = 0; i < allMOs.size(); i++ ) {
			OnuLoopbackMBean tmpLoopbackMBean = (OnuLoopbackMBean)allMOs.get(i);
			Integer tmpRegState = tmpLoopbackMBean.getUtsDot3OnuRegistrationState();
			// filter only registered ones
			if ( tmpRegState.intValue() == 3 ){
				registeredOnus.add( tmpLoopbackMBean );
			}
		}

//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//        String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//
//        Map map = onuMgmtMgr.getOnuLabelMap(neName);
//
//        for(int i = 0; i < registeredOnus.size(); i++)
//        {
//          OnuLoopbackMBean bean = (OnuLoopbackMBean)registeredOnus.get(i);
//
//          String key = neName + ConfigUtility.formatIfIndex("" + bean.getIfOnuIndex());
//          if(map.get(key) != null)
//          {
//            bean.setOnuLabel((String)map.get(key));
//          }
//        }
//      }
//      catch(Exception e)
//      {
//        e.printStackTrace();
//      }
//    }

		return registeredOnus;
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OnuPonLoopbackTestStatus));
		prepareSave(getProperty(utsDot3OnuPonLoopbackTestVlanId));

		return save();
	}

}
