package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r400.OuiFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SystemOutbandObjects;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class SystemOutbandObjectsPanel extends UPanel {
    private IPAddressField tfOutbandIpAddress = new IPAddressField();
    private IPAddressField tfOutbandIpSubnetMask = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField tfOutbandIpGateway = new IPAddressField();
    private JLabel tfOutbandMacAddress = new JLabel();
    private JLabel tfSystemOUI = new JLabel();
    private JLabel tfVendorName = new JLabel();

    private final String outbandIpAddress = fStringMap.getString("outbandIpAddress") + " : ";
    private final String outbandIpSubnetMask = fStringMap.getString("outbandIpSubnetMask") + " : ";
    private final String outbandIpGateway = fStringMap.getString("outbandIpGateway") + " : ";
    private final String outbandMacAddress = fStringMap.getString("outbandMacAddress") + " : ";
    private final String systemOUI = fStringMap.getString("systemOUI") + " : ";
    private final String vendorName = fStringMap.getString("vendorName") + " : ";

    public SystemOutbandObjectsPanel(IApplication app) {
        super(app);
        setModel(new SystemOutbandObjects(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SystemGlobalObjects");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("System_Outband")));

        baseInfoPanel.add(new JLabel(outbandIpAddress));
        tfOutbandIpAddress.setName(fStringMap.getString("outbandIpAddress"));
        baseInfoPanel.add(tfOutbandIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(outbandIpSubnetMask));
        tfOutbandIpSubnetMask.setName(fStringMap.getString("outbandIpSubnetMask"));
        baseInfoPanel.add(tfOutbandIpSubnetMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(outbandIpGateway));
        tfOutbandIpGateway.setName(fStringMap.getString("outbandIpGateway"));
        baseInfoPanel.add(tfOutbandIpGateway);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(outbandMacAddress));
        baseInfoPanel.add(tfOutbandMacAddress);
        tfOutbandMacAddress.setEnabled(false);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(systemOUI));
        baseInfoPanel.add(tfSystemOUI);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(vendorName));
        baseInfoPanel.add(tfVendorName);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        SystemOutbandObjects mbean = (SystemOutbandObjects) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);
        tfOutbandIpAddress.setValue(mbean.getOutbandIpAddress());
        tfOutbandIpSubnetMask.setValue(mbean.getOutbandIpSubnetMask());
        tfOutbandIpGateway.setValue(mbean.getOutbandIpGateway());
        tfOutbandMacAddress.setText(MacAddressFormatter.format(mbean.getOutbandMacAddress()));
        tfSystemOUI.setText(OuiFormatter.format(mbean.getSystemOUI()));
        tfVendorName.setText(mbean.getVendorName());
    }

    public void updateModel() {
        SystemOutbandObjects mbean = (SystemOutbandObjects) getModel();
        if (mbean == null)
            return;

        mbean.setOutbandIpAddress(tfOutbandIpAddress.getIPString());
        mbean.setOutbandIpSubnetMask(tfOutbandIpSubnetMask.getIPString());
        mbean.setOutbandIpGateway(tfOutbandIpGateway.getIPString());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
}