/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2QoSTable class. Created by QuickDVM
 */
public class Dot3Onu2QoSTable extends SnmpMibBean {
	public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
	public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
	public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
	public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
//  public static final String utsDot3OnuUpsPolicingAction = "utsDot3OnuUpsPolicingAction";
//  public static final String utsDot3OnuDownsPolicingAction = "utsDot3OnuDownsPolicingAction";
	public static final String utsDot3OnuQoSMode = "utsDot3OnuQoSMode";
	public static final String utsDot3OnuAclClassifiEnable = "utsDot3OnuAclClassifiEnable";
	public static final String utsDot3OnuSchedulingMode = "utsDot3OnuSchedulingMode";
	public static final String utsDot3OltSchedulingWeightRatio = "utsDot3OltSchedulingWeightRatio";
	public static final String utsDot3OnuDot1p2QueueMap = "utsDot3OnuDot1p2QueueMap";
	public static final String utsDot3OnuDscp2QueueMap = "utsDot3OnuDscp2QueueMap";
	public static final String utsDot3OnuDefault802Dot1p = "utsDot3OnuDefault802Dot1p";
	public static final String utsDot3OnuDefaultDscp = "utsDot3OnuDefaultDscp";
	public static final String utsDot3OnuDefaultQueue = "utsDot3OnuDefaultQueue";
	// public static final String utsDot3OnuShaperAction =
	// "utsDot3OnuShaperAction";
	public static final String utsDot3Onu2CtcUpsQueueNum = "utsDot3Onu2CtcUpsQueueNum";
	public static final String utsDot3Onu2CtcMaxUpsQueueNum = "utsDot3Onu2CtcMaxUpsQueueNum";
	public static final String utsDot3Onu2CtcDownsQueueNum = "utsDot3Onu2CtcDownsQueueNum";
	public static final String utsDot3Onu2CtcMaxDownsQueueNum = "utsDot3Onu2CtcMaxDownsQueueNum";

	public Dot3Onu2QoSTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId,
				new SnmpMibBeanProperty(utsDot3OnuLogicalPortId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuQoSMode, new SnmpMibBeanProperty(
				utsDot3OnuQoSMode, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuAclClassifiEnable,
				new SnmpMibBeanProperty(utsDot3OnuAclClassifiEnable,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.6",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuSchedulingMode,
				new SnmpMibBeanProperty(utsDot3OnuSchedulingMode,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.7",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltSchedulingWeightRatio,
				new SnmpMibBeanProperty(utsDot3OltSchedulingWeightRatio,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.8",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDot1p2QueueMap, new SnmpMibBeanProperty(
				utsDot3OnuDot1p2QueueMap,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.9", ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuDscp2QueueMap,
				new SnmpMibBeanProperty(utsDot3OnuDscp2QueueMap,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.10",
						ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuDefault802Dot1p, new SnmpMibBeanProperty(
				utsDot3OnuDefault802Dot1p,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDefaultDscp, new SnmpMibBeanProperty(
				utsDot3OnuDefaultDscp,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDefaultQueue, new SnmpMibBeanProperty(
				utsDot3OnuDefaultQueue,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.13",
				ISnmpConstant.INTEGER));
		// initProperty(utsDot3OnuShaperAction, new
		// SnmpMibBeanProperty(utsDot3OnuShaperAction,
		// ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.14", ISnmpConstant.INTEGER));
//		initProperty(utsDot3OnuUpsPolicingAction, new SnmpMibBeanProperty(
//				utsDot3OnuUpsPolicingAction,
//				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.16",
//				ISnmpConstant.INTEGER));
//		initProperty(utsDot3OnuDownsPolicingAction, new SnmpMibBeanProperty(
//				utsDot3OnuDownsPolicingAction,
//				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.3.1.17",
//				ISnmpConstant.INTEGER));

		initProperty(utsDot3Onu2CtcUpsQueueNum, new SnmpMibBeanProperty(
				utsDot3Onu2CtcUpsQueueNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.19",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcMaxUpsQueueNum, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMaxUpsQueueNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.20",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcDownsQueueNum, new SnmpMibBeanProperty(
				utsDot3Onu2CtcDownsQueueNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.21",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcMaxDownsQueueNum, new SnmpMibBeanProperty(
				utsDot3Onu2CtcMaxDownsQueueNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.10.1.22",
				ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OnuModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OnuModuleId(Integer aUtsDot3OnuModuleId) {
		setIndex(0, aUtsDot3OnuModuleId);
	}

	public Integer getUtsDot3OnuDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OnuDeviceId(Integer aUtsDot3DeviceId) {
		setIndex(1, aUtsDot3DeviceId);
	}

	public Integer getUtsDot3OnuPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OnuPortId(Integer aUtsDot3OnuPortId) {
		setIndex(2, aUtsDot3OnuPortId);
	}

	public Integer getUtsDot3OnuLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3OnuLogicalPortId(Integer aUtsDot3OnuLogicalPortId) {
		setIndex(3, aUtsDot3OnuLogicalPortId);
	}

	public Integer getUtsDot3OnuQoSMode() {
		return (Integer) getProperty(utsDot3OnuQoSMode).getValue();
	}

	public void setUtsDot3OnuQoSMode(Integer aUtsDot3OnuQoSMode) {
		getProperty(utsDot3OnuQoSMode).setValue(aUtsDot3OnuQoSMode);
	}

	public Integer getUtsDot3OnuAclClassifiEnable() {
		return (Integer) getProperty(utsDot3OnuAclClassifiEnable).getValue();
	}

	public void setUtsDot3OnuAclClassifiEnable(
			Integer aUtsDot3OnuAclClassifiEnable) {
		getProperty(utsDot3OnuAclClassifiEnable).setValue(
				aUtsDot3OnuAclClassifiEnable);
	}

	public Integer getUtsDot3OnuSchedulingMode() {
		return (Integer) getProperty(utsDot3OnuSchedulingMode).getValue();
	}

	public void setUtsDot3OnuSchedulingMode(Integer aUtsDot3OnuSchedulingMode) {
		getProperty(utsDot3OnuSchedulingMode).setValue(
				aUtsDot3OnuSchedulingMode);
	}

	public Integer getUtsDot3OltSchedulingWeightRatio() {
		return (Integer) getProperty(utsDot3OltSchedulingWeightRatio)
				.getValue();
	}

	public void setUtsDot3OltSchedulingWeightRatio(
			Integer aUtsDot3OltSchedulingWeightRatio) {
		getProperty(utsDot3OltSchedulingWeightRatio).setValue(
				aUtsDot3OltSchedulingWeightRatio);
	}

	public byte[] getUtsDot3OnuDot1p2QueueMap() {
		return (byte[]) getProperty(utsDot3OnuDot1p2QueueMap).getValue();
	}

	public void setUtsDot3OnuDot1p2QueueMap(byte[] aUtsDot3OnuDot1p2QueueMap) {
		getProperty(utsDot3OnuDot1p2QueueMap).setValue(
				aUtsDot3OnuDot1p2QueueMap);
	}

	public byte[] getUtsDot3OnuDscp2QueueMap() {
		return (byte[]) getProperty(utsDot3OnuDscp2QueueMap).getValue();
	}

	public void setUtsDot3OnuDscp2QueueMap(byte[] aUtsDot3OnuDscp2QueueMap) {
		getProperty(utsDot3OnuDscp2QueueMap).setValue(aUtsDot3OnuDscp2QueueMap);
	}

	public Integer getUtsDot3OnuDefault802Dot1p() {
		return (Integer) getProperty(utsDot3OnuDefault802Dot1p).getValue();
	}

	public void setUtsDot3OnuDefault802Dot1p(Integer aUtsDot3OnuDefault802Dot1p) {
		getProperty(utsDot3OnuDefault802Dot1p).setValue(
				aUtsDot3OnuDefault802Dot1p);
	}

	public Integer getUtsDot3OnuDefaultDscp() {
		return (Integer) getProperty(utsDot3OnuDefaultDscp).getValue();
	}

	public void setUtsDot3OnuDefaultDscp(Integer aUtsDot3OnuDefaultDscp) {
		getProperty(utsDot3OnuDefaultDscp).setValue(aUtsDot3OnuDefaultDscp);
	}

	public Integer getUtsDot3OnuDefaultQueue() {
		return (Integer) getProperty(utsDot3OnuDefaultQueue).getValue();
	}

	public void setUtsDot3OnuDefaultQueue(Integer aUtsDot3OnuDefaultQueue) {
		getProperty(utsDot3OnuDefaultQueue).setValue(aUtsDot3OnuDefaultQueue);
	}

	// public Integer getUtsDot3OnuShaperAction() {
	// return (Integer) getProperty(utsDot3OnuShaperAction).getValue();
	// }
	//
	// public void setUtsDot3OnuShaperAction(Integer aUtsDot3OnuShaperAction) {
	// getProperty(utsDot3OnuShaperAction).setValue(aUtsDot3OnuShaperAction);
	// }

//	public Integer getUtsDot3OnuUpsPolicingAction() {
//		return (Integer) getProperty(utsDot3OnuUpsPolicingAction).getValue();
//	}
//
//	public void setUtsDot3OnuUpsPolicingAction(
//			Integer aUtsDot3OnuUpsPolicingAction) {
//		getProperty(utsDot3OnuUpsPolicingAction).setValue(
//				aUtsDot3OnuUpsPolicingAction);
//	}
//
//	public Integer getUtsDot3OnuDownsPolicingAction() {
//		return (Integer) getProperty(utsDot3OnuDownsPolicingAction).getValue();
//	}
//
//	public void setUtsDot3OnuDownsPolicingAction(
//			Integer aUtsDot3OnuDownsPolicingAction) {
//		getProperty(utsDot3OnuDownsPolicingAction).setValue(
//				aUtsDot3OnuDownsPolicingAction);
//	}
//
	public Integer getUtsDot3Onu2CtcUpsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CtcUpsQueueNum).getValue();
	}

	public void setUtsDot3Onu2CtcUpsQueueNum(Integer aUtsDot3Onu2CtcUpsQueueNum) {
		getProperty(utsDot3Onu2CtcUpsQueueNum).setValue(
				aUtsDot3Onu2CtcUpsQueueNum);
	}

	public Integer getUtsDot3Onu2CtcMaxUpsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CtcMaxUpsQueueNum).getValue();
	}

	public void setUtsDot3Onu2CtcMaxUpsQueueNum(
			Integer aUtsDot3Onu2CtcMaxUpsQueueNum) {
		getProperty(utsDot3Onu2CtcMaxUpsQueueNum).setValue(
				aUtsDot3Onu2CtcMaxUpsQueueNum);
	}

	public Integer getUtsDot3Onu2CtcDownsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CtcDownsQueueNum).getValue();
	}

	public void setUtsDot3Onu2CtcDownsQueueNum(
			Integer aUtsDot3Onu2CtcDownsQueueNum) {
		getProperty(utsDot3Onu2CtcDownsQueueNum).setValue(
				aUtsDot3Onu2CtcDownsQueueNum);
	}

	public Integer getUtsDot3Onu2CtcMaxDownsQueueNum() {
		return (Integer) getProperty(utsDot3Onu2CtcMaxDownsQueueNum).getValue();
	}

	public void setUtsDot3Onu2CtcMaxDownsQueueNum(
			Integer aUtsDot3Onu2CtcMaxDownsQueueNum) {
		getProperty(utsDot3Onu2CtcMaxDownsQueueNum).setValue(
				aUtsDot3Onu2CtcMaxDownsQueueNum);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuQoSMode));
		prepareRead(super.getProperty(utsDot3OnuAclClassifiEnable));
		prepareRead(super.getProperty(utsDot3OnuSchedulingMode));
		prepareRead(super.getProperty(utsDot3OltSchedulingWeightRatio));
		prepareRead(super.getProperty(utsDot3OnuDot1p2QueueMap));
		prepareRead(super.getProperty(utsDot3OnuDscp2QueueMap));
		prepareRead(super.getProperty(utsDot3OnuDefault802Dot1p));
		prepareRead(super.getProperty(utsDot3OnuDefaultDscp));
		prepareRead(super.getProperty(utsDot3OnuDefaultQueue));
		// prepareRead(super.getProperty(utsDot3OnuShaperAction));
//		prepareRead(super.getProperty(utsDot3OnuUpsPolicingAction));
//		prepareRead(super.getProperty(utsDot3OnuDownsPolicingAction));
		
    prepareRead(super.getProperty(utsDot3Onu2CtcUpsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcMaxUpsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcDownsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcMaxDownsQueueNum));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuQoSMode));
		prepareRead(super.getProperty(utsDot3OnuAclClassifiEnable));
		prepareRead(super.getProperty(utsDot3OnuSchedulingMode));
		prepareRead(super.getProperty(utsDot3OltSchedulingWeightRatio));
		prepareRead(super.getProperty(utsDot3OnuDot1p2QueueMap));
		prepareRead(super.getProperty(utsDot3OnuDscp2QueueMap));
		prepareRead(super.getProperty(utsDot3OnuDefault802Dot1p));
		prepareRead(super.getProperty(utsDot3OnuDefaultDscp));
		prepareRead(super.getProperty(utsDot3OnuDefaultQueue));
		// prepareRead(super.getProperty(utsDot3OnuShaperAction));
//		prepareRead(super.getProperty(utsDot3OnuUpsPolicingAction));
//		prepareRead(super.getProperty(utsDot3OnuDownsPolicingAction));
		
    prepareRead(super.getProperty(utsDot3Onu2CtcUpsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcMaxUpsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcDownsQueueNum));
    prepareRead(super.getProperty(utsDot3Onu2CtcMaxDownsQueueNum));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OnuQoSMode));
		// prepareSave(getProperty(utsDot3OnuAclClassifiEnable));
		prepareSave(getProperty(utsDot3OnuSchedulingMode));
		prepareSave(getProperty(utsDot3OltSchedulingWeightRatio));
		prepareSave(getProperty(utsDot3OnuDot1p2QueueMap));
		prepareSave(getProperty(utsDot3OnuDscp2QueueMap));
		prepareSave(getProperty(utsDot3OnuDefault802Dot1p));
		prepareSave(getProperty(utsDot3OnuDefaultDscp));
		prepareSave(getProperty(utsDot3OnuDefaultQueue));
		// prepareSave(getProperty(utsDot3OnuShaperAction));
//		prepareSave(getProperty(utsDot3OnuUpsPolicingAction));
//		prepareSave(getProperty(utsDot3OnuDownsPolicingAction));

		return save();
	}

}
