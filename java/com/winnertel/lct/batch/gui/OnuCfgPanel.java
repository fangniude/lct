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
import com.winnertel.lct.batch.bean.OnuCfgBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

import static com.winnertel.lct.batch.gui.TransformUtils.*;

public class OnuCfgPanel extends UPanel {

    private final String idLabel = fStringMap.getString("onuId") + ": ";
    private final String dbaSlaEnableLabel = fStringMap.getString("dbaSlaEnable") + ": ";
    private final String upMaxBwLabel = fStringMap.getString("utsDot3OnuUpstreamPir") + ": ";
    private final String downMaxBwLabel = fStringMap.getString("utsDot3OnuDownstreamPir") + ": ";
    private final String upCommittedBwLabel = fStringMap.getString("utsDot3OnuUpstreamCir") + ": ";
    private final String downCommittedBwLabel = fStringMap.getString("utsDot3OnuDownstreamCir") + ": ";
    private final String upFixBwLabel = fStringMap.getString("utsDot3OnuUpstreamFir") + ": ";
    private final String upBurstSizeLabel = fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize") + ": ";
    private final String downBurstSizeLabel = fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize") + ": ";
    private final String upPriorityLabel = fStringMap.getString("utsDot3OnuUpstreamWeight") + ": ";

    private final String mxuMgmtGlbEnableL = fStringMap.getString("mxuMgmtGlbEnable") + ": ";
    private final String mxuIpAddressL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr") + ": ";
    private final String mxuIpMaskL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask") + ": ";
    private final String mxuGatewayL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfGw") + ": ";
    private final String mxuCVlanL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan") + ": ";
    private final String mxuSVlanL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan") + ": ";
    private final String mxuPriorityL = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfDataPrio") + ": ";


    private StringTextField idField = new StringTextField();

    private int[] dbaSlaEnableVList = new int[]{1, 0};
    private String[] dbaSlaEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox dbaSlaEnableF = new JComboBox(dbaSlaEnableTList);
    private IntegerTextField upMaxBwF = new IntegerTextField();
    private IntegerTextField downMaxBwF = new IntegerTextField();
    private IntegerTextField upCommittedBwF = new IntegerTextField();
    private IntegerTextField downCommittedBwF = new IntegerTextField();
    private IntegerTextField upFixBwF = new IntegerTextField();
    private IntegerTextField upBurstSizeF = new IntegerTextField();
    private IntegerTextField downBurstSizeF = new IntegerTextField();
    private IntegerTextField upPriorityF = new IntegerTextField();

    private int[] mxuMgmtGlbEnableVList = new int[]{1, 0};
    private String[] mxuMgmtGlbEnableTList = new String[]{
            fStringMap.getString("enable"),
            fStringMap.getString("disable")
    };
    private JComboBox mxuMgmtGlbEnableF = new JComboBox(mxuMgmtGlbEnableTList);
    private IPAddressField mxuIpAddressF = new IPAddressField();
    private IPAddressField mxuIpMaskF = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField mxuGatewayF = new IPAddressField();
    private IntegerTextField mxuCVlanF = new IntegerTextField();
    private IntegerTextField mxuSVlanF = new IntegerTextField();
    private IntegerTextField mxuPriorityF = new IntegerTextField();


    public OnuCfgPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(idLabel));
        baseInfoPanel.add(idField);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dbaSlaEnableLabel));
        baseInfoPanel.add(dbaSlaEnableF);
        baseInfoPanel.add(new HSpacer());
        dbaSlaEnableF.addItemListener(e -> dbaSlaEnableChange());

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

        baseInfoPanel.add(new JLabel(mxuMgmtGlbEnableL));
        baseInfoPanel.add(mxuMgmtGlbEnableF);
        baseInfoPanel.add(new HSpacer());
        mxuMgmtGlbEnableF.addItemListener(e -> mxuMgmtGlbEnableChange());

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

    private void mxuMgmtGlbEnableChange() {
        boolean enable = mxuMgmtGlbEnableF.getSelectedIndex() == 0;
        mxuIpAddressF.setEnabled(enable);
        mxuIpMaskF.setEnabled(enable);
        mxuGatewayF.setEnabled(enable);
        mxuCVlanF.setEnabled(enable);
        mxuSVlanF.setEnabled(enable);
        mxuPriorityF.setEnabled(enable);
    }

    private void dbaSlaEnableChange() {
        boolean enable = dbaSlaEnableF.getSelectedIndex() == 0;
        upMaxBwF.setEnabled(enable);
        downMaxBwF.setEnabled(enable);
        upCommittedBwF.setEnabled(enable);
        downCommittedBwF.setEnabled(enable);
        upFixBwF.setEnabled(enable);
        upBurstSizeF.setEnabled(enable);
        downBurstSizeF.setEnabled(enable);
        upPriorityF.setEnabled(enable);
    }

    protected void initForm() {
        idField.setDefaultString("1/1/1");
        upMaxBwF.setValueScope(1, 1000000);
        upMaxBwF.setDefaultValue(100000);
        downMaxBwF.setValueScope(1, 1000000);
        downMaxBwF.setDefaultValue(100000);
        upCommittedBwF.setValueScope(0, 1000000);
        upCommittedBwF.setDefaultValue(0);
        downCommittedBwF.setValueScope(0, 1000000);
        upCommittedBwF.setDefaultValue(0);
        upBurstSizeF.setValueScope(1, 100000);
        upBurstSizeF.setDefaultValue(1000);
        downBurstSizeF.setValueScope(1, 100000);
        downBurstSizeF.setDefaultValue(1000);
        upPriorityF.setValueScope(0, 10);
        upPriorityF.setDefaultValue(0);
        upFixBwF.setValueScope(0, 1000000);
        upFixBwF.setDefaultValue(0);

        mxuCVlanF.setValueScope(0, 4094);
        mxuCVlanF.setValue(0);
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
        } else {
            OnuCfgBean m = (OnuCfgBean) getModel();
            if (m == null) {
                throw new RuntimeException("error");
            }

            idField.setEditable(false);
            idField.setValue(TransformUtils.disableOnuId(m.getId()));
            String dbaSlaEnable = m.getDbaSlaEnable();
            dbaSlaEnableF.setSelectedIndex(getIndexFromValue(dbaSlaEnableVList, Integer.valueOf(dbaSlaEnable == null ? "1" : dbaSlaEnable)));
            setNullableIntField(upMaxBwF, m.getUpMaxBw());
            setNullableIntField(downMaxBwF, m.getDownMaxBw());
            setNullableIntField(upCommittedBwF, m.getUpCommittedBw());
            setNullableIntField(downCommittedBwF, m.getDownCommittedBw());
            setNullableIntField(upFixBwF, m.getUpFixBw());
            setNullableIntField(upBurstSizeF, m.getUpBurstSize());
            setNullableIntField(downBurstSizeF, m.getDownBurstSize());
            setNullableIntField(upPriorityF, m.getUpPriority());

            String mxuMgmtGlbEnable = m.getMxuMgmtGlbEnable();
            mxuMgmtGlbEnableF.setSelectedIndex(getIndexFromValue(mxuMgmtGlbEnableVList, Integer.valueOf(mxuMgmtGlbEnable == null ? "1" : mxuMgmtGlbEnable)));
            mxuIpAddressF.setValue(fromHexIp(m.getMxuIpAddress()));
            mxuIpMaskF.setValue(fromHexIp(m.getMxuIpMask()));
            mxuGatewayF.setValue(fromHexIp(m.getMxuGateway()));
            mxuCVlanF.setValue(fromHexShort(m.getMxuCVlan()));
            mxuSVlanF.setValue(fromHexShort(m.getMxuSVlan()));
            mxuPriorityF.setValue(fromHexByte(m.getMxuPriority()));
        }
        dbaSlaEnableChange();
        mxuMgmtGlbEnableChange();
    }

    public void updateModel() {
        OnuCfgBean model;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            model = new OnuCfgBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(TransformUtils.saveOnuId(idField.getValue()));
            setModel(model);
        } else {
            model = (OnuCfgBean) getModel();
        }
        model.setDbaSlaEnable(String.valueOf(dbaSlaEnableVList[dbaSlaEnableF.getSelectedIndex()]));
        if (dbaSlaEnableF.getSelectedIndex() == 0) {
            model.setUpMaxBw(String.valueOf(upMaxBwF.getValue()));
            model.setDownMaxBw(String.valueOf(downMaxBwF.getValue()));
            model.setUpCommittedBw(String.valueOf(upCommittedBwF.getValue()));
            model.setDownCommittedBw(String.valueOf(downCommittedBwF.getValue()));
            model.setUpFixBw(String.valueOf(upFixBwF.getValue()));
            model.setUpBurstSize(String.valueOf(upBurstSizeF.getValue()));
            model.setDownBurstSize(String.valueOf(downBurstSizeF.getValue()));
            model.setUpPriority(String.valueOf(upPriorityF.getValue()));
        }

        model.setMxuMgmtGlbEnable(String.valueOf(mxuMgmtGlbEnableVList[mxuMgmtGlbEnableF.getSelectedIndex()]));
        if (mxuMgmtGlbEnableF.getSelectedIndex() == 0) {
            model.setMxuIpAddress(toHexIp(mxuIpAddressF.getValue()));
            model.setMxuIpMask(toHexIp(mxuIpMaskF.getValue()));
            model.setMxuGateway(toHexIp(mxuGatewayF.getValue()));
            model.setMxuCVlan(toHexShort(mxuCVlanF.getValue()));
            model.setMxuSVlan(toHexShort(mxuSVlanF.getValue()));
            model.setMxuPriority(toHexByte(mxuPriorityF.getValue()));
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}
