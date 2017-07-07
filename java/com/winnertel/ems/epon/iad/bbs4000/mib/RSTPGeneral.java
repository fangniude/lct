package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The RSTPGeneral class. Created by QuickDVM
 */
public class RSTPGeneral extends SnmpMibBean
{
	public static final String utsEponDot1dStpBridgeVlanID = "utsEponDot1dStpBridgeVlanID";

	public static final String utsDot1dStpPriority = "utsDot1dStpPriority";

	public static final String utsDot1dStpTimeSinceTopologyChange = "utsDot1dStpTimeSinceTopologyChange";

	public static final String utsDot1dStpTopChanges = "utsDot1dStpTopChanges";

	public static final String utsDot1dStpDesignatedRoot = "utsDot1dStpDesignatedRoot";

	public static final String utsDot1dStpRootCost = "utsDot1dStpRootCost";

	public static final String utsDot1dStpRootPort = "utsDot1dStpRootPort";

	public static final String utsDot1dStpMaxAge = "utsDot1dStpMaxAge";

	public static final String utsDot1dStpHelloTime = "utsDot1dStpHelloTime";

	public static final String utsDot1dStpHoldTime = "utsDot1dStpHoldTime";

	public static final String utsDot1dStpForwardDelay = "utsDot1dStpForwardDelay";

	public static final String utsDot1dStpBridgeMaxAge = "utsDot1dStpBridgeMaxAge";

	public static final String utsDot1dStpBridgeHelloTime = "utsDot1dStpBridgeHelloTime";

	public static final String utsDot1dStpBridgeForwardDelay = "utsDot1dStpBridgeForwardDelay";

	public static final String utsDot1dStpBridgeOwnBridgeID = "utsDot1dStpBridgeOwnBridgeID";

	public RSTPGeneral(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsEponDot1dStpBridgeVlanID,
				new SnmpMibBeanProperty(utsEponDot1dStpBridgeVlanID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpPriority, new SnmpMibBeanProperty(
				utsDot1dStpPriority, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpTimeSinceTopologyChange,
				new SnmpMibBeanProperty(utsDot1dStpTimeSinceTopologyChange,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.3",
						ISnmpConstant.TIME_TICKS));
		initProperty(utsDot1dStpTopChanges,
				new SnmpMibBeanProperty(utsDot1dStpTopChanges,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.4",
						ISnmpConstant.COUNTER));
		initProperty(utsDot1dStpDesignatedRoot, new SnmpMibBeanProperty(
				utsDot1dStpDesignatedRoot,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.5", ISnmpConstant.OCTETS));
		initProperty(utsDot1dStpRootCost, new SnmpMibBeanProperty(
				utsDot1dStpRootCost, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpRootPort, new SnmpMibBeanProperty(
				utsDot1dStpRootPort, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpMaxAge, new SnmpMibBeanProperty(
				utsDot1dStpMaxAge, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpHelloTime, new SnmpMibBeanProperty(
				utsDot1dStpHelloTime, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpHoldTime, new SnmpMibBeanProperty(
				utsDot1dStpHoldTime, ".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpForwardDelay, new SnmpMibBeanProperty(
				utsDot1dStpForwardDelay,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpBridgeMaxAge, new SnmpMibBeanProperty(
				utsDot1dStpBridgeMaxAge,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpBridgeHelloTime, new SnmpMibBeanProperty(
				utsDot1dStpBridgeHelloTime,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpBridgeForwardDelay, new SnmpMibBeanProperty(
				utsDot1dStpBridgeForwardDelay,
				".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.14",
				ISnmpConstant.INTEGER));
		initProperty(utsDot1dStpBridgeOwnBridgeID,
				new SnmpMibBeanProperty(utsDot1dStpBridgeOwnBridgeID,
						".1.3.6.1.4.1.41355.1800.2.2.1.5.4.1.1.15",
						ISnmpConstant.OCTETS));

	}

	public Integer getUtsEponDot1dStpBridgeVlanID()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsEponDot1dStpBridgeVlanID(
			Integer aUtsEponDot1dStpBridgeVlanID)
	{
		setIndex(0, aUtsEponDot1dStpBridgeVlanID);
	}

	public Integer getUtsDot1dStpPriority()
	{
		return (Integer) getProperty(utsDot1dStpPriority).getValue();
	}

	public void setUtsDot1dStpPriority(Integer aUtsDot1dStpPriority)
	{
		getProperty(utsDot1dStpPriority).setValue(aUtsDot1dStpPriority);
	}

	public Long getUtsDot1dStpTimeSinceTopologyChange()
	{
		return (Long) getProperty(utsDot1dStpTimeSinceTopologyChange)
				.getValue();
	}

	public void setUtsDot1dStpTimeSinceTopologyChange(
			Long aUtsDot1dStpTimeSinceTopologyChange)
	{
		getProperty(utsDot1dStpTimeSinceTopologyChange).setValue(
				aUtsDot1dStpTimeSinceTopologyChange);
	}

	public Long getUtsDot1dStpTopChanges()
	{
		return (Long) getProperty(utsDot1dStpTopChanges).getValue();
	}

	public void setUtsDot1dStpTopChanges(Long aUtsDot1dStpTopChanges)
	{
		getProperty(utsDot1dStpTopChanges).setValue(aUtsDot1dStpTopChanges);
	}

	public byte[] getUtsDot1dStpDesignatedRoot()
	{
		return (byte[]) getProperty(utsDot1dStpDesignatedRoot).getValue();
	}

	public void setUtsDot1dStpDesignatedRoot(byte[] aUtsDot1dStpDesignatedRoot)
	{
		getProperty(utsDot1dStpDesignatedRoot).setValue(
				aUtsDot1dStpDesignatedRoot);
	}

	public Integer getUtsDot1dStpRootCost()
	{
		return (Integer) getProperty(utsDot1dStpRootCost).getValue();
	}

	public void setUtsDot1dStpRootCost(Integer aUtsDot1dStpRootCost)
	{
		getProperty(utsDot1dStpRootCost).setValue(aUtsDot1dStpRootCost);
	}

	public Integer getUtsDot1dStpRootPort()
	{
		return (Integer) getProperty(utsDot1dStpRootPort).getValue();
	}

	public void setUtsDot1dStpRootPort(Integer aUtsDot1dStpRootPort)
	{
		getProperty(utsDot1dStpRootPort).setValue(aUtsDot1dStpRootPort);
	}

	public Integer getUtsDot1dStpMaxAge()
	{
		return (Integer) getProperty(utsDot1dStpMaxAge).getValue();
	}

	public void setUtsDot1dStpMaxAge(Integer aUtsDot1dStpMaxAge)
	{
		getProperty(utsDot1dStpMaxAge).setValue(aUtsDot1dStpMaxAge);
	}

	public Integer getUtsDot1dStpHelloTime()
	{
		return (Integer) getProperty(utsDot1dStpHelloTime).getValue();
	}

	public void setUtsDot1dStpHelloTime(Integer aUtsDot1dStpHelloTime)
	{
		getProperty(utsDot1dStpHelloTime).setValue(aUtsDot1dStpHelloTime);
	}

	public Integer getUtsDot1dStpHoldTime()
	{
		return (Integer) getProperty(utsDot1dStpHoldTime).getValue();
	}

	public void setUtsDot1dStpHoldTime(Integer aUtsDot1dStpHoldTime)
	{
		getProperty(utsDot1dStpHoldTime).setValue(aUtsDot1dStpHoldTime);
	}

	public Integer getUtsDot1dStpForwardDelay()
	{
		return (Integer) getProperty(utsDot1dStpForwardDelay).getValue();
	}

	public void setUtsDot1dStpForwardDelay(Integer aUtsDot1dStpForwardDelay)
	{
		getProperty(utsDot1dStpForwardDelay).setValue(aUtsDot1dStpForwardDelay);
	}

	public Integer getUtsDot1dStpBridgeMaxAge()
	{
		return (Integer) getProperty(utsDot1dStpBridgeMaxAge).getValue();
	}

	public void setUtsDot1dStpBridgeMaxAge(Integer aUtsDot1dStpBridgeMaxAge)
	{
		getProperty(utsDot1dStpBridgeMaxAge).setValue(aUtsDot1dStpBridgeMaxAge);
	}

	public Integer getUtsDot1dStpBridgeHelloTime()
	{
		return (Integer) getProperty(utsDot1dStpBridgeHelloTime).getValue();
	}

	public void setUtsDot1dStpBridgeHelloTime(
			Integer aUtsDot1dStpBridgeHelloTime)
	{
		getProperty(utsDot1dStpBridgeHelloTime).setValue(
				aUtsDot1dStpBridgeHelloTime);
	}

	public Integer getUtsDot1dStpBridgeForwardDelay()
	{
		return (Integer) getProperty(utsDot1dStpBridgeForwardDelay).getValue();
	}

	public void setUtsDot1dStpBridgeForwardDelay(
			Integer aUtsDot1dStpBridgeForwardDelay)
	{
		getProperty(utsDot1dStpBridgeForwardDelay).setValue(
				aUtsDot1dStpBridgeForwardDelay);
	}

	public byte[] getUtsDot1dStpBridgeOwnBridgeID()
	{
		return (byte[]) getProperty(utsDot1dStpBridgeOwnBridgeID).getValue();
	}

	public void setUtsDot1dStpBridgeOwnBridgeID(
			byte[] aUtsDot1dStpBridgeOwnBridgeID)
	{
		getProperty(utsDot1dStpBridgeOwnBridgeID).setValue(
				aUtsDot1dStpBridgeOwnBridgeID);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot1dStpPriority));
		prepareRead(super.getProperty(utsDot1dStpTimeSinceTopologyChange));
		prepareRead(super.getProperty(utsDot1dStpTopChanges));
		prepareRead(super.getProperty(utsDot1dStpDesignatedRoot));
		prepareRead(super.getProperty(utsDot1dStpRootCost));
		prepareRead(super.getProperty(utsDot1dStpRootPort));
		prepareRead(super.getProperty(utsDot1dStpMaxAge));
		prepareRead(super.getProperty(utsDot1dStpHelloTime));
		prepareRead(super.getProperty(utsDot1dStpHoldTime));
		prepareRead(super.getProperty(utsDot1dStpForwardDelay));
		prepareRead(super.getProperty(utsDot1dStpBridgeMaxAge));
		prepareRead(super.getProperty(utsDot1dStpBridgeHelloTime));
		prepareRead(super.getProperty(utsDot1dStpBridgeForwardDelay));
		prepareRead(super.getProperty(utsDot1dStpBridgeOwnBridgeID));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot1dStpPriority));
		prepareRead(super.getProperty(utsDot1dStpTimeSinceTopologyChange));
		prepareRead(super.getProperty(utsDot1dStpTopChanges));
		prepareRead(super.getProperty(utsDot1dStpDesignatedRoot));
		prepareRead(super.getProperty(utsDot1dStpRootCost));
		prepareRead(super.getProperty(utsDot1dStpRootPort));
		prepareRead(super.getProperty(utsDot1dStpMaxAge));
		prepareRead(super.getProperty(utsDot1dStpHelloTime));
		prepareRead(super.getProperty(utsDot1dStpHoldTime));
		prepareRead(super.getProperty(utsDot1dStpForwardDelay));
		prepareRead(super.getProperty(utsDot1dStpBridgeMaxAge));
		prepareRead(super.getProperty(utsDot1dStpBridgeHelloTime));
		prepareRead(super.getProperty(utsDot1dStpBridgeForwardDelay));
		prepareRead(super.getProperty(utsDot1dStpBridgeOwnBridgeID));

		return loadAll(new int[]
		{ 1 });
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDot1dStpPriority));
		prepareSave(getProperty(utsDot1dStpBridgeMaxAge));
		prepareSave(getProperty(utsDot1dStpBridgeHelloTime));
		prepareSave(getProperty(utsDot1dStpBridgeForwardDelay));

		return save();
	}

}