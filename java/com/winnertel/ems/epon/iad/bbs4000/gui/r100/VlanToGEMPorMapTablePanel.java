/**
 * Modified by Zhou Chao
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.LongIndexGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.VlanToGEMPorMapTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class VlanToGEMPorMapTablePanel extends UPanel {

    private LongIndexGenField tfOltMultiVlantoMultiGEMPorMapIndex = new LongIndexGenField(fApplication);
    private LongTextField tfMulticastVLANIDStart = new LongTextField();
    private LongTextField tfMulticastVLANIDStop = new LongTextField();
    private LongTextField tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo = new LongTextField();

    private final String oltMultiVlantoMultiGEMPorMapIndex = fStringMap.getString("oltMultiVlantoMultiGEMPorMapIndex") + ": ";
    private final String multicastVLANIDStart = fStringMap.getString("multicastVLANIDStart") + ": ";
    private final String multicastVLANIDStop = fStringMap.getString("multicastVLANIDStop") + ": ";
    private final String oltMultiVlantoMultiGEMPorMapOltGEMPortNo = fStringMap.getString("oltMultiVlantoMultiGEMPorMapOltGEMPortNo") + ": ";

    public VlanToGEMPorMapTablePanel(IApplication app) {
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
        baseInfoPanel.add(tfOltMultiVlantoMultiGEMPorMapIndex);
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
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltMultiVlantoMultiGEMPorMapIndex.setEnabled(true);
            tfOltMultiVlantoMultiGEMPorMapIndex.setTable(fTable);
            tfMulticastVLANIDStart.setValue(4095);
            tfMulticastVLANIDStop.setValue(4095);
            return;
        }

        tfOltMultiVlantoMultiGEMPorMapIndex.setEnabled(false);

        VlanToGEMPorMapTable mbean = (VlanToGEMPorMapTable) getModel();

        tfOltMultiVlantoMultiGEMPorMapIndex.setValue(mbean.getOltMultiVlantoMultiGEMPorMapIndex());

        tfMulticastVLANIDStart.setEnabled(mbean.getMulticastVLANIDStart() != null);
        tfMulticastVLANIDStart.setValue(mbean.getMulticastVLANIDStart());

        tfMulticastVLANIDStop.setEnabled(mbean.getMulticastVLANIDStop() != null);
        tfMulticastVLANIDStop.setValue(mbean.getMulticastVLANIDStop());

        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setEnabled(mbean.getOltMultiVlantoMultiGEMPorMapOltGEMPortNo() != null);
        tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.setValue(mbean.getOltMultiVlantoMultiGEMPorMapOltGEMPortNo());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new VlanToGEMPorMapTable(fApplication.getSnmpProxy()));

        VlanToGEMPorMapTable mbean = (VlanToGEMPorMapTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOltMultiVlantoMultiGEMPorMapIndex(tfOltMultiVlantoMultiGEMPorMapIndex.getValue(0,null));
        }

        if (tfMulticastVLANIDStart.isEnabled())
            mbean.setMulticastVLANIDStart(tfMulticastVLANIDStart.getValue());

        if (tfMulticastVLANIDStop.isEnabled())
            mbean.setMulticastVLANIDStop(tfMulticastVLANIDStop.getValue());

        if (tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.isEnabled())
            mbean.setOltMultiVlantoMultiGEMPorMapOltGEMPortNo(tfOltMultiVlantoMultiGEMPorMapOltGEMPortNo.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}