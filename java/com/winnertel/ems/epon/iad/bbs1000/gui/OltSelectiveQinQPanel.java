package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.OltSelectiveQinQMBean;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
//import java.awt.event.ItemListener;
//import java.awt.event.ItemEvent;

public class OltSelectiveQinQPanel extends UPanel implements ActionListener {
//public class OltSelectiveQinQPanel extends UPanel {

    private JComboBox tfUtsDot3OnuSelectiveQinQModuleId = new JComboBox();
    //private JComboBox tfUtsDot3OnuSelectiveQinQDeviceId = new JComboBox();
    private JComboBox tfUtsDot3OnuSelectiveQinQPortId = new JComboBox();
    //private JComboBox tfUtsDot3OnuSelectiveQinQLogicalPortId = new JComboBox();

    private JCheckBox cbUtsDot3OnuSelectiveQinQEtherType = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private HexTextField tfUtsDot3OnuSelectiveQinQEtherType = new HexTextField();

    private JCheckBox cbUtsDot3OnuSelectiveQinQCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuSelectiveQinQCos = new IntegerTextField();

    //private JCheckBox cbUtsDot3OnuSelectiveQinQCVID = new JCheckBox(); //remarked by Zhou Chao, 2008/10/15
    //private IntegerTextField tfUtsDot3OnuSelectiveQinQCVID = new IntegerTextField(); //remarked by Zhou Chao, 2008/10/15

    private JCheckBox cbUtsDot3OnuSelectiveQinQStartCVID = new JCheckBox(); //added by Zhou Chao, 2008/10/15
    private IntegerTextField tfUtsDot3OnuSelectiveQinQStartCVID = new IntegerTextField(); //added by Zhou Chao, 2008/10/15

    private JCheckBox cbUtsDot3OnuSelectiveQinQEndCVID = new JCheckBox(); //added by Zhou Chao, 2008/10/15
    private IntegerTextField tfUtsDot3OnuSelectiveQinQEndCVID = new IntegerTextField(); //added by Zhou Chao, 2008/10/15

    private JCheckBox cbUtsDot3OnuSelectiveQinQSVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuSelectiveQinQSVID = new IntegerTextField();

    private int[] utsDot3OnuSelectiveQinQSCosSourceSelectVList = new int[]{1, 2,};
    private String[] utsDot3OnuSelectiveQinQSCosSourceSelectTList = new String[]{
            fStringMap.getString("copyfromctag"),
            fStringMap.getString("usingappointnewvalue"),
    };
    private JComboBox tfUtsDot3OnuSelectiveQinQSCosSourceSelect = new JComboBox(utsDot3OnuSelectiveQinQSCosSourceSelectTList);

    private JCheckBox cbUtsDot3OnuSelectiveQinQSAppointCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuSelectiveQinQSAppointCos = new IntegerTextField();

    private final String utsDot3OnuSelectiveQinQModuleId = fStringMap.getString("utsDot3OnuSelectiveQinQModuleId") + ": ";
    private final String utsDot3OnuSelectiveQinQPortId = fStringMap.getString("utsDot3OnuSelectiveQinQPortId") + ": ";
    //private final String utsDot3OnuSelectiveQinQLogicalPortId = fStringMap.getString("utsDot3OnuSelectiveQinQLogicalPortId") + ": ";
    private final String utsDot3OnuSelectiveQinQEtherType = fStringMap.getString("utsDot3OnuSelectiveQinQEtherType") + ": ";
    private final String utsDot3OnuSelectiveQinQCos = fStringMap.getString("utsDot3OnuSelectiveQinQCos") + ": ";
    //private final String utsDot3OnuSelectiveQinQCVID = fStringMap.getString("utsDot3OnuSelectiveQinQCVID") + ": ";
    private final String utsDot3OnuSelectiveQinQStartCVID = fStringMap.getString("utsDot3OnuSelectiveQinQStartCVID") + ": ";
    private final String utsDot3OnuSelectiveQinQEndCVID = fStringMap.getString("utsDot3OnuSelectiveQinQEndCVID") + ": ";

    private final String utsDot3OnuSelectiveQinQSVID = fStringMap.getString("utsDot3OnuSelectiveQinQSVID") + ": ";
    private final String utsDot3OnuSelectiveQinQSCosSourceSelect = fStringMap.getString("utsDot3OnuSelectiveQinQSCosSourceSelect") + ": ";
    private final String utsDot3OnuSelectiveQinQSAppointCos = fStringMap.getString("utsDot3OnuSelectiveQinQSAppointCos") + ": ";

    public OltSelectiveQinQPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5); //modified by Zhou Chao, 2008/8/9
        layout.setMargins(6, 30, 6, 10);
        baseInfoPanel.setLayout(layout);
//        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel lbModuleId = new JLabel(utsDot3OnuSelectiveQinQModuleId);
//      baseInfoPanel.add(new JLabel(utsDot3OnuSelectiveQinQModuleId));
        baseInfoPanel.add(lbModuleId);
        baseInfoPanel.add(tfUtsDot3OnuSelectiveQinQModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OnuSelectiveQinQDeviceId));
        //baseInfoPanel.add(tfUtsDot3OnuSelectiveQinQDeviceId) ;
        //baseInfoPanel.add(new HSpacer());

        for (int i = 1; i <= 4.; i++)
            tfUtsDot3OnuSelectiveQinQPortId.addItem(String.valueOf(i));
        baseInfoPanel.add(new JLabel(utsDot3OnuSelectiveQinQPortId));
        baseInfoPanel.add(tfUtsDot3OnuSelectiveQinQPortId);
        baseInfoPanel.add(new HSpacer());

        //String onu = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_ONU_ID);
        //tfUtsDot3OnuSelectiveQinQLogicalPortId.addItem(onu);
        //tfUtsDot3OnuSelectiveQinQLogicalPortId.setEnabled(false);
        //baseInfoPanel.add(new JLabel(utsDot3OnuSelectiveQinQLogicalPortId));
        //baseInfoPanel.add(tfUtsDot3OnuSelectiveQinQLogicalPortId);
        //baseInfoPanel.add(new HSpacer());
        
        //CVLAN Parameter
        JPanel cvlanPanel = new JPanel();
        NTLayout layout2 = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        cvlanPanel.setLayout(layout2);
        cvlanPanel.setBorder(BorderFactory.createTitledBorder("C-VLAN"));

        cbUtsDot3OnuSelectiveQinQEtherType.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQEtherType.setEnabled(cbUtsDot3OnuSelectiveQinQEtherType.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQEtherType.setText(utsDot3OnuSelectiveQinQEtherType);
        tfUtsDot3OnuSelectiveQinQEtherType.setEnabled(false);
        cvlanPanel.add(cbUtsDot3OnuSelectiveQinQEtherType);
        tfUtsDot3OnuSelectiveQinQEtherType.setName(fStringMap.getString("utsDot3OnuSelectiveQinQEtherType"));
        cvlanPanel.add(tfUtsDot3OnuSelectiveQinQEtherType);
        cvlanPanel.add(new HSpacer());

        cbUtsDot3OnuSelectiveQinQCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQCos.setEnabled(cbUtsDot3OnuSelectiveQinQCos.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQCos.setText(utsDot3OnuSelectiveQinQCos);
        tfUtsDot3OnuSelectiveQinQCos.setEnabled(false);
        cvlanPanel.add(cbUtsDot3OnuSelectiveQinQCos);
        tfUtsDot3OnuSelectiveQinQCos.setName(fStringMap.getString("utsDot3OnuSelectiveQinQCos"));
        cvlanPanel.add(tfUtsDot3OnuSelectiveQinQCos);
        cvlanPanel.add(new HSpacer());

        /*
        cbUtsDot3OnuSelectiveQinQCVID.addChangeListener(new ChangeListener() { //remarked by Zhou Chao, 2008/10/15
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQCVID.setEnabled(cbUtsDot3OnuSelectiveQinQCVID.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQCVID.setText(utsDot3OnuSelectiveQinQCVID);
        tfUtsDot3OnuSelectiveQinQCVID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuSelectiveQinQCVID);
        tfUtsDot3OnuSelectiveQinQCVID.setName(fStringMap.getString("utsDot3OnuSelectiveQinQCVID"));
        baseInfoPanel.add(tfUtsDot3OnuSelectiveQinQCVID);
        baseInfoPanel.add(new HSpacer());
        */

        cbUtsDot3OnuSelectiveQinQStartCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/10/15
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQStartCVID.setEnabled(cbUtsDot3OnuSelectiveQinQStartCVID.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQStartCVID.setText(utsDot3OnuSelectiveQinQStartCVID);
        tfUtsDot3OnuSelectiveQinQStartCVID.setEnabled(false);
        cvlanPanel.add(cbUtsDot3OnuSelectiveQinQStartCVID);
        tfUtsDot3OnuSelectiveQinQStartCVID.setName(fStringMap.getString("utsDot3OnuSelectiveQinQStartCVID"));
        cvlanPanel.add(tfUtsDot3OnuSelectiveQinQStartCVID);
        cvlanPanel.add(new HSpacer());

        cbUtsDot3OnuSelectiveQinQEndCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/10/15
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQEndCVID.setEnabled(cbUtsDot3OnuSelectiveQinQEndCVID.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQEndCVID.setText(utsDot3OnuSelectiveQinQEndCVID);
        tfUtsDot3OnuSelectiveQinQEndCVID.setEnabled(false);
        cvlanPanel.add(cbUtsDot3OnuSelectiveQinQEndCVID);
        tfUtsDot3OnuSelectiveQinQEndCVID.setName(fStringMap.getString("utsDot3OnuSelectiveQinQEndCVID"));
        cvlanPanel.add(tfUtsDot3OnuSelectiveQinQEndCVID);
        cvlanPanel.add(new HSpacer());
        
        //SVLAN Parameter
        JPanel svlanPanel = new JPanel();
        NTLayout layout3 = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout3.setMargins(6, 10, 6, 10);
        svlanPanel.setLayout(layout3);
        svlanPanel.setBorder(BorderFactory.createTitledBorder("S-VLAN"));

        cbUtsDot3OnuSelectiveQinQSVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQSVID.setEnabled(cbUtsDot3OnuSelectiveQinQSVID.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQSVID.setText(utsDot3OnuSelectiveQinQSVID);
        tfUtsDot3OnuSelectiveQinQSVID.setEnabled(false);
        svlanPanel.add(cbUtsDot3OnuSelectiveQinQSVID);
        //baseInfoPanel.add(new JLabel(utsDot3OnuSelectiveQinQSVID));
        tfUtsDot3OnuSelectiveQinQSVID.setName(fStringMap.getString("utsDot3OnuSelectiveQinQSVID"));
        svlanPanel.add(tfUtsDot3OnuSelectiveQinQSVID);
        svlanPanel.add(new HSpacer());

        /*
        tfUtsDot3OnuSelectiveQinQSCosSourceSelect.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() instanceof JComboBox)
                if (((JComboBox) e.getSource()).getSelectedIndex() == 1) { //usingappointnewvalue
                    cbUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(true);
                } else {
                    cbUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(false);
                }
            }
        });
        */
        JLabel lbCos = new JLabel(utsDot3OnuSelectiveQinQSCosSourceSelect);
        svlanPanel.add(lbCos);
//        svlanPanel.add(new JLabel(utsDot3OnuSelectiveQinQSCosSourceSelect));
        tfUtsDot3OnuSelectiveQinQSCosSourceSelect.setName(fStringMap.getString("utsDot3OnuSelectiveQinQSCosSourceSelect"));
        tfUtsDot3OnuSelectiveQinQSCosSourceSelect.addActionListener(this);
        svlanPanel.add(tfUtsDot3OnuSelectiveQinQSCosSourceSelect);
        svlanPanel.add(new HSpacer());

        cbUtsDot3OnuSelectiveQinQSAppointCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(cbUtsDot3OnuSelectiveQinQSAppointCos.isSelected());
            }
        });
        cbUtsDot3OnuSelectiveQinQSAppointCos.setText(utsDot3OnuSelectiveQinQSAppointCos);
        cbUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(false);
        tfUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(false);
        svlanPanel.add(cbUtsDot3OnuSelectiveQinQSAppointCos);
        tfUtsDot3OnuSelectiveQinQSAppointCos.setName(fStringMap.getString("utsDot3OnuSelectiveQinQSAppointCos"));
        svlanPanel.add(tfUtsDot3OnuSelectiveQinQSAppointCos);
        svlanPanel.add(new HSpacer());
        
        lbModuleId.setPreferredSize(lbCos.getPreferredSize());
        tfUtsDot3OnuSelectiveQinQModuleId.setPreferredSize(tfUtsDot3OnuSelectiveQinQSAppointCos.getPreferredSize());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(cvlanPanel);
        allPanel.add(svlanPanel);
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        actionPerformed(null); //fire the event to validate the filed state.
    }

    protected void initForm() { //modified by Zhou Chao, 2008/10/17
        tfUtsDot3OnuSelectiveQinQCos.setValueScope(0, 7);
        //tfUtsDot3OnuSelectiveQinQCVID.setValueScope(1, 4094);
        tfUtsDot3OnuSelectiveQinQStartCVID.setValueScope(1, 4094);
        tfUtsDot3OnuSelectiveQinQEndCVID.setValueScope(1, 4094);
        tfUtsDot3OnuSelectiveQinQSVID.setValueScope(1, 4094);
        tfUtsDot3OnuSelectiveQinQSAppointCos.setValueScope(0, 7);
    }

    public void refresh() { //modified by Zhou Chao, 2008/8/9
        tfUtsDot3OnuSelectiveQinQModuleId.removeAllItems();

        ModuleType fModuleType = new ModuleType();
        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS1000CardMibBean card = (BBS1000CardMibBean) list.get(i);
            if (fModuleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                tfUtsDot3OnuSelectiveQinQModuleId.addItem(card.getUtsEponModuleBoardPhyId());
            }
        }
    }

    public boolean validateFrom() {
        if(tfUtsDot3OnuSelectiveQinQModuleId.getSelectedItem() == null) {
          String error = fStringMap.getString("Err_Module_Id_Is_Null");
          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }
        if (cbUtsDot3OnuSelectiveQinQStartCVID.isSelected() && cbUtsDot3OnuSelectiveQinQEndCVID.isSelected() && tfUtsDot3OnuSelectiveQinQStartCVID.getValue() > tfUtsDot3OnuSelectiveQinQEndCVID.getValue()) {
            String error = fStringMap.getString("Err_Start_CVID_Great_Than_End_CVID");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        return true;
    }

    public void updateModel() { //modified by Zhou Chao, 2008/8/8
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OltSelectiveQinQMBean(fApplication.getSnmpProxy()));

        OltSelectiveQinQMBean mbean = (OltSelectiveQinQMBean) getModel();
        if (mbean == null)
            return;

        Integer iValue;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String moduleId = tfUtsDot3OnuSelectiveQinQModuleId.getSelectedItem().toString().trim();
            if (moduleId.length() <= 0)
                return;
            iValue = new Integer(moduleId);
            mbean.setUtsDot3OnuSelectiveQinQModuleId(iValue);

            iValue = 1;
            mbean.setUtsDot3OnuSelectiveQinQDeviceId(iValue);

            String portId = tfUtsDot3OnuSelectiveQinQPortId.getSelectedItem().toString().trim();
            if (portId.length() <= 0)
                return;
            iValue = new Integer(portId);
            mbean.setUtsDot3OnuSelectiveQinQPortId(iValue);

            //String logicalPortId = tfUtsDot3OnuSelectiveQinQLogicalPortId.getSelectedItem().toString().trim();
            //if (logicalPortId.length() <= 0)
            //    return;
            //iValue = new Integer(logicalPortId);
            iValue = 0;
            mbean.setUtsDot3OnuSelectiveQinQLogicalPortId(iValue);

            iValue = (!cbUtsDot3OnuSelectiveQinQEtherType.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsDot3OnuSelectiveQinQEtherType.getValue(), 16);
            mbean.setUtsDot3OnuSelectiveQinQEtherType(iValue);

            iValue = (!cbUtsDot3OnuSelectiveQinQCos.isSelected() ? 8 : tfUtsDot3OnuSelectiveQinQCos.getValue());
            mbean.setUtsDot3OnuSelectiveQinQCos(iValue);

            /* remarked by Zhou Chao, 2008/10/15
            iValue = (!cbUtsDot3OnuSelectiveQinQCVID.isSelected() ? 4095 : tfUtsDot3OnuSelectiveQinQCVID.getValue());
            mbean.setUtsDot3OnuSelectiveQinQCVID(iValue);
            */

            //added by Zhou Chao, 2008/10/15 -- begin
            iValue = (!cbUtsDot3OnuSelectiveQinQStartCVID.isSelected() ? 4095 : tfUtsDot3OnuSelectiveQinQStartCVID.getValue());
            mbean.setUtsDot3OnuSelectiveQinQStartCVID(iValue);

            iValue = (!cbUtsDot3OnuSelectiveQinQEndCVID.isSelected() ? 4095 : tfUtsDot3OnuSelectiveQinQEndCVID.getValue());
            mbean.setUtsDot3OnuSelectiveQinQEndCVID(iValue);
            //added by Zhou Chao, 2008/10/15 -- end
        }

        //iValue = (!cbUtsDot3OnuSelectiveQinQSVID.isSelected() ? 4095 : tfUtsDot3OnuSelectiveQinQSVID.getValue());
        iValue = tfUtsDot3OnuSelectiveQinQSVID.getValue();
        mbean.setUtsDot3OnuSelectiveQinQSVID(iValue);

        iValue = utsDot3OnuSelectiveQinQSCosSourceSelectVList[tfUtsDot3OnuSelectiveQinQSCosSourceSelect.getSelectedIndex()];
        mbean.setUtsDot3OnuSelectiveQinQSCosSourceSelect(iValue);

//        iValue = (cbUtsDot3OnuSelectiveQinQSAppointCos.isEnabled() ? (!cbUtsDot3OnuSelectiveQinQSAppointCos.isSelected() ? 8 : tfUtsDot3OnuSelectiveQinQSAppointCos.getValue()) : 8);
//        mbean.setUtsDot3OnuSelectiveQinQSAppointCos(iValue);
        if(cbUtsDot3OnuSelectiveQinQSAppointCos.isEnabled() && cbUtsDot3OnuSelectiveQinQSAppointCos.isSelected()) {
        	mbean.setUtsDot3OnuSelectiveQinQSAppointCos(tfUtsDot3OnuSelectiveQinQSAppointCos.getValue());
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        if (tfUtsDot3OnuSelectiveQinQSCosSourceSelect.getSelectedIndex() == 1) { //usingappointnewvalue
            cbUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(true);
        } else {
            cbUtsDot3OnuSelectiveQinQSAppointCos.setEnabled(false);
        }
    }

}