/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuEthUniCfgProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class EthernetUniProfileIndexFormatter extends SnmpFieldFormatter {

    public EthernetUniProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) aMibBean;
            return getEthernetUniProfileName(mbean.getOnuEthUniCfgEthernetUNIProfileIndex());
        }

        return "";
    }

    private String getEthernetUniProfileName(long index) {
        OnuEthUniCfgProTable bean = new OnuEthUniCfgProTable(fApplication.getSnmpProxy());
        bean.setOnuEthUniCfgProEthernetUNIProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOnuEthUniCfgProProfileName() != null ? bean.getOnuEthUniCfgProProfileName() : String.valueOf(index));
    }

}