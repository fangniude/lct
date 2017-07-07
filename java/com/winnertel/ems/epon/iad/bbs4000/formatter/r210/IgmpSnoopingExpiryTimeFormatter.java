package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class IgmpSnoopingExpiryTimeFormatter extends SnmpFieldFormatter {
  public IgmpSnoopingExpiryTimeFormatter(IApplication anApplication) {
    super(anApplication);
  }


  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    IStringMap fStringMap = fApplication.getGlobalStringMap();

    Long value = (Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    if (value == null || value == 4294967295l) //0xFFFFFFFF
      return fStringMap.getString("Never");

    StringBuffer time = new StringBuffer();
    long totalSeconds = value.longValue() / 100;
    long days = totalSeconds / (3600 * 24);
    time.append(days + fStringMap.getString("TIMETICK_DAY"));
    long hours = (totalSeconds - days * (3600 * 24)) / (3600);
    time.append(hours + fStringMap.getString("TIMETICK_HOUR"));
    long minutes = (totalSeconds - days * (3600 * 24) - hours * 3600) / 60;
    time.append(minutes + fStringMap.getString("TIMETICK_MINUTE"));
    long seconds = totalSeconds % 60;
    time.append(seconds + fStringMap.getString("TIMETICK_SECOND"));

    return time.toString();
  }
}
