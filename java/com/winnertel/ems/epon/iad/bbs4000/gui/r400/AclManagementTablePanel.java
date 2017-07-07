/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.AclManagementTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.AclRuleTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class AclManagementTablePanel extends UPanel {

    private IntegerTextField tfAclListIndex = new IntegerTextField();
    private StringTextField tfAclDescription = new StringTextField();

    private JTable aclRuleSelectionTable = null;
    private CustomTableModel aclRuleSelectionTableModel = null;

    private final String aclListIndex = fStringMap.getString("aclListIndex") + " : ";
    private final String aclDescription = fStringMap.getString("aclDescription") + " : ";
    //private final String aclRuleList = fStringMap.getString("aclRuleList") + " : ";

    public AclManagementTablePanel(IApplication app) {
        super(app);
        setModel(new AclManagementTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        //baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(aclListIndex));
        tfAclListIndex.setName(fStringMap.getString("aclListIndex"));
        baseInfoPanel1.add(tfAclListIndex);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(aclDescription));
        tfAclDescription.setName(fStringMap.getString("aclDescription"));
        baseInfoPanel1.add(tfAclDescription);
        baseInfoPanel1.add(new HSpacer());

        // construct ACL rule selecttion table
        JPanel baseInfoPanel2 = new JPanel();
        NTLayout layout2 = new NTLayout(1, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseInfoPanel2.setLayout(layout2);
        //baseInfoPanel2.setBorder(BorderFactory.createEtchedBorder());

        Vector columnNames = new Vector();
        Vector rowData = new Vector();
        columnNames.add(fStringMap.getString("aclRuleIndex"));
        columnNames.add(fStringMap.getString("selected")); //todo
        aclRuleSelectionTableModel = new CustomTableModel(rowData, columnNames);
        aclRuleSelectionTable = new JTable(aclRuleSelectionTableModel);
        aclRuleSelectionTable.setPreferredScrollableViewportSize(new Dimension(220, 230));
        /*
        aclRuleSelectionTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent event) {
                AbstractTableModel model = (AbstractTableModel) event.getSource();
                int type = event.getType();
                switch (type) {
                    case TableModelEvent.UPDATE:
                        int rowIdx = event.getFirstRow();
                        int colIdx = event.getColumn();
                        Boolean selected = (Boolean) model.getValueAt(rowIdx, 1);
                        //...
                        break;
                }
            }
        });
        */
        JScrollPane tmpScrollPane = new JScrollPane(aclRuleSelectionTable);
        baseInfoPanel2.add(tmpScrollPane);

        baseInfoPanel.add(baseInfoPanel1);
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

    protected void initForm() {
        tfAclDescription.setLenScope(0, 255);
        //tfAclRuleList.setLenScope(0, 64);
    }

    private Vector getAclRuleList() throws Exception {
        Vector allAclRuleList = new Vector();

        AclRuleTable aclRuleTableMBean = new AclRuleTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, aclRuleTableMBean);
        for (int i = 0; i < v.size(); i++) {
            int aclRuleIndex = ((AclRuleTable) v.get(i)).getAclRuleIndex();
            allAclRuleList.add(aclRuleIndex);
        }

        return allAclRuleList;
    }

    public void refresh() {

        try {
            aclRuleSelectionTableModel.getDataVector().clear();
            Vector aclRuleList = getAclRuleList();
            for (int i = 0; i < aclRuleList.size(); i++) {
                Vector tmpVector = new Vector();
                tmpVector.add(aclRuleList.elementAt(i));
                tmpVector.add(Boolean.FALSE);
                aclRuleSelectionTableModel.addRow(tmpVector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
        	tfAclListIndex.setEnabled(true);
            return;
        } else {
        	tfAclListIndex.setEnabled(false);
        }

        AclManagementTable mbean = (AclManagementTable) getModel();
        if (mbean == null)
            return;

        tfAclListIndex.setValue(mbean.getAclListIndex());
        tfAclDescription.setValue(mbean.getAclDescription());

        setAclRuleSelectionStr(1, mbean.getAclRuleList());
    }

    public boolean validateFrom() {
//        //check the selected acl-list-index whether used in the port-acl-list table before delete it
//        try {
//            Vector aclRuleList = getAclRuleList();
//            PortAclListTable portAclListTableMBean = new PortAclListTable(fApplication.getSnmpProxy());
//            Vector v = BeanService.refreshTableBean(fApplication, portAclListTableMBean);
//            for (int i = 0; i < v.size(); i++) {
//                int aclListIndex = ((PortAclListTable) v.get(i)).getPortAclListIndex();
//                if (aclRuleList.indexOf(aclListIndex) >= 0) {
//                    //pop-up a dialog to show the warning message. //todo
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	if (SnmpAction.IType.ADD.equals(fCommand)){
	    	for(int i=0;i<fTable.getRowCount();i++){
	    		if(fTable.getValueAt(i, 0).toString().trim().equals(tfAclListIndex.getText().trim()))
	    		{
	    			JOptionPane.showMessageDialog(this, fStringMap.getString("Index can not duplicated."));
	    			return false;
	    		}
	    	}
    	}
        return true;
    }

    private void setAclRuleSelectionStr(int colIdx, byte[] selectedAclRule) {
        if (colIdx == 1) {
            if (selectedAclRule != null && selectedAclRule.length > 0) {
                ArrayList buf = new ArrayList();
                for (int i = 0; i < selectedAclRule.length; i++) {
                    int n = 0x80;
                    for (int j = 0; j < 8; j++) {
                        if ((selectedAclRule[i] & n) != 0)
                            buf.add(i * 8 + j + 1);
                        n = n >> 1;
                    }
                }

                for (int i = 0; i < aclRuleSelectionTableModel.getRowCount(); i++) {
                    int id = (Integer) aclRuleSelectionTableModel.getValueAt(i, 0);
                    Boolean bValue = buf.contains(id);
                    aclRuleSelectionTableModel.setValueAt(bValue, i, colIdx);
                }
            }
        }
    }

    private String[] getAclRuleSelectionStr(int colIdx) {
        if (colIdx != 1)
            return new String[0];

        ArrayList list = new ArrayList();
        for (int i = 0; i < aclRuleSelectionTableModel.getRowCount(); i++) {
            Boolean bValue = (Boolean) aclRuleSelectionTableModel.getValueAt(i, colIdx);
            if (bValue) {
                String index = aclRuleSelectionTableModel.getValueAt(i, 0).toString();
                list.add(index);
            }
        }

        return (String[]) list.toArray(new String[0]);
    }

    private byte[] StringArrayToAclRuleListMapping(String[] array) {
        byte[] b = new byte[64];

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                int index = 0;
                try {
                    index = Integer.parseInt(array[i]) - 1;
                    int n = index / 8;
                    int m = index % 8;
                    b[n] = (byte) (b[n] | (0x80 >> m));
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        return b;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new AclManagementTable(fApplication.getSnmpProxy()));

        AclManagementTable mbean = (AclManagementTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setAclListIndex(new Integer(tfAclListIndex.getValue()));
        }

        mbean.setAclDescription(new String(tfAclDescription.getValue()));

        byte[] selectedAclRule = StringArrayToAclRuleListMapping(getAclRuleSelectionStr(1));
        mbean.setAclRuleList(selectedAclRule);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
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
            // dataVector is a protected member of DefaultTableModel
            Vector v = (Vector) dataVector.elementAt(0);

            return v.elementAt(col).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            if (!bGlobalEditable)
                return false;

            // make the first column, which is 'aclRuleIndex', uneditable
            if (col == 0) {
                return false;
            }

            return true;
        }

    }

}