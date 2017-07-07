package com.winnertel.ems.epon.iad.common.mib;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.MibBeanException;

public class OnuMBean extends SnmpMibBean {
    public static final String systemType = "systemType";
    public static final String sysSoftwareVer = "sysSoftwareVer";

    /**
     * @param aSnmpProxy
     */
    public OnuMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(systemType, new SnmpMibBeanProperty(systemType, ".1.3.6.1.4.1.41355.1.3.10.100.106.2.1", ISnmpConstant.STRING));
        initProperty(sysSoftwareVer, new SnmpMibBeanProperty(sysSoftwareVer, ".1.3.6.1.4.1.41355.1.3.10.100.106.2.2", ISnmpConstant.STRING));
    }


    public String getSystemType() {
        return (String) getProperty(systemType).getValue();
    }

    public void setSysMaintLocalFile(String aSysMaintLocalFile) {
        getProperty(systemType).setValue(aSysMaintLocalFile);
    }

    public String getSysSoftwareVer() {
        return (String) getProperty(sysSoftwareVer).getValue();
    }

    public void setSysSoftwareVer(String aSysSoftwareVer) {
        getProperty(sysSoftwareVer).setValue(aSysSoftwareVer);
    }

    public boolean retrieve() throws MibBeanException {
        int timeout = fSnmpProxy.getTimeout();
        int retries = fSnmpProxy.getRetries();


        try {
            fSnmpProxy.setTimeout(1);
            fSnmpProxy.setRetries(1);

//            prepareRead(super.getProperty(systemType));
            prepareRead(super.getProperty(sysSoftwareVer));

            return load();
        } finally {
            fSnmpProxy.setTimeout(timeout);
            fSnmpProxy.setRetries(retries);
        }
    }
}
