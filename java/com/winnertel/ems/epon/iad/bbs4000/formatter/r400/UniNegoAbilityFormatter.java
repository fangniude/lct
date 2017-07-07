package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03842
 * Date: 2007-4-12
 * Time: 14:02:15
 */
public class UniNegoAbilityFormatter extends SnmpFieldFormatter {
    DvmStringMap fStringMap = null;
    public UniNegoAbilityFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        StringBuffer sb = new StringBuffer();
        byte[] value = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(value == null) return null;

        int offset = 0;
        for (int i = 0; i < value.length; i++) {

            int mask = 0x80;
            for(int j = 0; j < 8; j++) {
                if((value[i] & (mask>>j)) != 0) {
                    sb.append(getDisplay(offset)).append(",");
                }

                offset++;
            }
        }
        try{
	        while(','==(sb.charAt(sb.length()-1))){
	        	sb.deleteCharAt(sb.length()-1);
	        }
        }catch(Exception e){}
//        if (sb.length() > 0) {
//            return sb.substring(0, sb.length() - 1);
//        }
        
        return sb.toString();
    }
/*
 				tenBaseTFullDuplex(1),
				tenBaseTHalfDuplex(2),
				hundredBaseTFullDuplex(3),
				hundredBaseTHalfDuplex(4),
				thousandBaseTFullDuplex(5),
				thousandBaseTHalfDuplex(6),
				thousandBaseXFullDuplex(7),
				thousandBaseXHalfDuplex(8),
				fdxPause(9),
				fdxApause(10),
				fdxSpause(11),
				fdxBpause(12)

*/
    private String getDisplay(int value) {
        String strRet = null;
        switch (value) {
            case 1:
                strRet = "tenBaseTFullDuplex";
                break;
            case 2:
                strRet = "tenBaseTHalfDuplex";
                break;
            case 3:
                strRet = "hundredBaseTFullDuplex";
                break;
            case 4:
                strRet = "hundredBaseTHalfDuplex";
                break;
            case 5:
                strRet = "thousandBaseTFullDuplex";
                break;
            case 6:
                strRet = "thousandBaseTHalfDuplex";
                break;
            case 7:
                strRet = "thousandBaseXFullDuplex";
                break;
            case 8:
                strRet = "thousandBaseXHalfDuplex";
                break;
            case 9:
                strRet = "fdxPause";
                break;
            case 10:
                strRet = "fdxApause";
                break;
            case 11:
                strRet = "fdxSpause";
                break;
            case 12:
                strRet = "fdxBpause";
                break;
        }
        if(strRet==null)return "";
        return fStringMap.getString(strRet);
    }
}