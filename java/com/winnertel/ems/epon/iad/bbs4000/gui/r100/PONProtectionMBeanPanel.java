package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

/**
 * @author Yang Yizai , 2009-3-20
 */

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.PONProtectionMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PONProtectionMBeanPanel extends UPanel {

    private IntegerTextField tfUtsPonTrunckProtectionGroupId = new IntegerTextField();
    private StringTextField tfUtsPonTrunckProtectionName = new StringTextField();
    private JComboBox tfUtsPonTrunckProtectionPort1ModuleId = new JComboBox();
    private JComboBox tfUtsPonTrunckProtectionPort1PortId = new JComboBox();
    private JComboBox tfUtsPonTrunckProtectionPort2ModuleId = new JComboBox();
    private JComboBox tfUtsPonTrunckProtectionPort2PortId = new JComboBox();

    
    private final String utsPonTrunckProtectionGroupId = fStringMap.getString("utsPonTrunckProtectionGroupId") + ": ";
//    private final String utsPonTrunckProtectionName = fStringMap.getString("utsPonTrunckProtectionName") + ": ";
    private final String utsPonTrunckProtectionPort1ModuleId = fStringMap.getString("utsPonTrunckProtectionPort1ModuleId") + ": ";
    private final String utsPonTrunckProtectionPort2ModuleId = fStringMap.getString("utsPonTrunckProtectionPort2ModuleId") + ": ";
    private final String utsPonTrunckProtectionPort1PortId = fStringMap.getString("utsPonTrunckProtectionPort1PortId") + ": ";
    private final String utsPonTrunckProtectionPort2PortId = fStringMap.getString("utsPonTrunckProtectionPort2PortId") + ": ";
    private BBS4000NE ne = null;
    public PONProtectionMBeanPanel(IApplication app) {
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

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionGroupId));
        tfUtsPonTrunckProtectionGroupId.setName(fStringMap.getString("utsPonTrunckProtectionGroupId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionGroupId);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionName));
//        tfUtsPonTrunckProtectionName.setName(fStringMap.getString("utsPonTrunckProtectionName"));
//        tfUtsPonTrunckProtectionName.setEnabled(false);
//        baseInfoPanel.add(tfUtsPonTrunckProtectionName);
//        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort1ModuleId));
        tfUtsPonTrunckProtectionPort1ModuleId.setName(fStringMap.getString("utsPonTrunckProtectionPort1ModuleId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort1ModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort1PortId));
        tfUtsPonTrunckProtectionPort1PortId.setName(fStringMap.getString("utsPonTrunckProtectionPort1PortId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort1PortId);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort2ModuleId));
        tfUtsPonTrunckProtectionPort2ModuleId.setName(fStringMap.getString("utsPonTrunckProtectionPort2ModuleId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort2ModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsPonTrunckProtectionPort2PortId));
        tfUtsPonTrunckProtectionPort2PortId.setName(fStringMap.getString("utsPonTrunckProtectionPort2PortId"));
        baseInfoPanel.add(tfUtsPonTrunckProtectionPort2PortId);
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
        tfUtsPonTrunckProtectionName.setLenScope(0, 16);
    }

    public void refresh() {
        tfUtsPonTrunckProtectionPort1ModuleId.removeAllItems();
        tfUtsPonTrunckProtectionPort2ModuleId.removeAllItems();
        
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsPonTrunckProtectionGroupId.setEnabled(true);
            tfUtsPonTrunckProtectionPort1ModuleId.setEnabled(true);
            tfUtsPonTrunckProtectionPort2ModuleId.setEnabled(true);
            tfUtsPonTrunckProtectionPort1PortId.setEnabled(true);
            tfUtsPonTrunckProtectionPort2PortId.setEnabled(true);
        } else {
            tfUtsPonTrunckProtectionGroupId.setEnabled(false);
            tfUtsPonTrunckProtectionPort1ModuleId.setEnabled(false);
            tfUtsPonTrunckProtectionPort2ModuleId.setEnabled(false);
            tfUtsPonTrunckProtectionPort1PortId.setEnabled(false);
            tfUtsPonTrunckProtectionPort2PortId.setEnabled(false);

            PONProtectionMBean mbean = (PONProtectionMBean) getModel();
            tfUtsPonTrunckProtectionPort1ModuleId.addItem(fStringMap.getString("Module") + " " + mbean.getUtsPonTrunckProtectionPort1ModuleId());
            tfUtsPonTrunckProtectionPort1PortId.addItem(fStringMap.getString("Port") + " " + mbean.getUtsPonTrunckProtectionPort1PortId());
            tfUtsPonTrunckProtectionPort2ModuleId.addItem(fStringMap.getString("Module") + " " + mbean.getUtsPonTrunckProtectionPort2ModuleId());
            tfUtsPonTrunckProtectionPort2PortId.addItem(fStringMap.getString("Port") + " " + mbean.getUtsPonTrunckProtectionPort2PortId());
            tfUtsPonTrunckProtectionGroupId.setValue(mbean.getUtsPonTrunckProtectionGroupId() != null ? mbean.getUtsPonTrunckProtectionGroupId() : 1);
            tfUtsPonTrunckProtectionName.setValue(mbean.getUtsPonTrunckProtectionName() != null ? mbean.getUtsPonTrunckProtectionName() : "");
            
            return;
        }

        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfUtsPonTrunckProtectionPort1ModuleId.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
                tfUtsPonTrunckProtectionPort2ModuleId.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfUtsPonTrunckProtectionPort1ModuleId.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
                tfUtsPonTrunckProtectionPort2ModuleId.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            }
        }
        tfUtsPonTrunckProtectionPort1PortId.removeAllItems();
        tfUtsPonTrunckProtectionPort2PortId.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfUtsPonTrunckProtectionPort1PortId.addItem(fStringMap.getString("Port") + " " + i);
            tfUtsPonTrunckProtectionPort2PortId.addItem(fStringMap.getString("Port") + " " + i);
        }
    }
    
    public boolean validateFrom(){
        String module1 = tfUtsPonTrunckProtectionPort1ModuleId.getSelectedItem().toString();
        String module2 = tfUtsPonTrunckProtectionPort2ModuleId.getSelectedItem().toString();
        String port1 = tfUtsPonTrunckProtectionPort1PortId.getSelectedItem().toString();
        String port2 = tfUtsPonTrunckProtectionPort2PortId.getSelectedItem().toString();

        if(module1.equals(module2) && port1.equals(port2))
        {
            String err = fStringMap.getString("Err_ModuleId1_Equals_ModuleId2");
            MessageDialog.showErrorMessageDialog(fApplication, err);
            return false;
        }
        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new PONProtectionMBean(fApplication.getSnmpProxy()));
        
        PONProtectionMBean mbean = (PONProtectionMBean) getModel();
        if (mbean == null)
            return;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUtsPonTrunckProtectionGroupId(tfUtsPonTrunckProtectionGroupId.getValue());
            mbean.setUtsPonTrunckProtectionPort1ModuleId(getSelectedId(tfUtsPonTrunckProtectionPort1ModuleId));
            mbean.setUtsPonTrunckProtectionPort1PortId(getSelectedId(tfUtsPonTrunckProtectionPort1PortId));
            mbean.setUtsPonTrunckProtectionPort2ModuleId(getSelectedId(tfUtsPonTrunckProtectionPort2ModuleId));
            mbean.setUtsPonTrunckProtectionPort2PortId(getSelectedId(tfUtsPonTrunckProtectionPort2PortId));
            mbean.setUtsPonTrunckProtectionPort1DeviceId(1);
            mbean.setUtsPonTrunckProtectionPort2DeviceId(1);
        }
        if(tfUtsPonTrunckProtectionName.isEnabled()) {
            mbean.setUtsPonTrunckProtectionName(tfUtsPonTrunckProtectionName.getValue());
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
    
    public int getSelectedId(JComboBox moduleId) {
        if (moduleId.getSelectedItem() != null) {
            String item = (String) moduleId.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

   

}
