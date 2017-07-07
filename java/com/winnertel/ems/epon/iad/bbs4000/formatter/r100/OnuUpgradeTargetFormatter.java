package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuUpgradeTargetFormatter extends SnmpFieldFormatter {

  public OnuUpgradeTargetFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    if(value != null) {
      int target = value.intValue();
      IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();

      if(target == 1) return composer.getString("ONT");

      if(target == 255) return composer.getString("MPU");

      return composer.getString("Circuit") + " " + (target - 1);
    }

    return "";
  }
}