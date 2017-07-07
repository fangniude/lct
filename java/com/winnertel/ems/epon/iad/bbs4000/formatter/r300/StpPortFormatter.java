package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * @author Yang Yizai , 2009-4-21
 */
public class StpPortFormatter extends SnmpFieldFormatter {
    public StpPortFormatter(IApplication anApplication) {
      super(anApplication);
    }


    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
      byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
      return format(value);
    }

    public static String format(byte[] value)
    {
      int v = value[1];

      if(v <= 12 ) {
        int card = (v - 1)/ 4 + 1;
        int port = (v - 1)% 4 + 1;

        return card + "/" + port;
      } else {
        return "lg" + (v - 12);
      }
    }
  }
