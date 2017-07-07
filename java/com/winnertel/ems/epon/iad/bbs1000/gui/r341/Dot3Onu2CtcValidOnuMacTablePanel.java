package com.winnertel.ems.epon.iad.bbs1000.gui.r341;

import com.winnertel.ems.epon.iad.bbs1000.mib.r341.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3UnboundOnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.UTable;
import com.winnertel.em.framework.gui.swing.UTableModel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.onuprofilemgmt.common.intf.IAllProfileOperation;
import com.winnertel.em.onuprofilemgmt.common.model.OnuProfileAssignInfoModel;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.MacAddressComboBoxEditor;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.inms.topoui.TopoMapContext;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

public class Dot3Onu2CtcValidOnuMacTablePanel extends UPanel {

    private JLabel tfUtsDot3OnuValidOnuMacModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuValidOnuMacDeviceId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacPortId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacAppLPortId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacNumber = new JLabel();
    private StringTextField tfOnuLabel = new StringTextField();
    private JComboBox tfUtsDot3ValidOnuMacAddr = new JComboBox();

    private int[] utsDot3Onu2ConfiguredOnuTypeVList = new int[]{
            1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
           21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,     38, 39, 40, 41, 42,
           61, 62, 
           71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86,     88, 89, 90, 91, 92,
           93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 108, 106, 107, 301, 302, 303, 401, 402, 200, };
    private String[] utsDot3Onu2ConfiguredOnuTypeTList = new String[]{
            fStringMap.getString("onu100"), //1
            fStringMap.getString("onu1000b"), //2
            fStringMap.getString("onu1000c"), //3
            fStringMap.getString("onu200a"), //4
            fStringMap.getString("onu200b"), //5
            fStringMap.getString("onu2024"), //6
            fStringMap.getString("onu2004"), //7
            fStringMap.getString("onu101k"), //8
            fStringMap.getString("onu301"), //9
            fStringMap.getString("onu301c"), //10
            fStringMap.getString("onu404"), //11
            fStringMap.getString("onu404c"), //12
            fStringMap.getString("onu804"), //13
            fStringMap.getString("onu804c"), //14
            fStringMap.getString("onu1001c"), //15
            fStringMap.getString("onu3004"), //16
            fStringMap.getString("onu1001i"), //17
            fStringMap.getString("onu2004i"), //18
            fStringMap.getString("onu404i"), //19
            fStringMap.getString("clt2060"), //20
            fStringMap.getString("onu204i"), //21
            fStringMap.getString("onu208i"), //22
            fStringMap.getString("onu204h"), //23
            fStringMap.getString("onu408t"), //24
            fStringMap.getString("onu2024i"), //25
            fStringMap.getString("onub210"), //26
            fStringMap.getString("onu1001h"), //27
            fStringMap.getString("onub220"), //28
            fStringMap.getString("onu804i"), //29
            fStringMap.getString("onu101"), //30
            fStringMap.getString("onu1001b"), //31
            fStringMap.getString("onu2004h"), //32
            fStringMap.getString("onu204d"), //33
            fStringMap.getString("onu404t"), //34
            fStringMap.getString("onu4024t"), //35
            fStringMap.getString("onu4024i"), //36
            fStringMap.getString("onu101i"), //38
            fStringMap.getString("onub1205y"), //39
            fStringMap.getString("onub1205d"), //40
            fStringMap.getString("onub130"), //41
            fStringMap.getString("onub1205"), //42
            
            fStringMap.getString("ont952"), //61
            fStringMap.getString("ont958"), //62
            
            fStringMap.getString("onu2004-2"), //71
            fStringMap.getString("onu404h"), //72
            fStringMap.getString("onu208h"), //73
            fStringMap.getString("onu4016i"), //74
            fStringMap.getString("onu4016i-t"), //75
            fStringMap.getString("onu2016i-e"), //76
            fStringMap.getString("onu4016i-tA1B"), //77
            fStringMap.getString("onu4016i-tA1S"), //78
            fStringMap.getString("onu208p"), //79
            fStringMap.getString("onu4024ia1b"), //80
            fStringMap.getString("onu4024ia1s"), //81
            fStringMap.getString("onu4024ia2b"), //82
            fStringMap.getString("onu4024ia2s"), //83
            fStringMap.getString("onub1202"), //84
            fStringMap.getString("onu204ie"), //85
            fStringMap.getString("onu204ih"), //86
            fStringMap.getString("onu2024i-c1"), //88
            fStringMap.getString("onu204i-h-R-c1"), //89
            fStringMap.getString("onu204i-h-R-c2"), //90
            fStringMap.getString("onu404i-R-c1"), //91
            fStringMap.getString("onu404i-R-c2"), //92
            fStringMap.getString("onu204i-h-R-h1"), //93
            fStringMap.getString("onu204i-k7-R-a1"), //94
            fStringMap.getString("onu204i-k7-R-a2"), //95
            fStringMap.getString("onu204i-k7-R-a3"), //96
            fStringMap.getString("onu204i-k7-R-a4"), //97
            fStringMap.getString("onu804i-R-c1"), //98
            fStringMap.getString("onu804i-R-c2"), //99
            fStringMap.getString("tkOnu"), //100
            fStringMap.getString("pmcOnu"), //101
            fStringMap.getString("onu101i-c1"), //102
            fStringMap.getString("onu204i-k7-R-a7"), //103
            fStringMap.getString("onu204i-k7-R-a5"), //104
            fStringMap.getString("onu204i-k7-R-b2"), //108
            fStringMap.getString("onu-clt2170"), //106
            fStringMap.getString("onu-c3160"), //107
            fStringMap.getString("js24b-v"), //301
            fStringMap.getString("js04h-v"), //302
            fStringMap.getString("js16b-v"), //303
            fStringMap.getString("s1201"), //401
            fStringMap.getString("s1202"), //402
            fStringMap.getString("unknow"), //200
    };
    private JComboBox tfUtsDot3Onu2ConfiguredOnuType = new JComboBox(utsDot3Onu2ConfiguredOnuTypeTList);
    
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
	

    private final String utsDot3OnuValidOnuMacModuleId = fStringMap.getString("utsDot3OnuValidOnuMacModuleId") + " : ";
    //private final String utsDot3OnuValidOnuMacDeviceId = fStringMap.getString("utsDot3OnuValidOnuMacDeviceId") + " : ";
    private final String utsDot3OnuValidOnuMacPortId = fStringMap.getString("utsDot3OnuValidOnuMacPortId") + " : ";
    private final String utsDot3OnuValidOnuMacAppLPortId = fStringMap.getString("utsDot3OnuValidOnuMacAppLPortId") + " : ";
    private final String utsDot3OnuValidOnuMacNumber = fStringMap.getString("utsDot3OnuValidOnuMacNumber") + " : ";
    private final String onuLabel = fStringMap.getString("onuLabel") + " : ";
    private final String utsDot3ValidOnuMacAddr = fStringMap.getString("utsDot3ValidOnuMacAddr") + " : ";
    private final String utsDot3Onu2ConfiguredOnuType = fStringMap.getString("utsDot3Onu2ConfiguredOnuType") + " : ";
	private final String utsDot3Onu2LoidAuthLoid = fStringMap.getString("utsDot3Onu2LoidAuthLoid") + " : ";
	private final String utsDot3Onu2LoidAuthPassword = fStringMap.getString("utsDot3Onu2LoidAuthPassword") + " : ";
	private final String utsDot3OnuAuthMethod = fStringMap.getString("utsDot3OnuAuthMethod") + " : ";
	private final String utsDot3OnuDescription = fStringMap.getString("utsDot3OnuDescription") + " : ";

    public Dot3Onu2CtcValidOnuMacTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(10, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacModuleId));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacDeviceId));
        //baseInfoPanel.add(tfUtsDot3OnuValidOnuMacDeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacPortId));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacAppLPortId));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacAppLPortId);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacNumber));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacNumber);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(onuLabel));
        baseInfoPanel.add(tfOnuLabel);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3ValidOnuMacAddr));
        tfUtsDot3ValidOnuMacAddr.setPreferredSize(new Dimension(180, 24));
        tfUtsDot3ValidOnuMacAddr.setEditor(new MacAddressComboBoxEditor());
        tfUtsDot3ValidOnuMacAddr.setEditable(true);
        tfUtsDot3ValidOnuMacAddr.setName(fStringMap.getString("utsDot3ValidOnuMacAddr"));
        baseInfoPanel.add(tfUtsDot3ValidOnuMacAddr);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2ConfiguredOnuType));
        tfUtsDot3Onu2ConfiguredOnuType.setName(fStringMap.getString("utsDot3Onu2ConfiguredOnuType"));
        baseInfoPanel.add(tfUtsDot3Onu2ConfiguredOnuType);
        baseInfoPanel.add(new HSpacer());
        
        baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthLoid));
		baseInfoPanel.add(tfUtsDot3Onu2LoidAuthLoid);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3Onu2LoidAuthPassword));
		baseInfoPanel.add(tfUtsDot3Onu2LoidAuthPassword);
		baseInfoPanel.add(new HSpacer());
		
		baseInfoPanel.add(new JLabel(utsDot3OnuDescription));
        baseInfoPanel.add(tfUtsDot3OnuDescription);
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
    }

    public void refresh() {
    	tfUtsDot3Onu2LoidAuthLoid.setEnabled(true);
		tfUtsDot3Onu2LoidAuthPassword.setEnabled(true);
		tfUtsDot3ValidOnuMacAddr.setEnabled(true);
    	
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3OnuValidOnuMacModuleId.setText("" + mbean.getUtsDot3OnuValidOnuMacModuleId());
        tfUtsDot3OnuValidOnuMacPortId.setText("" + mbean.getUtsDot3OnuValidOnuMacPortId());
        tfUtsDot3OnuValidOnuMacAppLPortId.setText("" + mbean.getUtsDot3OnuValidOnuMacAppLPortId());

        //retrieve the ONU MAC List from OLT.
        Dot3UnboundOnuTable unboundmbean = new Dot3UnboundOnuTable(fApplication.getSnmpProxy());
        Vector macs = null;
        try {
            //filter ONU MAC List by card and port ID.
            unboundmbean.setIndexPrefix(mbean.getUtsDot3OnuValidOnuMacModuleId() + "." + mbean.getUtsDot3OnuValidOnuMacPortId() + ".");
            macs = unboundmbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        tfUtsDot3OnuValidOnuMacNumber.setText((macs != null) ? ("" + macs.size()) : "0");

        tfUtsDot3ValidOnuMacAddr.removeAllItems();
//        tfUtsDot3ValidOnuMacAddr.addItem("00:00:00:00:00:00");
        if (macs != null) {
            for (int i = 0; i < macs.size(); i++)
                tfUtsDot3ValidOnuMacAddr.addItem(OctetToMacAddress(((Dot3UnboundOnuTable) macs.get(i)).getUtsDot3UnboundOnuPonMacAddr()));
        }
        ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).setValue(mbean.getUtsDot3ValidOnuMacAddr());
        ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).setValue(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString().toUpperCase());
        tfUtsDot3Onu2ConfiguredOnuType.setSelectedIndex(getIndexFromValue(utsDot3Onu2ConfiguredOnuTypeVList, mbean.getUtsDot3Onu2ConfiguredOnuType()));
        
        tfUtsDot3Onu2LoidAuthLoid.setText(mbean.getUtsDot3Onu2LoidAuthLoid()
				.toString());
		tfUtsDot3Onu2LoidAuthPassword.setValue(mbean
				.getUtsDot3Onu2LoidAuthPassword());
		tfUtsDot3OnuAuthMethod.setSelectedIndex(getIndexFromValue(
				utsDot3OnuAuthMethodVList, mbean.getUtsDot3OnuAuthMethod()
						.intValue()));
		tfUtsDot3OnuDescription.setValue(mbean.getUtsDot3OnuDescription());
		
		tfOnuLabel.setText(mbean.getOnuLabel());
		
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
            tfUtsDot3ValidOnuMacAddr.setEnabled(true);
            tfUtsDot3Onu2LoidAuthLoid.setEnabled(false);
            tfUtsDot3Onu2LoidAuthPassword.setEnabled(false);
        }
    }
    
    public boolean validateFrom() {
    	Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return false;

        mbean.setUtsDot3Onu2ConfiguredOnuType(utsDot3Onu2ConfiguredOnuTypeVList[tfUtsDot3Onu2ConfiguredOnuType.getSelectedIndex()]);
        
//        if((mbean.getUtsDot3OnuAuthMethod()==2) && ("".equals(tfUtsDot3Onu2LoidAuthLoid.getText()) || "".equals(tfUtsDot3Onu2LoidAuthPassword.getText()))){
//    		MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("LOID and Password can't be null."));
//            return false;
//    	}
//        if(mbean.getUtsDot3OnuAuthMethod()==3){
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
    	tableBean.setIndex(0, mbean.getIndex(0));
    	tableBean.setIndex(1, mbean.getIndex(1));
    	tableBean.setIndex(2, mbean.getIndex(2)); 
    	tableBean.setIndexPrefix(mbean.getIndex(0)+"."+mbean.getIndex(1)+"."+mbean.getIndex(2));
        Vector v = BeanService.refreshTableBean(fApplication, tableBean);
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
            	Dot3Onu2CtcValidOnuMacTable tmp=(Dot3Onu2CtcValidOnuMacTable) v.get(i);
            	if(tmp.getIndex(0).equals(mbean.getIndex(0))
            			&& tmp.getIndex(1).equals(mbean.getIndex(1))
            			&& tmp.getIndex(2).equals(mbean.getIndex(2))
            			&& tmp.getIndex(3).equals(mbean.getIndex(3))){
            		continue;
            	}
                String s = ((Dot3Onu2CtcValidOnuMacTable) v.get(i)).getUtsDot3Onu2LoidAuthLoid();
                if (s.trim().length()!=0 && tfUtsDot3Onu2LoidAuthLoid.getText().trim().length() != 0 && 
                		(mbean.getUtsDot3OnuAuthMethod()==2 || mbean.getUtsDot3OnuAuthMethod()==3) && (s.equalsIgnoreCase(tfUtsDot3Onu2LoidAuthLoid.getText()))) {
                    MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("LOID has been used."));
                    return false;
                }
            }
        }
        
        String newLabel = tfOnuLabel.getValue().trim();
        
        String toMacLabel = null;
        String neName=this.fApplication.getMainApplet().getParameter("neName");
        String mac = OctetToMacAddress(mbean.getUtsDot3ValidOnuMacAddr()).toLowerCase();
    	String currMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
    	
//        if (tfUtsDot3ValidOnuMacAddr.isEnabled() && currMacAddress != null && !currMacAddress.equalsIgnoreCase(mac)) {
//            if (currMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(currMacAddress))) {
//            	try {
//            		OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            		List<ONUDevice> onuDevices = onuMgmtMgr.getOnulistByMacAddress(currMacAddress.replaceAll(":", "-"));
//            		Vector<Vector> bindOnuList = new Vector<Vector>();
//            		for(int i = 0; i < onuDevices.size(); i++) {
//            			ONUDevice onuDevice = onuDevices.get(i);
//            			try {
//            				Rule condition = new Condition(ManagedElement.s_UserLabel,onuDevice.getNeName(),Condition.EQUAL_TO);
//            				List<ManagedElement> list = ScoaAPI.getApiFactory().getRemoteTopoAPI().getMOListByCategoryAndRule("ME", condition);
//            				if(list==null || list.size() == 0 || list.get(0) == null || list.get(0).getOld2020MOName() == null) {
//            					System.err.println("Dot3Onu2CtcValidOnuMac: can't find the ME by label " + onuDevice.getNeName());
//            					continue;
//            				}
//            				PonProtection ponprotection = getPonProtectionMgrAPI().getPonProtection(list.get(0).getOld2020MOName(), Integer.toString(onuDevice.getModuleId()),
//            						Integer.toString(onuDevice.getPortId()));
//            				Vector<String> data = new Vector();
//            				data.add(onuDevice.getLabel() == null ? "" : onuDevice.getLabel());
//            				data.add(onuDevice.getSerialNo() == null ? "" : onuDevice.getSerialNo());
//            				data.add(list.get(0).getIpAddress());
//            				data.add(onuDevice.getModuleId() + "-" + onuDevice.getPortId() + "-" + onuDevice.getOnuId());
//            				data.add(ponprotection!=null ? ponprotection.getProctionMode() : "");
//            				if((mbean.getUtsDot3OnuValidOnuMacModuleId().intValue() == onuDevice.getModuleId())
//            						&& (mbean.getUtsDot3OnuValidOnuMacPortId().intValue() == onuDevice.getPortId())
//            						&& (mbean.getUtsDot3OnuValidOnuMacAppLPortId().intValue() == onuDevice.getOnuId())
//            						&& (fApplication.getSnmpProxy().getTargetHost().equals(list.get(0).getIpAddress()))) {
//            					continue;
//            				}
//            				bindOnuList.add(data);
//            				toMacLabel = onuDevice.getLabel();
//            			}
//            			catch(Exception e) {
//            				e.printStackTrace();
//            			}
//            		}
//            		boolean isShowLabelReplace = true;
//                	if (newLabel!=null && mbean.getOnuLabel()!=null && !newLabel.equalsIgnoreCase(mbean.getOnuLabel()) && toMacLabel!=null &&
//                			!newLabel.equalsIgnoreCase(toMacLabel) ) {
//                		isShowLabelReplace = false;
//                		try {
//                			if(onuMgmtMgr.isLabelExisted(newLabel)) {
//                				MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("This ONU label has been used by another ONU."));
//                				return false;
//                			}
//                		}
//                		catch(Exception e){
//                			e.printStackTrace();
//                		}
//                	}
//
//            		if(bindOnuList.size() != 0 && showConfirmOperationDialog(fApplication, fApplication.getGlobalStringMap().getString("Please Confirm"), bindOnuList, isShowLabelReplace) == NO_OPTION) {
//            			return false;
//            		}
//            		else if(bindOnuList.size() == 0){
//            			cbLabelReplace.setSelected(true);
//            		}
//
//            		if (newLabel!=null && mbean.getOnuLabel()!=null && !newLabel.equalsIgnoreCase(mbean.getOnuLabel()) && toMacLabel!=null &&
//                			!newLabel.equalsIgnoreCase(toMacLabel) ) {
//            			cbLabelReplace.setSelected(true);
//            		}
//
//
//            		if(newLabel!=null && mbean.getOnuLabel()!=null && newLabel.equalsIgnoreCase(mbean.getOnuLabel()) && cbLabelReplace.isSelected()){
//            			if(isBindOnePort(mac)) {
//            				MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("This ONU label has been used by another ONU."));
//            				return false;
//            			}
//
//            			if (!DebugMode.isDebug()) {
//        		            try {
//        		                String index = mbean.getUtsDot3OnuValidOnuMacModuleId() + "-" + mbean.getUtsDot3OnuValidOnuMacPortId() + "-" + mbean.getUtsDot3OnuValidOnuMacAppLPortId();
//        		                onuMgmtMgr.unBindOnu(fApplication.getSnmpProxy().getTargetHost(), index);
//        		            } catch (Exception e) {
//        		                e.printStackTrace();
//        		                MessageDialog.showErrorMessageDialog(fApplication, fApplication.getActiveDeviceManager()
//        		            			.getGuiComposer().getString("Failed_clear_onu_in_database"));
//        		                return false;
//        		            }
//        		        }
//                    }
//            	}
//            	catch(Exception e){
//            		e.printStackTrace();
//            	}
//            }
//        }
//        else {
        	cbLabelReplace.setSelected(true);
//        	if (newLabel!=null && newLabel.trim().length()!=0 && !newLabel.equalsIgnoreCase(mbean.getOnuLabel())) {
//        		try {
//        			OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//        			if(onuMgmtMgr.isLabelExisted(newLabel)) {
//        				MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("This ONU label has been used by another ONU."));
//        				return false;
//        			}
//        		}
//        		catch(Exception e){
//        			e.printStackTrace();
//        		}
//        	}
//        }
        
        return true;
    }
    
    public boolean isBindOnePort(String macAddress) {
//		if (!DebugMode.isDebug()) {
//			try {
//				OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility
//						.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//				List<ONUDevice> onuDevices = onuMgmtMgr
//						.getOnulistByMacAddress(macAddress.replaceAll(":", "-"));
//				if (onuDevices == null || onuDevices.size() == 1)
//					return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				MessageDialog.showErrorMessageDialog(fApplication, fApplication
//						.getActiveDeviceManager().getGuiComposer().getString(
//								"Failed_clear_onu_in_database"));
//			}
//			return false;
//		}
		return false;
	}


    public void updateModel() {
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsDot3Onu2ConfiguredOnuType(utsDot3Onu2ConfiguredOnuTypeVList[tfUtsDot3Onu2ConfiguredOnuType.getSelectedIndex()]);
        
        if (tfUtsDot3ValidOnuMacAddr.isEnabled()) {
        	String currMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
            if (currMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(currMacAddress))) {
                Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
                macBean.setIndex(0, mbean.getIndex(0));
                macBean.setIndex(1, mbean.getIndex(1));
                macBean.setIndex(2, mbean.getIndex(2));
                macBean.setIndexPrefix(mbean.getIndex(0)+"."+mbean.getIndex(1)+"."+mbean.getIndex(2));
                int selfPortId = (Integer)mbean.getIndex(3);
                Vector v = BeanService.refreshTableBean(fApplication, macBean);
                if (v != null) {
                    for (int i = 0; i < v.size(); i++) {
                        byte[] b = ((Dot3Onu2CtcValidOnuMacTable) v.get(i)).getUtsDot3ValidOnuMacAddr();
                        int portId = ((Dot3Onu2CtcValidOnuMacTable) v.get(i)).getUtsDot3OnuValidOnuMacAppLPortId();
                        String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");
                        if (currMacAddress.equalsIgnoreCase(macAddress) && selfPortId != portId) {
                            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
                            return;
                        }
                    }
                }
            }
			mbean
					.setUtsDot3ValidOnuMacAddr(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr
							.getEditor()).getValue());
        }
        
        if (tfUtsDot3Onu2LoidAuthLoid.isEnabled())
			mbean.setUtsDot3Onu2LoidAuthLoid(tfUtsDot3Onu2LoidAuthLoid
					.getValue());

		if (tfUtsDot3Onu2LoidAuthPassword.isEnabled())
			mbean.setUtsDot3Onu2LoidAuthPassword(tfUtsDot3Onu2LoidAuthPassword
					.getValue());

		mbean.setUtsDot3OnuDescription(tfUtsDot3OnuDescription.getValue());
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
			String url="rmi://"+ TopoMapContext.getHostname()+":"+TopoMapContext.getRmiport();
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
    
    protected void modifyOnuLabel(Dot3Onu2CtcValidOnuMacTable mbean) {
//    	if (!fApplication.isDebug() && tfOnuLabel.getValue().trim().length()!=0) {
//            try {
//                String newLabel = tfOnuLabel.getValue().trim();
//                if (!newLabel.equals(mbean.getOnuLabel())) {
//                    OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                    onuMgmtMgr.modifyOnuLabel(Main.getApplet().getClientID(),Dot3Onu2CtcSerialNumberFormatter.getMacAddress(mbean.getUtsDot3ValidOnuMacAddr()), newLabel);
//
//                    mbean.setOnuLabel(tfOnuLabel.getValue());
//                }
//
//            } catch (RemoteException e) {
//                e.printStackTrace();
//                MessageDialog.showOperationFailedDialog(fApplication);
//            }
//        } else {
            mbean.setOnuLabel(tfOnuLabel.getValue());
//        }
    }
    
    public void afterUpdateModel() {
    	Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
    	
    	if(cbLabelReplace.isSelected())
			modifyOnuLabel(mbean);

    	Dot3Onu2CtcValidOnuMacTable newValueBean=new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
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
		
//		if( (mac==null && loid==null)
//				|| (mac==null && "".equals(loid))
//				|| ("00:00:00:00:00:00".equals(mac) && loid==null) 
//				|| ("00:00:00:00:00:00".equals(mac) && "".equals(loid)) ){
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

    public int showConfirmOperationDialog(IApplication anApplication, String title, Vector<Vector> onuDevices, boolean isShowLabelReplace) {
		JDialog dialog = createConfirmDialog((Frame)anApplication.getTopMostFrame(), title, onuDevices, isShowLabelReplace);
		dialog.setSize(new Dimension(600, 400));
		
//		dialog.setResizable(false);
		dialog.setLocationRelativeTo((Frame)anApplication.getTopMostFrame());
		
		dialog.show();
        dialog.dispose();

        return getInputValue();
		
	}
	
	public void setInputValue(Integer value) {
		inputvalue = value;
	}
	
	public int getInputValue() {
		return inputvalue;
	}
	
	private JLabel lbMessage = new JLabel(fStringMap.getString("This ONU MAC has been bound with other ports, are you sure to continue?"));
	private JButton btnYes = new JButton(fStringMap.getString("Yes")), btnNo = new JButton(fStringMap.getString("No")),
		btnUnbind = new JButton(fStringMap.getString("Unbound"));
	private JCheckBox cbLabelReplace = new JCheckBox(fStringMap.getString("Replace ONU Label with new Label"));
	private Integer inputvalue = 0;
    public static final int         YES_OPTION = 0;
    public static final int         NO_OPTION = 1;

	public JDialog createConfirmDialog(Frame owner, String title, Vector<Vector> onuDevices, boolean isShowLabelReplace) {
		JDialog dialog = new JDialog(owner, title, true);
		initDialog(dialog, onuDevices, isShowLabelReplace);
		return dialog;
	}
	
	private void initDialog(final JDialog dialog, final Vector<Vector> onuDevices, boolean isShowLabelReplace) {
		Container contentPane = dialog.getContentPane();
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(lbMessage, BorderLayout.CENTER);
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "", 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.black));
		

		final Vector<String> columnNames = new Vector<String>(6);
        columnNames.add( fStringMap.getString( "onuLabel" ) );
        columnNames.add( fApplication.getGlobalStringMap().getString( "MAC" ) );
//        columnNames.add( fApplication.getGlobalStringMap().getString( "LOID" ) );
        columnNames.add( fApplication.getGlobalStringMap().getString( "OLT" ) );
        columnNames.add( fApplication.getGlobalStringMap().getString( "Logical Port" ) );
        columnNames.add( fStringMap.getString( "PON Protection Type" ) );
		
		final UTable table = new UTable( fApplication, new UTableModel( onuDevices, columnNames ) );
		
		JPanel btnPanel = new JPanel(new BorderLayout());
		btnPanel.add(cbLabelReplace, BorderLayout.WEST);
		if(isShowLabelReplace) {
			cbLabelReplace.setSelected(false);
			cbLabelReplace.setVisible(true);
		}
		else {
			cbLabelReplace.setSelected(true);
			cbLabelReplace.setVisible(false);
		}
		JPanel btnPanel2 = new JPanel();
		btnPanel2.add(btnUnbind);
		btnPanel2.add(btnYes);
		btnPanel2.add(btnNo);
		btnPanel.add(btnPanel2, BorderLayout.CENTER);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mainPanel, BorderLayout.NORTH);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		WindowAdapter adapter = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
            	setInputValue(NO_OPTION);
            }
        };
        dialog.addWindowListener(adapter);
		
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInputValue(YES_OPTION);
				dialog.setVisible(false);
			}
		});
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInputValue(NO_OPTION);
				dialog.setVisible(false);
			}
		});
		
		btnUnbind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vector data = onuDevices.get(table.getSelectedRow());
                    SnmpParameter snmpParam = new SnmpParameter(data.get(2).toString(), fApplication.getSnmpProxy().getTargetPort());
					snmpParam.setReadCommunity(fApplication.getSnmpProxy().getReadCommunity());
		            snmpParam.setWriteCommunity(fApplication.getSnmpProxy().getWriteCommunity());
		            snmpParam.setSnmpVersion(fApplication.getSnmpProxy().getSnmpVersion());
					SnmpProxy snmpProxy = new SnmpProxy(snmpParam);
					
					Dot3Onu2CtcValidOnuMacTable fbean = new Dot3Onu2CtcValidOnuMacTable(snmpProxy);
					String onu = (String) data.get(3);
					String[] splits = onu.split("-");
					fbean.setUtsDot3OnuValidOnuMacModuleId(Integer
							.parseInt(splits[0]));
					fbean.setUtsDot3OnuValidOnuMacDeviceId(1);
					fbean.setUtsDot3OnuValidOnuMacPortId(Integer
							.parseInt(splits[1]));
					fbean.setUtsDot3OnuValidOnuMacAppLPortId(Integer
							.parseInt(splits[2]));

					SnmpActionTask task = new SnmpActionTask(fbean);
					task.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));
					Boolean result = (Boolean) fApplication.getTaskManager().executeTask(task);
					if (!result.booleanValue()) {
						MessageDialog.showOperationFailedDialog(fApplication);
					}
					else {
						Vector model = new Vector(onuDevices);
						model.remove(table.getSelectedRow());
						table.setModel(new UTableModel( model, columnNames ));
					}
			} catch (Exception ex) {
				MessageDialog.showOperationFailedDialog(fApplication);
			} 
		}});
	}
	
//	public static PonProtectionMgr protectionMgr=null;
//    protected PonProtectionMgr getPonProtectionMgrAPI(){
//		if(protectionMgr==null){
//			String url="rmi://"+TopoMapContext.getHostname()+":"+TopoMapContext.getRmiport();
//			url+="/PonProtectionMgr";
//			try {
//				protectionMgr = (PonProtectionMgr) Naming.lookup(url);
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			} catch (RemoteException e) {
//				e.printStackTrace();
//			} catch (NotBoundException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return protectionMgr;
//    }
    
    class SnmpActionTask extends Task {

		Dot3Onu2CtcValidOnuMacTable bean = null;

		public SnmpActionTask(Dot3Onu2CtcValidOnuMacTable tbean) {
			bean = tbean;
		}

		public Object execute() throws Exception {
			// return bean.resetONU() ? Boolean.TRUE : Boolean.FALSE;
			byte[] mac = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
			bean.setUtsDot3ValidOnuMacAddr(mac);
			return bean.modify();
		}

	}

}
