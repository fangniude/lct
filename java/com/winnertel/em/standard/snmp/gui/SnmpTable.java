package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.gui.swing.UTable;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;

import javax.swing.*;

public class SnmpTable extends UTable {
    private MibBeanIdFormatter fRowIdFormatter;

    private boolean refreshAllAfterAdd = true;
    private boolean refreshAllAfterModify = true;

    public SnmpTable(SnmpTableModel dm) {
        super(dm);
    }


    public void setMultipleSelection(boolean isMultipleSelection) {
        if (isMultipleSelection) {
            setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }

    public boolean isMultipleSelection() {
        if (getSelectionModel().getSelectionMode() == ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) {
            return true;
        } else {
            return false;
        }
    }


    public MibBeanIdFormatter getRowIdFormatter() {
        return fRowIdFormatter;
    }

    public void setRowIdFormatter(MibBeanIdFormatter aRowIdFormatter) {
        fRowIdFormatter = aRowIdFormatter;
    }

    public boolean getRefreshAllAfterAdd() {
        return refreshAllAfterAdd;
    }

    public void setRefreshAllAfterAdd(boolean b) {
        refreshAllAfterAdd = b;
    }

    public boolean getRefreshAllAfterModify() {
        return refreshAllAfterModify;
    }

    public void setRefreshAllAfterModify(boolean b) {
        refreshAllAfterModify = b;
    }
    
    @Override
    public int getSelectedRow(){
    	return convertRowIndexToModel(super.getSelectedRow());
    }
    
    @Override
    public int[] getSelectedRows(){
    	int[] rows = super.getSelectedRows();
    	for (int i = 0; i < rows.length; i++) {
    		rows[i] = convertRowIndexToModel(rows[i]);
		}
    	return rows;
    }
}
