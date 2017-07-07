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
public class Dot3OnuTable extends SnmpMibBean
{
	public static final String ifOnuIndex = "ifOnuIndex";

	public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";

	public static final String utsDot3OnuPortId = "utsDot3OnuPortId";

	public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";

	public static final String utsDot3OnuRegistrationState = "utsDot3OnuRegistrationState";

	public static final String utsDot3OnuHwVersion = "utsDot3OnuHwVersion";

	public static final String utsDot3OnuFwVersion = "utsDot3OnuFwVersion";

	public static final String utsDot3OnuMaxLLID = "utsDot3OnuMaxLLID";

	public static final String utsDot3OnuOAMStandardVersion = "utsDot3OnuOAMStandardVersion";

	public static final String utsDot3OnuRTT = "utsDot3OnuRTT";

	public static final String utsDot3OnuHwType = "utsDot3OnuHwType";

	public static final String utsDot3OnuSwitchHwRev = "utsDot3OnuSwitchHwRev";

	public static final String utsDot3OnuSwitchFwRev = "utsDot3OnuSwitchFwRev";

	public static final String utsDot3OnuIADStatus = "utsDot3OnuIADStatus";

	public static final String utsDot3OnuPonMacAddress = "utsDot3OnuPonMacAddress";

	public static final String utsDot3OnuAES128EncryptionStatus = "utsDot3OnuAES128EncryptionStatus";

	public static final String utsDot3OnuAES128EncryptionKey = "utsDot3OnuAES128EncryptionKey";

	public static final String utsDot3OnuPonLoopbackTestStatus = "utsDot3OnuPonLoopbackTestStatus";

	public static final String utsDot3OnuPonLoopbackTestVlanId = "utsDot3OnuPonLoopbackTestVlanId";

	public static final String utsDot3OnuEthernetLinkStatus = "utsDot3OnuEthernetLinkStatus";

	public static final String utsDot3OnuSwitchMacAddress = "utsDot3OnuSwitchMacAddress";

	public static final String utsDot3OnuAdminStatus = "utsDot3OnuAdminStatus";

	public static final String utsDot3OnuMulticastFilter = "utsDot3OnuMulticastFilter";

	public static final String utsDot3OnuRMAutoNegotiation = "utsDot3OnuRMAutoNegotiation";

	public static final String utsDot3OnuReset = "utsDot3OnuReset";

	public static final String utsDot3OnuQinQ = "utsDot3OnuQinQ";

  private String onuLabel = null;

	public Dot3OnuTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId,
				new SnmpMibBeanProperty(utsDot3OnuLogicalPortId,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRegistrationState,
				new SnmpMibBeanProperty(utsDot3OnuRegistrationState,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwVersion, new SnmpMibBeanProperty(
				utsDot3OnuHwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.5",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuFwVersion, new SnmpMibBeanProperty(
				utsDot3OnuFwVersion, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.6",
				ISnmpConstant.STRING));
		initProperty(utsDot3OnuMaxLLID, new SnmpMibBeanProperty(
				utsDot3OnuMaxLLID, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMStandardVersion,
				new SnmpMibBeanProperty(utsDot3OnuOAMStandardVersion,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRTT,
				new SnmpMibBeanProperty(utsDot3OnuRTT,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuHwType, new SnmpMibBeanProperty(
				utsDot3OnuHwType, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuSwitchHwRev,
				new SnmpMibBeanProperty(utsDot3OnuSwitchHwRev,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.11",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuSwitchFwRev,
				new SnmpMibBeanProperty(utsDot3OnuSwitchFwRev,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.12",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuIADStatus, new SnmpMibBeanProperty(
				utsDot3OnuIADStatus, ".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPonMacAddress,
				new SnmpMibBeanProperty(utsDot3OnuPonMacAddress,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.14",
						ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3OnuAES128EncryptionStatus, new SnmpMibBeanProperty(
				utsDot3OnuAES128EncryptionStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.15",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuAES128EncryptionKey,
				new SnmpMibBeanProperty(utsDot3OnuAES128EncryptionKey,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.16",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuPonLoopbackTestStatus, new SnmpMibBeanProperty(
				utsDot3OnuPonLoopbackTestStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.17",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPonLoopbackTestVlanId, new SnmpMibBeanProperty(
				utsDot3OnuPonLoopbackTestVlanId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.18",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEthernetLinkStatus, new SnmpMibBeanProperty(
				utsDot3OnuEthernetLinkStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuSwitchMacAddress,
				new SnmpMibBeanProperty(utsDot3OnuSwitchMacAddress,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.21",
						ISnmpConstant.MAC_ADDRESS));
		initProperty(utsDot3OnuAdminStatus, new SnmpMibBeanProperty(
				utsDot3OnuAdminStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.24",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuMulticastFilter, new SnmpMibBeanProperty(
				utsDot3OnuMulticastFilter,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.25",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuRMAutoNegotiation, new SnmpMibBeanProperty(
				utsDot3OnuRMAutoNegotiation,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.26",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuReset, new SnmpMibBeanProperty(utsDot3OnuReset,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.27",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuQinQ, new SnmpMibBeanProperty(utsDot3OnuQinQ,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.1.1.28",
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

	public Integer getUtsDot3OnuModuleId()
	{
		return (Integer) getProperty(utsDot3OnuModuleId).getValue();
	}

	public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId)
	{
		getProperty(utsDot3OnuModuleId).setValue(aUtsDot3OnuModuleId);
	}

	public Integer getUtsDot3OnuPortId()
	{
		return (Integer) getProperty(utsDot3OnuPortId).getValue();
	}

	public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId)
	{
		getProperty(utsDot3OnuPortId).setValue(aUtsDot3OnuPortId);
	}

	public Integer getUtsDot3OnuLogicalPortId()
	{
		return (Integer) getProperty(utsDot3OnuLogicalPortId).getValue();
	}

	public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId)
	{
		getProperty(utsDot3OnuLogicalPortId).setValue(aUtsDot3OnuLogicalPortId);
	}

	public Integer getUtsDot3OnuRegistrationState()
	{
		return (Integer) getProperty(utsDot3OnuRegistrationState).getValue();
	}

	public void setUtsDot3OnuRegistrationState(
			Integer aUtsDot3OnuRegistrationState)
	{
		getProperty(utsDot3OnuRegistrationState).setValue(
				aUtsDot3OnuRegistrationState);
	}

	public String getUtsDot3OnuHwVersion()
	{
		return (String) getProperty(utsDot3OnuHwVersion).getValue();
	}

	public void setUtsDot3OnuHwVersion(String aUtsDot3OnuHwVersion)
	{
		getProperty(utsDot3OnuHwVersion).setValue(aUtsDot3OnuHwVersion);
	}

	public String getUtsDot3OnuFwVersion()
	{
		return (String) getProperty(utsDot3OnuFwVersion).getValue();
	}

	public void setUtsDot3OnuFwVersion(String aUtsDot3OnuFwVersion)
	{
		getProperty(utsDot3OnuFwVersion).setValue(aUtsDot3OnuFwVersion);
	}

	public Integer getUtsDot3OnuMaxLLID()
	{
		return (Integer) getProperty(utsDot3OnuMaxLLID).getValue();
	}

	public void setUtsDot3OnuMaxLLID(Integer aUtsDot3OnuMaxLLID)
	{
		getProperty(utsDot3OnuMaxLLID).setValue(aUtsDot3OnuMaxLLID);
	}

	public Integer getUtsDot3OnuOAMStandardVersion()
	{
		return (Integer) getProperty(utsDot3OnuOAMStandardVersion).getValue();
	}

	public void setUtsDot3OnuOAMStandardVersion(
			Integer aUtsDot3OnuOAMStandardVersion)
	{
		getProperty(utsDot3OnuOAMStandardVersion).setValue(
				aUtsDot3OnuOAMStandardVersion);
	}

	public Integer getUtsDot3OnuRTT()
	{
		return (Integer) getProperty(utsDot3OnuRTT).getValue();
	}

	public void setUtsDot3OnuRTT(Integer aUtsDot3OnuRTT)
	{
		getProperty(utsDot3OnuRTT).setValue(aUtsDot3OnuRTT);
	}

	public Integer getUtsDot3OnuHwType()
	{
		return (Integer) getProperty(utsDot3OnuHwType).getValue();
	}

	public void setUtsDot3OnuHwType(Integer aUtsDot3OnuHwType)
	{
		getProperty(utsDot3OnuHwType).setValue(aUtsDot3OnuHwType);
	}

	public String getUtsDot3OnuSwitchHwRev()
	{
		return (String) getProperty(utsDot3OnuSwitchHwRev).getValue();
	}

	public void setUtsDot3OnuSwitchHwRev(String aUtsDot3OnuSwitchHwRev)
	{
		getProperty(utsDot3OnuSwitchHwRev).setValue(aUtsDot3OnuSwitchHwRev);
	}

	public String getUtsDot3OnuSwitchFwRev()
	{
		return (String) getProperty(utsDot3OnuSwitchFwRev).getValue();
	}

	public void setUtsDot3OnuSwitchFwRev(String aUtsDot3OnuSwitchFwRev)
	{
		getProperty(utsDot3OnuSwitchFwRev).setValue(aUtsDot3OnuSwitchFwRev);
	}

	public Integer getUtsDot3OnuIADStatus()
	{
		return (Integer) getProperty(utsDot3OnuIADStatus).getValue();
	}

	public void setUtsDot3OnuIADStatus(Integer aUtsDot3OnuIADStatus)
	{
		getProperty(utsDot3OnuIADStatus).setValue(aUtsDot3OnuIADStatus);
	}

	public byte[] getUtsDot3OnuPonMacAddress()
	{
		return (byte[]) getProperty(utsDot3OnuPonMacAddress).getValue();
	}

	public void setUtsDot3OnuPonMacAddress(byte[] aUtsDot3OnuPonMacAddress)
	{
		getProperty(utsDot3OnuPonMacAddress).setValue(aUtsDot3OnuPonMacAddress);
	}

	public Integer getUtsDot3OnuAES128EncryptionStatus()
	{
		return (Integer) getProperty(utsDot3OnuAES128EncryptionStatus)
				.getValue();
	}

	public void setUtsDot3OnuAES128EncryptionStatus(
			Integer aUtsDot3OnuAES128EncryptionStatus)
	{
		getProperty(utsDot3OnuAES128EncryptionStatus).setValue(
				aUtsDot3OnuAES128EncryptionStatus);
	}

	public String getUtsDot3OnuAES128EncryptionKey()
	{
		return (String) getProperty(utsDot3OnuAES128EncryptionKey).getValue();
	}

	public void setUtsDot3OnuAES128EncryptionKey(
			String aUtsDot3OnuAES128EncryptionKey)
	{
		getProperty(utsDot3OnuAES128EncryptionKey).setValue(
				aUtsDot3OnuAES128EncryptionKey);
	}

	public Integer getUtsDot3OnuPonLoopbackTestStatus()
	{
		return (Integer) getProperty(utsDot3OnuPonLoopbackTestStatus)
				.getValue();
	}

	public void setUtsDot3OnuPonLoopbackTestStatus(
			Integer aUtsDot3OnuPonLoopbackTestStatus)
	{
		getProperty(utsDot3OnuPonLoopbackTestStatus).setValue(
				aUtsDot3OnuPonLoopbackTestStatus);
	}

	public Integer getUtsDot3OnuPonLoopbackTestVlanId()
	{
		return (Integer) getProperty(utsDot3OnuPonLoopbackTestVlanId)
				.getValue();
	}

	public void setUtsDot3OnuPonLoopbackTestVlanId(
			Integer aUtsDot3OnuPonLoopbackTestVlanId)
	{
		getProperty(utsDot3OnuPonLoopbackTestVlanId).setValue(
				aUtsDot3OnuPonLoopbackTestVlanId);
	}

	public Integer getUtsDot3OnuEthernetLinkStatus()
	{
		return (Integer) getProperty(utsDot3OnuEthernetLinkStatus).getValue();
	}

	public void setUtsDot3OnuEthernetLinkStatus(
			Integer aUtsDot3OnuEthernetLinkStatus)
	{
		getProperty(utsDot3OnuEthernetLinkStatus).setValue(
				aUtsDot3OnuEthernetLinkStatus);
	}

	public byte[] getUtsDot3OnuSwitchMacAddress()
	{
		return (byte[]) getProperty(utsDot3OnuSwitchMacAddress).getValue();
	}

	public void setUtsDot3OnuSwitchMacAddress(byte[] aUtsDot3OnuSwitchMacAddress)
	{
		getProperty(utsDot3OnuSwitchMacAddress).setValue(
				aUtsDot3OnuSwitchMacAddress);
	}

	public Integer getUtsDot3OnuAdminStatus()
	{
		return (Integer) getProperty(utsDot3OnuAdminStatus).getValue();
	}

	public void setUtsDot3OnuAdminStatus(Integer aUtsDot3OnuAdminStatus)
	{
		getProperty(utsDot3OnuAdminStatus).setValue(aUtsDot3OnuAdminStatus);
	}

	public Integer getUtsDot3OnuMulticastFilter()
	{
		return (Integer) getProperty(utsDot3OnuMulticastFilter).getValue();
	}

	public void setUtsDot3OnuMulticastFilter(Integer aUtsDot3OnuMulticastFilter)
	{
		getProperty(utsDot3OnuMulticastFilter).setValue(
				aUtsDot3OnuMulticastFilter);
	}

	public Integer getUtsDot3OnuRMAutoNegotiation()
	{
		return (Integer) getProperty(utsDot3OnuRMAutoNegotiation).getValue();
	}

	public void setUtsDot3OnuRMAutoNegotiation(
			Integer aUtsDot3OnuRMAutoNegotiation)
	{
		getProperty(utsDot3OnuRMAutoNegotiation).setValue(
				aUtsDot3OnuRMAutoNegotiation);
	}

	public Integer getUtsDot3OnuReset()
	{
		return (Integer) getProperty(utsDot3OnuReset).getValue();
	}

	public void setUtsDot3OnuReset(Integer aUtsDot3OnuReset)
	{
		getProperty(utsDot3OnuReset).setValue(aUtsDot3OnuReset);
	}

	public Integer getUtsDot3OnuQinQ()
	{
		return (Integer) getProperty(utsDot3OnuQinQ).getValue();
	}

	public void setUtsDot3OnuQinQ(Integer aUtsDot3OnuQinQ)
	{
		getProperty(utsDot3OnuQinQ).setValue(aUtsDot3OnuQinQ);
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
		prepareRead(super.getProperty(utsDot3OnuModuleId));
		prepareRead(super.getProperty(utsDot3OnuPortId));
		prepareRead(super.getProperty(utsDot3OnuLogicalPortId));
		prepareRead(super.getProperty(utsDot3OnuRegistrationState));
		prepareRead(super.getProperty(utsDot3OnuHwVersion));
		prepareRead(super.getProperty(utsDot3OnuFwVersion));
		prepareRead(super.getProperty(utsDot3OnuMaxLLID));
		prepareRead(super.getProperty(utsDot3OnuOAMStandardVersion));
		prepareRead(super.getProperty(utsDot3OnuRTT));
		prepareRead(super.getProperty(utsDot3OnuHwType));
		prepareRead(super.getProperty(utsDot3OnuSwitchHwRev));
		prepareRead(super.getProperty(utsDot3OnuSwitchFwRev));
		prepareRead(super.getProperty(utsDot3OnuIADStatus));
		prepareRead(super.getProperty(utsDot3OnuPonMacAddress));
		prepareRead(super.getProperty(utsDot3OnuAES128EncryptionStatus));
		prepareRead(super.getProperty(utsDot3OnuAES128EncryptionKey));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestStatus));
		prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestVlanId));
		prepareRead(super.getProperty(utsDot3OnuEthernetLinkStatus));
		prepareRead(super.getProperty(utsDot3OnuSwitchMacAddress));
		prepareRead(super.getProperty(utsDot3OnuAdminStatus));
		prepareRead(super.getProperty(utsDot3OnuMulticastFilter));
		prepareRead(super.getProperty(utsDot3OnuRMAutoNegotiation));
		prepareRead(super.getProperty(utsDot3OnuReset));
		prepareRead(super.getProperty(utsDot3OnuQinQ));

    boolean b = load();
//    if(!DebugMode.isDebug())
//    {
//      try
//      {
//        OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//        String mac = ConfigUtility.OctetToMacAddress(getUtsDot3OnuPonMacAddress());
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
    prepareRead(super.getProperty(utsDot3OnuModuleId));
    prepareRead(super.getProperty(utsDot3OnuPortId));
    prepareRead(super.getProperty(utsDot3OnuLogicalPortId));
    prepareRead(super.getProperty(utsDot3OnuRegistrationState));
    prepareRead(super.getProperty(utsDot3OnuHwVersion));
    prepareRead(super.getProperty(utsDot3OnuFwVersion));
    prepareRead(super.getProperty(utsDot3OnuMaxLLID));
    prepareRead(super.getProperty(utsDot3OnuOAMStandardVersion));
    prepareRead(super.getProperty(utsDot3OnuRTT));
    prepareRead(super.getProperty(utsDot3OnuHwType));
    prepareRead(super.getProperty(utsDot3OnuSwitchHwRev));
    prepareRead(super.getProperty(utsDot3OnuSwitchFwRev));
    prepareRead(super.getProperty(utsDot3OnuIADStatus));
    prepareRead(super.getProperty(utsDot3OnuPonMacAddress));
    prepareRead(super.getProperty(utsDot3OnuAES128EncryptionStatus));
    prepareRead(super.getProperty(utsDot3OnuAES128EncryptionKey));
    prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestStatus));
    prepareRead(super.getProperty(utsDot3OnuPonLoopbackTestVlanId));
    prepareRead(super.getProperty(utsDot3OnuEthernetLinkStatus));
    prepareRead(super.getProperty(utsDot3OnuSwitchMacAddress));
    prepareRead(super.getProperty(utsDot3OnuAdminStatus));
    prepareRead(super.getProperty(utsDot3OnuMulticastFilter));
    prepareRead(super.getProperty(utsDot3OnuRMAutoNegotiation));
    prepareRead(super.getProperty(utsDot3OnuReset));
    prepareRead(super.getProperty(utsDot3OnuQinQ));

    setRowsToFetch(128);

    Vector v = loadAll(new int[] {1});

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
//          Dot3OnuTable bean = (Dot3OnuTable)v.get(i);
//
//          String key = neName + bean.getUtsDot3OnuModuleId() + "/" + bean.getUtsDot3OnuPortId() + "/" + bean.getUtsDot3OnuLogicalPortId();
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

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot3OnuAES128EncryptionStatus));
		prepareSave(getProperty(utsDot3OnuAES128EncryptionKey));
		prepareSave(getProperty(utsDot3OnuPonLoopbackTestStatus));
		prepareSave(getProperty(utsDot3OnuPonLoopbackTestVlanId));
		prepareSave(getProperty(utsDot3OnuAdminStatus));
		prepareSave(getProperty(utsDot3OnuMulticastFilter));
		prepareSave(getProperty(utsDot3OnuRMAutoNegotiation));
		prepareSave(getProperty(utsDot3OnuReset));
		prepareSave(getProperty(utsDot3OnuQinQ));

		return save();
	}

	public boolean delete() throws MibBeanException {
		// set ONU reset action to NE 
		setUtsDot3OnuReset( new Integer(1) );
		prepareSave(getProperty(utsDot3OnuReset));

		return save();
	}
}
