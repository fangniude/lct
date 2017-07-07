/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltGponProtocolProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltPonLinkCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class ProtocolProfileIndexFormatter extends SnmpFieldFormatter {

    public ProtocolProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof OltPonLinkCfgTable) {
            OltPonLinkCfgTable mbean = (OltPonLinkCfgTable) aMibBean;
            return getProtocolProfileName(mbean.getOltPonLinkCfgProtocolProfileIndex());
        }

        return "";
    }

    private String getProtocolProfileName(long index) {
        OltGponProtocolProfTable bean = new OltGponProtocolProfTable(fApplication.getSnmpProxy());
        bean.setOltGponProtocolProfProtocolPofileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOltGponProtocolProfProfileName() != null ? bean.getOltGponProtocolProfProfileName() : String.valueOf(index));
    }

}