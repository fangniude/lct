/**
 * Created by Zhou Chao, 2009/11/4
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r216;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.r216.SwitchBufferAdjustmentMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SwitchBufferAdjustmentMbeanPanel extends UPanel {

    private JTable portSelectionTable = null;
    private CustomTableModel portSelectionTableModel = null;

    private JTable cosSelectionTable = null;
    private CustomTableModel cosSelectionTableModel = null;

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public SwitchBufferAdjustmentMbeanPanel(IApplication app) {
        super(app);
        setModel(new SwitchBufferAdjustmentMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SwitchBufferAdjustmentMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        Vector portInfoRowData = new Vector();
        Vector portInfoColumnNames = new Vector();
        portInfoColumnNames.add(fStringMap.getString("Port ID"));
        portInfoColumnNames.add(fStringMap.getString("utsSwitchBufferAdjustmentUplinkPorts"));
        portInfoColumnNames.add(fStringMap.getString("utsSwitchBufferAdjustmentDownlinkPorts"));
        portSelectionTableModel = new CustomTableModel(portInfoRowData, portInfoColumnNames);
        portSelectionTable = new JTable(portSelectionTableModel);
        portSelectionTable.setPreferredScrollableViewportSize(new Dimension(360, 300));
        portSelectionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        portSelectionTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent event) {
                AbstractTableModel model = (AbstractTableModel) event.getSource();
                int type = event.getType();
                switch (type) {
                    case TableModelEvent.UPDATE:
                        int rowIdx = event.getFirstRow();
                        int colIdx = event.getColumn();
                        Boolean isSelectedColumn1 = (Boolean) model.getValueAt(rowIdx, 1); //uplink port
                        Boolean isSelectedColumn2 = (Boolean) model.getValueAt(rowIdx, 2); //downlink port
                        if (colIdx == 1) {
                            if (portSelectionTable.isCellEditable(rowIdx, colIdx) && isSelectedColumn1) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 2);
                            }
                        }
                        if (colIdx == 2) {
                            if (isSelectedColumn2) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
                            }
                        }
                        break;
                }
            }
        });
        JScrollPane portInfoScrollPane = new JScrollPane(portSelectionTable);
        baseInfoPanel.add(portInfoScrollPane);

        Vector cosInfoRowData = new Vector();
        Vector cosInfoColumnNames = new Vector();
        cosInfoColumnNames.add(fStringMap.getString("CoS ID"));
        cosInfoColumnNames.add(fStringMap.getString("utsSwitchBufferAdjustmentUsedCoS"));
        cosInfoColumnNames.add(fStringMap.getString("utsSwitchBufferAdjustmentUsedCoSWeight"));
        cosSelectionTableModel = new CustomTableModel(cosInfoRowData, cosInfoColumnNames);
        cosSelectionTable = new JTable(cosSelectionTableModel);
        cosSelectionTable.setPreferredScrollableViewportSize(new Dimension(360, 150));
        /*
        cosSelectionTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent event) {
                AbstractTableModel model = (AbstractTableModel) event.getSource();
                int type = event.getType();
                switch (type) {
                    case TableModelEvent.UPDATE:
                        int rowIdx = event.getFirstRow();
                        int colIdx = event.getColumn();
                        Boolean isSelectedColumn1 = (Boolean) model.getValueAt(rowIdx, 1);
                        Boolean isSelectedColumn2 = (Boolean) model.getValueAt(rowIdx, 2);
                        if (colIdx == 1) {
                            if (isSelectedColumn1)
                                model.setValueAt(Boolean.FALSE, rowIdx, 2);
                        }
                        if (colIdx == 2) {
                            if (isSelectedColumn2)
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
                        }
                        break;
                }
            }
        });
        */

//        String[] values = new String[100];
//        for (int i = 0; i < 100; i++)
//            values[i] = String.valueOf(i + 1);
//        TableColumn col = cosSelectionTable.getColumnModel().getColumn(2);
//        col.setCellEditor(new MyComboBoxEditor(values));
//        col.setCellRenderer(new MyComboBoxRenderer(values));

//        TableColumn col = cosSelectionTable.getColumnModel().getColumn(2);
//        col.setCellEditor(new MyTextFieldEditor(""));
//        col.setCellRenderer(new MyTextFieldRenderer(""));

        TableColumn col = cosSelectionTable.getColumnModel().getColumn(2);
        col.setCellEditor(new IntegerTextFieldEditor(0, 100));
        col.setCellRenderer(new IntegerTextFieldRenderer());

        JScrollPane cosInfoScrollPane = new JScrollPane(cosSelectionTable);
        baseInfoPanel.add(cosInfoScrollPane);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.SOUTH);
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        HashMap allModuleTypeStrMap = new HashMap();
        BBS4000CardMibBean cardMBean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();
/*
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType();
            int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat();
            int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState();
            //(1) EPM ports only can not be added into downlink ports.
            //(2) Uplink ports and downlink can not conflict.
            if ((moduleType.isGEMModule(moduleBoardType)
                    || moduleType.isEPMModule(moduleBoardType)
                    || moduleType.isCSMModule(moduleBoardType))
                    && modulePhyPreStat == 1 && moduleAdminState == 2) {
                String moduleTypeStr = "";
                if (moduleType.isGEMModule(moduleBoardType))
                    moduleTypeStr = "GEM ";
                else if (moduleType.isEPMModule(moduleBoardType))
                    moduleTypeStr = "EPM ";
                else if (moduleType.isCSMModule(moduleBoardType))
                    moduleTypeStr = "CSM ";
                for (int j = 1; j <= 4; j++) {
                    allPortList.add(moduleTypeStr + moduleBoardPhyId + "/" + j);
                }
            }
        }
*/
        for (int i = 0; i < v.size(); i++) {
            int moduleBoardPhyId = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardPhyId();
            int moduleBoardType = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleBoardType();
            int modulePhyPreStat = ((BBS4000CardMibBean) v.get(i)).getUtsEponModulePhyPresenceStat();
            int moduleAdminState = ((BBS4000CardMibBean) v.get(i)).getUtsEponModuleAdminState();
            if ((moduleType.isGEMModule(moduleBoardType) || moduleType.isEPMModule(moduleBoardType)) && modulePhyPreStat == 1 && moduleAdminState == 2) {
                String moduleTypeStr = "";
                if (moduleType.isGEMModule(moduleBoardType))
                    moduleTypeStr = "GEM ";
                else if (moduleType.isEPMModule(moduleBoardType))
                    moduleTypeStr = "EPM ";
                else if (moduleType.isCSMModule(moduleBoardType))
                    moduleTypeStr = "CSM ";
                for (int j = 1; j <= 4; j++) {
                    allPortList.add(moduleBoardPhyId + "/" + j);
                    allModuleTypeStrMap.put(moduleBoardPhyId + "/" + j, moduleTypeStr);
                }
            }
        }

        EthIfExtTable portMBean = new EthIfExtTable(fApplication.getSnmpProxy());
        Vector portVec = portMBean.retrieveRealAll();
        // remove layer-3 ports and add vlan IDs
        for (int i = 0; i < portVec.size(); i++) {
            EthIfExtTable tmpL2PortTbl = (EthIfExtTable) portVec.elementAt(i);
            String portName = tmpL2PortTbl.getUtsEthIfExtModuleId() + "/" + tmpL2PortTbl.getUtsEthIfExtPortId();
            int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType();
            int switchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode();
            if (tmpPortType == 1) {
                // remove layer-3 ports
                if (switchMode == 2) {
                    allPortList.remove(portName);
                    allModuleTypeStrMap.remove(portName);
                }
            } else if (tmpPortType == 2 && switchMode == 1) { //lg and lay 2.
                allPortList.add("lg" + tmpL2PortTbl.getUtsEthIfExtLinkAggGroupId());
            }
        }

        // remove L2 port that in Link Aggregation set
        LinkAggregation lgMBean = new LinkAggregation(fApplication.getSnmpProxy());
        Vector lgVec = BeanService.refreshTableBean(fApplication, lgMBean);
        if (lgVec == null)
            lgVec = new Vector(0);
        for (int i = 0; i < lgVec.size(); i++) {
            LinkAggregation tmpLGMBean = (LinkAggregation) lgVec.get(i);
            String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());
            for (int j = 0; j < array.length; j++) {
                allPortList.remove(array[j]);
                allModuleTypeStrMap.remove(array[j]);
            }
        }

        // add moudule type
        for (int i = 0; i < allPortList.size(); i++) {
            String moduleTypeStr = allModuleTypeStrMap.get(allPortList.get(i)) != null ? allModuleTypeStrMap.get(allPortList.get(i)).toString() : "";
            allPortList.set(i, moduleTypeStr + allPortList.get(i));
        }

        return allPortList;
    }

    public void refresh() {
        SwitchBufferAdjustmentMBean mbean = (SwitchBufferAdjustmentMBean) getModel();
        if (mbean == null)
            return;

        try {
            BeanService.refreshBean(fApplication, mbean);

            portSelectionTableModel.getDataVector().clear();
            Set uplinkPortList = parsePortListString(mbean.getUtsSwitchBufferAdjustmentUplinkPorts());
            Set downlinkPortList = parsePortListString(mbean.getUtsSwitchBufferAdjustmentDownlinkPorts());
            Vector portList = getPortList();
            for (int i = 0; i < portList.size(); i++) {
                Vector portVector = new Vector();
                String portName = (String) portList.elementAt(i);
                String purePortName = portName.substring(portName.indexOf(" ") + 1);
                portVector.add(portName);
                portVector.add(uplinkPortList.contains(purePortName));
                portVector.add(downlinkPortList.contains(purePortName));
                portSelectionTableModel.addRow(portVector);
            }

            cosSelectionTableModel.getDataVector().clear();
            int[] cosList = parseCosValue(mbean.getUtsSwitchBufferAdjustmentUsedCoS());
            String[] usedCoSWeightList = parseCosWeightListString(mbean.getUtsSwitchBufferAdjustmentUsedCoSWeight());
            //int[] cosList = parseCosValue(131); //test
            //String[] usedCoSWeightList = parseCosWeightListString(new byte[] {0x18, 0x17, 0x16, 0x15, 0x14, 0x13, 0x12, 0x11}); //test
            for (int i = 0; i < 8; i++) {
                Vector cosVector = new Vector();
                cosVector.add("CoS " + i);
                boolean isSelectedCos = (cosList[i] == 1);
                cosVector.add(isSelectedCos);
                cosVector.add(isSelectedCos ? usedCoSWeightList[i] : "0");
                cosSelectionTableModel.addRow(cosVector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateFrom() {
        for (int i = 0; i < portSelectionTable.getModel().getRowCount(); i++) {
            String portName = (String) portSelectionTable.getModel().getValueAt(i, 0);
            Boolean isSelectedColumn1 = (Boolean) portSelectionTable.getModel().getValueAt(i, 1); //uplink port
            if (portName != null && portName.startsWith("EPM") && isSelectedColumn1) {
                MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_EPM_port_cannot_be_added_into_uplink_port_list"));
                return false;
            }
        }

        return true;
    }

    public void updateModel() {
        SwitchBufferAdjustmentMBean mbean = (SwitchBufferAdjustmentMBean) getModel();
        if (mbean == null)
            return;

        byte[] uplinkPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionString(1));
        mbean.setUtsSwitchBufferAdjustmentUplinkPorts(uplinkPorts);

        byte[] downlonkPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionString(2));
        mbean.setUtsSwitchBufferAdjustmentDownlinkPorts(downlonkPorts);

        int usedCos = getCosSelectionValue();
        //byte[] usedCos = getCosSelectionValue();
        mbean.setUtsSwitchBufferAdjustmentUsedCoS(usedCos);

        byte[] usedCosWeight = getCosWeightSelectionString();
        mbean.setUtsSwitchBufferAdjustmentUsedCoSWeight(usedCosWeight);
    }

    private Set parsePortListString(byte[] b) {
        Set portListSet = new HashSet();

        if (b != null) {
            String[] portList = ConfigUtility.portMappingToStringArray(b);
            for (int i = 0; i < portList.length; i++) {
                portListSet.add(portList[i]);
            }
        }

        return portListSet;
    }

    private String[] getPortSelectionString(int colIdx) {
        if (colIdx < 1 || colIdx > 2)
            return new String[0];

        ArrayList list = new ArrayList();
        for (int i = 0; i < portSelectionTableModel.getRowCount(); i++) {
            String portName = (String) portSelectionTableModel.getValueAt(i, 0);
            String purePortName = portName.substring(portName.indexOf(" ") + 1);
            Boolean bValue = (Boolean) portSelectionTableModel.getValueAt(i, colIdx);
            if (bValue) {
                list.add(purePortName);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

//    private String[] parseCosListString(int b) {
//        String[] cosList = new String[8];
//
//        for (int i = 0; i < cosList.length; i++) {
//            char c = Integer.toBinaryString(b).charAt(i);
//            cosList[cosList.length - i - 1] = String.valueOf(c);
//        }
//
//        return cosList;
//    }
//
//    private int getCosSelectionValue_() {
//        int cos = 0;
//
//        char[] cosList = new char[8];
//        for (int i = 0; i < cosSelectionTableModel.getRowCount(); i++) {
//            Boolean bValue = (Boolean) cosSelectionTableModel.getValueAt(i, 1);
//            cosList[cosList.length - i - 1] = bValue ? '1' : '0';
//        }
//        cos = Integer.parseInt(String.valueOf(cosList), 2);
//
//        return cos;
//    }

    private int[] parseCosValue(int cos) {
        int[] cosList = new int[8];

        for (int i = 0; i < cosList.length; i++) {
            cosList[i] = ((cos & (int) Math.pow(2, i)) != 0) ? 1 : 0;
        }

        return cosList;
    }

/*
    private int[] parseCosValue(byte[] b) {
        int cos = 0;
        for (int t = 0; t < b.length; t++) {
            cos |= (b[t] << (8 * t)) & 0x01;
        }

        return parseCosValue(cos);
    }
*/

    private int getCosSelectionValue() {
        int cos = 0;

        for (int i = 0; i < cosSelectionTableModel.getRowCount(); i++) {
            Boolean isSelected = (Boolean) cosSelectionTableModel.getValueAt(i, 1);
            cos += (isSelected ? ((int) Math.pow(2, i)) : 0);
        }

        return cos;
    }

/*
    private byte[] getCosSelectionValue() {
        byte[] cos = new byte[8];

        for (int i = 0; i < cosSelectionTableModel.getRowCount(); i++) {
            Boolean isSelected = (Boolean) cosSelectionTableModel.getValueAt(i, 1);
            cos[i] = (isSelected ? (byte) 1 : 0);
        }

        return cos;
    }
*/

    private String[] parseCosWeightListString(byte[] b) {
        String[] list = new String[8];

        for (int i = 0; i < list.length; i++) {
            list[list.length - i - 1] = String.valueOf(b[i]);
        }

        return list;
    }

    private byte[] getCosWeightSelectionString() {
        byte[] list = new byte[cosSelectionTableModel.getRowCount()];

        for (int i = 0; i < cosSelectionTableModel.getRowCount(); i++) {
            Boolean isSelected = (Boolean) cosSelectionTableModel.getValueAt(i, 1);
            String cosWeight = (String) cosSelectionTableModel.getValueAt(i, 2);
            list[cosSelectionTableModel.getRowCount() - i - 1] = (isSelected ? (byte) Integer.parseInt(cosWeight) : 0);
            //list[cosSelectionTableModel.getRowCount() - i - 1] = (isSelected ? (byte) Integer.parseInt(cosWeight, 16) : 0);
        }

        return list;
    }

    private class CustomTableModel extends DefaultTableModel {

        private boolean bGlobalEditable = true;

        public void setBGlobalEditable(boolean editable) {
            bGlobalEditable = editable;
        }

        public CustomTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        public CustomTableModel(Vector rowData, Vector columnNames) {
            super(rowData, columnNames);
        }

        public Class getColumnClass(int col) {
            //dataVector is a protected member of DefaultTableModel
            Vector v = (Vector) dataVector.elementAt(0);

            return v.elementAt(col).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return !(!bGlobalEditable || col == 0);
        }

    }

    /*
    private class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {

        public MyComboBoxRenderer(String[] items) {
            super(items);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setSelectedItem(value);

            return this;
        }

    }

    private class MyComboBoxEditor extends DefaultCellEditor {

        public MyComboBoxEditor(String[] items) {
            super(new JComboBox(items));
        }

    }
    */

    private class IntegerTextFieldRenderer extends IntegerTextField implements TableCellRenderer {

        public IntegerTextFieldRenderer() {
            super();
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setText((String) value);

            return this;
        }

    }

    private class IntegerTextFieldEditor extends DefaultCellEditor {

        public IntegerTextFieldEditor() {
            super(new IntegerTextField());
        }

        public IntegerTextFieldEditor(int aMin, int aMax) {
            super(new IntegerTextField());
            ((IntegerTextField) getComponent()).setValueScope(aMin, aMax);
        }

    }

}