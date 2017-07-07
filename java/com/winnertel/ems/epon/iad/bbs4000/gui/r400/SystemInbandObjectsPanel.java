package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SystemInbandObjects;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class SystemInbandObjectsPanel extends UPanel {
    private IPAddressField tfInbandIpAddress = new IPAddressField();
    private IPAddressField tfInbandIpSubnetMask = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField tfInbandIpGateway = new IPAddressField();
    private IntegerTextField tfInbandVlanId = new IntegerTextField();
    private JLabel tfInbandMacAddress = new JLabel();

    private final String inbandIpAddress = fStringMap.getString("inbandIpAddress") + " : ";
    private final String inbandIpSubnetMask = fStringMap.getString("inbandIpSubnetMask") + " : ";
    private final String inbandIpGateway = fStringMap.getString("inbandIpGateway") + " : ";
    private final String inbandVlanId = fStringMap.getString("inbandVlanId") + " : ";
    private final String inbandMacAddress = fStringMap.getString("inbandMacAddress") + " : ";

    public SystemInbandObjectsPanel(IApplication app) {
        super(app);
        setModel(new SystemInbandObjects(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SystemInbandObjects");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("System_Inband")));

        baseInfoPanel.add(new JLabel(inbandIpAddress));
        tfInbandIpAddress.setName(fStringMap.getString("inbandIpAddress"));
        baseInfoPanel.add(tfInbandIpAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(inbandIpSubnetMask));
        tfInbandIpSubnetMask.setName(fStringMap.getString("inbandIpSubnetMask"));
        baseInfoPanel.add(tfInbandIpSubnetMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(inbandIpGateway));
        tfInbandIpGateway.setName(fStringMap.getString("inbandIpGateway"));
        baseInfoPanel.add(tfInbandIpGateway);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(inbandVlanId));
        tfInbandVlanId.setName(fStringMap.getString("inbandVlanId"));
        baseInfoPanel.add(tfInbandVlanId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(inbandMacAddress));
        tfInbandMacAddress.setEnabled(false);
        baseInfoPanel.add(tfInbandMacAddress);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        SystemInbandObjects mbean = (SystemInbandObjects) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);
        tfInbandIpAddress.setValue(mbean.getInbandIpAddress());
        tfInbandIpSubnetMask.setValue(mbean.getInbandIpSubnetMask());
        tfInbandIpGateway.setValue(mbean.getInbandIpGateway());
        tfInbandVlanId.setValue(mbean.getInbandVlanId());
        tfInbandMacAddress.setText(MacAddressFormatter.format(mbean.getInbandMacAddress()));
    }

    public void updateModel() {
        SystemInbandObjects mbean = (SystemInbandObjects) getModel();
        if (mbean == null)
            return;

        mbean.setInbandIpAddress(tfInbandIpAddress.getIPString());
        mbean.setInbandIpSubnetMask(tfInbandIpSubnetMask.getIPString());
        mbean.setInbandIpGateway(tfInbandIpGateway.getIPString());
        mbean.setInbandVlanId(tfInbandVlanId.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
}