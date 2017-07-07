package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * The EponMulticastCtrlGroup class. Created by QuickDVM
 */
public class EponMulticastCtrlGroup extends SnmpMibBean
{
	public static final String utsEponMulticastCtrlIpmcEnable = "utsEponMulticastCtrlIpmcEnable";

	public static final String utsEponMulticastCtrlIgmpSnoopingStatus = "utsEponMulticastCtrlIgmpSnoopingStatus";

	public static final String utsEponMcastCtrlIgmpProxyStatus = "utsEponMcastCtrlIgmpProxyStatus";

	public static final String utsEponMulticastCtrlSuperVidList = "utsEponMulticastCtrlSuperVidList";

	public static final String utsOltCtcMulticastCtrlMode = "utsOltCtcMulticastCtrlMode";

	public EponMulticastCtrlGroup(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
		init();
	}

	protected void init()
	{
		initProperty(utsEponMulticastCtrlIpmcEnable, 
				new SnmpMibBeanProperty( utsEponMulticastCtrlIpmcEnable, ".1.3.6.1.4.1.41355.1800.2.2.1.5.1.1.6", ISnmpConstant.INTEGER));
		initProperty(utsEponMulticastCtrlIgmpSnoopingStatus, 
				new SnmpMibBeanProperty(utsEponMulticastCtrlIgmpSnoopingStatus, ".1.3.6.1.4.1.41355.1800.2.2.1.5.1.1.7", ISnmpConstant.INTEGER));
		initProperty(utsEponMcastCtrlIgmpProxyStatus, 
				new SnmpMibBeanProperty( utsEponMcastCtrlIgmpProxyStatus, ".1.3.6.1.4.1.41355.1800.2.2.1.5.1.1.8", ISnmpConstant.INTEGER));
		initProperty(utsEponMulticastCtrlSuperVidList, 
				new SnmpMibBeanProperty( utsEponMulticastCtrlSuperVidList, ".1.3.6.1.4.1.41355.1800.2.2.1.5.1.1.9", ISnmpConstant.STRING));
		initProperty( utsOltCtcMulticastCtrlMode, 
				new SnmpMibBeanProperty(utsOltCtcMulticastCtrlMode, ".1.3.6.1.4.1.41355.1800.2.4.3.1.3.1.2", ISnmpConstant.INTEGER));
	}

	public Integer getUtsEponMulticastCtrlIpmcEnable()
	{
		return (Integer) getProperty(utsEponMulticastCtrlIpmcEnable).getValue();
	}

	public void setUtsEponMulticastCtrlIpmcEnable(
			Integer aUtsEponMulticastCtrlIpmcEnable)
	{
		getProperty(utsEponMulticastCtrlIpmcEnable).setValue(
				aUtsEponMulticastCtrlIpmcEnable);
	}

	public Integer getUtsEponMulticastCtrlIgmpSnoopingStatus()
	{
		return (Integer) getProperty(utsEponMulticastCtrlIgmpSnoopingStatus)
				.getValue();
	}

	public void setUtsEponMulticastCtrlIgmpSnoopingStatus(
			Integer aUtsEponMulticastCtrlIgmpSnoopingStatus)
	{
		getProperty(utsEponMulticastCtrlIgmpSnoopingStatus).setValue(
				aUtsEponMulticastCtrlIgmpSnoopingStatus);
	}

	public Integer getUtsOltCtcMulticastCtrlMode() {
		return (Integer) getProperty(utsOltCtcMulticastCtrlMode).getValue();
	}

	public void setUtsOltCtcMulticastCtrlMode( Integer autsOltCtcMulticastCtrlMode) {
		getProperty(utsOltCtcMulticastCtrlMode).setValue( autsOltCtcMulticastCtrlMode);
	}

	public Integer getUtsEponMcastCtrlIgmpProxyStatus()
	{
		return (Integer) getProperty(utsEponMcastCtrlIgmpProxyStatus).getValue();
	}

	public void setUtsEponMcastCtrlIgmpProxyStatus( Integer aUtsEponMcastCtrlIgmpProxyStatus)
	{
		getProperty(utsEponMcastCtrlIgmpProxyStatus).setValue( aUtsEponMcastCtrlIgmpProxyStatus);
	}

	public String getUtsEponMulticastCtrlSuperVidList() {
		return bitMapToString("" + getProperty(utsEponMulticastCtrlSuperVidList).getValue());
	}

	public void setUtsEponMulticastCtrlSuperVidList(
			String aUtsEponMulticastCtrlSuperVidList)
	{
		getProperty(utsEponMulticastCtrlSuperVidList).setValue( generateBitMap(aUtsEponMulticastCtrlSuperVidList));
	}

	public boolean retrieve() throws MibBeanException
	{
		prepareRead(super.getProperty(utsEponMulticastCtrlIpmcEnable));
		prepareRead(super.getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
		prepareRead(super.getProperty(utsEponMcastCtrlIgmpProxyStatus));
		prepareRead(super.getProperty(utsEponMulticastCtrlSuperVidList));
		prepareRead(super.getProperty(utsOltCtcMulticastCtrlMode));

		return load();
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsEponMulticastCtrlIpmcEnable));
		prepareSave(getProperty(utsEponMulticastCtrlIgmpSnoopingStatus));
		prepareSave(getProperty(utsEponMcastCtrlIgmpProxyStatus));
		prepareSave(getProperty(utsEponMulticastCtrlSuperVidList));
		prepareSave(getProperty(utsOltCtcMulticastCtrlMode));

		return save();
	}
	
    /*
     * Convert vlan member bitMap to String.
     * From Left to Right
     */
    private String bitMapToString(String mibValue) {
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
            strArray1[2 * i] = String.valueOf(c[0]);
            strArray1[2 * i + 1] = String.valueOf(c[1]);
        }
        for (int i = 0; i < strArray1.length; i++) {
            int tempInt = Integer.parseInt(strArray1[i], 16);
            if ( (tempInt & 0X01) != 0) {
                memberVector.add(new Integer(i * 4 + 4));
            }
            if ( (tempInt & 0X02) != 0) {
                memberVector.add(new Integer(i * 4 + 3));
            }
            if ( (tempInt & 0X04) != 0) {
                memberVector.add(new Integer(i * 4 + 2));
            }
            if ( (tempInt & 0X08) != 0) {
                memberVector.add(new Integer(i * 4 + 1));
            }
        }
        moAttrValue = formatBitMap(memberVector);
        return moAttrValue;
    }
    
    
    private String formatBitMap(Vector v) {
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
    
    private String generateBitMap(String s) {
        int[] tempInt = transferBitMap(s);
        char[] tempByte = createBytes(tempInt);
        return new String(tempByte);
    }
    
    private int[] transferBitMap(String s) {
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
    
    private char[] createBytes(int[] v) {
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
            bytes[bytesCursor] = (char) (bytes[bytesCursor] + Math.pow(2, 8-num1));
            a = bytesCursor * 8;
        }
        return bytes;
    }

}
