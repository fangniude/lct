package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.OnuUniBean;
import com.winnertel.lct.batch.proxy.XmlProxy;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static com.winnertel.lct.batch.gui.TransformUtils.setNullableIntField;

public class OnuUniPanel extends UPanel {
    private final String idLabel = fStringMap.getString("onuUniId") + ": ";
    private final String vlanModeL = fStringMap.getString("utsDot3OnuEtherPortVlanMode") + ": ";
    private final String vlanTagL = fStringMap.getString("utsDot3OnuEtherPortVlanTag") + ": ";
    private final String passVlanL = fStringMap.getString("passVlan") + ": ";
    private final String vlanTpidL = fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + ": ";
    private final String policingEnableL = fStringMap.getString("utsDot3OnuEtherPortPolicingEnable") + ": ";
    private final String policingCirL = fStringMap.getString("upPir") + ": ";
    //    private final String policingCbsL = fStringMap.getString("utsDot3OnuEtherPortPolicingCBS") + ": ";
//    private final String policingEbsL = fStringMap.getString("utsDot3OnuEtherPortPolicingEBS") + ": ";
    private final String dsEnableL = fStringMap.getString("utsDot3OnuEtherPortDSPolicingEnable") + ": ";
    //    private final String dsCirL = fStringMap.getString("downPir") + ": ";
    private final String dsPirL = fStringMap.getString("downPir") + ": ";
    private final String loopDetectL = fStringMap.getString("utsDot3OltPortLoopbackDetection") + ": ";

    private StringTextField idField = new StringTextField();
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

    private int[] policingEnableVList = new int[]{0, 1};
    private String[] policingEnableTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable")
    };
    private JComboBox policingEnableF = new JComboBox(policingEnableTList);

    //    private JComboBox policingCirF = new JComboBox(policingCirVals());
//    private JComboBox policingCbsF = new JComboBox(policingCbsVals());
    private IntegerTextField policingCirF = new IntegerTextField();

    private int[] dsEnableVList = new int[]{0, 1};
    private String[] dsEnableTList = new String[]{
            fStringMap.getString("disable"),
            fStringMap.getString("enable")
    };
    private JComboBox dsEnableF = new JComboBox(dsEnableTList);

    //    private JComboBox dsCirF = new JComboBox(dsCirPirVals());
    private IntegerTextField dsPirF = new IntegerTextField();
//    private JComboBox dsPirF = new JComboBox(dsCirPirVals());

    private int[] loopDetectVList = new int[]{1, 0};
    private String[] loopDetectTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox loopDetectF = new JComboBox(loopDetectTList);


    public OnuUniPanel(IApplication app) {
        super(app);
        init();
    }

    private Vector policingCirVals() {
        Vector tmpVec = new Vector();
        for (int i = 1000; i <= 127000; i += 1000) {
            tmpVec.add(i);
        }
        return tmpVec;
    }

    private Vector policingCbsVals() {
        Vector tmpVec = new Vector();
        for (int i = 1536; i <= 65280; i += 256) {
            tmpVec.add(new Integer(i));
        }
        return tmpVec;
    }

    private Vector dsCirPirVals() {
        Vector tmpVec = new Vector();
        for (int i = 0; i <= 1000; i += 128) {
            tmpVec.add(new Integer(i));
        }
        for (int i = 1000; i <= 16777215; i += 1000) {
            tmpVec.add(i);
        }
        return tmpVec;
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(13, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(idLabel));
        baseInfoPanel.add(idField);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(vlanModeL));
        baseInfoPanel.add(vlanModeF);
        baseInfoPanel.add(new HSpacer());

        vlanModeF.addItemListener(e -> vlanModeChange());

        baseInfoPanel.add(new JLabel(vlanTagL));
        baseInfoPanel.add(vlanTagF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(passVlanL));
        baseInfoPanel.add(passVlanF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(vlanTpidL));
        baseInfoPanel.add(vlanTpidF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(policingEnableL));
        baseInfoPanel.add(policingEnableF);
        baseInfoPanel.add(new HSpacer());

        policingEnableF.addItemListener(e -> policingEnable());

        baseInfoPanel.add(new JLabel(policingCirL));
        baseInfoPanel.add(policingCirF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dsEnableL));
        baseInfoPanel.add(dsEnableF);
        baseInfoPanel.add(new HSpacer());

        dsEnableF.addItemListener(e -> dsEnable());

        baseInfoPanel.add(new JLabel(dsPirL));
        baseInfoPanel.add(dsPirF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(loopDetectL));
        baseInfoPanel.add(loopDetectF);
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
        idField.setDefaultString("1/1/1/1");
        vlanTagF.setValueScope(2, 4094);
        policingCirF.setValueScope(256, 1000000);
        dsPirF.setValueScope(256, 1000000);
        vlanModeF.setSelectedIndex(0);
        policingEnableF.setSelectedIndex(0);
        dsEnableF.setSelectedIndex(0);
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
    }

    public void policingEnable() {
        if (policingEnableF.getSelectedIndex() == 0) {
            policingCirF.setEnabled(false);
        } else {
            policingCirF.setEnabled(true);
        }
    }

    public void dsEnable() {
        if (dsEnableF.getSelectedIndex() == 0) {
            dsPirF.setEnabled(false);
        } else {
            dsPirF.setEnabled(true);
        }
    }

    @Override
    public boolean validateFrom() {
        if (passVlanF.isEnabled()) {
            String pv = passVlanF.getValue();
            String[] split = pv.split(",");
            for (String s : split) {
                if (!NumberUtils.isNumber(s)) {
                    String error = fStringMap.getString("Err_pass_vlan_must_numbers_join_by_comma");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }
            if (split.length % 2 != 0) {
                String error = fStringMap.getString("Err_pass_vlan_count_must_even");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        return super.validateFrom();
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            idField.setEditable(true);
            vlanModeF.setSelectedIndex(0);
            policingEnableF.setSelectedIndex(0);
            dsEnableF.setSelectedIndex(0);
        } else {
            OnuUniBean m = (OnuUniBean) getModel();
            if (m == null) {
                throw new RuntimeException("error");
            }

            idField.setEditable(false);
            idField.setValue(TransformUtils.displayUniId(m.getId()));
            vlanModeF.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortVlanModeVList, Integer.valueOf(m.getVlanMode())));
            setNullableIntField(vlanTagF, m.getVlanTag());
            vlanTpidF.setSelectedItem(m.getVlanTpid());

            policingEnableF.setSelectedIndex(getIndexFromValue(policingEnableVList, Integer.valueOf(m.getPolicingEnable())));
            if (policingEnableF.getSelectedIndex() == 1) {
                policingCirF.setValue(Integer.valueOf(m.getPolicingCir()));
            }
            dsEnableF.setSelectedIndex(getIndexFromValue(dsEnableVList, Integer.valueOf(m.getDsEnable())));
            if (dsEnableF.getSelectedIndex() == 1) {
                dsPirF.setValue(Integer.valueOf(m.getDsPir()));
            }
            loopDetectF.setSelectedIndex(getIndexFromValue(dsEnableVList, Integer.valueOf(m.getLoopDetect())));
        }
        vlanModeChange();
        policingEnable();
        dsEnable();
    }

    public void updateModel() {
        OnuUniBean model;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            model = new OnuUniBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(TransformUtils.saveUniId(idField.getValue()));
            setModel(model);
        } else {
            model = (OnuUniBean) getModel();
        }
        model.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF.getSelectedIndex()]));
        if (vlanTagF.isEnabled()) {
            model.setVlanTag(String.valueOf(vlanTagF.getValue()));
        }
        if (vlanTpidF.isEnabled()) {
            model.setVlanTpid(String.valueOf(vlanTpidF.getSelectedItem()));
        }
        if (passVlanF.isEnabled()) {
            model.setPassVlan(String.valueOf(passVlanF.getValue()));
        }
        model.setPolicingEnable(String.valueOf(policingEnableVList[policingEnableF.getSelectedIndex()]));
        if (policingEnableF.getSelectedIndex() == 1) {
            model.setPolicingCir(String.valueOf(policingCirF.getValue()));
            model.setPolicingCbs("1000");
            model.setPolicingEbs("1000");
        }
        model.setDsEnable(String.valueOf(dsEnableVList[dsEnableF.getSelectedIndex()]));
        if (dsEnableF.getSelectedIndex() == 1) {
            model.setDsCir(String.valueOf(dsPirF.getValue()));
            model.setDsPir(String.valueOf(dsPirF.getValue()));
        }
        model.setLoopDetect(String.valueOf(loopDetectVList[loopDetectF.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }
}
