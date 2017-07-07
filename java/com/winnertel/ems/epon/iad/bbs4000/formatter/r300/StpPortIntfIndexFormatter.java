package com.winnertel.ems.epon.iad.bbs4000.formatter.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * @author Yang Yizai , 2009-4-24
 */
public class StpPortIntfIndexFormatter extends SnmpFieldFormatter {

    public StpPortIntfIndexFormatter(IApplication anApplication) {
        super(anApplication);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer portIndex = (Integer)MibBeanUtil.getSimpleProperty(mibBean, property);
        if(portIndex<=48){
        int card = (portIndex - 1)/ 4 + 1;
        int port = (portIndex - 1)% 4 + 1;
        return "ge"+ card + "/" + port;
        }
        else {
            return "lg" + (portIndex - 48);
        }
    }
    
}
