package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonPortInfoTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-6
 * Time: 2:20:12
 */
public class PonPortInfoIndexFormatter extends SnmpFieldFormatter {

    public PonPortInfoIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        PonPortInfoTable port = (PonPortInfoTable)aMibBean;
        if(port == null) return null;

        StringBuffer sb = new StringBuffer();

        sb.append(port.getPonDeviceIndex()).append("/").append(port.getPonCardIndex()).append("/").append(port.getPonPortIndex());

        return sb.toString();
    }
}
