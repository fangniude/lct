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
 * The Dot3Olt2QueueMapFormatter class.
 * byte:  |    byte0    | |    byte1    | ... |    byte7    |
 * weight:| queue0(int) | | queue2(int) | ... | queue7(int) |
 *
 * @author Rox Liu
 */
public class Dot3Olt2QueueMapFormatter extends SnmpFieldFormatter {
  public Dot3Olt2QueueMapFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    for(int i = 0; i < value.length; i++)
    {
      sb.append("|").append(value[i] & 255);
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
