package com.winnertel.em.framework.gui;

import javax.swing.*;


public interface TableHeaderSortable {
    public final static int NOT_SORTED = 0;
    public final static int ASCEND_SORTED = 1;
    public final static int DESCEND_SORTED = 2;

    /**
     * sort table according to the column
     *
     * @param table
     * @param column
     */
    public void sort(JTable table, int column);

    /**
     * get the status of the sort
     *
     * @param column index of the column
     * @return NOT_SORTED, ASCEND_SORTED, DESCEND_SORTED
     */
    public int getSortStatus(int column);

    /**
     * get the row after sort if there is one row selected
     *
     * @return
     */
    public int getMarkedRow();
}
