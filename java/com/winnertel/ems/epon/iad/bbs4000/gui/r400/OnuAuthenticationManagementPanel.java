/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuAuthenticationPolicyMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuAuthenticationManagementPanel extends UPanel {
//Value list:	1: acceptAll(1)
//	2: rejectNotConfigured(2)\
    private int[] onuAuthenticationPolicyVList = new int[] {1, 2};
    private String[] onuAuthenticationPolicyTList = new String[] {
            fStringMap.getString("acceptAll"), fStringMap.getString("rejectNotConfigured")
    };
    private JComboBox tfOnuAuthenticationPolicy = new JComboBox(onuAuthenticationPolicyTList);

    private final String onuAuthenticationPolicy = fStringMap.getString("onuAuthenticationPolicy") + " : ";

    private SnmpApplyButton btApply = null;
    private SnmpRefreshButton btRefresh = null;

    private SnmpTablePane tablepanel1;
    private JPanel baseInfoPanel;

    public OnuAuthenticationManagementPanel(IApplication app) {
        super(app);
        setModel(new OnuAuthenticationPolicyMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_Authentication_Policy")));

        baseInfoPanel.add(new JLabel(onuAuthenticationPolicy));
        tfOnuAuthenticationPolicy.setName(fStringMap.getString("onuAuthenticationPolicy"));
        baseInfoPanel.add(tfOnuAuthenticationPolicy);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(5, 1, NTLayout.FILL, NTLayout.CENTER, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(buttonsPanel);
        allPanel.add(new VSpacer());

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane("ONU_Authentication_Pre_Config");
        tablepanel1.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_Authentication_Pre_Config")));
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
        OnuAuthenticationPolicyMBean mbean = (OnuAuthenticationPolicyMBean) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        if (mbean.getOnuAuthenticationPolicy() != null)
            tfOnuAuthenticationPolicy.setSelectedIndex(getIndexFromValue(onuAuthenticationPolicyVList, mbean.getOnuAuthenticationPolicy()));

        tablepanel1.refresh();
    }

    public void updateModel() {
        OnuAuthenticationPolicyMBean mbean = (OnuAuthenticationPolicyMBean) getModel();
        if (mbean == null)
            return;

        mbean.setOnuAuthenticationPolicy(onuAuthenticationPolicyVList[tfOnuAuthenticationPolicy.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}