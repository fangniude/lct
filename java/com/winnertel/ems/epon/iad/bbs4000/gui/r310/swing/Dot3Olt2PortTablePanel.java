package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Olt2PortTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Dot3Olt2PortTablePanel extends UPanel {

    private JLabel tfUtsDot3OltModuleId = new JLabel();
    // private JLabel tfUtsDot3OltDeviceId = new JLabel();
    private JLabel tfUtsDot3OltPortId = new JLabel();

    private int[] utsDot3OltAdminStatusVList = new int[] { 1, 2, };
    private String[] utsDot3OltAdminStatusTList = new String[] { fStringMap.getString("up"), // 1
	    fStringMap.getString("down"), // 2
    };
    private JComboBox tfUtsDot3OltAdminStatus = new JComboBox(utsDot3OltAdminStatusTList);

    /*
     * private int[] utsDot3OltRxFECEnableVList = new int[]{1, 2,}; private String[] utsDot3OltRxFECEnableTList = new String[]{ fStringMap.getString("true"), //1 fStringMap.getString("false"), //2 }; private JComboBox tfUtsDot3OltRxFECEnable = new JComboBox(utsDot3OltRxFECEnableTList);
     * 
     * private int[] utsDot3OltTransceiverTxVList = new int[]{1, 2,}; private String[] utsDot3OltTransceiverTxTList = new String[]{ fStringMap.getString("enable"), //1 fStringMap.getString("disable") //2 }; private JComboBox tfUtsDot3OltTransceiverTx = new JComboBox(utsDot3OltTransceiverTxTList);
     * 
     * private int[] utsDot3OltTransceiverRxVList = new int[]{1, 2,}; private String[] utsDot3OltTransceiverRxTList = new String[]{ fStringMap.getString("enable"), //1 fStringMap.getString("disable") //2 }; private JComboBox tfUtsDot3OltTransceiverRx = new JComboBox(utsDot3OltTransceiverRxTList);
     * 
     * private int[] utsDot3OltONUP2PEnableVList = new int[]{1, 2,}; private String[] utsDot3OltONUP2PEnableTList = new String[]{ fStringMap.getString("true"), //1 fStringMap.getString("false"), //2 }; private JComboBox tfUtsDot3OltONUP2PEnable = new JComboBox(utsDot3OltONUP2PEnableTList);
     */

    private IntegerTextField tfUtsDot3OltMPCPGateBackoffTime = new IntegerTextField();

    private int[] utsDot3OltP2pEnableVList = new int[] { 1, 2, };
    private String[] utsDot3OltP2pEnableTList = new String[] { fStringMap.getString("enable"), // 1
	    fStringMap.getString("disable"), // 2
    };
    private JComboBox tfUtsDot3OltP2pEnable = new JComboBox(utsDot3OltP2pEnableTList);

    private int[] utsDot3OltOlpPortVList = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, };
    private String[] utsDot3OltOlpPortTList = new String[] { fStringMap.getString("disable"), // 0
	    "1", "2", "3", "4", "5", "6", "7", "8", };
    private JComboBox tfUtsDot3OltOlpPort = new JComboBox(utsDot3OltOlpPortTList);
    private int[] utsDot3OltPortONUSNumberSwitchVList = new int[]{1,2};
    private String[] utsDot3OltPortONUSNumberSwitchTList = new String[]{fStringMap.getString("disable"),fStringMap.getString("enable")};
//    private JComboBox tfUtsDot3OltPortONUSNumberSwitch = new JComboBox(utsDot3OltPortONUSNumberSwitchTList);
    private int[] utsDot3OltPortONUAuthModeVList = new int[] { 1, 2, 3, 4 };
    private String[] utsDot3OltPortONUAuthModeTList = new String[] { fStringMap.getString("mac"), // 1
	    fStringMap.getString("loid"), // 2
	    fStringMap.getString("hybrid"), // 3
	    fStringMap.getString("AutomaticBinding") // 4
    };
    private JComboBox tfUtsDot3OltPortONUAuthMode = new JComboBox(utsDot3OltPortONUAuthModeTList);

    private final String utsDot3OltModuleId = fStringMap.getString("utsDot3OltModuleId") + ": ";
    // private final String utsDot3OltDeviceId = fStringMap.getString("utsDot3OltDeviceId") + ": ";
    private final String utsDot3OltPortId = fStringMap.getString("utsDot3OltPortId") + ": ";
    private final String utsDot3OltAdminStatus = fStringMap.getString("utsDot3OltAdminStatus") + ": ";
    // private final String utsDot3OltRxFECEnable = fStringMap.getString("utsDot3OltRxFECEnable") + ": ";
    // private final String utsDot3OltTransceiverTx = fStringMap.getString("utsDot3OltTransceiverTx") + ": ";
    // private final String utsDot3OltTransceiverRx = fStringMap.getString("utsDot3OltTransceiverRx") + ": ";
    // private final String utsDot3OltONUP2PEnable = fStringMap.getString("utsDot3OltONUP2PEnable") + ": ";
    private final String utsDot3OltMPCPGateBackoffTime = fStringMap.getString("utsDot3OltMPCPGateBackoffTime") + ": ";
    private final String utsDot3OltP2pEnable = fStringMap.getString("utsDot3OltP2pEnable") + ": ";
    private final String utsDot3OltOlpPort = fStringMap.getString("utsDot3OltOlpPort") + ": ";
    private final String utsDot3OltPortONUSNumberSwitch = fStringMap.getString("utsDot3OltPortONUSNumberSwitch") + ":";
    private final String utsDot3OltPortONUAuthMode = fStringMap.getString("utsDot3OltPortONUAuthMode") + ":";
    private boolean isONUSAuthModeChanged = false;

    public Dot3Olt2PortTablePanel(IApplication app) {
	super(app);
	init();
    }

    public void initGui() {
	JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

	baseInfoPanel.add(new JLabel(utsDot3OltModuleId));
	baseInfoPanel.add(tfUtsDot3OltModuleId);
	baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltDeviceId));
	// baseInfoPanel.add(tfUtsDot3OltDeviceId);
	// baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OltPortId));
	baseInfoPanel.add(tfUtsDot3OltPortId);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OltAdminStatus));
	tfUtsDot3OltAdminStatus.setName(fStringMap.getString("utsDot3OltAdminStatus"));
	baseInfoPanel.add(tfUtsDot3OltAdminStatus);
	baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltRxFECEnable));
	// tfUtsDot3OltRxFECEnable.setName(fStringMap.getString("utsDot3OltRxFECEnable"));
	// baseInfoPanel.add(tfUtsDot3OltRxFECEnable);
	// baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltTransceiverTx));
	// tfUtsDot3OltTransceiverTx.setName(fStringMap.getString("utsDot3OltTransceiverTx"));
	// baseInfoPanel.add(tfUtsDot3OltTransceiverTx);
	// baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltTransceiverRx));
	// tfUtsDot3OltTransceiverRx.setName(fStringMap.getString("utsDot3OltTransceiverRx"));
	// baseInfoPanel.add(tfUtsDot3OltTransceiverRx);
	// baseInfoPanel.add(new HSpacer());

	// baseInfoPanel.add(new JLabel(utsDot3OltONUP2PEnable));
	// tfUtsDot3OltONUP2PEnable.setName(fStringMap.getString("utsDot3OltONUP2PEnable"));
	// baseInfoPanel.add(tfUtsDot3OltONUP2PEnable);
	// baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OltMPCPGateBackoffTime));
	tfUtsDot3OltMPCPGateBackoffTime.setName(fStringMap.getString("utsDot3OltMPCPGateBackoffTime"));
	baseInfoPanel.add(tfUtsDot3OltMPCPGateBackoffTime);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OltP2pEnable));
	tfUtsDot3OltP2pEnable.setName(utsDot3OltP2pEnable);
	baseInfoPanel.add(tfUtsDot3OltP2pEnable);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OltOlpPort));
	tfUtsDot3OltOlpPort.setName(utsDot3OltOlpPort);
	baseInfoPanel.add(tfUtsDot3OltOlpPort);
	baseInfoPanel.add(new HSpacer());

//    baseInfoPanel.add(new JLabel(utsDot3OltPortONUSNumberSwitch));
//    tfUtsDot3OltPortONUSNumberSwitch.setName(utsDot3OltPortONUSNumberSwitch);
//    baseInfoPanel.add(tfUtsDot3OltPortONUSNumberSwitch);
//    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OltPortONUAuthMode));
	tfUtsDot3OltPortONUAuthMode.setName(utsDot3OltPortONUAuthMode);
	baseInfoPanel.add(tfUtsDot3OltPortONUAuthMode);
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
	tfUtsDot3OltMPCPGateBackoffTime.setValueScope(0, 31);
    }

    public void refresh() {
	Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();
	if (mbean == null)
	    return;

	tfUtsDot3OltModuleId.setText(mbean.getUtsDot3OltModuleId().toString());
	// tfUtsDot3OltDeviceId.setText(mbean.getUtsDot3OltDeviceId().toString());
	tfUtsDot3OltPortId.setText(mbean.getUtsDot3OltPortId().toString());
	tfUtsDot3OltAdminStatus.setSelectedIndex(getIndexFromValue(utsDot3OltAdminStatusVList, mbean.getUtsDot3OltAdminStatus()));
	// tfUtsDot3OltRxFECEnable.setSelectedIndex(getIndexFromValue(utsDot3OltRxFECEnableVList, mbean.getUtsDot3OltRxFECEnable()));
	// tfUtsDot3OltTransceiverTx.setSelectedIndex(getIndexFromValue(utsDot3OltTransceiverTxVList, mbean.getUtsDot3OltTransceiverTx()));
	// tfUtsDot3OltTransceiverRx.setSelectedIndex(getIndexFromValue(utsDot3OltTransceiverRxVList, mbean.getUtsDot3OltTransceiverRx()));
	// tfUtsDot3OltONUP2PEnable.setSelectedIndex(getIndexFromValue(utsDot3OltONUP2PEnableVList, mbean.getUtsDot3OltONUP2PEnable()));
	tfUtsDot3OltMPCPGateBackoffTime.setValue(mbean.getUtsDot3OltMPCPGateBackoffTime());
	tfUtsDot3OltP2pEnable.setSelectedIndex(getIndexFromValue(utsDot3OltP2pEnableVList, mbean.getUtsDot3OltP2pEnable()));
	tfUtsDot3OltOlpPort.setSelectedIndex(getIndexFromValue(utsDot3OltOlpPortVList, mbean.getUtsDot3OltOlpPort()));
//    tfUtsDot3OltPortONUSNumberSwitch.setSelectedIndex(getIndexFromValue(utsDot3OltPortONUSNumberSwitchVList, mbean.getUtsDot3OltPortONUSNumberSwitch().intValue()));
	tfUtsDot3OltPortONUAuthMode.setSelectedIndex(getIndexFromValue(utsDot3OltPortONUAuthModeVList, mbean.getUtsDot3OltPortONUAuthMode()));
    }

    public boolean validateFrom() {
	Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();
	if (mbean != null) {
	    Dot3Olt2PortTable bean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
	    if (bean != null) {
		bean.setUtsDot3OltModuleId(mbean.getUtsDot3OltModuleId() - 1);
		bean.setUtsDot3OltDeviceId(1);
		bean.setUtsDot3OltPortId(4);
		Vector v = BeanService.refreshTableBean(fApplication, bean);
		if (v != null) {
		    for (int i = 0; i < v.size(); i++) {
			Dot3Olt2PortTable one = (Dot3Olt2PortTable) v.get(i);
			if ((!one.getUtsDot3OltPortId().equals(mbean.getUtsDot3OltPortId())) && one.getUtsDot3OltOlpPort() == utsDot3OltOlpPortVList[tfUtsDot3OltOlpPort.getSelectedIndex()] && one.getUtsDot3OltOlpPort().intValue() != 0) {
			    String error = fStringMap.getString("Err_Olp_Is_Used");
			    MessageDialog.showErrorMessageDialog(fApplication, error);
			    return false;
			}
		    }
		}
	    }
	}
	if(utsDot3OltPortONUAuthModeVList[tfUtsDot3OltPortONUAuthMode.getSelectedIndex()] != mbean.getUtsDot3OltPortONUAuthMode()){
		isONUSAuthModeChanged = true;
	} else {
		isONUSAuthModeChanged = false;
      }
	if(isONUSAuthModeChanged){
        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("ONUAuthModeInfo_Take_Effect_After_Register"));
        //return false;
	}

	return true;
    }

    public void updateModel() {
    	Dot3Olt2PortTable mbean = (Dot3Olt2PortTable) getModel();
    	if (mbean == null)
    	    return;
    
    	// if change Admin Status from Up(1) to Down(2), reset all ONUs under it.
    	if (mbean.getUtsDot3OltAdminStatus() == 1 && utsDot3OltAdminStatusVList[tfUtsDot3OltAdminStatus.getSelectedIndex()] == 2) {
    	    try {
    		Dot3Onu2CtcTable onuTblMBean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
    		String thisOnuModuleId = mbean.getUtsDot3OltModuleId().toString();
    		String thisOnuDeviceId = mbean.getUtsDot3OltDeviceId().toString();
    		String thisOnuPortId = mbean.getUtsDot3OltPortId().toString();
    		onuTblMBean.setIndex(0, mbean.getUtsDot3OltModuleId());
    		onuTblMBean.setIndex(1, mbean.getUtsDot3OltDeviceId());
    		onuTblMBean.setIndex(2, mbean.getUtsDot3OltPortId());
    		onuTblMBean.setIndexPrefix(thisOnuModuleId + "." + thisOnuDeviceId + "." + thisOnuPortId);
    
    		Vector onuTblAllValues = onuTblMBean.retrieveAll();
    		for (int i = 0; i < onuTblAllValues.size(); i++) {
    		    Dot3Onu2CtcTable tmpOnuTblMBean = (Dot3Onu2CtcTable) onuTblAllValues.get(i);
    
    		    // only reset ONUs with register(1) state
    		    // if register state is not 1: register(1), prompt error message.
    		    if (tmpOnuTblMBean.getUtsDot3Onu2CtcRegisterStatus() != 1) {
    			continue;
    		    }
    
    		    tmpOnuTblMBean.setUtsDot3Onu2CtcReset(1);
    		    tmpOnuTblMBean.resetONU();
    		}
    	    } catch (MibBeanException e) {
    		e.printStackTrace();
    	    }
    	}
    
    	mbean.setUtsDot3OltAdminStatus(utsDot3OltAdminStatusVList[tfUtsDot3OltAdminStatus.getSelectedIndex()]);
    	// mbean.setUtsDot3OltRxFECEnable(utsDot3OltRxFECEnableVList[tfUtsDot3OltRxFECEnable.getSelectedIndex()]);
    	// mbean.setUtsDot3OltTransceiverTx(utsDot3OltTransceiverTxVList[tfUtsDot3OltTransceiverTx.getSelectedIndex()]);
    	// mbean.setUtsDot3OltTransceiverRx(utsDot3OltTransceiverRxVList[tfUtsDot3OltTransceiverRx.getSelectedIndex()]);
    	// mbean.setUtsDot3OltONUP2PEnable(utsDot3OltONUP2PEnableVList[tfUtsDot3OltONUP2PEnable.getSelectedIndex()]);
    	mbean.setUtsDot3OltMPCPGateBackoffTime(tfUtsDot3OltMPCPGateBackoffTime.getValue());
    	mbean.setUtsDot3OltP2pEnable(utsDot3OltP2pEnableVList[tfUtsDot3OltP2pEnable.getSelectedIndex()]);
    	mbean.setUtsDot3OltOlpPort(utsDot3OltOlpPortVList[tfUtsDot3OltOlpPort.getSelectedIndex()]);
//        if(utsDot3OltPortONUSNumberSwitchVList[tfUtsDot3OltPortONUSNumberSwitch.getSelectedIndex()] != mbean.getUtsDot3OltPortONUSNumberSwitch()) {
//            isONUSNumberSwitchChanged = true;
//            mbean.setUtsDot3OltPortONUSNumberSwitch(new Integer(utsDot3OltPortONUSNumberSwitchVList[tfUtsDot3OltPortONUSNumberSwitch.getSelectedIndex()]));
//        } else {
//            isONUSNumberSwitchChanged = false;
//        }
    	
    	mbean.setUtsDot3OltPortONUAuthMode(utsDot3OltPortONUAuthModeVList[tfUtsDot3OltPortONUAuthMode.getSelectedIndex()]);
    }

    public void afterUpdateModel() {
        
    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}

	return 0;
    }

}