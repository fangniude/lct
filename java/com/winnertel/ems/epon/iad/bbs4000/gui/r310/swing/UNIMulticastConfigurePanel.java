package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.Dot3OnuEtherPortVlanListPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.UNIMulticastConfigure;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UNIMulticastConfigurePanel extends UPanel {

    private JLabel tfUtsDot3OnuModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuDeviceId = new JLabel();

    private JLabel tfUtsDot3OnuPortId = new JLabel();

    private JLabel tfUtsDot3OnuLogicalPortId = new JLabel();
    private JLabel tfUtsDot3OnuEtherPortIndex = new JLabel();
    private IntegerTextField tfUtsDot3OnuEtherPortMaxMcGroupNum = new IntegerTextField();

    private int[] utsDot3OnuEtherPortMcTagStripeVList = new int[]{1, 2, 3,};
    private String[] utsDot3OnuEtherPortMcTagStripeTList = new String[]{
            fStringMap.getString("stripe"),
            fStringMap.getString("noStripe"),
            fStringMap.getString("translate"),
    };
    private JComboBox tfUtsDot3OnuEtherPortMcTagStripe = new JComboBox(utsDot3OnuEtherPortMcTagStripeTList);

    private Dot3OnuEtherPortVlanListPanel vlanListPanel = null;

    private final String utsDot3OnuModuleId = fStringMap.getString("utsDot3OnuModuleId") + ": ";
    //private final String utsDot3OnuDeviceId = fStringMap.getString("utsDot3OnuDeviceId") + ": ";
    private final String utsDot3OnuPortId = fStringMap.getString("utsDot3OnuPortId") + ": ";
    private final String utsDot3OnuLogicalPortId = fStringMap.getString("utsDot3OnuLogicalPortId") + ": ";
    private final String utsDot3OnuEtherPortIndex = fStringMap.getString("utsDot3OnuEtherPortIndex") + ": ";
    private final String utsDot3OnuEtherPortMaxMcGroupNum = fStringMap.getString("utsDot3OnuEtherPortMaxMcGroupNum") + ": ";
    private final String utsDot3OnuEtherPortMcTagStripe = fStringMap.getString("utsDot3OnuEtherPortMcTagStripe") + ": ";

    private BBS4000NE bbs4000NE;

    public UNIMulticastConfigurePanel(IApplication app) {
        super(app);
        bbs4000NE = new BBS4000NE(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMaxMcGroupNum));
        tfUtsDot3OnuEtherPortMaxMcGroupNum.setName(fStringMap.getString("utsDot3OnuEtherPortMaxMcGroupNum"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortMaxMcGroupNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuEtherPortMcTagStripe));
        tfUtsDot3OnuEtherPortMcTagStripe.setName(fStringMap.getString("utsDot3OnuEtherPortMcTagStripe"));
        baseInfoPanel.add(tfUtsDot3OnuEtherPortMcTagStripe);
        baseInfoPanel.add(new HSpacer());

        vlanListPanel = new Dot3OnuEtherPortVlanListPanel(fApplication);
        vlanListPanel.setPreferredSize(new Dimension(300, 250));
        //baseInfoPanel.add(new JLabel(fStringMap.getString("Multicast_Vlan_Panel")));
        vlanListPanel.setName(fStringMap.getString("Multicast_Vlan_Panel"));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new JLabel(fStringMap.getString("Multicast_Vlan_List") + ":"));
        allPanel.add(vlanListPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfUtsDot3OnuEtherPortMaxMcGroupNum.setValueScope(4, 1024); //modified by Zhou Chao, 2008/8/25
    }

    public boolean validateFrom() {
        return true;
    }

    public void refresh() {
        UNIMulticastConfigure mbean = (UNIMulticastConfigure) getModel();

        tfUtsDot3OnuModuleId.setText(mbean.getUtsDot3OnuModuleId().toString());
        //tfUtsDot3OnuDeviceId.setText(mbean.getUtsDot3OnuDeviceId().toString());
        tfUtsDot3OnuPortId.setText("" + mbean.getUtsDot3OnuPortId());
        //tfUtsDot3OnuLogicalPortId.setText(mbean.getUtsDot3OnuLogicalPortId().toString());
        tfUtsDot3OnuLogicalPortId.setText("" + mbean.getUtsDot3OnuLogicalPortId());
        tfUtsDot3OnuEtherPortIndex.setText("" + mbean.getUtsDot3OnuEtherPortIndex());
        //tfUtsDot3OnuEtherPortVlanDefTag.setValue(mbean.getUtsDot3OnuEtherPortVlanDefTag().intValue());
        tfUtsDot3OnuEtherPortMaxMcGroupNum.setValue(mbean.getUtsDot3OnuEtherPortMaxMcGroupNum().intValue());
        tfUtsDot3OnuEtherPortMcTagStripe.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortMcTagStripeVList, mbean.getUtsDot3OnuEtherPortMcTagStripe()));
        vlanListPanel.setMulticastVlanList(mbean.getUtsDot3OnuEtherPortMVlanList());
    }

    public void updateModel() {
        UNIMulticastConfigure mbean = (UNIMulticastConfigure) getModel();

        mbean.setUtsDot3OnuEtherPortMaxMcGroupNum(new Integer(tfUtsDot3OnuEtherPortMaxMcGroupNum.getValue()));
        mbean.setUtsDot3OnuEtherPortMcTagStripe(utsDot3OnuEtherPortMcTagStripeVList[tfUtsDot3OnuEtherPortMcTagStripe.getSelectedIndex()]);
        mbean.setUtsDot3OnuEtherPortMVlanList(vlanListPanel.getMulticastVlanList());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
