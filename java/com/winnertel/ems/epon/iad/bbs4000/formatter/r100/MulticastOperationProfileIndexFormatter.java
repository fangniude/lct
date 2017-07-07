/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMulticastOperProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class MulticastOperationProfileIndexFormatter extends SnmpFieldFormatter {

    public MulticastOperationProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getMulticastOperationProfileName(mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex());
        }

        return "";
    }

    private String getMulticastOperationProfileName(long index) {
        GponOnuMulticastOperProfTable bean = new GponOnuMulticastOperProfTable(fApplication.getSnmpProxy());
        bean.setOnuMulticastOperProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOnuMulticastOperProfileName() != null ? bean.getOnuMulticastOperProfileName() : String.valueOf(index));
    }

}