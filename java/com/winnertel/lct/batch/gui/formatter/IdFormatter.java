package com.winnertel.lct.batch.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.lct.batch.bean.*;
import com.winnertel.lct.batch.gui.TransformUtils;

/**
 * Created by Lewis
 * 2017-07-15.
 */
public class IdFormatter extends SnmpFieldFormatter {

    public IdFormatter(IApplication anApplication) {
        super(anApplication);
    }

    @Override
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        String id = String.valueOf(MibBeanUtil.getSimpleProperty(aMibBean, aProperty));
        if (aMibBean instanceof OnuMacBean || aMibBean instanceof OnuCfgBean || aMibBean instanceof ProfileOnuBean) {
            return TransformUtils.disableOnuId(id);
        } else if (aMibBean instanceof OnuUniBean || aMibBean instanceof ProfileUniBean) {
            return TransformUtils.disableUniId(id);
        } else {
            return id;
        }
    }
}
