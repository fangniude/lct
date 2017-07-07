package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.gui.swing.UTableModel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;
import org.apache.commons.collections.SequencedHashMap;

import javax.swing.event.TableModelEvent;
import java.util.*;

public class SnmpTableModel extends UTableModel {
    private ILogger fLogger = LoggerController.createLogger(SnmpTableModel.class);

    private SnmpMibBean fMibBean = null;

    private Vector fFieldList = null;

    private SnmpTableFilter fFilter = null;

    private boolean fMarkable = false;

    private Object[][] fDataCache = null;


    public SnmpTableModel(Vector aFieldList, SnmpMibBean aMibBean, SnmpTableFilter aFilter, boolean markable) {
        fFieldList = aFieldList;
        fMibBean = aMibBean;
        fFilter = aFilter;
        fMarkable = markable;
        indexes = new int[0];
    }


    public String getColumnName(int column) {
        if (fMarkable) {
            if (column == 0) {
                return "";
            } else {
                return ((SnmpField) fFieldList.get(column - 1)).getLabel();
            }
        } else {
            return ((SnmpField) fFieldList.get(column)).getLabel();
        }
    }

    public int getColumnCount() {
        return fFieldList.size() + (fMarkable ? 1 : 0);
    }


    public Class getColumnClass(int column) {
        if (fMarkable && column == 0) {
            return Boolean.class;
        } else {
            return Object.class;
        }
    }


    public boolean isCellEditable(int row, int column) {
        if (fMarkable && column == 0) {
            return true;
        } else {
            return false;
        }
    }


    public void setValueAt(Object aValue, int row, int column) {
        // only mark column is not readonly
        fDataCache[row][column] = aValue;
    }

    public Object getValueAt(int row, int column) {
        Object result = null;
        //to get the index after sort
        row = indexes[row];
        // retrieve from cache
        result = fDataCache[row][column];

        // if cache is empty, get a display value and set into cache
        if (result == null) {
            if (fMarkable) {
                result = getDisplayValue(row, column - 1);
            } else {
                result = getDisplayValue(row, column);
            }
            if (result == null) {
                result = "";
            }
            fDataCache[row][column] = result;
        }

        return result;
    }

    private Object getDisplayValue(int row, int column) {
        Object result = null;
        SnmpMibBean bean = (SnmpMibBean) getDataVector().get(row);
        SnmpField field = (SnmpField) fFieldList.get(column);
        Map valueMap = field.getValueMap();
        SnmpFieldFormatter formatter = field.getFormatter();
        SnmpFieldReference ref = field.getReference();
        String property = field.getMibProperty();
        try {
            // use formatter first if any
            if (formatter != null) {
                return formatter.format(bean, property);
            }

            // get original value
            result = MibBeanUtil.getSimpleProperty(bean, property);

            if (result == null)
                return null;

            // use value map if any
            if (valueMap != null) {
                Object o = valueMap.get(result.toString());
                return o != null ? o : result.toString();
            }

            // handle reference if any
            if (ref != null) {
                SnmpMibBean refBean = ref.getMibBean();
                Properties p = ref.getCondition();
                Enumeration enumProp = p.keys();
                while (enumProp.hasMoreElements()) {
                    String mibProp = (String) enumProp.nextElement();
                    Object value = MibBeanUtil.getSimpleProperty(bean, mibProp);

                    String refMibProp = p.getProperty(mibProp);
                    MibBeanUtil.setSimpleProperty(refBean, refMibProp, value);
                }
                refBean.retrieve();

                return MibBeanUtil.getSimpleProperty(refBean, ref.getMibProperty());
            }

            // no formatter, no value map, then return original value
            return result;
        } catch (Exception ex) {
            fLogger.debug("Error in get display value", ex);
            return null;
        }
    }


    public SnmpMibBean getRow(int row) {
        return (SnmpMibBean) getDataVector().get(indexes[row]);
    }

    public void setRow(int row, SnmpMibBean bean) {
        getDataVector().set(indexes[row], bean);
        refreshCache(row);
        fireTableChanged(new TableModelEvent(this, indexes[row], indexes[row]));
    }

    public void refreshCache(int row) {
        row = indexes[row];

        Object result = null;
        for (int i = 0; i < fDataCache[row].length; i++) {
            if (fMarkable) {
                result = getDisplayValue(row, i - 1);
            } else {
                result = getDisplayValue(row, i);
            }
            if (result == null) {
                result = "";
            }
            fDataCache[row][i] = result;
        }
    }

    public SequencedHashMap getRowText(int row) {
        int fieldCount = fFieldList.size();
        SequencedHashMap result = new SequencedHashMap(fieldCount);
        for (int i = 0; i < fieldCount; i++) {
            SnmpField field = (SnmpField) fFieldList.elementAt(i);
            String key = field.getName();
            String value = fMarkable ? fDataCache[row][i + 1].toString() : fDataCache[row][i].toString();
            result.put(key, value);
        }
        return result;
    }


    public void setDataVector(Vector aDataVector) {
        Vector dataVector = getDataVector();
        dataVector.clear();

        if (aDataVector == null || aDataVector.size() == 0) {
        	fireTableDataChanged();
            return;
        }

        resetMibBeanStatus(aDataVector);

        if (fFilter == null) {
            dataVector.addAll(aDataVector);
        } else {
            for (int i = 0; i < aDataVector.size(); i++) {
                SnmpMibBean bean = (SnmpMibBean) aDataVector.elementAt(i);
                if (!fFilter.filter(bean)) {
                    dataVector.add(bean);
                }
            }
        }

        int fieldCount = fFieldList.size() + (fMarkable ? 1 : 0);
        fDataCache = new Object[aDataVector.size()][fieldCount];

        if (fMarkable) {
            // set mark colum value to false
            for (int i = 0; i < fDataCache.length; i++) {
                fDataCache[i][0] = Boolean.FALSE;
            }
        }

        //use dataVector not the fDataCache because of the filter
        //the fDataCache.length <> dataVector.size()
        reallocateIndexes(dataVector.size());

        fireTableDataChanged();
    }

    public void addRows(Vector rowData) {
        Vector dataVector = getDataVector();

        if (rowData == null || rowData.size() == 0) {
            return;
        }

        int oldSize = dataVector.size();

        resetMibBeanStatus(rowData);

        if (fFilter == null) {
            dataVector.addAll(rowData);
        } else {
            for (int i = 0; i < rowData.size(); i++) {
                SnmpMibBean bean = (SnmpMibBean) rowData.elementAt(i);
                if (!fFilter.filter(bean)) {
                    dataVector.add(bean);
                }
            }
        }

        int fieldCount = fFieldList.size() + (fMarkable ? 1 : 0);
        fDataCache = new Object[dataVector.size()][fieldCount];

        if (fMarkable) {
            // set mark colum value to false
            for (int i = 0; i < fDataCache.length; i++) {
                fDataCache[i][0] = Boolean.FALSE;
            }
        }

        //use dataVector not the fDataCache because of the filter
        //the fDataCache.length <> dataVector.size()
        reallocateIndexes(dataVector.size());

        fireTableRowsInserted(oldSize, dataVector.size());
    }

    private void resetMibBeanStatus(Vector aDataVector) {
        int count = aDataVector.size();
        for (int i = 0; i < count; i++) {
            SnmpMibBean mbean = (SnmpMibBean) aDataVector.get(i);
            mbean.resetStatus();
        }
    }


    public SnmpMibBean getMibBean() {
        return fMibBean;
    }


    public SnmpMibBean[] getMarkedData() {
        if (fMarkable == false) {
            return null;
        }

        ArrayList markedList = new ArrayList();
        for (int i = 0; i < fDataCache.length; i++) {
            if (fDataCache[i][0].equals(Boolean.TRUE)) {
                markedList.add(getRow(i));
            }
        }

        SnmpMibBean[] result = new SnmpMibBean[markedList.size()];
        markedList.toArray(result);

        return result;
    }

}
