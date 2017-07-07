package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcMduSnmpConfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcMduSnmpConfTablePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcMduSnmpConfModuleId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcMduSnmpConfDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcMduSnmpConfPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcMduSnmpConfLogicalPortId = new JLabel();

    private IntegerTextField tfUtsDot3Onu2CtcMduSnmpConfSnmpVer = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcMduSnmpConfTrapHost = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcMduSnmpConfTrapPort = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcMduSnmpConfSnmpPort = new IntegerTextField();
    private StringTextField tfUtsDot3Onu2CtcMduSnmpConfSecurityName = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcMduSnmpConfCommunityRead = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcMduSnmpConfCommunityWrite = new StringTextField();

    private final String utsDot3Onu2CtcMduSnmpConfModuleId = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfModuleId") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfDeviceId = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfDeviceId") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfPortId = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfPortId") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfLogicalPortId = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfSnmpVer = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSnmpVer") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfTrapHost = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfTrapHost") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfTrapPort = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfTrapPort") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfSnmpPort = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSnmpPort") + ": ";
//    private final String utsDot3Onu2CtcMduSnmpConfSecurityName = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSecurityName") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfCommunityRead = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfCommunityRead") + ": ";
    private final String utsDot3Onu2CtcMduSnmpConfCommunityWrite = fStringMap.getString("utsDot3Onu2CtcMduSnmpConfCommunityWrite") + ": ";

    public Onu2CtcMduSnmpConfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfModuleId);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfDeviceId));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfDeviceId);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfSnmpVer));
        tfUtsDot3Onu2CtcMduSnmpConfSnmpVer.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSnmpVer"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfSnmpVer);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfTrapHost));
        tfUtsDot3Onu2CtcMduSnmpConfTrapHost.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfTrapHost"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfTrapHost);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfTrapPort));
        tfUtsDot3Onu2CtcMduSnmpConfTrapPort.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfTrapPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfTrapPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfSnmpPort));
        tfUtsDot3Onu2CtcMduSnmpConfSnmpPort.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSnmpPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfSnmpPort);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfSecurityName));
//        tfUtsDot3Onu2CtcMduSnmpConfSecurityName.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfSecurityName"));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfSecurityName);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfCommunityRead));
        tfUtsDot3Onu2CtcMduSnmpConfCommunityRead.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfCommunityRead"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfCommunityRead);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduSnmpConfCommunityWrite));
        tfUtsDot3Onu2CtcMduSnmpConfCommunityWrite.setName(fStringMap.getString("utsDot3Onu2CtcMduSnmpConfCommunityWrite"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduSnmpConfCommunityWrite);
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
        tfUtsDot3Onu2CtcMduSnmpConfTrapPort.setValueScope(1, 65535);
        tfUtsDot3Onu2CtcMduSnmpConfSnmpPort.setValueScope(1, 65535);
    }

    public void refresh() {
        Onu2CtcMduSnmpConfTable mbean = (Onu2CtcMduSnmpConfTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcMduSnmpConfModuleId.setText(mbean.getUtsDot3Onu2CtcMduSnmpConfModuleId().toString());
        tfUtsDot3Onu2CtcMduSnmpConfDeviceId.setText(mbean.getUtsDot3Onu2CtcMduSnmpConfDeviceId().toString());
        tfUtsDot3Onu2CtcMduSnmpConfPortId.setText(mbean.getUtsDot3Onu2CtcMduSnmpConfPortId().toString());
        tfUtsDot3Onu2CtcMduSnmpConfLogicalPortId.setText(mbean.getUtsDot3Onu2CtcMduSnmpConfLogicalPortId().toString());
        tfUtsDot3Onu2CtcMduSnmpConfSnmpVer.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfSnmpVer().intValue());
        tfUtsDot3Onu2CtcMduSnmpConfTrapHost.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfTrapHost());
        tfUtsDot3Onu2CtcMduSnmpConfTrapPort.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfTrapPort().intValue());
        tfUtsDot3Onu2CtcMduSnmpConfSnmpPort.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfSnmpPort().intValue());
//        tfUtsDot3Onu2CtcMduSnmpConfSecurityName.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfSecurityName());
        tfUtsDot3Onu2CtcMduSnmpConfCommunityRead.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfCommunityRead());
        tfUtsDot3Onu2CtcMduSnmpConfCommunityWrite.setValue(mbean.getUtsDot3Onu2CtcMduSnmpConfCommunityWrite());
    }

    public void updateModel() {
        Onu2CtcMduSnmpConfTable mbean = (Onu2CtcMduSnmpConfTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcMduSnmpConfSnmpVer(new Integer(tfUtsDot3Onu2CtcMduSnmpConfSnmpVer.getValue()));
        mbean.setUtsDot3Onu2CtcMduSnmpConfTrapHost(new String(tfUtsDot3Onu2CtcMduSnmpConfTrapHost.getIPString()));
        mbean.setUtsDot3Onu2CtcMduSnmpConfTrapPort(new Integer(tfUtsDot3Onu2CtcMduSnmpConfTrapPort.getValue()));
        mbean.setUtsDot3Onu2CtcMduSnmpConfSnmpPort(new Integer(tfUtsDot3Onu2CtcMduSnmpConfSnmpPort.getValue()));
//        mbean.setUtsDot3Onu2CtcMduSnmpConfSecurityName(new String(tfUtsDot3Onu2CtcMduSnmpConfSecurityName.getValue()));
        mbean.setUtsDot3Onu2CtcMduSnmpConfCommunityRead(new String(tfUtsDot3Onu2CtcMduSnmpConfCommunityRead.getValue()));
        mbean.setUtsDot3Onu2CtcMduSnmpConfCommunityWrite(new String(tfUtsDot3Onu2CtcMduSnmpConfCommunityWrite.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}