package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.ProfileOnuBean;
import com.winnertel.lct.batch.bean.ProfileUniBean;
import com.winnertel.lct.batch.proxy.XmlProxy;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.awt.*;

public class ProfileUniPanel extends UPanel {
    private final String idLabel = "UNI ID";
    private final String vlanModeL = fStringMap.getString("utsDot3OnuEtherPortVlanMode");
    private final String vlanTagL = fStringMap.getString("utsDot3OnuEtherPortVlanTag");
    private final String passVlanL = fStringMap.getString("passVlan");
    private final String vlanTpidL = fStringMap.getString("utsDot3OnuEtherPortVlanTPID");
    private final String policingCirL = fStringMap.getString("upPir");
    private final String dsPirL = fStringMap.getString("downPir");

    private JCheckBox pon1 = new JCheckBox("PON 1");
    private JCheckBox pon2 = new JCheckBox("PON 2");
    private JCheckBox pon3 = new JCheckBox("PON 3");
    private JCheckBox pon4 = new JCheckBox("PON 4");

    private JCheckBox uni1 = new JCheckBox("1");
    private JCheckBox uni2 = new JCheckBox("2");
    private JCheckBox uni3 = new JCheckBox("3");
    private JCheckBox uni4 = new JCheckBox("4");

    private int[] utsDot3OnuEtherPortVlanModeVList = new int[]{0, 1,
//            2, 3,
            4};
    private String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
//            fStringMap.getString("translation"),
//            fStringMap.getString("n1aggregation"),
            fStringMap.getString("trunk")
    };

    private JComboBox vlanModeF = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
    private IntegerTextField vlanTagF = new IntegerTextField();
    private StringTextField passVlanF = new StringTextField();
    private JComboBox vlanTpidF = new JComboBox(new Object[]{"0x8100", "0x9100"});
    private IntegerTextField policingCirF = new IntegerTextField();
    private IntegerTextField dsPirF = new IntegerTextField();

    private JComboBox vlanModeF2 = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
    private IntegerTextField vlanTagF2 = new IntegerTextField();
    private StringTextField passVlanF2 = new StringTextField();
    private JComboBox vlanTpidF2 = new JComboBox(new Object[]{"0x8100", "0x9100"});
    private IntegerTextField policingCirF2 = new IntegerTextField();
    private IntegerTextField dsPirF2 = new IntegerTextField();

    private JComboBox vlanModeF3 = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
    private IntegerTextField vlanTagF3 = new IntegerTextField();
    private StringTextField passVlanF3 = new StringTextField();
    private JComboBox vlanTpidF3 = new JComboBox(new Object[]{"0x8100", "0x9100"});
    private IntegerTextField policingCirF3 = new IntegerTextField();
    private IntegerTextField dsPirF3 = new IntegerTextField();

    private JComboBox vlanModeF4 = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
    private IntegerTextField vlanTagF4 = new IntegerTextField();
    private StringTextField passVlanF4 = new StringTextField();
    private JComboBox vlanTpidF4 = new JComboBox(new Object[]{"0x8100", "0x9100"});
    private IntegerTextField policingCirF4 = new IntegerTextField();
    private IntegerTextField dsPirF4 = new IntegerTextField();

    public ProfileUniPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel ponPanel = new JPanel();
        NTLayout ponLayout = new NTLayout(1, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ponPanel.setLayout(ponLayout);
        ponPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("PON_Port")));

        ponPanel.add(pon1);
        ponPanel.add(pon2);
        ponPanel.add(pon3);
        ponPanel.add(pon4);

        NTLayout uniLayout = new NTLayout(5, 7, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel uniPanel = new JPanel();
        uniPanel.setLayout(uniLayout);
        uniPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_UNI_port_config")));
        uniPanel.add(new JLabel(idLabel));
        uniPanel.add(new JLabel(vlanModeL));
        uniPanel.add(new JLabel(vlanTagL));
        uniPanel.add(new JLabel(vlanTpidL));
        uniPanel.add(new JLabel(passVlanL));
        uniPanel.add(new JLabel(policingCirL));
        uniPanel.add(new JLabel(dsPirL));

        uniPanel.add(uni1);
        uniPanel.add(vlanModeF);
        uniPanel.add(vlanTagF);
        uniPanel.add(vlanTpidF);
        uniPanel.add(passVlanF);
        uniPanel.add(policingCirF);
        uniPanel.add(dsPirF);
        vlanModeF.addItemListener(e -> vlanModeChange());
        uni1.addChangeListener(e -> uniSelectChange());

        uniPanel.add(uni2);
        uniPanel.add(vlanModeF2);
        uniPanel.add(vlanTagF2);
        uniPanel.add(vlanTpidF2);
        uniPanel.add(passVlanF2);
        uniPanel.add(policingCirF2);
        uniPanel.add(dsPirF2);
        vlanModeF2.addItemListener(e -> vlanModeChange());
        uni2.addChangeListener(e -> uniSelectChange());

        uniPanel.add(uni3);
        uniPanel.add(vlanModeF3);
        uniPanel.add(vlanTagF3);
        uniPanel.add(vlanTpidF3);
        uniPanel.add(passVlanF3);
        uniPanel.add(policingCirF3);
        uniPanel.add(dsPirF3);
        vlanModeF3.addItemListener(e -> vlanModeChange());
        uni3.addChangeListener(e -> uniSelectChange());

        uniPanel.add(uni4);
        uniPanel.add(vlanModeF4);
        uniPanel.add(vlanTagF4);
        uniPanel.add(vlanTpidF4);
        uniPanel.add(passVlanF4);
        uniPanel.add(policingCirF4);
        uniPanel.add(dsPirF4);
        vlanModeF4.addItemListener(e -> vlanModeChange());
        uni4.addChangeListener(e -> uniSelectChange());

        baseInfoPanel.add(ponPanel);
        baseInfoPanel.add(uniPanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    private void uniSelectChange() {
        vlanModeF.setEnabled(uni1.isSelected());
        vlanTagF.setEnabled(uni1.isSelected());
        passVlanF.setEnabled(uni1.isSelected());
        vlanTpidF.setEnabled(uni1.isSelected());
        policingCirF.setEnabled(uni1.isSelected());
        dsPirF.setEnabled(uni1.isSelected());

        vlanModeF2.setEnabled(uni2.isSelected());
        vlanTagF2.setEnabled(uni2.isSelected());
        passVlanF2.setEnabled(uni2.isSelected());
        vlanTpidF2.setEnabled(uni2.isSelected());
        policingCirF2.setEnabled(uni2.isSelected());
        dsPirF2.setEnabled(uni2.isSelected());

        vlanModeF3.setEnabled(uni3.isSelected());
        vlanTagF3.setEnabled(uni3.isSelected());
        passVlanF3.setEnabled(uni3.isSelected());
        vlanTpidF3.setEnabled(uni3.isSelected());
        policingCirF3.setEnabled(uni3.isSelected());
        dsPirF3.setEnabled(uni3.isSelected());

        vlanModeF4.setEnabled(uni4.isSelected());
        vlanTagF4.setEnabled(uni4.isSelected());
        passVlanF4.setEnabled(uni4.isSelected());
        vlanTpidF4.setEnabled(uni4.isSelected());
        policingCirF4.setEnabled(uni4.isSelected());
        dsPirF4.setEnabled(uni4.isSelected());

        vlanModeChange();
    }

    private void vlanModeChange() {
        int str = utsDot3OnuEtherPortVlanModeVList[vlanModeF.getSelectedIndex()];
        if (0 == str) {
            vlanTagF.setEnabled(false);
            passVlanF.setEnabled(false);
            vlanTpidF.setEnabled(false);
        } else if (1 == str) {
            vlanTagF.setEnabled(true);
            passVlanF.setEnabled(false);
            vlanTpidF.setEnabled(true);
        } else if (4 == str) {
            vlanTagF.setEnabled(true);
            passVlanF.setEnabled(true);
            vlanTpidF.setEnabled(true);
        }
        str = utsDot3OnuEtherPortVlanModeVList[vlanModeF2.getSelectedIndex()];
        if (0 == str) {
            vlanTagF2.setEnabled(false);
            passVlanF2.setEnabled(false);
            vlanTpidF2.setEnabled(false);
        } else if (1 == str) {
            vlanTagF2.setEnabled(true);
            passVlanF2.setEnabled(false);
            vlanTpidF2.setEnabled(true);
        } else if (4 == str) {
            vlanTagF2.setEnabled(true);
            passVlanF2.setEnabled(true);
            vlanTpidF2.setEnabled(true);
        }
        str = utsDot3OnuEtherPortVlanModeVList[vlanModeF3.getSelectedIndex()];
        if (0 == str) {
            vlanTagF3.setEnabled(false);
            passVlanF3.setEnabled(false);
            vlanTpidF3.setEnabled(false);
        } else if (1 == str) {
            vlanTagF3.setEnabled(true);
            passVlanF3.setEnabled(false);
            vlanTpidF3.setEnabled(true);
        } else if (4 == str) {
            vlanTagF3.setEnabled(true);
            passVlanF3.setEnabled(true);
            vlanTpidF3.setEnabled(true);
        }
        str = utsDot3OnuEtherPortVlanModeVList[vlanModeF4.getSelectedIndex()];
        if (0 == str) {
            vlanTagF4.setEnabled(false);
            passVlanF4.setEnabled(false);
            vlanTpidF4.setEnabled(false);
        } else if (1 == str) {
            vlanTagF4.setEnabled(true);
            passVlanF4.setEnabled(false);
            vlanTpidF4.setEnabled(true);
        } else if (4 == str) {
            vlanTagF4.setEnabled(true);
            passVlanF4.setEnabled(true);
            vlanTpidF4.setEnabled(true);
        }
    }

    @Override
    public boolean validateFrom() {
        if (passVlanF.isEnabled()) {
            String pv = passVlanF.getValue();
            String[] split = pv.split(";");
            for (String s : split) {
                if (!NumberUtils.isNumber(s)) {
                    String error = fStringMap.getString("Err_pass_vlan_must_numbers_join_by_comma");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
//            if (split.length % 2 != 0) {
//                String error = fStringMap.getString("Err_pass_vlan_count_must_even");
//                MessageDialog.showErrorMessageDialog(fApplication, error);
//                return false;
//            }
        }
        if (passVlanF2.isEnabled()) {
            String pv = passVlanF2.getValue();
            String[] split = pv.split(";");
            for (String s : split) {
                if (!NumberUtils.isNumber(s)) {
                    String error = fStringMap.getString("Err_pass_vlan_must_numbers_join_by_comma");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
//            if (split.length % 2 != 0) {
//                String error = fStringMap.getString("Err_pass_vlan_count_must_even");
//                MessageDialog.showErrorMessageDialog(fApplication, error);
//                return false;
//            }
        }
        if (passVlanF3.isEnabled()) {
            String pv = passVlanF3.getValue();
            String[] split = pv.split(";");
            for (String s : split) {
                if (!NumberUtils.isNumber(s)) {
                    String error = fStringMap.getString("Err_pass_vlan_must_numbers_join_by_comma");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
//            if (split.length % 2 != 0) {
//                String error = fStringMap.getString("Err_pass_vlan_count_must_even");
//                MessageDialog.showErrorMessageDialog(fApplication, error);
//                return false;
//            }
        }
        if (passVlanF4.isEnabled()) {
            String pv = passVlanF4.getValue();
            String[] split = pv.split(";");
            for (String s : split) {
                if (!NumberUtils.isNumber(s)) {
                    String error = fStringMap.getString("Err_pass_vlan_must_numbers_join_by_comma");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
//            if (split.length % 2 != 0) {
//                String error = fStringMap.getString("Err_pass_vlan_count_must_even");
//                MessageDialog.showErrorMessageDialog(fApplication, error);
//                return false;
//            }
        }
        return super.validateFrom();
    }

    public void refresh() {
        pon1.setSelected(false);
        pon2.setSelected(false);
        pon3.setSelected(false);
        pon4.setSelected(false);
        uni1.setSelected(false);
        uni2.setSelected(false);
        uni3.setSelected(false);
        uni4.setSelected(false);
        vlanModeF.setSelectedIndex(0);
        vlanModeF2.setSelectedIndex(0);
        vlanModeF3.setSelectedIndex(0);
        vlanModeF4.setSelectedIndex(0);
        uniSelectChange();
        vlanModeChange();
    }

    public void updateModel() {
//        uniTable.updateUI();
        if (pon1.isSelected()) {
            save(1);
        }
        if (pon2.isSelected()) {
            save(2);
        }
        if (pon3.isSelected()) {
            save(3);
        }
        if (pon4.isSelected()) {
            save(4);
        }
    }

    private void save(int i) {
        try {
            XmlProxy proxy = new XmlProxy(fApplication.getSnmpProxy().getTargetHost());
            if (uni1.isSelected()) {
                ProfileUniBean uni = new ProfileUniBean(proxy);
                uni.setId(i + "-1-1");
                uni.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF.getSelectedIndex()]));
                if (vlanTagF.isEnabled()) {
                    uni.setVlanTag(String.valueOf(vlanTagF.getValue()));
                }
                if (vlanTpidF.isEnabled()) {
                    uni.setVlanTpid(String.valueOf(vlanTpidF.getSelectedItem()));
                }
                if (passVlanF.isEnabled()) {
                    uni.setPassVlan(String.valueOf(passVlanF.getValue()));
                }
                if (policingCirF.getValue() > 0) {
                    uni.setPolicingEnable("1");
                    uni.setPolicingCir(String.valueOf(policingCirF.getValue()));
                    uni.setPolicingCbs("1000");
                    uni.setPolicingEbs("1000");
                }
                if (dsPirF.getValue() > 0) {
                    uni.setDsEnable("1");
                    uni.setDsCir(String.valueOf(dsPirF.getValue()));
                    uni.setDsPir(String.valueOf(dsPirF.getValue()));
                }
                setModel((IMibBean) uni.clone());
                uni.add();
            }
            if (uni2.isSelected()) {
                ProfileUniBean uni = new ProfileUniBean(proxy);
                uni.setId(i + "-1-2");
                uni.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF2.getSelectedIndex()]));
                if (vlanTagF2.isEnabled()) {
                    uni.setVlanTag(String.valueOf(vlanTagF2.getValue()));
                }
                if (vlanTpidF2.isEnabled()) {
                    uni.setVlanTpid(String.valueOf(vlanTpidF2.getSelectedItem()));
                }
                if (passVlanF2.isEnabled()) {
                    uni.setPassVlan(String.valueOf(passVlanF2.getValue()));
                }
                if (policingCirF2.getValue() > 0) {
                    uni.setPolicingEnable("1");
                    uni.setPolicingCir(String.valueOf(policingCirF2.getValue()));
                    uni.setPolicingCbs("1000");
                    uni.setPolicingEbs("1000");
                }
                if (dsPirF2.getValue() > 0) {
                    uni.setDsEnable("1");
                    uni.setDsCir(String.valueOf(dsPirF2.getValue()));
                    uni.setDsPir(String.valueOf(dsPirF2.getValue()));
                }
                setModel((IMibBean) uni.clone());
                uni.add();
            }
            if (uni3.isSelected()) {
                ProfileUniBean uni = new ProfileUniBean(proxy);
                uni.setId(i + "-1-3");
                uni.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF3.getSelectedIndex()]));
                if (vlanTagF3.isEnabled()) {
                    uni.setVlanTag(String.valueOf(vlanTagF3.getValue()));
                }
                if (vlanTpidF3.isEnabled()) {
                    uni.setVlanTpid(String.valueOf(vlanTpidF3.getSelectedItem()));
                }
                if (passVlanF3.isEnabled()) {
                    uni.setPassVlan(String.valueOf(passVlanF3.getValue()));
                }
                if (policingCirF3.getValue() > 0) {
                    uni.setPolicingEnable("1");
                    uni.setPolicingCir(String.valueOf(policingCirF3.getValue()));
                    uni.setPolicingCbs("1000");
                    uni.setPolicingEbs("1000");
                }
                if (dsPirF3.getValue() > 0) {
                    uni.setDsEnable("1");
                    uni.setDsCir(String.valueOf(dsPirF3.getValue()));
                    uni.setDsPir(String.valueOf(dsPirF3.getValue()));
                }
                setModel((IMibBean) uni.clone());
                uni.add();
            }
            if (uni4.isSelected()) {
                ProfileUniBean uni = new ProfileUniBean(proxy);
                uni.setId(i + "-1-4");
                uni.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF4.getSelectedIndex()]));
                if (vlanTagF4.isEnabled()) {
                    uni.setVlanTag(String.valueOf(vlanTagF4.getValue()));
                }
                if (vlanTpidF4.isEnabled()) {
                    uni.setVlanTpid(String.valueOf(vlanTpidF4.getSelectedItem()));
                }
                if (passVlanF4.isEnabled()) {
                    uni.setPassVlan(String.valueOf(passVlanF4.getValue()));
                }
                if (policingCirF4.getValue() > 0) {
                    uni.setPolicingEnable("1");
                    uni.setPolicingCir(String.valueOf(policingCirF4.getValue()));
                    uni.setPolicingCbs("1000");
                    uni.setPolicingEbs("1000");
                }
                if (dsPirF4.getValue() > 0) {
                    uni.setDsEnable("1");
                    uni.setDsCir(String.valueOf(dsPirF4.getValue()));
                    uni.setDsPir(String.valueOf(dsPirF4.getValue()));
                }
                setModel((IMibBean) uni.clone());
                uni.add();
            }
        } catch (MibBeanException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterUpdateModel() {
        super.afterUpdateModel();
        SnmpTablePane snmpTablePane = (SnmpTablePane) this.getTable().getParent().getParent().getParent();
        ProfilePanel profilePanel = (ProfilePanel) snmpTablePane.getParent().getParent().getParent();
        profilePanel.refresh();
    }

    public int getIndexFromValue(String[] list, String v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i].equals(v))
                return i;
        }

        return 0;
    }
}
