/**
 * Created by Zhou Chao, 2008/8/4 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.EthFlexQinQMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
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

public class EthFlexQinQMBeanPanel extends UPanel {

    private JComboBox tfUtsEthFlexQinQModuleId = new JComboBox();
    //private JComboBox tfUtsEthFlexQinQDeviceId = new JComboBox();
    private JComboBox tfUtsEthFlexQinQPortId = new JComboBox();

    private JCheckBox cbUtsEthFlexQinQEtherType = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private HexTextField tfUtsEthFlexQinQEtherType = new HexTextField();

    private JCheckBox cbUtsEthFlexQinQSourceCCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQSourceCCos = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQSourceCVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQSourceCVID = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQSourceCTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private HexTextField tfUtsEthFlexQinQSourceCTPID = new HexTextField();

    private JCheckBox cbUtsEthFlexQinQSourceSCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQSourceSCos = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQSourceSVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQSourceSVID = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQSourceSTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private HexTextField tfUtsEthFlexQinQSourceSTPID = new HexTextField();

    private int[] utsEthFlexQinQSourceTagModeVList = new int[]{1, 2, 3, 4, 5, 6,};
    private String[] utsEthFlexQinQSourceTagModeTList = new String[]{
            fStringMap.getString("sit"),
            fStringMap.getString("sot"),
            fStringMap.getString("dt"),
            fStringMap.getString("sitordt"),
            fStringMap.getString("sotordt"),
            fStringMap.getString("all"),
    };
    private JComboBox tfUtsEthFlexQinQSourceTagMode = new JComboBox(utsEthFlexQinQSourceTagModeTList);

    private JCheckBox cbUtsEthFlexQinQDestinationSTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private HexTextField tfUtsEthFlexQinQDestinationSTPID = new HexTextField();

    private int[] utsEthFlexQinQDestinationSCosActionVList = new int[]{1, 2,};
    private String[] utsEthFlexQinQDestinationSCosActionTList = new String[]{
            fStringMap.getString("copyfromsourcectag"),
            fStringMap.getString("usingappointnewvalue"),
    };
    private JComboBox tfUtsEthFlexQinQDestinationSCosAction = new JComboBox(utsEthFlexQinQDestinationSCosActionTList);

    private JCheckBox cbUtsEthFlexQinQDestinationSVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQDestinationSVID = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQDestinationCTPID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private HexTextField tfUtsEthFlexQinQDestinationCTPID = new HexTextField();

    private int[] utsEthFlexQinQDestinationCCosActionVList = new int[]{1, 2,};
    private String[] utsEthFlexQinQDestinationCCosActionTList = new String[]{
            fStringMap.getString("copyfromsourcectag"),
            fStringMap.getString("usingappointnewvalue"),
    };
    private JComboBox tfUtsEthFlexQinQDestinationCCosAction = new JComboBox(utsEthFlexQinQDestinationCCosActionTList);

    private JCheckBox cbUtsEthFlexQinQDestinationCVID = new JCheckBox(); //addded by Zhou Chao, 2008/8/8
    private IntegerTextField tfUtsEthFlexQinQDestinationCVID = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQDestinationAppointSCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsEthFlexQinQDestinationAppointSCos = new IntegerTextField();

    private JCheckBox cbUtsEthFlexQinQDestinationAppointCCos = new JCheckBox(); //addded by Zhou Chao, 2008/8/9
    private IntegerTextField tfUtsEthFlexQinQDestinationAppointCCos = new IntegerTextField();

    private int[] utsEthFlexQinQDestinationTagModeVList = new int[]{1, 2, 3, 4, 5, 6,};
    private String[] utsEthFlexQinQDestinationTagModeTList = new String[]{
            fStringMap.getString("sit"),
            fStringMap.getString("sot"),
            fStringMap.getString("dt"),
            fStringMap.getString("sitordt"),
            fStringMap.getString("sotordt"),
            fStringMap.getString("all"),
    };
    private JComboBox tfUtsEthFlexQinQDestinationTagMode = new JComboBox(utsEthFlexQinQDestinationTagModeTList);

    private int[] utsEthFlexQinQDestinationSTagPropertyVList = new int[]{1, 2, 3,};
    private String[] utsEthFlexQinQDestinationSTagPropertyTList = new String[]{
            fStringMap.getString("bridging"),
            fStringMap.getString("stagcc"),
            fStringMap.getString("sctagcc"),
    };
    private JComboBox tfUtsEthFlexQinQDestinationSTagProperty = new JComboBox(utsEthFlexQinQDestinationSTagPropertyTList);

    private final String utsEthFlexQinQModuleId = fStringMap.getString("utsEthFlexQinQModuleId") + ": ";
    //private final String utsEthFlexQinQDeviceId = fStringMap.getString("utsEthFlexQinQDeviceId") + ": ";
    private final String utsEthFlexQinQPortId = fStringMap.getString("utsEthFlexQinQPortId") + ": ";
    private final String utsEthFlexQinQEtherType = fStringMap.getString("QinQEtherType") + ": ";
    private final String utsEthFlexQinQSourceCCos = fStringMap.getString("utsEthFlexQinQSourceCCos") + ": ";
    private final String utsEthFlexQinQSourceCVID = fStringMap.getString("utsEthFlexQinQSourceCVID") + ": ";
    private final String utsEthFlexQinQSourceCTPID = fStringMap.getString("utsEthFlexQinQSourceCTPID") + ": ";
    private final String utsEthFlexQinQSourceSCos = fStringMap.getString("utsEthFlexQinQSourceSCos") + ": ";
    private final String utsEthFlexQinQSourceSVID = fStringMap.getString("utsEthFlexQinQSourceSVID") + ": ";
    private final String utsEthFlexQinQSourceSTPID = fStringMap.getString("utsEthFlexQinQSourceSTPID") + ": ";
    private final String utsEthFlexQinQSourceTagMode = fStringMap.getString("utsEthFlexQinQSourceTagMode") + ": ";
    private final String utsEthFlexQinQDestinationSTPID = fStringMap.getString("utsEthFlexQinQDestinationSTPID") + ": ";
    private final String utsEthFlexQinQDestinationSCosAction = fStringMap.getString("utsEthFlexQinQDestinationSCosAction") + ": ";
    private final String utsEthFlexQinQDestinationSVID = fStringMap.getString("utsEthFlexQinQDestinationSVID") + ": ";
    private final String utsEthFlexQinQDestinationCTPID = fStringMap.getString("utsEthFlexQinQDestinationCTPID") + ": ";
    private final String utsEthFlexQinQDestinationCCosAction = fStringMap.getString("utsEthFlexQinQDestinationCCosAction") + ": ";
    private final String utsEthFlexQinQDestinationCVID = fStringMap.getString("utsEthFlexQinQDestinationCVID") + ": ";
    private final String utsEthFlexQinQDestinationAppointSCos = fStringMap.getString("utsEthFlexQinQDestinationAppointSCos") + ": ";
    private final String utsEthFlexQinQDestinationAppointCCos = fStringMap.getString("utsEthFlexQinQDestinationAppointCCos") + ": ";
    private final String utsEthFlexQinQDestinationTagMode = fStringMap.getString("utsEthFlexQinQDestinationTagMode") + ": ";
    private final String utsEthFlexQinQDestinationSTagProperty = fStringMap.getString("utsEthFlexQinQDestinationSTagProperty") + ": ";
    private BaseModuleType fModuleType = new ModuleType();

    public EthFlexQinQMBeanPanel(IApplication app) {
        super(app);
        setModel(new EthFlexQinQMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(20, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        //String slot = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_SLOT_ID);
        //tfUtsEthFlexQinQModuleId.addItem(slot);
        //tfUtsEthFlexQinQModuleId.setEnabled(false);
        baseInfoPanel.add(new JLabel(utsEthFlexQinQModuleId));
        baseInfoPanel.add(tfUtsEthFlexQinQModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsEthFlexQinQDeviceId));
        //baseInfoPanel.add(tfUtsEthFlexQinQDeviceId);
        //baseInfoPanel.add(new HSpacer());

        for (int i = 0; i < 4; i++)
            tfUtsEthFlexQinQPortId.addItem(i + 1);
        baseInfoPanel.add(new JLabel(utsEthFlexQinQPortId));
        baseInfoPanel.add(tfUtsEthFlexQinQPortId);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQEtherType.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQEtherType.setEnabled(cbUtsEthFlexQinQEtherType.isSelected());
            }
        });
        cbUtsEthFlexQinQEtherType.setText(utsEthFlexQinQEtherType);
        tfUtsEthFlexQinQEtherType.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQEtherType);
        tfUtsEthFlexQinQEtherType.setName(fStringMap.getString("utsEthFlexQinQEtherType"));
        baseInfoPanel.add(tfUtsEthFlexQinQEtherType);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceCCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceCCos.setEnabled(cbUtsEthFlexQinQSourceCCos.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceCCos.setText(utsEthFlexQinQSourceCCos);
        tfUtsEthFlexQinQSourceCCos.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceCCos);
        tfUtsEthFlexQinQSourceCCos.setName(fStringMap.getString("utsEthFlexQinQSourceCCos"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceCCos);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceCVID.setEnabled(cbUtsEthFlexQinQSourceCVID.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceCVID.setText(utsEthFlexQinQSourceCVID);
        tfUtsEthFlexQinQSourceCVID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceCVID);
        tfUtsEthFlexQinQSourceCVID.setName(fStringMap.getString("utsEthFlexQinQSourceCVID"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceCVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceCTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceCTPID.setEnabled(cbUtsEthFlexQinQSourceCTPID.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceCTPID.setText(utsEthFlexQinQSourceCTPID);
        tfUtsEthFlexQinQSourceCTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceCTPID);
        tfUtsEthFlexQinQSourceCTPID.setName(fStringMap.getString("utsEthFlexQinQSourceCTPID"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceCTPID);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceSCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceSCos.setEnabled(cbUtsEthFlexQinQSourceSCos.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceSCos.setText(utsEthFlexQinQSourceSCos);
        tfUtsEthFlexQinQSourceSCos.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceSCos);
        tfUtsEthFlexQinQSourceSCos.setName(fStringMap.getString("utsEthFlexQinQSourceSCos"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceSCos);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceSVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceSVID.setEnabled(cbUtsEthFlexQinQSourceSVID.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceSVID.setText(utsEthFlexQinQSourceSVID);
        tfUtsEthFlexQinQSourceSVID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceSVID);
        tfUtsEthFlexQinQSourceSVID.setName(fStringMap.getString("utsEthFlexQinQSourceSVID"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceSVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQSourceSTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQSourceSTPID.setEnabled(cbUtsEthFlexQinQSourceSTPID.isSelected());
            }
        });
        cbUtsEthFlexQinQSourceSTPID.setText(utsEthFlexQinQSourceSTPID);
        tfUtsEthFlexQinQSourceSTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQSourceSTPID);
        tfUtsEthFlexQinQSourceSTPID.setName(fStringMap.getString("utsEthFlexQinQSourceSTPID"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceSTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthFlexQinQSourceTagMode));
        tfUtsEthFlexQinQSourceTagMode.setName(fStringMap.getString("utsEthFlexQinQSourceTagMode"));
        baseInfoPanel.add(tfUtsEthFlexQinQSourceTagMode);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQDestinationSTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQDestinationSTPID.setEnabled(cbUtsEthFlexQinQDestinationSTPID.isSelected());
            }
        });
        cbUtsEthFlexQinQDestinationSTPID.setText(utsEthFlexQinQDestinationSTPID);
        tfUtsEthFlexQinQDestinationSTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationSTPID);
        tfUtsEthFlexQinQDestinationSTPID.setName(fStringMap.getString("utsEthFlexQinQDestinationSTPID"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationSTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthFlexQinQDestinationSCosAction));
        tfUtsEthFlexQinQDestinationSCosAction.setName(fStringMap.getString("utsEthFlexQinQDestinationSCosAction"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationSCosAction);
        baseInfoPanel.add(new HSpacer());
        
        tfUtsEthFlexQinQDestinationSCosAction.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {
        		if(utsEthFlexQinQDestinationSCosActionVList[tfUtsEthFlexQinQDestinationSCosAction.getSelectedIndex()] == 1) {
        			cbUtsEthFlexQinQDestinationAppointSCos.setSelected(false);
        			cbUtsEthFlexQinQDestinationAppointSCos.setEnabled(false);
        			tfUtsEthFlexQinQDestinationAppointSCos.setEnabled(false);
        		}
        		else {
        			cbUtsEthFlexQinQDestinationAppointSCos.setEnabled(true);
        		}
        	}
        });

        cbUtsEthFlexQinQDestinationSVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQDestinationSVID.setEnabled(cbUtsEthFlexQinQDestinationSVID.isSelected());
            }
        });
        cbUtsEthFlexQinQDestinationSVID.setText(utsEthFlexQinQDestinationSVID);
        tfUtsEthFlexQinQDestinationSVID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationSVID);
        tfUtsEthFlexQinQDestinationSVID.setName(fStringMap.getString("utsEthFlexQinQDestinationSVID"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationSVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQDestinationCTPID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQDestinationCTPID.setEnabled(cbUtsEthFlexQinQDestinationCTPID.isSelected());
            }
        });
        cbUtsEthFlexQinQDestinationCTPID.setText(utsEthFlexQinQDestinationCTPID);
        tfUtsEthFlexQinQDestinationCTPID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationCTPID);
        tfUtsEthFlexQinQDestinationCTPID.setName(fStringMap.getString("utsEthFlexQinQDestinationCTPID"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationCTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthFlexQinQDestinationCCosAction));
        tfUtsEthFlexQinQDestinationCCosAction.setName(fStringMap.getString("utsEthFlexQinQDestinationCCosAction"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationCCosAction);
        baseInfoPanel.add(new HSpacer());
        tfUtsEthFlexQinQDestinationCCosAction.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {
        		if(utsEthFlexQinQDestinationCCosActionVList[tfUtsEthFlexQinQDestinationCCosAction.getSelectedIndex()] == 1) {
        			tfUtsEthFlexQinQDestinationAppointCCos.setEnabled(false);
        		}
        	}
        });
        

        cbUtsEthFlexQinQDestinationCVID.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
                tfUtsEthFlexQinQDestinationCVID.setEnabled(cbUtsEthFlexQinQDestinationCVID.isSelected());
            }
        });
        cbUtsEthFlexQinQDestinationCVID.setText(utsEthFlexQinQDestinationCVID);
        tfUtsEthFlexQinQDestinationCVID.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationCVID);
        tfUtsEthFlexQinQDestinationCVID.setName(fStringMap.getString("utsEthFlexQinQDestinationCVID"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationCVID);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQDestinationAppointSCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
            	if(utsEthFlexQinQDestinationSCosActionVList[tfUtsEthFlexQinQDestinationSCosAction.getSelectedIndex()] != 1) {
            		tfUtsEthFlexQinQDestinationAppointSCos.setEnabled(cbUtsEthFlexQinQDestinationAppointSCos.isSelected());
        		}
            }
        });
        cbUtsEthFlexQinQDestinationAppointSCos.setText(utsEthFlexQinQDestinationAppointSCos);
        tfUtsEthFlexQinQDestinationAppointSCos.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationAppointSCos);
        tfUtsEthFlexQinQDestinationAppointSCos.setName(fStringMap.getString("utsEthFlexQinQDestinationAppointSCos"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationAppointSCos);
        baseInfoPanel.add(new HSpacer());

        cbUtsEthFlexQinQDestinationAppointCCos.addChangeListener(new ChangeListener() { //addded by Zhou Chao, 2008/8/9

            public void stateChanged(ChangeEvent e) {
            	if(utsEthFlexQinQDestinationCCosActionVList[tfUtsEthFlexQinQDestinationCCosAction.getSelectedIndex()] != 1) {
            		cbUtsEthFlexQinQDestinationAppointCCos.setSelected(false);
            		cbUtsEthFlexQinQDestinationAppointCCos.setEnabled(false);
            		tfUtsEthFlexQinQDestinationAppointCCos.setEnabled(cbUtsEthFlexQinQDestinationAppointCCos.isSelected());
        		}
            	else {
            		cbUtsEthFlexQinQDestinationAppointCCos.setEnabled(true);
            	}
            }
        });
        cbUtsEthFlexQinQDestinationAppointCCos.setText(utsEthFlexQinQDestinationAppointCCos);
        tfUtsEthFlexQinQDestinationAppointCCos.setEnabled(false);
        baseInfoPanel.add(cbUtsEthFlexQinQDestinationAppointCCos);
        tfUtsEthFlexQinQDestinationAppointCCos.setName(fStringMap.getString("utsEthFlexQinQDestinationAppointCCos"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationAppointCCos);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthFlexQinQDestinationTagMode));
        tfUtsEthFlexQinQDestinationTagMode.setName(fStringMap.getString("utsEthFlexQinQDestinationTagMode"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationTagMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsEthFlexQinQDestinationSTagProperty));
        tfUtsEthFlexQinQDestinationSTagProperty.setName(fStringMap.getString("utsEthFlexQinQDestinationSTagProperty"));
        baseInfoPanel.add(tfUtsEthFlexQinQDestinationSTagProperty);
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
        tfUtsEthFlexQinQSourceCCos.setValueScope(0, 7);
        tfUtsEthFlexQinQSourceCVID.setValueScope(1, 4094);
        tfUtsEthFlexQinQSourceSCos.setValueScope(0, 7);
        tfUtsEthFlexQinQSourceSVID.setValueScope(1, 4094);
        tfUtsEthFlexQinQDestinationSVID.setValueScope(1, 4094);
        tfUtsEthFlexQinQDestinationCVID.setValueScope(1, 4094);
        tfUtsEthFlexQinQDestinationAppointSCos.setValueScope(0, 7);
        tfUtsEthFlexQinQDestinationAppointCCos.setValueScope(0, 7);

    }

    public void refresh() {
        tfUtsEthFlexQinQModuleId.removeAllItems();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, bean);

        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                bean = (BBS4000CardMibBean) v.get(i);

                if (fModuleType.isEPMModule(bean.getUtsEponModuleBoardType())) {
                    tfUtsEthFlexQinQModuleId.addItem(bean.getUtsEponModuleBoardPhyId());
                }
            }
        }

        EthFlexQinQMBean mbean = (EthFlexQinQMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        if (mbean.getUtsEthFlexQinQModuleId() != null)
            tfUtsEthFlexQinQModuleId.setSelectedItem(mbean.getUtsEthFlexQinQModuleId().toString());

        //if (mbean.getUtsEthFlexQinQDeviceId() != null)
        //    tfUtsEthFlexQinQDeviceId.setSelectedItem(mbean.getUtsEthFlexQinQDeviceId().toString());

        if (mbean.getUtsEthFlexQinQPortId() != null)
            tfUtsEthFlexQinQPortId.setSelectedItem(mbean.getUtsEthFlexQinQPortId().toString());

        if (mbean.getUtsEthFlexQinQEtherType() != null) {
            cbUtsEthFlexQinQEtherType.setSelected(!(mbean.getUtsEthFlexQinQEtherType() == 65535));
            tfUtsEthFlexQinQEtherType.setText(mbean.getUtsEthFlexQinQEtherType().toString());
        }

        if (mbean.getUtsEthFlexQinQSourceCCos() != null) {
            cbUtsEthFlexQinQSourceCCos.setSelected(!(mbean.getUtsEthFlexQinQSourceCCos() == 8));
            tfUtsEthFlexQinQSourceCCos.setValue(mbean.getUtsEthFlexQinQSourceCCos());
        }

        if (mbean.getUtsEthFlexQinQSourceCVID() != null) {
            cbUtsEthFlexQinQSourceCVID.setSelected(!(mbean.getUtsEthFlexQinQSourceCVID() == 4095));
            tfUtsEthFlexQinQSourceCVID.setValue(mbean.getUtsEthFlexQinQSourceCVID());
        }

        if (mbean.getUtsEthFlexQinQSourceCTPID() != null) {
            cbUtsEthFlexQinQSourceCTPID.setSelected(!(mbean.getUtsEthFlexQinQSourceCTPID() == 65535));
            tfUtsEthFlexQinQSourceCTPID.setText(mbean.getUtsEthFlexQinQSourceCTPID().toString());
        }

        if (mbean.getUtsEthFlexQinQSourceSCos() != null) {
            cbUtsEthFlexQinQSourceSCos.setSelected(!(mbean.getUtsEthFlexQinQSourceSCos() == 8));
            tfUtsEthFlexQinQSourceSCos.setValue(mbean.getUtsEthFlexQinQSourceSCos());
        }

        if (mbean.getUtsEthFlexQinQSourceSVID() != null) {
            cbUtsEthFlexQinQSourceSVID.setSelected(!(mbean.getUtsEthFlexQinQSourceSVID() == 4095));
            tfUtsEthFlexQinQSourceSVID.setValue(mbean.getUtsEthFlexQinQSourceSVID());
        }

        if (mbean.getUtsEthFlexQinQSourceSTPID() != null) {
            cbUtsEthFlexQinQSourceSTPID.setSelected(!(mbean.getUtsEthFlexQinQSourceSTPID() == 65535));
            tfUtsEthFlexQinQSourceSTPID.setText(mbean.getUtsEthFlexQinQSourceSTPID().toString());
        }

        if (mbean.getUtsEthFlexQinQSourceTagMode() != null)
            tfUtsEthFlexQinQSourceTagMode.setSelectedIndex(getIndexFromValue(utsEthFlexQinQSourceTagModeVList, mbean.getUtsEthFlexQinQSourceTagMode()));

        if (mbean.getUtsEthFlexQinQDestinationSTPID() != null) {
            cbUtsEthFlexQinQDestinationSTPID.setSelected(!(mbean.getUtsEthFlexQinQDestinationSTPID() == 65535));
            tfUtsEthFlexQinQDestinationSTPID.setText(mbean.getUtsEthFlexQinQDestinationSTPID().toString());
        }

        if (mbean.getUtsEthFlexQinQDestinationSCosAction() != null)
            tfUtsEthFlexQinQDestinationSCosAction.setSelectedIndex(getIndexFromValue(utsEthFlexQinQDestinationSCosActionVList, mbean.getUtsEthFlexQinQDestinationSCosAction()));

        if (mbean.getUtsEthFlexQinQDestinationSVID() != null) {
            cbUtsEthFlexQinQDestinationSVID.setSelected(!(mbean.getUtsEthFlexQinQDestinationSVID() == 4095));
            tfUtsEthFlexQinQDestinationSVID.setValue(mbean.getUtsEthFlexQinQDestinationSVID());
        }

        if (mbean.getUtsEthFlexQinQDestinationCTPID() != null) {
            cbUtsEthFlexQinQDestinationCTPID.setSelected(!(mbean.getUtsEthFlexQinQDestinationCTPID() == 65535));
            tfUtsEthFlexQinQDestinationCTPID.setText(mbean.getUtsEthFlexQinQDestinationCTPID().toString());
        }

        if (mbean.getUtsEthFlexQinQDestinationCCosAction() != null)
            tfUtsEthFlexQinQDestinationCCosAction.setSelectedIndex(getIndexFromValue(utsEthFlexQinQDestinationCCosActionVList, mbean.getUtsEthFlexQinQDestinationCCosAction()));

        if (mbean.getUtsEthFlexQinQDestinationCVID() != null) {
            cbUtsEthFlexQinQDestinationCVID.setSelected(!(mbean.getUtsEthFlexQinQDestinationCVID() == 4095));
            tfUtsEthFlexQinQDestinationCVID.setValue(mbean.getUtsEthFlexQinQDestinationCVID());
        }

        if (mbean.getUtsEthFlexQinQDestinationAppointSCos() != null) {
            cbUtsEthFlexQinQDestinationAppointSCos.setSelected(!(mbean.getUtsEthFlexQinQDestinationAppointSCos() == 8));
            tfUtsEthFlexQinQDestinationAppointSCos.setValue(mbean.getUtsEthFlexQinQDestinationAppointSCos());
        }

        if (mbean.getUtsEthFlexQinQDestinationAppointCCos() != null) {
            cbUtsEthFlexQinQDestinationAppointCCos.setSelected(!(mbean.getUtsEthFlexQinQDestinationAppointCCos() == 8));
            tfUtsEthFlexQinQDestinationAppointCCos.setValue(mbean.getUtsEthFlexQinQDestinationAppointCCos());
        }

        if (mbean.getUtsEthFlexQinQDestinationTagMode() != null)
            tfUtsEthFlexQinQDestinationTagMode.setSelectedIndex(getIndexFromValue(utsEthFlexQinQDestinationTagModeVList, mbean.getUtsEthFlexQinQDestinationTagMode()));

        if (mbean.getUtsEthFlexQinQDestinationSTagProperty() != null)
            tfUtsEthFlexQinQDestinationSTagProperty.setSelectedIndex(getIndexFromValue(utsEthFlexQinQDestinationSTagPropertyVList, mbean.getUtsEthFlexQinQDestinationSTagProperty()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new EthFlexQinQMBean(fApplication.getSnmpProxy()));

        EthFlexQinQMBean mbean = (EthFlexQinQMBean) getModel();

        Integer iValue;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            String moduleId = tfUtsEthFlexQinQModuleId.getSelectedItem().toString().trim();
            if (moduleId.length() <= 0)
                return;
            iValue = new Integer(moduleId);
            mbean.setUtsEthFlexQinQModuleId(iValue);

            iValue = 1;
            mbean.setUtsEthFlexQinQDeviceId(iValue);

            String portId = tfUtsEthFlexQinQPortId.getSelectedItem().toString().trim();
            if (portId.length() <= 0)
                return;
//            iValue = new Integer(portId);
            iValue = Integer.parseInt(portId) + 1;
            mbean.setUtsEthFlexQinQPortId(iValue);

            iValue = (!cbUtsEthFlexQinQEtherType.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsEthFlexQinQEtherType.getValue(), 16);
            mbean.setUtsEthFlexQinQEtherType(iValue);

            iValue = (!cbUtsEthFlexQinQSourceCCos.isSelected() ? 8 : tfUtsEthFlexQinQSourceCCos.getValue());
            mbean.setUtsEthFlexQinQSourceCCos(iValue);

            iValue = (!cbUtsEthFlexQinQSourceCVID.isSelected() ? 4095 : tfUtsEthFlexQinQSourceCVID.getValue());
            mbean.setUtsEthFlexQinQSourceCVID(iValue);

            iValue = (!cbUtsEthFlexQinQSourceCTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsEthFlexQinQSourceCTPID.getValue(), 16);
            mbean.setUtsEthFlexQinQSourceCTPID(iValue);

            iValue = (!cbUtsEthFlexQinQSourceSCos.isSelected() ? 8 : tfUtsEthFlexQinQSourceSCos.getValue());
            mbean.setUtsEthFlexQinQSourceSCos(iValue);

            iValue = (!cbUtsEthFlexQinQSourceSVID.isSelected() ? 4095 : tfUtsEthFlexQinQSourceSVID.getValue());
            mbean.setUtsEthFlexQinQSourceSVID(iValue);

            iValue = (!cbUtsEthFlexQinQSourceSTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsEthFlexQinQSourceSTPID.getValue(), 16);
            mbean.setUtsEthFlexQinQSourceSTPID(iValue);

            iValue = utsEthFlexQinQSourceTagModeVList[tfUtsEthFlexQinQSourceTagMode.getSelectedIndex()];
            mbean.setUtsEthFlexQinQSourceTagMode(iValue);
        }

        iValue = (!cbUtsEthFlexQinQDestinationSTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsEthFlexQinQDestinationSTPID.getValue(), 16);
        mbean.setUtsEthFlexQinQDestinationSTPID(iValue);

        iValue = utsEthFlexQinQDestinationSCosActionVList[tfUtsEthFlexQinQDestinationSCosAction.getSelectedIndex()];
        mbean.setUtsEthFlexQinQDestinationSCosAction(iValue);

        iValue = (!cbUtsEthFlexQinQDestinationSVID.isSelected() ? 4095 : tfUtsEthFlexQinQDestinationSVID.getValue());
        mbean.setUtsEthFlexQinQDestinationSVID(iValue);

        iValue = (!cbUtsEthFlexQinQDestinationCTPID.isSelected()) ? 0xFFFF : Integer.parseInt(tfUtsEthFlexQinQDestinationCTPID.getValue(), 16);
        mbean.setUtsEthFlexQinQDestinationCTPID(iValue);

        iValue = utsEthFlexQinQDestinationCCosActionVList[tfUtsEthFlexQinQDestinationCCosAction.getSelectedIndex()];
        mbean.setUtsEthFlexQinQDestinationCCosAction(iValue);

        iValue = (!cbUtsEthFlexQinQDestinationCVID.isSelected() ? 4095 : tfUtsEthFlexQinQDestinationCVID.getValue());
        mbean.setUtsEthFlexQinQDestinationCVID(iValue);

        iValue = (!cbUtsEthFlexQinQDestinationAppointSCos.isSelected() ? 8 : tfUtsEthFlexQinQDestinationAppointSCos.getValue());        	
        mbean.setUtsEthFlexQinQDestinationAppointSCos(iValue);

        iValue = (!cbUtsEthFlexQinQDestinationAppointCCos.isSelected() ? 8 : tfUtsEthFlexQinQDestinationAppointCCos.getValue());
        mbean.setUtsEthFlexQinQDestinationAppointCCos(iValue);

        iValue = utsEthFlexQinQDestinationTagModeVList[tfUtsEthFlexQinQDestinationTagMode.getSelectedIndex()];
        mbean.setUtsEthFlexQinQDestinationTagMode(iValue);

        iValue = utsEthFlexQinQDestinationSTagPropertyVList[tfUtsEthFlexQinQDestinationSTagProperty.getSelectedIndex()];
        mbean.setUtsEthFlexQinQDestinationSTagProperty(iValue);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}