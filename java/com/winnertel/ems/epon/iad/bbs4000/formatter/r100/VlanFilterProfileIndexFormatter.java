/**
 * Created by Zhou Chao, 2009/2/26
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanFilterProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class VlanFilterProfileIndexFormatter extends SnmpFieldFormatter {

    public VlanFilterProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        /* (Reserved)
        if (aMibBean instanceof GponOnuVirtualPortConfigureMBean) {
            GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) aMibBean;
            return getOnuVlanFilterProfileName(mbean.getOnuVirtualPortCfgOnuVlanFilterProfileIndex());
        }
        */

        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getOnuVlanFilterProfileName(mbean.getOnuEthUniCfgOnuVlanFilterProfileIndex());
        }

        return "";
    }

    private String getOnuVlanFilterProfileName(long index) {
        OnuVlanFilterProfileTable bean = new OnuVlanFilterProfileTable(fApplication.getSnmpProxy());
        bean.setOnuVlanFilterProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOnuVlanFilterProfileName() != null ? bean.getOnuVlanFilterProfileName() : String.valueOf(index));
    }

}