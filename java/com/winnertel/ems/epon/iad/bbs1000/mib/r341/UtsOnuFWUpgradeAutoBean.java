package com.winnertel.ems.epon.iad.bbs1000.mib.r341;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class UtsOnuFWUpgradeAutoBean extends SnmpMibBean {
	public static final String utsOnuFWUpgradeAutoPortListBitMap = "utsOnuFWUpgradeManualPortListBitMap";
	public static final String utsOnuFWUpgradeAutoOption = "utsOnuFWUpgradeAutoOption";
	public static final String utsOnuFWUpgradeAutoCurrentStatus = "utsOnuFWUpgradeAutoCurrentStatus";

	public UtsOnuFWUpgradeAutoBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsOnuFWUpgradeAutoPortListBitMap,
				new SnmpMibBeanProperty(utsOnuFWUpgradeAutoPortListBitMap,
						".1.3.6.1.4.1.41355.1800.2.3.1.7.14.1",
						ISnmpConstant.OCTETS));
		initProperty(utsOnuFWUpgradeAutoOption, new SnmpMibBeanProperty(
				utsOnuFWUpgradeAutoOption,
				".1.3.6.1.4.1.41355.1800.2.3.1.7.14.2", ISnmpConstant.INTEGER));
		initProperty(utsOnuFWUpgradeAutoCurrentStatus, new SnmpMibBeanProperty(
				utsOnuFWUpgradeAutoCurrentStatus,
				".1.3.6.1.4.1.41355.1800.2.3.1.7.14.3", ISnmpConstant.OCTETS));
	}

	public byte[] getUtsOnuFWUpgradeAutoPortListBitMap() {
		return (byte[]) getProperty(utsOnuFWUpgradeAutoPortListBitMap)
				.getValue();
	}

	public void setUtsOnuFWUpgradeAutoPortListBitMap(
			byte[] aUtsOnuFWUpgradeAutoPortListBitMap) {
		getProperty(utsOnuFWUpgradeAutoPortListBitMap).setValue(
				aUtsOnuFWUpgradeAutoPortListBitMap);
	}

	public Integer getUtsOnuFWUpgradeAutoOption() {
		return (Integer) getProperty(utsOnuFWUpgradeAutoOption).getValue();
	}

	public void setUtsOnuFWUpgradeAutoOption(Integer aUtsOnuFWUpgradeAutoOption) {
		getProperty(utsOnuFWUpgradeAutoOption).setValue(
				aUtsOnuFWUpgradeAutoOption);
	}

	public String getUtsOnuFWUpgradeAutoCurrentStatus() {
		return (String) getProperty(utsOnuFWUpgradeAutoCurrentStatus)
				.getValue();
	}

	public void setUtsOnuFWUpgradeAutoCurrentStatus(
			String aUtsOnuFWUpgradeAutoCurrentStatus) {
		getProperty(utsOnuFWUpgradeAutoCurrentStatus).setValue(
				aUtsOnuFWUpgradeAutoCurrentStatus);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsOnuFWUpgradeAutoPortListBitMap));
		prepareRead(super.getProperty(utsOnuFWUpgradeAutoOption));
		prepareRead(super.getProperty(utsOnuFWUpgradeAutoCurrentStatus));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsOnuFWUpgradeAutoPortListBitMap));
		prepareSave(getProperty(utsOnuFWUpgradeAutoOption));
		// prepareSave(getProperty(utsOnuFWUpgradeAutoCurrentStatus));

		return save();
	}

}
