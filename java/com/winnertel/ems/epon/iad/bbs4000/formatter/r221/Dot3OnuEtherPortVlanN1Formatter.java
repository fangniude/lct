package com.winnertel.ems.epon.iad.bbs4000.formatter.r221;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class Dot3OnuEtherPortVlanN1Formatter extends SnmpFieldFormatter {

    public Dot3OnuEtherPortVlanN1Formatter(IApplication anApplication) {
        super(anApplication);
    }

    /**
	  1. utsDot3OnuEtherPortVlanNaggregation
  		512�ֽڵ��ַ����ڿ���֧��5��target vlan, ÿ��target vlan ������10��source vlan aggregation��
 		������ĸ�ʽ��ÿ����2���ֽڣ���s_tpid, s_vlan Ԥ������
			t_tpid1 t_vlan1 s_tpid1 s_vlan1 s_tpid2 s_vlan2 ... s_tpid10 s_vlan10 ...
			t_tpid2 t_vlan2 s_tpid1 s_vlan1 s_tpid2 s_vlan2 ... s_tpid10 s_vlan10 ...
     */
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        byte[] values = (byte[]) MibBeanUtil.getSimpleProperty(mibBean, property);
        
        if(values == null || values.length < 1) return null;

        StringBuffer sb = new StringBuffer();

        int cursor = 0;
        for(int i = 0; i < 5; i++) {
            cursor = i*44;
//            int number = values[cursor++];

            String tpid = Integer.toHexString(((values[cursor++]&0xFF)<<8) | (values[cursor++]&0xFF));
            int tag = ((values[cursor++]&0xFF)<<8) | (values[cursor++]&0xFF);

            sb.append("{").append("[").append(tpid).append(",").append(tag).append("]|");
            
            StringBuffer sbtmp = new StringBuffer();
            int postion = 0;
            for(int j = 0; j < 10; j++) {
//            	tpid = Integer.toHexString(((values[cursor++]&0xFF)<<8) | (values[cursor++]&0xFF));
            	int itpid = ((values[cursor++]&0xFF)<<8) | (values[cursor++]&0xFF);
                tpid = Integer.toHexString(itpid);
                tag = ((values[cursor++]&0xFF)<<8) | (values[cursor++]&0xFF);
                sbtmp.append("[").append(tpid).append(",").append(tag).append("]");
                if(itpid != 0 || tag != 0) postion = sbtmp.length();
            }
            
            if(sbtmp.length() > 0) {
                int bit = sbtmp.indexOf("[", postion);
                sbtmp.delete(bit, sbtmp.length());
            }
            
            sb.append(sbtmp).append("},");
        }



        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}
