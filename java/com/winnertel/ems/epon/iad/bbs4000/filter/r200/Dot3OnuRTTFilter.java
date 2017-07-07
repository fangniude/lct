package com.winnertel.ems.epon.iad.bbs4000.filter.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3OnuRTT;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTableFilter;

public class Dot3OnuRTTFilter extends SnmpTableFilter {
    @Override
    public boolean filter(SnmpMibBean aMibBean) {
    	Dot3OnuRTT bean = (Dot3OnuRTT) aMibBean;
        if (bean.getMin() != null && calc(bean.getUtsDot3Onu2CtcRTT()) < bean.getMin())  {
            return true;
        } else if (bean.getMax() != null && calc(bean.getUtsDot3Onu2CtcRTT()) > bean.getMax()) {
            return true;
        }
        return false;
    }
    
    protected int calc(int i) {
        if (i > 60)
            return (int) ((i - 60) * 1.6);
        else
            return 1;
    }
}