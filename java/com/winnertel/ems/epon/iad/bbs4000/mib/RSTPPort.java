package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The RSTPPort class. Created by QuickDVM
 */
public class RSTPPort extends SnmpMibBean
{
	public static final String utsEponDot1dStpPortIntfIndex = "utsEponDot1dStpPortIntfIndex";

	public static final String utsEponDot1dStpPortVlanID = "utsEponDot1dStpPortVlanID";

	public static final String utsEponDot1dStpModuleID = "utsEponDot1dStpModuleID";

	public static final String utsEponDot1dStpPortID = "utsEponDot1dStpPortID";

	public static final String utsEponDot1dStpPortLagID = "utsEponDot1dStpPortLagID";

	public static final String utsEponDot1dStpPortPriority = "utsEponDot1dStpPortPriority";

	public static final String utsEponDot1dStpPortState = "utsEponDot1dStpPortState";

	public static final String utsEponDot1dStpPortEnable = "utsEponDot1dStpPortEnable";

	public static final String utsEponDot1dStpPortPathCost = "utsEponDot1dStpPortPathCost";

	public static final String utsEponDot1dStpPortDesignatedRoot = "utsEponDot1dStpPortDesignatedRoot";

	public static final String utsEponDot1dStpPortDesignatedCost = "utsEponDot1dStpPortDesignatedCost";

	public static final String utsEponDot1dStpPortDesignatedBridge = "utsEponDot1dStpPortDesignatedBridge";

	public static final String utsEponDot1dStpPortDesignatedPort = "utsEponDot1dStpPortDesignatedPort";

	public static final String utsEponDot1dStpPortFastEnable = "utsEponDot1dStpPortFastEnable";

	public RSTPPort(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsEponDot1dStpPortIntfIndex,
				new SnmpMibBeanProperty(utsEponDot1dStpPortIntfIndex,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortVlanID,
				new SnmpMibBeanProperty(utsEponDot1dStpPortVlanID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpModuleID,
				new SnmpMibBeanProperty(utsEponDot1dStpModuleID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortID,
				new SnmpMibBeanProperty(utsEponDot1dStpPortID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortLagID,
				new SnmpMibBeanProperty(utsEponDot1dStpPortLagID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortPriority,
				new SnmpMibBeanProperty(utsEponDot1dStpPortPriority,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortState,
				new SnmpMibBeanProperty(utsEponDot1dStpPortState,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortEnable,
				new SnmpMibBeanProperty(utsEponDot1dStpPortEnable,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortPathCost,
				new SnmpMibBeanProperty(utsEponDot1dStpPortPathCost,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortDesignatedRoot,
				new SnmpMibBeanProperty(utsEponDot1dStpPortDesignatedRoot,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.10",
						ISnmpConstant.OCTETS));
		initProperty(utsEponDot1dStpPortDesignatedCost,
				new SnmpMibBeanProperty(utsEponDot1dStpPortDesignatedCost,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.11",
						ISnmpConstant.INTEGER));
		initProperty(utsEponDot1dStpPortDesignatedBridge,
				new SnmpMibBeanProperty(utsEponDot1dStpPortDesignatedBridge,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.12",
						ISnmpConstant.OCTETS));
		initProperty(utsEponDot1dStpPortDesignatedPort,
				new SnmpMibBeanProperty(utsEponDot1dStpPortDesignatedPort,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.13",
						ISnmpConstant.OCTETS));
		initProperty(utsEponDot1dStpPortFastEnable, new SnmpMibBeanProperty(
				utsEponDot1dStpPortFastEnable,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.2.1.15",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsEponDot1dStpPortIntfIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsEponDot1dStpPortIntfIndex(
			Integer aUtsEponDot1dStpPortIntfIndex)
	{
		setIndex(0, aUtsEponDot1dStpPortIntfIndex);
	}

	public Integer getUtsEponDot1dStpPortVlanID()
	{
		return (Integer) getIndex(1);
	}

	public void setUtsEponDot1dStpPortVlanID(Integer aUtsEponDot1dStpPortVlanID)
	{
		setIndex(1, aUtsEponDot1dStpPortVlanID);
	}

	public Integer getUtsEponDot1dStpModuleID()
	{
		return (Integer) getProperty(utsEponDot1dStpModuleID).getValue();
	}

	public void setUtsEponDot1dStpModuleID(Integer aUtsEponDot1dStpModuleID)
	{
		getProperty(utsEponDot1dStpModuleID).setValue(aUtsEponDot1dStpModuleID);
	}

	public Integer getUtsEponDot1dStpPortID()
	{
		return (Integer) getProperty(utsEponDot1dStpPortID).getValue();
	}

	public void setUtsEponDot1dStpPortID(Integer aUtsEponDot1dStpPortID)
	{
		getProperty(utsEponDot1dStpPortID).setValue(aUtsEponDot1dStpPortID);
	}

	public Integer getUtsEponDot1dStpPortLagID()
	{
		return (Integer) getProperty(utsEponDot1dStpPortLagID).getValue();
	}

	public void setUtsEponDot1dStpPortLagID(Integer aUtsEponDot1dStpPortLagID)
	{
		getProperty(utsEponDot1dStpPortLagID).setValue(
				aUtsEponDot1dStpPortLagID);
	}

	public Integer getUtsEponDot1dStpPortPriority()
	{
		return (Integer) getProperty(utsEponDot1dStpPortPriority).getValue();
	}

	public void setUtsEponDot1dStpPortPriority(
			Integer aUtsEponDot1dStpPortPriority)
	{
		getProperty(utsEponDot1dStpPortPriority).setValue(
				aUtsEponDot1dStpPortPriority);
	}

	public Integer getUtsEponDot1dStpPortState()
	{
		return (Integer) getProperty(utsEponDot1dStpPortState).getValue();
	}

	public void setUtsEponDot1dStpPortState(Integer aUtsEponDot1dStpPortState)
	{
		getProperty(utsEponDot1dStpPortState).setValue(
				aUtsEponDot1dStpPortState);
	}

	public Integer getUtsEponDot1dStpPortEnable()
	{
		return (Integer) getProperty(utsEponDot1dStpPortEnable).getValue();
	}

	public void setUtsEponDot1dStpPortEnable(Integer aUtsEponDot1dStpPortEnable)
	{
		getProperty(utsEponDot1dStpPortEnable).setValue(
				aUtsEponDot1dStpPortEnable);
	}

	public Integer getUtsEponDot1dStpPortPathCost()
	{
		return (Integer) getProperty(utsEponDot1dStpPortPathCost).getValue();
	}

	public void setUtsEponDot1dStpPortPathCost(
			Integer aUtsEponDot1dStpPortPathCost)
	{
		getProperty(utsEponDot1dStpPortPathCost).setValue(
				aUtsEponDot1dStpPortPathCost);
	}

	public byte[] getUtsEponDot1dStpPortDesignatedRoot()
	{
		return (byte[]) getProperty(utsEponDot1dStpPortDesignatedRoot)
				.getValue();
	}

	public void setUtsEponDot1dStpPortDesignatedRoot(
			byte[] aUtsEponDot1dStpPortDesignatedRoot)
	{
		getProperty(utsEponDot1dStpPortDesignatedRoot).setValue(
				aUtsEponDot1dStpPortDesignatedRoot);
	}

	public Integer getUtsEponDot1dStpPortDesignatedCost()
	{
		return (Integer) getProperty(utsEponDot1dStpPortDesignatedCost)
				.getValue();
	}

	public void setUtsEponDot1dStpPortDesignatedCost(
			Integer aUtsEponDot1dStpPortDesignatedCost)
	{
		getProperty(utsEponDot1dStpPortDesignatedCost).setValue(
				aUtsEponDot1dStpPortDesignatedCost);
	}

	public byte[] getUtsEponDot1dStpPortDesignatedBridge()
	{
		return (byte[]) getProperty(utsEponDot1dStpPortDesignatedBridge)
				.getValue();
	}

	public void setUtsEponDot1dStpPortDesignatedBridge(
			byte[] aUtsEponDot1dStpPortDesignatedBridge)
	{
		getProperty(utsEponDot1dStpPortDesignatedBridge).setValue(
				aUtsEponDot1dStpPortDesignatedBridge);
	}

	public byte[] getUtsEponDot1dStpPortDesignatedPort()
	{
		return (byte[]) getProperty(utsEponDot1dStpPortDesignatedPort)
				.getValue();
	}

	public void setUtsEponDot1dStpPortDesignatedPort(
			byte[] aUtsEponDot1dStpPortDesignatedPort)
	{
		getProperty(utsEponDot1dStpPortDesignatedPort).setValue(
				aUtsEponDot1dStpPortDesignatedPort);
	}

	public Integer getUtsEponDot1dStpPortFastEnable()
	{
		return (Integer) getProperty(utsEponDot1dStpPortFastEnable).getValue();
	}

	public void setUtsEponDot1dStpPortFastEnable(
			Integer aUtsEponDot1dStpPortFastEnable)
	{
		getProperty(utsEponDot1dStpPortFastEnable).setValue(
				aUtsEponDot1dStpPortFastEnable);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEponDot1dStpModuleID));
		prepareRead(super.getProperty(utsEponDot1dStpPortID));
		prepareRead(super.getProperty(utsEponDot1dStpPortLagID));
		prepareRead(super.getProperty(utsEponDot1dStpPortPriority));
		prepareRead(super.getProperty(utsEponDot1dStpPortState));
		prepareRead(super.getProperty(utsEponDot1dStpPortEnable));
		prepareRead(super.getProperty(utsEponDot1dStpPortPathCost));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedRoot));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedCost));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedBridge));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedPort));
		prepareRead(super.getProperty(utsEponDot1dStpPortFastEnable));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEponDot1dStpModuleID));
		prepareRead(super.getProperty(utsEponDot1dStpPortID));
		prepareRead(super.getProperty(utsEponDot1dStpPortLagID));
		prepareRead(super.getProperty(utsEponDot1dStpPortPriority));
		prepareRead(super.getProperty(utsEponDot1dStpPortState));
		prepareRead(super.getProperty(utsEponDot1dStpPortEnable));
		prepareRead(super.getProperty(utsEponDot1dStpPortPathCost));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedRoot));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedCost));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedBridge));
		prepareRead(super.getProperty(utsEponDot1dStpPortDesignatedPort));
		prepareRead(super.getProperty(utsEponDot1dStpPortFastEnable));

		return loadAll(new int[]
		{ 1, 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsEponDot1dStpPortPriority));
		prepareSave(getProperty(utsEponDot1dStpPortPathCost));
		prepareSave(getProperty(utsEponDot1dStpPortFastEnable));

		return save();
	}

}
