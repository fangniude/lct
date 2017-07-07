package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class IfIdFormatter extends SnmpFieldFormatter {
  public IfIdFormatter(IApplication anApplication) {
    super(anApplication);
  }


  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    if(value == null) return "";

    return format(value.intValue());
  }

  public static String format(int v)
  {
    if(v <= 48 ) {
      int card = (v - 1)/ 4 + 1;
      int port = (v - 1)% 4 + 1;

      return card + "/" + port;
    } else {
      return "lg" + (v - 48);
    }
  }
}
