package com.winnertel.ems.epon.iad.bbs4000.mib.r311;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The OltVlanBatchConfigScalars class. Created by QuickDVM
 */
public class OltVlanBatchConfigScalars extends SnmpMibBean {
	public static final String utsOltVlanBatchConfigStart = "utsOltVlanBatchConfigStart";
	public static final String utsOltVlanBatchConfigStop = "utsOltVlanBatchConfigStop";
	public static final String utsOltVlanBatchConfigVlanName = "utsOltVlanBatchConfigVlanName";
	public static final String utsOltVlanBatchConfigTaggedPortListPorts = "utsOltVlanBatchConfigTaggedPortListPorts";
	public static final String utsOltVlanBatchConfigUnTaggedPortListPorts = "utsOltVlanBatchConfigUnTaggedPortListPorts";
	public static final String utsOltVlanBacthConfigIgmpSnoop = "utsOltVlanBacthConfigIgmpSnoop";
	public static final String utsOltVlanBacthConfigPPPoEPlus = "utsOltVlanBacthConfigPPPoEPlus";
	public static final String utsOltVlanBatchConfigL2DHCPOption82 = "utsOltVlanBatchConfigL2DHCPOption82";
	public static final String utsOltVlanBatchConfigArpProxySwitch = "utsOltVlanBatchConfigArpProxySwitch";

	public OltVlanBatchConfigScalars(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsOltVlanBatchConfigStart, new SnmpMibBeanProperty(
				utsOltVlanBatchConfigStart,
				".1.3.6.1.4.1.41355.1800.2.2.1.13.1", ISnmpConstant.INTEGER));
		initProperty(utsOltVlanBatchConfigStop, new SnmpMibBeanProperty(
				utsOltVlanBatchConfigStop, ".1.3.6.1.4.1.41355.1800.2.2.1.13.2",
				ISnmpConstant.INTEGER));
		initProperty(utsOltVlanBatchConfigVlanName, new SnmpMibBeanProperty(
				utsOltVlanBatchConfigVlanName,
				".1.3.6.1.4.1.41355.1800.2.2.1.13.3", ISnmpConstant.STRING));
		initProperty(utsOltVlanBatchConfigTaggedPortListPorts,
				new SnmpMibBeanProperty(
						utsOltVlanBatchConfigTaggedPortListPorts,
						".1.3.6.1.4.1.41355.1800.2.2.1.13.4",
						ISnmpConstant.OCTETS));
		initProperty(utsOltVlanBatchConfigUnTaggedPortListPorts,
				new SnmpMibBeanProperty(
						utsOltVlanBatchConfigUnTaggedPortListPorts,
						".1.3.6.1.4.1.41355.1800.2.2.1.13.5",
						ISnmpConstant.OCTETS));
		initProperty(utsOltVlanBacthConfigIgmpSnoop, new SnmpMibBeanProperty(
				utsOltVlanBacthConfigIgmpSnoop,
				".1.3.6.1.4.1.41355.1800.2.2.1.13.6", ISnmpConstant.INTEGER));
		initProperty(utsOltVlanBacthConfigPPPoEPlus, new SnmpMibBeanProperty(
				utsOltVlanBacthConfigPPPoEPlus,
				".1.3.6.1.4.1.41355.1800.2.2.1.13.7", ISnmpConstant.INTEGER));
		initProperty(utsOltVlanBatchConfigL2DHCPOption82,
				new SnmpMibBeanProperty(utsOltVlanBatchConfigL2DHCPOption82,
						".1.3.6.1.4.1.41355.1800.2.2.1.13.8",
						ISnmpConstant.INTEGER));
		initProperty(utsOltVlanBatchConfigArpProxySwitch,
				new SnmpMibBeanProperty(utsOltVlanBatchConfigArpProxySwitch,
						".1.3.6.1.4.1.41355.1800.2.2.1.13.9",
						ISnmpConstant.INTEGER));

	}

	public Integer getUtsOltVlanBatchConfigStart() {
		return (Integer) getProperty(utsOltVlanBatchConfigStart).getValue();
	}

	public void setUtsOltVlanBatchConfigStart(
			Integer aUtsOltVlanBatchConfigStart) {
		getProperty(utsOltVlanBatchConfigStart).setValue(
				aUtsOltVlanBatchConfigStart);
	}

	public Integer getUtsOltVlanBatchConfigStop() {
		return (Integer) getProperty(utsOltVlanBatchConfigStop).getValue();
	}

	public void setUtsOltVlanBatchConfigStop(Integer aUtsOltVlanBatchConfigStop) {
		getProperty(utsOltVlanBatchConfigStop).setValue(
				aUtsOltVlanBatchConfigStop);
	}

	public String getUtsOltVlanBatchConfigVlanName() {
		return (String) getProperty(utsOltVlanBatchConfigVlanName).getValue();
	}

	public void setUtsOltVlanBatchConfigVlanName(
			String aUtsOltVlanBatchConfigVlanName) {
		getProperty(utsOltVlanBatchConfigVlanName).setValue(
				aUtsOltVlanBatchConfigVlanName);
	}

	public byte[] getUtsOltVlanBatchConfigTaggedPortListPorts() {
		return (byte[]) getProperty(utsOltVlanBatchConfigTaggedPortListPorts)
				.getValue();
	}

	public void setUtsOltVlanBatchConfigTaggedPortListPorts(
			byte[] aUtsOltVlanBatchConfigTaggedPortListPorts) {
		getProperty(utsOltVlanBatchConfigTaggedPortListPorts).setValue(
				aUtsOltVlanBatchConfigTaggedPortListPorts);
	}

	public byte[] getUtsOltVlanBatchConfigUnTaggedPortListPorts() {
		return (byte[]) getProperty(utsOltVlanBatchConfigUnTaggedPortListPorts)
				.getValue();
	}

	public void setUtsOltVlanBatchConfigUnTaggedPortListPorts(
			byte[] aUtsOltVlanBatchConfigUnTaggedPortListPorts) {
		getProperty(utsOltVlanBatchConfigUnTaggedPortListPorts).setValue(
				aUtsOltVlanBatchConfigUnTaggedPortListPorts);
	}

	public Integer getUtsOltVlanBacthConfigIgmpSnoop() {
		return (Integer) getProperty(utsOltVlanBacthConfigIgmpSnoop).getValue();
	}

	public void setUtsOltVlanBacthConfigIgmpSnoop(
			Integer aUtsOltVlanBacthConfigIgmpSnoop) {
		getProperty(utsOltVlanBacthConfigIgmpSnoop).setValue(
				aUtsOltVlanBacthConfigIgmpSnoop);
	}

	public Integer getUtsOltVlanBacthConfigPPPoEPlus() {
		return (Integer) getProperty(utsOltVlanBacthConfigPPPoEPlus).getValue();
	}

	public void setUtsOltVlanBacthConfigPPPoEPlus(
			Integer aUtsOltVlanBacthConfigPPPoEPlus) {
		getProperty(utsOltVlanBacthConfigPPPoEPlus).setValue(
				aUtsOltVlanBacthConfigPPPoEPlus);
	}

	public Integer getUtsOltVlanBatchConfigL2DHCPOption82() {
		return (Integer) getProperty(utsOltVlanBatchConfigL2DHCPOption82)
				.getValue();
	}

	public void setUtsOltVlanBatchConfigL2DHCPOption82(
			Integer aUtsOltVlanBatchConfigL2DHCPOption82) {
		getProperty(utsOltVlanBatchConfigL2DHCPOption82).setValue(
				aUtsOltVlanBatchConfigL2DHCPOption82);
	}

	public Integer getUtsOltVlanBatchConfigArpProxySwitch() {
		return (Integer) getProperty(utsOltVlanBatchConfigArpProxySwitch)
				.getValue();
	}

	public void setUtsOltVlanBatchConfigArpProxySwitch(
			Integer aUtsOltVlanBatchConfigArpProxySwitch) {
		getProperty(utsOltVlanBatchConfigArpProxySwitch).setValue(
				aUtsOltVlanBatchConfigArpProxySwitch);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsOltVlanBatchConfigStart));
		prepareRead(super.getProperty(utsOltVlanBatchConfigStop));
		prepareRead(super.getProperty(utsOltVlanBatchConfigVlanName));
		prepareRead(super.getProperty(utsOltVlanBatchConfigTaggedPortListPorts));
		prepareRead(super
				.getProperty(utsOltVlanBatchConfigUnTaggedPortListPorts));
		prepareRead(super.getProperty(utsOltVlanBacthConfigIgmpSnoop));
		prepareRead(super.getProperty(utsOltVlanBacthConfigPPPoEPlus));
		prepareRead(super.getProperty(utsOltVlanBatchConfigL2DHCPOption82));
		prepareRead(super.getProperty(utsOltVlanBatchConfigArpProxySwitch));

		return load();
	}

	public boolean modify() throws MibBeanException {
		prepareSave(getProperty(utsOltVlanBatchConfigStart));
		prepareSave(getProperty(utsOltVlanBatchConfigStop));
		prepareSave(getProperty(utsOltVlanBatchConfigVlanName));
		prepareSave(getProperty(utsOltVlanBatchConfigTaggedPortListPorts));
		prepareSave(getProperty(utsOltVlanBatchConfigUnTaggedPortListPorts));
		prepareSave(getProperty(utsOltVlanBacthConfigIgmpSnoop));
		prepareSave(getProperty(utsOltVlanBacthConfigPPPoEPlus));
		prepareSave(getProperty(utsOltVlanBatchConfigL2DHCPOption82));
		prepareSave(getProperty(utsOltVlanBatchConfigArpProxySwitch));

		return save();
	}

}
