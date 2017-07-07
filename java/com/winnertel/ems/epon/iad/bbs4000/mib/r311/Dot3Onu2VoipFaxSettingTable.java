package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2VoipFaxSettingTable class. Created by QuickDVM
 */
public class Dot3Onu2VoipFaxSettingTable extends SnmpMibBean {
	public static final String utsDot3Onu2CtcCombinedFeaturesModuleId = "utsDot3Onu2CtcCombinedFeaturesModuleId";
	public static final String utsDot3Onu2CtcCombinedFeaturesDeviceId = "utsDot3Onu2CtcCombinedFeaturesDeviceId";
	public static final String utsDot3Onu2CtcCombinedFeaturesPortId = "utsDot3Onu2CtcCombinedFeaturesPortId";
	public static final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = "utsDot3Onu2CtcCombinedFeaturesLogicalPortId";
	
	public static final String utsDot3Onu2CtcFaxmodemCfgT38Mode = "utsDot3Onu2CtcFaxmodemCfgT38Mode";
	public static final String utsDot3Onu2CtcFaxmodemCfgCtrl = "utsDot3Onu2CtcFaxmodemCfgCtrl";

	public Dot3Onu2VoipFaxSettingTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2CtcCombinedFeaturesModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesModuleId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesDeviceId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcCombinedFeaturesLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2CtcCombinedFeaturesLogicalPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.4",
				ISnmpConstant.INTEGER));
		
		initProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode, new SnmpMibBeanProperty(
				utsDot3Onu2CtcFaxmodemCfgT38Mode,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.301",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2CtcFaxmodemCfgCtrl, new SnmpMibBeanProperty(
				utsDot3Onu2CtcFaxmodemCfgCtrl,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.34.1.302",
				ISnmpConstant.INTEGER));

	}
	
	public Integer getUtsDot3Onu2CtcCombinedFeaturesModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesModuleId(Integer aUtsDot3Onu2CtcCombinedFeaturesModuleId) {
		setIndex(0, aUtsDot3Onu2CtcCombinedFeaturesModuleId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesDeviceId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesDeviceId(Integer aUtsDot3Onu2CtcCombinedFeaturesDeviceId) {
		setIndex(1, aUtsDot3Onu2CtcCombinedFeaturesDeviceId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3Onu2CtcCombinedFeaturesPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesPortId) {
		setIndex(2, aUtsDot3Onu2CtcCombinedFeaturesPortId);
	}

	public Integer getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId() {
		return (Integer) getIndex(3);
	}
	
	public void setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(Integer aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId) {
		setIndex(3, aUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
	}

	public Integer getUtsDot3Onu2CtcFaxmodemCfgT38Mode() {
		return (Integer) getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode).getValue();
	}

	public void setUtsDot3Onu2CtcFaxmodemCfgT38Mode(Integer aUtsDot3Onu2CtcFaxmodemCfgT38Mode) {
		getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode).setValue(aUtsDot3Onu2CtcFaxmodemCfgT38Mode);
	}

	public Integer getUtsDot3Onu2CtcFaxmodemCfgCtrl() {
		return (Integer) getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl).getValue();
	}

	public void setUtsDot3Onu2CtcFaxmodemCfgCtrl(
			Integer aUtsDot3Onu2CtcFaxmodemCfgCtrl) {
		getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl).setValue(
				aUtsDot3Onu2CtcFaxmodemCfgCtrl);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
		prepareRead(super.getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
		prepareRead(super.getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));

		return loadAll(new int[] { 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2CtcFaxmodemCfgT38Mode));
		prepareSave(getProperty(utsDot3Onu2CtcFaxmodemCfgCtrl));

		return save();
	}

}