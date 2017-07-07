package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The UtsDot3Onu2AlarmProfileTable class. Created by QuickDVM
 */
public class UtsDot3Onu2AlarmProfileTable extends SnmpMibBean {
	public static final String utsDot3Onu2AlarmProfileIndex = "utsDot3Onu2AlarmProfileIndex";
	public static final String utsDot3Onu2AlarmProfileName = "utsDot3Onu2AlarmProfileName";

	public UtsDot3Onu2AlarmProfileTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3Onu2AlarmProfileIndex, new SnmpMibBeanProperty(
				utsDot3Onu2AlarmProfileIndex,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.43.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3Onu2AlarmProfileName,
				new SnmpMibBeanProperty(utsDot3Onu2AlarmProfileName,
						".1.3.6.1.4.1.41355.1800.2.3.1.2.1.43.1.2",
						ISnmpConstant.STRING));
		initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS,
				".1.3.6.1.4.1.41355.1800.2.3.1.2.1.43.1.100",
				ISnmpConstant.INTEGER));

	}

	public Integer getUtsDot3Onu2AlarmProfileIndex() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3Onu2AlarmProfileIndex(
			Integer aUtsDot3Onu2AlarmProfileIndex) {
		setIndex(0, aUtsDot3Onu2AlarmProfileIndex);
	}

	public String getUtsDot3Onu2AlarmProfileName() {
		return (String) getProperty(utsDot3Onu2AlarmProfileName).getValue();
	}

	public void setUtsDot3Onu2AlarmProfileName(
			String aUtsDot3Onu2AlarmProfileName) {
		getProperty(utsDot3Onu2AlarmProfileName).setValue(
				aUtsDot3Onu2AlarmProfileName);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmProfileName));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(super.getProperty(utsDot3Onu2AlarmProfileName));

		return loadAll(new int[] { 1 });
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsDot3Onu2AlarmProfileName));

		return save();
	}

	public boolean add() throws MibBeanException {
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
