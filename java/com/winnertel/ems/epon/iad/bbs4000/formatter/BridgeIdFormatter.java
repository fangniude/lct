/**
 * Created by IntelliJ IDEA.
 * User: hz03392
 * Date: Apr 30, 2003
 * Time: 4:21:49 PM
 * To change this template use Options | File Templates.
 */
package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.Vector;

public class BridgeIdFormatter extends SnmpFieldFormatter {
  public BridgeIdFormatter(IApplication anApplication) {
    super(anApplication);
  } // BridgeIdFormatter


  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    return format(value);
  }

  public static String format(byte[] value)
  {
    if (value == null) {
      return null;
    }
    Vector v = new Vector();
    for (int k = 0; k < value.length; k++) {
      int n = value[k] & 255;
      String temp1 = Integer.toHexString(n).toUpperCase();
      if (temp1.length() == 1) {
        temp1 = "0" + temp1;
      }
      v.add(temp1);
    }
    String temp = v.remove(0).toString() + "00";
    v.remove(0);
    temp = temp.substring(temp.length() - 4);
    int tempInt = Integer.parseInt(temp, 16);
    temp = String.valueOf(tempInt);
    for (int ii = 0; ii < v.size(); ii++) temp = temp + ":" + v.get(ii).toString();
    return temp;
  }
} // BridgeIdFormatter
