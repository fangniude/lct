package com.winnertel.em.framework.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.TableHeaderSortable;
import com.winnertel.util.swingx.UBaseTable;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UTable extends JTable implements PropertyChangeListener {
    protected IApplication fApplication = null;

    private static class SortRenderer extends DefaultTableCellRenderer {
        TableHeaderSortable fSort = null;
        private static Icon fAscendIcon = null;
        private static Icon fDescendIcon = null;

        public SortRenderer(TableHeaderSortable sort) {
            fSort = sort;
//            fAscendIcon = new ImageIcon(getClass().getResource("images/Ascend.gif"));
//            fDescendIcon = new ImageIcon(getClass().getResource("images/Descend.gif"));
            fAscendIcon = new ImageIcon(UBaseTable.class.getResource("up.png"));
            fDescendIcon = new ImageIcon(UBaseTable.class.getResource("down.png"));
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {

            JButton header = new JButton(table.getModel().getColumnName(column));
            header.setFont( table.getFont() );
            header.setHorizontalTextPosition(SwingConstants.LEFT);
            header.setPreferredSize(new Dimension(10, 21));
            header.setMargin(new Insets(1, 2, 0, 2));

            header.setText((value == null) ? "" : value.toString());
            header.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            int col = table.convertColumnIndexToModel(column);
            int sortStatus = fSort.getSortStatus(col);
            if (sortStatus == TableHeaderSortable.ASCEND_SORTED) {
                header.setIcon(fAscendIcon);
            } else if (sortStatus == TableHeaderSortable.DESCEND_SORTED) {
                header.setIcon(fDescendIcon);
            } else {
                header.setIcon(null);
            }
//            setHorizontalAlignment(CENTER);
//            setHorizontalTextPosition(LEFT);
            return header;
        }
    }

    public UTable(IApplication anApplication) {
        super();
        fApplication = anApplication;
        init();
    }

    public UTable(IApplication anApplication, UTableModel dm) {
        super(dm);
        fApplication = anApplication;
        init();
    }

    public UTable(UTableModel dm) {
        super(dm);
        init();
    }


    private void init() {
        //getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        adjustWidthAccordingToContent();
        addPropertyChangeListener(this);
        if (getModel() instanceof TableHeaderSortable) {
            addMouseListenerToHeaderInTable();
            prepareRenderer((TableHeaderSortable) getModel());
        }
    }

    private void addMouseListenerToHeaderInTable() {
        setColumnSelectionAllowed(false);
        MouseAdapter listMouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getModifiers() == 16) {
                    TableColumnModel tablecolumnmodel = getColumnModel();
                    int i = tablecolumnmodel.getColumnIndexAtX(e.getX());
                    int j = convertColumnIndexToModel(i);
                    if (e.getClickCount() == 1 && j != -1) {
                        ((TableHeaderSortable) getModel()).sort(UTable.this, j);
                    }
                }
            }
        };
        getTableHeader().addMouseListener(listMouseListener);
    }

    private void prepareRenderer(TableHeaderSortable model) {
//        int colCount = getColumnModel().getColumnCount();
//        for (int x = 0; x < colCount; x++) {
//            getColumnModel().getColumn(x).setHeaderRenderer(new SortRenderer(model));
//        }

        getTableHeader().setDefaultRenderer(new SortRenderer(model));
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("model".equals(evt.getPropertyName())) {
            adjustWidthAccordingToContent();
        }
    }

    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        adjustWidthAccordingToContent();
    }

    private void adjustWidthAccordingToContent() {
        Font font = getFont();
        if (font == null) {
            return;
        }
        FontMetrics fm = getFontMetrics(font);
        int columnCount = getModel().getColumnCount();
        for (int column = 0; column < columnCount; column++) {
            int rowCount = getModel().getRowCount();
            TableColumn tblColumn = getColumnModel().getColumn(column);
            Component comp = null;
            int maxWidth = 0;
            if (tblColumn.getHeaderRenderer() != null) {
                comp = tblColumn.getHeaderRenderer().getTableCellRendererComponent(this, tblColumn.getHeaderValue(), false, false, -1, column);
                maxWidth = comp.getPreferredSize().width;
            } else {
                maxWidth = fm.stringWidth(tblColumn.getHeaderValue().toString());
            }
            // initially set maxWidth to column header width
            for (int row = 0; row < rowCount; row++) {
                String content = getValueAt(row, column).toString();
                int currentWidth = fm.stringWidth(content);
                if (currentWidth > maxWidth) {
                    maxWidth = currentWidth;
                }
            }
            tblColumn.setPreferredWidth(maxWidth + 10);
        }
    }


    public boolean getScrollableTracksViewportWidth() {
        Container parent = getParent();
        if (parent instanceof JViewport) {
            if (parent.getSize().getWidth() < getPreferredSize().getWidth()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public int getMarkedRow() {
        if (getModel() instanceof TableHeaderSortable) {
            return ((TableHeaderSortable) getModel()).getMarkedRow();
        }
        return getSelectedRow() == -1 ? 0 : getSelectedRow();
    }


}
