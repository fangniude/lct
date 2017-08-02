package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3OltTransceiverTable class. Created by QuickDVM
 */
public class Dot3OltTransceiverTable extends SnmpMibBean
{
	public static final String utsDot3OltTransceiverIndex = "utsDot3OltTransceiverIndex";

	public static final String utsDot3OltTransceiverPONPortLinkIndPolarity = "utsDot3OltTransceiverPONPortLinkIndPolarity";

	public static final String utsDot3OltTransceiverAGCResetGateOffset = "utsDot3OltTransceiverAGCResetGateOffset";

	public static final String utsDot3OltTransceiverAGCResetDiscoveryOffset = "utsDot3OltTransceiverAGCResetDiscoveryOffset";

	public static final String utsDot3OltTransceiverAGCResetDuration = "utsDot3OltTransceiverAGCResetDuration";

	public static final String utsDot3OltTransceiverAGCResetPolarity = "utsDot3OltTransceiverAGCResetPolarity";

	public static final String utsDot3OltTransceiverCDRResetGateOffset = "utsDot3OltTransceiverCDRResetGateOffset";

	public static final String utsDot3OltTransceiverCDRResetDiscoveryOffset = "utsDot3OltTransceiverCDRResetDiscoveryOffset";

	public static final String utsDot3OltTransceiverCDRResetDuration = "utsDot3OltTransceiverCDRResetDuration";

	public static final String utsDot3OltTransceiverCDRResetPolarity = "utsDot3OltTransceiverCDRResetPolarity";

	public static final String utsDot3OltTransceiverEndGrantResetOffset = "utsDot3OltTransceiverEndGrantResetOffset";

	public static final String utsDot3OltTransceiverEndGrantResetDuration = "utsDot3OltTransceiverEndGrantResetDuration";

	public static final String utsDot3OltTransceiverEndGrantResetPolarity = "utsDot3OltTransceiverEndGrantResetPolarity";

	public static final String utsDot3OltTransceiverDiscoveryRelockEnable = "utsDot3OltTransceiverDiscoveryRelockEnable";

	public static final String utsDot3OltTransceiverDiscoveryLaserRxLossPolarity = "utsDot3OltTransceiverDiscoveryLaserRxLossPolarity";

	public static final String utsDot3OltTransceiverPONTxDisablePolarity = "utsDot3OltTransceiverPONTxDisablePolarity";

	public static final String utsDot3OltTransceiverOpticsDeadZone = "utsDot3OltTransceiverOpticsDeadZone";

	public static final String utsDot3OltTransceiverUseOpticsSignalLoss = "utsDot3OltTransceiverUseOpticsSignalLoss";

	public static final String utsDot3OltTransceiverAGCLockTime = "utsDot3OltTransceiverAGCLockTime";

	public static final String utsDot3OltTransceiverCDRLockTime = "utsDot3OltTransceiverCDRLockTime";

	public Dot3OltTransceiverTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsDot3OltTransceiverIndex,
				new SnmpMibBeanProperty(utsDot3OltTransceiverIndex,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverPONPortLinkIndPolarity,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverPONPortLinkIndPolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.2",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverAGCResetGateOffset,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverAGCResetGateOffset,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverAGCResetDiscoveryOffset,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverAGCResetDiscoveryOffset,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverAGCResetDuration,
				new SnmpMibBeanProperty(utsDot3OltTransceiverAGCResetDuration,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.5",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverAGCResetPolarity,
				new SnmpMibBeanProperty(utsDot3OltTransceiverAGCResetPolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverCDRResetGateOffset,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverCDRResetGateOffset,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverCDRResetDiscoveryOffset,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverCDRResetDiscoveryOffset,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverCDRResetDuration,
				new SnmpMibBeanProperty(utsDot3OltTransceiverCDRResetDuration,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverCDRResetPolarity,
				new SnmpMibBeanProperty(utsDot3OltTransceiverCDRResetPolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.10",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverEndGrantResetOffset,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverEndGrantResetOffset,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.11",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverEndGrantResetDuration,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverEndGrantResetDuration,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.12",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverEndGrantResetPolarity,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverEndGrantResetPolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.13",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverDiscoveryRelockEnable,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverDiscoveryRelockEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.14",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverDiscoveryLaserRxLossPolarity,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverDiscoveryLaserRxLossPolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.15",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverPONTxDisablePolarity,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverPONTxDisablePolarity,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.16",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverOpticsDeadZone,
				new SnmpMibBeanProperty(utsDot3OltTransceiverOpticsDeadZone,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.17",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverUseOpticsSignalLoss,
				new SnmpMibBeanProperty(
						utsDot3OltTransceiverUseOpticsSignalLoss,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.18",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverAGCLockTime, new SnmpMibBeanProperty(
				utsDot3OltTransceiverAGCLockTime,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltTransceiverCDRLockTime, new SnmpMibBeanProperty(
				utsDot3OltTransceiverCDRLockTime,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.2.1.1.20",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3OltTransceiverIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OltTransceiverIndex(
			Integer aUtsDot3OltTransceiverIndex)
	{
		setIndex(0, aUtsDot3OltTransceiverIndex);
	}

	public Integer getUtsDot3OltTransceiverPONPortLinkIndPolarity()
	{
		return (Integer) getProperty(
				utsDot3OltTransceiverPONPortLinkIndPolarity).getValue();
	}

	public void setUtsDot3OltTransceiverPONPortLinkIndPolarity(
			Integer aUtsDot3OltTransceiverPONPortLinkIndPolarity)
	{
		getProperty(utsDot3OltTransceiverPONPortLinkIndPolarity).setValue(
				aUtsDot3OltTransceiverPONPortLinkIndPolarity);
	}

	public Integer getUtsDot3OltTransceiverAGCResetGateOffset()
	{
		return (Integer) getProperty(utsDot3OltTransceiverAGCResetGateOffset)
				.getValue();
	}

	public void setUtsDot3OltTransceiverAGCResetGateOffset(
			Integer aUtsDot3OltTransceiverAGCResetGateOffset)
	{
		getProperty(utsDot3OltTransceiverAGCResetGateOffset).setValue(
				aUtsDot3OltTransceiverAGCResetGateOffset);
	}

	public Integer getUtsDot3OltTransceiverAGCResetDiscoveryOffset()
	{
		return (Integer) getProperty(
				utsDot3OltTransceiverAGCResetDiscoveryOffset).getValue();
	}

	public void setUtsDot3OltTransceiverAGCResetDiscoveryOffset(
			Integer aUtsDot3OltTransceiverAGCResetDiscoveryOffset)
	{
		getProperty(utsDot3OltTransceiverAGCResetDiscoveryOffset).setValue(
				aUtsDot3OltTransceiverAGCResetDiscoveryOffset);
	}

	public Integer getUtsDot3OltTransceiverAGCResetDuration()
	{
		return (Integer) getProperty(utsDot3OltTransceiverAGCResetDuration)
				.getValue();
	}

	public void setUtsDot3OltTransceiverAGCResetDuration(
			Integer aUtsDot3OltTransceiverAGCResetDuration)
	{
		getProperty(utsDot3OltTransceiverAGCResetDuration).setValue(
				aUtsDot3OltTransceiverAGCResetDuration);
	}

	public Integer getUtsDot3OltTransceiverAGCResetPolarity()
	{
		return (Integer) getProperty(utsDot3OltTransceiverAGCResetPolarity)
				.getValue();
	}

	public void setUtsDot3OltTransceiverAGCResetPolarity(
			Integer aUtsDot3OltTransceiverAGCResetPolarity)
	{
		getProperty(utsDot3OltTransceiverAGCResetPolarity).setValue(
				aUtsDot3OltTransceiverAGCResetPolarity);
	}

	public Integer getUtsDot3OltTransceiverCDRResetGateOffset()
	{
		return (Integer) getProperty(utsDot3OltTransceiverCDRResetGateOffset)
				.getValue();
	}

	public void setUtsDot3OltTransceiverCDRResetGateOffset(
			Integer aUtsDot3OltTransceiverCDRResetGateOffset)
	{
		getProperty(utsDot3OltTransceiverCDRResetGateOffset).setValue(
				aUtsDot3OltTransceiverCDRResetGateOffset);
	}

	public Integer getUtsDot3OltTransceiverCDRResetDiscoveryOffset()
	{
		return (Integer) getProperty(
				utsDot3OltTransceiverCDRResetDiscoveryOffset).getValue();
	}

	public void setUtsDot3OltTransceiverCDRResetDiscoveryOffset(
			Integer aUtsDot3OltTransceiverCDRResetDiscoveryOffset)
	{
		getProperty(utsDot3OltTransceiverCDRResetDiscoveryOffset).setValue(
				aUtsDot3OltTransceiverCDRResetDiscoveryOffset);
	}

	public Integer getUtsDot3OltTransceiverCDRResetDuration()
	{
		return (Integer) getProperty(utsDot3OltTransceiverCDRResetDuration)
				.getValue();
	}

	public void setUtsDot3OltTransceiverCDRResetDuration(
			Integer aUtsDot3OltTransceiverCDRResetDuration)
	{
		getProperty(utsDot3OltTransceiverCDRResetDuration).setValue(
				aUtsDot3OltTransceiverCDRResetDuration);
	}

	public Integer getUtsDot3OltTransceiverCDRResetPolarity()
	{
		return (Integer) getProperty(utsDot3OltTransceiverCDRResetPolarity)
				.getValue();
	}

	public void setUtsDot3OltTransceiverCDRResetPolarity(
			Integer aUtsDot3OltTransceiverCDRResetPolarity)
	{
		getProperty(utsDot3OltTransceiverCDRResetPolarity).setValue(
				aUtsDot3OltTransceiverCDRResetPolarity);
	}

	public Integer getUtsDot3OltTransceiverEndGrantResetOffset()
	{
		return (Integer) getProperty(utsDot3OltTransceiverEndGrantResetOffset)
				.getValue();
	}

	public void setUtsDot3OltTransceiverEndGrantResetOffset(
			Integer aUtsDot3OltTransceiverEndGrantResetOffset)
	{
		getProperty(utsDot3OltTransceiverEndGrantResetOffset).setValue(
				aUtsDot3OltTransceiverEndGrantResetOffset);
	}

	public Integer getUtsDot3OltTransceiverEndGrantResetDuration()
	{
		return (Integer) getProperty(utsDot3OltTransceiverEndGrantResetDuration)
				.getValue();
	}

	public void setUtsDot3OltTransceiverEndGrantResetDuration(
			Integer aUtsDot3OltTransceiverEndGrantResetDuration)
	{
		getProperty(utsDot3OltTransceiverEndGrantResetDuration).setValue(
				aUtsDot3OltTransceiverEndGrantResetDuration);
	}

	public Integer getUtsDot3OltTransceiverEndGrantResetPolarity()
	{
		return (Integer) getProperty(utsDot3OltTransceiverEndGrantResetPolarity)
				.getValue();
	}

	public void setUtsDot3OltTransceiverEndGrantResetPolarity(
			Integer aUtsDot3OltTransceiverEndGrantResetPolarity)
	{
		getProperty(utsDot3OltTransceiverEndGrantResetPolarity).setValue(
				aUtsDot3OltTransceiverEndGrantResetPolarity);
	}

	public Integer getUtsDot3OltTransceiverDiscoveryRelockEnable()
	{
		return (Integer) getProperty(utsDot3OltTransceiverDiscoveryRelockEnable)
				.getValue();
	}

	public void setUtsDot3OltTransceiverDiscoveryRelockEnable(
			Integer aUtsDot3OltTransceiverDiscoveryRelockEnable)
	{
		getProperty(utsDot3OltTransceiverDiscoveryRelockEnable).setValue(
				aUtsDot3OltTransceiverDiscoveryRelockEnable);
	}

	public Integer getUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity()
	{
		return (Integer) getProperty(
				utsDot3OltTransceiverDiscoveryLaserRxLossPolarity).getValue();
	}

	public void setUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity(
			Integer aUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity)
	{
		getProperty(utsDot3OltTransceiverDiscoveryLaserRxLossPolarity)
				.setValue(aUtsDot3OltTransceiverDiscoveryLaserRxLossPolarity);
	}

	public Integer getUtsDot3OltTransceiverPONTxDisablePolarity()
	{
		return (Integer) getProperty(utsDot3OltTransceiverPONTxDisablePolarity)
				.getValue();
	}

	public void setUtsDot3OltTransceiverPONTxDisablePolarity(
			Integer aUtsDot3OltTransceiverPONTxDisablePolarity)
	{
		getProperty(utsDot3OltTransceiverPONTxDisablePolarity).setValue(
				aUtsDot3OltTransceiverPONTxDisablePolarity);
	}

	public Integer getUtsDot3OltTransceiverOpticsDeadZone()
	{
		return (Integer) getProperty(utsDot3OltTransceiverOpticsDeadZone)
				.getValue();
	}

	public void setUtsDot3OltTransceiverOpticsDeadZone(
			Integer aUtsDot3OltTransceiverOpticsDeadZone)
	{
		getProperty(utsDot3OltTransceiverOpticsDeadZone).setValue(
				aUtsDot3OltTransceiverOpticsDeadZone);
	}

	public Integer getUtsDot3OltTransceiverUseOpticsSignalLoss()
	{
		return (Integer) getProperty(utsDot3OltTransceiverUseOpticsSignalLoss)
				.getValue();
	}

	public void setUtsDot3OltTransceiverUseOpticsSignalLoss(
			Integer aUtsDot3OltTransceiverUseOpticsSignalLoss)
	{
		getProperty(utsDot3OltTransceiverUseOpticsSignalLoss).setValue(
				aUtsDot3OltTransceiverUseOpticsSignalLoss);
	}

	public Integer getUtsDot3OltTransceiverAGCLockTime()
	{
		return (Integer) getProperty(utsDot3OltTransceiverAGCLockTime)
				.getValue();
	}

	public void setUtsDot3OltTransceiverAGCLockTime(
			Integer aUtsDot3OltTransceiverAGCLockTime)
	{
		getProperty(utsDot3OltTransceiverAGCLockTime).setValue(
				aUtsDot3OltTransceiverAGCLockTime);
	}

	public Integer getUtsDot3OltTransceiverCDRLockTime()
	{
		return (Integer) getProperty(utsDot3OltTransceiverCDRLockTime)
				.getValue();
	}

	public void setUtsDot3OltTransceiverCDRLockTime(
			Integer aUtsDot3OltTransceiverCDRLockTime)
	{
		getProperty(utsDot3OltTransceiverCDRLockTime).setValue(
				aUtsDot3OltTransceiverCDRLockTime);
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super
				.getProperty(utsDot3OltTransceiverPONPortLinkIndPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetGateOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverAGCResetDiscoveryOffset));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetDuration));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetGateOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverCDRResetDiscoveryOffset));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetDuration));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverEndGrantResetOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverEndGrantResetDuration));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverEndGrantResetPolarity));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverDiscoveryRelockEnable));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverDiscoveryLaserRxLossPolarity));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverPONTxDisablePolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverOpticsDeadZone));
		prepareRead(super.getProperty(utsDot3OltTransceiverUseOpticsSignalLoss));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCLockTime));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRLockTime));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
		prepareRead(super
				.getProperty(utsDot3OltTransceiverPONPortLinkIndPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetGateOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverAGCResetDiscoveryOffset));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetDuration));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCResetPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetGateOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverCDRResetDiscoveryOffset));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetDuration));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRResetPolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverEndGrantResetOffset));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverEndGrantResetDuration));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverEndGrantResetPolarity));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverDiscoveryRelockEnable));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverDiscoveryLaserRxLossPolarity));
		prepareRead(super
				.getProperty(utsDot3OltTransceiverPONTxDisablePolarity));
		prepareRead(super.getProperty(utsDot3OltTransceiverOpticsDeadZone));
		prepareRead(super.getProperty(utsDot3OltTransceiverUseOpticsSignalLoss));
		prepareRead(super.getProperty(utsDot3OltTransceiverAGCLockTime));
		prepareRead(super.getProperty(utsDot3OltTransceiverCDRLockTime));

    setRowsToFetch(4);
		return loadAll(new int[]
		{ 1 });
	}

}
