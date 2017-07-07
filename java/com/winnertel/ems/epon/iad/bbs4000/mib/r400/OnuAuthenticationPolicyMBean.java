/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

public class OnuAuthenticationPolicyMBean extends SnmpMibBean {

    public static final String onuAuthenticationPolicy = "onuAuthenticationPolicy";

    public OnuAuthenticationPolicyMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuAuthenticationPolicy, new SnmpMibBeanProperty(onuAuthenticationPolicy, ".1.3.6.1.4.1.17409.2.3.4.5.1", ISnmpConstant.INTEGER));
    }

    public Integer getOnuAuthenticationPolicy() {
        return (Integer) getProperty(onuAuthenticationPolicy).getValue();
    }

    public void setOnuAuthenticationPolicy(Integer aUniMacAddrAgingTime) {
        getProperty(onuAuthenticationPolicy).setValue(aUniMacAddrAgingTime);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuAuthenticationPolicy));

        return load();
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuAuthenticationPolicy));

        return save();
    }

}