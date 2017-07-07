/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuPotsUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipSvcProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class VoIPServiceProfileIndexFormatter extends SnmpFieldFormatter {

    public VoIPServiceProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuVoipConfigureMBean) {
            GponOnuVoipConfigureMBean mbean = (GponOnuVoipConfigureMBean) aMibBean;
            return getVoIPServiceProfileName(mbean.getOnuCfgOnuVoIPServiceProfileIndex());
        }

        if (aMibBean instanceof GponOnuPotsUniCfgMBean) {
            GponOnuPotsUniCfgMBean mbean = (GponOnuPotsUniCfgMBean) aMibBean;
            return getVoIPServiceProfileName(mbean.getOnuPotsUniCfgOnuVoIPServiceProfileIndex());
        }

        return "";
    }

    private String getVoIPServiceProfileName(long index) {
        GponOnuVoipSvcProTable bean = new GponOnuVoipSvcProTable(fApplication.getSnmpProxy());
        bean.setOnuVoipSvcProfileIndex(index);
        try {
            bean.retrieve();
        } catch (MibBeanException e) {
        }

        return (bean.getOnuVoipSvcProfileName() != null ? bean.getOnuVoipSvcProfileName() : String.valueOf(index));
    }

}