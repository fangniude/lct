package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2PrivateUniOamTable class. Created by QuickDVM
 */
public class Dot3Onu2PrivateUniOamTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	public static final String utsDot3Onu2PrivateUniSchedulingScheme = "utsDot3Onu2PrivateUniSchedulingScheme";
	public static final String utsDot3Onu2PrivateUniWeight0 = "utsDot3Onu2PrivateUniWeight0";
	public static final String utsDot3Onu2PrivateUniWeight1 = "utsDot3Onu2PrivateUniWeight1";
	public static final String utsDot3Onu2PrivateUniWeight2 = "utsDot3Onu2PrivateUniWeight2";
	public static final String utsDot3Onu2PrivateUniWeight3 = "utsDot3Onu2PrivateUniWeight3";
	public static final String utsDot3Onu2PrivateUniWeight4 = "utsDot3Onu2PrivateUniWeight4";
	public static final String utsDot3Onu2PrivateUniWeight5 = "utsDot3Onu2PrivateUniWeight5";
	public static final String utsDot3Onu2PrivateUniWeight6 = "utsDot3Onu2PrivateUniWeight6";
	public static final String utsDot3Onu2PrivateUniWeight7 = "utsDot3Onu2PrivateUniWeight7";
	public static final String utsDot3Onu2PrivateUniCos0 = "utsDot3Onu2PrivateUniCos0";
	public static final String utsDot3Onu2PrivateUniCos1 = "utsDot3Onu2PrivateUniCos1";
	public static final String utsDot3Onu2PrivateUniCos2 = "utsDot3Onu2PrivateUniCos2";
	public static final String utsDot3Onu2PrivateUniCos3 = "utsDot3Onu2PrivateUniCos3";
	public static final String utsDot3Onu2PrivateUniCos4 = "utsDot3Onu2PrivateUniCos4";
	public static final String utsDot3Onu2PrivateUniCos5 = "utsDot3Onu2PrivateUniCos5";
	public static final String utsDot3Onu2PrivateUniCos6 = "utsDot3Onu2PrivateUniCos6";
	public static final String utsDot3Onu2PrivateUniCos7 = "utsDot3Onu2PrivateUniCos7";
	public static final String utsDot3Onu2PrivateUniStormControl = "utsDot3Onu2PrivateUniStormControl";
	public static final String utsDot3Onu2PrivateUniBcRate = "utsDot3Onu2PrivateUniBcRate";
	public static final String utsDot3Onu2PrivateUniMcRate = "utsDot3Onu2PrivateUniMcRate";
	public static final String utsDot3Onu2PrivateUniDlfRate = "utsDot3Onu2PrivateUniDlfRate";
//	public static final String utsDot3Onu2PrivateUniIsolate = "utsDot3Onu2PrivateUniIsolate";
	public static final String utsDot3Onu2PrivateUniSpeed = "utsDot3Onu2PrivateUniSpeed";
	public static final String utsDot3Onu2PrivateUniDuplex = "utsDot3Onu2PrivateUniDuplex";

	public Dot3Onu2PrivateUniOamTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2Ctc3UniModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.56.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.56.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.56.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniLogicalPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.56.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPhyPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPhyPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.56.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniSchedulingScheme,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniSchedulingScheme,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight0, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight0,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight1, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight1,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight2, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight2,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight3, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight3,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight4, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight4,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.6",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight5, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight5,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.7",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight6, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight6,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.8",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniWeight7, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniWeight7,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.9",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos0, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos0,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.10",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos1, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos1,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.11",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos2, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos2,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.12",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos3, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos3,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.13",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos4, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos4,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.14",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos5, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos5,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.15",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos6, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos6,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.16",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniCos7, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniCos7,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.17",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniStormControl,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniStormControl,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.18",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniBcRate, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniBcRate,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.19",
				ISnmpConstant.GAUGE));
		initProperty(utsDot3Onu2PrivateUniMcRate, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniMcRate,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.20",
				ISnmpConstant.GAUGE));
		initProperty(utsDot3Onu2PrivateUniDlfRate, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniDlfRate,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.21",
				ISnmpConstant.GAUGE));
//		initProperty(utsDot3Onu2PrivateUniIsolate, new SnmpMibBeanProperty(
//				utsDot3Onu2PrivateUniIsolate,
//				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.22",
//				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniSpeed, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniSpeed,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.22",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniDuplex, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateUniDuplex,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.102.1.23",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2Ctc3UniModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2Ctc3UniModuleId(
			Integer aUtsDot3Onu2Ctc3UniModuleId) {
		setIndex(0, aUtsDot3Onu2Ctc3UniModuleId);
	}

	public Integer getUtsDot3Onu2Ctc3UniDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2Ctc3UniDeviceId(
			Integer aUtsDot3Onu2Ctc3UniDeviceId) {
		setIndex(1, aUtsDot3Onu2Ctc3UniDeviceId);
	}

	public Integer getUtsDot3Onu2Ctc3UniPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2Ctc3UniPortId(Integer aUtsDot3Onu2Ctc3UniPortId) {
		setIndex(2, aUtsDot3Onu2Ctc3UniPortId);
	}

	public Integer getUtsDot3Onu2Ctc3UniLogicalPortId() {
		return (Integer) getIndex(3);
	}

	public void setUtsDot3Onu2Ctc3UniLogicalPortId(
			Integer aUtsDot3Onu2Ctc3UniLogicalPortId) {
		setIndex(3, aUtsDot3Onu2Ctc3UniLogicalPortId);
	}

	public Integer getUtsDot3Onu2Ctc3UniPhyPortId() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3Onu2Ctc3UniPhyPortId(
			Integer aUtsDot3Onu2Ctc3UniPhyPortId) {
		setIndex(4, aUtsDot3Onu2Ctc3UniPhyPortId);
	}

	public Integer getUtsDot3Onu2PrivateUniSchedulingScheme() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniSchedulingScheme)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniSchedulingScheme(
			Integer aUtsDot3Onu2PrivateUniSchedulingScheme) {
		getProperty(utsDot3Onu2PrivateUniSchedulingScheme).setValue(
				aUtsDot3Onu2PrivateUniSchedulingScheme);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight0() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight0).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight0(
			Integer aUtsDot3Onu2PrivateUniWeight0) {
		getProperty(utsDot3Onu2PrivateUniWeight0).setValue(
				aUtsDot3Onu2PrivateUniWeight0);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight1() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight1).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight1(
			Integer aUtsDot3Onu2PrivateUniWeight1) {
		getProperty(utsDot3Onu2PrivateUniWeight1).setValue(
				aUtsDot3Onu2PrivateUniWeight1);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight2() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight2).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight2(
			Integer aUtsDot3Onu2PrivateUniWeight2) {
		getProperty(utsDot3Onu2PrivateUniWeight2).setValue(
				aUtsDot3Onu2PrivateUniWeight2);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight3() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight3).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight3(
			Integer aUtsDot3Onu2PrivateUniWeight3) {
		getProperty(utsDot3Onu2PrivateUniWeight3).setValue(
				aUtsDot3Onu2PrivateUniWeight3);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight4() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight4).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight4(
			Integer aUtsDot3Onu2PrivateUniWeight4) {
		getProperty(utsDot3Onu2PrivateUniWeight4).setValue(
				aUtsDot3Onu2PrivateUniWeight4);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight5() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight5).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight5(
			Integer aUtsDot3Onu2PrivateUniWeight5) {
		getProperty(utsDot3Onu2PrivateUniWeight5).setValue(
				aUtsDot3Onu2PrivateUniWeight5);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight6() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight6).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight6(
			Integer aUtsDot3Onu2PrivateUniWeight6) {
		getProperty(utsDot3Onu2PrivateUniWeight6).setValue(
				aUtsDot3Onu2PrivateUniWeight6);
	}

	public Integer getUtsDot3Onu2PrivateUniWeight7() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniWeight7).getValue();
	}

	public void setUtsDot3Onu2PrivateUniWeight7(
			Integer aUtsDot3Onu2PrivateUniWeight7) {
		getProperty(utsDot3Onu2PrivateUniWeight7).setValue(
				aUtsDot3Onu2PrivateUniWeight7);
	}

	public Integer getUtsDot3Onu2PrivateUniCos0() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos0).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos0(Integer aUtsDot3Onu2PrivateUniCos0) {
		getProperty(utsDot3Onu2PrivateUniCos0).setValue(
				aUtsDot3Onu2PrivateUniCos0);
	}

	public Integer getUtsDot3Onu2PrivateUniCos1() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos1).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos1(Integer aUtsDot3Onu2PrivateUniCos1) {
		getProperty(utsDot3Onu2PrivateUniCos1).setValue(
				aUtsDot3Onu2PrivateUniCos1);
	}

	public Integer getUtsDot3Onu2PrivateUniCos2() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos2).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos2(Integer aUtsDot3Onu2PrivateUniCos2) {
		getProperty(utsDot3Onu2PrivateUniCos2).setValue(
				aUtsDot3Onu2PrivateUniCos2);
	}

	public Integer getUtsDot3Onu2PrivateUniCos3() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos3).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos3(Integer aUtsDot3Onu2PrivateUniCos3) {
		getProperty(utsDot3Onu2PrivateUniCos3).setValue(
				aUtsDot3Onu2PrivateUniCos3);
	}

	public Integer getUtsDot3Onu2PrivateUniCos4() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos4).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos4(Integer aUtsDot3Onu2PrivateUniCos4) {
		getProperty(utsDot3Onu2PrivateUniCos4).setValue(
				aUtsDot3Onu2PrivateUniCos4);
	}

	public Integer getUtsDot3Onu2PrivateUniCos5() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos5).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos5(Integer aUtsDot3Onu2PrivateUniCos5) {
		getProperty(utsDot3Onu2PrivateUniCos5).setValue(
				aUtsDot3Onu2PrivateUniCos5);
	}

	public Integer getUtsDot3Onu2PrivateUniCos6() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos6).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos6(Integer aUtsDot3Onu2PrivateUniCos6) {
		getProperty(utsDot3Onu2PrivateUniCos6).setValue(
				aUtsDot3Onu2PrivateUniCos6);
	}

	public Integer getUtsDot3Onu2PrivateUniCos7() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniCos7).getValue();
	}

	public void setUtsDot3Onu2PrivateUniCos7(Integer aUtsDot3Onu2PrivateUniCos7) {
		getProperty(utsDot3Onu2PrivateUniCos7).setValue(
				aUtsDot3Onu2PrivateUniCos7);
	}

	public Integer getUtsDot3Onu2PrivateUniStormControl() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniStormControl)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateUniStormControl(
			Integer aUtsDot3Onu2PrivateUniStormControl) {
		getProperty(utsDot3Onu2PrivateUniStormControl).setValue(
				aUtsDot3Onu2PrivateUniStormControl);
	}

	public Long getUtsDot3Onu2PrivateUniBcRate() {
		return (Long) getProperty(utsDot3Onu2PrivateUniBcRate).getValue();
	}

	public void setUtsDot3Onu2PrivateUniBcRate(
			Long aUtsDot3Onu2PrivateUniBcRate) {
		getProperty(utsDot3Onu2PrivateUniBcRate).setValue(
				aUtsDot3Onu2PrivateUniBcRate);
	}

	public Long getUtsDot3Onu2PrivateUniMcRate() {
		return (Long) getProperty(utsDot3Onu2PrivateUniMcRate).getValue();
	}

	public void setUtsDot3Onu2PrivateUniMcRate(
			Long aUtsDot3Onu2PrivateUniMcRate) {
		getProperty(utsDot3Onu2PrivateUniMcRate).setValue(
				aUtsDot3Onu2PrivateUniMcRate);
	}

	public Long getUtsDot3Onu2PrivateUniDlfRate() {
		return (Long) getProperty(utsDot3Onu2PrivateUniDlfRate).getValue();
	}

	public void setUtsDot3Onu2PrivateUniDlfRate(
			Long aUtsDot3Onu2PrivateUniDlfRate) {
		getProperty(utsDot3Onu2PrivateUniDlfRate).setValue(
				aUtsDot3Onu2PrivateUniDlfRate);
	}
	
	

//	public Integer getUtsDot3Onu2PrivateUniIsolate() {
//		return (Integer) getProperty(utsDot3Onu2PrivateUniIsolate).getValue();
//	}

//	public void setUtsDot3Onu2PrivateUniIsolate(
//			Integer aUtsDot3Onu2PrivateUniIsolate) {
//		getProperty(utsDot3Onu2PrivateUniIsolate).setValue(
//				aUtsDot3Onu2PrivateUniIsolate);
//	}

	public Integer getUtsDot3Onu2PrivateUniSpeed() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniSpeed).getValue();
	}
	
	public void setUtsDot3Onu2PrivateUniSpeed(
			Integer aUtsDot3Onu2PrivateUniSpeed) {
		getProperty(utsDot3Onu2PrivateUniSpeed).setValue(
				aUtsDot3Onu2PrivateUniSpeed);
	}

	public Integer getUtsDot3Onu2PrivateUniDuplex() {
		return (Integer) getProperty(utsDot3Onu2PrivateUniDuplex).getValue();
	}
	
	public void setUtsDot3Onu2PrivateUniDuplex(
			Integer aUtsDot3Onu2PrivateUniDuplex) {
		getProperty(utsDot3Onu2PrivateUniDuplex).setValue(
				aUtsDot3Onu2PrivateUniDuplex);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniSchedulingScheme));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniStormControl));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniBcRate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniMcRate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDlfRate));
//		prepareRead(super.getProperty(utsDot3Onu2PrivateUniIsolate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniSpeed));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDuplex));
		
		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniSchedulingScheme));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniWeight7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos0));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos1));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos2));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos3));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos4));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos5));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos6));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniCos7));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniStormControl));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniBcRate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniMcRate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDlfRate));
//		prepareRead(super.getProperty(utsDot3Onu2PrivateUniIsolate));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniSpeed));
		prepareRead(super.getProperty(utsDot3Onu2PrivateUniDuplex));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2PrivateUniSchedulingScheme));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight0));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight1));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight2));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight3));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight4));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight5));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight6));
		prepareSave(getProperty(utsDot3Onu2PrivateUniWeight7));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos0));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos1));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos2));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos3));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos4));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos5));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos6));
		prepareSave(getProperty(utsDot3Onu2PrivateUniCos7));
		prepareSave(getProperty(utsDot3Onu2PrivateUniStormControl));
		prepareSave(getProperty(utsDot3Onu2PrivateUniBcRate));
		prepareSave(getProperty(utsDot3Onu2PrivateUniMcRate));
		prepareSave(getProperty(utsDot3Onu2PrivateUniDlfRate));
//		prepareSave(getProperty(utsDot3Onu2PrivateUniIsolate));
		prepareSave(getProperty(utsDot3Onu2PrivateUniSpeed));
		prepareSave(getProperty(utsDot3Onu2PrivateUniDuplex));

		return save();
	}

}
