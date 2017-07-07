package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.VlanGlobalInfoTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The VlanGlobalInfoTablePanel class.
 * Created by DVM Creator
 */
public class VlanGlobalInfoTablePanel extends UPanel {

    private IntegerTextField tfVlanDeviceIndex = new IntegerTextField();

    private IntegerTextField tfMaxVlanId = new IntegerTextField();

    private IntegerTextField tfMaxSupportVlans = new IntegerTextField();

    private IntegerTextField tfCreatedVlanNumber = new IntegerTextField();


    private final String vlanDeviceIndex = fStringMap.getString("vlanDeviceIndex") + " : ";
    private final String maxVlanId = fStringMap.getString("maxVlanId") + " : ";
    private final String maxSupportVlans = fStringMap.getString("maxSupportVlans") + " : ";
    private final String createdVlanNumber = fStringMap.getString("createdVlanNumber") + " : ";


    public VlanGlobalInfoTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(vlanDeviceIndex));
        baseInfoPanel.add(tfVlanDeviceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(maxVlanId));
        baseInfoPanel.add(tfMaxVlanId);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(maxSupportVlans));
        baseInfoPanel.add(tfMaxSupportVlans);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(createdVlanNumber));
        baseInfoPanel.add(tfCreatedVlanNumber);
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

        //tfVlanDeviceIndex.setEditable(false);
        tfMaxVlanId.setEditable(false);
        tfMaxSupportVlans.setEditable(false);
        tfCreatedVlanNumber.setEditable(false);

    }

    public void refresh() {

        VlanGlobalInfoTable mbean = (VlanGlobalInfoTable) getModel();

        if (mbean == null)
            return;

        tfVlanDeviceIndex.setText(mbean.getVlanDeviceIndex().toString());
        tfMaxVlanId.setText(mbean.getMaxVlanId().toString());
        tfMaxSupportVlans.setText(mbean.getMaxSupportVlans().toString());
        tfCreatedVlanNumber.setText(mbean.getCreatedVlanNumber().toString());

    }

    public void updateModel() {

        VlanGlobalInfoTable mbean = (VlanGlobalInfoTable) getModel();


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}