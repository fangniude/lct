/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuMiscConfigureMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class GponOnuMiscConfigureSetupPanel extends UPanel {

    //------------------- MIB items -------------------
    private JLabel tfOnuCfgSlotNo = new JLabel();
    private JLabel tfOnuCfgPortNo = new JLabel();
    private JLabel tfOnuCfgLogicalPortNo = new JLabel();

    private LongTextField tfOnuCfgBerIntervalConfiguration = new LongTextField();
    /*
    private JLabel tfOnuCfgPowerLevel = new JLabel();

    private int[] onuCfgTrafficManagementOptionVList = new int[]{0, 1,};
    private String[] onuCfgTrafficManagementOptionTList = new String[]{
            fStringMap.getString("priorityControlledAndFlexiblyScheduledUpstreamTraffic"),
            fStringMap.getString("rateControlledUpstreamTraffic"),
    };
    private JComboBox tfOnuCfgTrafficManagementOption = new JComboBox(onuCfgTrafficManagementOptionTList);
    */

    private int[] onuCfgBatteryBackupVList = new int[]{1, 2,};
    private String[] onuCfgBatteryBackupTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOnuCfgBatteryBackup = new JComboBox(onuCfgBatteryBackupTList);

    /*
    private JLabel tfOnuCfgTotalPriorityQueueNumber = new JLabel();
    private JLabel tfOnuCfgTotalTrafficSchedulerNumber = new JLabel();
    private JLabel tfOnuCfgTotalGEMPortNumber = new JLabel();
    private JLabel tfOnuCfgTotalTCONTNumber = new JLabel();
    private JLabel tfOnuCfgTotalEthernetUNINumber = new JLabel();
    private JLabel tfOnuCfgTotalPOTSUNINumber = new JLabel();
    */

    private int[] onuCfgFecTxEnableVList = new int[]{2, 1,};
    private String[] onuCfgFecTxEnableTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };
    private JComboBox tfOnuCfgFecTxEnable = new JComboBox(onuCfgFecTxEnableTList);

    /*
    private IntegerTextField tfOnuCfgPiggybackDbaRep = new IntegerTextField();
    private IntegerTextField tfOnuCfgWholeOnuDbaRep = new IntegerTextField();
    */

    private final String onuCfgSlotNo = fStringMap.getString("onuCfgSlotNo") + ": ";
    private final String onuCfgPortNo = fStringMap.getString("onuCfgPortNo") + ": ";
    private final String onuCfgLogicalPortNo = fStringMap.getString("onuCfgLogicalPortNo") + ": ";
    private final String onuCfgBerIntervalConfiguration = fStringMap.getString("onuCfgBerIntervalConfiguration") + ": ";
    //private final String onuCfgPowerLevel = fStringMap.getString("onuCfgPowerLevel") + ": ";
    //private final String onuCfgTrafficManagementOption = fStringMap.getString("onuCfgTrafficManagementOption") + ": ";
    private final String onuCfgBatteryBackup = fStringMap.getString("onuCfgBatteryBackup") + ": ";
    /*
    private final String onuCfgTotalPriorityQueueNumber = fStringMap.getString("onuCfgTotalPriorityQueueNumber") + ": ";
    private final String onuCfgTotalTrafficSchedulerNumber = fStringMap.getString("onuCfgTotalTrafficSchedulerNumber") + ": ";
    private final String onuCfgTotalGEMPortNumber = fStringMap.getString("onuCfgTotalGEMPortNumber") + ": ";
    private final String onuCfgTotalTCONTNumber = fStringMap.getString("onuCfgTotalTCONTNumber") + ": ";
    private final String onuCfgTotalEthernetUNINumber = fStringMap.getString("onuCfgTotalEthernetUNINumber") + ": ";
    private final String onuCfgTotalPOTSUNINumber = fStringMap.getString("onuCfgTotalPOTSUNINumber") + ": ";
    */
    private final String onuCfgFecTxEnable = fStringMap.getString("onuCfgFecTxEnable") + ": ";
    /*
    private final String onuCfgPiggybackDbaRep = fStringMap.getString("onuCfgPiggybackDbaRep") + ": ";
    private final String onuCfgWholeOnuDbaRep = fStringMap.getString("onuCfgWholeOnuDbaRep") + ": ";
    */

    public GponOnuMiscConfigureSetupPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuCfgSlotNo));
        baseInfoPanel.add(tfOnuCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgPortNo));
        baseInfoPanel.add(tfOnuCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgBerIntervalConfiguration));
        tfOnuCfgBerIntervalConfiguration.setName(fStringMap.getString("onuCfgBerIntervalConfiguration"));
        baseInfoPanel.add(tfOnuCfgBerIntervalConfiguration);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuCfgPowerLevel));
        baseInfoPanel.add(tfOnuCfgPowerLevel);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTrafficManagementOption));
        baseInfoPanel.add(tfOnuCfgTrafficManagementOption);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(onuCfgBatteryBackup));
        tfOnuCfgBatteryBackup.setName(fStringMap.getString("onuCfgBatteryBackup"));
        baseInfoPanel.add(tfOnuCfgBatteryBackup);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuCfgTotalPriorityQueueNumber));
        baseInfoPanel.add(tfOnuCfgTotalPriorityQueueNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTotalTrafficSchedulerNumber));
        baseInfoPanel.add(tfOnuCfgTotalTrafficSchedulerNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTotalGEMPortNumber));
        baseInfoPanel.add(tfOnuCfgTotalGEMPortNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTotalTCONTNumber));
        baseInfoPanel.add(tfOnuCfgTotalTCONTNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTotalEthernetUNINumber));
        baseInfoPanel.add(tfOnuCfgTotalEthernetUNINumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuCfgTotalPOTSUNINumber));
        baseInfoPanel.add(tfOnuCfgTotalPOTSUNINumber);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(onuCfgFecTxEnable));
        tfOnuCfgFecTxEnable.setName(fStringMap.getString("onuCfgFecTxEnable"));
        baseInfoPanel.add(tfOnuCfgFecTxEnable);
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
        //tfOnuCfgTotalGEMPortNumber.setValueScope(3800, 3999);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            return;

        GponOnuMiscConfigureMBean mbean = (GponOnuMiscConfigureMBean) getModel();
        if (mbean == null)
            return;

        tfOnuCfgSlotNo.setText((mbean.getOnuCfgSlotNo() != null) ? mbean.getOnuCfgSlotNo().toString() : "");
        tfOnuCfgPortNo.setText((mbean.getOnuCfgPortNo() != null) ? mbean.getOnuCfgPortNo().toString() : "");
        tfOnuCfgLogicalPortNo.setText((mbean.getOnuCfgLogicalPortNo() != null) ? mbean.getOnuCfgLogicalPortNo().toString() : "");

        tfOnuCfgBerIntervalConfiguration.setEnabled(mbean.getOnuCfgBerIntervalConfiguration() != null);
        tfOnuCfgBerIntervalConfiguration.setValue((mbean.getOnuCfgBerIntervalConfiguration() != null) ? mbean.getOnuCfgBerIntervalConfiguration() : 5000);

        //tfOnuCfgPowerLevel.setText((mbean.getOnuCfgPowerLevel() != null) ? mbean.getOnuCfgPowerLevel().toString() : "");
        //tfOnuCfgTrafficManagementOption.setSelectedIndex(getIndexFromValue(onuCfgTrafficManagementOptionVList, (mbean.getOnuCfgTrafficManagementOption() != null) ? mbean.getOnuCfgTrafficManagementOption() : 0));

        tfOnuCfgBatteryBackup.setEnabled(mbean.getOnuCfgBatteryBackup() != null);
        tfOnuCfgBatteryBackup.setSelectedIndex(getIndexFromValue(onuCfgBatteryBackupVList, (mbean.getOnuCfgBatteryBackup() != null) ? mbean.getOnuCfgBatteryBackup() : 1));

        //tfOnuCfgTotalPriorityQueueNumber.setText((mbean.getOnuCfgTotalPriorityQueueNumber() != null) ? mbean.getOnuCfgTotalPriorityQueueNumber().toString() : "");
        //tfOnuCfgTotalTrafficSchedulerNumber.setText((mbean.getOnuCfgTotalTrafficSchedulerNumber() != null) ? mbean.getOnuCfgTotalTrafficSchedulerNumber().toString() : "");
        //tfOnuCfgTotalGEMPortNumber.setText((mbean.getOnuCfgTotalGEMPortNumber() != null) ? mbean.getOnuCfgTotalGEMPortNumber().toString() : "3800");
        //tfOnuCfgTotalTCONTNumber.setText((mbean.getOnuCfgTotalTCONTNumber() != null) ? mbean.getOnuCfgTotalTCONTNumber().toString() : "");
        //tfOnuCfgTotalEthernetUNINumber.setText((mbean.getOnuCfgTotalEthernetUNINumber() != null) ? mbean.getOnuCfgTotalEthernetUNINumber().toString() : "");
        //tfOnuCfgTotalPOTSUNINumber.setText((mbean.getOnuCfgTotalPOTSUNINumber() != null) ? mbean.getOnuCfgTotalPOTSUNINumber().toString() : "");

        tfOnuCfgFecTxEnable.setEnabled(mbean.getOnuCfgFecTxEnable() != null);
        tfOnuCfgFecTxEnable.setSelectedIndex(getIndexFromValue(onuCfgFecTxEnableVList, (mbean.getOnuCfgFecTxEnable() != null) ? mbean.getOnuCfgFecTxEnable() : 2));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuMiscConfigureMBean(fApplication.getSnmpProxy()));

        GponOnuMiscConfigureMBean mbean = (GponOnuMiscConfigureMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //...
        }

        if (tfOnuCfgBerIntervalConfiguration.isEnabled())
            mbean.setOnuCfgBerIntervalConfiguration(tfOnuCfgBerIntervalConfiguration.getValue());

        if (tfOnuCfgBatteryBackup.isEnabled())
            mbean.setOnuCfgBatteryBackup(onuCfgBatteryBackupVList[tfOnuCfgBatteryBackup.getSelectedIndex()]);

        if (tfOnuCfgFecTxEnable.isEnabled())
            mbean.setOnuCfgFecTxEnable(onuCfgFecTxEnableVList[tfOnuCfgFecTxEnable.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}