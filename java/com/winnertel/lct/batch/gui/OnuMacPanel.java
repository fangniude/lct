package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.lct.batch.bean.OnuMacBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

public class OnuMacPanel extends UPanel {
    private final String idLabel = fStringMap.getString("onuId") + ": ";
    private final String macLabel = fStringMap.getString("utsDot3ValidOnuMacAddr") + ": ";
    private final String descLabel = fStringMap.getString("utsDot3OnuDescription") + ": ";

    private StringTextField idField = new StringTextField();
    private MacAddressField macField = new MacAddressField();
    private StringTextField descField = new StringTextField();

    public OnuMacPanel(IApplication app) {
        super(app);
        init();
    }


    public void initGui() {
        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(idLabel));
        baseInfoPanel1.add(idField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(macLabel));
        baseInfoPanel1.add(macField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(descLabel));
        baseInfoPanel1.add(descField);
        baseInfoPanel1.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel1, BorderLayout.CENTER);
    }

    protected void initForm() {
        idField.setDefaultString("1/1/1");
    }

    public void refresh() {
        try {
            if (SnmpAction.IType.ADD.equals(fCommand)) {
                idField.setEditable(true);
            } else {
                OnuMacBean mbean = (OnuMacBean) getModel();
                if (mbean == null) {
                    throw new RuntimeException("error");
                }

                idField.setEditable(false);
                idField.setValue(TransformUtils.displayOnuId(mbean.getId()));
                macField.setValue(mbean.getMac());
                descField.setValue(TransformUtils.fromHex(mbean.getDesc()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateModel() {
        OnuMacBean model;
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            model = new OnuMacBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(TransformUtils.saveOnuId(idField.getValue()));
            setModel(model);
        } else {
            model = (OnuMacBean) getModel();
        }
        model.setMac(macField.getMacString());
        model.setDesc(TransformUtils.toHex(descField.getValue()));
    }
}
