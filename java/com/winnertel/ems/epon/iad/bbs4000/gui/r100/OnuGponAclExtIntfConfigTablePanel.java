package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuGponAclExtIntfConfigTable;
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

public class OnuGponAclExtIntfConfigTablePanel extends UPanel {
    
    private JComboBox cbOnuGponAclExtIntfConfigIntfNum = new JComboBox();
    private JComboBox cbOnuGponAclExtIntfConfigOnuId = new JComboBox();
    private JComboBox cbOnuGponAclExtIntfConfigVPId = new JComboBox();
    private JComboBox cbOnuGponAclExtIntfConfigApplProfileId = new JComboBox();

    int[] onuGponAclExtIntfConfigFlowDirectionVList = new int[]{1, 2};
    String[] onuGponAclExtIntfConfigFlowDirectionTList = new String[]{
            fStringMap.getString("ingress"),
            fStringMap.getString("egress"),
    };
    private JComboBox cbOnuGponAclExtIntfConfigFlowDirection = new JComboBox(onuGponAclExtIntfConfigFlowDirectionTList);

    private final String onuGponAclExtIntfConfigIntfNum = fStringMap.getString("onuGponAclExtIntfConfigIntfNum") + ": ";
    private final String onuGponAclExtIntfConfigOnuId = fStringMap.getString("onuGponAclExtIntfConfigOnuId")+": ";
    private final String onuGponAclExtIntfConfigVPId = fStringMap.getString("onuGponAclExtIntfConfigVPId") +": ";
    private final String onuGponAclExtIntfConfigApplProfileId = fStringMap.getString("onuGponAclExtIntfConfigApplProfileId") + ": ";
    private final String onuGponAclExtIntfConfigFlowDirection = fStringMap.getString("onuGponAclExtIntfConfigFlowDirection") + ": ";

    public OnuGponAclExtIntfConfigTablePanel(IApplication app) {
        super(app);
        setModel(new OnuGponAclExtIntfConfigTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuGponAclExtIntfConfigIntfNum));
        cbOnuGponAclExtIntfConfigIntfNum.setName(fStringMap.getString("onuGponAclExtIntfConfigIntfNum"));
        baseInfoPanel.add(cbOnuGponAclExtIntfConfigIntfNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuGponAclExtIntfConfigOnuId));
        cbOnuGponAclExtIntfConfigOnuId.setName(fStringMap.getString("onuGponAclExtIntfConfigOnuId"));
        baseInfoPanel.add(cbOnuGponAclExtIntfConfigOnuId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuGponAclExtIntfConfigVPId));
        cbOnuGponAclExtIntfConfigVPId.setName(fStringMap.getString("onuGponAclExtIntfConfigVPId"));
        baseInfoPanel.add(cbOnuGponAclExtIntfConfigVPId);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuGponAclExtIntfConfigApplProfileId));
        cbOnuGponAclExtIntfConfigApplProfileId.setName(fStringMap.getString("onuGponAclExtIntfConfigApplProfileId"));
        baseInfoPanel.add(cbOnuGponAclExtIntfConfigApplProfileId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuGponAclExtIntfConfigFlowDirection));
        cbOnuGponAclExtIntfConfigFlowDirection.setName(fStringMap.getString("onuGponAclExtIntfConfigFlowDirection"));
        baseInfoPanel.add(cbOnuGponAclExtIntfConfigFlowDirection);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=0; i<=40; i++)
            cbOnuGponAclExtIntfConfigVPId.addItem(i);
        for(int i=1; i<=128; i++)
            cbOnuGponAclExtIntfConfigOnuId.addItem(i);
    }

    protected void initForm() {
        
    }

    public void refresh() {
        
        cbOnuGponAclExtIntfConfigApplProfileId.removeAllItems();
        AclExtProfileImportTable mbean = new AclExtProfileImportTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, mbean);
        for (int i = 0; i < v.size(); i++) {
            AclExtProfileImportTable one = (AclExtProfileImportTable) v.get(i);
            if (one.getUtsAclExtProfileImportProfileId() <= 32) {
                cbOnuGponAclExtIntfConfigApplProfileId.addItem(one.getUtsAclExtProfileImportProfileId());
            }
        }
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            cbOnuGponAclExtIntfConfigIntfNum.removeAllItems();
            getAllInterface();
            cbOnuGponAclExtIntfConfigVPId.setEnabled(true);
            cbOnuGponAclExtIntfConfigOnuId.setEnabled(true);
            cbOnuGponAclExtIntfConfigFlowDirection.setEnabled(true);
            return;
        }

        OnuGponAclExtIntfConfigTable mbean1 = (OnuGponAclExtIntfConfigTable) getModel();
        if (mbean1 == null)
            return;
        cbOnuGponAclExtIntfConfigOnuId.setSelectedItem(mbean1.getOnuGponAclExtIntfConfigOnuId());
        cbOnuGponAclExtIntfConfigVPId.setSelectedItem(mbean1.getOnuGponAclExtIntfConfigVPId());
        cbOnuGponAclExtIntfConfigOnuId.setEnabled(false);
        cbOnuGponAclExtIntfConfigVPId.setEnabled(false);
        String index = mbean1.getOnuGponAclExtIntfConfigIntfNum().toString();
        cbOnuGponAclExtIntfConfigIntfNum.addItem(index);
        cbOnuGponAclExtIntfConfigIntfNum.setEnabled(false);
        cbOnuGponAclExtIntfConfigApplProfileId.setSelectedItem(mbean1.getOnuGponAclExtIntfConfigApplProfileId());
        cbOnuGponAclExtIntfConfigFlowDirection.setSelectedIndex(getIndexFromValue(onuGponAclExtIntfConfigFlowDirectionVList, mbean1.getOnuGponAclExtIntfConfigFlowDirection()));
        cbOnuGponAclExtIntfConfigFlowDirection.setEnabled(false);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuGponAclExtIntfConfigTable(fApplication.getSnmpProxy()));

        OnuGponAclExtIntfConfigTable mbean = (OnuGponAclExtIntfConfigTable) getModel();
        if (mbean == null)
            return;

        String id = cbOnuGponAclExtIntfConfigIntfNum.getSelectedItem().toString();
        int indexnum = 0;
            Integer module = Integer.valueOf(id.substring(0, id.indexOf('/')));
            Integer port = Integer.valueOf(id.substring(id.indexOf('/') + 1, id.length()));
            indexnum = new Integer((module.intValue() - 1) * 4 + port.intValue()).intValue();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuGponAclExtIntfConfigIntfNum(new Integer(indexnum));
            mbean.setOnuGponAclExtIntfConfigOnuId(new Integer(cbOnuGponAclExtIntfConfigOnuId.getSelectedItem().toString()));
            mbean.setOnuGponAclExtIntfConfigVPId(new Integer(cbOnuGponAclExtIntfConfigVPId.getSelectedItem().toString()));
            mbean.setOnuGponAclExtIntfConfigFlowDirection(new Integer(onuGponAclExtIntfConfigFlowDirectionVList[cbOnuGponAclExtIntfConfigFlowDirection.getSelectedIndex()]));
        }

        mbean.setOnuGponAclExtIntfConfigApplProfileId(new Integer(cbOnuGponAclExtIntfConfigApplProfileId.getSelectedItem().toString()));
       
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
        
        cbOnuGponAclExtIntfConfigIntfNum.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                for(int j=1; j<=4; j++)
                cbOnuGponAclExtIntfConfigIntfNum.addItem(card.getUtsEponModuleBoardPhyId() + "/" +j);
            } 
        }

    }
}
