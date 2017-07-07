package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

//import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtIntfConfigTable;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-29
 * Time: 10:54:32
 * To change this template use File | Settings | File Templates.
 */
public class AddAclConfigChecker   extends BaseChecker  {

    private IApplication fApplication;
    public AddAclConfigChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        AclExtProfileImportTable mbean = new AclExtProfileImportTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);

        if(v!=null){
            if(v.size() == 0){
                error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_No_Profile");
                MessageDialog.showErrorMessageDialog(getApplication(), error);
                return false;
            }

          for(int i = 0; i < v.size(); i++)
          {
            AclExtProfileImportTable bean = (AclExtProfileImportTable)v.get(i);
            {
              if(bean.getUtsAclExtProfileImportProfileId().intValue() <= 32)
              {
                return true;
              }
            }
          }

          //no the profile which id is less than 33.
          error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_No_Profile");
          MessageDialog.showErrorMessageDialog(getApplication(), error);
          return false;
        }

//        AclExtIntfConfigTable cmbean = new AclExtIntfConfigTable(fApplication.getSnmpProxy());
//        Vector v1 = BeanService.refreshTableBean(fApplication,cmbean);
//        if(v1!=null){
//            if(v1.size() == 0){
//                 error = "There is no Interface for you to configure.";
//                MessageDialog.showErrorMessageDialog(getApplication(), error);
//                return false;
//            }
//        }


        return true;
    }
}
