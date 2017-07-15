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

import static com.winnertel.lct.batch.gui.TransformUtils.setNullableIntField;

public class ProfileUniPanel extends UPanel {
    private final String idLabel = fStringMap.getString("idLabel") + ": ";
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
    private IntegerTextField vlanModeF = new IntegerTextField();
    private IntegerTextField vlanTagF = new IntegerTextField();
    private IntegerTextField vlanTpidF = new IntegerTextField();
    private IntegerTextField policingEnableF = new IntegerTextField();
    private IntegerTextField policingCirF = new IntegerTextField();
    private IntegerTextField policingCbsF = new IntegerTextField();
    private IntegerTextField policingEbsF = new IntegerTextField();
    private IntegerTextField dsCirF = new IntegerTextField();
    private IntegerTextField dsPirF = new IntegerTextField();
    private IntegerTextField dsEnableF = new IntegerTextField();
    private IntegerTextField loopDetectF = new IntegerTextField();


    public ProfileUniPanel(IApplication app) {
        super(app);
        init();
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

        baseInfoPanel.add(new JLabel(policingCirL));
        baseInfoPanel.add(policingCirF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(policingCbsL));
        baseInfoPanel.add(policingCbsF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(policingEbsL));
        baseInfoPanel.add(policingEbsF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dsCirL));
        baseInfoPanel.add(dsCirF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dsPirL));
        baseInfoPanel.add(dsPirF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dsEnableL));
        baseInfoPanel.add(dsEnableF);
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
        policingEbsF.setValueScope(0, 1522);
        vlanTagF.setValueScope(1, 4094);
        vlanTpidF.setValueScope(1, 65534);
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
            setNullableIntField(vlanModeF, m.getVlanMode());
            setNullableIntField(vlanTagF, m.getVlanTag());
            vlanTpidF.setValue(TransformUtils.fromHexShort(m.getVlanTpid()));
            setNullableIntField(policingEnableF, m.getPolicingEnable());
            setNullableIntField(policingCirF, m.getPolicingCir());
            setNullableIntField(policingCbsF, m.getPolicingCbs());
            setNullableIntField(policingEbsF, m.getPolicingEbs());
            setNullableIntField(dsCirF, m.getDsCir());
            setNullableIntField(dsPirF, m.getDsPir());
            setNullableIntField(dsEnableF, m.getDsEnable());
            setNullableIntField(loopDetectF, m.getLoopDetect());
        }
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
        model.setVlanMode(String.valueOf(vlanModeF.getValue()));
        model.setVlanTag(String.valueOf(vlanTagF.getValue()));
        model.setVlanTpid(TransformUtils.toHexShort(vlanTpidF.getValue()));
        model.setPolicingEnable(String.valueOf(policingEnableF.getValue()));
        model.setPolicingCir(String.valueOf(policingCirF.getValue()));
        model.setPolicingCbs(String.valueOf(policingCbsF.getValue()));
        model.setPolicingEbs(String.valueOf(policingEbsF.getValue()));
        model.setDsCir(String.valueOf(dsCirF.getValue()));
        model.setDsPir(String.valueOf(dsPirF.getValue()));
        model.setDsEnable(String.valueOf(dsEnableF.getValue()));
        model.setLoopDetect(String.valueOf(loopDetectF.getValue()));
    }
}
