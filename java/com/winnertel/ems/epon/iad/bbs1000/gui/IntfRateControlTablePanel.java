/**
 * Modified by Zhou Chao
 */

package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.IntfRateControlTable;

import javax.swing.*;
import java.awt.*;

public class IntfRateControlTablePanel extends UPanel {

    private JLabel tfUtsIntfRateControlId = new JLabel();

    private int[] utsIntfRateControlMcastEnableVList = new int[]{2, 1,};
    private String[] utsIntfRateControlMcastEnableTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfUtsIntfRateControlMcastEnable = new JComboBox(utsIntfRateControlMcastEnableTList);

    private IntegerTextField tfUtsIntfRateControlMcastLimit = new IntegerTextField();

    private int[] utsIntfRateControlBcastEnableVList = new int[]{2, 1,};
    private String[] utsIntfRateControlBcastEnableTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfUtsIntfRateControlBcastEnable = new JComboBox(utsIntfRateControlBcastEnableTList);

    private IntegerTextField tfUtsIntfRateControlBcastLimit = new IntegerTextField();

    private int[] utsIntfRateControlUnicastEnableVList = new int[]{2, 1,};
    private String[] utsIntfRateControlUnicastEnableTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfUtsIntfRateControlUnicastEnable = new JComboBox(utsIntfRateControlUnicastEnableTList);

    private IntegerTextField tfUtsIntfRateControlUnicastLimit = new IntegerTextField();

    private IntegerTextField tfUtsIntfRateLimitIngressBandwidth = new IntegerTextField();
    private IntegerTextField tfUtsIntfRateLimitEgressBandwidth = new IntegerTextField();

    private int[] utsIntfRateControlIsolationCtrlVList = new int[]{2, 1,};
    private String[] utsIntfRateControlIsolationCtrlTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsIntfRateControlIsolationCtrl = new JComboBox(utsIntfRateControlIsolationCtrlTList);

    private int[] utsIntfRateControlUplinkSpeedVList = new int[]{10, 100, 1000,};
    private String[] utsIntfRateControlUplinkSpeedTList = new String[]{
            fStringMap.getString("ten-mega"),
            fStringMap.getString("hundred-mega"),
            fStringMap.getString("giga-mega"),
    };
    private JComboBox tfUtsIntfRateControlUplinkSpeed = new JComboBox(utsIntfRateControlUplinkSpeedTList);

    private int[] utsIntfRateControlVlanIngressFilterVList = new int[]{2, 1,};
    private String[] utsIntfRateControlVlanIngressFilterTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsIntfRateControlVlanIngressFilter = new JComboBox(utsIntfRateControlVlanIngressFilterTList);

    private int[] utsIntfRateControlAutoNegotiationVList = new int[]{2, 1,};
    private String[] utsIntfRateControlAutoNegotiationTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable"),
    };
    private JComboBox tfUtsIntfRateControlAutoNegotiation = new JComboBox(utsIntfRateControlAutoNegotiationTList);

    private int[] utsIntfRateLimitIngressBurstSizeVList = new int[]{4, 8, 16, 32, 64, 128, 256, 512};
    private String[] utsIntfRateLimitIngressBurstSizeTList = new String[]{"4", "8", "16", "32", "64", "128", "256", "512"};
    private JComboBox tfUtsIntfRateLimitIngressBurstSize = new JComboBox(utsIntfRateLimitIngressBurstSizeTList);

    private int[] utsIntfRateLimitEgressBurstSizeVList = new int[]{4, 8, 16, 32, 64, 128, 256, 512};
    private String[] utsIntfRateLimitEgressBurstSizeTList = new String[]{"4", "8", "16", "32", "64", "128", "256", "512"};
    private JComboBox tfUtsIntfRateLimitEgressBurstSize = new JComboBox(utsIntfRateLimitEgressBurstSizeTList);

    private final String utsIntfRateControlId = fStringMap.getString("InterfaceIndex") + ": ";
    private final String utsIntfRateControlMcastEnable = fStringMap.getString("utsIntfRateControlMcastEnable") + ": ";
    private final String utsIntfRateControlMcastLimit = fStringMap.getString("utsIntfRateControlMcastLimit") + ": ";
    private final String utsIntfRateControlBcastEnable = fStringMap.getString("utsIntfRateControlBcastEnable") + ": ";
    private final String utsIntfRateControlBcastLimit = fStringMap.getString("utsIntfRateControlBcastLimit") + ": ";
    private final String utsIntfRateControlUnicastEnable = fStringMap.getString("utsIntfRateControlUnicastEnable") + ": ";
    private final String utsIntfRateControlUnicastLimit = fStringMap.getString("utsIntfRateControlUnicastLimit") + ": ";
    private final String utsIntfRateLimitIngressBandwidth = fStringMap.getString("utsIntfRateLimitIngressBandwidth") + ": ";
    private final String utsIntfRateLimitEgressBandwidth = fStringMap.getString("utsIntfRateLimitEgressBandwidth") + ": ";
    private final String utsIntfRateControlIsolationCtrl = fStringMap.getString("utsIntfRateControlIsolationCtrl") + ": ";
    private final String utsIntfRateControlUplinkSpeed = fStringMap.getString("utsIntfRateControlUplinkSpeed") + ": ";
    private final String utsIntfRateControlVlanIngressFilter = fStringMap.getString("utsIntfRateControlVlanIngressFilter") + ": ";
    private final String utsIntfRateControlAutoNegotiation = fStringMap.getString("utsIntfRateControlAutoNegotiation") + ": ";
    private final String utsIntfRateLimitIngressBurstSize = fStringMap.getString("utsIntfRateLimitIngressBurstSize") + ": ";
    private final String utsIntfRateLimitEgressBurstSize = fStringMap.getString("utsIntfRateLimitEgressBurstSize") + ": ";

    public IntfRateControlTablePanel(IApplication app) {
        super(app);
        setModel(new IntfRateControlTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsIntfRateControlId));
        baseInfoPanel.add(tfUtsIntfRateControlId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlMcastEnable));
        tfUtsIntfRateControlMcastEnable.setName(fStringMap.getString("utsIntfRateControlMcastEnable"));
        baseInfoPanel.add(tfUtsIntfRateControlMcastEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlMcastLimit));
        tfUtsIntfRateControlMcastLimit.setName(fStringMap.getString("utsIntfRateControlMcastLimit"));
        baseInfoPanel.add(tfUtsIntfRateControlMcastLimit);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlBcastEnable));
        tfUtsIntfRateControlBcastEnable.setName(fStringMap.getString("utsIntfRateControlBcastEnable"));
        baseInfoPanel.add(tfUtsIntfRateControlBcastEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlBcastLimit));
        tfUtsIntfRateControlBcastLimit.setName(fStringMap.getString("utsIntfRateControlBcastLimit"));
        baseInfoPanel.add(tfUtsIntfRateControlBcastLimit);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlUnicastEnable));
        tfUtsIntfRateControlUnicastEnable.setName(fStringMap.getString("utsIntfRateControlUnicastEnable"));
        baseInfoPanel.add(tfUtsIntfRateControlUnicastEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlUnicastLimit));
        tfUtsIntfRateControlUnicastLimit.setName(fStringMap.getString("utsIntfRateControlUnicastLimit"));
        baseInfoPanel.add(tfUtsIntfRateControlUnicastLimit);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateLimitIngressBandwidth));
        tfUtsIntfRateLimitIngressBandwidth.setName(fStringMap.getString("utsIntfRateLimitIngressBandwidth"));
        baseInfoPanel.add(tfUtsIntfRateLimitIngressBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateLimitEgressBandwidth));
        tfUtsIntfRateLimitEgressBandwidth.setName(fStringMap.getString("utsIntfRateLimitEgressBandwidth"));
        baseInfoPanel.add(tfUtsIntfRateLimitEgressBandwidth);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlIsolationCtrl));
        tfUtsIntfRateControlIsolationCtrl.setName(fStringMap.getString("utsIntfRateControlIsolationCtrl"));
        baseInfoPanel.add(tfUtsIntfRateControlIsolationCtrl);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlUplinkSpeed));
        tfUtsIntfRateControlUplinkSpeed.setName(fStringMap.getString("utsIntfRateControlUplinkSpeed"));
        baseInfoPanel.add(tfUtsIntfRateControlUplinkSpeed);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlVlanIngressFilter));
        tfUtsIntfRateControlVlanIngressFilter.setName(fStringMap.getString("utsIntfRateControlVlanIngressFilter"));
        baseInfoPanel.add(tfUtsIntfRateControlVlanIngressFilter);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateControlAutoNegotiation));
        tfUtsIntfRateControlAutoNegotiation.setName(fStringMap.getString("utsIntfRateControlAutoNegotiation"));
        baseInfoPanel.add(tfUtsIntfRateControlAutoNegotiation);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateLimitIngressBurstSize));
        tfUtsIntfRateLimitIngressBurstSize.setName(fStringMap.getString("utsIntfRateLimitIngressBurstSize"));
        baseInfoPanel.add(tfUtsIntfRateLimitIngressBurstSize);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIntfRateLimitEgressBurstSize));
        tfUtsIntfRateLimitEgressBurstSize.setName(fStringMap.getString("utsIntfRateLimitEgressBurstSize"));
        baseInfoPanel.add(tfUtsIntfRateLimitEgressBurstSize);
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
        tfUtsIntfRateControlMcastLimit.setValueScope(0, 10000);
        tfUtsIntfRateControlBcastLimit.setValueScope(0, 10000);
        tfUtsIntfRateControlUnicastLimit.setValueScope(0, 10000);
        tfUtsIntfRateLimitIngressBandwidth.setValueScope(1, 1000);
        tfUtsIntfRateLimitEgressBandwidth.setValueScope(1, 1000);
    }

    public void refresh() {
        IntfRateControlTable mbean = (IntfRateControlTable) getModel();
        if (mbean == null)
            return;

        tfUtsIntfRateControlId.setText(mbean.getUtsIntfRateControlModuleId().toString() + "/" + mbean.getUtsIntfRateControlPortId().toString());
        tfUtsIntfRateControlMcastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlMcastEnableVList, mbean.getUtsIntfRateControlMcastEnable()));
        tfUtsIntfRateControlMcastLimit.setValue(mbean.getUtsIntfRateControlMcastLimit());
        tfUtsIntfRateControlBcastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlBcastEnableVList, mbean.getUtsIntfRateControlBcastEnable()));
        tfUtsIntfRateControlBcastLimit.setValue(mbean.getUtsIntfRateControlBcastLimit());
        tfUtsIntfRateControlUnicastEnable.setSelectedIndex(getIndexFromValue(utsIntfRateControlUnicastEnableVList, mbean.getUtsIntfRateControlUnicastEnable()));
        tfUtsIntfRateControlUnicastLimit.setValue(mbean.getUtsIntfRateControlUnicastLimit());
        tfUtsIntfRateLimitIngressBandwidth.setValue(mbean.getUtsIntfRateLimitIngressBandwidth());
        tfUtsIntfRateLimitEgressBandwidth.setValue(mbean.getUtsIntfRateLimitEgressBandwidth());
        tfUtsIntfRateControlIsolationCtrl.setSelectedIndex(getIndexFromValue(utsIntfRateControlIsolationCtrlVList, mbean.getUtsIntfRateControlIsolationCtrl()));
        tfUtsIntfRateControlUplinkSpeed.setSelectedIndex(getIndexFromValue(utsIntfRateControlUplinkSpeedVList, mbean.getUtsIntfRateControlUplinkSpeed()));
        tfUtsIntfRateControlVlanIngressFilter.setSelectedIndex(getIndexFromValue(utsIntfRateControlVlanIngressFilterVList, mbean.getUtsIntfRateControlVlanIngressFilter()));
        tfUtsIntfRateControlAutoNegotiation.setSelectedIndex(getIndexFromValue(utsIntfRateControlAutoNegotiationVList, mbean.getUtsIntfRateControlAutoNegotiation()));
        tfUtsIntfRateLimitIngressBurstSize.setSelectedIndex(getIndexFromValue(utsIntfRateLimitIngressBurstSizeVList, mbean.getUtsIntfRateLimitIngressBurstSize()));
        tfUtsIntfRateLimitEgressBurstSize.setSelectedIndex(getIndexFromValue(utsIntfRateLimitEgressBurstSizeVList, mbean.getUtsIntfRateLimitEgressBurstSize()));

        int moduleId = mbean.getUtsIntfRateControlModuleId();
        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        bean.setUtsEponModuleBoardPhyId(moduleId);
        BeanService.refreshBean(fApplication, bean);
        int moduleType = (bean.getUtsEponModuleBoardType() != null) ? bean.getUtsEponModuleBoardType() : -1;
        BaseModuleType fModuleType = new ModuleType();
        if (fModuleType.isGSMModule(moduleType)) {
            tfUtsIntfRateControlIsolationCtrl.setEnabled(false);
            tfUtsIntfRateControlUplinkSpeed.setEnabled(true);
            tfUtsIntfRateControlAutoNegotiation.setEnabled(true);
        } else {
            tfUtsIntfRateControlIsolationCtrl.setEnabled(true);
            tfUtsIntfRateControlUplinkSpeed.setEnabled(false);
            tfUtsIntfRateControlAutoNegotiation.setEnabled(false);
        }
    }

    public void updateModel() {
        IntfRateControlTable mbean = (IntfRateControlTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsIntfRateControlMcastEnable(utsIntfRateControlMcastEnableVList[tfUtsIntfRateControlMcastEnable.getSelectedIndex()]);
        mbean.setUtsIntfRateControlMcastLimit(tfUtsIntfRateControlMcastLimit.getValue());
        mbean.setUtsIntfRateControlBcastEnable(utsIntfRateControlBcastEnableVList[tfUtsIntfRateControlBcastEnable.getSelectedIndex()]);
        mbean.setUtsIntfRateControlBcastLimit(tfUtsIntfRateControlBcastLimit.getValue());
        mbean.setUtsIntfRateControlUnicastEnable(utsIntfRateControlUnicastEnableVList[tfUtsIntfRateControlUnicastEnable.getSelectedIndex()]);
        mbean.setUtsIntfRateControlUnicastLimit(tfUtsIntfRateControlUnicastLimit.getValue());
        mbean.setUtsIntfRateLimitIngressBandwidth(tfUtsIntfRateLimitIngressBandwidth.getValue());
        mbean.setUtsIntfRateLimitEgressBandwidth(tfUtsIntfRateLimitEgressBandwidth.getValue());

        if (tfUtsIntfRateControlIsolationCtrl.isEnabled()) {
            mbean.setUtsIntfRateControlIsolationCtrl(utsIntfRateControlIsolationCtrlVList[tfUtsIntfRateControlIsolationCtrl.getSelectedIndex()]);
        }

        if (tfUtsIntfRateControlUplinkSpeed.isEnabled()) {
            mbean.setUtsIntfRateControlUplinkSpeed(utsIntfRateControlUplinkSpeedVList[tfUtsIntfRateControlUplinkSpeed.getSelectedIndex()]);
        }
        mbean.setUtsIntfRateControlVlanIngressFilter(utsIntfRateControlVlanIngressFilterVList[tfUtsIntfRateControlVlanIngressFilter.getSelectedIndex()]);

        if (tfUtsIntfRateControlAutoNegotiation.isEnabled()) {
            mbean.setUtsIntfRateControlAutoNegotiation(utsIntfRateControlAutoNegotiationVList[tfUtsIntfRateControlAutoNegotiation.getSelectedIndex()]);
        }

        mbean.setUtsIntfRateLimitIngressBurstSize(utsIntfRateLimitIngressBurstSizeVList[tfUtsIntfRateLimitIngressBurstSize.getSelectedIndex()]);
        mbean.setUtsIntfRateLimitEgressBurstSize(utsIntfRateLimitEgressBurstSizeVList[tfUtsIntfRateLimitEgressBurstSize.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}