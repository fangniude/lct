package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

/**
 * @author Yang Yizai , 2009-3-16
 */

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuLpDetectCfgTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The OnuLpDetectCfgTablePanel class.
 * Created by DVM Creator
 */
public class OnuLpDetectCfgTablePanel extends UPanel {

    private JComboBox tfOnuLpDetectCfgSlotNo = new JComboBox();
    private JComboBox tfOnuLpDetectCfgPortNo = new JComboBox();
    private JComboBox tfOnuLpDetectCfgLogicalPortNo = new JComboBox();
    
    private int[] onuLpDetectCfgEnableVList = new int[] { 2, 1, };
    private String[] onuLpDetectCfgEnableTList = new String[] { fStringMap.getString("disable"),
            fStringMap.getString("enable"), };
    private JComboBox tfOnuLpDetectCfgEnable = new JComboBox(onuLpDetectCfgEnableTList);
    private LongTextField tfOnuLpDetectCfgRecoveryTimer = new LongTextField();

    private int[] onuLpDetectCfgCfgRowStatusVList = new int[] { 1, 2, 5, 4, 3, 6, };
    private String[] onuLpDetectCfgCfgRowStatusTList = new String[] { fStringMap.getString("active"),
            fStringMap.getString("notInService"), fStringMap.getString("createAndWait"),
            fStringMap.getString("createAndGo"), fStringMap.getString("notReady"), fStringMap.getString("destroy"), };
    private JComboBox tfOnuLpDetectCfgCfgRowStatus = new JComboBox(onuLpDetectCfgCfgRowStatusTList);

    private final String onuLpDetectCfgSlotNo = fStringMap.getString("onuLpDetectCfgSlotNo") + " : ";
    private final String onuLpDetectCfgPortNo = fStringMap.getString("onuLpDetectCfgPortNo") + " : ";
    private final String onuLpDetectCfgLogicalPortNo = fStringMap.getString("onuLpDetectCfgLogicalPortNo") + " : ";
    private final String onuLpDetectCfgEnable = fStringMap.getString("onuLpDetectCfgEnable") + " : ";
    private final String onuLpDetectCfgRecoveryTimer = fStringMap.getString("onuLpDetectCfgRecoveryTimer") + " : ";
    private BBS4000NE ne = null;
    public OnuLpDetectCfgTablePanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuLpDetectCfgSlotNo));
        baseInfoPanel.add(tfOnuLpDetectCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLpDetectCfgPortNo));
        baseInfoPanel.add(tfOnuLpDetectCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLpDetectCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuLpDetectCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLpDetectCfgEnable));
        tfOnuLpDetectCfgEnable.setName(fStringMap.getString("onuLpDetectCfgEnable"));
        baseInfoPanel.add(tfOnuLpDetectCfgEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLpDetectCfgRecoveryTimer));
        tfOnuLpDetectCfgRecoveryTimer.setName(fStringMap.getString("onuLpDetectCfgRecoveryTimer"));
        baseInfoPanel.add(tfOnuLpDetectCfgRecoveryTimer);
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
        tfOnuLpDetectCfgRecoveryTimer.setValue(300);
    }

    public void refresh() {
      //-------------------
        //Slot
        tfOnuLpDetectCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuLpDetectCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuLpDetectCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            } 
        }
        //Port
        tfOnuLpDetectCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuLpDetectCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuLpDetectCfgLogicalPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
            tfOnuLpDetectCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }

        if (SnmpAction.IType.ADD.equals(fCommand)){
            tfOnuLpDetectCfgSlotNo.setEnabled(true);
            tfOnuLpDetectCfgPortNo.setEnabled(true);
            tfOnuLpDetectCfgLogicalPortNo.setEnabled(true);
            return;
        }
        else{
            tfOnuLpDetectCfgSlotNo.setEnabled(false);
            tfOnuLpDetectCfgPortNo.setEnabled(false);
            tfOnuLpDetectCfgLogicalPortNo.setEnabled(false);
        }
            
        OnuLpDetectCfgTable mbean = (OnuLpDetectCfgTable) getModel();

        tfOnuLpDetectCfgSlotNo.setSelectedItem((mbean.getOnuLpDetectCfgSlotNo() != null) ? fStringMap.getString("Slot") + " " + mbean.getOnuLpDetectCfgSlotNo().toString() : "");
        tfOnuLpDetectCfgPortNo.setSelectedItem((mbean.getOnuLpDetectCfgPortNo() != null) ? fStringMap.getString("Port") + " "+ mbean.getOnuLpDetectCfgPortNo().toString() : "");
        tfOnuLpDetectCfgLogicalPortNo.setSelectedItem((mbean.getOnuLpDetectCfgLogicalPortNo() != null) ? fStringMap.getString("ONT") + " " + mbean.getOnuLpDetectCfgLogicalPortNo().toString() : "");
        tfOnuLpDetectCfgEnable.setSelectedIndex(getIndexFromValue(onuLpDetectCfgEnableVList, mbean
                .getOnuLpDetectCfgEnable().intValue()));
        tfOnuLpDetectCfgRecoveryTimer.setValue(mbean.getOnuLpDetectCfgRecoveryTimer()!=null?mbean.getOnuLpDetectCfgRecoveryTimer().intValue():0);

    }

    public boolean validateFrom(){
        long timer = tfOnuLpDetectCfgRecoveryTimer.getValue();
        if(timer==0||(timer>=30&&timer<=86400))
            return true;
        else{
            String err = fStringMap.getString("err_recovery_timer");
            MessageDialog.showInfoMessageDialog(fApplication, err);
            return false;
        }
    }
    public void updateModel() {
              
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuLpDetectCfgTable(fApplication.getSnmpProxy()));
        OnuLpDetectCfgTable mbean = (OnuLpDetectCfgTable) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuLpDetectCfgSlotNo(getSelectedSlotId());
            mbean.setOnuLpDetectCfgPortNo(getSelectedPortId());
            mbean.setOnuLpDetectCfgLogicalPortNo(getSelectedOnuId());
        }
      
      mbean.setOnuLpDetectCfgEnable(new Integer(onuLpDetectCfgEnableVList[tfOnuLpDetectCfgEnable.getSelectedIndex()]));
      mbean.setOnuLpDetectCfgRecoveryTimer( new Long(tfOnuLpDetectCfgRecoveryTimer.getValue()));
          }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    
    public int getSelectedSlotId() {
        if (tfOnuLpDetectCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuLpDetectCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuLpDetectCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuLpDetectCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuLpDetectCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuLpDetectCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }
        return 0;
    }

}
