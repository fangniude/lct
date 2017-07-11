package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs1000.mib.r330.PortBasedVLAN;
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

public class OltVlanPanel extends UPanel {
    private final String utsLagExtDot1qVlanIndex = fStringMap.getString("utsLagExtDot1qVlanIndex") + ": ";
    private final String utsLagExtDot1qVlanName = fStringMap.getString("utsLagExtDot1qVlanName") + ": ";

    private IntegerTextField tfUtsLagExtDot1qVlanIndex = new IntegerTextField();
    private StringTextField tfUtsLagExtDot1qVlanName = new StringTextField();

    // table for selecting "Tagged / Untagged" fields
    private JTable portSelectionTbl = null;
    private CustomTblModel portSelectionTblModel = null;

    public OltVlanPanel(IApplication app) {
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
        tfUtsLagExtDot1qVlanIndex.setName(fStringMap.getString("utsLagExtDot1qVlanIndex"));
        baseInfoPanel1.add(tfUtsLagExtDot1qVlanIndex);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(utsLagExtDot1qVlanName));
        tfUtsLagExtDot1qVlanName.setName(fStringMap.getString("utsLagExtDot1qVlanName"));
        baseInfoPanel1.add(tfUtsLagExtDot1qVlanName);
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
        tfUtsLagExtDot1qVlanIndex.setValueScope(2, 4094);
        tfUtsLagExtDot1qVlanName.setLenScope(0, 16);
    }

    public void refresh() {
        try {
            if (SnmpAction.IType.ADD.equals(fCommand)) {
                tfUtsLagExtDot1qVlanIndex.setEditable(true);
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

                tfUtsLagExtDot1qVlanIndex.setEditable(false);
                tfUtsLagExtDot1qVlanIndex.setValue(mbean.getId());
                tfUtsLagExtDot1qVlanName.setValue(mbean.getName());
                portSelectionTblModel.getDataVector().clear(); // clear original data first.
//                Set taggedPortList = parsePortListString(mbean.getUtsLagExtDot1qVlanTaggedPortListPorts());
//                Set untaggedPortList = parsePortListString(mbean.getUtsLagExtDot1qVlanUnTaggedPortListPorts());

                Vector portList = getPortList();
                for (int i = 0; i < portList.size(); i++) {
                    Vector tmpVector = new Vector();
                    String portName = (String) portList.elementAt(i);
                    tmpVector.add(portName);
//                    tmpVector.add(taggedPortList.contains(portName));
//                    tmpVector.add(untaggedPortList.contains(portName));
                    portSelectionTblModel.addRow(tmpVector);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //modified by Zhou Chao, 2008/7/17
    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new OltVlanBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost())));
        }

        OltVlanBean mbean = (OltVlanBean) getModel();
        if (mbean == null) {
            return;
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index

            boolean isSingle = true;
            int startIndex = 0;
            int endIndex = 0;

            String vlanName = tfUtsLagExtDot1qVlanName.getValue();
            // get tagged/untagged/vid port lists
            byte[] taggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
            byte[] untaggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(2));
            byte[] vidPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(3));

            for (int i = startIndex; i < endIndex; i++) {
                PortBasedVLAN bean = new PortBasedVLAN(fApplication.getSnmpProxy());
                bean.setUtsLagExtDot1qVlanIndex(i);
                bean.setUtsLagExtDot1qVlanName(vlanName);
                bean.setUtsLagExtDot1qVlanTaggedPortListPorts(taggedPorts);
                bean.setUtsLagExtDot1qVlanUnTaggedPortListPorts(untaggedPorts);

                try {
                    if (!bean.add())
                        return;
                } catch (MibBeanException e) {
                    return;
                }
            }

            // one (last) record
//            mbean.setId(endIndex);
//            mbean.setName(vlanName);
//            mbean.setMember(taggedPorts);
//            mbean.setTagMember(untaggedPorts);
        } else {
//            mbean.setUtsLagExtDot1qVlanName(tfUtsLagExtDot1qVlanName.getValue());
//
//            // get tagged/untagged/vid port lists
//            byte[] taggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(1));
//            byte[] untaggedPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(2));
//            byte[] vidPorts = ConfigUtility.StringArrayToPortMapping(getPortSelectionStr(3));
//            mbean.setUtsLagExtDot1qVlanTaggedPortListPorts(taggedPorts);
//            mbean.setUtsLagExtDot1qVlanUnTaggedPortListPorts(untaggedPorts);
        }
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
