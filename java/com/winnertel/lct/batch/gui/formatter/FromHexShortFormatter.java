package com.winnertel.lct.batch.gui.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import com.winnertel.lct.batch.gui.TransformUtils;

/**
 * Created by Lewis
 * 2017-07-15.
 */
public class FromHexShortFormatter extends SnmpFieldFormatter {
    public FromHexShortFormatter(IApplication anApplication) {
        super(anApplication);
    }

    @Override
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        return TransformUtils.fromHexShort(String.valueOf(MibBeanUtil.getSimpleProperty(aMibBean, aProperty)));
    }
}
