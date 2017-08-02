package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;

import java.util.Vector;

/**
 * The Dot3UnboundOnuTable class. Created by QuickDVM
 */
public class Dot3UnboundOnuTable extends SnmpMibBean
{
	public static final String utsDot3UnboundOnuModuleId = "utsDot3UnboundOnuModuleId";

	public static final String utsDot3UnboundOnuPortId = "utsDot3UnboundOnuPortId";

	public static final String utsDot3UnboundOnuLlid = "utsDot3UnboundOnuLlid";

	public static final String utsDot3UnboundOnuPonMacAddr = "utsDot3UnboundOnuPonMacAddr";

  private String onuLabel = null;

	public Dot3UnboundOnuTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsDot3UnboundOnuModuleId,
				new SnmpMibBeanProperty(utsDot3UnboundOnuModuleId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3UnboundOnuPortId,
				new SnmpMibBeanProperty(utsDot3UnboundOnuPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3UnboundOnuLlid,
				new SnmpMibBeanProperty(utsDot3UnboundOnuLlid,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3UnboundOnuPonMacAddr, new SnmpMibBeanProperty(
				utsDot3UnboundOnuPonMacAddr,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.4", ISnmpConstant.MAC_ADDRESS));

	}

	public Integer getUtsDot3UnboundOnuModuleId()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsDot3UnboundOnuModuleId(Integer aUtsDot3UnboundOnuModuleId)
	{
		setIndex(0, aUtsDot3UnboundOnuModuleId);
	}

	public Integer getUtsDot3UnboundOnuPortId()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsDot3UnboundOnuPortId(Integer aUtsDot3UnboundOnuPortId)
	{
		setIndex(1, aUtsDot3UnboundOnuPortId);
	}

	public Integer getUtsDot3UnboundOnuLlid()
	{
        return (Integer) getIndex(2);
	}

	public void setUtsDot3UnboundOnuLlid(Integer aUtsDot3UnboundOnuLlid)
	{
		setIndex(2, aUtsDot3UnboundOnuLlid);
	}

	public byte[] getUtsDot3UnboundOnuPonMacAddr()
	{
		return (byte[]) getProperty(utsDot3UnboundOnuPonMacAddr).getValue();
	}

	public void setUtsDot3UnboundOnuPonMacAddr(byte[] aUtsDot3UnboundOnuPonMacAddr)
	{
		getProperty(utsDot3UnboundOnuPonMacAddr).setValue(aUtsDot3UnboundOnuPonMacAddr);
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
		prepareRead(super.getProperty(utsDot3UnboundOnuPonMacAddr));

    boolean b = load();

//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//        String mac = ConfigUtility.OctetToMacAddress(getUtsDot3UnboundOnuPonMacAddr());
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
		prepareRead(super.getProperty(utsDot3UnboundOnuPonMacAddr));

		Vector v = loadAll(new int[] { 1, 1, 1 });

//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//        for(int i = 0; i < v.size(); i++)
//        {
//          Dot3UnboundOnuTable bean = (Dot3UnboundOnuTable)v.get(i);
//          String mac = ConfigUtility.OctetToMacAddress(bean.getUtsDot3UnboundOnuPonMacAddr());
//
//          bean.setOnuLabel(onuMgmtMgr.getOnuLabel(mac));
//        }
//      }
//      catch(Exception e)
//      {
//        e.printStackTrace();
//      }
//    }

    return v;
	}

    public String toString() {
        if(onuLabel != null) {
            return onuLabel;
        }

        if(getProperty(utsDot3UnboundOnuPonMacAddr) != null) {
            return MacAddressFormatter.format(getUtsDot3UnboundOnuPonMacAddr());
        }

        return "";
    }
}
