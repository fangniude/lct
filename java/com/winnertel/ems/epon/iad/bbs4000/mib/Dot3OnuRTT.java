package com.winnertel.ems.epon.iad.bbs4000.mib;


import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3OnuTable class. Created by QuickDVM
 */
public class Dot3OnuRTT extends SnmpMibBean
{
	public static final String ifOnuIndex = "ifOnuIndex";

	public static final String utsDot3OnuRegistrationState = "utsDot3OnuRegistrationState";
	public static final String utsDot3OnuRTT = "utsDot3OnuRTT";
	public static final String distance = "distance";

  private String onuLabel = null;

	public Dot3OnuRTT(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuRegistrationState,
				new SnmpMibBeanProperty(utsDot3OnuRegistrationState,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRTT,
				new SnmpMibBeanProperty(utsDot3OnuRTT,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty( distance, new SnmpMibBeanProperty( distance,
						".1.3.6.1.4.1.41355.1800.2.3.1.3.1.1.1.37",
						ISnmpConstant.INTEGER));
	}

	public Integer getIfOnuIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfOnuIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsDot3OnuRegistrationState() {
		return (Integer) getProperty(utsDot3OnuRegistrationState).getValue();
	}

	public void setUtsDot3OnuRegistrationState( Integer aUtsDot3OnuRegistrationState) {
		getProperty(utsDot3OnuRegistrationState).setValue(aUtsDot3OnuRegistrationState);
	}

	public Integer getUtsDot3OnuRTT()
	{
		return (Integer) getProperty(utsDot3OnuRTT).getValue();
	}

	public void setUtsDot3OnuRTT(Integer aUtsDot3OnuRTT)
	{
		getProperty(utsDot3OnuRTT).setValue(aUtsDot3OnuRTT);
	}

	public Integer getDistance()
	{
		return (Integer) getProperty(distance).getValue();
	}

	public void setDistance( Integer udistance )
	{
		getProperty( distance ).setValue(udistance);
	}

  public String getOnuLabel()
  {
    return onuLabel;
  }

  public void setOnuLabel(String s)
  {
    onuLabel = s;
  }

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		prepareRead(super.getProperty(utsDot3OnuRTT));

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

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		prepareRead(super.getProperty(utsDot3OnuRTT));
//		prepareRead(super.getProperty(distance));
		setRowsToFetch(128);
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
//          Dot3OnuRTT bean = (Dot3OnuRTT)v.get(i);
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
}
