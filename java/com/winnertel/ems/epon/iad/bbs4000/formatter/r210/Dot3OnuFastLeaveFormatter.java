package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuFastLeaveFormatter extends SnmpFieldFormatter {
  public Dot3OnuFastLeaveFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    if(value.length > 0)
    {
//      fApplication.getActiveDeviceManager().getGuiComposer().get
      if((value[0] & 1) != 0)
        sb.append("|").append("Non-Fast-Leave in CTC IGMP Snooping");

      if((value[0] & 2) != 0)
        sb.append("|").append("Fast-Leave in CTC IGMP Snooping");

      if((value[0] & 4) != 0)
        sb.append("|").append("Non-Fast-Leave in CTC Control Multicast");

      if((value[0] & 8) != 0)
        sb.append("|").append("Fast-Leave in CTC Control Multicast");
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
