package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class PercentageFormatter extends SnmpFieldFormatter {

	public PercentageFormatter(IApplication anApplication) {
		super(anApplication);
	}

	public Object format(SnmpMibBean mibBean, String property) throws Exception {
		String value = (String)MibBeanUtil.getSimpleProperty(mibBean, property);
		String percent = "%";
		if ( value != null)
			percent = value + percent;
		
		return percent;
	}

}
