package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.lct.batch.bean.ProfileOnuBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

import static com.winnertel.lct.batch.gui.TransformUtils.*;

public class ProfileOnuPanel extends UPanel {

    private final String idLabel = fStringMap.getString("idLabel") + ": ";
    private final String upMaxBwLabel = fStringMap.getString("utsDot3OnuUpstreamPir") + ": ";
    private final String downMaxBwLabel = fStringMap.getString("utsDot3OnuDownstreamPir") + ": ";
    private final String upCommittedBwLabel = fStringMap.getString("utsDot3OnuUpstreamCir") + ": ";
    private final String downCommittedBwLabel = fStringMap.getString("utsDot3OnuDownstreamCir") + ": ";
    private final String upFixBwLabel = fStringMap.getString("utsDot3OnuUpstreamFir") + ": ";
    private final String upBurstSizeLabel = fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize") + ": ";
    private final String downBurstSizeLabel = fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize") + ": ";
    private final String upPriorityLabel = fStringMap.getString("utsDot3OnuUpstreamWeight") + ": ";

    private final String mxuIpAddressL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr") + ": ";
    private final String mxuIpMaskL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask") + ": ";
    private final String mxuGatewayL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfGw") + ": ";
    private final String mxuCVlanL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan") + ": ";
    private final String mxuSVlanL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan") + ": ";
    private final String mxuPriorityL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfDataPrio") + ": ";


    private StringTextField idField = new StringTextField();
    private IntegerTextField upMaxBwF = new IntegerTextField();
    private IntegerTextField downMaxBwF = new IntegerTextField();
    private IntegerTextField upCommittedBwF = new IntegerTextField();
    private IntegerTextField downCommittedBwF = new IntegerTextField();
    private IntegerTextField upFixBwF = new IntegerTextField();
    private IntegerTextField upBurstSizeF = new IntegerTextField();
    private IntegerTextField downBurstSizeF = new IntegerTextField();
    private IntegerTextField upPriorityF = new IntegerTextField();

    private IPAddressField mxuIpAddressF = new IPAddressField();
    private IPAddressField mxuIpMaskF = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField mxuGatewayF = new IPAddressField();
    private IntegerTextField mxuCVlanF = new IntegerTextField();
    private IntegerTextField mxuSVlanF = new IntegerTextField();
    private IntegerTextField mxuPriorityF = new IntegerTextField();


    public ProfileOnuPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(15, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(idLabel));
        baseInfoPanel.add(idField);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upMaxBwLabel));
        baseInfoPanel.add(upMaxBwF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(downMaxBwLabel));
        baseInfoPanel.add(downMaxBwF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upCommittedBwLabel));
        baseInfoPanel.add(upCommittedBwF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(downCommittedBwLabel));
        baseInfoPanel.add(downCommittedBwF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upFixBwLabel));
        baseInfoPanel.add(upFixBwF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upBurstSizeLabel));
        baseInfoPanel.add(upBurstSizeF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(downBurstSizeLabel));
        baseInfoPanel.add(downBurstSizeF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upPriorityLabel));
        baseInfoPanel.add(upPriorityF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuIpAddressL));
        baseInfoPanel.add(mxuIpAddressF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuIpMaskL));
        baseInfoPanel.add(mxuIpMaskF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuGatewayL));
        baseInfoPanel.add(mxuGatewayF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuCVlanL));
        baseInfoPanel.add(mxuCVlanF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuSVlanL));
        baseInfoPanel.add(mxuSVlanF);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(mxuPriorityL));
        baseInfoPanel.add(mxuPriorityF);
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
        upMaxBwF.setValueScope(1, 1000000);
        downMaxBwF.setValueScope(1, 1000000);
        upCommittedBwF.setValueScope(1, 1000000);
        downCommittedBwF.setValueScope(1, 1000000);
        upBurstSizeF.setValueScope(1, 1000);
        downBurstSizeF.setValueScope(1, 1000);
        upPriorityF.setValueScope(1, 10);
        upFixBwF.setValueScope(0, 1000000);

        mxuCVlanF.setValueScope(1, 4094);
        mxuSVlanF.setValueScope(0, 4094);
        mxuSVlanF.setValue(0);
        mxuPriorityF.setValueScope(0, 7);
        mxuPriorityF.setValue(5);
    }

    public boolean validateFrom() {
        if (upCommittedBwF.getValue() > upMaxBwF.getValue()) {
            String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        if (downCommittedBwF.getValue() > downMaxBwF.getValue()) {
            String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
            MessageDialog.showErrorMessageDialog(fApplication, error);
            return false;
        }

        return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            idField.setEditable(true);
            return;
        } else {
            ProfileOnuBean m = (ProfileOnuBean) getModel();
            if (m == null) {
                throw new RuntimeException("error");
            }

            idField.setEditable(false);
            idField.setValue(m.getId());
            setNullableIntField(upMaxBwF, m.getUpMaxBw());
            setNullableIntField(downMaxBwF, m.getDownMaxBw());
            setNullableIntField(upCommittedBwF, m.getUpCommittedBw());
            setNullableIntField(downCommittedBwF, m.getDownCommittedBw());
            setNullableIntField(upFixBwF, m.getUpFixBw());
            setNullableIntField(upBurstSizeF, m.getUpBurstSize());
            setNullableIntField(downBurstSizeF, m.getDownBurstSize());
            setNullableIntField(upPriorityF, m.getUpPriority());

            mxuIpAddressF.setValue(fromHexIp(m.getMxuIpAddress()));
            mxuIpMaskF.setValue(fromHexIp(m.getMxuIpMask()));
            mxuGatewayF.setValue(fromHexIp(m.getMxuGateway()));
            mxuCVlanF.setValue(fromHexShort(m.getMxuCVlan()));
            mxuSVlanF.setValue(fromHexShort(m.getMxuSVlan()));
            mxuPriorityF.setValue(fromHexByte(m.getMxuPriority()));
        }
    }

    public void updateModel() {
        ProfileOnuBean model;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            model = new ProfileOnuBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(String.valueOf(idField.getValue()));
            setModel(model);
        } else {
            model = (ProfileOnuBean) getModel();
        }
        model.setUpMaxBw(String.valueOf(upMaxBwF.getValue()));
        model.setDownMaxBw(String.valueOf(downMaxBwF.getValue()));
        model.setUpCommittedBw(String.valueOf(upCommittedBwF.getValue()));
        model.setDownCommittedBw(String.valueOf(downCommittedBwF.getValue()));
        model.setUpFixBw(String.valueOf(upFixBwF.getValue()));
        model.setUpBurstSize(String.valueOf(upBurstSizeF.getValue()));
        model.setDownBurstSize(String.valueOf(downBurstSizeF.getValue()));
        model.setUpPriority(String.valueOf(upPriorityF.getValue()));

        model.setMxuIpAddress(toHexIp(mxuIpAddressF.getValue()));
        model.setMxuIpMask(toHexIp(mxuIpAddressF.getValue()));
        model.setMxuGateway(toHexIp(mxuIpAddressF.getValue()));
        model.setMxuCVlan(toHexShort(mxuCVlanF.getValue()));
        model.setMxuSVlan(toHexShort(mxuSVlanF.getValue()));
        model.setMxuPriority(toHexByte(mxuPriorityF.getValue()));
    }
}
