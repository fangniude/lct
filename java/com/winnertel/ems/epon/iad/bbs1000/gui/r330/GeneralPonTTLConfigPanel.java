package com.winnertel.ems.epon.iad.bbs1000.gui.r330;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.ems.epon.iad.bbs1000.mib.r330.GeneralPonTTLConfig;

import javax.swing.*;
import java.awt.*;

public class GeneralPonTTLConfigPanel extends UPanel {

    private int[] vList = new int[]{2, 1,};
    private String[] tList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("enabled"),
    };

//    private JComboBox tfUtsBBSBPDUTermination = new JComboBox(tList);
    private JComboBox tfUtsBBSSysSoftwareRateLimiting = new JComboBox(tList);
    private IntegerTextField tfUtsBBSSysARPAgingTime = new IntegerTextField();
    private IntegerTextField tfUtsBBSSysMACAgingTime = new IntegerTextField();

    /*
    private StringTextField tfUtsBBSVlanVPNTPID = new StringTextField();
    private int[] utsBBSVlanVPNPRISourceVList = new int[]{1, 2,};
    private String[] utsBBSVlanVPNPRISourceTList = new String[]{
            fStringMap.getString("customertag"),
            fStringMap.getString("llid"),
    };
    private JComboBox tfUtsBBSVlanVPNPRISource = new JComboBox(utsBBSVlanVPNPRISourceTList);
    private IntegerTextField tfUtsBBSMaxFrameSize = new IntegerTextField();
    */

    private JComboBox tfUtsBBSMgmtGratuitousArpLearning = new JComboBox(tList);

//    private final String utsBBSBPDUTermination = fStringMap.getString("utsBBSBPDUTermination") + ": ";
    private final String utsBBSSysSoftwareRateLimiting = fStringMap.getString("utsBBSSysSoftwareRateLimiting") + ": ";
    private final String utsBBSSysARPAgingTime = fStringMap.getString("utsBBSSysARPAgingTime") + ": ";
    private final String utsBBSSysMACAgingTime = fStringMap.getString("utsBBSSysMACAgingTime") + ": ";
    //private final String utsBBSVlanVPNTPID = fStringMap.getString("utsBBSVlanVPNTPID") + ": ";
    //private final String utsBBSVlanVPNPRISource = fStringMap.getString("utsBBSVlanVPNPRISource") + ": ";
    //private final String utsBBSMaxFrameSize = fStringMap.getString("utsBBSMaxFrameSize") + ": ";
    private final String utsBBSMgmtGratuitousArpLearning = fStringMap.getString("utsBBSMgmtGratuitousArpLearning") + ": ";

    private JComboBox tfUtsBBSMgmtArpLearning = new JComboBox(tList);

    private IPAddressField tfUtsBBSMgmtIgmpProxySourceIP = new IPAddressField();

    private final String utsBBSMgmtArpLearning = fStringMap.getString("utsBBSMgmtArpLearning") + ": ";
    private final String utsBBSMgmtIgmpProxySourceIP = fStringMap.getString("utsBBSMgmtIgmpProxySourceIP") + ": ";

    private IntegerTextField tfUtsBBSMgmtTrafficTTL = new IntegerTextField();

    private final String utsBBSMgmtTrafficTTL = fStringMap.getString("utsBBSMgmtTrafficTTL") + ": ";

    public GeneralPonTTLConfigPanel(IApplication app) {
        super(app);
        setModel(new GeneralPonTTLConfig(app.getSnmpProxy()));
        init();
    }

    protected void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_GeneralGPonTTLConfig");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel generalPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        generalPanel.setLayout(layout);
        generalPanel.setBorder(BorderFactory.createEtchedBorder());

//        generalPanel.add(new JLabel(utsBBSBPDUTermination));
//        tfUtsBBSBPDUTermination.setName(fStringMap.getString("utsBBSBPDUTermination"));
//        generalPanel.add(tfUtsBBSBPDUTermination);
//        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysSoftwareRateLimiting));
        tfUtsBBSSysSoftwareRateLimiting.setName(fStringMap.getString("utsBBSSysSoftwareRateLimiting"));
        generalPanel.add(tfUtsBBSSysSoftwareRateLimiting);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSMgmtArpLearning));
        tfUtsBBSMgmtArpLearning.setName(fStringMap.getString("utsBBSMgmtArpLearning"));
        generalPanel.add(tfUtsBBSMgmtArpLearning);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysARPAgingTime));
        tfUtsBBSSysARPAgingTime.setName(fStringMap.getString("utsBBSSysARPAgingTime"));
        generalPanel.add(tfUtsBBSSysARPAgingTime);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSSysMACAgingTime));
        tfUtsBBSSysMACAgingTime.setName(fStringMap.getString("utsBBSSysMACAgingTime"));
        generalPanel.add(tfUtsBBSSysMACAgingTime);
        generalPanel.add(new HSpacer());

        /*
        generalPanel.add(new JLabel(utsBBSVlanVPNTPID));
        tfUtsBBSVlanVPNTPID.setName(fStringMap.getString("utsBBSVlanVPNTPID"));
        generalPanel.add(tfUtsBBSVlanVPNTPID);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSVlanVPNPRISource));
        generalPanel.add(tfUtsBBSVlanVPNPRISource);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSMaxFrameSize));
        generalPanel.add(tfUtsBBSMaxFrameSize);
        generalPanel.add(new HSpacer());
        */

        generalPanel.add(new JLabel(utsBBSMgmtGratuitousArpLearning));
        tfUtsBBSMgmtGratuitousArpLearning.setName(fStringMap.getString("utsBBSMgmtGratuitousArpLearning"));
        generalPanel.add(tfUtsBBSMgmtGratuitousArpLearning);
        generalPanel.add(new HSpacer());

        generalPanel.add(new JLabel(utsBBSMgmtIgmpProxySourceIP));
        tfUtsBBSMgmtIgmpProxySourceIP.setName(fStringMap.getString("utsBBSMgmtIgmpProxySourceIP"));
        generalPanel.add(tfUtsBBSMgmtIgmpProxySourceIP);
        generalPanel.add(new HSpacer());

        generalPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("General_Configuration")));

        JPanel ttlPanel = new JPanel();
        layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ttlPanel.setLayout(layout);
        ttlPanel.setBorder(BorderFactory.createEtchedBorder());

        ttlPanel.add(new JLabel(utsBBSMgmtTrafficTTL));
        tfUtsBBSMgmtTrafficTTL.setName(fStringMap.getString("utsBBSMgmtTrafficTTL"));
        ttlPanel.add(tfUtsBBSMgmtTrafficTTL);
        ttlPanel.add(new HSpacer());
        ttlPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("InBand_OutBand_TTL")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(generalPanel);
        allPanel.add(ttlPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
        tfUtsBBSSysARPAgingTime.setValueScope(30, 65535);
        tfUtsBBSSysMACAgingTime.setValueScope(0, 65535);
        //tfUtsBBSVlanVPNTPID.setEnabled(false);
        //tfUtsBBSVlanVPNPRISource.setEnabled(false);
        tfUtsBBSSysSoftwareRateLimiting.setEnabled(false);
        //tfUtsBBSMaxFrameSize.setValueScope(64, 16368);
        tfUtsBBSMgmtTrafficTTL.setValueScope(1, 255);
    }

    public boolean validateFrom() {
        // OLT MAC Aging time
        int sysMacAgingTime = tfUtsBBSSysMACAgingTime.getValue();
        if (sysMacAgingTime != 0 && !(sysMacAgingTime >= 10 && sysMacAgingTime <= 65535)) {
            String error = fStringMap.getString("Err_MAC_Aging_Time_Is_Invalid");
            MessageDialog.showInfoMessageDialog(fApplication, error);
            return false;
        }
        /*
        try {
            Integer theValue = Integer.valueOf(tfutsPonSysDot1adTPID.getText(), 16);
            if (theValue.intValue() < 0 || theValue.intValue() > 65535) {
                MessageDialog.showInfoMessageDialog(fApplication, utsPonSysDot1adTPID + fStringMap.getString("Err_hex"));
                return false;
            }
        } catch (Exception e) {
            MessageDialog.showInfoMessageDialog(fApplication, utsPonSysDot1adTPID + fStringMap.getString("Err_hex"));
            return false;
        }
        */

        return true;
    }

    public void refresh() {
        GeneralPonTTLConfig mbean = (GeneralPonTTLConfig) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

//        tfUtsBBSBPDUTermination.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSBPDUTermination()));
        tfUtsBBSSysSoftwareRateLimiting.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSSysSoftwareRateLimiting()));
        tfUtsBBSSysARPAgingTime.setValue(mbean.getUtsBBSSysARPAgingTime());
        tfUtsBBSSysMACAgingTime.setValue(mbean.getUtsBBSSysMACAgingTime());
        /*
        tfUtsBBSVlanVPNTPID.setValue(Integer.toHexString(mbean.getUtsBBSVlanVPNTPID()));
        tfUtsBBSVlanVPNPRISource.setSelectedIndex(getIndexFromValue(utsBBSVlanVPNPRISourceVList, mbean.getUtsBBSVlanVPNPRISource()));
        tfUtsBBSMaxFrameSize.setValue(mbean.getUtsBBSMaxFrameSize());
        */
        tfUtsBBSMgmtGratuitousArpLearning.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSMgmtGratuitousArpLearning()));
        tfUtsBBSMgmtTrafficTTL.setValue(mbean.getUtsBBSMgmtTrafficTTL());

        tfUtsBBSMgmtArpLearning.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBBSMgmtArpLearning()));
        tfUtsBBSMgmtIgmpProxySourceIP.setValue(mbean.getUtsBBSMgmtIgmpProxySourceIP());
    }

    public void updateModel() {
        GeneralPonTTLConfig mbean = (GeneralPonTTLConfig) getModel();
        if (mbean == null)
            return;

        mbean.setApplyChanged(true);
//        mbean.setUtsBBSBPDUTermination(vList[tfUtsBBSBPDUTermination.getSelectedIndex()]);
        mbean.setUtsBBSSysSoftwareRateLimiting(vList[tfUtsBBSSysSoftwareRateLimiting.getSelectedIndex()]);
        mbean.setUtsBBSSysARPAgingTime(tfUtsBBSSysARPAgingTime.getValue());
        mbean.setUtsBBSSysMACAgingTime(tfUtsBBSSysMACAgingTime.getValue());
        /*
        mbean.setUtsBBSVlanVPNTPID(Integer.valueOf(tfUtsBBSVlanVPNTPID.getValue(), 16));
        mbean.setUtsBBSMaxFrameSize(tfUtsBBSMaxFrameSize.getValue());
        */
        mbean.setUtsBBSMgmtGratuitousArpLearning(vList[tfUtsBBSMgmtGratuitousArpLearning.getSelectedIndex()]);
        //mbean.setUtsPonSysDot1adTPID(Integer.valueOf(tfutsPonSysDot1adTPID.getValue(), 16));
        mbean.setUtsBBSMgmtTrafficTTL(tfUtsBBSMgmtTrafficTTL.getValue());

        mbean.setUtsBBSMgmtArpLearning(vList[tfUtsBBSMgmtArpLearning.getSelectedIndex()]);
        mbean.setUtsBBSMgmtIgmpProxySourceIP(tfUtsBBSMgmtIgmpProxySourceIP.getIPString());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}