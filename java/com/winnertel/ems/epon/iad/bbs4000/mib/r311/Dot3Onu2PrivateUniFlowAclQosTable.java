package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The Dot3Onu2PrivateUniFlowAclQosTable class. Created by QuickDVM
 */
public class Dot3Onu2PrivateUniFlowAclQosTable extends SnmpMibBean {
	public static final String utsDot3Onu2Ctc3UniModuleId = "utsDot3Onu2Ctc3UniModuleId";
	public static final String utsDot3Onu2Ctc3UniDeviceId = "utsDot3Onu2Ctc3UniDeviceId";
	public static final String utsDot3Onu2Ctc3UniPortId = "utsDot3Onu2Ctc3UniPortId";
	public static final String utsDot3Onu2Ctc3UniLogicalPortId = "utsDot3Onu2Ctc3UniLogicalPortId";
	public static final String utsDot3Onu2Ctc3UniPhyPortId = "utsDot3Onu2Ctc3UniPhyPortId";
	public static final String utsDot3Onu2PrivateUniFlowPolicyId = "utsDot3Onu2PrivateUniFlowPolicyId";
	public static final String utsDot3Onu2PrivateRuleId = "utsDot3Onu2PrivateRuleId";
	public static final String utsDot3Onu2PrivateActionBitmap = "utsDot3Onu2PrivateActionBitmap";
	public static final String utsDot3Onu2PrivateActionBandwidth = "utsDot3Onu2PrivateActionBandwidth";
	public static final String utsDot3Onu2PrivateActionVlanId = "utsDot3Onu2PrivateActionVlanId";
	public static final String utsDot3Onu2PrivateActionPriority  = "utsDot3Onu2PrivateActionPriority";

	public Dot3Onu2PrivateUniFlowAclQosTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2Ctc3UniModuleId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniDeviceId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniDeviceId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniLogicalPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2Ctc3UniPhyPortId, new SnmpMibBeanProperty(
				utsDot3Onu2Ctc3UniPhyPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.56.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateUniFlowPolicyId,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateUniFlowPolicyId,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.1",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateRuleId, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateRuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateActionBitmap, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateActionBitmap,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.3",
				ISnmpConstant.OCTETS));
		initProperty(utsDot3Onu2PrivateActionBandwidth,
				new SnmpMibBeanProperty(utsDot3Onu2PrivateActionBandwidth,
						".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.4",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateActionVlanId, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateActionVlanId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.5",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2PrivateActionPriority, new SnmpMibBeanProperty(
				utsDot3Onu2PrivateActionPriority,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.6",
				ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.107.1.99",
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

	public Integer getUtsDot3Onu2PrivateUniFlowPolicyId() {
		return (Integer) getIndex(5);
	}

	public void setUtsDot3Onu2PrivateUniFlowPolicyId(
			Integer aUtsDot3Onu2PrivateUniFlowPolicyId) {
		setIndex(5, aUtsDot3Onu2PrivateUniFlowPolicyId);
	}

	public Integer getUtsDot3Onu2PrivateRuleId() {
		return (Integer) getProperty(utsDot3Onu2PrivateRuleId).getValue();
	}

	public void setUtsDot3Onu2PrivateRuleId(Integer aUtsDot3Onu2PrivateRuleId) {
		getProperty(utsDot3Onu2PrivateRuleId).setValue(
				aUtsDot3Onu2PrivateRuleId);
	}

	public byte[] getUtsDot3Onu2PrivateActionBitmap() {
		return (byte[]) getProperty(utsDot3Onu2PrivateActionBitmap).getValue();
	}

	public void setUtsDot3Onu2PrivateActionBitmap(
			byte[] aUtsDot3Onu2PrivateActionBitmap) {
		getProperty(utsDot3Onu2PrivateActionBitmap).setValue(
				aUtsDot3Onu2PrivateActionBitmap);
	}

	public Integer getUtsDot3Onu2PrivateActionBandwidth() {
		return (Integer) getProperty(utsDot3Onu2PrivateActionBandwidth)
				.getValue();
	}

	public void setUtsDot3Onu2PrivateActionBandwidth(
			Integer aUtsDot3Onu2PrivateActionBandwidth) {
		getProperty(utsDot3Onu2PrivateActionBandwidth).setValue(
				aUtsDot3Onu2PrivateActionBandwidth);
	}

	public Integer getUtsDot3Onu2PrivateActionVlanId() {
		return (Integer) getProperty(utsDot3Onu2PrivateActionVlanId).getValue();
	}

	public void setUtsDot3Onu2PrivateActionVlanId(
			Integer aUtsDot3Onu2PrivateActionVlanId) {
		getProperty(utsDot3Onu2PrivateActionVlanId).setValue(
				aUtsDot3Onu2PrivateActionVlanId);
	}
	
	public Integer getUtsDot3Onu2PrivateActionPriority() {
		return (Integer) getProperty(utsDot3Onu2PrivateActionPriority).getValue();
	}

	public void setUtsDot3Onu2PrivateActionPriority(
			Integer aUtsDot3Onu2PrivateActionPriority) {
		getProperty(utsDot3Onu2PrivateActionPriority).setValue(
				aUtsDot3Onu2PrivateActionPriority);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionBitmap));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionBandwidth));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionVlanId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionPriority));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2PrivateRuleId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionBitmap));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionBandwidth));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionVlanId));
		prepareRead(super.getProperty(utsDot3Onu2PrivateActionPriority));

		return loadAll(new int[] { 1, 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2PrivateRuleId));
		prepareSave(getProperty(utsDot3Onu2PrivateActionBitmap));
		prepareSave(getProperty(utsDot3Onu2PrivateActionBandwidth));
		prepareSave(getProperty(utsDot3Onu2PrivateActionVlanId));
		prepareSave(getProperty(utsDot3Onu2PrivateActionPriority));

		return save();
	}

	public boolean add() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2PrivateRuleId));
		prepareSave(getProperty(utsDot3Onu2PrivateActionBitmap));
		prepareSave(getProperty(utsDot3Onu2PrivateActionBandwidth));
		prepareSave(getProperty(utsDot3Onu2PrivateActionVlanId));
		prepareSave(getProperty(utsDot3Onu2PrivateActionPriority));
		
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException {
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}
