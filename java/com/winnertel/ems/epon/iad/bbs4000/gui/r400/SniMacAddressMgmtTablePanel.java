package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniMacAddressMgmtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The SniMacAddressMgmtTablePanel class.
 * Created by DVM Creator
 */
public class SniMacAddressMgmtTablePanel extends UPanel {

    private JLabel tfSniMacAddressManagementDeviceIndex = new JLabel();

    private IntegerTextField tfSniMacAddrTableAgingTime = new IntegerTextField();

    private final String sniMacAddressManagementDeviceIndex = fStringMap.getString("sniMacAddressManagementDeviceIndex") + " : ";
    private final String sniMacAddrTableAgingTime = fStringMap.getString("sniMacAddrTableAgingTime") + " : ";

    public SniMacAddressMgmtTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(sniMacAddressManagementDeviceIndex));
        baseInfoPanel.add(tfSniMacAddressManagementDeviceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(sniMacAddrTableAgingTime));
        tfSniMacAddrTableAgingTime.setName(fStringMap.getString("sniMacAddrTableAgingTime"));
        baseInfoPanel.add(tfSniMacAddrTableAgingTime);
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


    }

    public void refresh() {

        SniMacAddressMgmtTable mbean = (SniMacAddressMgmtTable) getModel();

        tfSniMacAddressManagementDeviceIndex.setText(mbean.getSniMacAddressManagementDeviceIndex().toString());
        tfSniMacAddrTableAgingTime.setValue(mbean.getSniMacAddrTableAgingTime().intValue());

    }

    public void updateModel() {

        SniMacAddressMgmtTable mbean = (SniMacAddressMgmtTable) getModel();


        mbean.setSniMacAddrTableAgingTime(new Integer(tfSniMacAddrTableAgingTime.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for(int i = 0; i != list.length; i++) {
            if(list[i] == v) return i;
        }
        return 0;
    }

}
