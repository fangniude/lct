package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.UNIVlanStackingMBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UNIVlanStackingMBeanPanel extends UPanel
{
    
    private JLabel tfUtsDot3OnuModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuDeviceId = new JLabel();
    
//    private Integer[] portList = new Integer[] { 1, 2, 3, 4 };
    private JLabel tfUtsDot3OnuPortId = new JLabel();
    
    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();
    
    private StringTextField tfUtsDot3OnuEtherPortVlanTPID = new StringTextField();
    
    private Dot3OnuEtherPortVlanPanel vlanPanel = null;
    
    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + " : ";
    //private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + " : ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + " : ";
    private final String utsDot3OnuLogicalPortId =
        fStringMap.getString("utsDot3OnuLogicalPortId") + " : ";
    private final String utsDot3OnuEtherPortIndex =
        fStringMap.getString("utsDot3OnuEtherPortIndex") + " : ";
    private final String utsDot3OnuEtherPortVlanTPID =
        fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + " : ";
    
    BBS4000NE bbs4000NE;
    
    public UNIVlanStackingMBeanPanel(IApplication app)
    {
        super(app);
        
        bbs4000NE = new BBS4000NE(app);
        
        init();
    }
    
//    private Integer[] getLogicalPortList() {
//        int number = bbs4000NE.getPonSplitRatio();
//        Integer[] logicalPorts = new Integer[number];
//
//        for (int i = 1; i <= number; i++) {
//            logicalPorts[i - 1] = new Integer(i);
//        }
//
//        return logicalPorts;
//    }
    
    public void initGui()
    {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.TOP, 5, 5);
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
        
        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortVlanTPID));
        tfUtsDot3OnuEtherPortVlanTPID.setName(fStringMap.getString("utsDot3OnuEtherPortVlanTPID"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortVlanTPID);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new VSpacer());

        //VLAN Setting
        vlanPanel = new Dot3OnuEtherPortVlanPanel(fApplication);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(fStringMap.getString("Basic_Info"), baseInfoPanel);
        tabbedPane.add(fStringMap.getString("VLAN_Translation_Panel"), vlanPanel);
        
        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(tabbedPane);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }
    
    protected void initForm()
    {

    }
    
    public boolean validateFrom()
    {
        try
        {
            Integer theValue = Integer.valueOf(tfUtsDot3OnuEtherPortVlanTPID.getText(), 16);
            if (theValue.intValue() < 0 || theValue.intValue() > 65535)
            {
                MessageDialog.showInfoMessageDialog(fApplication,
                    utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
                return false;
            }
        }
        catch (Exception e)
        {
            MessageDialog.showInfoMessageDialog(fApplication,
                utsDot3OnuEtherPortVlanTPID + fStringMap.getString("Err_hex"));
            return false;
        }
        
        return vlanPanel.validateFrom();
    }
    
    public void refresh()
    {
        UNIVlanStackingMBean mbean = (UNIVlanStackingMBean) getModel();
        BeanService.refreshBean(fApplication, mbean);
        
        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        tfUtsDot3OnuPortId.setText(mbean.getUtsDot3OnuPortId().toString());
        tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
        tfUtsDot3OnuEtherPortIndex.setText(mbean.getUtsDot3OnuEtherPortIndex().toString());
        tfUtsDot3OnuEtherPortVlanTPID.setValue(Integer.toHexString(mbean.getUtsDot3OnuEtherPortVlanTPID().intValue()));
        vlanPanel.setVlanTranslation(mbean.getUtsDot3OnuEtherPortVlanTranslation());
    }
    
    public void updateModel()
    {
        UNIVlanStackingMBean mbean = (UNIVlanStackingMBean) getModel();
        
//        mbean.setUtsDot3OnuPortId( (Integer)tfUtsDot3OnuPortId.getSelectedItem());
//        mbean.setUtsDot3OnuLogicalPortId( (Integer)tfUtsDot3OnuLogicalPortId.getSelectedItem() );
//        mbean.setUtsDot3OnuEtherPortIndex( tfUtsDot3OnuEtherPortIndex.getValue() );
        
        mbean.setUtsDot3OnuEtherPortVlanTPID(Integer.valueOf(
            tfUtsDot3OnuEtherPortVlanTPID.getText(), 16));
        
        mbean.setUtsDot3OnuEtherPortVlanTranslation(vlanPanel.getVlanTranslation());
    }
    
    public int getIndexFromValue(int[] list, int v)
    {
        for (int i = 0; i != list.length; i++)
        {
            if (list[i] == v)
                return i;
        }
        
        return 0;
    }
}
