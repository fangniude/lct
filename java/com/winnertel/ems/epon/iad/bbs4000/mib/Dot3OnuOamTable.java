package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3OnuOamTable class. Created by QuickDVM
 */
public class Dot3OnuOamTable extends SnmpMibBean
{
	public static final String ifOnuIndex = "ifOnuIndex";

	public static final String utsDot3OnuOAMModuleId = "utsDot3OnuOAMModuleId";

	public static final String utsDot3OnuOAMPortId = "utsDot3OnuOAMPortId";

	public static final String utsDot3OnuOAMLogicalPortId = "utsDot3OnuOAMLogicalPortId";

	public static final String utsDot3OnuOAMMode = "utsDot3OnuOAMMode";

	public static final String utsDot3OnuOAMDeviceIdentifier = "utsDot3OnuOAMDeviceIdentifier";

	public static final String utsDot3OnuOAMVersionIdentifier = "utsDot3OnuOAMVersionIdentifier";

	public static final String utsDot3OnuOAMLinktestTotalFrame = "utsDot3OnuOAMLinktestTotalFrame";

	public static final String utsDot3OnuOAMLinktestFrameSize = "utsDot3OnuOAMLinktestFrameSize";

	public static final String utsDot3OnuOAMLinktestDelayMeasureEnable = "utsDot3OnuOAMLinktestDelayMeasureEnable";

	public static final String utsDot3OnuOAMLinktestVLANTagEnable = "utsDot3OnuOAMLinktestVLANTagEnable";

	public static final String utsDot3OnuOAMLinktestVLANTagPriority = "utsDot3OnuOAMLinktestVLANTagPriority";

	public static final String utsDot3OnuOAMLinktestVLANTagVID = "utsDot3OnuOAMLinktestVLANTagVID";

	public static final String utsDot3OnuOAMLinktestFrameSent = "utsDot3OnuOAMLinktestFrameSent";

	public static final String utsDot3OnuOAMLinktestFrameReceived = "utsDot3OnuOAMLinktestFrameReceived";

	public static final String utsDot3OnuOAMLinktestErrFrameReceived = "utsDot3OnuOAMLinktestErrFrameReceived";

	public static final String utsDot3OnuOAMLinktestMinDelay = "utsDot3OnuOAMLinktestMinDelay";

	public static final String utsDot3OnuOAMLinktestMeanDelay = "utsDot3OnuOAMLinktestMeanDelay";

	public static final String utsDot3OnuOAMLinktestMaxDelay = "utsDot3OnuOAMLinktestMaxDelay";

	public static final String utsDot3OnuOAMPingElapsedTime = "utsDot3OnuOAMPingElapsedTime";

	public static final String utsDot3OnuOAMPortState = "utsDot3OnuOAMPortState";

	public static final String utsDot3OnuOAMStartTest = "utsDot3OnuOAMStartTest";

	public static final String utsDot3OnuOAMLinkTestStatus = "utsDot3OnuOAMLinkTestStatus";

	public static final String utsDot3OnuOAMLinkTestStationId = "utsDot3OnuOAMLinkTestStationId";

	public static final String utsDot3OnuOAMLinkTestResultStr = "utsDot3OnuOAMLinkTestResultStr";

	public static final String utsDot3OnuOAMPingStatus = "utsDot3OnuOAMPingStatus";

	public static final String utsDot3OnuOAMPingStationId = "utsDot3OnuOAMPingStationId";

	public static final String utsDot3OnuOAMPingResultStr = "utsDot3OnuOAMPingResultStr";

  private String onuLabel = null;

	public Dot3OnuOamTable(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
				".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMModuleId,
				new SnmpMibBeanProperty(utsDot3OnuOAMModuleId,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMPortId, new SnmpMibBeanProperty(
				utsDot3OnuOAMPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLogicalPortId,
				new SnmpMibBeanProperty(utsDot3OnuOAMLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMMode, new SnmpMibBeanProperty(
				utsDot3OnuOAMMode, ".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMDeviceIdentifier,
				new SnmpMibBeanProperty(utsDot3OnuOAMDeviceIdentifier,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.9",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMVersionIdentifier, new SnmpMibBeanProperty(
				utsDot3OnuOAMVersionIdentifier,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestTotalFrame, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestTotalFrame,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.23",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestFrameSize, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestFrameSize,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.24",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestDelayMeasureEnable,
				new SnmpMibBeanProperty(
						utsDot3OnuOAMLinktestDelayMeasureEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.25",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestVLANTagEnable,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinktestVLANTagEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.26",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestVLANTagPriority,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinktestVLANTagPriority,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.27",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestVLANTagVID, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestVLANTagVID,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.28",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestFrameSent, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestFrameSent,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.29",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestFrameReceived,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinktestFrameReceived,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.30",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestErrFrameReceived,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinktestErrFrameReceived,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.31",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestMinDelay, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestMinDelay,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.32",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestMeanDelay, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestMeanDelay,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.33",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinktestMaxDelay, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinktestMaxDelay,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.34",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMPingElapsedTime, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingElapsedTime,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.36",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMPortState, new SnmpMibBeanProperty(
				utsDot3OnuOAMPortState,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.37",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMStartTest, new SnmpMibBeanProperty(
				utsDot3OnuOAMStartTest,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.38",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinkTestStatus, new SnmpMibBeanProperty(
				utsDot3OnuOAMLinkTestStatus,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.39",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMLinkTestStationId,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinkTestStationId,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.40",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuOAMLinkTestResultStr,
				new SnmpMibBeanProperty(utsDot3OnuOAMLinkTestResultStr,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.41",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuOAMPingStatus, new SnmpMibBeanProperty(
				utsDot3OnuOAMPingStatus,
				".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.42",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuOAMPingStationId,
				new SnmpMibBeanProperty(utsDot3OnuOAMPingStationId,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.43",
						ISnmpConstant.STRING));
		initProperty(utsDot3OnuOAMPingResultStr,
				new SnmpMibBeanProperty(utsDot3OnuOAMPingResultStr,
						".1.3.6.1.4.1.45121.1800.2.3.1.3.1.1.1.44",
						ISnmpConstant.STRING));

	}

	public Integer getIfOnuIndex()
	{
		return (Integer) getIndex(0);
	}

	public void setIfOnuIndex(Integer aIfIndex)
	{
		setIndex(0, aIfIndex);
	}

	public Integer getUtsDot3OnuOAMModuleId()
	{
		return (Integer) getProperty(utsDot3OnuOAMModuleId).getValue();
	}

	public void setUtsDot3OnuOAMModuleId(Integer aUtsDot3OnuOAMModuleId)
	{
		getProperty(utsDot3OnuOAMModuleId).setValue(aUtsDot3OnuOAMModuleId);
	}

	public Integer getUtsDot3OnuOAMPortId()
	{
		return (Integer) getProperty(utsDot3OnuOAMPortId).getValue();
	}

	public void setUtsDot3OnuOAMPortId(Integer aUtsDot3OnuOAMPortId)
	{
		getProperty(utsDot3OnuOAMPortId).setValue(aUtsDot3OnuOAMPortId);
	}

	public Integer getUtsDot3OnuOAMLogicalPortId()
	{
		return (Integer) getProperty(utsDot3OnuOAMLogicalPortId).getValue();
	}

	public void setUtsDot3OnuOAMLogicalPortId(
			Integer aUtsDot3OnuOAMLogicalPortId)
	{
		getProperty(utsDot3OnuOAMLogicalPortId).setValue(
				aUtsDot3OnuOAMLogicalPortId);
	}

	public Integer getUtsDot3OnuOAMMode()
	{
		return (Integer) getProperty(utsDot3OnuOAMMode).getValue();
	}

	public void setUtsDot3OnuOAMMode(Integer aUtsDot3OnuOAMMode)
	{
		getProperty(utsDot3OnuOAMMode).setValue(aUtsDot3OnuOAMMode);
	}

	public Integer getUtsDot3OnuOAMDeviceIdentifier()
	{
		return (Integer) getProperty(utsDot3OnuOAMDeviceIdentifier).getValue();
	}

	public void setUtsDot3OnuOAMDeviceIdentifier(
			Integer aUtsDot3OnuOAMDeviceIdentifier)
	{
		getProperty(utsDot3OnuOAMDeviceIdentifier).setValue(
				aUtsDot3OnuOAMDeviceIdentifier);
	}

	public Integer getUtsDot3OnuOAMVersionIdentifier()
	{
		return (Integer) getProperty(utsDot3OnuOAMVersionIdentifier).getValue();
	}

	public void setUtsDot3OnuOAMVersionIdentifier(
			Integer aUtsDot3OnuOAMVersionIdentifier)
	{
		getProperty(utsDot3OnuOAMVersionIdentifier).setValue(
				aUtsDot3OnuOAMVersionIdentifier);
	}

	public Integer getUtsDot3OnuOAMLinktestTotalFrame()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestTotalFrame)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestTotalFrame(
			Integer aUtsDot3OnuOAMLinktestTotalFrame)
	{
		getProperty(utsDot3OnuOAMLinktestTotalFrame).setValue(
				aUtsDot3OnuOAMLinktestTotalFrame);
	}

	public Integer getUtsDot3OnuOAMLinktestFrameSize()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestFrameSize).getValue();
	}

	public void setUtsDot3OnuOAMLinktestFrameSize(
			Integer aUtsDot3OnuOAMLinktestFrameSize)
	{
		getProperty(utsDot3OnuOAMLinktestFrameSize).setValue(
				aUtsDot3OnuOAMLinktestFrameSize);
	}

	public Integer getUtsDot3OnuOAMLinktestDelayMeasureEnable()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestDelayMeasureEnable)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestDelayMeasureEnable(
			Integer aUtsDot3OnuOAMLinktestDelayMeasureEnable)
	{
		getProperty(utsDot3OnuOAMLinktestDelayMeasureEnable).setValue(
				aUtsDot3OnuOAMLinktestDelayMeasureEnable);
	}

	public Integer getUtsDot3OnuOAMLinktestVLANTagEnable()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestVLANTagEnable)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestVLANTagEnable(
			Integer aUtsDot3OnuOAMLinktestVLANTagEnable)
	{
		getProperty(utsDot3OnuOAMLinktestVLANTagEnable).setValue(
				aUtsDot3OnuOAMLinktestVLANTagEnable);
	}

	public Integer getUtsDot3OnuOAMLinktestVLANTagPriority()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestVLANTagPriority)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestVLANTagPriority(
			Integer aUtsDot3OnuOAMLinktestVLANTagPriority)
	{
		getProperty(utsDot3OnuOAMLinktestVLANTagPriority).setValue(
				aUtsDot3OnuOAMLinktestVLANTagPriority);
	}

	public Integer getUtsDot3OnuOAMLinktestVLANTagVID()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestVLANTagVID)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestVLANTagVID(
			Integer aUtsDot3OnuOAMLinktestVLANTagVID)
	{
		getProperty(utsDot3OnuOAMLinktestVLANTagVID).setValue(
				aUtsDot3OnuOAMLinktestVLANTagVID);
	}

	public Integer getUtsDot3OnuOAMLinktestFrameSent()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestFrameSent).getValue();
	}

	public void setUtsDot3OnuOAMLinktestFrameSent(
			Integer aUtsDot3OnuOAMLinktestFrameSent)
	{
		getProperty(utsDot3OnuOAMLinktestFrameSent).setValue(
				aUtsDot3OnuOAMLinktestFrameSent);
	}

	public Integer getUtsDot3OnuOAMLinktestFrameReceived()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestFrameReceived)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestFrameReceived(
			Integer aUtsDot3OnuOAMLinktestFrameReceived)
	{
		getProperty(utsDot3OnuOAMLinktestFrameReceived).setValue(
				aUtsDot3OnuOAMLinktestFrameReceived);
	}

	public Integer getUtsDot3OnuOAMLinktestErrFrameReceived()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestErrFrameReceived)
				.getValue();
	}

	public void setUtsDot3OnuOAMLinktestErrFrameReceived(
			Integer aUtsDot3OnuOAMLinktestErrFrameReceived)
	{
		getProperty(utsDot3OnuOAMLinktestErrFrameReceived).setValue(
				aUtsDot3OnuOAMLinktestErrFrameReceived);
	}

	public Integer getUtsDot3OnuOAMLinktestMinDelay()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestMinDelay).getValue();
	}

	public void setUtsDot3OnuOAMLinktestMinDelay(
			Integer aUtsDot3OnuOAMLinktestMinDelay)
	{
		getProperty(utsDot3OnuOAMLinktestMinDelay).setValue(
				aUtsDot3OnuOAMLinktestMinDelay);
	}

	public Integer getUtsDot3OnuOAMLinktestMeanDelay()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestMeanDelay).getValue();
	}

	public void setUtsDot3OnuOAMLinktestMeanDelay(
			Integer aUtsDot3OnuOAMLinktestMeanDelay)
	{
		getProperty(utsDot3OnuOAMLinktestMeanDelay).setValue(
				aUtsDot3OnuOAMLinktestMeanDelay);
	}

	public Integer getUtsDot3OnuOAMLinktestMaxDelay()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinktestMaxDelay).getValue();
	}

	public void setUtsDot3OnuOAMLinktestMaxDelay(
			Integer aUtsDot3OnuOAMLinktestMaxDelay)
	{
		getProperty(utsDot3OnuOAMLinktestMaxDelay).setValue(
				aUtsDot3OnuOAMLinktestMaxDelay);
	}

	public Integer getUtsDot3OnuOAMPingElapsedTime()
	{
		return (Integer) getProperty(utsDot3OnuOAMPingElapsedTime).getValue();
	}

	public void setUtsDot3OnuOAMPingElapsedTime(
			Integer aUtsDot3OnuOAMPingElapsedTime)
	{
		getProperty(utsDot3OnuOAMPingElapsedTime).setValue(
				aUtsDot3OnuOAMPingElapsedTime);
	}

	public Integer getUtsDot3OnuOAMPortState()
	{
		return (Integer) getProperty(utsDot3OnuOAMPortState).getValue();
	}

	public void setUtsDot3OnuOAMPortState(Integer aUtsDot3OnuOAMPortState)
	{
		getProperty(utsDot3OnuOAMPortState).setValue(aUtsDot3OnuOAMPortState);
	}

	public Integer getUtsDot3OnuOAMStartTest()
	{
		return (Integer) getProperty(utsDot3OnuOAMStartTest).getValue();
	}

	public void setUtsDot3OnuOAMStartTest(Integer aUtsDot3OnuOAMStartTest)
	{
		getProperty(utsDot3OnuOAMStartTest).setValue(aUtsDot3OnuOAMStartTest);
	}

	public Integer getUtsDot3OnuOAMLinkTestStatus()
	{
		return (Integer) getProperty(utsDot3OnuOAMLinkTestStatus).getValue();
	}

	public void setUtsDot3OnuOAMLinkTestStatus(
			Integer aUtsDot3OnuOAMLinkTestStatus)
	{
		getProperty(utsDot3OnuOAMLinkTestStatus).setValue(
				aUtsDot3OnuOAMLinkTestStatus);
	}

	public String getUtsDot3OnuOAMLinkTestStationId()
	{
		return (String) getProperty(utsDot3OnuOAMLinkTestStationId).getValue();
	}

	public void setUtsDot3OnuOAMLinkTestStationId(
			String aUtsDot3OnuOAMLinkTestStationId)
	{
		getProperty(utsDot3OnuOAMLinkTestStationId).setValue(
				aUtsDot3OnuOAMLinkTestStationId);
	}

	public String getUtsDot3OnuOAMLinkTestResultStr()
	{
		return (String) getProperty(utsDot3OnuOAMLinkTestResultStr).getValue();
	}

	public void setUtsDot3OnuOAMLinkTestResultStr(
			String aUtsDot3OnuOAMLinkTestResultStr)
	{
		getProperty(utsDot3OnuOAMLinkTestResultStr).setValue(
				aUtsDot3OnuOAMLinkTestResultStr);
	}

	public Integer getUtsDot3OnuOAMPingStatus()
	{
		return (Integer) getProperty(utsDot3OnuOAMPingStatus).getValue();
	}

	public void setUtsDot3OnuOAMPingStatus(Integer aUtsDot3OnuOAMPingStatus)
	{
		getProperty(utsDot3OnuOAMPingStatus).setValue(aUtsDot3OnuOAMPingStatus);
	}

	public String getUtsDot3OnuOAMPingStationId()
	{
		return (String) getProperty(utsDot3OnuOAMPingStationId).getValue();
	}

	public void setUtsDot3OnuOAMPingStationId(String aUtsDot3OnuOAMPingStationId)
	{
		getProperty(utsDot3OnuOAMPingStationId).setValue(
				aUtsDot3OnuOAMPingStationId);
	}

	public String getUtsDot3OnuOAMPingResultStr()
	{
		return (String) getProperty(utsDot3OnuOAMPingResultStr).getValue();
	}

	public void setUtsDot3OnuOAMPingResultStr(String aUtsDot3OnuOAMPingResultStr)
	{
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

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsDot3OnuOAMModuleId));
		prepareRead(super.getProperty(utsDot3OnuOAMPortId));
		prepareRead(super.getProperty(utsDot3OnuOAMLogicalPortId));
		prepareRead(super.getProperty(utsDot3OnuOAMMode));
		prepareRead(super.getProperty(utsDot3OnuOAMDeviceIdentifier));
		prepareRead(super.getProperty(utsDot3OnuOAMVersionIdentifier));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestTotalFrame));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameSize));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestDelayMeasureEnable));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagEnable));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagPriority));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagVID));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameSent));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameReceived));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestErrFrameReceived));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMinDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMeanDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMaxDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMPingElapsedTime));
		prepareRead(super.getProperty(utsDot3OnuOAMPortState));
		prepareRead(super.getProperty(utsDot3OnuOAMStartTest));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestStatus));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestStationId));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestResultStr));
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
//        String ifIndex = getUtsDot3OnuOAMModuleId() + "/" + getUtsDot3OnuOAMPortId() + "/" + getUtsDot3OnuOAMLogicalPortId();
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
		prepareRead(super.getProperty(utsDot3OnuOAMModuleId));
		prepareRead(super.getProperty(utsDot3OnuOAMPortId));
		prepareRead(super.getProperty(utsDot3OnuOAMLogicalPortId));
		prepareRead(super.getProperty(utsDot3OnuOAMMode));
		prepareRead(super.getProperty(utsDot3OnuOAMDeviceIdentifier));
		prepareRead(super.getProperty(utsDot3OnuOAMVersionIdentifier));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestTotalFrame));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameSize));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestDelayMeasureEnable));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagEnable));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagPriority));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestVLANTagVID));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameSent));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestFrameReceived));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestErrFrameReceived));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMinDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMeanDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMLinktestMaxDelay));
		prepareRead(super.getProperty(utsDot3OnuOAMPingElapsedTime));
		prepareRead(super.getProperty(utsDot3OnuOAMPortState));
		prepareRead(super.getProperty(utsDot3OnuOAMStartTest));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestStatus));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestStationId));
		prepareRead(super.getProperty(utsDot3OnuOAMLinkTestResultStr));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStatus));
		prepareRead(super.getProperty(utsDot3OnuOAMPingStationId));
		prepareRead(super.getProperty(utsDot3OnuOAMPingResultStr));

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
//          Dot3OnuOamTable bean = (Dot3OnuOamTable)v.get(i);
//
//          String key = neName + bean.getUtsDot3OnuOAMModuleId() + "/" + bean.getUtsDot3OnuOAMPortId() + "/" + bean.getUtsDot3OnuOAMLogicalPortId();
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
		prepareSave(getProperty(utsDot3OnuOAMLinktestTotalFrame));
		prepareSave(getProperty(utsDot3OnuOAMLinktestFrameSize));
		prepareSave(getProperty(utsDot3OnuOAMStartTest));
		prepareSave(getProperty(utsDot3OnuOAMLinkTestStationId));
		prepareSave(getProperty(utsDot3OnuOAMPingStationId));

		return save();
	}

}
