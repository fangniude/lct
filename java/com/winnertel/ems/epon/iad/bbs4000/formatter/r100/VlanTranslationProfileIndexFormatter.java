/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVirtualPortConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltVlanTransProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanTransProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.Vector;

public class VlanTranslationProfileIndexFormatter extends SnmpFieldFormatter {

    public VlanTranslationProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuVirtualPortConfigureMBean) {
            GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) aMibBean;
            return getOltVLANTranslationProfileName(mbean.getOnuVirtualPortCfgoltVLANTranslationProfileIndex());
        }

        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getOnuVLANTranslationProfileName(mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex());
        }

        return "";
    }

    private String getOltVLANTranslationProfileName(long index) {
		String name = String.valueOf(index);

		OltVlanTransProfTable bean = new OltVlanTransProfTable(fApplication.getSnmpProxy());
		bean.setOltVlanTransProfIndex1(index);
		bean.setOltVlanTransProfIndex2(0L);
		bean.setIndexPrefix(index + "");
		bean.setRowsToFetch(1);
		try {
			Vector beans = bean.retrieveAll();
			if (beans != null && beans.size() > 0) {
				OltVlanTransProfTable aBean = (OltVlanTransProfTable) beans.get(0);
				if (aBean != null)
					name = aBean.getOltVlanTransProfileName() != null ? aBean.getOltVlanTransProfileName() : String.valueOf(index);
			}
		} catch (MibBeanException e) {
		}

		return name;
    }

    private String getOnuVLANTranslationProfileName(long index) {
		String name = String.valueOf(index);

		OnuVlanTransProfTable bean = new OnuVlanTransProfTable(fApplication.getSnmpProxy());
		bean.setOnuVlanTransProfIndex1(index);
		bean.setOnuVlanTransProfIndex2(0L);
		bean.setIndexPrefix(index + "");
		bean.setRowsToFetch(1);
		try {
			Vector beans = bean.retrieveAll();
			if (beans != null && beans.size() > 0) {
				OnuVlanTransProfTable aBean = (OnuVlanTransProfTable) beans.get(0);
				if (aBean != null)
					name = aBean.getOnuVlanTransProfileName() != null ? aBean.getOnuVlanTransProfileName() : String.valueOf(index);
			}
		} catch (MibBeanException e) {
		}

		return name;
    }

}