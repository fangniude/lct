package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OltPropertyTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OltVlanConfigTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonPortInfoTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniAttributeTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniTrunkConfigTable;
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
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * The OltVlanConfigTablePanel class.
 * Created by DVM Creator
 */
public class OltVlanConfigTablePanel extends UPanel {

    private IntegerTextField tfOltVlanIndex = new IntegerTextField();

    private JComboBox tfOltVlanDeviceIndex = new JComboBox();

    private StringTextField tfOltVlanName = new StringTextField();

    //private StringTextField tfTaggedPort = new StringTextField();

    //private StringTextField tfUntaggedPort = new StringTextField();

    // table for selecting "Tagged / Untagged / Port VID" fields
    private JTable portSelectionTbl = null;
    private CustomTblModel portSelectionTblModel = null;

    /*
            private int[] oltVlanRowStatusVList =new int[]{
    1,2,5,4,3,6,};
    private String[] oltVlanRowStatusTList =new String[]{
            fStringMap.getString("active"),
            fStringMap.getString("notInService"),
            fStringMap.getString("createAndWait"),
            fStringMap.getString("createAndGo"),
            fStringMap.getString("notReady"),
            fStringMap.getString("destroy"),
    };
    private JComboBox tfOltVlanRowStatus = new JComboBox( oltVlanRowStatusTList);
    */

    private final String oltVlanIndex = fStringMap.getString("oltVlanIndex") + " : ";
    private final String oltVlanDeviceIndex = fStringMap.getString("oltVlanDeviceIndex") + " : ";
    private final String oltVlanName = fStringMap.getString("oltVlanName") + " : ";
    private final String taggedPort = fStringMap.getString("taggedPort") + " : ";
    private final String untaggedPort = fStringMap.getString("untaggedPort") + " : ";


    public OltVlanConfigTablePanel(IApplication app) {
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
        NTLayout layout1 = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        JLabel lb1=new JLabel(oltVlanIndex);
        baseInfoPanel1.add(lb1);
        lb1.setPreferredSize(new Dimension(80,20));
        baseInfoPanel1.add(tfOltVlanIndex);
        baseInfoPanel1.add(new HSpacer(10));


        baseInfoPanel1.add(new JLabel(oltVlanDeviceIndex));
        tfOltVlanDeviceIndex.setPreferredSize(new Dimension(150,20));
        baseInfoPanel1.add(tfOltVlanDeviceIndex);
        baseInfoPanel1.add(new HSpacer());


        baseInfoPanel1.add(new JLabel(oltVlanName));
        tfOltVlanName.setName(fStringMap.getString("oltVlanName"));
        baseInfoPanel1.add(tfOltVlanName);
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
        portSelectionTbl.setPreferredScrollableViewportSize(new Dimension(300, 230));
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

    //Hashtable<String,byte[]> ht_Trunk=new Hashtable();
    private Vector getPortList() throws Exception {
        Vector allPortList = new Vector();
        SniAttributeTable sniMBean = new SniAttributeTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, sniMBean);
        String eachPort;
        for (int i = 0; i < v.size(); i++) {
            SniAttributeTable eachBean = (SniAttributeTable) v.get(i);
            eachPort= eachBean.getSniAttributeDeviceIndex() +"/"+eachBean.getSniAttributeCardIndex()+"/"+eachBean.getSniAttributePortIndex();
            allPortList.add(eachPort);
        }

        PonPortInfoTable ponPortMBean = new PonPortInfoTable(fApplication.getSnmpProxy());
        v = BeanService.refreshTableBean(fApplication, ponPortMBean);
        for (int i = 0; i < v.size(); i++) {
            PonPortInfoTable eachBean = (PonPortInfoTable) v.get(i);
            eachPort= eachBean.getPonDeviceIndex()+"/"+ eachBean.getPonCardIndex()+"/"+eachBean.getPonPortIndex();
            allPortList.add(eachPort);
        }

        
        //remove trunk port ,add trunk id
        SniTrunkConfigTable trunkConfigMBean= new SniTrunkConfigTable(fApplication.getSnmpProxy());
        v= BeanService.refreshTableBean(fApplication, trunkConfigMBean);
        for (int i = 0; i < v.size(); i++) {
            SniTrunkConfigTable eachBean=(SniTrunkConfigTable) v.get(i);
            byte[] member=eachBean.getSniTrunkGroupConfigMember();
            if(member!=null && member.length>0){

                //ht_Trunk.put(String.valueOf(eachBean.getSniTrunkGroupConfigIndex()),member);
                
                for(int j=0;j<member.length;j=j+4){
                    String memPort=member[j]+"/"+member[j+1]+"/"+member[j+2];


                    if(allPortList.contains(memPort)){
                        allPortList.remove(memPort);
                    }
                }
                allPortList.add("trunk"+eachBean.getSniTrunkGroupConfigIndex());
            }

        }

        return allPortList;
    }

    protected void initForm() {

        tfOltVlanName.setLenScope(0, 128);
    }

    private byte[] codePort(String[] port){
        byte[] retByte=null;
        byte[] list = new byte[4000];
        int k=0;
        if (port!=null && port.length>0){
            //retByte=new byte[port.length*4];

            for (int i=0;i<port.length;i++){

                if(port[i]!=null && port[i].startsWith("trunk")){
                    String trunkID= port[i].substring(5, port[i].length());
                    //byte[] mem= ht_Trunk.get(trunkID);
                    //for(int j=0;j<mem.length;j++){
                    //    list[k++]= ( mem[j]) ;
                    //}
                    list[k++]= (byte) Integer.parseInt((String)tfOltVlanDeviceIndex.getSelectedItem());
                    list[k++]= (byte) 0x3F ;
                    list[k++]= (byte) Integer.parseInt(trunkID) ;
                    list[k++]= (byte) 0 ;
                }
                else if (port[i].indexOf("/") != -1){
                    int idx1=port[i].indexOf("/");
                    int idx2=port[i].indexOf("/",idx1+1);

                    list[k++]= (byte) Integer.parseInt(port[i].substring(0,idx1));

                    list[k++]=(byte) Integer.parseInt(port[i].substring(idx1+1, idx2));
                    list[k++]=(byte) Integer.parseInt(port[i].substring(idx2+1));
                    list[k++]=(byte) 0 ;
                }
            }
            if(k>0){
                retByte=new byte[k];
                for(int i=0;i<k;i++){
                    retByte[i]= list[i];
                }
            }
        }

        return retByte;

    }
    private String[] parsePort(byte[] b){

        String[] sb = new String[(b.length+3)/4];

        int sbIdx=0;
        for(int i=0;i<b.length;i=i+4){

            int byte1,byte2,byte3,byte4;
            byte1=  b[i]& 0xFF;
            byte2=  b[i+1]& 0xFF;
            byte3=  b[i+2]& 0xFF;
            byte4=  b[i+3]& 0xFF;

            if (byte2==0x3F){
                sb[sbIdx]="trunk"+ byte3;
            }
            else{
                sb[sbIdx]= byte1+"/" + byte2+"/"+ byte3;


                if (byte4!=0){
                    //sb.append("-").append(byte4);
                }
            }

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
    }


    private Vector getDeviceList() throws Exception {
        Vector allDeviceList = new Vector();
        String eachDevice;


        OltPropertyTable oltMBean = new OltPropertyTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, oltMBean);
        for (int i = 0; i < v.size(); i++) {
            OltPropertyTable eachBean = (OltPropertyTable) v.get(i);
            eachDevice= eachBean.getOltDeviceIndex().toString();
            allDeviceList.add(eachDevice);
        }

        return allDeviceList;
    }

    public void refresh() {

        tfOltVlanDeviceIndex.removeAllItems();
        try{
            Vector allDevice=getDeviceList();
            if(allDevice!=null){
                for (int i=0;i<allDevice.size();i++)
                    tfOltVlanDeviceIndex.addItem(allDevice.elementAt(i));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if (!SnmpAction.IType.ADD.equals(fCommand)){
            tfOltVlanIndex.setEditable(false);
            tfOltVlanDeviceIndex.setEditable(false);
        }
        else{
            tfOltVlanIndex.setText("");
            tfOltVlanName.setText("");
            tfOltVlanIndex.setEditable(true);
            tfOltVlanDeviceIndex.setEditable(true);
        }

        try{

            if (SnmpAction.IType.ADD.equals(fCommand)){

                //tfOltVlanDeviceIndex.addItem("1");

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

            OltVlanConfigTable mbean = (OltVlanConfigTable) getModel();

            if (mbean == null) {
                return;
            }

            tfOltVlanIndex.setText(mbean.getOltVlanIndex().toString());
            tfOltVlanDeviceIndex.setSelectedItem(mbean.getOltVlanDeviceIndex().toString());

            tfOltVlanName.setValue(mbean.getOltVlanName());

// begin to set tagged/untagged/vid data
            portSelectionTblModel.getDataVector().clear(); // clear original data first.
            Set taggedPortList = parsePortListString(mbean.getTaggedPort());
            Set untaggedPortList = parsePortListString(mbean.getUntaggedPort());


            Vector portList = getPortList();
            for (int i = 0; i < portList.size(); i++) {
                Vector tmpVector = new Vector();
                String portName = (String) portList.elementAt(i);
                tmpVector.add(portName);
                tmpVector.add(taggedPortList.contains(portName));
                tmpVector.add(untaggedPortList.contains(portName));
                portSelectionTblModel.addRow(tmpVector);
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OltVlanConfigTable(fApplication.getSnmpProxy()));

        OltVlanConfigTable mbean = (OltVlanConfigTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //   mbean.set??(new Integer(??.getValue()));
            mbean.setOltVlanIndex(new Integer(tfOltVlanIndex.getValue()));
            mbean.setOltVlanDeviceIndex(new Integer((String)tfOltVlanDeviceIndex.getSelectedItem()));
        }
        mbean.setOltVlanName(new String(tfOltVlanName.getValue()));
        byte[] taggedPorts = codePort(getPortSelectionStr(1));
        byte[] untaggedPorts = codePort(getPortSelectionStr(2));

        mbean.setTaggedPort(taggedPorts);
        mbean.setUntaggedPort(untaggedPorts);
    //    mbean.setTaggedPort(new String(tfTaggedPort.getValue()));
    //    mbean.setUntaggedPort(new String(tfUntaggedPort.getValue()));
        // mbean.setOltVlanRowStatus(new Integer(oltVlanRowStatusVList[tfOltVlanRowStatus.getSelectedIndex()]));


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
