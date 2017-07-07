package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-5-21
 * Time: 16:48:01
 * To change this template use File | Settings | File Templates.
 */
public class VlanPortFormatter extends SnmpFieldFormatter {

    public VlanPortFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(obj == null) return null;

        byte[] tmpObj= (byte[]) obj;

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<tmpObj.length;i=i+4){

            int byte1,byte2,byte3,byte4;
            byte1=  tmpObj[i]& 0xFF;
            byte2=  tmpObj[i+1]& 0xFF;
            byte3=  tmpObj[i+2]& 0xFF;
            byte4=  tmpObj[i+3]& 0xFF;

            if (byte2==0x3F){
                sb.append("trunk").append(byte3);
            }
            else{
                sb.append(byte1).append("/");
                sb.append(byte2).append("/");
                sb.append(byte3);

                if (byte4!=0){
                    //sb.append("-").append(byte4);
                }
            }

            sb.append(" ");
        }
            /*
        int index = 0;
        if(obj instanceof Long) {
            index = ((Long)obj).intValue();
        } else {
            index = ((Integer)obj).intValue();
        }

        int[] array = new int[4];

        for(int i = 0; i < array.length; i++) {
            array[array.length-1-i] = index & 0xFF;
            index = index >> 8;
        }

        if(array[0] > 0) {
            sb.append(array[0]).append("/");
        }

        sb.append(array[1]).append("/").append(array[2]);

        if(array[3] != 0) {
            sb.append("/").append(array[3]);
        }*/

        return sb.toString();
    }

    public static void main(String[] args){

    }
}
