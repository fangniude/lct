/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOltMultiVlanToMultiGEMPortMapMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class GponOltMultiVlanToMultiGEMPortMapPanel extends UPanel {

    private IndexAutoGenField tfOltMultiVlantoMultiGEMPorMapIndex = new IndexAutoGenField(fApplication,1);
    private LongTextField tfMulticastVLANIDStart = new LongTextField();
    private LongTextField tfMulticastVLANIDStop = new LongTextField();
    private LongTextField tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo = new LongTextField();

    private final String oltMultiVlantoMultiGEMPorMapIndex = fStringMap.getString("oltMultiVlantoMultiGEMPorMapIndex") + ": ";
    private final String multicastVLANIDStart = fStringMap.getString("multicastVLANIDStart") + ": ";
    private final String multicastVLANIDStop = fStringMap.getString("multicastVLANIDStop") + ": ";
    private final String oltMultiVlantoMultiGEMPorMapOltGEMPortNo = fStringMap.getString("oltMultiVlantoMultiGEMPorMapOltGEMPortNo") + ": ";

    public GponOltMultiVlanToMultiGEMPortMapPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltMultiVlantoMultiGEMPorMapIndex));
        baseInfoPanel.add(tfOltMultiVlantoMultiGEMPorMapIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastVLANIDStart));
        tfMulticastVLANIDStart.setName(fStringMap.getString("multicastVLANIDStart"));
        baseInfoPanel.add(tfMulticastVLANIDStart);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastVLANIDStop));
        tfMulticastVLANIDStop.setName(fStringMap.getString("multicastVLANIDStop"));
        baseInfoPanel.add(tfMulticastVLANIDStop);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltMultiVlantoMultiGEMPorMapOltGEMPortNo));
        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setName(fStringMap.getString("oltMultiVlantoMultiGEMPorMapOltGEMPortNo"));
        baseInfoPanel.add(tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo);
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
        tfMulticastVLANIDStart.setValueScope(1, 4094);
        tfMulticastVLANIDStop.setValueScope(1, 4094);
        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setValueScope(3800, 3999);
        tfOltMultiVlantoMultiGEMPorMapIndex.setValueScope(0,2, Long.MAX_VALUE);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltMultiVlantoMultiGEMPorMapIndex.setEnabled(true);
            tfOltMultiVlantoMultiGEMPorMapIndex.setTable(fTable);
            tfOltMultiVlantoMultiGEMPorMapIndex.refresh();
            return;
        } else {
            tfOltMultiVlantoMultiGEMPorMapIndex.setEnabled(false);
        }
        GponOltMultiVlanToMultiGEMPortMapMBean mbean = (GponOltMultiVlanToMultiGEMPortMapMBean) getModel();
        if (mbean == null)
            return;

        tfOltMultiVlantoMultiGEMPorMapIndex.setValue(0,mbean.getOltMultiVlantoMultiGEMPorMapIndex());

        tfMulticastVLANIDStart.setEnabled(mbean.getMulticastVLANIDStart() != null);
        tfMulticastVLANIDStart.setValue(mbean.getMulticastVLANIDStart());

        tfMulticastVLANIDStop.setEnabled(mbean.getMulticastVLANIDStop() != null);
        tfMulticastVLANIDStop.setValue(mbean.getMulticastVLANIDStop());

        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setEnabled(mbean.getOltMultiVlantoMultiGEMPorMapOltGEMPortNo() != null);
        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setValue(mbean.getOltMultiVlantoMultiGEMPorMapOltGEMPortNo());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOltMultiVlanToMultiGEMPortMapMBean(fApplication.getSnmpProxy()));

        GponOltMultiVlanToMultiGEMPortMapMBean mbean = (GponOltMultiVlanToMultiGEMPortMapMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOltMultiVlantoMultiGEMPorMapIndex(tfOltMultiVlantoMultiGEMPorMapIndex.getValue(0));
        }

        if (tfMulticastVLANIDStart.isEnabled())
            mbean.setMulticastVLANIDStart(tfMulticastVLANIDStart.getValue());

        if (tfMulticastVLANIDStop.isEnabled())
            mbean.setMulticastVLANIDStop(tfMulticastVLANIDStop.getValue());

        if (tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.isEnabled())
            mbean.setOltMultiVlantoMultiGEMPorMapOltGEMPortNo(tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.getValue());
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOltMultiVlantoMultiGEMPorMapIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}