package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.SystemConfigMB;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

//Modified by Zhou Chao, 2008/12/2
public class SystemConfigMBPanel extends UPanel {

    private LongTextField tfGponSysCfgFdbAgingTimer = new LongTextField();

    private int[] gponSysCfgIgmpProxyRoutingModeVList = new int[]{1, 2, 3, 4,};
    private String[] gponSysCfgIgmpProxyRoutingModeTList = new String[]{
            fStringMap.getString("standardDistributed"),
            fStringMap.getString("ctcDistributed"),
            fStringMap.getString("ctcCentralControlled"),
            fStringMap.getString("disabledIgmpProxy"),
    };
    private JComboBox tfGponSysCfgIgmpProxyRoutingMode = new JComboBox(gponSysCfgIgmpProxyRoutingModeTList);

    private int[] gponSysCfgAuthenticationMethodVList = new int[]{1, 2, 3,};
    private String[] gponSysCfgAuthenticationMethodTList = new String[]{
            fStringMap.getString("snOnly"),
            fStringMap.getString("snAndPassword"),
            fStringMap.getString("disabledAuthenticationMethod"),
    };
    private JComboBox tfGponSysCfgAuthenticationMethod = new JComboBox(gponSysCfgAuthenticationMethodTList);

    private int[] gponSysCfgEncryptionModeVList = new int[]{1, 2,};
    private String[] gponSysCfgEncryptionModeTList = new String[]{
            fStringMap.getString("enableEncryptionMode"),
            fStringMap.getString("disableEncryptionMode"),
    };
    private JComboBox tfGponSysCfgEncryptionMode = new JComboBox(gponSysCfgEncryptionModeTList);

    private LongTextField tfGponSysCfgKeyExchangeInterval = new LongTextField();
    private LongTextField tfGponSysCfgDownstreamBroadcastGEMPortNo = new LongTextField();

    private final String gponSysCfgFdbAgingTimer = fStringMap.getString("gponSysCfgFdbAgingTimer") + ": ";
    private final String gponSysCfgIgmpProxyRoutingMode = fStringMap.getString("gponSysCfgIgmpProxyRoutingMode") + ": ";
    private final String gponSysCfgAuthenticationMethod = fStringMap.getString("gponSysCfgAuthenticationMethod") + ": ";
    private final String gponSysCfgEncryptionMode = fStringMap.getString("gponSysCfgEncryptionMode") + ": ";
    private final String gponSysCfgKeyExchangeInterval = fStringMap.getString("gponSysCfgKeyExchangeInterval") + ": ";
    private final String gponSysCfgDownstreamBroadcastGEMPortNo = fStringMap.getString("gponSysCfgDownstreamBroadcastGEMPortNo") + ": ";

    private SnmpApplyButton btApply = null;
    private SnmpRefreshButton btRefresh = null;

    public SystemConfigMBPanel(IApplication app) {
        super(app);
        setModel(new SystemConfigMB(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_SystemConfigMB");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(gponSysCfgFdbAgingTimer));
        tfGponSysCfgFdbAgingTimer.setName(fStringMap.getString("gponSysCfgFdbAgingTimer"));
        baseInfoPanel.add(tfGponSysCfgFdbAgingTimer);
        tfGponSysCfgFdbAgingTimer.setValue(300000);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(gponSysCfgIgmpProxyRoutingMode));
        tfGponSysCfgIgmpProxyRoutingMode.setName(fStringMap.getString("gponSysCfgIgmpProxyRoutingMode"));
        tfGponSysCfgIgmpProxyRoutingMode.setSelectedIndex(getIndexFromValue(gponSysCfgIgmpProxyRoutingModeVList, 2));
        baseInfoPanel.add(tfGponSysCfgIgmpProxyRoutingMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(gponSysCfgAuthenticationMethod));
        tfGponSysCfgAuthenticationMethod.setName(fStringMap.getString("gponSysCfgAuthenticationMethod"));
        tfGponSysCfgAuthenticationMethod.setSelectedIndex(getIndexFromValue(gponSysCfgAuthenticationMethodVList, 3));
        baseInfoPanel.add(tfGponSysCfgAuthenticationMethod);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(gponSysCfgEncryptionMode));
        tfGponSysCfgEncryptionMode.setName(fStringMap.getString("gponSysCfgEncryptionMode"));
        baseInfoPanel.add(tfGponSysCfgEncryptionMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(gponSysCfgKeyExchangeInterval));
        tfGponSysCfgKeyExchangeInterval.setName(fStringMap.getString("gponSysCfgKeyExchangeInterval"));
        tfGponSysCfgKeyExchangeInterval.setValue(3600);
        baseInfoPanel.add(tfGponSysCfgKeyExchangeInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(gponSysCfgDownstreamBroadcastGEMPortNo));
        tfGponSysCfgDownstreamBroadcastGEMPortNo.setName(fStringMap.getString("gponSysCfgDownstreamBroadcastGEMPortNo"));
        baseInfoPanel.add(tfGponSysCfgDownstreamBroadcastGEMPortNo);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
        tfGponSysCfgFdbAgingTimer.setValueScope(100, 864000000);
        tfGponSysCfgKeyExchangeInterval.setValueScope(30, 26000);
        tfGponSysCfgDownstreamBroadcastGEMPortNo.setValueScope(3600, 3799);
    }

    public void refresh() {
        SystemConfigMB mbean = (SystemConfigMB) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfGponSysCfgFdbAgingTimer.setEnabled(mbean.getGponSysCfgFdbAgingTimer() != null);
        tfGponSysCfgFdbAgingTimer.setValue(mbean.getGponSysCfgFdbAgingTimer());

        tfGponSysCfgIgmpProxyRoutingMode.setEnabled(mbean.getGponSysCfgIgmpProxyRoutingMode() != null);
        tfGponSysCfgIgmpProxyRoutingMode.setSelectedIndex(getIndexFromValue(gponSysCfgIgmpProxyRoutingModeVList, mbean.getGponSysCfgIgmpProxyRoutingMode()));

        tfGponSysCfgAuthenticationMethod.setEnabled(mbean.getGponSysCfgAuthenticationMethod() != null);
        tfGponSysCfgAuthenticationMethod.setSelectedIndex(getIndexFromValue(gponSysCfgAuthenticationMethodVList, mbean.getGponSysCfgAuthenticationMethod()));

        tfGponSysCfgEncryptionMode.setEnabled(mbean.getGponSysCfgEncryptionMode() != null);
        tfGponSysCfgEncryptionMode.setSelectedIndex(getIndexFromValue(gponSysCfgEncryptionModeVList, mbean.getGponSysCfgEncryptionMode()));

        tfGponSysCfgKeyExchangeInterval.setEnabled(mbean.getGponSysCfgKeyExchangeInterval() != null);
        tfGponSysCfgKeyExchangeInterval.setValue(mbean.getGponSysCfgKeyExchangeInterval());

        tfGponSysCfgDownstreamBroadcastGEMPortNo.setEnabled(mbean.getGponSysCfgDownstreamBroadcastGEMPortNo() != null);
        tfGponSysCfgDownstreamBroadcastGEMPortNo.setValue(mbean.getGponSysCfgDownstreamBroadcastGEMPortNo());
    }

    public void updateModel() {
        SystemConfigMB mbean = (SystemConfigMB) getModel();
        if (mbean == null)
            return;

        if (tfGponSysCfgFdbAgingTimer.isEnabled())
            mbean.setGponSysCfgFdbAgingTimer(tfGponSysCfgFdbAgingTimer.getValue());

        if (tfGponSysCfgIgmpProxyRoutingMode.isEnabled())
            mbean.setGponSysCfgIgmpProxyRoutingMode(gponSysCfgIgmpProxyRoutingModeVList[tfGponSysCfgIgmpProxyRoutingMode.getSelectedIndex()]);

        if (tfGponSysCfgAuthenticationMethod.isEnabled())
            mbean.setGponSysCfgAuthenticationMethod(gponSysCfgAuthenticationMethodVList[tfGponSysCfgAuthenticationMethod.getSelectedIndex()]);

        if (tfGponSysCfgEncryptionMode.isEnabled())
            mbean.setGponSysCfgEncryptionMode(gponSysCfgEncryptionModeVList[tfGponSysCfgEncryptionMode.getSelectedIndex()]);

        if (tfGponSysCfgKeyExchangeInterval.isEnabled())
            mbean.setGponSysCfgKeyExchangeInterval(tfGponSysCfgKeyExchangeInterval.getValue());

        if (tfGponSysCfgDownstreamBroadcastGEMPortNo.isEnabled())
            mbean.setGponSysCfgDownstreamBroadcastGEMPortNo(tfGponSysCfgDownstreamBroadcastGEMPortNo.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}