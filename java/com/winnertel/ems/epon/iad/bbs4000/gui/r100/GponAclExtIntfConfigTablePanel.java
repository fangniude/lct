package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponAclExtIntfConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GponAclExtIntfConfigTablePanel extends UPanel {
    
    private JComboBox cbUtsGponAclExtIntfConfigIntfNum = new JComboBox();
    private JComboBox cbUtsGponAclExtIntfConfigOnuId = new JComboBox();
    private JComboBox cbUtsGponAclExtIntfConfigVPId = new JComboBox();
    private JComboBox cbUtsGponAclExtIntfConfigApplProfileId = new JComboBox();

    int[] utsGponAclExtIntfConfigFlowDirectionVList = new int[]{1, 2};
    String[] utsGponAclExtIntfConfigFlowDirectionTList = new String[]{
            fStringMap.getString("ingress"),
            fStringMap.getString("egress"),
    };
    private JComboBox cbUtsGponAclExtIntfConfigFlowDirection = new JComboBox(utsGponAclExtIntfConfigFlowDirectionTList);
  
    private final String utsGponAclExtIntfConfigIntfNum = fStringMap.getString("utsGponAclExtIntfConfigIntfNum") + ": ";
    private final String utsGponAclExtIntfConfigOnuId = fStringMap.getString("utsGponAclExtIntfConfigOnuId")+": ";
    private final String utsGponAclExtIntfConfigVPId = fStringMap.getString("utsGponAclExtIntfConfigVPId") +": ";
    private final String utsGponAclExtIntfConfigApplProfileId = fStringMap.getString("utsGponAclExtIntfConfigApplProfileId") + ": ";
    private final String utsGponAclExtIntfConfigFlowDirection = fStringMap.getString("utsGponAclExtIntfConfigFlowDirection") + ": ";

    public GponAclExtIntfConfigTablePanel(IApplication app) {
        super(app);
        setModel(new GponAclExtIntfConfigTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsGponAclExtIntfConfigIntfNum));
        cbUtsGponAclExtIntfConfigIntfNum.setName(fStringMap.getString("utsGponAclExtIntfConfigIntfNum"));
        baseInfoPanel.add(cbUtsGponAclExtIntfConfigIntfNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsGponAclExtIntfConfigOnuId));
        cbUtsGponAclExtIntfConfigOnuId.setName(fStringMap.getString("utsGponAclExtIntfConfigOnuId"));
        baseInfoPanel.add(cbUtsGponAclExtIntfConfigOnuId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsGponAclExtIntfConfigVPId));
        cbUtsGponAclExtIntfConfigVPId.setName(fStringMap.getString("utsGponAclExtIntfConfigVPId"));
        baseInfoPanel.add(cbUtsGponAclExtIntfConfigVPId);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsGponAclExtIntfConfigApplProfileId));
        cbUtsGponAclExtIntfConfigApplProfileId.setName(fStringMap.getString("utsGponAclExtIntfConfigApplProfileId"));
        baseInfoPanel.add(cbUtsGponAclExtIntfConfigApplProfileId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsGponAclExtIntfConfigFlowDirection));
        cbUtsGponAclExtIntfConfigFlowDirection.setName(fStringMap.getString("utsGponAclExtIntfConfigFlowDirection"));
        baseInfoPanel.add(cbUtsGponAclExtIntfConfigFlowDirection);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1; i<=40; i++)
            cbUtsGponAclExtIntfConfigVPId.addItem(i);
        for(int i=1; i<=128; i++)
            cbUtsGponAclExtIntfConfigOnuId.addItem(i);
    }

    protected void initForm() {
        
    }

    public void refresh() {
        
        cbUtsGponAclExtIntfConfigApplProfileId.removeAllItems();
        AclExtProfileImportTable mbean = new AclExtProfileImportTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        for (int i = 0; i < v.size(); i++) {
            AclExtProfileImportTable one = (AclExtProfileImportTable) v.get(i);
            if (one.getUtsAclExtProfileImportProfileId() <= 32) {
                cbUtsGponAclExtIntfConfigApplProfileId.addItem(one.getUtsAclExtProfileImportProfileId());
            }
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            cbUtsGponAclExtIntfConfigIntfNum.removeAllItems();
            getAllInterface();
            cbUtsGponAclExtIntfConfigVPId.setEnabled(true);
            cbUtsGponAclExtIntfConfigOnuId.setEnabled(true);
            cbUtsGponAclExtIntfConfigFlowDirection.setEnabled(true);
            return;
        }

        GponAclExtIntfConfigTable mbean1 = (GponAclExtIntfConfigTable) getModel();
        if (mbean1 == null)
            return;
        cbUtsGponAclExtIntfConfigOnuId.setSelectedItem(mbean1.getUtsGponAclExtIntfConfigOnuId());
        cbUtsGponAclExtIntfConfigVPId.setSelectedItem(mbean1.getUtsGponAclExtIntfConfigVPId());
        cbUtsGponAclExtIntfConfigOnuId.setEnabled(false);
        cbUtsGponAclExtIntfConfigVPId.setEnabled(false);
        String index = mbean1.getUtsGponAclExtIntfConfigIntfNum().toString();
        cbUtsGponAclExtIntfConfigIntfNum.addItem(index);
        cbUtsGponAclExtIntfConfigIntfNum.setEnabled(false);
        cbUtsGponAclExtIntfConfigApplProfileId.setSelectedItem(mbean1.getUtsGponAclExtIntfConfigApplProfileId());
        cbUtsGponAclExtIntfConfigFlowDirection.setSelectedIndex(getIndexFromValue(utsGponAclExtIntfConfigFlowDirectionVList, mbean1.getUtsGponAclExtIntfConfigFlowDirection()));
        cbUtsGponAclExtIntfConfigFlowDirection.setEnabled(false);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponAclExtIntfConfigTable(fApplication.getSnmpProxy()));

        GponAclExtIntfConfigTable mbean = (GponAclExtIntfConfigTable) getModel();
        if (mbean == null)
            return;

        String id = cbUtsGponAclExtIntfConfigIntfNum.getSelectedItem().toString();
        int indexnum = 0;
        if (id.startsWith("lg")) {
            indexnum = 48 + Integer.parseInt(id.substring(2));
        } else if (id.equalsIgnoreCase(fStringMap.getString("CPU Port"))) {
            indexnum = 5000;
        } else {
            Integer module = Integer.valueOf(id.substring(0, id.indexOf('/')));
            Integer port = Integer.valueOf(id.substring(id.indexOf('/') + 1, id.length()));
            indexnum = new Integer((module.intValue() - 1) * 4 + port.intValue()).intValue();
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUtsGponAclExtIntfConfigIntfNum(new Integer(indexnum));
            mbean.setUtsGponAclExtIntfConfigOnuId(new Integer(cbUtsGponAclExtIntfConfigOnuId.getSelectedItem().toString()));
            mbean.setUtsGponAclExtIntfConfigVPId(new Integer(cbUtsGponAclExtIntfConfigVPId.getSelectedItem().toString()));
            mbean.setUtsGponAclExtIntfConfigFlowDirection(new Integer(utsGponAclExtIntfConfigFlowDirectionVList[cbUtsGponAclExtIntfConfigFlowDirection.getSelectedIndex()]));
        }

        mbean.setUtsGponAclExtIntfConfigApplProfileId(new Integer(cbUtsGponAclExtIntfConfigApplProfileId.getSelectedItem().toString()));
       
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog(this).dispose();
    }

    void getAllInterface() {
        
        cbUtsGponAclExtIntfConfigIntfNum.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                for(int j=1; j<=4; j++)
                    cbUtsGponAclExtIntfConfigIntfNum.addItem(card.getUtsEponModuleBoardPhyId() + "/" +j);
            } 
        }

    }


}
