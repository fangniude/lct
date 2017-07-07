package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.AlarmAcuConfigGroup;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.winnertel.em.framework.gui.util.MessageDialog.showOperationFailedDialog;

public class AlarmAcuConfigPanel extends UPanel {

    private int[] vList = new int[]{1, 2,};
    private String[] tList = new String[]{
            fStringMap.getString("enabled"),
            fStringMap.getString("disabled"),
    };

    private JComboBox tfAlarmAcuAudioControl = new JComboBox(tList);

    private JCheckBox criticalLed = new JCheckBox(fStringMap.getString("Critical"));
    private JCheckBox majorLed = new JCheckBox(fStringMap.getString("Major"));
    private JCheckBox minorLed = new JCheckBox(fStringMap.getString("Minor"));

    private final String utsBbsAlarmAcuLedControl = fStringMap.getString("utsBbsAlarmAcuLedControl") + ": ";
    private final String utsBbsAlarmAcuAudioControl = fStringMap.getString("utsBbsAlarmAcuAudioControl") + ": ";

    public AlarmAcuConfigPanel(IApplication app) {
        super(app);
        setModel(new AlarmAcuConfigGroup(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        SnmpApplyButton btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_AlarmAcuControl");
        SnmpRefreshButton btRefresh = new SnmpRefreshButton(fApplication, this);

        JButton btMute = new JButton(fStringMap.getString("Mute"));
        btMute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(MessageDialog.showConfirmOperationDialog(fApplication)) {
                        fApplication.getTaskManager().executeTask(new Task() {

                            public Object execute() throws Exception {
                                AlarmAcuConfigGroup group = (AlarmAcuConfigGroup)getModel();
                                group.mute();
                                return null;
                            }
                        });
                    }
                } catch (Exception e1) {
                    showOperationFailedDialog(fApplication);
                    e1.printStackTrace();
                }
            }
        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btMute);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel ledPanel = new JPanel();
        layout = new NTLayout(2, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(0, 10, 6, 10);
        ledPanel.setLayout(layout);

        ledPanel.add(criticalLed);
        ledPanel.add(majorLed);
        ledPanel.add(minorLed);
        ledPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAlarmAcuLedControl));
        baseInfoPanel.add(ledPanel);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsBbsAlarmAcuAudioControl));
        tfAlarmAcuAudioControl.setName(fStringMap.getString("utsBbsAlarmAcuAudioControl"));
        baseInfoPanel.add(tfAlarmAcuAudioControl);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Annunciator_Setting")));
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

    public void refresh() { //modified by Zhou Chao, 2009/6/19
        AlarmAcuConfigGroup mbean = (AlarmAcuConfigGroup) getModel();

        BeanService.refreshBean(fApplication, mbean);

        setUtsBbsAlarmAcuLedControl(mbean.getUtsBbsAlarmAcuLedControl());

        if (mbean.getUtsBbsAlarmAcuAudioControl() != null)
            tfAlarmAcuAudioControl.setSelectedIndex(getIndexFromValue(vList, mbean.getUtsBbsAlarmAcuAudioControl()));
    }

    public void updateModel() {
        AlarmAcuConfigGroup mbean = (AlarmAcuConfigGroup) getModel();

        mbean.setutsBbsAlarmAcuLedControl(getUtsBbsAlarmAcuLedControl());
        mbean.setUtsBbsAlarmAcuAudioControl(vList[tfAlarmAcuAudioControl.getSelectedIndex()]);
    }

    byte[] getUtsBbsAlarmAcuLedControl() {
        byte[] b = new byte[1];

        if (criticalLed.isSelected())
            b[0] += 0x80;

        if (majorLed.isSelected())
            b[0] += 0x40;

        if (minorLed.isSelected())
            b[0] += 0x20;

        return b;
    }

    void setUtsBbsAlarmAcuLedControl(byte[] b) {
        if (b == null)
            return;

        criticalLed.setSelected((b[0] & 0x80) != 0);

        majorLed.setSelected((b[0] & 0x40) != 0);

        minorLed.setSelected((b[0] & 0x20) != 0);
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}