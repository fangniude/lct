package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcEtherPortRateTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

//refer to com.winnertel.ems.epon.iad.bbs4000.gui.r210.Dot3Onu2CtcEtherPortRateTablePanel
public class Dot3Onu2CtcEtherPortRateTablePanel extends UPanel implements ActionListener {

    private JLabel tfUtsDot3OnuModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuDeviceId = new JLabel();
//    private Integer[] portList = new Integer[] { 1, 2, 3, 4 };
    private JLabel tfUtsDot3OnuPortId = new JLabel();
    
    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

    private int[] utsDot3OnuEtherPortPauseVList = new int[]{1, 2,};
    private String[] utsDot3OnuEtherPortPauseTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsDot3OnuEtherPortPause = new JComboBox(utsDot3OnuEtherPortPauseTList);

    private int[] utsDot3OnuEtherPortPolicingEnableVList = new int[]{1, 2,};
    private String[] utsDot3OnuEtherPortPolicingEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };
    private JComboBox tfUtsDot3OnuEtherPortPolicingEnable = new JComboBox(utsDot3OnuEtherPortPolicingEnableTList);

    private JComboBox tfUtsDot3OnuEtherPortPolicingCIR = null;
    //private IntegerTextField tfUtsDot3OnuEtherPortPolicingCIR = new IntegerTextField(); //modified by Zhou Chao, 2008/7/21

    private JComboBox tfUtsDot3OnuEtherPortPolicingCBS = null;
    //private IntegerTextField tfUtsDot3OnuEtherPortPolicingCBS = new IntegerTextField(); //modified by Zhou Chao, 2008/7/21

    private IntegerTextField tfUtsDot3OnuEtherPortPolicingEBS = new IntegerTextField();

    private int[] vList = new int[]{1, 2,};
    private String[] tList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable"),
    };

    private JComboBox tfUtsDot3OnuEtherPortDSPolicingEnable = new JComboBox(tList);
    private JComboBox tfUtsDot3OnuEtherPortDSPolicingCIR = null;
    private JComboBox tfUtsDot3OnuEtherPortDSPolicingPIR = null;

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
    //private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
    private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
    private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
    private final String utsDot3OnuEtherPortPause = fStringMap.getString("utsDot3OnuEtherPortPause") + " : ";
    private final String utsDot3OnuEtherPortPolicingEnable = fStringMap.getString("utsDot3OnuEtherPortPolicingEnable") + " : ";
    private final String utsDot3OnuEtherPortPolicingCIR = fStringMap.getString("utsDot3OnuEtherPortPolicingCIR") + " : ";
    private final String utsDot3OnuEtherPortPolicingCBS = fStringMap.getString("utsDot3OnuEtherPortPolicingCBS") + " : ";
    private final String utsDot3OnuEtherPortPolicingEBS = fStringMap.getString("utsDot3OnuEtherPortPolicingEBS") + " : ";
    private final String utsDot3OnuEtherPortDSPolicingEnable = fStringMap.getString("utsDot3OnuEtherPortDSPolicingEnable") + " : ";
    private final String utsDot3OnuEtherPortDSPolicingCIR = fStringMap.getString("utsDot3OnuEtherPortDSPolicingCIR") + " : ";
    private final String utsDot3OnuEtherPortDSPolicingPIR = fStringMap.getString("utsDot3OnuEtherPortDSPolicingPIR") + " : ";

    BBS4000NE bbs4000NE;
    public Dot3Onu2CtcEtherPortRateTablePanel(IApplication app) {
        super(app);
        
        bbs4000NE = new BBS4000NE(app);
        init();
    }
    
    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
        baseInfoPanel.add(tfUtsDot3OnuModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OnuDeviceId));
        //baseInfoPanel.add(tfUtsDot3OnuDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
        baseInfoPanel.add(tfUtsDot3OnuPortId);
        baseInfoPanel.add(new HSpacer());

//        tfUtsDot3OnuLogicalPortId.setModel( new DefaultComboBoxModel( getLogicalPortList( ) ));
        baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPause));
        tfUtsDot3OnuEtherPortPause.setName(fStringMap.getString("utsDot3OnuEtherPortPause"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPause);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEnable));
        tfUtsDot3OnuEtherPortPolicingEnable.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEnable"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEnable);
        baseInfoPanel.add(new HSpacer());

        tfUtsDot3OnuEtherPortPolicingEnable.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemevent) {
                toggleEnableDisable();
            }
        });

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCIR));
        //remarked by Zhou Chao, 2008/7/21
        Vector tmpVec = new Vector(127);
        for (int i = 1000; i <= 127000; i += 1000) {
            tmpVec.add(new Integer(i));
        }
        tfUtsDot3OnuEtherPortPolicingCIR = new JComboBox(tmpVec);
        tfUtsDot3OnuEtherPortPolicingCIR.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCIR"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCIR);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingCBS));
        //ONS00038692
        tmpVec = new Vector();
        for (int i = 1536; i <= 65280; i += 256) {
            tmpVec.add(new Integer(i));
        } 
        tfUtsDot3OnuEtherPortPolicingCBS = new JComboBox(tmpVec);
        tfUtsDot3OnuEtherPortPolicingCBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingCBS"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingCBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortPolicingEBS));
        tfUtsDot3OnuEtherPortPolicingEBS.setName(fStringMap.getString("utsDot3OnuEtherPortPolicingEBS"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortPolicingEBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingEnable));
        tfUtsDot3OnuEtherPortDSPolicingEnable.setName(fStringMap.getString("utsDot3OnuEtherPortDSPolicingEnable"));
        tfUtsDot3OnuEtherPortDSPolicingEnable.addActionListener(this);
        baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingEnable);
        baseInfoPanel.add(new HSpacer());

        tmpVec = new Vector();
        for(int i = 0; i<=1000; i += 128){
            tmpVec.add(new Integer(i));
        }
        for(int i = 1000 ; i<=16777215; i+=1000){
            tmpVec.add(i);
        }
        tfUtsDot3OnuEtherPortDSPolicingCIR = new JComboBox(tmpVec);
        tfUtsDot3OnuEtherPortDSPolicingPIR = new JComboBox(tmpVec);
        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingCIR));
        tfUtsDot3OnuEtherPortDSPolicingCIR.setName(fStringMap.getString("utsDot3OnuEtherPortDSPolicingCIR"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingCIR);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortDSPolicingPIR));
        tfUtsDot3OnuEtherPortDSPolicingPIR.setName(fStringMap.getString("utsDot3OnuEtherPortDSPolicingPIR"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortDSPolicingPIR);
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
      //remake ONS00038692
      tfUtsDot3OnuEtherPortPolicingEBS.setValueScope(0, 1522);
//      tfUtsDot3OnuEtherPortDSPolicingCIR.setValueScope(0, 16777215);
//      tfUtsDot3OnuEtherPortDSPolicingPIR.setValueScope(0, 16777215);
    }

    public boolean validateFrom() {
      return true;
    }

    public void toggleEnableDisable() {
        if (tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex() == 1) {
            tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(false);
            tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(false);
            tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(false);
        } else {
            tfUtsDot3OnuEtherPortPolicingCIR.setEnabled(true);
            tfUtsDot3OnuEtherPortPolicingCBS.setEnabled(true);
            tfUtsDot3OnuEtherPortPolicingEBS.setEnabled(true);
        }
    }

    public void refresh() {
        Dot3Onu2CtcEtherPortRateTable mbean = (Dot3Onu2CtcEtherPortRateTable) getModel();

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        //tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
        tfUtsDot3OnuPortId.setText( "" + mbean.getUtsDot3OnuPortId() );
        //tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
        tfUtsDot3OnuLogicalPortId.setText( "" + mbean.getUtsDot3OnuLogicalPortId() );
        tfUtsDot3OnuEtherPortIndex.setText("" + mbean.getUtsDot3OnuEtherPortIndex());
        tfUtsDot3OnuEtherPortPause.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPauseVList, mbean.getUtsDot3OnuEtherPortPause().intValue()));
        tfUtsDot3OnuEtherPortPolicingEnable.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortPolicingEnableVList, mbean.getUtsDot3OnuEtherPortPolicingEnable().intValue()));

        int tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCIR().intValue() / 1000 - 1;
        tfUtsDot3OnuEtherPortPolicingCIR.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);
//        tfUtsDot3OnuEtherPortPolicingCIR.setValue(mbean.getUtsDot3OnuEtherPortPolicingCIR()); //modified by Zhou Chao, 2008/7/21

        tmpIntValue = mbean.getUtsDot3OnuEtherPortPolicingCBS().intValue() / 256 - 6;
        tfUtsDot3OnuEtherPortPolicingCBS.setSelectedIndex(tmpIntValue >= 0 ? tmpIntValue : 0);
//        tfUtsDot3OnuEtherPortPolicingCBS.setValue(mbean.getUtsDot3OnuEtherPortPolicingCBS()); //modified by Zhou Chao, 2008/7/21

        tfUtsDot3OnuEtherPortPolicingEBS.setValue(mbean.getUtsDot3OnuEtherPortPolicingEBS().intValue());

        tfUtsDot3OnuEtherPortDSPolicingEnable.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsDot3OnuEtherPortDSPolicingEnable()));
       tfUtsDot3OnuEtherPortDSPolicingCIR.setSelectedItem(mbean.getUtsDot3OnuEtherPortDSPolicingCIR());
       tfUtsDot3OnuEtherPortDSPolicingPIR.setSelectedItem(mbean.getUtsDot3OnuEtherPortDSPolicingPIR());

        toggleEnableDisable();
    }

    public void updateModel() {
        Dot3Onu2CtcEtherPortRateTable mbean = (Dot3Onu2CtcEtherPortRateTable) getModel();
        
        mbean.setUtsDot3OnuEtherPortPause(new Integer(utsDot3OnuEtherPortPauseVList[tfUtsDot3OnuEtherPortPause.getSelectedIndex()]));
        mbean.setUtsDot3OnuEtherPortPolicingEnable(new Integer(utsDot3OnuEtherPortPolicingEnableVList[tfUtsDot3OnuEtherPortPolicingEnable.getSelectedIndex()]));

        if (tfUtsDot3OnuEtherPortPolicingCIR.isEnabled()) { //modified by Zhou Chao, 2008/7/21
          mbean.setUtsDot3OnuEtherPortPolicingCIR((Integer) tfUtsDot3OnuEtherPortPolicingCIR.getSelectedItem());
//            mbean.setUtsDot3OnuEtherPortPolicingCIR(tfUtsDot3OnuEtherPortPolicingCIR.getValue());
        }
        
        if (tfUtsDot3OnuEtherPortPolicingCBS.isEnabled()) { //modified by Zhou Chao, 2008/7/21
          mbean.setUtsDot3OnuEtherPortPolicingCBS((Integer) tfUtsDot3OnuEtherPortPolicingCBS.getSelectedItem());
//            mbean.setUtsDot3OnuEtherPortPolicingCBS(tfUtsDot3OnuEtherPortPolicingCBS.getValue());
        }
        if(tfUtsDot3OnuEtherPortPolicingEBS.isEnabled())
        mbean.setUtsDot3OnuEtherPortPolicingEBS(new Integer(tfUtsDot3OnuEtherPortPolicingEBS.getValue()));
        
        mbean.setUtsDot3OnuEtherPortDSPolicingEnable(vList[tfUtsDot3OnuEtherPortDSPolicingEnable.getSelectedIndex()]);
        
        if (tfUtsDot3OnuEtherPortDSPolicingCIR.isEnabled()) {
            mbean.setUtsDot3OnuEtherPortDSPolicingCIR(new Integer(tfUtsDot3OnuEtherPortDSPolicingCIR.getSelectedItem().toString()));
        }

        if (tfUtsDot3OnuEtherPortDSPolicingPIR.isEnabled()) {
            mbean.setUtsDot3OnuEtherPortDSPolicingPIR(new Integer(tfUtsDot3OnuEtherPortDSPolicingPIR.getSelectedItem().toString()));
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
        if (tfUtsDot3OnuEtherPortDSPolicingEnable.getSelectedIndex() == 0) {
            tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(true);
            tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(true);
        } else {
            tfUtsDot3OnuEtherPortDSPolicingCIR.setEnabled(false);
            tfUtsDot3OnuEtherPortDSPolicingPIR.setEnabled(false);
        }
    }

}
