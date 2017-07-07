/**
 * Created by Zhou Chao, 2009/6/9
 */

package com.winnertel.ems.epon.iad.bbs1000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3Onu2CtcOamExtVersionFormatter extends SnmpFieldFormatter {

    public Dot3Onu2CtcOamExtVersionFormatter(IApplication anApplication) {
        super(anApplication);
    }

    //����豸֧�֡��й����EPON�豸����Ҫ��V1.3���涨��OAM��չ����Ver. Of supported Extension��Ӧ��Ϊ��01.03������0x13��
    //����豸֧�֡��й����EPON�豸����Ҫ��V2.0���涨��OAM��չ����ver. Of 1st supported Extension��Ӧ��Ϊ02.00����0x20��
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        try {
            if (aProperty.equals("utsDot3Onu2CtcOamExtVersion")) {
//                for (int i = 0; i < 4; i++) {
                    if (value == 33)
                        return "2.1"; //0x21(33)
//                }
                    
                    if(value == 0x13)
                    	return "01.03";
                    if(value == 0x20)
                    	return "02.00";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

}