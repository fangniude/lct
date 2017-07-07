package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontSvcProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontVPortBindProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuTcontServiceProfileIndexFormatter extends SnmpFieldFormatter {

    public OnuTcontServiceProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        if (mibBean instanceof OnuTcontVPortBindProfTable){
            OnuTcontVPortBindProfTable mbean = (OnuTcontVPortBindProfTable)mibBean;
        return getProfileName(mbean.getTcontServiceProfileIndex());
        }
        return null;
    }
    
    public String getProfileName(long index){
        OnuTcontSvcProfTable mbean = new OnuTcontSvcProfTable(fApplication.getSnmpProxy());
        mbean.setOnuTcontServiceProfileIndex(index);
        try {
            mbean.retrieve();
           
        } catch (MibBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mbean.getOnuTcontSvcProfileName()!=null?mbean.getOnuTcontSvcProfileName(): String.valueOf(index);
    }

}
