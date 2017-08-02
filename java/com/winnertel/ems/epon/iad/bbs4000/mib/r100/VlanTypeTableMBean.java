
package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The VlanTypeTableMBean class.
 * Created by QuickDVM
 */
public class VlanTypeTableMBean extends SnmpMibBean {
	public static final String vlanTypeNewSVLAN = "vlanTypeNewSVLAN";
	public static final String vlanTypeNewCVLAN = "vlanTypeNewCVLAN";
	public static final String vlanType = "vlanType";

	public VlanTypeTableMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(vlanTypeNewSVLAN, new SnmpMibBeanProperty(
				vlanTypeNewSVLAN, ".1.3.6.1.4.1.45121.1.3.10.5.2.24.1.1",
				ISnmpConstant.INTEGER));
		initProperty(vlanTypeNewCVLAN, new SnmpMibBeanProperty(
				vlanTypeNewCVLAN, ".1.3.6.1.4.1.45121.1.3.10.5.2.24.1.2",
				ISnmpConstant.INTEGER));
		initProperty(vlanType, new SnmpMibBeanProperty(vlanType,
				".1.3.6.1.4.1.45121.1.3.10.5.2.24.1.3", ISnmpConstant.INTEGER));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1.3.10.5.2.24.1.4", ISnmpConstant.INTEGER));

	}

	public Integer getVlanTypeNewSVLAN() {
		return (Integer) getIndex(0);
	}

	public void setVlanTypeNewSVLAN(Integer aVlanTypeNewSVLAN) {
		setIndex(0, aVlanTypeNewSVLAN);
	}

	public Integer getVlanTypeNewCVLAN() {
		return (Integer) getIndex(1);
	}

	public void setVlanTypeNewCVLAN(Integer aVlanTypeNewCVLAN) {
		setIndex(1, aVlanTypeNewCVLAN);
	}

	public Integer getVlanType() {
		return (Integer) getProperty(vlanType).getValue();
	}

	public void setVlanType(Integer aVlanType) {
		getProperty(vlanType).setValue(aVlanType);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(vlanType));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(vlanType));

		return loadAll(new int[] { 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(vlanType));

		return save();
	}

	public boolean add() throws MibBeanException {
	    prepareSave(getProperty(vlanType));
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
