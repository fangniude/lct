/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltPonLinkCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OltPonLinkCfgTablePanel extends UPanel {

    private JLabel tfOltPonLinkCfgSlotNo = new JLabel();
    private JLabel tfOltPonLinkCfgPortNo = new JLabel();

    private int[] oltPonLinkCfgAdministrativeStateVList = new int[]{1, 2,};
    private String[] oltPonLinkCfgAdministrativeStateTList = new String[]{
            fStringMap.getString("unlock"),
            fStringMap.getString("lock"),
    };
    private JComboBox tfOltPonLinkCfgAdministrativeState = new JComboBox(oltPonLinkCfgAdministrativeStateTList);

    //private int[] oltPonLinkCfgOperationalStateVList = new int[]{2, 1, 3,};
    //private String[] oltPonLinkCfgOperationalStateTList = new String[]{
    //        fStringMap.getString("disabled"),
    //        fStringMap.getString("enabled"),
    //        fStringMap.getString("unknown"),
    //};
    ////private JComboBox tfOltPonLinkCfgOperationalState = new JComboBox(oltPonLinkCfgOperationalStateTList);
    //private JLabel tfOltPonLinkCfgOperationalState = new JLabel();

    private ProfileChooser tfOltPonLinkCfgProtocolProfileIndex = new ProfileChooser(fApplication);

    private int[] oltPonLinkCfgOnuDiscoveryModeVList = new int[]{3, 1, 2,};
    private String[] oltPonLinkCfgOnuDiscoveryModeTList = new String[]{
            fStringMap.getString("disabled"),
            fStringMap.getString("autoPeriodic"),
            fStringMap.getString("manualEnabledOnceThenDisabled"),
    };
    private JComboBox tfOltPonLinkCfgOnuDiscoveryMode = new JComboBox(oltPonLinkCfgOnuDiscoveryModeTList);

    private LongTextField tfOltPonLinkCfgOnuDiscoveryInterval = new LongTextField();
    private LongTextField tfOltPonLinkCfgCycleTime = new LongTextField();

    private final String oltPonLinkCfgSlotNo = fStringMap.getString("oltPonLinkCfgSlotNo") + ": ";
    private final String oltPonLinkCfgPortNo = fStringMap.getString("oltPonLinkCfgPortNo") + ": ";
    private final String oltPonLinkCfgAdministrativeState = fStringMap.getString("oltPonLinkCfgAdministrativeState") + ": ";
    //private final String oltPonLinkCfgOperationalState = fStringMap.getString("oltPonLinkCfgOperationalState") + ": ";
    private final String oltPonLinkCfgProtocolProfileName = fStringMap.getString("oltPonLinkCfgProtocolProfileName") + ": ";
    private final String oltPonLinkCfgOnuDiscoveryMode = fStringMap.getString("oltPonLinkCfgOnuDiscoveryMode") + ": ";
    private final String oltPonLinkCfgOnuDiscoveryInterval = fStringMap.getString("oltPonLinkCfgOnuDiscoveryInterval") + ": ";
    private final String oltPonLinkCfgCycleTime = fStringMap.getString("oltPonLinkCfgCycleTime") + ": ";

    public OltPonLinkCfgTablePanel(IApplication app) {
        super(app);
        setModel(new OltPonLinkCfgTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        /*
        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_OltPonLinkCfgTable");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);
        */

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgSlotNo));
        baseInfoPanel.add(tfOltPonLinkCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgPortNo));
        baseInfoPanel.add(tfOltPonLinkCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgAdministrativeState));
        tfOltPonLinkCfgAdministrativeState.setName(fStringMap.getString("oltPonLinkCfgAdministrativeState"));
        baseInfoPanel.add(tfOltPonLinkCfgAdministrativeState);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(oltPonLinkCfgOperationalState));
        //baseInfoPanel.add(tfOltPonLinkCfgOperationalState);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgProtocolProfileName));
        tfOltPonLinkCfgProtocolProfileIndex.setName(fStringMap.getString("oltPonLinkCfgProtocolProfileName"));
        tfOltPonLinkCfgProtocolProfileIndex.setProfile("OltGponProtocolProfTable_Panel");
        baseInfoPanel.add(tfOltPonLinkCfgProtocolProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgOnuDiscoveryMode));
        tfOltPonLinkCfgOnuDiscoveryMode.setName(fStringMap.getString("oltPonLinkCfgOnuDiscoveryMode"));
        baseInfoPanel.add(tfOltPonLinkCfgOnuDiscoveryMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgOnuDiscoveryInterval));
        tfOltPonLinkCfgOnuDiscoveryInterval.setName(fStringMap.getString("oltPonLinkCfgOnuDiscoveryInterval"));
        baseInfoPanel.add(tfOltPonLinkCfgOnuDiscoveryInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltPonLinkCfgCycleTime));
        tfOltPonLinkCfgCycleTime.setName(fStringMap.getString("oltPonLinkCfgCycleTime"));
        baseInfoPanel.add(tfOltPonLinkCfgCycleTime);
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
        tfOltPonLinkCfgOnuDiscoveryInterval.setValueScope(1, 3600);
        tfOltPonLinkCfgCycleTime.setValueScope(2, 40);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltPonLinkCfgProtocolProfileIndex.refresh();
            tfOltPonLinkCfgProtocolProfileIndex.setSelectedProfileIndex(1);

            return;
        }

        OltPonLinkCfgTable mbean = (OltPonLinkCfgTable) getModel();
        if (mbean == null)
            return;

        BeanService.refreshBean(fApplication, mbean);

        tfOltPonLinkCfgSlotNo.setText(mbean.getOltPonLinkCfgSlotNo().toString());
        tfOltPonLinkCfgPortNo.setText(mbean.getOltPonLinkCfgPortNo().toString());

        tfOltPonLinkCfgAdministrativeState.setEnabled(mbean.getOltPonLinkCfgAdministrativeState() != null);
        tfOltPonLinkCfgAdministrativeState.setSelectedIndex(mbean.getOltPonLinkCfgAdministrativeState() != null ? getIndexFromValue(oltPonLinkCfgAdministrativeStateVList, mbean.getOltPonLinkCfgAdministrativeState()) : 1);

        //tfOltPonLinkCfgOperationalState.setText(oltPonLinkCfgOperationalStateTList[getIndexFromValue(oltPonLinkCfgOperationalStateVList, mbean.getOltPonLinkCfgOperationalState())]);

        tfOltPonLinkCfgProtocolProfileIndex.refresh();
        tfOltPonLinkCfgProtocolProfileIndex.setEnabled(mbean.getOltPonLinkCfgProtocolProfileIndex() != null);
        tfOltPonLinkCfgProtocolProfileIndex.setSelectedProfileIndex(mbean.getOltPonLinkCfgProtocolProfileIndex());

        tfOltPonLinkCfgOnuDiscoveryMode.setEnabled(mbean.getOltPonLinkCfgOnuDiscoveryMode() != null);
        tfOltPonLinkCfgOnuDiscoveryMode.setSelectedIndex(mbean.getOltPonLinkCfgOnuDiscoveryMode() != null ? getIndexFromValue(oltPonLinkCfgOnuDiscoveryModeVList, mbean.getOltPonLinkCfgOnuDiscoveryMode()) : 1);

        tfOltPonLinkCfgOnuDiscoveryInterval.setEnabled(mbean.getOltPonLinkCfgOnuDiscoveryInterval() != null);
        tfOltPonLinkCfgOnuDiscoveryInterval.setValue(mbean.getOltPonLinkCfgOnuDiscoveryInterval() != null ? mbean.getOltPonLinkCfgOnuDiscoveryInterval() : 30);

        tfOltPonLinkCfgCycleTime.setEnabled(mbean.getOltPonLinkCfgCycleTime() != null);
        tfOltPonLinkCfgCycleTime.setValue(mbean.getOltPonLinkCfgCycleTime() != null ? mbean.getOltPonLinkCfgCycleTime() : 10);
    }

    public boolean validateFrom() {
        return true;
    }

    public void updateModel() {
        OltPonLinkCfgTable mbean = (OltPonLinkCfgTable) getModel();
        if (mbean == null)
            return;

        if (tfOltPonLinkCfgAdministrativeState.isEnabled())
            mbean.setOltPonLinkCfgAdministrativeState(oltPonLinkCfgAdministrativeStateVList[tfOltPonLinkCfgAdministrativeState.getSelectedIndex()]);

        if (tfOltPonLinkCfgProtocolProfileIndex.isEnabled())
            mbean.setOltPonLinkCfgProtocolProfileIndex(tfOltPonLinkCfgProtocolProfileIndex.getSelectedProfileIndex() >= 0 ? tfOltPonLinkCfgProtocolProfileIndex.getSelectedProfileIndex() : 1);

        if (tfOltPonLinkCfgOnuDiscoveryMode.isEnabled())
            mbean.setOltPonLinkCfgOnuDiscoveryMode(oltPonLinkCfgOnuDiscoveryModeVList[tfOltPonLinkCfgOnuDiscoveryMode.getSelectedIndex()]);

        if (tfOltPonLinkCfgOnuDiscoveryInterval.isEnabled())
            mbean.setOltPonLinkCfgOnuDiscoveryInterval(tfOltPonLinkCfgOnuDiscoveryInterval.getValue());

        if (tfOltPonLinkCfgCycleTime.isEnabled())
            mbean.setOltPonLinkCfgCycleTime(tfOltPonLinkCfgCycleTime.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}