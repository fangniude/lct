package com.winnertel.ems.epon.iad.bbs1000.formatter;

import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

public class Dot3OnuSelectiveQinQSAppointCosFormatter  extends SnmpFieldFormatter {
  public Dot3OnuSelectiveQinQSAppointCosFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    Integer source = (Integer)MibBeanUtil.getSimpleProperty(aMibBean, "utsDot3OnuSelectiveQinQSCosSourceSelect");
    Integer cos = (Integer)MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    
    if(source != null && source == 1) //copy-cvid-mode
    {
      return fApplication.getActiveDeviceManager().getGuiComposer().getString("none");
    }
    else
    {
      

      if(cos != null && cos == 8)
      {
        return fApplication.getActiveDeviceManager().getGuiComposer().getString("No Limited");
      }
      else
      {
        return "" + cos;
      }
    }
  }
}
