package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonBroadcastStormSuppressionTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 2:31:10
 */
public class PonBsIndexFormatter extends SnmpFieldFormatter {

    public PonBsIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        PonBroadcastStormSuppressionTable bs = (PonBroadcastStormSuppressionTable)aMibBean;
        if(bs == null) return null;

        StringBuffer sb = new StringBuffer();

        sb.append(bs.getBsDeviceIndex()).append("/").append(bs.getBsCardIndex()).append("/").append(bs.getBsPortIndex());

        return sb.toString();
    }
}
