package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuGEPortListFormatter extends SnmpFieldFormatter {
  public Dot3OnuGEPortListFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    for(int i =  value.length-1; i >0; i--)
    {
      for(int j = 0; j < 8; j++)
      {
        int mask = (int)Math.pow(2, j);
        if((value[i] & mask) != 0)
        {
          sb.append("|" + ((value.length-1-i)*8 + j + 1));
        }
      }
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
