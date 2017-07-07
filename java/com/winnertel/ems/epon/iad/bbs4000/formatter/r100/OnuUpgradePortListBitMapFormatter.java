package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuUpgradePortListBitMapFormatter extends SnmpFieldFormatter {

  public OnuUpgradePortListBitMapFormatter(IApplication anApplication) {
    super(anApplication);
  }

  public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

    if(value != null) {
      return to64OnuContraction(value);
    }

    return null;
  }


    public static String to64OnuContraction(byte[] bitMap)
    {
      String contract = null;
      try
      {
        contract = contract(bitMap, 32);
      }
      catch(Exception e)
      {
        contract = "";
      }

      return contract;
    }

    static String contract(byte[] b, int size)
    {
      StringBuffer sb = new StringBuffer();

      int count = b.length/size;
      if(size == 32 || size == 16  //represent ONU of one Card: 32 bytes(1:64) or 16 bytes(1:32)
          || size == 8|| size == 4)//represent ONU of one Port: 8 bytes(1:64) or 4 bytes(1:32)
      {
        byte[][] split = new byte[count][size];

        for(int i = 0; i < count; i++)
        {
          System.arraycopy(b, i*size, split[i], 0, size);
        }

        int begin = 0, end = 0;
        String cur = "";

        for(int i = 0; i < split.length; i++)
        {
          String contract = contract(split[i], size/4);
          if(!cur.equals(contract))
          {
            if(begin == 0)
            {
              begin = i + 1;
              end = i + 1;
            }
            else
            {
              if(begin == end)
              {
                String[] s = cur.split(" ");
                for(int j = 0; j < s.length; j++)
                {
                  if(!s[j].equals(""))
                  {
                    sb.append(" ").append(begin).append("/").append(s[j]);
                  }
                }
              }
              else
              {
                String[] s = cur.split(" ");
                for(int j = 0; j < s.length; j++)
                {
                  if(!s[j].equals(""))
                  {
                    sb.append(" ").append(begin).append("-").append(end).append("/").append(s[j]);
                  }
                }
              }

              begin = i+1;
              end = i+1;
            }

            cur = contract;
          }
          else
          {
            if(!cur.equals(""))
            {
              end++;
            }
          }
        }

        if(begin == end)
        {
          String[] s = cur.split(" ");
          for(int j = 0; j < s.length; j++)
          {
            if(!s[j].equals(""))
            {
              sb.append(" ").append(begin).append("/").append(s[j]);
            }
          }
        }
        else
        {
          String[] s = cur.split(" ");
          for(int j = 0; j < s.length; j++)
          {
            if(!s[j].equals(""))
            {
              sb.append(" ").append(begin).append("-").append(end).append("/").append(s[j]);
            }
          }
        }
      }
      else
      {
        int begin = 0, end = 0, onu = 0;

        for(int i = 0; i < b.length; i++)
        {
          int mask = 128;
          for(int j = 0; j < 8; j++)
          {
            if((b[i] & mask) != 0)
            {
              onu = i * 8 + j + 1;
              if(begin == 0)
              {
                begin = onu;
                end = onu;
              }
              else if(onu == end + 1){
                end++;
              }
              else
              {
                if(begin == end)
                {
                  sb.append(" ").append(begin);
                }
                else
                {
                  sb.append(" ").append(begin).append("-").append(end);
                }

                begin = onu;
                end = onu;
              }
            }

            mask = mask >> 1;
          }
        }

        if(begin > 0){
          if(begin == end)
          {
            sb.append(" ").append(begin);
          }
          else
          {
            sb.append(" ").append(begin).append("-").append(end);
          }
        }
      }

      return sb.toString().trim();
    }
}