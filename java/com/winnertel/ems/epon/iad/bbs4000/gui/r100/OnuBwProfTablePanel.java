package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuBwProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The OnuBwProfTablePanel class.
 * Created by DVM Creator
 */
public class OnuBwProfTablePanel extends UPanel {

    private IndexAutoGenField tfBandwidthProfileIndex = new IndexAutoGenField(fApplication,1);

    private StringTextField tfOnuBwProfileName = new StringTextField();

    // private IntegerTextField tfTrafficType = new IntegerTextField();
    private int[] trafficTypeVList = new int[]{1, 2, 3, 4, 5};
    
    private String[] trafficTypeTList = new String[]{fStringMap.getString("tcout-type-1"), fStringMap.getString("tcout-type-2"), fStringMap.getString("tcout-type-3"), fStringMap.getString("tcout-type-4"), fStringMap.getString("tcout-type-5"),};
    private JComboBox tfTrafficType = new JComboBox(trafficTypeTList);


    private IntegerTextField tfFixedBandwidth = new IntegerTextField();

    private IntegerTextField tfAssuredBandwidth = new IntegerTextField();

    private IntegerTextField tfMaximumBandwidth = new IntegerTextField();

    private final String bandwidthProfileIndex = fStringMap.getString("bandwidthProfileIndex") + " : ";
    private final String onuBwProfileName = fStringMap.getString("onuBwProfileName") + " : ";
    private final String trafficType = fStringMap.getString("trafficType") + " : ";
    private final String fixedBandwidth = fStringMap.getString("fixedBandwidth") + " : ";
    private final String assuredBandwidth = fStringMap.getString("assuredBandwidth") + " : ";
    private final String maximumBandwidth = fStringMap.getString("maximumBandwidth") + " : ";

    public OnuBwProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(bandwidthProfileIndex));
        baseInfoPanel.add(tfBandwidthProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuBwProfileName));
        tfOnuBwProfileName.setName(fStringMap.getString("onuBwProfileName"));
        tfOnuBwProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuBwProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(trafficType));
        tfTrafficType.setName(fStringMap.getString("trafficType"));
        baseInfoPanel.add(tfTrafficType);
        baseInfoPanel.add(new HSpacer());
        tfTrafficType.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                int type = trafficTypeVList[tfTrafficType.getSelectedIndex()];
                switch(type){
                case 1: tfFixedBandwidth.setEnabled(true);tfAssuredBandwidth.setEnabled(false);break;
                case 2: tfFixedBandwidth.setEnabled(false);tfAssuredBandwidth.setEnabled(true);break;
                case 3: tfFixedBandwidth.setEnabled(false);tfAssuredBandwidth.setEnabled(true);break;
                case 4: tfFixedBandwidth.setEnabled(false);tfAssuredBandwidth.setEnabled(false);break;  
                case 5: tfFixedBandwidth.setEnabled(true);tfAssuredBandwidth.setEnabled(true);break;
                }
                
            }
            
        });
        

        baseInfoPanel.add(new JLabel(fixedBandwidth));
        tfFixedBandwidth.setName(fStringMap.getString("fixedBandwidth"));
        baseInfoPanel.add(tfFixedBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(assuredBandwidth));
        tfAssuredBandwidth.setName(fStringMap.getString("assuredBandwidth"));
        baseInfoPanel.add(tfAssuredBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(maximumBandwidth));
        tfMaximumBandwidth.setName(fStringMap.getString("maximumBandwidth"));
        baseInfoPanel.add(tfMaximumBandwidth);
        baseInfoPanel.add(new HSpacer());

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

        // tfTrafficType.setValueScope(1, 5);
        tfBandwidthProfileIndex.setValueScope(0,2, 256);

        tfFixedBandwidth.setValueScope(128, 2500000);
        tfFixedBandwidth.setValue(512);
//       tfAssuredBandwidth.setValueScope(0, 2500000);
       tfAssuredBandwidth.setValue(0);

        tfMaximumBandwidth.setValueScope(128, 2500000);
        tfMaximumBandwidth.setValue(1024);
        tfFixedBandwidth.setEnabled(true);
        tfAssuredBandwidth.setEnabled(false);
    }
    
    public boolean validateFrom(){
        if(tfAssuredBandwidth.isEnabled()){
    	int value = tfAssuredBandwidth.getValue();
    	
    	if((value<256&&value!=0)||value>2500000||value%64!=0){
    	 
    	    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_AssuredBandwidth"));
            return false;
    	}
    	
    	}
        if(tfFixedBandwidth.isEnabled()&&tfFixedBandwidth.getValue()%64!=0){
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_FixedBandwidth"));
            return false;
        }
        if(tfMaximumBandwidth.isEnabled()&&tfMaximumBandwidth.getValue()%64!=0){
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_MaximumBandwidth"));
            return false;
        }
    	
    	return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfBandwidthProfileIndex.setEnabled(true);
            tfBandwidthProfileIndex.setTable(fTable);
            tfBandwidthProfileIndex.refresh();
            return;
        } else
            tfBandwidthProfileIndex.setEnabled(false);
        OnuBwProfTable mbean = (OnuBwProfTable) getModel();

        String sValue = "";
        int iValue = 0;

       
        tfBandwidthProfileIndex.setValue(0,mbean.getBandwidthProfileIndex());

        try {
            sValue = mbean.getOnuBwProfileName();
        }
        catch (Exception e) {
            sValue = "";
        }
        tfOnuBwProfileName.setValue(sValue);

        try {
            iValue = getIndexFromValue(trafficTypeVList, mbean.getTrafficType().intValue());
        }
        catch (Exception e) {
            iValue = 0;
        }
        tfTrafficType.setSelectedIndex(iValue);

        try {
            iValue = mbean.getFixedBandwidth().intValue();
        }
        catch (Exception e) {
            iValue = 0;
        }
        tfFixedBandwidth.setValue(iValue);

        try {
            iValue = mbean.getAssuredBandwidth().intValue();
        }
        catch (Exception e) {
            iValue = 0;
        }
        tfAssuredBandwidth.setValue(iValue);

        try {
            iValue = mbean.getMaximumBandwidth().intValue();
        }
        catch (Exception e) {
            iValue = 0;
        }
        tfMaximumBandwidth.setValue(iValue);
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuBwProfTable(fApplication.getSnmpProxy()));
        OnuBwProfTable mbean = (OnuBwProfTable) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setBandwidthProfileIndex(tfBandwidthProfileIndex.getValue(0));
        }
        mbean.setOnuBwProfileName(new String(tfOnuBwProfileName.getValue()));
        mbean.setTrafficType(new Integer(trafficTypeVList[tfTrafficType.getSelectedIndex()]));
        if(tfFixedBandwidth.isEnabled())
        mbean.setFixedBandwidth(new Long(tfFixedBandwidth.getValue()));
        if(tfAssuredBandwidth.isEnabled())
        mbean.setAssuredBandwidth(new Long(tfAssuredBandwidth.getValue()));
        mbean.setMaximumBandwidth(new Long(tfMaximumBandwidth.getValue()));
        //   mbean.setOnuBwProfRowStatus(new Integer(onuBwProfRowStatusVList[tfOnuBwProfRowStatus.getSelectedIndex()]));

    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfBandwidthProfileIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}