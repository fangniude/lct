/**
 * Created by Zhou Chao, 2008/7/18
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.client;

import com.winnertel.ems.epon.iad.bbs4000.gui.r210.multicast.common.OnuMulticastCtrlProfileModel;
import com.winnertel.em.framework.IApplication;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Vector;

public class OnuMulticastCtrlProfileTableModel implements TableModel {

    private static IApplication fApplication = null;

    /**
     * create table OnuMulticastCtrlProfile (
     * profile varchar(32) NOT NULL,
     * multicast_vlan int NULL,
     * multicast_group_start varchar(15) NULL,
     * multicast_group_end varchar(15) NULL,
     * authentication_type int NULL,
     * PRIMARY KEY (profile)
     * )
     */

    /*
    private String[] columns = new String[]{
            //getString("Profile"),
            getString("MultiCast VLAN"),
            getString("MultiCast Group Start"),
            getString("MultiCast Group End"),
            getString("Authentication Type")
    };
    */
    private String[] columns = null;

    private Vector data = new Vector();

    private int[] utsDot3OnuAuthTypeVList = new int[]{1, 2, 3};
    /*
    private String[] utsDot3OnuAuthTypeTList = new String[]{
            getString("permit"),
            getString("deny"),
            getString("preview"),
    };
    */
    private String[] utsDot3OnuAuthTypeTList = null;

    public OnuMulticastCtrlProfileTableModel(IApplication fApplication) {
        super();
        this.fApplication = fApplication;
        columns = new String[]{
                //getString("Profile"),
                getString("MultiCast VLAN"),
                getString("MultiCast Group Start"),
                getString("MultiCast Group End"),
                getString("Authentication Type")
        };
        utsDot3OnuAuthTypeTList = new String[]{
                getString("permit"),
                getString("deny"),
                getString("preview"),
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
        OnuMulticastCtrlProfileModel row = (OnuMulticastCtrlProfileModel) data.get(rowIndex);
        if (columnIndex == 3)
            return utsDot3OnuAuthTypeTList[getIndexFromValue(utsDot3OnuAuthTypeVList, Integer.parseInt(row.getColumn(columnIndex + 1)))];

        return row.getColumn(columnIndex + 1);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        OnuMulticastCtrlProfileModel row = (OnuMulticastCtrlProfileModel) data.get(rowIndex);
        if (columnIndex == 3)
            row.setColumn(columnIndex, String.valueOf(utsDot3OnuAuthTypeVList[getIndexFromValue(utsDot3OnuAuthTypeTList, String.valueOf(row.getColumn(columnIndex + 1)))]));

        row.setColumn(columnIndex + 1, (String) aValue);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener l) {
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void addRow(OnuMulticastCtrlProfileModel model) {
        data.add(model);
    }

    public void removeRow(int rowindex) {
        data.remove(rowindex);
    }

    public OnuMulticastCtrlProfileModel getRow(int index) {
        return ((OnuMulticastCtrlProfileModel) data.get(index));
    }

    private int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    private int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] != null && v != null && list[i].equals(v))
                return i;
        }

        return 0;
    }

    public static String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fApplication.getActiveDeviceManager().getGuiComposer().getString(s);
    }

}