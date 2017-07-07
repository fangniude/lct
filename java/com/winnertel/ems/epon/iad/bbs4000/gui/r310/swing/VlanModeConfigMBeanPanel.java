package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.Dot3OnuEtherPortVlanN1Panel;
import com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing.Dot3OnuEtherPortVlanTrunkPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.VlanModeConfigMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VlanModeConfigMBeanPanel extends UPanel implements ActionListener {
    private JLabel tfUtsDot3OnuModuleId = new JLabel();
    private JLabel tfUtsDot3OnuPortId = new JLabel();
    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();

    private int[] utsDot3OnuEtherPortVlanModeVList = new int[]{1, 2, 3, /**4,*/ 5, 6};
    private String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
            fStringMap.getString("transparent"), fStringMap.getString("tag"),
            fStringMap.getString("translation"), //fStringMap.getString("vlanStacking"),
            fStringMap.getString("n1aggregation"), fStringMap.getString("trunk")};
    private JComboBox tfUtsDot3OnuEtherPortVlanMode = new JComboBox(utsDot3OnuEtherPortVlanModeTList);

    private IntegerTextField tfUtsDot3OnuEtherPortVlanTag = new IntegerTextField();

    private StringTextField tfUtsDot3OnuEtherPortVlanTPID = new StringTextField();

    private Dot3OnuEtherPortVlanPanel vlanPanel = null;

    private JComboBox tfUtsDot3OnuEtherPortVlanNaggregationNumber = new JComboBox();
    private Dot3OnuEtherPortVlanN1Panel[] n1PanelList = new Dot3OnuEtherPortVlanN1Panel[6];
    private Dot3OnuEtherPortVlanTrunkPanel trunkPanel = null;
    JTabbedPane tabbedPane = null;

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
    private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
    private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";

    private final String utsDot3OnuEtherPortVlanMode = fStringMap.getString("utsDot3OnuEtherPortVlanMode") + " : ";
    private final String utsDot3OnuEtherPortVlanTag = fStringMap.getString("utsDot3OnuEtherPortVlanTag") + " : ";

    private final String utsDot3OnuEtherPortVlanTPID = fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + " : ";
    private final String utsDot3OnuEtherPortVlanNaggregationNumber = fStringMap.getString("utsDot3OnuEtherPortVlanNaggregationNumber") + " : ";

    public VlanModeConfigMBeanPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(9, 3, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuModuleId));
        baseInfoPanel.add(tfUtsDot3OnuModuleId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuPortId));
        baseInfoPanel.add(tfUtsDot3OnuPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuLogicalPortId));
        baseInfoPanel.add(tfUtsDot3OnuLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortIndex));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanMode));
        tfUtsDot3OnuEtherPortVlanMode.setName(fStringMap.getString("utsDot3OnuEtherPortVlanMode"));
        tfUtsDot3OnuEtherPortVlanMode.addActionListener(this);
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTag));
        tfUtsDot3OnuEtherPortVlanTag.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTag"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTag);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTPID));
        tfUtsDot3OnuEtherPortVlanTPID.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTPID"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTPID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanNaggregationNumber));
        for(int i = 1; i < 6; i++) {
            tfUtsDot3OnuEtherPortVlanNaggregationNumber.addItem(Integer.valueOf(i));
        }

        tfUtsDot3OnuEtherPortVlanNaggregationNumber.setName(fStringMap.getString(utsDot3OnuEtherPortVlanNaggregationNumber));
        tfUtsDot3OnuEtherPortVlanNaggregationNumber.addActionListener(this);
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanNaggregationNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new VSpacer());
        //VLAN Setting
        vlanPanel = new Dot3OnuEtherPortVlanPanel(fApplication);

        tabbedPane = new JTabbedPane();
        tabbedPane.add(fStringMap.getString("Basic_Info"), baseInfoPanel);
        tabbedPane.add(fStringMap.getString("VLAN_Translation_Panel"), vlanPanel);

        trunkPanel = new Dot3OnuEtherPortVlanTrunkPanel(fApplication);
        tabbedPane.add(fStringMap.getString("VLAN_Trunk"), trunkPanel);

        for(int i = 0; i < 3; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            n1PanelList[i * 2] = new Dot3OnuEtherPortVlanN1Panel(fApplication);
            n1PanelList[i * 2].setBorder(BorderFactory.createTitledBorder(fStringMap.getString("vlan-aggregation") + (i * 2 + 1)));
            panel.add(n1PanelList[i * 2], BorderLayout.NORTH);

            n1PanelList[i * 2 + 1] = new Dot3OnuEtherPortVlanN1Panel(fApplication);
            n1PanelList[i * 2 + 1].setBorder(BorderFactory.createTitledBorder(fStringMap.getString("vlan-aggregation") + (i * 2 + 2)));
            panel.add(n1PanelList[i * 2 + 1], BorderLayout.CENTER);
            tabbedPane.add(fStringMap.getString("vlan-aggregation") + (i * 2 + 1) + ("-") + (i * 2 + 2), panel);
        }
        
        n1PanelList[n1PanelList.length - 1].setVisible(false);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfUtsDot3OnuEtherPortVlanTag.setValueScope(1, 4094);
    }

    public boolean validateFrom() {
        try {
            Integer theValue = Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(), 16);
            if(theValue.intValue() < 0 || theValue.intValue() > 65535) {
                MessageDialog.showInfoMessageDialog(fApplication, utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
                return false;
            }
        }
        catch(Exception e) {
            MessageDialog.showInfoMessageDialog(fApplication, utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
            return false;
        }

        if(tabbedPane.isEnabledAt(1) && (isNull(vlanPanel.getVlanTranslation()))) {
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Vlan_Translation_0"));
            return false;
        }
        
        if(tabbedPane.isEnabledAt(2) && (isNull(trunkPanel.getValue()))) {
        	MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Err_Vlan_Trunk_0"));
        	return false;
        }

        return true;
    }

    public void refresh() {
        VlanModeConfigMBean mbean = (VlanModeConfigMBean) getModel();

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        tfUtsDot3OnuPortId.setText("" + mbean.getUtsDot3OnuPortId());
        tfUtsDot3OnuLogicalPortId.setText("" + mbean.getUtsDot3OnuLogicalPortId());
        tfUtsDot3OnuEtherPortIndex.setText("" + mbean.getUtsDot3OnuEtherPortIndex());

        tfUtsDot3OnuEtherPortVlanMode.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortVlanModeVList, mbean.getUtsDot3OnuEtherPortVlanMode().intValue()));
        tfUtsDot3OnuEtherPortVlanTag.setValue(mbean.getUtsDot3OnuEtherPortVlanTag().intValue());
        tfUtsDot3OnuEtherPortVlanTPID.setValue(Integer.toHexString(mbean.getUtsDot3OnuEtherPortVlanTPID().intValue()));
        vlanPanel.setVlanTranslation(mbean.getUtsDot3OnuEtherPortVlanTranslation());

        if(mbean.getUtsDot3OnuEtherPortVlanNaggregationNumber() != null) {
            tfUtsDot3OnuEtherPortVlanNaggregationNumber.setSelectedItem(mbean.getUtsDot3OnuEtherPortVlanNaggregationNumber());
        }


        byte value[] = mbean.getUtsDot3OnuEtherPortVlanNaggregation();
        if(value != null && value.length > 0) {
            for(int i = 0; i < n1PanelList.length - 1; i++) {
                byte n1[] = new byte[44];
                System.arraycopy(value, i * 44, n1, 0, n1.length);
                n1PanelList[i].setValue(n1);
            }

        }

        trunkPanel.setValue(mbean.getUtsDot3OnuEtherPortVlanTrunk());
    }

    public void updateModel() {
        VlanModeConfigMBean mbean = (VlanModeConfigMBean) getModel();

        mbean.setUtsDot3OnuEtherPortVlanMode(utsDot3OnuEtherPortVlanModeVList[tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex()]);

        if(tfUtsDot3OnuEtherPortVlanTag.isEnabled())
            mbean.setUtsDot3OnuEtherPortVlanTag(new Integer(tfUtsDot3OnuEtherPortVlanTag.getValue()));

        if(tfUtsDot3OnuEtherPortVlanTPID.isEnabled()) {
            mbean.setUtsDot3OnuEtherPortVlanTPID(Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(), 16));
        }

        if(tabbedPane.isEnabledAt(1)) {
            mbean.setUtsDot3OnuEtherPortVlanTranslation(vlanPanel.getVlanTranslation());
        }

        if(tabbedPane.isEnabledAt(2)) {
            mbean.setUtsDot3OnuEtherPortVlanTrunk(trunkPanel.getValue());
        }

        if(tfUtsDot3OnuEtherPortVlanNaggregationNumber.isEnabled()) {
            mbean.setUtsDot3OnuEtherPortVlanNaggregationNumber((Integer) tfUtsDot3OnuEtherPortVlanNaggregationNumber.getSelectedItem());
            byte value[] = new byte[512];
            for(int i = 0; i < n1PanelList.length; i++) {
                if(n1PanelList[i].isEnabled()) {
                    byte n1[] = n1PanelList[i].getValue();
                    System.arraycopy(n1, 0, value, i * 44, n1.length);
                }
            }

            mbean.setUtsDot3OnuEtherPortVlanNaggregation(value);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v)
                return i;
        }

        return 0;
    }

    boolean isNull(byte[] b) {
        for(int i = 0; i < b.length; i++) {
            if(b[i] != 0) return false;
        }

        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tfUtsDot3OnuEtherPortVlanMode) {
            int mode = tfUtsDot3OnuEtherPortVlanMode.getSelectedIndex();
            if(mode == 0) {
                tfUtsDot3OnuEtherPortVlanTag.setEnabled(false);
                tfUtsDot3OnuEtherPortVlanTPID.setEnabled(false);
                tfUtsDot3OnuEtherPortVlanTPID.setValue("0");
                tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, false);
                fireNumberChangedEvent(false);
            } else if(mode == 1) {
                tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
                tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, false);
                fireNumberChangedEvent(false);
//            } else if(mode == 2 || mode == 3) {
            } else if(mode == 2) {
                tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
                tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
                tabbedPane.setEnabledAt(1, true);
                tabbedPane.setEnabledAt(2, false);
                fireNumberChangedEvent(false);
//            } else if(mode == 4) {
            } else if(mode == 3) {
                tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
                tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(true);
                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, false);
                fireNumberChangedEvent(true);
            } else {
                tfUtsDot3OnuEtherPortVlanTag.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setEnabled(true);
                tfUtsDot3OnuEtherPortVlanTPID.setValue("8100");
                tfUtsDot3OnuEtherPortVlanNaggregationNumber.setEnabled(false);
                tabbedPane.setEnabledAt(1, false);
                tabbedPane.setEnabledAt(2, true);
                fireNumberChangedEvent(false);
            }
        } else {
            fireNumberChangedEvent(true);
        }
    }

    void fireNumberChangedEvent(boolean isEnable) {
        Integer number = (Integer) tfUtsDot3OnuEtherPortVlanNaggregationNumber.getSelectedItem();
        if(number == null) {
            number = 0;
        }
        for(int i = 0; i < n1PanelList.length; i++) {
            n1PanelList[i].setEnabled(isEnable && i < number.intValue());
        }

        for(int i = 0; i < 3; i++) {
            tabbedPane.setEnabledAt(i + 3, isEnable && i < (number.intValue()-1) / 2 + 1);
        }
    }
}