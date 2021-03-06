package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.ONUUpgradeHwTableMBean;
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

public class ONUUpgradeHwTableMBeanPanel extends UPanel {

    /**
     * HwType: onu100(1) onu1000B(2) onu1000C(3) onu200A(4) onu200B(5) onu2024(6) onu2004(7) onu101K(8) onu301(9) onu301C(10) onu404(11) onu404C(12) onu804(13) onu804C(14) onu1001C(15) onu3004(16) onu1001i(17) onu2004i(18) onu404i(19) clt2060(20) onu204i(21) onu208i(22) onu204h(23) onu408t(24) onu2024i(25) onub210(26) onu1001h(27) onub220(28) onu804i(29) onu101(30) onu1001b(31) onu2004h(32) onu204d(33) onu404t(34) onu4024t(35) onu4024i(36) onu101i(38) onub1205y(39) onub1205d(40) onub130(41) onub1205(42) ont1001t(61) ont408t(62) tkOnu(100) pmcOnu(101) unknow(200) onu2004-2(71) onu404h(72) onu208h(73) onu4016i(74) onu4016i-t(75) onu2016i-e(76) onu4016i-tA1B(77) onu4016i-tA1S(78) ONU208p(79) ONU204i-e(85) ONU204i-h(86) tkOnu(100) pmcOnu(101) unknow(200)
     */
    
    // Modified by HZ20192, 2010/12/31
    private int[] utsDot3OnuHwTypeUpgradeHwTypeVList = new int[] {
	    // TODO only for hhjs OEM 302, 303, 301,
	    17, 38, 71, 18, 76, 25, 21, 85, 86, 89, 93, 94, 95, 97, 104, 103, 73, 22, 79, 75, 77, 78, 36, 19, 91, 24, 29, 98, 84, 42, 40, 39, 41, };
    /*
    private String[] utsDot3OnuHwTypeUpgradeHwTypeTList = new String[] {

	    // fStringMap.getString("clt2060"), // 20

	    // TODO only for hhjs OEM fStringMap.getString("js04h-v"), // 302
	    // TODO only for hhjs OEM fStringMap.getString("js16b-v"), // 303
	    // TODO only for hhjs OEM fStringMap.getString("js24b-v"), // 301

	    // fStringMap.getString("ont952"), // 61
	    // fStringMap.getString("ont958"), // 62
	    // fStringMap.getString("onu100"), // 1
	    // fStringMap.getString("onu1000B"), // 2
	    // fStringMap.getString("onu1000C"), // 3
	    // fStringMap.getString("onu1001C"), // 15
	    // fStringMap.getString("onu1001b"), // 31
	    // fStringMap.getString("onu1001h"), // 27
	    fStringMap.getString("onu1001i"), // 17
	    // fStringMap.getString("onu101"), // 30
	    // fStringMap.getString("onu101K"), // 8
	    fStringMap.getString("onu101i"), // 38
	    // fStringMap.getString("onu101i-c1"), // 102
	    // fStringMap.getString("onu2004"), // 7
	    fStringMap.getString("onu2004-2"), // 71
	    // fStringMap.getString("onu2004h"), // 32
	    fStringMap.getString("onu2004i"), // 18
	    // fStringMap.getString("onu200A"), // 4
	    // fStringMap.getString("onu200B"), // 5
	    fStringMap.getString("onu2016i-e"), // 76
	    // fStringMap.getString("onu2024"), // 6
	    fStringMap.getString("onu2024i"), // 25
	    // fStringMap.getString("onu2024i-c1"), // 88
	    // fStringMap.getString("onu204d"), // 33
	    // fStringMap.getString("onu204h"), // 23
	    fStringMap.getString("onu204i"), // 21
	    fStringMap.getString("onu204ie"), // 85
	    fStringMap.getString("onu204ih"), // 86
	    fStringMap.getString("onu204i-h-R-c1"), // 89
	    // fStringMap.getString("onu204i-h-R-c2"), // 90
	    fStringMap.getString("onu204i-h-R-h1"), // 93
	    fStringMap.getString("onu204i-k7-R-a1"), // 94
	    fStringMap.getString("onu204i-k7-R-a2"), // 95
	    // fStringMap.getString("onu204i-k7-R-a3"), // 96
	    fStringMap.getString("onu204i-k7-R-a4"), // 97
	    fStringMap.getString("onu204i-k7-R-a5"), // 104
	    fStringMap.getString("onu204i-k7-R-a7"), // 103
	    fStringMap.getString("onu208h"), // 73
	    fStringMap.getString("onu208i"), // 22
	    fStringMap.getString("onu208p"), // 79
	    // fStringMap.getString("onu3004"), // 16
	    // fStringMap.getString("onu301"), // 9
	    // fStringMap.getString("onu301C"), // 10
	    // fStringMap.getString("onu4016i"), // 74
	    fStringMap.getString("onu4016i-t"), // 75
	    fStringMap.getString("onu4016i-tA1B"), // 77
	    fStringMap.getString("onu4016i-tA1S"), // 78
	    fStringMap.getString("onu4024i"), // 36
	    // fStringMap.getString("onu4024ia1b"), // 80
	    // fStringMap.getString("onu4024ia1s"), // 81
	    // fStringMap.getString("onu4024ia2b"), // 82
	    // fStringMap.getString("onu4024ia2s"), // 83
	    // fStringMap.getString("onu4024t"), // 35
	    // fStringMap.getString("onu404"), // 11
	    // fStringMap.getString("onu404C"), // 12
	    // fStringMap.getString("onu404h"), // 72
	    fStringMap.getString("onu404i"), // 19
	    fStringMap.getString("onu404i-R-c1"), // 91
	    // fStringMap.getString("onu404i-R-c2"), // 92
	    // fStringMap.getString("onu404t"), // 34
	    fStringMap.getString("onu408t"), // 24
	    // fStringMap.getString("onu804"), // 13
	    // fStringMap.getString("onu804C"), // 14
	    fStringMap.getString("onu804i"), // 29
	    fStringMap.getString("onu804i-R-c1"), // 98
	    // fStringMap.getString("onu804i-R-c2"), // 99
	    fStringMap.getString("onub1202"), // 84
	    fStringMap.getString("onub1205"), // 42
	    fStringMap.getString("onub1205d"), // 40
	    fStringMap.getString("onub1205y"), // 39
	    fStringMap.getString("onub130"), // 41
    // fStringMap.getString("onub210"), // 26
    // fStringMap.getString("onub220"), // 28
    // fStringMap.getString("pmcOnu"), // 101
    // fStringMap.getString("tkOnu"), // 100
    // fStringMap.getString("unknow"), // 200
    };

             */

//    private String[] utsDot3OnuHwTypeUpgradeHwTypeTList = new String[] {
//        "ONU-0-1",
//    };

    private JComboBox tfUtsDot3OnuHwTypeUpgradeHwType = new JComboBox();

//    private int[] utsDot3OnuHwTypeUpgradeMethodVList = new int[] { 1, 2, };
//    private String[] utsDot3OnuHwTypeUpgradeMethodTList = new String[] { fStringMap.getString("manual"), fStringMap.getString("scheduled"), };
//    private JComboBox tfUtsDot3OnuHwTypeUpgradeMethod = new JComboBox(utsDot3OnuHwTypeUpgradeMethodTList);
    
    private int[] utsDot3OnuHwTypeUpgradeMethodVList = new int[] {1};
    private String[] utsDot3OnuHwTypeUpgradeMethodTList = new String[] {fStringMap.getString("manual")};
    private JComboBox tfUtsDot3OnuHwTypeUpgradeMethod = new JComboBox(utsDot3OnuHwTypeUpgradeMethodTList);

    private StringTextField tfUtsDot3OnuHwTypeUpgradeFwRev = new StringTextField();
    private StringTextField tfUtsDot3OnuHwTypeUpgradeImageName = new StringTextField();

//    private int[] utsDot3OnuHwTypeUpgradeComponentVList = new int[] { 1, 2, };
//    private String[] utsDot3OnuHwTypeUpgradeComponentTList = new String[] { fStringMap.getString("onu-pon-firmware"), fStringMap.getString("onu-switch-firmware"), };

    private int[] utsDot3OnuHwTypeUpgradeComponentVList = new int[] { 4 };
    private String[] utsDot3OnuHwTypeUpgradeComponentTList = new String[] { fStringMap.getString("onu-firmware") };
    private JComboBox tfUtsDot3OnuHwTypeUpgradeComponent = new JComboBox(utsDot3OnuHwTypeUpgradeComponentTList);

    private JButton btFileChooser = new JButton("...");

    private final String utsDot3OnuHwTypeUpgradeHwType = fStringMap.getString("utsDot3OnuHwTypeUpgradeHwType") + ": ";
    private final String utsDot3OnuHwTypeUpgradeMethod = fStringMap.getString("utsDot3OnuHwTypeUpgradeMethod") + ": ";
    private final String utsDot3OnuHwTypeUpgradeFwRev = fStringMap.getString("utsDot3OnuHwTypeUpgradeFwRev") + ": ";
    private final String utsDot3OnuHwTypeUpgradeImageName = fStringMap.getString("utsDot3OnuHwTypeUpgradeImageName") + ": ";

    private final String utsDot3OnuHwTypeUpgradeComponent = fStringMap.getString("utsDot3OnuHwTypeUpgradeComponent") + ": ";

    public ONUUpgradeHwTableMBeanPanel(IApplication app) {
	super(app);
	init();
    }

    public void initGui() {
        System.out.println("initGui called.");
        JPanel baseInfoPanel = new JPanel();
	NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	layout.setMargins(6, 10, 6, 10);
	baseInfoPanel.setLayout(layout);
	baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//	baseInfoPanel.add(new JLabel(utsDot3OnuHwTypeUpgradeHwType));
//	tfUtsDot3OnuHwTypeUpgradeHwType.setName(fStringMap.getString("utsDot3OnuHwTypeUpgradeHwType"));
//        Vector<String> ONUs = new Vector<String>();
//        for( int i = 0; i < 50; i++ ) {
//            ONUs.add("ONU-" + i/10 + "-" + i%10);
//        }
//        tfUtsDot3OnuHwTypeUpgradeHwType.setModel(new DefaultComboBoxModel(ONUs));
//	baseInfoPanel.add(tfUtsDot3OnuHwTypeUpgradeHwType);
//	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OnuHwTypeUpgradeMethod));
	tfUtsDot3OnuHwTypeUpgradeMethod.setName(fStringMap.getString("utsDot3OnuHwTypeUpgradeMethod"));
	baseInfoPanel.add(tfUtsDot3OnuHwTypeUpgradeMethod);
	baseInfoPanel.add(new HSpacer());
	baseInfoPanel.add(new JLabel(utsDot3OnuHwTypeUpgradeFwRev));
	tfUtsDot3OnuHwTypeUpgradeFwRev.setName(fStringMap.getString("utsDot3OnuHwTypeUpgradeFwRev"));
	baseInfoPanel.add(tfUtsDot3OnuHwTypeUpgradeFwRev);
	baseInfoPanel.add(new HSpacer());

	baseInfoPanel.add(new JLabel(utsDot3OnuHwTypeUpgradeImageName));
	tfUtsDot3OnuHwTypeUpgradeImageName.setName(fStringMap.getString("utsDot3OnuHwTypeUpgradeImageName"));

	JPanel filechoose = new JPanel();
	layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
	filechoose.setLayout(layout);
	filechoose.add(tfUtsDot3OnuHwTypeUpgradeImageName);
	filechoose.add(btFileChooser);
	btFileChooser.setPreferredSize(new Dimension(20, 20));
	baseInfoPanel.add(filechoose);
	baseInfoPanel.add(new HSpacer());

	btFileChooser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog) SwingUtilities.getWindowAncestor(ONUUpgradeHwTableMBeanPanel.this), new String[] { "flash:/onuImage" });
		chooser.show();
		if (chooser.getSelectedFile() != null) {
		    tfUtsDot3OnuHwTypeUpgradeImageName.setValue(chooser.getSelectedFile().getName());
		}
	    }
	});

	baseInfoPanel.add(new JLabel(utsDot3OnuHwTypeUpgradeComponent));
	tfUtsDot3OnuHwTypeUpgradeComponent.setName(fStringMap.getString("utsDot3OnuHwTypeUpgradeComponent"));
	baseInfoPanel.add(tfUtsDot3OnuHwTypeUpgradeComponent);
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
	tfUtsDot3OnuHwTypeUpgradeFwRev.setLenScope(0, 63);
	tfUtsDot3OnuHwTypeUpgradeImageName.setLenScope(0, 63);
	tfUtsDot3OnuHwTypeUpgradeMethod.setSelectedIndex(0);
    }

    public void refresh() {
	if (SnmpAction.IType.ADD.equals(fCommand))
	    return;

	ONUUpgradeHwTableMBean mbean = (ONUUpgradeHwTableMBean) getModel();
	if (mbean == null)
	    return;

//	tfUtsDot3OnuHwTypeUpgradeHwType.setSelectedIndex(getIndexFromValue(utsDot3OnuHwTypeUpgradeHwTypeVList, mbean.getUtsDot3OnuHwTypeUpgradeHwType().intValue()));
        tfUtsDot3OnuHwTypeUpgradeHwType.setSelectedIndex(mbean.getUtsDot3OnuHwTypeUpgradeHwType().intValue()-1);
	tfUtsDot3OnuHwTypeUpgradeMethod.setSelectedIndex(getIndexFromValue(utsDot3OnuHwTypeUpgradeMethodVList, mbean.getUtsDot3OnuHwTypeUpgradeMethod().intValue()));
	tfUtsDot3OnuHwTypeUpgradeFwRev.setValue(mbean.getUtsDot3OnuHwTypeUpgradeFwRev());
	tfUtsDot3OnuHwTypeUpgradeImageName.setValue(mbean.getUtsDot3OnuHwTypeUpgradeImageName());
	tfUtsDot3OnuHwTypeUpgradeComponent.setSelectedIndex(getIndexFromValue(utsDot3OnuHwTypeUpgradeComponentVList, mbean.getUtsDot3OnuHwTypeUpgradeComponent().intValue()));
    }

    public boolean validateFrom() {
//	int onuHWType = utsDot3OnuHwTypeUpgradeHwTypeVList[tfUtsDot3OnuHwTypeUpgradeHwType.getSelectedIndex()];
        int onuHWType = tfUtsDot3OnuHwTypeUpgradeHwType.getSelectedIndex() + 1;
	int onuUpgradeMethod = utsDot3OnuHwTypeUpgradeMethodVList[tfUtsDot3OnuHwTypeUpgradeMethod.getSelectedIndex()];
	int onuHWComponent = utsDot3OnuHwTypeUpgradeComponentVList[tfUtsDot3OnuHwTypeUpgradeComponent.getSelectedIndex()];

	ONUUpgradeHwTableMBean mbean = new ONUUpgradeHwTableMBean(fApplication.getSnmpProxy());

	Vector v = new Vector();
	try {
	    v = mbean.retrieveAll();
	} catch (MibBeanException e) {
	    e.printStackTrace();
	}

	if (v != null) {
	    for (int i = 0; i < v.size(); i++) {
		ONUUpgradeHwTableMBean one = (ONUUpgradeHwTableMBean) v.get(i);
		int i1 = one.getUtsDot3OnuHwTypeUpgradeHwType();
		int i2 = one.getUtsDot3OnuHwTypeUpgradeMethod();
		int i3 = one.getUtsDot3OnuHwTypeUpgradeComponent();
		if (i1 == onuHWType && i2 == onuUpgradeMethod && i3 == onuHWComponent) {
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
	    setModel(new ONUUpgradeHwTableMBean(fApplication.getSnmpProxy()));

	ONUUpgradeHwTableMBean mbean = (ONUUpgradeHwTableMBean) getModel();
	if (mbean == null)
	    return;

//	mbean.setUtsDot3OnuHwTypeUpgradeHwType(utsDot3OnuHwTypeUpgradeHwTypeVList[tfUtsDot3OnuHwTypeUpgradeHwType.getSelectedIndex()]);
        mbean.setUtsDot3OnuHwTypeUpgradeHwType(1);
	mbean.setUtsDot3OnuHwTypeUpgradeMethod(utsDot3OnuHwTypeUpgradeMethodVList[tfUtsDot3OnuHwTypeUpgradeMethod.getSelectedIndex()]);
	mbean.setUtsDot3OnuHwTypeUpgradeFwRev(tfUtsDot3OnuHwTypeUpgradeFwRev.getValue());
	mbean.setUtsDot3OnuHwTypeUpgradeImageName(tfUtsDot3OnuHwTypeUpgradeImageName.getValue());
	mbean.setUtsDot3OnuHwTypeUpgradeComponent(utsDot3OnuHwTypeUpgradeComponentVList[tfUtsDot3OnuHwTypeUpgradeComponent.getSelectedIndex()]);
    }

    public int getIndexFromValue(int[] list, int v) {
	for (int i = 0; i != list.length; i++) {
	    if (list[i] == v)
		return i;
	}

	return 0;
    }


}