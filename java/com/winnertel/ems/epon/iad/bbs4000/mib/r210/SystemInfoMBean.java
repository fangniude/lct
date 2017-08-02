package com.winnertel.ems.epon.iad.bbs4000.mib.r210;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class SystemInfoMBean extends SnmpMibBean {
	public static final String utsBBSMgmtSoftwareVersion = "utsBBSMgmtSoftwareVersion";

  public SystemInfoMBean(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsBBSMgmtSoftwareVersion, new SnmpMibBeanProperty(utsBBSMgmtSoftwareVersion, ".1.3.6.1.4.1.45121.1800.2.1.1.4.1.50", ISnmpConstant.STRING));
	}

	public String getUtsBBSMgmtSoftwareVersion() {
		return (String) getProperty(utsBBSMgmtSoftwareVersion).getValue();
	}

	public void setutsBBSMgmtSoftwareVersion(String aUtsBBSMgmtSoftwareVersion) {
		getProperty(utsBBSMgmtSoftwareVersion).setValue(aUtsBBSMgmtSoftwareVersion);
	}

  public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsBBSMgmtSoftwareVersion));

    return load();
	}
}
