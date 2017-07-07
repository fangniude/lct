/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.OnuFlexQinQMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class OnuFlexQinQMBeanPanel extends UPanel {

    private JComboBox tfUtsDot3OnuFlexQinQModuleId = new JComboBox();
    //private JComboBox tfUtsDot3OnuFlexQinQDeviceId = new JComboBox();
    private JComboBox tfUtsDot3OnuFlexQinQPortId = new JComboBox();
    private JComboBox tfUtsDot3OnuFlexQinQLogicalPortId = new JComboBox();
//    private IntegerTextField tfUtsDot3OnuFlexQinQLogicalPortId = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQEtherType = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private HexTextField tfUtsDot3OnuFlexQinQEtherType = new HexTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQSourceCCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQSourceCCos = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQSourceCVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQSourceCVID = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQSourceCTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private HexTextField tfUtsDot3OnuFlexQinQSourceCTPID = new HexTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationSTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private HexTextField tfUtsDot3OnuFlexQinQDestinationSTPID = new HexTextField();

    private int[] utsDot3OnuFlexQinQDestinationSCosActionVList = new int[]{1, 2,};
    private String[] utsDot3OnuFlexQinQDestinationSCosActionTList = new String[]{
            fStringMap.getString("copyfromsourcectag"),
            fStringMap.getString("usingappointnewvalue"),
    };
    private JComboBox tfUtsDot3OnuFlexQinQDestinationSCosAction = new JComboBox(utsDot3OnuFlexQinQDestinationSCosActionTList);

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationSVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQDestinationSVID = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationCTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private HexTextField tfUtsDot3OnuFlexQinQDestinationCTPID = new HexTextField();

    private int[] utsDot3OnuFlexQinQDestinationCCosActionVList = new int[]{1, 2,};
    private String[] utsDot3OnuFlexQinQDestinationCCosActionTList = new String[]{
            fStringMap.getString("copyfromsourcectag"),
            fStringMap.getString("usingappointnewvalue"),
    };
    private JComboBox tfUtsDot3OnuFlexQinQDestinationCCosAction = new JComboBox(utsDot3OnuFlexQinQDestinationCCosActionTList);

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationCVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQDestinationCVID = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationAppointSCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQDestinationAppointSCos = new IntegerTextField();

    private JCheckBox cbUtsDot3OnuFlexQinQDestinationAppointCCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsDot3OnuFlexQinQDestinationAppointCCos = new IntegerTextField();

    private int[] utsDot3OnuFlexQinQDestinationTagModeVList = new int[]{1, 2, 3, 4, 5,};
    private String[] utsDot3OnuFlexQinQDestinationTagModeTList = new String[]{
            fStringMap.getString("sit"),
            fStringMap.getString("sot"),
            fStringMap.getString("dt"),
            fStringMap.getString("sotordt"),
            fStringMap.getString("all"),
    };
    private JComboBox tfUtsDot3OnuFlexQinQDestinationTagMode = new JComboBox(utsDot3OnuFlexQinQDestinationTagModeTList);

    private int[] utsDot3OnuFlexQinQDestinationSTagPropertyVList = new int[]{1, 2, 3,};
    private String[] utsDot3OnuFlexQinQDestinationSTagPropertyTList = new String[]{
            fStringMap.getString("bridging"),
            fStringMap.getString("stagcc"),
            fStringMap.getString("sctagcc"),
    };
    private JComboBox tfUtsDot3OnuFlexQinQDestinationSTagProperty = new JComboBox(utsDot3OnuFlexQinQDestinationSTagPropertyTList);

    private final String utsDot3OnuFlexQinQModuleId = fStringMap.getString("utsDot3OnuFlexQinQModuleId") + ": ";
    //private final String utsDot3OnuFlexQinQDeviceId = fStringMap.getString("utsDot3OnuFlexQinQDeviceId") + ": ";
    private final String utsDot3OnuFlexQinQPortId = fStringMap.getString("utsDot3OnuFlexQinQPortId") + ": ";
    private final String utsDot3OnuFlexQinQLogicalPortId = fStringMap.getString("utsDot3OnuFlexQinQLogicalPortId") + ": ";
    private final String utsDot3OnuFlexQinQEtherType = fStringMap.getString("QinQEtherType") + ": ";
    private final String utsDot3OnuFlexQinQSourceCCos = fStringMap.getString("utsDot3OnuFlexQinQSourceCCos") + ": ";
    private final String utsDot3OnuFlexQinQSourceCVID = fStringMap.getString("utsDot3OnuFlexQinQSourceCVID") + ": ";
    private final String utsDot3OnuFlexQinQSourceCTPID = fStringMap.getString("utsDot3OnuFlexQinQSourceCTPID") + ": ";
    private final String utsDot3OnuFlexQinQDestinationSTPID = fStringMap.getString("utsDot3OnuFlexQinQDestinationSTPID") + ": ";
    private final String utsDot3OnuFlexQinQDestinationSCosAction = fStringMap.getString("utsDot3OnuFlexQinQDestinationSCosAction") + ": ";
    private final String utsDot3OnuFlexQinQDestinationSVID = fStringMap.getString("utsDot3OnuFlexQinQDestinationSVID") + ": ";
    private final String utsDot3OnuFlexQinQDestinationCTPID = fStringMap.getString("utsDot3OnuFlexQinQDestinationCTPID") + ": ";
    private final String utsDot3OnuFlexQinQDestinationCCosAction = fStringMap.getString("utsDot3OnuFlexQinQDestinationCCosAction") + ": ";
    private final String utsDot3OnuFlexQinQDestinationCVID = fStringMap.getString("utsDot3OnuFlexQinQDestinationCVID") + ": ";
    private final String utsDot3OnuFlexQinQDestinationAppointSCos = fStringMap.getString("utsDot3OnuFlexQinQDestinationAppointSCos") + ": ";
    private final String utsDot3OnuFlexQinQDestinationAppointCCos = fStringMap.getString("utsDot3OnuFlexQinQDestinationAppointCCos") + ": ";
    private final String utsDot3OnuFlexQinQDestinationTagMode = fStringMap.getString("utsDot3OnuFlexQinQDestinationTagMode") + ": ";
    private final String utsDot3OnuFlexQinQDestinationSTagProperty = fStringMap.getString("utsDot3OnuFlexQinQDestinationSTagProperty") + ": ";

    public OnuFlexQinQMBeanPanel(IApplication app) {
        super(app);
        setModel(new OnuFlexQinQMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(18, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQModuleId));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQModuleId);
        baseInfoPanel.add(new HSpacer());

        for(int i = 1; i <= 4; i++) {
          tfUtsDot3OnuFlexQinQPortId.addItem("" + i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQPortId));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQPortId);
        baseInfoPanel.add(new HSpacer());

        int split = new BBS4000NE(fApplication).getPonSplitRatio();
        for(int i = 1; i <= split; i++) {
          tfUtsDot3OnuFlexQinQLogicalPortId.addItem("" + i);
        }
        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQEtherType.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQEtherType.setEnabled(cbUtsDot3OnuFlexQinQEtherType.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQEtherType.setText(utsDot3OnuFlexQinQEtherType);
        tfUtsDot3OnuFlexQinQEtherType.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQEtherType);
        tfUtsDot3OnuFlexQinQEtherType.setName(fStringMap.getString("utsDot3OnuFlexQinQEtherType"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQEtherType);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQSourceCCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQSourceCCos.setEnabled(cbUtsDot3OnuFlexQinQSourceCCos.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQSourceCCos.setText(utsDot3OnuFlexQinQSourceCCos);
        tfUtsDot3OnuFlexQinQSourceCCos.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQSourceCCos);
        tfUtsDot3OnuFlexQinQSourceCCos.setName(fStringMap.getString("utsDot3OnuFlexQinQSourceCCos"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQSourceCCos);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQSourceCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQSourceCVID.setEnabled(cbUtsDot3OnuFlexQinQSourceCVID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQSourceCVID.setText(utsDot3OnuFlexQinQSourceCVID);
        tfUtsDot3OnuFlexQinQSourceCVID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQSourceCVID);
        tfUtsDot3OnuFlexQinQSourceCVID.setName(fStringMap.getString("utsDot3OnuFlexQinQSourceCVID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQSourceCVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQSourceCTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQSourceCTPID.setEnabled(cbUtsDot3OnuFlexQinQSourceCTPID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQSourceCTPID.setText(utsDot3OnuFlexQinQSourceCTPID);
        tfUtsDot3OnuFlexQinQSourceCTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQSourceCTPID);
        tfUtsDot3OnuFlexQinQSourceCTPID.setName(fStringMap.getString("utsDot3OnuFlexQinQSourceCTPID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQSourceCTPID);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQDestinationSTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQDestinationSTPID.setEnabled(cbUtsDot3OnuFlexQinQDestinationSTPID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQDestinationSTPID.setText(utsDot3OnuFlexQinQDestinationSTPID);
        tfUtsDot3OnuFlexQinQDestinationSTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationSTPID);
        tfUtsDot3OnuFlexQinQDestinationSTPID.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationSTPID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationSTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQDestinationSCosAction));
        tfUtsDot3OnuFlexQinQDestinationSCosAction.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationSCosAction"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationSCosAction);
        baseInfoPanel.add(new HSpacer());
        
        //TODO..
        tfUtsDot3OnuFlexQinQDestinationSCosAction.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {
        		if(utsDot3OnuFlexQinQDestinationSCosActionVList[tfUtsDot3OnuFlexQinQDestinationSCosAction.getSelectedIndex()] == 1) {
        			cbUtsDot3OnuFlexQinQDestinationAppointSCos.setSelected(false);
        			cbUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
        			tfUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
        		}
        		else {
        			cbUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(true);
        		}
        	}
        });

        cbUtsDot3OnuFlexQinQDestinationSVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQDestinationSVID.setEnabled(cbUtsDot3OnuFlexQinQDestinationSVID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQDestinationSVID.setText(utsDot3OnuFlexQinQDestinationSVID);
        tfUtsDot3OnuFlexQinQDestinationSVID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationSVID);
        tfUtsDot3OnuFlexQinQDestinationSVID.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationSVID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationSVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQDestinationCTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQDestinationCTPID.setEnabled(cbUtsDot3OnuFlexQinQDestinationCTPID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQDestinationCTPID.setText(utsDot3OnuFlexQinQDestinationCTPID);
        tfUtsDot3OnuFlexQinQDestinationCTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationCTPID);
        tfUtsDot3OnuFlexQinQDestinationCTPID.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationCTPID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationCTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQDestinationCCosAction));
        tfUtsDot3OnuFlexQinQDestinationCCosAction.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationCCosAction"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationCCosAction);
        baseInfoPanel.add(new HSpacer());
        
        tfUtsDot3OnuFlexQinQDestinationCCosAction.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {
        		if(utsDot3OnuFlexQinQDestinationCCosActionVList[tfUtsDot3OnuFlexQinQDestinationCCosAction.getSelectedIndex()] == 1) {
        			cbUtsDot3OnuFlexQinQDestinationAppointCCos.setSelected(false);
        			cbUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
        			tfUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
        		}
        		else {
        			cbUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(true);
        		}
        	}
        });

        cbUtsDot3OnuFlexQinQDestinationCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
                tfUtsDot3OnuFlexQinQDestinationCVID.setEnabled(cbUtsDot3OnuFlexQinQDestinationCVID.isSelected());
            }
        });
        cbUtsDot3OnuFlexQinQDestinationCVID.setText(utsDot3OnuFlexQinQDestinationCVID);
        tfUtsDot3OnuFlexQinQDestinationCVID.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationCVID);
        tfUtsDot3OnuFlexQinQDestinationCVID.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationCVID"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationCVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQDestinationAppointSCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
            	if(utsDot3OnuFlexQinQDestinationSCosActionVList[tfUtsDot3OnuFlexQinQDestinationSCosAction.getSelectedIndex()] != 1) {
            		tfUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(cbUtsDot3OnuFlexQinQDestinationAppointSCos.isSelected());
            	}
            }
        });
        cbUtsDot3OnuFlexQinQDestinationAppointSCos.setText(utsDot3OnuFlexQinQDestinationAppointSCos);
        tfUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationAppointSCos);
        tfUtsDot3OnuFlexQinQDestinationAppointSCos.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationAppointSCos"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationAppointSCos);
        baseInfoPanel.add(new HSpacer());

        cbUtsDot3OnuFlexQinQDestinationAppointCCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9
            public void stateChanged(ChangeEvent e) {
            	if(utsDot3OnuFlexQinQDestinationCCosActionVList[tfUtsDot3OnuFlexQinQDestinationCCosAction.getSelectedIndex()] != 1) {
            		tfUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(cbUtsDot3OnuFlexQinQDestinationAppointCCos.isSelected());
            	}
            }
        });
        cbUtsDot3OnuFlexQinQDestinationAppointCCos.setText(utsDot3OnuFlexQinQDestinationAppointCCos);
        tfUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
        baseInfoPanel.add(cbUtsDot3OnuFlexQinQDestinationAppointCCos);
        tfUtsDot3OnuFlexQinQDestinationAppointCCos.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationAppointCCos"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationAppointCCos);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQDestinationTagMode));
        tfUtsDot3OnuFlexQinQDestinationTagMode.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationTagMode"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationTagMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuFlexQinQDestinationSTagProperty));
        tfUtsDot3OnuFlexQinQDestinationSTagProperty.setName(fStringMap.getString("utsDot3OnuFlexQinQDestinationSTagProperty"));
        baseInfoPanel.add(tfUtsDot3OnuFlexQinQDestinationSTagProperty);
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
        tfUtsDot3OnuFlexQinQSourceCCos.setValueScope(0, 7);
        tfUtsDot3OnuFlexQinQSourceCVID.setValueScope(1, 4094);
        tfUtsDot3OnuFlexQinQDestinationSVID.setValueScope(1, 4094);
        tfUtsDot3OnuFlexQinQDestinationCVID.setValueScope(1, 4094);
        tfUtsDot3OnuFlexQinQDestinationAppointSCos.setValueScope(0, 7);
        tfUtsDot3OnuFlexQinQDestinationAppointCCos.setValueScope(0, 7);
    }

    public boolean validateFrom()
    {
      if (tfUtsDot3OnuFlexQinQModuleId.getSelectedItem() == null) {
        String error = fStringMap.getString("Err_Module_Id_Is_Null");
        MessageDialog.showErrorMessageDialog(fApplication, error);
        return false;
      }
      return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
          tfUtsDot3OnuFlexQinQModuleId.removeAllItems();

          BaseModuleType fModuleType = new ModuleType();
          BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
          Vector cardList = BeanService.refreshTableBean(fApplication, bean);

          for(int i = 0; i < cardList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean)cardList.get(i);

            if(fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
              tfUtsDot3OnuFlexQinQModuleId.addItem("" + card.getUtsEponModuleBoardPhyId());
            }
          }
          
			if (utsDot3OnuFlexQinQDestinationSCosActionVList[tfUtsDot3OnuFlexQinQDestinationSCosAction
					.getSelectedIndex()] == 1) {
				cbUtsDot3OnuFlexQinQDestinationAppointSCos.setSelected(false);
				cbUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
				tfUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
			} else {
				cbUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(true);
			}

			if (utsDot3OnuFlexQinQDestinationCCosActionVList[tfUtsDot3OnuFlexQinQDestinationCCosAction
					.getSelectedIndex()] == 1) {
				cbUtsDot3OnuFlexQinQDestinationAppointCCos.setSelected(false);
				cbUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
				tfUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
			} else {
				cbUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(true);
			}

          return;
        }

        OnuFlexQinQMBean mbean = (OnuFlexQinQMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        if (mbean.getUtsDot3OnuFlexQinQModuleId() != null)
            tfUtsDot3OnuFlexQinQModuleId.setSelectedItem(mbean.getUtsDot3OnuFlexQinQModuleId().toString());

        //if (mbean.getUtsDot3OnuFlexQinQDeviceId() != null)
        //  tfUtsDot3OnuFlexQinQDeviceId.setSelectedItem(mbean.getUtsDot3OnuFlexQinQDeviceId().toString());

        if (mbean.getUtsDot3OnuFlexQinQPortId() != null)
            tfUtsDot3OnuFlexQinQPortId.setSelectedItem(mbean.getUtsDot3OnuFlexQinQPortId().toString());

        if (mbean.getUtsDot3OnuFlexQinQLogicalPortId() != null)
            tfUtsDot3OnuFlexQinQLogicalPortId.setSelectedItem(mbean.getUtsDot3OnuFlexQinQLogicalPortId().toString());
//            tfUtsDot3OnuFlexQinQLogicalPortId.setText(mbean.getUtsDot3OnuFlexQinQLogicalPortId().toString());

        if (mbean.getUtsDot3OnuFlexQinQEtherType() != null) {
            cbUtsDot3OnuFlexQinQEtherType.setSelected(!(mbean.getUtsDot3OnuFlexQinQEtherType().intValue() == 65535));
            tfUtsDot3OnuFlexQinQEtherType.setText(Integer.toHexString(mbean.getUtsDot3OnuFlexQinQEtherType().intValue()));
        }

        if (mbean.getUtsDot3OnuFlexQinQSourceCCos() != null) {
            cbUtsDot3OnuFlexQinQSourceCCos.setSelected(!(mbean.getUtsDot3OnuFlexQinQSourceCCos().intValue() == 8));
            tfUtsDot3OnuFlexQinQSourceCCos.setValue(mbean.getUtsDot3OnuFlexQinQSourceCCos().intValue());
        }

        if (mbean.getUtsDot3OnuFlexQinQSourceCVID() != null) {
            cbUtsDot3OnuFlexQinQSourceCVID.setSelected(!(mbean.getUtsDot3OnuFlexQinQSourceCVID().intValue() == 4095));
            tfUtsDot3OnuFlexQinQSourceCVID.setValue(mbean.getUtsDot3OnuFlexQinQSourceCVID().intValue());
        }

        if (mbean.getUtsDot3OnuFlexQinQSourceCTPID() != null) {
            cbUtsDot3OnuFlexQinQSourceCTPID.setSelected(!(mbean.getUtsDot3OnuFlexQinQSourceCTPID().intValue() == 65535));
            tfUtsDot3OnuFlexQinQSourceCTPID.setText(Integer.toHexString(mbean.getUtsDot3OnuFlexQinQSourceCTPID().intValue()));
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationSTPID() != null) {
            cbUtsDot3OnuFlexQinQDestinationSTPID.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationSTPID().intValue() == 65535));
            tfUtsDot3OnuFlexQinQDestinationSTPID.setText(Integer.toHexString(mbean.getUtsDot3OnuFlexQinQDestinationSTPID().intValue()));
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationSCosAction() != null)
            tfUtsDot3OnuFlexQinQDestinationSCosAction.setSelectedIndex(getIndexFromValue(utsDot3OnuFlexQinQDestinationSCosActionVList, mbean.getUtsDot3OnuFlexQinQDestinationSCosAction().intValue()));

        if (mbean.getUtsDot3OnuFlexQinQDestinationSVID() != null) {
            cbUtsDot3OnuFlexQinQDestinationSVID.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationSVID().intValue() == 4095));
            tfUtsDot3OnuFlexQinQDestinationSVID.setValue(mbean.getUtsDot3OnuFlexQinQDestinationSVID().intValue());
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationCTPID() != null) {
            cbUtsDot3OnuFlexQinQDestinationCTPID.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationCTPID().intValue() == 65535));
            tfUtsDot3OnuFlexQinQDestinationCTPID.setText(Integer.toHexString(mbean.getUtsDot3OnuFlexQinQDestinationCTPID().intValue()));
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationCCosAction() != null)
            tfUtsDot3OnuFlexQinQDestinationCCosAction.setSelectedIndex(getIndexFromValue(utsDot3OnuFlexQinQDestinationCCosActionVList, mbean.getUtsDot3OnuFlexQinQDestinationCCosAction().intValue()));

        if (mbean.getUtsDot3OnuFlexQinQDestinationCVID() != null) {
            cbUtsDot3OnuFlexQinQDestinationCVID.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationCVID().intValue() == 4095));
            tfUtsDot3OnuFlexQinQDestinationCVID.setValue(mbean.getUtsDot3OnuFlexQinQDestinationCVID().intValue());
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationAppointSCos() != null) {
            if(utsDot3OnuFlexQinQDestinationSCosActionVList[tfUtsDot3OnuFlexQinQDestinationSCosAction.getSelectedIndex()] != 1) {
            	cbUtsDot3OnuFlexQinQDestinationAppointSCos.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationAppointSCos().intValue() == 8));
                tfUtsDot3OnuFlexQinQDestinationAppointSCos.setValue(mbean.getUtsDot3OnuFlexQinQDestinationAppointSCos().intValue());
    		}
    		else {
    			cbUtsDot3OnuFlexQinQDestinationAppointSCos.setSelected(false);
    			cbUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
    			tfUtsDot3OnuFlexQinQDestinationAppointSCos.setEnabled(false);
    		}
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationAppointCCos() != null) {
            if(utsDot3OnuFlexQinQDestinationCCosActionVList[tfUtsDot3OnuFlexQinQDestinationCCosAction.getSelectedIndex()] != 1) {
            	cbUtsDot3OnuFlexQinQDestinationAppointCCos.setSelected(!(mbean.getUtsDot3OnuFlexQinQDestinationAppointCCos().intValue() == 8));
                tfUtsDot3OnuFlexQinQDestinationAppointCCos.setValue(mbean.getUtsDot3OnuFlexQinQDestinationAppointCCos().intValue());
        	}
            else {
            	cbUtsDot3OnuFlexQinQDestinationAppointCCos.setSelected(false);
            	cbUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
            	tfUtsDot3OnuFlexQinQDestinationAppointCCos.setEnabled(false);
            }
        }

        if (mbean.getUtsDot3OnuFlexQinQDestinationTagMode() != null)
            tfUtsDot3OnuFlexQinQDestinationTagMode.setSelectedIndex(getIndexFromValue(utsDot3OnuFlexQinQDestinationTagModeVList, mbean.getUtsDot3OnuFlexQinQDestinationTagMode().intValue()));

        if (mbean.getUtsDot3OnuFlexQinQDestinationSTagProperty() != null)
            tfUtsDot3OnuFlexQinQDestinationSTagProperty.setSelectedIndex(getIndexFromValue(utsDot3OnuFlexQinQDestinationSTagPropertyVList, mbean.getUtsDot3OnuFlexQinQDestinationSTagProperty().intValue()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuFlexQinQMBean(fApplication.getSnmpProxy()));

        OnuFlexQinQMBean mbean = (OnuFlexQinQMBean) getModel();

        Integer iValue;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String moduleId = tfUtsDot3OnuFlexQinQModuleId.getSelectedItem().toString().trim();
            if (moduleId.length() <= 0)
                return;
            iValue = new Integer(moduleId);
            mbean.setUtsDot3OnuFlexQinQModuleId(iValue);

            iValue = new Integer(1);
            mbean.setUtsDot3OnuFlexQinQDeviceId(iValue);

            String portId = tfUtsDot3OnuFlexQinQPortId.getSelectedItem().toString().trim();
            if (portId.length() <= 0)
                return;
            iValue = new Integer(portId);
            mbean.setUtsDot3OnuFlexQinQPortId(iValue);

            //String logicalPortId = tfUtsDot3OnuFlexQinQLogicalPortId.getSelectedItem().toString().trim();
            //if (logicalPortId.length() <= 0)
            //    return;
            //iValue = new Integer(logicalPortId);
//            iValue = tfUtsDot3OnuFlexQinQLogicalPortId.getValue();
//            mbean.setUtsDot3OnuFlexQinQLogicalPortId(iValue);
            mbean.setUtsDot3OnuFlexQinQLogicalPortId(Integer.parseInt((String)tfUtsDot3OnuFlexQinQLogicalPortId.getSelectedItem()));

            iValue = (!cbUtsDot3OnuFlexQinQEtherType.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsDot3OnuFlexQinQEtherType.getValue(), 16);
            mbean.setUtsDot3OnuFlexQinQEtherType(iValue);

            iValue = (!cbUtsDot3OnuFlexQinQSourceCCos.isSelected() ? 8 : tfUtsDot3OnuFlexQinQSourceCCos.getValue());
            mbean.setUtsDot3OnuFlexQinQSourceCCos(iValue);

            iValue = (!cbUtsDot3OnuFlexQinQSourceCVID.isSelected() ? 4095 : tfUtsDot3OnuFlexQinQSourceCVID.getValue());
            mbean.setUtsDot3OnuFlexQinQSourceCVID(iValue);

            iValue = (!cbUtsDot3OnuFlexQinQSourceCTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsDot3OnuFlexQinQSourceCTPID.getValue(), 16);
            mbean.setUtsDot3OnuFlexQinQSourceCTPID(iValue);
        }

        iValue = (!cbUtsDot3OnuFlexQinQDestinationSTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsDot3OnuFlexQinQDestinationSTPID.getValue(), 16);
        mbean.setUtsDot3OnuFlexQinQDestinationSTPID(iValue);

        iValue = new Integer(utsDot3OnuFlexQinQDestinationSCosActionVList[tfUtsDot3OnuFlexQinQDestinationSCosAction.getSelectedIndex()]);
        mbean.setUtsDot3OnuFlexQinQDestinationSCosAction(iValue);

        iValue = (!cbUtsDot3OnuFlexQinQDestinationSVID.isSelected() ? 4095 : tfUtsDot3OnuFlexQinQDestinationSVID.getValue());
        mbean.setUtsDot3OnuFlexQinQDestinationSVID(iValue);

        iValue = (!cbUtsDot3OnuFlexQinQDestinationCTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsDot3OnuFlexQinQDestinationCTPID.getValue(), 16);
        mbean.setUtsDot3OnuFlexQinQDestinationCTPID(iValue);

        iValue = new Integer(utsDot3OnuFlexQinQDestinationCCosActionVList[tfUtsDot3OnuFlexQinQDestinationCCosAction.getSelectedIndex()]);
        mbean.setUtsDot3OnuFlexQinQDestinationCCosAction(iValue);

        iValue = (!cbUtsDot3OnuFlexQinQDestinationCVID.isSelected() ? 4095 : tfUtsDot3OnuFlexQinQDestinationCVID.getValue());
        mbean.setUtsDot3OnuFlexQinQDestinationCVID(iValue);

        iValue = (!cbUtsDot3OnuFlexQinQDestinationAppointSCos.isSelected() ? 8 : tfUtsDot3OnuFlexQinQDestinationAppointSCos.getValue());
        mbean.setUtsDot3OnuFlexQinQDestinationAppointSCos(iValue);

        iValue = (!cbUtsDot3OnuFlexQinQDestinationAppointCCos.isSelected() ? 8 : tfUtsDot3OnuFlexQinQDestinationAppointCCos.getValue());
        mbean.setUtsDot3OnuFlexQinQDestinationAppointCCos(iValue);

        iValue = new Integer(utsDot3OnuFlexQinQDestinationTagModeVList[tfUtsDot3OnuFlexQinQDestinationTagMode.getSelectedIndex()]);
        mbean.setUtsDot3OnuFlexQinQDestinationTagMode(iValue);

        iValue = new Integer(utsDot3OnuFlexQinQDestinationSTagPropertyVList[tfUtsDot3OnuFlexQinQDestinationSTagProperty.getSelectedIndex()]);
        mbean.setUtsDot3OnuFlexQinQDestinationSTagProperty(iValue);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}