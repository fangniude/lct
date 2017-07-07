package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuE1PortListFormatter extends SnmpFieldFormatter {
  public Dot3OnuE1PortListFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    if(value.length > 0)
    {
      for(int i = 0; i < 8; i++)
      {
        int mask = (int)Math.pow(2, i);
        if((value[0] & mask) != 0)
        {
          sb.append("|" + (i + 1));
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
