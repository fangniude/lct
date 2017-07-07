package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class IfIndexFormatter extends SnmpFieldFormatter
{

  public IfIndexFormatter(IApplication anApplication)
  {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception
  {
    String value = "" + MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    return ConfigUtility.formatIfIndex(value);
  }
}