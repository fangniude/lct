/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesSipCfg;
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

public class Onu2CtcCombinedFeaturesSipCfgPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

    private IntegerTextField tfUtsDot3Onu2CtcSipMgPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcSipProxyServIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcSipProxyServComPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcSipBackupProxyServIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcSipBackupProxyServComPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcSipActiveProxyServ = new IPAddressField();
    private IPAddressField tfUtsDot3Onu2CtcSipRegServIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcSipRegServComPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcSipBackupRegServIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcSipBackupRegServComPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcSipOutBoundServIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcSipOutBoundServPort = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcSipRegInterval = new IntegerTextField();

    private int[] utsDot3Onu2CtcSipHeartbeatSwitchVList = new int[]{1, 0,};
    private String[] utsDot3Onu2CtcSipHeartbeatSwitchTList = new String[]{
            fStringMap.getString("heartbeatOff"),
            fStringMap.getString("heartbeatOn"),
    };
    private JComboBox tfUtsDot3Onu2CtcSipHeartbeatSwitch = new JComboBox(utsDot3Onu2CtcSipHeartbeatSwitchTList);

    private IntegerTextField tfUtsDot3Onu2CtcSipHeartbeatCycle = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcSipHeartbeatCount = new IntegerTextField();

    private StringTextField tfUtsDot3Onu2CtcSipDigitMap = new StringTextField();

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcSipMgPort = fStringMap.getString("utsDot3Onu2CtcSipMgPort") + ": ";
    private final String utsDot3Onu2CtcSipProxyServIp = fStringMap.getString("utsDot3Onu2CtcSipProxyServIp") + ": ";
    private final String utsDot3Onu2CtcSipProxyServComPort = fStringMap.getString("utsDot3Onu2CtcSipProxyServComPort") + ": ";
    private final String utsDot3Onu2CtcSipBackupProxyServIp = fStringMap.getString("utsDot3Onu2CtcSipBackupProxyServIp") + ": ";
    private final String utsDot3Onu2CtcSipBackupProxyServComPort = fStringMap.getString("utsDot3Onu2CtcSipBackupProxyServComPort") + ": ";
    private final String utsDot3Onu2CtcSipActiveProxyServ = fStringMap.getString("utsDot3Onu2CtcSipActiveProxyServ") + ": ";
    private final String utsDot3Onu2CtcSipRegServIp = fStringMap.getString("utsDot3Onu2CtcSipRegServIp") + ": ";
    private final String utsDot3Onu2CtcSipRegServComPort = fStringMap.getString("utsDot3Onu2CtcSipRegServComPort") + ": ";
    private final String utsDot3Onu2CtcSipBackupRegServIp = fStringMap.getString("utsDot3Onu2CtcSipBackupRegServIp") + ": ";
    private final String utsDot3Onu2CtcSipBackupRegServComPort = fStringMap.getString("utsDot3Onu2CtcSipBackupRegServComPort") + ": ";
    private final String utsDot3Onu2CtcSipOutBoundServIp = fStringMap.getString("utsDot3Onu2CtcSipOutBoundServIp") + ": ";
    private final String utsDot3Onu2CtcSipOutBoundServPort = fStringMap.getString("utsDot3Onu2CtcSipOutBoundServPort") + ": ";
    private final String utsDot3Onu2CtcSipRegInterval = fStringMap.getString("utsDot3Onu2CtcSipRegInterval") + ": ";
    private final String utsDot3Onu2CtcSipHeartbeatSwitch = fStringMap.getString("utsDot3Onu2CtcSipHeartbeatSwitch") + ": ";
    private final String utsDot3Onu2CtcSipHeartbeatCycle = fStringMap.getString("utsDot3Onu2CtcSipHeartbeatCycle") + ": ";
    private final String utsDot3Onu2CtcSipHeartbeatCount = fStringMap.getString("utsDot3Onu2CtcSipHeartbeatCount") + ": ";
    private final String utsDot3Onu2CtcSipDigitMap = fStringMap.getString("utsDot3Onu2CtcSipDigitMap") + ": ";

    public Onu2CtcCombinedFeaturesSipCfgPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(20, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesDeviceId));
        //baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcCombinedFeaturesLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipMgPort));
        tfUtsDot3Onu2CtcSipMgPort.setName(fStringMap.getString("utsDot3Onu2CtcSipMgPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipMgPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipProxyServIp));
        tfUtsDot3Onu2CtcSipProxyServIp.setName(fStringMap.getString("utsDot3Onu2CtcSipProxyServIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipProxyServIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipProxyServComPort));
        tfUtsDot3Onu2CtcSipProxyServComPort.setName(fStringMap.getString("utsDot3Onu2CtcSipProxyServComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipProxyServComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupProxyServIp));
        tfUtsDot3Onu2CtcSipBackupProxyServIp.setName(fStringMap.getString("utsDot3Onu2CtcSipBackupProxyServIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupProxyServIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupProxyServComPort));
        tfUtsDot3Onu2CtcSipBackupProxyServComPort.setName(fStringMap.getString("utsDot3Onu2CtcSipBackupProxyServComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupProxyServComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipActiveProxyServ));
        tfUtsDot3Onu2CtcSipActiveProxyServ.setName(fStringMap.getString("utsDot3Onu2CtcSipActiveProxyServ"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipActiveProxyServ);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegServIp));
        tfUtsDot3Onu2CtcSipRegServIp.setName(fStringMap.getString("utsDot3Onu2CtcSipRegServIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegServIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegServComPort));
        tfUtsDot3Onu2CtcSipRegServComPort.setName(fStringMap.getString("utsDot3Onu2CtcSipRegServComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegServComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupRegServIp));
        tfUtsDot3Onu2CtcSipBackupRegServIp.setName(fStringMap.getString("utsDot3Onu2CtcSipBackupRegServIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupRegServIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipBackupRegServComPort));
        tfUtsDot3Onu2CtcSipBackupRegServComPort.setName(fStringMap.getString("utsDot3Onu2CtcSipBackupRegServComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipBackupRegServComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipOutBoundServIp));
        tfUtsDot3Onu2CtcSipOutBoundServIp.setName(fStringMap.getString("utsDot3Onu2CtcSipOutBoundServIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipOutBoundServIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipOutBoundServPort));
        tfUtsDot3Onu2CtcSipOutBoundServPort.setName(fStringMap.getString("utsDot3Onu2CtcSipOutBoundServPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipOutBoundServPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipRegInterval));
        tfUtsDot3Onu2CtcSipRegInterval.setName(fStringMap.getString("utsDot3Onu2CtcSipRegInterval"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipRegInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatSwitch));
        tfUtsDot3Onu2CtcSipHeartbeatSwitch.setName(fStringMap.getString("utsDot3Onu2CtcSipHeartbeatSwitch"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatSwitch);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatCycle));
        tfUtsDot3Onu2CtcSipHeartbeatCycle.setName(fStringMap.getString("utsDot3Onu2CtcSipHeartbeatCycle"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatCycle);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipHeartbeatCount));
        tfUtsDot3Onu2CtcSipHeartbeatCount.setName(fStringMap.getString("utsDot3Onu2CtcSipHeartbeatCount"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipHeartbeatCount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcSipDigitMap));
        tfUtsDot3Onu2CtcSipDigitMap.setName(fStringMap.getString("utsDot3Onu2CtcSipDigitMap"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcSipDigitMap);
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
        tfUtsDot3Onu2CtcSipRegInterval.setValueScope(1, 65535);
        tfUtsDot3Onu2CtcSipHeartbeatCycle.setValueScope(10, 1800);
        tfUtsDot3Onu2CtcSipHeartbeatCount.setValueScope(1, 10);
    }

    public void refresh() {
        Onu2CtcCombinedFeaturesSipCfg mbean = (Onu2CtcCombinedFeaturesSipCfg) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

        tfUtsDot3Onu2CtcSipMgPort.setValue(mbean.getUtsDot3Onu2CtcSipMgPort().intValue());
        tfUtsDot3Onu2CtcSipProxyServIp.setValue(mbean.getUtsDot3Onu2CtcSipProxyServIp());
        tfUtsDot3Onu2CtcSipProxyServComPort.setValue(mbean.getUtsDot3Onu2CtcSipProxyServComPort().intValue());
        tfUtsDot3Onu2CtcSipBackupProxyServIp.setValue(mbean.getUtsDot3Onu2CtcSipBackupProxyServIp());
        tfUtsDot3Onu2CtcSipBackupProxyServComPort.setValue(mbean.getUtsDot3Onu2CtcSipBackupProxyServComPort().intValue());
        tfUtsDot3Onu2CtcSipActiveProxyServ.setValue(mbean.getUtsDot3Onu2CtcSipActiveProxyServ());
        tfUtsDot3Onu2CtcSipRegServIp.setValue(mbean.getUtsDot3Onu2CtcSipRegServIp());
        tfUtsDot3Onu2CtcSipRegServComPort.setValue(mbean.getUtsDot3Onu2CtcSipRegServComPort().intValue());
        tfUtsDot3Onu2CtcSipBackupRegServIp.setValue(mbean.getUtsDot3Onu2CtcSipBackupRegServIp());
        tfUtsDot3Onu2CtcSipBackupRegServComPort.setValue(mbean.getUtsDot3Onu2CtcSipBackupRegServComPort().intValue());
        tfUtsDot3Onu2CtcSipOutBoundServIp.setValue(mbean.getUtsDot3Onu2CtcSipOutBoundServIp());
        tfUtsDot3Onu2CtcSipOutBoundServPort.setValue(mbean.getUtsDot3Onu2CtcSipOutBoundServPort().intValue());
        tfUtsDot3Onu2CtcSipRegInterval.setValue(mbean.getUtsDot3Onu2CtcSipRegInterval().intValue());
        tfUtsDot3Onu2CtcSipHeartbeatSwitch.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcSipHeartbeatSwitchVList, mbean.getUtsDot3Onu2CtcSipHeartbeatSwitch().intValue()));
        tfUtsDot3Onu2CtcSipHeartbeatCycle.setValue(mbean.getUtsDot3Onu2CtcSipHeartbeatCycle().intValue());
        tfUtsDot3Onu2CtcSipHeartbeatCount.setValue(mbean.getUtsDot3Onu2CtcSipHeartbeatCount().intValue());
        tfUtsDot3Onu2CtcSipDigitMap.setValue(mbean.getUtsDot3Onu2CtcSipDigitMap());
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesSipCfg mbean = (Onu2CtcCombinedFeaturesSipCfg) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcSipMgPort(new Integer(tfUtsDot3Onu2CtcSipMgPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipProxyServIp(tfUtsDot3Onu2CtcSipProxyServIp.getIPString());
        mbean.setUtsDot3Onu2CtcSipProxyServComPort(new Integer(tfUtsDot3Onu2CtcSipProxyServComPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipBackupProxyServIp(new String(tfUtsDot3Onu2CtcSipBackupProxyServIp.getIPString()));
        mbean.setUtsDot3Onu2CtcSipBackupProxyServComPort(new Integer(tfUtsDot3Onu2CtcSipBackupProxyServComPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipActiveProxyServ(new String(tfUtsDot3Onu2CtcSipActiveProxyServ.getIPString()));
        mbean.setUtsDot3Onu2CtcSipRegServIp(new String(tfUtsDot3Onu2CtcSipRegServIp.getIPString()));
        mbean.setUtsDot3Onu2CtcSipRegServComPort(new Integer(tfUtsDot3Onu2CtcSipRegServComPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipBackupRegServIp(new String(tfUtsDot3Onu2CtcSipBackupRegServIp.getIPString()));
        mbean.setUtsDot3Onu2CtcSipBackupRegServComPort(new Integer(tfUtsDot3Onu2CtcSipBackupRegServComPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipOutBoundServIp(new String(tfUtsDot3Onu2CtcSipOutBoundServIp.getIPString()));
        mbean.setUtsDot3Onu2CtcSipOutBoundServPort(new Integer(tfUtsDot3Onu2CtcSipOutBoundServPort.getValue()));
        mbean.setUtsDot3Onu2CtcSipRegInterval(new Integer(tfUtsDot3Onu2CtcSipRegInterval.getValue()));
        mbean.setUtsDot3Onu2CtcSipHeartbeatSwitch(new Integer(utsDot3Onu2CtcSipHeartbeatSwitchVList[tfUtsDot3Onu2CtcSipHeartbeatSwitch.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcSipHeartbeatCycle(new Integer(tfUtsDot3Onu2CtcSipHeartbeatCycle.getValue()));
        mbean.setUtsDot3Onu2CtcSipHeartbeatCount(new Integer(tfUtsDot3Onu2CtcSipHeartbeatCount.getValue()));
        mbean.setUtsDot3Onu2CtcSipDigitMap(new String(tfUtsDot3Onu2CtcSipDigitMap.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}