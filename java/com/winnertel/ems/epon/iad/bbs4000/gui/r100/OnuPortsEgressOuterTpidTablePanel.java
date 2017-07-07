package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuPortsEgressOuterTpidTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OnuPortsEgressOuterTpidTablePanel class.
 * Created by DVM Creator
 */
public class OnuPortsEgressOuterTpidTablePanel extends UPanel {

    
    private JComboBox tfOnuPortsEgressOuterTpidSlotNo = new JComboBox();
    private JComboBox tfOnuPortsEgressOuterTpidPortNo = new JComboBox();
    private JComboBox tfOnuPortsEgressOuterTpidLogicalPortNo = new JComboBox();
    private int[] onuPortsEgressOuterTpidVList = new int[]{33024,34984,37120};
    private String[] onuPortsEgressOuterTpidTList = new String[]{"0x8100","0x88a8","0x9100"};
    private JComboBox tfOnuPortsEgressOuterTpid = new JComboBox(onuPortsEgressOuterTpidTList);


    private final String onuPortsEgressOuterTpidSlotNo = fStringMap.getString("onuPortsEgressOuterTpidSlotNo") + " : ";
    private final String onuPortsEgressOuterTpidPortNo = fStringMap.getString("onuPortsEgressOuterTpidPortNo") + " : ";
    private final String onuPortsEgressOuterTpidLogicalPortNo = fStringMap
            .getString("onuPortsEgressOuterTpidLogicalPortNo")
            + " : ";
    private final String onuPortsEgressOuterTpid = fStringMap.getString("onuPortsEgressOuterTpid") + " : ";
    private BBS4000NE ne = null;
    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;
    
    public OnuPortsEgressOuterTpidTablePanel(IApplication app) {
        super(app);
        setModel(new OnuPortsEgressOuterTpidTable(app.getSnmpProxy()));
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication,this);
        btApply.getAction().putValue(BaseAction.ID,"Modify_OnuPortsEgressOuterTpidTable");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);
        
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuPortsEgressOuterTpidSlotNo));
        baseInfoPanel.add(tfOnuPortsEgressOuterTpidSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPortsEgressOuterTpidPortNo));
        baseInfoPanel.add(tfOnuPortsEgressOuterTpidPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPortsEgressOuterTpidLogicalPortNo));
        baseInfoPanel.add(tfOnuPortsEgressOuterTpidLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuPortsEgressOuterTpid));
        tfOnuPortsEgressOuterTpid.setName(fStringMap.getString("onuPortsEgressOuterTpid"));
        baseInfoPanel.add(tfOnuPortsEgressOuterTpid);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    protected void initForm() {

    }

    public void refresh() {
        
      //-------------------
        //Slot
        tfOnuPortsEgressOuterTpidSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuPortsEgressOuterTpidSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuPortsEgressOuterTpidSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } /*else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GEM");
            }*/
        }
        //Port
        tfOnuPortsEgressOuterTpidPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuPortsEgressOuterTpidPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuPortsEgressOuterTpidLogicalPortNo.removeAllItems();
        int count = ne.getPonSplitRatio();
        for (int i = 1; i <= count; i++) {
            tfOnuPortsEgressOuterTpidLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }
        //-------------------
        OnuPortsEgressOuterTpidTable mbean = (OnuPortsEgressOuterTpidTable) getModel();
        BeanService.refreshBean(fApplication, mbean);
            
        tfOnuPortsEgressOuterTpidSlotNo.setSelectedItem((mbean.getOnuPortsEgressOuterTpidSlotNo() != null) ? mbean.getOnuPortsEgressOuterTpidSlotNo().toString() : "");
        tfOnuPortsEgressOuterTpidPortNo.setSelectedItem((mbean.getOnuPortsEgressOuterTpidPortNo() != null) ? mbean.getOnuPortsEgressOuterTpidPortNo().toString() : "");
        tfOnuPortsEgressOuterTpidLogicalPortNo.setSelectedItem((mbean.getOnuPortsEgressOuterTpidLogicalPortNo() != null) ? mbean.getOnuPortsEgressOuterTpidLogicalPortNo().toString() : "");

        tfOnuPortsEgressOuterTpid.setSelectedIndex(getIndexFromValue(onuPortsEgressOuterTpidVList, mbean.getOnuPortsEgressOuterTpid()!=null?mbean.getOnuPortsEgressOuterTpid():0));

    }

    public void updateModel() {
              
        OnuPortsEgressOuterTpidTable mbean = (OnuPortsEgressOuterTpidTable) getModel();
              mbean.setOnuPortsEgressOuterTpidSlotNo(getSelectedSlotId());
              mbean.setOnuPortsEgressOuterTpidPortNo(getSelectedPortId());
              mbean.setOnuPortsEgressOuterTpidLogicalPortNo(getSelectedOnuId());
              mbean.setOnuPortsEgressOuterTpid( onuPortsEgressOuterTpidVList[tfOnuPortsEgressOuterTpid.getSelectedIndex()]);
          }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    
    public int getSelectedSlotId() {
        if (tfOnuPortsEgressOuterTpidSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuPortsEgressOuterTpidSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuPortsEgressOuterTpidPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuPortsEgressOuterTpidPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuPortsEgressOuterTpidLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuPortsEgressOuterTpidLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}
