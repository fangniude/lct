/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcCombinedFeaturesIadCfg;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Onu2CtcCombinedFeaturesIadCfgPanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesModuleId = new JLabel();
    //private JLabel tfUtsDot3Onu2CtcCombinedFeaturesDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId = new JLabel();

    private MacAddressField tfUtsDot3Onu2CtcIadInfoMacAddr = new MacAddressField();
    private int[] utsDot3Onu2CtcIadInfoSupportedProtocolVList = new int[]{0, 1,};
    private String[] utsDot3Onu2CtcIadInfoSupportedProtocolTList = new String[]{
    		"H.248", "SIP",
    };
    private JLabel tfUtsDot3Onu2CtcIadInfoSupportedProtocol = new JLabel();
    private JLabel tfUtsDot3Onu2CtcIadInfoSoftwareVer = new JLabel();
    private JLabel tfUtsDot3Onu2CtcIadInfoSoftwareDate = new JLabel();
    private JLabel tfUtsDot3Onu2CtcIadInfoVoipUserCount = new JLabel();

    private int[] utsDot3Onu2CtcIadIpModeVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcIadIpModeTList = new String[]{
            fStringMap.getString("staticIp"),
            fStringMap.getString("dhcp"),
            fStringMap.getString("pppoe"),
    };
    private JComboBox tfUtsDot3Onu2CtcIadIpMode = new JComboBox(utsDot3Onu2CtcIadIpModeTList);

    private IPAddressField tfUtsDot3Onu2CtcIadIpAddr = new IPAddressField();
    private IPAddressField tfUtsDot3Onu2CtcIadNetMask = new IPAddressField(true);
    private IPAddressField tfUtsDot3Onu2CtcIadDefaultGw = new IPAddressField();

    private int[] utsDot3Onu2CtcIadPppoeModeVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcIadPppoeModeTList = new String[]{
            fStringMap.getString("auto"),
            fStringMap.getString("chap"),
            fStringMap.getString("pap"),
    };
    private JComboBox tfUtsDot3Onu2CtcIadPppoeMode = new JComboBox(utsDot3Onu2CtcIadPppoeModeTList);

    private StringTextField tfUtsDot3Onu2CtcIadPppoeUsername = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcIadPppoePassword = new StringTextField();

    private int[] utsDot3Onu2CtcIadTagModeVList = new int[]{0, 1, 2,};
    private String[] utsDot3Onu2CtcIadTagModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
            fStringMap.getString("vlanStack"),
    };
    private JComboBox tfUtsDot3Onu2CtcIadTagMode = new JComboBox(utsDot3Onu2CtcIadTagModeTList);

    private IntegerTextField tfUtsDot3Onu2CtcIadCvlan = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcIadSvlan = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcIadPriority = new IntegerTextField();

    private final String utsDot3Onu2CtcCombinedFeaturesModuleId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesModuleId") + ": ";
    //private final String utsDot3Onu2CtcCombinedFeaturesDeviceId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesDeviceId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesPortId") + ": ";
    private final String utsDot3Onu2CtcCombinedFeaturesLogicalPortId = fStringMap.getString("utsDot3Onu2CtcCombinedFeaturesLogicalPortId") + ": ";

    private final String utsDot3Onu2CtcIadInfoMacAddr = fStringMap.getString("utsDot3Onu2CtcIadInfoMacAddr") + ": ";
    private final String utsDot3Onu2CtcIadInfoSupportedProtocol = fStringMap.getString("utsDot3Onu2CtcIadInfoSupportedProtocol") + ": ";
    private final String utsDot3Onu2CtcIadInfoSoftwareVer = fStringMap.getString("utsDot3Onu2CtcIadInfoSoftwareVer") + ": ";
    private final String utsDot3Onu2CtcIadInfoSoftwareDate = fStringMap.getString("utsDot3Onu2CtcIadInfoSoftwareDate") + ": ";
    private final String utsDot3Onu2CtcIadInfoVoipUserCount = fStringMap.getString("utsDot3Onu2CtcIadInfoVoipUserCount") + ": ";
    private final String utsDot3Onu2CtcIadIpMode = fStringMap.getString("utsDot3Onu2CtcIadIpMode") + ": ";
    private final String utsDot3Onu2CtcIadIpAddr = fStringMap.getString("utsDot3Onu2CtcIadIpAddr") + ": ";
    private final String utsDot3Onu2CtcIadNetMask = fStringMap.getString("utsDot3Onu2CtcIadNetMask") + ": ";
    private final String utsDot3Onu2CtcIadDefaultGw = fStringMap.getString("utsDot3Onu2CtcIadDefaultGw") + ": ";
    private final String utsDot3Onu2CtcIadPppoeMode = fStringMap.getString("utsDot3Onu2CtcIadPppoeMode") + ": ";
    private final String utsDot3Onu2CtcIadPppoeUsername = fStringMap.getString("utsDot3Onu2CtcIadPppoeUsername") + ": ";
    private final String utsDot3Onu2CtcIadPppoePassword = fStringMap.getString("utsDot3Onu2CtcIadPppoePassword") + ": ";
    private final String utsDot3Onu2CtcIadTagMode = fStringMap.getString("utsDot3Onu2CtcIadTagMode") + ": ";
    private final String utsDot3Onu2CtcIadCvlan = fStringMap.getString("utsDot3Onu2CtcIadCvlan") + ": ";
    private final String utsDot3Onu2CtcIadSvlan = fStringMap.getString("utsDot3Onu2CtcIadSvlan") + ": ";
    private final String utsDot3Onu2CtcIadPriority = fStringMap.getString("utsDot3Onu2CtcIadPriority") + ": ";

    public Onu2CtcCombinedFeaturesIadCfgPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(19, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoMacAddr));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoMacAddr);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSupportedProtocol));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSupportedProtocol);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSoftwareVer));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSoftwareVer);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoSoftwareDate));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoSoftwareDate);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadInfoVoipUserCount));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadInfoVoipUserCount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadIpMode));
        tfUtsDot3Onu2CtcIadIpMode.setName(fStringMap.getString("utsDot3Onu2CtcIadIpMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadIpMode);
        baseInfoPanel.add(new HSpacer());
        
        tfUtsDot3Onu2CtcIadIpMode.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent e) {
        		changeConfigItemByIadIpMode();
        	}
        });

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadIpAddr));
        tfUtsDot3Onu2CtcIadIpAddr.setName(fStringMap.getString("utsDot3Onu2CtcIadIpAddr"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadIpAddr);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadNetMask));
        tfUtsDot3Onu2CtcIadNetMask.setName(fStringMap.getString("utsDot3Onu2CtcIadNetMask"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadNetMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadDefaultGw));
        tfUtsDot3Onu2CtcIadDefaultGw.setName(fStringMap.getString("utsDot3Onu2CtcIadDefaultGw"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadDefaultGw);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoeMode));
        tfUtsDot3Onu2CtcIadPppoeMode.setName(fStringMap.getString("utsDot3Onu2CtcIadPppoeMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoeMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoeUsername));
        tfUtsDot3Onu2CtcIadPppoeUsername.setName(fStringMap.getString("utsDot3Onu2CtcIadPppoeUsername"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoeUsername);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPppoePassword));
        tfUtsDot3Onu2CtcIadPppoePassword.setName(fStringMap.getString("utsDot3Onu2CtcIadPppoePassword"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadPppoePassword);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadTagMode));
        tfUtsDot3Onu2CtcIadTagMode.setName(fStringMap.getString("utsDot3Onu2CtcIadTagMode"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadTagMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadCvlan));
        tfUtsDot3Onu2CtcIadCvlan.setName(fStringMap.getString("utsDot3Onu2CtcIadCvlan"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadCvlan);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadSvlan));
        tfUtsDot3Onu2CtcIadSvlan.setName(fStringMap.getString("utsDot3Onu2CtcIadSvlan"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadSvlan);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcIadPriority));
        tfUtsDot3Onu2CtcIadPriority.setName(fStringMap.getString("utsDot3Onu2CtcIadPriority"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcIadPriority);
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
        //tfUtsDot3Onu2CtcIadInfoMacAddr.setEditable(false);
        tfUtsDot3Onu2CtcIadCvlan.setValueScope(1, 4094);
        tfUtsDot3Onu2CtcIadSvlan.setValueScope(0, 4094);
        tfUtsDot3Onu2CtcIadPriority.setValueScope(0, 7);
        tfUtsDot3Onu2CtcIadInfoMacAddr.setValue("00:00:00:00:00:00");
    }

    public void refresh() {
        Onu2CtcCombinedFeaturesIadCfg mbean = (Onu2CtcCombinedFeaturesIadCfg) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcCombinedFeaturesModuleId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesModuleId().toString());
        //tfUtsDot3Onu2CtcCombinedFeaturesDeviceId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesDeviceId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesPortId().toString());
        tfUtsDot3Onu2CtcCombinedFeaturesLogicalPortId.setText(mbean.getUtsDot3Onu2CtcCombinedFeaturesLogicalPortId().toString());

        tfUtsDot3Onu2CtcIadInfoMacAddr.setValue(mbean.getUtsDot3Onu2CtcIadInfoMacAddr());
        tfUtsDot3Onu2CtcIadInfoMacAddr.setEnabled(false);
        int spIndex = getIndexFromValue(utsDot3Onu2CtcIadInfoSupportedProtocolVList, mbean.getUtsDot3Onu2CtcIadInfoSupportedProtocol().intValue());
        if(spIndex>=0 && spIndex < 2)
        	tfUtsDot3Onu2CtcIadInfoSupportedProtocol.setText(utsDot3Onu2CtcIadInfoSupportedProtocolTList[spIndex]);
        else 
        	tfUtsDot3Onu2CtcIadInfoSupportedProtocol.setText(mbean.getUtsDot3Onu2CtcIadInfoSupportedProtocol().toString());
        tfUtsDot3Onu2CtcIadInfoSoftwareVer.setText(mbean.getUtsDot3Onu2CtcIadInfoSoftwareVer());
        tfUtsDot3Onu2CtcIadInfoSoftwareDate.setText(mbean.getUtsDot3Onu2CtcIadInfoSoftwareDate());
        tfUtsDot3Onu2CtcIadInfoVoipUserCount.setText(mbean.getUtsDot3Onu2CtcIadInfoVoipUserCount().toString());
        tfUtsDot3Onu2CtcIadIpMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcIadIpModeVList, mbean.getUtsDot3Onu2CtcIadIpMode().intValue()));
        tfUtsDot3Onu2CtcIadIpAddr.setValue(mbean.getUtsDot3Onu2CtcIadIpAddr());
        tfUtsDot3Onu2CtcIadNetMask.setValue(mbean.getUtsDot3Onu2CtcIadNetMask());
        tfUtsDot3Onu2CtcIadDefaultGw.setValue(mbean.getUtsDot3Onu2CtcIadDefaultGw());
        tfUtsDot3Onu2CtcIadPppoeMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcIadPppoeModeVList, mbean.getUtsDot3Onu2CtcIadPppoeMode().intValue()));
        tfUtsDot3Onu2CtcIadPppoeUsername.setValue(mbean.getUtsDot3Onu2CtcIadPppoeUsername());
        tfUtsDot3Onu2CtcIadPppoePassword.setValue(mbean.getUtsDot3Onu2CtcIadPppoePassword());
        tfUtsDot3Onu2CtcIadTagMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcIadTagModeVList, mbean.getUtsDot3Onu2CtcIadTagMode().intValue()));
        tfUtsDot3Onu2CtcIadCvlan.setValue(mbean.getUtsDot3Onu2CtcIadCvlan().intValue());
        tfUtsDot3Onu2CtcIadSvlan.setValue(mbean.getUtsDot3Onu2CtcIadSvlan().intValue());
        tfUtsDot3Onu2CtcIadPriority.setValue(mbean.getUtsDot3Onu2CtcIadPriority().intValue());
        changeConfigItemByIadIpMode();
    }

    public void updateModel() {
        Onu2CtcCombinedFeaturesIadCfg mbean = (Onu2CtcCombinedFeaturesIadCfg) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2CtcIadIpMode(new Integer(utsDot3Onu2CtcIadIpModeVList[tfUtsDot3Onu2CtcIadIpMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcIadIpAddr(tfUtsDot3Onu2CtcIadIpAddr.getIPString());
        mbean.setUtsDot3Onu2CtcIadNetMask(tfUtsDot3Onu2CtcIadNetMask.getIPString());
        mbean.setUtsDot3Onu2CtcIadDefaultGw(tfUtsDot3Onu2CtcIadDefaultGw.getIPString());
        mbean.setUtsDot3Onu2CtcIadPppoeMode(new Integer(utsDot3Onu2CtcIadPppoeModeVList[tfUtsDot3Onu2CtcIadPppoeMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcIadPppoeUsername(new String(tfUtsDot3Onu2CtcIadPppoeUsername.getValue()));
        mbean.setUtsDot3Onu2CtcIadPppoePassword(new String(tfUtsDot3Onu2CtcIadPppoePassword.getValue()));
        mbean.setUtsDot3Onu2CtcIadTagMode(new Integer(utsDot3Onu2CtcIadTagModeVList[tfUtsDot3Onu2CtcIadTagMode.getSelectedIndex()]));
        mbean.setUtsDot3Onu2CtcIadCvlan(new Integer(tfUtsDot3Onu2CtcIadCvlan.getValue()));
        mbean.setUtsDot3Onu2CtcIadSvlan(new Integer(tfUtsDot3Onu2CtcIadSvlan.getValue()));
        mbean.setUtsDot3Onu2CtcIadPriority(new Integer(tfUtsDot3Onu2CtcIadPriority.getValue()));
    }
    
    public void changeConfigItemByIadIpMode() {
    	tfUtsDot3Onu2CtcIadIpAddr.setEnabled(false);
    	tfUtsDot3Onu2CtcIadNetMask.setEnabled(false);
    	tfUtsDot3Onu2CtcIadDefaultGw.setEnabled(false);
    	tfUtsDot3Onu2CtcIadPppoeMode.setEnabled(false);
    	tfUtsDot3Onu2CtcIadPppoeUsername.setEnabled(false);
    	tfUtsDot3Onu2CtcIadPppoePassword.setEnabled(false);
    	if(utsDot3Onu2CtcIadIpModeVList[tfUtsDot3Onu2CtcIadIpMode.getSelectedIndex()] == 0){ //staticIp
    		tfUtsDot3Onu2CtcIadIpAddr.setEnabled(true);
        	tfUtsDot3Onu2CtcIadNetMask.setEnabled(true);
        	tfUtsDot3Onu2CtcIadDefaultGw.setEnabled(true);
    	}
    	else if(utsDot3Onu2CtcIadIpModeVList[tfUtsDot3Onu2CtcIadIpMode.getSelectedIndex()] == 2){ //pppoe
    		tfUtsDot3Onu2CtcIadPppoeMode.setEnabled(true);
        	tfUtsDot3Onu2CtcIadPppoeUsername.setEnabled(true);
        	tfUtsDot3Onu2CtcIadPppoePassword.setEnabled(true);
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