package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolDefaultRouterTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolExcludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolIncludeTableMBean;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-14
 * Time: 16:49:53
 * To change this template use File | Settings | File Templates.
 */
public class DeleteDHCPInAddrChecker extends BaseChecker  {
    IApplication fApplication;
    String poolName;
    public DeleteDHCPInAddrChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        DHCPPoolIncludeTableMBean mbean = (DHCPPoolIncludeTableMBean) selectedMibBeans[0];
        String lowaddr = mbean.getUtsDHCPPoolIncludedLowIpAddress();
        String highaddr = mbean.getUtsDHCPPoolIncludedHighIpAddress();
        poolName = mbean.getUtsDHCPPoolName();
//        if(isExAddrOverLapped(lowaddr,highaddr)){
//            String error = "Please remove the related excluded IP range first.";
//            MessageDialog.showErrorMessageDialog(getApplication(), error);
//            return false;
//        }
        if(isDefRootin(lowaddr,highaddr))
            return false;


        return true;
    }

    public boolean isExAddrOverLapped(String lowaddr,String highaddr){
        DHCPPoolExcludeTableMBean mbean = new DHCPPoolExcludeTableMBean(fApplication.getSnmpProxy());
        Vector exv = BeanService.refreshTableBean(fApplication,mbean);
        if(exv!=null){
            for(int i=0;i<exv.size();i++){
                DHCPPoolExcludeTableMBean one = (DHCPPoolExcludeTableMBean)exv.get(i);
                String exlowaddr = one.getUtsDHCPPoolExcludedLowIpAddress();
                String exhighaddr = one.getUtsDHCPPoolExcludedHighIpAddress();
                String poolname = one.getUtsDHCPPoolName();
                if (poolname.equals(poolName)) {
   					if (ConfigUtility.checkIPScope(exlowaddr, lowaddr, highaddr) ||
   							ConfigUtility.checkIPScope(exhighaddr, lowaddr, highaddr)) {
   						return true;
   					}
                }
            }
        }

        return false;
    }

    public boolean isDefRootin(String lowaddr,String highaddr){
        DHCPPoolDefaultRouterTable mbean = new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);
        if(v!=null){
            for(int i=0;i<v.size();i++){
                DHCPPoolDefaultRouterTable one = (DHCPPoolDefaultRouterTable)v.get(i);
                if(one.getUtsDHCPPoolName().equals(poolName)){
                    String ip = one.getUtsDHCPPoolDefaultRouterIpAddress();
                    if(ConfigUtility.checkIPScope(ip, lowaddr, highaddr)){
                        String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Include_Default_Route");
                        MessageDialog.showErrorMessageDialog(fApplication, error);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
