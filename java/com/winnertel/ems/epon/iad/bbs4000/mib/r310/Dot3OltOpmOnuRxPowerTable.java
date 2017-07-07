package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class Dot3OltOpmOnuRxPowerTable extends SnmpMibBean {

	public static final String utsDot3OltOpmOnuRxPowerModuleID = "utsDot3OltOpmOnuRxPowerModuleID";
	public static final String utsDot3OltOpmOnuRxPowerPortId = "utsDot3OltOpmOnuRxPowerPortId";
	public static final String utsDot3OltOpmOnuRxPowerLogicalPortId = "utsDot3OltOpmOnuRxPowerLogicalPortId";
	public static final String utsDot3OltOpmOnuRxPower = "utsDot3OltOpmOnuRxPower";

	public Dot3OltOpmOnuRxPowerTable(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsDot3OltOpmOnuRxPowerModuleID, new SnmpMibBeanProperty(
				utsDot3OltOpmOnuRxPowerModuleID,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.19.1.1",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerPortId, new SnmpMibBeanProperty(
				utsDot3OltOpmOnuRxPowerPortId,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.19.1.2",
				ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPowerLogicalPortId,
				new SnmpMibBeanProperty(utsDot3OltOpmOnuRxPowerLogicalPortId,
						".1.3.6.1.4.1.41355.1800.2.3.1.1.3.19.1.3",
						ISnmpConstant.INTEGER));
		initProperty(utsDot3OltOpmOnuRxPower, new SnmpMibBeanProperty(
				utsDot3OltOpmOnuRxPower,
				".1.3.6.1.4.1.41355.1800.2.3.1.1.3.19.1.4",
				ISnmpConstant.INTEGER));
	}

	public Integer getUtsDot3OltOpmOnuRxPowerModuleID() {
		return (Integer) getIndex(0);
	}

	public void setUtsDot3OltOpmOnuRxPowerModuleID(
			Integer aUtsDot3OltOpmOnuRxPowerModuleID) {
		setIndex(0, aUtsDot3OltOpmOnuRxPowerModuleID);
	}

	public Integer getUtsDot3OltOpmOnuRxPowerPortId() {
		return (Integer) getIndex(1);
	}

	public void setUtsDot3OltOpmOnuRxPowerPortId(
			Integer aUtsDot3OltOpmOnuRxPowerPortId) {
		setIndex(1, aUtsDot3OltOpmOnuRxPowerPortId);
	}

	public Integer getUtsDot3OltOpmOnuRxPowerLogicalPortId() {
		return (Integer) getIndex(2);
	}

	public void setUtsDot3OltOpmOnuRxPowerLogicalPortId(
			Integer aUtsDot3OltOpmOnuRxPowerLogicalPortId) {
		setIndex(2, utsDot3OltOpmOnuRxPowerLogicalPortId);
	}

//	public Integer getUtsDot3OltOpmOnuRxPower() {
//		return (int) java.lang.Math.round(10 * java.lang.Math
//				.log10((Integer) getProperty(utsDot3OltOpmOnuRxPower)
//						.getValue() / 10000.0));
//	}
	
	public Integer getUtsDot3OltOpmOnuRxPower() {
		return (Integer) getProperty(utsDot3OltOpmOnuRxPower).getValue();
	}

	public void setUtsDot3OltOpmOnuRxPower(Integer aUtsDot3OltOpmOnuRxPower) {
		getProperty(utsDot3OltOpmOnuRxPower).setValue(aUtsDot3OltOpmOnuRxPower);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmOnuRxPower));

		return load();
	}

	public Vector retrieveAll() throws MibBeanException {
		prepareRead(getProperty(utsDot3OltOpmOnuRxPower));

		return loadAll(new int[] { 1, 1, 1 });
	}

}
