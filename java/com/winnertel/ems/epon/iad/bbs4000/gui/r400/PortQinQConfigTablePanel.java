package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortQinQConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The PortQinQConfigTablePanel class.
 * Created by DVM Creator
 */
public class PortQinQConfigTablePanel extends UPanel implements ActionListener {

    /*
    private JComboBox tfPqDeviceIndex = new JComboBox();
    private JComboBox tfPqOnuNUM = new JComboBox();

    private IntegerTextField tfPqCardIndex = new IntegerTextField();

    private IntegerTextField tfPqPortIndex = new IntegerTextField();
    */

    EponDeviceIndexPanel deviceIndex=null;     

    private IntegerTextField tfPqStartVlanId = new IntegerTextField();

    private IntegerTextField tfPqEndVlanId = new IntegerTextField();

    private IntegerTextField tfPqSVlanId = new IntegerTextField();

    private int[] pqSTagCosDetermineVList = new int[]{
            1, 2,};
    private String[] pqSTagCosDetermineTList = new String[]{
            fStringMap.getString("redefine"),
            fStringMap.getString("copyFromCTag"),
    };
    private JComboBox tfPqSTagCosDetermine = new JComboBox(pqSTagCosDetermineTList);
    private IntegerTextField tfPqSTagCosNewValue = new IntegerTextField();

    /*
    private int[] pqRowStatusVList =new int[]{
1,2,5,4,3,6,};
private String[] pqRowStatusTList =new String[]{
    fStringMap.getString("active"),
    fStringMap.getString("notInService"),
    fStringMap.getString("createAndWait"),
    fStringMap.getString("createAndGo"),
    fStringMap.getString("notReady"),
    fStringMap.getString("destroy"),
};
private JComboBox tfPqRowStatus = new JComboBox( pqRowStatusTList);
    */

    /*
    private final String pqDeviceIndex = fStringMap.getString("pqDeviceIndex") + " : ";
    private final String pqOnuNum = fStringMap.getString("pqOnuNum") + " : ";
    private final String pqCardIndex = fStringMap.getString("pqCardIndex") + " : ";
    private final String pqPortIndex = fStringMap.getString("pqPortIndex") + " : ";
    */
    private final String pqStartVlanId = fStringMap.getString("pqStartVlanId") + " : ";
    private final String pqEndVlanId = fStringMap.getString("pqEndVlanId") + " : ";
    private final String pqSVlanId = fStringMap.getString("pqSVlanId") + " : ";
    private final String pqSTagCosDetermine = fStringMap.getString("pqSTagCosDetermine") + " : ";
    private final String pqSTagCosNewValue = fStringMap.getString("pqSTagCosNewValue") + " : ";


    public PortQinQConfigTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        initPanel(true);
    }

    protected void initPanel(boolean addMode){

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        /*
        baseInfoPanel.add(new JLabel(pqDeviceIndex));
        baseInfoPanel.add(tfPqDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        tfPqDeviceIndex.addActionListener(this);

        baseInfoPanel.add(new JLabel(pqOnuNum));
        baseInfoPanel.add(tfPqOnuNUM);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(pqCardIndex));
        baseInfoPanel.add(tfPqCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pqPortIndex));
        baseInfoPanel.add(tfPqPortIndex);
        baseInfoPanel.add(new HSpacer());
        */

        JLabel lb1=new JLabel(pqStartVlanId);
        lb1.setPreferredSize(new Dimension(120,20));
        baseInfoPanel.add(lb1);
        tfPqStartVlanId.setPreferredSize(new Dimension(220,25));
        baseInfoPanel.add(tfPqStartVlanId);
        baseInfoPanel.add(new HSpacer(30));


        baseInfoPanel.add(new JLabel(pqEndVlanId));
        baseInfoPanel.add(tfPqEndVlanId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pqSVlanId));
        tfPqSVlanId.setName(fStringMap.getString("pqSVlanId"));
        baseInfoPanel.add(tfPqSVlanId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pqSTagCosDetermine));
        tfPqSTagCosDetermine.setName(fStringMap.getString("pqSTagCosDetermine"));
        tfPqSTagCosDetermine.setPreferredSize(new Dimension(220,25));
        baseInfoPanel.add(tfPqSTagCosDetermine);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pqSTagCosNewValue));
        tfPqSTagCosNewValue.setName(fStringMap.getString("pqSTagCosNewValue"));
        baseInfoPanel.add(tfPqSTagCosNewValue);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);

        deviceIndex=new EponDeviceIndexPanel(fStringMap,fApplication);
        allPanel.add(deviceIndex);

        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);


    }

    protected void initForm() {

        try{

            if (deviceIndex!=null){
                deviceIndex.initData();
            }
            /*
            if(allPonPortList!=null){
                for (int i=0;i<allPonPortList.size();i++)
                    tfPqDeviceIndex.addItem(allPonPortList.elementAt(i));
            }

            if(allSniPortList!=null){
                for (int i=0;i<allSniPortList.size();i++)
                    tfPqDeviceIndex.addItem(allSniPortList.elementAt(i));
            } */
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //tfPqDeviceIndex.setSelectedItem(null);

        //tfTranslationNewVid.setValueScope( 0,4294967295 );

        //for(int i=0;i<=64;i++){
        //    tfPqOnuNUM.addItem(String.valueOf(i));
        //}


        tfPqSTagCosNewValue.setValueScope(0, 7);
    }

    public void actionPerformed(ActionEvent e){ /*
        Object source = e.getSource();
        if (source == tfPqDeviceIndex) {
            String selPort= (String)tfPqDeviceIndex.getSelectedItem();
            for (int i=0;i<allPonPortList.size();i++){
                if(allPonPortList.elementAt(i).equals(selPort)){
                    tfPqOnuNUM.setEnabled(true);
                    //tfPqCardIndex.setText("0");
                    tfPqCardIndex.setEditable(true);
                    //tfPqPortIndex.setText("0");
                    tfPqPortIndex.setEditable(true);

                    break;
                }
            }

            for (int i=0;i<allSniPortList.size();i++){
                if(allSniPortList.elementAt(i).equals(selPort)){
                    tfPqOnuNUM.setSelectedItem("0");
                    tfPqOnuNUM.setEnabled(false);

                    tfPqCardIndex.setText("0");
                    tfPqCardIndex.setEditable(false);
                    tfPqPortIndex.setText("0");
                    tfPqPortIndex.setEditable(false);

                }
            }

        } */
    }

    public void refresh() {

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            deviceIndex.setEnabled(true);

            SnmpTableModel model = (SnmpTableModel)fTable.getModel();
            PortQinQConfigTable mbean = (PortQinQConfigTable) model.getMibBean();

            if(mbean.getPqDeviceIndex() != null)
                deviceIndex.setEponDeviceIndex(mbean.getPqDeviceIndex());

            if(mbean.getPqCardIndex() != null)
                deviceIndex.setOnuCardId(mbean.getPqCardIndex());

            if(mbean.getPqPortIndex() != null)
                deviceIndex.setOnuPortId(mbean.getPqPortIndex());
            
            return;
        } else {
            deviceIndex.setEnabled(false);
        }

        PortQinQConfigTable mbean = (PortQinQConfigTable) getModel();

        //tfPqDeviceIndex.setText(mbean.getPqDeviceIndex().toString());
       // tfPqDeviceIndex.setSelectedItem(mbean.getPqDeviceIndex().toString());

       // tfPqCardIndex.setText(mbean.getPqCardIndex().toString());
       // tfPqPortIndex.setText(mbean.getPqPortIndex().toString());
        tfPqStartVlanId.setEnabled(false);
        tfPqStartVlanId.setText(mbean.getPqStartVlanId().toString());
        tfPqEndVlanId.setEnabled(false);
        tfPqEndVlanId.setText(mbean.getPqEndVlanId().toString());
        tfPqSVlanId.setValue(mbean.getPqSVlanId().intValue());
        tfPqSTagCosDetermine.setSelectedIndex(getIndexFromValue(pqSTagCosDetermineVList, mbean.getPqSTagCosDetermine().intValue()));
        tfPqSTagCosNewValue.setValue(mbean.getPqSTagCosNewValue().intValue());
        //tfPqRowStatus.setSelectedIndex(getIndexFromValue(pqRowStatusVList,mbean.getPqRowStatus().intValue()));

    }

    public boolean validateFrom() {
        if (SnmpAction.IType.ADD.equals(fCommand)){

            if (!deviceIndex.validateFrom()){
                return false;
            }
        }

        return true;
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new PortQinQConfigTable(fApplication.getSnmpProxy()));

        PortQinQConfigTable mbean = (PortQinQConfigTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            //      mbean.set??(new Integer(??.getValue()));
            //mbean.setPqDeviceIndex(tfPqDeviceIndex.getValue());
            mbean.setPqDeviceIndex(deviceIndex.getEponDeviceIndex());

            mbean.setPqCardIndex(deviceIndex.getOnuCardId());
            mbean.setPqPortIndex(deviceIndex.getOnuPortId());
            mbean.setPqStartVlanId(tfPqStartVlanId.getValue());
            mbean.setPqEndVlanId(tfPqEndVlanId.getValue());

        }


        mbean.setPqSVlanId(new Integer(tfPqSVlanId.getValue()));
        mbean.setPqSTagCosDetermine(new Integer(pqSTagCosDetermineVList[tfPqSTagCosDetermine.getSelectedIndex()]));
        mbean.setPqSTagCosNewValue(new Integer(tfPqSTagCosNewValue.getValue()));
        // mbean.setPqRowStatus(new Integer(pqRowStatusVList[tfPqRowStatus.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
