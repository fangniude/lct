package com.winnertel.ems.epon.iad.bbs4000.formatter.r311;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class CtcCapabilities2IntfAttrPerSlotFormatter extends SnmpFieldFormatter {

    public CtcCapabilities2IntfAttrPerSlotFormatter(IApplication anApplication) {
        super(anApplication);
    }

    /**
    It is a sequence number of bytes. Each byte stands for 
 	different interface number. The interface type is fixed 
 	in this order: 
 	GE FE VoIP TDM ADSL2+ VDSL2 WLAN USB CATV_RF
 	The byte 0x00 stands for no corresponding interface 
 	supported in this ONU. 

     */
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        byte[] values = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
        if(values == null) return null;

        int btlength = values.length;
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; (i * 10)< btlength; i++) {
        	sb.append("slot " + i + " {");
        	if(((int)values[i * 10 + 0]& 0xFF) != 0) {
            	sb.append("GE [").append((int)values[0]& 0xFF).append("],");
            }
            if(((i * 10 + 1) < btlength) && ((int)values[i * 10 + 1]& 0xFF) != 0) {
            	sb.append("FE [").append((int)values[1]& 0xFF).append("],");
            }
            if(((i * 10 + 2) < btlength) && ((int)values[i * 10 + 2]& 0xFF) != 0) {
            	sb.append("VoIP [").append((int)values[2]& 0xFF).append("],");
            }
            if(((i * 10 + 3) < btlength) && ((int)values[i * 10 + 3]& 0xFF) != 0) {
            	sb.append("TDM [").append((int)values[3]& 0xFF).append("],");
            }
            if(((i * 10 + 4) < btlength) && ((int)values[i * 10 + 4]& 0xFF) != 0) {
            	sb.append("ADSL2+ [").append((int)values[4]& 0xFF).append("],");
            }
            if(((i * 10 + 5) < btlength) && ((int)values[i * 10 + 5]& 0xFF) != 0) {
            	sb.append("VDSL2 [").append((int)values[5]& 0xFF).append("],");
            }
            if(((i * 10 + 6) < btlength) && ((int)values[i * 10 + 6]& 0xFF) != 0) {
            	sb.append("WLAN [").append((int)values[6]& 0xFF).append("],");
            }
            if(((i * 10 + 7) < btlength) && ((int)values[i * 10 + 7]& 0xFF) != 0) {
            	sb.append("USB [").append((int)values[7]& 0xFF).append("],");
            }
            if(((i * 10 + 8) < btlength) && ((int)values[i * 10 + 8]& 0xFF) != 0) {
            	sb.append("CATV_RF [").append((int)values[8]& 0xFF).append("]");
            }
            sb.append(" } ");
//            (int)values[i + 9]& 0xFF); 
        }
        
        

        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}