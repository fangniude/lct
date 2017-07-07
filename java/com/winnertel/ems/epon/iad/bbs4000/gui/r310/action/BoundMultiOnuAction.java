package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3UnboundOnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.MultipleOperationSummaryDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.MultipleOperationSummary;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BoundMultiOnuAction extends SnmpAction {
    public BoundMultiOnuAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {

        int selectedRowCount = fTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }

        try {
            fApplication.getTaskManager().executeTask(new BoundMultiOnuTask());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    protected List<Integer> getOnuIdList(int moduleId, int portId) {
        List<Integer> list = new ArrayList<Integer>();

        Dot3Onu2CtcValidOnuMacTable binding = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
        binding.setUtsDot3OnuValidOnuMacModuleId(moduleId);
        binding.setUtsDot3OnuValidOnuMacDeviceId(1);
        binding.setUtsDot3OnuValidOnuMacPortId(portId);
        binding.setUtsDot3OnuValidOnuMacAppLPortId(0);
        binding.setIndexPrefix(moduleId + ".1." + portId + ".");

        Vector v = null;
        try {
            v = binding.retrieveAll();

            for (int i = 0; i < v.size(); i++) {
                Dot3Onu2CtcValidOnuMacTable one = (Dot3Onu2CtcValidOnuMacTable) v.get(i);

                if (isNullMacAddress(one.getUtsDot3ValidOnuMacAddr())) {
                    list.add(one.getUtsDot3OnuValidOnuMacAppLPortId());
                }
            }
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        return list;
    }

    static boolean isNullMacAddress(byte[] mac) {

        for (int i = 0; i < mac.length; i++) {
            if (mac[i] != 0) return false;
        }

        return true;
    }

    class BoundMultiOnuTask extends Task {
      public BoundMultiOnuTask() {
      }

      public Object execute() throws Exception {
          String port = "";
          List list = null;

          SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
          MultipleOperationSummary summary = new MultipleOperationSummary();
          int[] selectedRows = fTable.getSelectedRows();

          for (int i = 0; i < selectedRows.length; i++) {
              Dot3UnboundOnuTable onu = (Dot3UnboundOnuTable) tableModel.getRow(selectedRows[i]);

              int moduleId = onu.getUtsDot3UnboundOnuModuleId();
              int portId = onu.getUtsDot3UnboundOnuPortId();

              String index = moduleId + "/" + portId;
              if (!index.equals(port)) {
                  port = index;
                  list = getOnuIdList(moduleId, portId);
              }

              if (list != null && list.size() > 0) {
                  Dot3Onu2CtcValidOnuMacTable binding = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
                  binding.setUtsDot3OnuValidOnuMacModuleId(moduleId);
                  binding.setUtsDot3OnuValidOnuMacDeviceId(1);
                  binding.setUtsDot3OnuValidOnuMacPortId(portId);
                  binding.setUtsDot3OnuValidOnuMacAppLPortId((Integer) list.remove(0));
                  binding.setUtsDot3ValidOnuMacAddr(onu.getUtsDot3UnboundOnuPonMacAddr());

                  try {
                      binding.modify();
                      summary.add(onu.toString(), (int) Task.COMPLETED);
                  } catch (MibBeanException e1) {
                      e1.printStackTrace();
                      summary.add(onu.toString(), (int) Task.FAILED);
                  }
              } else {
                  summary.add(onu.toString(), (int) Task.FAILED);
              }
          }

          MultipleOperationSummaryDialog summaryDlg = new MultipleOperationSummaryDialog(fApplication, summary);
          summaryDlg.pack();
          summaryDlg.show();

          //
//          RefreshAllAction action = new RefreshAllAction(fApplication);
//          action.setTable(fTable);
//          action.executeAction(null);

          Dot3UnboundOnuTable m=new Dot3UnboundOnuTable(fApplication.getSnmpProxy());
          Vector v=m.retrieveAll();
          tableModel.setDataVector(v);
          fTable.updateUI();
          
          return Boolean.TRUE;
      }
    }
}
