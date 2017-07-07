package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-6-8
 * Time: 15:57:13
 * To change this template use File | Settings | File Templates.
 */
public class OnuVlanPortFormatter extends SnmpFieldFormatter {

    public OnuVlanPortFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(obj == null) return null;

        byte[] tmpObj= (byte[]) obj;

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<tmpObj.length;i=i+2){

            int byte1,byte2;
            byte1=  tmpObj[i]& 0xFF;
            byte2=  tmpObj[i+1]& 0xFF;


            sb.append(byte1).append("/");
            sb.append(byte2);

            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args){

    }
}
