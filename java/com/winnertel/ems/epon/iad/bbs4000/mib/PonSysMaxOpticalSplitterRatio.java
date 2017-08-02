package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class PonSysMaxOpticalSplitterRatio extends SnmpMibBean {

	public static final String utsPonSysMaxOpticalSplitterRatio = "utsPonSysMaxOpticalSplitterRatio";

	public PonSysMaxOpticalSplitterRatio(ISnmpProxy aSnmpProxy) {
		super(aSnmpProxy);
		init();
	}

	protected void init() {
		initProperty(utsPonSysMaxOpticalSplitterRatio, new SnmpMibBeanProperty(
				utsPonSysMaxOpticalSplitterRatio,
				".1.3.6.1.4.1.45121.1800.2.1.1.2.11", ISnmpConstant.INTEGER));
	}

	public Integer getUtsPonSysMaxOpticalSplitterRatio() {
		return (Integer) getProperty(utsPonSysMaxOpticalSplitterRatio)
				.getValue();
	}

	public void setUtsPonSysMaxOpticalSplitterRatio(
			Integer aUtsPonSysMaxOpticalSplitterRatio) {
		getProperty(utsPonSysMaxOpticalSplitterRatio).setValue(
				aUtsPonSysMaxOpticalSplitterRatio);
	}

	public boolean retrieve() throws MibBeanException {
		prepareRead(super.getProperty(utsPonSysMaxOpticalSplitterRatio));

		return load();
	}

}