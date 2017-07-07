package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuVlanConfigTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniAttributeTable;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The OnuVlanConfigTablePanel class.
 * Created by DVM Creator
 */
public class OnuVlanConfigTablePanel extends UPanel {

    private IntegerTextField tfOnuVlanIndex = new IntegerTextField();

    private StringTextField tfOnuVlanName = new StringTextField();

    //private StringTextField tfOnuVlanTaggedPort = new StringTextField();

    //private StringTextField tfOnuVlanUntaggedPort = new StringTextField();
    private JTable portSelectionTbl = null;
    private CustomTblModel portSelectionTblModel = null;

    /*
    private int[] onuVlanRowStatusVList = new int[]{
            1, 2, 5, 4, 3, 6,};
    private String[] onuVlanRowStatusTList = new String[]{
            fStringMap.getString("active"),
            fStringMap.getString("notInService"),
            fStringMap.getString("createAndWait"),
            fStringMap.getString("createAndGo"),
            fStringMap.getString("notReady"),
            fStringMap.getString("destroy"),
    };
    private JComboBox tfOnuVlanRowStatus = new JComboBox(onuVlanRowStatusTList);
    */

    private final String onuVlanIndex = fStringMap.getString("onuVlanIndex") + " : ";
    private final String onuVlanName = fStringMap.getString("onuVlanName") + " : ";
    private final String onuVlanTaggedPort = fStringMap.getString("onuVlanTaggedPort") + " : ";
    private final String onuVlanUntaggedPort = fStringMap.getString("onuVlanUntaggedPort") + " : ";


    public OnuVlanConfigTablePanel(IApplication app) {
        super(app);

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
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(onuVlanIndex));
        baseInfoPanel1.add(tfOnuVlanIndex);
        baseInfoPanel1.add(new HSpacer());


        baseInfoPanel1.add(new JLabel(onuVlanName));
        tfOnuVlanName.setName(fStringMap.getString("onuVlanName"));
        baseInfoPanel1.add(tfOnuVlanName);
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
        columnNames.add(fStringMap.getString("taggedPort"));
        columnNames.add(fStringMap.getString("untaggedPort"));
        //columnNames.add(fStringMap.getString("utsLagExtDot1qVlanPortVidListPorts"));

        portSelectionTblModel = new CustomTblModel(rowData, columnNames);
        portSelectionTbl = new JTable(portSelectionTblModel);
        portSelectionTbl.setPreferredScrollableViewportSize(new Dimension(320, 230));
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
                            //if (!tagged && !untagged) {
                            //    model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            //}
                        }
                        if (colIdx == 2) {
                            if (untagged)
                                model.setValueAt(Boolean.FALSE, rowIdx, 1);
                            //if (!tagged && !untagged) {
                            //    model.setValueAt(Boolean.FALSE, rowIdx, 3);
                            //}
                        }
                        /*if (colIdx == 3) {
                            Boolean pvid = (Boolean) model.getValueAt(rowIdx, 3);
                            if (!pvid) {
                                portVidSet.remove(model.getValueAt(rowIdx, 0));
                            }
                        } */
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
        UniAttributeTable uniMBean = new UniAttributeTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, uniMBean);
        String eachPort;
        for (int i = 0; i < v.size(); i++) {
            UniAttributeTable eachBean = (UniAttributeTable) v.get(i);
            eachPort= eachBean.getUniAttributeCardIndex()+"/"+eachBean.getUniAttributePortIndex();
            allPortList.add(eachPort);
        }


        return allPortList;
    }

    protected void initForm() {

        tfOnuVlanName.setLenScope(0, 128);
        //tfOnuVlanIndex.setEditable(false); 

    }

    private byte[] codePort(String[] port){
        byte[] retByte=null;
        if (port.length>0){
            retByte=new byte[port.length*4];

            for (int i=0;i<port.length;i++){

                int idx1=port[i].indexOf("/");

                retByte[i*2]= (byte) Integer.parseInt(port[i].substring(0,idx1));
                retByte[i*2+1]= (byte) Integer.parseInt(port[i].substring(idx1+1));

            }

        }

        return retByte;

    }
    /*
    private String[] parsePort(byte[] b){

        String[] sb = new String[(b.length+3)/4];

        int sbIdx=0;
        for(int i=0;i<b.length;i=i+2){

            int byte1,byte2,byte3,byte4;
            byte1=  b[i]& 0xFF;
            byte2=  b[i+1]& 0xFF;

            sb[sbIdx]=  byte1+"/"+ byte2;


            sbIdx=sbIdx+1;

        }
        return sb;
    }

    protected Set parsePortListString(byte[] b) {
        String[] portList = parsePort(b);
        Set portListSet = new HashSet();
        for (int i = 0; i < portList.length; i++) {
            portListSet.add(portList[i]);
        }

        return portListSet;
    } */

    public void refresh() {

        try{
        if (SnmpAction.IType.ADD.equals(fCommand)){

            portSelectionTblModel.getDataVector().clear();
            Vector portList = getPortList();
            for (int i = 0; i < portList.size(); i++) {
                Vector tmpVector = new Vector();
                tmpVector.add(portList.elementAt(i));
                tmpVector.add(Boolean.FALSE);
                tmpVector.add(Boolean.FALSE);
                //tmpVector.add(Boolean.FALSE);
                portSelectionTblModel.addRow(tmpVector);
            }
            return;

        }
        OnuVlanConfigTable mbean = (OnuVlanConfigTable) getModel();

        tfOnuVlanIndex.setText(mbean.getOnuVlanIndex().toString());
        tfOnuVlanName.setValue(mbean.getOnuVlanName());
        //tfOnuVlanTaggedPort.setValue(mbean.getOnuVlanTaggedPort());
        //tfOnuVlanUntaggedPort.setValue(mbean.getOnuVlanUntaggedPort());
        // tfOnuVlanRowStatus.setSelectedIndex(getIndexFromValue(onuVlanRowStatusVList,mbean.getOnuVlanRowStatus().intValue()));

        } catch (Exception ex) {
        ex.printStackTrace();
    }
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new OnuVlanConfigTable(fApplication.getSnmpProxy()));

        OnuVlanConfigTable mbean = (OnuVlanConfigTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //      mbean.set??(new Integer(??.getValue()));
            mbean.setOnuVlanIndex(tfOnuVlanIndex.getValue());
        }


        mbean.setOnuVlanName(new String(tfOnuVlanName.getValue()));

        byte[] taggedPorts = codePort(getPortSelectionStr(1));
        byte[] untaggedPorts = codePort(getPortSelectionStr(2));

        mbean.setOnuVlanTaggedPort(taggedPorts);
        mbean.setOnuVlanUntaggedPort(untaggedPorts);
        //    mbean.setOnuVlanRowStatus(new Integer(onuVlanRowStatusVList[tfOnuVlanRowStatus.getSelectedIndex()]));


    }

    protected String[] getPortSelectionStr(int colIdx) {
        if (colIdx > 3 || colIdx < 1) {
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

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
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

            /* the last column : VID
            if (col == 3) {
                String portName = (String) getValueAt(row, 0);
                Boolean tagged = (Boolean) getValueAt(row, 1);
                Boolean untagged = (Boolean) getValueAt(row, 2);

                if (!tagged && !untagged) {
                    return false;
                }

                Boolean pvid = (Boolean) getValueAt(row, 3);
                if (!pvid && portVidSet.contains(portName)) {
                    return false;
                }
            }    */

            return true;
        }

    }
}