package com.winnertel.em.standard.snmp.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.action.ICommand;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import java.awt.event.ActionEvent;

public abstract class SnmpAction extends BaseAction {
    public interface IType {
        public static final String REFRESH = "Refresh";
        public static final String ADD = "Add";
        public static final String MODIFY = "Modify";
        public static final String MODIFY_BATCH = "ModifyBatch";
        public static final String DELETE = "Delete";
        public static final String DELETE_BATCH = "DeleteBatch";
        public static final String CLOSE = "Close";
        public static final String EXPORT = "Export";
    }

    public interface IAction {
        public static final String PACKAGE = "com.winnertel.em.standard.snmp.action";
        public static final String REFRESH = PACKAGE + ".RefreshAllAction";
        public static final String ADD = PACKAGE + ".AddAction";
        public static final String MODIFY = PACKAGE + ".ModifyAction";
        public static final String DELETE = PACKAGE + ".DeleteAction";
        public static final String CLOSE = PACKAGE + ".CloseAction";
        public static final String EXPORT = PACKAGE + ".ExportAction";
    }

    public static final String COMMAND = "Command";

    protected SnmpTable fTable = null;

    protected UPanel fPanel = null;

    protected UDialog fDialog = null;

    protected ICommand fCommand = null;

    protected BaseChecker fChecker = null;

    public SnmpAction(IApplication anApplication) {
        super(anApplication);
    }


    public void setTable(SnmpTable aTable) {
        fTable = aTable;
    }

    public void setPanel(UPanel aPanel) {
        fPanel = aPanel;
    }


    public void setDialog(UDialog aDialog) {
        fDialog = aDialog;
    }

    public UDialog getDialog() {
        return fDialog;
    }


    public void setCommand(ICommand aCommand) {
        fCommand = aCommand;
    }

    public void setChecker(BaseChecker aChecker) {
        fChecker = aChecker;
    }


    public boolean canExecute(ActionEvent e) {
        if (fChecker != null && fTable != null) {
            SnmpTableModel model = (SnmpTableModel) fTable.getModel();
            int[] indices = fTable.getSelectedRows();//view index
            SnmpMibBean[] selectedMibBeans = new SnmpMibBean[indices.length];
            SnmpMibBean[] data = new SnmpMibBean[model.getDataVector().size()];
            int y = 0;
            for (int x = 0; x < data.length; x++) {
                data[x] = model.getRow(x);
                if (y < indices.length) {
                    if (x == indices[y]) {
                        selectedMibBeans[y++] = model.getRow(x);
                    }
                }
            }

            if (!fChecker.doCheck(data, selectedMibBeans)) {
                return false;
            }
        }
        return true;
    }
}
