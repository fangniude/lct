package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.ProfileUniBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static com.winnertel.lct.batch.gui.TransformUtils.setNullableIntField;

public class ProfileUniPanel extends UPanel {
    private final String idLabel = fStringMap.getString("onuUniId") + ": ";
    private final String vlanModeL = fStringMap.getString("utsDot3OnuEtherPortVlanMode") + ": ";
    private final String vlanTagL = fStringMap.getString("utsDot3OnuEtherPortVlanTag") + ": ";
    private final String vlanTpidL = fStringMap.getString("utsDot3OnuEtherPortVlanTPID") + ": ";
    private final String policingEnableL = fStringMap.getString("utsDot3OnuEtherPortPolicingEnable") + ": ";
    private final String policingCirL = fStringMap.getString("utsDot3OnuEtherPortPolicingCIR") + ": ";
    private final String policingCbsL = fStringMap.getString("utsDot3OnuEtherPortPolicingCBS") + ": ";
    private final String policingEbsL = fStringMap.getString("utsDot3OnuEtherPortPolicingEBS") + ": ";
    private final String dsCirL = fStringMap.getString("utsDot3OnuEtherPortDSPolicingCIR") + ": ";
    private final String dsPirL = fStringMap.getString("utsDot3OnuEtherPortDSPolicingPIR") + ": ";
    private final String dsEnableL = fStringMap.getString("utsDot3OnuEtherPortDSPolicingEnable") + ": ";
    private final String loopDetectL = fStringMap.getString("utsDot3OltPortLoopbackDetection") + ": ";

    private StringTextField idField = new StringTextField();
    private int[] utsDot3OnuEtherPortVlanModeVList = new int[]{0, 1, 2, 3, 4};
    private String[] utsDot3OnuEtherPortVlanModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
            fStringMap.getString("translation"),
            fStringMap.getString("n1aggregation"),
            fStringMap.getString("trunk")
    };
    private JComboBox vlanModeF = new JComboBox(utsDot3OnuEtherPortVlanModeTList);
    private IntegerTextField vlanTagF = new IntegerTextField();
    private IntegerTextField vlanTpidF = new IntegerTextField();

    private int[] policingEnableVList = new int[]{1, 0};
    private String[] policingEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox policingEnableF = new JComboBox(policingEnableTList);

    private JComboBox policingCirF = new JComboBox(policingCirVals());
    private JComboBox policingCbsF = new JComboBox(policingCbsVals());
    private IntegerTextField policingEbsF = new IntegerTextField();

    private int[] dsEnableVList = new int[]{1, 0};
    private String[] dsEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox dsEnableF = new JComboBox(dsEnableTList);

    private JComboBox dsCirF = new JComboBox(dsCirPirVals());
    private JComboBox dsPirF = new JComboBox(dsCirPirVals());

    private int[] loopDetectVList = new int[]{1, 0};
    private String[] loopDetectTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox loopDetectF = new JComboBox(loopDetectTList);


    public ProfileUniPanel(IApplication app) {
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
        NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(idLabel));
        baseInfoPanel.add(idField);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(vlanModeL));
        baseInfoPanel.add(vlanModeF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(vlanTagL));
        baseInfoPanel.add(vlanTagF);
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

        baseInfoPanel.add(new JLabel(policingCbsL));
        baseInfoPanel.add(policingCbsF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(policingEbsL));
        baseInfoPanel.add(policingEbsF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dsEnableL));
        baseInfoPanel.add(dsEnableF);
        baseInfoPanel.add(new HSpacer());

        dsEnableF.addItemListener(e -> dsEnable());

        baseInfoPanel.add(new JLabel(dsCirL));
        baseInfoPanel.add(dsCirF);
        baseInfoPanel.add(new HSpacer());

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
        idField.setDefaultString("1-1-1");
        policingEbsF.setValueScope(0, 1522);
        vlanTagF.setValueScope(1, 4094);
        vlanTpidF.setValueScope(1, 65534);
    }

    public void policingEnable() {
        if (policingEnableF.getSelectedIndex() == 1) {
            policingCirF.setEnabled(false);
            policingCbsF.setEnabled(false);
            policingEbsF.setEnabled(false);
        } else {
            policingCirF.setEnabled(true);
            policingCbsF.setEnabled(true);
            policingEbsF.setEnabled(true);
        }
    }

    public void dsEnable() {
        if (dsEnableF.getSelectedIndex() == 1) {
            dsCirF.setEnabled(false);
            dsPirF.setEnabled(false);
        } else {
            dsCirF.setEnabled(true);
            dsPirF.setEnabled(true);
        }
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            idField.setEditable(true);
            return;
        } else {
            ProfileUniBean m = (ProfileUniBean) getModel();
            if (m == null) {
                throw new RuntimeException("error");
            }

            idField.setEditable(false);
            idField.setValue(m.getId());
            vlanModeF.setSelectedIndex(getIndexFromValue(utsDot3OnuEtherPortVlanModeVList, Integer.valueOf(m.getVlanMode())));
            setNullableIntField(vlanTagF, m.getVlanTag());
            vlanTpidF.setValue(TransformUtils.fromHexShort(m.getVlanTpid()));

            policingEnableF.setSelectedIndex(getIndexFromValue(policingEnableVList, Integer.valueOf(m.getPolicingEnable())));
            if (policingEnableF.getSelectedIndex() == 0) {
                policingCirF.setSelectedItem(Integer.valueOf(m.getPolicingCir()));
                policingCbsF.setSelectedItem(Integer.valueOf(m.getPolicingCbs()));
                setNullableIntField(policingEbsF, m.getPolicingEbs());
            }
            dsEnableF.setSelectedIndex(getIndexFromValue(dsEnableVList, Integer.valueOf(m.getDsEnable())));
            if (dsEnableF.getSelectedIndex() == 0) {
                dsCirF.setSelectedItem(Integer.valueOf(m.getDsCir()));
                dsPirF.setSelectedItem(Integer.valueOf(m.getDsPir()));
            }
            loopDetectF.setSelectedIndex(getIndexFromValue(dsEnableVList, Integer.valueOf(m.getLoopDetect())));
        }
        policingEnable();
        dsEnable();
    }

    public void updateModel() {
        ProfileUniBean model;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            model = new ProfileUniBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(String.valueOf(idField.getValue()));
            setModel(model);
        } else {
            model = (ProfileUniBean) getModel();
        }
        model.setVlanMode(String.valueOf(utsDot3OnuEtherPortVlanModeVList[vlanModeF.getSelectedIndex()]));
        model.setVlanTag(String.valueOf(vlanTagF.getValue()));
        model.setVlanTpid(TransformUtils.toHexShort(vlanTpidF.getValue()));
        model.setPolicingEnable(String.valueOf(policingEnableVList[policingEnableF.getSelectedIndex()]));
        if (policingEnableF.getSelectedIndex() == 0) {
            model.setPolicingCir(String.valueOf(policingCirF.getSelectedItem()));
            model.setPolicingCbs(String.valueOf(policingCbsF.getSelectedItem()));
            model.setPolicingEbs(String.valueOf(policingEbsF.getValue()));
        }
        model.setDsEnable(String.valueOf(dsEnableVList[dsEnableF.getSelectedIndex()]));
        if (dsEnableF.getSelectedIndex() == 0) {
            model.setDsCir(String.valueOf(dsCirF.getSelectedItem()));
            model.setDsPir(String.valueOf(dsPirF.getSelectedItem()));
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
