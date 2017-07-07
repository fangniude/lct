/**
 * Title          :   OltSlotStatusTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.OltSlotStatusTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shen Dayong
 * Create on 2008-10-2
 * Modify by HZ21044
 */

public class OltSlotStatusTablePanel extends UPanel
{
    
    private IntegerTextField tfOltSlotStatusSlotNo = new IntegerTextField();
    
    private int[] oltSlotStatusOperationalStateVList = new int[] { 1, 2, 3, };
    private String[] oltSlotStatusOperationalStateTList =
        new String[] { fStringMap.getString("enabled"),
            fStringMap.getString("disabled"), fStringMap.getString("unknown"), };
    private JComboBox tfOltSlotStatusOperationalState =
        new JComboBox(oltSlotStatusOperationalStateTList);
    private LongTextField tfOltSlotStatusOltFirmwareVersion = new LongTextField();
    
    private final String oltSlotStatusSlotNo = fStringMap.getString("oltSlotStatusSlotNo") + " : ";
    private final String oltSlotStatusOperationalState =
        fStringMap.getString("oltSlotStatusOperationalState") + " : ";
    private final String oltSlotStatusOltFirmwareVersion =
        fStringMap.getString("oltSlotStatusOltFirmwareVersion") + " : ";
    
    public OltSlotStatusTablePanel(IApplication app)
    {
        super(app);
        
        init();
    }
    
    public void initGui()
    {
        
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
        
        baseInfoPanel.add(new JLabel(oltSlotStatusSlotNo));
        baseInfoPanel.add(tfOltSlotStatusSlotNo);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(oltSlotStatusOperationalState));
        baseInfoPanel.add(tfOltSlotStatusOperationalState);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(oltSlotStatusOltFirmwareVersion));
        baseInfoPanel.add(tfOltSlotStatusOltFirmwareVersion);
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
    
    protected void initForm()
    {
        
    }
    
    public void refresh()
    {
        OltSlotStatusTable mbean = (OltSlotStatusTable) getModel();
        
        tfOltSlotStatusSlotNo.setText(mbean.getOltSlotStatusSlotNo().toString());
        tfOltSlotStatusOperationalState.setSelectedIndex(getIndexFromValue(
            oltSlotStatusOperationalStateVList, mbean.getOltSlotStatusOperationalState().intValue()));
        tfOltSlotStatusOltFirmwareVersion.setText(mbean.getOltSlotStatusOltFirmwareVersion().toString());
    }
    
    public void updateModel()
    {
        
        OltSlotStatusTable mbean = (OltSlotStatusTable) getModel();
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
