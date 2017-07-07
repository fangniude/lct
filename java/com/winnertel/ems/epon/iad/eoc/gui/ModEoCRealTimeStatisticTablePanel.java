package com.winnertel.ems.epon.iad.eoc.gui;

import com.winnertel.ems.epon.iad.eoc.mib.ModEoCRealTimeStatisticTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.gui.SnmpApplyButton;
import com.winnertel.em.standard.snmp.gui.SnmpRefreshButton;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The ModEoCRealTimeStatisticTablePanel class.
 * Created by DVM Creator
 */
public class ModEoCRealTimeStatisticTablePanel extends UPanel {

    private JLabel tfModEoCRealTimeStatisticCBATCardIndex = new JLabel();

    private JLabel tfModEoCRealTimeStatisticCNUIndex = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxByte = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxByte = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxPkt = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxPkt = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxBcast = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxBcast = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxMcast = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxMcast = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxCrc = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxShort = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxShort = new JLabel();

    private JLabel tfModEoCRealTimeStatisticTxDropped = new JLabel();

    private JLabel tfModEoCRealTimeStatisticRxDropped = new JLabel();

    private JLabel tfModEoCRealTimeStatisticAveragePreFEC = new JLabel();

    private int[] modEoCRealTimeStatisticResetVList = new int[]{
            0, 1,};
    private String[] modEoCRealTimeStatisticResetTList = new String[]{
            fStringMap.getString("none"),
            fStringMap.getString("clear"),
    };
    private JComboBox tfModEoCRealTimeStatisticReset = new JComboBox(modEoCRealTimeStatisticResetTList);


    private final String modEoCRealTimeStatisticCBATCardIndex = fStringMap.getString("modEoCRealTimeStatisticCBATCardIndex") + " : ";
    private final String modEoCRealTimeStatisticCNUIndex = fStringMap.getString("modEoCRealTimeStatisticCNUIndex") + " : ";
    private final String modEoCRealTimeStatisticTxByte = fStringMap.getString("modEoCRealTimeStatisticTxByte") + " : ";
    private final String modEoCRealTimeStatisticRxByte = fStringMap.getString("modEoCRealTimeStatisticRxByte") + " : ";
    private final String modEoCRealTimeStatisticTxPkt = fStringMap.getString("modEoCRealTimeStatisticTxPkt") + " : ";
    private final String modEoCRealTimeStatisticRxPkt = fStringMap.getString("modEoCRealTimeStatisticRxPkt") + " : ";
    private final String modEoCRealTimeStatisticTxBcast = fStringMap.getString("modEoCRealTimeStatisticTxBcast") + " : ";
    private final String modEoCRealTimeStatisticRxBcast = fStringMap.getString("modEoCRealTimeStatisticRxBcast") + " : ";
    private final String modEoCRealTimeStatisticTxMcast = fStringMap.getString("modEoCRealTimeStatisticTxMcast") + " : ";
    private final String modEoCRealTimeStatisticRxMcast = fStringMap.getString("modEoCRealTimeStatisticRxMcast") + " : ";
    private final String modEoCRealTimeStatisticRxCrc = fStringMap.getString("modEoCRealTimeStatisticRxCrc") + " : ";
    private final String modEoCRealTimeStatisticTxShort = fStringMap.getString("modEoCRealTimeStatisticTxShort") + " : ";
    private final String modEoCRealTimeStatisticRxShort = fStringMap.getString("modEoCRealTimeStatisticRxShort") + " : ";
    private final String modEoCRealTimeStatisticTxDropped = fStringMap.getString("modEoCRealTimeStatisticTxDropped") + " : ";
    private final String modEoCRealTimeStatisticRxDropped = fStringMap.getString("modEoCRealTimeStatisticRxDropped") + " : ";
    private final String modEoCRealTimeStatisticAveragePreFEC = fStringMap.getString("modEoCRealTimeStatisticAveragePreFEC") + " : ";
    private final String modEoCRealTimeStatisticReset = fStringMap.getString("modEoCRealTimeStatisticReset") + " : ";


    private SnmpApplyButton btApply;
    private SnmpRefreshButton btRefresh;


    public ModEoCRealTimeStatisticTablePanel(IApplication app) {
        super(app);
        setModel(new ModEoCRealTimeStatisticTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        btApply = new SnmpApplyButton(fApplication, this);
        btApply.getAction().putValue(BaseAction.ID, "Modify_ModEoCRealTimeStatisticTable");
        btRefresh = new SnmpRefreshButton(fApplication, this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btApply);
        buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(17, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticCBATCardIndex));
        baseInfoPanel.add(tfModEoCRealTimeStatisticCBATCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticCNUIndex));
        baseInfoPanel.add(tfModEoCRealTimeStatisticCNUIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxByte));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxByte);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxByte));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxByte);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxPkt));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxPkt);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxPkt));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxPkt);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxBcast));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxBcast);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxBcast));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxBcast);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxMcast));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxMcast);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxMcast));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxMcast);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxCrc));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxCrc);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxShort));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxShort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxShort));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxShort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticTxDropped));
        baseInfoPanel.add(tfModEoCRealTimeStatisticTxDropped);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticRxDropped));
        baseInfoPanel.add(tfModEoCRealTimeStatisticRxDropped);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticAveragePreFEC));
        baseInfoPanel.add(tfModEoCRealTimeStatisticAveragePreFEC);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(modEoCRealTimeStatisticReset));
        tfModEoCRealTimeStatisticReset.setName(fStringMap.getString("modEoCRealTimeStatisticReset"));
        baseInfoPanel.add(tfModEoCRealTimeStatisticReset);
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


    }

    public void refresh() {

        ModEoCRealTimeStatisticTable mbean = (ModEoCRealTimeStatisticTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfModEoCRealTimeStatisticCBATCardIndex.setText(mbean.getModEoCRealTimeStatisticCBATCardIndex().toString());
        tfModEoCRealTimeStatisticCNUIndex.setText(mbean.getModEoCRealTimeStatisticCNUIndex().toString());
        tfModEoCRealTimeStatisticTxByte.setText(mbean.getModEoCRealTimeStatisticTxByte().toString());
        tfModEoCRealTimeStatisticRxByte.setText(mbean.getModEoCRealTimeStatisticRxByte().toString());
        tfModEoCRealTimeStatisticTxPkt.setText(mbean.getModEoCRealTimeStatisticTxPkt().toString());
        tfModEoCRealTimeStatisticRxPkt.setText(mbean.getModEoCRealTimeStatisticRxPkt().toString());
        tfModEoCRealTimeStatisticTxBcast.setText(mbean.getModEoCRealTimeStatisticTxBcast().toString());
        tfModEoCRealTimeStatisticRxBcast.setText(mbean.getModEoCRealTimeStatisticRxBcast().toString());
        tfModEoCRealTimeStatisticTxMcast.setText(mbean.getModEoCRealTimeStatisticTxMcast().toString());
        tfModEoCRealTimeStatisticRxMcast.setText(mbean.getModEoCRealTimeStatisticRxMcast().toString());
        tfModEoCRealTimeStatisticRxCrc.setText(mbean.getModEoCRealTimeStatisticRxCrc().toString());
        tfModEoCRealTimeStatisticTxShort.setText(mbean.getModEoCRealTimeStatisticTxShort().toString());
        tfModEoCRealTimeStatisticRxShort.setText(mbean.getModEoCRealTimeStatisticRxShort().toString());
        tfModEoCRealTimeStatisticTxDropped.setText(mbean.getModEoCRealTimeStatisticTxDropped().toString());
        tfModEoCRealTimeStatisticRxDropped.setText(mbean.getModEoCRealTimeStatisticRxDropped().toString());
        tfModEoCRealTimeStatisticAveragePreFEC.setText(mbean.getModEoCRealTimeStatisticAveragePreFEC().toString());
        tfModEoCRealTimeStatisticReset.setSelectedIndex(getIndexFromValue(modEoCRealTimeStatisticResetVList, mbean.getModEoCRealTimeStatisticReset().intValue()));

    }

    public void updateModel() {

        ModEoCRealTimeStatisticTable mbean = (ModEoCRealTimeStatisticTable) getModel();


        mbean.setModEoCRealTimeStatisticReset(new Integer(modEoCRealTimeStatisticResetVList[tfModEoCRealTimeStatisticReset.getSelectedIndex()]));


    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
