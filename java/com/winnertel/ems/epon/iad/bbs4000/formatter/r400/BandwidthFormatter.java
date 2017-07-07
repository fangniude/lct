package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 2:34:21
 */
public class BandwidthFormatter extends SnmpFieldFormatter {

    public BandwidthFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Integer band = (Integer)MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if(band == null) return null;

        if(band >= 1000){
            return (band/1000) + "M";
        } else {
            return band + "K";
        }
    }
}
