package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.util.BeanService;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-8-28
 * Time: 10:22:24
 * To change this template use File | Settings | File Templates.
 */
public class ModifyIfConfChecker extends BaseChecker  {
    public ModifyIfConfChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(selectedMibBeans[0], "ifIndex");

        String ifIndex = ConfigUtility.formatIfIndex("" + value);

        int idx = ifIndex.indexOf('/');
        if(idx !=-1){
            int card = Integer.parseInt(ifIndex.substring(0, idx));

            BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
            bean.setUtsEponModuleBoardPhyId(card);

            BeanService.refreshBean(fApplication, bean);

            ModuleType moduleType = new ModuleType();

            int type = bean.getUtsEponModuleBoardType();
            if((!moduleType.isGEMModule(type)) && (!moduleType.isXGMModule(type))) {
               String error = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_Forbid_Modify_EPM");
               MessageDialog.showErrorMessageDialog(getApplication(), error);
               return false;
            }
        }
        return true;
    }
}
