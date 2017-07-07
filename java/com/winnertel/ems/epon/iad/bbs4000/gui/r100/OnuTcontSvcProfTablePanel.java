package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuTcontSvcProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuTcontSvcProfTablePanel extends UPanel {

    private IndexAutoGenField tfOnuTcontServiceProfileIndex = new IndexAutoGenField(fApplication, 1);

    private StringTextField tfOnuTcontSvcProfileName = new StringTextField();

    private ProfileChooser tfUpstreamBandwidthProfileIndex = new ProfileChooser(fApplication);

    private int[] upstreamQueuingSchedulingTypesVList = new int[]{1, 2, 3,};
    private String[] upstreamQueuingSchedulingTypesTList = new String[]{
            fStringMap.getString("priority-controlled"),
            fStringMap.getString("rate-controlled"),
            fStringMap.getString("priority-and-rate-controlled"),
    };
    private JComboBox tfUpstreamQueuingSchedulingType = new JComboBox(upstreamQueuingSchedulingTypesTList);

    private long[] dbruModeVList = new long[]{1, 2,};
    private String[] dbruModeTList = new String[]{
            fStringMap.getString("NSR"),
            fStringMap.getString("SR_mode0"),
    };
    private JComboBox tfDbruMode = new JComboBox(dbruModeTList);

    private final String onuTcontServiceProfileIndex = fStringMap.getString("onuTcontServiceProfileIndex") + ": ";
    private final String onuTcontSvcProfileName = fStringMap.getString("onuTcontSvcProfileName") + ": ";
    private final String upstreamBandwidthProfileIndex = fStringMap.getString("upstreamBandwidthProfileIndex") + ": ";
    private final String upstreamQueuingSchedulingType = fStringMap.getString("upstreamQueuingSchedulingType") + ": ";
    private final String dbruMode = fStringMap.getString("dbruMode") + ": ";

    public OnuTcontSvcProfTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuTcontServiceProfileIndex));
        baseInfoPanel.add(tfOnuTcontServiceProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuTcontSvcProfileName));
        tfOnuTcontSvcProfileName.setName(fStringMap.getString("onuTcontSvcProfileName"));
        tfOnuTcontSvcProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuTcontSvcProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upstreamBandwidthProfileIndex));
        tfUpstreamBandwidthProfileIndex.setName(fStringMap.getString("upstreamBandwidthProfileIndex"));
        tfUpstreamBandwidthProfileIndex.setProfile("OnuBwProfTable_Panel");
        baseInfoPanel.add(tfUpstreamBandwidthProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(upstreamQueuingSchedulingType));
        tfUpstreamQueuingSchedulingType.setName(fStringMap.getString("upstreamQueuingSchedulingType"));
        baseInfoPanel.add(tfUpstreamQueuingSchedulingType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(dbruMode));
        tfDbruMode.setName(fStringMap.getString("dbruMode"));
        baseInfoPanel.add(tfDbruMode);
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
        tfOnuTcontServiceProfileIndex.setValueScope(0, 2, 128);
    }

    public void refresh() {
        tfUpstreamBandwidthProfileIndex.refresh();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuTcontServiceProfileIndex.setTable(fTable);
            tfOnuTcontServiceProfileIndex.setEnabled(true);
            tfOnuTcontServiceProfileIndex.refresh();
            tfUpstreamBandwidthProfileIndex.setSelectedProfileIndex(1);
            return;
        } else {
            tfOnuTcontServiceProfileIndex.setEnabled(false);
        }

        OnuTcontSvcProfTable mbean = (OnuTcontSvcProfTable) getModel();
        if (mbean == null)
            return;

        tfOnuTcontServiceProfileIndex.setValue(0, mbean.getOnuTcontServiceProfileIndex());

        tfOnuTcontSvcProfileName.setValue(mbean.getOnuTcontSvcProfileName());

        tfUpstreamQueuingSchedulingType.setSelectedIndex(getIndexFromValue(upstreamQueuingSchedulingTypesVList, mbean.getUpstreamQueuingSchedulingType()));

        tfUpstreamBandwidthProfileIndex.setSelectedProfileIndex(mbean.getUpstreamBandwidthProfileIndex());

        tfDbruMode.setSelectedIndex(getIndexFromValue(dbruModeVList, mbean.getDbruMode()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuTcontSvcProfTable(fApplication.getSnmpProxy()));

        OnuTcontSvcProfTable mbean = (OnuTcontSvcProfTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuTcontServiceProfileIndex(tfOnuTcontServiceProfileIndex.getValue(0));
        }

        mbean.setOnuTcontSvcProfileName(tfOnuTcontSvcProfileName.getValue());

        mbean.setUpstreamBandwidthProfileIndex(tfUpstreamBandwidthProfileIndex.getSelectedProfileIndex() >= 0 ? tfUpstreamBandwidthProfileIndex.getSelectedProfileIndex() : 1);

        mbean.setUpstreamQueuingSchedulingType(upstreamQueuingSchedulingTypesVList[tfUpstreamQueuingSchedulingType.getSelectedIndex()]);

        mbean.setDbruMode(dbruModeVList[tfDbruMode.getSelectedIndex()]);
    }

    public void afterUpdateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            tfOnuTcontServiceProfileIndex.increaseIndexValue();
    }

    public boolean validateFrom() {
        return true;
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getIndexFromValue(long[] list, long v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}