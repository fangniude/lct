/**
 * Modified by Zhou Chao, 2008/9/30
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.MultiItemSelector;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPCUTMProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

public class OnuUPCUTMProfTablePanel extends UPanel {

//    private LongIndexGenField tfOnuUsrPortCoSUpTrafficMapProfIndex1 = new LongIndexGenField(fApplication);
//    private LongIndexGenField tfOnuUsrPortCoSUpTrafficMapProfIndex2 = new LongIndexGenField(fApplication);
    private IndexAutoGenField tfOnuUsrPortCoSUpTrafficMapProfIndex = new IndexAutoGenField(fApplication,2);
//    private DoubleIndexGenField tfOnuUsrPortCoSUpTrafficMapProfIndex = new DoubleIndexGenField(fApplication);
    private StringTextField tfOnuUsrPortCoSUpTrafficMapProfileName = new StringTextField();

    private int[] cosSelectionVList = new int[]{1,  3,};
    private String[] cosSelectionTList = new String[]{
            fStringMap.getString("priority-bits"),
           // fStringMap.getString("dscp-value"),
            fStringMap.getString("na"),
    };
    private JComboBox tfCosSelection = new JComboBox(cosSelectionTList);

   // private LongTextField tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType = new LongTextField();
    private int[] onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList = new int[]{1};
    private String[] onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeTList = new String[]{fStringMap.getString("Ethernet UNI")};
    private JComboBox tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType = new JComboBox(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeTList);
    private JComboBox tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo = new JComboBox();
    private MultiItemSelector tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap = new MultiItemSelector();
   // private DigitalTextField tfDscpBitMap = new DigitalTextField();
    private JComboBox tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo = new JComboBox();

    private final String onuUsrPortCoSUpTrafficMapProfIndex1 = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfIndex1") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfIndex2 = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfIndex2") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfileName = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfileName") + ": ";
    private final String cosSelection = fStringMap.getString("cosSelection") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfPhysicalPortType = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfPhysicalPortType") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfPhysicalPortNo = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfPhysicalPortNo") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap") + ": ";
    private final String dscpBitMap = fStringMap.getString("dscpBitMap") + ": ";
    private final String onuUsrPortCoSUpTrafficMapProfVirtualPortNo = fStringMap.getString("onuUsrPortCoSUpTrafficMapProfVirtualPortNo") + ": ";
    private VlanPriorityBitMapModel model = new VlanPriorityBitMapModel();
    public OnuUPCUTMProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfIndex1));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfIndex2));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfIndex.getIndexPanel(1));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfileName));
        tfOnuUsrPortCoSUpTrafficMapProfileName.setName(fStringMap.getString("onuUsrPortCoSUpTrafficMapProfileName"));
        tfOnuUsrPortCoSUpTrafficMapProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(cosSelection));
        tfCosSelection.setName(fStringMap.getString("cosSelection"));
        baseInfoPanel.add(tfCosSelection);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfPhysicalPortType));
        tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.setName(fStringMap.getString("onuUsrPortCoSUpTrafficMapProfPhysicalPortType"));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType);
        baseInfoPanel.add(new HSpacer());
        tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList[tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.getSelectedIndex()]==1){
				//	tfDscpBitMap.setEnabled(true);
					tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setEnabled(true);
				}
				else
					{tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setEnabled(false);
				//	tfDscpBitMap.setEnabled(false);
					}
			}
        	
        	
        });

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfPhysicalPortNo));
        tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo.setName(fStringMap.getString("onuUsrPortCoSUpTrafficMapProfPhysicalPortNo"));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap));
        tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setName(fStringMap.getString("onuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap"));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap);
        baseInfoPanel.add(new HSpacer());
        


        baseInfoPanel.add(new JLabel(onuUsrPortCoSUpTrafficMapProfVirtualPortNo));
        tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo.setName(fStringMap.getString("onuUsrPortCoSUpTrafficMapProfVirtualPortNo"));
        baseInfoPanel.add(tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1;i<=128;i++){
        	tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo.addItem(i);
        	if(i<=40)
        		tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo.addItem(i);
        }
        
    }

    protected void initForm() {
        tfOnuUsrPortCoSUpTrafficMapProfIndex.setValueScope(0,2, 128);
        tfOnuUsrPortCoSUpTrafficMapProfIndex.setValueScope(1,1, 255);
        //tfDscpBitMap.setValue(0);
    }

    public void refresh() {
        
    	 tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setSelectionChoices(model.getPriorityBitMap());
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuUsrPortCoSUpTrafficMapProfIndex.setEnabled(true);
            tfOnuUsrPortCoSUpTrafficMapProfIndex.setTable(fTable);
            tfOnuUsrPortCoSUpTrafficMapProfIndex.refresh();
            tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(model.priorityBitMapToVector(1));
            return;
        } else {
            tfOnuUsrPortCoSUpTrafficMapProfIndex.setEnabled(false);
        }
        
        OnuUPCUTMProfTable mbean = (OnuUPCUTMProfTable) getModel();
        Vector<String> selected_priorityBitMap = model.priorityBitMapToVector(mbean.getOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap()); 
        tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.setSelectedChoices(selected_priorityBitMap);
        
        String sValue = "";
        long lValue = 0;
        tfOnuUsrPortCoSUpTrafficMapProfIndex.setValue(0,mbean.getOnuUsrPortCoSUpTrafficMapProfIndex1());
        tfOnuUsrPortCoSUpTrafficMapProfIndex.setValue(1,mbean.getOnuUsrPortCoSUpTrafficMapProfIndex2());

        try {
            sValue = mbean.getOnuUsrPortCoSUpTrafficMapProfileName();
        } catch (Exception e) {
            sValue = "";
        }
        tfOnuUsrPortCoSUpTrafficMapProfileName.setValue(sValue);

        try {
            lValue = mbean.getCosSelection();
        } catch (Exception e) {
            lValue = 0;
        }
        tfCosSelection.setSelectedIndex(getIndexFromValue(cosSelectionVList, lValue));

        try {
            lValue = mbean.getOnuUsrPortCoSUpTrafficMapProfPhysicalPortType();
        } catch (Exception e) {
            lValue = 0;
        }
        tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.setSelectedIndex(getIndexFromValue(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList, lValue));
        
        int iValue = 0;
        try {
            iValue = mbean.getOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo.setSelectedItem(iValue);

       // tfDscpBitMap.setValue(mbean.getDscpBitMap());

        try {
            iValue = mbean.getOnuUsrPortCoSUpTrafficMapProfVirtualPortNo();
        } catch (Exception e) {
            iValue = 0;
        }
        tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo.setSelectedItem(iValue);
    }
    
    public boolean validateFrom() {
    	if(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList[tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.getSelectedIndex()]==1){
        if(tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices().size() < 1)
        {
          MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_VlanPriorityBitMap_Not_Selected"));
          return false;
        }
        SnmpMibBean beans = new OnuUPCUTMProfTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, beans);
        Vector selected = tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        String new_record = model.priorityBitMapToLong(selected)+"*"+tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo.getSelectedItem();
        for (int i = 0; i < v.size(); i++) {
        	OnuUPCUTMProfTable bean = (OnuUPCUTMProfTable)v.get(i);
        	if(tfOnuUsrPortCoSUpTrafficMapProfIndex.getValue(0)==bean.getOnuUsrPortCoSUpTrafficMapProfIndex1()&&tfOnuUsrPortCoSUpTrafficMapProfIndex.getValue(1)==bean.getOnuUsrPortCoSUpTrafficMapProfIndex2())
        	    continue;
        	String record = bean.getOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap()+"*"+bean.getOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo();
        	if(new_record.equals(record)){
        if(!tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo.getSelectedItem().equals(bean.getOnuUsrPortCoSUpTrafficMapProfVirtualPortNo())){
        	MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("VlanPriority_PP_VP_Conflict"));
            return false;
        }
        }
        }
        
    	}
        return true;
      }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuUPCUTMProfTable(fApplication.getSnmpProxy()));

        OnuUPCUTMProfTable mbean = (OnuUPCUTMProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            long index1 = tfOnuUsrPortCoSUpTrafficMapProfIndex.getValue(0);
            mbean.setOnuUsrPortCoSUpTrafficMapProfIndex1(index1);
            mbean.setOnuUsrPortCoSUpTrafficMapProfIndex2(tfOnuUsrPortCoSUpTrafficMapProfIndex.getValue(1));
        }
        if(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList[tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.getSelectedIndex()]==1){
        Vector selected = tfOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap.getSelectedChoices();
        mbean.setOnuUsrPortCoSUpTrafficMapProfVlanPriorityBitMap(new Long(model.priorityBitMapToLong(selected)));
        }
        mbean.setOnuUsrPortCoSUpTrafficMapProfileName(tfOnuUsrPortCoSUpTrafficMapProfileName.getValue());
        mbean.setCosSelection(cosSelectionVList[tfCosSelection.getSelectedIndex()]);
        mbean.setOnuUsrPortCoSUpTrafficMapProfPhysicalPortType(new Long(onuUsrPortCoSUpTrafficMapProfPhysicalPortTypeVList[tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortType.getSelectedIndex()]));
        mbean.setOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo(Integer.parseInt(tfOnuUsrPortCoSUpTrafficMapProfPhysicalPortNo.getSelectedItem().toString()));
//        if (tfDscpBitMap.getValue() != null && tfDscpBitMap.getValue().trim().length() > 0)
//            mbean.setDscpBitMap(new BigInteger(tfDscpBitMap.getValue()));
        mbean.setOnuUsrPortCoSUpTrafficMapProfVirtualPortNo(Integer.parseInt(tfOnuUsrPortCoSUpTrafficMapProfVirtualPortNo.getSelectedItem().toString()));
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
        tfOnuUsrPortCoSUpTrafficMapProfIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}