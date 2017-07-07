package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponP2pServiceVlanCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class GponP2pServiceVlanCfgTablePanel extends UPanel {
    private IntegerTextField tfP2pServiceVlan = new IntegerTextField();

    private final String p2pServiceVlan = fStringMap.getString("p2pServiceVlan") + " : ";

    public GponP2pServiceVlanCfgTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(p2pServiceVlan));
        tfP2pServiceVlan.setName(fStringMap.getString("p2pServiceVlan"));
        baseInfoPanel.add(tfP2pServiceVlan);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfP2pServiceVlan.setValueScope(1, 4094);
    }

    public boolean validateFrom() {
        SnmpTableModel model = (SnmpTableModel)fTable.getModel();
        for(int i = 0; i < fTable.getRowCount(); i++) {
            GponP2pServiceVlanCfgTable row = (GponP2pServiceVlanCfgTable)model.getRow(i);

            if(tfP2pServiceVlan.getValue() == row.getP2pServiceVlan()) {
                String error = fStringMap.getString("Err_P2P_VLAN_EXIST");
                MessageDialog.showInfoMessageDialog(fApplication, error);
                return false;
            }
        }
        return true;
    }


    public void refresh() {
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            GponP2pServiceVlanCfgTable mbean = new GponP2pServiceVlanCfgTable(fApplication.getSnmpProxy());

            mbean.setP2pServiceVlan(tfP2pServiceVlan.getValue());
            setModel(mbean);
        }
    }

}
