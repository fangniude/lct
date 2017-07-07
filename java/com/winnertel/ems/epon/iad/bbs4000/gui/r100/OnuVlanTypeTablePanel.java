package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanTypeTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OnuVlanTypeTablePanel class.
 * Created by DVM Creator
 */
public class OnuVlanTypeTablePanel extends UPanel {
    
    
    private JComboBox tfOnuVlanTypeSlotNo = new JComboBox();
    private JComboBox tfOnuVlanTypePortNo = new JComboBox();
    private JComboBox tfOnuVlanTypeLogicalPortNo = new JComboBox();

    private JComboBox tfOnuVlanTypeVirtualPortNo = new JComboBox();

    private IntegerTextField tfOnuVlanTypeNewSVLAN = new IntegerTextField();

    private IntegerTextField tfOnuVlanTypeNewCVLAN = new IntegerTextField();

    private int[] onuVlanTypeVList = new int[] { 3, 1, 4, 5, 2, 6, };
    private String[] onuVlanTypeTList = new String[] { fStringMap.getString("types-n-1-s"),
            fStringMap.getString("types-1-1-s"), fStringMap.getString("types-n-1-s-c"),
            fStringMap.getString("types-n-1-s-cs"), fStringMap.getString("types-1-1-s-c"),
            fStringMap.getString("types-TLS"), };
    private JComboBox tfOnuVlanType = new JComboBox(onuVlanTypeTList);
    private final String onuVlanTypeSlotNo = fStringMap.getString("onuVlanTypeSlotNo") + " : ";
    private final String onuVlanTypePortNo = fStringMap.getString("onuVlanTypePortNo") + " : ";
    private final String onuVlanTypeLogicalPortNo = fStringMap.getString("onuVlanTypeLogicalPortNo") + " : ";
    private final String onuVlanTypeVirtualPortNo = fStringMap.getString("onuVlanTypeVirtualPortNo") + " : ";
    private final String onuVlanTypeNewSVLAN = fStringMap.getString("onuVlanTypeNewSVLAN") + " : ";
    private final String onuVlanTypeNewCVLAN = fStringMap.getString("onuVlanTypeNewCVLAN") + " : ";
    private final String onuVlanType = fStringMap.getString("onuVlanType") + " : ";
    private BBS4000NE ne = null;
    public OnuVlanTypeTablePanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
        
        baseInfoPanel.add(new JLabel(onuVlanTypeSlotNo));
        baseInfoPanel.add(tfOnuVlanTypeSlotNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuVlanTypePortNo));
        baseInfoPanel.add(tfOnuVlanTypePortNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuVlanTypeLogicalPortNo));
        baseInfoPanel.add(tfOnuVlanTypeLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTypeVirtualPortNo));
        baseInfoPanel.add(tfOnuVlanTypeVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTypeNewSVLAN));
        baseInfoPanel.add(tfOnuVlanTypeNewSVLAN);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanTypeNewCVLAN));
        baseInfoPanel.add(tfOnuVlanTypeNewCVLAN);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanType));
        tfOnuVlanType.setName(fStringMap.getString("onuVlanType"));
        baseInfoPanel.add(tfOnuVlanType);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1;i<=40;i++){
            tfOnuVlanTypeVirtualPortNo.addItem(i);
        }

    }

    protected void initForm() {
        tfOnuVlanTypeNewSVLAN.setValueScope(0, 4095);
        tfOnuVlanTypeNewCVLAN.setValueScope(0, 4095);
    }

    public void refresh() {
      //-------------------
        //Slot
        tfOnuVlanTypeSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuVlanTypeSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuVlanTypeSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuVlanTypePortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuVlanTypePortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuVlanTypeLogicalPortNo.removeAllItems();
        int count = ne.getPonSplitRatio();
        for (int i = 1; i <= count; i++) {
            tfOnuVlanTypeLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //-------------------
        
        if (SnmpAction.IType.ADD.equals(fCommand)){
            tfOnuVlanTypeSlotNo.setEnabled(true);
            tfOnuVlanTypePortNo.setEnabled(true);
            tfOnuVlanTypeLogicalPortNo.setEnabled(true);  
            tfOnuVlanTypeVirtualPortNo.setEnabled(true);
            tfOnuVlanTypeNewSVLAN.setEnabled(true);
            tfOnuVlanTypeNewCVLAN.setEnabled(true);

            return;
        }
       
       else {
           tfOnuVlanTypeSlotNo.setEnabled(false);
           tfOnuVlanTypePortNo.setEnabled(false);
           tfOnuVlanTypeLogicalPortNo.setEnabled(false);
           tfOnuVlanTypeVirtualPortNo.setEnabled(false);
           tfOnuVlanTypeNewSVLAN.setEnabled(false);
           tfOnuVlanTypeNewCVLAN.setEnabled(false);
        }
            
        OnuVlanTypeTable mbean = (OnuVlanTypeTable) getModel();
        tfOnuVlanTypeSlotNo.setSelectedItem((mbean.getOnuVlanTypeSlotNo() != null) ? fStringMap.getString("Slot") + " " +mbean.getOnuVlanTypeSlotNo()+" - GPM" : "");
        tfOnuVlanTypePortNo.setSelectedItem((mbean.getOnuVlanTypePortNo() != null) ? fStringMap.getString("Port") + " " +mbean.getOnuVlanTypePortNo() : "");
        tfOnuVlanTypeLogicalPortNo.setSelectedItem((mbean.getOnuVlanTypeLogicalPortNo() != null) ? fStringMap.getString("ONT") + " " +mbean.getOnuVlanTypeLogicalPortNo() : "");

        tfOnuVlanTypeVirtualPortNo.setSelectedItem(mbean.getOnuVlanTypeVirtualPortNo());
        tfOnuVlanTypeNewSVLAN.setValue(mbean.getOnuVlanTypeNewSVLAN());
        tfOnuVlanTypeNewCVLAN.setValue(mbean.getOnuVlanTypeNewCVLAN());
        tfOnuVlanType.setSelectedIndex(getIndexFromValue(onuVlanTypeVList, mbean.getOnuVlanType().intValue()));

    }

    public void updateModel() {
              
              if (SnmpAction.IType.ADD.equals(fCommand))  setModel(new OnuVlanTypeTable(fApplication.getSnmpProxy()));
                  OnuVlanTypeTable mbean = (OnuVlanTypeTable) getModel();
              if (SnmpAction.IType.ADD.equals(fCommand)) {
              //  here set the value of index
                  mbean.setOnuVlanTypeSlotNo(getSelectedSlotId());
                  mbean.setOnuVlanTypePortNo(getSelectedPortId());
                  mbean.setOnuVlanTypeLogicalPortNo(getSelectedOnuId());
                    mbean.setOnuVlanTypeVirtualPortNo(new Integer(tfOnuVlanTypeVirtualPortNo.getSelectedItem().toString()));
                    mbean.setOnuVlanTypeNewCVLAN(tfOnuVlanTypeNewCVLAN.getValue());
                    mbean.setOnuVlanTypeNewSVLAN(tfOnuVlanTypeNewSVLAN.getValue());
               }
              mbean.setOnuVlanType(new Integer(onuVlanTypeVList[tfOnuVlanType.getSelectedIndex()]));
          }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuVlanTypeSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuVlanTypeSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuVlanTypePortNo.getSelectedItem() != null) {
            String item = (String) tfOnuVlanTypePortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuVlanTypeLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuVlanTypeLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }
}
