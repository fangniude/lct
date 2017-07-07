package com.winnertel.ems.epon.iad.bbs4000.formatter.r310;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class LocationRogueOnuFormatter extends SnmpFieldFormatter {

    public LocationRogueOnuFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
    	byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
    	String smac = new String();
    	
        if(value == null || value.length < 12) return smac;
        
        for(int i = 0; value!=null && value.length > 12 && i < value.length; i = i + 13) {
			byte[] mac = new byte[12];
			System.arraycopy(value, i, mac, 0, 12);
			smac = smac + Byte.toString(mac[11]) + Byte.toString(mac[10]) + "-" + Byte.toString(mac[9]) + Byte.toString(mac[8]) + "-" +
				Byte.toString(mac[7]) + Byte.toString(mac[6]) + "-" + Byte.toString(mac[5]) + Byte.toString(mac[4]) + "-" + 
				Byte.toString(mac[3]) + Byte.toString(mac[2]) + "-" + Byte.toString(mac[1]) + Byte.toString(mac[0]) + ";";
		}
        
        return (smac.length() > 1 ? smac.substring(0, smac.length() - 1) : smac);
    }
}
