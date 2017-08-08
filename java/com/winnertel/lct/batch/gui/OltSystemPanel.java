package com.winnertel.lct.batch.gui;

import com.jgoodies.common.base.Strings;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.OltSystemBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

import static com.winnertel.lct.batch.gui.TransformUtils.fromHex;
import static com.winnertel.lct.batch.gui.TransformUtils.toHex;

public class OltSystemPanel extends UPanel {
    private final String nameLabel = fStringMap.getString("sysName") + ": ";
    private final String locationLabel = fStringMap.getString("sysLocation") + ": ";
    private final String contactLabel = fStringMap.getString("sysContact") + ": ";
    private final String mgmtVlanLabel = fStringMap.getString("mgmtVlanLabel") + ": ";
    private final String macAgeingLabel = fStringMap.getString("utsPonSysOltMACAgingTime") + ": ";
    private final String macAuthLabel = fStringMap.getString("macAuthLabel") + ": ";
    private final String vlanTransParentLabel = fStringMap.getString("vlanTransParentLabel") + ": ";
    private final String globalP2pLabel = fStringMap.getString("globalP2pLabel") + ": ";
    private final String mgmtIpLabel = fStringMap.getString("mgmtIpLabel") + ": ";


    private StringTextField nameField = new StringTextField();
    private StringTextField locationField = new StringTextField();
    private StringTextField contactField = new StringTextField();
    private IntegerTextField mgmtVlanField = new IntegerTextField();
    private IntegerTextField macAgeingField = new IntegerTextField();

//    private int[] macAuthFieldVList = new int[]{0, 1, 2
////            , 3, 4, 8
//    };


    private String[] macAuthFieldVList = new String[]{"disable", "mac_auth", "mac_auto"
//            , "loid_auth", "loid_paswd_auth", "hybrid_auth"
//            , 3, 4, 8
    };
    private String[] macAuthFieldTList = new String[]{
            fStringMap.getString("disableAuth"),
            fStringMap.getString("macAuth"),
            fStringMap.getString("macAuto"),
//            fStringMap.getString("loidAuth"),
//            fStringMap.getString("loidPwd"),
//            fStringMap.getString("hybridAuth")
    };
    private JComboBox macAuthField = new JComboBox(macAuthFieldTList);
    private JComboBox vlanTransParentField = new JComboBox(new Object[]{"enable", "disable"});
    private JComboBox globalP2pField = new JComboBox(new Object[]{"disable", "enable"});
    private IPAddressField mgmtIpField = new IPAddressField();


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    public OltSystemPanel(IApplication app) {
        super(app);
        setModel(new OltSystemBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost())));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(9, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(nameLabel));
        baseInfoPanel1.add(nameField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(locationLabel));
        baseInfoPanel1.add(locationField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(contactLabel));
        baseInfoPanel1.add(contactField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(mgmtIpLabel));
        baseInfoPanel1.add(mgmtIpField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(mgmtVlanLabel));
        baseInfoPanel1.add(mgmtVlanField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(macAuthLabel));
        baseInfoPanel1.add(macAuthField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(macAgeingLabel));
        baseInfoPanel1.add(macAgeingField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(vlanTransParentLabel));
        baseInfoPanel1.add(vlanTransParentField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(globalP2pLabel));
        baseInfoPanel1.add(globalP2pField);
        baseInfoPanel1.add(new HSpacer());

        JPanel allPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel1);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);


        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_OltSystemInfoMbean");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    protected void initForm() {
        mgmtVlanField.setValueScope(0, 4094);
        macAgeingField.setValueScope(0, 2400);
        mgmtVlanField.setDefaultValue(0);
        macAgeingField.setDefaultValue(300);
        vlanTransParentField.setSelectedIndex(0);
        globalP2pField.setSelectedIndex(0);
    }

    public void refresh() {

        OltSystemBean mbean = (OltSystemBean) getModel();
        BeanService.refreshBean(fApplication, mbean);

        if (mbean == null) {
            throw new RuntimeException("error");
        }

        nameField.setValue(fromHex(mbean.getName()));
        locationField.setValue(fromHex(mbean.getLocation()));
        contactField.setValue(fromHex(mbean.getContact()));
        String mgmtVlan = mbean.getMgmtVlan();
        if (mgmtVlan != null && !mgmtVlan.trim().isEmpty()) {
            try {
                mgmtVlanField.setValue(Integer.valueOf(mgmtVlan));
            } catch (NumberFormatException e) {
                mgmtVlanField.setValue(0);
            }
        }
        String macAgeing = mbean.getMacAgeing();
        if (macAgeing != null && !macAgeing.trim().isEmpty()) {
            try {
                macAgeingField.setValue(Integer.valueOf(macAgeing));
            } catch (NumberFormatException e) {
                macAgeingField.setValue(0);
            }
        }
        String macAuth = mbean.getMacAuth();
        if (Strings.isNotEmpty(macAuth)) {
            macAuthField.setSelectedIndex(getIndexFromValue(macAuthFieldVList, macAuth));
        } else {
            macAuthField.setSelectedIndex(0);
        }
        String vlanTransParent = mbean.getVlanTransParent();
        if (Strings.isNotEmpty(vlanTransParent)) {
            vlanTransParentField.setSelectedItem(vlanTransParent);
        } else {
            vlanTransParentField.setSelectedIndex(0);
        }
        String globalP2p = mbean.getGlobalP2p();
        if (Strings.isNotEmpty(globalP2p)) {
            globalP2pField.setSelectedItem(globalP2p);
        } else {
            globalP2pField.setSelectedIndex(0);
        }
        mgmtIpField.setValue(mbean.getMgmtIp());
    }

    public void updateModel() {
        OltSystemBean model = (OltSystemBean) getModel();
        model.setName(toHex(nameField.getValue()));
        model.setLocation(toHex(locationField.getValue()));
        model.setContact(toHex(contactField.getValue()));
        model.setMgmtVlan(String.valueOf(mgmtVlanField.getValue()));
        model.setMacAgeing(String.valueOf(macAgeingField.getValue()));
        model.setMacAuth(macAuthFieldVList[macAuthField.getSelectedIndex()]);
        model.setVlanTransParent(String.valueOf(vlanTransParentField.getSelectedItem()));
        model.setGlobalP2p(String.valueOf(globalP2pField.getSelectedItem()));
        model.setMgmtIp(mgmtIpField.getIPString());
    }

    public int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i].equals(v))
                return i;
        }

        return 0;
    }
}
