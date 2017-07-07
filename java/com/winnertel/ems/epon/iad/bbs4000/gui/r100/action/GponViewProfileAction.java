/**
 * Created by Zhou Chao, 2008/9/30
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.action;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponProfileViewPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public class GponViewProfileAction extends SnmpAction {

    public GponViewProfileAction(IApplication anApplication) {
        super(anApplication);
    }

    public void executeAction(ActionEvent e) throws OperationFailedException, OperationCanceledException, OperationFinishedWithoutLogException {
        SnmpTableModel tableModel = (SnmpTableModel) fTable.getModel();
        int selectedRow = fTable.getSelectedRow();
        //SnmpMibBean bean = (selectedRow >= 0) ? tableModel.getRow(selectedRow) : tableModel.getMibBean();
        if (selectedRow < 0) {
            MessageDialog.showSelectRowDialog(fApplication);
            return;
        }
        SnmpMibBean bean = tableModel.getRow(selectedRow);

        GponProfileViewPanel viewPanel = new GponProfileViewPanel(fApplication);
        if (fPanel.getName() != null && fPanel.getName().trim().length() > 0)
            viewPanel.setName(fPanel.getName());

        if (fDialog == null) {
            String title = fApplication.getActiveDeviceManager().getGuiComposer().getString("View Profile");
            fDialog = new SnmpDialog(fApplication, title, "Custom", "Q");
            ((SnmpDialog) fDialog).setTable(fTable);
            ((SnmpDialog) fDialog).setPanel(viewPanel);
        }

        //use the bean in tableModel directly.
        viewPanel.setModel(bean);
        viewPanel.refresh();
        fDialog.pack();
        fDialog.show();
    }

}