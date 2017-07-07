/**
 * Modified by Zhou Chao, 2008-6-12
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3UnboundOnuTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.MacAddressComboBoxEditor;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class Dot3Onu2CtcValidOnuMacTablePanel extends UPanel {

    private JLabel tfUtsDot3OnuValidOnuMacModuleId = new JLabel();
    //private JLabel tfUtsDot3OnuValidOnuMacDeviceId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacPortId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacAppLPortId = new JLabel();
    private JLabel tfUtsDot3OnuValidOnuMacNumber = new JLabel();
    private JComboBox tfUtsDot3ValidOnuMacAddr = new JComboBox();
    private StringTextField tfUtsDot3OnuDescription = new StringTextField();

    private final String utsDot3OnuValidOnuMacModuleId = fStringMap.getString("utsDot3OnuValidOnuMacModuleId") + " : ";
    //private final String utsDot3OnuValidOnuMacDeviceId = fStringMap.getString("utsDot3OnuValidOnuMacDeviceId") + " : ";
    private final String utsDot3OnuValidOnuMacPortId = fStringMap.getString("utsDot3OnuValidOnuMacPortId") + " : ";
    private final String utsDot3OnuValidOnuMacAppLPortId = fStringMap.getString("utsDot3OnuValidOnuMacAppLPortId") + " : ";
    private final String utsDot3OnuValidOnuMacNumber = fStringMap.getString("utsDot3OnuValidOnuMacNumber") + " : ";
    private final String utsDot3ValidOnuMacAddr = fStringMap.getString("utsDot3ValidOnuMacAddr") + " : ";
    private final String utsDot3OnuDescription = fStringMap.getString("utsDot3OnuDescription") + " : ";

    private String currMacAddress;

    public Dot3Onu2CtcValidOnuMacTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacNumber));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3OnuValidOnuMacAppLPortId));
        baseInfoPanel.add(tfUtsDot3OnuValidOnuMacAppLPortId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3ValidOnuMacAddr));
        tfUtsDot3ValidOnuMacAddr.setPreferredSize(new Dimension(180, 24));
        tfUtsDot3ValidOnuMacAddr.setEditor(new MacAddressComboBoxEditor());
        tfUtsDot3ValidOnuMacAddr.setEditable(true);
        tfUtsDot3ValidOnuMacAddr.setName(fStringMap.getString("utsDot3ValidOnuMacAddr"));
        baseInfoPanel.add(tfUtsDot3ValidOnuMacAddr);
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
            unboundmbean.setUtsDot3UnboundOnuModuleId(mbean.getUtsDot3OnuValidOnuMacModuleId());
            unboundmbean.setUtsDot3UnboundOnuPortId(mbean.getUtsDot3OnuValidOnuMacPortId());
            unboundmbean.setIndexPrefix(mbean.getUtsDot3OnuValidOnuMacModuleId() + "." + mbean.getUtsDot3OnuValidOnuMacPortId() + ".");
            macs = unboundmbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        tfUtsDot3OnuValidOnuMacNumber.setText((macs != null) ? ("" + macs.size()) : "0");

        tfUtsDot3ValidOnuMacAddr.removeAllItems();
        tfUtsDot3ValidOnuMacAddr.addItem("00:00:00:00:00:00");
        if (macs != null) {
            for (Object mac : macs)
                tfUtsDot3ValidOnuMacAddr.addItem(OctetToMacAddress(((Dot3UnboundOnuTable) mac).getUtsDot3UnboundOnuPonMacAddr()));
        }
        ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).setValue(mbean.getUtsDot3ValidOnuMacAddr());
        ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).setValue(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString().toUpperCase());

        currMacAddress = OctetToMacAddress(mbean.getUtsDot3ValidOnuMacAddr());
        
        tfUtsDot3OnuDescription.setValue(mbean.getUtsDot3OnuDescription());
    }

//    public boolean validateFrom() {
//        String newMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
//        if (newMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(newMacAddress))) {
//            Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
//            Vector v = BeanService.refreshTableBean(fApplication, macBean);
//            if (v != null) {
//                for (Object aV : v) {
//                    byte[] b = ((Dot3Onu2CtcValidOnuMacTable) aV).getUtsDot3ValidOnuMacAddr();
//                    String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");
//                    if (newMacAddress.equalsIgnoreCase(macAddress)) {
//                        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }

    public void updateModel() {
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();

        String newMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
        boolean macSame = false;
        if (newMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(newMacAddress))) {
            Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, macBean);
            if (v != null) {
                for (Object aV : v) {
                	Dot3Onu2CtcValidOnuMacTable tmp = (Dot3Onu2CtcValidOnuMacTable) aV;
                    byte[] b = tmp.getUtsDot3ValidOnuMacAddr();
                    String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");
                    if (newMacAddress.equalsIgnoreCase(macAddress)) {
                    	if (!(tmp.getIndex(0).equals(mbean.getIndex(0))
                    			&& tmp.getIndex(1).equals(mbean.getIndex(1))
                    			&& tmp.getIndex(2).equals(mbean.getIndex(2))
                    			&& tmp.getIndex(3).equals(mbean.getIndex(3)))) {
                    		MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
							return;
						}
                    	macSame = true;
                    }
                }
            }
        }
        if (!macSame) {
        	mbean.setUtsDot3ValidOnuMacAddr(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getValue());
		}
        if (!mbean.getUtsDot3OnuDescription().equals(tfUtsDot3OnuDescription.getValue())) {
			mbean.setUtsDot3OnuDescription(tfUtsDot3OnuDescription.getValue());
		}
    }
    public void afterUpdateModel() {
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return;

        String newMacAddress = OctetToMacAddress(mbean.getUtsDot3ValidOnuMacAddr());

//        if(!fApplication.isDebug()) {
//            try {
//                UnboundOnuMgmtMgr onuMgmtMgr = (UnboundOnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "UnboundOnuMgmtMgr");
//                String neName = ClientUtility.getNeNameByNeIp(fApplication.getSnmpProxy().getTargetHost());
//
//                UnboundOnuMOD onu = new UnboundOnuMOD();
//                onu.setNeName(neName);
//                onu.setCardId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacModuleId()));
//                onu.setPortId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacPortId()));
//                onu.setLlId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacAppLPortId()));
//
//                if(!"00:00:00:00:00:00".equals(currMacAddress)) {
//                    onu.setMacAddress(currMacAddress);
//                    onuMgmtMgr.addUnbindOnu(onu);
//                }
//                if(!"00:00:00:00:00:00".equals(newMacAddress)) {
//                    onu.setMacAddress(newMacAddress);
//                    onuMgmtMgr.deleteUnbindOnu(onu);
//                }
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }

        currMacAddress = newMacAddress;
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

}