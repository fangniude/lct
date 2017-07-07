package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.InterfaceTableGEMtMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-8-28
 * Time: 10:22:24
 * To change this template use File | Settings | File Templates.
 */
public class ModifyGemIfConfChecker extends BaseChecker  {
    public ModifyGemIfConfChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        InterfaceTableGEMtMBean mbean = (InterfaceTableGEMtMBean) selectedMibBeans[0];
        String port = ConfigUtility.formatIfIndex("" + mbean.getIfIndex().intValue());
        LinkAggregation lg = new LinkAggregation(fApplication.getSnmpProxy());
        try
        {
          Vector v = lg.retrieveAll();

          if(v != null)
          {
            for(int i = 0; i < v.size(); i++)
            {
              LinkAggregation bean = (LinkAggregation)v.get(i);

              String[] array = ConfigUtility.portMappingToStringArray(bean.getUtsLagExtDot3adAggPortListPorts());

              for(int j = 0; j < array.length; j++)
              {
                if(array[j].equals(port))
                {
                  IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
                  error = composer.getString("Err_Forbid_Modify_Lg_Port_1") + port + composer.getString("Err_Forbid_Modify_Lg_Port_2");
                  MessageDialog.showErrorMessageDialog(getApplication(), error);

                  return false;
                }
              }
            }
          }
        }catch(Exception e)
        {
          e.printStackTrace();
        }

        return true;
    }
}
