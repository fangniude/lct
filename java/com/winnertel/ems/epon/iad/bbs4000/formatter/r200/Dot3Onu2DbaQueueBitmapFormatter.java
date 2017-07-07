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
 * The Dot3Onu2DbaQueueBitmapFormatter class.
 * Bit 0[Que 1] 1[Que 2] 2[Que 3] 3[Que 4] 4[Que 5] 5[Que 6] 6[Que 7] 7[Que 8]
 * @author Rox Liu
 */
public class Dot3Onu2DbaQueueBitmapFormatter extends SnmpFieldFormatter {
  public Dot3Onu2DbaQueueBitmapFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    for(int i = 0; i < value.length; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        int mask = (int)Math.pow(2, j);
        if((value[i] & mask) != 0)
        {
          sb.append("|").append((i*8 + j + 1));
        }
      }
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
