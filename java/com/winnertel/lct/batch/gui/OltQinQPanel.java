package com.winnertel.lct.batch.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.lct.batch.bean.OltQinQBean;
import com.winnertel.lct.batch.proxy.XmlProxy;

import javax.swing.*;
import java.awt.*;

import static com.winnertel.lct.batch.gui.TransformUtils.setNullableIntField;

public class OltQinQPanel extends UPanel {
    private final String idLabel = fStringMap.getString("qinqPonId") + ": ";
    private final String indexLabel = fStringMap.getString("index") + ": ";
    private final String startVlanLabel = fStringMap.getString("startVlan") + ": ";
    private final String endVlanLabel = fStringMap.getString("endVlan") + ": ";
    private final String etherTypeLabel = fStringMap.getString("etherType") + ": ";
    private final String newVlanLabel = fStringMap.getString("newVlan") + ": ";

    private JComboBox idField = new JComboBox(new Object[]{1, 2, 3, 4});
    private JComboBox indexField = new JComboBox(new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    private IntegerTextField startVlanField = new IntegerTextField();
    private IntegerTextField endVlanField = new IntegerTextField();
    private StringTextField etherTypeField = new StringTextField();
    private IntegerTextField newVlanField = new IntegerTextField();

    public OltQinQPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel1 = new JPanel();
        NTLayout layout1 = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseInfoPanel1.setLayout(layout1);
        baseInfoPanel1.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel1.add(new JLabel(idLabel));
        baseInfoPanel1.add(idField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(indexLabel));
        baseInfoPanel1.add(indexField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(startVlanLabel));
        baseInfoPanel1.add(startVlanField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(endVlanLabel));
        baseInfoPanel1.add(endVlanField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(etherTypeLabel));
        baseInfoPanel1.add(etherTypeField);
        baseInfoPanel1.add(new HSpacer());

        baseInfoPanel1.add(new JLabel(newVlanLabel));
        baseInfoPanel1.add(newVlanField);
        baseInfoPanel1.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel1, BorderLayout.CENTER);
    }

    protected void initForm() {
        startVlanField.setValueScope(2, 4094);
        endVlanField.setValueScope(0, 4094);
        newVlanField.setValueScope(2, 4094);

        startVlanField.setDefaultValue(2);
        endVlanField.setDefaultValue(0);
        etherTypeField.setDefaultString("0x0");
    }

    public void refresh() {
        try {
            if (SnmpAction.IType.ADD.equals(fCommand)) {
                idField.setEditable(true);
            } else {
                OltQinQBean mbean = (OltQinQBean) getModel();
                if (mbean == null) {
                    throw new RuntimeException("error");
                }

                idField.setEnabled(false);
                indexField.setEnabled(false);
                setNullableIntField(startVlanField, mbean.getStartVlan());
                setNullableIntField(endVlanField, mbean.getEndVlan());
                setNullableIntField(newVlanField, mbean.getNewVlan());
                etherTypeField.setValue(mbean.getEtherType());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            OltQinQBean model = new OltQinQBean(new XmlProxy(fApplication.getSnmpProxy().getTargetHost()));
            model.setId(String.valueOf(idField.getSelectedItem()));
            model.setIndex(String.valueOf(indexField.getSelectedItem()));
            model.setStartVlan(String.valueOf(startVlanField.getValue()));
            model.setEndVlan(String.valueOf(endVlanField.getValue()));
            model.setNewVlan(String.valueOf(newVlanField.getValue()));
            model.setEtherType(etherTypeField.getValue());
            setModel(model);
        } else {
            OltQinQBean model = (OltQinQBean) getModel();
            model.setStartVlan(String.valueOf(startVlanField.getValue()));
            model.setEndVlan(String.valueOf(endVlanField.getValue()));
            model.setNewVlan(String.valueOf(newVlanField.getValue()));
            model.setEtherType(etherTypeField.getValue());
        }
    }
}
