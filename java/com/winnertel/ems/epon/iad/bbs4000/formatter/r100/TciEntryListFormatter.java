package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class TciEntryListFormatter extends SnmpFieldFormatter{

    public TciEntryListFormatter(IApplication app){
        super(app);
    }
    
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        
        byte[] value = (byte[])MibBeanUtil.getSimpleProperty(mibBean, property);
        StringBuffer list = new StringBuffer("");
        for(int i=0; i<value.length/2; i++)
        {StringBuffer entry = new StringBuffer("["); 
          entry.append(((value[i*2]&0x0F)*256)+(value[i*2+1]&0xFF)).append(",");
          entry.append((value[i*2]&0x10)!=0?"CFI":" ").append(",");
          entry.append((value[i*2]&0xFF)>>5).append("]");
          list.append(entry);
        }
        return list.toString();
    }
    

}
