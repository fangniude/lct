package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3DbaSlaTable class. Created by QuickDVM
 */
public class Dot3boundOnuTable extends SnmpMibBean
{
	public static final String ifOnuIndex = "ifOnuIndex";

	public static final String utsDot3DbaSlaModuleId = "utsDot3DbaSlaModuleId";

	public static final String utsDot3DbaSlaPortId = "utsDot3DbaSlaPortId";

	public static final String utsDot3DbaSlaLogicalPortId = "utsDot3DbaSlaLogicalPortId";

	public static final String utsDot3DbaSlaBindingMacAddress = "utsDot3DbaSlaBindingMacAddress";

  private String onuLabel;

	public Dot3boundOnuTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaSlaModuleId,
				new SnmpMibBeanProperty(utsDot3DbaSlaModuleId,
						".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaSlaPortId, new SnmpMibBeanProperty(
				utsDot3DbaSlaPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaSlaLogicalPortId,
				new SnmpMibBeanProperty(utsDot3DbaSlaLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3DbaSlaBindingMacAddress,
				new SnmpMibBeanProperty(utsDot3DbaSlaBindingMacAddress,
						".1.3.6.1.4.1.45121.1800.2.3.1.4.2.1.1.25",
						ISnmpConstant.MAC_ADDRESS));
	}

	public Integer getIfOnuIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfOnuIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsDot3DbaSlaModuleId()
	{
		return (Integer) getProperty(utsDot3DbaSlaModuleId).getValue();
	}

	public void setUtsDot3DbaSlaModuleId(Integer aUtsDot3DbaSlaModuleId)
	{
		getProperty(utsDot3DbaSlaModuleId).setValue(aUtsDot3DbaSlaModuleId);
	}

	public Integer getUtsDot3DbaSlaPortId()
	{
		return (Integer) getProperty(utsDot3DbaSlaPortId).getValue();
	}

	public void setUtsDot3DbaSlaPortId(Integer aUtsDot3DbaSlaPortId)
	{
		getProperty(utsDot3DbaSlaPortId).setValue(aUtsDot3DbaSlaPortId);
	}

	public Integer getUtsDot3DbaSlaLogicalPortId()
	{
		return (Integer) getProperty(utsDot3DbaSlaLogicalPortId).getValue();
	}

	public void setUtsDot3DbaSlaLogicalPortId(
			Integer aUtsDot3DbaSlaLogicalPortId)
	{
		getProperty(utsDot3DbaSlaLogicalPortId).setValue(
				aUtsDot3DbaSlaLogicalPortId);
	}

	public byte[] getUtsDot3DbaSlaBindingMacAddress()
	{
		return (byte[]) getProperty(utsDot3DbaSlaBindingMacAddress).getValue();
	}

	public void setUtsDot3DbaSlaBindingMacAddress(
			byte[] aUtsDot3DbaSlaBindingMacAddress)
	{
		getProperty(utsDot3DbaSlaBindingMacAddress).setValue(
				aUtsDot3DbaSlaBindingMacAddress);
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
		prepareRead(super.getProperty(utsDot3DbaSlaModuleId));
		prepareRead(super.getProperty(utsDot3DbaSlaPortId));
		prepareRead(super.getProperty(utsDot3DbaSlaLogicalPortId));
		prepareRead(super.getProperty(utsDot3DbaSlaBindingMacAddress));

    boolean b = load();

//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//        String mac = ConfigUtility.OctetToMacAddress(getUtsDot3DbaSlaBindingMacAddress());
//
//        setOnuLabel(onuMgmtMgr.getOnuLabel(mac));
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
		prepareRead(super.getProperty(utsDot3DbaSlaModuleId));
		prepareRead(super.getProperty(utsDot3DbaSlaPortId));
		prepareRead(super.getProperty(utsDot3DbaSlaLogicalPortId));
		prepareRead(super.getProperty(utsDot3DbaSlaBindingMacAddress));

    setRowsToFetch(128);
		Vector allv =  loadAll(new int[]{ 1 });
        Vector returnv = new Vector();
        if(allv!=null){
            for(int i=0;i<allv.size();i++){
                Dot3boundOnuTable one = (Dot3boundOnuTable)allv.get(i);
                String mac = new String(one.getUtsDot3DbaSlaBindingMacAddress());
                if(!mac.equals("\u0000\u0000\u0000\u0000\u0000\u0000"))
                    returnv.add(one);
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
//        for(int i = 0; i < returnv.size(); i++)
//        {
//          Dot3boundOnuTable bean = (Dot3boundOnuTable)returnv.get(i);
//
//          String key = neName + bean.getUtsDot3DbaSlaModuleId() + "/" + bean.getUtsDot3DbaSlaPortId() + "/" + bean.getUtsDot3DbaSlaLogicalPortId();
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

    return returnv;
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot3DbaSlaBindingMacAddress));

		return save();
	}

    public boolean delete() throws MibBeanException {
        String mac = "\u0000\u0000\u0000\u0000\u0000\u0000";
        setUtsDot3DbaSlaBindingMacAddress(mac.getBytes());
        prepareSave(getProperty(utsDot3DbaSlaBindingMacAddress));
        boolean b = save();

//        if(!DebugMode.isDebug() && b)
//        {
//          try
//          {
//            UnboundOnuMgmtMgr onuMgmtMgr = (UnboundOnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "UnboundOnuMgmtMgr");
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//
//
//            UnboundOnuMOD onu = new UnboundOnuMOD();
//            onu.setCardId("" + getUtsDot3DbaSlaModuleId());
//            onu.setPortId("" + getUtsDot3DbaSlaPortId());
//            onu.setLlId("" + getUtsDot3DbaSlaLogicalPortId());
//            onu.setNeName(neName);
//
//            onuMgmtMgr.addUnbindOnu(onu);
//          }
//          catch(Exception e)
//          {
//            e.printStackTrace();
//          }
//        }

      return b;
    }
}
