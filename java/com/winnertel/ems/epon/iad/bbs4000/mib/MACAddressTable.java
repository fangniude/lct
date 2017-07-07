package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The MACAddressTable class. Created by QuickDVM
 */
public class MACAddressTable extends SnmpMibBean
{
	public static final String utsLagExtLinkAggMacInterface = "utsLagExtLinkAggMacInterface";

	public static final String utsLagExtLinkAggMacModule = "utsLagExtLinkAggMacModule";

	public static final String utsLagExtLinkAggMacPort = "utsLagExtLinkAggMacPort";

	public static final String utsLagExtLinkAggMacVlanId = "utsLagExtLinkAggMacVlanId";

	public static final String utsLagExtLinkAggMacIsStatic = "utsLagExtLinkAggMacIsStatic";

	public static final String utsLagExtLinkAggMacIntfType = "utsLagExtLinkAggMacIntfType";

	public static final String utsLagExtLinkAggMacTrunkId = "utsLagExtLinkAggMacTrunkId";

	public static final String utsLagExtLinkAggMacAddress = "utsLagExtLinkAggMacAddress";

	public MACAddressTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsLagExtLinkAggMacInterface, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacInterface,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.1", ISnmpConstant.STRING));
		initProperty(utsLagExtLinkAggMacModule, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacModule,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.2", ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacPort, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacPort, ".1.3.6.1.4.1.41355.1800.2.2.1.3.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacVlanId, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacVlanId,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.4", ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacIsStatic, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacIsStatic,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.5", ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacIntfType, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacIntfType,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.6", ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacTrunkId, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacTrunkId,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.7", ISnmpConstant.INTEGER));
		initProperty(utsLagExtLinkAggMacAddress, new SnmpMibBeanProperty(
				utsLagExtLinkAggMacAddress,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.8", ISnmpConstant.MAC_ADDRESS));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.2.1.3.1.9", ISnmpConstant.INTEGER));

	}

	public Integer getUtsLagExtLinkAggMacVlanId()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsLagExtLinkAggMacVlanId(Integer aUtsLagExtLinkAggMacVlanId)
	{
		setIndex(1, aUtsLagExtLinkAggMacVlanId);
	}

	public byte[] getUtsLagExtLinkAggMacAddress()
	{
		return (byte[]) getIndex(0);
	}

	public void setUtsLagExtLinkAggMacAddress(byte[] aUtsLagExtLinkAggMacAddress)
	{
		setIndex(0, aUtsLagExtLinkAggMacAddress);
	}

	public String getUtsLagExtLinkAggMacInterface()
	{
		return (String) getProperty(utsLagExtLinkAggMacInterface).getValue();
	}

  public void setUtsLagExtLinkAggMacIfIndex(String aUtsLagExtLinkAggMacIfIndex)
  {
    getProperty("utsLagExtLinkAggMacIfIndex").setValue(aUtsLagExtLinkAggMacIfIndex);
  }

  public String getUtsLagExtLinkAggMacIfIndex() {
    if(getUtsLagExtLinkAggMacTrunkId() != null && getUtsLagExtLinkAggMacTrunkId().intValue() != 0)
    {
      return "lg" + getUtsLagExtLinkAggMacTrunkId();
    }
    else if(getUtsLagExtLinkAggMacModule().intValue() != 0)
    {
      return getUtsLagExtLinkAggMacModule() + "/" + getUtsLagExtLinkAggMacPort();
    }
    else
    {
      return "CPU";
    }
  }
	public void setUtsLagExtLinkAggMacInterface(
			String aUtsLagExtLinkAggMacInterface)
	{
		getProperty(utsLagExtLinkAggMacInterface).setValue(
				aUtsLagExtLinkAggMacInterface);
	}

	public Integer getUtsLagExtLinkAggMacModule()
	{
		return (Integer) getProperty(utsLagExtLinkAggMacModule).getValue();
	}

	public void setUtsLagExtLinkAggMacModule(Integer aUtsLagExtLinkAggMacModule)
	{
		getProperty(utsLagExtLinkAggMacModule).setValue(
				aUtsLagExtLinkAggMacModule);
	}

	public Integer getUtsLagExtLinkAggMacPort()
	{
		return (Integer) getProperty(utsLagExtLinkAggMacPort).getValue();
	}

	public void setUtsLagExtLinkAggMacPort(Integer aUtsLagExtLinkAggMacPort)
	{
		getProperty(utsLagExtLinkAggMacPort).setValue(aUtsLagExtLinkAggMacPort);
	}

	public Integer getUtsLagExtLinkAggMacIsStatic()
	{
		return (Integer) getProperty(utsLagExtLinkAggMacIsStatic).getValue();
	}

	public void setUtsLagExtLinkAggMacIsStatic(
			Integer aUtsLagExtLinkAggMacIsStatic)
	{
		getProperty(utsLagExtLinkAggMacIsStatic).setValue(
				aUtsLagExtLinkAggMacIsStatic);
	}

	public Integer getUtsLagExtLinkAggMacIntfType()
	{
		return (Integer) getProperty(utsLagExtLinkAggMacIntfType).getValue();
	}

	public void setUtsLagExtLinkAggMacIntfType(
			Integer aUtsLagExtLinkAggMacIntfType)
	{
		getProperty(utsLagExtLinkAggMacIntfType).setValue(
				aUtsLagExtLinkAggMacIntfType);
	}

	public Integer getUtsLagExtLinkAggMacTrunkId()
	{
		return (Integer) getProperty(utsLagExtLinkAggMacTrunkId).getValue();
	}

	public void setUtsLagExtLinkAggMacTrunkId(
			Integer aUtsLagExtLinkAggMacTrunkId)
	{
		getProperty(utsLagExtLinkAggMacTrunkId).setValue(
				aUtsLagExtLinkAggMacTrunkId);
	}
	
	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsLagExtLinkAggMacInterface));
		prepareRead(super.getProperty(utsLagExtLinkAggMacModule));
		prepareRead(super.getProperty(utsLagExtLinkAggMacPort));
		prepareRead(super.getProperty(utsLagExtLinkAggMacIsStatic));
		prepareRead(super.getProperty(utsLagExtLinkAggMacIntfType));
		prepareRead(super.getProperty(utsLagExtLinkAggMacTrunkId));
		prepareRead(super.getProperty(utsLagExtLinkAggMacAddress));
		prepareRead(super.getProperty(utsLagExtLinkAggMacVlanId));
		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsLagExtLinkAggMacInterface));
		prepareRead(super.getProperty(utsLagExtLinkAggMacModule));
		prepareRead(super.getProperty(utsLagExtLinkAggMacPort));
		prepareRead(super.getProperty(utsLagExtLinkAggMacIsStatic));
		prepareRead(super.getProperty(utsLagExtLinkAggMacIntfType));
		prepareRead(super.getProperty(utsLagExtLinkAggMacTrunkId));
		prepareRead(super.getProperty(utsLagExtLinkAggMacAddress));
		prepareRead(super.getProperty(utsLagExtLinkAggMacVlanId));
		return loadAll(new int[]
		{ 1, 6 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsLagExtLinkAggMacModule));
		prepareSave(getProperty(utsLagExtLinkAggMacPort));
		prepareSave(getProperty(utsLagExtLinkAggMacVlanId));
		prepareSave(getProperty(utsLagExtLinkAggMacIsStatic));
		prepareSave(getProperty(utsLagExtLinkAggMacIntfType));
		prepareSave(getProperty(utsLagExtLinkAggMacTrunkId));
		prepareSave(getProperty(utsLagExtLinkAggMacAddress));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		prepareSave(getProperty(utsLagExtLinkAggMacModule));
		prepareSave(getProperty(utsLagExtLinkAggMacPort));
		prepareSave(getProperty(utsLagExtLinkAggMacVlanId));
		prepareSave(getProperty(utsLagExtLinkAggMacIsStatic));
		prepareSave(getProperty(utsLagExtLinkAggMacIntfType));
		prepareSave(getProperty(utsLagExtLinkAggMacTrunkId));
		prepareSave(getProperty(utsLagExtLinkAggMacAddress));
		
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public String toString() {
		byte[] linkAggMacAddrB = getUtsLagExtLinkAggMacAddress();
		StringBuffer linkAggMacAddrStrBuf = new StringBuffer();
		for ( int i = 0; i < linkAggMacAddrB.length; i++ ) {
			String tmpMacAddr = Integer.toHexString( linkAggMacAddrB[i] ).toUpperCase();
			linkAggMacAddrStrBuf.append( tmpMacAddr.length() == 1 ? "0" + tmpMacAddr : tmpMacAddr.substring( tmpMacAddr.length() - 2 ) ).append(":");
		}

		String linkAggMacAddr = linkAggMacAddrStrBuf.substring(0, linkAggMacAddrStrBuf.length() - 1);
		return getUtsLagExtLinkAggMacModule() + "/" + getUtsLagExtLinkAggMacPort() + " vlan" + getUtsLagExtLinkAggMacVlanId() + " MAC:" + linkAggMacAddr;
	}
}
