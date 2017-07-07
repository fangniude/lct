package com.winnertel.ems.epon.iad.bbs4000.formatter.r311;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class RuleProfileBitmapFormatter extends SnmpFieldFormatter {
	
	public RuleProfileBitmapFormatter(IApplication anApplication) {
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

		if(bts == null) return "";
		if(bts.length > 0) {
			if ((bts[0] & 0x01) == 0x01) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("DAM AC") + ",");
			}
			if ((bts[0] & 0x02) == 0x02) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("SAM AC") + ",");
			}
			if ((bts[0] & 0x04) == 0x04) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("PRI") + ",");
			}
			if ((bts[0] & 0x08) == 0x08) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("VLAN ID") + ",");
			}
			if ((bts[0] & 0x10) == 0x10) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("Ether Type") + ",");
			}
			if ((bts[0] & 0x20) == 0x20) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("DA IP(IPv4)") + ",");
			}
			if ((bts[0] & 0x40) == 0x40) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("SA IP(IPv4)") + ",");
			}
			if ((bts[0] & 0x80) == 0x80) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("IP Protocol Type") + ",");
			}
		}
		if(bts.length > 1) {
			if ((bts[1] & 0x01) == 0x01) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("IP DSCP(IPv4)") + ",");
			}
			if ((bts[1] & 0x02) == 0x02) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("IP Precedence(IPv6)") + ",");
			}
			if ((bts[1] & 0x04) == 0x04) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("Source L4 Port") + ",");
			}
			if ((bts[1] & 0x08) == 0x08) {
				builder.append(fApplication.getActiveDeviceManager().getGuiComposer().getString("Destination L4 Port") + ",");
			}
		}
		return builder.substring(0, builder.length() > 1 ? builder.length() -1 : 0);
	}
}
