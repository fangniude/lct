package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class OltHandToHandConfigTable extends SnmpMibBean {

	public static final String utsOltHandToHandConfigModuleId = "utsOltHandToHandConfigModuleId";
	public static final String utsOltHandToHandConfigPortId = "utsOltHandToHandConfigPortId";
	public static final String utsOltHandToHandConfigUplinkPorts = "utsOltHandToHandConfigUplinkPorts";

	public OltHandToHandConfigTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsOltHandToHandConfigModuleId, new SnmpMibBeanProperty(
				utsOltHandToHandConfigModuleId,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.3.20.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsOltHandToHandConfigPortId, new SnmpMibBeanProperty(
				utsOltHandToHandConfigPortId,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.3.20.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsOltHandToHandConfigUplinkPorts,
				new SnmpMibBeanProperty(utsOltHandToHandConfigUplinkPorts,
						".1.3.6.1.4.1.45121.1800.2.3.1.1.3.20.1.3",
						ISnmpConstant.OCTETS));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.45121.1800.2.3.1.1.3.20.1.100",
				ISnmpConstant.INTEGER));
	}

	public Integer getUtsOltHandToHandConfigModuleId() {
		return (Integer) getIndex(0);
	}

	public void setUtsOltHandToHandConfigModuleId(
			Integer aUtsOltHandToHandConfigModuleId) {
		setIndex(0, aUtsOltHandToHandConfigModuleId);
	}

	public Integer getUtsOltHandToHandConfigPortId() {
		return (Integer) getIndex(1);
	}

	public void setUtsOltHandToHandConfigPortId(
			Integer aUtsOltHandToHandConfigPortId) {
		setIndex(1, aUtsOltHandToHandConfigPortId);
	}

	public byte[] getUtsOltHandToHandConfigUplinkPorts() {
		return (byte[]) getProperty(utsOltHandToHandConfigUplinkPorts)
				.getValue();
	}

	public void setUtsOltHandToHandConfigUplinkPorts(
			byte[] aUtsOltHandToHandConfigUplinkPorts) {
		getProperty(utsOltHandToHandConfigUplinkPorts).setValue(
				aUtsOltHandToHandConfigUplinkPorts);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsOltHandToHandConfigUplinkPorts));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsOltHandToHandConfigUplinkPorts));

		return loadAll(new int[] { 1, 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsOltHandToHandConfigUplinkPorts));
		return save();
	}

	public boolean add() throws MibBeanException {
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(utsOltHandToHandConfigUplinkPorts));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException {
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

}