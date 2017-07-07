package com.winnertel.ems.epon.iad.bbs1000;

/**
 * This is a utility class which is used to do some
 * simple operations, such as data conversion and
 * object search.
 *
 *	OctetToMacAddress: ��ʾMAC��ַ
 *	MacAddressToOctet�����MAC��ַ
 *
 *	formatIfIndex�� ��ʾIfIndex
 *	generateIfIndex�����IfIndex
 *
 *	bitMapToString: ��ʾbitMap(vlan member lists)
 *	formatBitMap����ʾbitMap(vlan member lists)�ĸ�����
 *	generateBitMap�����bitMap(vlan member lists)
 *	transferBitMap��ת��bitMap(vlan member lists)Ϊ����
 *
 *	portListToString����ʾportList
 *	formatPortList����ʾportList�ĸ�����
 *	generatePortList�����PortList
 *	transferPortList��ת��portListΪ����
 *
 * 	createBytes�����byte[]�ĸ�����
 *
 *	formatSysUpTime����ʾϵͳ����ʱ��
 *
 *  toBitMap: ���onu��bitMap
 *  toPortRange����ʾONU��bitMap
 */

import com.winnertel.ems.epon.global.ResourceManager;

import java.util.*;

public class ConfigUtility {
    /**
     * convert Octet to Mac address, return Mac address.
     *
     * @param mibValue is the Octet string.
     * @return MAC address.
     */
    public static String OctetToMacAddress(String mibValue) {
        String moAttrValue = "";
        try {
            char[] c = mibValue.toCharArray();
            String[] strArray = new String[c.length];
            for (int j = 0; j < c.length; j++) {
                int n = (int) c[j];
                strArray[j] = Integer.toHexString(n);
                if (strArray[j].length() == 1) {
                    strArray[j] = "0" + strArray[j];
                }
            }
            moAttrValue = strArray[0] + "-" + strArray[1] + "-" + strArray[2] +
                "-" + strArray[3] + "-" + strArray[4] + "-" + strArray[5];
        }
        catch (Exception e) {}
        return moAttrValue;
    }

  public static String OctetToMacAddress(byte[] value) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value.length; i++) {
            byte b = value[i];
            if (b >= 0 && b < 16) {
                sb.append('0');
            }

            int bi = value[i] & 0xff;
            sb.append(Integer.toHexString(bi).toLowerCase());

            if (i < value.length - 1) {
                sb.append("-");
            }
        }

        return sb.toString();
    }

    /*
     * format the ifIndex. ifIndex is encoded in bits; 0 to 31 from right to left.
     * 9-0 bits for logical port id, 14-10 for port id and 18-15 for module id,
     * 26-19 for device id or link aggregation group id. Change to String like
     * "module/port/logical port" if it is a port, and change to String like
     * "module/group#" if it is a link aggregation interface.
     */
    public static String formatIfIndex(String s) {
        String returnStr = null;
        int i = Integer.parseInt(s);

        // bits 28-27, 00 - L2, 01 - L3 VLAN, 10/11 - reserved.
        int highBits = i >>> 27;

        if (highBits == 0) {
            // this interface is a port or link aggregation.
            int bits = 67108864; // bit 26
            int bitsAnd = i & bits;
            if (bitsAnd != 0) {
                // this is a link aggregation interface.
                bits = 133693440; // bits 26-19
                bitsAnd = i & bits;
                int groupId = (bitsAnd >>> 19) - 128;
                returnStr = "lg" + groupId;
            }
            else {
                int delta = 1023; // 0-9
                int logicalPort = i & delta;

                i >>= 10;
                delta = 31; // 10-14
                int port = i & delta;

                i >>= 5;
                delta = 15;
                int module = i & delta; //15-18
                if (logicalPort == 0) {
                    returnStr = module + "/" + port;
                }
                else {
                    returnStr = module + "/" + port + "/" + logicalPort;
                }
            }
        }
        else if (highBits == 1) {
            // this interface is a VLAN.
            int bits = 134184960; // bits 26-15
            int bitsAnd = i & bits;
            int vlanId = bitsAnd >>> 15;
            returnStr = "vlan" + vlanId;
        }
        else if ( (highBits == 2) || (highBits == 3)) {
            // reserved for future use.
            returnStr = "unknown";
        }

        return returnStr;
    }

    /*
     *convert vlan member bitMap to String,
     (vlan id is separated by blank space, not contraction string)
     */
    public static String bitMapToString(String mibValue) {
        StringBuffer sb = new StringBuffer();
        char[] c = mibValue.toCharArray();
        String[] strArray = new String[c.length];
        for (int k = 0; k < c.length; k++) {
            int n = (int) c[k];
            strArray[k] = Integer.toHexString(n);
            if (strArray[k].length() == 1) {
                strArray[k] = "0" + strArray[k];
            }
        }
        String[] strArray1 = new String[2 * c.length];
        for (int i = 0; i < strArray.length; i++) {
            c = strArray[i].toCharArray();
            strArray1[2 * i] = String.valueOf(c[1]);
            strArray1[2 * i + 1] = String.valueOf(c[0]);
        }

        for (int i = 0; i < strArray1.length; i++) {
            int tempInt = Integer.parseInt(strArray1[i], 16);
            if ( (tempInt & 0X01) != 0) {
                sb.append(" ").append(i * 4 + 1);
            }
            if ( (tempInt & 0X02) != 0) {
                sb.append(" ").append(i * 4 + 2);
            }
            if ( (tempInt & 0X04) != 0) {
                sb.append(" ").append(i * 4 + 3);
            }
            if ( (tempInt & 0X08) != 0) {
                sb.append(" ").append(i * 4 + 4);
            }
        }

        return sb.toString().trim();
    }

    /*
     * Convert PortList to String
     * PortList just include 12 ports(4 gsm ports and 8 internal ports)
     * and 32 link aggregation id. So the string length is 6.
   * byte:  |msb byte0 lsb | |   byte1    |   ...
   * port:   8   ...    1     16   ...   9    ...
     */
  public static String portMappingToContractionString(String mibValue) {

    byte[] b = null;
    try
    {
      b = mibValue.getBytes("ISO-8859-1");
    }
    catch(Exception e)
    {
      b = mibValue.getBytes();
    }

    return byteArrayToContractionString(b);
}

  /*
   * Convert PortList to String
   * PortList just include 12 ports(4 gsm ports and 8 internal ports)
   * and 32 link aggregation id. So the string length is 6.
 * byte:  |msb byte0 lsb | |   byte1    |   ...
 * port:   8   ...    1     lg4   ...   9    ...
   */
public static String byteArrayToContractionString(byte[] b) {
    Hashtable portTable = new Hashtable();
    Vector groupVector = new Vector();

    for(int i = 0; i < b.length; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        if((b[i] & (int)Math.pow(2, j)) != 0)
        {
          int id = i * 8 + j + 1;

          if(id <= 12)
          {
            int cardId = i * 2 + j / 4 + 1;
            int portId = j % 4 + 1;

            Integer key = new Integer(cardId);
            Vector v = (Vector)portTable.get(key);
            if(v == null)
            {
              v = new Vector(4);
              portTable.put(key, v);
            }
            v.add("" + portId);
          }
          else if(id > 12)
          {
            groupVector.add("" + (id-12));
          }
          else
          {

          }
        }
      }
    }



      /**
       * change the sequence
       */
      String[] ports = formatPortList(portTable).split( " " );
      StringBuffer result = new StringBuffer();

      for(int i=ports.length-1; i >= 0; i--)
      {
    	  result.append( ports[i] );
    	  result.append( " " );
      }

      for (int i = 0; i < groupVector.size(); i++)
      {
    	  result.append( "lg" );
    	  result.append( groupVector.get( i ) );
      }

      return result.toString();
  }

  public static int[] portMappingToPortArray(byte[] mibValue)
  {
    ArrayList list = new ArrayList();
    for(int i = 0; i < mibValue.length; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        if((mibValue[i] & (int)Math.pow(2, j)) != 0)
        {
          list.add(new Integer(i*8 + j + 1));
        }
      }
    }

    int[] value = new int[list.size()];

    for(int i = 0; i < value.length; i++)
    {
      value[i] = ((Integer)list.get(i)).intValue();
    }

    return value;
  }
  /*
   * Convert port-bit mapping string to display string array.
   * for example: [][]...[][] -->  {1/1, 1/2, 2/1, 2-2}
   * the mapping string represents 48 ports and 32 link-aggregations, it length is 12 byte.
   * byte:  |msb byte0 lsb | |   byte1    |   ...
   * port:   8   ...    1     16   ...   9    ...
   */
  public static String[] portMappingToStringArray(byte[] mibValue) {
    ArrayList list = new ArrayList();

    for(int i = 0; i < mibValue.length; i++)
    {
      for(int j = 0; j < 8; j++)
      {
        if((mibValue[i] & (int)Math.pow(2, j)) != 0)
        {
          int id = i * 8 + j + 1;

          if(id <= 12)
          {
            int cardId = i * 2 + j / 4 + 1;
            int portId = j % 4 + 1;

            list.add(cardId + "/" + portId);
          }
          else if(id > 12)
          {
            list.add("lg" + (id-12));
          }
          else
          {

          }
        }
      }
    }

    return (String[])list.toArray(new String[0]);
  }

  public static byte[] StringArrayToPortMapping(String[] array) {
    byte[] b = new byte[12];

    if(array != null)
    {
      for(int i = 0; i < array.length; i++)
      {
        if(array[i].indexOf("/") != -1)
        {
          int cardId = Integer.parseInt(array[i].substring(0, array[i].indexOf("/")));
          int portId = Integer.parseInt(array[i].substring(array[i].indexOf("/")+1, array[i].length()));

          int pointer = (cardId-1) / 2;
          int mask = b[pointer] + (int)Math.pow(2, ((cardId-1)%2)*4 + portId-1);
          b[pointer] = (byte)mask;
        }
        else if(array[i].startsWith("lg"))
        {
          int lg = Integer.parseInt(array[i].substring(2, array[i].length()));
          int pointer = (lg+3) / 8 + 1;
          int mask = b[pointer] + (int)Math.pow(2, (lg+3) % 8);
          b[pointer] = (byte)mask;
        }
        else
        {

        }
      }
    }

    return b;
  }

  public static int[] StringArrayToPortArray(String[] array) {
    int[] b = new int[array.length];

    if(array != null)
    {
      for(int i = 0; i < array.length; i++)
      {
        if(array[i].indexOf("/") != -1)
        {
          int cardId = Integer.parseInt(array[i].substring(0, array[i].indexOf("/")));
          int portId = Integer.parseInt(array[i].substring(array[i].indexOf("/")+1, array[i].length()));

          b[i] = (cardId - 1) * 4 + portId;
        }
        else if(array[i].startsWith("lg"))
        {
          int lg = Integer.parseInt(array[i].substring(2, array[i].length()));

          b[i] = 48 + lg;
        }
        else
        {

        }
      }
    }

    return b;
  }

  public static int[] VlanMappingToVlanArray(byte[] b)
  {
    ArrayList list = new ArrayList();

    if(b != null)
    {
      for(int i = 0; i < b.length; i++)
      {
        for(int j = 0; j < 8; j++)
        {
          if((b[i] & (int)Math.pow(2, j)) != 0)
          {
            list.add(new Integer(i*8 + j + 1));
          }
        }
      }
    }

    int[] vlan = new int[list.size()];

    for(int i = 0; i < vlan.length; i++)
    {
      vlan[i] = ((Integer)list.get(i)).intValue();
    }
    return vlan;
  }

  public static byte[] StringArrayToVlanMapping(String[] vlan)
  {
    byte[] b = new byte[512];

    if(vlan != null)
    {
      for(int i = 0; i < vlan.length; i++)
      {
        int vlanId = Integer.parseInt(vlan[i]);

        int offset = (vlanId - 1) / 8;
        int mask = (int)Math.pow(2, (vlanId-1)%8);
        int value = b[offset] + mask;
        b[offset] = (byte)value;
      }
    }

    return b;
  }

    private static String formatPortList(Hashtable htable) {
        String strResult = "";
        Enumeration e = htable.keys();
        for (; e.hasMoreElements(); ) {
            Integer theKey = (Integer) e.nextElement();
            Vector a = (Vector) htable.get(theKey);
            int begin = 0;
            int end = 0;
            int temp = 0;
            boolean flag = false;
            int i = 0;
            while (i < a.size()) {
                begin = Integer.parseInt( (String) a.get(i));
                if (i < a.size() - 1) {
                    end = Integer.parseInt( (String) a.get(++i));
                }
                else {
                    i++;
                }
                temp = begin;
                flag = false;
                while ( (++temp) == end) {
                    if (i < a.size() - 1) {
                        end = Integer.parseInt( (String) a.get(++i));
                    }
                    else {
                        i++;
                    }
                    flag = true;
                }
                if (flag) {
                    if (i <= a.size() - 1) {
                        end = Integer.parseInt( (String) a.get(i - 1));
                    }
                    strResult = strResult + theKey + "/" + begin + "-" + end + " ";
                }
                else {
                    strResult = strResult + theKey + "/" + begin + " ";
                }
            }
        }
        return strResult;
    }

  /**
   * contract the number in vector, for example 1, 2, 3, -> 1-3.
   * @param v
   */
    private static String contract(Vector v) {
        String strResult = "";
        int begin = 0;
        int end = 0;
        int temp = 0;
        boolean flag = false;
        int i = 0;
        while (i < v.size()) {
            begin = ( (Integer) v.get(i)).intValue();
            if (i < v.size() - 1) {
                end = ( (Integer) v.get(++i)).intValue();
            }
            else {
                i++;
            }
            flag = false;
            temp = begin;
            while ( (++temp) == end) {
                if (i < v.size() - 1) {
                    end = ( (Integer) v.get(++i)).intValue();
                }
                else {
                    i++;
                }
                flag = true;
            }
            if (flag) {
                if (i <= v.size() - 1) {
                    end = ( (Integer) v.get(i - 1)).intValue();
                }
                strResult = strResult + begin + "-" + end + " ";
            }
            else {
                strResult = strResult + begin + " ";
            }
        }
        return strResult;
    }

    public static String formatSysUpTime(long upTime) {
        long upTimeSecond = upTime / 100;
        long totalHours = upTimeSecond / 3600;
        long days = totalHours / 24;
        long hours = totalHours % 24;
        long delta = upTimeSecond % 3600;
        long minutes = delta / 60;
        long seconds = delta % 60;

      StringBuffer time = new StringBuffer();

      time.append(days).append(ResourceManager.getString("TIMETICK_DAY"));
      time.append(hours).append(ResourceManager.getString("TIMETICK_HOUR"));
      time.append(minutes).append(ResourceManager.getString("TIMETICK_MINUTE"));
      time.append(seconds).append(ResourceManager.getString("TIMETICK_SECOND"));

      return time.toString();
    }

    /**
     * Chang the ifIndex to Octect String.
     */
    public static int generateIfIndex(String s) {
        int intResult = 0;
        if (s.startsWith("vlan")) {
            String temp = s.substring(s.indexOf("vlan") + 4);
            int intTemp = Integer.parseInt(temp);
            intTemp = intTemp << 15;
            intResult = intTemp + 134217728; // bit27
        }
        else if (s.startsWith("lg")) {
            String temp = s.substring(s.indexOf("lg") + 2);
            intResult = (Integer.parseInt(temp) + 128) << 19;
        }
        else {
            StringTokenizer st = new StringTokenizer(s, "/");
            int[] result = new int[st.countTokens()];
            int i = 0;
            while (st.hasMoreTokens()) {
                result[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            String tempModule = Integer.toBinaryString(result[0]);
            String tempPort = Integer.toBinaryString(result[1]);
            while (tempPort.length() < 5) {
                tempPort = "0" + tempPort;
            }
            String tempLogicalPort = "0000000000";
            if (result.length == 3) {
                tempLogicalPort = Integer.toBinaryString(result[2]);
                while (tempLogicalPort.length() < 10) {
                    tempLogicalPort = "0" + tempLogicalPort;
                }
            }
            String tempResult = tempModule + tempPort + tempLogicalPort;
            intResult = Integer.parseInt(tempResult, 2);
        }
        return intResult;
    }

    public static String MacAddressToOctet1(String mac) {
        StringTokenizer st = new StringTokenizer(mac, "-");
        char[] result = new char[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            int n = Integer.parseInt(temp, 16);
            result[i] = (char) n;
            i++;
        }

        return new String(result);
    }

    public static String MacAddressToIndex(String mac) {
    	String index = "";
    	StringTokenizer st = new StringTokenizer(mac, "-");
    	while (st.hasMoreTokens()) {
    		String temp = st.nextToken();
    		int n = Integer.parseInt(temp, 16);
    		index = index + n + ".";
    	}
    	index = index.substring(0, index.length()-1);
    	return index;
    }

    public static String MacAddressToOctet(String mac) {
        StringTokenizer st = new StringTokenizer(mac, "-");
        char[] result = new char[st.countTokens()];
        int i = 0;
        String resultStr = "";
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            int n = Integer.parseInt(temp, 16);
            result[i] = (char) n;
            resultStr = resultStr + temp + ":";
            i++;
        }
        resultStr = resultStr.substring(0, resultStr.length() - 1);
        //String resultStr = new String(result);
        return resultStr;
    }

    public static String generateBitMap(String s) {
        int[] tempInt = transferBitMap(s);
        char[] tempByte = createBytes(tempInt);
        return new String(tempByte);
    }

    public static String generatePortList(String s) {
        int[] tempInt = transferPortList(s);
        char[] tempByte = createBytes(tempInt);
        return new String(tempByte);
    }

    //change portList from display String to int array.
    public static int[] transferPortList(String s) {
        ArrayList v = new ArrayList();
        StringTokenizer st = new StringTokenizer(s, " ");
        Vector v1 = new Vector();
        while (st.hasMoreElements()) {
            String str = st.nextElement().toString();
            v1.add(str);
        }
        for (int i = 0; i < v1.size(); i++) {
            String str = v1.get(i).toString();
            //transfer link aggregation id;
            if (str.startsWith("lg")) {
                int lgId = Integer.parseInt(str.substring(2)) + 48; //link aggregation id need add 12.
                v.add(new Integer(lgId));
                continue;
            }
            if (str.startsWith("ge"))
            	str = str.substring(2);

            //transfer port id;
            st = new StringTokenizer(str, "/");
            Vector tempVector = new Vector();
            while (st.hasMoreElements()) {
                String str1 = st.nextElement().toString();
                tempVector.add(str1);
            }
            String cardStr = tempVector.get(0).toString();
            String portStr = tempVector.get(1).toString();
            Vector cardVector = new Vector();
            Vector portVector = new Vector();
            tempVector = new Vector();
            StringTokenizer st1 = new StringTokenizer(cardStr, "-");
            while (st1.hasMoreElements()) {
                String tempStr = st1.nextElement().toString();
                tempVector.add(tempStr);
            }
            int beginCard = Integer.parseInt(tempVector.get(0).toString());
            int endCard = 0;
            if (tempVector.size() > 1) {
                endCard = Integer.parseInt(tempVector.get(1).toString());
            }
            else {
                endCard = beginCard;
            }
            for (int j = beginCard; j <= endCard; j++) {
                cardVector.add(new Integer(j));
            }
            tempVector = new Vector();
            st1 = new StringTokenizer(portStr, "-");
            while (st1.hasMoreElements()) {
                String tempStr = st1.nextElement().toString();
                tempVector.add(tempStr);
            }
            int beginPort = Integer.parseInt(tempVector.get(0).toString());
            int endPort = 0;
            if (tempVector.size() > 1) {
                endPort = Integer.parseInt(tempVector.get(1).toString());
            }
            else {
                endPort = beginPort;
            }
            for (int j = beginPort; j <= endPort; j++) {
                portVector.add(new Integer(j));
            }

            for (int m = 0; m < cardVector.size(); m++) {
                int cardId = Integer.parseInt(cardVector.get(m).toString());
                for (int n = 0; n < portVector.size(); n++) {
                    int portId = Integer.parseInt(portVector.get(n).toString());
                    int tempInt = (cardId - 1) * 4 + portId;
                    v.add(new Integer(tempInt));
                }
            }
        }
        Object[] aArray = v.toArray();
        Arrays.sort(aArray);
        int[] returnArray = new int[aArray.length];
        for (int i = 0; i < aArray.length; i++) {
            returnArray[i] = Integer.parseInt(aArray[i].toString());
        }
        return returnArray;
    }

    //change the bitMap from display string to int array
    public static int[] transferBitMap(String s) {
        ArrayList v = new ArrayList();
        StringTokenizer st = new StringTokenizer(s, " ");
        Vector v1 = new Vector();
        while (st.hasMoreElements()) {
            String str = st.nextElement().toString();
            if (str.startsWith("vlan")) str = str.substring(4);
            v1.add(str);
        }
        for (int i = 0; i < v1.size(); i++) {
            String str = v1.get(i).toString();
            StringTokenizer st1 = new StringTokenizer(str, "-");
            Vector tempVector = new Vector();
            while (st1.hasMoreElements()) {
                String str1 = st1.nextElement().toString();
                tempVector.add(str1);
            }
            int begin = Integer.parseInt(tempVector.get(0).toString());
            int end = 0;
            if (tempVector.size() > 1) {
                end = Integer.parseInt(tempVector.get(1).toString());
            }
            else {
                end = begin;
            }
            for (int j = begin; j <= end; j++) {
                v.add(new Integer(j));
            }
        }
        Object[] aArray = v.toArray();
        Arrays.sort(aArray);
        int[] returnArray = new int[aArray.length];
        for (int i = 0; i < aArray.length; i++) {
            returnArray[i] = Integer.parseInt(aArray[i].toString());
        }
        return returnArray;
    }

    //create the byte arry send to NE
    private static char[] createBytes(int[] v) {
        if (v==null || v.length == 0) {
            char[] a = new char[1];
            a[0]=0;
            return a;
        }
        int aa = v[v.length - 1];
        int bb = aa / 8;
        if (aa % 8 != 0) {
            bb = bb + 1;

        }
        char[] bytes = new char[bb];
        int bytesCursor = 0;
        int a = 0, b = 0;
        for (int i = 0; i < v.length; i++) {
            b = v[i];
            int delta = b - a;
            int num = delta / 8;
            int num1 = delta % 8;
            if (num1 == 0) {
                num1 = 8;
                num = num - 1;
            }
            bytesCursor = bytesCursor + num;

            bytes[bytesCursor] = (char) (bytes[bytesCursor] + Math.pow(2, num1 - 1));
            a = bytesCursor * 8;
        }
        return bytes;
    }

    /**
     * used by P2P Police ONU list, The ONU list bitmap from left to right indicates ONU logical port 1..64.
     * byte:  |msb byte0 lsb| ... | byte3 | | byte4 | ... | byte7 |
     * onu :   8   ...     1                               64...57
     */
    public static String toOnuP2PString(byte[] b) {
      Vector memberVector = new Vector();
      for(int i = 0; i < b.length; i++)
      {
        for(int j = 0; j < 8; j++)
        {
          if((b[i] & (int)Math.pow(2, j)) != 0)
          {
            int onu = i * 8 + j + 1;
            memberVector.add(new Integer(onu));
          }
        }
      }
      Collections.sort(memberVector);
      return contract(memberVector);
    }

    /**
     * used by P2P Police ONU list, The ONU list bitmap from left to right indicates ONU logical port 1..64.
     * byte:  |msb byte0 lsb| ... | byte3 | | byte4 | ... | byte7 |
     * onu :   8   ...     1                               64...57
     * @param portList
     */
    public static byte[] toOnuBitList(int[] portList)
    {
      byte[] b = new byte[8];

      for(int i = 0; i < portList.length; i++)
      {
        if(portList[i] > 0 && portList[i] <= 64)
        {
          int index = (portList[i]-1)/8;
          int n = (portList[i]-1) % 8;
          int mask = (int)Math.pow(2, n);
          if((b[index] & mask) == 0)//this ONU port isn't added to list yet.
          {
            mask = mask + b[index];
            b[index] = (byte)mask;
          }
        }
      }

      return b;
    }

    public static String to32OnuContraction(byte[] bitMap)
    {
      String contract = null;
      try
      {
        contract = contract(bitMap, 16);
      }
      catch(Exception e)
      {
        contract = "";
      }

      return contract;
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
          for(int j = 0; j < 8; j++)
          {
            if((b[i] & (int)Math.pow(2, j)) != 0)
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

    public static String displayConfigIntfNum(int num) {
        if (num == 5000) {
            return "CPU";
        }
        if (1 <= num && num <= 12) {
            int cardId = num / 4 + 1;
            int portId = num % 4;
            if (portId == 0) {
                portId = 4;
                cardId = cardId - 1;
            }
            return cardId + "/" + portId;
        }
        if (num > 12) {
            return "lg" + (num - 12);
        }
        return "";
    }

    public static int generateConfigIntfNum(String s) {
        s = s.trim();
        if (s.equals("CPU")) {
            return 5000;
        }
        if (s.startsWith("lg")) {
            int temp = Integer.parseInt(s.substring(2));
            return temp + 12;
        }
        StringTokenizer st = new StringTokenizer(s, "/");
        if (st.countTokens() < 2) {
            return 0;
        }
        int cardId = Integer.parseInt(st.nextToken());
        int portId = Integer.parseInt(st.nextToken());
        return (cardId - 1) * 4 + portId;
    }

    public static boolean checkBroadcastAddr(String addr, String mask) {
      int hostaddr = getHostAddress(addr, mask) ;
      StringTokenizer tokenizer = new StringTokenizer(mask, ".") ;
      ArrayList altmp = new ArrayList() ;
      while (tokenizer.hasMoreTokens()) {
        altmp.add(tokenizer.nextToken()) ;
      }
      long maskBites32 = (Long.parseLong((String) altmp.get(0)) << 24)
          | (Long.parseLong((String) altmp.get(1)) << 16)
          | (Long.parseLong((String) altmp.get(2)) << 8)
          | Long.parseLong((String) altmp.get(3)) ;
      if ((~maskBites32 & ((1l << 32) - 1)) - hostaddr > 0) {
        return false ;
      }
      return true ;
    }

    public static int getHostAddress(String ipAddress, String subnetMask) {
      Vector ipVector = new Vector() ;
      Vector maskVector = new Vector() ;
      int[] ipArray = new int[4] ;
      int[] maskArray = new int[4] ;
      // convert String-typed IP address to int-types IP address.
      StringTokenizer tokenizer = new StringTokenizer(ipAddress, ".") ;
      while (tokenizer.hasMoreTokens()) {
        ipVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        ipArray[i] = Integer.parseInt((String) ipVector.get(i)) ;
      }
      // convert String-typed subnetMask to int-types subnetMaks.
      tokenizer = new java.util.StringTokenizer(subnetMask, ".") ;
      while (tokenizer.hasMoreTokens()) {
        maskVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        maskArray[i] = Integer.parseInt((String) maskVector.get(i)) ;
      }
      long ipBites32 = ((long) ipArray[0] << 24) | ((long) ipArray[1] << 16)
          | ((long) ipArray[2] << 8) | (long) ipArray[3] ;
      long maskBites32 = ((long) maskArray[0] << 24)
          | ((long) maskArray[1] << 16) | ((long) maskArray[2] << 8)
          | (long) maskArray[3] ;

      return (int) (ipBites32 & ~maskBites32) ;
    }

    public static boolean checkIP(String addr, String maskAddr) throws Exception {
    	if (addr.trim().indexOf("255") == 0) {
    		throw new Exception("INPUT_IP_START_WITH_255#" + addr) ;
    	}
    	if (ConfigUtility.checkBroadcastAddr(addr, maskAddr)
          || ConfigUtility.checkSubNetworkAddr(addr, maskAddr)) {
    		throw new Exception("INPUT_BROADCAST_OR_SUBNETWORK_ADDRESS#" + addr) ;
    	}
    	return true ;
    }

    /**
     * minip <= ipAddr <= maxip return true; ipAddr < minip or ipAddr > maxip
     * return false;
     */
    public static boolean checkIPScope(String ipAddr, String minip, String maxip)
    {
      int cp1 = ConfigUtility.compareIP(ipAddr, minip) ;
      int cp2 = ConfigUtility.compareIP(ipAddr, maxip) ;
      boolean ret = false ;
      if ((cp1 == 0 || cp1 > 0) && (cp2 == 0 || cp2 < 0))
      {
        ret = true ;
      }
      return ret ;
    }

    public static boolean checkSubNetworkAddr(String addr, String mask) {
      int hostaddr = ConfigUtility.getHostAddress(addr, mask) ;
      if (hostaddr == 0) {
        return true ;
      }
      return false ;
    }

    /**
     * IP1 > IP2 return > 0; IP1 == IP2 return = 0; IP1 < IP2 return < 0;
     */
    public static int compareIP(String ip1, String ip2)
    {
      StringTokenizer tokenizer = new java.util.StringTokenizer(ip1, ".") ;
      ArrayList altmp = Collections.list(tokenizer) ;
      int[] ipArray1 = new int[altmp.size()] ;
      for (int i = 0; i < altmp.size(); i++) {
        ipArray1[i] = Integer.parseInt((String) altmp.get(i)) ;
      }
      tokenizer = new java.util.StringTokenizer(ip2, ".") ;
      altmp = Collections.list(tokenizer) ;
      int[] ipArray2 = new int[altmp.size()] ;
      for (int i = 0; i < altmp.size(); i++) {
        ipArray2[i] = Integer.parseInt((String) altmp.get(i)) ;
      }
      int ret = 0 ;
      if (ipArray1[0] > ipArray2[0]) {
        ret = 1 ;
      }
      else if (ipArray1[0] < ipArray2[0]) {
        ret = -1 ;
      } else {
        if (ipArray1[1] > ipArray2[1]) {
          ret = 1 ;
        }
        else if (ipArray1[1] < ipArray2[1]) {
          ret = -1 ;
        } else {
          if (ipArray1[2] > ipArray2[2]) {
            ret = 1 ;
          }
          else if (ipArray1[2] < ipArray2[2]) {
            ret = -1 ;
          } else {
            if (ipArray1[3] > ipArray2[3]) {
              ret = 1 ;
            }
            else if (ipArray1[3] < ipArray2[3])  {
              ret = -1 ;
            } else {
              ret = 0 ;
            }
          }
        }
      }
      return ret ;
    }

    public static String compareNetMask(String s1, String s2) {
      int n1 = 0, n2 = 0 ;
      int ipByte = 0 ;
      StringTokenizer tokenizer = new java.util.StringTokenizer(s1, ".") ;
      if (tokenizer.countTokens() != 4) {
        return "0.0.0.0" ;
      }
      while (tokenizer.hasMoreTokens()) {
        ipByte = Integer.parseInt(tokenizer.nextToken().toString()) ;
        n1 = (n1 << 8) + ipByte ;
      }
      tokenizer = new java.util.StringTokenizer(s2, ".") ;
      if (tokenizer.countTokens() != 4) {
        return "0.0.0.0" ;
      }
      while (tokenizer.hasMoreTokens()) {
        ipByte = Integer.parseInt(tokenizer.nextToken().toString()) ;
        n2 = (n2 << 8) + ipByte ;
      }
      return (n1 < n2) ? s1 : s2 ;
    }

    public static String getSubnetAddress(String ipAddress, String subnetMask) {
      Vector ipVector = new Vector() ;
      Vector maskVector = new Vector() ;
      int[] ipArray = new int[4] ;
      int[] maskArray = new int[4] ;
      // convert String-typed IP address to int-types IP address.
      StringTokenizer tokenizer = new StringTokenizer(ipAddress, ".") ;
      while (tokenizer.hasMoreTokens()) {
        ipVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        ipArray[i] = Integer.parseInt((String) ipVector.get(i)) ;
      }
      // convert String-typed subnetMask to int-types subnetMaks.
      tokenizer = new java.util.StringTokenizer(subnetMask, ".") ;
      while (tokenizer.hasMoreTokens()) {
        maskVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        maskArray[i] = Integer.parseInt((String) maskVector.get(i)) ;
      }
      long ipBites32 = ((long) ipArray[0] << 24) | ((long) ipArray[1] << 16)
          | ((long) ipArray[2] << 8) | (long) ipArray[3] ;
      long maskBites32 = ((long) maskArray[0] << 24)
          | ((long) maskArray[1] << 16) | ((long) maskArray[2] << 8)
          | (long) maskArray[3] ;
      long subnetAddress = ipBites32 & maskBites32 ;
      long byte1 = (subnetAddress & 0X00000000FF000000) >> 24 ;
      long byte2 = (subnetAddress & 0X0000000000FF0000) >> 16 ;
      long byte3 = (subnetAddress & 0X000000000000FF00) >> 8 ;
      long byte4 = subnetAddress & 0X00000000000000FF ;

      return byte1 + "." + byte2 + "." + byte3 + "." + byte4 ;
    }
    
  public static String[] vlanMapToVlanList(byte[] mibValue)
  {
    Vector v = new Vector();

    if(mibValue != null)
    {
      for(int i = 0; i < mibValue.length; i++)
      {
        for(int j = 7; j >= 0; j--)
        {
          int mask = (int)Math.pow(2, j);
          if((mibValue[i] & mask) != 0)
          {
            v.add("vlan" + (i * 8 + 8 - j));
          }
        }
      }
    }

    return (String[])v.toArray(new String[0]);
  }

  public static byte[] vlanListToVlanMap(String[] list)
  {
    byte[] b = new byte[512];

    if(list != null)
    {
      for(int i = 0; i < list.length; i++)
      {
        int vlan = 0;
        if(list[i].startsWith("vlan"))
        {
          vlan = Integer.parseInt(list[i].substring(4));
        }
        else
        {
          vlan = Integer.parseInt(list[i]);
        }

        int index = (vlan - 1) / 8;
        int mask = (int)Math.pow(2, 7 - (vlan - 1) % 8);
        int value = b[index] + mask;
        b[index] = (byte)value;
      }
    }

    return b;
  }
}
