package com.winnertel.ems.epon.util;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

public class ConfigUtility {
    /**
     * convert Octet to Mac address, return Mac address.
     *
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
     *convert vlan member bitMap to String
     */
    public static String bitMapToString(String mibValue) {
        String moAttrValue = null;
        Vector memberVector = new Vector();
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
                memberVector.add(new Integer(i * 4 + 1));
            }
            if ( (tempInt & 0X02) != 0) {
                memberVector.add(new Integer(i * 4 + 2));
            }
            if ( (tempInt & 0X04) != 0) {
                memberVector.add(new Integer(i * 4 + 3));
            }
            if ( (tempInt & 0X08) != 0) {
                memberVector.add(new Integer(i * 4 + 4));
            }
        }
        moAttrValue = formatBitMap(memberVector);
        return moAttrValue;
    }

    /*
     * Convert PortList to String
     * PortList just include 12 ports(4 gsm ports and 8 internal ports)
     * and 32 link aggregation id. So the string length is 6.
     */
    public static String portListToString(String mibValue) {
        String moAttrValue = "";
        Hashtable portTable = new Hashtable();
        Vector groupVector = new Vector();
        
        char[] c = mibValue.toCharArray();
        
        String[] strArray = new String[6];
        for (int k = 0; k < 6; k++) {
            int n = (int) c[k];
            strArray[k] = Integer.toHexString(n);
            if (strArray[k].length() == 1) {
                strArray[k] = "0" + strArray[k];
            }
        }

        String[] strArray1 = new String[12];
        for (int i = 0; i < 6; i++) {
            c = strArray[i].toCharArray();
            strArray1[2 * i] = String.valueOf(c[1]);
            strArray1[2 * i + 1] = String.valueOf(c[0]);
        }
		
        int moudleId = 0;
        //the max number is 11 because the valid bits is 1-44, 
        //and divided by 4 is the String array max length. (12+32/4 = 11)
        for (int i = 0; i < 11; i++) {  
            int tempInt = Integer.parseInt(strArray1[i], 16);
            moudleId++;
            if (tempInt > 0) {
                if (moudleId < 4) {
                    Vector v = new Vector();
                    if ( (tempInt & 0X01) != 0) {
                        v.add("1");
                    }
                    if ( (tempInt & 0X02) != 0) {
                        v.add("2");
                    }
                    if ( (tempInt & 0X04) != 0) {
                        v.add("3");
                    }
                    if ( (tempInt & 0X08) != 0) {
                        v.add("4");
                    }
                    portTable.put(new Integer(moudleId), v);
                }
                else {
                    int base = moudleId - 4;
                    if ( (tempInt & 0X01) != 0) {
                        groupVector.add(new Integer(base * 4 + 1));
                    }
                    if ( (tempInt & 0X02) != 0) {
                        groupVector.add(new Integer(base * 4 + 2));
                    }
                    if ( (tempInt & 0X04) != 0) {
                        groupVector.add(new Integer(base * 4 + 3));
                    }
                    if ( (tempInt & 0X08) != 0) {
                        groupVector.add(new Integer(base * 4 + 4));
                    }
                }
            }
        }
        String temp = "";
        for (int i = 0; i < groupVector.size(); i++) {
            temp = temp + "lg" + groupVector.get(i) + " ";

        }
        moAttrValue = formatPortList(portTable) + " " + temp;

        return moAttrValue;
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

    private static String formatBitMap(Vector v) {
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

        StringBuffer sb = new StringBuffer();
        String lang = Locale.getDefault().getLanguage();
        //chinese
        if(lang != null && lang.equalsIgnoreCase("Chinese"))
        {
          sb.append(days).append("�� ").append(hours).append("Сʱ").append(minutes).append("����").append(seconds).append("��");
        }
        else
        {
          sb.append(days).append("d ").append(hours).append("h:").append(minutes).append("m:").append(seconds).append("s");
        }

        return sb.toString();
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
        String resultStr = new String(result);
        return resultStr;
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
                int lgId = Integer.parseInt(str.substring(2)) + 12; //link aggregation id need add 12.
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
     * used by P2P Police ONU list, convert bit map string to display string.

     * @param mibValue
     * @return
     */
    public static String toOnuP2PString(String mibValue) {
      byte[] b = null;

      try
      {
        b = mibValue.getBytes("ISO-8859-1");
      }
      catch(Exception e)
      {
        b = new byte[0];
      }

      Vector memberVector = new Vector();
      for(int i = 0; i < b.length; i++)
      {
        for(int j = 0; j < 8; j++)
        {
          if((b[i] & (int)Math.pow(2, j)) != 0)
          {
            int onu = (i/4 +1) * 32 - (i%4) * 8 -7 + j;
            memberVector.add(new Integer(onu));
          }
        }
      }
      Collections.sort(memberVector);
      String moAttrValue = formatBitMap(memberVector);
      return moAttrValue;
    }

    /**
     * used by P2P Police ONU list.
     * byte:  |msb byte0 lsb| ... | byte3 | | byte4 | ... | byte7 |
     * onu :   32   ...   25       8 ... 1   64...57       40...33
     * @param portList
     * @return
     */
    public static String toOnuBitList(int[] portList)
    {
      byte[] b = new byte[8];
      
      for(int i = 0; i < portList.length; i++)
      {
        if(portList[i] > 0 && portList[i] <= 64)
        {
          int index = 4 * ((portList[i]-1)/32) + 3 - ((portList[i]-1)%32) / 8;
          int n = (portList[i]-1) % 8;
          int mask = (int)Math.pow(2, n);
          if((b[index] & mask) == 0)//this ONU port isn't added to list yet.
          {
            mask = mask + b[index];
            b[index] = (byte)mask;
          }
        }
      }

      String s = null;
      try
      {
        s = new String(b, "ISO-8859-1");
      }
      catch(Exception e)
      {
        s = new String(b);
      }

      return s;
    }

    /**
     * used by NE 2.31.0, which only supports 32 ONUs under one OLT port.
     * @param portRange
     * @return
     */
    public static String to32BitMap(String portRange)
    {
      return toBitMap(portRange, 32);
    }
    
    /**
     * used by NE 2.32.1, which supports 64 ONUs under one OLT port.
     * @param portRange
     * @return
     */
    public static String to64BitMap(String portRange)
    {
      return toBitMap(portRange, 64);
    }
    
    /**
     * Convert port range (used in EMS) to bit map (used in NE).
     * Used in ONU FW Upgrade manager class.
     * size - the Max number of ONU in one OLT port. 
     */
    protected static String toBitMap(String portRange, int size)
    {
      //if the size is wrong, correct.
      if(size <= 32)
        size = 32;
      else
        size = 64;
      
      int portByteSize = size/8; //8- 1byte = 8bit
      int cardByteSize = portByteSize * 4; //each LTM card has 4 ports in BBS1000.
      String bitMap = null;
      byte[] data = new byte[size]; // BBS1000 has 512 ONU ports.
        
      if (portRange == null || portRange.equals("") ) {
        bitMap = new String(data);
        return bitMap;
      }
    
      int beginModule = 0;
      int endModule = 0;
      int beginPort = 0;
      int endPort = 0;
      int beginLogicalPort = 0;
      int endLogicalPort = 0;

      Vector tokens = new Vector();
      StringTokenizer tokenizer = new StringTokenizer(portRange, "/");
      while (tokenizer.hasMoreElements()) {
          String token = tokenizer.nextToken();
          tokens.add(token);
      }

      // parse module id.
      Vector modules = new Vector();
      tokenizer = new StringTokenizer( (String) tokens.get(0), "-");
      while (tokenizer.hasMoreElements()) {
          String token = tokenizer.nextToken();
          modules.add(token);
      }
      beginModule = Integer.parseInt( (String) modules.get(0));
      if ( modules.size() > 1 )
        endModule = Integer.parseInt( (String) modules.get(1));
      else 
        endModule = beginModule;

      // parse port id.
      Vector ports = new Vector();
      tokenizer = new StringTokenizer( (String) tokens.get(1), "-");
      while (tokenizer.hasMoreElements()) {
          String token = tokenizer.nextToken();
          ports.add(token);
      }
      beginPort = Integer.parseInt( (String) ports.get(0));
      if ( ports.size() > 1 )
        endPort = Integer.parseInt( (String) ports.get(1));
      else
        endPort = beginPort;
    
      // parse logical port id.
      Vector logicalPorts = new Vector();
      tokenizer = new StringTokenizer( (String) tokens.get(2), "-");
      while (tokenizer.hasMoreElements()) {
          String token = tokenizer.nextToken();
          logicalPorts.add(token);
      }
      beginLogicalPort = Integer.parseInt( (String) logicalPorts.get(0));
      if ( logicalPorts.size() > 1 )
        endLogicalPort = Integer.parseInt( (String) logicalPorts.get(1));
      else
        endLogicalPort = beginLogicalPort;
    
      int temp = 0;
      if (beginModule > endModule) {
          temp = beginModule;
          beginModule = endModule;
          endModule = temp;
      }
      if (beginPort > endPort) {
          temp = beginPort;
          beginPort = endPort;
          endPort = temp;
      }
      if (beginLogicalPort > endLogicalPort) {
          temp = beginLogicalPort;
          beginLogicalPort = endLogicalPort;
          endLogicalPort = temp;
      }
      
      // encode bit map
      for(int i = beginModule; i <= endModule; i++)
      {
        for(int j = beginPort; j <= endPort; j++)
        {
          for(int k = beginLogicalPort; k <= endLogicalPort; k++)
          {
            int index = (i-1) * cardByteSize + j * portByteSize - (k-1)/8 -1;
            int n = (k -1) % 8;
            int value = data[index] + (int)Math.pow(2, n);
            data[index] = (byte)value;
          }
        }
      }

      try
      {
        bitMap = new String(data, "ISO-8859-1");
      }
      catch(Exception e)
      {
        bitMap = new String(bitMap);
      }
      return bitMap;
    }

    public static String to32OnuRange(String bitMap)
    {
      return toOnuRange(bitMap, 32);
    }
    
    public static String to64OnuRange(String bitMap)
    {
      return toOnuRange(bitMap, 64);
    }
    
    /**
     * Convert bit map (used in NE) to port range (used in EMS).
     * Used in ONU FW upgrade manager class.
     */
    protected static String toOnuRange(String bitMaps, int size)
    {
      if(size <= 32)
        size = 32;
      else
        size = 64;
      
      if (bitMaps == null || bitMaps.equals("")) {
          return "";
      }
                
      int portByteSize = size/8; //8- 1byte = 8bit
      int cardByteSize = portByteSize * 4; //each LTM card has 4 ports in BBS1000.

      //Port range format: module-module/port-port/logical port-logical port.
      String portRange = null;
      int beginModule = 0;
      int endModule = 0;
      int beginPort = 0;
      int endPort = 0;
      int beginLogicalPort = 0;
      int endLogicalPort = 0;

      byte[] b = null;
      try
      {
        b = bitMaps.getBytes("ISO-8859-1");
      }
      catch(Exception e)
      {
        return "";
      }
      
      for(int i = 0; i < b.length; i++)
      {
        if(b[i] != 0)
        {
          int card = i/cardByteSize + 1;
          if(beginModule == 0)
          {
            beginModule = card;
            endModule = card;
          }
          else if(card > endModule)
          {
            endModule = card;
          }

          int port = i/portByteSize + 1 - (card - 1) * 4;
          if(beginPort == 0)
          {
            beginPort = port;
            endPort = port;
          }
          else if(port > endPort)
          {
            endPort = port;
          }
          
          
          for(int j = 0; j < 8; j++)
          {
            if((b[i] & (int)Math.pow(2, j)) != 0)
            {
              int onu = size - (i%(size/8)) * 8 + j -7;
              if(beginLogicalPort == 0)
              {
                beginLogicalPort = onu;
                endLogicalPort = onu;
              }
              if(onu < beginLogicalPort)
              {
                beginLogicalPort = onu;
              }
              
              if(onu > endLogicalPort)
              {
                endLogicalPort = onu;
              }
            }
          }
        }
      }
      
      if(beginModule ==0)
        return "";
      
      if (beginModule == endModule) 
      	portRange = beginModule +  "/";
      else
        portRange = beginModule + "-" + endModule + "/";
      
      if (beginPort == endPort)
      	portRange = portRange + beginPort + "/";
      else
        portRange = portRange + beginPort + "-" + endPort + "/";
      
      if (beginLogicalPort == endLogicalPort)
      	portRange = portRange + beginLogicalPort;
      else
        portRange = portRange + beginLogicalPort + "-" + endLogicalPort;
           
      return portRange;
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
        if (13 <= num && num <= 44) {
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
        int ipByte = Integer.parseInt((String) ipVector.get(i)) ;
        ipArray[i] = ipByte ;
      }
      // convert String-typed subnetMask to int-types subnetMaks.
      tokenizer = new StringTokenizer(subnetMask, ".") ;
      while (tokenizer.hasMoreTokens()) {
        maskVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        int ipByte = Integer.parseInt((String) maskVector.get(i)) ;
        maskArray[i] = ipByte ;
      }
      long ipBites32 = ((long) ipArray[0] << 24) | ((long) ipArray[1] << 16)
          | ((long) ipArray[2] << 8) | (long) ipArray[3] ;
      long maskBites32 = ((long) maskArray[0] << 24)
          | ((long) maskArray[1] << 16) | ((long) maskArray[2] << 8)
          | (long) maskArray[3] ;
      int hostAddress = (int) (ipBites32 & ~maskBites32) ;
      return hostAddress ;
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
      StringTokenizer tokenizer = new StringTokenizer(ip1, ".") ;
      ArrayList altmp = Collections.list(tokenizer) ;
      int[] ipArray1 = new int[altmp.size()] ;
      for (int i = 0; i < altmp.size(); i++) {
        ipArray1[i] = Integer.parseInt((String) altmp.get(i)) ;
      }
      tokenizer = new StringTokenizer(ip2, ".") ;
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
      StringTokenizer tokenizer = new StringTokenizer(s1, ".") ;
      if (tokenizer.countTokens() != 4) {
        return "0.0.0.0" ;
      }
      while (tokenizer.hasMoreTokens()) {
        ipByte = Integer.parseInt(tokenizer.nextToken().toString()) ;
        n1 = (n1 << 8) + ipByte ;
      }
      tokenizer = new StringTokenizer(s2, ".") ;
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
        int ipByte = Integer.parseInt((String) ipVector.get(i)) ;
        ipArray[i] = ipByte ;
      }
      // convert String-typed subnetMask to int-types subnetMaks.
      tokenizer = new StringTokenizer(subnetMask, ".") ;
      while (tokenizer.hasMoreTokens()) {
        maskVector.add(tokenizer.nextToken()) ;
      }
      for (int i = 0; i < 4; i++) {
        int ipByte = Integer.parseInt((String) maskVector.get(i)) ;
        maskArray[i] = ipByte ;
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
      String subnetAddressStr = byte1 + "." + byte2 + "." + byte3 + "." + byte4 ;
      return subnetAddressStr ;
    }
    
    public static String transIntToIP(int var){
        int mask = 0X00000001 ;
        int value = 0X00000000 ;
        for (int i = 31; i > 0; i = i - 2)
        {
          int temp = var & mask ;
          temp = temp << i ;
          value = value | temp ;
          mask = mask << 1 ;
        }
        for (int i = 1; i < 32; i = i + 2)
        {
          int temp = var & mask ;
          temp = temp >>> i ;
          value = value | temp ;
          mask = mask << 1 ;
        }
        int seg1 = value & 0XFF000000 ;
        seg1 = seg1 >>> 24 ;
        int seg2 = value & 0X00FF0000 ;
        seg2 = seg2 >>> 16 ;
        int seg3 = value & 0X0000FF00 ;
        seg3 = seg3 >>> 8 ;
        int seg4 = value & 0X000000FF ;
        return Integer.toString(seg1) + "." + Integer.toString(seg2) + "."
            + Integer.toString(seg3) + "." + Integer.toString(seg4) ;
      }

  public static List parseLgPortList(String mibValue)
  {
    List portList = new ArrayList();

    try
    {
      byte[] b = mibValue.getBytes("ISO-8859-1");

      for(int i = 0; i < b.length; i++)
      {
        for(int j = 0; j < 8; j++)
        {
          int mask = (int)Math.pow(2, j);

          if((b[i] & mask) != 0)
          {
            int cardId = i * 2 + j / 4 + 1;
            int portId = j % 4 + 1;
            portList.add(cardId + "/" + portId);
          }
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return portList;
  }

}
