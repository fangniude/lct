package com.winnertel.em.framework.gui.swing;

import com.winnertel.em.framework.gui.TableHeaderSortable;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class UTableModel extends DefaultTableModel implements TableHeaderSortable {

    protected int[] indexes = null;
    private int sortingColumns = -1;
    private int sortingStatus = NOT_SORTED;
    protected int selectedRow = -1;

    protected static class SortElement implements Comparable {
        public int fRowid = 0;
        public Object fValue = null;
        public boolean fAscending = false;

        public SortElement(int rowid, Object value, boolean ascending) {
            fRowid = rowid;
            fValue = value;
            fAscending = ascending;
        }

        public int compareTo(Object o) {
            if (o != null && o instanceof SortElement) {
                if (fAscending) {
                    return compare((SortElement) o);
                } else {
                    return -1 * compare((SortElement) o);
                }
            }
            return 0;
        }

        private int compare(SortElement anElement) {
            Object o1 = fValue;
            Object o2 = anElement.fValue;
            Class type = o1.getClass();

            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) { // Define null less than everything.
                return -1;
            } else if (o2 == null) {
                return 1;
            }

            if (type.getSuperclass() == java.lang.Number.class) {
                Number n1 = (Number) o1;
                double d1 = n1.doubleValue();
                Number n2 = (Number) o2;
                double d2 = n2.doubleValue();

                if (d1 < d2)
                    return -1;
                else if (d1 > d2)
                    return 1;
                else
                    return 0;
            } else if (type == java.util.Date.class) {
                Date d1 = (Date) o1;
                long n1 = d1.getTime();
                Date d2 = (Date) o2;
                long n2 = d2.getTime();

                if (n1 < n2)
                    return -1;
                else if (n1 > n2)
                    return 1;
                else
                    return 0;
            } else if (type == String.class) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                int result = s1.compareTo(s2);

                if (result < 0)
                    return -1;
                else if (result > 0)
                    return 1;
                else
                    return 0;
            } else if (type == Boolean.class) {
                Boolean bool1 = (Boolean) o1;
                boolean b1 = bool1.booleanValue();
                Boolean bool2 = (Boolean) o2;
                boolean b2 = bool2.booleanValue();

                if (b1 == b2)
                    return 0;
                else if (b1) // Define false < true
                    return 1;
                else
                    return -1;
            } else if (o1 instanceof Comparable) {
                return ((Comparable) o1).compareTo(o2);
            } else {
                Object v1 = o1;
                String s1 = v1.toString();
                Object v2 = o2;
                String s2 = v2.toString();
                int result = s1.compareTo(s2);

                if (result < 0)
                    return -1;
                else if (result > 0)
                    return 1;
                else
                    return 0;
            }
        }

    }

    public UTableModel() {
        super();
    }

    public UTableModel(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public UTableModel(Vector columnNames, int numRows) {
        super(columnNames, numRows);
    }

    public UTableModel(Object[] columnNames, int numRows) {
        super(columnNames, numRows);
    }

    public UTableModel(Vector data, Vector columnNames) {
        super(data, columnNames);
    }

    public UTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void sort(JTable table, int column) {
        if (dataVector == null || dataVector.size() == 0) {
            return;
        }
        int[] backup = null;
        if (indexes != null) {
            backup = (int[]) indexes.clone();
        }
        reallocateIndexes(getRowCount());
        switchSortingStatus(column);
        if (table != null) {
            if (table.getSelectedRow() == -1) {
                selectedRow = 0;
            } else {
                selectedRow = indexes[table.getSelectedRow()];
            }
        }
        basicSort(column, backup);
        super.fireTableChanged(new TableModelEvent(this));
    }

    private void switchSortingStatus(int column) {
        if (column != sortingColumns) {
            sortingStatus = NOT_SORTED;
        }
        sortingColumns = column;
        switch (sortingStatus) {
            case NOT_SORTED:
                sortingStatus = ASCEND_SORTED;
                break;
            case ASCEND_SORTED:
                sortingStatus = DESCEND_SORTED;
                break;
            case DESCEND_SORTED:
                sortingStatus = ASCEND_SORTED;
                break;
        }
    }

    public int getSortStatus(int column) {
        if (column < 0 || column >= getColumnCount() || column != sortingColumns) {
            return NOT_SORTED;
        }
        return sortingStatus;
    }

    protected void reallocateIndexes(int rowCount) {
        if (rowCount == -1) {
            return;
        }
        indexes = new int[rowCount];
        for (int row = 0; row < rowCount; row++)
            indexes[row] = row;
    }

    protected void fillinContent(List values, int sortingColumn) {
        int count = getRowCount();
        for (int x = 0; x < count; x++) {
            values.add(new SortElement(x,
                    getValueAt(x, sortingColumn),
                    getSortStatus(sortingColumn) == ASCEND_SORTED
            )
            );
        }
    }

    protected void basicSort(int sortingColumn, int[] backup) {
        List values = new ArrayList();
        fillinContent(values, sortingColumn);
        Collections.sort(values);
        reorgnize(values, backup);
    }

    private void reorgnize(List values, int[] backup) {
        if (values == null) {
            return;
        }
        boolean found = false;

        indexes = new int[values.size()];
        for (int x = 0; x < values.size(); x++) {
            SortElement tEle = (SortElement) values.get(x);
            indexes[x] = tEle.fRowid;
            if (backup != null) {
                if (backup[selectedRow] == tEle.fRowid && !found) {
                    selectedRow = x;
                    found = true;
                }
            }
        }
    }

    public int getMarkedRow() {
        return selectedRow == -1 ? 0 : selectedRow;
    }
}
