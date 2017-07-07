package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class SwitchInterfaceIndexFormatter extends SnmpFieldFormatter {
 public SwitchInterfaceIndexFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    return format(value.intValue());
  }

  public static String format(int index)
  {
    StringBuffer sb = new StringBuffer();
    if (index > 0 && index < 49)
    {
      int port = index % 4;
      if(port == 0)
      {
        sb.append((index - 1) / 4 + 1).append("/4");
      }
      else
      {
        sb.append((index - 1) / 4 + 1).append("/").append(port);
      }
    }
    else if(index >= 49){
        sb.append("lg").append(index - 48);
    }
    else
    {
      sb.append(index);
    }
    
    return sb.toString();
  }
}
