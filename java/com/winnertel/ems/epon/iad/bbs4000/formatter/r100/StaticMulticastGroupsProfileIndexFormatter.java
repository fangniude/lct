/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuStaticMultiGroupProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.Vector;

public class StaticMulticastGroupsProfileIndexFormatter extends SnmpFieldFormatter {

    public StaticMulticastGroupsProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        /* (Reserved)
        if (aMibBean instanceof GponOnuServiceConfigureMBean) {
            GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) aMibBean;
            return getStaticMulticastGroupsProfileName(mbean.getOnuCfgOnuStaticMulticastGroupsProfileIndex());
        }
        */

        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getStaticMulticastGroupsProfileName(mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex());
        }

        return "";
    }

    private String getStaticMulticastGroupsProfileName(long index) {
		String name = String.valueOf(index);

    	OnuStaticMultiGroupProfTable bean = new OnuStaticMultiGroupProfTable(fApplication.getSnmpProxy());
        bean.setOnuStaticMultiGroupProfIndex1(index);
        bean.setOnuStaticMultiGroupProfIndex2(0L);
		bean.setIndexPrefix(index + "");
		bean.setRowsToFetch(1);
		try {
			Vector beans = bean.retrieveAll();
			if (beans != null && beans.size() > 0) {
				OnuStaticMultiGroupProfTable aBean = (OnuStaticMultiGroupProfTable) beans.get(0);
				if (aBean != null)
					name = aBean.getOnuStaticMultiGroupProfileName() != null ? aBean.getOnuStaticMultiGroupProfileName() : String.valueOf(index);
			}
		} catch (MibBeanException e) {
		}

		return name;
    }

}