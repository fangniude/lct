package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuEtherPortVlanTranslationFormatter extends SnmpFieldFormatter {

	public Dot3OnuEtherPortVlanTranslationFormatter(IApplication anApplication) {
		super(anApplication);
	}

	public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
		StringBuffer sb = new StringBuffer();

		try {
      byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

      if(value == null) return "";
      
      for (int i = 0; i < value.length / 8; i++) {
				
				if ( value[i * 8] == 0 && value[i * 8 + 1] == 0 && value[i * 8 + 2] == 0 && value[i * 8 + 3] == 0 &&
						value[i * 8 + 4] == 0 && value[i * 8 + 5] == 0 && value[i * 8 + 6] == 0 && value[i * 8 + 7] == 0	) {
					continue;
				}

				sb.append(" [" + getHex(value[i * 8], value[i * 8 + 1]));
				sb.append(" , " + getInt(value[i * 8 + 2], value[i * 8 + 3]));
				sb.append("]->[" + getHex(value[i * 8 + 4], value[i * 8 + 5]));
				sb.append(" , " + getInt(value[i * 8 + 6], value[i * 8 + 7]));
				sb.append("] ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	private int getInt(byte b1, byte b2) {
		return (255 & b1) * 256 + (255 & b2);
	}

  private String getHex(byte b1, byte b2) {
    return Integer.toHexString(getInt(b1, b2)).toUpperCase();
  }
}
