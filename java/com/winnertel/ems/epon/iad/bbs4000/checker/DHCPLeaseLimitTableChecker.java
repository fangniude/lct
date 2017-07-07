package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-8-28
 * Time: 10:22:24
 * To change this template use File | Settings | File Templates.
 */
public class DHCPLeaseLimitTableChecker extends BaseChecker  {
    public DHCPLeaseLimitTableChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {

//      DHCPGeneral mbean = new DHCPGeneral(fApplication.getSnmpProxy());
//      try {
//          mbean.retrieve();
//      } catch (MibBeanException e) {
//          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      }
//      if (mbean.getUtsDHCPServiceMode().intValue() != 2 ||
//              mbean.getUtsDHCPServiceState().intValue() != 2) {
//          String error = "This operation is only allowed to perform when DHCP Server is active and its mode is SBB.";
//          MessageDialog.showErrorMessageDialog(fApplication, error);
//          return false;
//      }

        return true;
    }
}
