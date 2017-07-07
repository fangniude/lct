/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVirtualPortConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuMacFilterPreassignProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class MacFilterPreassignProfileIndexFormatter extends SnmpFieldFormatter {

    public MacFilterPreassignProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuVirtualPortConfigureMBean) {
            GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) aMibBean;
            return getMACFilterPreassignProfileName(mbean.getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex());
        }

        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getMACFilterPreassignProfileName(mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex());
        }

        return "";
    }

    private String getMACFilterPreassignProfileName(long index) {
        OnuMacFilterPreassignProTable bean = new OnuMacFilterPreassignProTable(fApplication.getSnmpProxy());
        bean.setOnuMacFilterPreassignProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOnuMacFilterPreassignProfileName() != null ? bean.getOnuMacFilterPreassignProfileName() : String.valueOf(index));
    }

}