package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3UnboundOnuTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2DbaGlbTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r216.Onu2TrafficProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2CtcValidOnuMacMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.onuprofilemgmt.common.intf.IAllProfileOperation;
import com.winnertel.em.onuprofilemgmt.common.model.OnuProfileAssignInfoModel;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressComboBoxEditor;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.inms.topoui.TopoMapContext;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

public class Dot3Onu2CtcValidOnuMacMPanel extends UPanel {
	private JLabel tfUtsDot3OnuValidOnuMacModuleId = new JLabel();
	private JLabel tfUtsDot3OnuValidOnuMacPortId = new JLabel();
	private JLabel tfUtsDot3OnuValidOnuMacAppLPortId = new JLabel();

	// private MacAddressField tfUtsDot3ValidOnuMacAddr = new MacAddressField();
	private JComboBox tfUtsDot3ValidOnuMacAddr = new JComboBox();

	private int[] utsDot3Onu2ConfiguredOnuTypeVList = new int[] { 17, 18, 19,
			21, 22, 24, 25, 29, 36, 38, 39, 40, 41, 42, 71, 73, 76, 77, 84, 85,
			86, 89, 91, 93, 95, 97, 98, 103, 104, 105, 106, 107, 108, /** 301, 302, 303, fix MR:ONS00043064 */ 401, 402, 200, };
	private String[] utsDot3Onu2ConfiguredOnuTypeTList = new String[] {
			fStringMap.getString("onu1001i"), fStringMap.getString("onu2004i"), fStringMap.getString("onu404i"), fStringMap.getString("onu204i"), 
			fStringMap.getString("onu208i"), fStringMap.getString("onu408t"), fStringMap.getString("onu2024i"), fStringMap.getString("onu804i"), 
			fStringMap.getString("onu4024i"), fStringMap.getString("onu101i"), fStringMap.getString("onub1205y"), fStringMap.getString("onub1205d"), 
			fStringMap.getString("onub130"), fStringMap.getString("onub1205"), fStringMap.getString("onu2004-2"), fStringMap.getString("onu208h"),
			fStringMap.getString("onu2016i-e"), fStringMap.getString("onu4016i-t A1B"), fStringMap.getString("onub1202"), fStringMap.getString("onu204ie"), 
			fStringMap.getString("onu204ih"), fStringMap.getString("onu204i-h-R-c1"), fStringMap.getString("onu404i-R-c1"), fStringMap.getString("onu204i-h-R-h1"), 
			fStringMap.getString("onu204i-k7-R-a2"), fStringMap.getString("onu204i-k7-R-a4"), fStringMap.getString("onu804i-R-c1"),
			fStringMap.getString("onu204i-k7-R-a7"), fStringMap.getString("onu204i-k7-R-a5"), fStringMap.getString("onu-clt2168"),
			fStringMap.getString("onu-clt2170"), fStringMap.getString("onu-c3160"), fStringMap.getString("onu204i-k7-R-b2"),fStringMap.getString("s1201"), fStringMap.getString("s1202"),
			/**fStringMap.getString("js24b-v"), fStringMap.getString("js04h-v"), fStringMap.getString("js16b-v"), fix MR:ONS00043064 */
			fStringMap.getString("unknow"), };
	private JComboBox tfUtsDot3Onu2ConfiguredOnuType = new JComboBox(
			utsDot3Onu2ConfiguredOnuTypeTList);

	private StringTextField tfUtsDot3Onu2LoidAuthLoid = new StringTextField();

	private StringTextField tfUtsDot3Onu2LoidAuthPassword = new StringTextField();

	private int[] utsDot3OnuAuthMethodVList = new int[] { 1, 2, 3, 4 };
	private String[] utsDot3OnuAuthMethodTList = new String[] {
			fStringMap.getString("mac"), // 1
			fStringMap.getString("loid"), // 2
			fStringMap.getString("hybrid"), // 3
			fStringMap.getString("AutomaticBinding"), // 4
	};
	private JComboBox tfUtsDot3OnuAuthMethod = new JComboBox(
			utsDot3OnuAuthMethodTList);

	private StringTextField tfUtsDot3OnuDescription = new StringTextField();

	private IntegerTextField tfUtsDot3OnuUpstreamPir = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuDownstreamPir = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuUpstreamCir = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuDownstreamCir = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuUpstreamMaxBurstSize = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuDownstreamMaxBurstSize = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuUpstreamWeight = new IntegerTextField();
	private IntegerTextField tfUtsDot3OnuUpstreamFir = new IntegerTextField();

	private JCheckBox cbDbaProfile = new JCheckBox();
	private ProfileChooser tfUtsDot3OnuAppliedDbaProfile = new ProfileChooser(
			fApplication);

	// private JLabel tfUtsDot3OnuMCastEntryMcVlanId = new JLabel();

//	private int[] utsDot3OnuMulticastSwitchVList = new int[] { 1, 2, 3, 4 };
//	private String[] utsDot3OnuMulticastSwitchTList = new String[] {
//			fStringMap.getString("ctc-specialSnooping"), // 1
//			fStringMap.getString("ctc-controlSnooping"), // 2
//			fStringMap.getString("standard-Snooping"), // 3
//			fStringMap.getString("disable"), // 4
//	};
//	private JComboBox tfUtsDot3OnuMulticastSwitch = new JComboBox(
//			utsDot3OnuMulticastSwitchTList);

//	private int[] utsDot3Onu2FastLeaveAdminControlVList = new int[] { 1, 2, };
//	private String[] utsDot3Onu2FastLeaveAdminControlTList = new String[] {
//			fStringMap.getString("disable"), fStringMap.getString("enable"), };
//	private JComboBox tfUtsDot3Onu2FastLeaveAdminControl = new JComboBox(
//			utsDot3Onu2FastLeaveAdminControlTList);

	private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr = new IPAddressField(IPAddressField.IPAll);
	private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfIpMask = new IPAddressField(IPAddressField.IPMASK);
	private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfGw = new IPAddressField(IPAddressField.IPAll);
	private IntegerTextField tfUtsDot3Onu2CtcMduMgmtIpConfCvlan = new IntegerTextField();
	private IntegerTextField tfUtsDot3Onu2CtcMduMgmtIpConfSvlan = new IntegerTextField();

	private final String utsDot3OnuValidOnuMacModuleId = fStringMap
			.getString("utsDot3OnuValidOnuMacModuleId")
			+ " : ";
	private final String utsDot3OnuValidOnuMacPortId = fStringMap
			.getString("utsDot3OnuValidOnuMacPortId")
			+ " : ";
	private final String utsDot3OnuValidOnuMacAppLPortId = fStringMap
			.getString("utsDot3OnuValidOnuMacAppLPortId")
			+ " : ";
	private final String utsDot3ValidOnuMacAddr = fStringMap
			.getString("utsDot3ValidOnuMacAddr")
			+ " : ";
	private final String utsDot3Onu2ConfiguredOnuType = fStringMap
			.getString("utsDot3Onu2ConfiguredOnuType")
			+ " : ";
	private final String utsDot3Onu2LoidAuthLoid = fStringMap
			.getString("utsDot3Onu2LoidAuthLoid")
			+ " : ";
	private final String utsDot3Onu2LoidAuthPassword = fStringMap
			.getString("utsDot3Onu2LoidAuthPassword")
			+ " : ";
	private final String utsDot3OnuAuthMethod = fStringMap
			.getString("utsDot3OnuAuthMethod")
			+ " : ";
	private final String utsDot3OnuDescription = fStringMap
			.getString("utsDot3OnuDescription")
			+ " : ";

	private final String utsDot3OnuUpstreamPir = fStringMap
			.getString("utsDot3OnuUpstreamPir")
			+ " : ";
	private final String utsDot3OnuDownstreamPir = fStringMap
			.getString("utsDot3OnuDownstreamPir")
			+ " : ";
	private final String utsDot3OnuUpstreamCir = fStringMap
			.getString("utsDot3OnuUpstreamCir")
			+ " : ";
	private final String utsDot3OnuDownstreamCir = fStringMap
			.getString("utsDot3OnuDownstreamCir")
			+ " : ";
	private final String utsDot3OnuUpstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuUpstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuDownstreamMaxBurstSize = fStringMap
			.getString("utsDot3OnuDownstreamMaxBurstSize")
			+ " : ";
	private final String utsDot3OnuUpstreamWeight = fStringMap
			.getString("utsDot3OnuUpstreamWeight")
			+ " : ";
	private final String utsDot3OnuUpstreamFir = fStringMap
			.getString("utsDot3OnuUpstreamFir")
			+ " : ";
	private final String utsDot3OnuAppliedDbaProfile = fStringMap
			.getString("utsDot3OnuAppliedDbaProfile")
			+ " : ";

//	private final String utsDot3OnuMCastEntryMcVlanId = fStringMap
//			.getString("utsDot3OnuMCastEntryMcVlanId")
//			+ " : ";
//	private final String utsDot3OnuMulticastSwitch = fStringMap
//			.getString("utsDot3OnuMulticastSwitch")
//			+ " : ";
//	private final String utsDot3Onu2FastLeaveAdminControl = fStringMap
//			.getString("utsDot3Onu2FastLeaveAdminControl")
//			+ " : ";

	private final String utsDot3Onu2CtcMduMgmtIpConfIpAddr = fStringMap
			.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr")
			+ ": ";
	private final String utsDot3Onu2CtcMduMgmtIpConfIpMask = fStringMap
			.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask")
			+ ": ";
	private final String utsDot3Onu2CtcMduMgmtIpConfGw = fStringMap
			.getString("utsDot3Onu2CtcMduMgmtIpConfGw")
			+ ": ";
	private final String utsDot3Onu2CtcMduMgmtIpConfCvlan = fStringMap
			.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan")
			+ ": ";
	private final String utsDot3Onu2CtcMduMgmtIpConfSvlan = fStringMap
			.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan")
			+ ": ";

	public Dot3Onu2CtcValidOnuMacMPanel(IApplication app) {
		super(app);
		init();
	}

	public void initGui() {
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(13, 5, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacModuleId));
		baseInfoPanel.add(tfUtsDot3OnuValidOnuMacModuleId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacPortId));
		baseInfoPanel.add(tfUtsDot3OnuValidOnuMacPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacAppLPortId));
		baseInfoPanel.add(tfUtsDot3OnuValidOnuMacAppLPortId);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDescription));
        baseInfoPanel.add(tfUtsDot3OnuDescription);
        baseInfoPanel.add(new HSpacer());
        
		baseInfoPanel.add(new JLabel(utsDot3Onu2ConfiguredOnuType));
		baseInfoPanel.add(tfUtsDot3Onu2ConfiguredOnuType);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuAuthMethod));
        baseInfoPanel.add(tfUtsDot3OnuAuthMethod);
        tfUtsDot3OnuAuthMethod.setEnabled(false);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3ValidOnuMacAddr));
        tfUtsDot3ValidOnuMacAddr.setEditor(new MacAddressComboBoxEditor());
        tfUtsDot3ValidOnuMacAddr.setEditable(true);
        tfUtsDot3ValidOnuMacAddr.setName(fStringMap
                .getString("utsDot3ValidOnuMacAddr"));
        baseInfoPanel.add(tfUtsDot3ValidOnuMacAddr);
        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new VSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthLoid));
		baseInfoPanel.add(tfUtsDot3Onu2LoidAuthLoid);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthPassword));
		baseInfoPanel.add(tfUtsDot3Onu2LoidAuthPassword);
		baseInfoPanel.add(new HSpacer());

		cbDbaProfile.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tfUtsDot3OnuAppliedDbaProfile.setEnabled(cbDbaProfile.isSelected());
				tfUtsDot3OnuUpstreamPir.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuDownstreamPir.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuUpstreamCir.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuDownstreamCir.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuUpstreamMaxBurstSize.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuDownstreamMaxBurstSize.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuUpstreamWeight.setEnabled(!cbDbaProfile.isSelected());
				tfUtsDot3OnuUpstreamFir.setEnabled(!cbDbaProfile.isSelected());
			}
		});

		cbDbaProfile.setText(utsDot3OnuAppliedDbaProfile);
		tfUtsDot3OnuAppliedDbaProfile.setEnabled(false);
		baseInfoPanel.add(cbDbaProfile);
		tfUtsDot3OnuAppliedDbaProfile.setName(fStringMap.getString("utsDot3OnuAppliedDbaProfile"));
		baseInfoPanel.add(tfUtsDot3OnuAppliedDbaProfile);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		tfUtsDot3OnuAppliedDbaProfile.setEnabled(true);
		tfUtsDot3OnuAppliedDbaProfile.setProfile("OnuDbaProfileTable_Panel");

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamPir));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamPir);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamPir));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamPir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamCir));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamCir);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamCir));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamCir);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamMaxBurstSize));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamMaxBurstSize);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamMaxBurstSize));
		baseInfoPanel.add(tfUtsDot3OnuDownstreamMaxBurstSize);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamWeight));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamWeight);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamFir));
		baseInfoPanel.add(tfUtsDot3OnuUpstreamFir);
		baseInfoPanel.add(new HSpacer());

		// baseInfoPanel.add(new JLabel(utsDot3OnuMCastEntryMcVlanId));
		// baseInfoPanel.add(tfUtsDot3OnuMCastEntryMcVlanId);
		// baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3OnuMulticastSwitch));
//		baseInfoPanel.add(tfUtsDot3OnuMulticastSwitch);
//		baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsDot3Onu2FastLeaveAdminControl));
//		baseInfoPanel.add(tfUtsDot3Onu2FastLeaveAdminControl);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
		tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.setName(fStringMap
				.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfIpMask));
		tfUtsDot3Onu2CtcMduMgmtIpConfIpMask.setName(fStringMap
				.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfIpMask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfGw));
		tfUtsDot3Onu2CtcMduMgmtIpConfGw.setName(fStringMap
				.getString("utsDot3Onu2CtcMduMgmtIpConfGw"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfGw);
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new VSpacer());
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfCvlan));
		tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setName(fStringMap
				.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfCvlan);
//		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfSvlan));
		tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setName(fStringMap
				.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan"));
		baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfSvlan);
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
		tfUtsDot3OnuUpstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamPir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuDownstreamCir.setValueScope(1, 1000000);
		tfUtsDot3OnuUpstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuDownstreamMaxBurstSize.setValueScope(1, 1000);
		tfUtsDot3OnuUpstreamWeight.setValueScope(1, 10);
		tfUtsDot3OnuUpstreamFir.setValueScope(0, 1000000);

		tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setValueScope(1, 4094);
		tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValueScope(0, 4094);
		tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValue(0);

	}

	public boolean validateFrom() {
		if (cbDbaProfile.isSelected())
			return true;

		if (tfUtsDot3OnuUpstreamCir.getValue() > tfUtsDot3OnuUpstreamPir.getValue()) {
			String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		if (tfUtsDot3OnuDownstreamCir.getValue() > tfUtsDot3OnuDownstreamPir.getValue()) {
			String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
			MessageDialog.showErrorMessageDialog(fApplication, error);
			return false;
		}

		Dot3Onu2CtcValidOnuMacMBean bean = (Dot3Onu2CtcValidOnuMacMBean) getModel();
		if (bean == null)
			return false;

        int module = bean.getUtsDot3OnuValidOnuMacModuleId();
        int port = bean.getUtsDot3OnuValidOnuMacPortId();
        int onu = bean.getUtsDot3OnuValidOnuMacAppLPortId();

        // chect the LOID whether exist or be used
//        if((bean.getUtsDot3OnuAuthMethod()==2) && ("".equals(tfUtsDot3Onu2LoidAuthLoid.getText()) || "".equals(tfUtsDot3Onu2LoidAuthPassword.getText()))){
//    		MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("LOID and Password can't be null."));
//            return false;
//    	}
//        if(bean.getUtsDot3OnuAuthMethod()==3){
//        	String currMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
//        	if((currMacAddress == null || (("00:00:00:00:00:00").equalsIgnoreCase(currMacAddress)))
//        			&& ((tfUtsDot3Onu2LoidAuthLoid.getText() == null || "".equals(tfUtsDot3Onu2LoidAuthLoid.getText()))
//        			|| (tfUtsDot3Onu2LoidAuthLoid.getText() == null || "".equals(tfUtsDot3Onu2LoidAuthLoid.getText())))) {
//				MessageDialog.showInfoMessageDialog(fApplication, fStringMap
//						.getString("utsDot3ValidOnuMacAddr")
//						+ fStringMap
//								.getString("and LOID or LOID Password can't be null at the same time."));
//        		return false;
//        	}
//            return true;
//    	}
        
        Dot3Onu2CtcValidOnuMacTable tableBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
        tableBean.setIndex(0, bean.getIndex(0));
    	tableBean.setIndex(1, bean.getIndex(1));
    	tableBean.setIndex(2, bean.getIndex(2)); 
    	tableBean.setIndexPrefix(bean.getIndex(0)+"."+bean.getIndex(1)+"."+bean.getIndex(2));
        Vector vect = BeanService.refreshTableBean(fApplication, tableBean);
        if (vect != null) {
            for (int i = 0; i < vect.size(); i++) {
            	Dot3Onu2CtcValidOnuMacTable tmp=(Dot3Onu2CtcValidOnuMacTable) vect.get(i);
            	if(tmp.getIndex(0).equals(bean.getIndex(0))
            			&& tmp.getIndex(1).equals(bean.getIndex(1))
            			&& tmp.getIndex(2).equals(bean.getIndex(2))
            			&& tmp.getIndex(3).equals(bean.getIndex(3))){
            		continue;
            	}
                String s = ((Dot3Onu2CtcValidOnuMacTable) vect.get(i)).getUtsDot3Onu2LoidAuthLoid();
                if (s.trim().length()!=0 && tfUtsDot3Onu2LoidAuthLoid.getText().trim().length() != 0 && 
                		(bean.getUtsDot3OnuAuthMethod()==2 || bean.getUtsDot3OnuAuthMethod()==3) && (s.equalsIgnoreCase(tfUtsDot3Onu2LoidAuthLoid.getText()))) {
                    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("LOID has been used."));
                    return false;
                }
            }
        }
        
        // check the input MAC whether it exist in MAC list
        String currMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
        if (currMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(currMacAddress))) {
            SnmpTableModel model = (SnmpTableModel)fTable.getModel();

            for(int i = 0; i < model.getRowCount(); i++) {
                Dot3Onu2CtcValidOnuMacMBean row = (Dot3Onu2CtcValidOnuMacMBean)model.getRow(i);

                byte[] b = row.getUtsDot3ValidOnuMacAddr();
                String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");

                if(row.getUtsDot3OnuValidOnuMacModuleId().intValue() != bean.getUtsDot3OnuValidOnuMacModuleId().intValue() &&
                        row.getUtsDot3OnuValidOnuMacPortId().intValue() != bean.getUtsDot3OnuValidOnuMacPortId().intValue() &&
                        row.getUtsDot3OnuValidOnuMacAppLPortId().intValue() != bean.getUtsDot3OnuValidOnuMacAppLPortId().intValue() &&
                        macAddress.equals(currMacAddress)) {
                    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
                    return false;
                }
            }
        }


		int usTotalCommit = 0;
		int dsTotalCommit = 0;

		Onu2TrafficProfTable mbean = new Onu2TrafficProfTable(fApplication.getSnmpProxy());

		/* The port ifIndex is the previous row data. */
		mbean.setUtsDot3OnuTProfModuleId(bean
				.getUtsDot3OnuValidOnuMacModuleId());
		mbean.setUtsDot3OnuTProfDeviceId(bean
				.getUtsDot3OnuValidOnuMacDeviceId());
		mbean.setUtsDot3OnuTProfPortId(bean.getUtsDot3OnuValidOnuMacPortId());
		mbean.setUtsDot3OnuTProfLogicalPortId(0);

		mbean.setRowsToFetch(64);
		Vector v = BeanService.refreshTableBean(fApplication, mbean);

		if (v != null) {
			for (int i = 0; i < v.size(); i++) {
				Onu2TrafficProfTable one = (Onu2TrafficProfTable) v.get(i);
				if (one.getUtsDot3OnuTProfModuleId() == module
						&& one.getUtsDot3OnuTProfPortId() == port
						&& one.getUtsDot3OnuTProfLogicalPortId() != onu) {
					usTotalCommit += one.getUtsDot3OnuUpstreamCir();
					dsTotalCommit += one.getUtsDot3OnuDownstreamCir();
				}
			}

			int usLeftCommit = 1000000 - usTotalCommit;
			int dsLeftCommit = 1000000 - dsTotalCommit;
			if (tfUtsDot3OnuUpstreamCir.getValue() > usLeftCommit) {
				String error = fStringMap
						.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
						+ module
						+ "/"
						+ port
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
						+ "\r\n"
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3")
						+ usLeftCommit
						+ fStringMap
								.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");
				MessageDialog.showErrorMessageDialog(fApplication, error);
				return false;
			}

			if (tfUtsDot3OnuDownstreamCir.getValue() > dsLeftCommit) {
				String error = fStringMap
						.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
						+ module
						+ "/"
						+ port
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2")
						+ "\r\n"
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_3")
						+ usLeftCommit
						+ fStringMap
								.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_4");
				MessageDialog.showErrorMessageDialog(fApplication, error);
				return false;
			}
		}

		return true;
	}

	public void refresh() {
		tfUtsDot3Onu2LoidAuthLoid.setEnabled(true);
		tfUtsDot3Onu2LoidAuthPassword.setEnabled(true);
		tfUtsDot3ValidOnuMacAddr.setEnabled(true);

		Dot3Onu2CtcValidOnuMacMBean mbean = (Dot3Onu2CtcValidOnuMacMBean) getModel();
		if (mbean == null)
			return;	
		
		tfUtsDot3OnuAppliedDbaProfile.refresh();
		// tfUtsDot3OnuAppliedDbaProfile.setSelectedProfileIndex(1);

		tfUtsDot3OnuValidOnuMacModuleId.setText(mbean
				.getUtsDot3OnuValidOnuMacModuleId().toString());
		tfUtsDot3OnuValidOnuMacPortId.setText(mbean
				.getUtsDot3OnuValidOnuMacPortId().toString());
		tfUtsDot3OnuValidOnuMacAppLPortId.setText(mbean
				.getUtsDot3OnuValidOnuMacAppLPortId().toString());

		// retrieve the ONU MAC List from OLT.
		Dot3UnboundOnuTable unboundmbean = new Dot3UnboundOnuTable(fApplication
				.getSnmpProxy());
		Vector macs = null;
		try {
			// filter ONU MAC List by card and port ID.
			unboundmbean.setIndexPrefix(mbean
					.getUtsDot3OnuValidOnuMacModuleId()
					+ "." + mbean.getUtsDot3OnuValidOnuMacPortId() + ".");
			macs = unboundmbean.retrieveAll();
		} catch (MibBeanException e) {
			e.printStackTrace();
		}

		tfUtsDot3ValidOnuMacAddr.removeAllItems();
		tfUtsDot3ValidOnuMacAddr.addItem("00:00:00:00:00:00");
		if (macs != null) {
			for (int i = 0; i < macs.size(); i++)
				tfUtsDot3ValidOnuMacAddr
						.addItem(OctetToMacAddress(((Dot3UnboundOnuTable) macs
								.get(i)).getUtsDot3UnboundOnuPonMacAddr()));
		}
		((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor())
				.setValue(mbean.getUtsDot3ValidOnuMacAddr());
		((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor())
				.setValue(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr
						.getEditor()).getMacString().toUpperCase());
		// tfUtsDot3ValidOnuMacAddr.setValue(mbean.getUtsDot3ValidOnuMacAddr());

		tfUtsDot3Onu2ConfiguredOnuType.setSelectedIndex(getIndexFromValue(
				utsDot3Onu2ConfiguredOnuTypeVList, mbean
						.getUtsDot3Onu2ConfiguredOnuType().intValue()));
		tfUtsDot3Onu2LoidAuthLoid.setText(mbean.getUtsDot3Onu2LoidAuthLoid()
				.toString());
		tfUtsDot3Onu2LoidAuthPassword.setValue(mbean
				.getUtsDot3Onu2LoidAuthPassword());

		tfUtsDot3OnuAuthMethod.setSelectedIndex(getIndexFromValue(
				utsDot3OnuAuthMethodVList, mbean.getUtsDot3OnuAuthMethod()
						.intValue()));
		tfUtsDot3OnuDescription.setValue(mbean.getUtsDot3OnuDescription());

		if (mbean.getUtsDot3OnuUpstreamPir() != null)
			tfUtsDot3OnuUpstreamPir.setValue(mbean.getUtsDot3OnuUpstreamPir());
		else
			tfUtsDot3OnuUpstreamPir.setText("");
		if (mbean.getUtsDot3OnuDownstreamPir() != null)
			tfUtsDot3OnuDownstreamPir.setValue(mbean
					.getUtsDot3OnuDownstreamPir());
		else
			tfUtsDot3OnuDownstreamPir.setText("");
		if (mbean.getUtsDot3OnuUpstreamCir() != null)
			tfUtsDot3OnuUpstreamCir.setValue(mbean.getUtsDot3OnuUpstreamCir());
		else
			tfUtsDot3OnuUpstreamCir.setText("");
		if (mbean.getUtsDot3OnuDownstreamCir() != null)
			tfUtsDot3OnuDownstreamCir.setValue(mbean
					.getUtsDot3OnuDownstreamCir());
		else
			tfUtsDot3OnuDownstreamCir.setText("");
		if (mbean.getUtsDot3OnuUpstreamMaxBurstSize() != null)
			tfUtsDot3OnuUpstreamMaxBurstSize.setValue(mbean
					.getUtsDot3OnuUpstreamMaxBurstSize());
		else
			tfUtsDot3OnuUpstreamMaxBurstSize.setText("");
		if (mbean.getUtsDot3OnuDownstreamMaxBurstSize() != null)
			tfUtsDot3OnuDownstreamMaxBurstSize.setValue(mbean
					.getUtsDot3OnuDownstreamMaxBurstSize());
		else
			tfUtsDot3OnuDownstreamMaxBurstSize.setText("");
		if (mbean.getUtsDot3OnuUpstreamWeight() != null)
			tfUtsDot3OnuUpstreamWeight.setValue(mbean
					.getUtsDot3OnuUpstreamWeight());
		else
			tfUtsDot3OnuUpstreamWeight.setText("");
		if (mbean.getUtsDot3OnuUpstreamFir() != null)
			tfUtsDot3OnuUpstreamFir.setValue(mbean.getUtsDot3OnuUpstreamFir());
		else
			tfUtsDot3OnuUpstreamFir.setText("");
		if (mbean.getUtsDot3OnuAppliedDbaProfile() != null)
			tfUtsDot3OnuAppliedDbaProfile.setSelectedProfileIndex(mbean
					.getUtsDot3OnuAppliedDbaProfile());
		else
			tfUtsDot3OnuAppliedDbaProfile.setSelectedProfileIndex(0);

		// tfUtsDot3OnuMCastEntryMcVlanId.setText(mbean
		// .getUtsDot3OnuMCastEntryMcVlanIdList() != null ? mbean
		// .getUtsDot3OnuMCastEntryMcVlanIdList().toString() : "");
//		if (mbean.getUtsDot3Onu2FastLeaveAdminControl() != null)
//			tfUtsDot3Onu2FastLeaveAdminControl
//					.setSelectedIndex(getIndexFromValue(
//							utsDot3Onu2FastLeaveAdminControlVList, mbean
//									.getUtsDot3Onu2FastLeaveAdminControl()
//									.intValue()));
//		else
//			tfUtsDot3Onu2FastLeaveAdminControl.setSelectedIndex(-1);

        if (mbean.getUtsDot3OnuAuthMethod() == 1) {//mac
            tfUtsDot3ValidOnuMacAddr.setEnabled(true);
			tfUtsDot3Onu2LoidAuthLoid.setEnabled(false);
			tfUtsDot3Onu2LoidAuthPassword.setEnabled(false);
        } else if (mbean.getUtsDot3OnuAuthMethod() == 2) {//loid
            tfUtsDot3ValidOnuMacAddr.setEnabled(false);
            tfUtsDot3Onu2LoidAuthLoid.setEnabled(true);
            tfUtsDot3Onu2LoidAuthPassword.setEnabled(true);
        } else if (mbean.getUtsDot3OnuAuthMethod() == 3) {//hybrid
            tfUtsDot3ValidOnuMacAddr.setEnabled(true);
            tfUtsDot3Onu2LoidAuthLoid.setEnabled(true);
            tfUtsDot3Onu2LoidAuthPassword.setEnabled(true);
        } else if (mbean.getUtsDot3OnuAuthMethod() == 4) {//auto
            tfUtsDot3ValidOnuMacAddr.setEnabled(false);
            tfUtsDot3Onu2LoidAuthLoid.setEnabled(false);
            tfUtsDot3Onu2LoidAuthPassword.setEnabled(false);
        }

		tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.setValue(mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() != null ? mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() : "");
		tfUtsDot3Onu2CtcMduMgmtIpConfIpMask.setValue(mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfIpMask() != null ? mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfIpMask() : "");
		tfUtsDot3Onu2CtcMduMgmtIpConfGw.setValue(mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfGw() != null ? mbean
				.getUtsDot3Onu2CtcMduMgmtIpConfGw() : "");

		if (mbean.getUtsDot3Onu2CtcMduMgmtIpConfCvlan() != null)
			tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setValue(mbean
					.getUtsDot3Onu2CtcMduMgmtIpConfCvlan());
		if (mbean.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() != null)
			tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValue((mbean
					.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() >= 0 && mbean
					.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() <= 4094) ? mbean
					.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() : 0);
		
		
		try {
			Dot3Olt2DbaGlbTable dbaBean = new Dot3Olt2DbaGlbTable(this.fApplication.getSnmpProxy());
			dbaBean.setUtsDot3OltModuleId(mbean.getUtsDot3OnuValidOnuMacModuleId());
			dbaBean.setUtsDot3OltDeviceId(mbean.getUtsDot3OnuValidOnuMacDeviceId());
			dbaBean.retrieve();
			if(dbaBean.getUtsDot3OltDbaMode() == 2) {
				tfUtsDot3OnuUpstreamFir.setEnabled(true);
			}
			else {
				tfUtsDot3OnuUpstreamFir.setEnabled(false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public void updateModel() {
		Dot3Onu2CtcValidOnuMacMBean mbean = (Dot3Onu2CtcValidOnuMacMBean) getModel();
		if (mbean == null)
			return;

		if (tfUtsDot3ValidOnuMacAddr.isEnabled())
			mbean
					.setUtsDot3ValidOnuMacAddr(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr
							.getEditor()).getValue());
		else
			mbean.setUtsDot3ValidOnuMacAddr(null);
		mbean
				.setUtsDot3Onu2ConfiguredOnuType(new Integer(
						utsDot3Onu2ConfiguredOnuTypeVList[tfUtsDot3Onu2ConfiguredOnuType
								.getSelectedIndex()]));

		if (tfUtsDot3Onu2LoidAuthLoid.isEnabled())
			mbean.setUtsDot3Onu2LoidAuthLoid(tfUtsDot3Onu2LoidAuthLoid
					.getValue());
		else
			mbean.setUtsDot3Onu2LoidAuthLoid(null);
		if (tfUtsDot3Onu2LoidAuthPassword.isEnabled())
			mbean.setUtsDot3Onu2LoidAuthPassword(tfUtsDot3Onu2LoidAuthPassword
					.getValue());
		else
			mbean.setUtsDot3Onu2LoidAuthPassword(null);
		mbean.setUtsDot3OnuDescription(tfUtsDot3OnuDescription.getValue());

		if (cbDbaProfile.isSelected()) {
			// Onu2TrafficProfTable trafficBean =
			// mbean.getTrafficProfTableBean();
			if (tfUtsDot3OnuAppliedDbaProfile.isEnabled()) {
				Onu2TrafficProfTable trafficBean = new Onu2TrafficProfTable(
						fApplication.getSnmpProxy());
				trafficBean.setUtsDot3OnuTProfModuleId(mbean
						.getUtsDot3OnuValidOnuMacModuleId());
				trafficBean.setUtsDot3OnuTProfDeviceId(mbean
						.getUtsDot3OnuValidOnuMacDeviceId());
				trafficBean.setUtsDot3OnuTProfPortId(mbean
						.getUtsDot3OnuValidOnuMacPortId());
				trafficBean.setUtsDot3OnuTProfLogicalPortId(mbean
						.getUtsDot3OnuValidOnuMacAppLPortId());
				trafficBean.setUtsDot3OnuAppliedDbaProfile(0); //clear selected profile
                try {
                	trafficBean.modify();
                } catch (MibBeanException e) {
                    e.printStackTrace();
                }
                
				trafficBean
						.setUtsDot3OnuAppliedDbaProfile(tfUtsDot3OnuAppliedDbaProfile
								.getSelectedProfileIndex() >= 0 ? ((int) tfUtsDot3OnuAppliedDbaProfile
								.getSelectedProfileIndex())
								: 0); // clear selected
				// profile
				try {
					trafficBean.modify();
				} catch (MibBeanException e) {
					e.printStackTrace();
				}
			}
			mbean.setUtsDot3OnuAppliedDbaProfile(null);
		} else {
			if (tfUtsDot3OnuUpstreamPir.getText().length() != 0)
				mbean.setUtsDot3OnuUpstreamPir(tfUtsDot3OnuUpstreamPir
						.getValue());
			if (tfUtsDot3OnuDownstreamPir.getText().length() != 0)
				mbean.setUtsDot3OnuDownstreamPir(tfUtsDot3OnuDownstreamPir
						.getValue());
			if (tfUtsDot3OnuUpstreamCir.getText().length() != 0)
				mbean.setUtsDot3OnuUpstreamCir(tfUtsDot3OnuUpstreamCir
						.getValue());
			if (tfUtsDot3OnuDownstreamCir.getText().length() != 0)
				mbean.setUtsDot3OnuDownstreamCir(tfUtsDot3OnuDownstreamCir
						.getValue());
			if (tfUtsDot3OnuUpstreamMaxBurstSize.getText().length() != 0)
				mbean
						.setUtsDot3OnuUpstreamMaxBurstSize(tfUtsDot3OnuUpstreamMaxBurstSize
								.getValue());
			if (tfUtsDot3OnuDownstreamMaxBurstSize.getText().length() != 0)
				mbean
						.setUtsDot3OnuDownstreamMaxBurstSize(tfUtsDot3OnuDownstreamMaxBurstSize
								.getValue());
			if (tfUtsDot3OnuUpstreamWeight.getText().length() != 0)
				mbean.setUtsDot3OnuUpstreamWeight(tfUtsDot3OnuUpstreamWeight
						.getValue());
			if ((tfUtsDot3OnuUpstreamFir.getText().length() != 0) && tfUtsDot3OnuUpstreamFir.isEnabled())
				mbean.setUtsDot3OnuUpstreamFir(tfUtsDot3OnuUpstreamFir
						.getValue());
			else 
				mbean.setUtsDot3OnuUpstreamFir(null);
			
			if (tfUtsDot3OnuUpstreamPir.getText().length() != 0
					|| tfUtsDot3OnuDownstreamPir.getText().length() != 0
					|| tfUtsDot3OnuUpstreamCir.getText().length() != 0
					|| tfUtsDot3OnuDownstreamCir.getText().length() != 0
					|| tfUtsDot3OnuUpstreamMaxBurstSize.getText().length() != 0
					|| tfUtsDot3OnuDownstreamMaxBurstSize.getText().length() != 0
					|| tfUtsDot3OnuUpstreamWeight.getText().length() != 0)
				mbean.setUtsDot3OnuAppliedDbaProfile(0);
		}
//		if (tfUtsDot3Onu2FastLeaveAdminControl.getSelectedIndex() != -1)
//			mbean
//					.setUtsDot3Onu2FastLeaveAdminControl(new Integer(
//							utsDot3Onu2FastLeaveAdminControlVList[tfUtsDot3Onu2FastLeaveAdminControl
//									.getSelectedIndex()]));

		mbean
				.setUtsDot3Onu2CtcMduMgmtIpConfIpAddr(tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr
						.getIPString());
		mbean
				.setUtsDot3Onu2CtcMduMgmtIpConfIpMask(tfUtsDot3Onu2CtcMduMgmtIpConfIpMask
						.getIPString());
		mbean.setUtsDot3Onu2CtcMduMgmtIpConfGw(tfUtsDot3Onu2CtcMduMgmtIpConfGw
				.getIPString());

		mbean
				.setUtsDot3Onu2CtcMduMgmtIpConfCvlan(tfUtsDot3Onu2CtcMduMgmtIpConfCvlan
						.getValue());
		mbean
				.setUtsDot3Onu2CtcMduMgmtIpConfSvlan(tfUtsDot3Onu2CtcMduMgmtIpConfSvlan
						.getValue());

	}

	public static String OctetToMacAddress(byte[] value) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			byte b = value[i];
			if (b >= 0 && b < 16) {
				sb.append('0');
			}

			int bi = value[i] & 0xff;
			sb.append(Integer.toHexString(bi).toUpperCase());

			if (i < value.length - 1) {
				sb.append(":");
			}
		}

		return sb.toString();
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}

		return 0;
	}

	   public static IAllProfileOperation profileOpration=null;
	   
	    protected void delBindLogicalPort(String neName,String logicalPort){
			if(profileOpration==null){
				String url="rmi://"+TopoMapContext.getHostname()+":"+ TopoMapContext.getRmiport();
				url+="/onuprofile_allops";
				try {
					profileOpration = (IAllProfileOperation) Naming.lookup(url);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				}  
			}
			try {
				profileOpration.delBindLogicalPort(neName, logicalPort);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	    }
			
	    protected void updateBindLogicalTable(OnuProfileAssignInfoModel bindLogicalPort){
			if(profileOpration==null){
				String url="rmi://"+TopoMapContext.getHostname()+":"+TopoMapContext.getRmiport();
				url+="/onuprofile_allops";
				try {
					profileOpration = (IAllProfileOperation) Naming.lookup(url);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				}  
			}
			try {
				profileOpration.addOrUpdateBindLogicalPortFrmValidOnuMacTable(bindLogicalPort);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	    }
	    
	    public void afterUpdateModel() {
	    	Dot3Onu2CtcValidOnuMacMBean mbean = (Dot3Onu2CtcValidOnuMacMBean) getModel();
	    	Dot3Onu2CtcValidOnuMacMBean newValueBean=new Dot3Onu2CtcValidOnuMacMBean(fApplication.getSnmpProxy());
	    	newValueBean.setUtsDot3OnuValidOnuMacDeviceId(mbean.getUtsDot3OnuValidOnuMacDeviceId());
	    	newValueBean.setUtsDot3OnuValidOnuMacModuleId(mbean.getUtsDot3OnuValidOnuMacModuleId());
	    	newValueBean.setUtsDot3OnuValidOnuMacPortId(mbean.getUtsDot3OnuValidOnuMacPortId());
	    	newValueBean.setUtsDot3OnuValidOnuMacAppLPortId(mbean.getUtsDot3OnuValidOnuMacAppLPortId());
	    	
	    	try {
				newValueBean.retrieve();
			} catch (MibBeanException e) {
				e.printStackTrace();
				return ;
			}
			String mac=OctetToMacAddress(newValueBean.getUtsDot3ValidOnuMacAddr()).toLowerCase();
			String loid=newValueBean.getUtsDot3Onu2LoidAuthLoid();
			
			String neName=this.fApplication.getMainApplet().getParameter("neName");
			String logicalPort="1-"+mbean.getUtsDot3OnuValidOnuMacModuleId()+"-"+mbean.getUtsDot3OnuValidOnuMacPortId()+"-"+mbean.getUtsDot3OnuValidOnuMacAppLPortId();
			
//			if( (mac==null && loid==null)
//					|| (mac==null && "".equals(loid))
//					|| ("00:00:00:00:00:00".equals(mac) && loid==null) 
//					|| ("00:00:00:00:00:00".equals(mac) && "".equals(loid)) ){
			if( ((mac==null) && (loid==null || "".equals(loid))) 
					|| ("00:00:00:00:00:00".equals(mac) && (loid==null || "".equals(loid)))) {
					delBindLogicalPort(neName, logicalPort);
				return;
			}
			
			
			
			OnuProfileAssignInfoModel bindLogicalPortModel=new OnuProfileAssignInfoModel();
			bindLogicalPortModel.setOltname(neName);
			bindLogicalPortModel.setLogicalport(logicalPort);
			bindLogicalPortModel.setOnumac(mac);
			bindLogicalPortModel.setLoid(loid);
			bindLogicalPortModel.setOnudesc(newValueBean.getUtsDot3OnuDescription());
			bindLogicalPortModel.setOlttype(this.fApplication.getMainApplet().getParameter("neType"));
			bindLogicalPortModel.setOnutype(Integer.toString(newValueBean.getUtsDot3Onu2ConfiguredOnuType()));
			bindLogicalPortModel.setAuthmode(newValueBean.getUtsDot3OnuAuthMethod());
			//bindLogicalPortModel.setOnulabel(newValueBean.getOnuLabel());
			bindLogicalPortModel.setOltip(this.fApplication.getMainApplet().getParameter("NodeIPAddress"));
			
			updateBindLogicalTable(bindLogicalPortModel);
			
	    }

}
