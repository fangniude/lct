package com.winnertel.ems.epon.iad.bbs4000.formatter.r216;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.OnuDbaProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuTrafficProfileIdFormatter extends SnmpFieldFormatter {

    public OnuTrafficProfileIdFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer id = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(id == null || id == 0) return 0;

        OnuDbaProfileTable bean = new OnuDbaProfileTable(fApplication.getSnmpProxy());
        bean.setUtsDot3DbaProfileId(id);

        try {
            bean.retrieve();

            if(bean.getUtsDot3DbaProfileName() != null) {
                return bean.getUtsDot3DbaProfileName();
            }

            return id;
        } catch(MibBeanException e) {
            e.printStackTrace();
            return "";
        }
    }
}