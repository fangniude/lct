package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class VlanPriorityBitMapFormatter extends SnmpFieldFormatter{
	
	public VlanPriorityBitMapFormatter(IApplication anApplication){
		super(anApplication);
	}

	@Override
	public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
		Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

	    return format(value.longValue());
		
	}
	
	public static String format(long value)
	{
//		  Bit0  Priority 0
//	 	  Bit1  Priority 1
//	 	  Bit2  Priority 2
//	 	  Bit3  Priority 3
//	 	  Bit4  Priority 4
//	 	  Bit5  Priority 5
//	 	  Bit6  Priority 6
//	 	  Bit7  Priority 7
//	
		StringBuffer sb = new StringBuffer();
		if((value&1) != 0) sb.append("Priority 0,");
		if((value&2) != 0) sb.append("Priority 1,");
		if((value&4) != 0) sb.append("Priority 2,");
		if((value&8) != 0) sb.append("Priority 3,");
		if((value&16) != 0) sb.append("Priority 4,");
		if((value&32) != 0) sb.append("Priority 5,");
		if((value&64) != 0) sb.append("Priority 6,");
		if((value&128) != 0) sb.append("Priority 7,");
		
		if (sb.length() > 0) {
	        //delete the last ','.
	        sb.deleteCharAt(sb.length() - 1);
	    }
		
	return sb.toString();	
	}
	
}
