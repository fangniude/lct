package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCNU;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The ModEoCCNUPanel class.
 * Created by DVM Creator
 */
public class ModEoCCNUPanel extends UPanel {

    private IntegerTextField tfModEoCCNUAllReset = new IntegerTextField();

    private IntegerTextField tfModEoCCNUCurrentAmount = new IntegerTextField();

    private IntegerTextField tfModEoCCNUAmountLimitation = new IntegerTextField();


    private final String modEoCCNUAllReset = fStringMap.getString("modEoCCNUAllReset") + " : ";
    private final String modEoCCNUCurrentAmount = fStringMap.getString("modEoCCNUCurrentAmount") + " : ";
    private final String modEoCCNUAmountLimitation = fStringMap.getString("modEoCCNUAmountLimitation") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;

    JButton btReset;


    public ModEoCCNUPanel(IApplication app) {
        super(app);
        setModel(new ModEoCCNU(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCCNU");
        btRefresh = new SnmpRefreshButton(fApplication, this);

        btReset = new JButton(fStringMap.getString("ResetAll"));
        BaseAction resetAction = new BaseAction(fApplication) {
            @Override
            public void executeAction(ActionEvent e) throws Exception {
                // TODO Auto-generated method stub
                try {
                    if (MessageDialog.showConfirmOperationDialog(fApplication)) {
                        fApplication.getTaskManager().executeTask(new Task() {

                            public Object execute() throws Exception {
                                ModEoCCNU resetBean = (ModEoCCNU) getModel();
                                resetBean.reset();
                                return null;
                            }
                        });
                    }
                } catch (Exception e1) {
                    MessageDialog.showOperationFailedDialog(fApplication);
                    e1.printStackTrace();
                }

            }

        };
        resetAction.putValue(BaseAction.ID, "Reset_ModEoCCNU");
        btReset.addActionListener(resetAction);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btReset);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        /*
        baseInfoPanel.add(new JLabel(modEoCCNUAllReset));
        tfModEoCCNUAllReset.setName(fStringMap.getString("modEoCCNUAllReset"));
        baseInfoPanel.add(tfModEoCCNUAllReset);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(modEoCCNUCurrentAmount));
        baseInfoPanel.add(tfModEoCCNUCurrentAmount);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCCNUAmountLimitation));
        tfModEoCCNUAmountLimitation.setName(fStringMap.getString("modEoCCNUAmountLimitation"));
        baseInfoPanel.add(tfModEoCCNUAmountLimitation);
        baseInfoPanel.add(new HSpacer());


        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);

        add(buttonsPanel, BorderLayout.SOUTH);


    }

    protected void initForm() {

        tfModEoCCNUAllReset.setEditable(false);
        tfModEoCCNUCurrentAmount.setEditable(false);
    }

    public void refresh() {

        ModEoCCNU mbean = (ModEoCCNU) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfModEoCCNUAllReset.setValue(mbean.getModEoCCNUAllReset().intValue());
        tfModEoCCNUCurrentAmount.setText(mbean.getModEoCCNUCurrentAmount().toString());
        tfModEoCCNUAmountLimitation.setValue(mbean.getModEoCCNUAmountLimitation().intValue());

    }

    public void updateModel() {

        ModEoCCNU mbean = (ModEoCCNU) getModel();

        mbean.setModEoCCNUAllReset(new Integer(tfModEoCCNUAllReset.getValue()));

        mbean.setModEoCCNUAmountLimitation(new Integer(tfModEoCCNUAmountLimitation.getValue()));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}