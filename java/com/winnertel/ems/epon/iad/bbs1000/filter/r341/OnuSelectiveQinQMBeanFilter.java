package com.winnertel.ems.epon.iad.bbs1000.filter.r341;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTableFilter;
import com.winnertel.ems.epon.iad.bbs1000.mib.r341.OnuSelectiveQinQMBean;

public class OnuSelectiveQinQMBeanFilter extends SnmpTableFilter {
    @Override
    public boolean filter(SnmpMibBean aMibBean) {
        //remove the olt QinQ item.
        OnuSelectiveQinQMBean bean = (OnuSelectiveQinQMBean) aMibBean;
        if (bean.getUtsDot3OnuSelectiveQinQLogicalPortId() != null && bean.getUtsDot3OnuSelectiveQinQLogicalPortId() == 0) {
            return true;
        } else {
            return false;
        }
    }
}

