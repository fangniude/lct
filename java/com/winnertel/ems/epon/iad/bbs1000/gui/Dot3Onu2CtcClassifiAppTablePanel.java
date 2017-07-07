package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcClassifiAppTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3OnuClassifiImportTable;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Onu2CtcClassifiRuleTable;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class Dot3Onu2CtcClassifiAppTablePanel extends UPanel implements ActionListener {

    private JComboBox tfUtsDot3OnuClassifiAppModuleId = new JComboBox();
    //private JComboBox tfUtsDot3OnuClassifiAppDeviceId = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppPortId = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppLogicalPortId = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppPortIndex = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppClassId = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppFieldId = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppPrecedence = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppQueueMapped = new JComboBox();
    private JComboBox tfUtsDot3OnuClassifiAppPriMark = new JComboBox();

    private final String utsDot3OnuClassifiAppModuleId = fStringMap.getString("utsDot3OnuClassifiAppModuleId") + " : ";
    //private final String utsDot3OnuClassifiAppDeviceId = fStringMap.getString("utsDot3OnuClassifiAppDeviceId") + " : ";
    private final String utsDot3OnuClassifiAppPortId = fStringMap.getString("utsDot3OnuClassifiAppPortId") + " : ";
    private final String utsDot3OnuClassifiAppLogicalPortId = fStringMap.getString("utsDot3OnuClassifiAppLogicalPortId") + " : ";
    private final String utsDot3OnuClassifiAppPortIndex = fStringMap.getString("utsDot3OnuClassifiAppPortIndex") + " : ";
    private final String utsDot3OnuClassifiAppPrecedence = fStringMap.getString("utsDot3OnuClassifiAppPrecedence") + " : ";
    private final String utsDot3OnuClassifiAppQueueMapped = fStringMap.getString("utsDot3OnuClassifiAppQueueMapped") + " : ";
    private final String utsDot3OnuClassifiAppPriMark = fStringMap.getString("utsDot3OnuClassifiAppPriMark") + " : ";
    private final String utsDot3OnuClassifiAppClassId = fStringMap.getString("utsDot3OnuClassifiAppClassId") + " : ";
    private final String utsDot3OnuClassifiAppFieldId = fStringMap.getString("utsDot3OnuClassifiAppFieldId") + " : ";

    public Dot3Onu2CtcClassifiAppTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppModuleId));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppModuleId);
        baseInfoPanel.add(new HSpacer());

        BBS1000NE ne = new BBS1000NE(fApplication);
        for (int i = 0; i < ne.getPortCount(); i++) {
            tfUtsDot3OnuClassifiAppPortId.addItem(i + 1);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppPortId));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppPortId);
        baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < ne.getPonSplitRatio(); i++) {
            tfUtsDot3OnuClassifiAppLogicalPortId.addItem(i + 1);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        for(int i = 1; i <= 4; i++) {
          tfUtsDot3OnuClassifiAppPortIndex.addItem(i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppPortIndex));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppPortIndex);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3OnuClassifiAppClassId.addActionListener(this);
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppClassId));
        tfUtsDot3OnuClassifiAppClassId.setName(fStringMap.getString("utsDot3OnuClassifiAppClassId"));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppClassId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppFieldId));
        tfUtsDot3OnuClassifiAppFieldId.setName(fStringMap.getString("utsDot3OnuClassifiAppFieldId"));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppFieldId);
        baseInfoPanel.add(new HSpacer());

        //zhangyunfang update to 1?20  2007.4.9
        for (int i = 1; i <= 20; i++) {
            tfUtsDot3OnuClassifiAppPrecedence.addItem("" + i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppPrecedence));
        tfUtsDot3OnuClassifiAppPrecedence.setName(fStringMap.getString("utsDot3OnuClassifiAppPrecedence"));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppPrecedence);
        baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < 8; i++) {
            tfUtsDot3OnuClassifiAppQueueMapped.addItem("" + i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppQueueMapped));
        tfUtsDot3OnuClassifiAppQueueMapped.setName(fStringMap.getString("utsDot3OnuClassifiAppQueueMapped"));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppQueueMapped);
        baseInfoPanel.add(new HSpacer());

        //zhangyunfang update to 0-8 and 8 is none  2007.4.9
        for (int i = 0; i <= 8; i++) {
            if (i == 8)
                tfUtsDot3OnuClassifiAppPriMark.addItem("none");
            else
                tfUtsDot3OnuClassifiAppPriMark.addItem("" + i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuClassifiAppPriMark));
        tfUtsDot3OnuClassifiAppPriMark.setName(fStringMap.getString("utsDot3OnuClassifiAppPriMark"));
        baseInfoPanel.add(tfUtsDot3OnuClassifiAppPriMark);
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
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfUtsDot3OnuClassifiAppModuleId.removeAllItems();
            ModuleType fModuleType = new ModuleType();
            BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
            Vector list = BeanService.refreshTableBean(fApplication, bean);
            for (int i = 0; i < list.size(); i++) {
                BBS1000CardMibBean card = (BBS1000CardMibBean) list.get(i);
                if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                    tfUtsDot3OnuClassifiAppModuleId.addItem(card.getUtsEponModuleBoardPhyId());
                }
            }

            tfUtsDot3OnuClassifiAppClassId.removeAllItems();
            Dot3OnuClassifiImportTable mbean = new Dot3OnuClassifiImportTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, mbean);
            for (int i = 0; i < v.size(); i++) {
                Dot3OnuClassifiImportTable one = (Dot3OnuClassifiImportTable) v.get(i);
                tfUtsDot3OnuClassifiAppClassId.addItem(one.getUtsDot3OnuClassifiImportClassId());
            }
        }
    }

    public boolean validateFrom() {
        if (tfUtsDot3OnuClassifiAppModuleId.getSelectedItem() == null) {
            String error = fStringMap.getString("Err_Module_Id_Is_Null");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        if (tfUtsDot3OnuClassifiAppClassId.getSelectedItem() == null) {
            String error = fStringMap.getString("Err_Classification_Id_Is_Null");
            MessageDialog.showErrorMessageDialog(fApplication, error);
        }

        if (tfUtsDot3OnuClassifiAppFieldId.getSelectedItem() == null) {
            String error = fStringMap.getString("Err_Rule_Id_Is_Null");
            MessageDialog.showErrorMessageDialog(fApplication, error);
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new Dot3Onu2CtcClassifiAppTable(fApplication.getSnmpProxy()));

        Dot3Onu2CtcClassifiAppTable mbean = (Dot3Onu2CtcClassifiAppTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setUtsDot3OnuClassifiAppModuleId((Integer) tfUtsDot3OnuClassifiAppModuleId.getSelectedItem());
            mbean.setUtsDot3OnuClassifiAppDeviceId(1);
            mbean.setUtsDot3OnuClassifiAppPortId((Integer) tfUtsDot3OnuClassifiAppPortId.getSelectedItem());
            mbean.setUtsDot3OnuClassifiAppLogicalPortId((Integer) tfUtsDot3OnuClassifiAppLogicalPortId.getSelectedItem());
            mbean.setUtsDot3OnuClassifiAppPortIndex((Integer) tfUtsDot3OnuClassifiAppPortIndex.getSelectedItem());
            mbean.setUtsDot3OnuClassifiAppClassId((Integer) tfUtsDot3OnuClassifiAppClassId.getSelectedItem());
            mbean.setUtsDot3OnuClassifiAppFieldId((Integer) tfUtsDot3OnuClassifiAppFieldId.getSelectedItem());
        }

        mbean.setUtsDot3OnuClassifiAppPrecedence(new Integer((String) tfUtsDot3OnuClassifiAppPrecedence.getSelectedItem()));
        mbean.setUtsDot3OnuClassifiAppQueueMapped(new Integer((String) tfUtsDot3OnuClassifiAppQueueMapped.getSelectedItem()));

        if (((String) tfUtsDot3OnuClassifiAppPriMark.getSelectedItem()).equalsIgnoreCase("none"))
            mbean.setUtsDot3OnuClassifiAppPriMark(new Integer("8"));
        else
            mbean.setUtsDot3OnuClassifiAppPriMark(new Integer((String) tfUtsDot3OnuClassifiAppPriMark.getSelectedItem()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        tfUtsDot3OnuClassifiAppFieldId.removeAllItems();

        Dot3Onu2CtcClassifiRuleTable ruleTable = null;
        try {
            Integer classId = (Integer) tfUtsDot3OnuClassifiAppClassId.getSelectedItem();
            ruleTable = new Dot3Onu2CtcClassifiRuleTable(fApplication.getSnmpProxy());
            ruleTable.setUtsDot3OnuClassifiRuleProfId(classId);
            ruleTable.setUtsDot3OnuClassifiRuleId(0);

            ruleTable.setRowsPerFetch(50);
            ruleTable.setIndexPrefix(classId + ".");
            Vector v = ruleTable.retrieveAll();

            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    tfUtsDot3OnuClassifiAppFieldId.addItem(((Dot3Onu2CtcClassifiRuleTable) v.get(i)).getUtsDot3OnuClassifiRuleId());
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}