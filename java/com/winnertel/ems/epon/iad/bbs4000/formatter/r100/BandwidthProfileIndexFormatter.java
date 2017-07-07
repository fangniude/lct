package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuBwProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontSvcProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVPorSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class BandwidthProfileIndexFormatter extends SnmpFieldFormatter{

    public BandwidthProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        if (mibBean instanceof OnuTcontSvcProfTable) {
            OnuTcontSvcProfTable mbean = (OnuTcontSvcProfTable)mibBean;
            return getProfileName(mbean.getUpstreamBandwidthProfileIndex());
        }
        
        if(mibBean instanceof OnuVPorSvcProfTable){
            OnuVPorSvcProfTable mbean = (OnuVPorSvcProfTable)mibBean;
            if(property.equals("downstreamBandwidthProfileIndex"))
            return getProfileName(mbean.getDownstreamBandwidthProfileIndex());
            else 
                return getProfileName(mbean.getOnuVPortSvcProfUpstreamBandwidthProfileIndex());
        }
        return null;
    }

    private String getProfileName(Long index) {
        OnuBwProfTable bean = new OnuBwProfTable(fApplication.getSnmpProxy());
        bean.setBandwidthProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
            e.printStackTrace();
        }
         return (bean.getOnuBwProfileName() != null ? bean.getOnuBwProfileName() : String.valueOf(index));
    }

}
