package com.winnertel.ems.epon.iad.bbs4000.checker.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3OnuClassifiImportTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-29
 * Time: 10:54:32
 * To change this template use File | Settings | File Templates.
 */
public class AddClassifiConfigChecker   extends BaseChecker  {

    private IApplication fApplication;
    public AddClassifiConfigChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        Dot3OnuClassifiImportTable mbean = new Dot3OnuClassifiImportTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication,mbean);

        if(v == null || v.size() == 0){
                error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_No_Classisfication");
                MessageDialog.showErrorMessageDialog(getApplication(), error);
                return false;
        }

        return true;
    }
}
