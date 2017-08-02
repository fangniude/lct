/*
 * @(#)OnuPingMBean.java
 * Created on 2006-10-19, ����01:38:07
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.net.InetAddress;
import java.util.Vector;

/**
 *
 * @version 1.0.0, 2006-10-19
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class OnuPingMBean extends SnmpMibBean {


	public static final String ifOnuIndex = "ifIndex";

	public static final String utsDot3OnuOAMPingElapsedTime = "utsDot3OnuOAMPingElapsedTime";

	public static final String utsDot3OnuOAMStartTest = "utsDot3OnuOAMStartTest";

	public static final String utsDot3OnuOAMPingStatus = "utsDot3OnuOAMPingStatus";

	public static final String utsDot3OnuOAMPingStationId = "utsDot3OnuOAMPingStationId";

	public static final String utsDot3OnuOAMPingResultStr = "utsDot3OnuOAMPingResultStr";

  private String onuLabel = null;

	public OnuPingMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuOAMPingElapsedTime, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingElapsedTime,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.36",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuOAMStartTest, new SnmpMibBeanProperty(
				utsDot3OnuOAMStartTest,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.38",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuOAMPingStatus, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingStatus,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.42",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuOAMPingStationId, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingStationId,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.43",
				ISnmpConstant.STRING));

		initProperty(utsDot3OnuOAMPingResultStr, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingResultStr,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.44",
				ISnmpConstant.STRING));

	}

	public Integer getIfOnuIndex() {
		return (Integer) getIndex(0);
	}

	public void setIfOnuIndex(Integer aIfOnuIndex) {
		setIndex(0, aIfOnuIndex);
	}

	public Integer getUtsDot3OnuOAMPingElapsedTime() {
		return (Integer) getProperty(utsDot3OnuOAMPingElapsedTime).getValue();
	}

	public void setUtsDot3OnuOAMPingElapsedTime(
			Integer aUtsDot3OnuOAMPingElapsedTime) {
		getProperty(utsDot3OnuOAMPingElapsedTime).setValue(
				aUtsDot3OnuOAMPingElapsedTime);
	}

	public Integer getUtsDot3OnuOAMStartTest() {
		return (Integer) getProperty(utsDot3OnuOAMStartTest).getValue();
	}

	public void setUtsDot3OnuOAMStartTest(Integer aUtsDot3OnuOAMStartTest) {
		getProperty(utsDot3OnuOAMStartTest).setValue(aUtsDot3OnuOAMStartTest);
	}

	public Integer getUtsDot3OnuOAMPingStatus() {
		return (Integer) getProperty(utsDot3OnuOAMPingStatus).getValue();
	}

	public void setUtsDot3OnuOAMPingStatus(Integer aUtsDot3OnuOAMPingStatus) {
		getProperty(utsDot3OnuOAMPingStatus).setValue(aUtsDot3OnuOAMPingStatus);
	}

	public String getUtsDot3OnuOAMPingStationId() {
		return (String) getProperty(utsDot3OnuOAMPingStationId).getValue();
	}

	public void setUtsDot3OnuOAMPingStationId(String aUtsDot3OnuOAMPingStationId) {
		getProperty(utsDot3OnuOAMPingStationId).setValue(
				aUtsDot3OnuOAMPingStationId);
	}

	public String getUtsDot3OnuOAMPingResultStr() {
		return (String) getProperty(utsDot3OnuOAMPingResultStr).getValue();
	}

	public void setUtsDot3OnuOAMPingResultStr(String aUtsDot3OnuOAMPingResultStr) {
		getProperty(utsDot3OnuOAMPingResultStr).setValue(
				aUtsDot3OnuOAMPingResultStr);
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
		prepareRead(super.getProperty(utsDot3OnuOAMPingElapsedTime));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStatus));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStationId));
		prepareRead(super.getProperty(utsDot3OnuOAMPingResultStr));

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
		prepareRead(super.getProperty(utsDot3OnuOAMPingElapsedTime));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStatus));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStationId));
		prepareRead(super.getProperty(utsDot3OnuOAMPingResultStr));

		setRowsToFetch( 128 );
		
		Vector v = loadAll(new int[] { 1 });

//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//        String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//
//        Map map = onuMgmtMgr.getOnuLabelMap(neName);
//
//        for(int i = 0; i < v.size(); i++)
//        {
//          OnuPingMBean bean = (OnuPingMBean)v.get(i);
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

    return v;
	}

    public boolean delete() throws MibBeanException {
		try {
			SnmpMibBeanProperty utsDot3OnuOAMPingStationIdProp = getProperty(utsDot3OnuOAMPingStationId);
			String emsServerIp = InetAddress.getLocalHost().getHostAddress();
			utsDot3OnuOAMPingStationIdProp.setValue(emsServerIp);
			prepareSave( utsDot3OnuOAMPingStationIdProp );

			SnmpMibBeanProperty utsDot3OnuOAMStartTestProp = getProperty(utsDot3OnuOAMStartTest);
			utsDot3OnuOAMStartTestProp.setValue( new Integer("3") );
			prepareSave(utsDot3OnuOAMStartTestProp);
		} catch ( Exception ex ) {
	        ex.printStackTrace();
		}

		return save();
    }

    public class ElapsedTimeFormatter extends SnmpFieldFormatter {
        public ElapsedTimeFormatter(IApplication anApplication) {
            super(anApplication);
        } // TimeTicksFormatter

        public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
            Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (value == null)
                return null;

            StringBuffer timeStr = new StringBuffer();
            timeStr.append( "Good morning!" );

            return timeStr.toString();
        }
    } // ElapsedTimeFormatter
}
