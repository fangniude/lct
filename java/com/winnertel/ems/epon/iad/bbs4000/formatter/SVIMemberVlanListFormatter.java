package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class SVIMemberVlanListFormatter extends SnmpFieldFormatter {
 public SVIMemberVlanListFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    byte[] b = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    int[] vlan = ConfigUtility.VlanMappingToVlanArray(b);

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < vlan.length; i++)
    {
      sb.append(" ").append(vlan[i]);
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }

    return sb.toString();
  }
}
