/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.formatter.r200;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * The Dot3OnuEtherPortMVlanListFormatter class.
 * 0x01 23[MVlan 1] 45 67[MVlan 2] 89 ab[MVlan 3]
 *
 * @author Rox Liu
 */
public class Dot3Onu2DbaQueueThresholdFormatter extends SnmpFieldFormatter {
  public Dot3Onu2DbaQueueThresholdFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();

    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    for(int i = 0; i < value.length/2; i++)
    {
      sb.append("|").append(getInt(value[i*2], value[i*2+1]));
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }

  private int getInt(byte b1, byte b2)
  {
    return (255 & b1) * 256 + (255 & b2);
  }
}
