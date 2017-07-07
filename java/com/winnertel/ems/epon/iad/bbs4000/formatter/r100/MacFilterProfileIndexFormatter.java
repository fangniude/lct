/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMacFilterProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVirtualPortConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.util.Vector;

public class MacFilterProfileIndexFormatter extends SnmpFieldFormatter {

	public MacFilterProfileIndexFormatter(IApplication anApplication) {
		super(anApplication);
	}

	public Object format(SnmpMibBean aMibBean, String aProperty)
			throws Exception {
		if (aMibBean instanceof GponOnuVirtualPortConfigureMBean) {
			GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) aMibBean;
			return getMACFilterProfileName(mbean.getOnuVirtualPortCfgOnuMACFilterProfileIndex());
		}

		if (aMibBean instanceof GponOnuEthUniCfgMBean) {
			GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
			return getMACFilterProfileName(mbean.getOnuEthUniCfgOnuMACFilterProfileIndex());
		}

		return "";
	}

	private String getMACFilterProfileName(long index) {
		String name = String.valueOf(index);

		GponOnuMacFilterProfTable bean = new GponOnuMacFilterProfTable(fApplication.getSnmpProxy());
		bean.setOnuMacFilterProfIndex1(index);
		bean.setOnuMacFilterProfIndex2(0L);
		bean.setIndexPrefix(index + "");
		bean.setRowsToFetch(1);
		try {
			Vector beans = bean.retrieveAll();
			if (beans != null && beans.size() > 0) {
				GponOnuMacFilterProfTable aBean = (GponOnuMacFilterProfTable) beans.get(0);
				if (aBean != null)
					name = aBean.getOnuMacFilterProfileName() != null ? aBean.getOnuMacFilterProfileName() : String.valueOf(index);
			}
		} catch (MibBeanException e) {
		}

		return name;
	}

}