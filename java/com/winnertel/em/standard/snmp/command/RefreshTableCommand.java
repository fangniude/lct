package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.task.RefreshAllTask;

import java.util.Vector;

public class RefreshTableCommand extends SnmpTableCommand {
    protected int mode = 0;
    public static final int REFRESH_ALL = 0;
    public static final int REFRESH_SELECTION = 1;

    public RefreshTableCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }

    public RefreshTableCommand(IApplication aApplication, SnmpTable aTable, int mode) {
        super(aApplication, aTable);
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public boolean execute() {
        final SnmpTableModel model = (SnmpTableModel) fTable.getModel();

        final int[] selectRows = fTable.getSelectedRows();

        if (mode == REFRESH_SELECTION) {
            if (selectRows.length > 0) {

                Task t = new RefreshAllTask(model.getMibBean());
                t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while retrieving data from NE"));

                try {
                    fApplication.getTaskManager().executeTask(
                            new Task() {
                                public Object execute() throws Exception {
                                    for (int i = 0; i < selectRows.length; i++) {
                                        SnmpMibBean bean = model.getRow(selectRows[i]);
                                        bean.retrieve();

                                        //set the data, and not fire the listener.
                                        model.getDataVector().setElementAt(bean, selectRows[i]);
                                        model.refreshCache(selectRows[i]);
                                    }
                                    return null;
                                }
                            }
                    );
                    //doesn't show the information dialog when user tries to cancel the operation.
//            if ( t.getStatus() == Task.CANCELED ) {
//                JOptionPane.showMessageDialog( this.fApplication.getTopMostFrame(), "Canceled by User",
//                                "Warning", JOptionPane.PLAIN_MESSAGE );
//                return false;
//            }
                    fTable.updateUI();
                } catch (Exception ex) {
                    MessageDialog.showQueryFailedDialog(fApplication);
                    return false;
                }
            }
        } else {
            Task t = new RefreshAllTask(model.getMibBean());
            t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while retrieving data from NE"));
            Vector dataVector = null;
            try {
                dataVector = (Vector) fApplication.getTaskManager().executeTask(t);
                //doesn't show the information dialog when user tries to cancel the operation.
//            if ( t.getStatus() == Task.CANCELED ) {
//                JOptionPane.showMessageDialog( this.fApplication.getTopMostFrame(), "Canceled by User",
//                                "Warning", JOptionPane.PLAIN_MESSAGE );
//                return false;
//            }
            } catch (Exception ex) {
                MessageDialog.showQueryFailedDialog(fApplication);
                return false;
            }

            model.setDataVector(dataVector);
            fTable.updateUI();

            fTable.clearSelection();
            for (int i = 0; i < selectRows.length; i++) {
                if (selectRows[i] < fTable.getRowCount()) {
                    fTable.addRowSelectionInterval(selectRows[i], selectRows[i]);
                }
            }
        }

        return true;
    }
}
