/**
 * Created by Zhou Chao, 2010/2/2
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.mib.r221.Onu2CtcPotsCfgTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipIadTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Onu2CtcPotsCfgTablePanel extends UPanel {

    private JLabel tfUtsDot3Onu2CtcPotsCfgModuleId = new JLabel();
//    private JLabel tfUtsDot3Onu2CtcPotsCfgDeviceId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPotsCfgPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPotsCfgLogicalPortId = new JLabel();
    private JLabel tfUtsDot3Onu2CtcPotsCfgPotsId = new JLabel();

    private StringTextField tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcPotsCfgSipUserAccount = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcPotsCfgSipUsername = new StringTextField();
    private StringTextField tfUtsDot3Onu2CtcPotsCfgSipPassword = new StringTextField();

//    private int[] utsDot3Onu2CtcPotsCfgIadPortStatusVList = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
//    private String[] utsDot3Onu2CtcPotsCfgIadPortStatusTList = new String[]{
//            fStringMap.getString("registering"), //0
//            fStringMap.getString("idle"), //1
//            fStringMap.getString("offHook"), //2
//            fStringMap.getString("dialing"), //3
//            fStringMap.getString("ringing"), //4
//            fStringMap.getString("ringingBack"), //5
//            fStringMap.getString("connecting"), //6
//            fStringMap.getString("connected"), //7
//            fStringMap.getString("releasingConnection"), //8
//            fStringMap.getString("regFailed"), //9
//            fStringMap.getString("notActivated"), //10
//    };
//    private JComboBox tfUtsDot3Onu2CtcPotsCfgIadPortStatus = new JComboBox(utsDot3Onu2CtcPotsCfgIadPortStatusTList);

//    private int[] utsDot3Onu2CtcPotsCfgIadPortServiceStateVList = new int[]{0, 1, 2, 3,};
//    private String[] utsDot3Onu2CtcPotsCfgIadPortServiceStateTList = new String[]{
//            fStringMap.getString("endByLocal"),
//            fStringMap.getString("endByRemote"),
//            fStringMap.getString("endAuto"),
//            fStringMap.getString("normal"),
//    };
//    private JComboBox tfUtsDot3Onu2CtcPotsCfgIadPortServiceState = new JComboBox(utsDot3Onu2CtcPotsCfgIadPortServiceStateTList);

//    private int[] utsDot3Onu2CtcPotsCfgIadPortCodecModeVList = new int[]{0, 1, 2, 3, 4, 5,};
//    private String[] utsDot3Onu2CtcPotsCfgIadPortCodecModeTList = new String[]{
//            fStringMap.getString("g711a"),
//            fStringMap.getString("g729"),
//            fStringMap.getString("g711u"),
//            fStringMap.getString("g723"),
//            fStringMap.getString("g726"),
//            fStringMap.getString("t38"),
//    };
//    private JComboBox tfUtsDot3Onu2CtcPotsCfgIadPortCodecMode = new JComboBox(utsDot3Onu2CtcPotsCfgIadPortCodecModeTList);

    private final String utsDot3Onu2CtcPotsCfgModuleId = fStringMap.getString("utsDot3Onu2CtcPotsCfgModuleId") + ": ";
//    private final String utsDot3Onu2CtcPotsCfgDeviceId = fStringMap.getString("utsDot3Onu2CtcPotsCfgDeviceId") + ": ";
    private final String utsDot3Onu2CtcPotsCfgPortId = fStringMap.getString("utsDot3Onu2CtcPotsCfgPortId") + ": ";
    private final String utsDot3Onu2CtcPotsCfgLogicalPortId = fStringMap.getString("utsDot3Onu2CtcPotsCfgLogicalPortId") + ": ";
    private final String utsDot3Onu2CtcPotsCfgPotsId = fStringMap.getString("utsDot3Onu2CtcPotsCfgPotsId") + ": ";
    private final String utsDot3Onu2CtcPotsCfgH248UserTidInfo = fStringMap.getString("utsDot3Onu2CtcPotsCfgH248UserTidInfo") + ": ";
    private final String utsDot3Onu2CtcPotsCfgSipUserAccount = fStringMap.getString("utsDot3Onu2CtcPotsCfgSipUserAccount") + ": ";
    private final String utsDot3Onu2CtcPotsCfgSipUsername = fStringMap.getString("utsDot3Onu2CtcPotsCfgSipUsername") + ": ";
    private final String utsDot3Onu2CtcPotsCfgSipPassword = fStringMap.getString("utsDot3Onu2CtcPotsCfgSipPassword") + ": ";
//    private final String utsDot3Onu2CtcPotsCfgIadPortStatus = fStringMap.getString("utsDot3Onu2CtcPotsCfgIadPortStatus") + ": ";
//    private final String utsDot3Onu2CtcPotsCfgIadPortServiceState = fStringMap.getString("utsDot3Onu2CtcPotsCfgIadPortServiceState") + ": ";
//    private final String utsDot3Onu2CtcPotsCfgIadPortCodecMode = fStringMap.getString("utsDot3Onu2CtcPotsCfgIadPortCodecMode") + ": ";

    public Onu2CtcPotsCfgTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgModuleId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgModuleId);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgDeviceId));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgDeviceId);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgLogicalPortId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgLogicalPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgPotsId));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgPotsId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgH248UserTidInfo));
        tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.setName(fStringMap.getString("utsDot3Onu2CtcPotsCfgH248UserTidInfo"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgSipUserAccount));
        tfUtsDot3Onu2CtcPotsCfgSipUserAccount.setName(fStringMap.getString("utsDot3Onu2CtcPotsCfgSipUserAccount"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgSipUserAccount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgSipUsername));
        tfUtsDot3Onu2CtcPotsCfgSipUsername.setName(fStringMap.getString("utsDot3Onu2CtcPotsCfgSipUsername"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgSipUsername);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgSipPassword));
        tfUtsDot3Onu2CtcPotsCfgSipPassword.setName(fStringMap.getString("utsDot3Onu2CtcPotsCfgSipPassword"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgSipPassword);
        baseInfoPanel.add(new HSpacer());

//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgIadPortStatus));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgIadPortStatus);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgIadPortServiceState));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgIadPortServiceState);
//        baseInfoPanel.add(new HSpacer());
//
//        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcPotsCfgIadPortCodecMode));
//        baseInfoPanel.add(tfUtsDot3Onu2CtcPotsCfgIadPortCodecMode);
//        baseInfoPanel.add(new HSpacer());

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
    }

    public void refresh() {
        Onu2CtcPotsCfgTable mbean = (Onu2CtcPotsCfgTable) getModel();
        if (mbean == null)
            return;
        tfUtsDot3Onu2CtcPotsCfgModuleId.setText(mbean.getUtsDot3Onu2CtcPotsCfgModuleId().toString());
//        tfUtsDot3Onu2CtcPotsCfgDeviceId.setText(mbean.getUtsDot3Onu2CtcPotsCfgDeviceId().toString());
        tfUtsDot3Onu2CtcPotsCfgPortId.setText(mbean.getUtsDot3Onu2CtcPotsCfgPortId().toString());
        tfUtsDot3Onu2CtcPotsCfgLogicalPortId.setText(mbean.getUtsDot3Onu2CtcPotsCfgLogicalPortId().toString());
        tfUtsDot3Onu2CtcPotsCfgPotsId.setText(mbean.getUtsDot3Onu2CtcPotsCfgPotsId().toString());
        tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.setValue(mbean.getUtsDot3Onu2CtcPotsCfgH248UserTidInfo());
        tfUtsDot3Onu2CtcPotsCfgSipUserAccount.setValue(mbean.getUtsDot3Onu2CtcPotsCfgSipUserAccount());
        tfUtsDot3Onu2CtcPotsCfgSipUsername.setValue(mbean.getUtsDot3Onu2CtcPotsCfgSipUsername());
        tfUtsDot3Onu2CtcPotsCfgSipPassword.setValue(mbean.getUtsDot3Onu2CtcPotsCfgSipPassword());
//        tfUtsDot3Onu2CtcPotsCfgIadPortStatus.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcPotsCfgIadPortStatusVList, mbean.getUtsDot3Onu2CtcPotsCfgIadPortStatus().intValue()));
//        tfUtsDot3Onu2CtcPotsCfgIadPortServiceState.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcPotsCfgIadPortServiceStateVList, mbean.getUtsDot3Onu2CtcPotsCfgIadPortServiceState().intValue()));
//        tfUtsDot3Onu2CtcPotsCfgIadPortCodecMode.setSelectedIndex(getIndexFromValue(utsDot3Onu2CtcPotsCfgIadPortCodecModeVList, mbean.getUtsDot3Onu2CtcPotsCfgIadPortCodecMode().intValue()));
//        tfUtsDot3Onu2CtcPotsCfgIadPortStatus.setEnabled(false);
//        tfUtsDot3Onu2CtcPotsCfgIadPortServiceState.setEnabled(false);
//        tfUtsDot3Onu2CtcPotsCfgIadPortCodecMode.setEnabled(false);
        
        Dot3Onu2VoipIadTable iadBean = new Dot3Onu2VoipIadTable(
				this.fApplication.getSnmpProxy());
		try {
			iadBean.setUtsDot3Onu2CtcCombinedFeaturesModuleId(mbean
					.getUtsDot3Onu2CtcPotsCfgModuleId());
			iadBean.setUtsDot3Onu2CtcCombinedFeaturesDeviceId(mbean
					.getUtsDot3Onu2CtcPotsCfgDeviceId());
			iadBean.setUtsDot3Onu2CtcCombinedFeaturesPortId(mbean
					.getUtsDot3Onu2CtcPotsCfgPortId());
			iadBean.setUtsDot3Onu2CtcCombinedFeaturesLogicalPortId(mbean
					.getUtsDot3Onu2CtcPotsCfgLogicalPortId());

			iadBean.retrieve();

			if(iadBean.getUtsDot3Onu2CtcIadInfoSupportedProtocol() == 0 ) { //h.248
				tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.setEnabled(true);
				tfUtsDot3Onu2CtcPotsCfgSipUserAccount.setEnabled(false);
				tfUtsDot3Onu2CtcPotsCfgSipUsername.setEnabled(false);
				tfUtsDot3Onu2CtcPotsCfgSipPassword.setEnabled(false);
			}
			else {
				tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.setEnabled(false);
				tfUtsDot3Onu2CtcPotsCfgSipUserAccount.setEnabled(true);
				tfUtsDot3Onu2CtcPotsCfgSipUsername.setEnabled(true);
				tfUtsDot3Onu2CtcPotsCfgSipPassword.setEnabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void updateModel() {
        Onu2CtcPotsCfgTable mbean = (Onu2CtcPotsCfgTable) getModel();
        if (mbean == null)
            return;

        if(tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.isEnabled() && tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.getValue()!= null && tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.getValue().length()!=0 ) {
        	mbean.setUtsDot3Onu2CtcPotsCfgH248UserTidInfo(new String(tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.getValue()));
        }
        else if(tfUtsDot3Onu2CtcPotsCfgH248UserTidInfo.isEnabled()){
        	mbean.setUtsDot3Onu2CtcPotsCfgH248UserTidInfo(new String(" "));
        }
        
        if(tfUtsDot3Onu2CtcPotsCfgSipUserAccount.isEnabled() && tfUtsDot3Onu2CtcPotsCfgSipUserAccount.getValue() != null && tfUtsDot3Onu2CtcPotsCfgSipUserAccount.getValue().length() != 0) {
        	mbean.setUtsDot3Onu2CtcPotsCfgSipUserAccount(new String(tfUtsDot3Onu2CtcPotsCfgSipUserAccount.getValue()));
        }
        else if(tfUtsDot3Onu2CtcPotsCfgSipUserAccount.isEnabled()) {
        	mbean.setUtsDot3Onu2CtcPotsCfgSipUserAccount(new String(" "));
        }
        
        if(tfUtsDot3Onu2CtcPotsCfgSipUsername.isEnabled() && tfUtsDot3Onu2CtcPotsCfgSipUsername.getValue() != null && tfUtsDot3Onu2CtcPotsCfgSipUsername.getValue().length() != 0) {
        	mbean.setUtsDot3Onu2CtcPotsCfgSipUsername(new String(tfUtsDot3Onu2CtcPotsCfgSipUsername.getValue()));
        }
        else if(tfUtsDot3Onu2CtcPotsCfgSipUsername.isEnabled()){
        	mbean.setUtsDot3Onu2CtcPotsCfgSipUsername(new String(" "));
        }
        
        if(tfUtsDot3Onu2CtcPotsCfgSipPassword.isEnabled() && tfUtsDot3Onu2CtcPotsCfgSipPassword.getValue() != null && tfUtsDot3Onu2CtcPotsCfgSipPassword.getValue().length() != 0) {
        	mbean.setUtsDot3Onu2CtcPotsCfgSipPassword(new String(tfUtsDot3Onu2CtcPotsCfgSipPassword.getValue()));
        }
        else if(tfUtsDot3Onu2CtcPotsCfgSipPassword.isEnabled()){
        	mbean.setUtsDot3Onu2CtcPotsCfgSipPassword(new String(" "));
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