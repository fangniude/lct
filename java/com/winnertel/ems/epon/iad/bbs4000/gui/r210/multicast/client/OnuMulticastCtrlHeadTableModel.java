/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlHeadModel;
import com.winnertel.em.framework.IApplication;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Vector;

public class OnuMulticastCtrlHeadTableModel implements TableModel {

    private static IApplication fApplication = null;

    /**
     * create table OnuMulticastCtrlHead (
     * module int NOT NULL,
     * device int default 1 NOT NULL,
     * port int NOT NULL,
     * logical_port int NOT NULL,
     * ether_port int NOT NULL,
     * profile varchar(32) NOT NULL,
     * PRIMARY KEY (module, device, port, logical_port, ether_port, profile)
     * )
     */

    /*
    private String[] columns = new String[]{
            getString("Module ID"),
            //getString("Device ID"), //reserved
            getString("Port ID"),
            getString("Logical Port ID"),
            getString("UNI ID"),
            getString("Profile")
    };
    */
    String[] columns = null;

    private Vector data = new Vector();

    public OnuMulticastCtrlHeadTableModel(IApplication fApplication) {
        super();
        this.fApplication = fApplication;
        columns = new String[]{
                getString("Module ID"),
                //getString("Device ID"), //reserved
                getString("Port ID"),
                getString("Logical Port ID"),
                getString("UNI ID"),
                getString("Profile")
        };
    }

    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    public int getRowCount() {
        if (data == null)
            return 0;

        return data.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        OnuMulticastCtrlHeadModel row = (OnuMulticastCtrlHeadModel) data.get(rowIndex);

        return (columnIndex == 0 ? row.getColumn(columnIndex) : row.getColumn(columnIndex + 1)); //ignore 'device-id'
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        OnuMulticastCtrlHeadModel row = (OnuMulticastCtrlHeadModel) data.get(rowIndex);
        row.setColumn((columnIndex == 0 ? columnIndex : columnIndex + 1), (String) aValue);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener l) {
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void addRow(OnuMulticastCtrlHeadModel model) {
        data.add(model);
    }

    public void removeRow(int rowindex) {
        data.remove(rowindex);
    }

    public OnuMulticastCtrlHeadModel getRow(int index) {
        return ((OnuMulticastCtrlHeadModel) data.get(index));
    }

    public static String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fApplication.getActiveDeviceManager().getGuiComposer().getString(s);
    }

}