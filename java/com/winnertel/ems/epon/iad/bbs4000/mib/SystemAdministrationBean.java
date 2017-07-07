package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

/**
 * The SystemInfoMbean class.
 * Created by QuickDVM
 */
public class SystemAdministrationBean extends SnmpMibBean {
    public static final String utsBBSSysOperState = "utsBBSSysOperState";
    public static final String utsBBSSaveRunningConfigure = "utsBBSSaveRunningConfigure";
    public static final String utsBBSSysFactoryDefault = "utsBBSSysFactoryDefault";

    public SystemAdministrationBean(ISnmpProxy aSnmpProxy) {
      super(aSnmpProxy);
      init();
    }

    protected void init() {
      initProperty(utsBBSSysOperState, new SnmpMibBeanProperty(utsBBSSysOperState, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.1", ISnmpConstant.INTEGER));
      initProperty(utsBBSSaveRunningConfigure, new SnmpMibBeanProperty(utsBBSSaveRunningConfigure, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.10", ISnmpConstant.INTEGER));
      initProperty(utsBBSSysFactoryDefault, new SnmpMibBeanProperty(utsBBSSysFactoryDefault, ".1.3.6.1.4.1.41355.1800.2.1.1.4.1.23", ISnmpConstant.INTEGER));
    }

    public Integer getUtsBBSSysOperState() {
      return (Integer)getProperty(utsBBSSysOperState).getValue();
    }

    public void setUtsBBSSysOperState(Integer autsBBSSysOperState) {
      getProperty(utsBBSSysOperState).setValue(autsBBSSysOperState);
    }

    public Integer getUtsBBSSaveRunningConfigure() {
      return (Integer)getProperty(utsBBSSaveRunningConfigure).getValue();
    }

    public void setUtsBBSSaveRunningConfigure(Integer autsBBSSaveRunningConfigure) {
      getProperty(utsBBSSaveRunningConfigure).setValue(autsBBSSaveRunningConfigure);
    }

    public Integer getUtsBBSSysFactoryDefault() {
      return (Integer)getProperty(utsBBSSysFactoryDefault).getValue();
    }

    public void setUtsBBSSysFactoryDefault(Integer autsBBSSysFactoryDefault) {
      getProperty(utsBBSSysFactoryDefault).setValue(autsBBSSysFactoryDefault);
    }

    public boolean retrieve() throws MibBeanException {
      prepareRead(super.getProperty(utsBBSSysOperState));
      prepareRead(super.getProperty(utsBBSSaveRunningConfigure));
      prepareRead(super.getProperty(utsBBSSysFactoryDefault));

      return load();
    }

    public boolean modify() throws MibBeanException {
      prepareSave(super.getProperty(utsBBSSysOperState));
      prepareSave(super.getProperty(utsBBSSaveRunningConfigure));
      prepareSave(super.getProperty(utsBBSSysFactoryDefault));
      int tryTimes = fSnmpProxy.getRetries();
      int oldTime = fSnmpProxy.getTimeout();
      try{
        fSnmpProxy.setRetries(1);
        fSnmpProxy.setTimeout(25);
        return save();
      }
      catch(MibBeanException e){
        throw e;
      }
      finally{
        fSnmpProxy.setRetries(tryTimes);
        fSnmpProxy.setTimeout(oldTime);
      }
    }
}
