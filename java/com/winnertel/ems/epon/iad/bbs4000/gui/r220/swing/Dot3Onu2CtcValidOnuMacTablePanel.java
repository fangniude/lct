/**
 * Created by Zhou Chao, 2010/4/28
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r220.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3UnboundOnuTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.MacAddressComboBoxEditor;
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

    private int[] utsDot3Onu2ConfiguredOnuTypeVList = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 38, 39,
            40, 41, 42, 61, 62, 71, 72, 73, 74, 75, 76, 77, 78, 79,
            80, 81, 82, 83, 84, 85, 86, 87, 88, 100, 101, 200,};
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
            fStringMap.getString("onu4016i-t A1B"), //77
            fStringMap.getString("onu4016i-t A1S"), //78
            fStringMap.getString("onu208p"), //79
            fStringMap.getString("onu4024ia1b"), //80
            fStringMap.getString("onu4024ia1s"), //81
            fStringMap.getString("onu4024ia2b"), //82
            fStringMap.getString("onu4024ia2s"), //83
            fStringMap.getString("onub1202"), //84
            fStringMap.getString("onu204ie"), //85
            fStringMap.getString("onu204ih"), //86
            fStringMap.getString("onu204i-c1"), //87
            fStringMap.getString("onu4024i-c1"), //88
            fStringMap.getString("tkOnu"), //100
            fStringMap.getString("pmcOnu"), //101
            fStringMap.getString("unknow"), //200
    };
    //private JComboBox tfUtsDot3Onu2ConfiguredOnuType = new JComboBox(utsDot3Onu2ConfiguredOnuTypeTList);

    private final String utsDot3OnuValidOnuMacModuleId = fStringMap.getString("utsDot3OnuValidOnuMacModuleId") + " : ";
    //private final String utsDot3OnuValidOnuMacDeviceId = fStringMap.getString("utsDot3OnuValidOnuMacDeviceId") + " : ";
    private final String utsDot3OnuValidOnuMacPortId = fStringMap.getString("utsDot3OnuValidOnuMacPortId") + " : ";
    private final String utsDot3OnuValidOnuMacAppLPortId = fStringMap.getString("utsDot3OnuValidOnuMacAppLPortId") + " : ";
    private final String utsDot3OnuValidOnuMacNumber = fStringMap.getString("utsDot3OnuValidOnuMacNumber") + " : ";
    private final String utsDot3ValidOnuMacAddr = fStringMap.getString("utsDot3ValidOnuMacAddr") + " : ";
    //private final String utsDot3Onu2ConfiguredOnuType = fStringMap.getString("utsDot3Onu2ConfiguredOnuType") + " : ";

    private String currMacAddress;

    public Dot3Onu2CtcValidOnuMacTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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

        /*
        baseInfoPanel.add(new JLabel(utsDot3Onu2ConfiguredOnuType));
        tfUtsDot3Onu2ConfiguredOnuType.setName(fStringMap.getString("utsDot3Onu2ConfiguredOnuType"));
        baseInfoPanel.add(tfUtsDot3Onu2ConfiguredOnuType);
        baseInfoPanel.add(new HSpacer());
        */

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

    public boolean validateFrom() {
        //added by Zhou Chao, 2009/1/7
        //check the input MAC whether it exist in MAC list
        String newMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
        if (newMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(newMacAddress))) {
            Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, macBean);
            if (v != null) {
                for (Object aV : v) {
                    byte[] b = ((Dot3Onu2CtcValidOnuMacTable) aV).getUtsDot3ValidOnuMacAddr();
                    String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");
                    if (newMacAddress.equalsIgnoreCase(macAddress)) {
                        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
                        return false;
                    }
                }
            }
        }

        return true;
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
        //tfUtsDot3Onu2ConfiguredOnuType.setSelectedIndex(getIndexFromValue(utsDot3Onu2ConfiguredOnuTypeVList, mbean.getUtsDot3Onu2ConfiguredOnuType()));

        currMacAddress = OctetToMacAddress(mbean.getUtsDot3ValidOnuMacAddr());
    }

    public void updateModel() {
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return;

        //added by Zhou Chao, 2009/1/7
        //check the input MAC whether it exist in MAC list
        String currMacAddress = ((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getMacString();
        if (currMacAddress != null && !(("00:00:00:00:00:00").equalsIgnoreCase(currMacAddress))) {
            Dot3Onu2CtcValidOnuMacTable macBean = new Dot3Onu2CtcValidOnuMacTable(fApplication.getSnmpProxy());
            //ONS00042804
            macBean.setIndex(0, mbean.getIndex(0));
            macBean.setIndex(1, mbean.getIndex(1));
            macBean.setIndex(2, mbean.getIndex(2));
            macBean.setIndexPrefix(mbean.getIndex(0)+"."+mbean.getIndex(1)+"."+mbean.getIndex(2));
            
            Vector v = BeanService.refreshTableBean(fApplication, macBean);
            if (v != null) {
                for (int i = 0; i < v.size(); i++) {
                    byte[] b = ((Dot3Onu2CtcValidOnuMacTable) v.get(i)).getUtsDot3ValidOnuMacAddr();
                    String macAddress = (b != null ? OctetToMacAddress(b) : "00:00:00:00:00:00");
                    if (currMacAddress.equalsIgnoreCase(macAddress)) {
                        MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("MSG_MAC_EXIST"));
                        return;
                    }
                }
            }
        }
        mbean.setUtsDot3ValidOnuMacAddr(((MacAddressComboBoxEditor) tfUtsDot3ValidOnuMacAddr.getEditor()).getValue());
        //mbean.setUtsDot3Onu2ConfiguredOnuType(utsDot3Onu2ConfiguredOnuTypeVList[tfUtsDot3Onu2ConfiguredOnuType.getSelectedIndex()]);
    }

/*
    public void afterUpdateModel() {
        Dot3Onu2CtcValidOnuMacTable mbean = (Dot3Onu2CtcValidOnuMacTable) getModel();
        if (mbean == null)
            return;

        String newMacAddress = OctetToMacAddress(mbean.getUtsDot3ValidOnuMacAddr());

        if(!fApplication.isDebug()) {
            try {
                UnboundOnuMgmtMgr onuMgmtMgr = (UnboundOnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "UnboundOnuMgmtMgr");
                String neName = ClientUtility.getNeNameByNeIp(fApplication.getSnmpProxy().getTargetHost());

                UnboundOnuMOD onu = new UnboundOnuMOD();
                onu.setNeName(neName);
                onu.setCardId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacModuleId()));
                onu.setPortId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacPortId()));
                onu.setLlId(String.valueOf(mbean.getUtsDot3OnuValidOnuMacAppLPortId()));

                onu.setMacAddress(currMacAddress);
                onuMgmtMgr.addUnbindOnu(onu);

                if(!"00:00:00:00:00:00".equals(newMacAddress)) {
                    onu.setMacAddress(newMacAddress);
                    onuMgmtMgr.deleteUnbindOnu(onu);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
//                    MessageDialog.showOperationFailedDialog(fApplication);
            }

            currMacAddress = newMacAddress;
        }
    }
*/

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

}