package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UTable;
import com.winnertel.em.framework.gui.swing.UTableModel;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.MultipleOperationSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MultipleOperationSummaryDialog extends UDialog {
    private MultipleOperationSummary fSummary;


    public MultipleOperationSummaryDialog(IApplication app, MultipleOperationSummary aSummary) {
        super(app);
        fSummary = aSummary;

        init();
    }

    protected void init() {
        Vector columnNames = new Vector(2);
        columnNames.add(fApplication.getGlobalStringMap().getString("Operation Object"));
        columnNames.add(fApplication.getGlobalStringMap().getString("Execution Result"));

        UTable table = new UTable(fApplication, new UTableModel(fSummary.getSummaryList(), columnNames)) {
            private final int OPERATION_OBJECT = 0;
            private final int EXECUTION_RESULT = 1;

            public Object getValueAt(int row, int column) {
                Object value = super.getValueAt(row, column);
                switch (column) {
                    case EXECUTION_RESULT:
                        int result = ((Integer) value).intValue();
                        if (result == Task.CANCELED) {
                            return fApplication.getGlobalStringMap().getString("Canceled");
                        } else if (result == Task.COMPLETED) {
                            return fApplication.getGlobalStringMap().getString("Success");
                        } else if (result == Task.FAILED) {
                            return fApplication.getGlobalStringMap().getString("Failure");
                        }
                    default:
                        return value;
                }
            }
        };
        JScrollPane sp = new JScrollPane();
        sp.getViewport().add(table);

        getContentPane().add(sp, BorderLayout.CENTER);

        JPanel controlPane = new JPanel();
        JButton okButton = new JButton(fApplication.getGlobalStringMap().getString("OK"));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MultipleOperationSummaryDialog.this.dispose();
            }
        });
        controlPane.add(okButton);

        getContentPane().add(controlPane, BorderLayout.SOUTH);

        setTitle(fApplication.getGlobalStringMap().getString("Information"));
    }


    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}
