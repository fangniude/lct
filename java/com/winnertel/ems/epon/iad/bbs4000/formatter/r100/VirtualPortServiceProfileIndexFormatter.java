package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontVPortBindProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVPorSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class VirtualPortServiceProfileIndexFormatter extends SnmpFieldFormatter{

    public VirtualPortServiceProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    @Override
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        if (mibBean instanceof OnuTcontVPortBindProfTable){
            OnuTcontVPortBindProfTable mbean = (OnuTcontVPortBindProfTable)mibBean;
        return getProfileName(mbean.getVirtualPortServicePr());
        }
        return null;
    }
    
    public String getProfileName(long index){
        OnuVPorSvcProfTable mbean = new OnuVPorSvcProfTable(fApplication.getSnmpProxy());
        mbean.setVirtualPortServiceProfileIndex(index);
        try {
            mbean.retrieve();
           
        } catch (MibBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mbean.getOnuVPorSvcProfileName()!=null?mbean.getOnuVPorSvcProfileName(): String.valueOf(index);
    }

}
