package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class IgmpSnoopingEgressPortListFormatter extends SnmpFieldFormatter {
  public IgmpSnoopingEgressPortListFormatter(IApplication anApplication) {
    super(anApplication);
  }


  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    if (value == null)
      return "";

    return ConfigUtility.byteArrayToContractionString(value);
  }
}
