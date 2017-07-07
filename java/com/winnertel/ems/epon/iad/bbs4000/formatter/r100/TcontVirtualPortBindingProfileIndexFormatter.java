/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuServiceConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontVPortBindProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class TcontVirtualPortBindingProfileIndexFormatter extends SnmpFieldFormatter {

    public TcontVirtualPortBindingProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuServiceConfigureMBean) {
            GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) aMibBean;
            return getTcontVirtualPortBindingProfileName(mbean.getOnuCfgTcontVirtualPortBindingProfileIndex());
        }

        return "";
    }

    private String getTcontVirtualPortBindingProfileName(long index) {
		String name = String.valueOf(index);

    	OnuTcontVPortBindProfTable bean = new OnuTcontVPortBindProfTable(fApplication.getSnmpProxy());
        bean.setTcontVirtualPortBindingProfileIndex(index);
        bean.setTcontVirtualPortBindingProfileVirtualPortNo(1); //(It should start from 1.) modified by Zhou Chao, 2009/2/26

		try {
            bean.retrieve();
            name = bean.getOnuTcontVPortBindProfileName() != null ? bean.getOnuTcontVPortBindProfileName() : String.valueOf(index);
		} catch (MibBeanException e) {
		}

		return name;
    }

}