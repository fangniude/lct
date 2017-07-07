package com.winnertel.ems.epon.iad.bbs4000.filter.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.OnuSelectiveQinQMBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTableFilter;

/**
 * Created by Li Pengpeng.
 * User: HZ20192
 * Date: 2012-05-16
 */
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
