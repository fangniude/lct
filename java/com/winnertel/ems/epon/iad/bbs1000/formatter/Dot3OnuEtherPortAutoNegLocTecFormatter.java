package com.winnertel.ems.epon.iad.bbs1000.formatter;

import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

/**
 * Created by IntelliJ IDEA.
 * User: hz03842
 * Date: 2007-4-12
 * Time: 14:02:15
 * To change this template use File | Settings | File Templates.
 */
public class Dot3OnuEtherPortAutoNegLocTecFormatter  extends SnmpFieldFormatter {
  public Dot3OnuEtherPortAutoNegLocTecFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    StringBuffer sb = new StringBuffer();
     byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    try
    {
        int count = value.length;
        if (count %4 != 0){
            count = count/4*4;
        }
      for(int i =  0; i <count/4;  i++)
      {
          int oneValue = 0;
          for (int j=0;j<4;j++){
              int oneByte = value[i*4+j];
              if (oneByte <0) oneByte +=256;
              oneValue = oneValue * 256 + oneByte;
          }

            sb.append("," + getDisplay(oneValue));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    if(sb.length() > 0)
    {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }

    private String getDisplay(int value){
        String strRet = String.valueOf(value);
        switch(value){
            case 0:
                strRet = "global";
                break;
            case 1:
                strRet = "other";
                break;
            case 2:
                strRet = "unknown";
                break;
            case 14:
                strRet = "10BASE-T";
                break;
            case 23:
                strRet = "100BASE-T4";
                break;
            case 25:
                strRet = "100BASE-TX";
                break;
            case 32:
                strRet = "100BASE-T2";
                break;
            case 36:
                strRet = "1000BASE-X";
                break;
            case 40:
                strRet = "1000BASE-T";
                break;
            case 142:
                strRet = "10BASE-TFD";
                break;
            case 252:
                strRet = "100BASE-TXFD";
                break;
            case 312:
                strRet = "FDX PAUSE";
                break;
            case 313:
                strRet = "FDX APAUSE";
                break;
            case 314:
                strRet = "FDX SPAUSE";
                break;
            case 315:
                strRet = "FDX BPAUSE";
                break;
            case 322:
                strRet = "100BASE-T2FD";
                break;
            case 362:
                strRet = "1000BASE-XFD";
                break;
            case 402:
                strRet = "1000BASE-TFD";
                break;
            case 8029:
                strRet = "isoethernet";
                break;
        }
        return strRet;
    }
}
