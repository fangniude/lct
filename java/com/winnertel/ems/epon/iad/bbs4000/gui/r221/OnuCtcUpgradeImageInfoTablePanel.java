package com.winnertel.ems.epon.iad.bbs4000.gui.r221;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r221.OnuCtcUpgradeImageInfoTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class OnuCtcUpgradeImageInfoTablePanel extends UPanel {
    private StringTextField tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo = new StringTextField();

    /**
     * HwType:
     * onu100(1)
     * onu1000B(2)
     * onu1000C(3)
     * onu200A(4)
     * onu200B(5)
     * onu2024(6)
     * onu2004(7)
     * onu101K(8)
     * onu301(9)
     * onu301C(10)
     * onu404(11)
     * onu404C(12)
     * onu804(13)
     * onu804C(14)
     * onu1001C(15)
     * onu3004(16)
     * onu1001i(17)
     * onu2004i(18)
     * onu404i(19)
     * clt2060(20)
     * onu204i(21)
     * onu208i(22)
     * onu204h(23)
     * onu408t(24)
     * onu2024i(25)
     * onub210(26)
     * onu1001h(27)
     * onub220(28)
     * onu804i(29)
     * onu101(30)
     * onu1001b(31)
     * onu2004h(32)
     * onu204d(33)
     * onu404t(34)
     * onu4024t(35)
     * onu4024i(36)
     * onu101i(38)
     * onub1205y(39)
     * onub1205d(40)
     * onub130(41)
     * onub1205(42)
     * ont1001t(61)
     * ont408t(62)
     * tkOnu(100)
     * pmcOnu(101)
     * unknow(200)
     * onu2004-2(71)
     * onu404h(72)
     * onu208h(73)
     * onu4016i(74)
     * onu4016i-t(75)
     * onu2016i-e(76)
     * onu4016i-tA1B(77)
     * onu4016i-tA1S(78)
     * ONU208p(79)
     * ONU204i-e(85)
     * ONU204i-h(86)
     * tkOnu(100)
     * pmcOnu(101)
     * unknow(200)
     */
    private int[] utsCtcTftpOamOnuUpgradeImageInfoOnuTypeVList = new int[]{
            /*1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16,*/ 17, 18, 19, /*20,*/
            21, 22, 24, 25, 26, 29, 35, 36, 38, 39, 40, 41, 71, 75, 76, 77, 78, 79, 85, 86, 100, 101,
    };
    private String[] utsCtcTftpOamOnuUpgradeImageInfoOnuTypeTList = new String[]{
            /*
            fStringMap.getString("onu100"), //1
            fStringMap.getString("onu1000b"), //2
            fStringMap.getString("onu1000c"), //3
            fStringMap.getString("onu200a"), //4
            fStringMap.getString("onu200b"), //5
            fStringMap.getString("onu2024"), //6
            fStringMap.getString("onu2004"), //7
            fStringMap.getString("onu1001c"), //9
            fStringMap.getString("onu301"), //10
            fStringMap.getString("onu404"), //12
            fStringMap.getString("onu404c"), //13
            fStringMap.getString("onu804"), //14
            fStringMap.getString("onu804c"), //15
            fStringMap.getString("onu3004"), //16
            */

            fStringMap.getString("onu1001i"), //17
            fStringMap.getString("onu2004i"), //18
            fStringMap.getString("onu404i"), //19
            //fStringMap.getString("clt2060"), //20
            fStringMap.getString("onu204i"), //21
            fStringMap.getString("onu208i"), //22
            fStringMap.getString("onu408t"), //24
            fStringMap.getString("onu2024i"),//25
            fStringMap.getString("onub210"), //26
            fStringMap.getString("onu804i"), //29
            fStringMap.getString("onu4024t"), //35
            fStringMap.getString("onu4024i"), //36
            fStringMap.getString("onu101i"), //38
            fStringMap.getString("onub130"), //39
            fStringMap.getString("onub1205d"), //40
            fStringMap.getString("onub1205y"), //41
            fStringMap.getString("onu2004-2"), //71
            fStringMap.getString("onu4016i-t"), //75
            fStringMap.getString("onu2016i-e"), //76
            fStringMap.getString("onu4016i-t A1B"), //77
            fStringMap.getString("onu4016i-t A1S"), //78
            fStringMap.getString("ONU208p"),//79
            fStringMap.getString("ONU204i-e"),//85
            fStringMap.getString("ONU204i-h"), //86
            fStringMap.getString("tkOnu"), //100
            fStringMap.getString("pmcOnu"), //101
    };

//    private JComboBox tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType = new JComboBox(utsCtcTftpOamOnuUpgradeImageInfoOnuTypeTList);

    private StringTextField tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType = new StringTextField();

    private StringTextField tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion = new StringTextField();
    private StringTextField tfUtsCtcTftpOamOnuUpgradeImageInfoImageName = new StringTextField();

    private StringTextField tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate = new StringTextField();

    private JButton btFileChooser = new JButton("...");

    private final String utsCtcTftpOamOnuUpgradeImageInfoVendorInfo = fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoVendorInfo") + ": ";
    private final String utsCtcTftpOamOnuUpgradeImageInfoOnuType = fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoOnuType") + ": ";
    private final String utsCtcTftpOamOnuUpgradeImageInfoImageVersion = fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageVersion") + ": ";
    private final String utsCtcTftpOamOnuUpgradeImageInfoImageName = fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageName") + ": ";
    private final String utsCtcTftpOamOnuUpgradeImageInfoImageDate = fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageDate") + ": ";


    public OnuCtcUpgradeImageInfoTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsCtcTftpOamOnuUpgradeImageInfoVendorInfo));
        tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo.setName(fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoVendorInfo"));
        baseInfoPanel.add(tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsCtcTftpOamOnuUpgradeImageInfoOnuType));
        tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType.setName(fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoOnuType"));
        baseInfoPanel.add(tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsCtcTftpOamOnuUpgradeImageInfoImageName));
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageName.setName(fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageName"));

        JPanel filechoose = new JPanel();
        layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        filechoose.setLayout(layout);
        filechoose.add(tfUtsCtcTftpOamOnuUpgradeImageInfoImageName);
        filechoose.add(btFileChooser);
        btFileChooser.setPreferredSize(new Dimension(20, 20));
        baseInfoPanel.add(filechoose);
        baseInfoPanel.add(new HSpacer());

        btFileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog) SwingUtilities.getWindowAncestor(com.winnertel.ems.epon.iad.bbs4000.gui.r221.OnuCtcUpgradeImageInfoTablePanel.this), new String[]{"flash:/onuImage"});
                chooser.show();
                if (chooser.getSelectedFile() != null) {
                    tfUtsCtcTftpOamOnuUpgradeImageInfoImageName.setValue(chooser.getSelectedFile().getName());
                }
            }
        });

        baseInfoPanel.add(new JLabel(utsCtcTftpOamOnuUpgradeImageInfoImageVersion));
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion.setName(fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageVersion"));
        baseInfoPanel.add(tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsCtcTftpOamOnuUpgradeImageInfoImageDate));
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate.setName(fStringMap.getString("utsCtcTftpOamOnuUpgradeImageInfoImageDate"));
        baseInfoPanel.add(tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate);
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
        tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo.setLenScope(0, 4);
        tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType.setLenScope(0, 8);
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageName.setLenScope(0, 63);
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion.setLenScope(0, 63);
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate.setLenScope(0, 8);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            return;

        OnuCtcUpgradeImageInfoTable mbean = (OnuCtcUpgradeImageInfoTable) getModel();
        if (mbean == null)
            return;

        tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo.setValue(mbean.getUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo());
        tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType.setValue(mbean.getUtsCtcTftpOamOnuUpgradeImageInfoOnuType());
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageName.setValue(mbean.getUtsCtcTftpOamOnuUpgradeImageInfoImageName());
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion.setValue(mbean.getUtsCtcTftpOamOnuUpgradeImageInfoImageVersion());
        tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate.setValue(mbean.getUtsCtcTftpOamOnuUpgradeImageInfoImageDate());
    }

    public boolean validateFrom() {
        String vendor = tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo.getValue();
        String onuType = tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType.getValue();

        OnuCtcUpgradeImageInfoTable mbean = new OnuCtcUpgradeImageInfoTable(fApplication.getSnmpProxy());

        Vector v = new Vector();
        try {
            v = mbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                OnuCtcUpgradeImageInfoTable one = (OnuCtcUpgradeImageInfoTable) v.get(i);
                if (vendor.equals(one.getUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo()) && onuType.equals(one.getUtsCtcTftpOamOnuUpgradeImageInfoOnuType())) {
                    String error = fStringMap.getString("Err_Upgrade_Rule_Exist");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuCtcUpgradeImageInfoTable(fApplication.getSnmpProxy()));

        OnuCtcUpgradeImageInfoTable mbean = (OnuCtcUpgradeImageInfoTable) getModel();
        if (mbean == null)
            return;

        mbean.setUtsCtcTftpOamOnuUpgradeImageInfoOnuType(tfUtsCtcTftpOamOnuUpgradeImageInfoOnuType.getValue());
        mbean.setUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo(tfUtsCtcTftpOamOnuUpgradeImageInfoVendorInfo.getValue());
        mbean.setUtsCtcTftpOamOnuUpgradeImageInfoImageVersion(tfUtsCtcTftpOamOnuUpgradeImageInfoImageVersion.getValue());
        mbean.setUtsCtcTftpOamOnuUpgradeImageInfoImageName(tfUtsCtcTftpOamOnuUpgradeImageInfoImageName.getValue());
        mbean.setUtsCtcTftpOamOnuUpgradeImageInfoImageDate(tfUtsCtcTftpOamOnuUpgradeImageInfoImageDate.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
