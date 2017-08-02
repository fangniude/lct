package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The EthIfExtTable class. Created by QuickDVM
 */
public class EthIfExtTable extends SnmpMibBean
{
	public static final String ifIndex = "ifIndex";

	public static final String utsEthIfExtModuleId = "utsEthIfExtModuleId";

	public static final String utsEthIfExtPortId = "utsEthIfExtPortId";

	public static final String utsEthIfExtLinkAggGroupId = "utsEthIfExtLinkAggGroupId";

	public static final String utsEthIfExtLoopbackPortId = "utsEthIfExtLoopbackPortId";

	public static final String utsEthIfExtVlanId = "utsEthIfExtVlanId";

	public static final String utsEthIfExtPortType = "utsEthIfExtPortType";

	public static final String utsEthIfExtIpAddress = "utsEthIfExtIpAddress";

	public static final String utsEthIfExtIpNetmask = "utsEthIfExtIpNetmask";

	public static final String utsEthIfExtSwitchMode = "utsEthIfExtSwitchMode";

	public static final String utsEthIfExtAdminStatus = "utsEthIfExtAdminStatus";

	public static final String utsEthIfExtIfIndex = "utsEthIfExtIfIndex";

	public EthIfExtTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifIndex, new SnmpMibBeanProperty(ifIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtModuleId, new SnmpMibBeanProperty(
				utsEthIfExtModuleId, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtPortId, new SnmpMibBeanProperty(
				utsEthIfExtPortId, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtLinkAggGroupId, new SnmpMibBeanProperty(
				utsEthIfExtLinkAggGroupId,
				".1.3.6.1.4.1.45121.1800.2.2.1.1.1.3", ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtLoopbackPortId, new SnmpMibBeanProperty(
				utsEthIfExtLoopbackPortId,
				".1.3.6.1.4.1.45121.1800.2.2.1.1.1.4", ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtVlanId, new SnmpMibBeanProperty(
				utsEthIfExtVlanId, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtPortType, new SnmpMibBeanProperty(
				utsEthIfExtPortType, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtIpAddress, new SnmpMibBeanProperty(
				utsEthIfExtIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.7",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsEthIfExtIpNetmask, new SnmpMibBeanProperty(
				utsEthIfExtIpNetmask, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.8",
				ISnmpConstant.IP_ADDRESS));
		initProperty(utsEthIfExtSwitchMode, new SnmpMibBeanProperty(
				utsEthIfExtSwitchMode, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtAdminStatus, new SnmpMibBeanProperty(
				utsEthIfExtAdminStatus, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsEthIfExtIfIndex, new SnmpMibBeanProperty(
				utsEthIfExtIfIndex, ".1.3.6.1.4.1.45121.1800.2.2.1.1.1.11",
				ISnmpConstant.INTEGER));

	}

	public Integer getIfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsEthIfExtModuleId()
	{
		return (Integer) getProperty(utsEthIfExtModuleId).getValue();
	}

	public void setUtsEthIfExtModuleId(Integer aUtsEthIfExtModuleId)
	{
		getProperty(utsEthIfExtModuleId).setValue(aUtsEthIfExtModuleId);
	}

	public Integer getUtsEthIfExtPortId()
	{
		return (Integer) getProperty(utsEthIfExtPortId).getValue();
	}

	public void setUtsEthIfExtPortId(Integer aUtsEthIfExtPortId)
	{
		getProperty(utsEthIfExtPortId).setValue(aUtsEthIfExtPortId);
	}

	public Integer getUtsEthIfExtLinkAggGroupId()
	{
		return (Integer) getProperty(utsEthIfExtLinkAggGroupId).getValue();
	}

	public void setUtsEthIfExtLinkAggGroupId(Integer aUtsEthIfExtLinkAggGroupId)
	{
		getProperty(utsEthIfExtLinkAggGroupId).setValue(
				aUtsEthIfExtLinkAggGroupId);
	}

	public Integer getUtsEthIfExtLoopbackPortId()
	{
		return (Integer) getProperty(utsEthIfExtLoopbackPortId).getValue();
	}

	public void setUtsEthIfExtLoopbackPortId(Integer aUtsEthIfExtLoopbackPortId)
	{
		getProperty(utsEthIfExtLoopbackPortId).setValue(
				aUtsEthIfExtLoopbackPortId);
	}

	public Integer getUtsEthIfExtVlanId()
	{
		return (Integer) getProperty(utsEthIfExtVlanId).getValue();
	}

	public void setUtsEthIfExtVlanId(Integer aUtsEthIfExtVlanId)
	{
		getProperty(utsEthIfExtVlanId).setValue(aUtsEthIfExtVlanId);
	}

	public Integer getUtsEthIfExtPortType()
	{
		return (Integer) getProperty(utsEthIfExtPortType).getValue();
	}

	public void setUtsEthIfExtPortType(Integer aUtsEthIfExtPortType)
	{
		getProperty(utsEthIfExtPortType).setValue(aUtsEthIfExtPortType);
	}

	public String getUtsEthIfExtIpAddress()
	{
		return (String) getProperty(utsEthIfExtIpAddress).getValue();
	}

	public void setUtsEthIfExtIpAddress(String aUtsEthIfExtIpAddress)
	{
		getProperty(utsEthIfExtIpAddress).setValue(aUtsEthIfExtIpAddress);
	}

	public String getUtsEthIfExtIpNetmask()
	{
		return (String) getProperty(utsEthIfExtIpNetmask).getValue();
	}

	public void setUtsEthIfExtIpNetmask(String aUtsEthIfExtIpNetmask)
	{
		getProperty(utsEthIfExtIpNetmask).setValue(aUtsEthIfExtIpNetmask);
	}

	public Integer getUtsEthIfExtSwitchMode()
	{
		return (Integer) getProperty(utsEthIfExtSwitchMode).getValue();
	}

	public void setUtsEthIfExtSwitchMode(Integer aUtsEthIfExtSwitchMode)
	{
		getProperty(utsEthIfExtSwitchMode).setValue(aUtsEthIfExtSwitchMode);
	}

	public Integer getUtsEthIfExtAdminStatus()
	{
		return (Integer) getProperty(utsEthIfExtAdminStatus).getValue();
	}

	public void setUtsEthIfExtAdminStatus(Integer aUtsEthIfExtAdminStatus)
	{
		getProperty(utsEthIfExtAdminStatus).setValue(aUtsEthIfExtAdminStatus);
	}

	public Integer getUtsEthIfExtIfIndex()
	{
		return (Integer) getProperty(utsEthIfExtIfIndex).getValue();
	}

	public void setUtsEthIfExtIfIndex(Integer aUtsEthIfExtIfIndex)
	{
		getProperty(utsEthIfExtIfIndex).setValue(aUtsEthIfExtIfIndex);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEthIfExtModuleId));
		prepareRead(super.getProperty(utsEthIfExtPortId));
		prepareRead(super.getProperty(utsEthIfExtLinkAggGroupId));
//		prepareRead(super.getProperty(utsEthIfExtLoopbackPortId));
		prepareRead(super.getProperty(utsEthIfExtVlanId));
		prepareRead(super.getProperty(utsEthIfExtPortType));
		prepareRead(super.getProperty(utsEthIfExtIpAddress));
		prepareRead(super.getProperty(utsEthIfExtIpNetmask));
		prepareRead(super.getProperty(utsEthIfExtSwitchMode));
		prepareRead(super.getProperty(utsEthIfExtAdminStatus));
//		prepareRead(super.getProperty(utsEthIfExtIfIndex));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEthIfExtModuleId));
		prepareRead(super.getProperty(utsEthIfExtPortId));
		prepareRead(super.getProperty(utsEthIfExtLinkAggGroupId));
//		prepareRead(super.getProperty(utsEthIfExtLoopbackPortId));
		prepareRead(super.getProperty(utsEthIfExtVlanId));
		prepareRead(super.getProperty(utsEthIfExtPortType));
		prepareRead(super.getProperty(utsEthIfExtIpAddress));
		prepareRead(super.getProperty(utsEthIfExtIpNetmask));
		prepareRead(super.getProperty(utsEthIfExtSwitchMode));
		prepareRead(super.getProperty(utsEthIfExtAdminStatus));
		prepareRead(super.getProperty(utsEthIfExtIfIndex));

		Vector vec = loadAll(new int[]
		{ 1 });
		
		Vector result = new Vector();

		for( int i=0; i<vec.size(); i++ )
		{
			EthIfExtTable table = (EthIfExtTable)vec.get( i );
			if( table.getUtsEthIfExtSwitchMode().intValue() == EthInterface.layer3 &&
					!table.getUtsEthIfExtIpAddress().equals("0.0.0.0") )
			{
				result.add( table );
			}
		}
		
		return result;
	}
	
	public Vector retrieveRealAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEthIfExtModuleId));
		prepareRead(super.getProperty(utsEthIfExtPortId));
		prepareRead(super.getProperty(utsEthIfExtLinkAggGroupId));
//		prepareRead(super.getProperty(utsEthIfExtLoopbackPortId));
		prepareRead(super.getProperty(utsEthIfExtVlanId));
		prepareRead(super.getProperty(utsEthIfExtPortType));
		prepareRead(super.getProperty(utsEthIfExtIpAddress));
		prepareRead(super.getProperty(utsEthIfExtIpNetmask));
		prepareRead(super.getProperty(utsEthIfExtSwitchMode));
		prepareRead(super.getProperty(utsEthIfExtAdminStatus));
//		prepareRead(super.getProperty(utsEthIfExtIfIndex));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsEthIfExtIpAddress));
		prepareSave(getProperty(utsEthIfExtIpNetmask));
//		prepareSave(getProperty(utsEthIfExtSwitchMode));
		prepareSave(getProperty(utsEthIfExtAdminStatus));

		return save();
	}
    public boolean delete() throws MibBeanException 
    {
    	setUtsEthIfExtSwitchMode(new Integer( 1 ));
		prepareSave(getProperty(utsEthIfExtSwitchMode));
		return save();
    }
	public boolean add() throws MibBeanException
	{
		
		prepareSave(getProperty(utsEthIfExtIpAddress));
		prepareSave(getProperty(utsEthIfExtIpNetmask));
		prepareSave(getProperty(utsEthIfExtSwitchMode));
		prepareSave(getProperty(utsEthIfExtAdminStatus));

		return save();
	}
}
