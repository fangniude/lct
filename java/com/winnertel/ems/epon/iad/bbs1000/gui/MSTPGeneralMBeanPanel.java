package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs4000.mib.MSTPGeneralMBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MSTPGeneralMBeanPanel extends UPanel {

    private IntegerTextField tfMstpGenBridgeMaxAge = new IntegerTextField();
    private IntegerTextField tfMstpGenBridgeHelloTime = new IntegerTextField();
    private IntegerTextField tfMstpGenBridgeForwardDelay = new IntegerTextField();
    private JLabel tfMstpGenMaxAge = new JLabel();
    private JLabel tfMstpGenHelloTime = new JLabel();
    private JLabel tfMstpGenForwardDelay = new JLabel();
    private IntegerTextField tfMstpGenMaxHops = new IntegerTextField();
    //private IntegerTextField tfMstpGenHoldTime = new IntegerTextField();
    //private IntegerTextField tfMstpGenMigrateTime = new IntegerTextField();

    /*
    private int[] mstpGenPathCostDefaultVList = new int[]{1, 2,};
    private String[] mstpGenPathCostDefaultTList = new String[]{
            fStringMap.getString("pathCostDefault8021d1998"),
            fStringMap.getString("pathCostDefault8021t2001"),
    };
    private JComboBox tfMstpGenPathCostDefault = new JComboBox(mstpGenPathCostDefaultTList);
    */
    //private int[] mstpGenPathCostDefaultVList_rstp = new int[]{1, 2,};
    private int[] mstpGenPathCostDefaultVList_rstp = new int[]{2,};
    private String[] mstpGenPathCostDefaultTList_rstp = new String[]{
            //fStringMap.getString("pathCostDefault8021d1998"),
            fStringMap.getString("pathCostDefault8021t2001"),
    };
    private int[] mstpGenPathCostDefaultVList_mstp = new int[]{2,};
    private String[] mstpGenPathCostDefaultTList_mstp = new String[]{
            fStringMap.getString("pathCostDefault8021t2001"),
    };
    private JComboBox tfMstpGenPathCostDefault = new JComboBox();

    private int[] mstpGenCapableVList = new int[]{6, 0, 1, 2, 3, 4, 5,};
    private String[] mstpGenCapableTList = new String[]{
            fStringMap.getString("unknown"), //6
            fStringMap.getString("nonStp"), //0
            fStringMap.getString("dot1d1998"), //1
            fStringMap.getString("dot1w"), //2
            fStringMap.getString("dot1d2004"), //3
            fStringMap.getString("dot1s"), //4
            fStringMap.getString("dot1q"), //5
    };
    private JComboBox tfMstpGenCapable = new JComboBox(mstpGenCapableTList);

    private int[] mstpGenForceVersionVList = new int[]{0, 2, 3,};
    private String[] mstpGenForceVersionTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("RSTP"),
            fStringMap.getString("MSTP"),
    };
    private JComboBox tfMstpGenForceVersion = new JComboBox(mstpGenForceVersionTList);

    //private IntegerTextField tfMstpGenCfgIdFmtSel = new IntegerTextField();
    private StringTextField tfMstpGenCfgIdName = new StringTextField();
    private IntegerTextField tfMstpGenCfgIdRevLevel = new IntegerTextField();
    private JLabel tfMstpGenReginalRoot = new JLabel();
    private JLabel tfMstpGenExternalRootCost = new JLabel();

    private final String mstpGenBridgeMaxAge = fStringMap.getString("mstpGenBridgeMaxAge") + ": ";
    private final String mstpGenBridgeHelloTime = fStringMap.getString("mstpGenBridgeHelloTime") + ": ";
    private final String mstpGenBridgeForwardDelay = fStringMap.getString("mstpGenBridgeForwardDelay") + ": ";
    private final String mstpGenMaxAge = fStringMap.getString("mstpGenMaxAge") + ": ";
    private final String mstpGenHelloTime = fStringMap.getString("mstpGenHelloTime") + ": ";
    private final String mstpGenForwardDelay = fStringMap.getString("mstpGenForwardDelay") + ": ";
    private final String mstpGenMaxHops = fStringMap.getString("mstpGenMaxHops") + ": ";
    //private final String mstpGenHoldTime = fStringMap.getString("mstpGenHoldTime") + ": ";
    //private final String mstpGenMigrateTime = fStringMap.getString("mstpGenMigrateTime") + ": ";
    private final String mstpGenPathCostDefault = fStringMap.getString("mstpGenPathCostDefault") + ": ";
    private final String mstpGenCapable = fStringMap.getString("mstpGenCapable") + ": ";
    private final String mstpGenForceVersion = fStringMap.getString("mstpGenForceVersion") + ": ";
    //private final String mstpGenCfgIdFmtSel = fStringMap.getString("mstpGenCfgIdFmtSel") + ": ";
    private final String mstpGenCfgIdName = fStringMap.getString("mstpGenCfgIdName") + ": ";
    private final String mstpGenCfgIdRevLevel = fStringMap.getString("mstpGenCfgIdRevLevel") + ": ";
    private final String mstpGenReginalRoot = fStringMap.getString("mstpGenReginalRoot") + ": ";
    private final String mstpGenExternalRootCost = fStringMap.getString("mstpGenExternalRootCost") + ": ";

    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public MSTPGeneralMBeanPanel(IApplication app) {
        super(app);
        setModel(new MSTPGeneralMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_MSTPGeneralMBean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(18, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(mstpGenForceVersion));
        baseInfoPanel.add(tfMstpGenForceVersion);
        baseInfoPanel.add(new HSpacer());
        tfMstpGenForceVersion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 3) { //MSTP is enable.
                    tfMstpGenBridgeMaxAge.setEnabled(true);
                    tfMstpGenBridgeHelloTime.setEnabled(true);
                    tfMstpGenBridgeForwardDelay.setEnabled(true);
                    tfMstpGenMaxHops.setEnabled(true);
                    tfMstpGenPathCostDefault.removeAllItems();
                    for (int i = 0; i < mstpGenPathCostDefaultTList_mstp.length; i++)
                        tfMstpGenPathCostDefault.addItem(mstpGenPathCostDefaultTList_mstp[i]);
                    tfMstpGenPathCostDefault.setEnabled(true);
                    tfMstpGenCapable.setEnabled(true);
                    tfMstpGenCfgIdName.setEnabled(true);
                    tfMstpGenCfgIdRevLevel.setEnabled(true);
                } else if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 2) { //RSTP is enable.
                    tfMstpGenBridgeMaxAge.setEnabled(false);
                    tfMstpGenBridgeHelloTime.setEnabled(false);
                    tfMstpGenBridgeForwardDelay.setEnabled(false);
                    tfMstpGenMaxHops.setEnabled(false);
                    tfMstpGenPathCostDefault.removeAllItems();
                    for (int i = 0; i < mstpGenPathCostDefaultTList_rstp.length; i++)
                        tfMstpGenPathCostDefault.addItem(mstpGenPathCostDefaultTList_rstp[i]);
                    tfMstpGenPathCostDefault.setEnabled(true);
                    tfMstpGenCapable.setEnabled(false);
                    tfMstpGenCfgIdName.setEnabled(false);
                    tfMstpGenCfgIdRevLevel.setEnabled(false);
                } else {
                    tfMstpGenBridgeMaxAge.setEnabled(false);
                    tfMstpGenBridgeHelloTime.setEnabled(false);
                    tfMstpGenBridgeForwardDelay.setEnabled(false);
                    tfMstpGenMaxHops.setEnabled(false);
                    tfMstpGenPathCostDefault.removeAllItems();
                    tfMstpGenPathCostDefault.setEnabled(false);
                    tfMstpGenCapable.setEnabled(false);
                    tfMstpGenCfgIdName.setEnabled(false);
                    tfMstpGenCfgIdRevLevel.setEnabled(false);
                }
            }
        });

        baseInfoPanel.add(new JLabel(mstpGenBridgeMaxAge));
        tfMstpGenBridgeMaxAge.setName(fStringMap.getString("mstpGenBridgeMaxAge"));
        baseInfoPanel.add(tfMstpGenBridgeMaxAge);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenBridgeHelloTime));
        tfMstpGenBridgeHelloTime.setName(fStringMap.getString("mstpGenBridgeHelloTime"));
        baseInfoPanel.add(tfMstpGenBridgeHelloTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenBridgeForwardDelay));
        tfMstpGenBridgeForwardDelay.setName(fStringMap.getString("mstpGenBridgeForwardDelay"));
        baseInfoPanel.add(tfMstpGenBridgeForwardDelay);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenMaxAge));
        baseInfoPanel.add(tfMstpGenMaxAge);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenHelloTime));
        baseInfoPanel.add(tfMstpGenHelloTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenForwardDelay));
        baseInfoPanel.add(tfMstpGenForwardDelay);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenMaxHops));
        tfMstpGenMaxHops.setName(fStringMap.getString("mstpGenMaxHops"));
        baseInfoPanel.add(tfMstpGenMaxHops);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(mstpGenHoldTime));
        //tfMstpGenHoldTime.setName(fStringMap.getString("mstpGenHoldTime"));
        //baseInfoPanel.add(tfMstpGenHoldTime);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(mstpGenMigrateTime));
        //tfMstpGenMigrateTime.setName(fStringMap.getString("mstpGenMigrateTime"));
        //baseInfoPanel.add(tfMstpGenMigrateTime);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenPathCostDefault));
        tfMstpGenPathCostDefault.setName(fStringMap.getString("mstpGenPathCostDefault"));
        baseInfoPanel.add(tfMstpGenPathCostDefault);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenCapable));
        baseInfoPanel.add(tfMstpGenCapable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenCfgIdName));
        tfMstpGenCfgIdName.setName(fStringMap.getString("mstpGenCfgIdName"));
        baseInfoPanel.add(tfMstpGenCfgIdName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenCfgIdRevLevel));
        tfMstpGenCfgIdRevLevel.setName(fStringMap.getString("mstpGenCfgIdRevLevel"));
        baseInfoPanel.add(tfMstpGenCfgIdRevLevel);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenReginalRoot));
        baseInfoPanel.add(tfMstpGenReginalRoot);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mstpGenExternalRootCost));
        baseInfoPanel.add(tfMstpGenExternalRootCost);
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
        tfMstpGenBridgeMaxAge.setValueScope(6, 40);
        tfMstpGenBridgeHelloTime.setValueScope(1, 10);
        tfMstpGenBridgeForwardDelay.setValueScope(4, 30);
        tfMstpGenCfgIdName.setLenScope(0, 32);
        tfMstpGenMaxHops.setValueScope(4, 30);
        //tfMstpGenHoldTime.setValueScope(100, 1000);
        //tfMstpGenMigrateTime.setValueScope(100, 1000);
        tfMstpGenCfgIdRevLevel.setValueScope(0, 65535);
        //tfMstpGenCfgIdFmtSel.setValueScope(-2147483648, 2147483647);
        //tfMstpGenPathCostDefault.setEnabled(false);
        //tfMstpGenCapable.setEnabled(false);
    }

    public void refresh() {
        MSTPGeneralMBean mbean = (MSTPGeneralMBean) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfMstpGenBridgeMaxAge.setValue(mbean.getMstpGenBridgeMaxAge());
        tfMstpGenBridgeHelloTime.setValue(mbean.getMstpGenBridgeHelloTime());
        tfMstpGenBridgeForwardDelay.setValue(mbean.getMstpGenBridgeForwardDelay());
        tfMstpGenMaxAge.setText(mbean.getMstpGenMaxAge().toString());
        tfMstpGenHelloTime.setText(mbean.getMstpGenHelloTime().toString());
        tfMstpGenForwardDelay.setText(mbean.getMstpGenForwardDelay().toString());
        tfMstpGenMaxHops.setValue(mbean.getMstpGenMaxHops());
        //tfMstpGenHoldTime.setValue(mbean.getMstpGenHoldTime());
        //tfMstpGenMigrateTime.setValue(mbean.getMstpGenMigrateTime());

        tfMstpGenCapable.setSelectedIndex(getIndexFromValue(mstpGenCapableVList, mbean.getMstpGenCapable()));
        tfMstpGenForceVersion.setSelectedIndex(getIndexFromValue(mstpGenForceVersionVList, mbean.getMstpGenForceVersion()));
        //tfMstpGenCfgIdFmtSel.setValue(mbean.getMstpGenCfgIdFmtSel());

        if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 3) { //MSTP is enable.
            tfMstpGenPathCostDefault.setSelectedIndex(getIndexFromValue(mstpGenPathCostDefaultVList_mstp, mbean.getMstpGenPathCostDefault()));
        } else if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 2) { //RSTP is enable.
            tfMstpGenPathCostDefault.setSelectedIndex(getIndexFromValue(mstpGenPathCostDefaultVList_rstp, mbean.getMstpGenPathCostDefault()));
        }

        tfMstpGenCfgIdName.setValue(mbean.getMstpGenCfgIdName());
        tfMstpGenCfgIdRevLevel.setValue(mbean.getMstpGenCfgIdRevLevel());
        tfMstpGenReginalRoot.setText(mbean.getMstpGenReginalRoot());
        tfMstpGenExternalRootCost.setText(mbean.getMstpGenExternalRootCost().toString());
    }

    public boolean validateFrom() {
        if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 3) {
            int hellotime = tfMstpGenBridgeHelloTime.getValue();
            int maxage = tfMstpGenBridgeMaxAge.getValue();
            int delay = tfMstpGenBridgeForwardDelay.getValue();
            if (!(2 * (delay - 1) >= maxage)) {
                String error = fStringMap.getString("Err_Max_Age_Too_Large");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
            if (!(maxage >= 2 * (hellotime + 1))) {
                String error = fStringMap.getString("Err_Max_Age_Too_Less");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }

        return true;
    }

    public void updateModel() {
        MSTPGeneralMBean mbean = (MSTPGeneralMBean) getModel();
        if (mbean == null)
            return;

        mbean.setApplyChanged(true);
        mbean.setMstpGenForceVersion(mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()]);

        if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 3) { //MSTP is enable.
            mbean.setMstpGenBridgeMaxAge(tfMstpGenBridgeMaxAge.getValue() * 100);
            mbean.setMstpGenBridgeHelloTime(tfMstpGenBridgeHelloTime.getValue() * 100);
            mbean.setMstpGenBridgeForwardDelay(tfMstpGenBridgeForwardDelay.getValue() * 100);
            mbean.setMstpGenMaxHops(tfMstpGenMaxHops.getValue());
            //mbean.setMstpGenHoldTime(tfMstpGenHoldTime.getValue());
            //mbean.setMstpGenMigrateTime(tfMstpGenMigrateTime.getValue());
            //mbean.setMstpGenCfgIdFmtSel(tfMstpGenCfgIdFmtSel.getValue());

            if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 3) { //MSTP is enable.
                mbean.setMstpGenPathCostDefault(mstpGenPathCostDefaultVList_mstp[tfMstpGenPathCostDefault.getSelectedIndex()]);
            } else if (mstpGenForceVersionVList[tfMstpGenForceVersion.getSelectedIndex()] == 2) { //RSTP is enable.
                mbean.setMstpGenPathCostDefault(mstpGenPathCostDefaultVList_rstp[tfMstpGenPathCostDefault.getSelectedIndex()]);
            }

            mbean.setMstpGenCfgIdName(tfMstpGenCfgIdName.getValue());
            mbean.setMstpGenCfgIdRevLevel(tfMstpGenCfgIdRevLevel.getValue());
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}