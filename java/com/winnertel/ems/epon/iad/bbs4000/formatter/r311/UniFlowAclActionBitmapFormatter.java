package com.winnertel.ems.epon.iad.bbs4000.formatter.r311;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class UniFlowAclActionBitmapFormatter extends SnmpFieldFormatter {
		
	public UniFlowAclActionBitmapFormatter(IApplication anApplication) {
		super(anApplication);		
	}

	public Object format(SnmpMibBean aMibBean, String aProperty)
			throws Exception {
		byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean,
				aProperty);
		return actionBitMappingToStringArray(value);
	}

	public String actionBitMappingToStringArray(byte[] bts) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < bts.length; i++) {
			if ((bts[i] & 0x01) == 0x01) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("forward") + ",");
			}
			if ((bts[i] & 0x02) == 0x02) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("drop") + ",");
			}
			if ((bts[i] & 0x04) == 0x04) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("rateLimit") + ",");
			}
			if ((bts[i] & 0x08) == 0x08) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("vlanAssignment") + ",");
			}
			if ((bts[i] & 0x10) == 0x10) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("priorityMarking") + ",");
			}

		}
		return builder.substring(0, builder.length() > 1 ? builder.length() -1 : 0);
	}
}
