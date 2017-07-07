/**
 * Created by Zhou Chao, 2010/5/7
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniMacAddressManagementNode;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class MacAddressManagementPanel extends UPanel {

    private IntegerTextField tfUniMacAddrAgingTime = new IntegerTextField();

    private final String uniMacAddrAgingTime = fStringMap.getString("uniMacAddrAgingTime") + " : ";

    private SnmpApplyButton btApply = null;
    private SnmpRefreshButton btRefresh = null;

    private SnmpTablePane tablepanel1;
    private JPanel baseInfoPanel;

    public MacAddressManagementPanel(IApplication app) {
        super(app);
        setModel(new UniMacAddressManagementNode(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_UniMacAddressManagement");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("UNI_MAC_Address_Management_Node")));

        baseInfoPanel.add(new JLabel(uniMacAddrAgingTime));
        tfUniMacAddrAgingTime.setName(fStringMap.getString("uniMacAddrAgingTime"));
        baseInfoPanel.add(tfUniMacAddrAgingTime);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(5, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(buttonsPanel);
        allPanel.add(new VSpacer());

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("UNI_MAC_Address_Table");
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("UNI_MAC_Address_Table")));
        allPanel.add(tablepanel1);

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(100, 200));
    }

    protected void initForm() {
        baseInfoPanel.setPreferredSize(new Dimension(100, 100));
        tablepanel1.setPreferredSize(new Dimension(100, 300));
    }

    public void refresh() {
        UniMacAddressManagementNode mbean = (UniMacAddressManagementNode) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        if (mbean.getUniMacAddrAgingTime() != null)
            tfUniMacAddrAgingTime.setValue(mbean.getUniMacAddrAgingTime());

        tablepanel1.refresh();
    }

    public void updateModel() {
        UniMacAddressManagementNode mbean = (UniMacAddressManagementNode) getModel();
        if (mbean == null)
            return;

        mbean.setUniMacAddrAgingTime(new Integer(tfUniMacAddrAgingTime.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}