package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.QosExtCosQueueSchedTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Vector;

public class ModifyCosQueueSchedChecker extends BaseChecker  {
    public ModifyCosQueueSchedChecker(IApplication app) {
        super(app);
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        String error = "";
        QosExtCosQueueSchedTable mbean = (QosExtCosQueueSchedTable) selectedMibBeans[0];
        String port = mbean.getUtsMLSQosExtCosQueueSchedModuleId() + "/" + mbean.getUtsMLSQosExtCosQueueSchedPortId();
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