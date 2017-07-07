/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesH248Cfg;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Onu2CtcCombinedFeaturesH248CfgPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

    private int[] utsDot3Onu2CtcH248IadOperationStausVList = new int[]{0, 1, 2, 3, 4,};
    private String[] utsDot3Onu2CtcH248IadOperationStausTList = new String[]{
            fStringMap.getString("registering"),
            fStringMap.getString("registered"),
            fStringMap.getString("iadFault"),
            fStringMap.getString("de-register"),
            fStringMap.getString("iadRebooting"),
    };
    private JComboBox tfUtsDot3Onu2CtcH248IadOperationStaus = new JComboBox(utsDot3Onu2CtcH248IadOperationStausTList);

    private IntegerTextField tfUtsDot3Onu2CtcH248MgPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcH248MgcIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcH248MgpComPort = new IntegerTextField();
    private IPAddressField tfUtsDot3Onu2CtcH248BackupMgcIp = new IPAddressField();
    private IntegerTextField tfUtsDot3Onu2CtcH248BackupMgcComPort = new IntegerTextField();

    private int[] utsDot3Onu2CtcH248ActiveMgcVList = new int[]{1, 0,};
    private String[] utsDot3Onu2CtcH248ActiveMgcTList = new String[]{
            fStringMap.getString("primaryMgc"),
            fStringMap.getString("backupMgc"),
    };
    private JComboBox tfUtsDot3Onu2CtcH248ActiveMgc = new JComboBox(utsDot3Onu2CtcH248ActiveMgcTList);

    private int[] utsDot3Onu2CtcH248RegModeVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcH248RegModeTList = new String[]{
            fStringMap.getString("ip"),
            fStringMap.getString("domain"),
            fStringMap.getString("deviceName"),
    };
    private JComboBox tfUtsDot3Onu2CtcH248RegMode = new JComboBox(utsDot3Onu2CtcH248RegModeTList);

    private StringTextField tfUtsDot3Onu2CtcH248Mid = new StringTextField();

    private int[] utsDot3Onu2CtcH248HeartbeatModeVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcH248HeartbeatModeTList = new String[]{
            fStringMap.getString("notUse"),
            fStringMap.getString("ctcNotify"),
    };
    private JComboBox tfUtsDot3Onu2CtcH248HeartbeatMode = new JComboBox(utsDot3Onu2CtcH248HeartbeatModeTList);

    private IntegerTextField tfUtsDot3Onu2CtcH248HeartbeatCycle = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcH248HeartbeatCount = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidNum = new IntegerTextField();
    private StringTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix = new StringTextField();
    private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = new IntegerTextField();

    private int[] utsDot3Onu2CtcH248RtpTidCfgTidModeVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcH248RtpTidCfgTidModeTList = new String[]{
            fStringMap.getString("align"),
            fStringMap.getString("notAlign"),
    };
    private JComboBox tfUtsDot3Onu2CtcH248RtpTidCfgTidMode = new JComboBox(utsDot3Onu2CtcH248RtpTidCfgTidModeTList);

    private IntegerTextField tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength = new IntegerTextField();
    private JLabel tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName = new JLabel();

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcH248IadOperationStaus = fStringMap.getString("utsDot3Onu2CtcH248IadOperationStaus") + ": ";
    private final String utsDot3Onu2CtcH248MgPort = fStringMap.getString("utsDot3Onu2CtcH248MgPort") + ": ";
    private final String utsDot3Onu2CtcH248MgcIp = fStringMap.getString("utsDot3Onu2CtcH248MgcIp") + ": ";
    private final String utsDot3Onu2CtcH248MgpComPort = fStringMap.getString("utsDot3Onu2CtcH248MgpComPort") + ": ";
    private final String utsDot3Onu2CtcH248BackupMgcIp = fStringMap.getString("utsDot3Onu2CtcH248BackupMgcIp") + ": ";
    private final String utsDot3Onu2CtcH248BackupMgcComPort = fStringMap.getString("utsDot3Onu2CtcH248BackupMgcComPort") + ": ";
    private final String utsDot3Onu2CtcH248ActiveMgc = fStringMap.getString("utsDot3Onu2CtcH248ActiveMgc") + ": ";
    private final String utsDot3Onu2CtcH248RegMode = fStringMap.getString("utsDot3Onu2CtcH248RegMode") + ": ";
    private final String utsDot3Onu2CtcH248Mid = fStringMap.getString("utsDot3Onu2CtcH248Mid") + ": ";
    private final String utsDot3Onu2CtcH248HeartbeatMode = fStringMap.getString("utsDot3Onu2CtcH248HeartbeatMode") + ": ";
    private final String utsDot3Onu2CtcH248HeartbeatCycle = fStringMap.getString("utsDot3Onu2CtcH248HeartbeatCycle") + ": ";
    private final String utsDot3Onu2CtcH248HeartbeatCount = fStringMap.getString("utsDot3Onu2CtcH248HeartbeatCount") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidCfgTidNum = fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidNum") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidCfgTidPrefix = fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidPrefix") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin = fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidCfgTidMode = fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidMode") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidCfgTidDigitLength = fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitLength") + ": ";
    private final String utsDot3Onu2CtcH248RtpTidInfoFirstTidName = fStringMap.getString("utsDot3Onu2CtcH248RtpTidInfoFirstTidName") + ": ";

    public Onu2CtcCombinedFeaturesH248CfgPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(21, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248IadOperationStaus));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248IadOperationStaus);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgPort));
        tfUtsDot3Onu2CtcH248MgPort.setName(fStringMap.getString("utsDot3Onu2CtcH248MgPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgcIp));
        tfUtsDot3Onu2CtcH248MgcIp.setName(fStringMap.getString("utsDot3Onu2CtcH248MgcIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgcIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248MgpComPort));
        tfUtsDot3Onu2CtcH248MgpComPort.setName(fStringMap.getString("utsDot3Onu2CtcH248MgpComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248MgpComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248BackupMgcIp));
        tfUtsDot3Onu2CtcH248BackupMgcIp.setName(fStringMap.getString("utsDot3Onu2CtcH248BackupMgcIp"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248BackupMgcIp);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248BackupMgcComPort));
        tfUtsDot3Onu2CtcH248BackupMgcComPort.setName(fStringMap.getString("utsDot3Onu2CtcH248BackupMgcComPort"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248BackupMgcComPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248ActiveMgc));
        tfUtsDot3Onu2CtcH248ActiveMgc.setName(fStringMap.getString("utsDot3Onu2CtcH248ActiveMgc"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248ActiveMgc);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RegMode));
        tfUtsDot3Onu2CtcH248RegMode.setName(fStringMap.getString("utsDot3Onu2CtcH248RegMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RegMode);
        baseInfoPanel.add(new HSpacer());
        
        tfUtsDot3Onu2CtcH248RegMode.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		changeConfigItemByRegMode();
        	}
        });

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248Mid));
        tfUtsDot3Onu2CtcH248Mid.setName(fStringMap.getString("utsDot3Onu2CtcH248Mid"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248Mid);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatMode));
        tfUtsDot3Onu2CtcH248HeartbeatMode.setName(fStringMap.getString("utsDot3Onu2CtcH248HeartbeatMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatCycle));
        tfUtsDot3Onu2CtcH248HeartbeatCycle.setName(fStringMap.getString("utsDot3Onu2CtcH248HeartbeatCycle"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatCycle);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248HeartbeatCount));
        tfUtsDot3Onu2CtcH248HeartbeatCount.setName(fStringMap.getString("utsDot3Onu2CtcH248HeartbeatCount"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248HeartbeatCount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidNum));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setName(fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidNum"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidPrefix));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setName(fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidPrefix"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setName(fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitBegin"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidMode));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.setName(fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidCfgTidDigitLength));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setName(fStringMap.getString("utsDot3Onu2CtcH248RtpTidCfgTidDigitLength"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcH248RtpTidInfoFirstTidName));
        baseInfoPanel.add(tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName);
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
        tfUtsDot3Onu2CtcH248HeartbeatCycle.setValueScope(10, 1800);
        tfUtsDot3Onu2CtcH248HeartbeatCount.setValueScope(1, 10);
        tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setValueScope(1, 255);
        tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setValueScope(0,2147483647);
        
    }

    public void refresh() {
        Onu2CtcCombinedFeaturesH248Cfg mbean = (Onu2CtcCombinedFeaturesH248Cfg) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

        tfUtsDot3Onu2CtcH248IadOperationStaus.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcH248IadOperationStausVList, mbean.getUtsDot3Onu2CtcH248IadOperationStaus().intValue()));
        tfUtsDot3Onu2CtcH248IadOperationStaus.setEnabled(false);
        tfUtsDot3Onu2CtcH248MgPort.setValue(mbean.getUtsDot3Onu2CtcH248MgPort().intValue());
        tfUtsDot3Onu2CtcH248MgcIp.setValue(mbean.getUtsDot3Onu2CtcH248MgcIp());
        tfUtsDot3Onu2CtcH248MgpComPort.setValue(mbean.getUtsDot3Onu2CtcH248MgpComPort().intValue());
        tfUtsDot3Onu2CtcH248BackupMgcIp.setValue(mbean.getUtsDot3Onu2CtcH248BackupMgcIp());
        tfUtsDot3Onu2CtcH248BackupMgcComPort.setValue(mbean.getUtsDot3Onu2CtcH248BackupMgcComPort().intValue());
        tfUtsDot3Onu2CtcH248ActiveMgc.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcH248ActiveMgcVList, mbean.getUtsDot3Onu2CtcH248ActiveMgc().intValue()));
        tfUtsDot3Onu2CtcH248RegMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcH248RegModeVList, mbean.getUtsDot3Onu2CtcH248RegMode().intValue()));
        tfUtsDot3Onu2CtcH248Mid.setValue(mbean.getUtsDot3Onu2CtcH248Mid());
        tfUtsDot3Onu2CtcH248HeartbeatMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcH248HeartbeatModeVList, mbean.getUtsDot3Onu2CtcH248HeartbeatMode().intValue()));
        tfUtsDot3Onu2CtcH248HeartbeatCycle.setValue(mbean.getUtsDot3Onu2CtcH248HeartbeatCycle().intValue());
        tfUtsDot3Onu2CtcH248HeartbeatCount.setValue(mbean.getUtsDot3Onu2CtcH248HeartbeatCount().intValue());
        tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.setValue(mbean.getUtsDot3Onu2CtcH248RtpTidCfgTidNum().intValue());
        tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.setValue(mbean.getUtsDot3Onu2CtcH248RtpTidCfgTidPrefix());
        tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.setValue(mbean.getUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin());
        tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcH248RtpTidCfgTidModeVList, mbean.getUtsDot3Onu2CtcH248RtpTidCfgTidMode().intValue()));
        tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.setValue(mbean.getUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength().intValue());
        tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName.setText(mbean.getUtsDot3Onu2CtcH248RtpTidInfoFirstTidName());
        tfUtsDot3Onu2CtcH248RtpTidInfoFirstTidName.setEnabled(false);
        changeConfigItemByRegMode();
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesH248Cfg mbean = (Onu2CtcCombinedFeaturesH248Cfg) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcH248MgPort(new Integer(tfUtsDot3Onu2CtcH248MgPort.getValue()));
        mbean.setUtsDot3Onu2CtcH248MgcIp(new String(tfUtsDot3Onu2CtcH248MgcIp.getIPString()));
        mbean.setUtsDot3Onu2CtcH248MgpComPort(new Integer(tfUtsDot3Onu2CtcH248MgpComPort.getValue()));
        mbean.setUtsDot3Onu2CtcH248BackupMgcIp(new String(tfUtsDot3Onu2CtcH248BackupMgcIp.getIPString()));
        mbean.setUtsDot3Onu2CtcH248BackupMgcComPort(new Integer(tfUtsDot3Onu2CtcH248BackupMgcComPort.getValue()));
        mbean.setUtsDot3Onu2CtcH248ActiveMgc(new Integer(utsDot3Onu2CtcH248ActiveMgcVList[tfUtsDot3Onu2CtcH248ActiveMgc.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcH248RegMode(new Integer(utsDot3Onu2CtcH248RegModeVList[tfUtsDot3Onu2CtcH248RegMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcH248Mid(new String(tfUtsDot3Onu2CtcH248Mid.getValue()));
        mbean.setUtsDot3Onu2CtcH248HeartbeatMode(new Integer(utsDot3Onu2CtcH248HeartbeatModeVList[tfUtsDot3Onu2CtcH248HeartbeatMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcH248HeartbeatCycle(new Integer(tfUtsDot3Onu2CtcH248HeartbeatCycle.getValue()));
        mbean.setUtsDot3Onu2CtcH248HeartbeatCount(new Integer(tfUtsDot3Onu2CtcH248HeartbeatCount.getValue()));
        mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidNum(new Integer(tfUtsDot3Onu2CtcH248RtpTidCfgTidNum.getValue()));
        mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidPrefix(new String(tfUtsDot3Onu2CtcH248RtpTidCfgTidPrefix.getValue()));
        mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin(new Integer(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitBegin.getValue()));
        mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidMode(new Integer(utsDot3Onu2CtcH248RtpTidCfgTidModeVList[tfUtsDot3Onu2CtcH248RtpTidCfgTidMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength(new Integer(tfUtsDot3Onu2CtcH248RtpTidCfgTidDigitLength.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
    
    public void changeConfigItemByRegMode() {
    	tfUtsDot3Onu2CtcH248Mid.setEnabled(false);
    	if(utsDot3Onu2CtcH248RegModeVList[tfUtsDot3Onu2CtcH248RegMode.getSelectedIndex()] == 1 ||
    			utsDot3Onu2CtcH248RegModeVList[tfUtsDot3Onu2CtcH248RegMode.getSelectedIndex()] == 2) {
    		tfUtsDot3Onu2CtcH248Mid.setEnabled(true);
    	}
    }

}