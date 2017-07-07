package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.OntTreePanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUpgradeTandRTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.platform.client.swing.calendar.CalendarPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Modified by Zhou Chao, 2008/12/17
public class OnuUpgradeTandRTablePanel extends UPanel {

    private LongTextField tfOnuUpgradeTaskandResultIndex = new LongTextField();

    private JComboBox tfOnuUpgradeTaskandResultOnuUpgradeTarget = new JComboBox();

    private int[] onuUpgradeTaskandResultOnuUpgradeMethodVList = new int[]{3, 1, 2,};
    private String[] onuUpgradeTaskandResultOnuUpgradeMethodTList = new String[]{
            fStringMap.getString("automatic"),
            fStringMap.getString("manual"),
            fStringMap.getString("scheduled"),
    };
    private JComboBox tfOnuUpgradeTaskandResultOnuUpgradeMethod = new JComboBox(onuUpgradeTaskandResultOnuUpgradeMethodTList);

    private int[] onuUpgradeTaskandResultOnuUpgradeOptionVList = new int[]{1, 2,};
    private String[] onuUpgradeTaskandResultOnuUpgradeOptionTList = new String[]{
            fStringMap.getString("normal"),
            fStringMap.getString("forced"),
    };
    private JComboBox tfOnuUpgradeTaskandResultOnuUpgradeOption = new JComboBox(onuUpgradeTaskandResultOnuUpgradeOptionTList);

    /*
    private int[] onuUpgradeTaskStatusVList = new int[]{1, 2,};
    private String[] onuUpgradeTaskStatusTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfOnuUpgradeTaskStatus = new JComboBox(onuUpgradeTaskStatusTList);
    */
    private int[] onuUpgradeImageInstanceVList = new int[]{1};
    private String[] onuUpgradeImageInstanceTList = new String[]{
            fStringMap.getString("onu_upgrade_instance_automatic"),
    };
    private JComboBox tfOnuUpgradeImageInstance = new JComboBox(onuUpgradeImageInstanceTList);

    private int[] onuUpgradeRebootModeVList = new int[]{1, 2, 3};
    private String[] onuUpgradeRebootModeTList = new String[]{
            fStringMap.getString("automatic"),
            fStringMap.getString("manual"),
            fStringMap.getString("scheduled"),
    };
    private JComboBox tfOnuUpgradeRebootMode = new JComboBox(onuUpgradeRebootModeTList);

//    private JbcDateTimeChooser tfOnuUpgradeScheduledTime = new JbcDateTimeChooser();
//    private JbcDateTimeChooser tfOnuUpgradeRebooScheduledTime = new JbcDateTimeChooser();

    private CalendarPicker tfOnuUpgradeScheduledTime = new CalendarPicker(true);
    private CalendarPicker tfOnuUpgradeRebooScheduledTime = new CalendarPicker(true);

    private final String onuUpgradeTaskandResultIndex = fStringMap.getString("onuUpgradeTaskandResultIndex") + ": ";
    private final String onuUpgradeTaskandResultOnuUpgradeTarget = fStringMap.getString("onuUpgradeTaskandResultOnuUpgradeTarget") + ": ";
    private final String onuUpgradeTaskandResultOnuUpgradeMethod = fStringMap.getString("onuUpgradeTaskandResultOnuUpgradeMethod") + ": ";
    private final String onuUpgradeTaskandResultOnuUpgradeOption = fStringMap.getString("onuUpgradeTaskandResultOnuUpgradeOption") + ": ";
    //private final String onuUpgradeTaskStatus = fStringMap.getString("onuUpgradeTaskStatus") + ": ";
    private final String onuUpgradeImageInstance = fStringMap.getString("onuUpgradeImageInstance") + ": ";
    private final String onuUpgradeRebootMode = fStringMap.getString("onuUpgradeRebootMode") + ": ";
    private final String onuUpgradeScheduledTime = fStringMap.getString("onuUpgradeScheduledTime") + ": ";
    private final String onuUpgradeRebooScheduledTime = fStringMap.getString("onuUpgradeRebooScheduledTime") + ": ";
    private final String onuUpgradeParticipantPortListBitMap = fStringMap.getString("onuUpgradeParticipantPortListBitMap") + ": ";

    private OntTreePanel trONTListTree = null;

    public OnuUpgradeTandRTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        //baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuUpgradeTaskandResultIndex));
        baseInfoPanel.add(tfOnuUpgradeTaskandResultIndex);
        baseInfoPanel.add(new HSpacer());

        tfOnuUpgradeTaskandResultOnuUpgradeTarget.addItem(fStringMap.getString("ONT"));
        for (int i = 1; i <= 253; i++) {
            tfOnuUpgradeTaskandResultOnuUpgradeTarget.addItem(fStringMap.getString("Circuit") + " " + i);
        }
        tfOnuUpgradeTaskandResultOnuUpgradeTarget.addItem(fStringMap.getString("MPU"));
        baseInfoPanel.add(new JLabel(onuUpgradeTaskandResultOnuUpgradeTarget));
        baseInfoPanel.add(tfOnuUpgradeTaskandResultOnuUpgradeTarget);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeTaskandResultOnuUpgradeMethod));
        baseInfoPanel.add(tfOnuUpgradeTaskandResultOnuUpgradeMethod);
        baseInfoPanel.add(new HSpacer());

//        tfOnuUpgradeScheduledTime.setChooserType(JbcDateTimeChooser.CHOOSER_TIME);
//        tfOnuUpgradeScheduledTime.setClockWithAmPm(false);
//        tfOnuUpgradeScheduledTime.setStylePattern(2);
        tfOnuUpgradeScheduledTime.setPreferredSize(new Dimension(100, 24));
        baseInfoPanel.add(new JLabel(onuUpgradeScheduledTime));
        tfOnuUpgradeScheduledTime.setName(fStringMap.getString("onuUpgradeScheduledTime"));
        baseInfoPanel.add(tfOnuUpgradeScheduledTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeTaskandResultOnuUpgradeOption));
        tfOnuUpgradeTaskandResultOnuUpgradeOption.setName(fStringMap.getString("onuUpgradeTaskandResultOnuUpgradeOption"));
        baseInfoPanel.add(tfOnuUpgradeTaskandResultOnuUpgradeOption);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuUpgradeTaskStatus));
        //baseInfoPanel.add(tfOnuUpgradeTaskStatus);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeImageInstance));
        tfOnuUpgradeImageInstance.setName(fStringMap.getString("onuUpgradeImageInstance"));
        baseInfoPanel.add(tfOnuUpgradeImageInstance);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeRebootMode));
        tfOnuUpgradeRebootMode.setName(fStringMap.getString("onuUpgradeRebootMode"));
        baseInfoPanel.add(tfOnuUpgradeRebootMode);
        baseInfoPanel.add(new HSpacer());

//        tfOnuUpgradeRebooScheduledTime.setChooserType(JbcDateTimeChooser.CHOOSER_TIME);
//        tfOnuUpgradeRebooScheduledTime.setClockWithAmPm(false);
//        tfOnuUpgradeRebooScheduledTime.setStylePattern(2);
        tfOnuUpgradeRebooScheduledTime.setPreferredSize(new Dimension(100, 24));
        baseInfoPanel.add(new JLabel(onuUpgradeRebooScheduledTime));
        tfOnuUpgradeRebooScheduledTime.setName(fStringMap.getString("onuUpgradeRebooScheduledTime"));
        baseInfoPanel.add(tfOnuUpgradeRebooScheduledTime);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(onuUpgradeParticipantPortListBitMap));
        tfOnuUpgradeParticipantPortListBitMap.setName(fStringMap.getString("onuUpgradeParticipantPortListBitMap"));
        baseInfoPanel.add(tfOnuUpgradeParticipantPortListBitMap);
        baseInfoPanel.add(new HSpacer());
        */

        /*
        baseInfoPanel.add(new JLabel(onuUpgradeImageInstancePortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeImageInstancePortListBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeProgressDownloadPortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeProgressDownloadPortListBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeProgressActivatePortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeProgressActivatePortListBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeProgressCommitPortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeProgressCommitPortListBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeProgressFinalPortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeProgressFinalPortListBitMap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeResultPortListBitMap));
        baseInfoPanel.add(tfOnuUpgradeResultPortListBitMap);
        baseInfoPanel.add(new HSpacer());
        */

        JPanel ontInfoPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        ontInfoPanel.setLayout(layout);
        //ontInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        ontInfoPanel.add(new JLabel(onuUpgradeParticipantPortListBitMap));
        trONTListTree = new OntTreePanel(fApplication);
        ontInfoPanel.add(trONTListTree);

        JPanel infoPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        infoPanel.setLayout(layout);
        infoPanel.setBorder(BorderFactory.createEtchedBorder());
        infoPanel.add(baseInfoPanel);
        infoPanel.add(ontInfoPanel);

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(infoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfOnuUpgradeTaskandResultIndex.setValueScope(1, 65535);
        //tfOnuUpgradeScheduledTime.setLenScope(0, 255);
        //tfOnuUpgradeRebooScheduledTime.setLenScope(0, 255);
        //tfOnuUpgradeParticipantPortListBitMap.setLenScope(0, 512);

        tfOnuUpgradeScheduledTime.setEnabled(false);
        tfOnuUpgradeTaskandResultOnuUpgradeMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfOnuUpgradeScheduledTime.setEnabled(onuUpgradeTaskandResultOnuUpgradeMethodVList[tfOnuUpgradeTaskandResultOnuUpgradeMethod.getSelectedIndex()] == 2);
            }
        });

        tfOnuUpgradeRebooScheduledTime.setEnabled(false);
        tfOnuUpgradeRebootMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfOnuUpgradeRebooScheduledTime.setEnabled(onuUpgradeRebootModeVList[tfOnuUpgradeRebootMode.getSelectedIndex()] == 3);
            }
        });
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuUpgradeTaskandResultIndex.setEnabled(true);
            tfOnuUpgradeTaskandResultOnuUpgradeTarget.setEnabled(true);
            tfOnuUpgradeTaskandResultOnuUpgradeMethod.setEnabled(true);
            return;
        } else {
            tfOnuUpgradeTaskandResultIndex.setEnabled(false);
            tfOnuUpgradeTaskandResultOnuUpgradeTarget.setEnabled(false);
            tfOnuUpgradeTaskandResultOnuUpgradeMethod.setEnabled(false);
        }

        OnuUpgradeTandRTable mbean = (OnuUpgradeTandRTable) getModel();
        if (mbean == null)
            return;

        tfOnuUpgradeTaskandResultIndex.setText(mbean.getOnuUpgradeTaskandResultIndex().toString());
        tfOnuUpgradeTaskandResultOnuUpgradeTarget.setSelectedIndex(mbean.getOnuUpgradeTaskandResultOnuUpgradeTarget() - 1);
        tfOnuUpgradeTaskandResultOnuUpgradeMethod.setSelectedIndex(getIndexFromValue(onuUpgradeTaskandResultOnuUpgradeMethodVList, mbean.getOnuUpgradeTaskandResultOnuUpgradeMethod()));

        tfOnuUpgradeTaskandResultOnuUpgradeOption.setEnabled(mbean.getOnuUpgradeTaskandResultOnuUpgradeOption() != null);
        tfOnuUpgradeTaskandResultOnuUpgradeOption.setSelectedIndex(getIndexFromValue(onuUpgradeTaskandResultOnuUpgradeOptionVList, mbean.getOnuUpgradeTaskandResultOnuUpgradeOption()));

        //tfOnuUpgradeTaskStatus.setSelectedIndex(getIndexFromValue(onuUpgradeTaskStatusVList, mbean.getOnuUpgradeTaskStatus()));

        tfOnuUpgradeImageInstance.setEnabled(mbean.getOnuUpgradeImageInstance() != null);
        tfOnuUpgradeImageInstance.setSelectedIndex(getIndexFromValue(onuUpgradeImageInstanceVList, mbean.getOnuUpgradeImageInstance()));

        tfOnuUpgradeRebootMode.setEnabled(mbean.getOnuUpgradeRebootMode() != null);
        tfOnuUpgradeRebootMode.setSelectedIndex(getIndexFromValue(onuUpgradeRebootModeVList, mbean.getOnuUpgradeRebootMode()));

        //tfOnuUpgradeScheduledTime.setValue(new String(mbean.getOnuUpgradeScheduledTime()));
        //tfOnuUpgradeRebooScheduledTime.setValue(new String(mbean.getOnuUpgradeRebooScheduledTime()));

        //tfOnuUpgradeScheduledTime.setEnabled(mbean.getOnuUpgradeScheduledTime() != null);
        tfOnuUpgradeScheduledTime.setDate(parseStringToTime(mbean.getOnuUpgradeScheduledTime()));

        //tfOnuUpgradeRebooScheduledTime.setEnabled(mbean.getOnuUpgradeRebooScheduledTime() != null);
        tfOnuUpgradeRebooScheduledTime.setDate(parseStringToTime(mbean.getOnuUpgradeRebooScheduledTime()));

        /*
        tfOnuUpgradeImageInstancePortListBitMap.setText(mbean.getOnuUpgradeImageInstancePortListBitMap());
        tfOnuUpgradeProgressDownloadPortListBitMap.setText(mbean.getOnuUpgradeProgressDownloadPortListBitMap());
        tfOnuUpgradeProgressActivatePortListBitMap.setText(mbean.getOnuUpgradeProgressActivatePortListBitMap());
        tfOnuUpgradeProgressCommitPortListBitMap.setText(mbean.getOnuUpgradeProgressCommitPortListBitMap());
        tfOnuUpgradeProgressFinalPortListBitMap.setText(mbean.getOnuUpgradeProgressFinalPortListBitMap());
        tfOnuUpgradeResultPortListBitMap.setText(mbean.getOnuUpgradeResultPortListBitMap());
        tfOnuUpgradeTaskandResultRowStatus.setSelectedIndex(getIndexFromValue(onuUpgradeTaskandResultRowStatusVList, mbean.getOnuUpgradeTaskandResultRowStatus()));
        */
    }

    public boolean validateFrom() { //added by Zhou Chao, 2009/2/11
        byte[] bitmap = trONTListTree.getSelectedOnuBitMap();
        if (bitmap == null) {
            MessageDialog.showInfoMessageDialog(fApplication, fStringMap.getString("Please select the ONT!"));
            return false;
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuUpgradeTandRTable(fApplication.getSnmpProxy()));

        OnuUpgradeTandRTable mbean = (OnuUpgradeTandRTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOnuUpgradeTaskandResultIndex(tfOnuUpgradeTaskandResultIndex.getValue());
            mbean.setOnuUpgradeTaskandResultOnuUpgradeMethod(onuUpgradeTaskandResultOnuUpgradeMethodVList[tfOnuUpgradeTaskandResultOnuUpgradeMethod.getSelectedIndex()]);
            mbean.setOnuUpgradeTaskandResultOnuUpgradeTarget(tfOnuUpgradeTaskandResultOnuUpgradeTarget.getSelectedIndex() + 1);
        }

        if (tfOnuUpgradeTaskandResultOnuUpgradeOption.isEnabled())
            mbean.setOnuUpgradeTaskandResultOnuUpgradeOption(onuUpgradeTaskandResultOnuUpgradeOptionVList[tfOnuUpgradeTaskandResultOnuUpgradeOption.getSelectedIndex()]);

        if (tfOnuUpgradeImageInstance.isEnabled())
            mbean.setOnuUpgradeImageInstance(onuUpgradeImageInstanceVList[tfOnuUpgradeImageInstance.getSelectedIndex()]);

        if (tfOnuUpgradeRebootMode.isEnabled())
            mbean.setOnuUpgradeRebootMode(onuUpgradeRebootModeVList[tfOnuUpgradeRebootMode.getSelectedIndex()]);

        if (tfOnuUpgradeScheduledTime.isEnabled())
            mbean.setOnuUpgradeScheduledTime(parseTimeToString(tfOnuUpgradeScheduledTime.getDate()));

        if (tfOnuUpgradeRebooScheduledTime.isEnabled())
            mbean.setOnuUpgradeRebooScheduledTime(parseTimeToString(tfOnuUpgradeRebooScheduledTime.getDate()));

        //if (trONTListTree.isEnabled())
        mbean.setOnuUpgradeParticipantPortListBitMap(trONTListTree.getSelectedOnuBitMap());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public Date parseStringToTime(String time) {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");

        Date result = null;
        try {
            result = formatter.parse(time);
        } catch (ParseException e) {
            result = new Date();
        }

        return result;
    }

    public String parseTimeToString(Date time) {
        Format formatter = new SimpleDateFormat("hh:mm:ss");

        return formatter.format(time);
    }

}