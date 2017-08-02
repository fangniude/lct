package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class UNIMulticastConfigure extends SnmpMibBean {
	public static final String utsDot3OnuModuleId = "utsDot3OnuModuleId";
	public static final String utsDot3OnuDeviceId = "utsDot3OnuDeviceId";
	public static final String utsDot3OnuPortId = "utsDot3OnuPortId";
	public static final String utsDot3OnuLogicalPortId = "utsDot3OnuLogicalPortId";
	public static final String utsDot3OnuEtherPortIndex = "utsDot3OnuEtherPortIndex";

	public static final String utsDot3OnuEtherPortMVlanList = "utsDot3OnuEtherPortMVlanList";
	public static final String utsDot3OnuEtherPortMVlanClear = "utsDot3OnuEtherPortMVlanClear";
	public static final String utsDot3OnuEtherPortMaxMcGroupNum = "utsDot3OnuEtherPortMaxMcGroupNum";
  public static final String utsDot3OnuEtherPortMcTagStripe = "utsDot3OnuEtherPortMcTagStripe";

  public UNIMulticastConfigure(ISnmpProxy arg0) {
		super(arg0);
		init();
	}

	protected void init() {
		initProperty(utsDot3OnuModuleId, new SnmpMibBeanProperty(
				utsDot3OnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuDeviceId, new SnmpMibBeanProperty(
				utsDot3OnuDeviceId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuPortId, new SnmpMibBeanProperty(
				utsDot3OnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.3",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuLogicalPortId, new SnmpMibBeanProperty(
				utsDot3OnuLogicalPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.4",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortIndex, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortIndex,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.5",
				ISnmpConstant.INTEGER));

		initProperty(utsDot3OnuEtherPortMVlanList, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortMVlanList,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.42",
				ISnmpConstant.OCTETS));
		initProperty(utsDot3OnuEtherPortMVlanClear, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortMVlanClear,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.43",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OnuEtherPortMaxMcGroupNum, new SnmpMibBeanProperty(
				utsDot3OnuEtherPortMaxMcGroupNum,
				".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.44",
				ISnmpConstant.INTEGER));
    initProperty(utsDot3OnuEtherPortMcTagStripe, new SnmpMibBeanProperty(
        utsDot3OnuEtherPortMcTagStripe,
        ".1.3.6.1.4.1.45121.1800.2.3.1.2.1.11.1.45",
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

	public void setUtsDot3OnuDeviceId(Integer aUtsDot3OnuDeviceId) {
		setIndex(1, aUtsDot3OnuDeviceId);
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

	public Integer getUtsDot3OnuEtherPortIndex() {
		return (Integer) getIndex(4);
	}

	public void setUtsDot3OnuEtherPortIndex(Integer aUtsDot3OnuEtherPortIndex) {
		setIndex(4, aUtsDot3OnuEtherPortIndex);
	}

	public byte[] getUtsDot3OnuEtherPortMVlanList() {
		return (byte[]) getProperty(utsDot3OnuEtherPortMVlanList).getValue();
	}

	public void setUtsDot3OnuEtherPortMVlanList(
			byte[] aUtsDot3OnuEtherPortMVlanList) {
		getProperty(utsDot3OnuEtherPortMVlanList).setValue(
				aUtsDot3OnuEtherPortMVlanList);
	}

	public Integer getUtsDot3OnuEtherPortMVlanClear() {
		return (Integer) getProperty(utsDot3OnuEtherPortMVlanClear).getValue();
	}

	public void setUtsDot3OnuEtherPortMVlanClear(
			Integer aUtsDot3OnuEtherPortMVlanClear) {
		getProperty(utsDot3OnuEtherPortMVlanClear).setValue(
				aUtsDot3OnuEtherPortMVlanClear);
	}

	public Integer getUtsDot3OnuEtherPortMaxMcGroupNum() {
		return (Integer) getProperty(utsDot3OnuEtherPortMaxMcGroupNum)
				.getValue();
	}

	public void setUtsDot3OnuEtherPortMaxMcGroupNum(
			Integer aUtsDot3OnuEtherPortMaxMcGroupNum) {
		getProperty(utsDot3OnuEtherPortMaxMcGroupNum).setValue(
				aUtsDot3OnuEtherPortMaxMcGroupNum);
	}

  public Integer getUtsDot3OnuEtherPortMcTagStripe() {
    return (Integer)getProperty(utsDot3OnuEtherPortMcTagStripe).getValue();
  }

  public void setUtsDot3OnuEtherPortMcTagStripe(Integer aUtsDot3OnuEtherPortMcTagStripe) {
    getProperty(utsDot3OnuEtherPortMcTagStripe).setValue(aUtsDot3OnuEtherPortMcTagStripe);
  }

  public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanList));
		prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanClear));
		prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMcTagStripe));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanList));
		prepareRead(super.getProperty(utsDot3OnuEtherPortMVlanClear));
		prepareRead(super.getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareRead(super.getProperty(utsDot3OnuEtherPortMcTagStripe));

		return loadAll(new int[] { 1, 1, 1, 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3OnuEtherPortMVlanList));
		prepareSave(getProperty(utsDot3OnuEtherPortMVlanClear));
		prepareSave(getProperty(utsDot3OnuEtherPortMaxMcGroupNum));
    prepareSave(getProperty(utsDot3OnuEtherPortMcTagStripe));

		return save();
	}

	public boolean clearMulticastVlanList() throws MibBeanException {
		setUtsDot3OnuEtherPortMVlanClear(new Integer(1));
		prepareSave(getProperty(utsDot3OnuEtherPortMVlanClear));

		return save();
	}

}
