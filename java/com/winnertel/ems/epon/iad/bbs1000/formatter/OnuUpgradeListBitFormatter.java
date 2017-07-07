package com.winnertel.ems.epon.iad.bbs1000.formatter;

import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;

public class OnuUpgradeListBitFormatter extends SnmpFieldFormatter {
 public OnuUpgradeListBitFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
//        byte[] bitmap = (byte[]) getProperty(utsDot3OnuFWUpgradePortListBitMap).getValue();

    int ratio = new BBS1000NE(fApplication).getPonSplitRatio();
    if(ratio == 32)
    {
      return ConfigUtility.to32OnuContraction(value);
    }
    else
    {
      return ConfigUtility.to64OnuContraction(value);
    }
  }

}
