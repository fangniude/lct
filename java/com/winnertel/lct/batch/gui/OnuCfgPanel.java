package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.OltVlanBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class OnuCfgPanel extends UPanel {
    private final String utsLagExtDot1qVlanIndex = fStringMap.getString("utsLagExtDot1qVlanIndex") + ": ";
    private final String utsLagExtDot1qVlanName = fStringMap.getString("utsLagExtDot1qVlanName") + ": ";

    private IntegerTextField idField = new IntegerTextField();
    private StringTextField nameField = new StringTextField();

    // table for selecting "Tagged / Untagged" fields
    private JTable portSelectionTbl = null;
    private CustomTblModel portSelectionTblModel = null;

    public OnuCfgPanel(IApplication app) {
        super(app);
        init();
    }


    public void initGui() {
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel baseInfoPanel = new JPanel(layout);

        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanIndex));
        idField.setName(fStringMap.getString("utsLagExtDot1qVlanIndex"));
        baseInfoPanel1.add(idField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanName));
        nameField.setName(fStringMap.getString("utsLagExtDot1qVlanName"));
        baseInfoPanel1.add(nameField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel.add(baseInfoPanel1);

        // begin of construct port selecttion table
        JPanel baseInfoPanel2 = new JPanel();
        NTLayout layout2 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseInfoPanel2.setLayout(layout2);
        baseInfoPanel2.setBorder(BorderFactory.createEtchedBorder());

        Vector columnNames = new Vector();
        Vector rowData = new Vector();

        columnNames.add(fStringMap.getString("Port ID"));
        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanTaggedPortListPorts"));
        columnNames.add(fStringMap.getString("utsLagExtDot1qVlanUnTaggedPortListPorts"));

        portSelectionTblModel = new CustomTblModel(rowData, columnNames);
        portSelectionTbl = new JTable(portSelectionTblModel);
        portSelectionTbl.setPreferredScrollableViewportSize(new Dimension(360, 230));
        portSelectionTbl.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent event) {
                AbstractTableModel model = (AbstractTableModel) event.getSource();
                int type = event.getType();
                switch (type) {
                    case TableModelEvent.UPDATE:
                        int rowIdx = event.getFirstRow();
                        int colIdx = event.getColumn();
                        Boolean tagged = (Boolean) model.getValueAt(rowIdx, 1);
                        Boolean untagged = (Boolean) model.getValueAt(rowIdx, 2);
                        if (colIdx == 1) {
                            if (tagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 2);
                            if (!tagged && !untagged) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            }
                        }
                        if (colIdx == 2) {
                            if (untagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
                            if (!tagged && !untagged) {
                                model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            }
                        }
                        break;
                }
            }
        });

        JScrollPane tmpScrollPane = new JScrollPane(portSelectionTbl);
        baseInfoPanel2.add(tmpScrollPane);

        baseInfoPanel.add(baseInfoPanel2);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        allPortList.add("pon1/1");
        allPortList.add("pon1/2");
        allPortList.add("pon1/3");
        allPortList.add("pon1/4");
        allPortList.add("ge2/1");
        allPortList.add("ge2/2");
        allPortList.add("ge2/3");
        allPortList.add("ge2/4");

        return allPortList;
    }

    protected void initForm() {
        idField.setValueScope(2, 4094);
        nameField.setLenScope(0, 16);
    }

    public void refresh() {
        try {
            if (SnmpAction.IType.ADD.equals(fCommand)) {
                idField.setEditable(true);
                portSelectionTblModel.getDataVector().clear();
                Vector portList = getPortList();
                for (int i = 0; i < portList.size(); i++) {
                    Vector tmpVector = new Vector();
                    tmpVector.add(portList.elementAt(i));
                    tmpVector.add(Boolean.FALSE);
                    tmpVector.add(Boolean.FALSE);
                    portSelectionTblModel.addRow(tmpVector);
                }
            } else {
                OltVlanBean mbean = (OltVlanBean) getModel();
                if (mbean == null) {
                    throw new RuntimeException("error");
                }

                idField.setEditable(false);
                idField.setValue(Integer.valueOf(mbean.getId()));
                nameField.setValue(mbean.getName());
                portSelectionTblModel.getDataVector().clear(); // clear original data first.

                String tags = getTagedPort(mbean.getTagMember());
                String untags = getUnTagedPort(mbean.getMember(), mbean.getTagMember());

                Vector portList = getPortList();
                for (int i = 0; i < portList.size(); i++) {
                    Vector tmpVector = new Vector();
                    String portName = (String) portList.elementAt(i);
                    tmpVector.add(portName);
                    tmpVector.add(tags.charAt(i) == '1');
                    tmpVector.add(untags.charAt(i) == '1');
                    portSelectionTblModel.addRow(tmpVector);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getUnTagedPort(String member, String tagMember) {
        Integer mem = Integer.valueOf(member.substring(2), 16);
        Integer tag = Integer.valueOf(tagMember.substring(2), 16);
        int unTag = mem ^ tag;
        String str = Integer.toBinaryString(unTag);
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() < 8) {
            sb.append("0");
        }
        return sb.toString();
    }

    private String getTagedPort(String tagMember) {
        String str = Integer.toBinaryString(Integer.valueOf(tagMember.substring(2), 16));
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() < 8) {
            sb.append("0");
        }
        return sb.toString();
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            OltVlanBean model = new OltVlanBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(String.valueOf(idField.getValue()));
            model.setName(nameField.getValue());
            model.setMember(getMember());
            model.setTagMember(getTagMember());
            setModel(model);
        } else {
            OltVlanBean model = (OltVlanBean) getModel();
            model.setName(nameField.getValue());
            model.setMember(getMember());
            model.setTagMember(getTagMember());
        }
    }

    private String getMember() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < portSelectionTblModel.getRowCount(); i++) {
            Boolean tag = (Boolean) portSelectionTblModel.getValueAt(i, 1);
            Boolean unTag = (Boolean) portSelectionTblModel.getValueAt(i, 2);
            sb.append(tag || unTag ? "1" : "0");
        }
        return toHexStr(sb.reverse().toString());
    }

    private String getTagMember() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < portSelectionTblModel.getRowCount(); i++) {
            Boolean tag = (Boolean) portSelectionTblModel.getValueAt(i, 1);
            sb.append(tag ? "1" : "0");
        }
        return toHexStr(sb.reverse().toString());
    }

    private String toHexStr(String binStr) {
        Integer intVal = Integer.valueOf(binStr, 2);
        return String.format("0x%s", String.format("%02X", intVal & 0xff));
    }

    protected String[] getPortSelectionStr(int colIdx) {
        if (colIdx > 2 || colIdx < 1) {
            return new String[0];
        }

        ArrayList list = new ArrayList();
        for (int i = 0; i < portSelectionTblModel.getRowCount(); i++) {
            String portName = (String) portSelectionTblModel.getValueAt(i, 0);
            Boolean bValue = (Boolean) portSelectionTblModel.getValueAt(i, colIdx);
            if (bValue) {
                list.add(portName);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

    private class CustomTblModel extends DefaultTableModel {

        private boolean bGlobalEditable = true;

        public void setBGlobalEditable(boolean editable) {
            bGlobalEditable = editable;
        }

        public CustomTblModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        public CustomTblModel(Vector rowData, Vector columnNames) {
            super(rowData, columnNames);
        }

        public Class getColumnClass(int col) {
            // dataVector is a protected member of DefaultTableModel
            Vector v = (Vector) dataVector.elementAt(0);

            return v.elementAt(col).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            // for condition when user editing default VLAN (index:1)
            if (!bGlobalEditable)
                return false;

            // make the first column, which is 'port name', uneditable
            if (col == 0) {
                return false;
            }

            return true;
        }

    }
}
